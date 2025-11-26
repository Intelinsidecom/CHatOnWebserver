package com.sec.chaton.poston;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p020c.C0816a;
import com.sec.widget.C3641ai;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.as */
/* loaded from: classes.dex */
class ViewOnClickListenerC1979as implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONDetailFragment f7676a;

    ViewOnClickListenerC1979as(PostONDetailFragment postONDetailFragment) {
        this.f7676a = postONDetailFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C0816a.m4365a()) {
            C3641ai.m13210a(this.f7676a.f7560z, R.string.toast_googleMAP_unavailable, 0).show();
            return;
        }
        String str = (String) view.getTag();
        if (str != null) {
            String strM7967a = this.f7676a.m7967a(str);
            String string = ((TextView) view).getText().toString();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("http://maps.google.com/maps?q=loc:");
            stringBuffer.append(strM7967a);
            if (string != null) {
                stringBuffer.append("(").append(string.replaceAll("[\\(\\)]", " ")).append(")");
            }
            this.f7676a.getActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(stringBuffer.toString())));
        }
    }
}
