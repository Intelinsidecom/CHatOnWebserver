package com.sec.chaton.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.common.util.C3364o;

/* compiled from: GeneralProgressDialog.java */
/* renamed from: com.sec.chaton.widget.c */
/* loaded from: classes.dex */
public class AlertDialogC3256c extends AlertDialog {

    /* renamed from: a */
    private TextView f11773a;

    /* renamed from: b */
    private ProgressBar f11774b;

    /* renamed from: c */
    private TextView f11775c;

    /* renamed from: d */
    private TextView f11776d;

    /* renamed from: e */
    private int f11777e;

    /* renamed from: f */
    private int f11778f;

    public AlertDialogC3256c(Context context) {
        super(context);
        this.f11777e = 0;
        this.f11778f = 0;
        m11481a();
    }

    /* renamed from: a */
    private void m11481a() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.general_progress_dialog, (ViewGroup) null, false);
        this.f11773a = (TextView) viewInflate.findViewById(R.id.progressDialogMessage);
        this.f11774b = (ProgressBar) viewInflate.findViewById(R.id.progressDialogBar);
        this.f11775c = (TextView) viewInflate.findViewById(R.id.progressDialogCount);
        this.f11776d = (TextView) viewInflate.findViewById(R.id.progressDialogsPercentage);
        setIcon(0);
        setView(viewInflate);
    }

    @Override // android.app.AlertDialog
    public void setMessage(CharSequence charSequence) {
        this.f11773a.setText(charSequence);
    }

    /* renamed from: a */
    public void m11483a(int i) {
        this.f11774b.setProgress(i);
        m11482b();
    }

    /* renamed from: b */
    private void m11482b() {
        this.f11776d.setText(C3364o.m11849a(Integer.valueOf(this.f11774b.getProgress()), "%"));
    }
}
