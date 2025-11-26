package com.sec.chaton.msgbox;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.p */
/* loaded from: classes.dex */
class ViewOnClickListenerC0751p implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f2555a;

    ViewOnClickListenerC0751p(MsgboxFragment msgboxFragment) {
        this.f2555a = msgboxFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCancel /* 2131427469 */:
                this.f2555a.getListView().setChoiceMode(0);
                this.f2555a.f2499e.setVisibility(8);
                this.f2555a.getListView().clearChoices();
                break;
            case R.id.btnLeave /* 2131427917 */:
                String[] strArrM3151d = this.f2555a.m3151d();
                if (strArrM3151d.length > 0) {
                    this.f2555a.m3147a(strArrM3151d);
                    break;
                }
                break;
        }
    }
}
