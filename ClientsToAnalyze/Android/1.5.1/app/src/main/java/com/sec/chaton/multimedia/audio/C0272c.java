package com.sec.chaton.multimedia.audio;

import android.content.Intent;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.multimedia.audio.c */
/* loaded from: classes.dex */
class C0272c implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ InsertSound f2079a;

    C0272c(InsertSound insertSound) {
        this.f2079a = insertSound;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str = InsertSound.f2032d + ((String) adapterView.getItemAtPosition(i));
        Intent intent = new Intent();
        intent.putExtra(InsertSound.f2031c, str);
        ChatONLogWriter.m3509d("MediaStore.Audio.Media.getContentUriForPath(path):" + MediaStore.Audio.Media.getContentUriForPath(str));
        this.f2079a.setResult(-1, intent);
        this.f2079a.finish();
    }
}
