package com.sec.chaton.multimedia.emoticon.ams;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.common.p069e.C3326c;
import com.sec.vip.amschaton.C3584q;

/* compiled from: AmsTemplateListAdapter.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.ams.g */
/* loaded from: classes.dex */
public class C1810g extends BaseAdapter {

    /* renamed from: a */
    private Context f6751a;

    /* renamed from: b */
    private int f6752b;

    /* renamed from: c */
    private C3326c f6753c;

    public C1810g(Context context, C3326c c3326c) {
        this.f6751a = context;
        this.f6753c = c3326c;
        this.f6752b = context.getResources().getDimensionPixelOffset(R.dimen.theme_gridview_item_width);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return C3584q.m12778a().m12811e() + 1 + C3584q.m12778a().m12809c() + C3584q.m12778a().m12810d();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = i - 1;
        int iM12811e = C3584q.m12778a().m12811e();
        int iM12809c = C3584q.m12778a().m12809c();
        if (i2 < iM12811e) {
            return C3584q.m12778a().m12805b(i2);
        }
        int i3 = i2 - iM12811e;
        if (i3 < iM12809c) {
            return C3584q.m12778a().m12794a(this.f6751a, i3);
        }
        return C3584q.m12778a().m12793a(i3 - iM12809c);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i == 0) {
            return 0L;
        }
        int i2 = i - 1;
        int iM12811e = C3584q.m12778a().m12811e();
        int iM12809c = C3584q.m12778a().m12809c();
        if (i2 < iM12811e) {
            return EnumC1807d.User.m7450a() + i2;
        }
        int i3 = i2 - iM12811e;
        if (i3 < iM12809c) {
            return EnumC1807d.Download.m7450a() + i3;
        }
        return EnumC1807d.Basic.m7450a() + (i3 - iM12809c);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        ImageView imageView2 = (ImageView) view;
        if (view == null) {
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, this.f6752b);
            imageView = new ImageView(this.f6751a);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            imageView = imageView2;
        }
        if (i == 0) {
            this.f6753c.m11732a(imageView);
            imageView.setBackgroundResource(R.drawable.ams_item_border);
            imageView.setImageResource(R.drawable.setting_add);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            return imageView;
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setBackgroundResource(R.drawable.ams_item_border);
        this.f6753c.m11730a(imageView, new C1808e((String) getItem(i)));
        return imageView;
    }
}
