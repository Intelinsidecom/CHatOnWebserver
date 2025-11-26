package com.sds.coolots.call.model;

import android.os.Handler;
import android.os.Message;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ConferenceInviteHandler extends Handler {

    /* renamed from: a */
    private static final String f2589a = "[ConferenceInviteHandler]";

    /* renamed from: b */
    private static final int f2590b = 1;

    /* renamed from: c */
    private static final int f2591c = 60000;

    /* renamed from: d */
    private final ArrayList f2592d = new ArrayList();

    /* renamed from: e */
    private OnConferenceInviteTimeoutHandler f2593e;

    public interface OnConferenceInviteTimeoutHandler {
        void onConferenceInviteTimeout(String str);
    }

    /* renamed from: b */
    private void m2388b(String str) {
        Log.m2958e(f2589a + str);
    }

    /* renamed from: c */
    private void m2389c(String str) {
        Log.m2963i(f2589a + str);
    }

    /* renamed from: a */
    public void m2390a() {
        this.f2592d.clear();
        removeMessages(1);
    }

    /* renamed from: a */
    public void m2391a(C1186A c1186a) {
        m2389c("addInviteInfo!!! key:" + c1186a.f2510a + ", userID:" + c1186a.f2511b);
        Iterator it = this.f2592d.iterator();
        while (it.hasNext()) {
            if (((C1186A) it.next()).f2510a == c1186a.f2510a) {
                m2388b("addInviteInfo!!! duplicated key");
                return;
            }
        }
        this.f2592d.add(c1186a);
        Message message = new Message();
        message.what = 1;
        message.arg1 = c1186a.f2510a;
        sendMessageDelayed(message, 60000L);
    }

    /* renamed from: a */
    public void m2392a(OnConferenceInviteTimeoutHandler onConferenceInviteTimeoutHandler) {
        this.f2593e = onConferenceInviteTimeoutHandler;
    }

    /* renamed from: a */
    public void m2393a(String str) {
        Iterator it = this.f2592d.iterator();
        while (it.hasNext()) {
            C1186A c1186a = (C1186A) it.next();
            if (c1186a.f2511b.equals(str)) {
                m2389c("removeInviteInfo!!! remove userID:" + str);
                this.f2592d.remove(c1186a);
                return;
            }
        }
    }

    /* renamed from: a */
    public void m2394a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            if (!"0".equals(simpleUserInfo.getStatus())) {
                Iterator it2 = this.f2592d.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        C1186A c1186a = (C1186A) it2.next();
                        if (c1186a.f2511b.equals(simpleUserInfo.getUserID())) {
                            m2389c("updateSimpleUserInfo!!! remove userID:" + c1186a.f2511b);
                            this.f2592d.remove(c1186a);
                            break;
                        }
                    }
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 1 && this.f2593e != null) {
            Iterator it = this.f2592d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C1186A c1186a = (C1186A) it.next();
                if (c1186a.f2510a == message.arg1) {
                    m2389c("handlemessage!!! remove member:" + c1186a.f2511b);
                    this.f2593e.onConferenceInviteTimeout(c1186a.f2511b);
                    break;
                }
            }
        }
        super.handleMessage(message);
    }
}
