package com.sec.chaton.global;

import com.sec.chaton.p033i.p034a.C1532a;
import com.sec.chaton.util.C3159aa;
import com.sec.common.util.log.collector.C3353c;
import com.sec.common.util.log.collector.C3358h;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.ArrayList;

/* compiled from: GlobalApplication.java */
/* renamed from: com.sec.chaton.global.c */
/* loaded from: classes.dex */
class C1495c implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    final /* synthetic */ Thread.UncaughtExceptionHandler f5530a;

    /* renamed from: b */
    final /* synthetic */ GlobalApplication f5531b;

    C1495c(GlobalApplication globalApplication, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f5531b = globalApplication;
        this.f5530a = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        try {
            if (C3159aa.m10962a().m10987b("uid") && C3353c.m11833b()) {
                ArrayList arrayList = new ArrayList();
                C1532a c1532a = new C1532a();
                for (Throwable cause = th; cause != null && !arrayList.contains(cause); cause = cause.getCause()) {
                    arrayList.add(cause);
                }
                Throwable th2 = (Throwable) arrayList.get(arrayList.size() - 1);
                StringWriter stringWriter = new StringWriter();
                th2.printStackTrace(new PrintWriter(stringWriter));
                c1532a.m6521a(stringWriter.toString().substring(0, 900));
                C3358h.m11842a().m11845a(c1532a);
                try {
                    Thread.sleep(1000L);
                } catch (Exception e) {
                }
                uncaughtExceptionHandler = this.f5530a;
            } else {
                uncaughtExceptionHandler = this.f5530a;
            }
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } catch (Throwable th3) {
            this.f5530a.uncaughtException(thread, th);
            throw th3;
        }
    }
}
