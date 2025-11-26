package android.support.v4.content;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

/* loaded from: classes.dex */
public class CursorLoader extends AsyncTaskLoader {

    /* renamed from: h */
    final Loader.ForceLoadContentObserver f115h;

    /* renamed from: i */
    Uri f116i;

    /* renamed from: j */
    String[] f117j;

    /* renamed from: k */
    String f118k;

    /* renamed from: l */
    String[] f119l;

    /* renamed from: m */
    String f120m;

    /* renamed from: n */
    Cursor f121n;

    public CursorLoader(Context context) {
        super(context);
        this.f115h = new Loader.ForceLoadContentObserver();
    }

    public CursorLoader(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        super(context);
        this.f115h = new Loader.ForceLoadContentObserver();
        this.f116i = uri;
        this.f117j = strArr;
        this.f118k = str;
        this.f119l = strArr2;
        this.f120m = str2;
    }

    @Override // android.support.v4.content.Loader
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo143a(Cursor cursor) {
        if (m156e()) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        Cursor cursor2 = this.f121n;
        this.f121n = cursor;
        if (m154c()) {
            super.mo143a((Object) cursor);
        }
        if (cursor2 == null || cursor2 == cursor || cursor2.isClosed()) {
            return;
        }
        cursor2.close();
    }

    /* renamed from: a */
    void m142a(Cursor cursor, ContentObserver contentObserver) {
        cursor.registerContentObserver(this.f115h);
    }

    @Override // android.support.v4.content.AsyncTaskLoader, android.support.v4.content.Loader
    /* renamed from: a */
    public void mo133a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.mo133a(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.f116i);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.f117j));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.f118k);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.f119l));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.f120m);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.f121n);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.f128g);
    }

    @Override // android.support.v4.content.AsyncTaskLoader
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void mo135c(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        cursor.close();
    }

    @Override // android.support.v4.content.Loader
    /* renamed from: g */
    protected void mo145g() {
        if (this.f121n != null) {
            mo143a(this.f121n);
        }
        if (m163p() || this.f121n == null) {
            m158h();
        }
    }

    @Override // android.support.v4.content.Loader
    /* renamed from: k */
    protected void mo146k() {
        m138t();
    }

    @Override // android.support.v4.content.Loader
    /* renamed from: o */
    protected void mo147o() {
        super.mo147o();
        mo146k();
        if (this.f121n != null && !this.f121n.isClosed()) {
            this.f121n.close();
        }
        this.f121n = null;
    }

    @Override // android.support.v4.content.AsyncTaskLoader
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public Cursor mo137s() {
        Cursor cursorQuery = m149a().getContentResolver().query(this.f116i, this.f117j, this.f118k, this.f119l, this.f120m);
        if (cursorQuery != null) {
            cursorQuery.getCount();
            m142a(cursorQuery, this.f115h);
        }
        return cursorQuery;
    }
}
