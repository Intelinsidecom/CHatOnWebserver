package com.sec.chaton.api.p048a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.C1071bk;
import com.sec.chaton.EnumC1094bm;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.chat.C1760hf;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.chat.EnumC1761hg;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.forward.ChatForwardActivity;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.search.C3408b;
import com.sec.chaton.smsplugin.p112ui.PluginComposeMessageActivity;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.spp.push.Config;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ChatLinkProcessor.java */
/* renamed from: com.sec.chaton.api.a.c */
/* loaded from: classes.dex */
public class C1021c extends AbstractC1019a {

    /* renamed from: c */
    private static final String f3320c = TabActivity.class.getSimpleName();

    /* renamed from: d */
    private static final String[] f3321d = {"apiver", "action", "type", "mime", Config.NOTIFICATION_INTENT_MSG, "uri", "appInfo", "recipients", "inboxNo", "chatType", "updatePushName", "fromUpdatePush", "roomType"};

    @Override // com.sec.chaton.api.p048a.AbstractC1019a
    /* renamed from: a */
    public boolean mo6112a(Activity activity, Intent intent) {
        boolean zM6119a;
        if (!m6111a() && !C2349a.m10301a("sms_feature")) {
            return false;
        }
        try {
            zM6119a = m6119a(intent);
        } catch (UnsupportedEncodingException e) {
            C4904y.m18635a(e, f3320c);
            zM6119a = false;
        }
        if (!zM6119a && C4904y.f17872b) {
            C4904y.m18639b("This intent doesn't have the URI for Chat.", f3320c);
        }
        return m6121a(C1760hf.m8731a(intent, activity), activity, intent);
    }

    /* renamed from: a */
    private boolean m6121a(EnumC1761hg enumC1761hg, Activity activity, Intent intent) {
        switch (enumC1761hg) {
            case CHATROOM:
                m6128e(activity, intent);
                break;
            case FORWARD:
                if (C4822an.m18218a()) {
                    if (C4822an.m18226c()) {
                        m6122b(activity, intent);
                        break;
                    } else {
                        m6125c(activity, intent);
                        break;
                    }
                } else {
                    m6127d(activity, intent);
                    break;
                }
            case CHATLIST:
                intent.putExtra(TabActivity.f2028o, 1);
                break;
        }
        return true;
    }

    /* renamed from: b */
    private void m6122b(Activity activity, Intent intent) {
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(activity);
        abstractC4932aM18733a.mo18734a(R.string.trunk_opt_header_share).mo18736a(R.array.share_type, new DialogInterfaceOnClickListenerC1022d(this, activity, intent));
        abstractC4932aM18733a.mo18745a().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m6125c(Activity activity, Intent intent) {
        if (C4904y.f17873c) {
            C4904y.m18641c("Shortcut or Notification: " + intent.getBooleanExtra("callChatList", false), f3320c);
        }
        if (intent.getBooleanExtra("callForward", false)) {
            intent.putExtra("callForward", false);
            intent.setClass(activity, ChatForwardActivity.class);
            intent.setFlags(67108864);
            activity.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m6127d(Activity activity, Intent intent) {
        if (C2349a.m10301a("sms_feature")) {
            intent.setClass(activity, PluginComposeMessageActivity.class);
            intent.setFlags(67108864);
            activity.startActivity(intent);
        }
    }

    /* renamed from: e */
    private void m6128e(Activity activity, Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("callChatList", false);
        if (C4904y.f17873c) {
            C4904y.m18641c("Shortcut or Notification: " + booleanExtra, f3320c);
        }
        if (booleanExtra) {
            boolean booleanExtra2 = intent.getBooleanExtra("specialbuddy", false);
            if (GlobalApplication.m10286e() && !booleanExtra2) {
                intent.putExtra(C1760hf.f6609e, true);
                return;
            }
            if (EnumC2301u.m10211a(intent.getIntExtra("roomType", EnumC2301u.NORMAL.m10212a())) == EnumC2301u.SMS) {
                String stringExtra = intent.getStringExtra("inboxNO");
                if (C3408b.m13226a(stringExtra)) {
                    Intent intentM15925a = PluginComposeMessageActivity.m15925a(activity, Long.parseLong(stringExtra));
                    if (intent.hasExtra("disable")) {
                        intentM15925a.putExtra("disable", intent.getBooleanExtra("disable", false));
                    }
                    activity.startActivity(intentM15925a);
                    return;
                }
            }
            intent.putExtra("callChatList", false);
            intent.setClass(activity, ChatActivity.class);
            intent.setFlags(67108864);
            activity.startActivity(intent);
            return;
        }
        if (EnumC2300t.m10207a(intent.getIntExtra("chatType", -1)) == EnumC2300t.WEB_AUTH) {
            C1813b.m8906b().m8940e();
            m6129f(activity, intent);
        }
    }

    /* renamed from: f */
    private void m6129f(Activity activity, Intent intent) {
        AbstractC4932a.m18733a(activity).mo18734a(R.string.app_name).mo18749b(intent.getStringExtra("Content")).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1023e(this)).mo18745a().show();
    }

    /* renamed from: a */
    private boolean m6119a(Intent intent) {
        Uri data = intent.getData();
        if (data == null || !m6120a(data)) {
            return false;
        }
        intent.putExtra(C1071bk.f3371e, EnumC1094bm.API);
        if (m6126c(data)) {
            m6117a(data, intent);
        } else if (m6124b(data)) {
            intent.putExtra("callChatTab", true);
        }
        return true;
    }

    /* renamed from: a */
    private void m6117a(Uri uri, Intent intent) {
        HashMap map = new HashMap();
        for (String str : f3321d) {
            map.put(str, m6110a(uri, str, f3317b));
        }
        if (C4904y.f17872b) {
            for (Map.Entry entry : map.entrySet()) {
                C4904y.m18639b(((String) entry.getKey()) + " : " + ((String) entry.getValue()), f3320c);
            }
        }
        if (map.containsKey("uri") && !TextUtils.isEmpty((CharSequence) map.get("uri"))) {
            if ("text_url".equals(map.get("type"))) {
                StringBuilder sb = new StringBuilder();
                sb.append((String) map.get("uri"));
                if (map.containsKey(Config.NOTIFICATION_INTENT_MSG) && !TextUtils.isEmpty((CharSequence) map.get(Config.NOTIFICATION_INTENT_MSG))) {
                    sb.append("\n").append("\n").append((String) map.get(Config.NOTIFICATION_INTENT_MSG));
                }
                map.put(Config.NOTIFICATION_INTENT_MSG, sb.toString());
            } else {
                intent.putExtra("android.intent.extra.STREAM", Uri.parse((String) map.get("uri")));
            }
        }
        if (map.containsKey(Config.NOTIFICATION_INTENT_MSG) && !TextUtils.isEmpty((CharSequence) map.get(Config.NOTIFICATION_INTENT_MSG))) {
            intent.putExtra("android.intent.extra.TEXT", (String) map.get(Config.NOTIFICATION_INTENT_MSG));
        }
        if (map.containsKey("appInfo") && !TextUtils.isEmpty((CharSequence) map.get("appInfo"))) {
            intent.putExtra("sub_content", (String) map.get("appInfo"));
        }
        if (map.containsKey("recipients") && !TextUtils.isEmpty((CharSequence) map.get("recipients"))) {
            intent.putExtra("receivers", ((String) map.get("recipients")).split(","));
        }
        if (map.containsKey("type") && ("app".equals(map.get("type")) || "app_multimedia".equals(map.get("type")) || "app_url".equals(map.get("type")))) {
            intent.setDataAndType(uri, "application/chaton-applink");
        } else if (map.containsKey("mime") && !TextUtils.isEmpty((CharSequence) map.get("mime"))) {
            intent.setDataAndType(uri, (String) map.get("mime"));
        }
        if (map.containsKey("inboxNo") && !TextUtils.isEmpty((CharSequence) map.get("inboxNo"))) {
            intent.putExtra("inboxNO", (String) map.get("inboxNo"));
        }
        if (map.containsKey("chatType") && !TextUtils.isEmpty((CharSequence) map.get("chatType"))) {
            intent.putExtra("chatType", Integer.valueOf((String) map.get("chatType")));
        }
        if (map.containsKey("updatePushName") && !TextUtils.isEmpty((CharSequence) map.get("updatePushName"))) {
            intent.putExtra("updatePushName", (String) map.get("updatePushName"));
        }
        if (map.containsKey("fromUpdatePush") && !TextUtils.isEmpty((CharSequence) map.get("fromUpdatePush"))) {
            intent.putExtra("fromUpdatePush", Boolean.valueOf((String) map.get("fromUpdatePush")));
        }
        if (map.containsKey("roomType") && !TextUtils.isEmpty((CharSequence) map.get("roomType"))) {
            intent.putExtra("roomType", Integer.parseInt((String) map.get("roomType")));
        }
    }

    /* renamed from: a */
    private boolean m6120a(Uri uri) {
        return m6124b(uri) || m6126c(uri);
    }

    /* renamed from: b */
    private boolean m6124b(Uri uri) {
        String host = uri.getHost();
        return "chats".equals(host) || (Config.CHATON_PACKAGE_NAME.equals(host) && "/chatlist".equals(uri.getPath()));
    }

    /* renamed from: c */
    private boolean m6126c(Uri uri) {
        String host = uri.getHost();
        return "chatroom".equals(host) || (Config.CHATON_PACKAGE_NAME.equals(host) && "/chat".equals(uri.getPath()));
    }
}
