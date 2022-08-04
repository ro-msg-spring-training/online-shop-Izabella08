package ro.msg.learning.shop.dto.mapper;


import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.model.Order;

@Component
public class OrderMapper {
    public Order dtoToModel(OrderDTO dto) {
      return Order.builder()
                .id(dto.getId())
                .createdAt(dto.getCreatedAt())
                .addressCountry(dto.getAddressCountry())
                .addressCity(dto.getAddressCity())
                .addressCounty(dto.getAddressCounty())
                .addressStreetAddress(dto.getAddressStreetAddress())
                .build();
    }
}
