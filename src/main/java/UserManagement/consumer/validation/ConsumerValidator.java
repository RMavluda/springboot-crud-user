package UserManagement.consumer.validation;

import UserManagement.consumer.model.Consumer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsumerValidator {
    public void beforeCreate(Consumer consumer){

    }
}
