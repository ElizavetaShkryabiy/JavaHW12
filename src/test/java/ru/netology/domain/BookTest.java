package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    public void shouldHaveAllFieldsAndMethodFromSuperClass() {
        Book book = new Book();
    }

    @Test
    public void shouldCastFromBaseClass() {
        Product product = new Book();
        if (product instanceof Book) {
            Book book = (Book) product;
        }
    }

//    @Test
//    public void shouldNotCastToDifferentClass() {
//        Product product = new Book();
//        Smartphone shirt = (Smartphone) product;
//    }

    @Test
    public void shouldUseOverridedMethod() {
        Product product = new Book();
        product.toString();
    }

    @Test
    public void shouldUseOverridedHashCode() {
        Product product = new Book();
        product.hashCode();
    }

    @Test
    public void shouldUseOverridedEquals() {
        Book product = new Book(2, "someBook", 300, "Someone");
        Book product2 = new Book(2, "someBook", 300, "Someone");

        assertEquals(product, product2);
    }

    @Test
    public void shouldUseOverridedEqualsWhenSameProduct() {
        Book product = new Book(2, "someBook", 300, "Someone");
        Book product2 = product;

        assertEquals(product, product2);
    }

    @Test
    public void shouldSetAuthor(){
        Product product = new Book();
        ((Book) product).setAuthor("Someone");
    }
}
