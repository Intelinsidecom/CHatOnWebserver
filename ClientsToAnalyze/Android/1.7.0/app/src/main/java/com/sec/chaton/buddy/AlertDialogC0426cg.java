package com.sec.chaton.buddy;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p025d.p026a.C0627g;
import com.sec.chaton.p025d.p027b.C0649l;
import com.sec.chaton.p025d.p027b.InterfaceC0641d;
import com.sec.chaton.util.C1341p;
import com.sec.widget.AlertDialogBuilderC1625m;
import com.sec.widget.C1606ac;
import com.sec.widget.EditTextWithClearButton;

/* compiled from: BuddyGroupDialog.java */
/* renamed from: com.sec.chaton.buddy.cg */
/* loaded from: classes.dex */
public class AlertDialogC0426cg extends AlertDialog {

    /* renamed from: b */
    public static final String f1411b = AlertDialogC0426cg.class.getSimpleName();

    /* renamed from: a */
    BuddyFragment f1412a;

    /* renamed from: c */
    InterfaceC0641d f1413c;

    /* renamed from: d */
    private FragmentActivity f1414d;

    /* renamed from: e */
    private int f1415e;

    /* renamed from: f */
    private EditTextWithClearButton f1416f;

    /* renamed from: g */
    private Context f1417g;

    /* renamed from: h */
    private Toast f1418h;

    /* renamed from: i */
    private TextWatcher f1419i;

    public AlertDialogC0426cg(Context context) {
        super(context);
        this.f1413c = new C0424ce(this);
        this.f1419i = new C0422cc(this);
        this.f1414d = (FragmentActivity) context;
        this.f1415e = 100;
        m2371a();
    }

    public AlertDialogC0426cg(Context context, int i, BuddyFragment buddyFragment) {
        super(context);
        this.f1413c = new C0424ce(this);
        this.f1419i = new C0422cc(this);
        this.f1414d = (FragmentActivity) context;
        this.f1415e = i;
        this.f1412a = buddyFragment;
        m2371a();
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        C1341p.m4663f("onCreate()", f1411b);
        super.onCreate(bundle);
        AlertDialogBuilderC1625m.m5911a(this);
        getButton(-2).setEnabled(false);
        setIcon(0);
    }

    /* renamed from: a */
    private void m2371a() {
        this.f1417g = getContext();
        setTitle(R.string.buddy_group_list_newgroup_info);
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.buddy_group_layout, (ViewGroup) null);
        setView(viewInflate);
        this.f1416f = (EditTextWithClearButton) viewInflate.findViewById(R.id.buddy_group_groupname_field);
        this.f1416f.setMaxLengthString(R.string.toast_text_max_Length);
        this.f1416f.addTextChangedListener(this.f1419i);
        C1606ac.m5880a(this.f1416f, new char[]{','}, R.string.buddy_group_profile_rename_not_allowed_character);
        this.f1416f.setOnEditorActionListener(new C0425cf(this));
        getWindow().setSoftInputMode(4);
        setButton(-2, this.f1417g.getText(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0423cd(this));
        setButton(-1, this.f1417g.getText(R.string.cancel), (DialogInterface.OnClickListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m2374b() {
        String strReplace = this.f1416f.getText().toString().trim().replace(",", "");
        this.f1416f.setText(strReplace);
        if (strReplace.length() > 0) {
            getButton(-2).setEnabled(false);
            C0627g.m2858a(new C0627g(), 3, new C0649l(this.f1413c, strReplace, 3));
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }
}
