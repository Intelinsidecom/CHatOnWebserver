package com.sec.chaton.userprofile;

import android.view.View;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2130k;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.util.C4904y;

/* compiled from: SetCoverstoryFragment.java */
/* renamed from: com.sec.chaton.userprofile.cm */
/* loaded from: classes.dex */
class ViewOnClickListenerC4781cm implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SetCoverstoryFragment f17498a;

    ViewOnClickListenerC4781cm(SetCoverstoryFragment setCoverstoryFragment) {
        this.f17498a = setCoverstoryFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C4904y.f17872b) {
            C4904y.m18639b("SetCoverstoryFragment [url] : " + this.f17498a.f17368i + ", #### [filename] : " + this.f17498a.f17369j + ", #### [id] : " + this.f17498a.f17370k, getClass().getSimpleName());
        }
        switch (view.getId()) {
            case R.id.button1 /* 2131165821 */:
                int iM10677a = C2471v.m10677a(this.f17498a.getActivity());
                if (-3 != iM10677a && -2 != iM10677a) {
                    this.f17498a.f17372m.show();
                    this.f17498a.f17373o = new C2130k(this.f17498a.f17377s);
                    this.f17498a.f17373o.m9542b(this.f17498a.f17370k);
                    this.f17498a.f17372m.show();
                    break;
                } else {
                    Toast.makeText(this.f17498a.getActivity(), R.string.popup_no_network_connection, 0).show();
                    break;
                }
                break;
        }
    }
}
