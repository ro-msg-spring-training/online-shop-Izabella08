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
@Table(name="SUPPLIER")
@Builder
@ToString(exclude = "products")
public class Supplier extends BaseEntity{
    @OneToMany(mappedBy = "supplier")
    @JsonIgnore
    private List<Product> products;
    private String name;
}
