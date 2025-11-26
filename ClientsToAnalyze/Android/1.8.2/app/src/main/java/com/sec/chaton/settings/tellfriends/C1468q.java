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

/* compiled from: InviteFacebookActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.q */
/* loaded from: classes.dex */
class C1468q extends ArrayAdapter {

    /* renamed from: a */
    int f5376a;

    /* renamed from: b */
    ArrayList f5377b;

    /* renamed from: c */
    final /* synthetic */ InviteFacebookActivity f5378c;

    /* renamed from: d */
    private LayoutInflater f5379d;

    /* synthetic */ C1468q(InviteFacebookActivity inviteFacebookActivity, Context context, int i, ArrayList arrayList, C1461j c1461j) {
        this(inviteFacebookActivity, context, i, arrayList);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C1468q(InviteFacebookActivity inviteFacebookActivity, Context context, int i, ArrayList arrayList) {
        super(context, i, arrayList);
        this.f5378c = inviteFacebookActivity;
        this.f5376a = 0;
        this.f5379d = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f5377b = arrayList;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1471t c1471t;
        C1373ba c1373ba = (C1373ba) this.f5378c.f4957n.get(i);
        if (view == null) {
            View viewInflate = this.f5379d.inflate(R.layout.layout_tell_friends_via_cell, viewGroup, false);
            C1471t c1471t2 = new C1471t(this.f5378c, null);
            c1471t2.f5382a = viewInflate;
            c1471t2.f5383b = (ImageView) c1471t2.f5382a.findViewById(R.id.twitter_following_thumb);
            c1471t2.f5384c = (TextView) c1471t2.f5382a.findViewById(R.id.twitter_followings_username);
            c1471t2.f5385d = (Button) c1471t2.f5382a.findViewById(R.id.twitter_following_invite);
            c1471t2.f5385d.setTag(Integer.valueOf(i));
            c1471t2.f5385d.setOnClickListener(new ViewOnClickListenerC1469r(this));
            viewInflate.setTag(c1471t2);
            c1471t = c1471t2;
        } else {
            c1471t = (C1471t) view.getTag();
        }
        c1471t.f5383b.setBackgroundDrawable(this.f5378c.getResources().getDrawable(R.drawable.contacts_default_image));
        if (i == 0 && this.f5376a == 1) {
            this.f5378c.f4946b = false;
        }
        if (!this.f5378c.f4946b) {
            if (i > this.f5378c.f4958o.size() - 1) {
                this.f5378c.f4958o.add(c1471t);
            } else {
                this.f5378c.f4958o.set(i, c1471t);
            }
            if (c1373ba.f5205d != null) {
                c1471t.f5383b.setBackgroundDrawable(((C1373ba) this.f5377b.get(i)).f5205d);
            }
        }
        c1471t.f5384c.setText(((C1373ba) this.f5377b.get(i)).f5203b);
        c1471t.f5385d.setTag(Integer.valueOf(i));
        if (i == 0) {
            this.f5376a = 1;
        }
        return c1471t.f5382a;
    }
}
