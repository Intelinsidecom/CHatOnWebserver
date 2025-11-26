package com.sec.chaton.multimedia.image;

import android.os.Bundle;
import android.support.v4.app.AbstractC0020af;
import android.support.v4.app.AbstractC0069w;
import android.support.v4.app.Fragment;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.localbackup.chatview.BackupImagePagerFragment;
import com.sec.chaton.util.C4904y;

/* compiled from: ImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.s */
/* loaded from: classes.dex */
public class C2859s extends AbstractC0020af {

    /* renamed from: a */
    final /* synthetic */ ImagePagerActivity f10493a;

    /* synthetic */ C2859s(ImagePagerActivity imagePagerActivity, AbstractC0069w abstractC0069w, C2852l c2852l) {
        this(imagePagerActivity, abstractC0069w);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C2859s(ImagePagerActivity imagePagerActivity, AbstractC0069w abstractC0069w) {
        super(abstractC0069w);
        this.f10493a = imagePagerActivity;
    }

    @Override // android.support.v4.app.AbstractC0020af
    /* renamed from: a */
    public Fragment mo86a(int i) {
        Fragment imagePagerFragment;
        if (this.f10493a.f10214R) {
            imagePagerFragment = new BackupImagePagerFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(VKApiConst.POSITION, i);
            imagePagerFragment.setArguments(bundle);
            if (C4904y.f17872b) {
                C4904y.m18639b("getItem : " + i, ImagePagerActivity.f10196o);
            }
        } else {
            imagePagerFragment = new ImagePagerFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putInt(VKApiConst.POSITION, i);
            imagePagerFragment.setArguments(bundle2);
            if (C4904y.f17872b) {
                C4904y.m18639b("getItem : " + i, ImagePagerActivity.f10196o);
            }
        }
        return imagePagerFragment;
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: b */
    public int mo612b() {
        return this.f10493a.f10201E.size();
    }

    @Override // android.support.v4.view.AbstractC0144ae
    /* renamed from: a */
    public int mo607a(Object obj) {
        return -2;
    }
}
