package android.support.v4.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.C0094f;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

/* compiled from: CursorLoader.java */
/* renamed from: android.support.v4.content.c */
/* loaded from: classes.dex */
public class C0091c extends AbstractC0090a<Cursor> {

    /* renamed from: f */
    final C0094f<Cursor>.g f298f;

    /* renamed from: g */
    Uri f299g;

    /* renamed from: h */
    String[] f300h;

    /* renamed from: i */
    String f301i;

    /* renamed from: j */
    String[] f302j;

    /* renamed from: k */
    String f303k;

    /* renamed from: l */
    Cursor f304l;

    @Override // android.support.v4.content.AbstractC0090a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Cursor mo326d() {
        Cursor cursorQuery = m343j().getContentResolver().query(this.f299g, this.f300h, this.f301i, this.f302j, this.f303k);
        if (cursorQuery != null) {
            cursorQuery.getCount();
            cursorQuery.registerContentObserver(this.f298f);
        }
        return cursorQuery;
    }

    @Override // android.support.v4.content.C0094f
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo332b(Cursor cursor) {
        if (m347n()) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        Cursor cursor2 = this.f304l;
        this.f304l = cursor;
        if (m345l()) {
            super.mo332b((C0091c) cursor);
        }
        if (cursor2 != null && cursor2 != cursor && !cursor2.isClosed()) {
            cursor2.close();
        }
    }

    public C0091c(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        super(context);
        this.f298f = new C0094f.g();
        this.f299g = uri;
        this.f300h = strArr;
        this.f301i = str;
        this.f302j = strArr2;
        this.f303k = str2;
    }

    @Override // android.support.v4.content.C0094f
    /* renamed from: g */
    protected void mo334g() {
        if (this.f304l != null) {
            mo332b(this.f304l);
        }
        if (m354u() || this.f304l == null) {
            m349p();
        }
    }

    @Override // android.support.v4.content.C0094f
    /* renamed from: h */
    protected void mo335h() {
        m324b();
    }

    @Override // android.support.v4.content.AbstractC0090a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void mo321a(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    @Override // android.support.v4.content.C0094f
    /* renamed from: i */
    protected void mo336i() {
        super.mo336i();
        mo335h();
        if (this.f304l != null && !this.f304l.isClosed()) {
            this.f304l.close();
        }
        this.f304l = null;
    }

    @Override // android.support.v4.content.AbstractC0090a, android.support.v4.content.C0094f
    /* renamed from: a */
    public void mo322a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.mo322a(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.f299g);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.f300h));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.f301i);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.f302j));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.f303k);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.f304l);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.f313s);
    }
}
