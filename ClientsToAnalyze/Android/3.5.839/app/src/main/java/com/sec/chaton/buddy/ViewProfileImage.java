package com.sec.chaton.buddy;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.multimedia.image.ViewOnTouchListenerC2837av;
import com.sec.chaton.p065io.entry.inner.Buddy;
import com.sec.chaton.util.C4812ad;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.widget.C5179v;

/* loaded from: classes.dex */
public class ViewProfileImage extends BaseActivity {

    /* renamed from: n */
    public static final String f4195n = ViewProfileImage.class.getSimpleName();

    /* renamed from: o */
    private Activity f4196o;

    /* renamed from: p */
    private ImageView f4197p;

    /* renamed from: q */
    private ProgressDialog f4198q = null;

    /* renamed from: r */
    private Bitmap f4199r = null;

    /* renamed from: s */
    private ViewOnTouchListenerC2837av f4200s;

    /* renamed from: t */
    private ViewTreeObserver.OnGlobalLayoutListener f4201t;

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.view_profile_image_layout);
        this.f4196o = this;
        m7025f();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        m6159a((Activity) this);
        if (this.f4197p != null) {
            ViewTreeObserver viewTreeObserver = this.f4197p.getViewTreeObserver();
            this.f4201t = new ViewTreeObserverOnGlobalLayoutListenerC1402ja(this);
            viewTreeObserver.addOnGlobalLayoutListener(this.f4201t);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        m6159a((Activity) this);
        if (this.f4198q != null) {
            this.f4198q.dismiss();
        }
        this.f4198q = null;
        m7025f();
        super.onConfigurationChanged(configuration);
    }

    /* renamed from: f */
    private void m7025f() {
        this.f4197p = (ImageView) findViewById(R.id.profile_big_image);
        this.f4200s = new ViewOnTouchListenerC2837av();
        if (getIntent().getExtras().getInt("PROFILE_BUDDY_BIGIMAGE_STATUS") == Buddy.BuddyImageStatus.PROFILE_UPDATED.getCode() || getIntent().getExtras().getInt("PROFILE_BUDDY_BIGIMAGE_STATUS") == Buddy.BuddyImageStatus.NOT_CHANGE.getCode() || getIntent().getExtras().getInt("PROFILE_BUDDY_BIGIMAGE_STATUS") == Buddy.BuddyImageStatus.PROFILE_DELETED.getCode()) {
            this.f4198q = ProgressDialogC4926s.m18728a(this.f4196o, null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
            C4812ad.m18154a(getIntent().getExtras().getString("PROFILE_BUDDY_NO"), new C1403jb(this));
        } else {
            C5179v.m19810a(this.f4196o, R.string.view_profileiamge_download_toast_failed_notfound, 0).show();
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.f4197p != null) {
            this.f4197p.getViewTreeObserver().removeGlobalOnLayoutListener(this.f4201t);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
