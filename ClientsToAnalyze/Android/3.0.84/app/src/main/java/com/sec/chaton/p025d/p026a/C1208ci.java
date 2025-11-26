package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.C1398ap;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.p027e.p028a.C1355ad;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p035io.entry.GetSoundListEntry;
import com.sec.chaton.p035io.entry.inner.EffectSound;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.settings.downloads.C2620df;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3170al;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3364o;
import java.util.ArrayList;

/* compiled from: GetSoundListTask.java */
/* renamed from: com.sec.chaton.d.a.ci */
/* loaded from: classes.dex */
public class C1208ci extends AbstractC1145a {

    /* renamed from: b */
    private static final String f4713b = C1208ci.class.getSimpleName();

    public C1208ci(Handler handler, C1580h c1580h, EnumC1172b enumC1172b) {
        super(handler, c1580h, enumC1172b);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    public String mo5496f() {
        return null;
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    public void mo5488a(C0267d c0267d) {
        if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
            C1533b.m6522a("01000011", "4001", c0267d);
        }
        if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
            GetSoundListEntry getSoundListEntry = (GetSoundListEntry) c0267d.m1354e();
            if (getSoundListEntry == null) {
                if (C3250y.f11737e) {
                    C3250y.m11442a("Http result object is null.", f4713b);
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<ContentProviderOperation> arrayListM9594a = C2620df.m9594a(CommonApplication.m11493l());
            if (arrayListM9594a != null && arrayListM9594a.size() >= 0) {
                arrayList.addAll(arrayListM9594a);
            }
            if (C3250y.f11734b) {
                C3250y.m11450b("download_sound, Remove all item list from database.", f4713b);
            }
            arrayList.add(ContentProviderOperation.newDelete(C1398ap.m6249a(EnumC1399aq.Sound)).withSelection(C3364o.m11849a("install", " = ?"), new String[]{"0"}).build());
            if (C3250y.f11734b) {
                C3250y.m11450b("download_sound, Save item to database.", f4713b);
            }
            for (EffectSound effectSound : getSoundListEntry.sounds) {
                if (C3250y.f11734b) {
                    C3250y.m11450b(effectSound.toString(), f4713b);
                }
                arrayList.add(C1355ad.m5976a(effectSound));
            }
            C3170al.m11043a(CommonApplication.m11493l(), "com.sec.chaton.provider2", (ArrayList<ContentProviderOperation>) arrayList);
            C3159aa.m10962a().m10984b("new_sound_count", (Integer) 0);
            LocalBroadcastManager.getInstance(CommonApplication.m11493l()).sendBroadcast(new Intent("more_tab_badge_update"));
        }
    }
}
