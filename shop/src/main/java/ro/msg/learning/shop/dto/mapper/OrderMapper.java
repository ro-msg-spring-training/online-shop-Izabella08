package ro.msg.learning.shop.dto.mapper;


import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.model.Order;

@Component
public class OrderMapper {

    public Order dtoToModel(OrderDTO dto) {
       Order newOrder = Order.builder()
                .id(dto.getId())
                .createdAt(dto.getCreatedAt())
                .addressCountry(dto.getAddress_country())
                .addressCity(dto.getAddress_city())
                .addressCounty(dto.getAddress_county())
                .addressStreetAddress(dto.getAddress_streetAddress())
                .build();
       return newOrder;
    }

}
