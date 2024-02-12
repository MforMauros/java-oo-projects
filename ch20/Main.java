package gr.aueb.cf.ch20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    private static final List<Product> products = Arrays.asList(
            new Product(1, "Mobile", 200.0, 3),
            new Product(2, "Tablet", 380.0, 8),
            new Product(3, "Laptop", 670.0, 7),
            new Product(4, "Desktop", 1300.0, 4)

    );
    public static void main(String[] args) {

        checkAndPrintProducts(products, product -> product.getQuantity() >= 4, System.out::println);
        checkAndPrintProducts(products, product -> product.getPrice() > 150 && product.getPrice() < 700, System.out::println);
        checkAndPrintProducts(products, product -> product.getId() == 3, System.out::println);
        checkAndPrintProducts(products, product -> product.getQuantity() >= 3 && product.getPrice() > 1000, System.out::println);
    }

    public static List<Product> getFilteredProducts(List<Product> products, Predicate<Product> filter) {
        List<Product> productsToReturn = new ArrayList<>();
        for (Product product : products) {
            if (filter.test(product)) {
                productsToReturn.add(product);
            }
        }
        return productsToReturn;
    }

    public static void printProducts(List<Product> teachers, Consumer<Product> consumer) {
        for (Product product : products) {
            consumer.accept(product);
        }
    }

    public static void checkAndPrintProducts(List<Product> teachers, Predicate<Product> filter, Consumer<Product> consumer) {
        products.forEach(product -> {
            if (filter.test(product)) {
                consumer.accept(product);
            }
        });
    }


}
