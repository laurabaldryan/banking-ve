package edu.tumo.banking.validation;

import edu.tumo.banking.domain.user.UserModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserValidation {

    private final Logger logger = LogManager.getLogger(UserValidation.class);

    public boolean validateForNull(UserModel userModel){
        if(userModel.getUserId() == null){
            logger.warn("Id of bank can't be null");
            return false;
        }
        if(userModel.getUsername() == null){
            System.out.println("Username of user is null");
            return false;
        }
        if(userModel.getPassword() == null){
            System.out.println("Password of user is null");
            return false;
        }
        return true;
    }
}
