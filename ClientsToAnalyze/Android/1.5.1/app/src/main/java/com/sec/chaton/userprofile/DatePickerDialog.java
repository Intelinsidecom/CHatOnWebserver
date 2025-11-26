package com.sec.chaton.userprofile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;

/* loaded from: classes.dex */
public class DatePickerDialog extends AlertDialog implements DialogInterface.OnClickListener, DatePicker.OnDateChangedListener {

    /* renamed from: a */
    private final DatePicker f3336a;

    /* renamed from: b */
    private final OnDateSetListener f3337b;

    /* renamed from: c */
    private final Button f3338c;

    public interface OnDateSetListener {
        /* renamed from: a */
        void m3322a(DatePicker datePicker, int i, int i2, int i3, String str);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f3337b != null) {
            this.f3336a.clearFocus();
            this.f3337b.m3322a(this.f3336a, this.f3336a.getYear(), this.f3336a.getMonth(), this.f3336a.getDayOfMonth(), (String) this.f3338c.getText());
        }
    }

    @Override // android.widget.DatePicker.OnDateChangedListener
    public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
    }

    @Override // android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f3336a.init(bundle.getInt("year"), bundle.getInt("month"), bundle.getInt("day"), this);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        bundleOnSaveInstanceState.putInt("year", this.f3336a.getYear());
        bundleOnSaveInstanceState.putInt("month", this.f3336a.getMonth());
        bundleOnSaveInstanceState.putInt("day", this.f3336a.getDayOfMonth());
        bundleOnSaveInstanceState.putString("check", (String) this.f3338c.getText());
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }
}
