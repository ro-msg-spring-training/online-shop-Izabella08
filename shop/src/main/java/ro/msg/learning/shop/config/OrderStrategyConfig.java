package ro.msg.learning.shop.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.repository.IStockRepository;
import ro.msg.learning.shop.strategy.IOrderStrategy;
import ro.msg.learning.shop.strategy.OrderStrategyMostAbundant;
import ro.msg.learning.shop.strategy.OrderStrategySingleLocation;

@Configuration
@RequiredArgsConstructor
public class OrderStrategyConfig {

    @Value("${strategy}")
    private String orderStrategy;
    private final IStockRepository stockRepository;

    @Bean
    public IOrderStrategy strategy() {
        if(orderStrategy.equals("singleLocation"))
            return new OrderStrategySingleLocation(stockRepository);
        else
            return new OrderStrategyMostAbundant(stockRepository);
    }
}
