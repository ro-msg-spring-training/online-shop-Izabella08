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
@Table(name="LOCATION")
public class Location extends BaseEntity{
    private String Name;
    private String AddressCountry;
    private String AddressCity;
    private String AddressCounty;
    private String AddressStreetAddress;
}
