package com.sec.chaton.mobileweb;

import android.os.Handler;
import android.os.Message;
import android.webkit.JavascriptInterface;
import com.sec.chaton.util.C4904y;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: MobileWebBridgeClass.java */
/* renamed from: com.sec.chaton.mobileweb.o */
/* loaded from: classes.dex */
public class C2601o {
    public final String TAG = C2601o.class.getSimpleName();
    final Object lockObject = new Object();
    Handler mHandler;
    Map<String, EnumC2598l> mHandshakeIndexMap;
    List<EnumC2598l> mHandshakeList;

    public static C2601o buildMobileWebBridgeClass(Handler handler, List<EnumC2598l> list) {
        return new C2601o(handler, list);
    }

    private C2601o(Handler handler, List<EnumC2598l> list) {
        if (C4904y.f17872b) {
            C4904y.m18639b("MobileWebBridgeClass has been created !! ", this.TAG);
        }
        this.mHandler = handler;
        this.mHandshakeList = list;
        this.mHandshakeIndexMap = new HashMap();
        for (EnumC2598l enumC2598l : list) {
            this.mHandshakeIndexMap.put(enumC2598l.m11004b(), enumC2598l);
        }
    }

    public void release() {
        synchronized (this.lockObject) {
            this.mHandler = null;
        }
    }

    private void sendMessage(String str, String str2) {
        synchronized (this.lockObject) {
            if (C4904y.f17872b) {
                C4904y.m18639b(String.format("%s() is called with arg(%s)", str, str2), this.TAG);
            }
            if (this.mHandler != null && this.mHandshakeIndexMap != null) {
                EnumC2598l enumC2598l = this.mHandshakeIndexMap.get(str);
                if (enumC2598l == null) {
                    C4904y.m18634a("I didn't request to use this api : " + str, this.TAG);
                    return;
                }
                Message messageObtainMessage = this.mHandler.obtainMessage();
                messageObtainMessage.what = enumC2598l.m11003a();
                messageObtainMessage.obj = str2;
                messageObtainMessage.sendToTarget();
            }
        }
    }

    @JavascriptInterface
    public void handshake(String str) {
        sendMessage("handshake", str);
    }

    @JavascriptInterface
    public void proxy(String str) {
        sendMessage("proxy", str);
    }

    @JavascriptInterface
    public void gopage(String str) {
        sendMessage("gopage", str);
    }

    @JavascriptInterface
    public void share(String str) {
        sendMessage("share", str);
    }

    @JavascriptInterface
    public void badgeclear(String str) {
        sendMessage("badgeclear", str);
    }

    @JavascriptInterface
    public void follow(String str) {
        sendMessage("follow", str);
    }

    @JavascriptInterface
    public void itempurchase(String str) {
        sendMessage("itempurchase", str);
    }

    @JavascriptInterface
    public void itemdownload(String str) {
        sendMessage("itemdownload", str);
    }

    @JavascriptInterface
    public void itemapply(String str) {
        sendMessage("itemapply", str);
    }

    @JavascriptInterface
    public void itemdownloadcancel(String str) {
        sendMessage("itemdownloadcancel", str);
    }

    @JavascriptInterface
    public void itemdownloadedlist(String str) {
        sendMessage("itemdownloadedlist", str);
    }

    @JavascriptInterface
    public void verifieditemlist(String str) {
        sendMessage("verifieditemlist", str);
    }

    @JavascriptInterface
    public void itemmultidownload(String str) {
        sendMessage("itemmultidownload", str);
    }

    @JavascriptInterface
    public void itemdelete(String str) {
        sendMessage("itemdelete", str);
    }

    @JavascriptInterface
    public void viewresolution(String str) {
        sendMessage("viewresolution", str);
    }

    @JavascriptInterface
    public void predownload(String str) {
        sendMessage("predownload", str);
    }

    @JavascriptInterface
    public void clearhistory() {
        sendMessage("clearhistory", "");
    }

    @JavascriptInterface
    public void toast(String str) {
        sendMessage("toast", str);
    }

    @JavascriptInterface
    public void applist(String str) {
        sendMessage("applist", str);
    }

    @JavascriptInterface
    public void appexec(String str) {
        sendMessage("appexec", str);
    }

    @JavascriptInterface
    public void followingstatus(String str) {
        sendMessage("followingstatus", str);
    }

    @JavascriptInterface
    public void topicchat(String str) {
        sendMessage("topicchat", str);
    }

    @JavascriptInterface
    public void recommend(String str) {
        sendMessage("recommend", str);
    }

    @JavascriptInterface
    public void forwardchatmessage(String str) {
        sendMessage("forwardchatmessage", str);
    }
}
