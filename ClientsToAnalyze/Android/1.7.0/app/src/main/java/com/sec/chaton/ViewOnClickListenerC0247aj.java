package com.sec.chaton;

import android.view.View;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p013a.p014a.C0184w;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;

/* compiled from: ExitAppDialogActivity.java */
/* renamed from: com.sec.chaton.aj */
/* loaded from: classes.dex */
class ViewOnClickListenerC0247aj implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ExitAppDialogActivity f594a;

    ViewOnClickListenerC0247aj(ExitAppDialogActivity exitAppDialogActivity) {
        this.f594a = exitAppDialogActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f594a.f246a == 0) {
            try {
                C0184w.m724b();
            } catch (Exception e) {
                C1341p.m4653a(e, getClass().getSimpleName());
            }
            this.f594a.finish();
            GlobalApplication.m3104b(this.f594a);
            return;
        }
        C1323bs.m4575a().edit().remove("exit_app_done").commit();
        this.f594a.finish();
        GlobalApplication.m3102a(this.f594a);
    }
}
