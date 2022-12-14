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
@Table(name="LOCATION")
@ToString(exclude = {"stocks, shippedFrom"})
public class Location extends BaseEntity{
    @OneToMany(mappedBy = "location")
    @JsonIgnore
    private List<Stock> stocks;
    @OneToMany(mappedBy = "shippedFrom")
    @JsonIgnore
    private List<Order> orders;

    private String name;
    private String addressCountry;
    private String addressCity;
    private String addressCounty;
    private String addressStreetAddress;
}
