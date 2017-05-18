package com.ieds.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jia on 2017/5/2.
 */
@Entity
@Table(name = "item_info", schema = "tec", catalog = "")
public class ItemInfoEntity {
    private int id;
    private String itemNm;
    private Date operateTime;
    private String bidId;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ITEM_NM", nullable = true, length = 255)
    public String getItemNm() {
        return itemNm;
    }

    public void setItemNm(String itemNm) {
        this.itemNm = itemNm;
    }

    @Basic
    @Column(name = "OPERATE_TIME", nullable = true)
    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    @Basic
    @Column(name = "BID_ID", nullable = true, length = 32)
    public String getBidId() {
        return bidId;
    }

    public void setBidId(String bidId) {
        this.bidId = bidId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemInfoEntity that = (ItemInfoEntity) o;

        if (id != that.id) return false;
        if (itemNm != null ? !itemNm.equals(that.itemNm) : that.itemNm != null) return false;
        if (operateTime != null ? !operateTime.equals(that.operateTime) : that.operateTime != null) return false;
        if (bidId != null ? !bidId.equals(that.bidId) : that.bidId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (itemNm != null ? itemNm.hashCode() : 0);
        result = 31 * result + (operateTime != null ? operateTime.hashCode() : 0);
        result = 31 * result + (bidId != null ? bidId.hashCode() : 0);
        return result;
    }
}
