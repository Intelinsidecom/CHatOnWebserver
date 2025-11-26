package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.audio.DialogC2747w;
import com.sec.chaton.multimedia.audio.VoiceListActivity;
import com.sec.chaton.util.C4822an;
import com.sec.widget.C5179v;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.cd */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1623cd implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6150a;

    DialogInterfaceOnClickListenerC1623cd(ChatFragment chatFragment) {
        this.f6150a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            this.f6150a.startActivityForResult(new Intent(this.f6150a.f5624cN, (Class<?>) VoiceListActivity.class), 9);
            return;
        }
        if (i == 1) {
            if (!C4822an.m18245m() || !C4822an.m18246n()) {
                C5179v.m19810a(this.f6150a.f5624cN, R.string.recordaudio_unable_to_record_during_call, 0).show();
            } else if (this.f6150a.m7957aB()) {
                this.f6150a.f5513aF = new DialogC2747w(this.f6150a.getActivity(), this.f6150a.f5712eA, null, this.f6150a.f5750v, true);
                this.f6150a.f5513aF.show();
            }
        }
    }
}
