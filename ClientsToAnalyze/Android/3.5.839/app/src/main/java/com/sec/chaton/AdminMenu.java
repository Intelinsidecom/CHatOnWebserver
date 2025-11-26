package com.sec.chaton;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TabHost;
import android.widget.TextView;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.msgsend.C2717y;
import com.sec.chaton.p055d.AbstractC1899a;
import com.sec.chaton.p055d.C2093az;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4839bd;
import com.sec.chaton.util.C4844bi;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.HandlerC4826ar;
import com.sec.chaton.widget.AlertDialogC4919l;
import com.sec.common.p123a.AbstractC4932a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class AdminMenu extends BaseActivity implements TabHost.OnTabChangeListener {

    /* renamed from: p */
    private static final String[] f1863p = {"chatondev@samsung.com"};

    /* renamed from: A */
    private Button f1864A;

    /* renamed from: B */
    private Button f1865B;

    /* renamed from: C */
    private Button f1866C;

    /* renamed from: D */
    private Button f1867D;

    /* renamed from: E */
    private Button f1868E;

    /* renamed from: F */
    private Button f1869F;

    /* renamed from: G */
    private Button f1870G;

    /* renamed from: H */
    private Button f1871H;

    /* renamed from: I */
    private Button f1872I;

    /* renamed from: J */
    private Button f1873J;

    /* renamed from: K */
    private Button f1874K;

    /* renamed from: L */
    private Button f1875L;

    /* renamed from: M */
    private Button f1876M;

    /* renamed from: N */
    private Button f1877N;

    /* renamed from: O */
    private Button f1878O;

    /* renamed from: P */
    private Button f1879P;

    /* renamed from: Q */
    private Button f1880Q;

    /* renamed from: R */
    private Button f1881R;

    /* renamed from: S */
    private Button f1882S;

    /* renamed from: T */
    private Button f1883T;

    /* renamed from: U */
    private Context f1884U;

    /* renamed from: X */
    private TabHost f1887X;

    /* renamed from: Y */
    private EditText f1888Y;

    /* renamed from: Z */
    private EditText f1889Z;

    /* renamed from: aa */
    private boolean f1890aa;

    /* renamed from: ac */
    private int f1892ac;

    /* renamed from: ad */
    private EditText f1893ad;

    /* renamed from: ae */
    private ArrayList<String> f1894ae;

    /* renamed from: af */
    private C2142w f1895af;

    /* renamed from: ag */
    private int f1896ag;

    /* renamed from: ah */
    private int f1897ah;

    /* renamed from: ai */
    private Handler f1898ai;

    /* renamed from: aj */
    private AbstractC1899a<?> f1899aj;

    /* renamed from: al */
    private boolean f1901al;

    /* renamed from: q */
    private EditText f1906q;

    /* renamed from: r */
    private EditText f1907r;

    /* renamed from: s */
    private EditText f1908s;

    /* renamed from: t */
    private EditText f1909t;

    /* renamed from: u */
    private Button f1910u;

    /* renamed from: v */
    private Button f1911v;

    /* renamed from: w */
    private Button f1912w;

    /* renamed from: x */
    private Button f1913x;

    /* renamed from: y */
    private TextView f1914y;

    /* renamed from: z */
    private Button f1915z;

    /* renamed from: V */
    private ProgressDialog f1885V = null;

    /* renamed from: W */
    private boolean f1886W = false;

    /* renamed from: ab */
    private boolean f1891ab = false;

    /* renamed from: ak */
    private ProgressDialog f1900ak = null;

    /* renamed from: am */
    private String f1902am = "";

    /* renamed from: an */
    private View.OnClickListener f1903an = new ViewOnClickListenerC2409j(this);

    /* renamed from: n */
    final Handler f1904n = new HandlerC2476k(this);

    /* renamed from: o */
    HandlerC4826ar f1905o = new HandlerC1055b(this);

    /* renamed from: H */
    static /* synthetic */ int m2829H(AdminMenu adminMenu) {
        int i = adminMenu.f1896ag;
        adminMenu.f1896ag = i + 1;
        return i;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1884U = this;
        this.f1894ae = new ArrayList<>();
        setContentView(R.layout.admin_tab_menu);
        this.f1887X = (TabHost) findViewById(R.id.admin_tab_menu);
        this.f1887X.setup();
        TabHost.TabSpec tabSpecNewTabSpec = this.f1887X.newTabSpec("Tab1");
        tabSpecNewTabSpec.setIndicator("GENERAL");
        tabSpecNewTabSpec.setContent(R.id.tab_general);
        this.f1887X.addTab(tabSpecNewTabSpec);
        TabHost.TabSpec tabSpecNewTabSpec2 = this.f1887X.newTabSpec("Tab2");
        tabSpecNewTabSpec2.setIndicator("SQE");
        tabSpecNewTabSpec2.setContent(R.id.tab_sqe);
        this.f1887X.addTab(tabSpecNewTabSpec2);
        TabHost.TabSpec tabSpecNewTabSpec3 = this.f1887X.newTabSpec("Tab3");
        tabSpecNewTabSpec3.setIndicator("DEV");
        tabSpecNewTabSpec3.setContent(R.id.tab_dev);
        this.f1887X.addTab(tabSpecNewTabSpec3);
        Bundle extras = getIntent().getExtras();
        this.f1906q = (EditText) findViewById(R.id.timeOut);
        this.f1906q.setText(Spam.ACTIVITY_CANCEL);
        this.f1907r = (EditText) findViewById(R.id.replyTimeOut);
        this.f1907r.setText(Spam.ACTIVITY_CANCEL);
        this.f1908s = (EditText) findViewById(R.id.chatTimeOut);
        this.f1908s.setText(Spam.ACTIVITY_CANCEL);
        this.f1909t = (EditText) findViewById(R.id.initChatTimeOut);
        this.f1909t.setText(Spam.ACTIVITY_CANCEL);
        this.f1910u = (Button) findViewById(R.id.timeOutValueSet);
        this.f1910u.setOnClickListener(this.f1903an);
        this.f1911v = (Button) findViewById(R.id.timeOutValueReset);
        this.f1911v.setOnClickListener(this.f1903an);
        this.f1912w = (Button) findViewById(R.id.applyhanzitopinyin);
        this.f1912w.setOnClickListener(this.f1903an);
        this.f1913x = (Button) findViewById(R.id.resethanzitopinyin);
        this.f1913x.setOnClickListener(this.f1903an);
        this.f1914y = (TextView) findViewById(R.id.mccCode);
        this.f1914y.setText(C4822an.m18241i());
        this.f1915z = (Button) findViewById(R.id.btn_make_dummy_groupchatroom100);
        this.f1864A = (Button) findViewById(R.id.btn_make_dummy_groupchatroom200);
        this.f1915z.setOnClickListener(this.f1903an);
        this.f1864A.setOnClickListener(this.f1903an);
        this.f1878O = (Button) findViewById(R.id.btn_autoresend_turn_on_off);
        this.f1879P = (Button) findViewById(R.id.btn_autoresend_enable_notification);
        this.f1880Q = (Button) findViewById(R.id.btn_autoresend_dump_log_current);
        this.f1881R = (Button) findViewById(R.id.btn_autoresend_do_send);
        this.f1882S = (Button) findViewById(R.id.btn_autoresend_loaddb);
        this.f1883T = (Button) findViewById(R.id.btn_autoresend_clearmsg);
        this.f1878O.setOnClickListener(this.f1903an);
        this.f1879P.setOnClickListener(this.f1903an);
        this.f1880Q.setOnClickListener(this.f1903an);
        this.f1881R.setOnClickListener(this.f1903an);
        this.f1882S.setOnClickListener(this.f1903an);
        this.f1883T.setOnClickListener(this.f1903an);
        if (C2717y.m11398b()) {
            this.f1878O.setText("A-Resend:ENABLED");
        } else {
            this.f1878O.setText("A-Resend:DISABLED");
        }
        if (C2717y.m11406i()) {
            this.f1879P.setText("A-Resend:Noti enabled");
        } else {
            this.f1879P.setText("A-Resend:Noti disabled");
        }
        this.f1866C = (Button) findViewById(R.id.btn_random_imei);
        this.f1867D = (Button) findViewById(R.id.btn_change_GLD);
        this.f1868E = (Button) findViewById(R.id.btn_skip);
        this.f1871H = (Button) findViewById(R.id.chaton_upgrade);
        this.f1872I = (Button) findViewById(R.id.chaton_notice);
        this.f1873J = (Button) findViewById(R.id.chaton_disclaimer);
        this.f1874K = (Button) findViewById(R.id.set_mcc);
        this.f1875L = (Button) findViewById(R.id.deregiSPP);
        this.f1876M = (Button) findViewById(R.id.changeSAid);
        this.f1877N = (Button) findViewById(R.id.changeSMSFeature);
        this.f1901al = C2349a.m10301a("sms_feature");
        this.f1877N.setText("Change SMS feature : " + String.valueOf(this.f1901al));
        this.f1866C.setOnClickListener(this.f1903an);
        this.f1867D.setOnClickListener(this.f1903an);
        this.f1868E.setOnClickListener(this.f1903an);
        this.f1871H.setOnClickListener(this.f1903an);
        this.f1872I.setOnClickListener(this.f1903an);
        this.f1873J.setOnClickListener(this.f1903an);
        this.f1874K.setOnClickListener(this.f1903an);
        this.f1875L.setOnClickListener(this.f1903an);
        this.f1876M.setOnClickListener(this.f1903an);
        this.f1877N.setOnClickListener(this.f1903an);
        this.f1869F = (Button) findViewById(R.id.btn_push_status);
        this.f1869F.setOnClickListener(this.f1903an);
        this.f1899aj = C2093az.m9337a();
        this.f1899aj.mo9080c(new HandlerC0775a(this, Looper.getMainLooper()));
        this.f1865B = (Button) findViewById(R.id.btn_log_on_off);
        this.f1865B.setOnClickListener(this.f1903an);
        this.f1892ac = C4904y.m18630a();
        C4904y.m18632a(1);
        if (this.f1892ac > 0) {
            this.f1865B.setText("Log Off");
        } else {
            this.f1865B.setText("Log On");
        }
        if (this.f1890aa) {
            this.f1867D.setEnabled(false);
            this.f1866C.setEnabled(false);
        }
        this.f1870G = (Button) findViewById(R.id.dump_database);
        this.f1870G.setOnClickListener(this.f1903an);
        this.f1887X.setVisibility(8);
        this.f1887X.setOnTabChangedListener(this);
        for (int i = 0; i < this.f1887X.getTabWidget().getChildCount(); i++) {
            ((TextView) this.f1887X.getTabWidget().getChildAt(i).findViewById(android.R.id.title)).setTextColor(Color.parseColor("#000000"));
        }
        if (extras != null) {
            this.f1890aa = extras.getBoolean("mapping_mode", false);
            this.f1891ab = extras.getBoolean("operation", false);
            if (extras.getBoolean("general_tab", true)) {
                this.f1887X.setVisibility(0);
                return;
            } else if (this.f1891ab) {
                this.f1887X.setVisibility(8);
                m2865p();
                return;
            } else {
                m2853j();
                return;
            }
        }
        m2853j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m2851i() {
        AlertDialogC4919l alertDialogC4919l = new AlertDialogC4919l(this.f1884U);
        alertDialogC4919l.setTitle("DB File SendEmail");
        View viewInflate = ((LayoutInflater) this.f1884U.getSystemService("layout_inflater")).inflate(R.layout.admin_menu_db_sendmail, (ViewGroup) null);
        alertDialogC4919l.setInverseBackgroundForced(true);
        alertDialogC4919l.setView(viewInflate);
        this.f1893ad = (EditText) viewInflate.findViewById(R.id.admin_menu_db_send_mail);
        alertDialogC4919l.setButton(-1, getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC2478l(this));
        alertDialogC4919l.setButton(-2, getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC2568m(this));
        alertDialogC4919l.setCancelable(false);
        alertDialogC4919l.setCanceledOnTouchOutside(false);
        alertDialogC4919l.show();
    }

    /* renamed from: j */
    private void m2853j() {
        AlertDialogC4919l alertDialogC4919l = new AlertDialogC4919l(this.f1884U);
        alertDialogC4919l.setTitle("Enter Password");
        View viewInflate = ((LayoutInflater) this.f1884U.getSystemService("layout_inflater")).inflate(R.layout.admin_menu_password, (ViewGroup) null);
        alertDialogC4919l.setInverseBackgroundForced(true);
        alertDialogC4919l.setView(viewInflate);
        this.f1888Y = (EditText) viewInflate.findViewById(R.id.admin_id_input);
        this.f1889Z = (EditText) viewInflate.findViewById(R.id.admin_pass_input);
        this.f1888Y.addTextChangedListener(new C2914n(this));
        alertDialogC4919l.setButton(-1, getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC2919o(this));
        alertDialogC4919l.setButton(-2, getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC2920p(this));
        alertDialogC4919l.setCancelable(false);
        alertDialogC4919l.setCanceledOnTouchOutside(false);
        alertDialogC4919l.show();
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(String str) {
    }

    /* renamed from: a */
    public boolean m2876a(String str, String str2) throws NoSuchAlgorithmException {
        String string = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            string = new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return str2.toLowerCase().equals(string.toLowerCase());
    }

    /* renamed from: f */
    public static void m2845f() throws IOException {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream = null;
        Log.i("TEST", "copyPreferenceToSdcard start");
        try {
            fileInputStream = new FileInputStream(new File("data/data/com.sec.chaton/shared_prefs/", "ChatON.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fileInputStream = null;
        }
        try {
            fileOutputStream = new FileOutputStream(Environment.getExternalStorageDirectory().getAbsolutePath() + "/ChatON.xml");
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }
        byte[] bArr = new byte[1];
        if (fileInputStream != null) {
            while (fileInputStream.read(bArr) > 0) {
                try {
                    if (fileOutputStream != null) {
                        fileOutputStream.write(bArr);
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        }
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e6) {
                e6.printStackTrace();
            }
        }
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        Log.i("TEST", "copyPreferenceToSdcard end");
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m2847g() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.AdminMenu.m2847g():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m2855k() {
        for (int i = 0; i < 199; i++) {
            if (i < 10) {
                this.f1894ae.add("82779999000" + String.valueOf(i));
            } else if (i < 100) {
                this.f1894ae.add("827799990" + Spam.ACTIVITY_CANCEL + String.valueOf(i));
            } else {
                this.f1894ae.add("827799990" + String.valueOf(i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m2857l() {
        String strM18311a = C4839bd.m18311a();
        EnumC2300t enumC2300t = EnumC2300t.GROUPCHAT;
        this.f1895af = C2142w.m9593a(strM18311a, enumC2300t);
        if (this.f1895af != null) {
            String[] strArr = new String[199];
            this.f1895af.m9648e(strM18311a);
            this.f1895af.mo9252a(strM18311a, C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b());
            this.f1895af.m9246a(this.f1898ai);
            this.f1895af.mo9278f();
            this.f1894ae.toArray(strArr);
            this.f1895af.mo9240a(strM18311a, EnumC2214ab.TEXT, enumC2300t, strArr, "i-" + this.f1896ag, (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m2859m() {
        this.f1898ai = new HandlerC3118q(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m2861n() {
        View viewInflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.layout_eidit_text, (ViewGroup) null);
        EditText editText = (EditText) viewInflate.findViewById(R.id.editBox);
        editText.setText("test@samsung.com");
        AbstractC4932a.m18733a(this.f1884U).mo18742a(true).mo18748b(viewInflate).mo18756d(R.string.done, new DialogInterfaceOnClickListenerC1898d(this, editText)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1426c(this)).mo18745a().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m2863o() {
        View viewInflate = ((LayoutInflater) this.f1884U.getSystemService("layout_inflater")).inflate(R.layout.layout_eidit_text, (ViewGroup) null);
        EditText editText = (EditText) viewInflate.findViewById(R.id.editBox);
        editText.setText(C4809aa.m18104a().m18121a("admin_mcc", (String) null));
        AbstractC4932a.m18733a(this.f1884U).mo18742a(true).mo18748b(viewInflate).mo18756d(R.string.done, new DialogInterfaceOnClickListenerC2330f(this, editText)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2172e(this)).mo18745a().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m2865p() {
        this.f1887X.getTabWidget().getChildTabViewAt(0).setVisibility(8);
        this.f1887X.getTabWidget().getChildTabViewAt(1).setVisibility(8);
        this.f1887X.getTabWidget().getChildTabViewAt(2).setVisibility(8);
        this.f1887X.setVisibility(8);
        AlertDialogC4919l alertDialogC4919l = new AlertDialogC4919l(this.f1884U);
        alertDialogC4919l.setTitle("Set Operation Area");
        View viewInflate = ((LayoutInflater) this.f1884U.getSystemService("layout_inflater")).inflate(R.layout.admin_menu_set_operation_area, (ViewGroup) null);
        alertDialogC4919l.setInverseBackgroundForced(true);
        alertDialogC4919l.setView(viewInflate);
        Spinner spinner = (Spinner) viewInflate.findViewById(R.id.admin_menu_operation_area);
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(this.f1884U, R.array.operation_area_array, android.R.layout.simple_spinner_item);
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) arrayAdapterCreateFromResource);
        spinner.setOnItemSelectedListener(new C2341g(this));
        alertDialogC4919l.setButton(-1, getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC2354h(this));
        alertDialogC4919l.setButton(-2, getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC2403i(this));
        alertDialogC4919l.setCancelable(false);
        alertDialogC4919l.setCanceledOnTouchOutside(false);
        alertDialogC4919l.show();
    }
}
