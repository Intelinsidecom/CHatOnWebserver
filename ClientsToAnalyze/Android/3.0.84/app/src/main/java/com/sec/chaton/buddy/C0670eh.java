package com.sec.chaton.buddy;

import android.net.Uri;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;

/* compiled from: BuddyInfoFragment.java */
/* renamed from: com.sec.chaton.buddy.eh */
/* loaded from: classes.dex */
class C0670eh implements InterfaceC1378v {

    /* renamed from: a */
    final /* synthetic */ BuddyInfoFragment f2891a;

    C0670eh(BuddyInfoFragment buddyInfoFragment) {
        this.f2891a = buddyInfoFragment;
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0427, code lost:
    
        r2 = r3.getString(r3.getColumnIndex("data1"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0435, code lost:
    
        if (android.text.TextUtils.isEmpty(r2) != false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0437, code lost:
    
        r30.f2891a.f1979i = r2;
     */
    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onQueryComplete(int r31, java.lang.Object r32, android.database.Cursor r33) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.C0670eh.onQueryComplete(int, java.lang.Object, android.database.Cursor):void");
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
