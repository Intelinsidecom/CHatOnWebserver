package com.sec.chaton.privateplugin.p088a;

import android.text.TextUtils;
import com.sec.chaton.plugin.p085d.C2940b;
import com.sec.chaton.plugin.p086e.AbstractRunnableC2943b;
import java.util.StringTokenizer;

/* compiled from: PrivateHttpTask.java */
/* renamed from: com.sec.chaton.privateplugin.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC3032a extends AbstractRunnableC2943b {
    protected AbstractC3032a(int i) {
        super(i);
    }

    @Override // com.sec.chaton.plugin.p086e.AbstractRunnableC2943b
    /* renamed from: a */
    protected Object mo12182a(int i, String str, String str2) {
        C2940b c2940bM12390b = m12390b(str2);
        c2940bM12390b.m12174a(i);
        c2940bM12390b.m12175a(str);
        return c2940bM12390b;
    }

    /* renamed from: b */
    private C2940b m12390b(String str) {
        C2940b c2940b = new C2940b();
        if (TextUtils.isEmpty(str)) {
            return c2940b;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, "[]");
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            if (i == 2) {
                c2940b.m12176b(strNextToken);
            } else if (i == 3) {
                c2940b.m12177c(strNextToken);
            }
            i++;
        }
        return c2940b;
    }
}
