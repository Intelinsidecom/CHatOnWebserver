package com.sec.chaton.multimedia.audio;

import android.widget.SeekBar;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.pns.msg.MsgResultCode;

/* renamed from: com.sec.chaton.multimedia.audio.k */
/* loaded from: classes.dex */
class C0280k implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f2088a;

    C0280k(RecordAudio recordAudio) {
        this.f2088a = recordAudio;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        this.f2088a.m2472b();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        ChatONLogWriter.m3509d("onStartTrackingTouch!!!!");
        ChatONLogWriter.m3509d("seekBar.getDrawingTime():" + seekBar.getDrawingTime());
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) throws IllegalStateException, NumberFormatException {
        ChatONLogWriter.m3509d("onStopTrackingTouch!!!!");
        ChatONLogWriter.m3509d("seekBar.getProgress():" + seekBar.getProgress());
        ChatONLogWriter.m3509d("seekBar.getProgress():" + seekBar.getProgress());
        ChatONLogWriter.m3509d("mediaPlayer.getCurrentPosition():" + this.f2088a.f2071u.getCurrentPosition());
        if (seekBar.getProgress() < 10) {
            this.f2088a.f2071u.seekTo(MsgResultCode.SUCCESS);
            this.f2088a.f2069s.setProgress(10);
            this.f2088a.f2074x = 1;
            this.f2088a.f2075y = this.f2088a.f2076z - 1;
            this.f2088a.m2472b();
        } else {
            int i = Integer.parseInt(Integer.toString(seekBar.getProgress()).substring(0, Integer.toString(seekBar.getProgress()).length() - 1));
            this.f2088a.f2071u.seekTo(i * MsgResultCode.SUCCESS);
            this.f2088a.f2069s.setProgress(i * 10);
            this.f2088a.f2074x = i - 1;
            this.f2088a.f2075y = (this.f2088a.f2076z - i) + 1;
            this.f2088a.m2472b();
        }
        this.f2088a.f2071u.seekTo(this.f2088a.f2071u.getCurrentPosition());
    }
}
