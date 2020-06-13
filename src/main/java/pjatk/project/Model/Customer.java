package pjatk.project.Model;

import java.util.List;

public class Customer {
    private int id;
    private List<Product> purchasedProducts;

    public Customer(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(List<Product> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }

    public void addProductToPurchased(Product product) {
        purchasedProducts.add(product);
    }

    public void removeProductFromPurchasedListById(int id) {
        purchasedProducts.removeIf(product -> product.getId() == id);
    }
}
