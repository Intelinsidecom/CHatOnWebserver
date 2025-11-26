package com.sec.chaton.smsplugin.p112ui;

import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.audio.DialogC2747w;
import com.sec.chaton.smsplugin.multimedia.audio.MmsVoiceListActivity;
import com.sec.chaton.util.C4822an;
import com.sec.widget.C5179v;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.dv */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4194dv implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PluginComposeMessageActivity f15521a;

    DialogInterfaceOnClickListenerC4194dv(PluginComposeMessageActivity pluginComposeMessageActivity) {
        this.f15521a = pluginComposeMessageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            this.f15521a.startActivityForResult(new Intent(this.f15521a, (Class<?>) MmsVoiceListActivity.class), 105);
            return;
        }
        if (i == 1) {
            if (C4822an.m18245m() && C4822an.m18246n()) {
                if (this.f15521a.m15974aA()) {
                    String strValueOf = String.valueOf(this.f15521a.f14935G.m14359d());
                    this.f15521a.f15038bo = new DialogC2747w(this.f15521a, this.f15521a.f15014bI, null, strValueOf, true);
                    this.f15521a.f15038bo.show();
                    return;
                }
                return;
            }
            C5179v.m19810a(this.f15521a, R.string.recordaudio_unable_to_record_during_call, 0).show();
        }
    }
}
