package ro.msg.learning.shop.strategy;

import ro.msg.learning.shop.model.OrderDetail;
import ro.msg.learning.shop.model.Stock;


import java.util.List;

public interface IOrderStrategy {
    List<Stock> findShippingLocation(List<OrderDetail> products) throws Exception;
}
