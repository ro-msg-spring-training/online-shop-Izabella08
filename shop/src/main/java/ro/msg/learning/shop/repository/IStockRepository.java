package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.msg.learning.shop.model.Stock;

@Repository
public interface IStockRepository extends JpaRepository<Stock, Integer> {
}
