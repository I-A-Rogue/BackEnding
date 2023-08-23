package net.weg.wegproject.ConcreteClasses.address.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.user.model.entity.User;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    @NotBlank(message = "Rua é obrigatório")
    private String rua;
    @NotBlank(message = "Número é obrigatório")
    private Integer numero;
    private String complemento;
    @NotBlank(message = "Bairro é obrigatório")
    private String bairro;
    @NotBlank(message = "Cidade é obrigatório")
    private String cidade;
    @NotBlank(message = "Estado é obrigatório")
    private String estado;
    @NotBlank(message = "País é obrigatório")
    private String pais;
    @NotBlank(message = "UF é obrigatório")
    private String uf;
    @NotBlank(message = "CEP é obrigatório")
    private String cep;

}
