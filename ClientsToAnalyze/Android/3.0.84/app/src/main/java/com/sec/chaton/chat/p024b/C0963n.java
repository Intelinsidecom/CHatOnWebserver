package com.sec.chaton.chat.p024b;

import android.os.Build;
import android.os.Handler;
import com.sec.chaton.chat.translate.TranslateHelper;
import java.util.ArrayList;

/* compiled from: TranslateHelper.java */
/* renamed from: com.sec.chaton.chat.b.n */
/* loaded from: classes.dex */
public class C0963n {

    /* renamed from: b */
    private static ArrayList<TranslateHelper.TranslateInfo> f3962b = new ArrayList<>();

    /* renamed from: a */
    static Handler f3961a = new HandlerC0964o();

    /* renamed from: a */
    public static boolean m5180a() {
        return Build.VERSION.SDK_INT >= 14;
    }
}
