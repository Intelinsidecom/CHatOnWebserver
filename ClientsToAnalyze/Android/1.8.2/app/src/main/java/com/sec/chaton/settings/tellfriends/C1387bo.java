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

/* compiled from: TWFollowingsListActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bo */
/* loaded from: classes.dex */
class C1387bo extends ArrayAdapter {

    /* renamed from: a */
    boolean f5234a;

    /* renamed from: b */
    boolean f5235b;

    /* renamed from: c */
    public ArrayList f5236c;

    /* renamed from: d */
    Context f5237d;

    /* renamed from: e */
    final /* synthetic */ TWFollowingsListActivity f5238e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1387bo(TWFollowingsListActivity tWFollowingsListActivity, Context context, int i, ArrayList arrayList, TWFollowingsListActivity tWFollowingsListActivity2) {
        super(context, i, arrayList);
        this.f5238e = tWFollowingsListActivity;
        this.f5234a = true;
        this.f5235b = true;
        this.f5236c = new ArrayList();
        this.f5237d = null;
        this.f5237d = context;
        this.f5236c = arrayList;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = ((LayoutInflater) this.f5237d.getSystemService("layout_inflater")).inflate(R.layout.layout_tell_friends_via_cell, (ViewGroup) null);
        C1390br c1390br = new C1390br(this.f5238e, null);
        c1390br.f5241a = (ImageView) viewInflate.findViewById(R.id.twitter_following_thumb);
        c1390br.f5242b = (TextView) viewInflate.findViewById(R.id.twitter_followings_username);
        c1390br.f5243c = (Button) viewInflate.findViewById(R.id.twitter_following_invite);
        C1383bk c1383bk = (C1383bk) this.f5236c.get(i);
        if (c1383bk.f5227e) {
            c1390br.f5241a.setVisibility(4);
            c1390br.f5242b.setVisibility(4);
            c1390br.f5243c.setVisibility(4);
        } else {
            c1390br.f5241a.setVisibility(0);
            c1390br.f5242b.setVisibility(0);
            c1390br.f5243c.setVisibility(0);
            if (i == 0 && !this.f5234a) {
                this.f5235b = false;
            }
            c1390br.f5241a.setBackgroundDrawable(this.f5238e.getResources().getDrawable(R.drawable.contacts_default_image));
            if (!this.f5235b) {
                if (i > this.f5238e.f5021h.size() - 1) {
                    this.f5238e.f5021h.add(c1390br);
                } else {
                    this.f5238e.f5021h.set(i, c1390br);
                }
                if (c1383bk.f5223a != null) {
                    c1390br.f5241a.setBackgroundDrawable(c1383bk.f5223a);
                }
            }
            if (c1383bk.f5225c != null) {
                c1390br.f5242b.setText(c1383bk.f5225c);
            }
            c1390br.f5243c.setTag(Integer.valueOf(i));
            c1390br.f5243c.setOnClickListener(new ViewOnClickListenerC1388bp(this));
        }
        if (this.f5234a) {
            this.f5234a = false;
        }
        return viewInflate;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.f5236c.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1383bk getItem(int i) {
        return (C1383bk) this.f5236c.get(i);
    }

    /* renamed from: b */
    public void m5130b(int i) {
        this.f5238e.f5026m = i;
    }
}
