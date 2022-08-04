package ro.msg.learning.shop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.dto.mapper.OrderMapper;
import ro.msg.learning.shop.model.Order;
import ro.msg.learning.shop.model.OrderDetail;
import ro.msg.learning.shop.repository.IProductRepository;
import ro.msg.learning.shop.service.OrderService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {
    private final OrderMapper orderMapper;
    private final OrderService orderService;
    private final IProductRepository productRepository;

    public OrderController(OrderMapper orderMapper, OrderService orderService, IProductRepository productRepository) {
        this.orderMapper = orderMapper;
        this.orderService = orderService;
        this.productRepository = productRepository;
    }


    @PostMapping(value="/new_order/{customerId}")
    public ResponseEntity<Object> addOrder(@RequestBody OrderDTO orderDTO, @PathVariable Integer customerId) throws Exception {
        Order order = orderMapper.dtoToModel(orderDTO);
        List<OrderDetail> orderDetailList = new ArrayList<>();
        orderDTO.getProducts().forEach(
                (key, value) -> {
                    orderDetailList.add(new OrderDetail(order, productRepository.findById(key).get(), value));
                }
        );
        try{
            orderService.createOrder(orderDetailList, customerId, order);
            return new ResponseEntity<>("Order created successfully!", HttpStatus.CREATED);

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping(value = "/orders")
    public ResponseEntity<Object> getOrders() {
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }
}
