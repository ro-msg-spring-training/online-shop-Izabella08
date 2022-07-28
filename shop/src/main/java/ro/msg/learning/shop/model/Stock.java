package ro.msg.learning.shop.model;

import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
    private Product Product;
    @ManyToOne(fetch = FetchType.EAGER)
    private Location Location;
    private Integer Quantity;
}
