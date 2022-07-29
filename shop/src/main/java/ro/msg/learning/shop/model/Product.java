package ro.msg.learning.shop.model;

import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Optional;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@EnableJpaRepositories(basePackages = "ro.msg.learning.shop.repository")
@Table(name="PRODUCT")
@Builder
public class Product extends BaseEntity{
    private String name;
    private String description;
    private BigDecimal price;
    private double weight;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="productCategory", insertable = false, updatable = false)
    private ProductCategory category;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="supplier", insertable = false, updatable = false)
    private Supplier supplier;
    private String imageUrl;

}
