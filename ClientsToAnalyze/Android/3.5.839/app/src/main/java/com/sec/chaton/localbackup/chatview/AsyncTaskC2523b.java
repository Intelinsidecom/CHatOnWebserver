package com.sec.chaton.localbackup.chatview;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.audio.AsyncTaskC2728d;

/* compiled from: BackupPlayVoiceTask.java */
/* renamed from: com.sec.chaton.localbackup.chatview.b */
/* loaded from: classes.dex */
public class AsyncTaskC2523b extends AsyncTaskC2728d {
    public AsyncTaskC2523b(View view, String str, long j) {
        super(view, str, j, true);
    }

    @Override // com.sec.chaton.multimedia.audio.AsyncTaskC2728d
    /* renamed from: a */
    protected void mo10934a() {
        if (this.f9775a != null) {
            C2527f c2527f = (C2527f) this.f9775a.getTag();
            this.f9783i = c2527f.f9114i;
            if (this.f9783i == this.f9776b) {
                this.f9777c = c2527f.f9106a;
                this.f9778d = c2527f.f9108c;
                this.f9777c.setImageResource(R.drawable.chat_push_to_talk_play);
                this.f9782h = (AnimationDrawable) this.f9777c.getDrawable();
                if (this.f9782h != null && !this.f9782h.isRunning()) {
                    this.f9782h.start();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.multimedia.audio.AsyncTaskC2728d, android.os.AsyncTask
    /* renamed from: a */
    public void onProgressUpdate(Integer... numArr) {
        if (this.f9775a != null) {
            this.f9783i = ((C2527f) this.f9775a.getTag()).f9114i;
            if (this.f9783i == this.f9776b) {
                String str = String.format("%d:%02d/%d:%02d", Integer.valueOf(numArr[0].intValue() / 60000), Integer.valueOf((numArr[0].intValue() / 1000) % 60), Integer.valueOf(this.f9780f), Integer.valueOf(this.f9781g));
                if (this.f9778d != null) {
                    this.f9778d.setText(str);
                }
            }
        }
    }

    @Override // com.sec.chaton.multimedia.audio.AsyncTaskC2728d
    /* renamed from: b */
    protected void mo10936b() {
        C2522a.m10927a().m10932b();
    }
}
