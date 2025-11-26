package com.sec.chaton.buddy;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cq */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC0436cq implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1428a;

    ViewOnFocusChangeListenerC0436cq(BuddyFragment buddyFragment) {
        this.f1428a = buddyFragment;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        this.f1428a.f1166x.setLongClickable(z);
        if (z) {
            this.f1428a.f1164v = true;
            this.f1428a.f1162t.setButtonImageResource(R.drawable.general_btn_icon_complete_xml);
            if (this.f1428a.f1166x.getText().toString().replaceAll(" ", "").replaceAll("\n", "").replaceAll(",", "").length() == 0) {
                this.f1428a.f1162t.setButtonEnabled(false);
                return;
            } else {
                this.f1428a.f1162t.setButtonEnabled(true);
                return;
            }
        }
        this.f1428a.f1162t.setButtonImageResource(R.drawable.general_btn_down_arrow_xml);
        this.f1428a.f1164v = false;
        this.f1428a.f1162t.setButtonEnabled(true);
    }
}
