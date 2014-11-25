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
public class Sell {

    private String tempProductId;
    private Products product;
    private int qty;
    private String price;
    private String totalPrice;
    private int remainingQty;
    private String variationID;

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return price;
    }

    public String getPriceStr() {
        return MyUtil.decimalFormat.format(Double.parseDouble(price.replaceAll(",", "")));
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotalPrice() {
        setTotalPrice(MyUtil.decimalFormat.format(getQty() * Double.parseDouble(getPrice() == null ? "0" : getPrice())));
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTempProductId() {
        return tempProductId;
    }

    public void setTempProductId(String tempProductId) {
        this.tempProductId = tempProductId;
    }

    public int getRemainingQty() {
        return remainingQty;
    }

    public void setRemainingQty(int remainingQty) {
        this.remainingQty = remainingQty;
    }

    public String getVariationID() {
        return variationID;
    }

    public void setVariationID(String variationID) {
        this.variationID = variationID;
    }
}
