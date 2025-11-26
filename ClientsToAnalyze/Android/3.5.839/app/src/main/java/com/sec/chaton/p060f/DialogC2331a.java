package com.sec.chaton.p060f;

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
public class DialogC2331a extends Dialog {

    /* renamed from: a */
    private C2333c f8284a;

    /* renamed from: b */
    private ChatFragment f8285b;

    /* renamed from: c */
    private ArrayList<C2337g> f8286c;

    public DialogC2331a(ChatFragment chatFragment, ArrayList<C2337g> arrayList) {
        super(chatFragment.getActivity(), R.style.AppTheme_Dialog_Alert);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.f8285b = chatFragment;
        this.f8286c = arrayList;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m10252a();
    }

    /* renamed from: a */
    private void m10252a() {
        setContentView(R.layout.chat_insert_gridview_menu);
        GridView gridView = (GridView) findViewById(R.id.gridViewMenu);
        if (this.f8286c != null) {
            this.f8284a = new C2333c(this.f8285b, this.f8286c);
        }
        gridView.setAdapter((ListAdapter) this.f8284a);
        gridView.setOnItemClickListener(new C2332b(this));
    }
}
