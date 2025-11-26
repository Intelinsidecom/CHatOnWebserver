package com.samsung.sdraw;

/* renamed from: com.samsung.sdraw.bc */
/* loaded from: classes.dex */
class C1017bc implements InterfaceC1011ax {

    /* renamed from: a */
    protected boolean f1555a = false;

    @Override // com.samsung.sdraw.InterfaceC1011ax
    public void deselect() {
        this.f1555a = false;
    }

    @Override // com.samsung.sdraw.InterfaceC1011ax
    public boolean isSelected() {
        return this.f1555a;
    }

    @Override // com.samsung.sdraw.InterfaceC1011ax
    public void select() {
        this.f1555a = true;
    }
}
