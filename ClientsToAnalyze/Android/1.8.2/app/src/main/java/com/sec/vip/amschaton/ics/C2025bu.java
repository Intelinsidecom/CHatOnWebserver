package com.sec.vip.amschaton.ics;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.vip.amschaton.C2064n;

/* compiled from: AMSSamplesActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.bu */
/* loaded from: classes.dex */
class C2025bu extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ AMSSamplesActivity f7310a;

    /* renamed from: b */
    private C2064n f7311b;

    public C2025bu(AMSSamplesActivity aMSSamplesActivity) {
        this.f7310a = aMSSamplesActivity;
        this.f7311b = null;
        this.f7311b = C2064n.m7173a();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f7311b == null) {
            return 0;
        }
        return this.f7311b.m7187b();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C2026bv c2026bv;
        Bitmap bitmap;
        if (view == null) {
            c2026bv = new C2026bv(this, null);
            view = this.f7310a.getLayoutInflater().inflate(R.layout.ams_ics_list_item_contents, viewGroup, false);
            c2026bv.f7312a = (ImageView) view.findViewById(R.id.image_ams_image);
            c2026bv.f7313b = (CheckBox) view.findViewById(R.id.check_box_delete);
            view.setTag(c2026bv);
        } else {
            c2026bv = (C2026bv) view.getTag();
        }
        if (this.f7310a.f7228p != null && (bitmap = (Bitmap) this.f7310a.f7228p.get(i)) != null) {
            c2026bv.f7312a.setImageBitmap(bitmap);
        } else {
            c2026bv.f7312a.setImageResource(R.drawable.attach_ams);
        }
        c2026bv.f7313b.setVisibility(8);
        return view;
    }
}
