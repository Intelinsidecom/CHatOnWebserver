package com.sec.chaton.poston;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.image.PostONImagePagerActivity;

/* loaded from: classes.dex */
public class PostONDetailActivity extends BaseSinglePaneActivity implements InterfaceC1982av {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        return new PostONDetailFragment();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // com.sec.chaton.poston.InterfaceC1982av
    /* renamed from: a */
    public void mo7922a(Uri uri) {
        if (PostONImagePagerActivity.class != 0) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(uri, "video/*");
            intent.putExtra("android.intent.extra.finishOnCompletion", false);
            startActivity(intent);
        }
    }

    @Override // com.sec.chaton.poston.InterfaceC1982av
    /* renamed from: a */
    public void mo7923a(String str, String str2) {
        if (GlobalApplication.m6456e()) {
            Intent intent = new Intent(this, (Class<?>) BuddyProfileActivity.class);
            intent.putExtra("PROFILE_BUDDY_NO", str);
            intent.putExtra("PROFILE_BUDDY_NAME", str2);
            intent.putExtra("ACTIVITY_PURPOSE_CALL_START_CHAT", 21);
            startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(this, (Class<?>) BuddyDialog.class);
        intent2.putExtra("BUDDY_DIALOG_BUDDY_NO", str);
        intent2.putExtra("BUDDY_DIALOG_BUDDY_NAME", str2);
        if (this instanceof Activity) {
            intent2.setFlags(67108864);
        } else {
            intent2.setFlags(335544320);
        }
        startActivity(intent2);
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        super.onResume();
        if (GlobalApplication.m6456e()) {
            BaseActivity.m3080a(this);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (GlobalApplication.m6456e()) {
            BaseActivity.m3080a(this);
        }
    }
}
