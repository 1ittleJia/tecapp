package com.ieds.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by jia on 2017/5/3.
 */
@Entity
@Table(name = "expert_info", schema = "tec", catalog = "")
public class ExpertInfoEntity {
    private int id;
    private String expertNm;
    private String sex;
    private String nativePlace;
    private String identCard;
    private String politicalStatus;
    private String birthdate;
    private String schooltag;
    private String graduationDate;
    private String education;
    private String locationProvince;
    private String locationCity;
    private String workUnit;
    private String unitType;
    private String jobTitle;
    private String phone;
    private String alternativePhone;
    private String goodProfessional;
    private Date operateTime;
    private String isBlacklist;
    private String isWhitelist;
    private String workTime;
    private String majorPerformance;
    private String department;
    private String position;
    private String evaluationSpecialist1;
    private String evaluationSpecialist2;
    private String evaluationSpecialist3;
    private String evaluationSpecialist4;
    private String extractClass;

    public void setOperateTime(Timestamp operateTime) {
        this.operateTime = operateTime;
    }

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "SEX", nullable = true, length = 2)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "NATIVE_PLACE", nullable = true, length = 128)
    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    @Basic
    @Column(name = "IDENT_CARD", nullable = true, length = 20)
    public String getIdentCard() {
        return identCard;
    }

    public void setIdentCard(String identCard) {
        this.identCard = identCard;
    }

    @Basic
    @Column(name = "POLITICAL_STATUS", nullable = true, length = 32)
    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    @Basic
    @Column(name = "BIRTHDATE", nullable = true, length = 32)
    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Basic
    @Column(name = "SCHOOLTAG", nullable = true, length = 128)
    public String getSchooltag() {
        return schooltag;
    }

    public void setSchooltag(String schooltag) {
        this.schooltag = schooltag;
    }

    @Basic
    @Column(name = "GRADUATION_DATE", nullable = true, length = 32)
    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    @Basic
    @Column(name = "EDUCATION", nullable = true, length = 32)
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Basic
    @Column(name = "LOCATION_PROVINCE", nullable = true, length = 32)
    public String getLocationProvince() {
        return locationProvince;
    }

    public void setLocationProvince(String locationProvince) {
        this.locationProvince = locationProvince;
    }

    @Basic
    @Column(name = "LOCATION_CITY", nullable = true, length = 32)
    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    @Basic
    @Column(name = "WORK_UNIT", nullable = true, length = 128)
    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    @Basic
    @Column(name = "UNIT_TYPE", nullable = true, length = 32)
    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    @Basic
    @Column(name = "JOB_TITLE", nullable = true, length = 32)
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
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
    @Column(name = "ALTERNATIVE_PHONE", nullable = true, length = 11)
    public String getAlternativePhone() {
        return alternativePhone;
    }

    public void setAlternativePhone(String alternativePhone) {
        this.alternativePhone = alternativePhone;
    }

    @Basic
    @Column(name = "GOOD_PROFESSIONAL", nullable = true, length = 128)
    public String getGoodProfessional() {
        return goodProfessional;
    }

    public void setGoodProfessional(String goodProfessional) {
        this.goodProfessional = goodProfessional;
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
    @Column(name = "IS_BLACKLIST", nullable = true, length = 1)
    public String getIsBlacklist() {
        return isBlacklist;
    }

    public void setIsBlacklist(String isBlacklist) {
        this.isBlacklist = isBlacklist;
    }

    @Basic
    @Column(name = "IS_WHITELIST", nullable = true, length = 1)
    public String getIsWhitelist() {
        return isWhitelist;
    }

    public void setIsWhitelist(String isWhitelist) {
        this.isWhitelist = isWhitelist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpertInfoEntity that = (ExpertInfoEntity) o;

        if (id != that.id) return false;
        if (expertNm != null ? !expertNm.equals(that.expertNm) : that.expertNm != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (nativePlace != null ? !nativePlace.equals(that.nativePlace) : that.nativePlace != null) return false;
        if (identCard != null ? !identCard.equals(that.identCard) : that.identCard != null) return false;
        if (politicalStatus != null ? !politicalStatus.equals(that.politicalStatus) : that.politicalStatus != null)
            return false;
        if (birthdate != null ? !birthdate.equals(that.birthdate) : that.birthdate != null) return false;
        if (schooltag != null ? !schooltag.equals(that.schooltag) : that.schooltag != null) return false;
        if (graduationDate != null ? !graduationDate.equals(that.graduationDate) : that.graduationDate != null)
            return false;
        if (education != null ? !education.equals(that.education) : that.education != null) return false;
        if (locationProvince != null ? !locationProvince.equals(that.locationProvince) : that.locationProvince != null)
            return false;
        if (locationCity != null ? !locationCity.equals(that.locationCity) : that.locationCity != null) return false;
        if (workUnit != null ? !workUnit.equals(that.workUnit) : that.workUnit != null) return false;
        if (unitType != null ? !unitType.equals(that.unitType) : that.unitType != null) return false;
        if (jobTitle != null ? !jobTitle.equals(that.jobTitle) : that.jobTitle != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (alternativePhone != null ? !alternativePhone.equals(that.alternativePhone) : that.alternativePhone != null)
            return false;
        if (goodProfessional != null ? !goodProfessional.equals(that.goodProfessional) : that.goodProfessional != null)
            return false;
        if (operateTime != null ? !operateTime.equals(that.operateTime) : that.operateTime != null) return false;
        if (isBlacklist != null ? !isBlacklist.equals(that.isBlacklist) : that.isBlacklist != null) return false;
        if (isWhitelist != null ? !isWhitelist.equals(that.isWhitelist) : that.isWhitelist != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (expertNm != null ? expertNm.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (nativePlace != null ? nativePlace.hashCode() : 0);
        result = 31 * result + (identCard != null ? identCard.hashCode() : 0);
        result = 31 * result + (politicalStatus != null ? politicalStatus.hashCode() : 0);
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        result = 31 * result + (schooltag != null ? schooltag.hashCode() : 0);
        result = 31 * result + (graduationDate != null ? graduationDate.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (locationProvince != null ? locationProvince.hashCode() : 0);
        result = 31 * result + (locationCity != null ? locationCity.hashCode() : 0);
        result = 31 * result + (workUnit != null ? workUnit.hashCode() : 0);
        result = 31 * result + (unitType != null ? unitType.hashCode() : 0);
        result = 31 * result + (jobTitle != null ? jobTitle.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (alternativePhone != null ? alternativePhone.hashCode() : 0);
        result = 31 * result + (goodProfessional != null ? goodProfessional.hashCode() : 0);
        result = 31 * result + (operateTime != null ? operateTime.hashCode() : 0);
        result = 31 * result + (isBlacklist != null ? isBlacklist.hashCode() : 0);
        result = 31 * result + (isWhitelist != null ? isWhitelist.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "WORK_TIME", nullable = true, length = 32)
    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    @Basic
    @Column(name = "MAJOR_PERFORMANCE", nullable = true, length = 256)
    public String getMajorPerformance() {
        return majorPerformance;
    }

    public void setMajorPerformance(String majorPerformance) {
        this.majorPerformance = majorPerformance;
    }

    @Basic
    @Column(name = "DEPARTMENT", nullable = true, length = 64)
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Basic
    @Column(name = "POSITION", nullable = true, length = 64)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "EVALUATION_SPECIALIST1", nullable = true, length = 128)
    public String getEvaluationSpecialist1() {
        return evaluationSpecialist1;
    }

    public void setEvaluationSpecialist1(String evaluationSpecialist1) {
        this.evaluationSpecialist1 = evaluationSpecialist1;
    }

    @Basic
    @Column(name = "EVALUATION_SPECIALIST2", nullable = true, length = 128)
    public String getEvaluationSpecialist2() {
        return evaluationSpecialist2;
    }

    public void setEvaluationSpecialist2(String evaluationSpecialist2) {
        this.evaluationSpecialist2 = evaluationSpecialist2;
    }

    @Basic
    @Column(name = "EVALUATION_SPECIALIST3", nullable = true, length = 128)
    public String getEvaluationSpecialist3() {
        return evaluationSpecialist3;
    }

    public void setEvaluationSpecialist3(String evaluationSpecialist3) {
        this.evaluationSpecialist3 = evaluationSpecialist3;
    }

    @Basic
    @Column(name = "EVALUATION_SPECIALIST4", nullable = true, length = 128)
    public String getEvaluationSpecialist4() {
        return evaluationSpecialist4;
    }

    public void setEvaluationSpecialist4(String evaluationSpecialist4) {
        this.evaluationSpecialist4 = evaluationSpecialist4;
    }

    @Basic
    @Column(name = "EXTRACT_CLASS", nullable = true, length = 32)
    public String getExtractClass() {
        return extractClass;
    }

    public void setExtractClass(String extractClass) {
        this.extractClass = extractClass;
    }
}
