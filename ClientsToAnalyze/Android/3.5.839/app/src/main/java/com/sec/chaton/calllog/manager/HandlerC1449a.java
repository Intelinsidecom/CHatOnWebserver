package com.sec.chaton.calllog.manager;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.calllog.manager.model.C1456d;
import com.sec.chaton.calllog.manager.model.CallLogDBData;
import com.sec.chaton.calllog.manager.model.CallLogData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* compiled from: CallLogManager.java */
/* renamed from: com.sec.chaton.calllog.manager.a */
/* loaded from: classes.dex */
public class HandlerC1449a extends Handler {

    /* renamed from: a */
    private static final String f5171a = HandlerC1449a.class.getSimpleName();

    /* renamed from: b */
    private Handler f5172b = null;

    /* renamed from: c */
    private C1456d f5173c = new C1456d();

    /* renamed from: a */
    public ArrayList<CallLogData> m7577a(CallLogDBData callLogDBData, boolean z) {
        return this.f5173c.m7638a(callLogDBData, z);
    }

    /* renamed from: a */
    public ArrayList<CallLogData> m7576a(long j, boolean z) {
        return this.f5173c.m7637a(j, z);
    }

    /* renamed from: a */
    public ArrayList<CallLogData> m7575a(int i, boolean z) {
        return this.f5173c.m7636a(i, z);
    }

    /* renamed from: a */
    public ArrayList<CallLogData> m7578a(ArrayList<Integer> arrayList, boolean z) {
        return this.f5173c.m7640a(arrayList, z);
    }

    /* renamed from: a */
    public int m7574a(ArrayList<CallLogDBData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return -8002;
        }
        int iM7634a = this.f5173c.m7634a(arrayList);
        if (this.f5172b != null) {
            Message message = new Message();
            message.what = 7000;
            message.obj = arrayList;
            this.f5172b.sendMessage(message);
            return iM7634a;
        }
        return iM7634a;
    }

    /* renamed from: b */
    public int m7583b(ArrayList<CallLogData> arrayList) {
        if (arrayList == null) {
            return -8002;
        }
        int iM7645b = this.f5173c.m7645b(arrayList);
        if (this.f5172b != null) {
            this.f5172b.sendEmptyMessage(8000);
            return iM7645b;
        }
        return iM7645b;
    }

    /* renamed from: a */
    public void m7581a(Handler handler) {
        this.f5172b = handler;
    }

    /* renamed from: a */
    public HashMap<Set<String>, String> m7580a() {
        return this.f5173c.m7642a();
    }

    /* renamed from: b */
    public int m7582b() {
        return this.f5173c.m7644b();
    }

    /* renamed from: c */
    public int m7585c() {
        return this.f5173c.m7647c();
    }

    /* renamed from: a */
    public ArrayList<CallLogData> m7579a(boolean z) {
        return this.f5173c.m7641a(z);
    }

    /* renamed from: b */
    public ArrayList<CallLogData> m7584b(boolean z) {
        return this.f5173c.m7646b(z);
    }
}
