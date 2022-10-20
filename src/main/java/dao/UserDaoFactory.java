package dao;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserDaoFactory {
    @Bean
    public UserDao awsUserDao(){
        AWSConnectionMaker connection = new AWSConnectionMaker();
        UserDao userDao = new UserDao(connection);
        return userDao;
    }
}
