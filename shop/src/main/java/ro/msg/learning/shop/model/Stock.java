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
@Table(name="STOCK")
public class Stock extends BaseEntity{
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product", insertable = false, updatable = false)
    private Product product;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="location", insertable = false, updatable = false)
    private Location location;
    private Integer quantity;
}
