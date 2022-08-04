package ro.msg.learning.shop.service;

import org.springframework.stereotype.Service;
import ro.msg.learning.shop.model.*;
import ro.msg.learning.shop.repository.*;
import ro.msg.learning.shop.strategy.IOrderStrategy;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final IOrderRepository orderRepository;
    private final IOrderDetailRepository orderDetailRepository;
    private final ICustomerRepository customerRepository;
    private IOrderStrategy orderStrategy;


    public OrderService(IOrderRepository orderRepository, IOrderDetailRepository orderDetailRepository, ICustomerRepository customerRepository, IOrderStrategy orderStrategy) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.customerRepository = customerRepository;
        this.orderStrategy = orderStrategy;
    }

    public Order createOrder(List<OrderDetail> orderDetails, Integer customerId, Order order) throws Exception {
        List<Stock> stockList = orderStrategy.findShippingLocation(orderDetails);
        List<Location> locations = stockList.stream().map(Stock::getLocation).collect(Collectors.toList());
        order.setShippedFrom(locations.get(0));
        Customer customer = customerRepository.getReferenceById(customerId);
        order.setCustomer(customer);
        Order savedOrder = orderRepository.save(order);
        orderDetails.forEach((orderDetail) -> {
                    orderDetail.setOrderp(savedOrder);
                    orderDetailRepository.save(orderDetail);
                }
        );
        return order;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

}
