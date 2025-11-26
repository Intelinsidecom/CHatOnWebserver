package com.sec.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: GeneralToast.java */
/* renamed from: com.sec.widget.y */
/* loaded from: classes.dex */
public class C2153y extends Toast {

    /* renamed from: a */
    private TextView f7846a;

    public C2153y(Context context) {
        super(context);
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.toast_layout, (ViewGroup) null);
        this.f7846a = (TextView) viewInflate.findViewById(R.id.text1);
        setView(viewInflate);
        setDuration(0);
    }

    @Override // android.widget.Toast
    public void setText(CharSequence charSequence) {
        this.f7846a.setText(charSequence);
    }

    @Override // android.widget.Toast
    public void setText(int i) {
        this.f7846a.setText(i);
    }

    /* renamed from: a */
    public static Toast m7535a(Context context, int i, int i2) {
        return m7536a(context, context.getResources().getText(i), i2);
    }

    /* renamed from: a */
    public static Toast m7536a(Context context, CharSequence charSequence, int i) {
        C2153y c2153y = new C2153y(context);
        c2153y.setText(charSequence);
        c2153y.setDuration(i);
        return c2153y;
    }
}
