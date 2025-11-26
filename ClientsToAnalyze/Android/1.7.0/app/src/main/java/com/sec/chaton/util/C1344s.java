package com.sec.chaton.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.EnumC0665r;

/* compiled from: ChatONShortcutUtil.java */
/* renamed from: com.sec.chaton.util.s */
/* loaded from: classes.dex */
public class C1344s {
    /* renamed from: a */
    public static Intent m4673a(Context context, String str, EnumC0665r enumC0665r) {
        Intent intentM630a = HomeActivity.m630a(context, true);
        intentM630a.putExtra("inboxNO", str);
        intentM630a.putExtra("chatType", enumC0665r.m3012a());
        return intentM630a;
    }

    /* renamed from: a */
    public static Intent m4674a(Context context, String str, boolean z) {
        Intent intent = new Intent("com.coolots.chaton.CALL_SHORTCUT");
        if (z) {
            intent.putExtra("videocall", z);
        }
        intent.setData(Uri.parse("tel:" + str));
        return intent;
    }

    /* renamed from: a */
    public static void m4675a(Context context, Intent intent, String str, Bitmap bitmap) {
        Intent intent2 = new Intent();
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.NAME", str);
        intent2.putExtra("android.intent.extra.shortcut.ICON", bitmap);
        intent2.putExtra("duplicate", false);
        intent2.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        context.sendBroadcast(intent2);
    }

    /* renamed from: a */
    public static int m4672a(float f) {
        if ((GlobalApplication.m3100a().getResources().getConfiguration().screenLayout & 15) == 4) {
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
