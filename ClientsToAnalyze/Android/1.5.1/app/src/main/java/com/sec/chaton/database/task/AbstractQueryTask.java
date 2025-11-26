package com.sec.chaton.database.task;

import android.os.Handler;
import com.sec.chaton.util.ChatONLogWriter;

/* loaded from: classes.dex */
public abstract class AbstractQueryTask {

    /* renamed from: a */
    private OnQueryTaskResult f1781a;

    /* renamed from: d */
    public Handler f1782d;

    public interface OnQueryTaskResult {
        /* renamed from: a */
        void mo654a(int i, boolean z, Object obj);
    }

    public AbstractQueryTask(OnQueryTaskResult onQueryTaskResult) {
        this.f1781a = onQueryTaskResult;
    }

    public AbstractQueryTask(OnQueryTaskResult onQueryTaskResult, Handler handler) {
        this.f1781a = onQueryTaskResult;
        this.f1782d = handler;
    }

    /* renamed from: a */
    public abstract Object mo2320a();

    /* renamed from: a */
    public void m2321a(int i) {
        Object objMo2320a = mo2320a();
        if (this.f1781a != null) {
            try {
                if (this.f1782d != null) {
                    this.f1782d.post(new RunnableC0216b(this, i, objMo2320a));
                } else {
                    this.f1781a.mo654a(i, true, objMo2320a);
                }
            } catch (Exception e) {
                ChatONLogWriter.m3501a(e, getClass().getSimpleName());
                if (this.f1782d != null) {
                    this.f1782d.post(new RunnableC0215a(this, i, objMo2320a));
                } else {
                    this.f1781a.mo654a(i, false, objMo2320a);
                }
            }
        }
    }
}
