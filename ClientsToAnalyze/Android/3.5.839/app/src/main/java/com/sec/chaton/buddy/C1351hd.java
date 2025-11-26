package com.sec.chaton.buddy;

import android.database.Cursor;
import android.net.Uri;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.hd */
/* loaded from: classes.dex */
class C1351hd implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendFragment f4930a;

    C1351hd(BuddyRecommendFragment buddyRecommendFragment) {
        this.f4930a = buddyRecommendFragment;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7099a(int i, Object obj, int i2) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onUpdateComplete", BuddyRecommendFragment.f4065a);
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onQueryComplete", BuddyRecommendFragment.f4065a);
        }
        try {
            if (!this.f4930a.f4092t && this.f4930a.f4066A != null) {
                switch (i) {
                    case 1:
                        if (cursor != null) {
                            this.f4930a.f4086n = cursor.getCount();
                        } else {
                            this.f4930a.f4086n = 0;
                        }
                        if (this.f4930a.f4077e != null) {
                            this.f4930a.f4077e.notifyDataSetChanged();
                        }
                        if (this.f4930a.f4086n <= 0) {
                            if (this.f4930a.f4086n == 0) {
                                C4809aa.m18107a("recommend_timestamp", (Long) 0L);
                            }
                            this.f4930a.f4079g.setVisibility(8);
                            break;
                        } else {
                            this.f4930a.f4079g.setVisibility(0);
                            break;
                        }
                    case 2:
                    default:
                        if (cursor != null) {
                            cursor.close();
                            break;
                        }
                        break;
                    case 3:
                        if (cursor != null && cursor.moveToFirst() && cursor.getInt(cursor.getColumnIndex(VKApiConst.COUNT)) > 0) {
                            this.f4930a.getLoaderManager().mo111b(0, null, this.f4930a);
                            break;
                        }
                        break;
                }
                if (cursor == null) {
                }
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7101a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: b */
    public void mo7102b(int i, Object obj, int i2) {
    }
}
