package ro.msg.learning.shop.model;

import javax.persistence.*;
import java.time.LocalDateTime;
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
public class Order extends BaseEntity{
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="location", insertable = false, updatable = false)
    private Location shippedFrom;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="customer", insertable = false, updatable = false)
    private Customer customer;
    private LocalDateTime createdAt;
    private String addressCountry;
    private String addressCity;
    private String addressCounty;
    private String addressStreetAddress;
}
