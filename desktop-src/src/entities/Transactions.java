/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import utils.MyUtil;

/**
 *
 * @author David Daniel Kurtz <daviddanielkurtz@gmail.com>
 */
@Entity
@Table(name = "transactions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactions.findAll", query = "SELECT t FROM Transactions t"),
    @NamedQuery(name = "Transactions.findById", query = "SELECT t FROM Transactions t WHERE t.id = :id"),
    @NamedQuery(name = "Transactions.findByCustomerName", query = "SELECT t FROM Transactions t WHERE t.customerName = :customerName"),
    @NamedQuery(name = "Transactions.findByProductName", query = "SELECT t FROM Transactions t WHERE t.productName = :productName"),
    @NamedQuery(name = "Transactions.findByProductId", query = "SELECT t FROM Transactions t WHERE t.productId = :productId"),
    @NamedQuery(name = "Transactions.findByPrice", query = "SELECT t FROM Transactions t WHERE t.price = :price"),
    @NamedQuery(name = "Transactions.findByTotalPrice", query = "SELECT t FROM Transactions t WHERE t.totalPrice = :totalPrice"),
    @NamedQuery(name = "Transactions.findByQty", query = "SELECT t FROM Transactions t WHERE t.qty = :qty"),
    @NamedQuery(name = "Transactions.findByDate", query = "SELECT t FROM Transactions t WHERE t.date = :date"),
    @NamedQuery(name = "Transactions.findByCustomerAddress", query = "SELECT t FROM Transactions t WHERE t.customerAddress = :customerAddress"),
    @NamedQuery(name = "Transactions.findByCustomerContactNumber", query = "SELECT t FROM Transactions t WHERE t.customerContactNumber = :customerContactNumber"),
    @NamedQuery(name = "Transactions.findByCustomerEmail", query = "SELECT t FROM Transactions t WHERE t.customerEmail = :customerEmail"),
    @NamedQuery(name = "Transactions.findByAmountTender", query = "SELECT t FROM Transactions t WHERE t.amountTender = :amountTender"),
    @NamedQuery(name = "Transactions.findByOrderId", query = "SELECT t FROM Transactions t WHERE t.orderId = :orderId")})
public class Transactions implements Serializable {

    @Column(name = "product_id")
    private Long productId;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "customer_name")
    private String customerName;
    @Basic(optional = false)
    @Column(name = "product_name")
    private String productName;
    @Basic(optional = false)
    @Column(name = "price")
    private double price;
    @Basic(optional = false)
    @Column(name = "totalPrice")
    private double totalPrice;
    @Basic(optional = false)
    @Column(name = "qty")
    private int qty;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "customer_address")
    private String customerAddress;
    @Column(name = "customer_contact_number")
    private String customerContactNumber;
    @Column(name = "customer_email")
    private String customerEmail;
    @Basic(optional = false)
    @Lob
    @Column(name = "product_details")
    private String productDetails;
    @Basic(optional = false)
    @Column(name = "amount_tender")
    private String amountTender;
    @Column(name = "order_id")
    private String orderId;
    @OneToMany(mappedBy = "parrentTransaction")
    private List<Transactions> transactionsList;
    @JoinColumn(name = "parrent_transaction", referencedColumnName = "id")
    @ManyToOne
    private Transactions parrentTransaction;
    @Basic(optional = false)
    @Column(name = "invoice")
    private int invoice;

    public Transactions() {
    }

    public Transactions(Long id) {
        this.id = id;
    }

    public Transactions(Long id, String customerName, String productName, double price, double totalPrice, int qty, Date date, String productDetails, String amountTender) {
        this.id = id;
        this.customerName = customerName;
        this.productName = productName;
        this.price = price;
        this.totalPrice = totalPrice;
        this.qty = qty;
        this.date = date;
        this.productDetails = productDetails;
        this.amountTender = amountTender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    @Transient
    public String getPriceStr() {
        return MyUtil.decimalFormat.format(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

     @Transient
    public String getTotalPriceStr() {
        return MyUtil.decimalFormat.format(totalPrice);
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerContactNumber() {
        return customerContactNumber;
    }

    public void setCustomerContactNumber(String customerContactNumber) {
        this.customerContactNumber = customerContactNumber;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public String getAmountTender() {
        return amountTender;
    }

    public void setAmountTender(String amountTender) {
        this.amountTender = amountTender;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @XmlTransient
    public List<Transactions> getTransactionsList() {
        return transactionsList;
    }

    public void setTransactionsList(List<Transactions> transactionsList) {
        this.transactionsList = transactionsList;
    }

    public Transactions getParrentTransaction() {
        return parrentTransaction;
    }

    public void setParrentTransaction(Transactions parrentTransaction) {
        this.parrentTransaction = parrentTransaction;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactions)) {
            return false;
        }
        Transactions other = (Transactions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pos.entities.Transactions[ id=" + id + " ]";
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getInvoice() {
        return invoice;
    }

    public void setInvoice(int invoice) {
        this.invoice = invoice;
    }
}
