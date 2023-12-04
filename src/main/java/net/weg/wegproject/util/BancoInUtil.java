package net.weg.wegproject.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.address.model.entity.Address;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.repository.ProductRepository;
import net.weg.wegproject.ConcreteClasses.user.model.entity.User;
import net.weg.wegproject.ConcreteClasses.user.repository.UserRepository;
import net.weg.wegproject.security.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class BancoInUtil {

    @Autowired
    private UserRepository userRepository;
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
            productRepository.saveAll(entidades);
    }

    @PostConstruct
    public void createRandomUsers(){
        userRepository.deleteAll();
        userRepository.save(generateUser());
    }

    public User generateUser(){
        User user = new User();
        user.setEmail("teste@teste");
        user.setPassword(new BCryptPasswordEncoder().encode("teste"));
        user.setName(faker.name().fullName());
        user.setCpf(faker.number().randomNumber(11, true));
        user.setAddress(generateAddress());
        user.setAuthorities(List.of(Profile.ADMIN));
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setEnabled(true);
        user.setCredentialsNonExpired(true);
        return user;
    }

    private List<Address> generateAddress() {
        Address address = new Address(
                faker.address().streetName(),
                faker.number().numberBetween(1, 1000),
                faker.address().secondaryAddress(),
                faker.address().city(),
                faker.address().city(),
                faker.address().state(),
                faker.address().country(),
                faker.address().stateAbbr(),
                faker.address().zipCode()
        );

        List<Address> addresses = new ArrayList<>();
        addresses.add(address);
        return addresses;
    }
}


