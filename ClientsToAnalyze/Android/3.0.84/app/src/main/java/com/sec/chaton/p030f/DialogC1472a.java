package com.sec.chaton.p030f;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.chat.ChatFragment;
import java.util.ArrayList;

/* compiled from: DialogMenu.java */
/* renamed from: com.sec.chaton.f.a */
/* loaded from: classes.dex */
public class DialogC1472a extends Dialog {

    /* renamed from: a */
    private C1474c f5450a;

    /* renamed from: b */
    private ChatFragment f5451b;

    /* renamed from: c */
    private ArrayList<C1478g> f5452c;

    public DialogC1472a(ChatFragment chatFragment, ArrayList<C1478g> arrayList) {
        super(chatFragment.getActivity(), R.style.AppTheme_Dialog);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.f5451b = chatFragment;
        this.f5452c = arrayList;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m6409a();
    }

    /* renamed from: a */
    private void m6409a() {
        setContentView(R.layout.chat_insert_gridview_menu);
        GridView gridView = (GridView) findViewById(R.id.gridViewMenu);
        if (this.f5452c != null) {
            this.f5450a = new C1474c(this.f5451b, this.f5452c);
        }
        gridView.setAdapter((ListAdapter) this.f5450a);
        gridView.setOnItemClickListener(new C1473b(this));
    }
}
