package com.sec.chaton.buddy;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.p033io.entry.inner.Buddy;
import com.sec.chaton.util.C1294aq;
import com.sec.chaton.widget.ProgressDialogC1354a;
import com.sec.widget.C1619g;

/* loaded from: classes.dex */
public class ViewProfileImage extends BaseActivity {

    /* renamed from: a */
    public static final String f1264a = ViewProfileImage.class.getSimpleName();

    /* renamed from: b */
    private Context f1265b;

    /* renamed from: c */
    private ImageView f1266c;

    /* renamed from: d */
    private ProgressDialog f1267d = null;

    /* renamed from: e */
    private Bitmap f1268e = null;

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.view_profile_image_layout);
        this.f1265b = this;
        m2304a();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (this.f1267d != null) {
            this.f1267d.dismiss();
        }
        this.f1267d = null;
        m2304a();
        super.onConfigurationChanged(configuration);
    }

    /* renamed from: a */
    private void m2304a() {
        this.f1266c = (ImageView) findViewById(R.id.profile_big_image);
        if (getIntent().getExtras().getInt("PROFILE_BUDDY_BIGIMAGE_STATUS") == Buddy.BuddyImageStatus.PROFILE_UPDATED.getCode() || getIntent().getExtras().getInt("PROFILE_BUDDY_BIGIMAGE_STATUS") == Buddy.BuddyImageStatus.NOT_CHANGE.getCode()) {
            this.f1267d = ProgressDialogC1354a.m4724a(this.f1265b, null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
            C1294aq.m4509a(getIntent().getExtras().getString("PROFILE_BUDDY_NO"), new C0412bt(this));
        } else {
            C1619g.m5888a(this.f1265b, R.string.view_profileiamge_download_toast_failed_notfound, 0).show();
        }
    }
}
