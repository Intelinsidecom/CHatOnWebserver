package com.sec.chaton.multimedia.emoticon.anicon;

import com.sec.chaton.util.C4904y;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: AniconPlusTask.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.n */
/* loaded from: classes.dex */
class C2782n extends Thread {

    /* renamed from: a */
    final /* synthetic */ C2780l f10074a;

    /* renamed from: b */
    private boolean f10075b;

    /* renamed from: c */
    private String f10076c;

    /* renamed from: d */
    private int f10077d;

    private C2782n(C2780l c2780l) {
        this.f10074a = c2780l;
        this.f10075b = false;
        this.f10076c = null;
        this.f10077d = 1;
    }

    /* renamed from: a */
    public void m11688a(String str) {
        this.f10076c = str;
    }

    /* renamed from: a */
    public void m11687a(int i) {
        this.f10077d = i;
    }

    /* renamed from: a */
    public void m11686a() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method method;
        if (this.f10074a.f10072c != null) {
            try {
                method = this.f10074a.f10072c.getClass().getMethod("cancel", new Class[0]);
            } catch (NoSuchMethodException e) {
                C4904y.m18635a(e, C2780l.f10069b);
                method = null;
            }
            Object[] objArr = new Object[0];
            if (method != null) {
                try {
                    method.invoke(this.f10074a.f10072c, objArr);
                } catch (IllegalAccessException e2) {
                    C4904y.m18635a(e2, C2780l.f10069b);
                } catch (IllegalArgumentException e3) {
                    C4904y.m18635a(e3, C2780l.f10069b);
                } catch (InvocationTargetException e4) {
                    C4904y.m18635a(e4, C2780l.f10069b);
                }
            }
        }
        this.f10074a.f10072c = null;
        this.f10074a.f10071a = null;
        this.f10075b = false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:11|(1:13)|14|114|15|109|16|(3:103|17|(2:101|19))|20|(1:22)|107|23|24|(3:(6:112|28|29|(2:31|117)(1:118)|32|26)|116|121)(1:120)) */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ea, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00eb, code lost:
    
        com.sec.chaton.util.C4904y.m18635a(r2, com.sec.chaton.multimedia.emoticon.anicon.C2780l.f10069b);
     */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0088 A[LOOP:0: B:26:0x0088->B:32:0x00a5, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.multimedia.emoticon.anicon.C2782n.run():void");
    }
}
