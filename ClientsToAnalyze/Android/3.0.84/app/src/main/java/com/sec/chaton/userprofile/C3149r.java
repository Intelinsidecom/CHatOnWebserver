package com.sec.chaton.userprofile;

import android.database.Cursor;
import android.net.Uri;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.util.C3250y;

/* compiled from: CoverstorySampleFragment.java */
/* renamed from: com.sec.chaton.userprofile.r */
/* loaded from: classes.dex */
class C3149r implements InterfaceC1378v {

    /* renamed from: a */
    final /* synthetic */ CoverstorySampleFragment f11418a;

    C3149r(CoverstorySampleFragment coverstorySampleFragment) {
        this.f11418a = coverstorySampleFragment;
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        if (i == CoverstorySampleFragment.f11046b) {
            try {
                if (cursor != null) {
                    try {
                        if (C3250y.f11733a) {
                            C3250y.m11456e("CoverStory list count: " + cursor.getCount(), CoverstorySampleFragment.f11047c);
                        }
                        this.f11418a.f11058l.clear();
                        if (cursor.getCount() != 0) {
                            while (cursor.moveToNext()) {
                                String string = cursor.getString(cursor.getColumnIndex("coverstory_id"));
                                String string2 = cursor.getString(cursor.getColumnIndex("coverstory_thumb_url"));
                                this.f11418a.f11058l.add(new C3147p(string, string2, cursor.getString(cursor.getColumnIndex("coverstory_filename"))));
                                if (C3250y.f11733a) {
                                    C3250y.m11456e("CoverStorySampleTable.KEY_COVERSTORY_ID: " + string + "CoverStorySampleTable.KEY_COVERSTORY_THUMB_URL: " + string2, CoverstorySampleFragment.f11047c);
                                }
                            }
                            if (this.f11418a.f11056i == null) {
                                if (GlobalApplication.m6456e()) {
                                    this.f11418a.f11056i = new C3144m(this.f11418a.getActivity(), R.layout.item_sample_image, this.f11418a.f11058l, this.f11418a.f11057j);
                                } else {
                                    this.f11418a.f11056i = new C3144m(this.f11418a.getActivity(), R.layout.item_profile_image, this.f11418a.f11058l, this.f11418a.f11057j);
                                }
                                this.f11418a.f11056i.m10934a(this.f11418a);
                                this.f11418a.f11053e.setAdapter((ListAdapter) this.f11418a.f11056i);
                            } else {
                                this.f11418a.f11056i.notifyDataSetChanged();
                            }
                        }
                        if (cursor == null) {
                            return;
                        }
                    } catch (Exception e) {
                        if (C3250y.f11737e) {
                            C3250y.m11443a(e, getClass().getSimpleName());
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

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onUpdateComplete(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
