package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);


        Car bmw = (new Car("BMW", 12345));
        Car audi = (new Car("Audi", 56789));
        Car mercedes = (new Car("Mercedes", 7890));

        carService.add(bmw);
        carService.add(audi);
        carService.add(mercedes);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
        userService.add(new User("User5", "Lastname5", "user5@mail.ru", bmw));
        userService.add(new User("User6", "Lastname6", "user6@mail.ru", audi));
        userService.add(new User("User7", "Lastname7", "user7@mail.ru", mercedes));




        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
        }

        List<Car> cars = carService.listCars();
        for (Car car : cars) {
            System.out.println("Serial = " + car.getSerial());
            System.out.println("Model = " + car.getModel());
        }

        System.out.println(userService.getUserByCar( 12345, "BMW"));
    }
}
