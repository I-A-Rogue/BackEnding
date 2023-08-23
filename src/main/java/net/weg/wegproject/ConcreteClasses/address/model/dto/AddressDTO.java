package net.weg.wegproject.ConcreteClasses.address.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.user.model.entity.User;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private String rua;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String uf;
    private String cep;

}
