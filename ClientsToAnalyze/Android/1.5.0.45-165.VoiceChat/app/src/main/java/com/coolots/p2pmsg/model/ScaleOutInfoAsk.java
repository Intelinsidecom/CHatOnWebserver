package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ScaleOutInfoAsk extends MsgBody {
    private List<ConfigInfo> serverConfig = new ArrayList();
    private int serverNo;
    private String serverType;
    private String service;

    public String getServerType() {
        return this.serverType;
    }

    public void setServerType(String serverType) {
        this.serverType = serverType;
    }

    public int getServerNo() {
        return this.serverNo;
    }

    public void setServerNo(int serverNo) {
        this.serverNo = serverNo;
    }

    public String getService() {
        return this.service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public List<ConfigInfo> getServerConfig() {
        return this.serverConfig;
    }

    public void setServerConfig(List<ConfigInfo> serverConfig) {
        this.serverConfig = serverConfig;
    }
}
