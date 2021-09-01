package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    public void shouldUseEquals() {
        Product first = new Product(1, "Java I", 1000);
        Product second = new Product(1, "Java I", 1000);
        assertEquals(first, second);
    }

    @Test
    public void shouldUseEqualsWhenSameProduct() {
        Product first = new Product(1, "Java I", 1000);
        Product second = first;
        assertEquals(first, second);
    }

    @Test
    public void shouldUseOverridedMethod() {
        Product product = new Product();
        product.toString();
    }

    @Test
    public void shouldUseOverridedHashCode() {
        Product product = new Product();
        product.hashCode();
    }

    @Test
    public void shouldSetId() {
        Product product = new Product();
        product.setId(1);
    }

    @Test
    public void shouldSetPrice() {
        Product product = new Product();
        product.setPrice(100);
    }

    @Test
    public void shouldSetName() {
        Product product = new Product();
        product.setName("Name");
    }

    @Test
    public void shouldGetPrice() {
        Product product = new Product();
        product.setPrice(100);
        product.getPrice();
    }

}
