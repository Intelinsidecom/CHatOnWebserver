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
import com.sec.chaton.util.C4809aa;

/* compiled from: CustomTimePicker.java */
/* renamed from: com.sec.chaton.settings.dm */
/* loaded from: classes.dex */
public class AlertDialogC3576dm extends AlertDialog {

    /* renamed from: a */
    private final int f13073a;

    /* renamed from: b */
    private final int f13074b;

    /* renamed from: c */
    private int f13075c;

    /* renamed from: d */
    private int f13076d;

    /* renamed from: e */
    private int f13077e;

    /* renamed from: f */
    private int f13078f;

    /* renamed from: g */
    private ImageButton f13079g;

    /* renamed from: h */
    private ImageButton f13080h;

    /* renamed from: i */
    private ImageButton f13081i;

    /* renamed from: j */
    private ImageButton f13082j;

    /* renamed from: k */
    private ImageButton f13083k;

    /* renamed from: l */
    private ImageButton f13084l;

    /* renamed from: m */
    private ImageButton f13085m;

    /* renamed from: n */
    private ImageButton f13086n;

    /* renamed from: o */
    private EditText f13087o;

    /* renamed from: p */
    private EditText f13088p;

    /* renamed from: q */
    private EditText f13089q;

    /* renamed from: r */
    private EditText f13090r;

    /* renamed from: s */
    private LinearLayout f13091s;

    /* renamed from: t */
    private CheckBox f13092t;

    /* renamed from: u */
    private View.OnClickListener f13093u;

    public AlertDialogC3576dm(Context context) {
        super(context);
        this.f13073a = 23;
        this.f13074b = 7;
        this.f13093u = new ViewOnClickListenerC3578do(this);
        ScrollView scrollView = new ScrollView(context);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.alert_time_picker_dialog, (ViewGroup) null);
        scrollView.addView(viewInflate);
        setView(scrollView, 0, 0, 0, 0);
        setIcon(0);
        ((LinearLayout) viewInflate.findViewById(R.id.hiddenLayout)).requestFocus();
        this.f13079g = (ImageButton) viewInflate.findViewById(R.id.btn_start_up);
        this.f13079g.setOnClickListener(this.f13093u);
        this.f13080h = (ImageButton) viewInflate.findViewById(R.id.btn_start_down);
        this.f13080h.setOnClickListener(this.f13093u);
        this.f13081i = (ImageButton) viewInflate.findViewById(R.id.btn_end_up);
        this.f13081i.setOnClickListener(this.f13093u);
        this.f13082j = (ImageButton) viewInflate.findViewById(R.id.btn_end_down);
        this.f13082j.setOnClickListener(this.f13093u);
        this.f13083k = (ImageButton) viewInflate.findViewById(R.id.btn_start_min_up);
        this.f13083k.setOnClickListener(this.f13093u);
        this.f13084l = (ImageButton) viewInflate.findViewById(R.id.btn_start_min_down);
        this.f13084l.setOnClickListener(this.f13093u);
        this.f13085m = (ImageButton) viewInflate.findViewById(R.id.btn_end_min_up);
        this.f13085m.setOnClickListener(this.f13093u);
        this.f13086n = (ImageButton) viewInflate.findViewById(R.id.btn_end_min_down);
        this.f13086n.setOnClickListener(this.f13093u);
        this.f13087o = (EditText) viewInflate.findViewById(R.id.text_start);
        this.f13087o.setText(Integer.toString(23));
        this.f13087o.clearFocus();
        this.f13089q = (EditText) viewInflate.findViewById(R.id.text_start_min);
        this.f13088p = (EditText) viewInflate.findViewById(R.id.text_end);
        this.f13088p.setText(Integer.toString(7));
        this.f13088p.clearFocus();
        this.f13090r = (EditText) viewInflate.findViewById(R.id.text_end_min);
        m13869b();
        this.f13087o.setFilters(new InputFilter[]{new C3587dx(this, false)});
        this.f13087o.addTextChangedListener(new C3577dn(this));
        this.f13087o.setOnFocusChangeListener(new ViewOnFocusChangeListenerC3579dp(this));
        this.f13089q.setFilters(new InputFilter[]{new C3587dx(this, true)});
        this.f13089q.addTextChangedListener(new C3580dq(this));
        this.f13089q.setOnFocusChangeListener(new ViewOnFocusChangeListenerC3581dr(this));
        this.f13088p.setFilters(new InputFilter[]{new C3587dx(this, false)});
        this.f13088p.addTextChangedListener(new C3582ds(this));
        this.f13088p.setOnFocusChangeListener(new ViewOnFocusChangeListenerC3583dt(this));
        this.f13090r.setFilters(new InputFilter[]{new C3587dx(this, true)});
        this.f13090r.addTextChangedListener(new C3584du(this));
        this.f13090r.setOnFocusChangeListener(new ViewOnFocusChangeListenerC3585dv(this));
        this.f13091s = (LinearLayout) viewInflate.findViewById(R.id.layoutcheck_repeat);
        this.f13091s.setOnClickListener(new ViewOnClickListenerC3586dw(this));
        this.f13092t = (CheckBox) viewInflate.findViewById(R.id.check_repeat);
        this.f13092t.setClickable(false);
        this.f13092t.setChecked(C4809aa.m18104a().m18119a("Setting mute repeat", (Boolean) false).booleanValue());
    }

    /* renamed from: b */
    private void m13869b() {
        C3575dl c3575dlM13853a = C3575dl.m13853a(C4809aa.m18104a().m18118a("Setting mute hour start Long", 0L), C4809aa.m18104a().m18118a("Setting mute hour end Long", 0L));
        if (C4809aa.m18104a().m18120a("Setting mute type", (Integer) 3).intValue() == 2) {
            this.f13075c = c3575dlM13853a.m13861f();
            this.f13077e = c3575dlM13853a.m13862g();
            this.f13076d = c3575dlM13853a.m13863h();
            this.f13078f = c3575dlM13853a.m13864i();
        } else {
            this.f13075c = 23;
            this.f13077e = 0;
            this.f13076d = 7;
            this.f13078f = 0;
        }
        this.f13088p.setText(String.format("%02d", Integer.valueOf(this.f13076d)));
        this.f13087o.setText(String.format("%02d", Integer.valueOf(this.f13075c)));
        this.f13090r.setText(String.format("%02d", Integer.valueOf(this.f13078f)));
        this.f13089q.setText(String.format("%02d", Integer.valueOf(this.f13077e)));
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f13075c == this.f13076d) {
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
    public void m13872c() {
        if (this.f13076d == 0) {
            this.f13076d += 24;
        }
        this.f13076d = (this.f13076d - 1) % 24;
        this.f13088p.setText(String.format("%02d", Integer.valueOf(this.f13076d)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m13875d() {
        this.f13076d = (this.f13076d + 1) % 24;
        this.f13088p.setText(String.format("%02d", Integer.valueOf(this.f13076d)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m13877e() {
        if (this.f13075c == 0) {
            this.f13075c += 24;
        }
        this.f13075c = (this.f13075c - 1) % 24;
        this.f13087o.setText(String.format("%02d", Integer.valueOf(this.f13075c)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m13879f() {
        this.f13075c = (this.f13075c + 1) % 24;
        this.f13087o.setText(String.format("%02d", Integer.valueOf(this.f13075c)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m13881g() {
        if (this.f13078f == 0) {
            this.f13078f += 60;
        }
        this.f13078f = (this.f13078f - 1) % 60;
        this.f13090r.setText(String.format("%02d", Integer.valueOf(this.f13078f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m13883h() {
        this.f13078f = (this.f13078f + 1) % 60;
        this.f13090r.setText(String.format("%02d", Integer.valueOf(this.f13078f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m13885i() {
        if (this.f13077e == 0) {
            this.f13077e += 60;
        }
        this.f13077e = (this.f13077e - 1) % 60;
        this.f13089q.setText(String.format("%02d", Integer.valueOf(this.f13077e)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m13886j() {
        this.f13077e = (this.f13077e + 1) % 60;
        this.f13089q.setText(String.format("%02d", Integer.valueOf(this.f13077e)));
    }

    /* renamed from: a */
    public C3575dl m13895a() {
        return C3575dl.m13852a(this.f13075c, this.f13077e, this.f13076d, this.f13078f, this.f13092t.isChecked());
    }
}
