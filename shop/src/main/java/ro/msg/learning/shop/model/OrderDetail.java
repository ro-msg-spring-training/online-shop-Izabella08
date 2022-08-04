package ro.msg.learning.shop.model;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@SuperBuilder
@EnableJpaRepositories(basePackages = "ro.msg.learning.shop.repository")
@Table(name="ORDER_DETAIL")
public class OrderDetail extends BaseEntity{
    @ManyToOne
    @JoinColumn(name="orderp")
    @JsonIgnore
    private Order orderp;

    @ManyToOne
    @JoinColumn(name="product")
    @JsonIgnore
    private Product product;
    private Integer quantity;
}
