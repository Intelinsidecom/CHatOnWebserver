package com.sec.chaton.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.util.C1348w;
import com.sec.chaton.util.EnumC1310bf;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ProfileImageView extends ImageView {

    /* renamed from: a */
    int f4607a;

    /* renamed from: b */
    ArrayList f4608b;

    /* renamed from: c */
    private Context f4609c;

    /* renamed from: d */
    private String f4610d;

    /* renamed from: e */
    private String f4611e;

    /* renamed from: f */
    private View.OnClickListener f4612f;

    /* renamed from: g */
    private View.OnClickListener f4613g;

    public ProfileImageView(Context context) {
        super(context);
        this.f4611e = null;
        this.f4607a = 0;
        this.f4608b = new ArrayList();
        this.f4612f = new ViewOnClickListenerC1359f(this);
        this.f4613g = new ViewOnClickListenerC1357d(this);
        this.f4609c = context;
    }

    public ProfileImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4611e = null;
        this.f4607a = 0;
        this.f4608b = new ArrayList();
        this.f4612f = new ViewOnClickListenerC1359f(this);
        this.f4613g = new ViewOnClickListenerC1357d(this);
        this.f4609c = context;
    }

    public ProfileImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4611e = null;
        this.f4607a = 0;
        this.f4608b = new ArrayList();
        this.f4612f = new ViewOnClickListenerC1359f(this);
        this.f4613g = new ViewOnClickListenerC1357d(this);
        this.f4609c = context;
    }

    public void setBuddyNo(String str) {
        this.f4610d = str;
    }

    public void setBuddyName(String str) {
        this.f4611e = str;
    }

    /* renamed from: a */
    public void m4722a(View view, EnumC0665r enumC0665r) {
        switch (C1358e.f4617a[enumC0665r.ordinal()]) {
            case 1:
                C1348w.m4685a(getContext()).m4698a((ImageView) view, EnumC1310bf.BUDDY);
                setOnClickListener(this.f4613g);
                break;
            case 2:
                C1348w.m4685a(getContext()).m4698a((ImageView) view, EnumC1310bf.GROUP);
                setOnClickListener(this.f4612f);
                break;
            case 3:
                C1348w.m4685a(getContext()).m4698a((ImageView) view, EnumC1310bf.BROADCAST);
                setOnClickListener(this.f4612f);
                break;
        }
    }
}
