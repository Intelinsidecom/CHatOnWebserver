package com.sds.coolots.common.util;

import android.os.Build;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.FeatureInfoAsk;
import com.coolots.p2pmsg.model.P2PMsg;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.coolots.p2pmsg.parser.ProtoBufHandler;
import com.coolots.p2pmsg.parser.ProtoBufHandlerException;
import com.google.protobuf.ByteString;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.p014b.C1149a;
import com.sds.coolots.common.httpAdaptor.C1258h;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.sds.coolots.common.util.a */
/* loaded from: classes.dex */
public class C1260a {

    /* renamed from: a */
    private static final String f3094a = "[FeatureInfoUtil]";

    /* renamed from: b */
    private static final String f3095b = "1.1.3.2";

    /* renamed from: a */
    public static FeatureInfoAsk m2985a() {
        m2988a("<CIH> makeMyFeatureInfo()");
        FeatureInfoAsk featureInfoAsk = new FeatureInfoAsk();
        featureInfoAsk.setDeviceModelName(Build.MODEL);
        featureInfoAsk.setAppVersion(MainApplication.mConfig.getAppVersion());
        if (m2989a(MainApplication.mPhoneManager.getAppVersion(), f3095b)) {
            m2988a("<CIH> this version is less equal then 1.1.3.2");
            featureInfoAsk.setP2pVoiceCall(true);
            featureInfoAsk.setP2pVideoCall(true);
            featureInfoAsk.setP2pVoiceToVideoCallSwitching(true);
            featureInfoAsk.setP2pVideoToVoiceCallSwitching(true);
            featureInfoAsk.setP2pShareScreen(true);
            featureInfoAsk.setP2pShareCamera(true);
            featureInfoAsk.setP2pHandwritingInShareScreen(true);
            featureInfoAsk.setP2pHandwritingInDocView(false);
            featureInfoAsk.setP2pShareRemoteControl(true);
            featureInfoAsk.setP2pShareDocView(false);
            featureInfoAsk.setP2pTranslation(false);
            featureInfoAsk.setConfVoiceCall(true);
            featureInfoAsk.setConfVideoCall(true);
            featureInfoAsk.setConfVoiceToVideoCallSwitching(false);
            featureInfoAsk.setConfVideoToVoiceCallSwitching(false);
            featureInfoAsk.setConfShareScreen(false);
            featureInfoAsk.setConfShareCamera(false);
            featureInfoAsk.setConfHandwritingInShareScreen(false);
            featureInfoAsk.setConfHandwritingInDocView(false);
            featureInfoAsk.setConfShareRemoteControl(false);
            featureInfoAsk.setConfShareDocView(false);
            featureInfoAsk.setConfTranslation(false);
        } else {
            m2988a("<CIH> this version is greater than 1.1.3.2");
            featureInfoAsk.setP2pVoiceCall(true);
            featureInfoAsk.setP2pVideoCall(true);
            featureInfoAsk.setP2pVoiceToVideoCallSwitching(true);
            featureInfoAsk.setP2pVideoToVoiceCallSwitching(true);
            featureInfoAsk.setP2pShareScreen(true);
            featureInfoAsk.setP2pShareCamera(true);
            featureInfoAsk.setP2pHandwritingInShareScreen(true);
            featureInfoAsk.setP2pHandwritingInDocView(true);
            featureInfoAsk.setP2pShareRemoteControl(true);
            featureInfoAsk.setP2pShareDocView(true);
            featureInfoAsk.setP2pTranslation(true);
            featureInfoAsk.setConfVoiceCall(true);
            featureInfoAsk.setConfVideoCall(true);
            featureInfoAsk.setConfVoiceToVideoCallSwitching(false);
            featureInfoAsk.setConfVideoToVoiceCallSwitching(false);
            featureInfoAsk.setConfShareScreen(true);
            featureInfoAsk.setConfShareCamera(false);
            featureInfoAsk.setConfHandwritingInShareScreen(true);
            featureInfoAsk.setConfHandwritingInDocView(true);
            featureInfoAsk.setConfShareRemoteControl(true);
            featureInfoAsk.setConfShareDocView(true);
            featureInfoAsk.setConfTranslation(false);
        }
        m2988a("<CIH> " + featureInfoAsk.toString());
        return featureInfoAsk;
    }

    /* renamed from: a */
    public static FeatureInfoAsk m2986a(byte[] bArr) {
        P2PMsg p2PMsgM2946a;
        m2988a("<CIH> transferFeatureInfoFromReceivedByteArray()");
        FeatureInfoAsk featureInfoAsk = new FeatureInfoAsk();
        P2PMsg p2PMsg = new P2PMsg();
        StringBuilder sb = new StringBuilder();
        try {
            byte[] byteArray = ProtoBufHandler.toByteArray(C1149a.m2140a(MessageInfo.FeatureInfoAsk.getServiceCode(), MessageInfo.FeatureInfoAsk.getMessageCode()));
            if (bArr == null) {
                m2988a("<CIH> byteParam1 is null!");
                bArr = ProtoBufHandler.toByteArray(featureInfoAsk);
            }
            p2PMsgM2946a = C1258h.m2946a(byteArray, bArr, sb);
        } catch (ProtoBufHandlerException e) {
            e.printStackTrace();
            p2PMsgM2946a = p2PMsg;
        }
        FeatureInfoAsk featureInfoAsk2 = p2PMsgM2946a != null ? (FeatureInfoAsk) p2PMsgM2946a.getMsgBody() : featureInfoAsk;
        if (featureInfoAsk2 != null) {
            if (featureInfoAsk2.getDeviceModelName() == null && featureInfoAsk2.getAppVersion() == null) {
                featureInfoAsk2.setP2pVoiceCall(true);
                featureInfoAsk2.setP2pVideoCall(true);
                featureInfoAsk2.setP2pVoiceToVideoCallSwitching(true);
                featureInfoAsk2.setP2pVideoToVoiceCallSwitching(true);
                featureInfoAsk2.setP2pShareScreen(true);
                featureInfoAsk2.setP2pShareCamera(true);
                featureInfoAsk2.setP2pHandwritingInShareScreen(true);
                featureInfoAsk2.setP2pHandwritingInDocView(false);
                featureInfoAsk2.setP2pShareRemoteControl(true);
                featureInfoAsk2.setP2pShareDocView(false);
                featureInfoAsk2.setP2pTranslation(false);
                featureInfoAsk2.setConfVoiceCall(true);
                featureInfoAsk2.setConfVideoCall(true);
                featureInfoAsk2.setConfVoiceToVideoCallSwitching(false);
                featureInfoAsk2.setConfVideoToVoiceCallSwitching(false);
                featureInfoAsk2.setConfShareScreen(false);
                featureInfoAsk2.setConfShareCamera(false);
                featureInfoAsk2.setConfHandwritingInShareScreen(false);
                featureInfoAsk2.setConfHandwritingInDocView(false);
                featureInfoAsk2.setConfShareRemoteControl(false);
                featureInfoAsk2.setConfShareDocView(false);
                featureInfoAsk2.setConfTranslation(false);
            }
            m2988a("<CIH> " + featureInfoAsk2.toString());
        }
        return featureInfoAsk2;
    }

    /* renamed from: a */
    public static ArrayList m2987a(ArrayList arrayList) {
        m2988a("<CIH> makeFeatureInfoList()");
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            if ("1".equals(simpleUserInfo.getStatus()) || "0".equals(simpleUserInfo.getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(simpleUserInfo.getStatus())) {
                simpleUserInfo.getFeatureSet();
                byte[] byteArray = (byte[]) null;
                ByteString featureSet = simpleUserInfo.getFeatureSet();
                if (featureSet != null) {
                    byteArray = featureSet.toByteArray();
                }
                arrayList2.add(m2986a(byteArray));
            }
        }
        return arrayList2;
    }

    /* renamed from: a */
    private static void m2988a(String str) {
        Log.m2963i(f3094a + str);
    }

    /* renamed from: a */
    private static boolean m2989a(String str, String str2) {
        ArrayList arrayListM2990b = m2990b(str);
        ArrayList arrayListM2990b2 = m2990b(str2);
        m2988a("<CIH> myVerString = " + str);
        m2988a("<CIH> criterionVerString = " + str2);
        if (arrayListM2990b == null || arrayListM2990b2 == null || arrayListM2990b.size() < arrayListM2990b2.size()) {
            return false;
        }
        for (int i = 0; i < arrayListM2990b.size(); i++) {
            if (((Integer) arrayListM2990b.get(i)).intValue() > ((Integer) arrayListM2990b2.get(i)).intValue()) {
                return false;
            }
            if (((Integer) arrayListM2990b.get(i)).intValue() < ((Integer) arrayListM2990b2.get(i)).intValue()) {
                return true;
            }
        }
        return true;
    }

    /* renamed from: b */
    private static ArrayList m2990b(String str) {
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            for (String str2 : str.split("\\.")) {
                if (str2 != null) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str2)));
                }
            }
        }
        return arrayList;
    }
}
