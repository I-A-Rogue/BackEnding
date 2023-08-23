package net.weg.wegproject.ConcreteClasses.productsClasses.product.exceptions;

public class ProductCreateException extends RuntimeException{
    public ProductCreateException() {
        super("Não foi possivel criar este produto");
    }
}
