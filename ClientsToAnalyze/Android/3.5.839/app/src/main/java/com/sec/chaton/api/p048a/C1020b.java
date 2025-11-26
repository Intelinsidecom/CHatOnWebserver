package com.sec.chaton.api.p048a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.C1071bk;
import com.sec.chaton.EnumC1094bm;
import com.sec.chaton.TabActivity;
import com.sec.chaton.buddy.AddBuddyActivity;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.SpecialBuddyActivity;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.buddy.dialog.SpecialBuddyDialog;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p057e.p058a.C2186al;
import java.io.UnsupportedEncodingException;

/* compiled from: BuddyLinkProcessor.java */
/* renamed from: com.sec.chaton.api.a.b */
/* loaded from: classes.dex */
public class C1020b extends AbstractC1019a {

    /* renamed from: c */
    private static String f3318c = "com.sec.chaton.action.VIEW_BUDDY";

    /* renamed from: d */
    private static String f3319d = "com.sec.chaton.action.ADD_BUDDY";

    @Override // com.sec.chaton.api.p048a.AbstractC1019a
    /* renamed from: a */
    public boolean mo6112a(Activity activity, Intent intent) {
        if (!m6111a() && !C2349a.m10301a("sms_feature")) {
            return false;
        }
        Uri data = intent.getData();
        String action = intent.getAction();
        if (f3319d.equals(action)) {
            intent.setClass(activity, AddBuddyActivity.class);
            intent.setFlags(67108864);
            return true;
        }
        if (f3318c.equals(action)) {
            return m6115b(data, activity, intent);
        }
        if (data == null) {
            return false;
        }
        if (!"android.intent.action.VIEW".equals(action) && !"android.intent.action.SEND".equals(action)) {
            return false;
        }
        String host = data.getHost();
        String path = data.getPath();
        if (!"buddies".equals(host)) {
            return false;
        }
        if ("/page".equals(path)) {
            intent.putExtra(TabActivity.f2028o, 0);
            return m6115b(data, activity, intent);
        }
        if ("/dialog".equals(path)) {
            intent.putExtra(TabActivity.f2028o, 0);
            return m6116c(data, activity, intent);
        }
        if ("/addbuddy/suggestions".equals(path)) {
            return m6114a(data, activity, intent);
        }
        intent.putExtra(TabActivity.f2028o, 0);
        return true;
    }

    /* renamed from: a */
    private boolean m6114a(Uri uri, Activity activity, Intent intent) {
        intent.setFlags(67108864);
        intent.putExtra("ADD_BUDDY_TYPE", 102);
        intent.putExtra("ENTRY_THROUGH_DEEP_LINK", true);
        intent.putExtra(TabActivity.f2028o, 0);
        intent.setClass(activity, AddBuddyActivity.class);
        activity.startActivity(intent);
        return true;
    }

    /* renamed from: b */
    private boolean m6115b(Uri uri, Activity activity, Intent intent) throws C1026h {
        String strM6113a;
        if (uri == null) {
            strM6113a = intent.getExtras().getString("PROFILE_BUDDY_NO");
        } else {
            strM6113a = m6113a(uri);
        }
        if (!TextUtils.isEmpty(strM6113a)) {
            intent.setFlags(67108864);
            intent.putExtra("showProfileViaExternal", true);
            intent.putExtra("PROFILE_BUDDY_NO", strM6113a);
            intent.putExtra(C1071bk.f3371e, EnumC1094bm.API);
            if (C2186al.m9766a(strM6113a)) {
                intent.putExtra("specialuserid", strM6113a);
                intent.setClass(activity, SpecialBuddyActivity.class);
            } else {
                intent.setClass(activity, BuddyProfileActivity.class);
            }
            activity.startActivity(intent);
            return true;
        }
        return false;
    }

    /* renamed from: c */
    private boolean m6116c(Uri uri, Activity activity, Intent intent) throws C1026h {
        String strM6113a = m6113a(uri);
        if (!TextUtils.isEmpty(strM6113a)) {
            intent.setFlags(67108864);
            intent.putExtra("showProfileViaExternal", true);
            intent.putExtra("BUDDY_DIALOG_BUDDY_NO", strM6113a);
            intent.putExtra(C1071bk.f3371e, EnumC1094bm.API);
            if (C2186al.m9766a(strM6113a)) {
                intent.putExtra("specialuserid", strM6113a);
                intent.setClass(activity, SpecialBuddyDialog.class);
            } else {
                intent.setClass(activity, BuddyDialog.class);
            }
            activity.startActivity(intent);
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private String m6113a(Uri uri) throws C1026h {
        try {
            return m6110a(uri, "id", f3317b);
        } catch (UnsupportedEncodingException e) {
            throw new C1026h(e);
        }
    }
}
