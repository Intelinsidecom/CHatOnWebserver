package com.sec.chaton.registration;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.C0229at;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.p015d.C0634f;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.ProgressDialogC1806j;
import com.sec.widget.EditTextWithClearButton;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* loaded from: classes.dex */
public class ActivityRegist extends BaseSinglePaneActivity {

    /* renamed from: a */
    public static String f4213a;

    /* renamed from: b */
    public static String f4214b;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo649a() {
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
        return new RegistFragment();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 32) {
            if (i2 == -1) {
                String stringExtra = intent.getStringExtra("AUTH_NUM");
                String stringExtra2 = intent.getStringExtra("TOKEN");
                Intent intent2 = new Intent();
                intent2.putExtra("MSISDN", f4213a);
                intent2.putExtra("AUTH_NUM", stringExtra);
                intent2.putExtra("TOKEN", stringExtra2);
                if (C1789u.m6075a().getBoolean("skipRegi", false)) {
                    C1789u.m6076a("skipRegi", (Boolean) false);
                }
                setResult(-1, intent2);
                finish();
                return;
            }
            if (i2 == 0) {
                finish();
            } else if (i2 == 2) {
                C1789u.m6076a("skipRegi", (Boolean) false);
                C1789u.m6075a().edit().remove("acstoken").commit();
            }
        }
    }

    public class RegistFragment extends Fragment implements View.OnClickListener {

        /* renamed from: A */
        private Context f4215A;

        /* renamed from: K */
        private String f4225K;

        /* renamed from: N */
        private String f4228N;

        /* renamed from: P */
        private String f4230P;

        /* renamed from: g */
        private Map f4237g;

        /* renamed from: h */
        private Map f4238h;

        /* renamed from: i */
        private CharSequence[] f4239i;

        /* renamed from: j */
        private CharSequence[] f4240j;

        /* renamed from: k */
        private CharSequence[] f4241k;

        /* renamed from: l */
        private String f4242l;

        /* renamed from: m */
        private String f4243m;

        /* renamed from: n */
        private LinearLayout f4244n;

        /* renamed from: o */
        private EditTextWithClearButton f4245o;

        /* renamed from: p */
        private TextView f4246p;

        /* renamed from: q */
        private TextView f4247q;

        /* renamed from: r */
        private Button f4248r;

        /* renamed from: s */
        private Button f4249s;

        /* renamed from: t */
        private Button f4250t;

        /* renamed from: u */
        private Button f4251u;

        /* renamed from: v */
        private TextView f4252v;

        /* renamed from: w */
        private String f4253w;

        /* renamed from: x */
        private Button f4254x;

        /* renamed from: y */
        private Button f4255y;

        /* renamed from: a */
        final int f4231a = 16;

        /* renamed from: b */
        final int f4232b = 0;

        /* renamed from: c */
        final int f4233c = 48;

        /* renamed from: z */
        private ProgressDialog f4256z = null;

        /* renamed from: B */
        private Menu f4216B = null;

        /* renamed from: C */
        private int f4217C = 0;

        /* renamed from: D */
        private String f4218D = null;

        /* renamed from: E */
        private String f4219E = null;

        /* renamed from: F */
        private String f4220F = null;

        /* renamed from: G */
        private String f4221G = null;

        /* renamed from: H */
        private String f4222H = null;

        /* renamed from: I */
        private String f4223I = null;

        /* renamed from: J */
        private String f4224J = null;

        /* renamed from: L */
        private final String f4226L = C1789u.m6075a().getString("country_name", "");

        /* renamed from: M */
        private final String f4227M = C1789u.m6075a().getString("phonenumber", null);

        /* renamed from: d */
        View.OnClickListener f4234d = new ViewOnClickListenerC1151ae(this);

        /* renamed from: O */
        private TextWatcher f4229O = new C1152af(this);

        /* renamed from: e */
        Handler f4235e = new HandlerC1153ag(this);

        /* renamed from: f */
        Handler f4236f = new HandlerC1155ai(this);

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            C1786r.m6061b("onCreate...", getClass().getSimpleName());
            if (C1789u.m6075a().getBoolean("skipRegi", false) && this.f4217C == 0) {
                if (C1789u.m6075a().getBoolean("isSMS", true)) {
                    m4373a(getActivity(), "SMS");
                } else {
                    m4373a(getActivity(), "ACS");
                }
            }
            this.f4215A = getActivity();
            BaseActivity.m1829b(this, true);
            this.f4256z = new ProgressDialogC1806j(getActivity());
            this.f4237g = new HashMap();
            this.f4238h = new HashMap();
            this.f4239i = getResources().getTextArray(R.array.country);
            this.f4240j = getResources().getTextArray(R.array.country_code);
            this.f4241k = getResources().getTextArray(R.array.ISO_country_code_Letter2);
            for (int i = 0; i < this.f4239i.length; i++) {
                this.f4237g.put(this.f4239i[i], this.f4240j[i]);
                this.f4238h.put(this.f4239i[i], this.f4241k[i]);
            }
        }

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            C1786r.m6061b("onCreateView...", getClass().getSimpleName());
            View viewInflate = layoutInflater.inflate(R.layout.layout_regist, viewGroup, false);
            if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 11) {
                getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
            }
            this.f4244n = (LinearLayout) viewInflate.findViewById(R.id.newSearch);
            this.f4246p = (TextView) viewInflate.findViewById(R.id.editCountryCode);
            this.f4247q = (TextView) viewInflate.findViewById(R.id.editCountryName);
            this.f4245o = (EditTextWithClearButton) viewInflate.findViewById(R.id.editPno);
            this.f4245o.setMaxLengthString(R.string.toast_text_max_Length);
            this.f4252v = (TextView) viewInflate.findViewById(R.id.txtRegist_2);
            if (GlobalApplication.m3265f()) {
                this.f4252v.setText(getString(R.string.regist_select_acs_sms, 4));
            }
            if (viewInflate.findViewById(R.id.btnCancel) != null) {
                this.f4248r = (Button) viewInflate.findViewById(R.id.btnCancel);
                this.f4248r.setOnClickListener(this);
            }
            if (viewInflate.findViewById(R.id.btnSelfSMS) != null) {
                this.f4249s = (Button) viewInflate.findViewById(R.id.btnSelfSMS);
                this.f4249s.setOnClickListener(this);
            }
            if (viewInflate.findViewById(R.id.btnSMSACS) != null) {
                this.f4250t = (Button) viewInflate.findViewById(R.id.btnSMSACS);
                this.f4250t.setOnClickListener(this);
            }
            if (viewInflate.findViewById(R.id.btnGenerateIMEI) != null) {
                this.f4254x = (Button) viewInflate.findViewById(R.id.btnGenerateIMEI);
                this.f4254x.setOnClickListener(this);
            }
            if (viewInflate.findViewById(R.id.btnNSS) != null) {
                this.f4255y = (Button) viewInflate.findViewById(R.id.btnNSS);
                this.f4255y.setOnClickListener(this);
            }
            if (viewInflate.findViewById(R.id.btnACS) != null) {
                this.f4251u = (Button) viewInflate.findViewById(R.id.btnACS);
                this.f4251u.setOnClickListener(this);
            }
            this.f4244n.setOnClickListener(this.f4234d);
            if (getActivity().getIntent() != null) {
                this.f4217C = getActivity().getIntent().getIntExtra(RtspHeaders.Values.MODE, 0);
            }
            if (this.f4217C == 1) {
                ((TextView) viewInflate.findViewById(R.id.txt_title)).setText(R.string.buddy_list_dialog_addbuddy_title);
                ((TextView) viewInflate.findViewById(R.id.txtRegist_1)).setText(R.string.buddy_list_dialog_addbuddy_hint);
                ((TextView) viewInflate.findViewById(R.id.txt_select_country)).setText(R.string.provision_select_country_or_region);
                if (GlobalApplication.m3265f()) {
                    this.f4218D = C1789u.m6075a().getString("country_name", null);
                    this.f4219E = C1789u.m6075a().getString("country_code", null);
                    this.f4220F = C1789u.m6075a().getString("last_add_buddy_country", this.f4218D);
                    this.f4221G = C1789u.m6075a().getString("last_add_buddy_country_code", this.f4219E);
                    if (this.f4220F == null && this.f4221G == null) {
                        this.f4220F = "South Korea";
                    }
                }
            }
            if (this.f4217C == 0) {
                if (GlobalApplication.m3265f()) {
                    this.f4252v.setVisibility(0);
                }
                C1786r.m6050a();
                if (viewInflate.findViewById(R.id.txtRegist_1) != null) {
                    viewInflate.findViewById(R.id.txtRegist_1).setOnClickListener(new ViewOnClickListenerC1150ad(this));
                }
            }
            if (GlobalApplication.m3265f() && this.f4216B == null) {
                getActivity().invalidateOptionsMenu();
            }
            if (bundle != null) {
                if (bundle != null) {
                    this.f4222H = bundle.getString("countryCodeSaved");
                    this.f4223I = bundle.getString("countryNameSaved");
                    this.f4224J = bundle.getString("phoneNoSaved");
                }
                this.f4246p.setText(this.f4222H);
                this.f4247q.setText(this.f4223I);
                this.f4245o.setText(this.f4224J);
            }
            return viewInflate;
        }

        @Override // android.support.v4.app.Fragment
        public void onPrepareOptionsMenu(Menu menu) {
            C1786r.m6061b("onPrepareOptionsMenu", getClass().getSimpleName());
            menu.clear();
            getActivity().getMenuInflater().inflate(R.menu.actionbar_title_done_cancel_next, menu);
            if (GlobalApplication.m3265f()) {
                if (this.f4245o != null && this.f4245o.length() > 0) {
                    menu.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
                    menu.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
                } else {
                    menu.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(true);
                    menu.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
                }
            }
            if (getActivity().getIntent() != null) {
                this.f4217C = getActivity().getIntent().getIntExtra(RtspHeaders.Values.MODE, 0);
            }
            menu.removeItem(R.id.actionbar_title_next);
            this.f4216B = menu;
        }

        @Override // android.support.v4.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            C1786r.m6061b("onOptionsItemSelected...", getClass().getSimpleName());
            switch (menuItem.getItemId()) {
                case android.R.id.home:
                    getActivity().finish();
                    break;
                case R.id.actionbar_title_search /* 2131494127 */:
                case R.id.actionbar_title_done /* 2131494130 */:
                    m4375a("SMS");
                    break;
                case R.id.actionbar_title_cancel /* 2131494128 */:
                    getActivity().finish();
                    break;
            }
            return true;
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityCreated(Bundle bundle) throws Resources.NotFoundException {
            super.onActivityCreated(bundle);
            String strM5878e = C1721ad.m5878e();
            if (this.f4217C == 0) {
                if (strM5878e != null && strM5878e.length() > 0) {
                    CharSequence[] textArray = getResources().getTextArray(R.array.ISO_country_code_Letter2);
                    CharSequence[] charSequenceArr = this.f4239i;
                    String string = C1789u.m6075a().getString("country_code", this.f4222H);
                    String string2 = C1789u.m6075a().getString("country_name", this.f4223I);
                    int i = 0;
                    while (true) {
                        if (i >= textArray.length) {
                            break;
                        }
                        if (!strM5878e.equalsIgnoreCase(textArray[i].toString())) {
                            i++;
                        } else {
                            this.f4253w = textArray[i].toString();
                            this.f4243m = String.valueOf(this.f4237g.get(charSequenceArr[i].toString()));
                            C1786r.m6061b("[First] mSimCountryCallingCode : " + this.f4243m, getClass().getSimpleName());
                            if (this.f4217C == 0) {
                                if (string == null) {
                                    this.f4247q.setText(charSequenceArr[i].toString());
                                    this.f4246p.setText(" (+" + this.f4237g.get(charSequenceArr[i].toString()) + ")");
                                    this.f4242l = this.f4243m;
                                } else if (bundle == null) {
                                    this.f4247q.setText(string2);
                                    this.f4246p.setText(" (+" + string + ")");
                                    this.f4242l = string;
                                }
                                C1786r.m6061b("CountryName : " + this.f4247q.toString() + "CountryCode" + this.f4246p.toString(), getClass().getSimpleName());
                            }
                        }
                    }
                } else if (!TextUtils.isEmpty(this.f4226L) || !TextUtils.isEmpty(this.f4223I)) {
                    String strValueOf = String.valueOf(this.f4237g.get(this.f4226L));
                    this.f4253w = String.valueOf(this.f4238h.get(this.f4226L));
                    C1786r.m6061b("countryName: " + this.f4226L + " countrycode: " + strValueOf, getClass().getSimpleName());
                    if (this.f4217C == 0 && bundle == null) {
                        this.f4247q.setText(this.f4226L);
                        this.f4246p.setText(" (+" + strValueOf + ")");
                        this.f4242l = strValueOf;
                    }
                } else {
                    m4377b();
                }
                m4395a();
            } else {
                m4377b();
            }
            this.f4225K = C1721ad.m5877d();
            if (getActivity().getIntent() != null) {
                this.f4217C = getActivity().getIntent().getIntExtra(RtspHeaders.Values.MODE, 0);
            }
            if (this.f4217C != 1) {
                if (this.f4227M != null) {
                    this.f4245o.append(this.f4227M);
                } else if (this.f4225K != null && this.f4242l != null && this.f4225K.length() > 3) {
                    if (this.f4225K.startsWith("+" + this.f4242l)) {
                        if (this.f4242l.equals("82") && this.f4225K.startsWith("+" + this.f4242l + "1")) {
                            this.f4245o.append("0" + this.f4225K.substring(this.f4242l.length() + 1));
                        } else {
                            this.f4245o.append(this.f4225K.substring(this.f4242l.length() + 1));
                        }
                    } else if (this.f4225K.startsWith(this.f4242l)) {
                        if (this.f4242l.equals("82") && this.f4225K.startsWith(this.f4242l + "1")) {
                            this.f4245o.append("0" + this.f4225K.substring(this.f4242l.length()));
                        } else {
                            this.f4245o.append(this.f4225K.substring(this.f4242l.length()));
                        }
                    } else if (!this.f4225K.startsWith("0000") && this.f4225K.length() > 6) {
                        C1786r.m6061b("msisdn did NOT start with CC", getClass().getSimpleName());
                        this.f4245o.append(this.f4225K);
                    }
                }
            }
            C1786r.m6061b("Auto Read #phone > phoneNum : " + this.f4225K + "CountryCallingCode :" + this.f4242l, getClass().getSimpleName());
            this.f4245o.addTextChangedListener(this.f4229O);
        }

        /* renamed from: b */
        private void m4377b() {
            this.f4247q.setText(R.string.layout_regist_no_country_selected);
            this.f4246p.setText("");
            this.f4242l = null;
            if (GlobalApplication.m3265f() && this.f4217C == 1) {
                if (this.f4220F == null) {
                    this.f4247q.setText("");
                    this.f4246p.setText(" (+" + this.f4221G + ")");
                    this.f4242l = this.f4221G;
                } else {
                    this.f4247q.setText(this.f4220F);
                    this.f4246p.setText(" (+" + this.f4237g.get(this.f4220F) + ")");
                    this.f4242l = String.valueOf(this.f4237g.get(this.f4220F));
                }
            }
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityResult(int i, int i2, Intent intent) {
            if (i2 == -1) {
                switch (i) {
                    case C0229at.HorizontalSrollView_android_paddingRight /* 16 */:
                        Bundle extras = intent.getExtras();
                        String string = extras.getString("PARAMS_COUNTRY_NAME");
                        if (string != null) {
                            this.f4242l = String.valueOf(this.f4237g.get(string));
                            this.f4246p.setText(" (+" + this.f4237g.get(string) + ")");
                            this.f4247q.setText(string);
                            C1786r.m6061b("mSimCountryCallingCode : " + this.f4243m + " mCountryCallingCode : " + this.f4242l, getClass().getSimpleName());
                            if (this.f4243m != null && !this.f4243m.equals(this.f4242l)) {
                                this.f4245o.setText("");
                            }
                            if (GlobalApplication.m3265f()) {
                                C1789u.m6075a().edit().putString("last_add_buddy_country", string).commit();
                                C1789u.m6075a().edit().putString("last_add_buddy_country_code", String.valueOf(this.f4237g.get(string))).commit();
                            }
                            this.f4253w = String.valueOf(this.f4238h.get(string));
                        } else {
                            String string2 = extras.getString("PARAMS_COUNTRY_CODE");
                            this.f4247q.setText("");
                            this.f4242l = string2;
                            this.f4246p.setText(" (+" + string2 + ")");
                        }
                        m4395a();
                        break;
                    case 48:
                        m4373a(getActivity(), "normal_ACS");
                        break;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public void m4379c() {
            String strTrim;
            C0633e c0633e = new C0633e(this.f4236f);
            if (this.f4242l != null) {
                strTrim = this.f4242l + this.f4245o.getText().toString().trim();
            } else {
                strTrim = this.f4245o.getText().toString().trim();
            }
            C1786r.m6061b("addBuddyInternal orgnum=" + strTrim + ", country code=" + this.f4242l, getClass().getSimpleName());
            c0633e.m2869b(strTrim, this.f4242l != null);
            this.f4230P = (this.f4242l != null ? "+" : "") + strTrim;
        }

        @Override // android.support.v4.app.Fragment
        public void onResume() {
            super.onResume();
            C1786r.m6061b("onResume", getClass().getSimpleName());
            if (this.f4245o.getText().length() > 0) {
                if (this.f4249s != null) {
                    this.f4249s.setEnabled(true);
                }
                if (this.f4250t != null) {
                    this.f4250t.setEnabled(true);
                }
                if (this.f4251u != null) {
                    this.f4251u.setEnabled(true);
                }
                if (GlobalApplication.m3265f() && this.f4217C != 1 && this.f4216B != null) {
                    this.f4216B.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
                    this.f4216B.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
                    return;
                }
                return;
            }
            if (this.f4249s != null) {
                this.f4249s.setEnabled(false);
            }
            if (this.f4251u != null) {
                this.f4251u.setEnabled(false);
            }
            if (this.f4250t != null) {
                this.f4250t.setEnabled(false);
            }
            if (GlobalApplication.m3265f() && this.f4217C != 1 && this.f4216B != null) {
                this.f4216B.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(false);
                this.f4216B.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnCancel /* 2131493037 */:
                    this.f4245o.setText("");
                    break;
                case R.id.btnSelfSMS /* 2131493737 */:
                    m4375a("SMS");
                    break;
                case R.id.btnGenerateIMEI /* 2131493738 */:
                    C1721ad.m5874a(getActivity());
                    Toast.makeText(getActivity(), "Random device id is generated.", 1).show();
                    break;
                case R.id.btnNSS /* 2131493739 */:
                    m4373a(getActivity(), "SMS");
                    break;
                case R.id.btnSMSACS /* 2131493741 */:
                    m4375a("SMS");
                    break;
                case R.id.btnACS /* 2131493742 */:
                    m4375a("ACS");
                    break;
            }
        }

        /* renamed from: a */
        private void m4375a(String str) {
            this.f4228N = str;
            if (this.f4228N == "SMS") {
                if (this.f4249s != null) {
                    this.f4249s.setEnabled(false);
                }
                if (this.f4250t != null) {
                    this.f4250t.setEnabled(false);
                }
            } else if (this.f4251u != null) {
                this.f4251u.setEnabled(false);
            }
            if (this.f4245o.getText().length() <= 0) {
                Toast.makeText(getActivity(), R.string.setting_toast_enter_phone_number, 1).show();
                return;
            }
            if (getActivity() != null) {
                this.f4256z.dismiss();
            }
            if (this.f4217C != 1) {
            }
            if (this.f4217C == 1) {
                this.f4256z = ProgressDialogC1806j.m6141a(this.f4215A, null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
                m4379c();
                return;
            }
            C1786r.m6061b("mCountryCallingCode=" + this.f4242l + " userPhoneNumber=" + this.f4245o.getText().toString(), getClass().getSimpleName());
            C0634f c0634f = new C0634f(this.f4235e);
            this.f4256z = ProgressDialogC1806j.m6141a(this.f4215A, null, getResources().getString(R.string.dialog_provision_ing), true);
            if (this.f4222H != null) {
                this.f4222H = this.f4222H.replaceAll(Pattern.quote("(+"), "").replaceAll(Pattern.quote(")"), "");
                this.f4222H = this.f4222H.trim();
                this.f4242l = this.f4222H;
            }
            c0634f.m2885a(this.f4242l, this.f4245o.getText().toString());
            C1789u.m6079a("country_name", this.f4247q.getText().toString());
            C1789u.m6079a("country_code", this.f4242l);
            C1789u.m6079a("country_ISO", this.f4253w);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m4373a(Activity activity, String str) {
            Intent intent = new Intent(activity, (Class<?>) ActivityNonSelfSMS.class);
            if (str.equals("SMS")) {
                C1789u.m6076a("isSMS", (Boolean) true);
            } else if (str.equals("ACS")) {
                C1789u.m6076a("isSMS", (Boolean) false);
            }
            if (str.equals("normal_ACS")) {
                C1789u.m6076a("isSMS", (Boolean) false);
                intent.putExtra("normal_acs", true);
            }
            C1786r.m6061b("flag : " + str, getClass().getSimpleName());
            if (!C1789u.m6075a().getBoolean("skipRegi", false)) {
                intent.putExtra("from_regist", true);
            }
            activity.startActivityForResult(intent, 32);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public void m4381d() {
            try {
                InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(this.f4245o.getWindowToken(), 0);
                }
            } catch (Exception e) {
            }
        }

        /* renamed from: a */
        void m4395a() {
            C1786r.m6061b("[CheckACSMode ] mISOcountryCode : " + this.f4253w, getClass().getSimpleName());
            if (this.f4253w != null) {
                if (GlobalApplication.m3265f()) {
                    if (this.f4253w.equals("US") || this.f4253w.equals("JP")) {
                        if (this.f4250t != null) {
                            this.f4250t.setVisibility(0);
                        }
                        if (this.f4251u != null) {
                            this.f4251u.setVisibility(0);
                        }
                        this.f4252v.setText(getString(R.string.regist_select_acs_sms, 4));
                        C1786r.m6061b("sim is america or japan", getClass().getSimpleName());
                        return;
                    }
                    if (this.f4250t != null) {
                        this.f4250t.setVisibility(8);
                    }
                    if (this.f4251u != null) {
                        this.f4251u.setVisibility(8);
                    }
                    this.f4252v.setText(getString(R.string.regist_receive_sms, 4));
                    C1786r.m6061b("sim is NOT america or japan : " + this.f4253w, getClass().getSimpleName());
                    return;
                }
                if (this.f4253w.equals("US") || this.f4253w.equals("JP")) {
                    if (this.f4249s != null) {
                        this.f4249s.setVisibility(8);
                    }
                    if (this.f4250t != null) {
                        this.f4250t.setVisibility(0);
                    }
                    if (this.f4251u != null) {
                        this.f4251u.setVisibility(0);
                    }
                    C1786r.m6061b("sim is america or japan", getClass().getSimpleName());
                    return;
                }
                if (this.f4249s != null) {
                    this.f4249s.setVisibility(0);
                }
                if (this.f4250t != null) {
                    this.f4250t.setVisibility(8);
                }
                if (this.f4251u != null) {
                    this.f4251u.setVisibility(8);
                }
                C1786r.m6061b("sim is NOT america or japan : " + this.f4253w, getClass().getSimpleName());
            }
        }

        @Override // android.support.v4.app.Fragment
        public void onSaveInstanceState(Bundle bundle) {
            super.onSaveInstanceState(bundle);
            bundle.putString("countryCodeSaved", this.f4246p.getText().toString());
            bundle.putString("countryNameSaved", this.f4247q.getText().toString());
            bundle.putString("phoneNoSaved", this.f4245o.getText().toString());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }
}
