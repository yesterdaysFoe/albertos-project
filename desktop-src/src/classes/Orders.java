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
public class Orders {

    private String Id;
    private Customer customer;
    private String totalOrder;
    private String orderDate;
    private String orderStatus;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getTotalOrder() {
        return totalOrder;
    }

    public String getTotalOrderStr() {
        return MyUtil.decimalFormat.format(Double.parseDouble(getTotalOrder()));
    }

    public void setTotalOrder(String totalOrder) {
        this.totalOrder = totalOrder;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
