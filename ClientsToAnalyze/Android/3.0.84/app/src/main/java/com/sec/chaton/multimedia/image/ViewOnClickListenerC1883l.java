package com.sec.chaton.multimedia.image;

import android.view.View;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.trunk.TrunkDetailActivity;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3250y;

/* compiled from: ImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.l */
/* loaded from: classes.dex */
class ViewOnClickListenerC1883l implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ImagePagerActivity f7166a;

    ViewOnClickListenerC1883l(ImagePagerActivity imagePagerActivity) {
        this.f7166a = imagePagerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1891t c1891t;
        if (!C3197bl.m11159a() && this.f7166a.f6924r.containsKey(Integer.valueOf(this.f7166a.f6916j)) && (c1891t = (C1891t) this.f7166a.f6923q.get(this.f7166a.f6924r.get(Integer.valueOf(this.f7166a.f6916j)))) != null && c1891t.f7177d != null) {
            if (C3250y.f11734b) {
                C3250y.m11450b("onDetailView : " + c1891t, ImagePagerActivity.f6898b);
            }
            String[] strArrSplit = c1891t.f7177d.split("\n");
            String str = c1891t.f7178e;
            boolean z = (c1891t.f7179f == EnumC1455w.IMAGE || c1891t.f7179f == EnumC1455w.AMS || c1891t.f7179f != EnumC1455w.VIDEO) ? false : true;
            if (strArrSplit.length > 4) {
                TrunkDetailActivity.m10199a(this.f7166a.f6918l, this.f7166a.f6912f, this.f7166a.f6911e, strArrSplit[4], strArrSplit[3], 0, this.f7166a.f6921o, str, z);
            }
        }
    }
}
