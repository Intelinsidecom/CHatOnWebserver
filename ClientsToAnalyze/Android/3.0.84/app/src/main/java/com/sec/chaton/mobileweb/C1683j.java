package com.sec.chaton.mobileweb;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.SpecialBuddyActivity;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.buddy.dialog.MeDialog;
import com.sec.chaton.buddy.dialog.SpecialBuddyDialog;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import java.util.Map;

/* compiled from: ChatONAction.java */
/* renamed from: com.sec.chaton.mobileweb.j */
/* loaded from: classes.dex */
public class C1683j {

    /* renamed from: a */
    private static final String f6191a = C1683j.class.getSimpleName();

    /* renamed from: b */
    private EnumC1685l f6192b;

    /* renamed from: c */
    private Map<String, String> f6193c;

    /* renamed from: d */
    private boolean f6194d;

    public C1683j(EnumC1685l enumC1685l, Map<String, String> map) {
        this.f6194d = false;
        this.f6192b = enumC1685l;
        this.f6193c = map;
        this.f6194d = m6974d();
    }

    /* renamed from: a */
    public static C1683j m6969a(Uri uri) {
        EnumC1685l enumC1685lM6975a;
        C3250y.m11450b("Create(), uri : " + uri.toString(), f6191a);
        String scheme = uri.getScheme();
        String host = uri.getHost();
        String path = uri.getPath();
        String encodedQuery = uri.getEncodedQuery();
        if (TextUtils.isEmpty(scheme) || TextUtils.isEmpty(host) || TextUtils.isEmpty(path) || !"chaton".equals(scheme) || !"com.sec.chaton".equals(host) || (enumC1685lM6975a = EnumC1685l.m6975a(path)) == null) {
            return null;
        }
        return new C1683j(enumC1685lM6975a, C1692s.m6988a(encodedQuery));
    }

    /* renamed from: a */
    public EnumC1685l m6971a() {
        return this.f6192b;
    }

    /* renamed from: b */
    public Map<String, String> m6972b() {
        return this.f6193c;
    }

    /* renamed from: c */
    public boolean m6973c() {
        return this.f6194d;
    }

    /* renamed from: d */
    boolean m6974d() {
        return this.f6192b != null;
    }

    /* renamed from: a */
    public Intent m6970a(Context context) {
        String str;
        String str2;
        String str3;
        String str4;
        Intent intent;
        if (!m6973c() || context == null) {
            C3250y.m11450b("doDefaultAction(), not valid status. " + this, f6191a);
            return null;
        }
        switch (this.f6192b) {
            case BUDDY_POPUP:
                if (this.f6193c != null) {
                    str4 = this.f6193c.get("buddyid");
                    str3 = this.f6193c.get("buddyname");
                } else {
                    str3 = null;
                    str4 = null;
                }
                if (!TextUtils.isEmpty(str4)) {
                    if (str4.startsWith("0999")) {
                        if (GlobalApplication.m6456e()) {
                            intent = new Intent(context, (Class<?>) SpecialBuddyActivity.class);
                        } else {
                            intent = new Intent(context, (Class<?>) SpecialBuddyDialog.class);
                        }
                        intent.putExtra("specialuserid", str4);
                        if (!TextUtils.isEmpty(str3)) {
                            intent.putExtra("speicalusername", str3);
                            break;
                        }
                    } else {
                        String strM10979a = C3159aa.m10962a().m10979a("chaton_id", "");
                        if (!TextUtils.isEmpty(strM10979a) && strM10979a.equals(str4)) {
                            Intent intent2 = new Intent(context, (Class<?>) MeDialog.class);
                            intent2.putExtra("ME_DIALOG_NAME", C3159aa.m10962a().m10979a("Push Name", ""));
                            intent2.putExtra("ME_DIALOG_STATUSMSG", C3159aa.m10962a().m10979a("status_message", ""));
                            break;
                        } else if (GlobalApplication.m6456e()) {
                            Intent intent3 = new Intent(context, (Class<?>) BuddyProfileActivity.class);
                            intent3.putExtra("PROFILE_BUDDY_NO", str4);
                            intent3.putExtra("PROFILE_BUDDY_NAME", str3);
                            intent3.putExtra("ACTIVITY_PURPOSE_CALL_START_CHAT", 21);
                            break;
                        } else {
                            Intent intent4 = new Intent(context, (Class<?>) BuddyDialog.class);
                            intent4.putExtra("BUDDY_DIALOG_BUDDY_NO", str4);
                            intent4.putExtra("BUDDY_DIALOG_BUDDY_NAME", str3);
                            break;
                        }
                    }
                }
                break;
            case LIVE_CONTENTS:
                if (this.f6193c != null) {
                    str2 = this.f6193c.get("buddyid");
                    str = this.f6193c.get("url");
                } else {
                    str = null;
                    str2 = null;
                }
                if (!TextUtils.isEmpty(str2)) {
                    Intent intent5 = new Intent(context, (Class<?>) ChatActivity.class);
                    intent5.putExtra("specialbuddy", true);
                    intent5.putExtra("receivers", new String[]{String.valueOf(str2)});
                    intent5.putExtra("key_web_url", str);
                    break;
                }
                break;
        }
        return null;
    }

    public String toString() {
        String.format("mActionType=%s, mExtras=%s, mIsValid=%s, ", this.f6192b, this.f6193c, Boolean.valueOf(this.f6194d));
        return super.toString();
    }
}
