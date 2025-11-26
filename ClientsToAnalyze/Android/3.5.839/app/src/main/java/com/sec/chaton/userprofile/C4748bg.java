package com.sec.chaton.userprofile;

import android.database.Cursor;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.p057e.p058a.C2178ad;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.poston.C3009d;
import com.sec.chaton.poston.C3016k;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.bg */
/* loaded from: classes.dex */
class C4748bg implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f17412a;

    C4748bg(MyPageFragment myPageFragment) {
        this.f17412a = myPageFragment;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
        if (i == 1) {
            if (cursor != null) {
                try {
                    try {
                        if (C4904y.f17871a) {
                            C4904y.m18646e("queryPostONList. PostON list count: " + C4809aa.m18104a().m18121a("chaton_id", "") + ", " + cursor.getCount(), MyPageFragment.f17192a);
                        }
                        this.f17412a.f17245an.clear();
                        if (cursor.getCount() == 0) {
                            if (this.f17412a.f17276w != null) {
                                this.f17412a.f17276w.setVisibility(8);
                            }
                            this.f17412a.f17277x.setVisibility(0);
                            if (this.f17412a.f17244am != null) {
                                this.f17412a.f17244am.notifyDataSetChanged();
                            }
                        } else {
                            this.f17412a.f17277x.setVisibility(8);
                            while (cursor.moveToNext()) {
                                String string = cursor.getString(cursor.getColumnIndex("buddy_no"));
                                String string2 = cursor.getString(cursor.getColumnIndex("joined_name"));
                                String string3 = cursor.getString(cursor.getColumnIndex("poston"));
                                String string4 = cursor.getString(cursor.getColumnIndex("timestamp"));
                                String string5 = cursor.getString(cursor.getColumnIndex("unread_comment_count"));
                                String string6 = cursor.getString(cursor.getColumnIndex("read_comment_count"));
                                String string7 = cursor.getString(cursor.getColumnIndex("isread"));
                                String string8 = cursor.getString(cursor.getColumnIndex("multimedia_list"));
                                this.f17412a.f17245an.add(new C3016k(C4809aa.m18104a().m18121a("chaton_id", ""), string, string2, string3, string4, string5, string6, string7, null, C2178ad.m9714a(string8), cursor.getString(cursor.getColumnIndex("poston_id")), cursor.getString(cursor.getColumnIndex("joined_no"))));
                                if (C4904y.f17871a) {
                                    C4904y.m18646e("PostONMyTable.KEY_BUDDY_NO: " + string + "KEY_JOINED_NAME: " + string2 + "KEY_POSTON: " + string3, MyPageFragment.f17192a);
                                }
                            }
                            if (this.f17412a.f17276w != null) {
                                if (this.f17412a.f17214S == null || !"true".equals(this.f17412a.f17214S)) {
                                    this.f17412a.f17276w.setVisibility(8);
                                } else {
                                    this.f17412a.f17276w.setVisibility(0);
                                }
                            }
                            if (this.f17412a.f17244am != null) {
                                this.f17412a.f17244am.notifyDataSetChanged();
                            } else {
                                this.f17412a.f17244am = new C3009d(this.f17412a.f17261h, this.f17412a.getActivity(), this.f17412a.f17245an, R.layout.list_item_common_9, this.f17412a.f17209N);
                                this.f17412a.f17261h.setAdapter((ListAdapter) this.f17412a.f17244am);
                            }
                        }
                        if (C4904y.f17871a) {
                            C4904y.m18646e("queryPostONList. PostON list Updated", MyPageFragment.f17192a);
                        }
                    } finally {
                    }
                } catch (Exception e) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, getClass().getSimpleName());
                    }
                }
                return;
            }
            return;
        }
        if (i == 6) {
            try {
                if (cursor != null) {
                    try {
                        if (C4904y.f17871a) {
                            C4904y.m18646e("queryProfileImage End. Profile image list count: " + cursor.getCount(), MyPageFragment.f17192a);
                        }
                        this.f17412a.f17246ao.clear();
                        if (cursor.getCount() == 0) {
                            this.f17412a.f17267n.setVisibility(0);
                            C4754bm.m18044a(this.f17412a.f17269p, this.f17412a.f17209N);
                            C4754bm.m18056b(this.f17412a.f17270q, this.f17412a.f17209N);
                            C4754bm.m18056b(this.f17412a.f17271r, this.f17412a.f17209N);
                            C4754bm.m18056b(this.f17412a.f17272s, this.f17412a.f17209N);
                            this.f17412a.f17269p.setOnClickListener(this.f17412a.f17227aF);
                            this.f17412a.f17273t.setVisibility(8);
                        } else {
                            if (cursor.getCount() > 3) {
                                this.f17412a.f17273t.setVisibility(0);
                            } else {
                                this.f17412a.f17273t.setVisibility(8);
                            }
                            this.f17412a.f17267n.setVisibility(8);
                            while (cursor.moveToNext() && cursor.getPosition() < 4) {
                                String string9 = cursor.getString(cursor.getColumnIndex("profile_image_id"));
                                String string10 = cursor.getString(cursor.getColumnIndex("profile_image_url"));
                                String string11 = cursor.getString(cursor.getColumnIndex("represent"));
                                String string12 = cursor.getString(cursor.getColumnIndex("regdttm"));
                                if (cursor.getPosition() != 0) {
                                    this.f17412a.f17246ao.add(new C4757bp(string9, string10, string11, string12, this.f17412a.f17246ao.size() + 1));
                                } else if (string11.equals(Spam.ACTIVITY_REPORT)) {
                                    C4754bm.m18050a(string9, string10, (ImageView) this.f17412a.f17269p, true, this.f17412a.f17209N, this.f17412a.f17223aB);
                                } else {
                                    C4754bm.m18044a(this.f17412a.f17269p, this.f17412a.f17209N);
                                    this.f17412a.f17246ao.add(new C4757bp(string9, string10, string11, string12, this.f17412a.f17246ao.size() + 1));
                                }
                                if (C4904y.f17871a) {
                                    C4904y.m18646e("ProfileImageTable.KEY_PROFILE_IMAGE_ID: " + string9 + " / KEY_PROFILE_IMAGE_URL: " + string10 + " / KEY_REPRESENT: " + string11, MyPageFragment.f17192a);
                                }
                            }
                            C4754bm.m18043a(this.f17412a.f17270q, this.f17412a.f17271r, this.f17412a.f17272s, this.f17412a.f17209N, (ArrayList<C4757bp>) this.f17412a.f17246ao, this.f17412a.f17223aB);
                            this.f17412a.f17269p.setOnClickListener(this.f17412a.f17226aE);
                        }
                        if (C4904y.f17871a) {
                            C4904y.m18646e("queryProfileImage End. Profile image Setting End.", MyPageFragment.f17192a);
                        }
                    } catch (Exception e2) {
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e2, getClass().getSimpleName());
                        }
                    }
                }
            } finally {
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
