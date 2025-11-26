package com.sec.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;

/* compiled from: GeneralToast.java */
/* renamed from: com.sec.widget.v */
/* loaded from: classes.dex */
public class C5179v extends Toast {

    /* renamed from: a */
    private TextView f18970a;

    public C5179v(Context context) {
        super(context);
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.toast_layout, (ViewGroup) null);
        this.f18970a = (TextView) viewInflate.findViewById(R.id.text1);
        setView(viewInflate);
        setDuration(0);
    }

    @Override // android.widget.Toast
    public void setText(CharSequence charSequence) {
        this.f18970a.setText(charSequence);
    }

    @Override // android.widget.Toast
    public void setText(int i) {
        this.f18970a.setText(i);
    }

    /* renamed from: a */
    public static Toast m19810a(Context context, int i, int i2) {
        return m19811a(context, context.getResources().getText(i), i2);
    }

    /* renamed from: a */
    public static Toast m19811a(Context context, CharSequence charSequence, int i) {
        C5179v c5179v = new C5179v(context);
        c5179v.setText(charSequence);
        c5179v.setDuration(i);
        return c5179v;
    }
}
