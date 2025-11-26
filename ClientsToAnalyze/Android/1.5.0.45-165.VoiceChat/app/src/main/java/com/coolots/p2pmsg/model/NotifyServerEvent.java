package com.coolots.p2pmsg.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class NotifyServerEvent extends MsgBody {
    public static final int CONN_SERVER_SHUTDOWN_SOON = 1;
    public static final int INVALID_SERVER_EVENT = 0;
    private String EventDesc;
    private int EventType;
    private int ServerNo;

    @NotNull
    @Size(max = 10)
    private String ServerType;

    public String getServerType() {
        return this.ServerType;
    }

    public void setServerType(String serverType) {
        this.ServerType = serverType;
    }

    public int getServerNo() {
        return this.ServerNo;
    }

    public void setServerNo(int port) {
        this.ServerNo = port;
    }

    public int getEventType() {
        return this.EventType;
    }

    public void setEventType(int eventType) {
        this.EventType = eventType;
    }

    public String getEventDesc() {
        return this.EventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.EventDesc = eventDesc;
    }
}
