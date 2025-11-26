package com.sec.chaton.userprofile;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.sec.chaton.R;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.widget.CustomDatePicker;
import com.sec.widget.InterfaceC3680n;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Calendar;

/* compiled from: DatePickerWithCheckbox.java */
/* renamed from: com.sec.chaton.userprofile.u */
/* loaded from: classes.dex */
public class AlertDialogC3152u extends AlertDialog implements DialogInterface.OnClickListener, DatePicker.OnDateChangedListener, InterfaceC3680n {

    /* renamed from: a */
    final Calendar f11420a;

    /* renamed from: b */
    int f11421b;

    /* renamed from: c */
    int f11422c;

    /* renamed from: d */
    int f11423d;

    /* renamed from: e */
    private CustomDatePicker f11424e;

    /* renamed from: f */
    private DatePicker f11425f;

    /* renamed from: g */
    private final InterfaceC3155x f11426g;

    /* renamed from: h */
    private final Calendar f11427h;

    /* renamed from: i */
    private int f11428i;

    /* renamed from: j */
    private int f11429j;

    /* renamed from: k */
    private int f11430k;

    /* renamed from: l */
    private CheckBox f11431l;

    /* renamed from: m */
    private LinearLayout f11432m;

    /* renamed from: n */
    private View.OnClickListener f11433n;

    /* renamed from: o */
    private DialogInterface.OnClickListener f11434o;

    public AlertDialogC3152u(Context context, InterfaceC3155x interfaceC3155x, int i, int i2, int i3, String str) {
        super(context);
        this.f11420a = Calendar.getInstance();
        this.f11421b = this.f11420a.get(1);
        this.f11422c = this.f11420a.get(2);
        this.f11423d = this.f11420a.get(5);
        this.f11433n = new ViewOnClickListenerC3153v(this);
        this.f11434o = new DialogInterfaceOnClickListenerC3154w(this);
        this.f11426g = interfaceC3155x;
        this.f11428i = i;
        this.f11429j = i2;
        this.f11430k = i3;
        new DateFormatSymbols().getShortWeekdays();
        DateFormat.getDateInstance(0);
        this.f11427h = Calendar.getInstance();
        if (Build.VERSION.SDK_INT < 11) {
            setButton(context.getText(R.string.date_time_set), this);
            setButton2(context.getText(R.string.cancel), this.f11434o);
        } else {
            setButton2(context.getText(R.string.date_time_set), this);
            setButton(context.getText(R.string.cancel), this.f11434o);
        }
        ScrollView scrollView = new ScrollView(context);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        if (Build.VERSION.SDK_INT >= 11) {
            scrollView.addView(layoutInflater.inflate(R.layout.date_picker_checkbox, (ViewGroup) null));
        } else {
            scrollView.addView(layoutInflater.inflate(R.layout.date_picker_checkbox_gb, (ViewGroup) null));
        }
        setView(scrollView, 0, 0, 0, 0);
        if (Build.VERSION.SDK_INT >= 11) {
            this.f11424e = (CustomDatePicker) scrollView.findViewById(R.id.datePicker);
            this.f11424e.m13077a(this.f11428i, this.f11429j, this.f11430k, this);
        } else {
            this.f11425f = (DatePicker) scrollView.findViewById(R.id.datePicker);
            this.f11425f.init(this.f11428i, this.f11429j, this.f11430k, this);
        }
        this.f11431l = (CheckBox) scrollView.findViewById(android.R.id.checkbox);
        if ("FULL".equals(str) || "FULL_HIDE".equals(str)) {
            this.f11431l.setChecked(true);
            C3159aa.m10963a("birthday_year_show", (Boolean) true);
        } else {
            this.f11431l.setChecked(false);
            C3159aa.m10963a("birthday_year_show", (Boolean) false);
        }
        this.f11431l.setClickable(false);
        this.f11431l.setFocusable(false);
        this.f11432m = (LinearLayout) scrollView.findViewById(R.id.birthday_year_check_layout);
        this.f11432m.setFocusable(true);
        this.f11432m.setClickable(true);
        this.f11432m.setOnClickListener(this.f11433n);
    }

    @Override // android.app.Dialog
    public void show() {
        setTitle(getContext().getResources().getString(R.string.setting_birthday));
        setCanceledOnTouchOutside(false);
        setIcon(0);
        super.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f11426g != null) {
            C3159aa.m10963a("birthday_year_show", Boolean.valueOf(this.f11431l.isChecked()));
            this.f11426g.mo10897a(C3159aa.m10962a().m10977a("birthday_year_show", (Boolean) false).booleanValue());
            C3250y.m11456e("Birthday year show : ", getClass().getSimpleName());
            if (Build.VERSION.SDK_INT >= 11) {
                this.f11424e.clearFocus();
                this.f11426g.mo10896a(this.f11424e.m13075a(), this.f11424e.m13079b(), this.f11424e.m13080c());
            } else {
                this.f11425f.clearFocus();
                this.f11426g.mo10896a(this.f11425f.getYear(), this.f11425f.getMonth(), this.f11425f.getDayOfMonth());
            }
            getWindow().setSoftInputMode(2);
        }
    }

    /* renamed from: a */
    public void m10941a(int i, int i2, int i3) throws NumberFormatException {
        this.f11428i = i;
        this.f11429j = i2;
        this.f11430k = i3;
        if (Build.VERSION.SDK_INT >= 11) {
            this.f11424e.m13076a(i, i2, i3);
        } else {
            this.f11425f.updateDate(i, i2, i3);
        }
    }

    /* renamed from: b */
    private void m10940b(int i, int i2, int i3) {
        this.f11427h.set(1, i);
        this.f11427h.set(2, i2);
        this.f11427h.set(5, i3);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        if (Build.VERSION.SDK_INT >= 11) {
            bundleOnSaveInstanceState.putInt("year", this.f11424e.m13075a());
            bundleOnSaveInstanceState.putInt("month", this.f11424e.m13079b());
            bundleOnSaveInstanceState.putInt("day", this.f11424e.m13080c());
        } else {
            bundleOnSaveInstanceState.putInt("year", this.f11425f.getYear());
            bundleOnSaveInstanceState.putInt("month", this.f11425f.getMonth());
            bundleOnSaveInstanceState.putInt("day", this.f11425f.getDayOfMonth());
        }
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        int i = bundle.getInt("year");
        int i2 = bundle.getInt("month");
        int i3 = bundle.getInt("day");
        if (Build.VERSION.SDK_INT >= 11) {
            this.f11424e.m13077a(i, i2, i3, this);
        } else {
            this.f11425f.init(i, i2, i3, this);
        }
        m10940b(i, i2, i3);
    }

    @Override // android.widget.DatePicker.OnDateChangedListener
    public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
        if (i >= this.f11421b) {
            i = this.f11421b;
            if (i2 >= this.f11422c) {
                i2 = this.f11422c;
                if (i3 > this.f11423d) {
                    i3 = this.f11423d;
                }
            }
        }
        datePicker.init(i, i2, i3, this);
    }

    @Override // com.sec.widget.InterfaceC3680n
    /* renamed from: a */
    public void mo10942a(CustomDatePicker customDatePicker, int i, int i2, int i3) {
        if (i >= this.f11421b) {
            i = this.f11421b;
            if (i2 >= this.f11422c) {
                i2 = this.f11422c;
                if (i3 > this.f11423d) {
                    i3 = this.f11423d;
                }
            }
        }
        customDatePicker.m13077a(i, i2, i3, this);
    }
}
