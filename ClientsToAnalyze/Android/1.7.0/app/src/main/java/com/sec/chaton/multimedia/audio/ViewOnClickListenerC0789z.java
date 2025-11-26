package com.sec.chaton.multimedia.audio;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import com.sec.chaton.R;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;
import java.util.Timer;

/* compiled from: PlayAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.z */
/* loaded from: classes.dex */
class ViewOnClickListenerC0789z implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Button f2688a;

    /* renamed from: b */
    final /* synthetic */ PlayAudio f2689b;

    ViewOnClickListenerC0789z(PlayAudio playAudio, Button button) {
        this.f2689b = playAudio;
        this.f2688a = button;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException {
        try {
            this.f2688a.setEnabled(false);
            this.f2689b.f2611g.start();
            this.f2689b.f2616l = this.f2689b.f2615k;
            this.f2689b.m3210a();
            this.f2689b.f2609e = new Timer(true);
            this.f2689b.f2609e.schedule(new C0782s(this, new Handler()), 1000L, 1000L);
        } catch (Exception e) {
            C1341p.m4653a(e, getClass().getName());
            C1619g.m5888a(this.f2689b.f2610f, R.string.toast_error, 1).show();
        }
    }
}
