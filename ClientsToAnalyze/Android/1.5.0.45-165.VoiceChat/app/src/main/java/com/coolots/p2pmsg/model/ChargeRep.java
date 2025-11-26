package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ChargeRep extends MsgBody {
    private String AutoChargeYn;
    private String CalledPartyZone;
    private List<GrantedServiceUnit> GrantedServiceUnitList = new ArrayList();
    private String ResultCode;

    public void setCalledPartyZone(String value) {
        this.CalledPartyZone = value;
    }

    public String getCalledPartyZone() {
        return this.CalledPartyZone;
    }

    public void setResultCode(String value) {
        this.ResultCode = value;
    }

    public String getResultCode() {
        return this.ResultCode;
    }

    public void setGrantedServiceUnitList(List<GrantedServiceUnit> grantedServiceUnitList) {
        this.GrantedServiceUnitList = grantedServiceUnitList;
    }

    public List<GrantedServiceUnit> getGrantedServiceUnitList() {
        return this.GrantedServiceUnitList;
    }

    public void setAutoChargeYn(String value) {
        this.AutoChargeYn = value;
    }

    public String getAutoChargeYn() {
        return this.AutoChargeYn;
    }
}
