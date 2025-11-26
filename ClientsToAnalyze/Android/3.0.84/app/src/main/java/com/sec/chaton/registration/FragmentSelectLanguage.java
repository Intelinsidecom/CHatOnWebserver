package com.sec.chaton.registration;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.p025d.C1305ar;
import com.sec.chaton.p035io.entry.GetSMSAuthToken;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.p063a.AbstractC3271a;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class FragmentSelectLanguage extends Fragment {

    /* renamed from: b */
    protected GetSMSAuthToken f8340b;

    /* renamed from: e */
    private Map<CharSequence, CharSequence> f8343e;

    /* renamed from: f */
    private Map<CharSequence, CharSequence> f8344f;

    /* renamed from: g */
    private CharSequence[] f8345g;

    /* renamed from: h */
    private CharSequence[] f8346h;

    /* renamed from: i */
    private LinearLayout f8347i;

    /* renamed from: j */
    private TextView f8348j;

    /* renamed from: l */
    private Context f8350l;

    /* renamed from: n */
    private String f8352n;

    /* renamed from: o */
    private C1305ar f8353o;

    /* renamed from: p */
    private String f8354p;

    /* renamed from: q */
    private String f8355q;

    /* renamed from: r */
    private String f8356r;

    /* renamed from: s */
    private TextView f8357s;

    /* renamed from: a */
    final int f8339a = 0;

    /* renamed from: k */
    private ProgressDialog f8349k = null;

    /* renamed from: m */
    private final String f8351m = "English";

    /* renamed from: c */
    View.OnClickListener f8341c = new ViewOnClickListenerC2267fj(this);

    /* renamed from: d */
    Handler f8342d = new HandlerC2268fk(this, Looper.getMainLooper());

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3250y.m11450b("onCreate...", getClass().getSimpleName());
        this.f8350l = getActivity();
        BaseActivity.m3083b(this, true);
        BaseActivity.m3081a(this, true);
        if (getActivity() != null) {
            this.f8349k = new ProgressDialogC3265l(getActivity());
        }
        this.f8343e = new HashMap();
        this.f8344f = new HashMap();
        this.f8345g = getResources().getTextArray(R.array.ACS_Locale_Language);
        this.f8346h = getResources().getTextArray(R.array.ACS_Lcale_Code);
        for (int i = 0; i < this.f8345g.length; i++) {
            this.f8343e.put(this.f8346h[i], this.f8345g[i]);
            this.f8344f.put(this.f8345g[i], this.f8346h[i]);
        }
        this.f8353o = new C1305ar(this.f8342d);
        this.f8355q = C3159aa.m10962a().m10979a("country_code", (String) null);
        this.f8356r = C3159aa.m10962a().m10979a("phonenumber", (String) null);
        this.f8354p = C3159aa.m10962a().m10979a("acstoken", (String) null);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C3250y.m11450b("onCreateView...", getClass().getSimpleName());
        View viewInflate = layoutInflater.inflate(R.layout.layout_select_language, viewGroup, false);
        this.f8347i = (LinearLayout) viewInflate.findViewById(R.id.rootLayout);
        this.f8348j = (TextView) viewInflate.findViewById(R.id.text1);
        this.f8348j.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow, 0);
        this.f8357s = (TextView) viewInflate.findViewById(R.id.noticeACS);
        this.f8357s.setText(getString(R.string.regist_acs_notice, 4, "0000", "0000"));
        this.f8347i.setOnClickListener(this.f8341c);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.done_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.menu_done) {
            return super.onOptionsItemSelected(menuItem);
        }
        m8645a();
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        String language = getResources().getConfiguration().locale.getLanguage();
        C3250y.m11450b("LANG : " + language, getClass().getSimpleName());
        if (!TextUtils.isEmpty(language)) {
            int i = 0;
            while (true) {
                if (i >= this.f8346h.length) {
                    break;
                }
                if (!this.f8346h[i].toString().startsWith(language)) {
                    i++;
                } else {
                    this.f8352n = this.f8346h[i].toString();
                    this.f8348j.setText(String.valueOf(this.f8343e.get(this.f8352n)));
                    break;
                }
            }
        }
        if (TextUtils.isEmpty(this.f8348j.getText().toString())) {
            this.f8348j.setText("English");
            this.f8352n = String.valueOf(this.f8343e.get("English"));
        }
        C3250y.m11450b("mLanguageCode : " + this.f8352n, getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 0:
                    String string = intent.getExtras().getString("LANGUAGE_NAME");
                    if (string != null) {
                        this.f8352n = String.valueOf(this.f8344f.get(string));
                        this.f8348j.setText(string);
                        C3250y.m11450b("mLanguageCode : " + this.f8352n + " selectedLanguageName : " + string, getClass().getSimpleName());
                        break;
                    }
                    break;
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C3250y.m11450b("onResume", getClass().getSimpleName());
    }

    /* renamed from: a */
    private void m8645a() {
        if (getActivity() != null) {
            this.f8349k.dismiss();
        }
        if (this.f8350l != null) {
            this.f8349k = ProgressDialogC3265l.m11490a(this.f8350l, null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
        }
        m8646b();
    }

    /* renamed from: b */
    private void m8646b() {
        this.f8353o.m5612b(this.f8355q, this.f8356r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m8649c() {
        this.f8353o.m5611a(this.f8354p, this.f8355q, this.f8356r, this.f8352n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m8650d() {
        if (getActivity() != null) {
            String strM10979a = C3159aa.m10962a().m10979a("acs_expire_time", "");
            AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(getActivity());
            abstractC3271aM11494a.mo11495a(R.string.provisioning_verification_failed);
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(strM10979a == "" ? 24 : Integer.valueOf(strM10979a).intValue());
            abstractC3271aM11494a.mo11509b(getString(R.string.registration_acs_24_hour_over, objArr)).mo11507b(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2273fp(this));
            abstractC3271aM11494a.mo11505a().show();
        }
    }
}
