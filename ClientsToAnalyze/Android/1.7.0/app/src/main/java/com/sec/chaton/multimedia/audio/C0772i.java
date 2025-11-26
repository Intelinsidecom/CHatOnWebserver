package com.sec.chaton.multimedia.audio;

import android.content.Intent;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.util.C1341p;

/* compiled from: InsertSound.java */
/* renamed from: com.sec.chaton.multimedia.audio.i */
/* loaded from: classes.dex */
class C0772i implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ InsertSound f2667a;

    C0772i(InsertSound insertSound) {
        this.f2667a = insertSound;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str = InsertSound.f2600d + ((String) adapterView.getItemAtPosition(i));
        Intent intent = new Intent();
        intent.putExtra(InsertSound.f2599c, str);
        C1341p.m4659c("MediaStore.Audio.Media.getContentUriForPath(path):" + MediaStore.Audio.Media.getContentUriForPath(str));
        this.f2667a.setResult(-1, intent);
        this.f2667a.finish();
    }
}
