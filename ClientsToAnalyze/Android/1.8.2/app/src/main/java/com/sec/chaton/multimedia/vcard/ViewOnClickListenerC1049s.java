package com.sec.chaton.multimedia.vcard;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: VCardReadContactActivity.java */
/* renamed from: com.sec.chaton.multimedia.vcard.s */
/* loaded from: classes.dex */
class ViewOnClickListenerC1049s implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ VCardReadContactActivity f3903a;

    ViewOnClickListenerC1049s(VCardReadContactActivity vCardReadContactActivity) {
        this.f3903a = vCardReadContactActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() == null || !view.getTag().equals("selected")) {
            this.f3903a.f3827u.setImageResource(R.drawable.check_select);
            view.setTag("selected");
            for (int i = 0; this.f3903a.f3818l.size() > i; i++) {
                ((C1039i) this.f3903a.f3818l.get(i)).f3860f = true;
            }
            this.f3903a.f3820n = this.f3903a.f3818l.size();
            if (this.f3903a.f3811b != null) {
                this.f3903a.f3811b.notifyDataSetChanged();
            }
            this.f3903a.f3826t.setEnabled(true);
            return;
        }
        view.setTag("unselected");
        this.f3903a.f3827u.setImageResource(R.drawable.check_normal);
        for (int i2 = 0; this.f3903a.f3818l.size() > i2; i2++) {
            ((C1039i) this.f3903a.f3818l.get(i2)).f3860f = false;
        }
        this.f3903a.f3820n = 0;
        if (this.f3903a.f3811b != null) {
            this.f3903a.f3811b.notifyDataSetChanged();
        }
        this.f3903a.f3826t.setEnabled(false);
    }
}
