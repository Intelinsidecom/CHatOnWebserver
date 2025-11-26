package com.sec.chaton.mobileweb;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.util.C3250y;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: MobileWebBridgeClass.java */
/* renamed from: com.sec.chaton.mobileweb.r */
/* loaded from: classes.dex */
public class C1691r {
    public final String TAG = C1691r.class.getSimpleName();
    Object lockObject = new Object();
    Handler mHandler;
    Map<String, EnumC1688o> mHandshakeIndexMap;
    List<EnumC1688o> mHandshakeList;

    public C1691r(Handler handler, List<EnumC1688o> list) {
        if (C3250y.f11734b) {
            C3250y.m11450b("MobileWebBridgeClass has been created !! ", this.TAG);
        }
        this.mHandler = handler;
        this.mHandshakeList = list;
        this.mHandshakeIndexMap = new HashMap();
        for (EnumC1688o enumC1688o : list) {
            this.mHandshakeIndexMap.put(enumC1688o.m6979b(), enumC1688o);
        }
    }

    public void release() {
        synchronized (this.lockObject) {
            this.mHandler = null;
        }
    }

    private void sendMessage(String str, String str2) {
        synchronized (this.lockObject) {
            if (C3250y.f11734b) {
                C3250y.m11450b(String.format("%s() is called with arg(%s)", str, str2), this.TAG);
            }
            if (this.mHandler != null && this.mHandshakeIndexMap != null) {
                EnumC1688o enumC1688o = this.mHandshakeIndexMap.get(str);
                if (enumC1688o == null) {
                    C3250y.m11442a("I didn't request to use this api : " + str, this.TAG);
                    return;
                }
                Message messageObtainMessage = this.mHandler.obtainMessage();
                messageObtainMessage.what = enumC1688o.m6978a();
                messageObtainMessage.obj = str2;
                messageObtainMessage.sendToTarget();
            }
        }
    }

    public void handshake(String str) {
        sendMessage("handshake", str);
    }

    public void proxy(String str) {
        sendMessage("proxy", str);
    }

    public void gopage(String str) {
        sendMessage("gopage", str);
    }

    public void share(String str) {
        sendMessage("share", str);
    }

    public void badgeclear(String str) {
        sendMessage("badgeclear", str);
    }
}
