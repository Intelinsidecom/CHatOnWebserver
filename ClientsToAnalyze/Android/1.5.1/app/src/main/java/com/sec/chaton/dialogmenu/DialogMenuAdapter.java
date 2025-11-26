package com.sec.chaton.dialogmenu;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import com.sec.chaton.chat.ChatFragment;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class DialogMenuAdapter extends BaseAdapter {

    /* renamed from: a */
    public static Object f1827a;

    /* renamed from: b */
    public ChatFragment f1828b;

    /* renamed from: c */
    private final LayoutInflater f1829c;

    /* renamed from: d */
    private ArrayList f1830d;

    public DialogMenuAdapter(ChatFragment chatFragment, Object obj, ArrayList arrayList) {
        this.f1830d = new ArrayList();
        this.f1828b = chatFragment;
        this.f1829c = (LayoutInflater) this.f1828b.getActivity().getSystemService("layout_inflater");
        this.f1828b.getResources();
        this.f1830d = arrayList;
        f1827a = obj;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f1830d.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f1830d.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ListItem listItem = (ListItem) getItem(i);
        View viewInflate = view == null ? this.f1829c.inflate(C0062R.layout.item_dialog_menu, viewGroup, false) : view;
        TextView textView = (TextView) viewInflate;
        textView.setTag(listItem);
        textView.setText(listItem.f1831a);
        textView.setCompoundDrawablesWithIntrinsicBounds(listItem.f1832b, (Drawable) null, (Drawable) null, (Drawable) null);
        return viewInflate;
    }
}
