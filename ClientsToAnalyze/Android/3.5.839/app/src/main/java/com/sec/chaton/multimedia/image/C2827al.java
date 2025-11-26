package com.sec.chaton.multimedia.image;

import android.os.Bundle;
import android.support.v4.app.AbstractC0020af;
import android.support.v4.app.AbstractC0069w;
import android.support.v4.app.Fragment;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.util.C4904y;

/* compiled from: PostONImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.al */
/* loaded from: classes.dex */
public class C2827al extends AbstractC0020af {

    /* renamed from: a */
    final /* synthetic */ PostONImagePagerActivity f10397a;

    /* synthetic */ C2827al(PostONImagePagerActivity postONImagePagerActivity, AbstractC0069w abstractC0069w, C2821af c2821af) {
        this(postONImagePagerActivity, abstractC0069w);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C2827al(PostONImagePagerActivity postONImagePagerActivity, AbstractC0069w abstractC0069w) {
        super(abstractC0069w);
        this.f10397a = postONImagePagerActivity;
    }

    @Override // android.support.v4.app.AbstractC0020af
    /* renamed from: a */
    public Fragment mo86a(int i) {
        PostONImagePagerFragment postONImagePagerFragment = new PostONImagePagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(VKApiConst.POSITION, i);
        bundle.putString("buddyId", this.f10397a.f10295s);
        postONImagePagerFragment.setArguments(bundle);
        if (C4904y.f17872b) {
            C4904y.m18639b("getItem : " + i, PostONImagePagerActivity.f10266o);
        }
        return postONImagePagerFragment;
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: b */
    public int mo612b() {
        return this.f10397a.f10272E.size();
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: a */
    public int mo607a(Object obj) {
        return -2;
    }
}
