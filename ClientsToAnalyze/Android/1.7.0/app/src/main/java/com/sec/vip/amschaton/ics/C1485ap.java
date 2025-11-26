package com.sec.vip.amschaton.ics;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.vip.amschaton.C1364aa;

/* compiled from: AMSSamplesActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.ap */
/* loaded from: classes.dex */
class C1485ap extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ AMSSamplesActivity f5299a;

    /* renamed from: b */
    private C1364aa f5300b;

    public C1485ap(AMSSamplesActivity aMSSamplesActivity) {
        this.f5299a = aMSSamplesActivity;
        this.f5300b = null;
        this.f5300b = C1364aa.m4865a();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f5300b == null) {
            return 0;
        }
        return this.f5300b.m4879b();
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
        C1496b c1496b;
        Bitmap bitmap;
        if (view == null) {
            c1496b = new C1496b(this, null);
            view = this.f5299a.getLayoutInflater().inflate(R.layout.ams_ics_list_item_contents, viewGroup, false);
            c1496b.f5315a = (ImageView) view.findViewById(R.id.image_ams_image);
            c1496b.f5316b = (CheckBox) view.findViewById(R.id.check_box_delete);
            view.setTag(c1496b);
        } else {
            c1496b = (C1496b) view.getTag();
        }
        if (this.f5299a.f5259o != null && (bitmap = (Bitmap) this.f5299a.f5259o.get(i)) != null) {
            c1496b.f5315a.setImageBitmap(bitmap);
        } else {
            c1496b.f5315a.setImageResource(R.drawable.attach_ams);
        }
        c1496b.f5316b.setVisibility(8);
        return view;
    }
}
