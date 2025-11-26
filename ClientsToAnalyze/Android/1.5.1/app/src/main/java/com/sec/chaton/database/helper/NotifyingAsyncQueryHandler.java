package com.sec.chaton.database.helper;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class NotifyingAsyncQueryHandler extends AsyncQueryHandler {

    /* renamed from: a */
    private WeakReference f1775a;

    public interface AsyncQueryListener {
        /* renamed from: a */
        void mo529a(int i, Object obj, int i2);

        /* renamed from: a */
        void mo530a(int i, Object obj, Cursor cursor);

        /* renamed from: a */
        void mo531a(int i, Object obj, Uri uri);

        /* renamed from: b */
        void mo534b(int i, Object obj, int i2);
    }

    public NotifyingAsyncQueryHandler(ContentResolver contentResolver, AsyncQueryListener asyncQueryListener) {
        super(contentResolver);
        m2302a(asyncQueryListener);
    }

    /* renamed from: a */
    public void m2302a(AsyncQueryListener asyncQueryListener) {
        this.f1775a = new WeakReference(asyncQueryListener);
    }

    @Override // android.content.AsyncQueryHandler
    protected void onDeleteComplete(int i, Object obj, int i2) {
        AsyncQueryListener asyncQueryListener = this.f1775a == null ? null : (AsyncQueryListener) this.f1775a.get();
        if (asyncQueryListener != null) {
            asyncQueryListener.mo534b(i, obj, i2);
        }
    }

    @Override // android.content.AsyncQueryHandler
    protected void onInsertComplete(int i, Object obj, Uri uri) {
        AsyncQueryListener asyncQueryListener = this.f1775a == null ? null : (AsyncQueryListener) this.f1775a.get();
        if (asyncQueryListener != null) {
            asyncQueryListener.mo531a(i, obj, uri);
        }
    }

    @Override // android.content.AsyncQueryHandler
    protected void onQueryComplete(int i, Object obj, Cursor cursor) {
        AsyncQueryListener asyncQueryListener = this.f1775a == null ? null : (AsyncQueryListener) this.f1775a.get();
        if (asyncQueryListener != null) {
            asyncQueryListener.mo530a(i, obj, cursor);
        } else if (cursor != null) {
            cursor.close();
        }
    }

    @Override // android.content.AsyncQueryHandler
    protected void onUpdateComplete(int i, Object obj, int i2) {
        AsyncQueryListener asyncQueryListener = this.f1775a == null ? null : (AsyncQueryListener) this.f1775a.get();
        if (asyncQueryListener != null) {
            asyncQueryListener.mo529a(i, obj, i2);
        }
    }
}
