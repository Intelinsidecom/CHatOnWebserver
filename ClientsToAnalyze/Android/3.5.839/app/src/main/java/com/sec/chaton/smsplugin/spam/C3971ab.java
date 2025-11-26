package com.sec.chaton.smsplugin.spam;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.C3847e;
import java.util.ArrayList;

/* compiled from: SetupSpamKeywordList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.ab */
/* loaded from: classes.dex */
class C3971ab extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ SetupSpamKeywordList f14402a;

    /* renamed from: b */
    private LayoutInflater f14403b;

    /* renamed from: c */
    private Activity f14404c;

    /* renamed from: d */
    private ArrayList<C4017bu> f14405d;

    public C3971ab(SetupSpamKeywordList setupSpamKeywordList, Activity activity, ArrayList<C4017bu> arrayList) {
        this.f14402a = setupSpamKeywordList;
        this.f14404c = activity;
        this.f14403b = LayoutInflater.from(this.f14404c);
        this.f14405d = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f14405d.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C4017bu getItem(int i) {
        return this.f14405d.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.f14405d.get(i).m15454a();
    }

    /* renamed from: a */
    private View m15415a(int i, View view, ViewGroup viewGroup) {
        C3975af c3975af = new C3975af(this);
        C4017bu c4017bu = this.f14405d.get(i);
        if (c4017bu != null) {
            View viewInflate = this.f14403b.inflate(R.layout.spamlist_delete_item, (ViewGroup) null);
            c3975af.f14412a = (TextView) viewInflate.findViewById(R.id.autoreject_delete_item_text);
            c3975af.f14413b = (CheckBox) viewInflate.findViewById(R.id.delete_checkbox);
            c3975af.f14413b.setFocusable(false);
            c3975af.f14412a.setText(c4017bu.m15458c());
            return viewInflate;
        }
        return view;
    }

    /* renamed from: b */
    private View m15416b(int i, View view, ViewGroup viewGroup) {
        C3975af c3975af = new C3975af(this);
        this.f14402a.m15329b("Spamkeyword idx : " + i + " filter = " + this.f14405d.get(i).m15458c());
        C4017bu c4017bu = this.f14405d.get(i);
        if (c4017bu != null) {
            view = this.f14403b.inflate(R.layout.spamitem, (ViewGroup) null);
            c3975af.f14412a = (TextView) view.findViewById(R.id.autoreject_item_text);
            c3975af.f14413b = (CheckBox) view.findViewById(R.id.autoreject_item_checkbox);
            c3975af.f14414c = (LinearLayout) view.findViewById(R.id.autoreject_text_layout);
            if (C3847e.m14672ad()) {
                c3975af.f14413b.setOnClickListener(new ViewOnClickListenerC3972ac(this, c4017bu));
            } else {
                view.findViewById(R.id.divider1).setVisibility(8);
                ((LinearLayout) view.findViewById(R.id.autoreject_checkbox_layer)).setVisibility(8);
            }
            c3975af.f14414c.setOnClickListener(new ViewOnClickListenerC3973ad(this, c4017bu));
            c3975af.f14414c.setOnLongClickListener(new ViewOnLongClickListenerC3974ae(this, c4017bu));
            c3975af.f14412a.setText(c4017bu.m15458c());
            this.f14402a.m15329b("mScreenType " + this.f14402a.f14305f + "position = " + i + " checked = " + c4017bu.m15457b());
            c3975af.f14413b.setChecked(c4017bu.m15457b());
        }
        return view;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.f14402a.f14305f == 0) {
            return m15416b(i, view, viewGroup);
        }
        return m15415a(i, view, viewGroup);
    }
}
