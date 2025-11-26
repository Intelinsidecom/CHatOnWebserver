package com.sec.chaton.localbackup.chatview;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.audio.AsyncTaskC1776h;

/* compiled from: BackupPlayVoiceTask.java */
/* renamed from: com.sec.chaton.localbackup.chatview.b */
/* loaded from: classes.dex */
public class AsyncTaskC1621b extends AsyncTaskC1776h {
    public AsyncTaskC1621b(View view, String str, long j) {
        super(view, str, j, true);
    }

    @Override // com.sec.chaton.multimedia.audio.AsyncTaskC1776h
    /* renamed from: a */
    protected void mo6904a() {
        if (this.f6569a != null) {
            C1625f c1625f = (C1625f) this.f6569a.getTag();
            this.f6577i = c1625f.f6070i;
            if (this.f6577i == this.f6570b) {
                this.f6571c = c1625f.f6062a;
                this.f6572d = c1625f.f6064c;
                this.f6571c.setImageResource(R.drawable.chat_push_to_talk_play);
                this.f6576h = (AnimationDrawable) this.f6571c.getDrawable();
                if (this.f6576h != null && !this.f6576h.isRunning()) {
                    this.f6576h.start();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.multimedia.audio.AsyncTaskC1776h, android.os.AsyncTask
    /* renamed from: a */
    public void onProgressUpdate(Integer... numArr) {
        if (this.f6569a != null) {
            this.f6577i = ((C1625f) this.f6569a.getTag()).f6070i;
            if (this.f6577i == this.f6570b) {
                String str = String.format("%d:%02d/%d:%02d", Integer.valueOf(numArr[0].intValue() / 60000), Integer.valueOf((numArr[0].intValue() / 1000) % 60), Integer.valueOf(this.f6574f), Integer.valueOf(this.f6575g));
                if (this.f6572d != null) {
                    this.f6572d.setText(str);
                }
            }
        }
    }

    @Override // com.sec.chaton.multimedia.audio.AsyncTaskC1776h
    /* renamed from: b */
    protected void mo6906b() {
        C1620a.m6897a().m6902b();
    }
}
