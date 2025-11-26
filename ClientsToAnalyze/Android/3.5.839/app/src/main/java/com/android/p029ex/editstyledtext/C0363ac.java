package com.android.p029ex.editstyledtext;

/* compiled from: EditStyledText.java */
/* renamed from: com.android.ex.editstyledtext.ac */
/* loaded from: classes.dex */
public class C0363ac extends C0364ad {

    /* renamed from: a */
    final /* synthetic */ C0392c f880a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0363ac(C0392c c0392c) {
        super(c0392c);
        this.f880a = c0392c;
    }

    @Override // com.android.p029ex.editstyledtext.C0364ad, com.android.p029ex.editstyledtext.C0400k
    /* renamed from: d */
    protected boolean mo1304d() {
        if (!super.mo1304d()) {
            Object objA = m1463a(0);
            if (objA != null && (objA instanceof Integer)) {
                this.f880a.f953b.onTextContextMenuItem(((Integer) objA).intValue());
            }
            this.f880a.f954c.m1332I();
        }
        return true;
    }
}
