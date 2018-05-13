/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaiko;

import java.io.Serializable;

/**
 *
 * @author takizawaryoutarou
 */
public class Product implements Serializable {


    private int productID;       //商品ID
    private String productName;  //商品名  
    private String productType;  //商品の種類  
    private int productPrice;    //商品の価格
    private int productStock;    //商品の在庫

    public Product() {
    }

    public Product(int productID, String productName, String productType, int productPrice, int productStock) {
        this.productID = productID;
        this.productName = productName;
        this.productType = productType;
        this.productPrice = productPrice;
        this.productStock = productStock;

    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public int getProductStock() {
        return productStock;
    }

}
    

