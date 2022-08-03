package ro.msg.learning.shop.strategy;

import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.OrderDetail;
import ro.msg.learning.shop.model.Stock;
import ro.msg.learning.shop.repository.ILocationRepository;
import ro.msg.learning.shop.repository.IStockRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderStrategySingleLocation implements IOrderStrategy {

    private final ILocationRepository locationRepository;
    private final IStockRepository stockRepository;

    public OrderStrategySingleLocation(ILocationRepository locationRepository, IStockRepository stockRepository) {
        this.locationRepository = locationRepository;
        this.stockRepository = stockRepository;
    }


    @Override
    public List<Stock> findShippingLocation(List<OrderDetail> products) throws Exception {

        Optional<Location> location = findLocation(products);
        return products.stream()
                .map(orderDetail ->
                        Stock.builder()
                                .product(orderDetail.getProduct())
                                .location(location.get())
                                .quantity(orderDetail.getQuantity())
                                .build()
                ).collect(Collectors.toList());
    }

    private Optional<Location> findLocation(List<OrderDetail> orderDetails) {
        List<Location> foundLocations = new ArrayList<>();

        List<Stock> stockList = stockRepository.findAll();
        List<Stock> newStockList = orderDetails.stream().map(
                orderDetail -> {
                    Stock foundStock = returnProductStock(stockList, orderDetail.getQuantity(), orderDetail.getProduct().getId());
                    if (foundStock != null) {
                        return foundStock;
                    } else {
                        throw new RuntimeException();
                    }
                }
        ).collect(Collectors.toList());

        if (newStockList.size() == orderDetails.size()) {
            foundLocations.add(newStockList.get(0).getLocation());
        }

        if (foundLocations.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(foundLocations.get(0));
        }

    }

    private Stock returnProductStock(List<Stock> stocks, Integer quantity, Integer productId) {
        return stocks.stream().filter(
                stock -> stock.getProduct().getId().equals(productId) && stock.getQuantity() >= quantity
        ).findFirst().orElse(null);
    }
}
