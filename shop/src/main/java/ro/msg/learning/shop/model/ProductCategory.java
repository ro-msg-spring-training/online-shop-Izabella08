package ro.msg.learning.shop.model;

import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;
import javax.persistence.Table;

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
public class ProductCategory extends BaseEntity{
    private String name;
    private String description;
}
