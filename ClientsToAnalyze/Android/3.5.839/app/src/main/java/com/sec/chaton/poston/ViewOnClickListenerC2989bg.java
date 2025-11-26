package com.sec.chaton.poston;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bg */
/* loaded from: classes.dex */
class ViewOnClickListenerC2989bg implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f11104a;

    ViewOnClickListenerC2989bg(PostONWriteFragment postONWriteFragment) {
        this.f11104a = postONWriteFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f11104a.f10971C != null) {
            String string = this.f11104a.f11031z.getText().toString();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("http://maps.google.com/maps?q=loc:");
            stringBuffer.append(this.f11104a.f10971C);
            if (string != null) {
                stringBuffer.append("(").append(string.replaceAll("[\\(\\)]", " ")).append(")");
            }
            this.f11104a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(stringBuffer.toString())));
        }
    }
}
