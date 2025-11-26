package com.sec.chaton.smsplugin.multimedia.audio;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.util.C4904y;

/* compiled from: MmsVoiceListFragment.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.audio.e */
/* loaded from: classes.dex */
class C3910e implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ MmsVoiceListFragment f14050a;

    C3910e(MmsVoiceListFragment mmsVoiceListFragment) {
        this.f14050a = mmsVoiceListFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f14050a.f14031g != null && !this.f14050a.f14031g.isClosed() && this.f14050a.f14031g.moveToPosition(i)) {
            String string = this.f14050a.f14031g.getString(this.f14050a.f14031g.getColumnIndex("_data"));
            if (C4904y.f17872b) {
                C4904y.m18639b("send voice: " + string, MmsVoiceListFragment.f14025b);
            }
            if (this.f14050a.f14028d != null) {
                Intent intent = new Intent();
                intent.setData(Uri.withAppendedPath(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, String.valueOf(j)));
                this.f14050a.f14028d.setResult(-1, intent);
                this.f14050a.f14028d.finish();
            }
        }
    }
}
