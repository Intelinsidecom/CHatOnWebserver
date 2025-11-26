package com.sec.chaton.chat;

import android.os.AsyncTask;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.audio.AsyncTaskC1779k;
import com.sec.chaton.multimedia.audio.C1770b;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3223ck;
import com.sec.common.util.C3347i;
import com.sec.widget.C3641ai;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.f */
/* loaded from: classes.dex */
class ViewOnLongClickListenerC1085f implements View.OnLongClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4347a;

    ViewOnLongClickListenerC1085f(ChatFragment chatFragment) {
        this.f4347a = chatFragment;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!C3171am.m11072j() || !C3171am.m11073k()) {
            C3641ai.m13210a(this.f4347a.f3672cr, R.string.recordaudio_unable_to_record_during_call, 0).show();
        } else if (!C3223ck.m11327a()) {
            C3641ai.m13210a(this.f4347a.f3672cr, R.string.sdcard_not_found, 0).show();
        } else if (this.f4347a.m4834am()) {
            this.f4347a.f3655ca.setVisibility(0);
            this.f4347a.f3657cc.setVisibility(0);
            this.f4347a.f3657cc.bringToFront();
            this.f4347a.f3658cd.setVisibility(0);
            this.f4347a.f3613bj.requestFocus();
            this.f4347a.f3603bZ.requestFocus();
            this.f4347a.f3603bZ.setPressed(true);
            this.f4347a.f3507I = true;
            C1770b.m7289a().m7302b();
            this.f4347a.f3656cb = new AsyncTaskC1779k(this.f4347a.f3703r, this.f4347a.f3655ca, this.f4347a.f3698dr, this.f4347a.f3672cr, view);
            if (Build.VERSION.SDK_INT < 11) {
                this.f4347a.f3656cb.execute(new String[0]);
            } else {
                this.f4347a.f3656cb.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            }
            if (this.f4347a.f3672cr != null && this.f4347a.getResources() != null) {
                if (Settings.System.getInt(this.f4347a.f3672cr.getContentResolver(), "accelerometer_rotation", 0) == 1) {
                    this.f4347a.f3672cr.setRequestedOrientation(C3347i.m11773a(this.f4347a.f3672cr));
                }
                this.f4347a.f3672cr.getWindow().addFlags(128);
            }
        }
        return true;
    }
}
