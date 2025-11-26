package com.facebook;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.facebook.p032b.C0476s;
import com.p137vk.sdk.VKOpenAuthActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: NativeProtocol.java */
/* renamed from: com.facebook.al */
/* loaded from: classes.dex */
final class C0442al {
    /* renamed from: a */
    static final boolean m1575a(Context context, String str) {
        try {
            for (Signature signature : context.getPackageManager().getPackageInfo(str, 64).signatures) {
                if (signature.toCharsString().equals("30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2")) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /* renamed from: a */
    static Intent m1570a(Context context, Intent intent) {
        ResolveInfo resolveInfoResolveActivity;
        if (intent == null || (resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 0)) == null || !m1575a(context, resolveInfoResolveActivity.activityInfo.packageName)) {
            return null;
        }
        return intent;
    }

    /* renamed from: b */
    static Intent m1576b(Context context, Intent intent) {
        ResolveInfo resolveInfoResolveService;
        if (intent == null || (resolveInfoResolveService = context.getPackageManager().resolveService(intent, 0)) == null || !m1575a(context, resolveInfoResolveService.serviceInfo.packageName)) {
            return null;
        }
        return intent;
    }

    /* renamed from: a */
    static Intent m1572a(Context context, String str, List<String> list) {
        Intent intentPutExtra = new Intent().setClassName("com.facebook.katana", "com.facebook.katana.ProxyAuth").putExtra(VKOpenAuthActivity.VK_EXTRA_CLIENT_ID, str);
        if (!C0476s.m1718a(list)) {
            intentPutExtra.putExtra(VKOpenAuthActivity.VK_EXTRA_SCOPE, TextUtils.join(",", list));
        }
        return m1570a(context, intentPutExtra);
    }

    /* renamed from: a */
    static Intent m1569a(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.facebook.katana", "com.facebook.katana.platform.TokenRefreshService");
        return m1576b(context, intent);
    }

    /* renamed from: a */
    static Intent m1571a(Context context, String str, ArrayList<String> arrayList, String str2) {
        return m1570a(context, new Intent().setAction("com.facebook.platform.PLATFORM_ACTIVITY").addCategory("android.intent.category.DEFAULT").putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 20121101).putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", "com.facebook.platform.action.request.LOGIN_DIALOG").putExtra("com.facebook.platform.extra.APPLICATION_ID", str).putStringArrayListExtra("com.facebook.platform.extra.PERMISSIONS", m1574a(arrayList)).putExtra("com.facebook.platform.extra.WRITE_PRIVACY", m1573a(str2)));
    }

    /* renamed from: a */
    private static String m1573a(String str) {
        if (C0476s.m1717a(str)) {
            return "SELF";
        }
        return str;
    }

    /* renamed from: a */
    private static ArrayList<String> m1574a(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2;
        if (C0476s.m1718a(arrayList)) {
            arrayList2 = new ArrayList<>();
        } else {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (C0478ba.m1738a(next) || "basic_info".equals(next)) {
                    return arrayList;
                }
            }
            arrayList2 = new ArrayList<>(arrayList);
        }
        arrayList2.add("basic_info");
        return arrayList2;
    }
}
