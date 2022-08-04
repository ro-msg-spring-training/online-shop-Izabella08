package ro.msg.learning.shop.unitTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import ro.msg.learning.shop.model.*;
import ro.msg.learning.shop.repository.IStockRepository;
import ro.msg.learning.shop.strategy.OrderStrategySingleLocation;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class LocationStrategyTest {

    @InjectMocks
    private OrderStrategySingleLocation singleLocation;
    @Mock
    private IStockRepository stockRepository;

     @Test
    public void singleLocationStrategyTest1() throws Exception {
         ProductCategory category1 = new ProductCategory("CategoryName1", "CategoryDescription1");

         Supplier supplier1 = new Supplier("Supplier1");

         Product product1 = new Product("ProductName1", "ProductDescription1", new BigDecimal(100), 3.0, category1, supplier1, "ImageUrl1");

         Location location1 = new Location("LocationName1", "LocationAddressCountry1", "LocationAddressCity1", "LocationAddressCounty1", "LocationAddressStreetAddress1");

         Stock stock1 = new Stock(product1, location1, 105);
         stockRepository.save(stock1);

         Customer customer1 = new Customer("Firstname1","Lastname1", "Username1", "Password1", "EmailAddress1");

         Order order1 = new Order(location1, customer1, LocalDateTime.now(), "AddressCountry2", "AddressCity2", "AddressCounty2", "AddressStreetAddress2");

         OrderDetail orderDetail1 = new OrderDetail(order1, product1, 19);

         List<OrderDetail> orderDetailList = new ArrayList<>();
         orderDetailList.add(orderDetail1);

         List<Stock> stockList = singleLocation.findShippingLocation(orderDetailList);
         assert(!stockList.isEmpty());
     }

    @Test
    public void singleLocationStrategyTest2() throws Exception {
        ProductCategory category1 = new ProductCategory("CategoryName1", "CategoryDescription1");

        Supplier supplier1 = new Supplier("Supplier1");

        Product product1 = new Product("ProductName1", "ProductDescription1", new BigDecimal(100), 3.0, category1, supplier1, "ImageUrl1");

        Product product2 = new Product("ProductName2", "ProductDescription2", new BigDecimal(167), 1.0, category1, supplier1, "ImageUrl2");

        Location location1 = new Location("LocationName1", "LocationAddressCountry1", "LocationAddressCity1", "LocationAddressCounty1", "LocationAddressStreetAddress1");

        Stock stock1 = new Stock(product1, location1, 105);
        stockRepository.save(stock1);

        Stock stock2 = new Stock(product2, location1, 105);
        stockRepository.save(stock2);

        Customer customer1 = new Customer("Firstname1","Lastname1", "Username1", "Password1", "EmailAddress1");

        Order order1 = new Order(location1, customer1, LocalDateTime.now(), "AddressCountry2", "AddressCity2", "AddressCounty2", "AddressStreetAddress2");

        Order order2 = new Order(location1, customer1, LocalDateTime.now(), "AddressCountry3", "AddressCity3", "AddressCounty3", "AddressStreetAddress3");


        OrderDetail orderDetail1 = new OrderDetail(order1, product1, 19);

        OrderDetail orderDetail2 = new OrderDetail(order2, product2, 15);

        List<OrderDetail> orderDetailList = new ArrayList<>();
        orderDetailList.add(orderDetail1);
        orderDetailList.add(orderDetail2);

        singleLocation.findShippingLocation(orderDetailList);
    }
}
