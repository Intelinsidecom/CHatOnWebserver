package com.sec.chaton.smsplugin.p103c;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import java.util.ArrayList;

/* compiled from: MmsDialogMenu.java */
/* renamed from: com.sec.chaton.smsplugin.c.a */
/* loaded from: classes.dex */
public class DialogC3806a extends Dialog {

    /* renamed from: a */
    final boolean f13665a;

    /* renamed from: b */
    private C3808c f13666b;

    /* renamed from: c */
    private ArrayList<C3809d> f13667c;

    /* renamed from: d */
    private Context f13668d;

    public DialogC3806a(Context context, ArrayList<C3809d> arrayList, boolean z) {
        super(context, R.style.AppTheme_Dialog);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.f13668d = context;
        this.f13667c = arrayList;
        this.f13665a = z;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m14479a();
    }

    /* renamed from: a */
    private void m14479a() {
        setContentView(R.layout.chat_insert_gridview_menu);
        GridView gridView = (GridView) findViewById(R.id.gridViewMenu);
        if (this.f13667c != null) {
            this.f13666b = new C3808c(this.f13668d, this.f13667c);
        }
        gridView.setAdapter((ListAdapter) this.f13666b);
        gridView.setOnItemClickListener(new C3807b(this));
    }
}
