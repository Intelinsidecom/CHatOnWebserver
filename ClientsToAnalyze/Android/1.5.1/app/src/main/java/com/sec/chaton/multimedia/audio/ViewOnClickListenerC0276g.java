package com.sec.chaton.multimedia.audio;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.multimedia.audio.g */
/* loaded from: classes.dex */
class ViewOnClickListenerC0276g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RecordAudio f2083a;

    ViewOnClickListenerC0276g(RecordAudio recordAudio) {
        this.f2083a = recordAudio;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException {
        this.f2083a.f2064n = false;
        this.f2083a.f2065o = false;
        this.f2083a.f2056f.setClickable(true);
        this.f2083a.f2053c.cancel();
        if (this.f2083a.f2071u != null) {
            try {
                this.f2083a.f2071u.stop();
                this.f2083a.f2071u.release();
                this.f2083a.f2071u = null;
            } catch (Exception e) {
                ChatONLogWriter.m3501a(e, getClass().getName());
                Toast.makeText(this.f2083a.f2055e, C0062R.string.toast_error, 1).show();
            }
        }
        Intent intent = new Intent();
        intent.putExtra(RecordAudio.f2050a, this.f2083a.f2072v);
        this.f2083a.setResult(-1, intent);
        this.f2083a.finish();
    }
}
