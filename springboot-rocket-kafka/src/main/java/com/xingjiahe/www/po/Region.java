package com.xingjiahe.www.po;

public class Region {
    private Short regionId;

    private Short parentId;

    private String regionName;

    private Boolean regionLevel;

    public Short getRegionId() {
        return regionId;
    }

    public void setRegionId(Short regionId) {
        this.regionId = regionId;
    }

    public Short getParentId() {
        return parentId;
    }

    public void setParentId(Short parentId) {
        this.parentId = parentId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    public Boolean getRegionLevel() {
        return regionLevel;
    }

    public void setRegionLevel(Boolean regionLevel) {
        this.regionLevel = regionLevel;
    }
}