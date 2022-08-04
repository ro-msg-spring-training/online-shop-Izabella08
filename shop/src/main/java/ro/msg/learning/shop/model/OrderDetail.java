package ro.msg.learning.shop.model;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @ManyToOne
    @JoinColumn(name="order")
    @JsonIgnore
    private Order order;

    @ManyToOne
    @JoinColumn(name="product")
    @JsonIgnore
    private Product product;
    private Integer quantity;
}
