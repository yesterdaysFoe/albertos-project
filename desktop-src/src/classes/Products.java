/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import utils.MyUtil;

/**
 *
 * @author David Daniel Kurtz <daviddanielkurtz@gmail.com>
 */
public class Products {

    private String id;
    private String sku;
    private String productName;
    private String productDetails;
    private String remainingQty;
    private String price;
    private String category;
    private String addText;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getRemainingQty() {
        if (remainingQty == null || remainingQty.equals("")) {
            return "0";
        }
        return remainingQty;
    }

    public void setRemainingQty(String remainingQty) {
        this.remainingQty = remainingQty;
    }

    public String getPrice() {
        if (price == null || price.equals("")) {
            return "0";
        }
        return price;
    }

    public String getPriceStr() {
        return MyUtil.decimalFormat.format(Double.parseDouble(getPrice().replaceAll(",", "")));
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public String getTotalCost() {
        return "" + MyUtil.decimalFormat.format(Double.parseDouble(getPrice().replaceAll(",", "")) * Double.parseDouble(getRemainingQty()));
    }

    public String getAddText() {
        if (addText == null) {
            addText = "";
        }
        return addText;
    }

    public String getRealName() {
        return getProductName() + getAddText();
    }

    public void setAddText(String addText) {
        this.addText = addText;
    }
}
