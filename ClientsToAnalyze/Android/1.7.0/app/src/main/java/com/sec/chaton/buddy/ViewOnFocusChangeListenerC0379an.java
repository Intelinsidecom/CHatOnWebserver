package com.sec.chaton.buddy;

import android.view.View;
import com.sec.chaton.R;

/* compiled from: BuddyGroupProfileActivity.java */
/* renamed from: com.sec.chaton.buddy.an */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC0379an implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupProfileActivity f1347a;

    ViewOnFocusChangeListenerC0379an(BuddyGroupProfileActivity buddyGroupProfileActivity) {
        this.f1347a = buddyGroupProfileActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.f1347a.f1194t = true;
            this.f1347a.f1180e.setButtonImageResource(R.drawable.general_btn_icon_complete_xml);
            this.f1347a.f1180e.setButtonEnabled(false);
        } else {
            this.f1347a.f1194t = false;
            this.f1347a.f1180e.setButtonImageResource(R.drawable.general_btn_down_arrow_xml);
        }
    }
}
