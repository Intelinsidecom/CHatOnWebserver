package android.support.v4.widget;

import android.database.Cursor;

/* renamed from: android.support.v4.widget.d */
/* loaded from: classes.dex */
interface InterfaceC0046d {
    void changeCursor(Cursor cursor);

    CharSequence convertToString(Cursor cursor);

    Cursor getCursor();

    Cursor runQueryOnBackgroundThread(CharSequence charSequence);
}
