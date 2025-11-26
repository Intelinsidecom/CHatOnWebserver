package com.sec.chaton.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.util.C4855bt;
import com.sec.chaton.util.EnumC4857bv;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ProfileImageView extends ImageView {

    /* renamed from: a */
    int f17920a;

    /* renamed from: b */
    ArrayList<C1106c> f17921b;

    /* renamed from: c */
    private Context f17922c;

    /* renamed from: d */
    private String f17923d;

    /* renamed from: e */
    private String f17924e;

    /* renamed from: f */
    private View.OnClickListener f17925f;

    /* renamed from: g */
    private View.OnClickListener f17926g;

    public ProfileImageView(Context context) {
        super(context);
        this.f17924e = null;
        this.f17920a = 0;
        this.f17921b = new ArrayList<>();
        this.f17925f = new ViewOnClickListenerC4920m(this);
        this.f17926g = new ViewOnClickListenerC4921n(this);
        this.f17922c = context;
    }

    public ProfileImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17924e = null;
        this.f17920a = 0;
        this.f17921b = new ArrayList<>();
        this.f17925f = new ViewOnClickListenerC4920m(this);
        this.f17926g = new ViewOnClickListenerC4921n(this);
        this.f17922c = context;
    }

    public ProfileImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17924e = null;
        this.f17920a = 0;
        this.f17921b = new ArrayList<>();
        this.f17925f = new ViewOnClickListenerC4920m(this);
        this.f17926g = new ViewOnClickListenerC4921n(this);
        this.f17922c = context;
    }

    public void setBuddyNo(String str) {
        this.f17923d = str;
    }

    public void setBuddyName(String str) {
        this.f17924e = str;
    }

    /* renamed from: a */
    public void m18704a(View view, EnumC2300t enumC2300t) {
        switch (enumC2300t) {
            case ONETOONE:
                C4855bt.m18351a(getContext()).m18359a((ImageView) view, EnumC4857bv.BUDDY);
                setOnClickListener(this.f17926g);
                break;
            case GROUPCHAT:
                C4855bt.m18351a(getContext()).m18359a((ImageView) view, EnumC4857bv.GROUP);
                setOnClickListener(this.f17925f);
                break;
            case BROADCAST:
            case BROADCAST2:
                C4855bt.m18351a(getContext()).m18359a((ImageView) view, EnumC4857bv.BROADCAST);
                setOnClickListener(this.f17925f);
                break;
            case MONOLOGUE:
                C4855bt.m18351a(getContext()).m18359a((ImageView) view, EnumC4857bv.MONOLOGUE);
                setOnClickListener(this.f17925f);
                break;
        }
    }
}
