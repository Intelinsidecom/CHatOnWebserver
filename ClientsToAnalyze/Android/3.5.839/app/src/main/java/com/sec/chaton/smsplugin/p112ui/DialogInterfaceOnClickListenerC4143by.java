package com.sec.chaton.smsplugin.p112ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.CheckBox;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p110g.C3855a;
import java.io.File;
import java.util.ArrayList;

/* compiled from: MessageOptions.java */
/* renamed from: com.sec.chaton.smsplugin.ui.by */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4143by implements DialogInterface.OnClickListener {

    /* renamed from: a */
    boolean f15423a;

    /* renamed from: b */
    final /* synthetic */ C4132bn f15424b;

    DialogInterfaceOnClickListenerC4143by(C4132bn c4132bn, Context context, boolean z, long j) {
        this.f15424b = c4132bn;
        this.f15423a = z;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ListView listView = ((AlertDialog) dialogInterface).getListView();
        if (listView != null) {
            ViewOnClickListenerC4172d viewOnClickListenerC4172d = (ViewOnClickListenerC4172d) listView.getAdapter();
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= listView.getCount()) {
                    break;
                }
                if (((CheckBox) viewOnClickListenerC4172d.getView(i3, null, null).findViewById(R.id.selected)).isChecked()) {
                    C3855a c3855a = (C3855a) listView.getItemAtPosition(i3);
                    if (this.f15423a && c3855a != null) {
                        String strM16445n = C4149cd.m16445n(c3855a.m14748d());
                        if (new File(C4132bn.f15385w.concat(strM16445n)).exists()) {
                            this.f15424b.f15393m.add(c3855a);
                            this.f15424b.f15392l.add(strM16445n);
                        } else {
                            arrayList.add(c3855a);
                        }
                    }
                }
                i2 = i3 + 1;
            }
            if (this.f15423a) {
                if (!arrayList.isEmpty()) {
                    this.f15424b.m16364a((ArrayList<C3855a>) arrayList, this.f15424b.f15395o);
                }
                if (!this.f15424b.f15392l.isEmpty()) {
                    this.f15424b.m16357a(this.f15424b.f15386b);
                }
            }
        }
    }
}
