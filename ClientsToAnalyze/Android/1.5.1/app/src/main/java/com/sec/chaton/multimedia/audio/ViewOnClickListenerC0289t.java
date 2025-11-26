package com.sec.chaton.multimedia.audio;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;
import java.util.Timer;

/* renamed from: com.sec.chaton.multimedia.audio.t */
/* loaded from: classes.dex */
class ViewOnClickListenerC0289t implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Button f2100a;

    /* renamed from: b */
    final /* synthetic */ PlayAudio f2101b;

    ViewOnClickListenerC0289t(PlayAudio playAudio, Button button) {
        this.f2101b = playAudio;
        this.f2100a = button;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException {
        try {
            this.f2100a.setEnabled(false);
            this.f2101b.f2043g.start();
            this.f2101b.f2048l = this.f2101b.f2047k;
            this.f2101b.m2455a();
            this.f2101b.f2041e = new Timer(true);
            this.f2101b.f2041e.schedule(new C0282m(this, new Handler()), 1000L, 1000L);
        } catch (Exception e) {
            ChatONLogWriter.m3501a(e, getClass().getName());
            Toast.makeText(this.f2101b.f2042f, C0062R.string.toast_error, 1).show();
        }
    }
}
