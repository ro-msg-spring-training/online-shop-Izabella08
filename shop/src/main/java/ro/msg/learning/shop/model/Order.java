package ro.msg.learning.shop.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
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
}
