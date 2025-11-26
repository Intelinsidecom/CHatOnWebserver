package com.sec.chaton.chat;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p027e.p028a.C1379w;
import com.sec.chaton.p027e.p029b.C1418i;
import com.sec.chaton.p027e.p029b.InterfaceC1413d;
import com.sec.chaton.p035io.entry.inner.Buddy;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ClearableEditText;
import com.sec.widget.C3641ai;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ChatInfoMoreFragment.java */
/* renamed from: com.sec.chaton.chat.eb */
/* loaded from: classes.dex */
public class AlertDialogC1060eb extends AlertDialog {

    /* renamed from: a */
    public final String f4171a;

    /* renamed from: b */
    InterfaceC1413d f4172b;

    /* renamed from: c */
    final /* synthetic */ ChatInfoMoreFragment f4173c;

    /* renamed from: d */
    private FragmentActivity f4174d;

    /* renamed from: e */
    private ClearableEditText f4175e;

    /* renamed from: f */
    private Context f4176f;

    /* renamed from: g */
    private TextWatcher f4177g;

    /* renamed from: h */
    private Handler f4178h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlertDialogC1060eb(ChatInfoMoreFragment chatInfoMoreFragment, Context context) {
        super(context);
        this.f4173c = chatInfoMoreFragment;
        this.f4171a = AlertDialogC1060eb.class.getSimpleName();
        this.f4172b = new C1062ed(this);
        this.f4177g = new C1063ee(this);
        this.f4178h = new HandlerC1064ef(this);
        this.f4174d = (FragmentActivity) context;
        m5262a();
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        C3250y.m11458g("onCreate()", this.f4171a);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT < 14) {
            getButton(-1).setEnabled(false);
        } else {
            getButton(-2).setEnabled(false);
        }
        setIcon(0);
    }

    /* renamed from: a */
    private void m5262a() {
        int i = -1;
        int i2 = -2;
        this.f4176f = getContext();
        setTitle(this.f4176f.getString(R.string.buddy_group_list_newgroup_info));
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.buddy_group_layout, (ViewGroup) null);
        setView(viewInflate);
        this.f4175e = (ClearableEditText) viewInflate.findViewById(R.id.buddy_group_groupname_field);
        this.f4175e.setMaxLength(R.string.toast_text_max_Length);
        this.f4175e.m11464a(this.f4177g);
        getWindow().setSoftInputMode(4);
        if (Build.VERSION.SDK_INT < 11) {
            i2 = -1;
            i = -2;
        }
        setButton(i2, this.f4176f.getText(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1061ec(this));
        setButton(i, this.f4176f.getText(R.string.cancel), (DialogInterface.OnClickListener) null);
        setInverseBackgroundForced(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m5265b() {
        String strReplace = this.f4175e.m11463a().toString().trim().replace(",", "");
        this.f4175e.setText(strReplace);
        if (strReplace.length() > 0) {
            if (Build.VERSION.SDK_INT < 14) {
                getButton(-1).setEnabled(false);
            } else {
                getButton(-2).setEnabled(false);
            }
            C1379w.m6203a(new C1379w(), 3, new C1418i(this.f4172b, strReplace, 3));
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }

    /* renamed from: a */
    public void m5269a(String str) {
        C3250y.m11458g("NEW GROUP NAME : " + str, this.f4171a);
        C3250y.m11458g("MEMBER COUNT  : " + this.f4173c.f3767i.size(), this.f4171a);
        C3250y.m11458g("BLOCK BUDDY COUNT  : " + this.f4173c.f3768j.size(), this.f4171a);
        if (this.f4173c.f3767i.size() - this.f4173c.f3768j.size() > 0) {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f4173c.f3767i.iterator();
            while (it.hasNext()) {
                C0513c c0513c = (C0513c) it.next();
                Iterator it2 = this.f4173c.f3768j.iterator();
                boolean z = false;
                while (it2.hasNext()) {
                    z = ((Buddy) it2.next()).value.equals(c0513c.m3975b()) ? true : z;
                }
                if (!z) {
                    arrayList.add(c0513c.m3975b());
                }
            }
            int iM6733a = C1594v.m6733a(GlobalApplication.m11493l());
            if (-3 == iM6733a || -2 == iM6733a) {
                C3641ai.m13210a(this.f4176f, R.string.popup_no_network_connection, 0).show();
                return;
            }
            C3250y.m11458g("REQUEST BUDDY COUNT  : " + arrayList.size(), this.f4171a);
            new C1330h(this.f4178h).m5716a("group", false, (String) null, str, (String[]) arrayList.toArray(new String[arrayList.size()]), 325);
            this.f4173c.m5071c();
        }
    }
}
