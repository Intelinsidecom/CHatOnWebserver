package com.sec.vip.amschaton.honeycomb;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.vip.amschaton.C1364aa;

/* compiled from: AMSSamplesActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.aj */
/* loaded from: classes.dex */
class C1414aj extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ AMSSamplesActivity f5043a;

    /* renamed from: b */
    private C1364aa f5044b;

    public C1414aj(AMSSamplesActivity aMSSamplesActivity) {
        this.f5043a = aMSSamplesActivity;
        this.f5044b = null;
        this.f5044b = C1364aa.m4865a();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f5044b == null) {
            return 0;
        }
        return this.f5044b.m4879b();
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
        C1442bk c1442bk;
        Bitmap bitmap;
        if (view == null) {
            c1442bk = new C1442bk(this, null);
            view = this.f5043a.getLayoutInflater().inflate(R.layout.ams_ics_list_item_contents, viewGroup, false);
            c1442bk.f5077a = (ImageView) view.findViewById(R.id.image_ams_image);
            c1442bk.f5078b = (CheckBox) view.findViewById(R.id.check_box_delete);
            view.setTag(c1442bk);
        } else {
            c1442bk = (C1442bk) view.getTag();
        }
        if (this.f5043a.f5015o != null && (bitmap = (Bitmap) this.f5043a.f5015o.get(i)) != null) {
            c1442bk.f5077a.setImageBitmap(bitmap);
        } else {
            c1442bk.f5077a.setImageResource(R.drawable.attach_ams);
        }
        c1442bk.f5078b.setVisibility(8);
        return view;
    }
}
