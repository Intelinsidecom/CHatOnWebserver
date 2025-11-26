package com.sec.chaton.multimedia.audio;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.util.C3250y;

/* compiled from: VoiceListFragment.java */
/* renamed from: com.sec.chaton.multimedia.audio.u */
/* loaded from: classes.dex */
class C1789u implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ VoiceListFragment f6628a;

    C1789u(VoiceListFragment voiceListFragment) {
        this.f6628a = voiceListFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f6628a.f6528g != null && !this.f6628a.f6528g.isClosed() && this.f6628a.f6528g.moveToPosition(i)) {
            String string = this.f6628a.f6528g.getString(this.f6628a.f6528g.getColumnIndex("_data"));
            if (C3250y.f11734b) {
                C3250y.m11450b("send voice: " + string, VoiceListFragment.f6522b);
            }
            if (this.f6628a.f6525d != null) {
                Intent intent = new Intent();
                intent.setData(Uri.parse(Uri.encode(string)));
                this.f6628a.f6525d.setResult(-1, intent);
                this.f6628a.f6525d.finish();
            }
        }
    }
}
