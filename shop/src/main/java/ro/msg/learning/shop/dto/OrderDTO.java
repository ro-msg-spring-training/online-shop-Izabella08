package ro.msg.learning.shop.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderDTO {
    private Integer id;
    private LocalDateTime createdAt;
    private String address_country;
    private String address_city;
    private String address_county;
    private String address_streetAddress;
    private Map<Integer, Integer> products;
}
