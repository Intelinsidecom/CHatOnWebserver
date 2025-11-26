package com.sec.vip.amschaton.ics;

import android.widget.BaseAdapter;
import com.sec.vip.amschaton.C1849ai;

/* compiled from: AMSStampSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.cd */
/* loaded from: classes.dex */
public class C2035cd extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionActivity f7323a;

    /* renamed from: b */
    private C1849ai f7324b;

    public C2035cd(AMSStampSelectionActivity aMSStampSelectionActivity) {
        this.f7323a = aMSStampSelectionActivity;
        this.f7324b = aMSStampSelectionActivity.f7239t;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f7324b == null) {
            return 0;
        }
        return this.f7324b.m6402b() + this.f7324b.m6405c() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011b A[PHI: r0
  0x011b: PHI (r0v17 android.graphics.Bitmap) = (r0v16 android.graphics.Bitmap), (r0v26 android.graphics.Bitmap) binds: [B:36:0x00ec, B:31:0x00ce] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View getView(int r9, android.view.View r10, android.view.ViewGroup r11) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.ics.C2035cd.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    /* renamed from: a */
    public void m7169a() {
        notifyDataSetChanged();
    }
}
