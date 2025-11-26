package com.sec.chaton.registration;

import android.accounts.AccountManager;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
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
import com.coolots.sso.p006a.C0045a;
import com.coolots.sso.p006a.InterfaceC0047c;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.chat.C1090fe;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.p025d.AbstractC1144a;
import com.sec.chaton.p025d.C1302ao;
import com.sec.chaton.p025d.C1303ap;
import com.sec.chaton.p025d.C1307at;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3248w;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.HandlerC3176ar;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public class FragmentRegistPushName extends Fragment implements InterfaceC0047c {

    /* renamed from: a */
    EditText f8313a;

    /* renamed from: b */
    Activity f8314b;

    /* renamed from: e */
    private String f8317e;

    /* renamed from: f */
    private String f8318f;

    /* renamed from: g */
    private String f8319g;

    /* renamed from: h */
    private AbstractC1144a<?> f8320h;

    /* renamed from: i */
    private C1303ap f8321i;

    /* renamed from: k */
    private C1307at f8323k;

    /* renamed from: l */
    private C1090fe f8324l;

    /* renamed from: m */
    private C1330h f8325m;

    /* renamed from: o */
    private String f8327o;

    /* renamed from: p */
    private String f8328p;

    /* renamed from: q */
    private String f8329q;

    /* renamed from: s */
    private MenuItem f8331s;

    /* renamed from: u */
    private String f8333u;

    /* renamed from: w */
    private View f8335w;

    /* renamed from: j */
    private InterfaceC3274d f8322j = null;

    /* renamed from: n */
    private final int f8326n = 30;

    /* renamed from: r */
    private int f8330r = 0;

    /* renamed from: t */
    private C0045a f8332t = null;

    /* renamed from: v */
    private InterfaceC3274d f8334v = null;

    /* renamed from: x */
    private ProgressDialog f8336x = null;

    /* renamed from: y */
    private TextWatcher f8337y = new C2243em(this);

    /* renamed from: c */
    HandlerC3176ar f8315c = new HandlerC2244en(this);

    /* renamed from: d */
    public Handler f8316d = new HandlerC2249es(this);

    /* renamed from: z */
    private BroadcastReceiver f8338z = new C2266fi(this);

    /* renamed from: t */
    static /* synthetic */ int m8640t(FragmentRegistPushName fragmentRegistPushName) {
        int i = fragmentRegistPushName.f8330r;
        fragmentRegistPushName.f8330r = i + 1;
        return i;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_regist_name, viewGroup, false);
        this.f8313a = (EditText) viewInflate.findViewById(R.id.txtName);
        if (C3159aa.m10962a().m10977a("hidden_skip_mode", (Boolean) false).booleanValue()) {
            this.f8327o = "skip";
        } else if (C3159aa.m10962a().m10977a("prov_phone", (Boolean) false).booleanValue()) {
            this.f8327o = "phone";
        } else {
            this.f8327o = "";
        }
        this.f8319g = C3159aa.m10962a().m10979a("msisdn", (String) null);
        this.f8317e = C3159aa.m10962a().m10979a("token", (String) null);
        this.f8318f = C3159aa.m10962a().m10979a("authnum", (String) null);
        this.f8320h = C1302ao.m5594a();
        this.f8321i = new C1303ap(this.f8316d);
        this.f8323k = new C1307at(this.f8316d);
        this.f8324l = new C1090fe(this.f8316d, 0L);
        this.f8325m = new C1330h(this.f8316d);
        String[] strArrSplit = getResources().getString(R.string.multidevice_sync_popup).split("\n\n");
        this.f8328p = strArrSplit[0];
        this.f8329q = strArrSplit[1];
        m8615b();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BaseActivity.m3081a(this, true);
        BaseActivity.m3083b(this, true);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_sso_receive_code");
        getActivity().registerReceiver(this.f8338z, intentFilter);
        this.f8314b = getActivity();
        if (C3214cb.m11256a(this.f8314b)) {
            this.f8332t = new C0045a();
            this.f8332t.m51a(this.f8314b, this);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (C3250y.f11734b) {
            C3250y.m11450b("onDestroy", getClass().getSimpleName());
        }
        m8622d();
        this.f8314b.unregisterReceiver(this.f8338z);
        if (C1493a.m6463a("chatonv_feature") && this.f8332t != null) {
            this.f8332t.m51a(this.f8314b, (InterfaceC0047c) null);
        }
        if (this.f8334v != null && this.f8334v.isShowing()) {
            this.f8334v.dismiss();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f8322j != null && this.f8322j.isShowing()) {
            this.f8322j.dismiss();
            this.f8335w = null;
        }
        if (this.f8336x != null && this.f8336x.isShowing()) {
            this.f8336x.dismiss();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.done_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
        this.f8331s = menu.findItem(R.id.menu_done);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.f8331s.setEnabled(false);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.menu_done) {
            return super.onOptionsItemSelected(menuItem);
        }
        m8642a();
        return true;
    }

    /* renamed from: b */
    private void m8615b() {
        this.f8313a.setFilters(new InputFilter[]{new C3248w(getActivity(), 30)});
        this.f8313a.addTextChangedListener(this.f8337y);
        this.f8313a.setOnEditorActionListener(new C2242el(this));
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C3250y.m11456e("onResume", getClass().getSimpleName());
        if (C3159aa.m10962a().m10979a("provisioning_pushname_status", "").equals("DONE")) {
            if (C3250y.f11734b) {
                C3250y.m11450b("PushName state is already done", getClass().getSimpleName());
            }
            if (getActivity() != null) {
                getActivity().finish();
            } else if (C3250y.f11734b) {
                C3250y.m11450b("getActivity is null", getClass().getSimpleName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8613a(String str, String str2, String str3) {
        if (getActivity() != null) {
            if (this.f8327o.equals("skip") || this.f8327o.equals("phone")) {
                this.f8336x = ProgressDialogC3265l.m11489a(this.f8314b, null, this.f8314b.getResources().getString(R.string.buddy_list_progress_dialog_message));
                return;
            }
            this.f8335w = null;
            this.f8335w = LayoutInflater.from(getActivity()).inflate(R.layout.layout_multidevice_sync, (ViewGroup) null, false);
            TextView textView = (TextView) this.f8335w.findViewById(R.id.messageText);
            ((TextView) this.f8335w.findViewById(R.id.subTitleText)).setText(str2);
            if (TextUtils.isEmpty(str3) || str3.equals("")) {
                textView.setVisibility(8);
            } else {
                textView.setText(str3);
            }
            this.f8322j = AbstractC3271a.m11494a(this.f8314b).mo11500a(str).mo11508b(this.f8335w).mo11505a();
            this.f8322j.setCancelable(false);
            this.f8322j.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8612a(String str) {
        if (this.f8322j != null && this.f8322j.isShowing() && this.f8335w != null) {
            ((TextView) this.f8335w.findViewById(R.id.subTitleText)).setText(str);
        }
    }

    /* renamed from: a */
    protected void m8642a() {
        if (this.f8331s != null) {
            this.f8331s.setEnabled(false);
        }
        if (getActivity() != null) {
            m8613a(getActivity().getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8328p, this.f8329q);
        }
        this.f8320h.mo5479a(this.f8315c);
        this.f8315c.m11090a(30000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m8619c() {
        if (this.f8327o.equals("skip")) {
            this.f8321i.m5598a(this.f8313a.getText().toString());
        } else if (this.f8327o.equals("phone")) {
            this.f8321i.m5601a(this.f8319g, this.f8313a.getText().toString(), this.f8317e == null ? null : this.f8317e, this.f8318f);
        } else {
            this.f8323k.m5615a(this.f8313a.getText().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m8622d() {
        if (this.f8322j != null && this.f8322j.isShowing()) {
            this.f8322j.dismiss();
            this.f8335w = null;
        }
        if (this.f8336x != null && this.f8336x.isShowing()) {
            this.f8336x.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m8623e() {
        if (AccountManager.get(CommonApplication.m11493l()).getAccountsByType("com.sec.chaton").length <= 0 && C3159aa.m10962a().m10987b("uid")) {
            C3171am.m11051a(C3159aa.m10962a().m10979a("samsung_account_email", ""), C3159aa.m10962a().m10979a("uid", ""), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public boolean m8626f() throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        try {
            packageInfo = getActivity().getPackageManager().getPackageInfo("com.osp.app.signin", 0);
        } catch (PackageManager.NameNotFoundException e) {
            C3250y.m11455d(e.toString(), getClass().getSimpleName());
            packageInfo = null;
        }
        return packageInfo != null && packageInfo.versionCode >= 13001;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8617b(String str) throws Resources.NotFoundException {
        String string;
        if (TextUtils.isEmpty(str)) {
            C3250y.m11450b("Input MCC is null", getClass().getSimpleName());
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
        C3250y.m11450b("Input MCC : " + str + " Output : " + string, getClass().getSimpleName());
        C3159aa.m10966a("temp_account_country_code", string);
    }

    @Override // com.coolots.sso.p006a.InterfaceC0047c
    public void onReceiveCreateAccount(boolean z, String str) throws UnsupportedEncodingException {
        if (C3250y.f11734b) {
            C3250y.m11450b("onReceiveCreateAccount : " + z, getClass().getSimpleName());
        }
        if (z) {
            this.f8325m.m5723a("voip", 1, false);
            return;
        }
        new C2160bk().m8674a();
        m8612a(getResources().getString(R.string.auto_regi_buddy_sync));
        this.f8325m.m5717a();
    }

    @Override // com.coolots.sso.p006a.InterfaceC0047c
    public void onReceiveRemoveAccount(boolean z) {
    }
}
