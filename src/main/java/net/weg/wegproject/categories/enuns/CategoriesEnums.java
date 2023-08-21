package net.weg.wegproject.categories.enuns;

import net.weg.wegproject.categories.model.entity.Categories;

public enum CategoriesEnums {
    TINTA("Tinta"), MOTOR("Motor"), AUTOMACAO("Automação"), SEGURANCA("Segurança"), BUILDING("Building");

    String nome;
    CategoriesEnums(String nome){
        this.nome = nome;
    }
}
