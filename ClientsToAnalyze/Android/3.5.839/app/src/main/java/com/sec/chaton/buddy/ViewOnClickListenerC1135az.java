package com.sec.chaton.buddy;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.buddy.dialog.MeDialog;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.az */
/* loaded from: classes.dex */
class ViewOnClickListenerC1135az implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4353a;

    ViewOnClickListenerC1135az(BuddyFragment buddyFragment) {
        this.f4353a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.f4353a.getActivity(), (Class<?>) MeDialog.class);
        intent.putExtra("ME_DIALOG_NAME", this.f4353a.f3702bg.getText());
        intent.putExtra("ME_DIALOG_STATUSMSG", this.f4353a.f3703bh.getText());
        this.f4353a.getActivity().startActivity(intent);
    }
}
