package com.sec.chaton.mobileweb;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.sec.chaton.p037j.C1554c;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.EnumC3218cf;
import com.sec.chaton.util.EnumC3219cg;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: MobileWebHelper.java */
/* renamed from: com.sec.chaton.mobileweb.s */
/* loaded from: classes.dex */
public class C1692s {

    /* renamed from: a */
    private static final String f6223a = C1692s.class.getSimpleName();

    /* renamed from: a */
    public static String m6985a() {
        String strM6590a = C1554c.m6590a(EnumC3218cf.PRIMARY, EnumC3219cg.LIVE_MOBILEWEB);
        String strM6590a2 = C1554c.m6590a(EnumC3218cf.SECONDARY, EnumC3219cg.LIVE_MOBILEWEB);
        if (C3250y.f11734b) {
            C3250y.m11450b("getLiveMobileWebServerAddress(), GLD primary : " + strM6590a, f6223a);
            C3250y.m11450b("getLiveMobileWebServerAddress(), GLD secondary : " + strM6590a2, f6223a);
            C3250y.m11450b("getLiveMobileWebServerAddress(), GLD default : http://smm.samsung.com", f6223a);
        }
        if (TextUtils.isEmpty(strM6590a)) {
            return !TextUtils.isEmpty(strM6590a2) ? strM6590a2 : "http://smm.samsung.com";
        }
        return strM6590a;
    }

    /* renamed from: a */
    public static Map<String, String> m6988a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap map = new HashMap();
        try {
            for (String str2 : str.split("&")) {
                String[] strArrSplit = str2.split("=");
                map.put(Uri.decode(strArrSplit[0]), Uri.decode(strArrSplit[1]));
            }
            return map;
        } catch (Exception e) {
            C3250y.m11443a(e, f6223a);
            return null;
        }
    }

    /* renamed from: a */
    public static String m6986a(String str, String str2) {
        return String.format("javascript:%s(\"%s\")", str, str2);
    }

    /* renamed from: a */
    public static String m6987a(List<EnumC1688o> list) {
        String strM10979a = C3159aa.m10962a().m10979a("uid", "");
        String strM11045a = C3171am.m11045a();
        String strM10979a2 = C3159aa.m10962a().m10979a("primary_file_addrss", "");
        int iIntValue = C3159aa.m10962a().m10978a("primary_file_port", (Integer) 0).intValue();
        String strM10979a3 = C3159aa.m10962a().m10979a("primary_contact_addrss", "");
        int iIntValue2 = C3159aa.m10962a().m10978a("primary_contact_port", (Integer) 0).intValue();
        String strM10979a4 = C3159aa.m10962a().m10979a("primary_message_addrss", "");
        int iIntValue3 = C3159aa.m10962a().m10978a("primary_message_port", (Integer) 0).intValue();
        String strM10979a5 = C3159aa.m10962a().m10979a("primary_sms_address", "");
        int iIntValue4 = C3159aa.m10962a().m10978a("primary_sms_port", (Integer) 0).intValue();
        return "<reqsource>" + String.format("<authkey>uid=%s&amp;imei=%s</authkey>", strM10979a, strM11045a) + String.format("<handshake>%s</handshake>", m6990b(list)) + String.format("<server name=\\\"file\\\" address=\\\"%s\\\" port=\\\"%d\\\"/>", strM10979a2, Integer.valueOf(iIntValue)) + String.format("<server name=\\\"contact\\\" address=\\\"%s\\\" port=\\\"%d\\\"/>", strM10979a3, Integer.valueOf(iIntValue2)) + String.format("<server name=\\\"message\\\" address=\\\"%s\\\" port=\\\"%d\\\"/>", strM10979a4, Integer.valueOf(iIntValue3)) + String.format("<server name=\\\"sms\\\" address=\\\"%s\\\" port=\\\"%d\\\"/>", strM10979a5, Integer.valueOf(iIntValue4)) + "</reqsource>";
    }

    /* renamed from: a */
    public static void m6989a(WebView webView) {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setVerticalScrollbarOverlay(true);
        webView.setOnLongClickListener(new ViewOnLongClickListenerC1693t());
        webView.setLongClickable(false);
        settings.setDatabaseEnabled(true);
        PushClientApplication pushClientApplicationM8156h = PushClientApplication.m8156h();
        settings.setDatabasePath(pushClientApplicationM8156h.getDir("webview_database", 0).getPath());
        String path = pushClientApplicationM8156h.getDir("webview_appcache", 0).getPath();
        settings.setAppCacheEnabled(true);
        settings.setAppCachePath(path);
        settings.setAppCacheMaxSize(8388608L);
        settings.setAllowFileAccess(true);
        settings.setCacheMode(-1);
    }

    /* renamed from: b */
    public static String m6990b(List<EnumC1688o> list) {
        if (list == null || list.size() <= 0) {
            return "";
        }
        EnumC1688o enumC1688o = list.get(list.size() - 1);
        StringBuilder sb = new StringBuilder();
        for (EnumC1688o enumC1688o2 : list) {
            sb.append(enumC1688o2.m6981d());
            if (enumC1688o2 != enumC1688o) {
                sb.append(",");
            }
        }
        return sb.toString().toString();
    }
}
