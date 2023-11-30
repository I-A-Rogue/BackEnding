package net.weg.wegproject.ConcreteClasses.address.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wegproject.ConcreteClasses.user.model.entity.User;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String rua;
    @Column(nullable = false)
    private Integer numero;
    private String complemento;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)
    private String pais;
    @Column(nullable = false)
    @Size(min = 2, max = 2)
    private String uf;
    @Column(nullable = false)
    private String cep;
    @ManyToMany(mappedBy = "address", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<User> user;

    public Address(String rua, int numero, String complemento, String bairro, String cidade, String estado, String pais, String uf, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.uf = uf;
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", rua='" + rua + '\'' +
                ", numero=" + numero +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", pais='" + pais + '\'' +
                ", uf='" + uf + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
