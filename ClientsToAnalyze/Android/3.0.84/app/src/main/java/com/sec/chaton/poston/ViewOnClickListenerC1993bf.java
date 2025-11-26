package com.sec.chaton.poston;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bf */
/* loaded from: classes.dex */
class ViewOnClickListenerC1993bf implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f7708a;

    ViewOnClickListenerC1993bf(PostONWriteFragment postONWriteFragment) {
        this.f7708a = postONWriteFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f7708a.f7576B != null) {
            String string = this.f7708a.f7633y.getText().toString();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("http://maps.google.com/maps?q=loc:");
            stringBuffer.append(this.f7708a.f7576B);
            if (string != null) {
                stringBuffer.append("(").append(string.replaceAll("[\\(\\)]", " ")).append(")");
            }
            this.f7708a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(stringBuffer.toString())));
        }
    }
}
