package UserManagement.consumer.mapper;

import UserManagement.consumer.dto.ConsumerCreateDto;
import UserManagement.consumer.dto.ConsumerRequestDto;
import UserManagement.consumer.dto.ConsumerResponseDto;
import UserManagement.consumer.model.Consumer;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = ComponentModel.SPRING)
public interface ConsumerMapper {

  Consumer toEntity(ConsumerCreateDto dto);

  void updateEntityFromDto(
      ConsumerRequestDto dto,
      @MappingTarget Consumer entity
  );

  ConsumerResponseDto toDto(Consumer consumer);

  List<ConsumerResponseDto> toDtoList(List<Consumer> all);
}
