package com.sec.chaton.poston;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p057e.p058a.C2179ae;
import com.sec.chaton.util.C4847bl;
import com.sec.widget.C5179v;

/* compiled from: PostONAdapter.java */
/* renamed from: com.sec.chaton.poston.i */
/* loaded from: classes.dex */
class ViewOnClickListenerC3014i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3009d f11152a;

    ViewOnClickListenerC3014i(C3009d c3009d) {
        this.f11152a = c3009d;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18333a()) {
            if (!C1427a.m7518a()) {
                C5179v.m19810a(this.f11152a.f11138g, R.string.toast_googleMAP_unavailable, 0).show();
                return;
            }
            C2179ae c2179ae = (C2179ae) view.getTag();
            if (c2179ae != null) {
                String strM12363b = this.f11152a.m12363b(c2179ae);
                String string = ((TextView) view).getText().toString();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("http://maps.google.com/maps?q=loc:");
                if (strM12363b != null) {
                    stringBuffer.append(strM12363b);
                }
                if (string != null) {
                    stringBuffer.append("(").append(string.replaceAll("[\\(\\)]", " ")).append(")");
                }
                this.f11152a.f11138g.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(stringBuffer.toString())));
            }
        }
    }
}
