package com.sec.chaton;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.ProgressDialogC1806j;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class SelectCountry extends BaseSinglePaneActivity {

    /* renamed from: a */
    private RegisteFragment f284a;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo649a() {
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14) {
            getActionBar();
        }
        String unused = RegisteFragment.f285n = null;
        this.f284a = new RegisteFragment();
        return this.f284a;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            this.f284a = new RegisteFragment();
            this.f284a.setArguments(m1828b(getIntent()));
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_controller, this.f284a, "com.sec.chaton:single_pane_fragment").addToBackStack(null).commit();
        } catch (Exception e) {
            C1786r.m6054a("Failed to reload fragment", getClass().getSimpleName());
        }
    }

    public class RegisteFragment extends Fragment {

        /* renamed from: n */
        private static String f285n;

        /* renamed from: c */
        private Map f288c;

        /* renamed from: d */
        private CharSequence[] f289d;

        /* renamed from: e */
        private CharSequence[] f290e;

        /* renamed from: f */
        private String f291f;

        /* renamed from: g */
        private LinearLayout f292g;

        /* renamed from: h */
        private TextView f293h;

        /* renamed from: i */
        private TextView f294i;

        /* renamed from: k */
        private Context f296k;

        /* renamed from: l */
        private TextView f297l;

        /* renamed from: m */
        private Menu f298m;

        /* renamed from: a */
        final int f286a = 16;

        /* renamed from: b */
        final int f287b = 0;

        /* renamed from: j */
        private ProgressDialog f295j = null;

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            BaseActivity.m1829b(this, true);
            this.f296k = getActivity();
            C1786r.m6061b("onCreate..............", getClass().getSimpleName());
            this.f295j = new ProgressDialogC1806j(getActivity());
            this.f288c = new HashMap();
            this.f289d = getResources().getTextArray(R.array.country);
            this.f290e = getResources().getTextArray(R.array.ISO_country_code_Letter2);
            for (int i = 0; i < this.f289d.length; i++) {
                this.f288c.put(this.f289d[i], this.f290e[i]);
            }
        }

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            C1786r.m6061b("onCreateView..............", getClass().getSimpleName());
            View viewInflate = layoutInflater.inflate(R.layout.layout_select_country, viewGroup, false);
            this.f297l = (TextView) viewInflate.findViewById(R.id.txt_title);
            this.f293h = (TextView) viewInflate.findViewById(R.id.editCountryCode);
            if (GlobalApplication.m3265f()) {
                this.f297l.setVisibility(8);
            }
            this.f292g = (LinearLayout) viewInflate.findViewById(R.id.newSearch);
            this.f294i = (TextView) viewInflate.findViewById(R.id.editCountryName);
            this.f292g.setOnClickListener(new ViewOnClickListenerC0230au(this));
            if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 11) {
                getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
            }
            return viewInflate;
        }

        @Override // android.support.v4.app.Fragment
        public void onResume() {
            super.onResume();
            if (f285n != null) {
                this.f294i.setText(f285n);
                C1789u.m6079a("country_letter", this.f291f);
                C1789u.m6079a("country_name", f285n);
                C1786r.m6061b("mCountryLetter: " + this.f291f + " selectedCountryName: " + f285n, getClass().getSimpleName());
                this.f298m.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
                this.f298m.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
            }
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityResult(int i, int i2, Intent intent) {
            if (i2 == -1) {
                switch (i) {
                    case C0229at.HorizontalSrollView_android_paddingRight /* 16 */:
                        String string = intent.getExtras().getString("PARAMS_COUNTRY_NAME");
                        if (string != null) {
                            this.f291f = String.valueOf(this.f288c.get(string));
                            this.f294i.setText(string);
                            f285n = string;
                            C1789u.m6079a("country_letter", this.f291f);
                            C1789u.m6079a("country_name", string);
                            C1786r.m6061b("mCountryLetter: " + this.f291f + " selectedCountryName: " + string, getClass().getSimpleName());
                            this.f298m.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
                            this.f298m.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
                            break;
                        } else {
                            C1786r.m6061b("selectedCountryName is null", getClass().getSimpleName());
                            break;
                        }
                }
            }
        }

        @Override // android.support.v4.app.Fragment
        public void onPrepareOptionsMenu(Menu menu) {
            menu.clear();
            getActivity().getMenuInflater().inflate(R.menu.actionbar_title_done_cancel_next, menu);
            menu.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
            menu.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(false);
            menu.removeItem(R.id.actionbar_title_next);
            this.f298m = menu;
        }

        @Override // android.support.v4.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case android.R.id.home:
                    getActivity().finish();
                    break;
                case R.id.actionbar_title_cancel /* 2131494128 */:
                    getActivity().finish();
                    break;
                case R.id.actionbar_title_done /* 2131494130 */:
                    getActivity().setResult(-1);
                    getActivity().finish();
                    break;
            }
            return true;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }
}
