package com.sec.chaton.p031h;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.chat.ChatFragment;
import java.util.ArrayList;

/* compiled from: DialogMenu.java */
/* renamed from: com.sec.chaton.h.a */
/* loaded from: classes.dex */
public class DialogC0716a extends Dialog {

    /* renamed from: a */
    private C0718c f2430a;

    /* renamed from: b */
    private ChatFragment f2431b;

    /* renamed from: c */
    private Object f2432c;

    /* renamed from: d */
    private ArrayList f2433d;

    public DialogC0716a(ChatFragment chatFragment, Object obj, ArrayList arrayList) {
        super(chatFragment.getActivity(), R.style.InsertMenuDialogTheme);
        this.f2431b = chatFragment;
        this.f2432c = obj;
        this.f2433d = arrayList;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m3113a();
    }

    public DialogC0716a(Context context) {
        super(context);
    }

    /* renamed from: a */
    private void m3113a() {
        setContentView(R.layout.chat_insert_gridview_menu);
        setTitle(R.string.menu_chat_insert);
        GridView gridView = (GridView) findViewById(R.id.gridViewMenu);
        if (this.f2433d != null) {
            this.f2430a = new C0718c(this.f2431b, this.f2432c, this.f2433d);
        }
        gridView.setAdapter((ListAdapter) this.f2430a);
        gridView.setOnItemClickListener(new C0719d(this));
    }
}
