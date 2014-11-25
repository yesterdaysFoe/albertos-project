/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author David Daniel Kurtz <daviddanielkurtz@gmail.com>
 */
@Entity
@Table(name = "wp1_postmeta")
@XmlRootElement
public class Postmeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "meta_id")
    private Long metaId;
    @Basic(optional = false)
    @Column(name = "post_id")
    private long postId;
    @Column(name = "meta_key")
    private String metaKey;
    @Lob
    @Column(name = "meta_value")
    private String metaValue;

    public Postmeta() {
    }

    public Postmeta(Long metaId) {
        this.metaId = metaId;
    }

    public Postmeta(Long metaId, long postId) {
        this.metaId = metaId;
        this.postId = postId;
    }

    public Long getMetaId() {
        return metaId;
    }

    public void setMetaId(Long metaId) {
        this.metaId = metaId;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public String getMetaKey() {
        return metaKey;
    }

    public void setMetaKey(String metaKey) {
        this.metaKey = metaKey;
    }

    public String getMetaValue() {
        return metaValue;
    }

    public void setMetaValue(String metaValue) {
        this.metaValue = metaValue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (metaId != null ? metaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Postmeta)) {
            return false;
        }
        Postmeta other = (Postmeta) object;
        if ((this.metaId == null && other.metaId != null) || (this.metaId != null && !this.metaId.equals(other.metaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pos.entities.Wp1Postmeta[ metaId=" + metaId + " ]";
    }
}
