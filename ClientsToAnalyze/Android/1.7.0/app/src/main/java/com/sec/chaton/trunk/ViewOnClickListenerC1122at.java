package com.sec.chaton.trunk;

import android.view.View;
import android.widget.EditText;
import com.sec.chaton.R;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.at */
/* loaded from: classes.dex */
class ViewOnClickListenerC1122at implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f3933a;

    ViewOnClickListenerC1122at(TrunkItemView trunkItemView) {
        this.f3933a = trunkItemView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f3933a.f3803f != null) {
            this.f3933a.f3803f.mo3965b_();
        }
        if (this.f3933a.f3800c != null) {
            this.f3933a.f3801d = (EditText) this.f3933a.f3802e.findViewById(R.id.trunkCommentEdit);
            if (this.f3933a.f3801d != null) {
                this.f3933a.f3800c.hideSoftInputFromWindow(this.f3933a.f3801d.getWindowToken(), 0);
            }
        }
    }
}
