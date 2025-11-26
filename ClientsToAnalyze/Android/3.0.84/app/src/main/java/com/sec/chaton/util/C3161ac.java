package com.sec.chaton.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.sec.chaton.IntentControllerActivity;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.common.CommonApplication;

/* compiled from: ChatONShortcutUtil.java */
/* renamed from: com.sec.chaton.util.ac */
/* loaded from: classes.dex */
public class C3161ac {
    /* renamed from: a */
    public static Intent m10990a(Context context, C0513c c0513c, EnumC1450r enumC1450r) {
        Intent intentM1170a = IntentControllerActivity.m1170a(context);
        intentM1170a.setFlags(67108864);
        intentM1170a.putExtra("callChatList", true);
        intentM1170a.putExtra("chatType", EnumC1450r.GROUPCHAT.m6342a());
        intentM1170a.putExtra("receivers", (String[]) c0513c.m3999z().keySet().toArray(new String[0]));
        intentM1170a.putExtra("groupId", c0513c.m3975b());
        intentM1170a.putExtra("shortcut_chat", true);
        intentM1170a.putExtra(ChatFragment.f3494k, true);
        return intentM1170a;
    }

    /* renamed from: a */
    public static Intent m10991a(Context context, String str, EnumC1450r enumC1450r) {
        Intent intentM1170a = IntentControllerActivity.m1170a(context);
        intentM1170a.putExtra("callChatList", true);
        intentM1170a.putExtra("inboxNO", str);
        intentM1170a.putExtra("chatType", enumC1450r.m6342a());
        intentM1170a.putExtra("shortcut_chat", true);
        intentM1170a.putExtra(ChatFragment.f3494k, true);
        return intentM1170a;
    }

    /* renamed from: a */
    public static void m10992a(Context context, Intent intent, String str, Bitmap bitmap) {
        Intent intent2 = new Intent();
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.NAME", str);
        intent2.putExtra("android.intent.extra.shortcut.ICON", bitmap);
        intent2.putExtra("duplicate", false);
        intent2.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        context.sendBroadcast(intent2);
    }

    /* renamed from: a */
    public static int m10989a(float f) {
        if ((CommonApplication.m11493l().getResources().getConfiguration().screenLayout & 15) == 4) {
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
        return ((double) f) == 3.0d ? 144 : 72;
    }
}
