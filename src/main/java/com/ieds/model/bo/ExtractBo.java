package com.ieds.model.bo;

/**
 * Created by jia on 2017/5/8.
 */
public class ExtractBo {
    private Integer itemId;
    private Integer packSeq;
    private String packIds;
    private String extractClass;
    private Integer evalueNum;
    private Integer extractExpertId;
    private String reason;
    private String itemNm;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getPackSeq() {
        return packSeq;
    }

    public void setPackSeq(Integer packSeq) {
        this.packSeq = packSeq;
    }

    public String getPackIds() {
        return packIds;
    }

    public void setPackIds(String packIds) {
        this.packIds = packIds;
    }

    public String getExtractClass() {
        return extractClass;
    }

    public void setExtractClass(String extractClass) {
        this.extractClass = extractClass;
    }

    public Integer getEvalueNum() {
        return evalueNum;
    }

    public void setEvalueNum(Integer evalueNum) {
        this.evalueNum = evalueNum;
    }

    public Integer getExtractExpertId() {
        return extractExpertId;
    }

    public void setExtractExpertId(Integer extractExpertId) {
        this.extractExpertId = extractExpertId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getItemNm() {
        return itemNm;
    }

    public void setItemNm(String itemNm) {
        this.itemNm = itemNm;
    }
}
