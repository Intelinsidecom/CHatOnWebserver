package com.sec.chaton.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.sec.chaton.IntentControllerActivity;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p074l.C2496n;
import com.sec.common.CommonApplication;
import com.sec.common.p131f.C4999c;
import com.sec.common.util.C5034k;
import java.io.File;

/* compiled from: ChatONShortcutUtil.java */
/* renamed from: com.sec.chaton.util.ac */
/* loaded from: classes.dex */
public class C4811ac {
    /* renamed from: a */
    public static boolean m18137a(Intent intent) {
        return intent.hasExtra("shortcut_chat") && intent.getBooleanExtra("shortcut_chat", false);
    }

    /* renamed from: a */
    public static Intent m18132a(Context context, C1106c c1106c, EnumC2300t enumC2300t) {
        Intent intentM2920a = IntentControllerActivity.m2920a(context);
        intentM2920a.setFlags(67108864);
        intentM2920a.putExtra("callChatList", true);
        intentM2920a.putExtra("chatType", EnumC2300t.GROUPCHAT.m10210a());
        intentM2920a.putExtra("groupId", c1106c.m7046a());
        intentM2920a.putExtra("shortcut_chat", true);
        intentM2920a.putExtra(ChatFragment.f5473i, true);
        return intentM2920a;
    }

    /* renamed from: a */
    public static Intent m18133a(Context context, String str, EnumC2300t enumC2300t) {
        return m18134a(context, str, enumC2300t, EnumC2301u.NORMAL);
    }

    /* renamed from: a */
    public static Intent m18134a(Context context, String str, EnumC2300t enumC2300t, EnumC2301u enumC2301u) {
        Intent intentM2920a = IntentControllerActivity.m2920a(context);
        intentM2920a.putExtra("callChatList", true);
        intentM2920a.putExtra("inboxNO", str);
        intentM2920a.putExtra("chatType", enumC2300t.m10210a());
        intentM2920a.putExtra("shortcut_chat", true);
        intentM2920a.putExtra(ChatFragment.f5473i, true);
        intentM2920a.putExtra("roomType", enumC2301u.m10212a());
        return intentM2920a;
    }

    /* renamed from: a */
    public static void m18136a(Context context, Intent intent, String str, Bitmap bitmap) {
        Intent intent2 = new Intent();
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.NAME", str);
        intent2.putExtra("android.intent.extra.shortcut.ICON", bitmap);
        intent2.putExtra("duplicate", false);
        intent2.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        context.sendBroadcast(intent2);
    }

    /* renamed from: a */
    public static int m18131a(float f) {
        if ((CommonApplication.m18732r().getResources().getConfiguration().screenLayout & 15) == 4) {
            return 72;
        }
        if (f == 0.75d) {
            return 36;
        }
        if (f == 1.0d) {
            return 48;
        }
        if (f == 1.5d) {
            return 72;
        }
        if (f == 2.0d) {
            return 96;
        }
        if (f == 3.0d) {
            return 144;
        }
        return ((double) f) == 4.0d ? 192 : 72;
    }

    /* renamed from: a */
    public static Bitmap m18135a(File file, int i, int i2) {
        Context contextM18732r = CommonApplication.m18732r();
        C4999c c4999c = new C4999c();
        if (C2496n.m10767a(file)) {
            c4999c.m18976a(file);
        } else {
            c4999c.m18971a(i);
        }
        int iM18131a = m18131a(contextM18732r.getResources().getDisplayMetrics().density);
        return c4999c.m18970a(C5034k.m19088a(3.5f), C5034k.m19088a(3.5f)).m18973a(-((int) C5034k.m19088a(4.0f)), -((int) C5034k.m19088a(4.0f)), BitmapFactory.decodeResource(contextM18732r.getResources(), i2), 85).m18974a(iM18131a, iM18131a, false).m18969a();
    }
}
