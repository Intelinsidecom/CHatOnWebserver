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
public class BlackScreenNotification extends BaseActivity {

    /* renamed from: a */
    public static boolean f4379a;

    /* renamed from: c */
    private C0223v f4381c;

    /* renamed from: d */
    private String f4382d;

    /* renamed from: e */
    private String f4383e;

    /* renamed from: f */
    private String f4384f;

    /* renamed from: g */
    private int f4385g;

    /* renamed from: i */
    private AlertDialog f4386i;

    /* renamed from: j */
    private boolean f4387j;

    /* renamed from: k */
    private boolean f4388k;

    /* renamed from: l */
    private String f4389l;

    /* renamed from: m */
    private String f4390m;

    /* renamed from: n */
    private String f4391n;

    /* renamed from: o */
    private int f4392o;

    /* renamed from: p */
    private InputMethodManager f4393p;

    /* renamed from: q */
    private Button f4394q;

    /* renamed from: r */
    private EditText f4395r;

    /* renamed from: s */
    private LinearLayout f4396s;

    /* renamed from: t */
    private Toast f4397t;

    /* renamed from: u */
    private ProgressBar f4398u;

    /* renamed from: v */
    private AlertDialogBuilderC1625m f4399v;

    /* renamed from: w */
    private LinearLayout f4400w;

    /* renamed from: y */
    private SharedPreferences f4402y;

    /* renamed from: z */
    private C0630j f4403z;

    /* renamed from: x */
    private boolean f4401x = true;

    /* renamed from: b */
    Handler f4380b = new HandlerC1285ah(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4397t = C1619g.m5889a(this, (CharSequence) null, 0);
        this.f4393p = (InputMethodManager) getSystemService("input_method");
        this.f4402y = C1323bs.m4575a();
        requestWindowFeature(1);
        getWindow().addFlags(2621440);
        setContentView(R.layout.base_singlepane);
        this.f4400w = (LinearLayout) findViewById(R.id.blackscreen_layout);
        m4449b(getIntent().getExtras());
        showDialog(0);
        this.f4403z = new C0630j(GlobalApplication.m3100a().getContentResolver(), null);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        if (this.f4381c != null) {
            this.f4381c.m853b(this.f4380b);
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        f4379a = true;
        GlobalApplication.f2410d = this;
        if (!GlobalApplication.f2409c) {
            if (this.f4387j && !this.f4388k) {
                this.f4388k = true;
            }
            if (!this.f4387j) {
                this.f4387j = true;
            }
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        f4379a = false;
        GlobalApplication.f2410d = null;
        if (GlobalApplication.f2409c || this.f4388k) {
            removeDialog(0);
            finish();
        }
        this.f4393p.hideSoftInputFromWindow(this.f4395r.getWindowToken(), 0);
        GlobalApplication.f2412f = null;
        GlobalApplication.f2413g = false;
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i, Bundle bundle) {
        switch (i) {
            case 0:
                View viewInflate = getLayoutInflater().inflate(R.layout.layout_blackscreen_noti, (ViewGroup) null);
                TextView textView = (TextView) viewInflate.findViewById(R.id.black_noti_content);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.black_noti_content2);
                textView2.setMovementMethod(new ScrollingMovementMethod());
                textView.setText(this.f4382d);
                textView2.setText(new C0760c(getResources(), this.f4391n, (int) C1301ax.m4544a(30.0f)));
                if (this.f4402y.getBoolean("Setting show receive message", true)) {
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
                if (this.f4401x) {
                    this.f4396s = (LinearLayout) viewInflate.findViewById(R.id.noti_chat);
                    this.f4396s.setVisibility(0);
                    this.f4398u = (ProgressBar) viewInflate.findViewById(R.id.noti_progress);
                    this.f4398u.setVisibility(8);
                }
                this.f4394q = (Button) viewInflate.findViewById(R.id.noti_send_button);
                this.f4395r = (EditText) viewInflate.findViewById(R.id.noti_edit_chat);
                if (getResources().getConfiguration().locale.toString().startsWith("fr")) {
                    this.f4394q.setTextSize(1, 16.0f);
                }
                this.f4395r.addTextChangedListener(new C1284ag(this));
                this.f4395r.setOnClickListener(new ViewOnClickListenerC1283af(this));
                this.f4394q.setOnClickListener(new ViewOnClickListenerC1280ac(this));
                View viewInflate2 = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.layout_blackscreen_noti_title, (ViewGroup) null);
                ((TextView) viewInflate2.findViewById(R.id.black_noti_title)).setText(R.string.app_name);
                this.f4399v = new AlertDialogBuilderC1625m(this);
                this.f4386i = this.f4399v.setCustomTitle(viewInflate2).setView(viewInflate).setPositiveButton(R.string.dialog_view, new DialogInterfaceOnClickListenerC1282ae(this)).setNegativeButton(R.string.close, new DialogInterfaceOnClickListenerC1279ab(this)).create();
                this.f4386i.setOnDismissListener(new DialogInterfaceOnDismissListenerC1281ad(this));
                return this.f4386i;
            case 1:
            default:
                return super.onCreateDialog(i, bundle);
            case 2:
                this.f4399v = new AlertDialogBuilderC1625m(this);
                this.f4399v.setMessage(R.string.auth_error_restart).setPositiveButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1286ai(this));
                return this.f4399v.create();
        }
    }

    /* renamed from: a */
    public void m4448a(Bundle bundle) {
        m4449b(bundle);
        Message message = new Message();
        message.what = 1028;
        message.obj = new C0592i(-1L, new C0257e(true, 1));
        this.f4380b.sendMessage(message);
    }

    /* renamed from: b */
    public void m4449b(Bundle bundle) {
        this.f4382d = bundle.getString("Sender");
        this.f4384f = bundle.getString("InboxNO");
        this.f4385g = bundle.getInt("Chattype");
        this.f4389l = bundle.getString("SenderID");
        this.f4390m = bundle.getString("SessionID");
        this.f4391n = bundle.getString("Content");
        this.f4392o = bundle.getInt("InboxRawID");
        EnumC0651d enumC0651dM2976a = EnumC0651d.m2976a(bundle.getInt("MediaType"));
        if (enumC0651dM2976a != EnumC0651d.TEXT) {
            String strM2977a = EnumC0651d.m2977a(enumC0651dM2976a);
            if (!TextUtils.isEmpty(strM2977a)) {
                this.f4391n = String.format(strM2977a, this.f4382d);
            }
        }
        this.f4381c = C0223v.m806a(this.f4384f, EnumC0665r.m3011a(this.f4385g));
        this.f4381c.m848a(this.f4380b);
        this.f4381c.m851a(this.f4384f, GlobalApplication.m3107h().m4488b().m4513a(), GlobalApplication.m3107h().m4488b().m4516b());
        GlobalApplication.f2412f = this.f4384f;
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog, Bundle bundle) {
        super.onPrepareDialog(i, dialog, bundle);
        switch (i) {
            case 0:
                TextView textView = (TextView) dialog.findViewById(R.id.black_noti_content);
                TextView textView2 = (TextView) dialog.findViewById(R.id.black_noti_content2);
                textView2.scrollTo(0, 0);
                textView.setText(this.f4382d);
                textView2.setText(new C0760c(getResources(), this.f4391n, (int) C1301ax.m4544a(30.0f)));
                if (this.f4402y.getBoolean("Setting show receive message", true)) {
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
    public void m4434a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_unread_count", (Integer) 0);
        this.f4403z.startUpdate(0, null, C0671x.f2315a, contentValues, "inbox_no='" + this.f4384f + "'", null);
    }
}
