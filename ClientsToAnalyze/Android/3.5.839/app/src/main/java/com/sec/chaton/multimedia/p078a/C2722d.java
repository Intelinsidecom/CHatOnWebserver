package com.sec.chaton.multimedia.p078a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.R;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GlympseIntent.java */
/* renamed from: com.sec.chaton.multimedia.a.d */
/* loaded from: classes.dex */
public class C2722d {

    /* renamed from: b */
    private static final String f9746b = C2722d.class.getSimpleName();

    /* renamed from: a */
    static LinkedList<String> f9745a = new LinkedList<>();

    /* renamed from: c */
    private static final int[] f9747c = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 1, 18, 19, 1, 20, 21, 0, 22, 23, 24, 25, 26, 27, 27, 28, 29, 30, 31, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 1, 18, 19, 1, 20, 21, 0, 22, 23, 24, 25, 26, 27, 27, 28, 29, 30, 31};

    /* renamed from: a */
    public static Intent m11408a(Context context) throws JSONException {
        Intent intent = new Intent("com.glympse.android.intent.CREATE");
        intent.setPackage("com.glympse.android.glympse");
        intent.putExtra("app_sdk_rev", 10);
        intent.putExtra("source", context.getPackageName());
        intent.putExtra("flags", 268435457L);
        intent.putExtra("duration", 1800000L);
        intent.putExtra("initial_nickname", C4809aa.m18104a().m18121a("Push Name", ""));
        LinkedList linkedList = new LinkedList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "app");
            jSONObject.put("brand", "chaton");
            jSONObject.put("create_only", Boolean.TRUE);
            jSONObject.put("subtype", "chaton");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        linkedList.add(jSONObject.toString());
        intent.putExtra("recipients", (String[]) linkedList.toArray(new String[linkedList.size()]));
        return intent;
    }

    /* renamed from: a */
    public static Intent m11409a(Context context, String str) {
        Intent intent = new Intent("com.glympse.android.intent.VIEW");
        intent.setPackage("com.glympse.android.glympse");
        intent.putExtra("app_sdk_rev", 10);
        intent.putExtra("source", context.getPackageName());
        intent.putExtra("flags", 1L);
        m11411a(str);
        intent.putExtra("codes", (String[]) f9745a.toArray(new String[f9745a.size()]));
        return intent;
    }

    /* renamed from: a */
    private static void m11411a(String str) {
        Matcher matcher = Pattern.compile("(?:\\bglympse)(?:.[a-z]{2,}/|:|2:|://|2://)([a-z0-9]+-[a-z0-9]+(-[a-z0-9]+)*|![a-z0-9_{}]+)", 2).matcher(str);
        while (matcher.find()) {
            m11413b(matcher.group(1));
        }
    }

    /* renamed from: b */
    private static void m11413b(String str) {
        if (!str.startsWith("!") && m11412a(m11414c(str))) {
            f9745a.add(str);
        }
    }

    /* renamed from: c */
    private static long m11414c(String str) {
        int length = str.length();
        long j = 0;
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ('-' != cCharAt) {
                int i2 = (cCharAt < '0' || cCharAt > 'z') ? -1 : f9747c[cCharAt - '0'];
                if (i2 < 0) {
                    return 0L;
                }
                j = (j << 5) + i2;
            }
        }
        return j;
    }

    /* renamed from: a */
    private static boolean m11412a(long j) {
        return 0 != j && 0 == (((long) ((int) (j >> 35))) & 3);
    }

    /* renamed from: a */
    public static String m11410a(Intent intent) {
        String str;
        String stringExtra = "";
        if (intent.hasExtra(VKApiConst.MESSAGE)) {
            stringExtra = intent.getStringExtra(VKApiConst.MESSAGE);
        }
        String[] stringArrayExtra = intent.getStringArrayExtra("recipients");
        long longExtra = intent.getLongExtra("remaining", 0L);
        int i = (int) (longExtra / 3600000);
        int i2 = (int) ((longExtra / 60000) % 60);
        int i3 = (int) ((longExtra / 1000) % 60);
        if (i > 0) {
            str = String.format("%d:%02d:%02d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        } else {
            str = String.format("%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        String string = null;
        if (stringArrayExtra != null) {
            try {
                if (stringArrayExtra.length > 0) {
                    string = new JSONObject(stringArrayExtra[0]).getString("url");
                }
            } catch (JSONException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f9746b);
                }
            }
        }
        return String.format("glympse\n\n\n%s\n\n%s", stringExtra, String.format("%s\n%s", CommonApplication.m18732r().getString(R.string.glympse_message, str), string));
    }

    /* renamed from: a */
    public static Intent m11407a() {
        return new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.glympse.android.glympse"));
    }
}
