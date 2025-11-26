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
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.C0968n;
import com.sec.chaton.multimedia.emoticon.C0970p;
import com.sec.chaton.p007a.p008a.C0103d;
import com.sec.chaton.p015d.C0639k;
import com.sec.chaton.p017e.C0694i;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.p017e.p018a.C0660d;
import com.sec.chaton.p017e.p018a.C0666j;
import com.sec.widget.AlertDialogBuilderC2120a;

/* loaded from: classes.dex */
public class ScreenOnNotification extends BaseActivity {

    /* renamed from: a */
    public static boolean f6289a;

    /* renamed from: A */
    private Runnable f6290A;

    /* renamed from: C */
    private SharedPreferences f6292C;

    /* renamed from: D */
    private int f6293D;

    /* renamed from: E */
    private C0666j f6294E;

    /* renamed from: c */
    private C0639k f6296c;

    /* renamed from: d */
    private String f6297d;

    /* renamed from: e */
    private String f6298e;

    /* renamed from: i */
    private String f6299i;

    /* renamed from: j */
    private int f6300j;

    /* renamed from: k */
    private AlertDialog f6301k;

    /* renamed from: l */
    private String f6302l;

    /* renamed from: m */
    private String f6303m;

    /* renamed from: n */
    private String f6304n;

    /* renamed from: o */
    private String f6305o;

    /* renamed from: p */
    private InputMethodManager f6306p;

    /* renamed from: q */
    private Button f6307q;

    /* renamed from: r */
    private EditText f6308r;

    /* renamed from: s */
    private LinearLayout f6309s;

    /* renamed from: t */
    private Toast f6310t;

    /* renamed from: u */
    private ProgressBar f6311u;

    /* renamed from: v */
    private AlertDialogBuilderC2120a f6312v;

    /* renamed from: w */
    private LinearLayout f6313w;

    /* renamed from: z */
    private Handler f6316z;

    /* renamed from: x */
    private boolean f6314x = true;

    /* renamed from: y */
    private int f6315y = 6000;

    /* renamed from: B */
    private boolean f6291B = false;

    /* renamed from: b */
    Handler f6295b = new HandlerC1762br(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f6289a = true;
        this.f6316z = new Handler();
        this.f6290A = new RunnableC1753bi(this);
        this.f6306p = (InputMethodManager) getSystemService("input_method");
        this.f6292C = C1789u.m6075a();
        requestWindowFeature(1);
        getWindow().addFlags(2621440);
        setContentView(R.layout.base_singlepane);
        this.f6313w = (LinearLayout) findViewById(R.id.blackscreen_layout);
        m5865b(getIntent().getExtras());
        showDialog(1);
        this.f6316z.postDelayed(this.f6290A, this.f6315y);
        this.f6294E = new C0666j(GlobalApplication.m3260b().getContentResolver(), null);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        if (this.f6296c != null) {
            this.f6296c.m2954f();
            this.f6296c = null;
        }
        super.onDestroy();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        f6289a = true;
        GlobalApplication.f2779e = this;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        f6289a = false;
        GlobalApplication.f2779e = null;
        removeDialog(1);
        finish();
        this.f6306p.hideSoftInputFromWindow(this.f6308r.getWindowToken(), 0);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i, Bundle bundle) {
        switch (i) {
            case 1:
                View viewInflate = getLayoutInflater().inflate(R.layout.layout_blackscreen_noti, (ViewGroup) null);
                TextView textView = (TextView) viewInflate.findViewById(R.id.black_noti_content2);
                textView.setMovementMethod(new ScrollingMovementMethod());
                this.f6309s = (LinearLayout) viewInflate.findViewById(R.id.noti_chat);
                String string = this.f6292C.getString("lock_state", "OFF");
                C1786r.m6061b("LOCK_STATE : " + string, getClass().getSimpleName());
                if (this.f6292C.getBoolean("Setting show receive message", true) && string.equals("OFF")) {
                    this.f6314x = true;
                } else {
                    this.f6314x = false;
                }
                CharSequence charSequenceM3825a = C0968n.m3825a(this, this.f6304n, (int) C1722ae.m5894a(26.0f));
                textView.setVisibility(0);
                if (string.equals("OFF") && this.f6292C.getBoolean("Setting show receive message", true)) {
                    textView.setText(charSequenceM3825a);
                    this.f6309s.setVisibility(0);
                } else {
                    textView.setText(this.f6305o);
                    this.f6309s.setVisibility(8);
                }
                this.f6311u = (ProgressBar) viewInflate.findViewById(R.id.noti_progress);
                this.f6311u.setVisibility(8);
                this.f6307q = (Button) viewInflate.findViewById(R.id.noti_send_button);
                this.f6308r = (EditText) viewInflate.findViewById(R.id.noti_edit_chat);
                this.f6308r.addTextChangedListener(new C1755bk(this));
                this.f6308r.setOnClickListener(new ViewOnClickListenerC1756bl(this));
                this.f6307q.setOnClickListener(new ViewOnClickListenerC1757bm(this));
                View viewInflate2 = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.layout_blackscreen_noti_title, (ViewGroup) null);
                TextView textView2 = (TextView) viewInflate2.findViewById(R.id.black_noti_title);
                if (this.f6292C.getBoolean("Setting show receive message", true) && string.equals("OFF")) {
                    textView2.setText(this.f6297d);
                } else {
                    textView2.setText(R.string.app_name);
                }
                this.f6312v = new AlertDialogBuilderC2120a(this);
                this.f6301k = this.f6312v.setCustomTitle(viewInflate2).setView(viewInflate).setPositiveButton(R.string.dialog_view, new DialogInterfaceOnClickListenerC1759bo(this)).setNegativeButton(R.string.close, new DialogInterfaceOnClickListenerC1758bn(this)).create();
                this.f6301k.setOnDismissListener(new DialogInterfaceOnDismissListenerC1760bp(this));
                return this.f6301k;
            case 2:
                this.f6312v = new AlertDialogBuilderC2120a(this);
                this.f6312v.setMessage(R.string.auth_error_restart).setPositiveButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1761bq(this));
                return this.f6312v.create();
            default:
                return super.onCreateDialog(i, bundle);
        }
    }

    /* renamed from: a */
    public void m5864a(Bundle bundle) {
        C1786r.m6061b("changeDialog", getClass().getSimpleName());
        if (m5865b(bundle)) {
            Message message = new Message();
            message.what = 1028;
            message.obj = new C0103d(true, 1);
            this.f6295b.sendMessage(message);
        }
    }

    /* renamed from: b */
    public boolean m5865b(Bundle bundle) {
        C1786r.m6061b("setInfo mInboxNO " + this.f6299i + " new inbox " + bundle.getString("InboxNO"), getClass().getSimpleName());
        if (this.f6299i != null && !this.f6299i.equals(bundle.getString("InboxNO"))) {
            C1786r.m6061b("changeDialog setInfo " + this.f6291B, getClass().getSimpleName());
            if (this.f6291B) {
                return false;
            }
        }
        this.f6297d = bundle.getString("Sender");
        this.f6299i = bundle.getString("InboxNO");
        this.f6300j = bundle.getInt("Chattype");
        this.f6302l = bundle.getString("SenderID");
        this.f6303m = bundle.getString("SessionID");
        this.f6305o = bundle.getString("TempMessage");
        this.f6304n = bundle.getString("Content");
        EnumC0699n enumC0699nM3160a = EnumC0699n.m3160a(bundle.getInt("MediaType"));
        this.f6293D = C0660d.m3003a(getContentResolver(), this.f6299i);
        String string = this.f6292C.getString("lock_state", "OFF");
        C1786r.m6061b("LOCK_STATE : " + string, getClass().getSimpleName());
        if (this.f6292C.getBoolean("Setting show receive message", true) && string.equals("OFF") && enumC0699nM3160a != EnumC0699n.TEXT) {
            String strM3161a = EnumC0699n.m3161a(enumC0699nM3160a);
            if (!TextUtils.isEmpty(strM3161a)) {
                if (enumC0699nM3160a != EnumC0699n.DOCUMENT) {
                    this.f6304n = String.format(strM3161a, this.f6297d);
                } else {
                    String[] strArrSplit = this.f6304n.split("\n");
                    if (strArrSplit == null || strArrSplit.length <= 3) {
                        this.f6304n = String.format(strM3161a, this.f6297d, "");
                    } else {
                        this.f6304n = String.format(strM3161a, this.f6297d, strArrSplit[3].substring(strArrSplit[3].lastIndexOf(".") + 1).toUpperCase());
                    }
                }
            }
        }
        this.f6296c = C0639k.m2904a(this.f6295b, this.f6299i, EnumC0695j.m3145a(this.f6300j));
        this.f6296c.m2947a(this.f6299i, GlobalApplication.m3263d().m5922b().m5923a(), GlobalApplication.m3263d().m5922b().m5926b());
        return true;
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog, Bundle bundle) {
        super.onPrepareDialog(i, dialog, bundle);
        switch (i) {
            case 1:
                TextView textView = (TextView) dialog.findViewById(R.id.black_noti_content2);
                new C0970p(getResources(), this.f6304n, (int) C1722ae.m5894a(26.0f));
                CharSequence charSequenceM3825a = C0968n.m3825a(this, this.f6304n, (int) C1722ae.m5894a(26.0f));
                textView.setVisibility(0);
                String string = this.f6292C.getString("lock_state", "OFF");
                if (string.equals("OFF") && this.f6292C.getBoolean("Setting show receive message", true)) {
                    textView.setText(charSequenceM3825a);
                    this.f6309s = (LinearLayout) dialog.findViewById(R.id.noti_chat);
                    this.f6309s.setVisibility(0);
                } else {
                    textView.setText(this.f6305o);
                    this.f6309s = (LinearLayout) dialog.findViewById(R.id.noti_chat);
                    this.f6309s.setVisibility(8);
                }
                TextView textView2 = (TextView) dialog.findViewById(R.id.black_noti_title);
                if (this.f6292C.getBoolean("Setting show receive message", true) && string.equals("OFF")) {
                    textView2.setText(this.f6297d);
                } else {
                    textView2.setText(R.string.app_name);
                }
                C1786r.m6061b("LOCK_STATE : " + string, getClass().getSimpleName());
                if (!this.f6292C.getBoolean("Setting show receive message", true) || string.equals("OFF")) {
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5845a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_unread_count", (Integer) 0);
        this.f6294E.startUpdate(0, null, C0694i.f2616a, contentValues, "inbox_no='" + this.f6299i + "'", null);
    }
}
