/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;
import utils.MyUtil;

/**
 *
 * @author David Daniel Kurtz <daviddanielkurtz@gmail.com>
 */
public class TransactionVo {

    private long id;
    private Date date;
    private String customerName;
    private double price;
    private double totalPrice;
    private int invoice;

    public Date getDate() {
        return date;
    }

    public String getDateStr() {
        return MyUtil.dateFormatMMMMMddyyyy.format(getDate());
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getTotalPriceStr() {
        return MyUtil.decimalFormat.format(getTotalPrice());
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInvoiceStr() {
        return MyUtil.df.format(getInvoice());
    }

    public int getInvoice() {
        return invoice;
    }

    public void setInvoice(int invoice) {
        this.invoice = invoice;
    }
    
}
