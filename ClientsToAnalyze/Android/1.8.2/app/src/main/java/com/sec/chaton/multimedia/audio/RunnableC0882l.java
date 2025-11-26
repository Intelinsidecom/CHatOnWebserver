package com.sec.chaton.multimedia.audio;

import com.sec.chaton.R;

/* compiled from: RecordAudio.java */
/* renamed from: com.sec.chaton.multimedia.audio.l */
/* loaded from: classes.dex */
class RunnableC0882l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0881k f3277a;

    RunnableC0882l(C0881k c0881k) {
        this.f3277a = c0881k;
    }

    @Override // java.lang.Runnable
    public void run() {
        RecordAudio.m3568a(this.f3277a.f3276b);
        RecordAudio.m3573b(this.f3277a.f3276b);
        if (this.f3277a.f3276b.f3254x >= this.f3277a.f3276b.f3256z) {
            this.f3277a.f3276b.f3254x = this.f3277a.f3276b.f3256z;
        }
        if (this.f3277a.f3276b.f3225D >= this.f3277a.f3276b.f3249s.getMax()) {
            this.f3277a.f3276b.f3234d.cancel();
            this.f3277a.f3276b.f3224C.cancel();
        }
        if (this.f3277a.f3276b.f3244n) {
            if (this.f3277a.f3276b.f3226E != null) {
                if (this.f3277a.f3276b.f3226E.isEnabled()) {
                    this.f3277a.f3276b.f3226E.setEnabled(false);
                    return;
                } else {
                    if (this.f3277a.f3276b.f3227F != null) {
                        this.f3277a.f3276b.f3226E.setEnabled(true);
                        this.f3277a.f3276b.f3227F.setTextColor(this.f3277a.f3276b.f3236f.getResources().getColor(R.color.chat_rec_on));
                        this.f3277a.f3276b.f3227F.setVisibility(0);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        this.f3277a.f3276b.f3226E.setEnabled(false);
        this.f3277a.f3276b.f3227F.setVisibility(4);
    }
}
