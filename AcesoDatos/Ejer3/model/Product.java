package model;

import java.math.BigDecimal;

public class Product {
    private Integer productID;
    private String productName;
    private Integer supplierID;
    private Integer categoryID;
    private String quantityPerUnit;
    private BigDecimal unitPrice;
    private Integer unitsInStock;

    public Product() {}

    public Product(Integer productID, String productName, Integer supplierID, Integer categoryID,
                   String quantityPerUnit, BigDecimal unitPrice, Integer unitsInStock) {
        this.productID = productID;
        this.productName = productName;
        this.supplierID = supplierID;
        this.categoryID = categoryID;
        this.quantityPerUnit = quantityPerUnit;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
    }

    public Integer getProductID() { return productID; }
    public void setProductID(Integer productID) { this.productID = productID; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public Integer getSupplierID() { return supplierID; }
    public void setSupplierID(Integer supplierID) { this.supplierID = supplierID; }

    public Integer getCategoryID() { return categoryID; }
    public void setCategoryID(Integer categoryID) { this.categoryID = categoryID; }

    public String getQuantityPerUnit() { return quantityPerUnit; }
    public void setQuantityPerUnit(String quantityPerUnit) { this.quantityPerUnit = quantityPerUnit; }

    public BigDecimal getUnitPrice() { return unitPrice; }
    public void setUnitPrice(BigDecimal unitPrice) { this.unitPrice = unitPrice; }

    public Integer getUnitsInStock() { return unitsInStock; }
    public void setUnitsInStock(Integer unitsInStock) { this.unitsInStock = unitsInStock; }

    @Override
    public String toString() {
        return productID + " - " + productName;
    }
}
