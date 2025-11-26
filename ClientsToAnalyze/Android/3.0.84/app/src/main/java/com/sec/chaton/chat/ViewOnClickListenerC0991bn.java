package com.sec.chaton.chat;

import android.view.View;
import android.widget.CheckedTextView;
import com.sec.chaton.R;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bn */
/* loaded from: classes.dex */
class ViewOnClickListenerC0991bn implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4061a;

    ViewOnClickListenerC0991bn(ChatFragment chatFragment) {
        this.f4061a = chatFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((CheckedTextView) view).isChecked()) {
            if (this.f4061a.f3527aC.m5288b().size() != 0 || this.f4061a.f3527aC.m5282a().size() != 0) {
                this.f4061a.f3552ab.findItem(R.id.chat_menu_delete_confirm).setEnabled(true);
            } else {
                this.f4061a.f3552ab.findItem(R.id.chat_menu_delete_confirm).setEnabled(false);
            }
            this.f4061a.f3568ar.setChecked(false);
            this.f4061a.f3527aC.m5293f();
        } else {
            this.f4061a.f3552ab.findItem(R.id.chat_menu_delete_confirm).setEnabled(true);
            this.f4061a.f3568ar.setChecked(true);
            this.f4061a.f3527aC.m5294g();
        }
        this.f4061a.f3526aB.invalidateViews();
    }
}
