package UserManagement.consumer.controller;

import UserManagement.consumer.dto.ConsumerCreateDto;
import UserManagement.consumer.dto.ConsumerRequestDto;
import UserManagement.consumer.service.ConsumerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import UserManagement.consumer.dto.ConsumerResponseDto;
import UserManagement.consumer.model.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@RequestMapping("/consumers")
@RestController
@Tag(name = "Consumers")
public class ConsumerController {

  private final ConsumerService consumerService;

  @Autowired
  public ConsumerController(ConsumerService consumerService) {
    this.consumerService = consumerService;
  }

  @GetMapping()
  public ResponseEntity<List<ConsumerResponseDto>> getAll() {
    return ResponseEntity.ok(consumerService.getAll());
  }

  @PostMapping()
  public ResponseEntity<Void> create(ConsumerCreateDto createDto) {
    consumerService.create(createDto);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("{id}")
  public ConsumerResponseDto getById(@PathVariable("id") Long id){
    return consumerService.getById(id);
  }

  @PostMapping("{id}")
  public void updateById(@PathVariable("id") Long id, ConsumerRequestDto dto) {
    consumerService.update(id, dto);
  }

  @DeleteMapping("{id}")
  public void deleteById(@PathVariable("id") Long id) {
    consumerService.deleteById(id);
  }
}
