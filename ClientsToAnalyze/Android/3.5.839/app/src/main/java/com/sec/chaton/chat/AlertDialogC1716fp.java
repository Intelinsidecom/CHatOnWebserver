package com.sec.chaton.chat;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p057e.p058a.C2212z;
import com.sec.chaton.p057e.p059b.C2248i;
import com.sec.chaton.p057e.p059b.InterfaceC2243d;
import com.sec.chaton.p065io.entry.inner.Buddy;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.util.C4902w;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ClearableEditText;
import com.sec.widget.C5144ag;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ChatInfoMoreFragment.java */
/* renamed from: com.sec.chaton.chat.fp */
/* loaded from: classes.dex */
public class AlertDialogC1716fp extends AlertDialog {

    /* renamed from: a */
    public final String f6321a;

    /* renamed from: b */
    InterfaceC2243d f6322b;

    /* renamed from: c */
    final /* synthetic */ ChatInfoMoreFragment f6323c;

    /* renamed from: d */
    private ClearableEditText f6324d;

    /* renamed from: e */
    private Context f6325e;

    /* renamed from: f */
    private TextWatcher f6326f;

    /* renamed from: g */
    private Handler f6327g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlertDialogC1716fp(ChatInfoMoreFragment chatInfoMoreFragment, Context context) {
        super(context);
        this.f6323c = chatInfoMoreFragment;
        this.f6321a = AlertDialogC1716fp.class.getSimpleName();
        this.f6322b = new C1718fr(this);
        this.f6326f = new C1719fs(this);
        this.f6327g = new HandlerC1720ft(this);
        m8530a();
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        C4904y.m18639b("onCreate()", this.f6321a);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT < 14) {
            getButton(-1).setEnabled(false);
        } else {
            getButton(-2).setEnabled(false);
        }
        setIcon(0);
    }

    /* renamed from: a */
    private void m8530a() {
        int i = -1;
        int i2 = -2;
        this.f6325e = getContext();
        setTitle(this.f6325e.getString(R.string.buddy_group_list_newgroup_info));
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.buddy_group_layout, (ViewGroup) null);
        setView(viewInflate);
        this.f6324d = (ClearableEditText) viewInflate.findViewById(R.id.buddy_group_groupname_field);
        this.f6324d.setFilters(new InputFilter[]{new C4902w(this.f6325e, 30)});
        this.f6324d.m18659a(this.f6326f);
        C5144ag.m19710a(this.f6324d, new char[]{','}, R.string.buddy_group_profile_rename_not_allowed_character);
        getWindow().setSoftInputMode(4);
        if (Build.VERSION.SDK_INT < 11) {
            i2 = -1;
            i = -2;
        }
        setButton(i2, this.f6325e.getText(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1717fq(this));
        setButton(i, this.f6325e.getText(R.string.cancel), (DialogInterface.OnClickListener) null);
        setInverseBackgroundForced(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8533b() {
        String strReplace = this.f6324d.m18658a().toString().trim().replace(",", "");
        this.f6324d.setText(strReplace);
        if (strReplace.length() > 0) {
            if (Build.VERSION.SDK_INT < 14) {
                getButton(-1).setEnabled(false);
            } else {
                getButton(-2).setEnabled(false);
            }
            C2212z.m10068a(new C2212z(), 3, new C2248i(this.f6322b, strReplace, 3));
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }

    /* renamed from: a */
    public void m8536a(String str) throws Resources.NotFoundException {
        C4904y.m18639b("NEW GROUP NAME : " + str, this.f6321a);
        C4904y.m18639b("MEMBER COUNT  : " + this.f6323c.f5823h.size(), this.f6321a);
        C4904y.m18639b("BLOCK BUDDY COUNT  : " + this.f6323c.f5824i.size(), this.f6321a);
        if (this.f6323c.f5823h.size() - this.f6323c.f5824i.size() > 0) {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f6323c.f5823h.iterator();
            while (it.hasNext()) {
                C1106c c1106c = (C1106c) it.next();
                Iterator it2 = this.f6323c.f5824i.iterator();
                boolean z = false;
                while (it2.hasNext()) {
                    z = ((Buddy) it2.next()).value.equals(c1106c.m7046a()) ? true : z;
                }
                if (!z) {
                    arrayList.add(c1106c.m7046a());
                }
            }
            int iM10677a = C2471v.m10677a(GlobalApplication.m18732r());
            if (-3 == iM10677a || -2 == iM10677a) {
                C5179v.m19810a(this.f6325e, R.string.popup_no_network_connection, 0).show();
                return;
            }
            C4904y.m18639b("REQUEST BUDDY COUNT  : " + arrayList.size(), this.f6321a);
            new C2128i(this.f6327g).m9489a("group", false, (String) null, str, (String[]) arrayList.toArray(new String[arrayList.size()]), 325);
            this.f6323c.m8339c();
        }
    }
}
