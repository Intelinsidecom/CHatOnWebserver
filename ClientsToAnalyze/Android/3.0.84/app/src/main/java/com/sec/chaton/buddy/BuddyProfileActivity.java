package com.sec.chaton.buddy;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.MenuItem;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.image.PostONImagePagerActivity;

/* loaded from: classes.dex */
public class BuddyProfileActivity extends BaseSinglePaneActivity implements InterfaceC0696fg {

    /* renamed from: b */
    private static final String f1997b = BuddyProfileActivity.class.getSimpleName();

    /* renamed from: a */
    private int f1998a = 2;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public BuddyProfileFragment mo1193a() throws Resources.NotFoundException {
        if (getIntent().getExtras().getBoolean("PROFILE_BUDDY_FROM_CHATINFO", false) && GlobalApplication.m6456e()) {
            BaseActivity.m3080a(this);
        }
        return new BuddyProfileFragment();
    }

    /* renamed from: a */
    public static boolean m3573a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.home:
                finish();
                break;
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    @Override // com.sec.chaton.buddy.InterfaceC0696fg, com.sec.chaton.userprofile.InterfaceC3112bk
    /* renamed from: b */
    public void mo1320b(String str, String str2) {
        Intent intent = new Intent(this, (Class<?>) PostONImagePagerActivity.class);
        intent.putExtra("buddyId", str);
        intent.putExtra("url", str2);
        startActivity(intent);
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        m3080a(this);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m3080a(this);
    }
}
