package com.sec.chaton.smsplugin.p112ui;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.util.C4874cl;
import com.sec.chaton.util.C4904y;

/* compiled from: ThreadSelectionFragment.java */
/* renamed from: com.sec.chaton.smsplugin.ui.je */
/* loaded from: classes.dex */
class C4339je implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ ThreadSelectionFragment f15769a;

    C4339je(ThreadSelectionFragment threadSelectionFragment) {
        this.f15769a = threadSelectionFragment;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7099a(int i, Object obj, int i2) {
        C4904y.m18644d("result:" + i2);
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
        if (this.f15769a.f15176I) {
            if (cursor != null) {
                cursor.close();
            }
            return;
        }
        if (this.f15769a.getActivity() != null) {
            switch (i) {
                case 1:
                    this.f15769a.f15205v.setVisibility(8);
                    if (cursor == null || cursor.getCount() == 0) {
                        this.f15769a.f15206w.setVisibility(8);
                        this.f15769a.m16259d();
                        this.f15769a.f15208y.setVisibility(8);
                    } else {
                        this.f15769a.f15206w.setVisibility(0);
                        this.f15769a.m16260e();
                        if (3 != this.f15769a.f15180M) {
                            this.f15769a.f15208y.setVisibility(0);
                            if (this.f15769a.f15170C != -1 && this.f15769a.f15170C != cursor.getCount()) {
                                this.f15769a.f15209z = false;
                                this.f15769a.f15208y.setChecked(false);
                            }
                            this.f15769a.f15170C = cursor.getCount();
                        }
                    }
                    Cursor cursorB = this.f15769a.f15207x.mo877b(cursor);
                    if (cursorB != null) {
                        this.f15769a.m16248a(cursorB);
                    }
                    if (this.f15769a.f15204u != null) {
                        this.f15769a.f15204u.setVisibility(0);
                        break;
                    }
                    break;
                case 2:
                    this.f15769a.f15189V = true;
                    this.f15769a.f15207x.m16507a(C4874cl.m18505a((String) obj));
                    if (cursor == null || cursor.getCount() == 0) {
                        this.f15769a.f15187T.setVisibility(0);
                        this.f15769a.f15206w.setVisibility(8);
                        break;
                    } else {
                        this.f15769a.f15187T.setVisibility(8);
                        this.f15769a.f15206w.setVisibility(0);
                        this.f15769a.f15207x.mo875a(cursor);
                        break;
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
