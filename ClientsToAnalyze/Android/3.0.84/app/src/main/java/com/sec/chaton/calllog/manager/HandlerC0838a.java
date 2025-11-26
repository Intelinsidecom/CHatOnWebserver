package com.sec.chaton.calllog.manager;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.calllog.manager.model.C0845d;
import com.sec.chaton.calllog.manager.model.CallLogDBData;
import com.sec.chaton.calllog.manager.model.CallLogData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* compiled from: CallLogManager.java */
/* renamed from: com.sec.chaton.calllog.manager.a */
/* loaded from: classes.dex */
public class HandlerC0838a extends Handler {

    /* renamed from: a */
    private static final String f3201a = HandlerC0838a.class.getSimpleName();

    /* renamed from: b */
    private Handler f3202b = null;

    /* renamed from: c */
    private C0845d f3203c = new C0845d();

    /* renamed from: a */
    public ArrayList<CallLogData> m4423a(CallLogDBData callLogDBData, boolean z) {
        return this.f3203c.m4483a(callLogDBData, z);
    }

    /* renamed from: a */
    public ArrayList<CallLogData> m4422a(long j, boolean z) {
        return this.f3203c.m4482a(j, z);
    }

    /* renamed from: a */
    public ArrayList<CallLogData> m4421a(int i, boolean z) {
        return this.f3203c.m4481a(i, z);
    }

    /* renamed from: a */
    public ArrayList<CallLogData> m4424a(ArrayList<Integer> arrayList, boolean z) {
        return this.f3203c.m4485a(arrayList, z);
    }

    /* renamed from: a */
    public int m4420a(ArrayList<CallLogDBData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -8002;
        }
        int iM4479a = this.f3203c.m4479a(arrayList);
        if (this.f3202b != null) {
            Message message = new Message();
            message.what = 7000;
            message.obj = arrayList;
            this.f3202b.sendMessage(message);
            return iM4479a;
        }
        return iM4479a;
    }

    /* renamed from: b */
    public int m4429b(ArrayList<CallLogData> arrayList) {
        if (arrayList == null) {
            return -8002;
        }
        int iM4490b = this.f3203c.m4490b(arrayList);
        if (this.f3202b != null) {
            this.f3202b.sendEmptyMessage(8000);
            return iM4490b;
        }
        return iM4490b;
    }

    /* renamed from: a */
    public void m4427a(Handler handler) {
        this.f3202b = handler;
    }

    /* renamed from: a */
    public HashMap<Set<String>, String> m4426a() {
        return this.f3203c.m4487a();
    }

    /* renamed from: b */
    public int m4428b() {
        return this.f3203c.m4489b();
    }

    /* renamed from: c */
    public int m4431c() {
        return this.f3203c.m4492c();
    }

    /* renamed from: a */
    public ArrayList<CallLogData> m4425a(boolean z) {
        return this.f3203c.m4486a(z);
    }

    /* renamed from: b */
    public ArrayList<CallLogData> m4430b(boolean z) {
        return this.f3203c.m4491b(z);
    }
}
