package pjatk.project.Controller;

import pjatk.project.Model.Customer;
import pjatk.project.Model.Product;
import pjatk.project.Model.Shop;

import java.util.List;
import java.util.Optional;

public class ShopService {
    private Shop shop;

    public ShopService(Shop shop) {
        this.shop = shop;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    private Optional<Product> findProductInShop(int productId) {
        return shop.getProductList().stream().filter(product -> product.getId() == productId).findFirst();
    }

    private Optional<Product> findProductInCustomer(int productId) {
        List<Product> productsBoughtByCustomers = shop.getCustomerList().forEach(customer -> customer.getPurchasedProducts().add());
        return productsBoughtByCustomers.stream().filter(product -> product.getId() == productId).findFirst();
    }

    public List<Product> sellProduct(int productID, Customer customer) {
        shop.removeProductById(productID);
        shop.addProductToSold(findProductInShop(productID).get());
        customer.addProductToPurchased(findProductInShop(productID).get());
        return customer.getPurchasedProducts();
    }



}
