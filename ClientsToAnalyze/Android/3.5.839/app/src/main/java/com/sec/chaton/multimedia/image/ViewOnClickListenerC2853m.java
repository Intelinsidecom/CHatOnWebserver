package com.sec.chaton.multimedia.image;

import android.view.View;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.trunk.TrunkDetailActivity;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4904y;

/* compiled from: ImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.m */
/* loaded from: classes.dex */
class ViewOnClickListenerC2853m implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ImagePagerActivity f10487a;

    ViewOnClickListenerC2853m(ImagePagerActivity imagePagerActivity) {
        this.f10487a = imagePagerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C2860t c2860t;
        if (!C4847bl.m18333a() && this.f10487a.f10202F.containsKey(Integer.valueOf(this.f10487a.f10228w)) && (c2860t = (C2860t) this.f10487a.f10201E.get(this.f10487a.f10202F.get(Integer.valueOf(this.f10487a.f10228w)))) != null && c2860t.f10497d != null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("onDetailView : " + c2860t, ImagePagerActivity.f10196o);
            }
            String[] strArrSplit = c2860t.f10497d.split("\n");
            String str = c2860t.f10498e;
            boolean z = (c2860t.f10499f == EnumC2214ab.IMAGE || c2860t.f10499f == EnumC2214ab.AMS || c2860t.f10499f != EnumC2214ab.VIDEO) ? false : true;
            if (strArrSplit.length > 4) {
                TrunkDetailActivity.m17292a(this.f10487a.f10231z, this.f10487a.f10224s, this.f10487a.f10223r, strArrSplit[4], strArrSplit[3], 0, this.f10487a.f10199C, str, z);
            }
        }
    }
}
