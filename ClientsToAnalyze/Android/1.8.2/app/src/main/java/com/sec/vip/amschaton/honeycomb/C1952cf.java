package com.sec.vip.amschaton.honeycomb;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.vip.amschaton.C1849ai;

/* compiled from: AMSStampSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.cf */
/* loaded from: classes.dex */
public class C1952cf extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionActivity f7097a;

    /* renamed from: b */
    private C1849ai f7098b;

    public C1952cf(AMSStampSelectionActivity aMSStampSelectionActivity) {
        this.f7097a = aMSStampSelectionActivity;
        this.f7098b = aMSStampSelectionActivity.f7013u;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f7098b == null) {
            return 0;
        }
        int i = 4;
        while (i > 0 && this.f7097a.f7008p[i - 1] == -1) {
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
            view = this.f7097a.getLayoutInflater().inflate(R.layout.ams_ics_list_item_stamp, viewGroup, false);
        }
        Bitmap bitmap = null;
        int i2 = i < this.f7097a.f7008p.length ? this.f7097a.f7008p[i] : 0;
        if (i2 < this.f7098b.m6410f()) {
            bitmap = (Bitmap) this.f7097a.f7014v.get(this.f7098b.m6408d(i2));
        } else {
            int i3 = i2 - 1000;
            int size = this.f7097a.f7015w.size();
            if (size > 0 && i3 >= 0 && i3 < size) {
                bitmap = (Bitmap) this.f7097a.f7015w.get(i3);
            }
        }
        if (bitmap != null) {
            ((ImageView) view.findViewById(R.id.image_basic_stamp)).setImageBitmap(bitmap);
        }
        return view;
    }

    /* renamed from: a */
    public void m6857a() {
        notifyDataSetChanged();
    }
}
