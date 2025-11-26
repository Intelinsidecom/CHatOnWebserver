package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;
import java.io.UnsupportedEncodingException;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.fc */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2260fc implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2249es f8556a;

    DialogInterfaceOnClickListenerC2260fc(HandlerC2249es handlerC2249es) {
        this.f8556a = handlerC2249es;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws UnsupportedEncodingException {
        this.f8556a.f8544a.m8613a(this.f8556a.f8544a.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8556a.f8544a.getActivity().getResources().getString(R.string.auto_regi_buddy_sync), this.f8556a.f8544a.f8329q);
        this.f8556a.f8544a.f8325m.m5717a();
    }
}
