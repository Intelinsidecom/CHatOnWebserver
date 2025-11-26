package com.sec.chaton.multimedia.audio;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import java.util.Timer;

/* compiled from: PlayAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.e */
/* loaded from: classes.dex */
class ViewOnClickListenerC0875e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Button f3266a;

    /* renamed from: b */
    final /* synthetic */ PlayAudio f3267b;

    ViewOnClickListenerC0875e(PlayAudio playAudio, Button button) {
        this.f3267b = playAudio;
        this.f3266a = button;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException {
        try {
            this.f3266a.setEnabled(false);
            this.f3267b.f3214g.start();
            this.f3267b.f3219l = this.f3267b.f3218k;
            this.f3267b.m3550a();
            this.f3267b.f3212e = new Timer(true);
            this.f3267b.f3212e.schedule(new C0876f(this, new Handler()), 1000L, 1000L);
        } catch (Exception e) {
            C1786r.m6056a(e, getClass().getName());
            Toast.makeText(this.f3267b.f3213f, R.string.toast_error, 1).show();
        }
    }
}
