package com.sec.chaton.userprofile;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Calendar;

/* compiled from: DatePickerWithCheckbox.java */
/* renamed from: com.sec.chaton.userprofile.bs */
/* loaded from: classes.dex */
public class AlertDialogC1249bs extends AlertDialog implements DialogInterface.OnClickListener, DatePicker.OnDateChangedListener {

    /* renamed from: a */
    final Calendar f4331a;

    /* renamed from: b */
    int f4332b;

    /* renamed from: c */
    int f4333c;

    /* renamed from: d */
    int f4334d;

    /* renamed from: e */
    private final DatePicker f4335e;

    /* renamed from: f */
    private final InterfaceC1250bt f4336f;

    /* renamed from: g */
    private final Calendar f4337g;

    /* renamed from: h */
    private final DateFormat f4338h;

    /* renamed from: i */
    private final String[] f4339i;

    /* renamed from: j */
    private int f4340j;

    /* renamed from: k */
    private int f4341k;

    /* renamed from: l */
    private int f4342l;

    /* renamed from: m */
    private CheckBox f4343m;

    /* renamed from: n */
    private LinearLayout f4344n;

    /* renamed from: o */
    private View.OnClickListener f4345o;

    public AlertDialogC1249bs(Context context, InterfaceC1250bt interfaceC1250bt, int i, int i2, int i3) {
        super(context);
        this.f4331a = Calendar.getInstance();
        this.f4332b = this.f4331a.get(1);
        this.f4333c = this.f4331a.get(2);
        this.f4334d = this.f4331a.get(5);
        this.f4345o = new ViewOnClickListenerC1239bi(this);
        this.f4336f = interfaceC1250bt;
        this.f4340j = i;
        this.f4341k = i2;
        this.f4342l = i3;
        this.f4339i = new DateFormatSymbols().getShortWeekdays();
        this.f4338h = DateFormat.getDateInstance(0);
        this.f4337g = Calendar.getInstance();
        setButton2(context.getText(R.string.date_time_set), this);
        setButton(context.getText(R.string.cancel), (DialogInterface.OnClickListener) null);
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.date_picker_checkbox, (ViewGroup) null);
        setView(viewInflate);
        this.f4335e = (DatePicker) viewInflate.findViewById(R.id.datePicker);
        this.f4335e.init(this.f4340j, this.f4341k, this.f4342l, this);
        this.f4343m = (CheckBox) viewInflate.findViewById(R.id.birthday_year_check);
        this.f4343m.setChecked(C1323bs.m4575a().getBoolean("birthday_year_show", false));
        this.f4343m.setClickable(true);
        this.f4344n = (LinearLayout) viewInflate.findViewById(R.id.birthday_year_check_layout);
        this.f4344n.setOnClickListener(this.f4345o);
    }

    @Override // android.app.Dialog
    public void show() {
        setTitle(R.string.setting_birthday);
        setIcon(0);
        super.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f4336f != null) {
            C1323bs.m4576a("birthday_year_show", Boolean.valueOf(this.f4343m.isChecked()));
            this.f4336f.mo4427a(C1323bs.m4575a().getBoolean("birthday_year_show", false));
            C1341p.m4662e("Birthday year show : ", getClass().getSimpleName());
            this.f4335e.clearFocus();
            this.f4336f.mo4426a(this.f4335e, this.f4335e.getYear(), this.f4335e.getMonth(), this.f4335e.getDayOfMonth());
        }
    }

    @Override // android.widget.DatePicker.OnDateChangedListener
    public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
        if (i >= this.f4332b) {
            i = this.f4332b;
            if (i2 >= this.f4333c) {
                i2 = this.f4333c;
                if (i3 > this.f4334d) {
                    i3 = this.f4334d;
                }
            }
        }
        datePicker.init(i, i2, i3, this);
    }

    /* renamed from: a */
    public void m4425a(int i, int i2, int i3) {
        this.f4340j = i;
        this.f4341k = i2;
        this.f4342l = i3;
        this.f4335e.updateDate(i, i2, i3);
    }

    /* renamed from: b */
    private void m4424b(int i, int i2, int i3) {
        this.f4337g.set(1, i);
        this.f4337g.set(2, i2);
        this.f4337g.set(5, i3);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        bundleOnSaveInstanceState.putInt("year", this.f4335e.getYear());
        bundleOnSaveInstanceState.putInt("month", this.f4335e.getMonth());
        bundleOnSaveInstanceState.putInt("day", this.f4335e.getDayOfMonth());
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        int i = bundle.getInt("year");
        int i2 = bundle.getInt("month");
        int i3 = bundle.getInt("day");
        this.f4335e.init(i, i2, i3, this);
        m4424b(i, i2, i3);
    }
}
