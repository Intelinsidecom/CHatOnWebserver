package com.sec.chaton.util;

import android.view.View;
import android.widget.CheckBox;

/* compiled from: ChatONFileUtil.java */
/* renamed from: com.sec.chaton.util.q */
/* loaded from: classes.dex */
final class ViewOnClickListenerC4896q implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CheckBox f17856a;

    ViewOnClickListenerC4896q(CheckBox checkBox) {
        this.f17856a = checkBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C4904y.f17872b) {
            C4904y.m18639b("neverShow : " + this.f17856a.isChecked(), C4894o.f17852a);
        }
        C4809aa.m18104a().m18125b("file_upload_warning_check", Boolean.valueOf(this.f17856a.isChecked()));
    }
}
