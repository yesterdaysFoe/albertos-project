/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import utils.MyUtil;

/**
 *
 * @author David Daniel Kurtz <daviddanielkurtz@gmail.com>
 */
@Entity
@Table(name = "stocks_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StocksHistory.findAll", query = "SELECT s FROM StocksHistory s"),
    @NamedQuery(name = "StocksHistory.findById", query = "SELECT s FROM StocksHistory s WHERE s.id = :id"),
    @NamedQuery(name = "StocksHistory.findByDate", query = "SELECT s FROM StocksHistory s WHERE s.date = :date"),
    @NamedQuery(name = "StocksHistory.findByQty", query = "SELECT s FROM StocksHistory s WHERE s.qty = :qty"),
    @NamedQuery(name = "StocksHistory.findByAction", query = "SELECT s FROM StocksHistory s WHERE s.action = :action"),
    @NamedQuery(name = "StocksHistory.findByComment", query = "SELECT s FROM StocksHistory s WHERE s.comment = :comment"),
    @NamedQuery(name = "StocksHistory.findByProductId", query = "SELECT s FROM StocksHistory s WHERE s.productId = :productId")})
public class StocksHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @Column(name = "qty")
    private int qty;
    @Basic(optional = false)
    @Column(name = "action")
    private String action;
    @Basic(optional = false)
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @Column(name = "product_id")
    private int productId;

    public StocksHistory() {
    }

    public StocksHistory(Integer id) {
        this.id = id;
    }

    public StocksHistory(Integer id, Date date, int qty, String action, String comment, int productId) {
        this.id = id;
        this.date = date;
        this.qty = qty;
        this.action = action;
        this.comment = comment;
        this.productId = productId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public String getDateStr() {
        return MyUtil.dateFormatMMMMMddyyyy.format(getDate());
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
        if (!(object instanceof StocksHistory)) {
            return false;
        }
        StocksHistory other = (StocksHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.StocksHistory[ id=" + id + " ]";
    }
}
