package com.sec.vip.amschaton.ics;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.vip.amschaton.C1849ai;

/* compiled from: AMSStampSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.ce */
/* loaded from: classes.dex */
public class C2036ce extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionActivity f7325a;

    /* renamed from: b */
    private C1849ai f7326b;

    public C2036ce(AMSStampSelectionActivity aMSStampSelectionActivity) {
        this.f7325a = aMSStampSelectionActivity;
        this.f7326b = aMSStampSelectionActivity.f7239t;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f7326b == null) {
            return 0;
        }
        int i = 4;
        while (i > 0 && this.f7325a.f7234o[i - 1] == -1) {
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
            view = this.f7325a.getLayoutInflater().inflate(R.layout.ams_ics_list_item_stamp, viewGroup, false);
        }
        Bitmap bitmap = null;
        int i2 = i < this.f7325a.f7234o.length ? this.f7325a.f7234o[i] : 0;
        if (i2 < this.f7326b.m6410f()) {
            bitmap = (Bitmap) this.f7325a.f7240u.get(this.f7326b.m6408d(i2));
        } else {
            int i3 = i2 - 1000;
            int size = this.f7325a.f7241v.size();
            if (size > 0 && i3 >= 0 && i3 < size) {
                bitmap = (Bitmap) this.f7325a.f7241v.get(i3);
            }
        }
        if (bitmap != null) {
            ((ImageView) view.findViewById(R.id.image_basic_stamp)).setImageBitmap(bitmap);
        }
        return view;
    }

    /* renamed from: a */
    public void m7170a() {
        notifyDataSetChanged();
    }
}
