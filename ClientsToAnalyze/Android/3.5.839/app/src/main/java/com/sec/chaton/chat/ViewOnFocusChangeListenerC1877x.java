package com.sec.chaton.chat;

import android.os.Bundle;
import android.view.View;
import com.sec.chaton.p057e.EnumC2300t;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.x */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC1877x implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f7095a;

    ViewOnFocusChangeListenerC1877x(ChatFragment chatFragment) {
        this.f7095a = chatFragment;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z && this.f7095a.f5487D == EnumC2300t.ONETOONE) {
            Bundle bundle = new Bundle();
            bundle.putString("ContextAwareUniqueID", this.f7095a.f5752x);
            this.f7095a.f5643cg.sendAppPrivateCommand(view, "COMMAND_CONTEXT_AWARE", bundle);
        }
    }
}
