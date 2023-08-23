package net.weg.wegproject.ConcreteClasses.productsClasses.product.exceptions;

public class ProductDeleteException extends RuntimeException{
    public ProductDeleteException() {
        super("Não foi possivel deletar este produto");
    }
}
