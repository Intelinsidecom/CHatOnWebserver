package com.sec.chaton.msgbox;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.util.C4874cl;
import com.sec.chaton.util.C4904y;

/* compiled from: MsgboxSelectionFragment.java */
/* renamed from: com.sec.chaton.msgbox.bo */
/* loaded from: classes.dex */
class C2650bo implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ MsgboxSelectionFragment f9508a;

    C2650bo(MsgboxSelectionFragment msgboxSelectionFragment) {
        this.f9508a = msgboxSelectionFragment;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7099a(int i, Object obj, int i2) {
        C4904y.m18644d("result:" + i2);
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
        if (this.f9508a.f9380H) {
            if (cursor != null) {
                cursor.close();
            }
            return;
        }
        if (this.f9508a.getActivity() != null) {
            switch (i) {
                case 1:
                    this.f9508a.f9409u.setVisibility(8);
                    this.f9508a.f9395W = 0;
                    if (cursor == null || cursor.getCount() == 0) {
                        this.f9508a.f9410v.setVisibility(8);
                        this.f9508a.m11118g();
                        this.f9508a.f9412x.setVisibility(8);
                        if (cursor != null) {
                            this.f9508a.m11103a(cursor);
                        }
                    } else {
                        this.f9508a.f9395W = cursor.getCount();
                        this.f9508a.f9410v.setVisibility(0);
                        this.f9508a.m11120h();
                        if (3 != this.f9508a.f9385M) {
                            this.f9508a.f9412x.setVisibility(0);
                            if (this.f9508a.f9374B != -1 && this.f9508a.f9374B != cursor.getCount()) {
                                this.f9508a.f9413y = false;
                                this.f9508a.f9412x.setChecked(false);
                            }
                            this.f9508a.f9374B = cursor.getCount();
                        }
                    }
                    Cursor cursorB = this.f9508a.f9411w.mo877b(cursor);
                    if (cursorB != null) {
                        this.f9508a.m11103a(cursorB);
                    }
                    if (this.f9508a.f9408t != null) {
                        this.f9508a.f9408t.setVisibility(0);
                        break;
                    }
                    break;
                case 2:
                    this.f9508a.f9394V = true;
                    this.f9508a.f9411w.m11159b(C4874cl.m18505a((String) obj));
                    if (cursor == null || cursor.getCount() == 0) {
                        this.f9508a.f9392T.setVisibility(0);
                        this.f9508a.f9410v.setVisibility(8);
                        if (cursor != null) {
                            this.f9508a.m11103a(cursor);
                            break;
                        }
                    } else {
                        this.f9508a.f9392T.setVisibility(8);
                        this.f9508a.f9410v.setVisibility(0);
                        Cursor cursorB2 = this.f9508a.f9411w.mo877b(cursor);
                        if (cursorB2 != null) {
                            this.f9508a.m11103a(cursorB2);
                            break;
                        }
                    }
                    break;
                default:
                    if ((cursor == null || cursor.getCount() == 0) && cursor != null) {
                        cursor.close();
                        break;
                    }
                    break;
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
