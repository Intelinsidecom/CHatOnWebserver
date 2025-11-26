package com.sec.chaton.samsungaccount;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.SelectCountry;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p055d.C2095ba;
import com.sec.chaton.p055d.C2105bk;
import com.sec.chaton.p055d.InterfaceC2113bs;
import com.sec.chaton.plugin.C2948h;
import com.sec.chaton.plugin.EnumC2949i;
import com.sec.chaton.registration.ActivityDisclaimerGlobal;
import com.sec.chaton.registration.ActivityDisclaimerKR;
import com.sec.chaton.sns.p114b.AbstractC4439w;
import com.sec.chaton.sns.p114b.InterfaceC4377ac;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ImageTextViewGroup;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;

/* loaded from: classes.dex */
public class MainActivity extends AbstractMultiDeviceActivity {

    /* renamed from: B */
    protected Context f12192B;

    /* renamed from: C */
    protected C2105bk f12193C;

    /* renamed from: I */
    private Bundle f12199I;

    /* renamed from: J */
    private ImageTextViewGroup f12200J;

    /* renamed from: K */
    private ImageTextViewGroup f12201K;

    /* renamed from: L */
    private LinearLayout f12202L;

    /* renamed from: M */
    private Button f12203M;

    /* renamed from: N */
    private TextView f12204N;

    /* renamed from: O */
    private boolean f12205O;

    /* renamed from: P */
    private ImageView f12206P;

    /* renamed from: Q */
    private ImageView f12207Q;

    /* renamed from: R */
    private ImageView f12208R;

    /* renamed from: S */
    private String f12209S;

    /* renamed from: T */
    private ViewPager f12210T;

    /* renamed from: U */
    private C3367bs f12211U;

    /* renamed from: V */
    private LinearLayout f12212V;

    /* renamed from: W */
    private LinearLayout f12213W;

    /* renamed from: X */
    private LinearLayout f12214X;

    /* renamed from: Y */
    private LinearLayout f12215Y;

    /* renamed from: Z */
    private LinearLayout f12216Z;

    /* renamed from: aa */
    private int f12217aa;

    /* renamed from: ab */
    private EditText f12218ab;

    /* renamed from: ae */
    private View f12221ae;

    /* renamed from: af */
    private InterfaceC4936e f12222af;

    /* renamed from: ag */
    private ImageView f12223ag;

    /* renamed from: ah */
    private ImageView f12224ah;

    /* renamed from: ai */
    private ImageView f12225ai;

    /* renamed from: aj */
    private LinearLayout f12226aj;

    /* renamed from: ak */
    private LinearLayout f12227ak;

    /* renamed from: al */
    private LinearLayout f12228al;

    /* renamed from: ao */
    private C2095ba f12231ao;

    /* renamed from: ap */
    private boolean f12232ap;

    /* renamed from: E */
    private final int f12195E = 5;

    /* renamed from: F */
    private final int f12196F = 6;

    /* renamed from: G */
    private final int f12197G = 7;

    /* renamed from: H */
    private final int f12198H = 8;

    /* renamed from: ac */
    private int f12219ac = 0;

    /* renamed from: ad */
    private int f12220ad = 0;

    /* renamed from: am */
    private ProgressDialog f12229am = null;

    /* renamed from: an */
    private InterfaceC4936e f12230an = null;

    /* renamed from: D */
    InterfaceC2113bs f12194D = new C3344aw(this);

    /* renamed from: aq */
    private View.OnClickListener f12233aq = new ViewOnClickListenerC3350bb(this);

    /* renamed from: ar */
    private Handler f12234ar = new HandlerC3351bc(this);

    /* renamed from: h */
    static /* synthetic */ int m13178h(MainActivity mainActivity) {
        int i = mainActivity.f12217aa;
        mainActivity.f12217aa = i + 1;
        return i;
    }

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onCreate", this.f12209S);
        }
        this.f12192B = this;
        this.f12209S = getClass().getSimpleName();
        if (C2349a.m10301a("chatonv_feature") && C2948h.m12190a().m12192a(this.f12192B, EnumC2949i.ChatONV)) {
            this.f12205O = false;
        }
        this.f12199I = getIntent().getExtras();
        if (this.f12199I != null && this.f12199I.getBoolean("is_sns_mode", false)) {
            setTitle(R.string.sign_in_with_sns_account);
        } else if (m18784t() != null) {
            m18784t().mo18837f();
        }
        this.f12231ao = new C2095ba(this.f12234ar);
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity
    /* renamed from: f */
    protected void mo12783f() {
        setContentView(R.layout.layout_multi_device_main);
        this.f12200J = (ImageTextViewGroup) findViewById(R.id.btn_phone_number).findViewById(R.id.button4);
        this.f12200J.setImageResource(R.drawable.sync_ic_contact);
        this.f12200J.setText(R.string.buddy_contact_sync);
        this.f12200J.setOnClickListener(new ViewOnClickListenerC3343av(this));
        this.f12201K = (ImageTextViewGroup) findViewById(R.id.btn_samsung_account).findViewById(R.id.button4);
        this.f12201K.setImageResource(R.drawable.sync_ic_account);
        this.f12201K.setText(R.string.setting_samsung_account);
        this.f12201K.setOnClickListener(new ViewOnClickListenerC3359bk(this));
        this.f12202L = (LinearLayout) findViewById(R.id.sns_or_skip);
        if (GlobalApplication.m10286e()) {
            this.f12202L.setVisibility(8);
        }
        this.f12203M = (Button) findViewById(R.id.btn_next).findViewById(R.id.button1);
        this.f12203M.setText(R.string.dialog_next);
        this.f12203M.setOnClickListener(new ViewOnClickListenerC3360bl(this));
        m13184u();
        this.f12204N = (TextView) findViewById(R.id.textEmail);
        this.f12210T = (ViewPager) findViewById(R.id.flickinng_image);
        this.f12206P = (ImageView) findViewById(R.id.indicator1);
        this.f12207Q = (ImageView) findViewById(R.id.indicator2);
        this.f12208R = (ImageView) findViewById(R.id.indicator3);
        this.f12212V = (LinearLayout) findViewById(R.id.layout_overall_bottom);
        this.f12213W = (LinearLayout) findViewById(R.id.sync_intro_layout1);
        this.f12214X = (LinearLayout) findViewById(R.id.sync_intro_layout2);
        this.f12215Y = (LinearLayout) findViewById(R.id.sync_intro_layout3);
        m13169a(getResources().getConfiguration());
        if (C2349a.m10301a("for_wifi_only_device") || C4822an.m18196F()) {
            if (GlobalApplication.m10286e()) {
                this.f12227ak.setVisibility(8);
            }
            this.f12200J.setVisibility(8);
            findViewById(R.id.weight_layout).setVisibility(8);
        } else {
            if (this.f12163q) {
                if (GlobalApplication.m10286e()) {
                    this.f12227ak.setVisibility(8);
                }
                this.f12200J.setVisibility(8);
            } else {
                if (GlobalApplication.m10286e()) {
                    this.f12228al.setVisibility(8);
                }
                this.f12200J.setVisibility(8);
            }
            findViewById(R.id.weight_layout).setVisibility(8);
        }
        if (this.f12205O) {
            this.f12208R.setVisibility(0);
        }
        this.f12211U = new C3367bs(this, m50e(), this.f12205O);
        this.f12210T.setAdapter(this.f12211U);
        C4904y.m18638b();
        this.f12202L.setOnClickListener(this.f12233aq);
        this.f12221ae = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.layout_eidit_text, (ViewGroup) null);
        this.f12218ab = (EditText) this.f12221ae.findViewById(R.id.editBox);
        this.f12222af = AbstractC4932a.m18733a(this.f12192B).mo18742a(true).mo18748b(this.f12221ae).mo18756d(R.string.done, new DialogInterfaceOnClickListenerC3362bn(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3361bm(this)).mo18745a();
        this.f12210T.setOnPageChangeListener(new C3363bo(this));
    }

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity
    /* renamed from: g */
    protected void mo12787g() {
        if (this.f12199I != null) {
            this.f12163q = this.f12199I.getBoolean("is_mapping_mode", false);
        }
    }

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity
    /* renamed from: h */
    protected void mo12788h() {
        if (!this.f12232ap) {
            this.f12213W.setVisibility(8);
            this.f12214X.setVisibility(0);
            if (GlobalApplication.m10286e()) {
                this.f12226aj.setVisibility(0);
            }
        }
    }

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity
    /* renamed from: i */
    protected void mo12789i() {
        if (this.f12199I != null) {
            this.f12165s = this.f12199I.getBoolean("is_ready_to_sa", false);
        }
    }

    /* renamed from: u */
    private void m13184u() {
        this.f12223ag = (ImageView) findViewById(R.id.btn_facebook);
        this.f12223ag.setOnClickListener(new ViewOnClickListenerC3364bp(this));
        this.f12224ah = (ImageView) findViewById(R.id.btn_odnoklassniki);
        this.f12224ah.setOnClickListener(new ViewOnClickListenerC3365bq(this));
        this.f12225ai = (ImageView) findViewById(R.id.btn_vkontakte);
        this.f12225ai.setOnClickListener(new ViewOnClickListenerC3366br(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: s */
    public void m13191s() {
        this.f12170x = false;
        if (C4809aa.m18104a().m18121a("provisioning_disclaimer_status", "").equals("DONE")) {
            m13185v();
            if (this.f12193C != null) {
                this.f12193C.m9426a(this.f12194D);
                this.f12193C.m9430e();
                return;
            }
            return;
        }
        if (!C4809aa.m18104a().m18129b("country_letter")) {
            Intent intent = new Intent(this, (Class<?>) SelectCountry.class);
            intent.putExtra("sns_type", this.f12193C.m9424a());
            startActivityForResult(intent, 7);
            return;
        }
        m13165A();
    }

    /* renamed from: v */
    private void m13185v() {
        m13186w();
        this.f12229am = ProgressDialogC4926s.m18727a(this.f12192B, null, getResources().getString(R.string.dialog_provision_ing));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public void m13186w() {
        if (this.f12229am != null && this.f12229am.isShowing()) {
            this.f12229am.dismiss();
        }
        m13148q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public void m13187x() {
        m13188y();
        this.f12230an = AbstractC4932a.m18733a(this.f12192B).mo18740a(getResources().getString(R.string.registration_error)).mo18749b(getResources().getString(R.string.chatonv_sign_in_error)).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3349ba(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3347az(this)).mo18745a();
        this.f12230an.show();
    }

    /* renamed from: y */
    private void m13188y() {
        if (this.f12230an != null && this.f12230an.isShowing()) {
            this.f12230an.dismiss();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        m13171a(i);
        return super.onKeyUp(i, keyEvent);
    }

    /* renamed from: a */
    private boolean m13171a(int i) {
        switch (i) {
            case 24:
                if (this.f12219ac < 2) {
                    this.f12219ac++;
                } else {
                    this.f12219ac = 0;
                }
                if (!C4904y.f17872b) {
                    return true;
                }
                C4904y.m18639b("volume up : " + this.f12219ac + " volume down : " + this.f12220ad, this.f12209S);
                return true;
            case 25:
                if (this.f12219ac == 2) {
                    if (this.f12220ad < 2) {
                        this.f12220ad++;
                    } else if (this.f12220ad == 2) {
                        if (!this.f12166t && this.f12222af != null) {
                            this.f12222af.setCancelable(false);
                            this.f12222af.show();
                        }
                        this.f12220ad = 0;
                        this.f12219ac = 0;
                    } else {
                        this.f12220ad = 0;
                    }
                }
                if (!C4904y.f17872b) {
                    return true;
                }
                C4904y.m18639b("volume up : " + this.f12219ac + " volume down : " + this.f12220ad, this.f12209S);
                return true;
            default:
                return false;
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.f12232ap) {
            if (GlobalApplication.m10286e() && this.f12211U != null) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("onConfigurationChanged", getClass().getSimpleName());
                }
                this.f12211U.m617c();
            } else if (this.f12210T != null) {
                int iM424c = this.f12210T.m424c();
                if (C4904y.f17872b) {
                    C4904y.m18639b("onConfigurationChanged, item : " + iM424c, getClass().getSimpleName());
                }
                this.f12210T.setAdapter(this.f12211U);
                this.f12210T.setCurrentItem(iM424c);
            }
            m13169a(configuration);
        }
    }

    /* renamed from: a */
    private void m13169a(Configuration configuration) {
        this.f12216Z = (LinearLayout) findViewById(R.id.layout_buttons);
        if (!GlobalApplication.m10286e()) {
            if (configuration.orientation == 2) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("It is Landscape Mode", getClass().getSimpleName());
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
                this.f12213W.setLayoutParams(layoutParams);
                this.f12214X.setLayoutParams(layoutParams);
                this.f12215Y.setLayoutParams(layoutParams);
                this.f12216Z.setOrientation(0);
                this.f12212V.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                return;
            }
            if (C4904y.f17872b) {
                C4904y.m18639b("It is Portrait Mode", getClass().getSimpleName());
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0, 1.0f);
            this.f12213W.setLayoutParams(layoutParams2);
            this.f12214X.setLayoutParams(layoutParams2);
            this.f12215Y.setLayoutParams(layoutParams2);
            this.f12216Z.setOrientation(1);
            this.f12212V.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    public void onWindowStatusChanged(boolean z, boolean z2, boolean z3) {
        if (GlobalApplication.m10288g()) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            View decorView = getWindow().getDecorView();
            if (decorView != null && displayMetrics != null) {
                m13170a(decorView, displayMetrics);
            }
        }
    }

    /* renamed from: a */
    private void m13170a(View view, DisplayMetrics displayMetrics) {
        double d = view.getLayoutParams().width / displayMetrics.widthPixels;
        double d2 = view.getLayoutParams().height / displayMetrics.heightPixels;
        ImageView imageView = (ImageView) view.findViewById(R.id.logo_on);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.logo_text);
        if (d <= 0.0d || d2 <= 0.0d) {
            imageView2.getLayoutParams().width = getResources().getDimensionPixelSize(R.dimen.intro_chaton_logo_width);
            imageView2.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.intro_chaton_logo_height);
            imageView.getLayoutParams().width = getResources().getDimensionPixelSize(R.dimen.intro_chaton_image_width);
            imageView.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.intro_chaton_image_height);
            return;
        }
        imageView2.getLayoutParams().width = (int) (r6.width * d);
        imageView2.getLayoutParams().height = (int) (r1.height * d2);
        imageView.getLayoutParams().width = (int) (d * r1.width);
        imageView.getLayoutParams().height = (int) (r0.height * d2);
    }

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        if (C4904y.f17872b) {
            C4904y.m18639b("onStart", this.f12209S);
        }
        if (!this.f12232ap) {
            this.f12204N.setText(getString(R.string.provision_start_chat_as, new Object[]{this.f12167u}));
            if ((this.f12168v && !TextUtils.isEmpty(this.f12167u)) || C4809aa.m18104a().m18119a("account_mapping_fail", (Boolean) false).booleanValue()) {
                this.f12213W.setVisibility(8);
                this.f12214X.setVisibility(0);
                this.f12215Y.setVisibility(8);
                if (GlobalApplication.m10286e()) {
                    this.f12226aj.setVisibility(0);
                }
            } else {
                this.f12213W.setVisibility(0);
                this.f12214X.setVisibility(8);
                if (this.f12163q) {
                    this.f12215Y.setVisibility(8);
                } else {
                    this.f12215Y.setVisibility(0);
                }
                if (GlobalApplication.m10286e()) {
                    this.f12226aj.setVisibility(8);
                }
            }
            String strM18121a = C4809aa.m18104a().m18121a("country_letter", (String) null);
            if (!C4859bx.m18408f((String) null) || !C4859bx.m18408f(strM18121a)) {
                this.f12223ag.setVisibility(8);
            } else {
                this.f12223ag.setVisibility(0);
            }
            if (!C4859bx.m18411g((String) null) || !C4859bx.m18411g(strM18121a)) {
                this.f12225ai.setVisibility(8);
            } else {
                this.f12225ai.setVisibility(0);
            }
            if (!C4859bx.m18413h(strM18121a)) {
                this.f12224ah.setVisibility(8);
            } else {
                this.f12224ah.setVisibility(0);
            }
        }
    }

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) throws Resources.NotFoundException {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 5:
                if (i2 == 3) {
                    m13145n();
                    break;
                }
                break;
            case 7:
                if (i2 == -1) {
                    m13165A();
                    break;
                } else if (i2 == 8) {
                    this.f12193C = null;
                    break;
                } else if (i2 == 11) {
                    setResult(11);
                    finish();
                    break;
                }
                break;
            case 8:
                if (i2 == -1) {
                    m13185v();
                    if (this.f12193C != null) {
                        this.f12193C.m9426a(this.f12194D);
                        this.f12193C.m9430e();
                        break;
                    }
                } else if (i2 == 2 && this.f12193C != null) {
                    C4809aa.m18104a().m18123a("country_letter");
                    Intent intent2 = new Intent(this, (Class<?>) SelectCountry.class);
                    intent2.putExtra("sns_type", this.f12193C.m9424a());
                    startActivityForResult(intent2, 7);
                    break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public void m13189z() {
        AbstractC4439w abstractC4439wM16816a;
        if (this.f12193C != null && (abstractC4439wM16816a = AbstractC4439w.m16816a(this.f12193C.m9424a(), this.f12192B)) != null) {
            abstractC4439wM16816a.mo16642a((InterfaceC4377ac) null);
        }
        m13186w();
    }

    @Override // com.sec.chaton.samsungaccount.AbstractMultiDeviceActivity
    /* renamed from: j */
    protected void mo12790j() {
        this.f12231ao.m9350a(this.f12193C);
    }

    /* renamed from: A */
    private void m13165A() {
        Intent intent;
        String strM18243k = C4822an.m18243k();
        String strM18121a = C4809aa.m18104a().m18121a("country_letter", "GB");
        if (TextUtils.isEmpty(strM18243k)) {
            strM18243k = "234";
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("[runDisclaimer] CC : " + strM18121a + " MCC : " + strM18243k, this.f12209S);
        }
        if (strM18243k.equals("450") || strM18121a.equals("KR")) {
            intent = new Intent(this, (Class<?>) ActivityDisclaimerKR.class);
        } else {
            intent = new Intent(this, (Class<?>) ActivityDisclaimerGlobal.class);
        }
        startActivityForResult(intent, 8);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        setResult(2);
        finish();
        return true;
    }

    /* renamed from: d */
    protected void m13190d(boolean z) {
        this.f12232ap = z;
    }
}
