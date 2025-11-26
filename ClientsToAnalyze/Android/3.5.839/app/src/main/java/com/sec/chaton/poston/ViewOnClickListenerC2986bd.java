package com.sec.chaton.poston;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bd */
/* loaded from: classes.dex */
class ViewOnClickListenerC2986bd implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f11101a;

    ViewOnClickListenerC2986bd(PostONWriteFragment postONWriteFragment) {
        this.f11101a = postONWriteFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C4904y.m18646e("mVideoButton Click", "PostONWriteFragment");
        if (this.f11101a.f10987S.size() >= 1) {
            if (this.f11101a.f11030y.getVisibility() == 8) {
                this.f11101a.f10991W.setVisibility(0);
                this.f11101a.f11029x.setVisibility(8);
                this.f11101a.f11030y.setVisibility(0);
            } else if (this.f11101a.f10991W.getVisibility() == 0) {
                this.f11101a.f11030y.setVisibility(8);
            } else {
                this.f11101a.f11029x.setVisibility(8);
                this.f11101a.f10991W.setVisibility(0);
            }
        } else {
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("video/*");
            try {
                this.f11101a.startActivityForResult(intent, 6);
            } catch (ActivityNotFoundException e) {
                C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, "PostONWriteFragment");
                }
            }
        }
        this.f11101a.m12299a(this.f11101a.f11028w, false);
    }
}
