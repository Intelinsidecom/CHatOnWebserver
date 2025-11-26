package com.sec.chaton.localbackup.chatview;

import com.sec.chaton.localbackup.p075a.AsyncTaskC2510a;
import com.sec.chaton.multimedia.image.ImagePagerFragment;
import com.sec.chaton.p057e.EnumC2214ab;

/* loaded from: classes.dex */
public class BackupImagePagerFragment extends ImagePagerFragment {
    @Override // com.sec.chaton.multimedia.image.ImagePagerFragment
    /* renamed from: a */
    protected void mo10895a() {
        this.f10240a.setVisibility(0);
        new AsyncTaskC2510a(m11844d(), this.f10242c, m11844d().m11821i(), this.f10241b, this.f10243d, EnumC2214ab.IMAGE, null, m11844d().m11824l(), false).execute(new String[0]);
    }

    @Override // com.sec.chaton.multimedia.image.ImagePagerFragment
    /* renamed from: b */
    protected void mo10896b() {
        new AsyncTaskC2510a(m11844d(), this.f10242c, m11844d().m11821i(), this.f10241b, this.f10243d, EnumC2214ab.VIDEO, null, m11844d().m11824l(), true).execute(new String[0]);
    }
}
