package com.sec.chaton.multimedia.emoticon.anicon;

import com.sec.chaton.util.C3250y;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: AniconPlusTask.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.m */
/* loaded from: classes.dex */
class C1823m extends Thread {

    /* renamed from: a */
    final /* synthetic */ C1821k f6799a;

    /* renamed from: b */
    private boolean f6800b;

    /* renamed from: c */
    private String f6801c;

    /* renamed from: d */
    private int f6802d;

    private C1823m(C1821k c1821k) {
        this.f6799a = c1821k;
        this.f6800b = false;
        this.f6801c = null;
        this.f6802d = 1;
    }

    /* renamed from: a */
    public void m7487a(String str) {
        this.f6801c = str;
    }

    /* renamed from: a */
    public void m7486a(int i) {
        this.f6802d = i;
    }

    /* renamed from: a */
    public void m7485a() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method method;
        if (this.f6799a.f6797c != null) {
            try {
                method = this.f6799a.f6797c.getClass().getMethod("cancel", new Class[0]);
            } catch (NoSuchMethodException e) {
                C3250y.m11443a(e, C1821k.f6794b);
                method = null;
            }
            Object[] objArr = new Object[0];
            if (method != null) {
                try {
                    method.invoke(this.f6799a.f6797c, objArr);
                } catch (IllegalAccessException e2) {
                    C3250y.m11443a(e2, C1821k.f6794b);
                } catch (IllegalArgumentException e3) {
                    C3250y.m11443a(e3, C1821k.f6794b);
                } catch (InvocationTargetException e4) {
                    C3250y.m11443a(e4, C1821k.f6794b);
                }
            }
        }
        this.f6799a.f6797c = null;
        this.f6799a.f6796a = null;
        this.f6800b = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0083 A[LOOP:0: B:26:0x0083->B:32:0x00a0, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.multimedia.emoticon.anicon.C1823m.run():void");
    }
}
