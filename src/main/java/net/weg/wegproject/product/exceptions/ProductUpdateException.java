package net.weg.wegproject.product.exceptions;

public class ProductUpdateException extends RuntimeException{
    public ProductUpdateException() {
        super("Não foi possível editar este produto");
    }
}
