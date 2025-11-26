package com.sec.chaton.multimedia.multisend;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

/* compiled from: GalleryView.java */
/* renamed from: com.sec.chaton.multimedia.multisend.j */
/* loaded from: classes.dex */
class C2876j implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ GalleryView f10590a;

    C2876j(GalleryView galleryView) {
        this.f10590a = galleryView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str = ((C2877k) this.f10590a.f10533b.get(i)).f10595e;
        String str2 = ((C2877k) this.f10590a.f10533b.get(i)).f10591a;
        Intent intent = new Intent(this.f10590a.getActivity(), (Class<?>) CategoryActivity.class);
        intent.putExtra("category", str);
        intent.putExtra("categoryName", str2);
        if (this.f10590a.f10539h) {
            intent.putExtra("caller", "POSTON");
            intent.putExtra("attachedimagecount", this.f10590a.f10540i);
        }
        intent.putParcelableArrayListExtra("preview_data", this.f10590a.f10534c);
        this.f10590a.startActivityForResult(intent, 1);
    }
}
