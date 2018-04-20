package com.li.model;

import java.util.Date;

public class UserVarietyshow {
    private Long id;

    private Long familyId;

    private Long varietyShowId;

    private Long varietyShowGrade;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Long familyId) {
        this.familyId = familyId;
    }

    public Long getVarietyShowId() {
        return varietyShowId;
    }

    public void setVarietyShowId(Long varietyShowId) {
        this.varietyShowId = varietyShowId;
    }

    public Long getVarietyShowGrade() {
        return varietyShowGrade;
    }

    public void setVarietyShowGrade(Long varietyShowGrade) {
        this.varietyShowGrade = varietyShowGrade;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}