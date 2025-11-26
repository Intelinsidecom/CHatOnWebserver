package com.sec.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: GeneralToast.java */
/* renamed from: com.sec.widget.g */
/* loaded from: classes.dex */
public class C1619g extends Toast {

    /* renamed from: a */
    private TextView f5712a;

    public C1619g(Context context) {
        super(context);
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.toast_layout, (ViewGroup) null);
        this.f5712a = (TextView) viewInflate.findViewById(R.id.text1);
        setView(viewInflate);
        setDuration(0);
    }

    @Override // android.widget.Toast
    public void setText(CharSequence charSequence) {
        this.f5712a.setText(charSequence);
    }

    @Override // android.widget.Toast
    public void setText(int i) {
        this.f5712a.setText(i);
    }

    /* renamed from: a */
    public static Toast m5888a(Context context, int i, int i2) {
        return m5889a(context, context.getResources().getText(i), i2);
    }

    /* renamed from: a */
    public static Toast m5889a(Context context, CharSequence charSequence, int i) {
        C1619g c1619g = new C1619g(context);
        c1619g.setText(charSequence);
        c1619g.setDuration(i);
        return c1619g;
    }
}
