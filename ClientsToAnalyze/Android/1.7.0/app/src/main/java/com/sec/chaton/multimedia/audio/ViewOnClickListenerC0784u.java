package com.sec.chaton.multimedia.audio;

import android.view.View;
import android.widget.Button;
import com.sec.chaton.R;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;
import java.io.IOException;

/* compiled from: PlayAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.u */
/* loaded from: classes.dex */
class ViewOnClickListenerC0784u implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Button f2681a;

    /* renamed from: b */
    final /* synthetic */ PlayAudio f2682b;

    ViewOnClickListenerC0784u(PlayAudio playAudio, Button button) {
        this.f2682b = playAudio;
        this.f2681a = button;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException, IOException {
        try {
            this.f2681a.setEnabled(true);
            this.f2682b.f2611g.stop();
            this.f2682b.f2611g.prepare();
            this.f2682b.f2609e.cancel();
            this.f2682b.m3210a();
        } catch (Exception e) {
            C1341p.m4653a(e, getClass().getName());
            C1619g.m5888a(this.f2682b.f2610f, R.string.toast_error, 1).show();
        }
    }
}
