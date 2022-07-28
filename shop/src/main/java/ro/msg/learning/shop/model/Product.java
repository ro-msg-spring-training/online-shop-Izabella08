package ro.msg.learning.shop.model;

import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@EnableJpaRepositories(basePackages = "ro.msg.learning.shop.repository")
@Table(name="PRODUCT")
public class Product extends BaseEntity{
    private String Name;
    private String Description;
    private BigDecimal Price;
    private double Weight;
    @ManyToOne(fetch = FetchType.EAGER)
    private ProductCategory Category;
    @ManyToOne(fetch = FetchType.EAGER)
    private Supplier Supplier;
    private String ImageUrl;
}
