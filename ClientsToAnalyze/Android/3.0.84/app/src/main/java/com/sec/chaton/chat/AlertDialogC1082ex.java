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
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.util.C3248w;
import com.sec.chaton.widget.C3263j;
import com.sec.chaton.widget.ClearableEditText;
import com.sec.widget.C3641ai;

/* compiled from: EditChatTitleDialog.java */
/* renamed from: com.sec.chaton.chat.ex */
/* loaded from: classes.dex */
public class AlertDialogC1082ex extends AlertDialog {

    /* renamed from: a */
    public static final String f4333a = AlertDialogC1082ex.class.getSimpleName();

    /* renamed from: b */
    ProgressDialog f4334b;

    /* renamed from: c */
    Handler f4335c;

    /* renamed from: d */
    private int f4336d;

    /* renamed from: e */
    private InterfaceC1088fc f4337e;

    /* renamed from: f */
    private ClearableEditText f4338f;

    /* renamed from: g */
    private Context f4339g;

    /* renamed from: h */
    private String f4340h;

    /* renamed from: i */
    private String f4341i;

    /* renamed from: j */
    private String f4342j;

    /* renamed from: k */
    private String f4343k;

    /* renamed from: l */
    private TextWatcher f4344l;

    public AlertDialogC1082ex(InterfaceC1088fc interfaceC1088fc, Context context, String str, String str2, String str3) {
        super(context);
        this.f4336d = 30;
        this.f4335c = new HandlerC1083ey(this);
        this.f4344l = new C1087fb(this);
        this.f4337e = interfaceC1088fc;
        this.f4339g = context;
        this.f4341i = str;
        this.f4342j = str2;
        this.f4343k = str3;
        m5351a();
        setInverseBackgroundForced(true);
        if (this.f4334b == null) {
            this.f4334b = (ProgressDialog) new C3263j(this.f4339g).m11487a(R.string.dialog_userprofile_updating);
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
        String strSubstring = this.f4341i;
        if (strSubstring.length() > 30) {
            strSubstring = strSubstring.substring(0, 30);
        }
        this.f4338f.setText(strSubstring);
        this.f4338f.setSelection(this.f4338f.m11463a().length());
    }

    /* renamed from: a */
    private void m5351a() {
        int i = -1;
        int i2 = -2;
        setTitle(this.f4339g.getString(R.string.enter_chat_title));
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.buddy_group_layout, (ViewGroup) null);
        setView(viewInflate);
        this.f4338f = (ClearableEditText) viewInflate.findViewById(R.id.buddy_group_groupname_field);
        this.f4338f.setFilters(new InputFilter[]{new C3248w(this.f4339g, this.f4336d)});
        this.f4338f.setHint("");
        this.f4338f.m11464a(this.f4344l);
        this.f4338f.setOnEditorActionListener(new C1084ez(this));
        getWindow().setSoftInputMode(4);
        if (Build.VERSION.SDK_INT < 11) {
            i2 = -1;
            i = -2;
        }
        setButton(i2, this.f4339g.getText(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1086fa(this));
        setButton(i, this.f4339g.getText(R.string.cancel), (DialogInterface.OnClickListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m5354b() {
        if (!TextUtils.isEmpty(this.f4340h)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("inbox_title", this.f4338f.m11463a().toString());
            contentValues.put("inbox_title_fixed", "Y");
            if (this.f4339g.getContentResolver().update(C1449q.f5381a, contentValues, "inbox_no='" + this.f4342j + "'", null) > 0) {
                C3641ai c3641ai = new C3641ai(this.f4339g);
                c3641ai.setText(R.string.buddy_profile_saveprofile_toast_success);
                c3641ai.show();
                this.f4341i = this.f4338f.m11463a().toString();
            } else {
                C3641ai.m13210a(this.f4339g, R.string.buddy_profile_saveprofile_toast_failed, 0).show();
            }
        }
        dismiss();
        this.f4337e.mo5060c(this.f4340h);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }
}
