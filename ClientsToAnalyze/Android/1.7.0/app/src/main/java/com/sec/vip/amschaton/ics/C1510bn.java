package com.sec.vip.amschaton.ics;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.vip.amschaton.C1561z;

/* compiled from: AMSStampSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.bn */
/* loaded from: classes.dex */
public class C1510bn extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionActivity f5334a;

    /* renamed from: b */
    private C1561z f5335b;

    public C1510bn(AMSStampSelectionActivity aMSStampSelectionActivity) {
        this.f5334a = aMSStampSelectionActivity;
        this.f5335b = aMSStampSelectionActivity.f5271s;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f5335b == null) {
            return 0;
        }
        int i = 4;
        while (i > 0 && this.f5334a.f5266n[i - 1] == -1) {
            i--;
        }
        return i;
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
        if (view == null) {
            view = this.f5334a.getLayoutInflater().inflate(R.layout.ams_ics_list_item_stamp, viewGroup, false);
        }
        Bitmap bitmap = null;
        int i2 = i < this.f5334a.f5266n.length ? this.f5334a.f5266n[i] : 0;
        if (i2 < this.f5335b.m5670f()) {
            bitmap = (Bitmap) this.f5334a.f5272t.get(this.f5335b.m5668d(i2));
        } else {
            int i3 = i2 - 1000;
            int size = this.f5334a.f5273u.size();
            if (size > 0 && i3 >= 0 && i3 < size) {
                bitmap = (Bitmap) this.f5334a.f5273u.get(i3);
            }
        }
        if (bitmap != null) {
            ((ImageView) view.findViewById(R.id.image_basic_stamp)).setImageBitmap(bitmap);
        }
        return view;
    }

    /* renamed from: a */
    public void m5613a() {
        notifyDataSetChanged();
    }
}
