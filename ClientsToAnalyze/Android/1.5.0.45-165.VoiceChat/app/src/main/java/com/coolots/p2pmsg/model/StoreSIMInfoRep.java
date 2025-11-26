package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class StoreSIMInfoRep extends MsgBody {
    private List<PaidSvcPolicyInfo> PaidSvcPolicyList = new ArrayList();
    private boolean PayView;

    public List<PaidSvcPolicyInfo> getPaidSvcPolicyList() {
        return this.PaidSvcPolicyList;
    }

    public void setPaidSvcPolicyList(List<PaidSvcPolicyInfo> paidSvcPolicyList) {
        this.PaidSvcPolicyList = paidSvcPolicyList;
    }

    public boolean isPayView() {
        return this.PayView;
    }

    public boolean getPayView() {
        return this.PayView;
    }

    public void setPayView(boolean payView) {
        this.PayView = payView;
    }
}
