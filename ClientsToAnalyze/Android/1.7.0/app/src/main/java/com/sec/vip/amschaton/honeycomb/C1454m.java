package com.sec.vip.amschaton.honeycomb;

import android.widget.BaseAdapter;
import com.sec.vip.amschaton.C1561z;

/* compiled from: AMSStampSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.m */
/* loaded from: classes.dex */
public class C1454m extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionActivity f5099a;

    /* renamed from: b */
    private C1561z f5100b;

    public C1454m(AMSStampSelectionActivity aMSStampSelectionActivity) {
        this.f5099a = aMSStampSelectionActivity;
        this.f5100b = aMSStampSelectionActivity.f5026s;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f5100b == null) {
            return 0;
        }
        return this.f5100b.m5662b() + this.f5100b.m5665c() + 1;
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
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.honeycomb.C1454m.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    /* renamed from: a */
    public void m5282a() {
        notifyDataSetChanged();
    }
}
