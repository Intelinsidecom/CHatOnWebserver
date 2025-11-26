package com.sec.chaton.privateplugin.data;

import com.sec.chaton.plugin.data.Server;
import com.sec.chaton.plugin.p082a.C2922a;

/* loaded from: classes.dex */
public class ProvisioningInfo {
    private Long expdate;
    private C2922a<Server> primary = new C2922a<>();
    private C2922a<Server> secondary = new C2922a<>();

    public Long getExpdate() {
        return this.expdate;
    }

    public void setExpdate(Long l) {
        this.expdate = l;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProvisioningInfo [expdate=").append(this.expdate).append(", primary=").append(getPrimary()).append(", secondary=").append(getSecondary()).append("]");
        return sb.toString();
    }

    public C2922a<Server> getPrimary() {
        return this.primary;
    }

    public void setPrimary(C2922a<Server> c2922a) {
        this.primary = c2922a;
    }

    public C2922a<Server> getSecondary() {
        return this.secondary;
    }

    public void setSecondary(C2922a<Server> c2922a) {
        this.secondary = c2922a;
    }
}
