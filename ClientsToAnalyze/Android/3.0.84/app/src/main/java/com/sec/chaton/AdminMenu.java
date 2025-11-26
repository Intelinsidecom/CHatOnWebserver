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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.msgsend.C1757q;
import com.sec.chaton.p025d.C1302ao;
import com.sec.chaton.p025d.C1337o;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3189bd;
import com.sec.chaton.util.C3194bi;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.AlertDialogC3259f;
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

    /* renamed from: b */
    private static final String[] f627b = {"chatondev@samsung.com"};

    /* renamed from: A */
    private Button f628A;

    /* renamed from: B */
    private Button f629B;

    /* renamed from: C */
    private Context f630C;

    /* renamed from: F */
    private TabHost f633F;

    /* renamed from: G */
    private EditText f634G;

    /* renamed from: H */
    private EditText f635H;

    /* renamed from: I */
    private boolean f636I;

    /* renamed from: J */
    private int f637J;

    /* renamed from: K */
    private EditText f638K;

    /* renamed from: L */
    private ArrayList<String> f639L;

    /* renamed from: M */
    private C1337o f640M;

    /* renamed from: N */
    private int f641N;

    /* renamed from: O */
    private int f642O;

    /* renamed from: P */
    private Handler f643P;

    /* renamed from: c */
    private EditText f646c;

    /* renamed from: d */
    private EditText f647d;

    /* renamed from: e */
    private EditText f648e;

    /* renamed from: f */
    private EditText f649f;

    /* renamed from: g */
    private Button f650g;

    /* renamed from: h */
    private Button f651h;

    /* renamed from: i */
    private Button f652i;

    /* renamed from: j */
    private Button f653j;

    /* renamed from: k */
    private TextView f654k;

    /* renamed from: l */
    private Button f655l;

    /* renamed from: m */
    private Button f656m;

    /* renamed from: n */
    private Button f657n;

    /* renamed from: o */
    private Button f658o;

    /* renamed from: p */
    private Button f659p;

    /* renamed from: q */
    private Button f660q;

    /* renamed from: r */
    private Button f661r;

    /* renamed from: s */
    private Button f662s;

    /* renamed from: t */
    private Button f663t;

    /* renamed from: u */
    private Button f664u;

    /* renamed from: v */
    private Button f665v;

    /* renamed from: w */
    private Button f666w;

    /* renamed from: x */
    private Button f667x;

    /* renamed from: y */
    private Button f668y;

    /* renamed from: z */
    private Button f669z;

    /* renamed from: D */
    private ProgressDialog f631D = null;

    /* renamed from: E */
    private boolean f632E = false;

    /* renamed from: Q */
    private View.OnClickListener f644Q = new ViewOnClickListenerC0452b(this);

    /* renamed from: a */
    final Handler f645a = new HandlerC0815c(this);

    /* renamed from: A */
    static /* synthetic */ int m1090A(AdminMenu adminMenu) {
        int i = adminMenu.f641N;
        adminMenu.f641N = i + 1;
        return i;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f630C = this;
        this.f639L = new ArrayList<>();
        setContentView(R.layout.admin_tab_menu);
        this.f633F = (TabHost) findViewById(R.id.admin_tab_menu);
        this.f633F.setup();
        TabHost.TabSpec tabSpecNewTabSpec = this.f633F.newTabSpec("Tab1");
        tabSpecNewTabSpec.setIndicator("GENERAL");
        tabSpecNewTabSpec.setContent(R.id.tab_general);
        this.f633F.addTab(tabSpecNewTabSpec);
        TabHost.TabSpec tabSpecNewTabSpec2 = this.f633F.newTabSpec("Tab2");
        tabSpecNewTabSpec2.setIndicator("SQE");
        tabSpecNewTabSpec2.setContent(R.id.tab_sqe);
        this.f633F.addTab(tabSpecNewTabSpec2);
        TabHost.TabSpec tabSpecNewTabSpec3 = this.f633F.newTabSpec("Tab3");
        tabSpecNewTabSpec3.setIndicator("DEV");
        tabSpecNewTabSpec3.setContent(R.id.tab_dev);
        this.f633F.addTab(tabSpecNewTabSpec3);
        Bundle extras = getIntent().getExtras();
        this.f646c = (EditText) findViewById(R.id.timeOut);
        this.f646c.setText("0");
        this.f647d = (EditText) findViewById(R.id.replyTimeOut);
        this.f647d.setText("0");
        this.f648e = (EditText) findViewById(R.id.chatTimeOut);
        this.f648e.setText("0");
        this.f649f = (EditText) findViewById(R.id.initChatTimeOut);
        this.f649f.setText("0");
        this.f650g = (Button) findViewById(R.id.timeOutValueSet);
        this.f650g.setOnClickListener(this.f644Q);
        this.f651h = (Button) findViewById(R.id.timeOutValueReset);
        this.f651h.setOnClickListener(this.f644Q);
        this.f652i = (Button) findViewById(R.id.applyhanzitopinyin);
        this.f652i.setOnClickListener(this.f644Q);
        this.f653j = (Button) findViewById(R.id.resethanzitopinyin);
        this.f653j.setOnClickListener(this.f644Q);
        this.f654k = (TextView) findViewById(R.id.mccCode);
        this.f654k.setText(C3171am.m11064f());
        this.f655l = (Button) findViewById(R.id.btn_make_dummy_groupchatroom100);
        this.f656m = (Button) findViewById(R.id.btn_make_dummy_groupchatroom200);
        this.f655l.setOnClickListener(this.f644Q);
        this.f656m.setOnClickListener(this.f644Q);
        this.f666w = (Button) findViewById(R.id.btn_autoresend_turn_on_off);
        this.f667x = (Button) findViewById(R.id.btn_autoresend_enable_notification);
        this.f668y = (Button) findViewById(R.id.btn_autoresend_dump_log_current);
        this.f669z = (Button) findViewById(R.id.btn_autoresend_do_send);
        this.f628A = (Button) findViewById(R.id.btn_autoresend_loaddb);
        this.f629B = (Button) findViewById(R.id.btn_autoresend_clearmsg);
        this.f666w.setOnClickListener(this.f644Q);
        this.f667x.setOnClickListener(this.f644Q);
        this.f668y.setOnClickListener(this.f644Q);
        this.f669z.setOnClickListener(this.f644Q);
        this.f628A.setOnClickListener(this.f644Q);
        this.f629B.setOnClickListener(this.f644Q);
        if (C1757q.m7251b()) {
            this.f666w.setText("A-Resend:ENABLED");
        } else {
            this.f666w.setText("A-Resend:DISABLED");
        }
        if (C1757q.m7257g()) {
            this.f667x.setText("A-Resend:Noti enabled");
        } else {
            this.f667x.setText("A-Resend:Noti disabled");
        }
        this.f658o = (Button) findViewById(R.id.btn_random_imei);
        this.f659p = (Button) findViewById(R.id.btn_change_GLD);
        this.f660q = (Button) findViewById(R.id.btn_skip);
        this.f663t = (Button) findViewById(R.id.chaton_upgrade);
        this.f664u = (Button) findViewById(R.id.chaton_notice);
        this.f665v = (Button) findViewById(R.id.chaton_disclaimer);
        this.f658o.setOnClickListener(this.f644Q);
        this.f659p.setOnClickListener(this.f644Q);
        this.f660q.setOnClickListener(this.f644Q);
        this.f663t.setOnClickListener(this.f644Q);
        this.f664u.setOnClickListener(this.f644Q);
        this.f665v.setOnClickListener(this.f644Q);
        this.f661r = (Button) findViewById(R.id.btn_push_status);
        this.f661r.setOnClickListener(this.f644Q);
        C1302ao.m5594a().mo5482c(new HandlerC0262a(this, Looper.getMainLooper()));
        this.f657n = (Button) findViewById(R.id.btn_log_on_off);
        this.f657n.setOnClickListener(this.f644Q);
        this.f637J = C3250y.m11447b();
        C3250y.m11439a(1);
        if (this.f637J > 0) {
            this.f657n.setText("Log Off");
        } else {
            this.f657n.setText("Log On");
        }
        if (this.f636I) {
            this.f659p.setEnabled(false);
            this.f658o.setEnabled(false);
        }
        this.f662s = (Button) findViewById(R.id.dump_database);
        this.f662s.setOnClickListener(this.f644Q);
        this.f633F.setVisibility(8);
        this.f633F.setOnTabChangedListener(this);
        for (int i = 0; i < this.f633F.getTabWidget().getChildCount(); i++) {
            ((TextView) this.f633F.getTabWidget().getChildAt(i).findViewById(android.R.id.title)).setTextColor(Color.parseColor("#000000"));
        }
        if (extras != null) {
            this.f636I = extras.getBoolean("mapping_mode", false);
            if (extras.getBoolean("general_tab", true)) {
                this.f633F.setVisibility(0);
                return;
            } else {
                m1106e();
                return;
            }
        }
        m1106e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m1103d() {
        AlertDialogC3259f alertDialogC3259f = new AlertDialogC3259f(this.f630C);
        alertDialogC3259f.setTitle("DB File SendEmail");
        View viewInflate = ((LayoutInflater) this.f630C.getSystemService("layout_inflater")).inflate(R.layout.admin_menu_db_sendmail, (ViewGroup) null);
        alertDialogC3259f.setInverseBackgroundForced(true);
        alertDialogC3259f.setView(viewInflate);
        this.f638K = (EditText) viewInflate.findViewById(R.id.admin_menu_db_send_mail);
        alertDialogC3259f.setButton(-1, getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1143d(this));
        alertDialogC3259f.setButton(-2, getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC1349e(this));
        alertDialogC3259f.setCancelable(false);
        alertDialogC3259f.setCanceledOnTouchOutside(false);
        alertDialogC3259f.show();
    }

    /* renamed from: e */
    private void m1106e() {
        AlertDialogC3259f alertDialogC3259f = new AlertDialogC3259f(this.f630C);
        alertDialogC3259f.setTitle("Enter Password");
        View viewInflate = ((LayoutInflater) this.f630C.getSystemService("layout_inflater")).inflate(R.layout.admin_menu_password, (ViewGroup) null);
        alertDialogC3259f.setInverseBackgroundForced(true);
        alertDialogC3259f.setView(viewInflate);
        this.f634G = (EditText) viewInflate.findViewById(R.id.admin_id_input);
        this.f635H = (EditText) viewInflate.findViewById(R.id.admin_pass_input);
        alertDialogC3259f.setButton(-1, getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1471f(this));
        alertDialogC3259f.setButton(-2, getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC1482g(this));
        alertDialogC3259f.setCancelable(false);
        alertDialogC3259f.setCanceledOnTouchOutside(false);
        alertDialogC3259f.show();
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(String str) {
    }

    /* renamed from: a */
    public boolean m1131a(String str, String str2) throws NoSuchAlgorithmException {
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

    /* renamed from: a */
    public static void m1095a() throws IOException {
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
            fileOutputStream = new FileOutputStream(Environment.getExternalStorageDirectory().getAbsolutePath() + "/chaton.xml");
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

    /* JADX WARN: Removed duplicated region for block: B:74:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m1099b() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.AdminMenu.m1099b():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m1108f() {
        for (int i = 0; i < 199; i++) {
            if (i < 10) {
                this.f639L.add("82779999000" + String.valueOf(i));
            } else if (i < 100) {
                this.f639L.add("8277999900" + String.valueOf(i));
            } else {
                this.f639L.add("827799990" + String.valueOf(i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m1110g() {
        String strM11137a = C3189bd.m11137a();
        EnumC1450r enumC1450r = EnumC1450r.GROUPCHAT;
        this.f640M = C1337o.m5795a(strM11137a, enumC1450r);
        if (this.f640M != null) {
            String[] strArr = new String[199];
            this.f640M.m5897e(strM11137a);
            this.f640M.m5880a(strM11137a, C3194bi.m11149a().m11154c().m11155a(), C3194bi.m11149a().m11154c().m11158b());
            this.f640M.m5874a(this.f643P);
            this.f640M.m5902k();
            this.f639L.toArray(strArr);
            this.f640M.m5861a(strM11137a, EnumC1455w.TEXT, enumC1450r, strArr, "i-" + this.f641N, (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m1112h() {
        this.f643P = new HandlerC1497h(this);
    }
}
