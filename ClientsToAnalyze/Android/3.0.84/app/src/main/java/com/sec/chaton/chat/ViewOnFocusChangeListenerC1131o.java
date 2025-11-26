package com.sec.chaton.chat;

import android.os.Bundle;
import android.view.View;
import com.sec.chaton.p027e.EnumC1450r;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.o */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC1131o implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4547a;

    ViewOnFocusChangeListenerC1131o(ChatFragment chatFragment) {
        this.f4547a = chatFragment;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z && this.f4547a.f3709x == EnumC1450r.ONETOONE) {
            Bundle bundle = new Bundle();
            bundle.putString("ContextAwareUniqueID", this.f4547a.f3704s);
            this.f4547a.f3584bG.sendAppPrivateCommand(view, "COMMAND_CONTEXT_AWARE", bundle);
        }
    }
}
