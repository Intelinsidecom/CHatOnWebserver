package com.sec.chaton.p032h;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.C2310s;
import com.sec.chaton.EnumC3073u;
import com.sec.chaton.settings2.PrefFragmentChats;
import com.sec.chaton.util.C3250y;
import com.sec.spp.push.Config;
import java.net.URLDecoder;
import java.nio.charset.Charset;

/* compiled from: InterlockedIntentSortExt.java */
/* renamed from: com.sec.chaton.h.j */
/* loaded from: classes.dex */
public class C1507j {

    /* renamed from: a */
    static final Charset f5541a = Charset.forName("UTF-8");

    /* renamed from: b */
    static final String f5542b = f5541a.name();

    /* renamed from: a */
    public static InterfaceC1498a m6469a(Intent intent) {
        Uri data = intent.getData();
        if (data != null) {
            String host = data.getHost();
            String path = data.getPath();
            if ("com.sec.chaton".equals(host)) {
                if ("/chat".equals(path)) {
                    String strM6470a = m6470a(data, "apiver", f5542b);
                    String strM6470a2 = m6470a(data, "action", f5542b);
                    String strM6470a3 = m6470a(data, PrefFragmentChats.TYPE, f5542b);
                    String strM6470a4 = m6470a(data, "mime", f5542b);
                    String strM6470a5 = m6470a(data, Config.NOTIFICATION_INTENT_MSG, f5542b);
                    String strM6470a6 = m6470a(data, "uri", f5542b);
                    String strM6470a7 = m6470a(data, "appInfo", f5542b);
                    String strM6470a8 = m6470a(data, "recipients", f5542b);
                    String strM6470a9 = m6470a(data, "inboxNo", f5542b);
                    String strM6470a10 = m6470a(data, "chatType", f5542b);
                    if (C3250y.f11734b) {
                        C3250y.m11450b("apiver : " + strM6470a, "HandleIntent");
                        C3250y.m11450b("action : " + strM6470a2, "HandleIntent");
                        C3250y.m11450b("type : " + strM6470a3, "HandleIntent");
                        C3250y.m11450b("mime : " + strM6470a4, "HandleIntent");
                        C3250y.m11450b("msg : " + strM6470a5, "HandleIntent");
                        C3250y.m11450b("uri: " + strM6470a6, "HandleIntent");
                        C3250y.m11450b("appInfo : " + strM6470a7, "HandleIntent");
                        C3250y.m11450b("recipients : " + strM6470a8, "HandleIntent");
                        C3250y.m11450b("inboxNo : " + strM6470a9, "HandleIntent");
                        C3250y.m11450b("chatType : " + strM6470a10, "HandleIntent");
                    }
                    if (!TextUtils.isEmpty(strM6470a6)) {
                        if ("text_url".equals(strM6470a3)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(strM6470a6);
                            if (!TextUtils.isEmpty(strM6470a5)) {
                                sb.append("\n").append("\n").append(strM6470a5);
                            }
                            strM6470a5 = sb.toString();
                        } else {
                            intent.putExtra("android.intent.extra.STREAM", Uri.parse(strM6470a6));
                        }
                    }
                    if (!TextUtils.isEmpty(strM6470a5)) {
                        intent.putExtra("android.intent.extra.TEXT", strM6470a5);
                    }
                    if (!TextUtils.isEmpty(strM6470a7)) {
                        intent.putExtra("sub_content", strM6470a7);
                    }
                    if (!TextUtils.isEmpty(strM6470a8)) {
                        intent.putExtra("receivers", strM6470a8.split(","));
                    }
                    if ("app".equals(strM6470a3) || "app_multimedia".equals(strM6470a3) || "app_url".equals(strM6470a3)) {
                        intent.setDataAndType(data, "application/chaton-applink");
                    } else if (!TextUtils.isEmpty(strM6470a4)) {
                        intent.setDataAndType(data, strM6470a4);
                    }
                    if (!TextUtils.isEmpty(strM6470a9)) {
                        intent.putExtra("inboxNO", strM6470a9);
                    }
                    if (!TextUtils.isEmpty(strM6470a10)) {
                        intent.putExtra("chatType", Integer.valueOf(strM6470a10));
                    }
                    intent.putExtra(C2310s.f8621e, EnumC3073u.API);
                } else if ("/chatlist".equals(path)) {
                    intent.putExtra("callChatTab", true);
                    intent.putExtra(C2310s.f8621e, EnumC3073u.API);
                } else if ("/mypage".equals(path)) {
                    intent.putExtra("callMyPageTab", true);
                    intent.putExtra(C2310s.f8621e, EnumC3073u.API);
                }
            }
        }
        return C1505h.m6468a(intent);
    }

    /* renamed from: a */
    private static String m6470a(Uri uri, String str, String str2) {
        if (str == null) {
            throw new NullPointerException("key");
        }
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return null;
        }
        int length = encodedQuery.length();
        int i = 0;
        while (true) {
            int iIndexOf = encodedQuery.indexOf(38, i);
            int i2 = iIndexOf != -1 ? iIndexOf : length;
            int iIndexOf2 = encodedQuery.indexOf(61, i);
            if (iIndexOf2 > i2 || iIndexOf2 == -1) {
                iIndexOf2 = i2;
            }
            if (iIndexOf2 - i == str.length() && encodedQuery.regionMatches(i, str, 0, str.length())) {
                if (iIndexOf2 == i2) {
                    return "";
                }
                return URLDecoder.decode(encodedQuery.substring(iIndexOf2 + 1, i2), str2);
            }
            if (iIndexOf == -1) {
                return null;
            }
            i = iIndexOf + 1;
        }
    }
}
