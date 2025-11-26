package com.sec.chaton.settings;

import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;
import com.sec.chaton.settings.downloads.C2591cd;
import com.sec.chaton.settings.downloads.C2598ck;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3223ck;
import com.sec.widget.C3641ai;

/* compiled from: FragmentSkinChange3.java */
/* renamed from: com.sec.chaton.settings.ea */
/* loaded from: classes.dex */
class C2664ea implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentSkinChange3 f9931a;

    C2664ea(FragmentSkinChange3 fragmentSkinChange3) {
        this.f9931a = fragmentSkinChange3;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) throws Throwable {
        Drawable drawableM9584g;
        C2673ej c2673ej = (C2673ej) view.getTag();
        if (c2673ej != null) {
            if (this.f9931a.f9211u != FragmentSkinChange3.f9174c) {
                if (this.f9931a.f9211u != FragmentSkinChange3.f9173b) {
                    if (this.f9931a.f9211u == FragmentSkinChange3.f9172a && (drawableM9584g = C2591cd.m9584g(this.f9931a.getActivity(), c2673ej.f9945a)) != null) {
                        this.f9931a.f9206p.setBackgroundDrawable(drawableM9584g.getConstantState().newDrawable());
                        if (this.f9931a.f9213w == null) {
                            this.f9931a.m9156b(c2673ej.f9945a, c2673ej.f9947c);
                            return;
                        } else {
                            this.f9931a.m9153a(c2673ej.f9945a, c2673ej.f9947c);
                            return;
                        }
                    }
                    return;
                }
                Drawable drawableM9586i = C2591cd.m9586i(this.f9931a.getActivity(), c2673ej.f9945a);
                if (drawableM9586i != null) {
                    this.f9931a.f9207q.setBackgroundDrawable(drawableM9586i.getConstantState().newDrawable());
                    if (this.f9931a.f9213w == null) {
                        this.f9931a.m9156b(c2673ej.f9945a, c2673ej.f9947c);
                        return;
                    } else {
                        this.f9931a.m9153a(c2673ej.f9945a, c2673ej.f9947c);
                        return;
                    }
                }
                return;
            }
            if (c2673ej.f9946b.equals("skin_add")) {
                if (!C3197bl.m11159a()) {
                    if (!C3223ck.m11327a() || this.f9931a.f9179E == null) {
                        if (this.f9931a.f9186L == null) {
                            this.f9931a.f9186L = C3641ai.m13211a(this.f9931a.getActivity(), this.f9931a.getString(R.string.sdcard_not_found), 1);
                        }
                        this.f9931a.f9186L.show();
                        return;
                    }
                    this.f9931a.m9134a(this.f9931a.f9179E);
                    return;
                }
                return;
            }
            if (c2673ej.f9946b.equals("skin_myskin.png_")) {
                this.f9931a.m9149k();
                if (this.f9931a.f9213w == null) {
                    this.f9931a.m9156b(c2673ej.f9946b, c2673ej.f9947c);
                    return;
                } else {
                    this.f9931a.m9153a(c2673ej.f9946b, c2673ej.f9947c);
                    return;
                }
            }
            C2598ck c2598ckM9582f = C2591cd.m9582f(this.f9931a.getActivity(), c2673ej.f9946b);
            if (c2598ckM9582f != null) {
                if (c2673ej.f9947c.equals("pa")) {
                    this.f9931a.f9192R = new BitmapDrawable(c2598ckM9582f.f9826b);
                    this.f9931a.f9192R.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                    this.f9931a.f9205o.setImageBitmap(null);
                    this.f9931a.f9205o.setBackgroundDrawable(this.f9931a.f9192R);
                } else {
                    this.f9931a.f9205o.setImageBitmap(c2598ckM9582f.f9826b);
                }
                if (this.f9931a.f9213w == null) {
                    this.f9931a.m9156b(c2673ej.f9946b, c2673ej.f9947c);
                } else {
                    this.f9931a.m9153a(c2673ej.f9946b, c2673ej.f9947c);
                }
            }
        }
    }
}
