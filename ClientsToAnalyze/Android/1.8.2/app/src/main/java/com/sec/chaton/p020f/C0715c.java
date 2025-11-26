package com.sec.chaton.p020f;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.chat.ChatFragment;
import java.util.ArrayList;

/* compiled from: DialogMenuAdapter.java */
/* renamed from: com.sec.chaton.f.c */
/* loaded from: classes.dex */
public class C0715c extends BaseAdapter {

    /* renamed from: a */
    public static Object f2675a;

    /* renamed from: b */
    public ChatFragment f2676b;

    /* renamed from: c */
    private final LayoutInflater f2677c;

    /* renamed from: d */
    private ArrayList f2678d;

    public C0715c(ChatFragment chatFragment, Object obj, ArrayList arrayList) {
        this.f2678d = new ArrayList();
        this.f2676b = chatFragment;
        this.f2677c = (LayoutInflater) this.f2676b.getActivity().getSystemService("layout_inflater");
        this.f2676b.getResources();
        this.f2678d = arrayList;
        f2675a = obj;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0719g c0719g = (C0719g) getItem(i);
        if (view == null) {
            view = this.f2677c.inflate(R.layout.item_dialog_menu, viewGroup, false);
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.insertLayout);
        linearLayout.setOnClickListener(new ViewOnClickListenerC0716d(this, c0719g));
        linearLayout.setOnKeyListener(new ViewOnKeyListenerC0717e(this, c0719g));
        ((ImageView) view.findViewById(R.id.insertMenuIcon)).setImageDrawable(c0719g.f2684b);
        TextView textView = (TextView) view.findViewById(R.id.insertMenuText);
        if (Build.VERSION.SDK_INT < 14) {
            textView.setTextSize(16.0f);
        }
        if (this.f2676b.getActivity() != null) {
            textView.setText(this.f2676b.getResources().getString(c0719g.f2683a));
        }
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f2678d.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f2678d.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
