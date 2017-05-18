package com.ieds.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jia on 2017/5/7.
 */
@Entity
@Table(name = "pack_extract_expert", schema = "tec", catalog = "")
public class PackExtractExpertEntity {
    private int id;
    private Integer packSeq;
    private String packId;
    private String packNm;
    private Integer expertId;
    private String expertNm;
    private Date operateTime;
    private String delFlag;
    private String phone;
    private String reason;
    private String extractClass;
    private String delFlagNm;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PACK_SEQ", nullable = true)
    public Integer getPackSeq() {
        return packSeq;
    }

    public void setPackSeq(Integer packSeq) {
        this.packSeq = packSeq;
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
    @Column(name = "PACK_NM", nullable = true, length = 128)
    public String getPackNm() {
        return packNm;
    }

    public void setPackNm(String packNm) {
        this.packNm = packNm;
    }

    @Basic
    @Column(name = "EXPERT_ID", nullable = true)
    public Integer getExpertId() {
        return expertId;
    }

    public void setExpertId(Integer expertId) {
        this.expertId = expertId;
    }

    @Basic
    @Column(name = "EXPERT_NM", nullable = true, length = 128)
    public String getExpertNm() {
        return expertNm;
    }

    public void setExpertNm(String expertNm) {
        this.expertNm = expertNm;
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
    @Column(name = "DEL_FLAG", nullable = true, length = 2)
    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PackExtractExpertEntity that = (PackExtractExpertEntity) o;

        if (id != that.id) return false;
        if (packSeq != null ? !packSeq.equals(that.packSeq) : that.packSeq != null) return false;
        if (packId != null ? !packId.equals(that.packId) : that.packId != null) return false;
        if (packNm != null ? !packNm.equals(that.packNm) : that.packNm != null) return false;
        if (expertId != null ? !expertId.equals(that.expertId) : that.expertId != null) return false;
        if (expertNm != null ? !expertNm.equals(that.expertNm) : that.expertNm != null) return false;
        if (operateTime != null ? !operateTime.equals(that.operateTime) : that.operateTime != null) return false;
        if (delFlag != null ? !delFlag.equals(that.delFlag) : that.delFlag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (packSeq != null ? packSeq.hashCode() : 0);
        result = 31 * result + (packId != null ? packId.hashCode() : 0);
        result = 31 * result + (packNm != null ? packNm.hashCode() : 0);
        result = 31 * result + (expertId != null ? expertId.hashCode() : 0);
        result = 31 * result + (expertNm != null ? expertNm.hashCode() : 0);
        result = 31 * result + (operateTime != null ? operateTime.hashCode() : 0);
        result = 31 * result + (delFlag != null ? delFlag.hashCode() : 0);
        return result;
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
    @Column(name = "REASON", nullable = true, length = 128)
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Basic
    @Column(name = "EXTRACT_CLASS", nullable = true, length = 32)
    public String getExtractClass() {
        return extractClass;
    }

    public void setExtractClass(String extractClass) {
        this.extractClass = extractClass;
    }

    @Basic
    @Column(name = "DEL_FLAG_NM", nullable = true, length = 6)
    public String getDelFlagNm() {
        return delFlagNm;
    }

    public void setDelFlagNm(String delFlagNm) {
        this.delFlagNm = delFlagNm;
    }
}
