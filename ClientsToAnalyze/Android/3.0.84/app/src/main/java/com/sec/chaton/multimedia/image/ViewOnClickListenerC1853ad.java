package com.sec.chaton.multimedia.image;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.poston.C2013d;
import com.sec.chaton.poston.PostONDetailActivity;
import com.sec.chaton.poston.PostONDetailFragment;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3250y;

/* compiled from: PostONImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.ad */
/* loaded from: classes.dex */
class ViewOnClickListenerC1853ad implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONImagePagerActivity f7081a;

    ViewOnClickListenerC1853ad(PostONImagePagerActivity postONImagePagerActivity) {
        this.f7081a = postONImagePagerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1859aj c1859aj;
        if (!C3197bl.m11159a() && this.f7081a.f6987r.containsKey(Integer.valueOf(this.f7081a.m7661e())) && (c1859aj = (C1859aj) this.f7081a.f6986q.get(this.f7081a.f6987r.get(Integer.valueOf(this.f7081a.m7661e())))) != null && c1859aj.f7087a != null) {
            if (C3250y.f11734b) {
                C3250y.m11450b("onDetailView : " + c1859aj, PostONImagePagerActivity.f6962b);
            }
            Intent intent = new Intent(this.f7081a.f6982m, (Class<?>) PostONDetailActivity.class);
            intent.putExtra(PostONDetailFragment.f7486a, this.f7081a.f6975f);
            intent.putExtra(PostONDetailFragment.f7488b, c1859aj.f7097k);
            intent.putExtra(PostONDetailFragment.f7489c, c1859aj.f7092f);
            intent.putExtra(PostONDetailFragment.f7492f, c1859aj.f7091e);
            intent.putExtra(PostONDetailFragment.f7490d, c1859aj.f7094h);
            intent.putExtra(PostONDetailFragment.f7491e, C2013d.m8038a(Long.parseLong(c1859aj.f7094h)));
            intent.putExtra(PostONDetailFragment.f7493g, c1859aj.m7699a());
            intent.putExtra(PostONDetailFragment.f7494h, c1859aj.f7087a);
            intent.putExtra(PostONDetailFragment.f7495i, c1859aj.f7090d);
            intent.putExtra(PostONDetailFragment.f7496j, c1859aj.f7089c);
            intent.putExtra(PostONDetailFragment.f7497k, c1859aj.f7097k);
            intent.putExtra(PostONDetailFragment.f7499m, PostONDetailFragment.f7501o);
            if (this.f7081a.f6988s != null && this.f7081a.f6980k != null) {
                intent.putExtra(PostONDetailFragment.f7498l, (String) this.f7081a.f6988s.get(this.f7081a.f6980k));
            }
            if (C3250y.f11733a) {
                C3250y.m11456e("Total Read Comment : " + c1859aj.m7699a(), PostONImagePagerActivity.f6962b);
            }
            if (this.f7081a.f6975f.equals(this.f7081a.f6976g)) {
                intent.putExtra(PostONDetailFragment.f7500n, "MY_PAGE");
            }
            this.f7081a.startActivityForResult(intent, 1);
        }
    }
}
