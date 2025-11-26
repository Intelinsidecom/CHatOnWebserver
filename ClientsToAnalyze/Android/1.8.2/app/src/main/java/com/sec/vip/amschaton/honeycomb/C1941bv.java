package com.sec.vip.amschaton.honeycomb;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.vip.amschaton.C2064n;

/* compiled from: AMSSamplesActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.bv */
/* loaded from: classes.dex */
class C1941bv extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ AMSSamplesActivity f7082a;

    /* renamed from: b */
    private C2064n f7083b;

    public C1941bv(AMSSamplesActivity aMSSamplesActivity) {
        this.f7082a = aMSSamplesActivity;
        this.f7083b = null;
        this.f7083b = C2064n.m7173a();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f7083b == null) {
            return 0;
        }
        return this.f7083b.m7187b();
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
        C1942bw c1942bw;
        Bitmap bitmap;
        if (view == null) {
            c1942bw = new C1942bw(this, null);
            view = this.f7082a.getLayoutInflater().inflate(R.layout.ams_ics_list_item_contents, viewGroup, false);
            c1942bw.f7084a = (ImageView) view.findViewById(R.id.image_ams_image);
            c1942bw.f7085b = (CheckBox) view.findViewById(R.id.check_box_delete);
            view.setTag(c1942bw);
        } else {
            c1942bw = (C1942bw) view.getTag();
        }
        if (this.f7082a.f7000q != null && (bitmap = (Bitmap) this.f7082a.f7000q.get(i)) != null) {
            c1942bw.f7084a.setImageBitmap(bitmap);
        } else {
            c1942bw.f7084a.setImageResource(R.drawable.attach_ams);
        }
        c1942bw.f7085b.setVisibility(8);
        return view;
    }
}
