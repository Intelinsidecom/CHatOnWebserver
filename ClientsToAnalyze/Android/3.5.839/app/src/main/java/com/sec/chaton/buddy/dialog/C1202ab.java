package com.sec.chaton.buddy.dialog;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.userprofile.C4754bm;
import com.sec.chaton.userprofile.C4757bp;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

/* compiled from: MeDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.ab */
/* loaded from: classes.dex */
class C1202ab implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ MeDialog f4697a;

    C1202ab(MeDialog meDialog) {
        this.f4697a = meDialog;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
        if (i == 6) {
            try {
                if (cursor != null) {
                    try {
                        if (C4904y.f17871a) {
                            C4904y.m18646e("Profile image list count: " + cursor.getCount(), MeDialog.f4578a);
                        }
                        this.f4697a.f4597S.clear();
                        if (cursor.getCount() == 0) {
                            C4754bm.m18044a(this.f4697a.f4622w, this.f4697a.f4609j);
                            C4754bm.m18056b(this.f4697a.f4623x, this.f4697a.f4609j);
                            C4754bm.m18056b(this.f4697a.f4624y, this.f4697a.f4609j);
                            C4754bm.m18056b(this.f4697a.f4625z, this.f4697a.f4609j);
                            this.f4697a.f4583E.setVisibility(8);
                        } else {
                            if (cursor.getCount() > 3) {
                                this.f4697a.f4583E.setVisibility(0);
                            } else {
                                this.f4697a.f4583E.setVisibility(8);
                            }
                            while (cursor.moveToNext() && cursor.getPosition() < 4) {
                                String string = cursor.getString(cursor.getColumnIndex("profile_image_id"));
                                String string2 = cursor.getString(cursor.getColumnIndex("profile_image_url"));
                                String string3 = cursor.getString(cursor.getColumnIndex("represent"));
                                String string4 = cursor.getString(cursor.getColumnIndex("regdttm"));
                                if (cursor.getPosition() != 0) {
                                    this.f4697a.f4597S.add(new C4757bp(string, string2, string3, string4, this.f4697a.f4597S.size() + 1));
                                } else if (string3.equals(Spam.ACTIVITY_REPORT)) {
                                    C4754bm.m18050a(string, string2, this.f4697a.f4622w, true, this.f4697a.f4609j, this.f4697a.f4600V);
                                } else {
                                    C4754bm.m18044a(this.f4697a.f4622w, this.f4697a.f4609j);
                                    this.f4697a.f4597S.add(new C4757bp(string, string2, string3, string4, this.f4697a.f4597S.size() + 1));
                                }
                                if (C4904y.f17871a) {
                                    C4904y.m18646e("ProfileImageTable.KEY_PROFILE_IMAGE_ID: " + string + " / KEY_PROFILE_IMAGE_URL: " + string2 + " / KEY_REPRESENT: " + string3, MeDialog.f4578a);
                                }
                            }
                            C4754bm.m18043a(this.f4697a.f4623x, this.f4697a.f4624y, this.f4697a.f4625z, this.f4697a.f4609j, (ArrayList<C4757bp>) this.f4697a.f4597S, this.f4697a.f4600V);
                        }
                    } catch (Exception e) {
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e, getClass().getSimpleName());
                        }
                    }
                }
            } finally {
                cursor.close();
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
