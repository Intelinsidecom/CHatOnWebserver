package com.sec.chaton.chat;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sec.chaton.R;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.util.C4902w;
import com.sec.chaton.widget.C4923p;
import com.sec.chaton.widget.ClearableEditText;
import com.sec.widget.C5179v;

/* compiled from: EditChatTitleDialog.java */
/* renamed from: com.sec.chaton.chat.gt */
/* loaded from: classes.dex */
public class AlertDialogC1747gt extends AlertDialog {

    /* renamed from: a */
    public static final String f6564a = AlertDialogC1747gt.class.getSimpleName();

    /* renamed from: b */
    ProgressDialog f6565b;

    /* renamed from: c */
    Handler f6566c;

    /* renamed from: d */
    private int f6567d;

    /* renamed from: e */
    private InterfaceC1752gy f6568e;

    /* renamed from: f */
    private ClearableEditText f6569f;

    /* renamed from: g */
    private Context f6570g;

    /* renamed from: h */
    private String f6571h;

    /* renamed from: i */
    private String f6572i;

    /* renamed from: j */
    private String f6573j;

    /* renamed from: k */
    private String f6574k;

    /* renamed from: l */
    private TextWatcher f6575l;

    public AlertDialogC1747gt(InterfaceC1752gy interfaceC1752gy, Context context, String str, String str2, String str3) {
        super(context);
        this.f6567d = 30;
        this.f6566c = new HandlerC1748gu(this);
        this.f6575l = new C1751gx(this);
        this.f6568e = interfaceC1752gy;
        this.f6570g = context;
        this.f6572i = str;
        this.f6573j = str2;
        this.f6574k = str3;
        m8690a();
        setInverseBackgroundForced(true);
        if (this.f6565b == null) {
            this.f6565b = (ProgressDialog) new C4923p(this.f6570g).m18724a(R.string.dialog_userprofile_updating);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT < 14) {
            getButton(-1).setEnabled(false);
        } else {
            getButton(-2).setEnabled(false);
        }
        setIcon(0);
        String strSubstring = this.f6572i;
        if (strSubstring.length() > 30) {
            strSubstring = strSubstring.substring(0, 30);
        }
        this.f6569f.setText(strSubstring);
        this.f6569f.setSelection(this.f6569f.m18658a().length());
    }

    /* renamed from: a */
    private void m8690a() {
        int i = -1;
        int i2 = -2;
        setTitle(this.f6570g.getString(R.string.enter_chat_title));
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.buddy_group_layout, (ViewGroup) null);
        setView(viewInflate);
        this.f6569f = (ClearableEditText) viewInflate.findViewById(R.id.buddy_group_groupname_field);
        this.f6569f.setFilters(new InputFilter[]{new C4902w(this.f6570g, this.f6567d)});
        this.f6569f.setHint("");
        this.f6569f.m18659a(this.f6575l);
        this.f6569f.setOnEditorActionListener(new C1749gv(this));
        getWindow().setSoftInputMode(5);
        if (Build.VERSION.SDK_INT < 11) {
            i2 = -1;
            i = -2;
        }
        setButton(i2, this.f6570g.getText(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1750gw(this));
        setButton(i, this.f6570g.getText(R.string.cancel), (DialogInterface.OnClickListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8693b() {
        if (!TextUtils.isEmpty(this.f6571h)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("inbox_title", this.f6569f.m18658a().toString().trim());
            contentValues.put("inbox_title_fixed", "Y");
            if (this.f6570g.getContentResolver().update(C2299s.f8209a, contentValues, "inbox_no='" + this.f6573j + "'", null) > 0) {
                C5179v c5179v = new C5179v(this.f6570g);
                c5179v.setText(R.string.buddy_profile_saveprofile_toast_success);
                c5179v.show();
                this.f6572i = this.f6569f.m18658a().toString();
            } else {
                C5179v.m19810a(this.f6570g, R.string.buddy_profile_saveprofile_toast_failed, 0).show();
            }
        }
        dismiss();
        this.f6568e.mo8326a(this.f6571h);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }
}
