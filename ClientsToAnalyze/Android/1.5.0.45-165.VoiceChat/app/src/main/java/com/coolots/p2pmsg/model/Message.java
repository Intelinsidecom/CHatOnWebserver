package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import java.text.ParseException;
import java.util.Date;

/* loaded from: classes.dex */
public class Message {
    private Date DateTime;
    private String Direction;
    private String MessageName;
    private String OppositeSite;

    public String getMessageName() {
        return this.MessageName;
    }

    public void setMessageName(String messageName) {
        this.MessageName = messageName;
    }

    public String getOppositeSite() {
        return this.OppositeSite;
    }

    public void setOppositeSite(String oppositeSite) {
        this.OppositeSite = oppositeSite;
    }

    public String getDirection() {
        return this.Direction;
    }

    public void setDirection(String direction) {
        this.Direction = direction;
    }

    public Date getDateTime() {
        return this.DateTime;
    }

    public void setDateTime(Date dateTime) {
        this.DateTime = dateTime;
    }

    public void setDateTime(String dateTime) throws ParseException {
        this.DateTime = DateTimeUtil.changeFormat(dateTime, "yyyy-MM-dd HH:mm:ss");
    }
}
