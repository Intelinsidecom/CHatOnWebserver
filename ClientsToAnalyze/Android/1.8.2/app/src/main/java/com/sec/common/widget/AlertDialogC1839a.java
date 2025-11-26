package com.sec.common.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.common.p056b.p060d.C1828c;
import com.sec.widget.AlertDialogBuilderC2120a;

/* compiled from: GeneralProgressDialog.java */
/* renamed from: com.sec.common.widget.a */
/* loaded from: classes.dex */
public class AlertDialogC1839a extends AlertDialog implements DialogInterface.OnShowListener {

    /* renamed from: a */
    private TextView f6593a;

    /* renamed from: b */
    private ProgressBar f6594b;

    /* renamed from: c */
    private TextView f6595c;

    /* renamed from: d */
    private TextView f6596d;

    /* renamed from: e */
    private int f6597e;

    /* renamed from: f */
    private int f6598f;

    public AlertDialogC1839a(Context context) {
        super(context);
        this.f6597e = 0;
        this.f6598f = 0;
        m6236b();
    }

    /* renamed from: b */
    private void m6236b() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.general_progress_dialog, (ViewGroup) null, false);
        this.f6593a = (TextView) viewInflate.findViewById(R.id.progressDialogMessage);
        this.f6594b = (ProgressBar) viewInflate.findViewById(R.id.progressDialogBar);
        this.f6595c = (TextView) viewInflate.findViewById(R.id.progressDialogCount);
        this.f6596d = (TextView) viewInflate.findViewById(R.id.progressDialogsPercentage);
        setIcon(0);
        setView(viewInflate);
        setOnShowListener(this);
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        AlertDialogBuilderC2120a.m7479a(this);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            super.setTitle(charSequence);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ForegroundColorSpan(-1), 0, spannableString.length(), 33);
        super.setTitle(spannableString);
    }

    @Override // android.app.AlertDialog
    public void setMessage(CharSequence charSequence) {
        this.f6593a.setText(charSequence);
    }

    /* renamed from: a */
    public void m6240a(int i) {
        this.f6598f = i;
        m6237c();
    }

    /* renamed from: b */
    public void m6241b(int i) {
        this.f6597e = i;
        m6237c();
    }

    /* renamed from: c */
    public void m6242c(int i) {
        this.f6594b.setProgress(i);
        m6238d();
    }

    /* renamed from: c */
    private void m6237c() {
        this.f6595c.setText(C1828c.m6207a(Integer.valueOf(this.f6597e), "/", Integer.valueOf(this.f6598f)));
    }

    /* renamed from: d */
    private void m6238d() {
        this.f6596d.setText(C1828c.m6207a(Integer.valueOf(this.f6594b.getProgress()), "%"));
    }

    /* renamed from: a */
    public void m6239a() {
        if (this.f6593a != null) {
            this.f6593a.setVisibility(8);
        }
    }
}
