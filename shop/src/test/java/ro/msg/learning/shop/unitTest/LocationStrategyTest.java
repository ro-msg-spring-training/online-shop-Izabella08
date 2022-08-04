package ro.msg.learning.shop.unitTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import ro.msg.learning.shop.model.*;
import ro.msg.learning.shop.repository.IStockRepository;
import ro.msg.learning.shop.strategy.IOrderStrategy;
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

    List<OrderDetail> orderDetailList = new ArrayList<>();

    @Before
    public void initTestValues(){
        ProductCategory category1 = new ProductCategory("CategoryName1", "CategoryDescription1");

        Supplier supplier1 = new Supplier("Supplier1");

        Product product1 = new Product("ProductName1", "ProductDescription1", new BigDecimal(100), 3.0, category1, supplier1, "ImageUrl1");

        Location location1 = new Location("LocationName1", "LocationAddressCountry1", "LocationAddressCity1", "LocationAddressCounty1", "LocationAddressStreetAddress1");

        Stock stock1 = new Stock(product1, location1, 105);

        Customer customer1 = new Customer("Firstname1","Lastname1", "Username1", "Password1", "EmailAddress1");

        Order order1 = new Order(location1, customer1, LocalDateTime.now(), "AddressCountry2", "AddressCit2", "AddressCounty2", "AddressStreetAddress2");

        OrderDetail orderDetail1 = new OrderDetail(order1, product1, 19);

        orderDetailList.add(orderDetail1);
     }

     @Test
    public void singleLocationStrategyTest() throws Exception {
         List<Stock> stockList = singleLocation.findShippingLocation(orderDetailList);
         assert (!stockList.isEmpty());
     }

}
