package com.sec.vip.amschaton.honeycomb;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.vip.amschaton.C1561z;

/* compiled from: AMSStampSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.l */
/* loaded from: classes.dex */
public class C1453l extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionActivity f5097a;

    /* renamed from: b */
    private C1561z f5098b;

    public C1453l(AMSStampSelectionActivity aMSStampSelectionActivity) {
        this.f5097a = aMSStampSelectionActivity;
        this.f5098b = aMSStampSelectionActivity.f5026s;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f5098b == null) {
            return 0;
        }
        int i = 4;
        while (i > 0 && this.f5097a.f5021n[i - 1] == -1) {
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
            view = this.f5097a.getLayoutInflater().inflate(R.layout.ams_ics_list_item_stamp, viewGroup, false);
        }
        Bitmap bitmap = null;
        int i2 = i < this.f5097a.f5021n.length ? this.f5097a.f5021n[i] : 0;
        if (i2 < this.f5098b.m5670f()) {
            bitmap = (Bitmap) this.f5097a.f5027t.get(this.f5098b.m5668d(i2));
        } else {
            int i3 = i2 - 1000;
            int size = this.f5097a.f5028u.size();
            if (size > 0 && i3 >= 0 && i3 < size) {
                bitmap = (Bitmap) this.f5097a.f5028u.get(i3);
            }
        }
        if (bitmap != null) {
            ((ImageView) view.findViewById(R.id.image_basic_stamp)).setImageBitmap(bitmap);
        }
        return view;
    }

    /* renamed from: a */
    public void m5281a() {
        notifyDataSetChanged();
    }
}
