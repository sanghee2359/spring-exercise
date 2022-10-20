package dao;

import domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserDaoFactory.class)
class UserDaoTest {
    @Autowired
    ApplicationContext context;
    @Test
    void addAndSelect() throws SQLException, ClassNotFoundException {
        User user1 = new User("1", "sanghee", "1106");

        UserDao userDao = context.getBean("awsUserDao", UserDao.class);
        userDao.deleteAll();
        Assertions.assertEquals(0, userDao.getCount());

//        String id = "16";
//        userDao.add(new User(id, "stop", "25345"));
        userDao.add(user1);
        Assertions.assertEquals(1, userDao.getCount());
        User user = userDao.findById(user1.getId());

        Assertions.assertEquals(user1.getName(), user.getName());
        Assertions.assertEquals(user1.getPassword(), user.getPassword());
    }

    @Test void count() throws SQLException, ClassNotFoundException {
        User user1 = new User("1", "정상희", "1106");
        User user2 = new User("2", "신지원", "0129");
        User user3 = new User("3", "박정현", "0308");

        UserDao userDao = context.getBean("awsUserDao", UserDao.class);
        userDao.deleteAll();
        Assertions.assertEquals(0, userDao.getCount());

        userDao.add(user1);
        Assertions.assertEquals(1, userDao.getCount());
        userDao.add(user1);
        Assertions.assertEquals(2, userDao.getCount());
        userDao.add(user1);
        Assertions.assertEquals(3, userDao.getCount());
    }
}