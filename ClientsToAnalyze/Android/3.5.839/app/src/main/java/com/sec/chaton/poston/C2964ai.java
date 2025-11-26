package com.sec.chaton.poston;

import android.database.Cursor;
import android.net.Uri;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4904y;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.ai */
/* loaded from: classes.dex */
class C2964ai implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ PostONDetailFragment f11056a;

    C2964ai(PostONDetailFragment postONDetailFragment) {
        this.f11056a = postONDetailFragment;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
        if (i == 1) {
            this.f11056a.f10905T.clear();
            try {
                if (cursor == null) {
                    this.f11056a.f10911Z.setText(Spam.ACTIVITY_CANCEL);
                    return;
                }
                try {
                    this.f11056a.f10895J = String.valueOf(cursor.getCount());
                    C4904y.m18646e("PostON Comment list count: " + this.f11056a.f10889D + ", " + cursor.getCount(), getClass().getSimpleName());
                    if (cursor.getCount() == 0) {
                        if (this.f11056a.f10928aj != null) {
                            this.f11056a.f10928aj.setVisibility(8);
                        }
                        if (this.f11056a.f10904S != null) {
                            this.f11056a.f10904S.notifyDataSetChanged();
                        }
                        cursor.close();
                        this.f11056a.f10911Z.setText(Spam.ACTIVITY_CANCEL);
                    } else {
                        while (cursor.moveToNext()) {
                            String string = cursor.getString(cursor.getColumnIndex("buddy_no"));
                            String string2 = cursor.getString(cursor.getColumnIndex("joined_name"));
                            String string3 = cursor.getString(cursor.getColumnIndex("comment"));
                            String string4 = cursor.getString(cursor.getColumnIndex("timestamp"));
                            String string5 = cursor.getString(cursor.getColumnIndex("isread"));
                            String string6 = cursor.getString(cursor.getColumnIndex("commentid"));
                            C4904y.m18646e("no: " + string + "name: " + string2 + "comment: " + string3 + "time: " + string4 + "isRead: " + string5 + "sender: ", getClass().getSimpleName());
                            this.f11056a.f10905T.add(new C3021p(string, string2, string3, string4, string5, string6));
                        }
                        if (this.f11056a.f10928aj != null) {
                            this.f11056a.f10928aj.setVisibility(8);
                        }
                        if (this.f11056a.f10904S == null) {
                            this.f11056a.f10904S = new C3018m(this.f11056a.f10903R, this.f11056a.getActivity(), this.f11056a.f10905T, R.layout.list_item_common_10);
                            this.f11056a.f10903R.setAdapter((ListAdapter) this.f11056a.f10904S);
                        } else {
                            this.f11056a.f10904S.notifyDataSetChanged();
                        }
                        this.f11056a.f10929ak = false;
                        this.f11056a.f10911Z.setText(this.f11056a.f10909X);
                        if (this.f11056a.f10936ar) {
                            this.f11056a.f10903R.setSelection(this.f11056a.f10904S.getCount() - 1);
                            this.f11056a.f10936ar = false;
                        }
                    }
                    if (cursor == null) {
                        return;
                    }
                } catch (Exception e) {
                    C4904y.m18646e("Exception is occurred in showPostONCommentList", PostONDetailFragment.f10885r);
                    if (cursor == null) {
                        return;
                    }
                }
                cursor.close();
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
