package com.sds.coolots.call.model;

import android.os.Handler;
import android.os.Message;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.PhoneManager;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;

/* renamed from: com.sds.coolots.call.model.F */
/* loaded from: classes.dex */
public class HandlerC1191F extends Handler {

    /* renamed from: a */
    public static final int f2616a = 50000;

    /* renamed from: b */
    public static final int f2617b = 10010;

    /* renamed from: c */
    public static final int f2618c = 10011;

    /* renamed from: d */
    public static final int f2619d = 10012;

    /* renamed from: e */
    private HighPriorityHandlerInterface f2620e;

    public HandlerC1191F(HighPriorityHandlerInterface highPriorityHandlerInterface) {
        this.f2620e = highPriorityHandlerInterface;
    }

    /* renamed from: a */
    private void m2401a() {
        if (MainApplication.mContext != null) {
            PhoneManager.releaseHIPRI(MainApplication.mContext);
            MainApplication.mPhoneManager.setStartedRequestHIPRI(false);
            this.f2620e.removeMessages(10010);
            this.f2620e.removeMessages(f2618c);
            this.f2620e.removeMessages(f2619d);
        }
    }

    /* renamed from: a */
    private void m2402a(int i, ArrayList arrayList) {
        if (i > 30) {
            this.f2620e.sendEmptyMessage(f2618c);
            return;
        }
        if (PhoneManager.checkHipriState(MainApplication.mContext)) {
            PhoneManager.requestRoute(MainApplication.mContext, arrayList);
            return;
        }
        Message message = new Message();
        message.what = f2619d;
        message.arg1 = i + 1;
        message.obj = arrayList;
        this.f2620e.sendMessageDelayed(message, 1000L);
    }

    /* renamed from: a */
    private void m2403a(String str) {
        Log.m2958e("[HighPriorityHandler]" + str);
    }

    /* renamed from: a */
    private void m2404a(ArrayList arrayList) {
        if (MainApplication.mContext != null) {
            m2403a("handleRequestHipri!!!!!");
            PhoneManager.requestHIPRI(MainApplication.mContext);
            MainApplication.mPhoneManager.setStartedRequestHIPRI(true);
            if (arrayList != null) {
                Message message = new Message();
                message.what = f2619d;
                message.arg1 = 0;
                message.obj = arrayList;
                this.f2620e.sendMessage(message);
            }
            Message message2 = new Message();
            message2.what = 10010;
            this.f2620e.sendMessageDelayed(message2, 50000L);
            this.f2620e.removeMessages(f2618c);
        }
    }

    /* renamed from: b */
    private void m2405b(String str) {
        Log.m2963i("[HighPriorityHandler]" + str);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 10010) {
            m2404a((ArrayList) message.obj);
        } else if (message.what == 10012) {
            m2402a(message.arg1, (ArrayList) message.obj);
        } else if (message.what == 10011) {
            m2401a();
        }
    }
}
