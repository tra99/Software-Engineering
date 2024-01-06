package models;

public class ProductModel {
    private String productCode;
    private String productName;
    private String originCountry;
    private double price;
    private double cost;
    private String imageUrl;
    private String description;
    private String edit;


    public ProductModel(String edit) {
        this.edit = edit;
    }
    public String getEdit() {
        return edit;
    }
    public void setEdit(String edit) {
        this.edit = edit;
    }
    public ProductModel(String productCode, String productName, String originCountry,
                        double price, double cost, String imageUrl, String description) {
        this.productCode = productCode;
        this.productName = productName;
        this.originCountry = originCountry;
        this.price = price;
        this.cost = cost;
        this.imageUrl = imageUrl;
        this.description = description;
    }
    public String getProductCode() {
        return productCode;
    }
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getOriginCountry() {
        return originCountry;
    }
    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
