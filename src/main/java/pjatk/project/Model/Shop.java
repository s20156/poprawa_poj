package pjatk.project.Model;

import java.util.List;

public class Shop {
    private String shopId;
    private String name;
    private List<Product> productList;
    private List<Product> soldList;

    public Shop(String shopId, String name, List<Product> productList, List<Product> soldList) {
        this.shopId = shopId;
        this.name = name;
        this.productList = productList;
        this.soldList = soldList;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getSoldList() {
        return soldList;
    }

    public void setSoldList(List<Product> soldList) {
        this.soldList = soldList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void removeProductById(int id) {
        productList.removeIf(product -> product.getId() == id);
    }
}
