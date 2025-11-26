package com.sec.chaton.multimedia.audio;

import android.view.View;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.multimedia.audio.j */
/* loaded from: classes.dex */
class ViewOnClickListenerC0279j implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f2087a;

    ViewOnClickListenerC0279j(RecordAudio recordAudio) {
        this.f2087a = recordAudio;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException {
        RecordAudio recordAudio;
        if (this.f2087a.f2063m) {
            this.f2087a.finish();
            return;
        }
        this.f2087a.f2053c.cancel();
        this.f2087a.f2058h.setVisibility(4);
        if (this.f2087a.f2067q) {
            this.f2087a.f2061k.setBackgroundResource(C0062R.drawable.record_voice_bg_h);
        } else {
            this.f2087a.f2061k.setBackgroundResource(C0062R.drawable.record_voice_bg);
        }
        this.f2087a.f2062l.setVisibility(8);
        if (this.f2087a.f2071u != null) {
            try {
                try {
                    this.f2087a.f2071u.stop();
                    this.f2087a.f2071u.release();
                    recordAudio = this.f2087a;
                } catch (Exception e) {
                    ChatONLogWriter.m3501a(e, getClass().getName());
                    Toast.makeText(this.f2087a.f2055e, C0062R.string.toast_error, 1).show();
                    this.f2087a.f2071u.release();
                    recordAudio = this.f2087a;
                }
                recordAudio.f2071u = null;
            } catch (Throwable th) {
                this.f2087a.f2071u.release();
                this.f2087a.f2071u = null;
                throw th;
            }
        }
        if (this.f2087a.f2064n) {
            this.f2087a.f2070t.stop();
            this.f2087a.f2070t.release();
        }
        this.f2087a.f2056f.setClickable(true);
        this.f2087a.f2063m = true;
        this.f2087a.f2064n = false;
        this.f2087a.f2065o = false;
        this.f2087a.f2068r = false;
        this.f2087a.f2069s.setEnabled(false);
        this.f2087a.f2069s.setProgress(0);
        this.f2087a.f2074x = 0;
        this.f2087a.f2075y = 120;
        this.f2087a.f2076z = 120;
        this.f2087a.m2472b();
        this.f2087a.f2069s.setMax(947);
        this.f2087a.f2056f.setBackgroundResource(C0062R.drawable.recorder_player_recoding);
    }
}
