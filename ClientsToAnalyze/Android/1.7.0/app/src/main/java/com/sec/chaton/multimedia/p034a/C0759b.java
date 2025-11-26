package com.sec.chaton.multimedia.p034a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.sec.chaton.util.C1301ax;
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;
import java.util.List;

/* compiled from: EmoticonAdapter.java */
/* renamed from: com.sec.chaton.multimedia.a.b */
/* loaded from: classes.dex */
public class C0759b extends BaseAdapter {

    /* renamed from: a */
    public static int f2582a = 7;

    /* renamed from: b */
    private Context f2583b;

    /* renamed from: c */
    private int f2584c;

    /* renamed from: d */
    private int f2585d;

    /* renamed from: e */
    private int f2586e = (int) C1301ax.m4544a(37.0f);

    /* renamed from: f */
    private List f2587f;

    /* renamed from: g */
    private C0758a f2588g;

    public C0759b(Context context, int i, C0758a c0758a, int i2) {
        this.f2584c = -1;
        this.f2587f = new ArrayList();
        this.f2583b = context;
        this.f2585d = i2;
        this.f2588g = c0758a;
        this.f2587f = this.f2588g.m3184a();
        if (i >= 0 && i < C0760c.f2591c.length) {
            this.f2584c = i;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f2584c > -1) {
            if (this.f2585d == 1) {
                if (this.f2588g.m3187c() > f2582a) {
                    return f2582a;
                }
                this.f2588g.m3187c();
            } else {
                return this.f2588g.m3187c();
            }
        }
        return this.f2588g.m3187c();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.f2584c > -1) {
            if (this.f2584c < C0760c.f2591c.length) {
                if (i < C0760c.f2591c[this.f2584c].length) {
                    return Integer.valueOf(C0760c.m3196b(C0760c.f2591c[this.f2584c][i]));
                }
                C1341p.m4651a("array index is out of bound", getClass().getSimpleName());
                return -1;
            }
            C1341p.m4651a("array index is out of bound", getClass().getSimpleName());
            return -1;
        }
        return Integer.valueOf(C0760c.m3196b(i));
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.f2584c > -1) {
            if (this.f2584c < C0760c.f2591c.length) {
                if (i < C0760c.f2591c[this.f2584c].length) {
                    return C0760c.f2591c[this.f2584c][i];
                }
                C1341p.m4651a("array index is out of bound", getClass().getSimpleName());
                return -1L;
            }
            C1341p.m4651a("array index is out of bound", getClass().getSimpleName());
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        if (view == null) {
            imageView = new ImageView(this.f2583b);
            imageView.setLayoutParams(new AbsListView.LayoutParams(this.f2586e, this.f2586e));
            imageView.setAdjustViewBounds(false);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) view;
        }
        if (this.f2588g.m3187c() != 0 && this.f2587f.size() > i) {
            imageView.setImageResource(((C0762e) this.f2587f.get(i)).f2596b);
        }
        return imageView;
    }
}
