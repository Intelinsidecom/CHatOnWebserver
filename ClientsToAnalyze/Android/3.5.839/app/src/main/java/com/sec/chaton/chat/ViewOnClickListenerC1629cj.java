package com.sec.chaton.chat;

import android.view.View;
import com.sec.chaton.multimedia.emoticon.anicon.C2780l;
import com.sec.chaton.util.C4847bl;
import java.io.IOException;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cj */
/* loaded from: classes.dex */
class ViewOnClickListenerC1629cj implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6156a;

    ViewOnClickListenerC1629cj(ChatFragment chatFragment) {
        this.f6156a = chatFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (!C4847bl.m18333a()) {
            C2780l.m11679a().m11683a(this.f6156a.f5609by);
        }
    }
}
