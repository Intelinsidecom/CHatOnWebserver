package com.sec.chaton.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.chat.C0592i;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.p034a.C0760c;
import com.sec.chaton.p013a.C0223v;
import com.sec.chaton.p015b.p016a.C0257e;
import com.sec.chaton.p025d.C0671x;
import com.sec.chaton.p025d.EnumC0651d;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p025d.p026a.C0630j;
import com.sec.widget.AlertDialogBuilderC1625m;
import com.sec.widget.C1619g;

/* loaded from: classes.dex */
public class ScreenOnNotification extends BaseActivity {

    /* renamed from: a */
    public static boolean f4431a;

    /* renamed from: A */
    private SharedPreferences f4432A;

    /* renamed from: B */
    private C0630j f4433B;

    /* renamed from: c */
    private C0223v f4435c;

    /* renamed from: d */
    private String f4436d;

    /* renamed from: e */
    private String f4437e;

    /* renamed from: f */
    private String f4438f;

    /* renamed from: g */
    private int f4439g;

    /* renamed from: i */
    private AlertDialog f4440i;

    /* renamed from: j */
    private String f4441j;

    /* renamed from: k */
    private String f4442k;

    /* renamed from: l */
    private String f4443l;

    /* renamed from: m */
    private int f4444m;

    /* renamed from: n */
    private InputMethodManager f4445n;

    /* renamed from: o */
    private Button f4446o;

    /* renamed from: p */
    private EditText f4447p;

    /* renamed from: q */
    private LinearLayout f4448q;

    /* renamed from: r */
    private Toast f4449r;

    /* renamed from: s */
    private ProgressBar f4450s;

    /* renamed from: t */
    private AlertDialogBuilderC1625m f4451t;

    /* renamed from: u */
    private LinearLayout f4452u;

    /* renamed from: x */
    private Handler f4455x;

    /* renamed from: y */
    private Runnable f4456y;

    /* renamed from: v */
    private boolean f4453v = true;

    /* renamed from: w */
    private int f4454w = 6000;

    /* renamed from: z */
    private boolean f4457z = false;

    /* renamed from: b */
    Handler f4434b = new HandlerC1316bl(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4455x = new Handler();
        this.f4449r = C1619g.m5889a(this, (CharSequence) null, 0);
        this.f4456y = new RunnableC1317bm(this);
        this.f4445n = (InputMethodManager) getSystemService("input_method");
        this.f4432A = C1323bs.m4575a();
        requestWindowFeature(1);
        getWindow().addFlags(2621440);
        setContentView(R.layout.base_singlepane);
        this.f4452u = (LinearLayout) findViewById(R.id.blackscreen_layout);
        m4484b(getIntent().getExtras());
        showDialog(1);
        this.f4455x.postDelayed(this.f4456y, this.f4454w);
        this.f4433B = new C0630j(GlobalApplication.m3100a().getContentResolver(), null);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        if (this.f4435c != null) {
            this.f4435c.m853b(this.f4434b);
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        f4431a = true;
        GlobalApplication.f2411e = this;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        f4431a = false;
        GlobalApplication.f2411e = null;
        removeDialog(1);
        finish();
        this.f4445n.hideSoftInputFromWindow(this.f4447p.getWindowToken(), 0);
        GlobalApplication.f2412f = null;
        GlobalApplication.f2413g = false;
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i, Bundle bundle) {
        switch (i) {
            case 1:
                View viewInflate = getLayoutInflater().inflate(R.layout.layout_blackscreen_noti, (ViewGroup) null);
                TextView textView = (TextView) viewInflate.findViewById(R.id.black_noti_content);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.black_noti_content2);
                textView2.setMovementMethod(new ScrollingMovementMethod());
                textView.setText(this.f4436d);
                textView2.setText(new C0760c(getResources(), this.f4443l, (int) C1301ax.m4544a(30.0f)));
                if (this.f4432A.getBoolean("Setting show receive message", true)) {
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
                if (this.f4453v) {
                    this.f4448q = (LinearLayout) viewInflate.findViewById(R.id.noti_chat);
                    this.f4448q.setVisibility(0);
                }
                this.f4450s = (ProgressBar) viewInflate.findViewById(R.id.noti_progress);
                this.f4450s.setVisibility(8);
                this.f4446o = (Button) viewInflate.findViewById(R.id.noti_send_button);
                this.f4447p = (EditText) viewInflate.findViewById(R.id.noti_edit_chat);
                if (getResources().getConfiguration().locale.toString().startsWith("fr")) {
                    this.f4446o.setTextSize(1, 16.0f);
                }
                this.f4447p.addTextChangedListener(new C1318bn(this));
                this.f4447p.setOnClickListener(new ViewOnClickListenerC1319bo(this));
                this.f4446o.setOnClickListener(new ViewOnClickListenerC1320bp(this));
                View viewInflate2 = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.layout_blackscreen_noti_title, (ViewGroup) null);
                ((TextView) viewInflate2.findViewById(R.id.black_noti_title)).setText(R.string.app_name);
                this.f4451t = new AlertDialogBuilderC1625m(this);
                this.f4440i = this.f4451t.setCustomTitle(viewInflate2).setView(viewInflate).setPositiveButton(R.string.dialog_view, new DialogInterfaceOnClickListenerC1313bi(this)).setNegativeButton(R.string.close, new DialogInterfaceOnClickListenerC1312bh(this)).create();
                this.f4440i.setOnDismissListener(new DialogInterfaceOnDismissListenerC1314bj(this));
                return this.f4440i;
            case 2:
                this.f4451t = new AlertDialogBuilderC1625m(this);
                this.f4451t.setMessage(R.string.auth_error_restart).setPositiveButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1315bk(this));
                return this.f4451t.create();
            default:
                return super.onCreateDialog(i, bundle);
        }
    }

    /* renamed from: a */
    public void m4483a(Bundle bundle) {
        m4484b(bundle);
        Message message = new Message();
        message.what = 1028;
        message.obj = new C0592i(-1L, new C0257e(true, 1));
        this.f4434b.sendMessage(message);
    }

    /* renamed from: b */
    public void m4484b(Bundle bundle) {
        this.f4436d = bundle.getString("Sender");
        this.f4438f = bundle.getString("InboxNO");
        this.f4439g = bundle.getInt("Chattype");
        this.f4441j = bundle.getString("SenderID");
        this.f4442k = bundle.getString("SessionID");
        this.f4443l = bundle.getString("Content");
        this.f4444m = bundle.getInt("InboxRawID");
        EnumC0651d enumC0651dM2976a = EnumC0651d.m2976a(bundle.getInt("MediaType"));
        if (enumC0651dM2976a != EnumC0651d.TEXT) {
            String strM2977a = EnumC0651d.m2977a(enumC0651dM2976a);
            if (!TextUtils.isEmpty(strM2977a)) {
                this.f4443l = String.format(strM2977a, this.f4436d);
            }
        }
        this.f4435c = C0223v.m806a(this.f4438f, EnumC0665r.m3011a(this.f4439g));
        this.f4435c.m848a(this.f4434b);
        this.f4435c.m851a(this.f4438f, GlobalApplication.m3107h().m4488b().m4513a(), GlobalApplication.m3107h().m4488b().m4516b());
        GlobalApplication.f2412f = this.f4438f;
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog, Bundle bundle) {
        super.onPrepareDialog(i, dialog, bundle);
        switch (i) {
            case 1:
                TextView textView = (TextView) dialog.findViewById(R.id.black_noti_content);
                TextView textView2 = (TextView) dialog.findViewById(R.id.black_noti_content2);
                textView2.scrollTo(0, 0);
                textView.setText(this.f4436d);
                textView2.setText(new C0760c(getResources(), this.f4443l, (int) C1301ax.m4544a(30.0f)));
                if (this.f4432A.getBoolean("Setting show receive message", true)) {
                    textView.setVisibility(0);
                    break;
                } else {
                    textView.setVisibility(8);
                    break;
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4464a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_unread_count", (Integer) 0);
        this.f4433B.startUpdate(0, null, C0671x.f2315a, contentValues, "inbox_no='" + this.f4438f + "'", null);
    }
}
