package pjatk.project.Controller;

import pjatk.project.Model.Customer;
import pjatk.project.Model.Product;
import pjatk.project.Model.Shop;


import java.math.BigDecimal;
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

    private Optional<Product> findProductInCustomer(int productId, Customer customer) {
        return customer.getPurchasedProducts().stream().filter(product -> product.getId() == productId).findFirst();
    }
//
//    Miałem tutaj pomysł, żeby wyciągnąć customera z listy customerów w sklepie i przez forEacha dodawać każdą listę kupionych produktów do listy, ale trochę zabrakło mi czasu na dopieszczenie implementacji, dlatego dodałem wersję uproszczoną z Customerem w
//
//    private Optional<Product> findProductInCustomer(int productId) {
//        List<Product> productsBoughtByCustomers;
//        productsBoughtByCustomers.addAll(shop.getCustomerList().forEach(customer -> customer.getPurchasedProducts()));
//        return productsBoughtByCustomers.stream().filter(product -> product.getId() == productId).findFirst();
//    }


    public List<Product> sellProduct(int productID, Customer customer) {
        shop.removeProductById(productID);
        shop.addProductToSold(findProductInShop(productID).get());
        customer.addProductToPurchased(findProductInShop(productID).get());
        return customer.getPurchasedProducts();
    }

    public List<Product> returnProduct(int productId, Customer customer) {
        try {
            customer.removeProductFromPurchasedListById(productId);
            shop.removeProductByIdFromSold(productId);
            shop.addProduct(findProductInCustomer(productId, customer).get());
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return shop.getProductList();
    }

    public BigDecimal getSoldProductsReport() {
        BigDecimal report = new BigDecimal(shop.getSoldList().stream().map(product -> product.getPrice()).reduce(0.0,(a, b) -> a+b));
        return report;
    }
}
