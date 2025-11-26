package com.sec.chaton.userprofile;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Calendar;

/* compiled from: DatePickerWithCheckbox.java */
/* renamed from: com.sec.chaton.userprofile.f */
/* loaded from: classes.dex */
public class AlertDialogC1696f extends AlertDialog implements DialogInterface.OnClickListener, DatePicker.OnDateChangedListener {

    /* renamed from: a */
    final Calendar f6193a;

    /* renamed from: b */
    int f6194b;

    /* renamed from: c */
    int f6195c;

    /* renamed from: d */
    int f6196d;

    /* renamed from: e */
    private final DatePicker f6197e;

    /* renamed from: f */
    private final InterfaceC1698h f6198f;

    /* renamed from: g */
    private final Calendar f6199g;

    /* renamed from: h */
    private final DateFormat f6200h;

    /* renamed from: i */
    private final String[] f6201i;

    /* renamed from: j */
    private int f6202j;

    /* renamed from: k */
    private int f6203k;

    /* renamed from: l */
    private int f6204l;

    /* renamed from: m */
    private CheckBox f6205m;

    /* renamed from: n */
    private View.OnClickListener f6206n;

    public AlertDialogC1696f(Context context, InterfaceC1698h interfaceC1698h, int i, int i2, int i3) {
        super(context, R.style.CustomAlertDialogtheme);
        this.f6193a = Calendar.getInstance();
        this.f6194b = this.f6193a.get(1);
        this.f6195c = this.f6193a.get(2);
        this.f6196d = this.f6193a.get(5);
        this.f6206n = new ViewOnClickListenerC1697g(this);
        this.f6198f = interfaceC1698h;
        this.f6202j = i;
        this.f6203k = i2;
        this.f6204l = i3;
        this.f6201i = new DateFormatSymbols().getShortWeekdays();
        this.f6200h = DateFormat.getDateInstance(0);
        this.f6199g = Calendar.getInstance();
        setButton(context.getText(R.string.cancel), (DialogInterface.OnClickListener) null);
        setButton2(context.getText(R.string.date_time_set), this);
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.date_picker_checkbox, (ViewGroup) null);
        setView(viewInflate);
        this.f6197e = (DatePicker) viewInflate.findViewById(R.id.datePicker);
        this.f6197e.init(this.f6202j, this.f6203k, this.f6204l, this);
        NumberPicker numberPicker = (NumberPicker) this.f6197e.findViewById(Resources.getSystem().getIdentifier("month", "id", "android"));
        NumberPicker numberPicker2 = (NumberPicker) this.f6197e.findViewById(Resources.getSystem().getIdentifier("day", "id", "android"));
        NumberPicker numberPicker3 = (NumberPicker) this.f6197e.findViewById(Resources.getSystem().getIdentifier("year", "id", "android"));
        ((EditText) numberPicker.findViewById(Resources.getSystem().getIdentifier("numberpicker_input", "id", "android"))).setTextColor(R.color.ics_main_font_color_2);
        ((EditText) numberPicker2.findViewById(Resources.getSystem().getIdentifier("numberpicker_input", "id", "android"))).setTextColor(R.color.ics_main_font_color_2);
        ((EditText) numberPicker3.findViewById(Resources.getSystem().getIdentifier("numberpicker_input", "id", "android"))).setTextColor(R.color.ics_main_font_color_2);
        if (Build.VERSION.SDK_INT > 12) {
            this.f6197e.getCalendarView().setVisibility(8);
        } else {
            this.f6197e.setDescendantFocusability(393216);
            this.f6197e.setCalendarViewShown(false);
        }
        this.f6205m = (CheckBox) viewInflate.findViewById(R.id.birthday_year_check);
        this.f6205m.setChecked(C1789u.m6075a().getBoolean("birthday_year_show", false));
        this.f6205m.setOnClickListener(this.f6206n);
    }

    @Override // android.app.Dialog
    public void show() {
        setTitle(R.string.setting_birthday);
        setIcon(0);
        super.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f6198f != null) {
            C1789u.m6076a("birthday_year_show", Boolean.valueOf(this.f6205m.isChecked()));
            this.f6198f.mo5806a(C1789u.m6075a().getBoolean("birthday_year_show", false));
            C1786r.m6066e("Birthday year show : ", getClass().getSimpleName());
            this.f6197e.clearFocus();
            this.f6198f.mo5805a(this.f6197e, this.f6197e.getYear(), this.f6197e.getMonth(), this.f6197e.getDayOfMonth());
        }
    }

    @Override // android.widget.DatePicker.OnDateChangedListener
    public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
        if (i >= this.f6194b) {
            i = this.f6194b;
            if (i2 >= this.f6195c) {
                i2 = this.f6195c;
                if (i3 > this.f6196d) {
                    i3 = this.f6196d;
                }
            }
        }
        datePicker.init(i, i2, i3, this);
    }

    /* renamed from: a */
    public void m5810a(int i, int i2, int i3) {
        this.f6202j = i;
        this.f6203k = i2;
        this.f6204l = i3;
        this.f6197e.updateDate(i, i2, i3);
    }

    /* renamed from: b */
    private void m5809b(int i, int i2, int i3) {
        this.f6199g.set(1, i);
        this.f6199g.set(2, i2);
        this.f6199g.set(5, i3);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        bundleOnSaveInstanceState.putInt("year", this.f6197e.getYear());
        bundleOnSaveInstanceState.putInt("month", this.f6197e.getMonth());
        bundleOnSaveInstanceState.putInt("day", this.f6197e.getDayOfMonth());
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        int i = bundle.getInt("year");
        int i2 = bundle.getInt("month");
        int i3 = bundle.getInt("day");
        this.f6197e.init(i, i2, i3, this);
        m5809b(i, i2, i3);
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }
}
