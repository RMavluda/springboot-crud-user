package UserManagement.consumer.service;

import UserManagement.consumer.dto.ConsumerCreateDto;
import UserManagement.consumer.dto.ConsumerRequestDto;
import UserManagement.consumer.model.Consumer;
import UserManagement.consumer.repository.ConsumerRepository;
import UserManagement.consumer.mapper.ConsumerMapper;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import UserManagement.consumer.dto.ConsumerResponseDto;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
@Slf4j
public class ConsumerService {

  private final ConsumerRepository repository;
  private final ConsumerMapper mapper;

  public List<ConsumerResponseDto> getAll() {
    return mapper.toDtoList(repository.findAll());
  }

  public ConsumerResponseDto getById(Long id) {
    var entity = findById(id);
    return mapper.toDto(entity);
  }

  public void create(ConsumerCreateDto createDto) {
    repository
        .findByEmail(createDto.getEmail())
        .ifPresent(c -> {
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Consumer with this email already exists");
        });
    repository.save(mapper.toEntity(createDto));
  }

  @Transactional
  public void update(Long id, ConsumerRequestDto dto) {
    var entity = findById(id);
    mapper.updateEntityFromDto(dto, entity);
    repository.save(entity);

  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }

  private Consumer findById(Long id) {
    return repository
        .findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Consumer not found"));
  }

}
