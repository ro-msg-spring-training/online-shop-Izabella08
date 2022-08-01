package ro.msg.learning.shop.model;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

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
@ToString(exclude = {"stocks", "orders"})
public class Product extends BaseEntity{
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Stock> stocks;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<OrderDetail> orders;

    private String name;
    private String description;
    private BigDecimal price;
    private double weight;
    @ManyToOne
    @JoinColumn(name="category")
    @JsonIgnore
    private ProductCategory category;
    @ManyToOne
    @JoinColumn(name="supplier")
    @JsonIgnore
    private Supplier supplier;
    private String imageUrl;

}
