package com.sec.chaton.sns.p113a;

import android.content.Context;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: SnsManager.java */
/* renamed from: com.sec.chaton.sns.a.f */
/* loaded from: classes.dex */
public abstract class AbstractC4369f {

    /* renamed from: a */
    public Context f15830a;

    /* renamed from: b */
    public InterfaceC4367d f15831b;

    /* renamed from: c */
    private String f15832c;

    /* renamed from: d */
    private final Object f15833d = new Object();

    /* renamed from: e */
    private ArrayList<AsyncTaskC4371h> f15834e = new ArrayList<>();

    public AbstractC4369f(Context context, InterfaceC4367d interfaceC4367d, String str) {
        this.f15830a = context;
        this.f15831b = interfaceC4367d;
        this.f15832c = str;
    }

    /* renamed from: a */
    public void mo16569a() {
        m16571a("killAllTask() \t- BlockingTaskListCount : " + this.f15834e.size() + "\tBlockingTaskList : " + this.f15834e);
        Iterator<AsyncTaskC4371h> it = this.f15834e.iterator();
        while (it.hasNext()) {
            AsyncTaskC4371h next = it.next();
            if (next != null) {
                next.cancel(true);
            }
        }
        this.f15834e.clear();
    }

    /* renamed from: a */
    protected void m16571a(String str) {
        C4904y.m18639b(str, this.f15832c);
    }

    /* renamed from: b */
    protected void m16572b(String str) {
        C4904y.m18634a(str, this.f15832c);
    }

    /* renamed from: a */
    public void mo16570a(int i, boolean z) {
    }
}
