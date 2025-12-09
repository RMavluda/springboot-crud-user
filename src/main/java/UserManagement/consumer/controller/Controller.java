package UserManagement.consumer.controller;

import UserManagement.consumer.repository.ConsumerRepository;
import UserManagement.kafka.KafkaProducer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Controller {

  private final KafkaProducer kafkaProducer;
  private final ConsumerRepository consumerRepository;

  @PostMapping("/kafka/send")
  public String send(@RequestParam Long id){
    var consumer = consumerRepository.findById(id);
    kafkaProducer.sendMessage(consumer.toString());
    return "Success";
  }
}
