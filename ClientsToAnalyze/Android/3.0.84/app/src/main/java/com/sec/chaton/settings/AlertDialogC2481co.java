package com.sec.chaton.settings;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.sec.chaton.R;
import com.sec.chaton.util.C3159aa;

/* compiled from: CustomTimePicker.java */
/* renamed from: com.sec.chaton.settings.co */
/* loaded from: classes.dex */
public class AlertDialogC2481co extends AlertDialog {

    /* renamed from: a */
    private final int f9348a;

    /* renamed from: b */
    private final int f9349b;

    /* renamed from: c */
    private int f9350c;

    /* renamed from: d */
    private int f9351d;

    /* renamed from: e */
    private int f9352e;

    /* renamed from: f */
    private int f9353f;

    /* renamed from: g */
    private ImageButton f9354g;

    /* renamed from: h */
    private ImageButton f9355h;

    /* renamed from: i */
    private ImageButton f9356i;

    /* renamed from: j */
    private ImageButton f9357j;

    /* renamed from: k */
    private ImageButton f9358k;

    /* renamed from: l */
    private ImageButton f9359l;

    /* renamed from: m */
    private ImageButton f9360m;

    /* renamed from: n */
    private ImageButton f9361n;

    /* renamed from: o */
    private EditText f9362o;

    /* renamed from: p */
    private EditText f9363p;

    /* renamed from: q */
    private EditText f9364q;

    /* renamed from: r */
    private EditText f9365r;

    /* renamed from: s */
    private CheckBox f9366s;

    /* renamed from: t */
    private View.OnClickListener f9367t;

    public AlertDialogC2481co(Context context) {
        super(context);
        this.f9348a = 23;
        this.f9349b = 7;
        this.f9367t = new ViewOnClickListenerC2483cq(this);
        ScrollView scrollView = new ScrollView(context);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.alert_time_picker_dialog, (ViewGroup) null);
        scrollView.addView(viewInflate);
        setView(scrollView, 0, 0, 0, 0);
        setIcon(0);
        ((LinearLayout) viewInflate.findViewById(R.id.hiddenLayout)).requestFocus();
        this.f9354g = (ImageButton) viewInflate.findViewById(R.id.btn_start_up);
        this.f9354g.setOnClickListener(this.f9367t);
        this.f9355h = (ImageButton) viewInflate.findViewById(R.id.btn_start_down);
        this.f9355h.setOnClickListener(this.f9367t);
        this.f9356i = (ImageButton) viewInflate.findViewById(R.id.btn_end_up);
        this.f9356i.setOnClickListener(this.f9367t);
        this.f9357j = (ImageButton) viewInflate.findViewById(R.id.btn_end_down);
        this.f9357j.setOnClickListener(this.f9367t);
        this.f9358k = (ImageButton) viewInflate.findViewById(R.id.btn_start_min_up);
        this.f9358k.setOnClickListener(this.f9367t);
        this.f9359l = (ImageButton) viewInflate.findViewById(R.id.btn_start_min_down);
        this.f9359l.setOnClickListener(this.f9367t);
        this.f9360m = (ImageButton) viewInflate.findViewById(R.id.btn_end_min_up);
        this.f9360m.setOnClickListener(this.f9367t);
        this.f9361n = (ImageButton) viewInflate.findViewById(R.id.btn_end_min_down);
        this.f9361n.setOnClickListener(this.f9367t);
        this.f9362o = (EditText) viewInflate.findViewById(R.id.text_start);
        this.f9362o.setText(Integer.toString(this.f9350c));
        this.f9362o.clearFocus();
        this.f9364q = (EditText) viewInflate.findViewById(R.id.text_start_min);
        this.f9363p = (EditText) viewInflate.findViewById(R.id.text_end);
        this.f9363p.setText(Integer.toString(this.f9351d));
        this.f9363p.clearFocus();
        this.f9365r = (EditText) viewInflate.findViewById(R.id.text_end_min);
        m9230b();
        this.f9362o.setFilters(new InputFilter[]{new C2492cz(this, false)});
        this.f9362o.addTextChangedListener(new C2482cp(this));
        this.f9362o.setOnFocusChangeListener(new ViewOnFocusChangeListenerC2484cr(this));
        this.f9364q.setFilters(new InputFilter[]{new C2492cz(this, true)});
        this.f9364q.addTextChangedListener(new C2485cs(this));
        this.f9364q.setOnFocusChangeListener(new ViewOnFocusChangeListenerC2486ct(this));
        this.f9363p.setFilters(new InputFilter[]{new C2492cz(this, false)});
        this.f9363p.addTextChangedListener(new C2487cu(this));
        this.f9363p.setOnFocusChangeListener(new ViewOnFocusChangeListenerC2488cv(this));
        this.f9365r.setFilters(new InputFilter[]{new C2492cz(this, true)});
        this.f9365r.addTextChangedListener(new C2489cw(this));
        this.f9365r.setOnFocusChangeListener(new ViewOnFocusChangeListenerC2490cx(this));
        this.f9366s = (CheckBox) viewInflate.findViewById(R.id.check_repeat);
        this.f9366s.setChecked(C3159aa.m10962a().m10977a("Setting mute repeat", (Boolean) false).booleanValue());
        this.f9366s.setOnClickListener(new ViewOnClickListenerC2491cy(this));
    }

    /* renamed from: b */
    private void m9230b() {
        C2480cn c2480cn = new C2480cn(C3159aa.m10962a().m10976a("Setting mute hour start Long", 0L), C3159aa.m10962a().m10976a("Setting mute hour end Long", 0L));
        if (C3159aa.m10962a().m10978a("Setting mute type", (Integer) 3).intValue() == 2) {
            this.f9350c = c2480cn.m9222f();
            this.f9352e = c2480cn.m9223g();
            this.f9351d = c2480cn.m9224h();
            this.f9353f = c2480cn.m9225i();
        } else {
            this.f9350c = 23;
            this.f9352e = 0;
            this.f9351d = 7;
            this.f9353f = 0;
        }
        this.f9363p.setText(String.format("%02d", Integer.valueOf(this.f9351d)));
        this.f9362o.setText(String.format("%02d", Integer.valueOf(this.f9350c)));
        this.f9365r.setText(String.format("%02d", Integer.valueOf(this.f9353f)));
        this.f9364q.setText(String.format("%02d", Integer.valueOf(this.f9352e)));
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f9350c == this.f9351d) {
            getButton(-2).setEnabled(false);
        } else {
            getButton(-2).setEnabled(true);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        setTitle(getContext().getResources().getString(R.string.settings_mute_manually));
        setCanceledOnTouchOutside(false);
        setIcon(0);
        super.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m9233c() {
        if (this.f9351d == 0) {
            this.f9351d += 24;
        }
        this.f9351d = (this.f9351d - 1) % 24;
        this.f9363p.setText(String.format("%02d", Integer.valueOf(this.f9351d)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m9236d() {
        this.f9351d = (this.f9351d + 1) % 24;
        this.f9363p.setText(String.format("%02d", Integer.valueOf(this.f9351d)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m9238e() {
        if (this.f9350c == 0) {
            this.f9350c += 24;
        }
        this.f9350c = (this.f9350c - 1) % 24;
        this.f9362o.setText(String.format("%02d", Integer.valueOf(this.f9350c)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m9240f() {
        this.f9350c = (this.f9350c + 1) % 24;
        this.f9362o.setText(String.format("%02d", Integer.valueOf(this.f9350c)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m9242g() {
        if (this.f9353f == 0) {
            this.f9353f += 60;
        }
        this.f9353f = (this.f9353f - 1) % 60;
        this.f9365r.setText(String.format("%02d", Integer.valueOf(this.f9353f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m9244h() {
        this.f9353f = (this.f9353f + 1) % 60;
        this.f9365r.setText(String.format("%02d", Integer.valueOf(this.f9353f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m9245i() {
        if (this.f9352e == 0) {
            this.f9352e += 60;
        }
        this.f9352e = (this.f9352e - 1) % 60;
        this.f9364q.setText(String.format("%02d", Integer.valueOf(this.f9352e)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m9247j() {
        this.f9352e = (this.f9352e + 1) % 60;
        this.f9364q.setText(String.format("%02d", Integer.valueOf(this.f9352e)));
    }

    /* renamed from: a */
    public C2480cn m9255a() {
        return new C2480cn(this.f9350c, this.f9352e, this.f9351d, this.f9353f, this.f9366s.isChecked());
    }
}
