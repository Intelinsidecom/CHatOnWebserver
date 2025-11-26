package com.sec.chaton.buddy;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;
import com.sec.chaton.settings.tellfriends.RenrenSubMenuActivity;
import com.sec.chaton.settings.tellfriends.TwitterSubMenuActivity;
import com.sec.chaton.settings.tellfriends.WeiboSubMenuActivity;
import com.sec.common.CommonApplication;
import com.sec.common.util.log.collector.C3358h;
import com.sec.widget.C3641ai;
import java.util.List;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.w */
/* loaded from: classes.dex */
class C0808w implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f3104a;

    C0808w(AddBuddyFragment addBuddyFragment) {
        this.f3104a = addBuddyFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) throws Resources.NotFoundException {
        String str = (String) adapterView.getAdapter().getItem(i);
        if (str.equals(this.f3104a.getString(R.string.tellfriends_via_message))) {
            if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                C3358h.m11842a().m11846a("00030025");
            }
            String string = this.f3104a.getResources().getString(R.string.setting_chaton_tell_friends_email_text, "\nwww.chaton.com/invite.html");
            PackageManager packageManager = CommonApplication.m11493l().getPackageManager();
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SENDTO").setAction("android.intent.action.VIEW").setData(Uri.parse("smsto:"));
            intent.hasCategory("android.intent.category.DEFAULT");
            intent.hasCategory("android.intent.category.BROWSABLE");
            intent.putExtra("sms_body", string);
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            if (listQueryIntentActivities == null || listQueryIntentActivities.size() <= 0) {
                C3641ai.m13211a(this.f3104a.f1676X, this.f3104a.getResources().getString(R.string.settings_push_status_unavailable), 0).show();
                return;
            } else {
                this.f3104a.startActivity(intent);
                return;
            }
        }
        if (str.equals(this.f3104a.getString(R.string.tellfriends_via_twitter))) {
            if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                C3358h.m11842a().m11846a("00030027");
            }
            this.f3104a.startActivity(new Intent(this.f3104a.f1676X, (Class<?>) TwitterSubMenuActivity.class));
        } else if (str.equals(this.f3104a.getString(R.string.tellfriends_via_weibo))) {
            if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                C3358h.m11842a().m11846a("00030028");
            }
            this.f3104a.startActivity(new Intent(this.f3104a.f1676X, (Class<?>) WeiboSubMenuActivity.class));
        } else if (str.equals(this.f3104a.getString(R.string.tellfriends_via_renren))) {
            if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                C3358h.m11842a().m11846a("00030028");
            }
            this.f3104a.startActivity(new Intent(this.f3104a.f1676X, (Class<?>) RenrenSubMenuActivity.class));
        }
    }
}
