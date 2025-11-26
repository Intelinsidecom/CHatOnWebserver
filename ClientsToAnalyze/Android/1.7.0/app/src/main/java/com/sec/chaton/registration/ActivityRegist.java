package com.sec.chaton.registration;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.hardware.motion.MREvent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.p013a.C0202ao;
import com.sec.chaton.p013a.C0225x;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1336k;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1346u;
import com.sec.chaton.widget.ProgressDialogC1354a;
import com.sec.widget.C1619g;
import com.sec.widget.EditTextWithClearButton;
import com.sec.widget.GeneralHeaderView;
import java.util.HashMap;
import java.util.Map;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* loaded from: classes.dex */
public class ActivityRegist extends BaseSinglePaneActivity {

    /* renamed from: a */
    public static String f3189a;

    /* renamed from: b */
    public static String f3190b;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo664a() {
        return new RegistFragment();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 32) {
            if (i2 == -1) {
                String stringExtra = intent.getStringExtra("AUTH_NUM");
                String stringExtra2 = intent.getStringExtra("TOKEN");
                Intent intent2 = new Intent();
                intent2.putExtra("MSISDN", f3189a);
                intent2.putExtra("AUTH_NUM", stringExtra);
                intent2.putExtra("TOKEN", stringExtra2);
                if (C1323bs.m4575a().getBoolean("wasSMSregi", false)) {
                    C1323bs.m4576a("wasSMSregi", (Boolean) false);
                }
                setResult(-1, intent2);
                finish();
                return;
            }
            if (i2 == 0) {
                finish();
            } else if (i2 == 2) {
                C1323bs.m4576a("wasSMSregi", (Boolean) false);
                C1323bs.m4575a().edit().remove("acstoken").commit();
            }
        }
    }

    public class RegistFragment extends Fragment implements View.OnClickListener {

        /* renamed from: A */
        private Menu f3191A;

        /* renamed from: G */
        private String f3197G;

        /* renamed from: K */
        private String f3201K;

        /* renamed from: L */
        private GeneralHeaderView f3202L;

        /* renamed from: O */
        private String f3205O;

        /* renamed from: g */
        private Map f3212g;

        /* renamed from: h */
        private Map f3213h;

        /* renamed from: i */
        private CharSequence[] f3214i;

        /* renamed from: j */
        private CharSequence[] f3215j;

        /* renamed from: k */
        private CharSequence[] f3216k;

        /* renamed from: l */
        private String f3217l;

        /* renamed from: m */
        private String f3218m;

        /* renamed from: n */
        private LinearLayout f3219n;

        /* renamed from: o */
        private EditTextWithClearButton f3220o;

        /* renamed from: p */
        private TextView f3221p;

        /* renamed from: q */
        private TextView f3222q;

        /* renamed from: r */
        private Button f3223r;

        /* renamed from: s */
        private Button f3224s;

        /* renamed from: t */
        private Button f3225t;

        /* renamed from: u */
        private Button f3226u;

        /* renamed from: v */
        private TextView f3227v;

        /* renamed from: w */
        private String f3228w;

        /* renamed from: x */
        private Button f3229x;

        /* renamed from: z */
        private Context f3231z;

        /* renamed from: a */
        final int f3206a = 16;

        /* renamed from: b */
        final int f3207b = 0;

        /* renamed from: c */
        final int f3208c = 48;

        /* renamed from: y */
        private ProgressDialog f3230y = null;

        /* renamed from: B */
        private int f3192B = 0;

        /* renamed from: C */
        private String f3193C = null;

        /* renamed from: D */
        private String f3194D = null;

        /* renamed from: E */
        private String f3195E = null;

        /* renamed from: F */
        private String f3196F = null;

        /* renamed from: H */
        private final String f3198H = C1323bs.m4575a().getString("country_letter", "");

        /* renamed from: I */
        private final boolean f3199I = C1323bs.m4575a().getString("selected_country", "").equals("DONE");

        /* renamed from: J */
        private final String f3200J = C1323bs.m4575a().getString("phonenumber", null);

        /* renamed from: M */
        private boolean f3203M = false;

        /* renamed from: d */
        View.OnClickListener f3209d = new ViewOnClickListenerC0988t(this);

        /* renamed from: N */
        private TextWatcher f3204N = new C0987s(this);

        /* renamed from: e */
        Handler f3210e = new HandlerC0993y(this);

        /* renamed from: f */
        Handler f3211f = new HandlerC0992x(this);

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            C1341p.m4658b("onCreate...", getClass().getSimpleName());
            if (bundle != null) {
                this.f3203M = true;
            }
            if (C1323bs.m4575a().getBoolean("wasSMSregi", false) && this.f3192B == 0) {
                if (!this.f3203M) {
                    if (C1323bs.m4575a().getBoolean("isSMS", true)) {
                        m3688a(getActivity(), "SMS");
                    } else {
                        m3688a(getActivity(), "ACS");
                    }
                } else {
                    getActivity().finish();
                }
            }
            this.f3231z = getActivity();
            BaseActivity.m2043b(this, true);
            if (getActivity() != null) {
                this.f3230y = new ProgressDialogC1354a(getActivity());
            }
            this.f3212g = new HashMap();
            this.f3213h = new HashMap();
            this.f3214i = getResources().getTextArray(R.array.country);
            this.f3215j = getResources().getTextArray(R.array.country_code);
            this.f3216k = getResources().getTextArray(R.array.ISO_country_code_Letter2);
            for (int i = 0; i < this.f3214i.length; i++) {
                this.f3212g.put(this.f3216k[i], this.f3215j[i]);
                this.f3213h.put(this.f3216k[i], this.f3214i[i]);
            }
        }

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            C1341p.m4658b("onCreateView...", getClass().getSimpleName());
            View viewInflate = layoutInflater.inflate(R.layout.layout_regist, viewGroup, false);
            this.f3219n = (LinearLayout) viewInflate.findViewById(R.id.newSearch);
            this.f3221p = (TextView) viewInflate.findViewById(R.id.editCountryCode);
            this.f3222q = (TextView) viewInflate.findViewById(R.id.editCountryName);
            this.f3220o = (EditTextWithClearButton) viewInflate.findViewById(R.id.editPno);
            this.f3220o.setMaxLengthString(R.string.toast_text_max_Length);
            this.f3227v = (TextView) viewInflate.findViewById(R.id.txtRegist_2);
            this.f3227v.setText(getString(R.string.regist_select_acs_sms, 4));
            this.f3202L = (GeneralHeaderView) viewInflate.findViewById(R.id.txt_title_regist);
            this.f3202L.setButtonClickListener(new ViewOnClickListenerC0990v(this));
            if (viewInflate.findViewById(R.id.btnCancel) != null) {
                this.f3223r = (Button) viewInflate.findViewById(R.id.btnCancel);
                this.f3223r.setOnClickListener(this);
            }
            if (viewInflate.findViewById(R.id.btnSMS) != null) {
                this.f3224s = (Button) viewInflate.findViewById(R.id.btnSMS);
                this.f3224s.setOnClickListener(this);
            }
            if (viewInflate.findViewById(R.id.btnSMSACS) != null) {
                this.f3225t = (Button) viewInflate.findViewById(R.id.btnSMSACS);
                this.f3225t.setOnClickListener(this);
            }
            if (viewInflate.findViewById(R.id.btnGenerateIMEI) != null) {
                this.f3229x = (Button) viewInflate.findViewById(R.id.btnGenerateIMEI);
                this.f3229x.setOnClickListener(this);
            }
            if (viewInflate.findViewById(R.id.btnACS) != null) {
                this.f3226u = (Button) viewInflate.findViewById(R.id.btnACS);
                this.f3226u.setOnClickListener(this);
            }
            this.f3219n.setOnClickListener(this.f3209d);
            if (getActivity().getIntent() != null) {
                this.f3192B = getActivity().getIntent().getIntExtra(RtspHeaders.Values.MODE, 0);
            }
            if (this.f3192B == 1) {
                ((GeneralHeaderView) viewInflate.findViewById(R.id.txt_title_regist)).setText(R.string.buddy_list_dialog_addbuddy_title);
                ((TextView) viewInflate.findViewById(R.id.txtRegist_1)).setText(R.string.buddy_list_dialog_addbuddy_hint);
                ((TextView) viewInflate.findViewById(R.id.txt_select_country)).setText(R.string.layout_regist_select_country_code_if_differs);
            }
            if (this.f3192B == 0) {
                C1341p.m4647a();
                if (viewInflate.findViewById(R.id.txt_title_regist) != null) {
                    viewInflate.findViewById(R.id.txt_title_regist).setOnClickListener(new ViewOnClickListenerC0989u(this));
                }
            }
            return viewInflate;
        }

        @Override // android.support.v4.app.Fragment
        public void onPrepareOptionsMenu(Menu menu) {
            C1341p.m4658b("onPrepareOptionsMenu", getClass().getSimpleName());
            menu.clear();
            MenuInflater menuInflater = getActivity().getMenuInflater();
            if (this.f3192B != 1) {
                menuInflater.inflate(R.menu.actionbar_title_done_cancel_next, menu);
                menu.removeItem(R.id.actionbar_title_cancel);
                menu.removeItem(R.id.actionbar_title_next);
            } else {
                menuInflater.inflate(R.menu.actionbar_menu_search_cancel, menu);
                menu.findItem(R.id.actionbar_title_search).setVisible(true).setEnabled(false);
            }
            this.f3191A = menu;
        }

        @Override // android.support.v4.app.Fragment
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            C1341p.m4658b("onOptionsItemSelected...", getClass().getSimpleName());
            switch (menuItem.getItemId()) {
                case R.id.actionbar_title_search /* 2131428236 */:
                case R.id.actionbar_title_done /* 2131428239 */:
                    m3691a("SMS");
                    break;
                case R.id.actionbar_title_cancel /* 2131428237 */:
                    getActivity().finish();
                    break;
            }
            return true;
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            String upperCase = C1336k.m4628e().toUpperCase();
            if (this.f3192B == 0) {
                if (upperCase != null && upperCase.length() > 0 && !this.f3199I) {
                    String string = C1323bs.m4575a().getString("country_code", null);
                    String string2 = C1323bs.m4575a().getString("country_ISO", null);
                    if (string2 == null) {
                        String strValueOf = String.valueOf(this.f3213h.get(upperCase));
                        this.f3217l = String.valueOf(this.f3212g.get(upperCase));
                        if (strValueOf.length() > 21 && strValueOf.length() <= 28) {
                            this.f3222q.setTextSize(18.0f);
                            this.f3221p.setTextSize(18.0f);
                        } else if (strValueOf.length() > 29) {
                            this.f3222q.setTextSize(14.0f);
                            this.f3221p.setTextSize(14.0f);
                        } else {
                            this.f3222q.setTextSize(21.0f);
                            this.f3221p.setTextSize(21.0f);
                        }
                        this.f3222q.setText(strValueOf);
                        this.f3221p.setText(" (+" + this.f3217l + ")");
                        this.f3228w = upperCase;
                        C1341p.m4658b("[First]CallingCode : " + this.f3217l + " ISOLetter : " + this.f3228w + " CountryName : " + strValueOf, getClass().getSimpleName());
                    } else {
                        this.f3228w = string2;
                        String strValueOf2 = String.valueOf(this.f3213h.get(this.f3228w));
                        if (strValueOf2.length() > 21 && strValueOf2.length() <= 28) {
                            this.f3222q.setTextSize(18.0f);
                            this.f3221p.setTextSize(18.0f);
                        } else if (strValueOf2.length() > 29) {
                            this.f3222q.setTextSize(14.0f);
                            this.f3221p.setTextSize(14.0f);
                        } else {
                            this.f3222q.setTextSize(21.0f);
                            this.f3221p.setTextSize(21.0f);
                        }
                        this.f3222q.setText(strValueOf2);
                        this.f3221p.setText(" (+" + string + ")");
                        this.f3217l = string;
                        C1341p.m4658b("[SavedISO]CallingCode : " + this.f3217l + " ISOLetter : " + this.f3228w + " CountryName : " + strValueOf2, getClass().getSimpleName());
                    }
                } else if (this.f3199I && !TextUtils.isEmpty(this.f3198H)) {
                    String strValueOf3 = String.valueOf(this.f3212g.get(this.f3198H));
                    String strValueOf4 = String.valueOf(this.f3213h.get(this.f3198H));
                    C1341p.m4658b("[MID]countryName: " + strValueOf4 + " countrycode: " + strValueOf3 + " ISOletter : " + this.f3198H, getClass().getSimpleName());
                    if (strValueOf4.length() > 21 && strValueOf4.length() <= 28) {
                        this.f3222q.setTextSize(18.0f);
                        this.f3221p.setTextSize(18.0f);
                    } else if (strValueOf4.length() > 29) {
                        this.f3222q.setTextSize(14.0f);
                        this.f3221p.setTextSize(14.0f);
                    } else {
                        this.f3222q.setTextSize(21.0f);
                        this.f3221p.setTextSize(21.0f);
                    }
                    this.f3222q.setText(strValueOf4);
                    this.f3221p.setText(" (+" + strValueOf3 + ")");
                    this.f3217l = strValueOf3;
                    this.f3228w = this.f3198H;
                } else {
                    m3693b();
                }
                m3708a();
            } else {
                m3693b();
            }
            this.f3197G = C1336k.m4627d();
            if (getActivity().getIntent() != null) {
                this.f3192B = getActivity().getIntent().getIntExtra(RtspHeaders.Values.MODE, 0);
            }
            if (this.f3192B != 1) {
                if (this.f3200J != null) {
                    this.f3220o.append(this.f3200J);
                } else if (this.f3197G != null && this.f3217l != null && this.f3197G.length() > 3) {
                    if (this.f3197G.startsWith("+" + this.f3217l)) {
                        this.f3220o.append(this.f3197G.substring(this.f3217l.length() + 1));
                    } else if (this.f3197G.startsWith(this.f3217l)) {
                        this.f3220o.append(this.f3197G.substring(this.f3217l.length()));
                    } else if (!this.f3197G.startsWith("0000") && this.f3197G.length() > 6) {
                        C1341p.m4658b("msisdn did NOT start with CC", getClass().getSimpleName());
                        this.f3220o.append(this.f3197G);
                    }
                }
            }
            C1341p.m4658b("Auto Read #phone > phoneNum : " + this.f3197G + "CountryCallingCode :" + this.f3217l, getClass().getSimpleName());
            this.f3220o.addTextChangedListener(this.f3204N);
        }

        /* renamed from: b */
        private void m3693b() {
            this.f3222q.setText(R.string.layout_regist_no_country_selected);
            this.f3221p.setText("");
            this.f3217l = null;
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityResult(int i, int i2, Intent intent) {
            if (i2 == -1) {
                switch (i) {
                    case 16:
                        Bundle extras = intent.getExtras();
                        String string = extras.getString("PARAMS_COUNTRY_NAME");
                        if (string != null) {
                            this.f3218m = this.f3217l;
                            this.f3217l = String.valueOf(this.f3212g.get(string));
                            if (String.valueOf(this.f3213h.get(string)).length() > 21 && String.valueOf(this.f3213h.get(string)).length() <= 28) {
                                this.f3222q.setTextSize(18.0f);
                                this.f3221p.setTextSize(18.0f);
                            } else if (String.valueOf(this.f3213h.get(string)).length() > 29) {
                                this.f3222q.setTextSize(14.0f);
                                this.f3221p.setTextSize(14.0f);
                            } else {
                                this.f3222q.setTextSize(21.0f);
                                this.f3221p.setTextSize(21.0f);
                            }
                            this.f3221p.setText(" (+" + this.f3217l + ")");
                            this.f3222q.setText(String.valueOf(this.f3213h.get(string)));
                            C1341p.m4658b("[SelectCountry] NewCallingCode : " + this.f3217l + " PreviusCallingCode : " + this.f3218m, getClass().getSimpleName());
                            if (this.f3218m != null && !this.f3218m.equals(this.f3217l)) {
                                this.f3220o.setText("");
                            }
                            this.f3228w = String.valueOf(string);
                        } else {
                            String string2 = extras.getString("PARAMS_COUNTRY_CODE");
                            this.f3222q.setText("");
                            this.f3217l = string2;
                            this.f3221p.setText(" (+" + string2 + ")");
                        }
                        m3708a();
                        break;
                    case MREvent.SNAP1_X_NEGATIVE /* 48 */:
                        m3688a(getActivity(), "ACS");
                        break;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public void m3695c() {
            String strTrim;
            C0202ao c0202ao = new C0202ao(this.f3211f);
            if (this.f3217l != null) {
                strTrim = this.f3217l + this.f3220o.getText().toString().trim();
            } else {
                strTrim = this.f3220o.getText().toString().trim();
            }
            C1341p.m4658b("addBuddyInternal orgnum=" + strTrim + ", country code=" + this.f3217l, getClass().getSimpleName());
            c0202ao.m765b(strTrim, this.f3217l != null);
            this.f3205O = (this.f3217l != null ? "+" : "") + strTrim;
        }

        @Override // android.support.v4.app.Fragment
        public void onResume() {
            super.onResume();
            C1341p.m4658b("onResume", getClass().getSimpleName());
            if (this.f3220o.getText().length() > 0) {
                if (this.f3224s != null) {
                    this.f3224s.setEnabled(true);
                }
                if (this.f3225t != null) {
                    this.f3225t.setEnabled(true);
                }
                if (this.f3226u != null) {
                    this.f3226u.setEnabled(true);
                }
                if (this.f3202L != null) {
                    this.f3202L.setButtonEnabled(true);
                    return;
                }
                return;
            }
            if (this.f3224s != null) {
                this.f3224s.setEnabled(false);
            }
            if (this.f3226u != null) {
                this.f3226u.setEnabled(false);
            }
            if (this.f3225t != null) {
                this.f3225t.setEnabled(false);
            }
            if (this.f3202L != null) {
                this.f3202L.setButtonEnabled(false);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!C1346u.m4676a()) {
                switch (view.getId()) {
                    case R.id.btnCancel /* 2131427469 */:
                        this.f3220o.setText("");
                        break;
                    case R.id.btnSMS /* 2131427840 */:
                        m3691a("SMS");
                        break;
                    case R.id.btnSMSACS /* 2131427974 */:
                        m3691a("SMS");
                        break;
                    case R.id.btnACS /* 2131427975 */:
                        m3691a("ACS");
                        break;
                    case R.id.btnGenerateIMEI /* 2131427976 */:
                        C1336k.m4622a(getActivity());
                        C1619g.m5889a(getActivity(), "Random device id is generated.", 1).show();
                        break;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m3691a(String str) {
            this.f3201K = str;
            if (this.f3201K == "SMS") {
                this.f3202L.setButtonEnabled(false);
                this.f3224s.setEnabled(false);
                this.f3225t.setEnabled(false);
            } else {
                this.f3226u.setEnabled(false);
            }
            if (this.f3220o.getText().length() <= 0) {
                C1619g.m5888a(getActivity(), R.string.setting_toast_enter_phone_number, 1).show();
                return;
            }
            if (getActivity() != null) {
                this.f3230y.dismiss();
            }
            if (this.f3192B != 1) {
            }
            if (this.f3192B == 1) {
                if (this.f3231z != null) {
                    this.f3230y = ProgressDialogC1354a.m4724a(this.f3231z, null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
                }
                m3695c();
                return;
            }
            C1341p.m4658b("mCountryCallingCode=" + this.f3217l + " userPhoneNumber=" + this.f3220o.getText().toString(), getClass().getSimpleName());
            C0225x c0225x = new C0225x(this.f3210e);
            if (this.f3231z != null) {
                this.f3230y = ProgressDialogC1354a.m4724a(this.f3231z, null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
            }
            c0225x.m870a(this.f3217l, this.f3220o.getText().toString());
            C1323bs.m4579a("country_name", this.f3222q.getText().toString());
            C1323bs.m4579a("country_code", this.f3217l);
            C1323bs.m4579a("country_ISO", this.f3228w);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m3688a(Activity activity, String str) {
            Intent intent = new Intent(activity, (Class<?>) ActivityNonSelfSMS.class);
            if (str.equals("SMS")) {
                C1323bs.m4576a("isSMS", (Boolean) true);
            } else if (str.equals("ACS")) {
                C1323bs.m4576a("isSMS", (Boolean) false);
            }
            C1341p.m4658b("flag : " + str, getClass().getSimpleName());
            activity.startActivityForResult(intent, 32);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public void m3697d() {
            try {
                InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(this.f3220o.getWindowToken(), 0);
                }
            } catch (Exception e) {
            }
        }

        /* renamed from: a */
        void m3708a() {
            C1341p.m4658b("[CheckACSMode ] mISOcountryCode : " + this.f3228w, getClass().getSimpleName());
            if (this.f3228w != null) {
                if (this.f3228w.equals("US") || this.f3228w.equals("JP")) {
                    if (this.f3202L != null) {
                        this.f3202L.setButtonImageResource(0);
                    }
                    if (this.f3224s != null) {
                        this.f3224s.setVisibility(8);
                    }
                    if (this.f3225t != null) {
                        this.f3225t.setVisibility(0);
                    }
                    if (this.f3226u != null) {
                        this.f3226u.setVisibility(0);
                    }
                    this.f3227v.setText(getString(R.string.regist_select_acs_sms, 4));
                    C1341p.m4658b("sim is america or japan", getClass().getSimpleName());
                    return;
                }
                if (this.f3202L != null) {
                    this.f3202L.setButtonImageResource(R.drawable.general_btn_icon_complete_xml);
                }
                if (this.f3224s != null) {
                    this.f3224s.setVisibility(8);
                }
                if (this.f3225t != null) {
                    this.f3225t.setVisibility(8);
                }
                if (this.f3226u != null) {
                    this.f3226u.setVisibility(8);
                }
                this.f3227v.setText(getString(R.string.regist_receive_sms, 4));
                C1341p.m4658b("sim is NOT america or japan : " + this.f3228w, getClass().getSimpleName());
                this.f3220o.setOnEditorActionListener(new C0991w(this));
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }
}
