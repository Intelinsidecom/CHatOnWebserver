package com.coolots.p2pmsg.model;

import com.coolots.p2pmsg.validator.StringCase;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class StoreEPInfoAsk extends MsgBody {
    public static final String EP_TYPE_C2DM = "C2DM";
    public static final String EP_TYPE_C2DM_L = "c2dm";
    public static final String EP_TYPE_GCM = "GCM";
    public static final String EP_TYPE_GCM_L = "gcm";
    public static final String EP_TYPE_SPP = "SPP";
    public static final String EP_TYPE_SPP_L = "spp";
    public static final String EP_TYPE_VD = "VD";
    public static final String EP_TYPE_VD_L = "vd";

    @Size(max = 300)
    private String PushRegID;

    @StringCase(caseArray = {EP_TYPE_C2DM, EP_TYPE_SPP, EP_TYPE_VD, EP_TYPE_C2DM_L, EP_TYPE_SPP_L, EP_TYPE_VD_L, EP_TYPE_GCM, EP_TYPE_GCM_L})
    private String PushSvcType;

    public String getPushSvcType() {
        return this.PushSvcType;
    }

    public void setPushSvcType(String pushSvcType) {
        this.PushSvcType = pushSvcType;
    }

    public String getPushRegID() {
        return this.PushRegID;
    }

    public void setPushRegID(String pushRegID) {
        this.PushRegID = pushRegID;
    }
}
