package com.sec.chaton.multimedia.audio;

import android.view.View;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1786r;
import java.io.IOException;

/* compiled from: RecordAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.x */
/* loaded from: classes.dex */
class ViewOnClickListenerC0894x implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f3289a;

    ViewOnClickListenerC0894x(RecordAudio recordAudio) {
        this.f3289a = recordAudio;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (!C1721ad.m5887n() || !C1721ad.m5888o()) {
            Toast.makeText(this.f3289a.f3236f, R.string.recordaudio_unable_to_record_during_call, 0).show();
            return;
        }
        if (this.f3289a.f3243m) {
            this.f3289a.f3244n = true;
            this.f3289a.f3243m = false;
            this.f3289a.f3237g.setClickable(false);
            this.f3289a.m3571a();
            this.f3289a.m3602n();
            this.f3289a.f3231J.requestAudioFocus(this.f3289a.f3232K, 3, 1);
            try {
                this.f3289a.f3250t.start();
                this.f3289a.m3579c();
                this.f3289a.f3248r = true;
                this.f3289a.f3235e.sendEmptyMessage(100);
                if (this.f3289a.f3247q) {
                    this.f3289a.f3242l.setBackgroundResource(R.drawable.record_voice_bg_highlight);
                } else {
                    this.f3289a.f3242l.setBackgroundResource(R.drawable.record_voice_bg_highlight);
                }
                this.f3289a.f3237g.setImageResource(R.drawable.recorder_player_stop);
                this.f3289a.f3249s.setEnabled(false);
                this.f3289a.f3228G.setVisibility(0);
                return;
            } catch (IllegalStateException e) {
                C1786r.m6056a(e, getClass().getName());
                Toast.makeText(this.f3289a.f3236f, R.string.toast_error, 0).show();
                this.f3289a.f3243m = true;
                this.f3289a.f3244n = false;
                this.f3289a.f3237g.setClickable(true);
                return;
            }
        }
        if (!this.f3289a.f3244n) {
            if (!this.f3289a.f3245o) {
                if (this.f3289a.f3251u != null) {
                    if (this.f3289a.f3247q) {
                        this.f3289a.f3242l.setBackgroundResource(R.drawable.chaton_chats_attach_record_mic);
                    } else {
                        this.f3289a.f3242l.setBackgroundResource(R.drawable.chaton_chats_attach_record_mic);
                    }
                    this.f3289a.f3237g.setImageResource(R.drawable.recorder_player_stop);
                    try {
                        this.f3289a.f3251u.seekTo(0);
                    } catch (IllegalStateException e2) {
                        C1786r.m6056a(e2, getClass().getName());
                        Toast.makeText(this.f3289a.f3236f, R.string.toast_error, 0).show();
                    } catch (NullPointerException e3) {
                        C1786r.m6054a("media player null", getClass().getName());
                        return;
                    }
                    this.f3289a.m3602n();
                    this.f3289a.f3231J.requestAudioFocus(this.f3289a.f3232K, 3, 1);
                    this.f3289a.f3249s.setEnabled(true);
                    this.f3289a.f3245o = true;
                    this.f3289a.f3251u.start();
                    this.f3289a.f3248r = true;
                    this.f3289a.f3235e.sendEmptyMessage(100);
                    this.f3289a.f3226E.setEnabled(true);
                    this.f3289a.f3228G.setVisibility(0);
                    return;
                }
                C1786r.m6054a("media player null", getClass().getName());
                return;
            }
            if (this.f3289a.f3245o) {
                if (this.f3289a.f3247q) {
                    this.f3289a.f3242l.setBackgroundResource(R.drawable.chaton_chats_attach_record_mic);
                } else {
                    this.f3289a.f3242l.setBackgroundResource(R.drawable.chaton_chats_attach_record_mic);
                }
                this.f3289a.f3237g.setImageResource(R.drawable.recorder_player_play);
                this.f3289a.f3254x = 0;
                this.f3289a.f3225D = 0;
                this.f3289a.f3255y = this.f3289a.f3256z;
                this.f3289a.m3575b();
                this.f3289a.f3245o = false;
                this.f3289a.f3248r = false;
                this.f3289a.f3249s.setEnabled(false);
                this.f3289a.f3249s.setProgress(0);
                this.f3289a.f3249s.setPressed(false);
                try {
                    this.f3289a.f3251u.stop();
                } catch (Exception e4) {
                    C1786r.m6056a(e4, getClass().getName());
                    Toast.makeText(this.f3289a.f3236f, R.string.toast_error, 0).show();
                }
                try {
                    this.f3289a.f3251u.prepare();
                } catch (Exception e5) {
                    C1786r.m6056a(e5, getClass().getName());
                    if (this.f3289a.f3251u != null) {
                        this.f3289a.f3251u.reset();
                        this.f3289a.m3585e();
                    } else {
                        C1786r.m6054a("media player null", getClass().getName());
                        return;
                    }
                }
                this.f3289a.f3226E.setEnabled(true);
                this.f3289a.f3227F.setTextColor(this.f3289a.f3236f.getResources().getColor(R.color.chat_rec_on));
                return;
            }
            return;
        }
        if (GlobalApplication.m3265f()) {
        }
        this.f3289a.f3234d.cancel();
        this.f3289a.f3224C.cancel();
        if (this.f3289a.f3247q) {
            this.f3289a.f3242l.setBackgroundResource(R.drawable.chaton_chats_attach_record_mic);
        } else {
            this.f3289a.f3242l.setBackgroundResource(R.drawable.chaton_chats_attach_record_mic);
        }
        this.f3289a.f3237g.setImageResource(R.drawable.recorder_player_play);
        this.f3289a.f3248r = false;
        this.f3289a.f3249s.setProgress(0);
        this.f3289a.f3249s.setPressed(false);
        this.f3289a.f3244n = false;
        this.f3289a.f3245o = false;
        this.f3289a.f3250t.stop();
        this.f3289a.f3250t.release();
        this.f3289a.f3250t = null;
        this.f3289a.m3585e();
        this.f3289a.f3254x = 0;
        this.f3289a.f3225D = 0;
        this.f3289a.f3226E.setEnabled(true);
        this.f3289a.f3227F.setTextColor(this.f3289a.f3236f.getResources().getColor(R.color.chat_rec_on));
        this.f3289a.m3575b();
        try {
            this.f3289a.f3241k.setText(String.format("%d:%02d", Integer.valueOf(this.f3289a.f3251u.getDuration() / 60000), Integer.valueOf((this.f3289a.f3251u.getDuration() / 1000) % 60)));
            this.f3289a.f3239i.setVisibility(0);
        } catch (NullPointerException e6) {
            C1786r.m6056a(e6, getClass().getName());
        }
    }
}
