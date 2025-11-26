package com.sec.chaton.registration;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sec.chaton.BootstrapActivity;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1058ba;
import com.sec.chaton.C1062bb;
import com.sec.chaton.IntentControllerActivity;
import com.sec.chaton.R;
import com.sec.chaton.SelectCountry;
import com.sec.chaton.TabActivity;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.event.UsingChatONDialogActivity;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.samsungaccount.AutoRegiSamsungAccountActivity;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.HandlerC4826ar;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.common.util.log.collector.C5043h;
import com.sec.widget.C5179v;

/* loaded from: classes.dex */
public class RegisterSMSActivity extends BaseActivity {

    /* renamed from: n */
    public static String f11832n = "from_messaging_tab";

    /* renamed from: A */
    private boolean f11833A;

    /* renamed from: B */
    private String f11834B;

    /* renamed from: D */
    private boolean f11836D;

    /* renamed from: E */
    private boolean f11837E;

    /* renamed from: F */
    private Intent f11838F;

    /* renamed from: y */
    private Context f11849y;

    /* renamed from: p */
    private final int f11840p = 0;

    /* renamed from: q */
    private final int f11841q = 1;

    /* renamed from: r */
    private final int f11842r = 2;

    /* renamed from: s */
    private final int f11843s = 3;

    /* renamed from: t */
    private final int f11844t = 4;

    /* renamed from: u */
    private final int f11845u = 5;

    /* renamed from: v */
    private final int f11846v = 6;

    /* renamed from: w */
    private final int f11847w = 7;

    /* renamed from: x */
    private final String f11848x = RegisterSMSActivity.class.getSimpleName();

    /* renamed from: z */
    private EnumC3297gd f11850z = null;

    /* renamed from: C */
    private boolean f11835C = false;

    /* renamed from: o */
    HandlerC4826ar f11839o = new HandlerC3296gc(this);

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (C4904y.f17872b) {
            C4904y.m18639b("onCreate : " + bundle, this.f11848x);
        }
        this.f11849y = this;
        Intent intent = getIntent();
        boolean zBooleanValue = C4809aa.m18104a().m18119a("chaton_sa_is_valid", (Boolean) false).booleanValue();
        if (intent != null) {
            if (m13007b(intent)) {
                C4904y.m18641c(this.f11848x + " is requested finish.", this.f11848x);
                finish();
                return;
            }
            this.f11838F = (Intent) intent.getParcelableExtra("base_intent");
            if (intent.getExtras() != null) {
                this.f11850z = (EnumC3297gd) intent.getExtras().get("request_register");
                this.f11833A = intent.getExtras().getBoolean("is_call_direct");
                this.f11834B = intent.getExtras().getString("register_sms_token");
                this.f11835C = intent.getExtras().getBoolean(f11832n);
                if (this.f11850z != null && C4904y.f17872b) {
                    C4904y.m18639b("register mode : " + this.f11850z.toString() + " isCallDirect : " + this.f11833A + " mSMSToken : " + this.f11834B, this.f11848x);
                }
            }
        }
        if (bundle == null) {
            if (C4822an.m18218a()) {
                if (C4904y.f17875e) {
                    C4904y.m18634a("It's already full feature user : " + bundle, this.f11848x);
                }
                if (this.f11833A) {
                    C5179v.m19810a(this.f11849y, R.string.regist_already_regist, 0).show();
                } else {
                    startActivity(BootstrapActivity.m2877a(this, 0));
                }
                finish();
                return;
            }
            if (this.f11850z != null && this.f11850z.equals(EnumC3297gd.reigster)) {
                int iIntValue = C4809aa.m18104a().m18120a("sms_provision_state", (Integer) (-1)).intValue();
                if (iIntValue == -1) {
                    m13013a(5);
                    return;
                } else {
                    m13013a(iIntValue);
                    return;
                }
            }
            if (this.f11833A && this.f11850z != null && this.f11850z.equals(EnumC3297gd.auto_register)) {
                if (!C4822an.m18201K()) {
                    m13013a(4);
                    return;
                } else {
                    m13013a(5);
                    return;
                }
            }
            if (zBooleanValue) {
                m13009g();
            } else {
                m13008f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m13008f() {
        if (EnumC3297gd.auto_register.equals(this.f11850z)) {
            if (!C4822an.m18201K()) {
                m13013a(4);
                return;
            } else {
                m13011i();
                return;
            }
        }
        if (C4809aa.m18104a().m18119a("skip_sms_register_now", (Boolean) false).booleanValue()) {
            startActivity(TabActivity.m3016a(this, this.f11838F));
            finish();
        } else {
            m13010h();
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (m13007b(intent)) {
            C4904y.m18641c("onNewIntent", getClass().getSimpleName());
            finish();
        }
    }

    /* renamed from: g */
    private void m13009g() {
        Intent intent = new Intent(this, (Class<?>) AutoRegiSamsungAccountActivity.class);
        if (C4822an.m18201K()) {
            intent.putExtra("from_lite_user", true);
        }
        startActivityForResult(intent, 0);
        overridePendingTransition(0, 0);
    }

    /* renamed from: h */
    private void m13010h() {
        int iIntValue = C4809aa.m18104a().m18120a("sms_provision_state", (Integer) (-1)).intValue();
        if (iIntValue != -1) {
            this.f11836D = C4809aa.m18104a().m18119a("skip_sms_register_now", (Boolean) false).booleanValue() ? false : true;
            if (this.f11836D) {
                this.f11850z = EnumC3297gd.register_select_now;
            }
            m13013a(iIntValue);
            return;
        }
        m13013a(2);
    }

    /* renamed from: a */
    protected void m13013a(int i) {
        m13014a(i, true);
    }

    /* renamed from: a */
    protected void m13014a(int i, boolean z) {
        if (C4904y.f17872b) {
            C4904y.m18639b("runNextStep : " + i, this.f11848x);
        }
        if (z) {
            C4809aa.m18106a("sms_provision_state", Integer.valueOf(i));
        }
        Intent intent = new Intent();
        switch (i) {
            case 2:
                intent.setClass(this, UsingChatONDialogActivity.class);
                startActivityForResult(intent, 2);
                break;
            case 3:
                intent.setClass(this, SelectCountry.class);
                startActivityForResult(intent, 3);
                break;
            case 4:
                String strM18236g = C4822an.m18236g();
                if (!TextUtils.isEmpty(strM18236g)) {
                    strM18236g = strM18236g.toUpperCase();
                }
                if (!C4859bx.m18387a(strM18236g, this)) {
                    C4809aa.m18104a().m18123a("provisioning_disclaimer_status");
                    String strM18243k = C4822an.m18243k();
                    String strM18121a = C4809aa.m18104a().m18121a("country_letter", "GB");
                    if (TextUtils.isEmpty(strM18243k)) {
                        strM18243k = "234";
                    }
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[runNextStep] SCC : " + strM18121a + " MCC : " + strM18243k, this.f11848x);
                    }
                    if (strM18243k.equals("450") || strM18121a.equals("KR")) {
                        intent.setClass(this, ActivityDisclaimerKR.class);
                        intent.putExtra("request_sms_mode", true);
                        startActivityForResult(intent, 4);
                        break;
                    } else {
                        intent.setClass(this, ActivityDisclaimerGlobal.class);
                        intent.putExtra("request_sms_mode", true);
                        startActivityForResult(intent, 4);
                        break;
                    }
                }
                break;
            case 5:
                if (this.f11850z != null) {
                    C4809aa.m18104a().m18123a("skipRegi");
                }
                intent.setClass(this, ActivityRegist.class);
                intent.putExtra(FragmentRegist.f11705a, true);
                intent.putExtra(FragmentRegist.f11706b, true);
                if (this.f11835C) {
                    if (C4809aa.m18104a().m18129b("menuIndex")) {
                        C4809aa.m18104a().m18123a("menuIndex");
                    }
                    intent.putExtra(FragmentRegist.f11709e, true);
                } else {
                    intent.putExtra(FragmentRegist.f11709e, false);
                }
                if (this.f11850z != null) {
                    intent.putExtra(FragmentRegist.f11707c, this.f11850z);
                    intent.putExtra("register_sms_token", this.f11834B);
                }
                intent.putExtra(FragmentRegist.f11711g, true);
                startActivityForResult(intent, 5);
                break;
            case 6:
                intent.setClass(this, ActivitySignInWithAccount.class);
                intent.putExtra("is_sns_mode", true);
                startActivityForResult(intent, 6);
                break;
            case 7:
                intent.setClass(this, ActivityRegistPushName.class);
                startActivityForResult(intent, 7);
                break;
            default:
                if (C4904y.f17874d) {
                    C4904y.m18645d("requestStep is NOT available", this.f11848x);
                }
                finish();
                break;
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (C4904y.f17872b) {
            C4904y.m18639b("onActivityResult : " + i + " , " + i2, this.f11848x);
        }
        switch (i) {
            case 0:
                if (i2 == 4) {
                    m13012j();
                    setResult(-1);
                    Intent intent2 = new Intent(this.f11849y, (Class<?>) ActivityRegist.class);
                    intent2.putExtra(FragmentRegist.f11708d, true);
                    intent2.putExtra(FragmentRegist.f11706b, true);
                    startActivityForResult(intent2, 1);
                    break;
                } else if (i2 == 3) {
                    C0991aa.m6037a().m18962d(new C1062bb());
                    finish();
                    break;
                } else if (i2 == 11) {
                    finish();
                    break;
                } else {
                    finish();
                    break;
                }
            case 1:
                if (i2 == -1 || i2 == 3) {
                    C4859bx.m18410g();
                    C0991aa.m6037a().m18962d(new C1062bb());
                    finish();
                    break;
                } else {
                    C0991aa.m6037a().m18962d(new C1058ba());
                    finish();
                    break;
                }
                break;
            case 2:
                if (i2 == -1) {
                    this.f11836D = intent.getExtras().getBoolean("key_register_now");
                    C4809aa.m18105a("skip_sms_register_now", Boolean.valueOf(this.f11836D ? false : true));
                    if (C4822an.m18243k() == null) {
                        m13014a(3, false);
                        break;
                    } else if (C4822an.m18201K()) {
                        if (this.f11836D) {
                            this.f11850z = EnumC3297gd.register_select_now;
                            m13013a(5);
                            break;
                        } else {
                            C4809aa.m18104a().m18123a("sms_provision_state");
                            startActivity(TabActivity.m3016a(this, this.f11838F));
                            finish();
                            break;
                        }
                    } else {
                        m13014a(4, false);
                        break;
                    }
                } else {
                    finish();
                    break;
                }
            case 3:
                if (i2 == -1) {
                    m13013a(4);
                    break;
                } else if (i2 == 11) {
                    finish();
                    break;
                } else {
                    finish();
                    break;
                }
            case 4:
                if (i2 == -1) {
                    C4809aa.m18104a().m18128b("lite_feature_user_disclaimer_mcc_code", C4822an.m18243k());
                    if (C4822an.m18236g() != null) {
                        C4809aa.m18104a().m18128b("accept_disclaimer_iso", C4822an.m18236g().toUpperCase());
                    }
                    if (EnumC3297gd.auto_register.equals(this.f11850z)) {
                        m13013a(5);
                        break;
                    } else if (!C4809aa.m18104a().m18119a("skip_sms_register_now", (Boolean) false).booleanValue()) {
                        this.f11850z = EnumC3297gd.register_select_now;
                        m13013a(5);
                        break;
                    } else {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("[SendLog] Accept Disclaimer in only SMS mode", this.f11848x);
                        }
                        C5043h.m19179a().m19185a("0001", "2107", false);
                        C4809aa.m18104a().m18123a("sms_provision_state");
                        if (C2349a.m10301a("sms_feature") && !C4809aa.m18104a().m18129b("pref_key_using_sms_mms_mode")) {
                            C4809aa.m18104a().m18125b("pref_key_using_sms_mms_mode", Boolean.valueOf(C3847e.m14688at()));
                        }
                        startActivity(TabActivity.m3016a(this, this.f11838F));
                        finish();
                        break;
                    }
                } else {
                    finish();
                    break;
                }
                break;
            case 5:
                if (i2 == -1) {
                    C4809aa.m18105a("prov_phone", (Boolean) true);
                    m13013a(7);
                    break;
                } else if (i2 == 2) {
                    if (EnumC3297gd.reigster.equals(this.f11850z)) {
                        finish();
                        break;
                    } else {
                        m13013a(4);
                        break;
                    }
                } else if (i2 == 6) {
                    m13013a(6);
                    break;
                } else if (i2 == 3) {
                    m13013a(7);
                    break;
                } else if (i2 == 4) {
                    m13012j();
                    C4809aa.m18104a().m18123a("sms_provision_state");
                    setResult(-1, new Intent());
                    if (!this.f11833A) {
                        C0991aa.m6037a().m18962d(new C1062bb());
                        Intent intentM2921a = IntentControllerActivity.m2921a(this, 2);
                        intentM2921a.putExtra("callRestart", true);
                        startActivity(intentM2921a);
                    }
                    finish();
                    break;
                } else if (i2 == 11) {
                    finish();
                    break;
                } else {
                    finish();
                    break;
                }
            case 6:
                if (i2 == 6 || i2 == 4) {
                    m13012j();
                    C4809aa.m18104a().m18123a("sms_provision_state");
                    C0991aa.m6037a().m18962d(new C1062bb());
                    finish();
                    break;
                } else if (i2 == 2) {
                    m13013a(5);
                    break;
                } else if (i2 == 11) {
                    finish();
                    break;
                } else {
                    finish();
                    break;
                }
            case 7:
                if (i2 == -1) {
                    m13012j();
                    C4809aa.m18104a().m18123a("sms_provision_state");
                    setResult(-1);
                    if (!this.f11833A) {
                        C0991aa.m6037a().m18962d(new C1062bb());
                    }
                    finish();
                    break;
                } else if (i2 == 7) {
                    C4809aa.m18104a().m18123a("token");
                    C4809aa.m18104a().m18123a("authnum");
                    C4809aa.m18104a().m18123a("acstoken");
                    m13013a(5);
                    break;
                } else {
                    finish();
                    break;
                }
            case 100:
                if (!this.f11837E) {
                    setResult(11);
                    finish();
                    break;
                }
                break;
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        if (C4904y.f17872b) {
            C4904y.m18639b("onDestroy", this.f11848x);
        }
        if (EnumC3297gd.auto_register.equals(this.f11850z)) {
            C4809aa.m18104a().m18123a("sms_provision_state");
        }
        this.f11837E = true;
        super.onDestroy();
    }

    /* renamed from: i */
    private void m13011i() {
        InterfaceC4936e interfaceC4936eMo18745a = AbstractC4932a.m18733a(this.f11849y).mo18740a(getResources().getString(R.string.popup_title_confirm)).mo18749b(getResources().getString(R.string.popup_title_auto_register)).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3294ga(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3292fz(this)).mo18745a();
        interfaceC4936eMo18745a.setOnCancelListener(new DialogInterfaceOnCancelListenerC3295gb(this));
        if (!this.f11837E) {
            interfaceC4936eMo18745a.show();
        }
    }

    /* renamed from: b */
    private boolean m13007b(Intent intent) {
        return intent.getBooleanExtra("finish", false);
    }

    /* renamed from: j */
    private void m13012j() {
        if (C4809aa.m18104a().m18119a("skip_sms_register_now", (Boolean) false).booleanValue()) {
            if (C4904y.f17872b) {
                C4904y.m18639b("lite feature upgrade to full feature", this.f11848x);
            }
            C5043h.m19179a().m19185a("0001", "2127", false);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC4876cn
    public int getDefaultTheme() {
        return R.style.AppTheme_NoTitleBar;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC4876cn
    public int getBlackTheme() {
        return R.style.AppTheme_NoTitleBar;
    }
}
