package com.sec.chaton.buddy;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.p000io.entry.inner.Buddy;
import com.sec.chaton.util.ChatOnGraphics;

/* loaded from: classes.dex */
public class ViewProfileImage extends BaseActivity {

    /* renamed from: b */
    private Context f603b;

    /* renamed from: c */
    private LinearLayout f604c;

    /* renamed from: d */
    private ImageView f605d;

    /* renamed from: e */
    private Button f606e;

    /* renamed from: f */
    private Button f607f;

    /* renamed from: g */
    private ProgressDialog f608g = null;

    /* renamed from: a */
    View.OnClickListener f602a = new ViewOnClickListenerC0087ak(this);

    /* renamed from: a */
    private void m644a() {
        this.f604c = (LinearLayout) findViewById(C0062R.id.profile_holder);
        this.f605d = (ImageView) findViewById(C0062R.id.profile_big_image);
        this.f606e = (Button) findViewById(C0062R.id.profile_save);
        this.f606e.setOnClickListener(this.f602a);
        this.f606e.setEnabled(false);
        this.f607f = (Button) findViewById(C0062R.id.profile_cancel);
        this.f607f.setOnClickListener(this.f602a);
        this.f607f.setEnabled(false);
        if (getIntent().getExtras().getInt("PROFILE_BUDDY_BIGIMAGE_STATUS") == Buddy.BuddyImageStatus.PROFILE_UPDATED.getCode() || getIntent().getExtras().getInt("PROFILE_BUDDY_BIGIMAGE_STATUS") == Buddy.BuddyImageStatus.NOT_CHANGE.getCode()) {
            this.f608g = ProgressDialog.show(this.f603b, null, getResources().getString(C0062R.string.buddy_list_progress_dialog_message), true);
            ChatOnGraphics.m3539a(getIntent().getExtras().getString("PROFILE_BUDDY_NO"), new C0086aj(this));
        } else {
            Toast.makeText(this.f603b, C0062R.string.view_profileiamge_download_toast_failed_notfound, 0).show();
            this.f607f.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m646b() {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            this.f603b.sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0062R.layout.view_profile_image_layout);
        this.f603b = this;
        m644a();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }
}
