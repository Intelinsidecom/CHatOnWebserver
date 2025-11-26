package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RelayInfoRep extends MsgBody {
    private String DNSIP;
    private int Items;
    private String SIPBrokerIP;
    private String SIPBrokerPort;
    private String SIPDomainName;
    private String SIPPort;
    private List<Server> Servers = new ArrayList();

    public int getItems() {
        return this.Items;
    }

    public void setItems(int items) {
        this.Items = items;
    }

    public List<Server> getServers() {
        return this.Servers;
    }

    public void setServers(List<Server> servers) {
        this.Servers = servers;
    }

    public String getDNSIP() {
        return this.DNSIP;
    }

    public void setDNSIP(String dnsip) {
        this.DNSIP = dnsip;
    }

    public String getSIPDomainName() {
        return this.SIPDomainName;
    }

    public void setSIPDomainName(String domainName) {
        this.SIPDomainName = domainName;
    }

    public String getSIPPort() {
        return this.SIPPort;
    }

    public void setSIPPort(String port) {
        this.SIPPort = port;
    }

    public String getSIPBrokerIP() {
        return this.SIPBrokerIP;
    }

    public void setSIPBrokerIP(String brokerIP) {
        this.SIPBrokerIP = brokerIP;
    }

    public String getSIPBrokerPort() {
        return this.SIPBrokerPort;
    }

    public void setSIPBrokerPort(String brokerPort) {
        this.SIPBrokerPort = brokerPort;
    }

    public static class Server {

        /* renamed from: IP */
        private String f19IP;
        private int Index;
        private int Port;
        private int Priority;
        private String ServerType;

        public int getIndex() {
            return this.Index;
        }

        public void setIndex(int index) {
            this.Index = index;
        }

        public String getServerType() {
            return this.ServerType;
        }

        public void setServerType(String serverType) {
            this.ServerType = serverType;
        }

        public String getIP() {
            return this.f19IP;
        }

        public void setIP(String ipAddress) {
            this.f19IP = ipAddress;
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
    }
}
