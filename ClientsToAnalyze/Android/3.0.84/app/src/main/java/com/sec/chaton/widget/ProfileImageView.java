package com.sec.chaton.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.EnumC3208bw;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ProfileImageView extends ImageView {

    /* renamed from: a */
    int f11757a;

    /* renamed from: b */
    ArrayList<C0513c> f11758b;

    /* renamed from: c */
    private Context f11759c;

    /* renamed from: d */
    private String f11760d;

    /* renamed from: e */
    private String f11761e;

    /* renamed from: f */
    private View.OnClickListener f11762f;

    /* renamed from: g */
    private View.OnClickListener f11763g;

    public ProfileImageView(Context context) {
        super(context);
        this.f11761e = null;
        this.f11757a = 0;
        this.f11758b = new ArrayList<>();
        this.f11762f = new ViewOnClickListenerC3260g(this);
        this.f11763g = new ViewOnClickListenerC3261h(this);
        this.f11759c = context;
    }

    public ProfileImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11761e = null;
        this.f11757a = 0;
        this.f11758b = new ArrayList<>();
        this.f11762f = new ViewOnClickListenerC3260g(this);
        this.f11763g = new ViewOnClickListenerC3261h(this);
        this.f11759c = context;
    }

    public ProfileImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11761e = null;
        this.f11757a = 0;
        this.f11758b = new ArrayList<>();
        this.f11762f = new ViewOnClickListenerC3260g(this);
        this.f11763g = new ViewOnClickListenerC3261h(this);
        this.f11759c = context;
    }

    public void setBuddyNo(String str) {
        this.f11760d = str;
    }

    public void setBuddyName(String str) {
        this.f11761e = str;
    }

    /* renamed from: a */
    public void m11473a(View view, EnumC1450r enumC1450r) {
        switch (enumC1450r) {
            case ONETOONE:
                C3205bt.m11182a(getContext()).m11209a((ImageView) view, EnumC3208bw.BUDDY);
                setOnClickListener(this.f11763g);
                break;
            case GROUPCHAT:
                C3205bt.m11182a(getContext()).m11209a((ImageView) view, EnumC3208bw.GROUP);
                setOnClickListener(this.f11762f);
                break;
            case BROADCAST:
            case BROADCAST2:
                C3205bt.m11182a(getContext()).m11209a((ImageView) view, EnumC3208bw.BROADCAST);
                setOnClickListener(this.f11762f);
                break;
        }
    }
}
