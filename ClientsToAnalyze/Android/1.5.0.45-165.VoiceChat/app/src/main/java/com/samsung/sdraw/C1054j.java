package com.samsung.sdraw;

import android.content.Context;
import android.graphics.RectF;
import android.text.Editable;
import android.text.Layout;
import com.samsung.sdraw.StrokeSprite;

/* renamed from: com.samsung.sdraw.j */
/* loaded from: classes.dex */
class C1054j implements InterfaceC1020bf {

    /* renamed from: a */
    private Context f1749a;

    public C1054j(Context context) {
        this.f1749a = context;
    }

    /* renamed from: a */
    public StrokeSprite m1557a(StrokeSprite.Type type, StrokeSprite.ThicknessParameter thicknessParameter, StrokeSprite.InputMethod inputMethod, float f, int i) {
        StrokeSprite strokeSprite = new StrokeSprite();
        strokeSprite.m1165j();
        strokeSprite.m1140a(type, thicknessParameter, inputMethod, f, i);
        strokeSprite.setBehavior(new C1016bb(strokeSprite), new C1055k(), new C1056l());
        return strokeSprite;
    }

    @Override // com.samsung.sdraw.InterfaceC1020bf
    /* renamed from: a */
    public StrokeSprite mo1401a(StrokeSprite.Type type, StrokeSprite.ThicknessParameter thicknessParameter, StrokeSprite.InputMethod inputMethod, float f, int i, int i2) {
        StrokeSprite strokeSprite = new StrokeSprite();
        strokeSprite.m1165j();
        strokeSprite.m1141a(type, thicknessParameter, inputMethod, f, i, i2);
        strokeSprite.setBehavior(new C1016bb(strokeSprite), new C1055k(), new C1056l());
        return strokeSprite;
    }

    @Override // com.samsung.sdraw.InterfaceC1020bf
    /* renamed from: a */
    public C0989ab mo1404a(float f, float f2, int i, int i2, int i3, int i4) {
        C0989ab c0989ab = new C0989ab();
        c0989ab.m1254a(f, f2, i, i2, i3, i4);
        c0989ab.setBehavior(new C1004aq(c0989ab), new C1015ba(c0989ab), new C1017bc());
        return c0989ab;
    }

    @Override // com.samsung.sdraw.InterfaceC1020bf
    /* renamed from: a */
    public TextSprite mo1402a(int i, int i2, Layout.Alignment alignment, Editable editable, String str) {
        TextSprite textSprite = new TextSprite(this.f1749a);
        textSprite.m1192a(editable, i, i2, alignment);
        textSprite.setBehavior(new C1016bb(textSprite), new C1034bt(textSprite), new C1017bc());
        return textSprite;
    }

    @Override // com.samsung.sdraw.InterfaceC1020bf
    /* renamed from: a */
    public TextSprite mo1403a(int i, int i2, Layout.Alignment alignment, Editable editable, String str, int i3) {
        TextSprite textSprite = new TextSprite(this.f1749a);
        textSprite.m1193a(editable, i, i2, alignment, i3);
        textSprite.setBehavior(new C1016bb(textSprite), new C1034bt(textSprite), new C1017bc());
        return textSprite;
    }

    @Override // com.samsung.sdraw.InterfaceC1020bf
    /* renamed from: a */
    public C1063s mo1405a(AbstractModeContext abstractModeContext, int i, int i2, int i3, RectF rectF, String str, int i4) {
        C1063s c1063s = new C1063s();
        c1063s.m1593a(abstractModeContext, i, i2, i3, rectF, str, i4);
        c1063s.setBehavior(new C1016bb(c1063s), new C1055k(), new C1017bc());
        return c1063s;
    }
}
