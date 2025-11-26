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

/* compiled from: SetupSpamNumberList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.bd */
/* loaded from: classes.dex */
class C4000bd extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ SetupSpamNumberList f14441a;

    /* renamed from: b */
    private final LayoutInflater f14442b;

    /* renamed from: c */
    private final Activity f14443c;

    /* renamed from: d */
    private final ArrayList<C4017bu> f14444d;

    public C4000bd(SetupSpamNumberList setupSpamNumberList, Activity activity, ArrayList<C4017bu> arrayList) {
        this.f14441a = setupSpamNumberList;
        this.f14443c = activity;
        this.f14442b = LayoutInflater.from(this.f14443c);
        this.f14444d = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f14444d.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C4017bu getItem(int i) {
        return this.f14444d.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.f14444d.get(i).m15454a();
    }

    /* renamed from: a */
    private View m15418a(int i, View view, ViewGroup viewGroup) {
        C4005bi c4005bi = new C4005bi(this);
        C4017bu c4017bu = this.f14444d.get(i);
        if (c4017bu != null) {
            view = this.f14442b.inflate(R.layout.spamlist_delete_item, (ViewGroup) null);
            c4005bi.f14453a = (TextView) view.findViewById(R.id.autoreject_delete_item_contact_name);
            c4005bi.f14454b = (TextView) view.findViewById(R.id.autoreject_delete_item_text);
            c4005bi.f14456d = (CheckBox) view.findViewById(R.id.delete_checkbox);
            c4005bi.f14456d.setFocusable(false);
            c4005bi.f14455c = (TextView) view.findViewById(R.id.autoreject_delete_text_sub);
            if (c4005bi.f14453a != null) {
                c4005bi.f14453a.setText(c4017bu.m15460e());
            }
            c4005bi.f14454b.setText(c4017bu.m15458c());
            if (c4017bu.m15459d() == 0) {
                c4005bi.f14455c.setText(R.string.Dialog_ExactlyTheSameAs);
            } else if (c4017bu.m15459d() == 1) {
                c4005bi.f14455c.setText(R.string.Dialog_StartWith);
            } else if (c4017bu.m15459d() == 2) {
                c4005bi.f14455c.setText(R.string.Dialog_EndsWith);
            } else if (c4017bu.m15459d() == 3) {
                c4005bi.f14455c.setText(R.string.Dialog_Includes);
            }
        }
        return view;
    }

    /* renamed from: b */
    private View m15419b(int i, View view, ViewGroup viewGroup) {
        View view2;
        C4005bi c4005bi = new C4005bi(this);
        this.f14441a.m15378c("autoreject idx : " + i + " rejectNum = " + this.f14444d.get(i).m15458c());
        C4017bu c4017bu = this.f14444d.get(i);
        if (c4017bu == null) {
            return view;
        }
        if (i == 0 && C3847e.m14672ad()) {
            View viewInflate = this.f14442b.inflate(R.layout.spam_unknown, (ViewGroup) null);
            c4005bi.f14454b = (TextView) viewInflate.findViewById(R.id.autoreject_item_text);
            c4005bi.f14457e = (LinearLayout) viewInflate.findViewById(R.id.autoreject_item);
            c4005bi.f14456d = (CheckBox) viewInflate.findViewById(R.id.autoreject_item_checkbox);
            c4005bi.f14456d.setOnClickListener(new ViewOnClickListenerC4001be(this, c4017bu));
            c4005bi.f14457e.setOnClickListener(new ViewOnClickListenerC4002bf(this, c4017bu));
            view2 = viewInflate;
        } else {
            View viewInflate2 = this.f14442b.inflate(R.layout.spamitem, (ViewGroup) null);
            c4005bi.f14453a = (TextView) viewInflate2.findViewById(R.id.autoreject_item_contact_name);
            c4005bi.f14454b = (TextView) viewInflate2.findViewById(R.id.autoreject_item_text);
            c4005bi.f14455c = (TextView) viewInflate2.findViewById(R.id.text_sub);
            c4005bi.f14456d = (CheckBox) viewInflate2.findViewById(R.id.autoreject_item_checkbox);
            c4005bi.f14457e = (LinearLayout) viewInflate2.findViewById(R.id.autoreject_text_layout);
            if (C3847e.m14672ad()) {
                c4005bi.f14456d.setOnClickListener(new ViewOnClickListenerC4003bg(this, c4017bu));
            } else {
                ((LinearLayout) viewInflate2.findViewById(R.id.autoreject_checkbox_layer)).setVisibility(8);
            }
            c4005bi.f14457e.setOnClickListener(new ViewOnClickListenerC4004bh(this, c4017bu));
            view2 = viewInflate2;
        }
        if (c4005bi.f14453a != null) {
            c4005bi.f14453a.setText(c4017bu.m15460e());
        }
        c4005bi.f14454b.setText(c4017bu.m15458c());
        if (i != 0 || (i == 0 && !C3847e.m14672ad())) {
            if (c4017bu.m15459d() == 0) {
                c4005bi.f14455c.setText(R.string.Dialog_ExactlyTheSameAs);
            } else if (c4017bu.m15459d() == 1) {
                c4005bi.f14455c.setText(R.string.Dialog_StartWith);
            } else if (c4017bu.m15459d() == 2) {
                c4005bi.f14455c.setText(R.string.Dialog_EndsWith);
            } else if (c4017bu.m15459d() == 3) {
                c4005bi.f14455c.setText(R.string.Dialog_Includes);
            }
        }
        this.f14441a.m15378c("mScreenType " + this.f14441a.f14370u + "position = " + i + " checked = " + c4017bu.m15457b());
        c4005bi.f14456d.setChecked(c4017bu.m15457b());
        return view2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.f14441a.f14370u == 0) {
            return m15419b(i, view, viewGroup);
        }
        return m15418a(i, view, viewGroup);
    }
}
