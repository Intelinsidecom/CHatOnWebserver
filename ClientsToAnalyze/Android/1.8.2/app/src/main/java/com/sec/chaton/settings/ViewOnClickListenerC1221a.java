package com.sec.chaton.settings;

import android.content.Context;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p015d.C0629as;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.ProgressDialogC1806j;

/* compiled from: AboutFragment.java */
/* renamed from: com.sec.chaton.settings.a */
/* loaded from: classes.dex */
class ViewOnClickListenerC1221a implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AboutFragment f4760a;

    ViewOnClickListenerC1221a(AboutFragment aboutFragment) {
        this.f4760a = aboutFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean zM4476a = AboutFragment.m4476a((Context) this.f4760a.getActivity(), true);
        C1786r.m6066e("isApps :" + zM4476a, getClass().getSimpleName());
        if (zM4476a) {
            if (this.f4760a.getActivity() != null) {
                this.f4760a.f4453k = ProgressDialogC1806j.m6141a(this.f4760a.getActivity(), null, this.f4760a.getResources().getString(R.string.buddy_list_progress_dialog_message), true);
            }
            new C0629as(this.f4760a.f4448f).m2833b();
            return;
        }
        this.f4760a.getActivity().finish();
    }
}
