package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User vasiliy = new User("Vasiliy", "Petrov", "vas@mail.ru");
      User andrey = new User("Andrey", "Ivanov", "andre@gmail.com");
      User olga = new User("Olga", "Sidorova", "ola@yahoo.com");
      User dima = new User("Dmitry", "Sokolov", "dim@rambler.ru");

      Car volvo = new Car("Volvo", 121);
      Car bmw = new Car("BMW", 323);
      Car audi = new Car("Audi", 5);
      Car skoda = new Car("Skoda", 43);

      userService.add(vasiliy.setCar(volvo));


      context.close();
   }
}
