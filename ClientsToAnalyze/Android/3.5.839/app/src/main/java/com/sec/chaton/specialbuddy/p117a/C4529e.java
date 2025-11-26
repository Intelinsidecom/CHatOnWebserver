package com.sec.chaton.specialbuddy.p117a;

import android.text.TextUtils;
import com.sec.chaton.chat.translate.C1865r;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4808a;
import com.sec.chaton.util.C4904y;

/* compiled from: LiveChatHelper.java */
/* renamed from: com.sec.chaton.specialbuddy.a.e */
/* loaded from: classes.dex */
public class C4529e {
    /* renamed from: a */
    public static String m17224a(String str) {
        String strM18595a = GlobalApplication.m10284c().m18595a();
        if (TextUtils.isEmpty(strM18595a)) {
            if (!C4904y.f17872b) {
                return null;
            }
            C4904y.m18639b("getAesEncryptedString(), ChatON EnKey is Empty", C4529e.class.getSimpleName());
            return null;
        }
        try {
            byte[] bArrM9071b = C1865r.m9071b(strM18595a, str);
            if (bArrM9071b != null) {
                return C4808a.m18098a(bArrM9071b);
            }
            return null;
        } catch (Exception e) {
            if (!C4904y.f17875e) {
                return null;
            }
            C4904y.m18635a(e, C4529e.class.getSimpleName());
            return null;
        }
    }
}
