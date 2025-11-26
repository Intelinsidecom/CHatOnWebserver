package com.sec.chaton.mobileweb;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p067j.C2433c;
import com.sec.chaton.push.PushClientApplication;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4867ce;
import com.sec.chaton.util.EnumC4868cf;
import com.sec.common.CommonApplication;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: MobileWebHelper.java */
/* renamed from: com.sec.chaton.mobileweb.p */
/* loaded from: classes.dex */
public class C2602p {

    /* renamed from: a */
    private static final String f9301a = C2602p.class.getSimpleName();

    /* renamed from: a */
    public static String m11010a() {
        String strM10534a = C2433c.m10534a(EnumC4867ce.PRIMARY, EnumC4868cf.LIVE_MOBILEWEB);
        String strM10534a2 = C2433c.m10534a(EnumC4867ce.SECONDARY, EnumC4868cf.LIVE_MOBILEWEB);
        if (C4904y.f17872b) {
            C4904y.m18639b("getLiveMobileWebServerAddress(), GLD primary : " + strM10534a, f9301a);
            C4904y.m18639b("getLiveMobileWebServerAddress(), GLD secondary : " + strM10534a2, f9301a);
        }
        if (TextUtils.isEmpty(strM10534a)) {
            return !TextUtils.isEmpty(strM10534a2) ? strM10534a2 : "";
        }
        return strM10534a;
    }

    /* renamed from: b */
    public static String m11015b() {
        String strM10534a = C2433c.m10534a(EnumC4867ce.PRIMARY, EnumC4868cf.SHOP);
        String strM10534a2 = C2433c.m10534a(EnumC4867ce.SECONDARY, EnumC4868cf.SHOP);
        if (C4904y.f17872b) {
            C4904y.m18639b("getShopServerAddress(), GLD primary : " + strM10534a, f9301a);
            C4904y.m18639b("getShopServerAddress(), GLD secondary : " + strM10534a2, f9301a);
        }
        if (TextUtils.isEmpty(strM10534a)) {
            return !TextUtils.isEmpty(strM10534a2) ? strM10534a2 : "";
        }
        return strM10534a;
    }

    /* renamed from: c */
    public static String m11020c() {
        String strM10534a = C2433c.m10534a(EnumC4867ce.PRIMARY, EnumC4868cf.GAME);
        String strM10534a2 = C2433c.m10534a(EnumC4867ce.SECONDARY, EnumC4868cf.GAME);
        if (C4904y.f17872b) {
            C4904y.m18639b("getGameServerAddress(), GLD primary : " + strM10534a, f9301a);
            C4904y.m18639b("getGameServerAddress(), GLD secondary : " + strM10534a2, f9301a);
        }
        return !TextUtils.isEmpty(strM10534a) ? strM10534a : strM10534a2;
    }

    /* renamed from: a */
    public static Map<String, String> m11013a(String str) {
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
            C4904y.m18635a(e, f9301a);
            return null;
        }
    }

    /* renamed from: a */
    public static String m11011a(String str, String str2) {
        return String.format("javascript:%s(%s)", str, str2);
    }

    /* renamed from: b */
    public static String m11016b(String str, String str2) {
        return String.format("javascript:%s(\"%s\")", str, str2);
    }

    /* renamed from: a */
    public static String m11012a(List<EnumC2598l> list) {
        String strM18121a = C4809aa.m18104a().m18121a("uid", "");
        String strM18228d = C4822an.m18228d();
        String strM18121a2 = C4809aa.m18104a().m18121a("primary_file_addrss", "");
        int iIntValue = C4809aa.m18104a().m18120a("primary_file_port", (Integer) 0).intValue();
        String strM18121a3 = C4809aa.m18104a().m18121a("primary_contact_addrss", "");
        int iIntValue2 = C4809aa.m18104a().m18120a("primary_contact_port", (Integer) 0).intValue();
        String strM18121a4 = C4809aa.m18104a().m18121a("primary_message_addrss", "");
        int iIntValue3 = C4809aa.m18104a().m18120a("primary_message_port", (Integer) 0).intValue();
        String strM18121a5 = C4809aa.m18104a().m18121a("primary_sms_address", "");
        int iIntValue4 = C4809aa.m18104a().m18120a("primary_sms_port", (Integer) 0).intValue();
        return "<reqsource>" + String.format("<authkey>uid=%s&amp;imei=%s</authkey>", strM18121a, strM18228d) + String.format("<user country=%s/>", C4822an.m18257y()) + String.format("<handshake>%s</handshake>", m11017b(list)) + String.format("<server name=\\\"file\\\" address=\\\"%s\\\" port=\\\"%d\\\"/>", strM18121a2, Integer.valueOf(iIntValue)) + String.format("<server name=\\\"contact\\\" address=\\\"%s\\\" port=\\\"%d\\\"/>", strM18121a3, Integer.valueOf(iIntValue2)) + String.format("<server name=\\\"message\\\" address=\\\"%s\\\" port=\\\"%d\\\"/>", strM18121a4, Integer.valueOf(iIntValue3)) + String.format("<server name=\\\"sms\\\" address=\\\"%s\\\" port=\\\"%d\\\"/>", strM18121a5, Integer.valueOf(iIntValue4)) + String.format("<pkgname>%s</pkgname>", CommonApplication.m18732r().getPackageName()) + String.format("<version>%s</version>", C1427a.f5063a) + "</reqsource>";
    }

    /* renamed from: a */
    public static void m11014a(WebView webView) {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setVerticalScrollbarOverlay(true);
        webView.setLongClickable(true);
        settings.setDatabaseEnabled(true);
        PushClientApplication pushClientApplicationM12499n = PushClientApplication.m12499n();
        settings.setDatabasePath(pushClientApplicationM12499n.getDir("webview_database", 0).getPath());
        String path = pushClientApplicationM12499n.getDir("webview_appcache", 0).getPath();
        settings.setAppCacheEnabled(true);
        settings.setAppCachePath(path);
        settings.setAppCacheMaxSize(8388608L);
        settings.setAllowFileAccess(true);
        settings.setCacheMode(-1);
    }

    /* renamed from: b */
    public static void m11018b(WebView webView) {
        WebSettings settings = webView.getSettings();
        if (Build.VERSION.SDK_INT >= 19) {
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
        }
        webView.setOnLongClickListener(new ViewOnLongClickListenerC2603q());
    }

    /* renamed from: c */
    public static void m11021c(WebView webView) {
        WebSettings settings = webView.getSettings();
        try {
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setDisplayZoomControls(false);
        } catch (NoSuchMethodError e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f9301a);
            }
        }
    }

    /* renamed from: d */
    public static void m11023d(WebView webView) {
        if (Build.VERSION.SDK_INT < 11) {
            webView.requestFocus(130);
        }
    }

    /* renamed from: d */
    public static void m11022d() {
        WebView webView = new WebView(CommonApplication.m18732r());
        WebSettings settings = webView.getSettings();
        settings.setDatabaseEnabled(true);
        PushClientApplication pushClientApplicationM12499n = PushClientApplication.m12499n();
        settings.setDatabasePath(pushClientApplicationM12499n.getDir("webview_database", 0).getPath());
        String path = pushClientApplicationM12499n.getDir("webview_appcache", 0).getPath();
        settings.setAppCacheEnabled(true);
        settings.setAppCachePath(path);
        settings.setAppCacheMaxSize(8388608L);
        settings.setAllowFileAccess(true);
        settings.setCacheMode(-1);
        webView.clearCache(true);
        if (C4904y.f17872b) {
            C4904y.m18639b("clearCache when deregisted", C2602p.class.getSimpleName());
        }
    }

    /* renamed from: b */
    public static String m11017b(List<EnumC2598l> list) {
        if (list == null || list.size() <= 0) {
            return "";
        }
        EnumC2598l enumC2598l = list.get(list.size() - 1);
        StringBuilder sb = new StringBuilder();
        for (EnumC2598l enumC2598l2 : list) {
            sb.append(enumC2598l2.m11006d());
            if (enumC2598l2 != enumC2598l) {
                sb.append(",");
            }
        }
        return sb.toString().toString();
    }

    /* renamed from: b */
    public static boolean m11019b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                if (!C4904y.f17872b) {
                    return false;
                }
                C4904y.m18639b("isChatONInternalURL url is null", C2602p.class.getSimpleName());
                return false;
            }
            String host = new URI(str).getHost();
            if (TextUtils.isEmpty(host)) {
                return false;
            }
            if (host.startsWith("www.")) {
                host = host.substring(4);
            }
            if (C4904y.f17872b) {
                C4904y.m18639b("isChatONInternalURL Domain : " + host, C2602p.class.getSimpleName());
            }
            return host.contains(".samsungchaton.com") || host.contains("lb-sue1iscp-1849305675.us-east-1.elb.amazonaws.com") || host.contains("14.63.233.216");
        } catch (URISyntaxException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f9301a);
            }
            return true;
        } catch (Exception e2) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e2, f9301a);
            }
            return true;
        }
    }
}
