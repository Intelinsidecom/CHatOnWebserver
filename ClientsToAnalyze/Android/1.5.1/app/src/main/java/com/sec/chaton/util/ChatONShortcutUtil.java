package com.sec.chaton.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.database.ChatONContract;

/* loaded from: classes.dex */
public class ChatONShortcutUtil {
    /* renamed from: a */
    public static int m3524a(float f) {
        if (f == 0.75d) {
            return 36;
        }
        if (f == 1.0d) {
            return 48;
        }
        return (((double) f) != 1.5d && ((double) f) == 2.0d) ? 96 : 72;
    }

    /* renamed from: a */
    public static Intent m3525a(Context context, String str, ChatONContract.InBoxTable.ChatType chatType) {
        Intent intentM358a = HomeActivity.m358a(context, true);
        intentM358a.putExtra("inboxNO", str);
        intentM358a.putExtra("chatType", chatType.m2189a());
        return intentM358a;
    }

    /* renamed from: a */
    public static void m3526a(Context context, Intent intent, String str, Bitmap bitmap) {
        Intent intent2 = new Intent();
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.NAME", str);
        intent2.putExtra("android.intent.extra.shortcut.ICON", bitmap);
        intent2.putExtra("duplicate", false);
        intent2.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        context.sendBroadcast(intent2);
    }
}
