package com.sec.chaton.chat;

import android.view.View;
import android.widget.CheckedTextView;
import com.sec.chaton.R;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cm */
/* loaded from: classes.dex */
class ViewOnClickListenerC1632cm implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6159a;

    ViewOnClickListenerC1632cm(ChatFragment chatFragment) {
        this.f6159a = chatFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((CheckedTextView) view).isChecked()) {
            if (this.f6159a.f5528aU.m8573d().size() != 0 || this.f6159a.f5528aU.m8570c().size() != 0) {
                this.f6159a.f5547ap.findItem(R.id.chat_menu_delete_confirm).setEnabled(true);
            } else {
                this.f6159a.f5547ap.findItem(R.id.chat_menu_delete_confirm).setEnabled(false);
            }
            this.f6159a.f5517aJ.setChecked(false);
            this.f6159a.f5528aU.m8581j();
        } else {
            this.f6159a.f5547ap.findItem(R.id.chat_menu_delete_confirm).setEnabled(true);
            this.f6159a.f5517aJ.setChecked(true);
            this.f6159a.f5528aU.m8582k();
        }
        this.f6159a.f5527aT.invalidateViews();
    }
}
