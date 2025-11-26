package com.sec.chaton.settings;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.C2075ah;
import com.sec.chaton.p055d.C2105bk;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p055d.InterfaceC2113bs;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.sns.p113a.C4368e;
import com.sec.chaton.sns.p114b.AbstractC4439w;
import com.sec.chaton.sns.p114b.InterfaceC4377ac;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;

/* loaded from: classes.dex */
public class AccountFragment extends Fragment {

    /* renamed from: l */
    private static final String f12465l = AccountFragment.class.getName().toString();

    /* renamed from: A */
    private boolean f12466A;

    /* renamed from: B */
    private boolean f12467B;

    /* renamed from: C */
    private boolean f12468C;

    /* renamed from: G */
    private Button f12472G;

    /* renamed from: H */
    private FragmentActivity f12473H;

    /* renamed from: b */
    Integer f12476b;

    /* renamed from: j */
    private ListView f12484j;

    /* renamed from: m */
    private int f12486m;

    /* renamed from: n */
    private Context f12487n;

    /* renamed from: p */
    private C2075ah f12489p;

    /* renamed from: q */
    private C2105bk f12490q;

    /* renamed from: s */
    private LayoutInflater f12492s;

    /* renamed from: t */
    private String f12493t;

    /* renamed from: y */
    private C2128i f12498y;

    /* renamed from: d */
    private final int f12478d = 0;

    /* renamed from: e */
    private final int f12479e = 1;

    /* renamed from: f */
    private final int f12480f = 2;

    /* renamed from: g */
    private final int f12481g = 3;

    /* renamed from: h */
    private final int f12482h = 4;

    /* renamed from: i */
    private final int f12483i = 5;

    /* renamed from: k */
    private C3682t f12485k = null;

    /* renamed from: o */
    private ProgressDialog f12488o = null;

    /* renamed from: r */
    private InterfaceC4936e f12491r = null;

    /* renamed from: u */
    private AbstractC4439w f12494u = null;

    /* renamed from: v */
    private AbstractC4439w f12495v = null;

    /* renamed from: w */
    private AbstractC4439w f12496w = null;

    /* renamed from: x */
    private AbstractC4439w f12497x = null;

    /* renamed from: z */
    private int f12499z = 6;

    /* renamed from: D */
    private boolean f12469D = true;

    /* renamed from: E */
    private boolean f12470E = true;

    /* renamed from: F */
    private boolean f12471F = true;

    /* renamed from: a */
    InterfaceC2113bs f12475a = new C3664l(this);

    /* renamed from: I */
    private InterfaceC4377ac f12474I = new C3680r(this);

    /* renamed from: c */
    Handler f12477c = new HandlerC3681s(this, Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m13335b() {
        this.f12492s = LayoutInflater.from(this.f12487n);
        this.f12493t = C4822an.m18198H();
        if (this.f12494u == null) {
            this.f12494u = AbstractC4439w.m16816a(C4822an.m18198H(), this.f12487n);
        }
        if (this.f12495v == null) {
            this.f12495v = AbstractC4439w.m16816a(C4368e.f15815a, this.f12487n);
        }
        if (this.f12496w == null) {
            this.f12496w = AbstractC4439w.m16816a(C4368e.f15818d, this.f12487n);
        }
        if (this.f12497x == null) {
            this.f12497x = AbstractC4439w.m16816a(C4368e.f15820f, this.f12487n);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Throwable {
        if (C4904y.f17872b) {
            C4904y.m18639b("onCreateView", getClass().getSimpleName());
        }
        View viewInflate = layoutInflater.inflate(R.layout.layout_settings_account, viewGroup, false);
        this.f12484j = (ListView) viewInflate.findViewById(R.id.layout_list_header);
        this.f12484j.setItemsCanFocus(true);
        View viewInflate2 = layoutInflater.inflate(R.layout.layout_register_red_button_type, (ViewGroup) null);
        this.f12472G = (Button) viewInflate2.findViewById(R.id.button);
        if (C4822an.m18255w()) {
            this.f12472G.setText(R.string.deregister_device);
            this.f12472G.setContentDescription(getString(R.string.deregister_device));
        } else {
            this.f12472G.setText(R.string.delete_account);
            this.f12472G.setContentDescription(getString(R.string.delete_account));
        }
        this.f12472G.setOnClickListener(new ViewOnClickListenerC3662j(this));
        this.f12484j.addFooterView(viewInflate2, null, true);
        this.f12466A = C4368e.f15815a.equals(this.f12493t);
        this.f12467B = C4368e.f15818d.equals(this.f12493t);
        this.f12468C = C4368e.f15820f.equals(this.f12493t);
        String strM18121a = C4809aa.m18104a().m18121a("country_letter", "");
        if (!this.f12466A && (!C4859bx.m18408f((String) null) || !C4859bx.m18408f(strM18121a))) {
            this.f12469D = false;
            this.f12499z--;
        }
        if (!this.f12468C && (!C4859bx.m18411g((String) null) || !C4859bx.m18411g(strM18121a))) {
            this.f12470E = false;
            this.f12499z--;
        }
        if (!this.f12467B && !C4859bx.m18413h(strM18121a)) {
            this.f12471F = false;
            this.f12499z--;
        }
        if (this.f12499z == 3) {
            this.f12499z--;
        }
        this.f12485k = new C3682t(this);
        this.f12484j.setAdapter((ListAdapter) this.f12485k);
        this.f12484j.setOnItemClickListener(new C3663k(this));
        this.f12484j.setFooterDividersEnabled(false);
        if (C4822an.m18255w()) {
            this.f12488o = ProgressDialogC4926s.m18727a(this.f12487n, null, getResources().getString(R.string.dialog_provision_ing));
            this.f12488o.setCancelable(true);
            this.f12489p.m9312c(null);
        }
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public boolean m13340c() {
        return C4368e.m16564a(GlobalApplication.m18732r()).m16566a(C4368e.f15815a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public boolean m13341d() {
        return C4368e.m16564a(this.f12487n).m16566a(C4368e.f15818d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public boolean m13343e() {
        return C4368e.m16564a(this.f12487n).m16566a(C4368e.f15820f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m13345f() {
        m13348g();
        this.f12488o = ProgressDialogC4926s.m18727a(getActivity(), null, getResources().getString(R.string.dialog_provision_ing));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m13348g() {
        if (this.f12488o != null && this.f12488o.isShowing()) {
            this.f12488o.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m13349h() {
        m13351i();
        this.f12491r = AbstractC4932a.m18733a(getActivity()).mo18740a(getResources().getString(R.string.toast_error)).mo18749b(getResources().getString(R.string.sync_fail_retry_again)).mo18756d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3679q(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3678p(this)).mo18745a();
        this.f12491r.show();
    }

    /* renamed from: i */
    private void m13351i() {
        if (this.f12491r != null && this.f12491r.isShowing()) {
            this.f12491r.dismiss();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f12487n = getActivity();
        this.f12473H = getActivity();
        this.f12489p = new C2075ah(this.f12477c);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C4904y.m18646e("onConfigurationChagne", getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (C4904y.f17872b) {
            C4904y.m18639b("onDestroyView ", f12465l);
        }
        if (this.f12488o != null && this.f12488o.isShowing()) {
            this.f12488o.dismiss();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m13334a(String str) {
        return str.equals(this.f12493t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m13338b(String str) {
        return TextUtils.isEmpty(C4809aa.m18104a().m18121a(str, ""));
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 0:
                if (i2 == -1) {
                    if (this.f12485k != null) {
                        this.f12485k.notifyDataSetChanged();
                        if (this.f12484j != null) {
                            this.f12484j.setAdapter((ListAdapter) this.f12485k);
                        }
                    }
                    this.f12472G.setText(R.string.deregister_device);
                    this.f12472G.setContentDescription(getString(R.string.deregister_device));
                    break;
                }
                break;
            case 1:
                if (i2 == -1 && this.f12485k != null) {
                    this.f12485k.notifyDataSetChanged();
                    if (this.f12484j != null) {
                        this.f12484j.setAdapter((ListAdapter) this.f12485k);
                        break;
                    }
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m13330a(String str, Integer num) {
        this.f12476b = num;
        AbstractC4439w abstractC4439wM16816a = AbstractC4439w.m16816a(str, this.f12487n);
        if (this.f12498y == null) {
            this.f12498y = new C2128i(this.f12477c);
        }
        this.f12498y.m9501a(str, abstractC4439wM16816a.mo16648c(), num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m13331a(C0778b c0778b) {
        if (c0778b != null && c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            if (this.f12476b.intValue() == 201) {
                this.f12495v.mo16642a(this.f12474I);
                return true;
            }
            if (this.f12476b.intValue() == 203) {
                this.f12496w.mo16642a(this.f12474I);
                return true;
            }
            if (this.f12476b.intValue() == 202) {
                this.f12497x.mo16642a(this.f12474I);
                return true;
            }
            return true;
        }
        m13348g();
        Toast.makeText(this.f12487n, R.string.toast_network_unable, 0).show();
        return true;
    }
}
