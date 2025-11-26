package com.sec.chaton.buddy;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextWatcher;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p017e.p018a.C0668l;
import com.sec.chaton.p017e.p019b.C0680g;
import com.sec.chaton.p017e.p019b.InterfaceC0677d;
import com.sec.chaton.util.C1786r;
import com.sec.widget.AlertDialogBuilderC2120a;
import com.sec.widget.C2126af;
import com.sec.widget.C2153y;
import com.sec.widget.EditTextWithClearButton;

/* compiled from: BuddyGroupDialog.java */
/* renamed from: com.sec.chaton.buddy.bs */
/* loaded from: classes.dex */
public class AlertDialogC0307bs extends AlertDialog {

    /* renamed from: b */
    public static final String f1418b = AlertDialogC0307bs.class.getSimpleName();

    /* renamed from: a */
    BuddyFragment f1419a;

    /* renamed from: c */
    InterfaceC0677d f1420c;

    /* renamed from: d */
    private FragmentActivity f1421d;

    /* renamed from: e */
    private int f1422e;

    /* renamed from: f */
    private EditTextWithClearButton f1423f;

    /* renamed from: g */
    private Context f1424g;

    /* renamed from: h */
    private Toast f1425h;

    /* renamed from: i */
    private TextWatcher f1426i;

    public AlertDialogC0307bs(Context context) {
        super(new ContextThemeWrapper(context, R.style.ChatONAddGroupAlertDialog2theme));
        this.f1420c = new C0310bv(this);
        this.f1426i = new C0311bw(this);
        this.f1421d = (FragmentActivity) context;
        this.f1422e = 100;
        m2384a();
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        C1786r.m6067f("onCreate()", f1418b);
        super.onCreate(bundle);
        getWindow().setLayout(549, -2);
        AlertDialogBuilderC2120a.m7479a(this);
        getButton(-2).setEnabled(false);
        setIcon(0);
    }

    /* renamed from: a */
    private void m2384a() {
        this.f1424g = getContext();
        setTitle(R.string.buddy_group_list_newgroup_info);
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.buddy_group_layout, (ViewGroup) null);
        setView(viewInflate);
        this.f1423f = (EditTextWithClearButton) viewInflate.findViewById(R.id.buddy_group_groupname_field);
        this.f1423f.setMaxLengthString(R.string.toast_text_max_Length);
        this.f1423f.addTextChangedListener(this.f1426i);
        C2126af.m7480a(this.f1423f, new char[]{','}, R.string.buddy_group_profile_rename_not_allowed_character);
        this.f1423f.setOnEditorActionListener(new C0308bt(this));
        getWindow().setSoftInputMode(4);
        setButton(-1, this.f1424g.getText(R.string.cancel), (DialogInterface.OnClickListener) null);
        setButton(-2, this.f1424g.getText(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0309bu(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m2387b() {
        String strReplace = this.f1423f.getText().toString().trim().replace(",", "");
        this.f1423f.setText(strReplace);
        if (strReplace.toUpperCase().equals(this.f1421d.getResources().getString(R.string.buddy_list_group_birthday).toUpperCase()) || strReplace.toUpperCase().equals(this.f1421d.getResources().getString(R.string.buddy_list_group_favorites).toUpperCase()) || strReplace.toUpperCase().equals(this.f1421d.getResources().getString(R.string.buddy_list_group_favorites2).toUpperCase())) {
            C2153y.m7536a(this.f1421d, this.f1421d.getResources().getString(R.string.buddy_group_list_addgroup_toast_failed_exist), 0).show();
        } else if (strReplace.length() > 0) {
            getButton(-2).setEnabled(false);
            C0668l.m3077a(new C0668l(), 3, new C0680g(this.f1420c, strReplace, 3));
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }
}
