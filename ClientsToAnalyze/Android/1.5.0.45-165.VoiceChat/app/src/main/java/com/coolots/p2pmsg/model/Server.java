package com.coolots.p2pmsg.model;

import com.coolots.p2pmsg.validator.Ip;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class Server {
    private String CipherKey;

    /* renamed from: IP */
    @NotNull
    @Ip
    private String f20IP;

    @Max(65535)
    @Min(1)
    private int Port;

    @Min(0)
    private int Priority;

    @NotNull
    @Size(max = 10)
    private String ServerType;

    @Max(65535)
    @Min(1)
    private Integer SubPort;

    public String getServerType() {
        return this.ServerType;
    }

    public void setServerType(String serverType) {
        this.ServerType = serverType;
    }

    public String getIP() {
        return this.f20IP;
    }

    public void setIP(String ipAddress) {
        this.f20IP = ipAddress;
    }

    public int getPort() {
        return this.Port;
    }

    public void setPort(int port) {
        this.Port = port;
    }

    public int getPriority() {
        return this.Priority;
    }

    public void setPriority(int priority) {
        this.Priority = priority;
    }

    public String getCipherKey() {
        return this.CipherKey;
    }

    public void setCipherKey(String cipherKey) {
        this.CipherKey = cipherKey;
    }

    public Integer getSubPort() {
        return this.SubPort;
    }

    public void setSubPort(Integer subPort) {
        this.SubPort = subPort;
    }
}
