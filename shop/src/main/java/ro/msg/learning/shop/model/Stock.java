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
@Table(name="STOCK")
public class Stock extends BaseEntity{
    @ManyToOne
    @JoinColumn(name="product")
    @JsonIgnore
    private Product product;
    @ManyToOne
    @JoinColumn(name="location")
    @JsonIgnore
    private Location location;
    private Integer quantity;
}
