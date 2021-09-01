package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
  private ProductRepository repository = new ProductRepository();
  private Book coreJava = new Book(1, "coreJava", 100, "Developers");
  private Book someBook = new Book(2, "someBook", 300, "Someone");
  private Book someBook2 = new Book(2, "someBook", 300, "Someone");
  private Smartphone iPhone10 = new Smartphone(3, "iPhone10", 70_000, "Apple");
  private Smartphone samsung10 = new Smartphone(4, "samsung10", 50_000, "Samsung");

  @Test
  public void shouldSaveOneItem() {
    repository.save(coreJava);

    Product[] expected = new Product[]{coreJava};
    Product[] actual = repository.findAll();
    assertArrayEquals(expected, actual);
  }
  @Test
  public void shouldSaveAllItems() {
    repository.save(coreJava);
    repository.save(someBook);
    repository.save(iPhone10);
    repository.save(samsung10);

    Product[] expected = new Product[]{coreJava, someBook, iPhone10, samsung10};
    Product[] actual = repository.findAll();
    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldRemoveById (){
    repository.save(coreJava);
    repository.save(someBook);
    repository.save(iPhone10);
    repository.save(samsung10);
    Product[] expected = new Product[]{coreJava, someBook, samsung10};
    Product[] actual = repository.removeById(3);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldFindById () {
    repository.save(coreJava);
    repository.save(someBook);
    repository.save(iPhone10);
    repository.save(samsung10);
    Product[] expected = new Product[]{someBook};
    Product[] actual = repository.findById(2);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldFindByNotExistingId () {
    repository.save(coreJava);
    repository.save(someBook);
    repository.save(iPhone10);
    repository.save(samsung10);
    Product[] expected = null;
    Product[] actual = repository.findById(7);
    assertArrayEquals(expected, actual);
  }




}
