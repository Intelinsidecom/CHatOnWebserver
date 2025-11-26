package com.sec.chaton.msgbox;

import android.view.View;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.chaton.msgbox.n */
/* loaded from: classes.dex */
class ViewOnClickListenerC0264n implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f2005a;

    ViewOnClickListenerC0264n(MsgboxFragment msgboxFragment) {
        this.f2005a = msgboxFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C0062R.id.btnCancel /* 2131427489 */:
                this.f2005a.m35d().setChoiceMode(0);
                this.f2005a.f1974m.setVisibility(8);
                this.f2005a.m35d().clearChoices();
                break;
            case C0062R.id.btnLeave /* 2131427828 */:
                String[] strArrM2427f = this.f2005a.m2427f();
                if (strArrM2427f.length > 0) {
                    this.f2005a.m2421a(strArrM2427f);
                    break;
                }
                break;
        }
    }
}
