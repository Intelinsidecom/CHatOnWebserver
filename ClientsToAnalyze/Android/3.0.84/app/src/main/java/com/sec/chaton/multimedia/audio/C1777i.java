package com.sec.chaton.multimedia.audio;

import com.sec.chaton.util.C3250y;
import java.util.TimerTask;

/* compiled from: PlayVoiceTask.java */
/* renamed from: com.sec.chaton.multimedia.audio.i */
/* loaded from: classes.dex */
class C1777i extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC1776h f6585a;

    C1777i(AsyncTaskC1776h asyncTaskC1776h) {
        this.f6585a = asyncTaskC1776h;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            if (this.f6585a.f6580m != null && this.f6585a.f6582o) {
                this.f6585a.publishProgress(Integer.valueOf(this.f6585a.f6580m.getCurrentPosition()));
                C3250y.m11450b("CurrentPosition : " + this.f6585a.f6580m.getCurrentPosition(), AsyncTaskC1776h.f6568j);
            }
        } catch (Exception e) {
            C3250y.m11443a(e, AsyncTaskC1776h.f6568j);
        }
    }
}
