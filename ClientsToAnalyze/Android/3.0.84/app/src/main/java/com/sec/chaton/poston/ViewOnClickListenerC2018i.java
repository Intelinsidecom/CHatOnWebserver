package com.sec.chaton.poston;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p027e.p028a.C1352aa;
import com.sec.widget.C3641ai;

/* compiled from: PostONAdapter.java */
/* renamed from: com.sec.chaton.poston.i */
/* loaded from: classes.dex */
class ViewOnClickListenerC2018i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C2013d f7756a;

    ViewOnClickListenerC2018i(C2013d c2013d) {
        this.f7756a = c2013d;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C0816a.m4365a()) {
            C3641ai.m13210a(this.f7756a.f7742g, R.string.toast_googleMAP_unavailable, 0).show();
            return;
        }
        C1352aa c1352aa = (C1352aa) view.getTag();
        if (c1352aa != null) {
            String strM8043b = this.f7756a.m8043b(c1352aa);
            String string = ((TextView) view).getText().toString();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("http://maps.google.com/maps?q=loc:");
            stringBuffer.append(strM8043b);
            if (string != null) {
                stringBuffer.append("(").append(string.replaceAll("[\\(\\)]", " ")).append(")");
            }
            this.f7756a.f7742g.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(stringBuffer.toString())));
        }
    }
}
