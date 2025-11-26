package com.sec.chaton.buddy;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.view.MenuItem;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.multimedia.image.PostONImagePagerActivity;
import java.util.List;

/* loaded from: classes.dex */
public class BuddyProfileActivity extends BaseSinglePaneActivity implements InterfaceC1328gh {

    /* renamed from: o */
    private static final String f3889o = BuddyProfileActivity.class.getSimpleName();

    /* renamed from: n */
    private int f3890n = 2;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public BuddyProfileFragment mo2967f() {
        getIntent().getExtras().getBoolean("PROFILE_BUDDY_FROM_CHATINFO", false);
        return new BuddyProfileFragment();
    }

    /* renamed from: a */
    public static boolean m6743a(Context context, Intent intent) {
        List<ResolveInfo> listQueryIntentActivities;
        return (context == null || (listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536)) == null || listQueryIntentActivities.size() <= 0) ? false : true;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.home:
                finish();
                break;
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    @Override // com.sec.chaton.buddy.InterfaceC1328gh
    /* renamed from: b */
    public void mo3088b(String str, String str2) {
        Intent intent = new Intent(this, (Class<?>) PostONImagePagerActivity.class);
        intent.putExtra("buddyId", str);
        intent.putExtra("url", str2);
        startActivity(intent);
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        m6159a(this);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m6159a(this);
    }
}
