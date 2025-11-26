package com.sec.chaton.smsplugin.p112ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p110g.C3869o;

/* compiled from: SlideEditorActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.hx */
/* loaded from: classes.dex */
class ViewOnClickListenerC4304hx implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SlideEditorActivity f15698a;

    ViewOnClickListenerC4304hx(SlideEditorActivity slideEditorActivity) {
        this.f15698a = slideEditorActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C3869o c3869o = this.f15698a.f15110i.get(this.f15698a.f15114m);
        if (c3869o != null && c3869o.m14867g()) {
            Toast.makeText(this.f15698a, R.string.cannot_add_picture_and_video, 0).show();
            return;
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT", (Uri) null);
        intent.setType("image/*");
        this.f15698a.startActivityForResult(intent, 1);
    }
}
