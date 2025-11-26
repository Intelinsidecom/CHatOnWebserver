package com.android.p029ex.editstyledtext;

/* compiled from: EditStyledText.java */
/* renamed from: com.android.ex.editstyledtext.an */
/* loaded from: classes.dex */
class C0374an {

    /* renamed from: a */
    final /* synthetic */ EditStyledText f915a;

    /* renamed from: b */
    private EditStyledText f916b;

    /* renamed from: c */
    private InterfaceC0389bb f917c;

    public C0374an(EditStyledText editStyledText, EditStyledText editStyledText2, InterfaceC0389bb interfaceC0389bb) {
        this.f915a = editStyledText;
        this.f916b = editStyledText2;
        this.f917c = interfaceC0389bb;
    }

    /* renamed from: a */
    public void m1424a(InterfaceC0389bb interfaceC0389bb) {
        this.f917c = interfaceC0389bb;
    }

    /* renamed from: a */
    public void m1425a(String str) {
        this.f916b.setText(this.f917c.mo1451a(str, new C0375ao(this), null));
    }
}
