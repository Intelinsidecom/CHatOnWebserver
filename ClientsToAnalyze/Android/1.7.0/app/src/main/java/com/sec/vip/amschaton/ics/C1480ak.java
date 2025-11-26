package com.sec.vip.amschaton.ics;

import android.widget.BaseAdapter;
import com.sec.vip.amschaton.C1561z;

/* compiled from: AMSStampSelectionActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.ak */
/* loaded from: classes.dex */
public class C1480ak extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionActivity f5292a;

    /* renamed from: b */
    private C1561z f5293b;

    public C1480ak(AMSStampSelectionActivity aMSStampSelectionActivity) {
        this.f5292a = aMSStampSelectionActivity;
        this.f5293b = aMSStampSelectionActivity.f5271s;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f5293b == null) {
            return 0;
        }
        return this.f5293b.m5662b() + this.f5293b.m5665c() + 1;
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
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.ics.C1480ak.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    /* renamed from: a */
    public void m5601a() {
        notifyDataSetChanged();
    }
}
