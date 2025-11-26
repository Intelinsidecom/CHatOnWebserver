package com.sec.chaton.p020f;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.chat.ChatFragment;
import java.util.ArrayList;

/* compiled from: DialogMenu.java */
/* renamed from: com.sec.chaton.f.a */
/* loaded from: classes.dex */
public class DialogC0713a extends Dialog {

    /* renamed from: a */
    private C0715c f2670a;

    /* renamed from: b */
    private ChatFragment f2671b;

    /* renamed from: c */
    private Object f2672c;

    /* renamed from: d */
    private ArrayList f2673d;

    public DialogC0713a(ChatFragment chatFragment, Object obj, ArrayList arrayList) {
        super(chatFragment.getActivity(), R.style.InsertMenuDialogTheme);
        this.f2671b = chatFragment;
        this.f2672c = obj;
        this.f2673d = arrayList;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m3188b();
    }

    /* renamed from: b */
    private void m3188b() {
        setContentView(R.layout.chat_insert_gridview_menu);
        GridView gridView = (GridView) findViewById(R.id.gridViewMenu);
        if (this.f2673d != null) {
            this.f2670a = new C0715c(this.f2671b, this.f2672c, this.f2673d);
        }
        gridView.setAdapter((ListAdapter) this.f2670a);
        gridView.setOnItemClickListener(new C0714b(this));
    }

    /* renamed from: a */
    public void m3190a() {
        m3188b();
    }
}
