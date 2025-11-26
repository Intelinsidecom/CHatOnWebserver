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
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p025d.C1308au;
import com.sec.chaton.p025d.InterfaceC1316bb;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;

/* loaded from: classes.dex */
public class FragmentConnectAccounts extends Fragment {

    /* renamed from: d */
    private Button f8197d;

    /* renamed from: e */
    private Button f8198e;

    /* renamed from: f */
    private Button f8199f;

    /* renamed from: g */
    private Button f8200g;

    /* renamed from: h */
    private FragmentActivity f8201h;

    /* renamed from: i */
    private Button f8202i;

    /* renamed from: j */
    private C1308au f8203j;

    /* renamed from: c */
    private String f8196c = ActivityConnectAccounts.class.getSimpleName();

    /* renamed from: k */
    private ProgressDialog f8204k = null;

    /* renamed from: l */
    private InterfaceC3274d f8205l = null;

    /* renamed from: a */
    View.OnClickListener f8194a = new ViewOnClickListenerC2164bo(this);

    /* renamed from: b */
    InterfaceC1316bb f8195b = new C2165bp(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f8201h = (FragmentActivity) activity;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(R.layout.layout_connect_sns_accounts, viewGroup, false);
        C3250y.m11453c("[LIFE] onCreate", this.f8196c);
        this.f8197d = (Button) viewInflate.findViewById(R.id.twitter);
        this.f8198e = (Button) viewInflate.findViewById(R.id.facebook);
        this.f8199f = (Button) viewInflate.findViewById(R.id.sina_weibo);
        this.f8200g = (Button) viewInflate.findViewById(R.id.renren);
        this.f8202i = (Button) viewInflate.findViewById(R.id.textSkip);
        this.f8197d.setOnClickListener(this.f8194a);
        this.f8198e.setOnClickListener(this.f8194a);
        this.f8199f.setOnClickListener(this.f8194a);
        this.f8200g.setOnClickListener(this.f8194a);
        this.f8202i.setOnClickListener(this.f8194a);
        C0816a.m4368d();
        if (!C0816a.m4369e()) {
            this.f8197d.setVisibility(8);
            this.f8198e.setVisibility(8);
        }
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (C3250y.f11735c) {
            C3250y.m11453c("[LIFE] onDetach", this.f8196c);
        }
        this.f8201h = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (C3250y.f11735c) {
            C3250y.m11453c("[LIFE] onDestroy", this.f8196c);
        }
        m8507d();
        m8503b();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 32665:
                this.f8203j.m5649a(i, i2, intent);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8502a() {
        m8503b();
        this.f8204k = ProgressDialogC3265l.m11489a(this.f8201h, null, getResources().getString(R.string.dialog_provision_ing));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8503b() {
        if (this.f8204k != null && this.f8204k.isShowing()) {
            this.f8204k.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m8506c() {
        m8507d();
        this.f8205l = AbstractC3271a.m11494a(this.f8201h).mo11500a(getResources().getString(R.string.toast_error)).mo11509b(getResources().getString(R.string.sync_fail_retry_again)).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2170bu(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2169bt(this)).mo11505a();
        this.f8205l.show();
    }

    /* renamed from: d */
    private void m8507d() {
        if (this.f8205l != null && this.f8205l.isShowing()) {
            this.f8205l.dismiss();
        }
    }
}
