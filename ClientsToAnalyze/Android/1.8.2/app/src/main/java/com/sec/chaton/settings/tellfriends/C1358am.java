package com.sec.chaton.settings.tellfriends;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import java.util.ArrayList;

/* compiled from: SnsFriendsUsingChatOnActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.am */
/* loaded from: classes.dex */
public class C1358am extends ArrayAdapter {

    /* renamed from: a */
    final /* synthetic */ SnsFriendsUsingChatOnActivity f5176a;

    /* renamed from: b */
    private final Context f5177b;

    /* renamed from: c */
    private final ArrayList f5178c;

    /* renamed from: d */
    private final LayoutInflater f5179d;

    /* renamed from: e */
    private final int f5180e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1358am(SnsFriendsUsingChatOnActivity snsFriendsUsingChatOnActivity, Context context, int i, ArrayList arrayList) {
        super(context, i, arrayList);
        this.f5176a = snsFriendsUsingChatOnActivity;
        this.f5177b = context;
        this.f5178c = arrayList;
        this.f5180e = i;
        this.f5179d = LayoutInflater.from(this.f5177b);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1364as c1364as;
        if (view == null) {
            view = this.f5179d.inflate(this.f5180e, viewGroup, false);
            c1364as = new C1364as(this.f5176a);
            c1364as.f5195b = (TextView) view.findViewById(R.id.listItemText1);
            c1364as.f5194a = (ImageView) view.findViewById(R.id.listItemImage);
            c1364as.f5196c = (Button) view.findViewById(R.id.listItemButton);
            view.setTag(c1364as);
        } else {
            c1364as = (C1364as) view.getTag();
        }
        c1364as.f5195b.setText(((C1342a) this.f5178c.get(i)).m5068b());
        this.f5176a.f4992j.m5145a(((C1342a) this.f5178c.get(i)).m5070d(), c1364as.f5194a);
        c1364as.f5196c.setTag(Integer.valueOf(i));
        c1364as.f5196c.setOnClickListener(new ViewOnClickListenerC1359an(this, i));
        return view;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.f5178c.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1342a getItem(int i) {
        return (C1342a) this.f5178c.get(i);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
