package com.sec.chaton.multimedia.p078a;

import android.content.ActivityNotFoundException;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: GlympseInstallDialog.java */
/* renamed from: com.sec.chaton.multimedia.a.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC2720b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DialogC2719a f9743a;

    ViewOnClickListenerC2720b(DialogC2719a dialogC2719a) {
        this.f9743a = dialogC2719a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            this.f9743a.getContext().startActivity(C2722d.m11407a());
        } catch (ActivityNotFoundException e) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
            if (C4904y.f17875e) {
                C4904y.m18635a(e, getClass().getSimpleName());
            }
        }
        this.f9743a.dismiss();
    }
}
