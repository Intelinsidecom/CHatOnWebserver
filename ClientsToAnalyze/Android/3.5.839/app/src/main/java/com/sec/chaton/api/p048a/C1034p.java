package com.sec.chaton.api.p048a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.localbackup.ActivityLocalBackup;
import com.sec.chaton.registration.ActivityRegist;
import com.sec.chaton.settings.ActivityAboutService;
import com.sec.chaton.settings.ActivityAccount;
import com.sec.chaton.settings.ActivityChat;
import com.sec.chaton.settings.ActivityContactSync;
import com.sec.chaton.settings.ActivityDeregister;
import com.sec.chaton.settings.ActivityManageBuddy;
import com.sec.chaton.settings.ActivityMultiDeviceView;
import com.sec.chaton.settings.ActivityNoti2;
import com.sec.chaton.settings.ActivityPrivacy;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p112ui.SMSPreferenceActivity;
import com.sec.chaton.util.C4809aa;

/* compiled from: SettingLinkProcessor.java */
/* renamed from: com.sec.chaton.api.a.p */
/* loaded from: classes.dex */
public class C1034p extends AbstractC1019a {
    @Override // com.sec.chaton.api.p048a.AbstractC1019a
    /* renamed from: a */
    public boolean mo6112a(Activity activity, Intent intent) {
        intent.getExtras();
        Uri data = intent.getData();
        String action = intent.getAction();
        if (data != null && ("android.intent.action.VIEW".equals(action) || "android.intent.action.SEND".equals(action))) {
            String host = data.getHost();
            String path = data.getPath();
            if (host.equals("settings")) {
                if (path.equals("/managebuddy")) {
                    activity.startActivity(new Intent(activity, (Class<?>) ActivityManageBuddy.class));
                    return true;
                }
                if (path.equals("/privacy")) {
                    activity.startActivity(new Intent(activity, (Class<?>) ActivityPrivacy.class));
                    return true;
                }
                if (path.equals("/alerts")) {
                    activity.startActivity(new Intent(activity, (Class<?>) ActivityNoti2.class));
                    return true;
                }
                if (path.equals("/chat")) {
                    activity.startActivity(new Intent(activity, (Class<?>) ActivityChat.class));
                    return true;
                }
                if (path.equals("/connecteddevice")) {
                    activity.startActivity(new Intent(activity, (Class<?>) ActivityMultiDeviceView.class));
                    return true;
                }
                if (path.equals("/account")) {
                    activity.startActivity(new Intent(activity, (Class<?>) ActivityAccount.class));
                    return true;
                }
                if (path.equals("/backup")) {
                    activity.startActivity(new Intent(activity, (Class<?>) ActivityLocalBackup.class));
                    return true;
                }
                if (path.equals("/contactsync")) {
                    if (C2349a.m10301a("sms_feature")) {
                        activity.startActivity(new Intent(activity, (Class<?>) ActivityContactSync.class));
                        return true;
                    }
                    if (TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""))) {
                        activity.startActivity(new Intent(activity, (Class<?>) ActivityRegist.class));
                        return true;
                    }
                    activity.startActivity(new Intent(activity, (Class<?>) ActivityContactSync.class));
                    return true;
                }
                if (path.equals("/about")) {
                    activity.startActivity(new Intent(activity, (Class<?>) ActivityAboutService.class));
                    return true;
                }
                if (path.equals("/deregister")) {
                    activity.startActivity(new Intent(activity, (Class<?>) ActivityDeregister.class));
                    return true;
                }
                if (path.equals("/smsmms") && C2349a.m10301a("sms_feature") && C3847e.m14692ax()) {
                    activity.startActivity(new Intent(activity, (Class<?>) SMSPreferenceActivity.class));
                    return true;
                }
            }
        }
        return false;
    }
}
