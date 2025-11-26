package com.sec.chaton.chat;

import android.view.View;
import com.sec.chaton.multimedia.emoticon.anicon.C1821k;
import com.sec.chaton.util.C3197bl;
import java.io.IOException;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bk */
/* loaded from: classes.dex */
class ViewOnClickListenerC0988bk implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4058a;

    ViewOnClickListenerC0988bk(ChatFragment chatFragment) {
        this.f4058a = chatFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (!C3197bl.m11159a()) {
            C1821k.m7478a().m7482a(this.f4058a.f3606bc);
        }
    }
}
