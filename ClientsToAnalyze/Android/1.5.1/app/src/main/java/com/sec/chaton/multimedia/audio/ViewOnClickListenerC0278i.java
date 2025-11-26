package com.sec.chaton.multimedia.audio;

import android.view.View;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;
import java.io.IOException;

/* renamed from: com.sec.chaton.multimedia.audio.i */
/* loaded from: classes.dex */
class ViewOnClickListenerC0278i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f2086a;

    ViewOnClickListenerC0278i(RecordAudio recordAudio) {
        this.f2086a = recordAudio;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (this.f2086a.f2063m) {
            this.f2086a.f2064n = true;
            this.f2086a.f2063m = false;
            this.f2086a.f2056f.setClickable(false);
            this.f2086a.m2468a();
            this.f2086a.f2070t.start();
            this.f2086a.m2476c();
            this.f2086a.f2068r = true;
            this.f2086a.f2054d.sendEmptyMessage(100);
            if (this.f2086a.f2067q) {
                this.f2086a.f2061k.setBackgroundResource(C0062R.drawable.record_voice_recoding_h);
            } else {
                this.f2086a.f2061k.setBackgroundResource(C0062R.drawable.record_voice_recoding);
            }
            this.f2086a.f2056f.setBackgroundResource(C0062R.drawable.recorder_player_stop);
            this.f2086a.f2069s.setEnabled(false);
            return;
        }
        if (this.f2086a.f2064n) {
            this.f2086a.f2053c.cancel();
            if (this.f2086a.f2067q) {
                this.f2086a.f2061k.setBackgroundResource(C0062R.drawable.record_voice_bg_h);
            } else {
                this.f2086a.f2061k.setBackgroundResource(C0062R.drawable.record_voice_bg);
            }
            this.f2086a.f2056f.setBackgroundResource(C0062R.drawable.recorder_player_play);
            this.f2086a.f2062l.setVisibility(8);
            this.f2086a.f2068r = false;
            this.f2086a.f2069s.setProgress(0);
            this.f2086a.f2064n = false;
            this.f2086a.f2065o = false;
            this.f2086a.f2070t.stop();
            this.f2086a.f2070t.release();
            this.f2086a.f2070t = null;
            this.f2086a.m2482e();
            this.f2086a.f2074x = 0;
            this.f2086a.m2472b();
            this.f2086a.f2058h.setVisibility(0);
            return;
        }
        if (!this.f2086a.f2065o) {
            if (this.f2086a.f2067q) {
                this.f2086a.f2061k.setBackgroundResource(C0062R.drawable.record_voice_bg_h);
            } else {
                this.f2086a.f2061k.setBackgroundResource(C0062R.drawable.record_voice_bg);
            }
            this.f2086a.f2056f.setBackgroundResource(C0062R.drawable.recorder_player_stop);
            try {
                this.f2086a.f2071u.seekTo(0);
            } catch (IllegalStateException e) {
                ChatONLogWriter.m3501a(e, getClass().getName());
                Toast.makeText(this.f2086a.f2055e, C0062R.string.toast_error, 0).show();
            }
            this.f2086a.f2071u.start();
            this.f2086a.f2069s.setEnabled(true);
            this.f2086a.f2065o = true;
            this.f2086a.m2476c();
            this.f2086a.f2068r = true;
            this.f2086a.f2054d.sendEmptyMessage(100);
            return;
        }
        if (this.f2086a.f2065o) {
            this.f2086a.f2053c.cancel();
            if (this.f2086a.f2067q) {
                this.f2086a.f2061k.setBackgroundResource(C0062R.drawable.record_voice_bg_h);
            } else {
                this.f2086a.f2061k.setBackgroundResource(C0062R.drawable.record_voice_bg);
            }
            this.f2086a.f2056f.setBackgroundResource(C0062R.drawable.recorder_player_play);
            this.f2086a.f2062l.setVisibility(8);
            this.f2086a.f2074x = 0;
            this.f2086a.f2075y = this.f2086a.f2076z;
            this.f2086a.m2472b();
            this.f2086a.f2065o = false;
            this.f2086a.f2068r = false;
            this.f2086a.f2069s.setEnabled(false);
            this.f2086a.f2069s.setProgress(0);
            try {
                this.f2086a.f2071u.stop();
            } catch (Exception e2) {
                ChatONLogWriter.m3501a(e2, getClass().getName());
                Toast.makeText(this.f2086a.f2055e, C0062R.string.toast_error, 0).show();
            }
            try {
                this.f2086a.f2071u.prepare();
            } catch (Exception e3) {
                ChatONLogWriter.m3501a(e3, getClass().getName());
                this.f2086a.f2071u.reset();
                this.f2086a.m2482e();
            }
        }
    }
}
