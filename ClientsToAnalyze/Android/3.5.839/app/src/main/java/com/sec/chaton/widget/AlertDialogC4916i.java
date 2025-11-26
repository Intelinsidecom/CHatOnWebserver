package com.sec.chaton.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.common.util.C5052r;

/* compiled from: GeneralProgressDialog.java */
/* renamed from: com.sec.chaton.widget.i */
/* loaded from: classes.dex */
public class AlertDialogC4916i extends AlertDialog {

    /* renamed from: a */
    private TextView f17970a;

    /* renamed from: b */
    private ProgressBar f17971b;

    /* renamed from: c */
    private TextView f17972c;

    /* renamed from: d */
    private TextView f17973d;

    /* renamed from: e */
    private int f17974e;

    /* renamed from: f */
    private int f17975f;

    public AlertDialogC4916i(Context context) {
        super(context);
        this.f17974e = 0;
        this.f17975f = 0;
        m18717a();
    }

    /* renamed from: a */
    private void m18717a() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.general_progress_dialog, (ViewGroup) null, false);
        this.f17970a = (TextView) viewInflate.findViewById(R.id.progressDialogMessage);
        this.f17971b = (ProgressBar) viewInflate.findViewById(R.id.progressDialogBar);
        this.f17972c = (TextView) viewInflate.findViewById(R.id.progressDialogCount);
        this.f17973d = (TextView) viewInflate.findViewById(R.id.progressDialogsPercentage);
        setIcon(0);
        setView(viewInflate);
    }

    @Override // android.app.AlertDialog
    public void setMessage(CharSequence charSequence) {
        this.f17970a.setText(charSequence);
    }

    /* renamed from: a */
    public void m18719a(int i) {
        this.f17971b.setProgress(i);
        m18718b();
    }

    /* renamed from: b */
    private void m18718b() {
        this.f17973d.setText(C5052r.m19199a(Integer.valueOf(this.f17971b.getProgress()), "%"));
    }
}
