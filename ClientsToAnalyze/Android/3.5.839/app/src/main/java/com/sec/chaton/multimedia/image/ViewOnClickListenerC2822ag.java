package com.sec.chaton.multimedia.image;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.poston.C3009d;
import com.sec.chaton.poston.PostONDetailActivity;
import com.sec.chaton.poston.PostONDetailFragment;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4904y;

/* compiled from: PostONImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.ag */
/* loaded from: classes.dex */
class ViewOnClickListenerC2822ag implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONImagePagerActivity f10392a;

    ViewOnClickListenerC2822ag(PostONImagePagerActivity postONImagePagerActivity) {
        this.f10392a = postONImagePagerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C2828am c2828am;
        if (!C4847bl.m18333a() && this.f10392a.f10273F.containsKey(Integer.valueOf(this.f10392a.m11880j())) && (c2828am = (C2828am) this.f10392a.f10272E.get(this.f10392a.f10273F.get(Integer.valueOf(this.f10392a.m11880j())))) != null && c2828am.f10398a != null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("onDetailView : " + c2828am, PostONImagePagerActivity.f10266o);
            }
            Intent intent = new Intent(this.f10392a.f10268A, (Class<?>) PostONDetailActivity.class);
            intent.putExtra(PostONDetailFragment.f10867a, this.f10392a.f10295s);
            intent.putExtra(PostONDetailFragment.f10869b, c2828am.f10408k);
            intent.putExtra(PostONDetailFragment.f10870c, c2828am.f10403f);
            intent.putExtra(PostONDetailFragment.f10873f, c2828am.f10402e);
            intent.putExtra(PostONDetailFragment.f10871d, c2828am.f10405h);
            intent.putExtra(PostONDetailFragment.f10872e, C3009d.m12358a(Long.parseLong(c2828am.f10405h)));
            intent.putExtra(PostONDetailFragment.f10874g, c2828am.m11925a());
            intent.putExtra(PostONDetailFragment.f10876i, c2828am.f10398a);
            intent.putExtra(PostONDetailFragment.f10877j, c2828am.f10401d);
            intent.putExtra(PostONDetailFragment.f10878k, c2828am.f10400c);
            intent.putExtra(PostONDetailFragment.f10879l, c2828am.f10408k);
            intent.putExtra(PostONDetailFragment.f10881n, PostONDetailFragment.f10883p);
            if (this.f10392a.f10274G != null && this.f10392a.f10300x != null) {
                intent.putExtra(PostONDetailFragment.f10880m, (String) this.f10392a.f10274G.get(this.f10392a.f10300x));
            }
            if (C4904y.f17871a) {
                C4904y.m18646e("Total Read Comment : " + c2828am.m11925a(), PostONImagePagerActivity.f10266o);
            }
            if (this.f10392a.f10295s.equals(this.f10392a.f10296t)) {
                intent.putExtra(PostONDetailFragment.f10882o, "MY_PAGE");
            }
            this.f10392a.startActivityForResult(intent, 1);
        }
    }
}
