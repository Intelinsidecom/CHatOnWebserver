package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class EWalletInfoRep extends MsgBody {
    private List<EWalletInfo> EWalletInfoList = new ArrayList();

    public List<EWalletInfo> getEWalletInfoList() {
        return this.EWalletInfoList;
    }

    public void setEWalletInfoList(List<EWalletInfo> eWalletInfoList) {
        this.EWalletInfoList = eWalletInfoList;
    }
}
