package com.sec.chaton.chat;

import android.view.View;
import android.view.Window;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.audio.DialogC2747w;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4873ck;
import com.sec.widget.C5179v;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.n */
/* loaded from: classes.dex */
class ViewOnLongClickListenerC1792n implements View.OnLongClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6706a;

    ViewOnLongClickListenerC1792n(ChatFragment chatFragment) {
        this.f6706a = chatFragment;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!C4822an.m18245m() || !C4822an.m18246n()) {
            C5179v.m19810a(this.f6706a.f5624cN, R.string.recordaudio_unable_to_record_during_call, 0).show();
        } else if (!C4873ck.m18500a()) {
            C5179v.m19810a(this.f6706a.f5624cN, R.string.sdcard_not_found, 0).show();
        } else if (this.f6706a.m7957aB() && (this.f6706a.f5513aF == null || !this.f6706a.f5513aF.isShowing())) {
            this.f6706a.f5527aT.setItemsCanFocus(false);
            this.f6706a.f5564bF.requestFocus();
            this.f6706a.f5662cz.requestFocus();
            this.f6706a.f5662cz.setPressed(true);
            this.f6706a.f5496M = true;
            this.f6706a.f5611cA.setVisibility(0);
            this.f6706a.f5513aF = new DialogC2747w(this.f6706a.getActivity(), this.f6706a.f5712eA, view, this.f6706a.f5750v, false);
            Window window = this.f6706a.f5513aF.getWindow();
            window.clearFlags(2);
            window.setFlags(32, 32);
            window.setFlags(8, 8);
            this.f6706a.f5513aF.show();
            this.f6706a.m8124c(false);
        }
        return true;
    }
}
