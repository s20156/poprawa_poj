package pjatk.project.Controller;

import pjatk.project.Model.Product;
import pjatk.project.Model.Shop;
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

    public Optional<Product> findProductInShop(int productId) {
        return shop.getProductList().stream().filter(product -> product.getId() == productId).findFirst();
    }


}
