package ro.msg.learning.shop.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.repository.ILocationRepository;
import ro.msg.learning.shop.repository.IStockRepository;
import ro.msg.learning.shop.strategy.IOrderStrategy;
import ro.msg.learning.shop.strategy.OrderStrategyMostAbundant;
import ro.msg.learning.shop.strategy.OrderStrategySingleLocation;
import org.springframework.beans.factory.annotation.Value;

@Configuration
@RequiredArgsConstructor
public class OrderStrategyConfig {

    @Value("${strategy}")
    private String orderStrategy;
    private final ILocationRepository locationRepository;
    private final IStockRepository stockRepository;

    @Bean
    public IOrderStrategy strategy() {
        if(orderStrategy.equals("singleLocation"))
            return new OrderStrategySingleLocation(locationRepository, stockRepository);
        else
            return new OrderStrategyMostAbundant(stockRepository);
    }
}
