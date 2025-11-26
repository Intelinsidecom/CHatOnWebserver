package com.sec.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: GeneralToast.java */
/* renamed from: com.sec.widget.ai */
/* loaded from: classes.dex */
public class C3641ai extends Toast {

    /* renamed from: a */
    private TextView f13520a;

    public C3641ai(Context context) {
        super(context);
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.toast_layout, (ViewGroup) null);
        this.f13520a = (TextView) viewInflate.findViewById(R.id.text1);
        setView(viewInflate);
        setDuration(0);
    }

    @Override // android.widget.Toast
    public void setText(CharSequence charSequence) {
        this.f13520a.setText(charSequence);
    }

    @Override // android.widget.Toast
    public void setText(int i) {
        this.f13520a.setText(i);
    }

    /* renamed from: a */
    public static Toast m13210a(Context context, int i, int i2) {
        return m13211a(context, context.getResources().getText(i), i2);
    }

    /* renamed from: a */
    public static Toast m13211a(Context context, CharSequence charSequence, int i) {
        C3641ai c3641ai = new C3641ai(context);
        c3641ai.setText(charSequence);
        c3641ai.setDuration(i);
        return c3641ai;
    }
}
