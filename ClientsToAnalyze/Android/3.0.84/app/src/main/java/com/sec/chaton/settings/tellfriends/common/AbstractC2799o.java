package com.sec.chaton.settings.tellfriends.common;

import android.app.Activity;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: SnsManager.java */
/* renamed from: com.sec.chaton.settings.tellfriends.common.o */
/* loaded from: classes.dex */
public abstract class AbstractC2799o {

    /* renamed from: a */
    private String f10299a;

    /* renamed from: b */
    public Activity f10300b;

    /* renamed from: c */
    public InterfaceC2787c f10301c;

    /* renamed from: d */
    private ArrayList<AsyncTaskC2801q> f10302d = new ArrayList<>();

    public AbstractC2799o(Activity activity, InterfaceC2787c interfaceC2787c, String str) {
        this.f10300b = activity;
        this.f10301c = interfaceC2787c;
        this.f10299a = str;
    }

    /* renamed from: e */
    public void mo10016e() {
        m10014b("killAllTask() \t- BlockingTaskListCount : " + this.f10302d.size() + "\tBlockingTaskList : " + this.f10302d);
        Iterator<AsyncTaskC2801q> it = this.f10302d.iterator();
        while (it.hasNext()) {
            AsyncTaskC2801q next = it.next();
            if (next != null) {
                next.cancel(true);
            }
        }
        this.f10302d.clear();
    }

    /* renamed from: b */
    protected void m10014b(String str) {
        C3250y.m11450b(str, this.f10299a);
    }

    /* renamed from: c */
    protected void m10015c(String str) {
        C3250y.m11442a(str, this.f10299a);
    }
}
