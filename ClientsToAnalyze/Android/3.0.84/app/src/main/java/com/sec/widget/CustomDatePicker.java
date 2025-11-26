package com.sec.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import com.sec.chaton.R;
import java.text.DateFormatSymbols;
import java.util.Calendar;

/* loaded from: classes.dex */
public class CustomDatePicker extends FrameLayout {

    /* renamed from: c */
    private final EditText f13353c;

    /* renamed from: d */
    private final EditText f13354d;

    /* renamed from: e */
    private final EditText f13355e;

    /* renamed from: f */
    private final CheckBox f13356f;

    /* renamed from: g */
    private final NumberPicker f13357g;

    /* renamed from: h */
    private final NumberPicker f13358h;

    /* renamed from: i */
    private final NumberPicker f13359i;

    /* renamed from: j */
    private InterfaceC3680n f13360j;

    /* renamed from: k */
    private int f13361k;

    /* renamed from: l */
    private int f13362l;

    /* renamed from: m */
    private int f13363m;

    /* renamed from: n */
    private boolean f13364n;

    /* renamed from: o */
    private boolean f13365o;

    /* renamed from: b */
    private static int f13352b = 1;

    /* renamed from: a */
    public static final NumberPicker.Formatter f13351a = new C3671e();

    public CustomDatePicker(Context context) {
        this(context, null);
    }

    public CustomDatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13363m = 2000;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.layout_date_picker, (ViewGroup) this, true);
        this.f13357g = (NumberPicker) findViewById(R.id.day);
        this.f13357g.setFormatter(f13351a);
        this.f13357g.setMinValue(1);
        this.f13357g.setOnLongPressUpdateInterval(100L);
        this.f13357g.setOnValueChangedListener(new C3669c(this));
        if (this.f13357g.getChildCount() == 1) {
            f13352b = 0;
            this.f13353c = null;
        } else {
            this.f13353c = (EditText) this.f13357g.getChildAt(f13352b);
            this.f13353c.setTextColor(getResources().getColor(R.color.black));
        }
        this.f13358h = (NumberPicker) findViewById(R.id.month);
        this.f13358h.setFormatter(f13351a);
        String[] shortMonths = new DateFormatSymbols().getShortMonths();
        if (shortMonths[0].startsWith("1")) {
            for (int i2 = 0; i2 < shortMonths.length; i2++) {
                shortMonths[i2] = String.valueOf(i2 + 1);
            }
            this.f13358h.setMinValue(1);
            this.f13358h.setMaxValue(12);
        } else {
            this.f13358h.setMinValue(1);
            this.f13358h.setMaxValue(12);
        }
        if (f13352b == 0) {
            this.f13354d = null;
        } else {
            this.f13354d = (EditText) this.f13358h.getChildAt(f13352b);
            this.f13354d.setTextColor(getResources().getColor(R.color.black));
        }
        this.f13358h.setOnLongPressUpdateInterval(200L);
        this.f13358h.setOnValueChangedListener(new C3672f(this));
        this.f13359i = (NumberPicker) findViewById(R.id.year);
        this.f13359i.setOnLongPressUpdateInterval(100L);
        this.f13359i.setOnValueChangedListener(new C3673g(this));
        if (f13352b == 0) {
            this.f13355e = null;
        } else {
            this.f13355e = (EditText) this.f13359i.getChildAt(f13352b);
            this.f13355e.setTextColor(getResources().getColor(R.color.black));
        }
        this.f13356f = (CheckBox) findViewById(R.id.yearToggle);
        this.f13356f.setOnCheckedChangeListener(new C3674h(this));
        this.f13359i.setMinValue(1900);
        this.f13359i.setMaxValue(2100);
        if (this.f13355e != null) {
            this.f13355e.addTextChangedListener(new C3675i(this));
            this.f13355e.setOnFocusChangeListener(new ViewOnFocusChangeListenerC3676j(this));
        }
        if (this.f13354d != null) {
            this.f13354d.addTextChangedListener(new C3677k(this));
            this.f13354d.setOnFocusChangeListener(new ViewOnFocusChangeListenerC3678l(this));
        }
        if (this.f13353c != null) {
            this.f13353c.addTextChangedListener(new C3679m(this));
            this.f13353c.setOnFocusChangeListener(new ViewOnFocusChangeListenerC3670d(this));
        }
        Calendar calendar = Calendar.getInstance();
        m13077a(calendar.get(1), calendar.get(2), calendar.get(5), null);
        m13061a(shortMonths);
        if (!isEnabled()) {
            setEnabled(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f13357g.setEnabled(z);
        this.f13358h.setEnabled(z);
        this.f13359i.setEnabled(z);
    }

    /* renamed from: a */
    private void m13061a(String[] strArr) {
        EditText editText;
        char[] dateFormatOrder = DateFormat.getDateFormatOrder(getContext());
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.parent);
        linearLayout.removeAllViews();
        int length = dateFormatOrder.length;
        int i = 0;
        int i2 = 1;
        while (i < length) {
            char c = dateFormatOrder[i];
            NumberPicker numberPicker = null;
            if (c == 'd') {
                linearLayout.addView(this.f13357g);
                numberPicker = this.f13357g;
            } else if (c == 'M') {
                linearLayout.addView(this.f13358h);
                numberPicker = this.f13358h;
            } else if (c == 'y') {
                linearLayout.addView(this.f13359i);
                numberPicker = this.f13359i;
            }
            if (numberPicker != null && numberPicker.getChildCount() > 2) {
                View childAt = numberPicker.getChildAt(1);
                if (childAt.getClass().getSimpleName().contains("EditText") && (editText = (EditText) childAt) != null) {
                    if (i2 == dateFormatOrder.length) {
                        editText.setImeOptions(268435462);
                    } else {
                        editText.setImeOptions(268435461);
                    }
                }
            }
            i++;
            i2++;
        }
    }

    /* renamed from: a */
    public void m13076a(int i, int i2, int i3) throws NumberFormatException {
        if (this.f13363m != i || this.f13362l != i2 || this.f13361k != i3) {
            if (this.f13364n && i == 0) {
                i = m13067d();
            }
            this.f13363m = i;
            this.f13362l = i2;
            this.f13361k = i3;
            m13069e();
            m13061a(new DateFormatSymbols().getShortMonths());
            m13074j();
        }
    }

    /* renamed from: d */
    private int m13067d() {
        return Calendar.getInstance().get(1);
    }

    class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C3681o();
        private final int mDay;
        private final boolean mHasYear;
        private final int mMonth;
        private final int mYear;
        private final boolean mYearOptional;

        /* synthetic */ SavedState(Parcel parcel, C3669c c3669c) {
            this(parcel);
        }

        /* synthetic */ SavedState(Parcelable parcelable, int i, int i2, int i3, boolean z, boolean z2, C3669c c3669c) {
            this(parcelable, i, i2, i3, z, z2);
        }

        private SavedState(Parcelable parcelable, int i, int i2, int i3, boolean z, boolean z2) {
            super(parcelable);
            this.mYear = i;
            this.mMonth = i2;
            this.mDay = i3;
            this.mHasYear = z;
            this.mYearOptional = z2;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mYear = parcel.readInt();
            this.mMonth = parcel.readInt();
            this.mDay = parcel.readInt();
            this.mHasYear = parcel.readInt() != 0;
            this.mYearOptional = parcel.readInt() != 0;
        }

        /* renamed from: a */
        public int m13081a() {
            return this.mYear;
        }

        /* renamed from: b */
        public int m13082b() {
            return this.mMonth;
        }

        /* renamed from: c */
        public int m13083c() {
            return this.mDay;
        }

        /* renamed from: d */
        public boolean m13084d() {
            return this.mHasYear;
        }

        /* renamed from: e */
        public boolean m13085e() {
            return this.mYearOptional;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mYear);
            parcel.writeInt(this.mMonth);
            parcel.writeInt(this.mDay);
            parcel.writeInt(this.mHasYear ? 1 : 0);
            parcel.writeInt(this.mYearOptional ? 1 : 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f13363m, this.f13362l, this.f13361k, this.f13365o, this.f13364n, null);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f13363m = savedState.m13081a();
        this.f13362l = savedState.m13082b();
        this.f13361k = savedState.m13083c();
        this.f13365o = savedState.m13084d();
        this.f13364n = savedState.m13085e();
        m13069e();
    }

    /* renamed from: a */
    public void m13077a(int i, int i2, int i3, InterfaceC3680n interfaceC3680n) {
        m13078a(i, i2, i3, false, interfaceC3680n);
    }

    /* renamed from: a */
    public void m13078a(int i, int i2, int i3, boolean z, InterfaceC3680n interfaceC3680n) {
        this.f13363m = (z && i == 0) ? m13067d() : i;
        this.f13362l = i2;
        this.f13361k = i3;
        this.f13364n = z;
        boolean z2 = (z && i == 0) ? false : true;
        this.f13365o = z2;
        this.f13360j = interfaceC3680n;
        m13069e();
    }

    /* renamed from: a */
    private void m13059a(EditText editText, int i) {
        if (editText != null) {
            String string = Integer.toString(i);
            editText.setText(string);
            if (editText.isFocused()) {
                editText.setSelection(string.length());
            }
        }
    }

    /* renamed from: e */
    private void m13069e() {
        m13070f();
        this.f13356f.setChecked(this.f13365o);
        this.f13356f.setVisibility(this.f13364n ? 0 : 8);
        this.f13359i.setValue(this.f13363m);
        m13059a(this.f13355e, this.f13363m);
        this.f13359i.setVisibility(this.f13365o ? 0 : 8);
        this.f13358h.setValue(this.f13362l + 1);
        m13059a(this.f13354d, this.f13362l + 1);
    }

    /* renamed from: f */
    private void m13070f() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(this.f13365o ? this.f13363m : 2000, this.f13362l, 1);
        this.f13357g.setMaxValue(calendar.getActualMaximum(5));
        this.f13357g.setValue(this.f13361k);
        m13059a(this.f13353c, this.f13361k);
    }

    /* renamed from: a */
    public int m13075a() {
        if (!this.f13364n || this.f13365o) {
            return this.f13363m;
        }
        return 0;
    }

    /* renamed from: b */
    public int m13079b() {
        return this.f13362l;
    }

    /* renamed from: c */
    public int m13080c() {
        return this.f13361k;
    }

    /* renamed from: g */
    private void m13071g() throws NumberFormatException {
        if (this.f13353c != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(1, this.f13365o ? this.f13363m : 2000);
            calendar.set(2, this.f13362l);
            int actualMaximum = calendar.getActualMaximum(5);
            String string = this.f13353c.getText().toString();
            int i = 0;
            if (string != null && !string.equals("")) {
                i = Integer.parseInt(string);
            }
            this.f13361k = i;
            if (this.f13361k > actualMaximum || this.f13361k == 0) {
                this.f13361k = actualMaximum;
            }
        }
    }

    /* renamed from: h */
    private void m13072h() throws NumberFormatException {
        if (this.f13355e != null) {
            String string = this.f13355e.getText().toString();
            int i = 0;
            if (string != null && !string.equals("")) {
                i = Integer.parseInt(string);
            }
            this.f13363m = i;
            if (this.f13363m > 2100) {
                this.f13363m = 2100;
            } else if (this.f13363m < 1900) {
                this.f13363m = 1900;
            }
        }
    }

    /* renamed from: i */
    private void m13073i() throws NumberFormatException {
        if (this.f13354d != null) {
            String string = this.f13354d.getText().toString();
            int i = 0;
            if (string != null && !string.equals("")) {
                i = Integer.parseInt(string);
                this.f13362l = i - 1;
            }
            if (i == 0) {
                this.f13362l = 11;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m13074j() throws NumberFormatException {
        m13072h();
        m13073i();
        m13071g();
        m13069e();
        if (this.f13360j != null) {
            this.f13360j.mo10942a(this, (!this.f13364n || this.f13365o) ? this.f13363m : 0, this.f13362l, this.f13361k);
        }
    }
}
