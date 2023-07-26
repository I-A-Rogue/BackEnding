package net.weg.wegproject.company.service;

import lombok.AllArgsConstructor;
import net.weg.wegproject.company.model.entity.Company;
import net.weg.wegproject.model.exceptions.companyExceptions.NoCompanyException;
import net.weg.wegproject.company.repository.CompanyRepository;
import net.weg.wegproject.interfeces.ServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class CompanyService implements ServiceInterface<Company> {
    CompanyRepository companyRepository;

    @Override
    public Company create(Company obj) {
        return companyRepository.save(obj);
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findOne(Long id) {
        try {
            return companyRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new NoCompanyException();
        }
    }

    @Override
    public Company update(Company obj) {
        return companyRepository.save(obj);
    }

    @Override
    public Company delete(Long id) {
        Company company = findOne(id);
        companyRepository.deleteById(id);
        return company;
    }

    public static boolean verificarCNPJ(String cnpj) {

        cnpj = cnpj.replaceAll("[^0-9]", "");

        if (cnpj.length() != 14) {
            return false;
        }

        if (cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }

        int soma = 0;
        int[] peso = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        for (int i = 0; i < 12; i++) {
            soma += (cnpj.charAt(i) - '0') * peso[i];
        }
        int digito1 = 11 - (soma % 11);
        if (digito1 > 9) {
            digito1 = 0;
        }

        soma = 0;
        peso = new int[]{6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        for (int i = 0; i < 13; i++) {
            soma += (cnpj.charAt(i) - '0') * peso[i];
        }
        int digito2 = 11 - (soma % 11);
        if (digito2 > 9) {
            digito2 = 0;
        }

        return (cnpj.charAt(12) - '0' == digito1) && (cnpj.charAt(13) - '0' == digito2);
    }
}
