package com.sec.chaton.buddy;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sec.chaton.R;
import com.sec.chaton.p027e.p028a.C1379w;
import com.sec.chaton.p027e.p029b.C1418i;
import com.sec.chaton.p027e.p029b.InterfaceC1413d;
import com.sec.chaton.util.C3248w;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.InterfaceC3200bo;
import com.sec.chaton.widget.ClearableEditText;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.widget.C3641ai;
import com.sec.widget.C3652at;

/* compiled from: BuddyGroupDialog.java */
/* renamed from: com.sec.chaton.buddy.dc */
/* loaded from: classes.dex */
public class AlertDialogC0599dc extends AlertDialog {

    /* renamed from: a */
    public static final String f2578a = AlertDialogC0599dc.class.getSimpleName();

    /* renamed from: b */
    InterfaceC1413d f2579b;

    /* renamed from: c */
    InterfaceC1413d f2580c;

    /* renamed from: d */
    private FragmentActivity f2581d;

    /* renamed from: e */
    private String f2582e;

    /* renamed from: f */
    private String[] f2583f;

    /* renamed from: g */
    private BuddyFragment f2584g;

    /* renamed from: h */
    private ProgressDialog f2585h;

    /* renamed from: i */
    private boolean f2586i;

    /* renamed from: j */
    private ClearableEditText f2587j;

    /* renamed from: k */
    private Context f2588k;

    /* renamed from: l */
    private InterfaceC3200bo f2589l;

    /* renamed from: m */
    private Handler f2590m;

    /* renamed from: n */
    private TextWatcher f2591n;

    /* renamed from: a */
    public void m4084a(boolean z) {
        this.f2586i = z;
    }

    public AlertDialogC0599dc(Context context, BuddyFragment buddyFragment) {
        super(context);
        this.f2585h = null;
        this.f2586i = false;
        this.f2589l = new C0600dd(this);
        this.f2579b = new C0603dg(this);
        this.f2590m = new HandlerC0604dh(this);
        this.f2580c = new C0645dj(this);
        this.f2591n = new C0646dk(this);
        this.f2581d = (FragmentActivity) context;
        this.f2584g = buddyFragment;
        this.f2583f = this.f2584g.m3443h();
        m4069a();
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        C3250y.m11458g("onCreate()", f2578a);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT < 14) {
            getButton(-1).setEnabled(false);
        } else {
            getButton(-2).setEnabled(false);
        }
        setIcon(0);
    }

    /* renamed from: a */
    private void m4069a() {
        int i = -1;
        int i2 = -2;
        this.f2588k = getContext();
        setTitle(this.f2588k.getString(R.string.buddy_group_list_newgroup_info));
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.buddy_group_layout, (ViewGroup) null);
        setView(viewInflate);
        this.f2587j = (ClearableEditText) viewInflate.findViewById(R.id.buddy_group_groupname_field);
        this.f2587j.setFilters(new InputFilter[]{new C3248w(this.f2588k, 30)});
        this.f2587j.m11464a(this.f2591n);
        C3652at.m13220a(this.f2587j, new char[]{','}, R.string.buddy_group_profile_rename_not_allowed_character);
        this.f2587j.setOnEditorActionListener(new C0601de(this));
        getWindow().setSoftInputMode(5);
        if (Build.VERSION.SDK_INT < 11) {
            i2 = -1;
            i = -2;
        }
        setButton(i2, this.f2588k.getText(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0602df(this));
        setButton(i, this.f2588k.getText(R.string.cancel), (DialogInterface.OnClickListener) null);
        setInverseBackgroundForced(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m4070b() {
        String strReplace = this.f2587j.m11463a().toString().trim().replace(",", "");
        if (!strReplace.toUpperCase().equals("FAVORITES")) {
            return false;
        }
        C3641ai.m13211a(this.f2588k, this.f2588k.getString(R.string.buddy_group_list_addgroup_toast_exist, strReplace), 0).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m4073c() {
        C1418i c1418i;
        this.f2582e = this.f2587j.m11463a().toString().trim().replace(",", "");
        if (this.f2582e.length() > 0) {
            if (Build.VERSION.SDK_INT < 14) {
                getButton(-1).setEnabled(false);
            } else {
                getButton(-2).setEnabled(false);
            }
            if (this.f2583f != null && this.f2583f.length > 0) {
                c1418i = new C1418i(this.f2579b, this.f2582e, this.f2583f, 3);
            } else {
                c1418i = new C1418i(this.f2579b, this.f2582e, 3);
            }
            C1379w.m6203a(new C1379w(), 3, c1418i);
            if (this.f2583f != null && this.f2583f.length > 0) {
                m4074d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m4074d() {
        if (this.f2581d != null) {
            if (this.f2585h == null) {
                this.f2585h = ProgressDialogC3265l.m11490a(this.f2581d, null, this.f2581d.getResources().getString(R.string.buddy_list_progress_dialog_message), true);
            } else {
                this.f2585h.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m4076e() {
        if (this.f2581d != null && this.f2585h != null) {
            this.f2585h.dismiss();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }
}
