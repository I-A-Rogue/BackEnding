//        package net.weg.wegproject.util;
//
//        import com.github.javafaker.Faker;
//        import jakarta.annotation.PostConstruct;
//        import lombok.AllArgsConstructor;
//        import lombok.NoArgsConstructor;
//        import net.weg.wegproject.ConcreteClasses.address.model.dto.AddressDTO;
//        import net.weg.wegproject.ConcreteClasses.address.model.entity.Address;
//        import net.weg.wegproject.ConcreteClasses.address.service.AddressService;
//        import net.weg.wegproject.ConcreteClasses.productsClasses.product.controller.ProductController;
//        import net.weg.wegproject.ConcreteClasses.user.controller.UserController;
//        import net.weg.wegproject.ConcreteClasses.user.model.dto.UserDTO;
//        import org.springframework.beans.BeanUtils;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.stereotype.Component;
//
//        import java.util.ArrayList;
//        import java.util.List;
//
//@Component
//@AllArgsConstructor
//@NoArgsConstructor
//public class BancoInUtil {
//
//    @Autowired
//    private UserController userController;
//
//    private final Faker faker = new Faker();
//
//    @PostConstruct
//    public void createRandomMotors() {
//        userController.create(gerarUser());
//    }
//
//    public UserDTO gerarUser(){
//        UserDTO userDTO = new UserDTO();
//        userDTO.setName(faker.name().fullName());
//        userDTO.setCpf(faker.number().randomNumber(11, true));
//        userDTO.setEmail(faker.internet().emailAddress());
//        userDTO.setPassword(faker.internet().password());
//        AddressDTO addressDTO = new AddressDTO(faker.address().streetName(),
//                faker.number().numberBetween(1, 1000),
//                faker.address().secondaryAddress(),
//                faker.address().cityName(),
//                faker.address().city(),
//                faker.address().state(),
//                faker.address().country(),
//                faker.address().stateAbbr(),
//                faker.address().zipCode());
//        Address address = new Address();
//        BeanUtils.copyProperties(addressDTO, address);
//        List<Address> addresses = new ArrayList<>();
//        addresses.add(address);
//        userDTO.setAddress(addresses);
//        return userDTO;
//    }
//}
