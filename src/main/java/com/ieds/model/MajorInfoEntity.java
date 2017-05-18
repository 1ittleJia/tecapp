package com.ieds.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jia on 2017/5/4.
 */
@Entity
@Table(name = "major_info", schema = "tec", catalog = "")
public class MajorInfoEntity {
    private int id;
    private Integer pid;
    private String pids;
    private String majorNm;
    private Date operateTime;
    private Integer sort;
    private String leaf;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PID", nullable = true)
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "PIDS", nullable = true, length = 128)
    public String getPids() {
        return pids;
    }

    public void setPids(String pids) {
        this.pids = pids;
    }

    @Basic
    @Column(name = "MAJOR_NM", nullable = true, length = 64)
    public String getMajorNm() {
        return majorNm;
    }

    public void setMajorNm(String majorNm) {
        this.majorNm = majorNm;
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
    @Column(name = "SORT", nullable = true)
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MajorInfoEntity that = (MajorInfoEntity) o;

        if (id != that.id) return false;
        if (pid != null ? !pid.equals(that.pid) : that.pid != null) return false;
        if (pids != null ? !pids.equals(that.pids) : that.pids != null) return false;
        if (majorNm != null ? !majorNm.equals(that.majorNm) : that.majorNm != null) return false;
        if (operateTime != null ? !operateTime.equals(that.operateTime) : that.operateTime != null) return false;
        if (sort != null ? !sort.equals(that.sort) : that.sort != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (pid != null ? pid.hashCode() : 0);
        result = 31 * result + (pids != null ? pids.hashCode() : 0);
        result = 31 * result + (majorNm != null ? majorNm.hashCode() : 0);
        result = 31 * result + (operateTime != null ? operateTime.hashCode() : 0);
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "LEAF", nullable = true, length = 1)
    public String getLeaf() {
        return leaf;
    }

    public void setLeaf(String leaf) {
        this.leaf = leaf;
    }
}
