package com.sec.chaton;

import android.support.v4.view.AbstractC0144ae;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.sec.chaton.settings.moreapps.CallableC3675g;
import com.sec.chaton.util.C4904y;
import com.sec.common.p132g.C5007c;

/* compiled from: PlusFragment.java */
/* renamed from: com.sec.chaton.cc */
/* loaded from: classes.dex */
public class C1499cc extends AbstractC0144ae {

    /* renamed from: a */
    final /* synthetic */ PlusFragment f5427a;

    public C1499cc(PlusFragment plusFragment) {
        this.f5427a = plusFragment;
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: b */
    public int mo612b() {
        return this.f5427a.f1966J;
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: a */
    public void mo79a(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView(viewGroup);
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: a */
    public Object mo76a(ViewGroup viewGroup, int i) {
        if (this.f5427a.f1966J <= 0) {
            return null;
        }
        C1498cb c1498cb = new C1498cb(null);
        String strM7816b = this.f5427a.m2941e() == 2 ? ((C1502cf) this.f5427a.f1964H.get(i)).m7816b() : ((C1502cf) this.f5427a.f1964H.get(i)).m7817c();
        View viewInflate = this.f5427a.f1996w.inflate(R.layout.layout_plus_event, (ViewGroup) null);
        c1498cb.f5424a = (ImageView) viewInflate.findViewById(R.id.banner_img);
        c1498cb.f5425b = (ImageView) viewInflate.findViewById(R.id.event_badge);
        c1498cb.f5426c = i;
        this.f5427a.f1989p = new C5007c();
        this.f5427a.f1989p.m19023b(c1498cb.f5424a, new CallableC3675g(strM7816b, ((C1502cf) this.f5427a.f1964H.get(i)).m7815a(), c1498cb.f5425b));
        viewInflate.setTag(c1498cb);
        viewInflate.setOnClickListener(this.f5427a.f1973Q);
        viewGroup.addView(viewInflate);
        if (C4904y.f17872b) {
            C4904y.m18639b("Total event count : " + this.f5427a.f1966J, PlusFragment.f1956a);
        }
        return viewInflate;
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: a */
    public boolean mo80a(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: a */
    public int mo607a(Object obj) {
        return -2;
    }
}
