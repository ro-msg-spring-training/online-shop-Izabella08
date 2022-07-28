package ro.msg.learning.shop.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
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
@Table(name="REVENUE")
public class Revenue extends BaseEntity{
    @ManyToOne(fetch = FetchType.EAGER)
    private Location Location;
    private LocalDateTime Date;
    private BigDecimal Sum;
}
