package com.sec.chaton.multimedia.audio;

import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C4847bl;

/* compiled from: VoiceRecordDialog.java */
/* renamed from: com.sec.chaton.multimedia.audio.x */
/* loaded from: classes.dex */
class ViewOnClickListenerC2748x implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DialogC2747w f9877a;

    ViewOnClickListenerC2748x(DialogC2747w dialogC2747w) {
        this.f9877a = dialogC2747w;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18333a()) {
            if (!this.f9877a.f9873v) {
                this.f9877a.m11525d();
                this.f9877a.f9852a.setText(this.f9877a.getContext().getString(R.string.button_record_stop));
                this.f9877a.f9873v = true;
            } else {
                if (this.f9877a.f9861j != null) {
                    this.f9877a.f9861j.m11487a(true);
                }
                this.f9877a.f9873v = false;
            }
        }
    }
}
