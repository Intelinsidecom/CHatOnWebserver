package com.sec.chaton.mobileweb;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.buddy.dialog.MeDialog;
import com.sec.chaton.buddy.dialog.SpecialBuddyDialog;
import com.sec.chaton.buddy.p050a.EnumC1109f;
import com.sec.chaton.specialbuddy.C4542g;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.spp.push.Config;
import java.util.Map;

/* compiled from: ChatONAction.java */
/* renamed from: com.sec.chaton.mobileweb.a */
/* loaded from: classes.dex */
public class C2586a {

    /* renamed from: a */
    private static final String f9228a = C2586a.class.getSimpleName();

    /* renamed from: b */
    private EnumC2589c f9229b;

    /* renamed from: c */
    private Map<String, String> f9230c;

    /* renamed from: d */
    private boolean f9231d;

    public C2586a(EnumC2589c enumC2589c, Map<String, String> map) {
        this.f9231d = false;
        this.f9229b = enumC2589c;
        this.f9230c = map;
        this.f9231d = m10994d();
    }

    /* renamed from: a */
    public static C2586a m10989a(Uri uri) {
        EnumC2590d enumC2590d;
        C4904y.m18639b("Create(), uri : " + uri.toString(), f9228a);
        String scheme = uri.getScheme();
        String host = uri.getHost();
        String path = uri.getPath();
        String encodedQuery = uri.getEncodedQuery();
        if (TextUtils.isEmpty(scheme) || TextUtils.isEmpty(host) || TextUtils.isEmpty(path)) {
            return null;
        }
        if (!"chaton".equals(scheme)) {
            return null;
        }
        if (Config.CHATON_PACKAGE_NAME.equals(host)) {
            enumC2590d = EnumC2590d.FROM_MOBILE_WEB;
        } else {
            if (!"live".equals(host)) {
                return null;
            }
            enumC2590d = EnumC2590d.FROM_EXTERNAL_LINK;
        }
        EnumC2589c enumC2589cM10998a = EnumC2589c.m10998a(path, enumC2590d);
        if (enumC2589cM10998a == null) {
            return null;
        }
        return new C2586a(enumC2589cM10998a, C2602p.m11013a(encodedQuery));
    }

    /* renamed from: a */
    public EnumC2589c m10991a() {
        return this.f9229b;
    }

    /* renamed from: b */
    public Map<String, String> m10992b() {
        return this.f9230c;
    }

    /* renamed from: c */
    public boolean m10993c() {
        return this.f9231d;
    }

    /* renamed from: d */
    boolean m10994d() {
        return this.f9229b != null;
    }

    /* renamed from: a */
    public Intent m10990a(Context context) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Intent intent;
        if (!m10993c() || context == null) {
            C4904y.m18639b("doDefaultAction(), not valid status. " + this, f9228a);
            return null;
        }
        switch (this.f9229b) {
            case M_ACTION_BUDDY_POPUP:
                if (this.f9230c != null) {
                    str6 = this.f9230c.get("buddyid");
                    str5 = this.f9230c.get("buddyname");
                } else {
                    str5 = null;
                    str6 = null;
                }
                if (!TextUtils.isEmpty(str6)) {
                    if (str6.startsWith("0999")) {
                        Intent intent2 = new Intent(context, (Class<?>) SpecialBuddyDialog.class);
                        intent2.putExtra("specialuserid", str6);
                        if (TextUtils.isEmpty(str5)) {
                            intent = intent2;
                        } else {
                            intent2.putExtra("speicalusername", str5);
                            intent = intent2;
                        }
                    } else {
                        String strM18121a = C4809aa.m18104a().m18121a("chaton_id", "");
                        if (!TextUtils.isEmpty(strM18121a) && strM18121a.equals(str6)) {
                            intent = new Intent(context, (Class<?>) MeDialog.class);
                            intent.putExtra("ME_DIALOG_NAME", C4809aa.m18104a().m18121a("Push Name", ""));
                            intent.putExtra("ME_DIALOG_STATUSMSG", C4809aa.m18104a().m18121a("status_message", ""));
                        } else {
                            Intent intent3 = new Intent(context, (Class<?>) BuddyDialog.class);
                            intent3.putExtra("BUDDY_DIALOG_BUDDY_NO", str6);
                            intent3.putExtra("BUDDY_DIALOG_BUDDY_NAME", str5);
                            intent = intent3;
                        }
                    }
                    break;
                }
                break;
            case M_ACTION_LIVE_CONTENTS:
            case L_ACTION_LIVE_CONTENTS:
                String strM7095a = EnumC1109f.CONTENTS.m7095a();
                if (this.f9230c != null) {
                    str4 = this.f9230c.get("buddyid");
                    str3 = this.f9230c.get("ctid");
                    str = this.f9230c.get("cpname");
                    String str7 = this.f9230c.get("follow");
                    str2 = (TextUtils.isEmpty(str7) || str7.equals("off")) ? strM7095a : this.f9230c.get("usertype");
                } else {
                    str = null;
                    str2 = strM7095a;
                    str3 = null;
                    str4 = null;
                }
                if (!TextUtils.isEmpty(str4)) {
                    Intent intentM17226a = C4542g.m17226a(context, String.valueOf(str4), str, str2);
                    intentM17226a.putExtra("callChatList", true);
                    if (!TextUtils.isEmpty(str3)) {
                        intentM17226a.putExtra("key_intent_ctid", "ctid=" + str3);
                        break;
                    }
                }
                break;
            case M_ACTION_LIVE_CHAT:
                String str8 = this.f9230c != null ? this.f9230c.get("buddyid") : null;
                if (!TextUtils.isEmpty(str8)) {
                    Intent intentM17232b = C4542g.m17232b(context, String.valueOf(str8));
                    intentM17232b.putExtra("callChatList", true);
                    break;
                }
                break;
        }
        return null;
    }

    public String toString() {
        String.format("mActionType=%s, mExtras=%s, mIsValid=%s, ", this.f9229b, this.f9230c, Boolean.valueOf(this.f9231d));
        return super.toString();
    }
}
