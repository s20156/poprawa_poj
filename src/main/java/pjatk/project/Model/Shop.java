package pjatk.project.Model;

import java.util.List;

public class Shop {
    private int shopId;
    @ShopName
    private String name;
    private List<Product> productList;
    private List<Product> soldList;
    private List<Customer> customerList;

    public Shop(int shopId, String name) {
        this.shopId = shopId;
        this.name = name;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
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

    public void addProductToSold(Product product) {
        soldList.add(product);
    }

    public void removeProductByIdFromSold(int id) {
        soldList.removeIf(product -> product.getId() == id);
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
