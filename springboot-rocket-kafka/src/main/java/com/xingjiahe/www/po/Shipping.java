package com.xingjiahe.www.po;

import java.math.BigDecimal;
import java.util.Date;

public class Shipping {
    private Byte shipId;

    private String shipName;

    private String shipContact;

    private String telphone;

    private BigDecimal price;

    private Date modifiedTime;

    public Byte getShipId() {
        return shipId;
    }

    public void setShipId(Byte shipId) {
        this.shipId = shipId;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName == null ? null : shipName.trim();
    }

    public String getShipContact() {
        return shipContact;
    }

    public void setShipContact(String shipContact) {
        this.shipContact = shipContact == null ? null : shipContact.trim();
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}