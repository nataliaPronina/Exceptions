import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class ShopRepositoryTest {


    @Test

    public void RemoveIfProductFound() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "телефон", 30000);
        Product product2 = new Product(22, "книга", 3000);
        Product product3 = new Product(33, "машина", 3000000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(22);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);

    }


    @Test

    public void RemoveIfProductNotFoundA() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "телефон", 30000);
        Product product2 = new Product(22, "книга", 3000);
        Product product3 = new Product(33, "машина", 3000000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);


        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(44));

    }
}
