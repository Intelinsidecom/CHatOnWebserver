package com.sec.chaton.multimedia.audio;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.util.C4904y;

/* compiled from: VoiceListFragment.java */
/* renamed from: com.sec.chaton.multimedia.audio.q */
/* loaded from: classes.dex */
class C2741q implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ VoiceListFragment f9836a;

    C2741q(VoiceListFragment voiceListFragment) {
        this.f9836a = voiceListFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f9836a.f9754g != null && !this.f9836a.f9754g.isClosed() && this.f9836a.f9754g.moveToPosition(i)) {
            String string = this.f9836a.f9754g.getString(this.f9836a.f9754g.getColumnIndex("_data"));
            if (C4904y.f17872b) {
                C4904y.m18639b("send voice: " + string, VoiceListFragment.f9748b);
            }
            if (this.f9836a.f9751d != null) {
                Intent intent = new Intent();
                intent.setData(Uri.parse(Uri.encode(string)));
                this.f9836a.f9751d.setResult(-1, intent);
                this.f9836a.f9751d.finish();
            }
        }
    }
}
