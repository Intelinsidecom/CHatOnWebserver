package com.sec.chaton.multimedia.audio;

import android.content.Intent;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.util.C1786r;

/* compiled from: InsertSound.java */
/* renamed from: com.sec.chaton.multimedia.audio.b */
/* loaded from: classes.dex */
class C0872b implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ InsertSound f3262a;

    C0872b(InsertSound insertSound) {
        this.f3262a = insertSound;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str = InsertSound.f3203d + ((String) adapterView.getItemAtPosition(i));
        Intent intent = new Intent();
        intent.putExtra(InsertSound.f3202c, str);
        C1786r.m6064d("MediaStore.Audio.Media.getContentUriForPath(path):" + MediaStore.Audio.Media.getContentUriForPath(str));
        this.f3262a.setResult(-1, intent);
        this.f3262a.finish();
    }
}
