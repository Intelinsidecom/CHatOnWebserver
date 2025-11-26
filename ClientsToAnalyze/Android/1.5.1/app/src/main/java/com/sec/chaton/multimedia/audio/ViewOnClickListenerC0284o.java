package com.sec.chaton.multimedia.audio;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;
import java.io.IOException;

/* renamed from: com.sec.chaton.multimedia.audio.o */
/* loaded from: classes.dex */
class ViewOnClickListenerC0284o implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Button f2093a;

    /* renamed from: b */
    final /* synthetic */ PlayAudio f2094b;

    ViewOnClickListenerC0284o(PlayAudio playAudio, Button button) {
        this.f2094b = playAudio;
        this.f2093a = button;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException, IOException {
        try {
            this.f2093a.setEnabled(true);
            this.f2094b.f2043g.stop();
            this.f2094b.f2043g.prepare();
            this.f2094b.f2041e.cancel();
            this.f2094b.m2455a();
        } catch (Exception e) {
            ChatONLogWriter.m3501a(e, getClass().getName());
            Toast.makeText(this.f2094b.f2042f, C0062R.string.toast_error, 1).show();
        }
    }
}
