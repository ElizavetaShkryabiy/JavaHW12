package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartphoneTest {
    @Test
    public void shouldHaveAllFieldsAndMethodFromSuperClass() {
        Smartphone smartphone = new Smartphone();
    }

    @Test
    public void shouldCastFromBaseClass() {
        Product product = new Smartphone();
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
        }
    }

//    @Test
//    public void shouldNotCastToDifferentClass() {
//        Product product = new Smartphone();
//        Book book = (Book) product;
//    }

    @Test
    public void shouldUseOverridedMethod() {
        Product product = new Smartphone();
        product.toString();
    }

    @Test
    public void shouldUseOverridedHashCode() {
        Product product = new Smartphone();
        product.hashCode();
    }

    @Test
    public void shouldUseOverridedEquals() {
        Smartphone product = new Smartphone(2, "iPhone10", 300, "Apple");
        Smartphone product2 = new Smartphone(2, "iPhone10", 300, "Apple");

        assertEquals(product, product2);
    }
    @Test
    public void shouldUseOverridedEqualsWhenSameProduct() {
        Smartphone product = new Smartphone(2, "iPhone10", 300, "");
        Smartphone product2 = product;

        assertEquals(product, product2);
    }

    @Test
    public void shouldSetAuthor(){
        Product product = new Smartphone();
        ((Smartphone) product).setManufacturer("Apple");
    }
}

