package com.sec.chaton.userprofile;

import android.database.Cursor;
import android.net.Uri;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.util.C4904y;

/* compiled from: CoverstorySampleFragment.java */
/* renamed from: com.sec.chaton.userprofile.m */
/* loaded from: classes.dex */
class C4794m implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ CoverstorySampleFragment f17527a;

    C4794m(CoverstorySampleFragment coverstorySampleFragment) {
        this.f17527a = coverstorySampleFragment;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
        if (i == CoverstorySampleFragment.f17102b) {
            try {
                if (cursor != null) {
                    try {
                        if (C4904y.f17871a) {
                            C4904y.m18646e("CoverStory list count: " + cursor.getCount(), CoverstorySampleFragment.f17103c);
                        }
                        this.f17527a.f17114l.clear();
                        if (cursor.getCount() != 0) {
                            while (cursor.moveToNext()) {
                                String string = cursor.getString(cursor.getColumnIndex("coverstory_id"));
                                String string2 = cursor.getString(cursor.getColumnIndex("coverstory_thumb_url"));
                                this.f17527a.f17114l.add(new C4792k(string, string2, cursor.getString(cursor.getColumnIndex("coverstory_filename"))));
                                if (C4904y.f17871a) {
                                    C4904y.m18646e("CoverStorySampleTable.KEY_COVERSTORY_ID: " + string + "CoverStorySampleTable.KEY_COVERSTORY_THUMB_URL: " + string2, CoverstorySampleFragment.f17103c);
                                }
                            }
                            if (this.f17527a.f17112i == null) {
                                this.f17527a.f17112i = new C4789h(this.f17527a.getActivity(), R.layout.item_profile_image, this.f17527a.f17114l, this.f17527a.f17113j);
                                this.f17527a.f17112i.m18082a(this.f17527a);
                                this.f17527a.f17109e.setAdapter((ListAdapter) this.f17527a.f17112i);
                            } else {
                                this.f17527a.f17112i.notifyDataSetChanged();
                            }
                        }
                        if (cursor == null) {
                            return;
                        }
                    } catch (Exception e) {
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e, getClass().getSimpleName());
                        }
                        if (cursor == null) {
                            return;
                        }
                    }
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7101a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7099a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: b */
    public void mo7102b(int i, Object obj, int i2) {
    }
}
