package com.sec.chaton.buddy;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p050a.C1106c;
import java.util.ArrayList;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ax */
/* loaded from: classes.dex */
class ViewOnClickListenerC1133ax implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4351a;

    ViewOnClickListenerC1133ax(BuddyFragment buddyFragment) {
        this.f4351a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        boolean z = !this.f4351a.f3616W.isChecked();
        if (z) {
            this.f4351a.m6565t();
        } else {
            this.f4351a.m6595b(true);
        }
        this.f4351a.f3616W.setChecked(z);
        if (this.f4351a.f3660ao != 23 || this.f4351a.m6605h() == 0) {
            this.f4351a.f3739cc.setVisibility(8);
            return;
        }
        this.f4351a.f3739cc.setVisibility(0);
        this.f4351a.f3653ah = (ImageButton) this.f4351a.getView().findViewById(R.id.button_chatonvoice);
        this.f4351a.f3654ai = (ImageButton) this.f4351a.getView().findViewById(R.id.button_chatonvideo);
        if (this.f4351a.m6557p() != 1) {
            this.f4351a.f3653ah.setVisibility(8);
            this.f4351a.f3654ai.setVisibility(8);
        } else {
            boolean z2 = false;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < this.f4351a.m6604g().length; i3++) {
                if (BuddyFragment.f3584j.get(this.f4351a.m6604g()[i3]) != null) {
                    i2++;
                    i++;
                } else {
                    z2 = true;
                }
            }
            if (i2 > this.f4351a.f3720bz - 1 || z2) {
                this.f4351a.f3653ah.setVisibility(8);
                this.f4351a.f3654ai.setVisibility(8);
            }
        }
        this.f4351a.f3655aj = (ImageButton) this.f4351a.getView().findViewById(R.id.button_sms);
        this.f4351a.f3656ak = (ImageButton) this.f4351a.getView().findViewById(R.id.button_call);
        boolean z3 = false;
        for (int i4 = 0; i4 < this.f4351a.m6604g().length; i4++) {
            if (TextUtils.isEmpty(this.f4351a.m6341a(this.f4351a.m6604g()[i4], (ArrayList<ArrayList<C1106c>>) this.f4351a.f3666au).m7044G())) {
                z3 = true;
            }
        }
        if (z3) {
            this.f4351a.f3655aj.setVisibility(8);
            this.f4351a.f3656ak.setVisibility(8);
        }
    }
}
