package net.weg.wegproject.util;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.address.model.entity.Address;
import net.weg.wegproject.ConcreteClasses.address.model.dto.AddressDTO;
import net.weg.wegproject.ConcreteClasses.address.service.AddressService;
import net.weg.wegproject.ConcreteClasses.productsClasses.automation.model.Automation;
import net.weg.wegproject.ConcreteClasses.productsClasses.building.model.Building;
import net.weg.wegproject.ConcreteClasses.productsClasses.ink.model.Ink;
import net.weg.wegproject.ConcreteClasses.productsClasses.motors.model.Motors;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.controller.ProductController;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.dto.ProductDTO;
import net.weg.wegproject.ConcreteClasses.productsClasses.security.model.Security;
import net.weg.wegproject.ConcreteClasses.user.controller.UserController;
import net.weg.wegproject.ConcreteClasses.user.model.dto.UserDTO;
import net.weg.wegproject.enums.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class BancoUtil {

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
            CategoriesEnums random =
                    CategoriesEnums.values()[faker.number().numberBetween(0, CategoriesEnums.values().length)];
            productDTO.setCategories(random);
            switch (random) {
                case AUTOMATION -> productDTO.setObject(gerarAutomation());
                case BUILDING -> productDTO.setObject(gerarBuilding());
                case INK -> productDTO.setObject(gerarInk());
                case SECURITY -> productDTO.setObject(gerarSecurity());
                case MOTORS -> productDTO.setObject(gerarMotor());
            }
            productController.create(productDTO);
        }

        userController.create(gerarUser());
    }

    public UserDTO gerarUser(){
        UserDTO userDTO = new UserDTO();
        userDTO.setName(faker.name().fullName());
        userDTO.setCpf(faker.number().randomNumber());
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
        userDTO.setCards(new ArrayList<>());
        return userDTO;
    }

    public Motors gerarMotor(){
        Motors motors = new Motors();
        motors.setCarcass(faker.lorem().word());
        motors.setMaterialCarcass(faker.lorem().word());
        motors.setPower((float) faker.number().randomDouble(2, 1, 100));
        motors.setFrequency(faker.number().randomDigit());
        motors.setPerformance((float) faker.number().randomDouble(2, 1, 100));
        motors.setPowerFactor((float) faker.number().randomDouble(2, 1, 100));
        motors.setNominalRotation(faker.number().randomDigit());
        motors.setSlip((float) faker.number().randomDouble(2, 1, 100));
        motors.setRatedVoltage((float) faker.number().randomDouble(2, 1, 100));
        motors.setNominalChain((float) faker.number().randomDouble(2, 1, 100));
        motors.setCurrentDeparture((float) faker.number().randomDouble(2, 1, 100));
        motors.setIpIn((float) faker.number().randomDouble(2, 1, 100));
        motors.setCurrentEmpty((float) faker.number().randomDouble(2, 1, 100));
        motors.setConjugateNominal((float) faker.number().randomDouble(2, 1, 100));
        motors.setConjugateDeparture((float) faker.number().randomDouble(2, 1, 100));
        motors.setMaximumConjugate((float) faker.number().randomDouble(2, 1, 100));
        motors.setTimeRotorLocked(faker.number().randomDigit() + "s");
        motors.setMomentInertia((float) faker.number().randomDouble(2, 1, 100));
        motors.setClassIsolation(IsolationClass.B);
        motors.setRegimeService(faker.lorem().word());
        motors.setMatchMethod(faker.bool().bool());
        motors.setRoomTemperature((float) faker.number().randomDouble(2, 1, 100));
        motors.setAltitude(faker.number().randomDigit());
        motors.setDegreeProtection(faker.lorem().word());
        motors.setRefrigeration(faker.lorem().word());
        motors.setConstructiveWay(faker.lorem().word());
        motors.setRotationDirection(faker.bool().bool());
        motors.setApproximateMass((float) faker.number().randomDouble(2, 1, 100));
        motors.setImpregnationMethod(faker.lorem().word());
        motors.setMaterialAxis(faker.lorem().word());
        motors.setPainting(faker.lorem().word());
        motors.setTypeGrounding(faker.lorem().word());
        motors.setMaterialBaffleCover(faker.lorem().word());
        motors.setThermalProtectionWinding(faker.lorem().word());
        motors.setBearingType(faker.lorem().word());
        motors.setBearingLNA(faker.lorem().word());
        motors.setProtectorFenolicOverload(faker.lorem().word());
        motors.setTropicalizedPainting(faker.lorem().word());
        return motors;
    }

    public Automation gerarAutomation(){
        Automation automation = new Automation();
        automation.setNominalVoltageInput(faker.number().randomDigit());
        InputPhases random =
                InputPhases.values()[faker.number().numberBetween(0, InputPhases.values().length)];
        automation.setNumberPhasesEntry(random);
        automation.setSettings(faker.lorem().word());
        automation.setNominalChain(faker.number().randomDigit());
        automation.setNominalChainH(faker.number().randomDigit());
        automation.setFilterRFI(faker.lorem().word());
        automation.setDegreeProtection(faker.lorem().word());
        automation.setRheostaticBraking(faker.lorem().word());
        automation.setInductorLink(faker.bool().bool());
        automation.setTemperature((float) faker.number().randomDouble(2, 1, 100));
        automation.setSafetyStop(faker.bool().bool());
        automation.setElectronicFeed(faker.lorem().word());
        return automation;
    }

    public Building gerarBuilding(){
        Building building = new Building();
        building.setReferenceProduct(faker.lorem().word());
        building.setCodigoInteligente(faker.lorem().word());
        building.setRatedPower(faker.number().randomDigit());
        building.setVoltageInput(faker.number().randomDigit() + "V");
        building.setVoltageOutput(faker.number().randomDigit());
        building.setAutonomy(faker.number().randomDigit());
        building.setBatterytype(faker.lorem().word());
        building.setFrequency(faker.number().randomDigit());
        LanguageAcronyms random =
                LanguageAcronyms.values()[faker.number().numberBetween(0, LanguageAcronyms.values().length)];
        building.setLanguage(random);
        building.setNominalChain((float) faker.number().randomDouble(2, 1, 100));
        building.setBusVoltage(faker.number().randomDigit());
        building.setCurrentBatteries(faker.number().randomDigit());
        building.setTypeplug(faker.lorem().word());
        building.setCasing(faker.lorem().word());
        building.setColorStructure(faker.lorem().word());
        return building;
    }

    public Security gerarSecurity(){
        Security security = new Security();
        security.setVoltageNominalIsolationUi(faker.number().randomDigit());
        security.setLimitMinimumFrequency(faker.number().randomDigit());
        security.setLimitMaximumFrequency(faker.number().randomDigit());
        security.setMechanics(faker.number().randomDigit());
        security.setMechanicalLife(faker.number().randomDigit());
        security.setEletricalLife(faker.lorem().word());
        security.setDegreeProtecaoTerminals(faker.lorem().word());
        security.setGrauProtecaoBobina(faker.lorem().word());
        security.setDegreeProtectionCoil(faker.number().randomDigit());
        security.setCurrentNominalIn(faker.lorem().word());
        security.setCurrentNominalEmployment(faker.lorem().word());
        security.setVoltageEmploymentUIEC(faker.number().randomDigit());
        security.setVoltageEmploymentUIUE(faker.number().randomDigit());
        security.setHeight((float) faker.number().randomDouble(2, 1, 100));
        security.setWidth((float) faker.number().randomDouble(2, 1, 100));
        security.setDepth((float) faker.number().randomDouble(2, 1, 100));
        security.setGrossWeight((float) faker.number().randomDouble(2, 1, 100));
        security.setReference(faker.lorem().word());
        security.setContact(faker.lorem().word());
        security.setVoltageCommand(faker.number().randomDigit());
        security.setTerminalType(faker.lorem().word());
        return security;
    }

    public Ink gerarInk(){
        Ink ink = new Ink();
        ink.setColor(faker.color().name());
        ink.setDensity(faker.lorem().word());
        ink.setType(InkEnums.values()[faker.number().numberBetween(0, InkEnums.values().length)]);
        return ink;
    }


}
