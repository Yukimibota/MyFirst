/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FYP.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Yukimibota
 */
@Entity
public class DetectedObject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double x;
    private double y;
    private double leng;
    private double width;
    private Date time;
    
    public DetectedObject(double x, double y, double leng, double width) {
        this.x = x;
        this.y = y;
        this.leng = leng;
        this.width = width;
        time = new Date();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getLeng() {
        return leng;
    }

    public double getWidth() {
        return width;
    }

    public Date getTime() {
        return time;
    }
    
    public ObjectPoint getObjectPoint() {
        ObjectPoint pt = new ObjectPoint(x+width/2,y+leng/2,time);
        return pt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(java.lang.Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetectedObject)) {
            return false;
        }
        DetectedObject other = (DetectedObject) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[x:"+x+", y:"+y+", width:"+width+", length:"+leng+", time:"+time+"]";
    }
    
}
