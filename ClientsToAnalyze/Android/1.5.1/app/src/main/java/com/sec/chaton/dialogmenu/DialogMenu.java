package com.sec.chaton.dialogmenu;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import com.sec.chaton.C0062R;
import com.sec.chaton.chat.ChatFragment;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class DialogMenu implements DialogInterface.OnClickListener {

    /* renamed from: a */
    AlertDialog f1822a;

    /* renamed from: b */
    private DialogMenuAdapter f1823b;

    /* renamed from: c */
    private ChatFragment f1824c;

    /* renamed from: d */
    private Object f1825d;

    /* renamed from: e */
    private ArrayList f1826e;

    public DialogMenu(ChatFragment chatFragment, Object obj, ArrayList arrayList) {
        this.f1824c = chatFragment;
        this.f1825d = obj;
        this.f1826e = arrayList;
    }

    /* renamed from: a */
    public Dialog m2339a() {
        if (this.f1826e != null) {
            this.f1823b = new DialogMenuAdapter(this.f1824c, this.f1825d, this.f1826e);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f1824c.getActivity());
        builder.setTitle(C0062R.string.menu_chat_insert);
        builder.setAdapter(this.f1823b, this);
        builder.setInverseBackgroundForced(true);
        this.f1822a = builder.create();
        return this.f1822a;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1824c.mo767a(this.f1825d, ((ListItem) this.f1822a.getListView().getAdapter().getItem(i)).f1833c);
    }
}
