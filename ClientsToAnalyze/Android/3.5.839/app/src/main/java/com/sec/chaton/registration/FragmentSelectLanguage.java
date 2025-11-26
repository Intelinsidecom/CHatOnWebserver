package com.sec.chaton.registration;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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
import com.sec.chaton.p055d.C2097bc;
import com.sec.chaton.p065io.entry.GetSMSAuthToken;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.p123a.AbstractC4932a;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public class FragmentSelectLanguage extends Fragment {

    /* renamed from: b */
    protected GetSMSAuthToken f11814b;

    /* renamed from: e */
    private Map<CharSequence, CharSequence> f11817e;

    /* renamed from: f */
    private Map<CharSequence, CharSequence> f11818f;

    /* renamed from: g */
    private CharSequence[] f11819g;

    /* renamed from: h */
    private CharSequence[] f11820h;

    /* renamed from: i */
    private LinearLayout f11821i;

    /* renamed from: j */
    private TextView f11822j;

    /* renamed from: l */
    private Context f11824l;

    /* renamed from: n */
    private String f11826n;

    /* renamed from: o */
    private C2097bc f11827o;

    /* renamed from: p */
    private String f11828p;

    /* renamed from: q */
    private String f11829q;

    /* renamed from: r */
    private String f11830r;

    /* renamed from: s */
    private TextView f11831s;

    /* renamed from: a */
    final int f11813a = 0;

    /* renamed from: k */
    private ProgressDialog f11823k = null;

    /* renamed from: m */
    private final String f11825m = "English";

    /* renamed from: c */
    View.OnClickListener f11815c = new ViewOnClickListenerC3285fs(this);

    /* renamed from: d */
    Handler f11816d = new HandlerC3286ft(this, Looper.getMainLooper());

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C4904y.m18639b("onCreate...", getClass().getSimpleName());
        this.f11824l = getActivity();
        BaseActivity.m6160a((Fragment) this, true);
        if (getActivity() != null) {
            this.f11823k = new ProgressDialogC4926s(getActivity());
        }
        this.f11817e = new HashMap();
        this.f11818f = new HashMap();
        this.f11819g = getResources().getTextArray(R.array.ACS_Locale_Language);
        this.f11820h = getResources().getTextArray(R.array.ACS_Lcale_Code);
        for (int i = 0; i < this.f11819g.length; i++) {
            this.f11817e.put(this.f11820h[i], this.f11819g[i]);
            this.f11818f.put(this.f11819g[i], this.f11820h[i]);
        }
        this.f11827o = new C2097bc(this.f11816d);
        this.f11829q = C4809aa.m18104a().m18121a("country_code", (String) null);
        this.f11830r = C4809aa.m18104a().m18121a("phonenumber", (String) null);
        this.f11828p = C4809aa.m18104a().m18121a("acstoken", (String) null);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C4904y.m18639b("onCreateView...", getClass().getSimpleName());
        View viewInflate = layoutInflater.inflate(R.layout.layout_select_language, viewGroup, false);
        this.f11821i = (LinearLayout) viewInflate.findViewById(R.id.rootLayout);
        this.f11822j = (TextView) viewInflate.findViewById(R.id.text1);
        this.f11822j.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow, 0);
        this.f11831s = (TextView) viewInflate.findViewById(R.id.noticeACS);
        this.f11831s.setText(getString(R.string.regist_acs_notice, 4, "0000", "0000"));
        this.f11821i.setOnClickListener(this.f11815c);
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
        m12998a();
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        String language = getResources().getConfiguration().locale.getLanguage();
        C4904y.m18639b("LANG : " + language, getClass().getSimpleName());
        if (!TextUtils.isEmpty(language)) {
            int i = 0;
            while (true) {
                if (i >= this.f11820h.length) {
                    break;
                }
                if (!this.f11820h[i].toString().startsWith(language)) {
                    i++;
                } else {
                    this.f11826n = this.f11820h[i].toString();
                    this.f11822j.setText(String.valueOf(this.f11817e.get(this.f11826n)));
                    break;
                }
            }
        }
        if (TextUtils.isEmpty(this.f11822j.getText().toString())) {
            this.f11822j.setText("English");
            this.f11826n = String.valueOf(this.f11817e.get("English"));
        }
        C4904y.m18639b("mLanguageCode : " + this.f11826n, getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 0:
                    String string = intent.getExtras().getString("LANGUAGE_NAME");
                    if (string != null) {
                        this.f11826n = String.valueOf(this.f11818f.get(string));
                        this.f11822j.setText(string);
                        C4904y.m18639b("mLanguageCode : " + this.f11826n + " selectedLanguageName : " + string, getClass().getSimpleName());
                        break;
                    }
                    break;
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C4904y.m18639b("onResume", getClass().getSimpleName());
    }

    /* renamed from: a */
    private void m12998a() {
        if (getActivity() != null) {
            this.f11823k.dismiss();
        }
        if (this.f11824l != null) {
            this.f11823k = ProgressDialogC4926s.m18728a(this.f11824l, null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
        }
        m12999b();
    }

    /* renamed from: b */
    private void m12999b() {
        this.f11827o.m9376b(this.f11829q, this.f11830r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m13002c() {
        this.f11827o.m9372a(this.f11828p, this.f11829q, this.f11830r, this.f11826n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m13003d() throws Resources.NotFoundException {
        if (getActivity() != null) {
            String strM18121a = C4809aa.m18104a().m18121a("acs_expire_time", "");
            String string = getActivity().getResources().getString(R.string.registration_acs_24_hour_over);
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(TextUtils.isEmpty(strM18121a) ? 24 : Integer.valueOf(strM18121a).intValue());
            String str = String.format(string, objArr);
            if (C4822an.m18194D()) {
                Locale locale = Locale.US;
                String string2 = getActivity().getResources().getString(R.string.registration_acs_24_hour_over);
                Object[] objArr2 = new Object[1];
                objArr2[0] = Integer.valueOf(TextUtils.isEmpty(strM18121a) ? 24 : Integer.valueOf(strM18121a).intValue());
                str = String.format(locale, string2, objArr2);
            }
            AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(getActivity());
            abstractC4932aM18733a.mo18734a(R.string.pop_up_attention);
            abstractC4932aM18733a.mo18749b(str).mo18747b(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3291fy(this));
            abstractC4932aM18733a.mo18745a().show();
        }
    }
}
