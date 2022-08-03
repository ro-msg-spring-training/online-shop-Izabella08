package ro.msg.learning.shop.strategy;

import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.OrderDetail;
import ro.msg.learning.shop.model.Stock;
import ro.msg.learning.shop.repository.IStockRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrderStrategyMostAbundant implements IOrderStrategy {

    private final IStockRepository stockRepository;

    public OrderStrategyMostAbundant(IStockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public List<Stock> findShippingLocation(List<OrderDetail> products) throws Exception {
        return products.stream().map(orderDetail -> {
            Location location = null;
            try {
                location = findLocationForProduct(orderDetail);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return Stock.builder()
                    .product(orderDetail.getProduct())
                    .location(location)
                    .quantity(orderDetail.getQuantity())
                    .build();
        }).collect(Collectors.toList());
    }

    protected Location findLocationForProduct(OrderDetail orderDetail) throws Exception {
        return stockRepository.findAllByProduct(orderDetail.getProduct())
                .stream()
                .filter(stock -> stock.getQuantity() >= orderDetail.getQuantity())
                .max(Comparator.comparing(Stock::getQuantity))
                .orElseThrow(() -> new Exception("No location is good enough"))
                .getLocation();
    }
}
