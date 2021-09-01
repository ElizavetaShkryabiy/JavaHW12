package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.Manager;
import ru.netology.repository.NotFoundException;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ManagerTest {

    ProductRepository productRepository = new ProductRepository();
    Manager manager = new Manager(productRepository);
    private Book coreJava = new Book(1, "coreJava", 100, "Developers");
    private Book someBook = new Book(2, "someBook", 300, "Someone");
    private Book someBook2 = new Book(6, "someBook", 3600, "Roman");
    private Smartphone iPhone10 = new Smartphone(3, "iPhone10", 70_000, "Apple");
    private Smartphone samsung10 = new Smartphone(4, "samsung10", 50_000, "Samsung");
    private Product toy = new Product(5, "dog", 250);


    @BeforeEach
    public void setUp() {
        manager.add(coreJava);
        manager.add(someBook);
        manager.add(iPhone10);
        manager.add(samsung10);
        manager.add(toy);
    }

    @Test
    public void shouldAddItemsInRepository() {
        Product[] actual = manager.findAll();
        Product[] expected = new Product[]{coreJava, someBook, iPhone10, samsung10, toy};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookByName() {
        Product[] actual = manager.searchBy("coreJava");
        Product[] expected = new Product[]{coreJava};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByName() {
        Product[] actual = manager.searchBy("iPhone10");
        Product[] expected = new Product[]{iPhone10};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthor() {
        Product[] actual = manager.searchBy("Developers");
        Product[] expected = new Product[]{coreJava};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByManufacturer() {
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{iPhone10};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByProductNotInSearchParameters() {
        Product[] actual = manager.searchBy("dog");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProductsWithSameFields() {
        manager.add(someBook2);
        Product[] actual = manager.searchBy("someBook");
        Product[] expected = new Product[]{someBook, someBook2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        Product[] expected = new Product[]{coreJava, someBook, samsung10, toy};
        Product[] actual = manager.removeById(3);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByNotExistingId() {
        assertThrows(NotFoundException.class, () -> manager.removeById(9));
    }
}
