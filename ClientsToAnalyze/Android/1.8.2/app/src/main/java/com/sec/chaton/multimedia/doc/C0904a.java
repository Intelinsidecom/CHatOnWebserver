package com.sec.chaton.multimedia.doc;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.util.C1786r;

/* compiled from: FileExplorerActivity.java */
/* renamed from: com.sec.chaton.multimedia.doc.a */
/* loaded from: classes.dex */
class C0904a implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ FileExplorerActivity f3319a;

    C0904a(FileExplorerActivity fileExplorerActivity) {
        this.f3319a = fileExplorerActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (((C0906c) this.f3319a.f3312c.get(i)).m3640a() == EnumC0905b.DIRECTORY) {
            this.f3319a.f3317k.push(this.f3319a.f3314e);
            this.f3319a.f3314e = ((C0906c) this.f3319a.f3312c.get(i)).m3649e();
            this.f3319a.f3316j.setText(this.f3319a.f3314e);
            this.f3319a.m3636c(this.f3319a.f3314e);
            return;
        }
        if (C1786r.f6452b) {
            C1786r.m6061b("send file: " + ((C0906c) this.f3319a.f3312c.get(i)).m3649e(), FileExplorerActivity.f3308b);
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(((C0906c) this.f3319a.f3312c.get(i)).m3649e()));
        this.f3319a.setResult(-1, intent);
        this.f3319a.finish();
    }
}
