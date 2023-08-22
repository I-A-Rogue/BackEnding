package net.weg.wegproject.util;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.productsClasses.motors.model.Motors;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.controller.ProductController;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.dto.ProductDTO;
import net.weg.wegproject.enums.CategoriesEnums;
import net.weg.wegproject.enums.IsolationClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BancoUtil {

    @Autowired
    private static ProductController productController;
    private static final Faker faker = new Faker();

    public static void createRandomMotors() {
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

        ProductDTO productDTO = new ProductDTO();
        productDTO.setCode(faker.number().randomNumber());
        productDTO.setName(faker.commerce().productName());
        productDTO.setPrice((float) faker.number().randomDouble(2, 10, 1000)); // Adjust the range as needed
        productDTO.setStockSize(faker.number().randomDigit());
        productDTO.setDescription(faker.lorem().sentence());
        productDTO.setAssessment(null);
        CategoriesEnums randomCategory = CategoriesEnums.values()[faker.number().numberBetween(0, CategoriesEnums.values().length)];
        productDTO.setCategories(randomCategory);
        productDTO.setObject(motors);

        productController.create(productDTO);
    }

}
