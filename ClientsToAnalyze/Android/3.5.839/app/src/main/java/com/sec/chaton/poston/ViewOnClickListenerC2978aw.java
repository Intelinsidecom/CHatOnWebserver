package com.sec.chaton.poston;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p051c.C1427a;
import com.sec.widget.C5179v;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.aw */
/* loaded from: classes.dex */
class ViewOnClickListenerC2978aw implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONDetailFragment f11075a;

    ViewOnClickListenerC2978aw(PostONDetailFragment postONDetailFragment) {
        this.f11075a = postONDetailFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C1427a.m7518a()) {
            C5179v.m19810a(this.f11075a.f10887B, R.string.toast_googleMAP_unavailable, 0).show();
            return;
        }
        String str = (String) view.getTag();
        if (str != null) {
            String strM12226b = this.f11075a.m12226b(str);
            String string = ((TextView) view).getText().toString();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("http://maps.google.com/maps?q=loc:");
            if (strM12226b != null) {
                stringBuffer.append(strM12226b);
            }
            if (string != null) {
                stringBuffer.append("(").append(string.replaceAll("[\\(\\)]", " ")).append(")");
            }
            this.f11075a.getActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(stringBuffer.toString())));
        }
    }
}
