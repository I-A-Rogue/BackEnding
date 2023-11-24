package net.weg.wegproject.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.address.model.dto.AddressDTO;
import net.weg.wegproject.ConcreteClasses.address.model.entity.Address;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.repository.ProductRepository;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.service.ProductService;
import net.weg.wegproject.ConcreteClasses.user.controller.UserController;
import net.weg.wegproject.ConcreteClasses.user.model.dto.UserDTO;
import net.weg.wegproject.ConcreteClasses.user.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class BancoInUtil {

    @Autowired
    private UserController userController;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    private final Faker faker = new Faker();

    @PostConstruct
    public void createRandomMotors() throws IOException {
        productRepository.deleteAll();
        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("json/motores.json");
        List<Product> entidades = objectMapper.readValue(resource.getInputStream(),
                new TypeReference<List<Product>>() {});
        for (Product product:entidades) {
            productService.create(product);
        }
    }

    @PostConstruct
    public void createRandomUsers(){
        userRepository.deleteAll();
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
}


