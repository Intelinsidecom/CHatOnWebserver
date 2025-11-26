package com.sec.chaton.localbackup.chatview;

import com.sec.chaton.localbackup.p045a.AsyncTaskC1610a;
import com.sec.chaton.multimedia.image.ImagePagerFragment;
import com.sec.chaton.p027e.EnumC1455w;

/* loaded from: classes.dex */
public class BackupImagePagerFragment extends ImagePagerFragment {
    @Override // com.sec.chaton.multimedia.image.ImagePagerFragment
    /* renamed from: a */
    protected void mo6864a() {
    }

    /* renamed from: b */
    public void m6865b() {
        this.f6936a.setVisibility(0);
        new AsyncTaskC1610a(m7630e(), this.f6938c, m7630e().m7614d(), this.f6937b, this.f6939d, EnumC1455w.IMAGE, null, m7630e().m7617g(), false).execute(new String[0]);
    }

    @Override // com.sec.chaton.multimedia.image.ImagePagerFragment
    /* renamed from: c */
    protected void mo6866c() {
        new AsyncTaskC1610a(m7630e(), this.f6938c, m7630e().m7614d(), this.f6937b, this.f6939d, EnumC1455w.VIDEO, null, m7630e().m7617g(), true).execute(new String[0]);
    }
}
