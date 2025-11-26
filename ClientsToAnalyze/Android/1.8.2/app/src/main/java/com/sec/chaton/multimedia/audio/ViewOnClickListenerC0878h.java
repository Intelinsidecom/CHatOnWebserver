package com.sec.chaton.multimedia.audio;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import java.io.IOException;

/* compiled from: PlayAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.h */
/* loaded from: classes.dex */
class ViewOnClickListenerC0878h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Button f3271a;

    /* renamed from: b */
    final /* synthetic */ PlayAudio f3272b;

    ViewOnClickListenerC0878h(PlayAudio playAudio, Button button) {
        this.f3272b = playAudio;
        this.f3271a = button;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException, IOException {
        try {
            this.f3271a.setEnabled(true);
            this.f3272b.f3214g.stop();
            this.f3272b.f3214g.prepare();
            this.f3272b.f3212e.cancel();
            this.f3272b.m3550a();
        } catch (Exception e) {
            C1786r.m6056a(e, getClass().getName());
            Toast.makeText(this.f3272b.f3213f, R.string.toast_error, 1).show();
        }
    }
}
