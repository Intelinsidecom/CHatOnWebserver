package android.support.v4.view;

import android.content.Context;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import java.util.Locale;

/* compiled from: PagerTitleStripIcs.java */
/* renamed from: android.support.v4.view.an */
/* loaded from: classes.dex */
class C0153an extends SingleLineTransformationMethod {

    /* renamed from: a */
    private Locale f466a;

    public C0153an(Context context) {
        this.f466a = context.getResources().getConfiguration().locale;
    }

    @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        CharSequence transformation = super.getTransformation(charSequence, view);
        if (transformation != null) {
            return transformation.toString().toUpperCase(this.f466a);
        }
        return null;
    }
}
