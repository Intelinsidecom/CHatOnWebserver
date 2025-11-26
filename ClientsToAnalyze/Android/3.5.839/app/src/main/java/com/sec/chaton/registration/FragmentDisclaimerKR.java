package com.sec.chaton.registration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class FragmentDisclaimerKR extends FragmentDisclaimerGlobal {

    /* renamed from: x */
    private static final String f11643x = FragmentDisclaimerKR.class.getSimpleName();

    /* renamed from: j */
    private Button f11644j;

    /* renamed from: k */
    private CheckBox f11645k;

    /* renamed from: l */
    private CheckBox f11646l;

    /* renamed from: m */
    private CheckBox f11647m;

    /* renamed from: n */
    private CheckBox f11648n;

    /* renamed from: o */
    private LinearLayout f11649o;

    /* renamed from: p */
    private LinearLayout f11650p;

    /* renamed from: q */
    private LinearLayout f11651q;

    /* renamed from: r */
    private LinearLayout f11652r;

    /* renamed from: s */
    private LinearLayout f11653s;

    /* renamed from: t */
    private ImageButton f11654t;

    /* renamed from: u */
    private ImageButton f11655u;

    /* renamed from: v */
    private ImageButton f11656v;

    /* renamed from: w */
    private ImageButton f11657w;

    @Override // com.sec.chaton.registration.FragmentDisclaimerGlobal, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(R.layout.new_disclaimer_view, viewGroup, false);
        this.f11644j = (Button) viewInflate.findViewById(R.id.accept_button);
        this.f11645k = (CheckBox) viewInflate.findViewById(R.id.disclaimer_chekcbox);
        this.f11649o = (LinearLayout) viewInflate.findViewById(R.id.linear_disclaimer_chekcbox);
        this.f11646l = (CheckBox) viewInflate.findViewById(R.id.disclaimer_chekcbox2);
        this.f11647m = (CheckBox) viewInflate.findViewById(R.id.disclaimer_chekcbox3);
        this.f11648n = (CheckBox) viewInflate.findViewById(R.id.disclaimer_chekcbox4);
        this.f11650p = (LinearLayout) viewInflate.findViewById(R.id.linear_disclaimer_chekcbox2);
        this.f11651q = (LinearLayout) viewInflate.findViewById(R.id.linear_disclaimer_chekcbox3);
        this.f11652r = (LinearLayout) viewInflate.findViewById(R.id.linear_disclaimer_chekcbox4);
        this.f11653s = (LinearLayout) viewInflate.findViewById(R.id.spp_marketing);
        this.f11654t = (ImageButton) viewInflate.findViewById(R.id.link_button);
        this.f11655u = (ImageButton) viewInflate.findViewById(R.id.link_button2);
        this.f11656v = (ImageButton) viewInflate.findViewById(R.id.link_button3);
        this.f11657w = (ImageButton) viewInflate.findViewById(R.id.link_button4);
        if (!this.f11632f) {
            this.f11653s.setVisibility(8);
        }
        m12845a((TextView) viewInflate.findViewById(R.id.text_comment));
        this.f11644j.setOnClickListener(new ViewOnClickListenerC3186ca(this));
        this.f11654t.setOnClickListener(new ViewOnClickListenerC3187cb(this));
        this.f11655u.setOnClickListener(new ViewOnClickListenerC3188cc(this));
        this.f11656v.setOnClickListener(new ViewOnClickListenerC3189cd(this));
        this.f11657w.setOnClickListener(new ViewOnClickListenerC3190ce(this));
        this.f11649o.setOnClickListener(new ViewOnClickListenerC3191cf(this));
        this.f11650p.setOnClickListener(new ViewOnClickListenerC3192cg(this));
        this.f11651q.setOnClickListener(new ViewOnClickListenerC3193ch(this));
        this.f11652r.setOnClickListener(new ViewOnClickListenerC3194ci(this));
        this.f11649o.setFocusable(true);
        this.f11645k.setClickable(false);
        this.f11650p.setFocusable(true);
        this.f11646l.setClickable(false);
        this.f11651q.setFocusable(true);
        this.f11647m.setClickable(false);
        this.f11652r.setFocusable(true);
        this.f11648n.setClickable(false);
        return viewInflate;
    }

    @Override // com.sec.chaton.registration.FragmentDisclaimerGlobal, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (C4904y.f17872b) {
            C4904y.m18639b("onResume ", f11643x);
        }
        m12854f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m12854f() {
        if (this.f11645k.isChecked() && this.f11646l.isChecked()) {
            this.f11644j.setEnabled(true);
        } else {
            this.f11644j.setEnabled(false);
        }
    }

    @Override // com.sec.chaton.registration.FragmentDisclaimerGlobal
    /* renamed from: c */
    protected boolean mo12847c() {
        return this.f11648n.isChecked();
    }
}
