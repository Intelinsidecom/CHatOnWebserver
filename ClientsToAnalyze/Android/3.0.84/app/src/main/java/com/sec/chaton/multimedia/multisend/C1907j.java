package com.sec.chaton.multimedia.multisend;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

/* compiled from: GalleryView.java */
/* renamed from: com.sec.chaton.multimedia.multisend.j */
/* loaded from: classes.dex */
class C1907j implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ GalleryView f7269a;

    C1907j(GalleryView galleryView) {
        this.f7269a = galleryView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str = ((C1908k) this.f7269a.f7212b.get(i)).f7274e;
        String str2 = ((C1908k) this.f7269a.f7212b.get(i)).f7270a;
        Intent intent = new Intent(this.f7269a.getActivity(), (Class<?>) CategoryActivity.class);
        intent.putExtra("category", str);
        intent.putExtra("categoryName", str2);
        if (this.f7269a.f7218h) {
            intent.putExtra("caller", "POSTON");
            intent.putExtra("attachedimagecount", this.f7269a.f7219i);
        }
        intent.putParcelableArrayListExtra("preview_data", this.f7269a.f7213c);
        this.f7269a.startActivityForResult(intent, 1);
    }
}
