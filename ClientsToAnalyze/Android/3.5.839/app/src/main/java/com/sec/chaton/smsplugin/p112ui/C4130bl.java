package com.sec.chaton.smsplugin.p112ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p110g.C3869o;
import com.sec.chaton.smsplugin.p110g.C3870p;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.C3892o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

/* compiled from: MessageListItem.java */
/* renamed from: com.sec.chaton.smsplugin.ui.bl */
/* loaded from: classes.dex */
class C4130bl extends ArrayList<MmsSlideView> {

    /* renamed from: b */
    private LayoutInflater f15375b;

    /* renamed from: c */
    private final LinearLayout f15376c;

    /* renamed from: e */
    private C3870p f15378e;

    /* renamed from: a */
    private int f15374a = 0;

    /* renamed from: d */
    private final C4129bk f15377d = new C4129bk();

    public C4130bl(LinearLayout linearLayout) {
        this.f15376c = linearLayout;
    }

    /* renamed from: a */
    public void m16346a(MessageListItem messageListItem) {
        m16347a(messageListItem, false);
    }

    /* renamed from: a */
    public void m16347a(MessageListItem messageListItem, boolean z) throws IOException {
        boolean zM15865a;
        int iM14796g = this.f15378e != null ? this.f15378e.m14913d().m14796g() : 0;
        if (this.f15378e != null && C4149cd.m16389a(this.f15378e) == 10 && this.f15378e.get(0) != null && this.f15378e.get(0).m14863e()) {
            C3869o c3869oRemove = this.f15378e.remove(0);
            if (c3869oRemove != null && c3869oRemove.m14863e()) {
                c3869oRemove.m14871k();
            }
            this.f15378e.add(c3869oRemove);
        }
        StringBuilder sb = new StringBuilder();
        boolean z2 = false;
        for (int i = 0; i < this.f15374a; i++) {
            if (this.f15378e != null && this.f15378e.get(i) != null) {
                if (C3847e.m14681am()) {
                    zM15865a = get(i).m15866a(iM14796g, this.f15378e.get(i), messageListItem, z);
                } else {
                    zM15865a = get(i).m15865a(iM14796g, this.f15378e.get(i), messageListItem);
                }
                boolean z3 = z2 || zM15865a;
                sb.setLength(0);
                sb.append("present page ").append(i).append(", hasContent ").append(zM15865a);
                C3890m.m14996b("MessageListItem", sb.toString());
                z2 = z3;
            }
        }
    }

    /* renamed from: a */
    public void m16342a(int i) {
        this.f15377d.f15373d = i;
        Iterator<MmsSlideView> it = iterator();
        while (it.hasNext()) {
            C3892o.m15015a(it.next().m15868c(), i);
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean add(MmsSlideView mmsSlideView) {
        this.f15376c.addView(mmsSlideView);
        return super.add(mmsSlideView);
    }

    /* renamed from: a */
    public void m16345a(View.OnTouchListener onTouchListener) {
        this.f15377d.f15370a = onTouchListener;
        Iterator<MmsSlideView> it = iterator();
        while (it.hasNext()) {
            it.next().m15868c().setOnTouchListener(onTouchListener);
        }
    }

    /* renamed from: b */
    public void m16349b(int i) {
        Iterator<MmsSlideView> it = iterator();
        while (it.hasNext()) {
            it.next().m15868c().setMaxWidth(i);
        }
    }

    /* renamed from: a */
    public void m16343a(int i, float f) {
        this.f15377d.f15371b = i;
        this.f15377d.f15372c = f;
        Iterator<MmsSlideView> it = iterator();
        while (it.hasNext()) {
            it.next().m15868c().setTextSize(i, f);
        }
    }

    /* renamed from: a */
    public void m16344a(int i, C4108aq c4108aq) {
        this.f15374a = i;
        this.f15378e = c4108aq.f15287v;
        boolean zM16317t = c4108aq.m16317t();
        Pattern pattern = c4108aq.f15279n;
        C3892o.m15014a(this.f15376c, this.f15374a > 0);
        if (this.f15375b == null) {
            this.f15375b = LayoutInflater.from(this.f15376c.getContext());
        }
        int size = size();
        while (true) {
            int i2 = size;
            if (i2 >= this.f15374a) {
                break;
            }
            add((MmsSlideView) this.f15375b.inflate(R.layout.mms_slide_view, (ViewGroup) null));
            size = i2 + 1;
        }
        size();
        Iterator<MmsSlideView> it = iterator();
        int i3 = 0;
        while (it.hasNext()) {
            MmsSlideView next = it.next();
            if (i3 < this.f15374a) {
                C3892o.m15014a((View) next, true);
                next.m15864a(this.f15377d);
                next.setIsFailedMessage(zM16317t);
                next.setHighlight(pattern);
            } else {
                C3892o.m15014a((View) next, false);
            }
            i3++;
        }
    }
}
