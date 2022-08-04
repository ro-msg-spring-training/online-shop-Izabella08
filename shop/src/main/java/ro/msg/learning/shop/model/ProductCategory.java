package ro.msg.learning.shop.model;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@EnableJpaRepositories(basePackages = "ro.msg.learning.shop.repository")
@Table(name="PRODUCT_CATEGORY")
@Builder
@ToString(exclude = "products")
public class ProductCategory extends BaseEntity{
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Product> products;
    private String name;
    private String description;
}
