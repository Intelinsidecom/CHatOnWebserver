package com.sec.chaton.samsungaccount;

import android.accounts.AccountManager;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolots.sso.p006a.C0045a;
import com.coolots.sso.p006a.InterfaceC0047c;
import com.sec.chaton.R;
import com.sec.chaton.UpgradeDialog;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.chat.C1090fe;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p025d.AbstractC1144a;
import com.sec.chaton.p025d.C1302ao;
import com.sec.chaton.p025d.C1303ap;
import com.sec.chaton.p025d.C1307at;
import com.sec.chaton.p025d.C1324bj;
import com.sec.chaton.p025d.C1329g;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p025d.C1334l;
import com.sec.chaton.p025d.p026a.EnumC1172b;
import com.sec.chaton.p027e.p028a.C1357af;
import com.sec.chaton.p027e.p028a.C1362f;
import com.sec.chaton.p035io.entry.GetVersionNotice;
import com.sec.chaton.plugin.C1954g;
import com.sec.chaton.plugin.EnumC1955h;
import com.sec.chaton.registration.C2160bk;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.EnumC3215cc;
import com.sec.chaton.util.HandlerC3176ar;
import com.sec.chaton.widget.ImageTextViewGroup;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;
import com.sec.common.util.C3348j;
import com.sec.spp.push.Config;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class MainActivity extends BaseActivity implements InterfaceC0047c {

    /* renamed from: a */
    public static boolean f8649a = false;

    /* renamed from: A */
    private String f8650A;

    /* renamed from: B */
    private String f8651B;

    /* renamed from: C */
    private boolean f8652C;

    /* renamed from: D */
    private boolean f8653D;

    /* renamed from: E */
    private boolean f8654E;

    /* renamed from: F */
    private String f8655F;

    /* renamed from: G */
    private ImageTextViewGroup f8656G;

    /* renamed from: H */
    private ImageTextViewGroup f8657H;

    /* renamed from: I */
    private LinearLayout f8658I;

    /* renamed from: J */
    private Button f8659J;

    /* renamed from: K */
    private TextView f8660K;

    /* renamed from: L */
    private boolean f8661L;

    /* renamed from: M */
    private C1303ap f8662M;

    /* renamed from: N */
    private String f8663N;

    /* renamed from: O */
    private boolean f8664O;

    /* renamed from: P */
    private boolean f8665P;

    /* renamed from: Q */
    private boolean f8666Q;

    /* renamed from: R */
    private ImageView f8667R;

    /* renamed from: S */
    private ImageView f8668S;

    /* renamed from: T */
    private ImageView f8669T;

    /* renamed from: U */
    private int f8670U;

    /* renamed from: V */
    private boolean f8671V;

    /* renamed from: W */
    private String f8672W;

    /* renamed from: X */
    private ViewPager f8673X;

    /* renamed from: Y */
    private C2336ay f8674Y;

    /* renamed from: Z */
    private LinearLayout f8675Z;

    /* renamed from: aa */
    private LinearLayout f8679aa;

    /* renamed from: ab */
    private LinearLayout f8680ab;

    /* renamed from: ad */
    private int f8682ad;

    /* renamed from: ae */
    private EditText f8683ae;

    /* renamed from: ah */
    private View f8686ah;

    /* renamed from: ai */
    private InterfaceC3274d f8687ai;

    /* renamed from: aj */
    private boolean f8688aj;

    /* renamed from: ak */
    private InterfaceC3274d f8689ak;

    /* renamed from: am */
    private String f8691am;

    /* renamed from: an */
    private String f8692an;

    /* renamed from: ap */
    private TextView f8694ap;

    /* renamed from: as */
    private GetVersionNotice f8697as;

    /* renamed from: d */
    private String f8707d;

    /* renamed from: k */
    private Context f8714k;

    /* renamed from: l */
    private String f8715l;

    /* renamed from: m */
    private C1307at f8716m;

    /* renamed from: n */
    private C1334l f8717n;

    /* renamed from: o */
    private C1090fe f8718o;

    /* renamed from: p */
    private C1330h f8719p;

    /* renamed from: q */
    private C1324bj f8720q;

    /* renamed from: r */
    private AbstractC1144a<?> f8721r;

    /* renamed from: s */
    private C1329g f8722s;

    /* renamed from: t */
    private boolean f8723t;

    /* renamed from: u */
    private String f8724u;

    /* renamed from: v */
    private String f8725v;

    /* renamed from: w */
    private Bundle f8726w;

    /* renamed from: x */
    private boolean f8727x;

    /* renamed from: y */
    private boolean f8728y;

    /* renamed from: z */
    private InterfaceC3274d f8729z;

    /* renamed from: e */
    private final int f8708e = 0;

    /* renamed from: f */
    private final int f8709f = 1;

    /* renamed from: g */
    private final int f8710g = 2;

    /* renamed from: h */
    private final int f8711h = 4;

    /* renamed from: i */
    private DialogC2339ba f8712i = null;

    /* renamed from: j */
    private ProgressDialog f8713j = null;

    /* renamed from: ac */
    private int f8681ac = 0;

    /* renamed from: af */
    private int f8684af = 0;

    /* renamed from: ag */
    private int f8685ag = 0;

    /* renamed from: al */
    private C0045a f8690al = null;

    /* renamed from: ao */
    private boolean f8693ao = false;

    /* renamed from: aq */
    private boolean f8695aq = false;

    /* renamed from: ar */
    private View f8696ar = null;

    /* renamed from: at */
    private View.OnClickListener f8698at = new ViewOnClickListenerC2332au(this);

    /* renamed from: au */
    private Handler f8699au = new HandlerC2333av(this);

    /* renamed from: b */
    Handler f8705b = new HandlerC2334aw(this, Looper.getMainLooper());

    /* renamed from: av */
    private Handler f8700av = new HandlerC2367o(this);

    /* renamed from: aw */
    private Handler f8701aw = new HandlerC2368p(this);

    /* renamed from: c */
    Handler f8706c = new HandlerC2371s(this);

    /* renamed from: ax */
    private BroadcastReceiver f8702ax = new C2312aa(this);

    /* renamed from: ay */
    private BroadcastReceiver f8703ay = new C2313ab(this);

    /* renamed from: az */
    private BroadcastReceiver f8704az = new C2314ac(this);

    /* renamed from: aA */
    private Handler f8676aA = new HandlerC2318ag(this);

    /* renamed from: aB */
    private InterfaceC2347bi f8677aB = new C2321aj(this);

    /* renamed from: aC */
    private HandlerC3176ar f8678aC = new HandlerC2322ak(this);

    /* renamed from: l */
    static /* synthetic */ int m8787l(MainActivity mainActivity) {
        int i = mainActivity.f8682ad;
        mainActivity.f8682ad = i + 1;
        return i;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException, UnsupportedEncodingException {
        super.onCreate(bundle);
        if (C3250y.f11734b) {
            C3250y.m11450b("onCreate", this.f8672W);
        }
        this.f8714k = this;
        this.f8672W = getClass().getSimpleName();
        if (C1954g.m7916a().m7918a(this.f8714k, EnumC1955h.ChatONV)) {
            this.f8690al = new C0045a();
            this.f8690al.m51a(this, this);
        }
        this.f8707d = this.f8714k.getPackageName();
        this.f8664O = false;
        if (C3250y.f11734b) {
            C3250y.m11450b("packageName : " + this.f8707d, this.f8672W);
        }
        this.f8726w = getIntent().getExtras();
        if (this.f8726w != null) {
            this.f8727x = this.f8726w.getBoolean("is_mapping_mode", false);
            this.f8653D = this.f8726w.getBoolean("is_multi_device_mode", false);
            this.f8654E = this.f8726w.getBoolean("disable_back_button", false);
            this.f8688aj = this.f8726w.getBoolean("auto_regi", false);
            this.f8693ao = this.f8726w.getBoolean("is_ready_to_sa", false);
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("[Start Mode] mappingMode : " + this.f8727x + " multiDeviceMode : " + this.f8653D + " disableBack : " + this.f8654E + " isAutoRegi : " + this.f8688aj + " isReadytoSA : " + this.f8693ao, this.f8672W);
        }
        if (this.f8693ao) {
            m8813a();
        } else {
            setContentView(R.layout.layout_multi_device_main);
        }
        if (C1493a.m6463a("chatonv_feature") && C1954g.m7916a().m7918a(this.f8714k, EnumC1955h.ChatONV)) {
            this.f8661L = true;
        }
        if (!this.f8693ao) {
            this.f8656G = (ImageTextViewGroup) findViewById(R.id.btn_phone_number).findViewById(R.id.button4);
            this.f8656G.setImageResource(R.drawable.sync_ic_contact);
            this.f8656G.setText(R.string.buddy_contact_sync);
            this.f8656G.setOnClickListener(new ViewOnClickListenerC2366n(this));
            this.f8657H = (ImageTextViewGroup) findViewById(R.id.btn_samsung_account).findViewById(R.id.button4);
            this.f8657H.setImageResource(R.drawable.sync_ic_account);
            this.f8657H.setText(R.string.setting_samsung_account);
            this.f8657H.setOnClickListener(new ViewOnClickListenerC2316ae(this));
            this.f8658I = (LinearLayout) findViewById(R.id.sns_or_skip);
            this.f8659J = (Button) findViewById(R.id.btn_next).findViewById(R.id.button1);
            this.f8659J.setText(R.string.dialog_next);
            this.f8659J.setOnClickListener(new ViewOnClickListenerC2328aq(this));
            this.f8660K = (TextView) findViewById(R.id.textEmail);
            this.f8673X = (ViewPager) findViewById(R.id.flickinng_image);
            this.f8667R = (ImageView) findViewById(R.id.indicator1);
            this.f8668S = (ImageView) findViewById(R.id.indicator2);
            this.f8669T = (ImageView) findViewById(R.id.indicator3);
            this.f8675Z = (LinearLayout) findViewById(R.id.layout_overall_bottom);
            this.f8679aa = (LinearLayout) findViewById(R.id.sync_intro_layout1);
            this.f8680ab = (LinearLayout) findViewById(R.id.sync_intro_layout2);
            m8735a(getResources().getConfiguration());
            if (C1493a.m6463a("for_wifi_only_device")) {
                this.f8656G.setVisibility(8);
                findViewById(R.id.weight_layout).setVisibility(8);
            } else {
                if (this.f8727x) {
                    this.f8656G.setVisibility(8);
                } else {
                    this.f8657H.setVisibility(8);
                }
                findViewById(R.id.weight_layout).setVisibility(8);
            }
            if (this.f8661L) {
                this.f8669T.setVisibility(0);
            }
            this.f8674Y = new C2336ay(this, getSupportFragmentManager(), this.f8661L);
            this.f8673X.setAdapter(this.f8674Y);
            C3250y.m11438a();
            this.f8658I.setOnClickListener(this.f8698at);
            this.f8686ah = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.layout_eidit_text, (ViewGroup) null);
            this.f8683ae = (EditText) this.f8686ah.findViewById(R.id.editBox);
            this.f8687ai = AbstractC3271a.m11494a(this.f8714k).mo11502a(true).mo11508b(this.f8686ah).mo11515d(R.string.done, new DialogInterfaceOnClickListenerC2330as(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2329ar(this)).mo11505a();
            this.f8673X.setOnPageChangeListener(new C2331at(this));
        }
        if (C0816a.f3115d) {
            if (C3250y.f11734b) {
                C3250y.m11450b("Welcome, First Time after update ChatON.", this.f8672W);
            }
            C3171am.m11081s();
            C3159aa.m10966a("chaton_version", C0816a.f3112a);
            C0816a.f3115d = false;
        }
        C3250y.m11450b("email : " + this.f8715l + " reuslt : " + this.f8723t, this.f8672W);
        this.f8716m = new C1307at(this.f8701aw);
        this.f8717n = new C1334l(this.f8701aw);
        this.f8720q = new C1324bj(this.f8701aw);
        this.f8718o = new C1090fe(this.f8699au, C3159aa.m10962a().m10976a("multidevice_chatlist_sync_last_time", 0L));
        this.f8719p = new C1330h(this.f8699au);
        this.f8721r = C1302ao.m5594a();
        this.f8722s = new C1329g(this.f8701aw);
        if (m8783i()) {
            String strM10979a = C3159aa.m10962a().m10979a("UpdateAppsReady", "NO");
            Intent intent = new Intent(this, (Class<?>) UpgradeDialog.class);
            intent.putExtra("isCritical", true);
            intent.putExtra("isFromHome", false);
            intent.putExtra("isReadyApps", strM10979a);
            startActivity(intent);
            new C1324bj(this.f8705b).m5694b();
        }
        String[] strArrSplit = getResources().getString(R.string.multidevice_sync_popup).split("\n\n");
        this.f8650A = strArrSplit[0];
        this.f8651B = strArrSplit[1];
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_sso_receive_code");
        registerReceiver(this.f8702ax, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("upgrade_cancel");
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(this.f8704az, intentFilter2);
        this.f8655F = C3159aa.m10962a().m10979a("samsung_account_email", "");
        if (C1493a.m6463a("auto_regi_feature")) {
            IntentFilter intentFilter3 = new IntentFilter();
            intentFilter3.addAction("back_auto_regi");
            LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(this.f8703ay, intentFilter3);
            if (GlobalApplication.f5516g) {
                if (C3250y.f11734b) {
                    C3250y.m11450b("Now, background register is still going", this.f8672W);
                }
                m8803t();
            }
        }
        if (this.f8693ao) {
            if (!C1493a.m6463a("mum_enable_feature")) {
                m8777f();
            } else {
                m8744a(true);
            }
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        m8745a(i);
        return super.onKeyUp(i, keyEvent);
    }

    /* renamed from: a */
    private boolean m8745a(int i) {
        switch (i) {
            case 24:
                if (this.f8684af < 2) {
                    this.f8684af++;
                } else {
                    this.f8684af = 0;
                }
                if (!C3250y.f11734b) {
                    return true;
                }
                C3250y.m11450b("volume up : " + this.f8684af + " volume down : " + this.f8685ag, this.f8672W);
                return true;
            case 25:
                if (this.f8684af == 2) {
                    if (this.f8685ag < 2) {
                        this.f8685ag++;
                    } else if (this.f8685ag == 2) {
                        if (!this.f8695aq && this.f8687ai != null) {
                            this.f8687ai.setCancelable(false);
                            this.f8687ai.show();
                        }
                        this.f8685ag = 0;
                        this.f8684af = 0;
                    } else {
                        this.f8685ag = 0;
                    }
                }
                if (!C3250y.f11734b) {
                    return true;
                }
                C3250y.m11450b("volume up : " + this.f8684af + " volume down : " + this.f8685ag, this.f8672W);
                return true;
            default:
                return false;
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (C3250y.f11734b) {
            C3250y.m11450b("onConfigurationChanged", getClass().getSimpleName());
        }
        m8735a(configuration);
    }

    /* renamed from: a */
    private void m8735a(Configuration configuration) {
        if (this.f8693ao) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            if (C3250y.f11734b) {
                C3250y.m11450b("densityDpi : " + displayMetrics.densityDpi + " Config : " + configuration, this.f8672W);
            }
            Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
            if (configuration.orientation == 2) {
                if (1 == defaultDisplay.getRotation()) {
                    setRequestedOrientation(0);
                    return;
                } else {
                    if (3 == defaultDisplay.getRotation()) {
                        setRequestedOrientation(8);
                        return;
                    }
                    return;
                }
            }
            if (defaultDisplay.getRotation() == 0) {
                setRequestedOrientation(1);
                return;
            } else {
                if (2 == defaultDisplay.getRotation()) {
                    setRequestedOrientation(9);
                    return;
                }
                return;
            }
        }
        if (configuration.orientation == 2) {
            if (C3250y.f11734b) {
                C3250y.m11450b("It is Landscape Mode", getClass().getSimpleName());
            }
            this.f8675Z.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        } else {
            if (C3250y.f11734b) {
                C3250y.m11450b("It is Portrait Mode", getClass().getSimpleName());
            }
            this.f8675Z.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    /* renamed from: a */
    void m8813a() {
        setContentView(R.layout.layout_settings_starting);
        this.f8694ap = (TextView) findViewById(R.id.step_comment);
        m8735a(getResources().getConfiguration());
        findViewById(R.id.progress).setVisibility(4);
        findViewById(R.id.loading).setVisibility(4);
        findViewById(R.id.step_comment).setVisibility(0);
        findViewById(R.id.registration_progress).setVisibility(0);
    }

    /* renamed from: d */
    private void m8769d() throws UnsupportedEncodingException {
        m8743a(getResources().getString(R.string.multi_deivce_mapping_pop_up_title), getResources().getString(R.string.auto_regi_buddy_sync), this.f8651B);
        this.f8719p.m5717a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m8773e() throws Resources.NotFoundException, UnsupportedEncodingException {
        if (this.f8723t) {
            C3250y.m11450b("SSO was installed, SSO ver : " + this.f8670U, this.f8672W);
            if (this.f8671V) {
                m8760b(false);
                return;
            } else {
                m8789m();
                return;
            }
        }
        C3250y.m11450b("SSO was NOT installed", this.f8672W);
        if (TextUtils.isEmpty(this.f8655F)) {
            if (this.f8713j != null && this.f8713j.isShowing()) {
                this.f8713j.dismiss();
            }
            this.f8712i = new DialogC2339ba(this.f8714k, this.f8677aB);
            this.f8712i.show();
            return;
        }
        m8743a(getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8650A, this.f8651B);
        if (this.f8727x) {
            m8765c(false);
            return;
        }
        if (C1493a.m6463a("auto_regi_feature")) {
            if (C3214cb.m11248a().equals(EnumC3215cc.OTHER)) {
                this.f8716m.m5614a();
            } else if (C3214cb.m11248a().equals(EnumC3215cc.SUCCESS)) {
                m8742a(getResources().getString(R.string.auto_regi_buddy_sync));
                this.f8719p.m5717a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m8777f() throws Resources.NotFoundException, UnsupportedEncodingException {
        m8803t();
        if (!this.f8727x) {
            if (C3159aa.m10962a().m10979a("primary_contact_addrss", (String) null) == null) {
                this.f8717n.m5775a();
                return;
            }
            if (C1493a.m6463a("chatonv_feature")) {
                this.f8722s.m5710a(EnumC1172b.UI);
            } else {
                this.f8720q.m5694b();
            }
            C3250y.m11450b("[GLD] Already get server address", this.f8672W);
            return;
        }
        if (C1493a.m6463a("auto_regi_feature")) {
            if (!C3214cb.m11248a().equals(EnumC3215cc.OTHER)) {
                m8769d();
                if (C3250y.f11734b) {
                    C3250y.m11450b("Mapping & Auto Request", this.f8672W);
                    return;
                }
                return;
            }
            m8773e();
            if (C3250y.f11734b) {
                C3250y.m11450b("Mapping Request", this.f8672W);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8744a(boolean z) throws Resources.NotFoundException, UnsupportedEncodingException {
        String strM10979a;
        if (z) {
            strM10979a = C3214cb.m11257b(this.f8714k);
            if (!TextUtils.isEmpty(strM10979a)) {
                this.f8665P = true;
            } else {
                this.f8665P = false;
            }
        } else {
            strM10979a = C3159aa.m10962a().m10979a("samsung_account_email", "");
            this.f8665P = false;
        }
        if (TextUtils.isEmpty(strM10979a)) {
            m8777f();
            return;
        }
        this.f8655F = strM10979a;
        C3250y.m11450b("Samsung email : " + strM10979a, this.f8672W);
        m8803t();
        if (C3159aa.m10962a().m10979a("primary_contact_addrss", (String) null) == null) {
            this.f8664O = true;
            this.f8717n.m5775a();
        } else {
            this.f8662M = new C1303ap(this.f8706c);
            this.f8662M.m5599a(C3159aa.m10962a().m10979a("msisdn", ""), strM10979a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m8778g() {
        String strM11257b = C3214cb.m11257b(this.f8714k);
        if (!TextUtils.isEmpty(strM11257b)) {
            this.f8655F = strM11257b;
            C3250y.m11450b("Samsung email : " + strM11257b, this.f8672W);
            this.f8662M = new C1303ap(this.f8706c);
            this.f8662M.m5603b(C3159aa.m10962a().m10979a("msisdn", ""), strM11257b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m8781h() throws Resources.NotFoundException {
        C3214cb.m11251a(this.f8714k, this.f8663N);
        m8755b(R.string.auto_regi_checking_push);
        this.f8721r.mo5479a(this.f8678aC);
        this.f8678aC.m11091a(1001, 30000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8743a(String str, String str2, String str3) {
        if (!this.f8695aq && !this.f8693ao) {
            this.f8696ar = null;
            this.f8696ar = LayoutInflater.from(this).inflate(R.layout.layout_multidevice_sync, (ViewGroup) null, false);
            TextView textView = (TextView) this.f8696ar.findViewById(R.id.messageText);
            ((TextView) this.f8696ar.findViewById(R.id.subTitleText)).setText(str2);
            textView.setText(str3);
            this.f8729z = AbstractC3271a.m11494a(this.f8714k).mo11500a(str).mo11508b(this.f8696ar).mo11502a(true).mo11505a();
            this.f8729z.setCancelable(false);
            this.f8729z.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8742a(String str) {
        if (this.f8729z != null && this.f8729z.isShowing() && this.f8696ar != null) {
            ((TextView) this.f8696ar.findViewById(R.id.subTitleText)).setText(str);
        }
        m8759b(str);
    }

    /* renamed from: i */
    private boolean m8783i() {
        boolean zBooleanValue = C3159aa.m10962a().m10977a("UpdateIsCritical", (Boolean) false).booleanValue();
        C3250y.m11450b("checkCriticalUpdate : " + zBooleanValue, this.f8672W);
        return zBooleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m8785j() {
        LocalBroadcastManager.getInstance(this.f8714k).sendBroadcast(new Intent("com.sec.chaton.ACTION_DISMISS"));
    }

    /* renamed from: a */
    public static boolean m8746a(Context context) {
        String simpleName = context.getClass().getSimpleName();
        try {
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.sec.spp.provider/version_info/"), null, null, null, null);
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex(Config.COLUMN_CURRENT_VERSION));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(Config.COLUMN_LATEST_VERSION));
                    boolean z = Boolean.parseBoolean(cursorQuery.getString(cursorQuery.getColumnIndex(Config.COLUMN_NEED_UPDATE)));
                    if (C3250y.f11734b) {
                        C3250y.m11450b("[SPP update status] currentVer : " + string + " latestVer : " + string2 + " needUpdate : " + z, simpleName);
                    }
                    C3159aa.m10963a("spp_update_is", Boolean.valueOf(z));
                    C3159aa.m10966a("spp_latest_ver", string2);
                    cursorQuery.close();
                    return z;
                }
                cursorQuery.close();
                return false;
            }
            if (C3250y.f11734b) {
                C3250y.m11450b("cursor is null", simpleName);
            }
            return false;
        } catch (Exception e) {
            C3250y.m11442a(e.toString(), simpleName);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8741a(EnumC2337az enumC2337az, String str) {
        m8806u();
        if (C3250y.f11734b) {
            C3250y.m11450b("network error, type : " + enumC2337az.toString() + " errorCode : " + str, this.f8672W);
        }
        if (GlobalApplication.m11493l() != null) {
            this.f8689ak = AbstractC3271a.m11494a(this.f8714k).mo11500a(getResources().getString(R.string.toast_error)).mo11509b(C3171am.m11046a(getResources().getString(R.string.toast_network_unable), getResources().getString(R.string.toast_error), str)).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2377y(this, enumC2337az)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2376x(this, enumC2337az)).mo11505a();
            if (!this.f8695aq) {
                this.f8689ak.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m8788l() throws Resources.NotFoundException {
        this.f8681ac++;
        if (TextUtils.isEmpty(this.f8715l) || this.f8681ac >= 2) {
            m8806u();
        }
        if (this.f8681ac < 2) {
            m8760b(true);
            return;
        }
        this.f8681ac = 0;
        this.f8689ak = AbstractC3271a.m11494a(this.f8714k).mo11500a(getResources().getString(R.string.toast_error)).mo11509b(getResources().getString(R.string.samsung_account_try_later)).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2378z(this)).mo11505a();
        if (!this.f8695aq) {
            this.f8689ak.show();
        }
    }

    /* renamed from: m */
    private void m8789m() throws Resources.NotFoundException {
        if (!TextUtils.isEmpty(this.f8715l)) {
            Intent intent = new Intent("com.msc.action.samsungaccount.request.BackGroundSignin");
            intent.putExtra("client_id", "fs24s8z0hh");
            intent.putExtra("client_secret", "8F23805C79D7D4EBAAC5CE705A87371D");
            intent.putExtra("mypackage", this.f8707d);
            intent.putExtra("OSP_VER", "OSP_02");
            sendBroadcast(intent);
            return;
        }
        m8806u();
        C3250y.m11450b("ActivitySignIn will be run", this.f8672W);
        Intent intent2 = new Intent();
        intent2.setClassName("com.osp.app.signin", "com.osp.app.signin.AccountView");
        intent2.putExtra("client_id", "fs24s8z0hh");
        intent2.putExtra("client_secret", "8F23805C79D7D4EBAAC5CE705A87371D");
        intent2.putExtra("OSP_VER", "OSP_02");
        try {
            startActivityForResult(intent2, 1);
            f8649a = true;
        } catch (ActivityNotFoundException e) {
            m8734a(this.f8714k, EnumC2335ax.disable, this.f8693ao);
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m8760b(boolean z) throws Resources.NotFoundException {
        if (C3250y.f11734b) {
            C3250y.m11450b("runNewSSO", this.f8672W);
        }
        if (!TextUtils.isEmpty(this.f8715l)) {
            Intent intent = new Intent("com.msc.action.ACCESSTOKEN_V02_REQUEST");
            intent.putExtra("client_id", "fs24s8z0hh");
            intent.putExtra("client_secret", "8F23805C79D7D4EBAAC5CE705A87371D");
            intent.putExtra("mypackage", this.f8707d);
            intent.putExtra("OSP_VER", "OSP_02");
            intent.putExtra("MODE", "HIDE_NOTIFICATION_WITH_RESULT");
            intent.putExtra("additional", new String[]{"user_id", "email_id", "mcc", "api_server_url", "birthday"});
            if (z) {
                intent.putExtra("expired_access_token", C3159aa.m10962a().m10979a("samsung_account_token", ""));
            }
            sendBroadcast(intent);
            return;
        }
        m8806u();
        C3250y.m11450b("ActivitySignIn will be run", this.f8672W);
        Intent intent2 = new Intent("com.osp.app.signin.action.ADD_SAMSUNG_ACCOUNT");
        intent2.putExtra("client_id", "fs24s8z0hh");
        intent2.putExtra("client_secret", "8F23805C79D7D4EBAAC5CE705A87371D");
        intent2.putExtra("mypackage", this.f8707d);
        intent2.putExtra("OSP_VER", "OSP_02");
        intent2.putExtra("MODE", "ADD_ACCOUNT");
        try {
            startActivityForResult(intent2, 2);
            f8649a = true;
        } catch (ActivityNotFoundException e) {
            m8734a(this.f8714k, EnumC2335ax.disable, this.f8693ao);
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m8791n() {
        if (this.f8713j != null && this.f8713j.isShowing()) {
            this.f8713j.dismiss();
        }
        Intent intent = new Intent();
        if (this.f8727x) {
            setResult(-1, intent);
        } else {
            setResult(4, intent);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m8794o() {
        if (this.f8727x) {
            finish();
            return;
        }
        this.f8652C = true;
        m8803t();
        if (C3159aa.m10962a().m10979a("primary_contact_addrss", (String) null) == null) {
            this.f8717n.m5775a();
            return;
        }
        if (C1493a.m6463a("chatonv_feature")) {
            this.f8722s.m5710a(EnumC1172b.UI);
        } else {
            this.f8720q.m5694b();
        }
        C3250y.m11450b("[GLD] Already get server address", this.f8672W);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m8795p() {
        if (this.f8713j != null && this.f8713j.isShowing()) {
            this.f8713j.dismiss();
        }
        setResult(3, new Intent());
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m8797q() {
        m8806u();
        setResult(5, new Intent());
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m8799r() throws Resources.NotFoundException {
        m8806u();
        m8734a(this.f8714k, EnumC2335ax.normal, this.f8693ao);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (C3250y.f11734b) {
            C3250y.m11450b("onPause", this.f8672W);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (C3250y.f11734b) {
            C3250y.m11450b("onResume", this.f8672W);
        }
        m8802s();
    }

    /* renamed from: s */
    private void m8802s() {
        C3250y.m11450b("showPasswordLockActivity", this.f8672W);
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        if (C3250y.f11734b) {
            C3250y.m11450b("onStart", this.f8672W);
        }
        this.f8670U = C3214cb.m11262c(this.f8714k);
        if (this.f8670U > -1) {
            this.f8723t = true;
        } else {
            this.f8723t = false;
        }
        this.f8715l = C3214cb.m11257b(this.f8714k);
        this.f8671V = C3214cb.m11255a(this.f8670U);
        C3250y.m11450b("email : " + this.f8715l + " verSSO : " + this.f8670U + " supportNewSSO : " + this.f8671V + " supportOldSSO : " + this.f8723t, this.f8672W);
        if (!this.f8693ao) {
            this.f8660K.setText(C3348j.m11793a(this.f8715l));
        }
        if (!this.f8693ao) {
            if (this.f8723t && !TextUtils.isEmpty(this.f8715l)) {
                this.f8679aa.setVisibility(8);
                this.f8680ab.setVisibility(0);
            } else if (C3159aa.m10962a().m10977a("account_mapping_fail", (Boolean) false).booleanValue()) {
                this.f8679aa.setVisibility(8);
                this.f8680ab.setVisibility(0);
            } else {
                this.f8679aa.setVisibility(0);
                this.f8680ab.setVisibility(8);
            }
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        if (C3250y.f11734b) {
            C3250y.m11450b("onStop", this.f8672W);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (C3250y.f11734b) {
            C3250y.m11450b("onDestroy", this.f8672W);
        }
        this.f8695aq = true;
        if (this.f8713j != null && this.f8713j.isShowing()) {
            this.f8713j.dismiss();
        }
        if (this.f8729z != null && this.f8729z.isShowing()) {
            this.f8729z.dismiss();
            this.f8696ar = null;
        }
        if (this.f8689ak != null && this.f8689ak.isShowing()) {
            this.f8689ak.dismiss();
        }
        unregisterReceiver(this.f8702ax);
        if (C1493a.m6463a("auto_regi_feature")) {
            LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(this.f8703ay);
        }
        f8649a = false;
        if (C1493a.m6463a("chatonv_feature") && this.f8690al != null) {
            this.f8690al.m51a(this, (InterfaceC0047c) null);
        }
        LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(this.f8704az);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f8654E) {
            if (this.f8653D && this.f8658I.getVisibility() == 0) {
                super.onBackPressed();
                return;
            } else {
                GlobalApplication.m6449a(this);
                return;
            }
        }
        super.onBackPressed();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) throws Resources.NotFoundException {
        switch (i) {
            case 0:
                if (i2 == -1) {
                    String stringExtra = intent.getStringExtra("country_code");
                    if (this.f8727x) {
                        C3214cb.m11253a(stringExtra, this.f8714k, true);
                        m8743a(getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8650A, this.f8651B);
                        m8765c(false);
                        break;
                    } else {
                        C3214cb.m11253a(stringExtra, this.f8714k, false);
                        m8743a(getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8650A, this.f8651B);
                        this.f8716m.m5617b();
                        break;
                    }
                }
                break;
            case 1:
                m8803t();
                if (i2 == -1) {
                    this.f8724u = intent.getStringExtra("authcode");
                    if (this.f8724u != null) {
                        this.f8716m.m5616a(this.f8724u, "fs24s8z0hh", "8F23805C79D7D4EBAAC5CE705A87371D");
                    } else {
                        m8806u();
                        m8734a(this.f8714k, EnumC2335ax.normal, this.f8693ao);
                    }
                    C3250y.m11450b("authcode : " + this.f8724u, this.f8672W);
                    break;
                } else {
                    m8806u();
                    C3250y.m11450b("SIGN_IN : result is ERROR", this.f8672W);
                    break;
                }
            case 2:
                m8803t();
                if (!GlobalApplication.f5516g) {
                    if (i2 == -1) {
                        this.f8715l = C3214cb.m11257b(this.f8714k);
                        if (!TextUtils.isEmpty(this.f8715l)) {
                            m8760b(false);
                            break;
                        } else {
                            m8806u();
                            m8734a(this.f8714k, EnumC2335ax.normal, this.f8693ao);
                            break;
                        }
                    } else {
                        m8806u();
                        String stringExtra2 = "";
                        if (intent != null) {
                            stringExtra2 = intent.getStringExtra("error_message");
                        }
                        C3250y.m11450b("NEW_SIGN_IN : result is ERROR, errorMessage : " + stringExtra2, this.f8672W);
                        break;
                    }
                }
                break;
            case 4:
                if (i2 == 3) {
                    m8794o();
                    break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void m8803t() {
        if ((this.f8713j == null || !this.f8713j.isShowing()) && !this.f8693ao) {
            String strM11257b = C3214cb.m11257b(this.f8714k);
            this.f8670U = C3214cb.m11262c(this);
            if (this.f8652C || this.f8728y) {
                this.f8713j = ProgressDialogC3265l.m11489a(this.f8714k, null, this.f8714k.getResources().getString(R.string.dialog_provision_ing));
            } else if (TextUtils.isEmpty(strM11257b) || this.f8670U <= -1) {
                this.f8713j = ProgressDialogC3265l.m11489a(this.f8714k, null, this.f8714k.getResources().getString(R.string.multi_device_checking_account_no_email));
            } else {
                this.f8713j = ProgressDialogC3265l.m11489a(this.f8714k, null, this.f8714k.getResources().getString(R.string.multi_device_checking_account, strM11257b));
            }
            this.f8713j.setCancelable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public void m8806u() {
        if (C3250y.f11734b) {
            C3250y.m11450b("dismissProgressBar, progressBar : " + (this.f8713j == null ? this.f8713j : Boolean.valueOf(this.f8713j.isShowing())) + " mMultiDeviceDialog : " + (this.f8729z == null ? this.f8729z : Boolean.valueOf(this.f8729z.isShowing())), this.f8672W);
        }
        if (this.f8713j != null && this.f8713j.isShowing()) {
            this.f8713j.dismiss();
        }
        if (this.f8729z != null && this.f8729z.isShowing()) {
            this.f8729z.dismiss();
            this.f8696ar = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8734a(Context context, EnumC2335ax enumC2335ax, boolean z) throws Resources.NotFoundException {
        String string = "";
        if (enumC2335ax == EnumC2335ax.normal) {
            string = context.getResources().getString(R.string.samsung_account_try_later);
        } else if (enumC2335ax == EnumC2335ax.disable) {
            string = context.getResources().getString(R.string.chaton_ps_has_been_disabled, context.getResources().getString(R.string.setting_samsung_account));
        }
        if (z) {
            this.f8689ak = AbstractC3271a.m11494a(context).mo11500a(context.getResources().getString(R.string.toast_error)).mo11509b(string).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2315ad(this)).mo11505a();
            if (!this.f8695aq) {
                this.f8689ak.show();
                return;
            }
            return;
        }
        m8733a(context, enumC2335ax);
    }

    /* renamed from: a */
    public static void m8733a(Context context, EnumC2335ax enumC2335ax) throws Resources.NotFoundException {
        String string = context.getResources().getString(R.string.setting_samsung_account);
        if (enumC2335ax == EnumC2335ax.normal) {
            string = context.getResources().getString(R.string.samsung_account_try_later);
        } else if (enumC2335ax == EnumC2335ax.disable) {
            string = context.getResources().getString(R.string.chaton_ps_has_been_disabled, context.getResources().getString(R.string.setting_samsung_account));
        }
        AbstractC3271a.m11494a(context).mo11500a(context.getResources().getString(R.string.toast_error)).mo11509b(string).mo11515d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC2317af()).mo11505a().show();
    }

    /* renamed from: b */
    public static void m8754b() {
        if (AccountManager.get(CommonApplication.m11493l()).getAccountsByType("com.sec.chaton").length <= 0 && C3159aa.m10962a().m10987b("uid")) {
            String strM10979a = C3159aa.m10962a().m10979a("msisdn", "");
            String strM10979a2 = C3159aa.m10962a().m10979a("samsung_account_email", "");
            String strM10979a3 = C3159aa.m10962a().m10979a("uid", "");
            if (TextUtils.isEmpty(strM10979a)) {
                C3171am.m11051a(strM10979a2, strM10979a3, false);
            } else {
                C3171am.m11051a(strM10979a, strM10979a3, true);
            }
        }
    }

    /* renamed from: c */
    public static void m8764c() throws UnsupportedEncodingException {
        ArrayList<String> arrayListM6068b = C1362f.m6068b(CommonApplication.m11493l().getContentResolver());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayListM6068b.size()) {
                C3205bt.m11182a(CommonApplication.m11493l()).m11219a(arrayListM6068b.get(i2).toString().trim(), true);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m8765c(boolean z) {
        if (C1493a.m6463a("mum_enable_feature") && !z) {
            m8744a(false);
            return;
        }
        ContentResolver contentResolver = CommonApplication.m11493l().getContentResolver();
        ArrayList<String> arrayListM6068b = C1362f.m6068b(contentResolver);
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<Integer> arrayListM6059a = C1362f.m6059a(contentResolver);
        for (int i = 0; i < arrayListM6059a.size(); i++) {
            ArrayList<String> arrayListM6060a = C1362f.m6060a(contentResolver, arrayListM6059a.get(i).intValue());
            if (!arrayListM6068b.get(i).equals("Favorites")) {
                map.put(arrayListM6068b.get(i), arrayListM6060a);
            }
        }
        new C1330h(this.f8676aA).m5714a("group", false, 328, arrayListM6068b, map);
    }

    @Override // com.coolots.sso.p006a.InterfaceC0047c
    public void onReceiveRemoveAccount(boolean z) {
    }

    @Override // com.coolots.sso.p006a.InterfaceC0047c
    public void onReceiveCreateAccount(boolean z, String str) throws UnsupportedEncodingException {
        if (C3250y.f11734b) {
            C3250y.m11450b("onReceiveCreateAccount : " + z, this.f8672W);
        }
        if (z) {
            this.f8719p.m5723a("voip", 1, false);
            return;
        }
        new C2160bk().m8674a();
        m8742a(getResources().getString(R.string.auto_regi_buddy_sync));
        if (this.f8727x) {
            C1357af.m5988a();
            this.f8719p.m5717a();
            this.f8719p.m5736c();
            return;
        }
        this.f8719p.m5717a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8755b(int i) {
        if (this.f8693ao && this.f8694ap != null) {
            this.f8694ap.setText(i);
        }
    }

    /* renamed from: b */
    private void m8759b(String str) {
        if (this.f8693ao && this.f8694ap != null) {
            this.f8694ap.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public void m8808v() throws UnsupportedEncodingException {
        if (C3214cb.m11256a(this.f8714k)) {
            if (this.f8690al != null) {
                if (C3214cb.m11245a(this.f8714k, this.f8690al) != 0) {
                    m8742a(getResources().getString(R.string.auto_regi_buddy_sync));
                    this.f8719p.m5717a();
                    return;
                } else {
                    m8742a(getResources().getString(R.string.auto_regi_initializing_voice_and_video));
                    return;
                }
            }
            if (C3250y.f11734b) {
                C3250y.m11450b("mChatonV is null", this.f8672W);
            }
            m8742a(getResources().getString(R.string.auto_regi_buddy_sync));
            this.f8719p.m5717a();
            return;
        }
        m8742a(getResources().getString(R.string.auto_regi_buddy_sync));
        this.f8719p.m5717a();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC3226cn
    public int getDefaultTheme() {
        return R.style.AppTheme_NoTitleBar;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC3226cn
    public int getBlackTheme() {
        return R.style.AppTheme_NoTitleBar;
    }
}
