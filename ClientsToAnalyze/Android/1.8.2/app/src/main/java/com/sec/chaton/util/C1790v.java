package com.sec.chaton.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.EnumC0695j;

/* compiled from: ChatONShortcutUtil.java */
/* renamed from: com.sec.chaton.util.v */
/* loaded from: classes.dex */
public class C1790v {
    /* renamed from: a */
    public static Intent m6081a(Context context, String str, EnumC0695j enumC0695j) {
        Intent intentM585a = HomeActivity.m585a(context, true);
        intentM585a.putExtra("inboxNO", str);
        intentM585a.putExtra("chatType", enumC0695j.m3146a());
        intentM585a.putExtra("shortcut_chat", true);
        return intentM585a;
    }

    /* renamed from: a */
    public static void m6082a(Context context, Intent intent, String str, Bitmap bitmap) {
        Intent intent2 = new Intent();
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.NAME", str);
        intent2.putExtra("android.intent.extra.shortcut.ICON", bitmap);
        intent2.putExtra("duplicate", false);
        intent2.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        context.sendBroadcast(intent2);
    }

    /* renamed from: a */
    public static int m6080a(float f) {
        if ((GlobalApplication.m3260b().getResources().getConfiguration().screenLayout & 15) == 4) {
            return 72;
        }
        if (f == 0.75d) {
            return 36;
        }
        if (f == 1.0d) {
            return 48;
        }
        return (((double) f) == 1.5d || ((double) f) != 2.0d) ? 72 : 96;
    }
}
