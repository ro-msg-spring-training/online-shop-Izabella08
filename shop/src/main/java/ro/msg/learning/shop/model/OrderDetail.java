package ro.msg.learning.shop.model;

import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@EnableJpaRepositories(basePackages = "ro.msg.learning.shop.repository")
@Table(name="ORDER_DETAIL")
public class OrderDetail extends BaseEntity{
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="order", insertable = false, updatable = false)
    private Order order;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product", insertable = false, updatable = false)
    private Product product;
    private Integer quantity;
}
