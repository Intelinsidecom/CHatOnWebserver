package com.sec.chaton.buddy;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.multimedia.image.ViewOnTouchListenerC1868as;
import com.sec.chaton.p035io.entry.inner.Buddy;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.widget.C3641ai;

/* loaded from: classes.dex */
public class ViewProfileImage extends BaseActivity {

    /* renamed from: a */
    public static final String f2345a = ViewProfileImage.class.getSimpleName();

    /* renamed from: b */
    private Context f2346b;

    /* renamed from: c */
    private ImageView f2347c;

    /* renamed from: d */
    private ProgressDialog f2348d = null;

    /* renamed from: e */
    private Bitmap f2349e = null;

    /* renamed from: f */
    private ViewOnTouchListenerC1868as f2350f;

    /* renamed from: g */
    private ViewTreeObserver.OnGlobalLayoutListener f2351g;

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.view_profile_image_layout);
        this.f2346b = this;
        m3946a();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        m3080a((Activity) this);
        if (this.f2347c != null) {
            ViewTreeObserver viewTreeObserver = this.f2347c.getViewTreeObserver();
            this.f2351g = new ViewTreeObserverOnGlobalLayoutListenerC0792iv(this);
            viewTreeObserver.addOnGlobalLayoutListener(this.f2351g);
        }
        m3948b();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        m3080a((Activity) this);
        if (this.f2348d != null) {
            this.f2348d.dismiss();
        }
        this.f2348d = null;
        m3946a();
        super.onConfigurationChanged(configuration);
    }

    /* renamed from: a */
    private void m3946a() {
        this.f2347c = (ImageView) findViewById(R.id.profile_big_image);
        this.f2350f = new ViewOnTouchListenerC1868as();
        if (getIntent().getExtras().getInt("PROFILE_BUDDY_BIGIMAGE_STATUS") == Buddy.BuddyImageStatus.PROFILE_UPDATED.getCode() || getIntent().getExtras().getInt("PROFILE_BUDDY_BIGIMAGE_STATUS") == Buddy.BuddyImageStatus.NOT_CHANGE.getCode() || getIntent().getExtras().getInt("PROFILE_BUDDY_BIGIMAGE_STATUS") == Buddy.BuddyImageStatus.PROFILE_DELETED.getCode()) {
            this.f2348d = ProgressDialogC3265l.m11490a(this.f2346b, null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
            C3162ad.m11009a(getIntent().getExtras().getString("PROFILE_BUDDY_NO"), new C0793iw(this));
        } else {
            C3641ai.m13210a(this.f2346b, R.string.view_profileiamge_download_toast_failed_notfound, 0).show();
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.f2347c != null) {
            this.f2347c.getViewTreeObserver().removeGlobalOnLayoutListener(this.f2351g);
        }
    }

    /* renamed from: b */
    private void m3948b() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
