        package net.weg.wegproject.util;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.address.model.dto.AddressDTO;
import net.weg.wegproject.ConcreteClasses.address.model.entity.Address;
import net.weg.wegproject.ConcreteClasses.address.service.AddressService;
import net.weg.wegproject.ConcreteClasses.productsClasses.motors.model.Motors;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.controller.ProductController;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.dto.ProductDTO;
import net.weg.wegproject.ConcreteClasses.user.controller.UserController;
import net.weg.wegproject.ConcreteClasses.user.model.dto.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class BancoInUtil {

    @Autowired
    private ProductController productController;
    @Autowired
    private UserController userController;
    @Autowired
    private AddressService addressService;
    private final Faker faker = new Faker();

    @PostConstruct
    public void createRandomMotors() {
            for (Long i = 1l; i <= 30; i++) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setCode(i);
            productDTO.setName(faker.commerce().productName());
            productDTO.setPrice((float) faker.number().randomDouble(2, 10, 1000)); // Adjust the range as needed
            productDTO.setStockSize(faker.number().randomDigit());
            productDTO.setDescription(faker.lorem().sentence());
            productDTO.setApplication(faker.lorem().sentence());
            productDTO.setCaracteristics(faker.lorem().sentence());
            productDTO.setOptional(faker.lorem().sentence());
            productDTO.setObject(gerarMotor());
            productController.create(productDTO);
        }

        userController.create(gerarUser());
    }

    public UserDTO gerarUser(){
        UserDTO userDTO = new UserDTO();
        userDTO.setName(faker.name().fullName());
        userDTO.setCpf(faker.number().randomNumber(11, true));
        userDTO.setEmail(faker.internet().emailAddress());
        userDTO.setPassword(faker.internet().password());
        AddressDTO addressDTO = new AddressDTO(faker.address().streetName(),
                faker.number().numberBetween(1, 1000),
                faker.address().secondaryAddress(),
                faker.address().cityName(),
                faker.address().city(),
                faker.address().state(),
                faker.address().country(),
                faker.address().stateAbbr(),
                faker.address().zipCode());
        Address address = new Address();
        BeanUtils.copyProperties(addressDTO, address);
        List<Address> addresses = new ArrayList<>();
        addresses.add(address);
        userDTO.setAddress(addresses);
        return userDTO;
    }

    public Motors gerarMotor(){
        Motors motors = new Motors();
        motors.setFrequency(faker.number().randomDigit());
        motors.setNominalRotation(faker.number().randomDigit());
        motors.setIpIn((float) faker.number().randomDouble(2, 1, 100));
        motors.setConjugateNominal((float) faker.number().randomDouble(2, 1, 100));
        motors.setMaximumConjugate((float) faker.number().randomDouble(2, 1, 100));
        motors.setRoomTemperature((float) faker.number().randomDouble(2, 1, 100));
        motors.setAltitude(faker.number().randomDigit());
        return motors;
    }
}
