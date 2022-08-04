package ro.msg.learning.shop.model;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.experimental.SuperBuilder;
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
@SuperBuilder
@EnableJpaRepositories(basePackages = "ro.msg.learning.shop.repository")
@Table(name="CUSTOMER")
@ToString(exclude = "orders")
public class Customer extends BaseEntity{

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Order> orders;

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String emailAddress;

    public Customer(String firstName, String lastName, String username, String password, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
    }
}
