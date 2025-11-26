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
import com.sec.chaton.p007a.p008a.C0103d;
import com.sec.chaton.p015d.C0639k;
import com.sec.chaton.p017e.C0694i;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.p017e.p018a.C0660d;
import com.sec.chaton.p017e.p018a.C0666j;
import com.sec.widget.AlertDialogBuilderC2120a;

/* loaded from: classes.dex */
public class BlackScreenNotification extends BaseActivity {

    /* renamed from: a */
    public static boolean f6234a;

    /* renamed from: A */
    private SharedPreferences f6235A;

    /* renamed from: B */
    private int f6236B;

    /* renamed from: C */
    private C0666j f6237C;

    /* renamed from: c */
    private C0639k f6240c;

    /* renamed from: d */
    private String f6241d;

    /* renamed from: e */
    private String f6242e;

    /* renamed from: i */
    private String f6243i;

    /* renamed from: j */
    private int f6244j;

    /* renamed from: k */
    private AlertDialog f6245k;

    /* renamed from: l */
    private boolean f6246l;

    /* renamed from: m */
    private boolean f6247m;

    /* renamed from: n */
    private String f6248n;

    /* renamed from: o */
    private String f6249o;

    /* renamed from: p */
    private String f6250p;

    /* renamed from: q */
    private String f6251q;

    /* renamed from: r */
    private InputMethodManager f6252r;

    /* renamed from: s */
    private Button f6253s;

    /* renamed from: t */
    private EditText f6254t;

    /* renamed from: u */
    private LinearLayout f6255u;

    /* renamed from: v */
    private Toast f6256v;

    /* renamed from: w */
    private ProgressBar f6257w;

    /* renamed from: x */
    private AlertDialogBuilderC2120a f6258x;

    /* renamed from: y */
    private LinearLayout f6259y;

    /* renamed from: z */
    private boolean f6260z = true;

    /* renamed from: D */
    private boolean f6238D = false;

    /* renamed from: b */
    Handler f6239b = new HandlerC1779k(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6252r = (InputMethodManager) getSystemService("input_method");
        this.f6235A = C1789u.m6075a();
        requestWindowFeature(1);
        getWindow().addFlags(2621440);
        setContentView(R.layout.base_singlepane);
        this.f6259y = (LinearLayout) findViewById(R.id.blackscreen_layout);
        m5831b(getIntent().getExtras());
        showDialog(0);
        this.f6237C = new C0666j(GlobalApplication.m3260b().getContentResolver(), null);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        if (this.f6240c != null) {
            this.f6240c.m2954f();
            this.f6240c = null;
        }
        super.onDestroy();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        f6234a = true;
        GlobalApplication.f2778d = this;
        if (!GlobalApplication.f2777c) {
            if (this.f6246l && !this.f6247m) {
                this.f6247m = true;
            }
            if (!this.f6246l) {
                this.f6246l = true;
            }
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        f6234a = false;
        GlobalApplication.f2778d = null;
        if (GlobalApplication.f2777c || this.f6247m) {
            removeDialog(0);
            finish();
        }
        this.f6252r.hideSoftInputFromWindow(this.f6254t.getWindowToken(), 0);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i, Bundle bundle) {
        switch (i) {
            case 0:
                View viewInflate = getLayoutInflater().inflate(R.layout.layout_blackscreen_noti, (ViewGroup) null);
                TextView textView = (TextView) viewInflate.findViewById(R.id.black_noti_content2);
                textView.setMovementMethod(new ScrollingMovementMethod());
                this.f6255u = (LinearLayout) viewInflate.findViewById(R.id.noti_chat);
                String string = this.f6235A.getString("lock_state", "OFF");
                C1786r.m6061b("LOCK_STATE : " + string, getClass().getSimpleName());
                CharSequence charSequenceM3825a = C0968n.m3825a(this, this.f6250p, (int) C1722ae.m5894a(26.0f));
                textView.setVisibility(0);
                if (string.equals("OFF") && this.f6235A.getBoolean("Setting show receive message", true)) {
                    textView.setText(charSequenceM3825a);
                    this.f6255u.setVisibility(0);
                    this.f6257w = (ProgressBar) viewInflate.findViewById(R.id.noti_progress);
                    this.f6257w.setVisibility(8);
                } else {
                    textView.setText(this.f6251q);
                    this.f6255u.setVisibility(8);
                }
                this.f6253s = (Button) viewInflate.findViewById(R.id.noti_send_button);
                this.f6254t = (EditText) viewInflate.findViewById(R.id.noti_edit_chat);
                this.f6254t.addTextChangedListener(new C1772d(this));
                this.f6254t.setOnClickListener(new ViewOnClickListenerC1773e(this));
                this.f6253s.setOnClickListener(new ViewOnClickListenerC1774f(this));
                View viewInflate2 = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.layout_blackscreen_noti_title, (ViewGroup) null);
                TextView textView2 = (TextView) viewInflate2.findViewById(R.id.black_noti_title);
                if (this.f6235A.getBoolean("Setting show receive message", true) && string.equals("OFF")) {
                    textView2.setText(this.f6241d);
                } else {
                    textView2.setText(R.string.app_name);
                }
                this.f6258x = new AlertDialogBuilderC2120a(this);
                this.f6245k = this.f6258x.setCustomTitle(viewInflate2).setView(viewInflate).setPositiveButton(R.string.dialog_view, new DialogInterfaceOnClickListenerC1776h(this)).setNegativeButton(R.string.close, new DialogInterfaceOnClickListenerC1775g(this)).create();
                this.f6245k.setOnDismissListener(new DialogInterfaceOnDismissListenerC1777i(this));
                return this.f6245k;
            case 1:
            default:
                return super.onCreateDialog(i, bundle);
            case 2:
                this.f6258x = new AlertDialogBuilderC2120a(this);
                this.f6258x.setMessage(R.string.auth_error_restart).setPositiveButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1778j(this));
                return this.f6258x.create();
        }
    }

    /* renamed from: a */
    public void m5830a(Bundle bundle) {
        C1786r.m6061b("changeDialog", getClass().getSimpleName());
        if (m5831b(bundle)) {
            Message message = new Message();
            message.what = 1028;
            message.obj = new C0103d(true, 1);
            this.f6239b.sendMessage(message);
        }
    }

    /* renamed from: b */
    public boolean m5831b(Bundle bundle) {
        C1786r.m6061b("setInfo mInboxNO " + this.f6243i + " new inbox " + bundle.getString("InboxNO"), getClass().getSimpleName());
        if (this.f6243i != null && !this.f6243i.equals(bundle.getString("InboxNO"))) {
            C1786r.m6061b("changeDialog setInfo " + this.f6238D, getClass().getSimpleName());
            if (this.f6238D) {
                return false;
            }
        }
        this.f6241d = bundle.getString("Sender");
        this.f6243i = bundle.getString("InboxNO");
        this.f6244j = bundle.getInt("Chattype");
        this.f6248n = bundle.getString("SenderID");
        this.f6249o = bundle.getString("SessionID");
        this.f6251q = bundle.getString("TempMessage");
        this.f6250p = bundle.getString("Content");
        EnumC0699n enumC0699nM3160a = EnumC0699n.m3160a(bundle.getInt("MediaType"));
        this.f6236B = C0660d.m3003a(getContentResolver(), this.f6243i);
        String string = this.f6235A.getString("lock_state", "OFF");
        C1786r.m6061b("LOCK_STATE : " + string, getClass().getSimpleName());
        if (this.f6235A.getBoolean("Setting show receive message", true) && string.equals("OFF")) {
            if (enumC0699nM3160a != EnumC0699n.TEXT) {
                String strM3161a = EnumC0699n.m3161a(enumC0699nM3160a);
                if (!TextUtils.isEmpty(strM3161a)) {
                    if (enumC0699nM3160a != EnumC0699n.DOCUMENT) {
                        this.f6250p = String.format(strM3161a, this.f6241d);
                    } else {
                        String[] strArrSplit = this.f6250p.split("\n");
                        if (strArrSplit == null || strArrSplit.length <= 3) {
                            this.f6250p = String.format(strM3161a, this.f6241d, "");
                        } else {
                            this.f6250p = String.format(strM3161a, this.f6241d, strArrSplit[3].substring(strArrSplit[3].lastIndexOf(".") + 1).toUpperCase());
                        }
                    }
                }
            }
        } else {
            this.f6241d = GlobalApplication.m3260b().getString(R.string.app_name);
        }
        this.f6240c = C0639k.m2904a(this.f6239b, this.f6243i, EnumC0695j.m3145a(this.f6244j));
        this.f6240c.m2947a(this.f6243i, GlobalApplication.m3263d().m5922b().m5923a(), GlobalApplication.m3263d().m5922b().m5926b());
        return true;
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog, Bundle bundle) {
        super.onPrepareDialog(i, dialog, bundle);
        switch (i) {
            case 0:
                TextView textView = (TextView) dialog.findViewById(R.id.black_noti_content2);
                textView.scrollTo(0, 0);
                this.f6255u = (LinearLayout) dialog.findViewById(R.id.noti_chat);
                CharSequence charSequenceM3825a = C0968n.m3825a(this, this.f6250p, (int) C1722ae.m5894a(26.0f));
                textView.setVisibility(0);
                String string = this.f6235A.getString("lock_state", "OFF");
                if (string.equals("OFF") && this.f6235A.getBoolean("Setting show receive message", true)) {
                    textView.setText(charSequenceM3825a);
                    this.f6255u = (LinearLayout) dialog.findViewById(R.id.noti_chat);
                    this.f6255u.setVisibility(0);
                } else {
                    textView.setText(this.f6251q);
                    this.f6255u = (LinearLayout) dialog.findViewById(R.id.noti_chat);
                    this.f6255u.setVisibility(8);
                }
                TextView textView2 = (TextView) dialog.findViewById(R.id.black_noti_title);
                if (this.f6235A.getBoolean("Setting show receive message", true) && string.equals("OFF")) {
                    textView2.setText(this.f6241d);
                } else {
                    textView2.setText(R.string.app_name);
                }
                C1786r.m6061b("LOCK_STATE : " + string, getClass().getSimpleName());
                if (!this.f6235A.getBoolean("Setting show receive message", true) || string.equals("OFF")) {
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5815a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_unread_count", (Integer) 0);
        this.f6237C.startUpdate(0, null, C0694i.f2616a, contentValues, "inbox_no='" + this.f6243i + "'", null);
    }
}
