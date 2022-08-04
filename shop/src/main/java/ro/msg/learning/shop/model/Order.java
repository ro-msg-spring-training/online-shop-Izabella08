package ro.msg.learning.shop.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@SuperBuilder
@EnableJpaRepositories(basePackages = "ro.msg.learning.shop.repository")
@Table(name="ORDER_PRODUCT")
@ToString(exclude = "orderDetails")
public class Order extends BaseEntity{
    @ManyToOne
    @JoinColumn(name="shippedFrom")
    @JsonIgnore
    private Location shippedFrom;
    @ManyToOne
    @JoinColumn(name="customer")
    @JsonIgnore
    private Customer customer;
    private LocalDateTime createdAt;
    private String addressCountry;
    private String addressCity;
    private String addressCounty;
    private String addressStreetAddress;

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private List<OrderDetail> orderDetails;

    public Order(Location shippedFrom, Customer customer, LocalDateTime createdAt, String addressCountry, String addressCity, String addressCounty, String addressStreetAddress) {
        this.shippedFrom = shippedFrom;
        this.customer = customer;
        this.createdAt = createdAt;
        this.addressCountry = addressCountry;
        this.addressCity = addressCity;
        this.addressCounty = addressCounty;
        this.addressStreetAddress = addressStreetAddress;
    }
}
