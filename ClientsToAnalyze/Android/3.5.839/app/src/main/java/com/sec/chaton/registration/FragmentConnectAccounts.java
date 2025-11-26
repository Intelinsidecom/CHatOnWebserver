package com.sec.chaton.registration;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.sec.chaton.R;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p055d.C2105bk;
import com.sec.chaton.p055d.InterfaceC2113bs;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;

/* loaded from: classes.dex */
public class FragmentConnectAccounts extends Fragment {

    /* renamed from: d */
    private Button f11617d;

    /* renamed from: e */
    private Button f11618e;

    /* renamed from: f */
    private Button f11619f;

    /* renamed from: g */
    private Button f11620g;

    /* renamed from: h */
    private FragmentActivity f11621h;

    /* renamed from: i */
    private Button f11622i;

    /* renamed from: j */
    private C2105bk f11623j;

    /* renamed from: c */
    private String f11616c = ActivityConnectAccounts.class.getSimpleName();

    /* renamed from: k */
    private ProgressDialog f11624k = null;

    /* renamed from: l */
    private InterfaceC4936e f11625l = null;

    /* renamed from: a */
    View.OnClickListener f11614a = new ViewOnClickListenerC3163be(this);

    /* renamed from: b */
    InterfaceC2113bs f11615b = new C3164bf(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f11621h = (FragmentActivity) activity;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(R.layout.layout_connect_sns_accounts, viewGroup, false);
        C4904y.m18641c("[LIFE] onCreate", this.f11616c);
        this.f11617d = (Button) viewInflate.findViewById(R.id.twitter);
        this.f11618e = (Button) viewInflate.findViewById(R.id.facebook);
        this.f11619f = (Button) viewInflate.findViewById(R.id.sina_weibo);
        this.f11620g = (Button) viewInflate.findViewById(R.id.renren);
        this.f11622i = (Button) viewInflate.findViewById(R.id.textSkip);
        this.f11617d.setOnClickListener(this.f11614a);
        this.f11618e.setOnClickListener(this.f11614a);
        this.f11619f.setOnClickListener(this.f11614a);
        this.f11620g.setOnClickListener(this.f11614a);
        this.f11622i.setOnClickListener(this.f11614a);
        C1427a.m7521d();
        if (!C1427a.m7522e()) {
            this.f11617d.setVisibility(8);
            this.f11618e.setVisibility(8);
        }
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (C4904y.f17873c) {
            C4904y.m18641c("[LIFE] onDetach", this.f11616c);
        }
        this.f11621h = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (C4904y.f17873c) {
            C4904y.m18641c("[LIFE] onDestroy", this.f11616c);
        }
        m12831d();
        m12827b();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 32665:
                this.f11623j.m9425a(i, i2, intent);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12826a() {
        m12827b();
        this.f11624k = ProgressDialogC4926s.m18727a(this.f11621h, null, getResources().getString(R.string.dialog_provision_ing));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m12827b() {
        if (this.f11624k != null && this.f11624k.isShowing()) {
            this.f11624k.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m12830c() {
        m12831d();
        this.f11625l = AbstractC4932a.m18733a(this.f11621h).mo18740a(getResources().getString(R.string.toast_error)).mo18749b(getResources().getString(R.string.sync_fail_retry_again)).mo18756d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3169bk(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3168bj(this)).mo18745a();
        this.f11625l.show();
    }

    /* renamed from: d */
    private void m12831d() {
        if (this.f11625l != null && this.f11625l.isShowing()) {
            this.f11625l.dismiss();
        }
    }
}
