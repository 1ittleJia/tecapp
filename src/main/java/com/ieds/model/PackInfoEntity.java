package com.ieds.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jia on 2017/5/2.
 */
@Entity
@Table(name = "pack_info", schema = "tec", catalog = "")
public class PackInfoEntity {
    private int id;
    private String packNm;
    private Integer itemId;
    private String bidMode;
    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date evalueTime;
    private String evalueAddr;
    private Integer evalueNum;
    private String proposer;
    private Date applicationTime;
    private Date operateTime;
    private String packId;
    private String extractClass;
    private String extractStatue;
    private Integer evalueNumReal;
    private Integer evalueNumEffect;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PACK_NM", nullable = true, length = 128)
    public String getPackNm() {
        return packNm;
    }

    public void setPackNm(String packNm) {
        this.packNm = packNm;
    }

    @Basic
    @Column(name = "ITEM_ID", nullable = true)
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "BID_MODE", nullable = true, length = 32)
    public String getBidMode() {
        return bidMode;
    }

    public void setBidMode(String bidMode) {
        this.bidMode = bidMode;
    }

    @Basic
    @Column(name = "PHONE", nullable = true, length = 11)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "EVALUE_TIME", nullable = true)
    public Date getEvalueTime() {
        return evalueTime;
    }

    public void setEvalueTime(Date evalueTime) {
        this.evalueTime = evalueTime;
    }

    @Basic
    @Column(name = "EVALUE_ADDR", nullable = true, length = 128)
    public String getEvalueAddr() {
        return evalueAddr;
    }

    public void setEvalueAddr(String evalueAddr) {
        this.evalueAddr = evalueAddr;
    }

    @Basic
    @Column(name = "EVALUE_NUM", nullable = true)
    public Integer getEvalueNum() {
        return evalueNum;
    }

    public void setEvalueNum(Integer evalueNum) {
        this.evalueNum = evalueNum;
    }

    @Basic
    @Column(name = "PROPOSER", nullable = true, length = 32)
    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
    }

    @Basic
    @Column(name = "APPLICATION_TIME", nullable = true)
    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    @Basic
    @Column(name = "OPERATE_TIME", nullable = true)
    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PackInfoEntity that = (PackInfoEntity) o;

        if (id != that.id) return false;
        if (packNm != null ? !packNm.equals(that.packNm) : that.packNm != null) return false;
        if (itemId != null ? !itemId.equals(that.itemId) : that.itemId != null) return false;
        if (bidMode != null ? !bidMode.equals(that.bidMode) : that.bidMode != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (evalueTime != null ? !evalueTime.equals(that.evalueTime) : that.evalueTime != null) return false;
        if (evalueAddr != null ? !evalueAddr.equals(that.evalueAddr) : that.evalueAddr != null) return false;
        if (evalueNum != null ? !evalueNum.equals(that.evalueNum) : that.evalueNum != null) return false;
        if (proposer != null ? !proposer.equals(that.proposer) : that.proposer != null) return false;
        if (applicationTime != null ? !applicationTime.equals(that.applicationTime) : that.applicationTime != null)
            return false;
        if (operateTime != null ? !operateTime.equals(that.operateTime) : that.operateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (packNm != null ? packNm.hashCode() : 0);
        result = 31 * result + (itemId != null ? itemId.hashCode() : 0);
        result = 31 * result + (bidMode != null ? bidMode.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (evalueTime != null ? evalueTime.hashCode() : 0);
        result = 31 * result + (evalueAddr != null ? evalueAddr.hashCode() : 0);
        result = 31 * result + (evalueNum != null ? evalueNum.hashCode() : 0);
        result = 31 * result + (proposer != null ? proposer.hashCode() : 0);
        result = 31 * result + (applicationTime != null ? applicationTime.hashCode() : 0);
        result = 31 * result + (operateTime != null ? operateTime.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "PACK_ID", nullable = true, length = 32)
    public String getPackId() {
        return packId;
    }

    public void setPackId(String packId) {
        this.packId = packId;
    }

    @Basic
    @Column(name = "EXTRACT_CLASS", nullable = true, length = 128)
    public String getExtractClass() {
        return extractClass;
    }

    public void setExtractClass(String extractClass) {
        this.extractClass = extractClass;
    }

    @Basic
    @Column(name = "EXTRACT_STATUE", nullable = true, length = 2)
    public String getExtractStatue() {
        return extractStatue;
    }

    public void setExtractStatue(String extractStatue) {
        this.extractStatue = extractStatue;
    }

    @Basic
    @Column(name = "EVALUE_NUM_REAL", nullable = true)
    public Integer getEvalueNumReal() {
        return evalueNumReal;
    }

    public void setEvalueNumReal(Integer evalueNumReal) {
        this.evalueNumReal = evalueNumReal;
    }

    @Basic
    @Column(name = "EVALUE_NUM_EFFECT", nullable = true)
    public Integer getEvalueNumEffect() {
        return evalueNumEffect;
    }

    public void setEvalueNumEffect(Integer evalueNumEffect) {
        this.evalueNumEffect = evalueNumEffect;
    }
}
