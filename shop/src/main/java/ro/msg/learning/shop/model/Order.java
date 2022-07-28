package ro.msg.learning.shop.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
    private Location ShippedFrom;
    @ManyToOne(fetch = FetchType.EAGER)
    private Customer Customer;
    private LocalDateTime CreatedAt;
    private String AddressCountry;
    private String AddressCity;
    private String AddressCounty;
    private String AddressStreetAddress;
}
