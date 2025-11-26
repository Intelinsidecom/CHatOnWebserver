package com.sec.chaton.registration;

import android.accounts.AccountManager;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.coolots.sso.p030a.C0416a;
import com.coolots.sso.p030a.InterfaceC0418c;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.chat.C1759he;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.p055d.AbstractC1899a;
import com.sec.chaton.p055d.C2093az;
import com.sec.chaton.p055d.C2095ba;
import com.sec.chaton.p055d.C2104bj;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4902w;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.HandlerC4826ar;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class FragmentRegistPushName extends Fragment implements InterfaceC0418c {

    /* renamed from: a */
    EditText f11787a;

    /* renamed from: b */
    Activity f11788b;

    /* renamed from: e */
    private String f11791e;

    /* renamed from: f */
    private String f11792f;

    /* renamed from: g */
    private String f11793g;

    /* renamed from: h */
    private AbstractC1899a<?> f11794h;

    /* renamed from: i */
    private C2095ba f11795i;

    /* renamed from: k */
    private C2104bj f11797k;

    /* renamed from: l */
    private C1759he f11798l;

    /* renamed from: m */
    private C2128i f11799m;

    /* renamed from: o */
    private String f11801o;

    /* renamed from: p */
    private String f11802p;

    /* renamed from: q */
    private String f11803q;

    /* renamed from: s */
    private MenuItem f11805s;

    /* renamed from: u */
    private String f11807u;

    /* renamed from: w */
    private View f11809w;

    /* renamed from: j */
    private InterfaceC4936e f11796j = null;

    /* renamed from: n */
    private final int f11800n = 30;

    /* renamed from: r */
    private int f11804r = 0;

    /* renamed from: t */
    private C0416a f11806t = null;

    /* renamed from: v */
    private InterfaceC4936e f11808v = null;

    /* renamed from: x */
    private ProgressDialog f11810x = null;

    /* renamed from: y */
    private TextWatcher f11811y = new C3261ev(this);

    /* renamed from: c */
    HandlerC4826ar f11789c = new HandlerC3262ew(this);

    /* renamed from: d */
    public Handler f11790d = new HandlerC3268fb(this);

    /* renamed from: z */
    private BroadcastReceiver f11812z = new C3284fr(this);

    /* renamed from: t */
    static /* synthetic */ int m12993t(FragmentRegistPushName fragmentRegistPushName) {
        int i = fragmentRegistPushName.f11804r;
        fragmentRegistPushName.f11804r = i + 1;
        return i;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_regist_name, viewGroup, false);
        this.f11787a = (EditText) viewInflate.findViewById(R.id.txtName);
        if (C4809aa.m18104a().m18119a("hidden_skip_mode", (Boolean) false).booleanValue()) {
            this.f11801o = "skip";
        } else if (C4809aa.m18104a().m18119a("prov_phone", (Boolean) false).booleanValue()) {
            this.f11801o = "phone";
        } else {
            this.f11801o = "";
        }
        this.f11793g = C4809aa.m18104a().m18121a("msisdn", (String) null);
        if (TextUtils.isEmpty(this.f11793g)) {
            this.f11793g = C4809aa.m18104a().m18121a("msisdn_temp", (String) null);
        }
        this.f11791e = C4809aa.m18104a().m18121a("token", (String) null);
        if (this.f11791e == null) {
            this.f11791e = C4809aa.m18104a().m18121a("acstoken", (String) null);
        }
        this.f11792f = C4809aa.m18104a().m18121a("authnum", (String) null);
        this.f11794h = C2093az.m9337a();
        this.f11795i = new C2095ba(this.f11790d);
        this.f11797k = new C2104bj(this.f11790d);
        this.f11798l = C1759he.m8726a(this.f11790d, 0L);
        this.f11799m = new C2128i(this.f11790d);
        String[] strArrSplit = getResources().getString(R.string.multidevice_sync_popup).split("\n\n");
        this.f11802p = strArrSplit[0];
        this.f11803q = strArrSplit[1];
        m12968b();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BaseActivity.m6160a((Fragment) this, true);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_sso_receive_code");
        getActivity().registerReceiver(this.f11812z, intentFilter);
        this.f11788b = getActivity();
        if (C4859bx.m18386a((Context) this.f11788b)) {
            this.f11806t = new C0416a();
            this.f11806t.m1491a(this.f11788b, this);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (C4904y.f17872b) {
            C4904y.m18639b("onDestroy", getClass().getSimpleName());
        }
        m12975d();
        this.f11788b.unregisterReceiver(this.f11812z);
        if (C2349a.m10301a("chatonv_feature") && this.f11806t != null) {
            this.f11806t.m1491a(this.f11788b, (InterfaceC0418c) null);
        }
        if (this.f11808v != null && this.f11808v.isShowing()) {
            this.f11808v.dismiss();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f11796j != null && this.f11796j.isShowing()) {
            this.f11796j.dismiss();
            this.f11809w = null;
        }
        if (this.f11810x != null && this.f11810x.isShowing()) {
            this.f11810x.dismiss();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.done_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
        this.f11805s = menu.findItem(R.id.menu_done);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.f11805s.setEnabled(false);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.menu_done) {
            return super.onOptionsItemSelected(menuItem);
        }
        m12995a();
        return true;
    }

    /* renamed from: b */
    private void m12968b() {
        this.f11787a.setFilters(new InputFilter[]{new C4902w(getActivity(), 30)});
        this.f11787a.addTextChangedListener(this.f11811y);
        this.f11787a.setOnEditorActionListener(new C3260eu(this));
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C4904y.m18646e("onResume", getClass().getSimpleName());
        if (C4809aa.m18104a().m18129b("uid")) {
            if (C4904y.f17872b) {
                C4904y.m18639b("PushName state is already done", getClass().getSimpleName());
            }
            if (getActivity() != null) {
                getActivity().finish();
            } else if (C4904y.f17872b) {
                C4904y.m18639b("getActivity is null", getClass().getSimpleName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12965a(String str, String str2, String str3) {
        m12966a(str, str2, str3, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12966a(String str, String str2, String str3, boolean z) {
        if (getActivity() != null) {
            if (!z && (this.f11801o.equals("skip") || this.f11801o.equals("phone"))) {
                this.f11810x = ProgressDialogC4926s.m18727a(this.f11788b, null, this.f11788b.getResources().getString(R.string.buddy_list_progress_dialog_message));
                return;
            }
            if (this.f11796j == null || !this.f11796j.isShowing()) {
                this.f11809w = null;
                this.f11809w = LayoutInflater.from(getActivity()).inflate(R.layout.layout_multidevice_sync, (ViewGroup) null, false);
                TextView textView = (TextView) this.f11809w.findViewById(R.id.messageText);
                ((TextView) this.f11809w.findViewById(R.id.subTitleText)).setText(str2);
                if (TextUtils.isEmpty(str3) || str3.equals("")) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(str3);
                }
                this.f11796j = AbstractC4932a.m18733a(this.f11788b).mo18740a(str).mo18748b(this.f11809w).mo18745a();
                this.f11796j.setCancelable(false);
                this.f11796j.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12964a(String str) {
        if (this.f11796j != null && this.f11796j.isShowing() && this.f11809w != null) {
            ((TextView) this.f11809w.findViewById(R.id.subTitleText)).setText(str);
        }
    }

    /* renamed from: a */
    protected void m12995a() {
        if (this.f11805s != null) {
            this.f11805s.setEnabled(false);
        }
        if (getActivity() != null) {
            m12965a(getActivity().getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f11802p, this.f11803q);
        }
        this.f11794h.mo9077a(this.f11789c);
        this.f11789c.m18262a(30000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m12972c() {
        if (this.f11801o.equals("skip")) {
            this.f11795i.m9351a(this.f11787a.getText().toString());
        } else if (this.f11801o.equals("phone")) {
            this.f11795i.m9354a(this.f11793g, this.f11787a.getText().toString(), this.f11791e == null ? null : this.f11791e, this.f11792f);
        } else {
            this.f11797k.m9388a(this.f11787a.getText().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m12975d() {
        if (this.f11796j != null && this.f11796j.isShowing()) {
            this.f11796j.dismiss();
            this.f11809w = null;
        }
        if (this.f11810x != null && this.f11810x.isShowing()) {
            this.f11810x.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m12976e() {
        if (AccountManager.get(CommonApplication.m18732r()).getAccountsByType(Config.CHATON_PACKAGE_NAME).length <= 0 && C4809aa.m18104a().m18129b("uid")) {
            C4822an.m18217a(C4809aa.m18104a().m18121a("samsung_account_email", ""), C4809aa.m18104a().m18121a("uid", ""), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public boolean m12979f() throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        try {
            packageInfo = getActivity().getPackageManager().getPackageInfo("com.osp.app.signin", 0);
        } catch (PackageManager.NameNotFoundException e) {
            C4904y.m18645d(e.toString(), getClass().getSimpleName());
            packageInfo = null;
        }
        return packageInfo != null && packageInfo.versionCode >= 13001;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m12970b(String str) throws Resources.NotFoundException {
        String string;
        if (TextUtils.isEmpty(str)) {
            C4904y.m18639b("Input MCC is null", getClass().getSimpleName());
            return;
        }
        CharSequence[] textArray = getResources().getTextArray(R.array.Account_SSO_ISO2);
        CharSequence[] textArray2 = getResources().getTextArray(R.array.Account_SSO_MCC);
        int i = 0;
        while (true) {
            if (i >= textArray2.length) {
                string = null;
                break;
            } else if (!textArray2[i].equals(str)) {
                i++;
            } else {
                string = textArray[i].toString();
                break;
            }
        }
        C4904y.m18639b("Input MCC : " + str + " Output : " + string, getClass().getSimpleName());
        C4809aa.m18108a("temp_account_country_code", string);
    }

    @Override // com.coolots.sso.p030a.InterfaceC0418c
    /* renamed from: a */
    public void mo1508a(boolean z, String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onReceiveCreateAccount : " + z + " msg : " + str, getClass().getSimpleName());
        }
        if (z) {
            this.f11799m.m9499a("voip", 1, false);
            return;
        }
        new C3317x().m13050a();
        m12964a(getResources().getString(R.string.auto_regi_buddy_sync));
        this.f11799m.m9495a();
    }

    @Override // com.coolots.sso.p030a.InterfaceC0418c
    /* renamed from: a_ */
    public void mo1509a_(boolean z) {
    }
}
