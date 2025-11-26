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

/* compiled from: TellFriendsWeiboActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.cs */
/* loaded from: classes.dex */
class C1418cs extends ArrayAdapter {

    /* renamed from: a */
    boolean f5293a;

    /* renamed from: b */
    boolean f5294b;

    /* renamed from: c */
    public ArrayList f5295c;

    /* renamed from: d */
    Context f5296d;

    /* renamed from: e */
    final /* synthetic */ TellFriendsWeiboActivity f5297e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1418cs(TellFriendsWeiboActivity tellFriendsWeiboActivity, Context context, int i, ArrayList arrayList, TellFriendsWeiboActivity tellFriendsWeiboActivity2) {
        super(context, i, arrayList);
        this.f5297e = tellFriendsWeiboActivity;
        this.f5293a = true;
        this.f5294b = true;
        this.f5295c = new ArrayList();
        this.f5296d = null;
        this.f5296d = context;
        this.f5295c = arrayList;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = ((LayoutInflater) this.f5296d.getSystemService("layout_inflater")).inflate(R.layout.layout_tell_friends_via_cell, (ViewGroup) null);
        C1416cq c1416cq = new C1416cq(this.f5297e, null);
        c1416cq.f5282a = (ImageView) viewInflate.findViewById(R.id.twitter_following_thumb);
        c1416cq.f5283b = (TextView) viewInflate.findViewById(R.id.twitter_followings_username);
        c1416cq.f5284c = (Button) viewInflate.findViewById(R.id.twitter_following_invite);
        C1417cr c1417cr = (C1417cr) this.f5295c.get(i);
        if (c1417cr.f5291f) {
            c1416cq.f5282a.setVisibility(4);
            c1416cq.f5283b.setVisibility(4);
            c1416cq.f5284c.setVisibility(4);
        } else {
            c1416cq.f5282a.setVisibility(0);
            c1416cq.f5283b.setVisibility(0);
            c1416cq.f5284c.setVisibility(0);
            if (i == 0 && !this.f5293a) {
                this.f5294b = false;
            }
            c1416cq.f5282a.setBackgroundDrawable(this.f5297e.getResources().getDrawable(R.drawable.contacts_default_image));
            if (!this.f5294b) {
                if (i > this.f5297e.f5062h.size() - 1) {
                    this.f5297e.f5062h.add(c1416cq);
                } else {
                    this.f5297e.f5062h.set(i, c1416cq);
                }
                if (c1417cr.f5287b != null) {
                    c1416cq.f5282a.setBackgroundDrawable(c1417cr.f5287b);
                }
            }
            if (c1417cr.f5289d != null) {
                c1416cq.f5283b.setText(c1417cr.f5289d);
            }
            c1416cq.f5284c.setTag(Integer.valueOf(i));
            c1416cq.f5284c.setOnClickListener(new ViewOnClickListenerC1419ct(this));
        }
        if (this.f5293a) {
            this.f5293a = false;
        }
        return viewInflate;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.f5295c.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1417cr getItem(int i) {
        return (C1417cr) this.f5295c.get(i);
    }

    /* renamed from: b */
    public void m5155b(int i) {
        this.f5297e.f5068n = i;
    }
}
