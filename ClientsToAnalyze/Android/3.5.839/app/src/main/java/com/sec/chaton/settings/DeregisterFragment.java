package com.sec.chaton.settings;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.coolots.sso.p030a.C0416a;
import com.coolots.sso.p030a.InterfaceC0418c;
import com.sec.chaton.R;
import com.sec.chaton.p055d.AbstractC1899a;
import com.sec.chaton.p055d.C2093az;
import com.sec.chaton.p055d.C2095ba;
import com.sec.chaton.p055d.C2104bj;
import com.sec.chaton.p055d.p056a.C1907ag;
import com.sec.chaton.plugin.C2948h;
import com.sec.chaton.plugin.EnumC2949i;
import com.sec.chaton.settings2.SettingActivity;
import com.sec.chaton.sns.p113a.C4368e;
import com.sec.chaton.sns.p114b.AbstractC4439w;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.HandlerC4826ar;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;

/* loaded from: classes.dex */
public class DeregisterFragment extends Fragment implements InterfaceC0418c {

    /* renamed from: p */
    private static final String f12663p = SettingActivity.class.getSimpleName();

    /* renamed from: c */
    private TextView f12666c;

    /* renamed from: d */
    private TextView f12667d;

    /* renamed from: e */
    private CheckBox f12668e;

    /* renamed from: f */
    private Button f12669f;

    /* renamed from: h */
    private AbstractC1899a<?> f12671h;

    /* renamed from: i */
    private C2104bj f12672i;

    /* renamed from: j */
    private C1907ag f12673j;

    /* renamed from: k */
    private C2095ba f12674k;

    /* renamed from: m */
    private C0416a f12676m;

    /* renamed from: g */
    private ProgressDialog f12670g = null;

    /* renamed from: l */
    private InterfaceC4936e f12675l = null;

    /* renamed from: n */
    private boolean f12677n = false;

    /* renamed from: o */
    private String f12678o = null;

    /* renamed from: a */
    HandlerC4826ar f12664a = new HandlerC3591ea(this);

    /* renamed from: b */
    public Handler f12665b = new HandlerC3592eb(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f12674k = new C2095ba(this.f12665b);
        this.f12671h = C2093az.m9337a();
        this.f12677n = C4822an.m18255w();
        this.f12672i = new C2104bj(this.f12665b);
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.getExtras() != null) {
            this.f12678o = intent.getExtras().getString("key_chaton_id");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_deregister_device, viewGroup, false);
        this.f12666c = (TextView) viewInflate.findViewById(R.id.deregister_textview);
        this.f12667d = (TextView) viewInflate.findViewById(R.id.deregister_textview_number);
        this.f12668e = (CheckBox) viewInflate.findViewById(R.id.agree_checkbox);
        viewInflate.findViewById(R.id.layout_agree_checkbox);
        this.f12669f = (Button) viewInflate.findViewById(R.id.ok_button);
        if (this.f12677n) {
            if (C4859bx.m18386a((Context) getActivity()) && new C0416a().m1495d(getActivity())) {
                this.f12666c.setText(getActivity().getResources().getString(R.string.multideivce_delete_account_chatonv));
            }
        } else {
            String strM18121a = C4809aa.m18104a().m18121a("msisdn", (String) null);
            String str = "";
            if (C4822an.m18218a()) {
                if (TextUtils.isEmpty(strM18121a)) {
                    this.f12666c.setText(getActivity().getResources().getString(R.string.multideivce_delete_account));
                } else {
                    this.f12666c.setText(getActivity().getResources().getString(R.string.multideivce_delete_account));
                    str = "+" + strM18121a;
                }
                this.f12667d.setVisibility(0);
                String strMo16647b = AbstractC4439w.m16816a(C4368e.f15815a, getActivity()).mo16647b();
                String strMo16647b2 = AbstractC4439w.m16816a(C4368e.f15818d, getActivity()).mo16647b();
                String strMo16647b3 = AbstractC4439w.m16816a(C4368e.f15820f, getActivity()).mo16647b();
                if (!TextUtils.isEmpty(strMo16647b)) {
                    if (!TextUtils.isEmpty(str)) {
                        str = str + "\n" + strMo16647b;
                    } else {
                        str = str + strMo16647b;
                    }
                }
                if (!TextUtils.isEmpty(strMo16647b2)) {
                    if (!TextUtils.isEmpty(str)) {
                        str = str + "\n" + strMo16647b2;
                    } else {
                        str = str + strMo16647b2;
                    }
                }
                if (!TextUtils.isEmpty(strMo16647b3)) {
                    if (!TextUtils.isEmpty(str)) {
                        str = str + "\n" + strMo16647b3;
                    } else {
                        str = str + strMo16647b3;
                    }
                }
                this.f12667d.setText(str);
            } else {
                this.f12666c.setText(getActivity().getResources().getString(R.string.comment_service_terminated));
            }
        }
        this.f12668e.setOnCheckedChangeListener(new C3588dy(this));
        this.f12669f.setOnClickListener(new ViewOnClickListenerC3589dz(this));
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m13548b() {
        if (this.f12668e.isChecked()) {
            this.f12669f.setEnabled(true);
        } else {
            this.f12669f.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m13549c() {
        if (this.f12670g != null && this.f12670g.isShowing()) {
            this.f12670g.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m13552d() {
        m13554e();
        this.f12675l = AbstractC4932a.m18733a(getActivity()).mo18734a(R.string.deregister_device).mo18746b(R.string.toast_dereg_failed).mo18751b(true).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3593ec(this)).mo18752b();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (C2948h.m12190a().m12192a(getActivity(), EnumC2949i.ChatONV) && this.f12676m != null) {
            this.f12676m.m1491a(getActivity(), (InterfaceC0418c) null);
            C4904y.m18639b("onDestroy:mChatonV.setListener(null)", f12663p);
        }
        m13549c();
        m13554e();
    }

    /* renamed from: e */
    private void m13554e() {
        if (this.f12675l != null && this.f12675l.isShowing()) {
            this.f12675l.dismiss();
        }
    }

    @Override // com.coolots.sso.p030a.InterfaceC0418c
    /* renamed from: a */
    public void mo1508a(boolean z, String str) {
    }

    @Override // com.coolots.sso.p030a.InterfaceC0418c
    /* renamed from: a_ */
    public void mo1509a_(boolean z) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onReceiveRemoveAccount : " + z, f12663p);
        }
        this.f12671h.mo9079b(this.f12664a);
        this.f12664a.m18262a(30000);
    }
}
