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
import android.widget.ImageButton;
import com.sec.chaton.R;
import com.sec.chaton.p057e.p058a.C2212z;
import com.sec.chaton.p057e.p059b.C2248i;
import com.sec.chaton.p057e.p059b.InterfaceC2243d;
import com.sec.chaton.util.C4902w;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.InterfaceC4850bo;
import com.sec.chaton.widget.ClearableEditText;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.widget.C5144ag;
import com.sec.widget.C5179v;

/* compiled from: BuddyGroupDialog.java */
/* renamed from: com.sec.chaton.buddy.dw */
/* loaded from: classes.dex */
public class AlertDialogC1262dw extends AlertDialog {

    /* renamed from: a */
    public static final String f4782a = AlertDialogC1262dw.class.getSimpleName();

    /* renamed from: b */
    InterfaceC2243d f4783b;

    /* renamed from: c */
    InterfaceC2243d f4784c;

    /* renamed from: d */
    private FragmentActivity f4785d;

    /* renamed from: e */
    private String f4786e;

    /* renamed from: f */
    private String[] f4787f;

    /* renamed from: g */
    private BuddyFragment f4788g;

    /* renamed from: h */
    private ProgressDialog f4789h;

    /* renamed from: i */
    private boolean f4790i;

    /* renamed from: j */
    private ClearableEditText f4791j;

    /* renamed from: k */
    private Context f4792k;

    /* renamed from: l */
    private InterfaceC4850bo f4793l;

    /* renamed from: m */
    private Handler f4794m;

    /* renamed from: n */
    private TextWatcher f4795n;

    /* renamed from: a */
    public void m7435a(boolean z) {
        this.f4790i = z;
    }

    public AlertDialogC1262dw(Context context, BuddyFragment buddyFragment) {
        super(context);
        this.f4789h = null;
        this.f4790i = false;
        this.f4793l = new C1263dx(this);
        this.f4783b = new C1267ea(this);
        this.f4794m = new HandlerC1269ec(this);
        this.f4784c = new C1271ee(this);
        this.f4795n = new C1272ef(this);
        this.f4785d = (FragmentActivity) context;
        this.f4788g = buddyFragment;
        this.f4787f = this.f4788g.m6604g();
        m7419a();
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        C4904y.m18639b("onCreate()", f4782a);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT < 14) {
            getButton(-1).setEnabled(false);
        } else {
            getButton(-2).setEnabled(false);
        }
        setIcon(0);
    }

    /* renamed from: a */
    private void m7419a() {
        int i = -1;
        int i2 = -2;
        this.f4792k = getContext();
        setTitle(this.f4792k.getString(R.string.buddy_group_list_newgroup_info));
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.buddy_group_layout, (ViewGroup) null);
        setView(viewInflate);
        this.f4791j = (ClearableEditText) viewInflate.findViewById(R.id.buddy_group_groupname_field);
        this.f4791j.setSearchIcon(0);
        ((ImageButton) this.f4791j.findViewById(R.id.clearable_button1)).setContentDescription(this.f4785d.getResources().getString(R.string.clear_query_button));
        this.f4791j.setFilters(new InputFilter[]{new C4902w(this.f4792k, 30)});
        this.f4791j.m18659a(this.f4795n);
        C5144ag.m19710a(this.f4791j, new char[]{','}, R.string.buddy_group_profile_rename_not_allowed_character);
        this.f4791j.setOnEditorActionListener(new C1264dy(this));
        getWindow().setSoftInputMode(5);
        if (Build.VERSION.SDK_INT < 11) {
            i2 = -1;
            i = -2;
        }
        setButton(i2, this.f4792k.getText(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1265dz(this));
        setButton(i, this.f4792k.getText(R.string.cancel), (DialogInterface.OnClickListener) null);
        setInverseBackgroundForced(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m7420b() {
        String strReplace = this.f4791j.m18658a().toString().trim().replace(",", "");
        if (!strReplace.toUpperCase().equals("FAVORITES")) {
            return false;
        }
        C5179v.m19811a(this.f4792k, this.f4792k.getString(R.string.buddy_group_list_addgroup_toast_exist, strReplace), 0).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m7423c() {
        C2248i c2248i;
        this.f4786e = this.f4791j.m18658a().toString().trim().replace(",", "");
        if (this.f4786e.length() > 0) {
            if (Build.VERSION.SDK_INT < 14) {
                getButton(-1).setEnabled(false);
            } else {
                getButton(-2).setEnabled(false);
            }
            if (this.f4787f != null && this.f4787f.length > 0) {
                c2248i = new C2248i(this.f4783b, this.f4786e, this.f4787f, 3);
            } else {
                c2248i = new C2248i(this.f4783b, this.f4786e, 3);
            }
            C2212z.m10068a(new C2212z(), 3, c2248i);
            if (this.f4787f != null && this.f4787f.length > 0) {
                m7424d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m7424d() {
        if (this.f4785d != null) {
            if (this.f4789h == null) {
                this.f4789h = ProgressDialogC4926s.m18728a(this.f4785d, null, this.f4785d.getResources().getString(R.string.buddy_list_progress_dialog_message), true);
            } else {
                this.f4789h.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m7426e() {
        if (this.f4785d != null && this.f4789h != null) {
            this.f4789h.dismiss();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }
}
