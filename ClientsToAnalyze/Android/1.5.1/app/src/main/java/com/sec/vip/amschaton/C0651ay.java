package com.sec.vip.amschaton;

import android.view.View;
import android.widget.AdapterView;
import java.io.IOException;

/* renamed from: com.sec.vip.amschaton.ay */
/* loaded from: classes.dex */
class C0651ay implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ BackgroundDefaultMusicSelectionActivity f4265a;

    C0651ay(BackgroundDefaultMusicSelectionActivity backgroundDefaultMusicSelectionActivity) {
        this.f4265a = backgroundDefaultMusicSelectionActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) throws IllegalStateException, IOException, IllegalArgumentException {
        this.f4265a.f4120a = i - 1;
        this.f4265a.m4152j();
        if (i > 0) {
            this.f4265a.m4146a();
        }
        this.f4265a.f4122c.m4230a();
    }
}
