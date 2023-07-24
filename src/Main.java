import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Product {
    private int id;
    private String type;
    private double price;
    private boolean discount;
    private LocalDate createDate;

    public Product(int id, String type, double price, boolean discount, LocalDate createDate) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean hasDiscount() {
        return discount;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product(1, "Book", 100, false, LocalDate.of(2022, 1, 1)),
                new Product(2, "Book", 200, true, LocalDate.of(2022, 2, 1)),
                new Product(3, "Toy", 50, false, LocalDate.of(2022, 3, 1)),
                new Product(4, "Toy", 150, true, LocalDate.of(2022, 4, 1))
        );

        Map<String, List<Product>> groupedProducts = products.stream()
                .collect(Collectors.groupingBy(Product::getType));

        groupedProducts.forEach((type, productList) -> {
            System.out.println(type + ":");
            productList.forEach(p -> System.out.println("Id: " + p.getId() + ", Price: " + p.getPrice()));
            System.out.println();
        });
    }
}
