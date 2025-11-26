package com.sec.chaton.multimedia.audio;

import android.media.AudioManager;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C1336k;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1346u;
import com.sec.widget.C1619g;
import java.io.IOException;

/* compiled from: RecordAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.j */
/* loaded from: classes.dex */
class ViewOnClickListenerC0773j implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f2668a;

    ViewOnClickListenerC0773j(RecordAudio recordAudio) {
        this.f2668a = recordAudio;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (!C1346u.m4677a(800L)) {
            if (!C1336k.m4631h() || !C1336k.m4632i()) {
                C1619g.m5888a(this.f2668a.f2633f, R.string.recordaudio_unable_to_record_during_call, 0).show();
                return;
            }
            if (this.f2668a.f2640m) {
                AudioManager audioManager = this.f2668a.f2628J;
                AudioManager unused = this.f2668a.f2628J;
                audioManager.setStreamMute(5, true);
                this.f2668a.f2641n = true;
                this.f2668a.f2640m = false;
                this.f2668a.f2634g.setClickable(false);
                this.f2668a.m3229a();
                this.f2668a.m3260n();
                this.f2668a.f2628J.requestAudioFocus(this.f2668a.f2629K, 3, 1);
                try {
                    this.f2668a.f2647t.start();
                    this.f2668a.m3237c();
                    this.f2668a.f2645r = true;
                    this.f2668a.f2632e.sendEmptyMessage(100);
                    if (this.f2668a.f2644q) {
                        this.f2668a.f2639l.setBackgroundResource(R.drawable.record_voice_bg_highlight_h);
                    } else {
                        this.f2668a.f2639l.setBackgroundResource(R.drawable.record_voice_bg_highlight);
                    }
                    this.f2668a.f2634g.setImageResource(R.drawable.recorder_player_stop);
                    this.f2668a.f2625G.setVisibility(0);
                    return;
                } catch (IllegalStateException e) {
                    C1341p.m4653a(e, getClass().getName());
                    C1619g.m5888a(this.f2668a.f2633f, R.string.toast_error, 0).show();
                    this.f2668a.f2640m = true;
                    this.f2668a.f2641n = false;
                    this.f2668a.f2634g.setClickable(true);
                    return;
                } catch (Exception e2) {
                    C1341p.m4653a(e2, getClass().getName());
                    C1619g.m5888a(this.f2668a.f2633f, R.string.toast_error, 0).show();
                    this.f2668a.f2641n = false;
                    this.f2668a.finish();
                    return;
                }
            }
            if (this.f2668a.f2641n) {
                AudioManager audioManager2 = this.f2668a.f2628J;
                AudioManager unused2 = this.f2668a.f2628J;
                audioManager2.setStreamMute(5, false);
                this.f2668a.f2631d.cancel();
                this.f2668a.f2621C.cancel();
                if (this.f2668a.f2644q) {
                    this.f2668a.f2639l.setBackgroundResource(R.drawable.record_voice_bg_h);
                } else {
                    this.f2668a.f2639l.setBackgroundResource(R.drawable.record_voice_bg);
                }
                this.f2668a.f2634g.setImageResource(R.drawable.recorder_player_play);
                this.f2668a.f2645r = false;
                this.f2668a.f2646s.setProgress(0);
                this.f2668a.f2646s.setPressed(false);
                this.f2668a.f2641n = false;
                this.f2668a.f2642o = false;
                this.f2668a.f2647t.stop();
                this.f2668a.f2647t.release();
                this.f2668a.f2647t = null;
                this.f2668a.m3243e();
                this.f2668a.f2651x = 0;
                this.f2668a.f2622D = 0;
                this.f2668a.f2623E.setEnabled(false);
                this.f2668a.m3233b();
                try {
                    this.f2668a.f2638k.setText(String.format("%d:%02d", Integer.valueOf(this.f2668a.f2648u.getDuration() / 60000), Integer.valueOf((this.f2668a.f2648u.getDuration() / 1000) % 60)));
                    this.f2668a.f2636i.setVisibility(0);
                    return;
                } catch (NullPointerException e3) {
                    C1341p.m4653a(e3, getClass().getName());
                    return;
                }
            }
            if (!this.f2668a.f2642o) {
                if (this.f2668a.f2648u != null) {
                    if (this.f2668a.f2644q) {
                        this.f2668a.f2639l.setBackgroundResource(R.drawable.record_voice_bg_h);
                    } else {
                        this.f2668a.f2639l.setBackgroundResource(R.drawable.record_voice_bg);
                    }
                    this.f2668a.f2634g.setImageResource(R.drawable.recorder_player_stop);
                    try {
                        this.f2668a.f2648u.seekTo(0);
                    } catch (IllegalStateException e4) {
                        C1341p.m4653a(e4, getClass().getName());
                        C1619g.m5888a(this.f2668a.f2633f, R.string.toast_error, 0).show();
                    }
                    this.f2668a.m3260n();
                    this.f2668a.f2628J.requestAudioFocus(this.f2668a.f2629K, 3, 1);
                    this.f2668a.f2642o = true;
                    this.f2668a.f2648u.start();
                    this.f2668a.f2645r = true;
                    this.f2668a.f2632e.sendEmptyMessage(100);
                    this.f2668a.f2623E.setEnabled(false);
                    this.f2668a.f2625G.setVisibility(0);
                    this.f2668a.f2628J.setStreamMute(5, true);
                    return;
                }
                C1341p.m4651a("Media player null", getClass().getName());
                return;
            }
            if (this.f2668a.f2642o) {
                if (this.f2668a.f2644q) {
                    this.f2668a.f2639l.setBackgroundResource(R.drawable.record_voice_bg_h);
                } else {
                    this.f2668a.f2639l.setBackgroundResource(R.drawable.record_voice_bg);
                }
                this.f2668a.f2634g.setImageResource(R.drawable.recorder_player_play);
                this.f2668a.f2651x = 0;
                this.f2668a.f2622D = 0;
                this.f2668a.f2652y = this.f2668a.f2653z;
                this.f2668a.m3233b();
                this.f2668a.f2642o = false;
                this.f2668a.f2645r = false;
                this.f2668a.f2646s.setProgress(0);
                this.f2668a.f2646s.setPressed(false);
                try {
                    this.f2668a.f2648u.stop();
                } catch (Exception e5) {
                    C1341p.m4653a(e5, getClass().getName());
                    C1619g.m5888a(this.f2668a.f2633f, R.string.toast_error, 0).show();
                }
                try {
                    this.f2668a.f2648u.prepare();
                } catch (Exception e6) {
                    C1341p.m4653a(e6, getClass().getName());
                    this.f2668a.f2648u.reset();
                    this.f2668a.m3243e();
                }
                this.f2668a.f2623E.setEnabled(false);
                this.f2668a.f2625G.setVisibility(4);
                this.f2668a.f2628J.setStreamMute(5, false);
            }
        }
    }
}
