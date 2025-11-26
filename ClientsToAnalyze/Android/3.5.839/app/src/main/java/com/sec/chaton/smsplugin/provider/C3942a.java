package com.sec.chaton.smsplugin.provider;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.smsplugin.p102b.C3789h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: AsyncSmsInboxTask.java */
@SuppressLint({"NewApi"})
/* renamed from: com.sec.chaton.smsplugin.provider.a */
/* loaded from: classes.dex */
public class C3942a {

    /* renamed from: a */
    public static final String f14207a = C3942a.class.getSimpleName();

    /* renamed from: d */
    private static Looper f14208d = null;

    /* renamed from: b */
    final WeakReference<ContentResolver> f14209b;

    /* renamed from: c */
    private final Handler f14210c;

    public C3942a(ContentResolver contentResolver) {
        this.f14209b = new WeakReference<>(contentResolver);
        synchronized (C3942a.class) {
            if (f14208d == null) {
                HandlerThread handlerThread = new HandlerThread("AsyncSmsInboxHandler");
                handlerThread.start();
                f14208d = handlerThread.getLooper();
            }
        }
        this.f14210c = m15231a(f14208d);
    }

    /* renamed from: a */
    protected Handler m15231a(Looper looper) {
        return new HandlerC3946d(this, looper);
    }

    /* renamed from: a */
    public void m15235a(Handler handler, int i, Object obj, boolean z) {
        if (z) {
            m15228b(handler, i, obj);
        } else {
            m15225a(handler, i, obj);
        }
    }

    /* renamed from: a */
    public void m15236a(Handler handler, int i, Object obj, boolean z, Collection<Long> collection) {
        if (z) {
            m15229b(handler, i, obj, collection);
        } else {
            m15226a(handler, i, obj, collection);
        }
    }

    /* renamed from: a */
    private void m15225a(Handler handler, int i, Object obj) {
        Message messageObtainMessage = this.f14210c.obtainMessage(i);
        messageObtainMessage.arg1 = 3;
        C3945c c3945c = new C3945c();
        c3945c.f14222g = obj;
        c3945c.f14224i = handler;
        messageObtainMessage.obj = c3945c;
        this.f14210c.sendMessage(messageObtainMessage);
    }

    /* renamed from: b */
    private void m15228b(Handler handler, int i, Object obj) {
        Message messageObtainMessage = this.f14210c.obtainMessage(i);
        messageObtainMessage.arg1 = 2;
        C3945c c3945c = new C3945c();
        c3945c.f14222g = obj;
        c3945c.f14224i = handler;
        messageObtainMessage.obj = c3945c;
        this.f14210c.sendMessage(messageObtainMessage);
    }

    /* renamed from: a */
    private void m15226a(Handler handler, int i, Object obj, Collection<Long> collection) {
        Message messageObtainMessage = this.f14210c.obtainMessage(i);
        messageObtainMessage.arg1 = 1;
        C3945c c3945c = new C3945c();
        c3945c.f14222g = obj;
        c3945c.f14216a = collection;
        c3945c.f14224i = handler;
        messageObtainMessage.obj = c3945c;
        this.f14210c.sendMessage(messageObtainMessage);
    }

    /* renamed from: a */
    public void m15242a(Handler handler, Object obj, int i) {
        Message messageObtainMessage = this.f14210c.obtainMessage(i);
        messageObtainMessage.arg1 = 7;
        C3945c c3945c = new C3945c();
        c3945c.f14222g = obj;
        c3945c.f14224i = handler;
        messageObtainMessage.obj = c3945c;
        this.f14210c.sendMessage(messageObtainMessage);
    }

    /* renamed from: b */
    private void m15229b(Handler handler, int i, Object obj, Collection<Long> collection) {
        Message messageObtainMessage = this.f14210c.obtainMessage(i);
        messageObtainMessage.arg1 = 0;
        C3945c c3945c = new C3945c();
        c3945c.f14222g = obj;
        c3945c.f14216a = collection;
        c3945c.f14224i = handler;
        messageObtainMessage.obj = c3945c;
        this.f14210c.sendMessage(messageObtainMessage);
    }

    /* renamed from: a */
    public void m15234a(Handler handler, int i, Object obj, long j, C3789h c3789h) {
        Message messageObtainMessage = this.f14210c.obtainMessage(i);
        messageObtainMessage.arg1 = 4;
        C3945c c3945c = new C3945c();
        c3945c.f14222g = obj;
        c3945c.f14224i = handler;
        c3945c.f14218c = j;
        c3945c.f14221f = c3789h;
        messageObtainMessage.obj = c3945c;
        this.f14210c.sendMessage(messageObtainMessage);
    }

    /* renamed from: a */
    public void m15233a(Handler handler, int i, Object obj, long j) {
        Message messageObtainMessage = this.f14210c.obtainMessage(i);
        messageObtainMessage.arg1 = 18;
        C3945c c3945c = new C3945c();
        c3945c.f14222g = obj;
        c3945c.f14224i = handler;
        c3945c.f14218c = j;
        messageObtainMessage.obj = c3945c;
        this.f14210c.sendMessage(messageObtainMessage);
    }

    /* renamed from: a */
    public void m15237a(Handler handler, int i, Object obj, String[] strArr, long j) {
        m15232a(i);
        Message messageObtainMessage = this.f14210c.obtainMessage(i);
        messageObtainMessage.arg1 = 5;
        C3945c c3945c = new C3945c();
        c3945c.f14222g = obj;
        c3945c.f14224i = handler;
        c3945c.f14225j = strArr;
        c3945c.f14218c = j;
        messageObtainMessage.obj = c3945c;
        this.f14210c.sendMessage(messageObtainMessage);
    }

    /* renamed from: a */
    public void m15238a(Handler handler, int i, Object obj, String[] strArr, long j, int i2) {
        m15232a(i);
        Message messageObtainMessage = this.f14210c.obtainMessage(i);
        messageObtainMessage.arg1 = 17;
        C3945c c3945c = new C3945c();
        c3945c.f14222g = obj;
        c3945c.f14224i = handler;
        c3945c.f14225j = strArr;
        c3945c.f14218c = j;
        messageObtainMessage.arg2 = i2;
        messageObtainMessage.obj = c3945c;
        this.f14210c.sendMessage(messageObtainMessage);
    }

    /* renamed from: b */
    public void m15244b(Handler handler, int i, Object obj, long j) {
        m15232a(i);
        Message messageObtainMessage = this.f14210c.obtainMessage(i);
        messageObtainMessage.arg1 = 19;
        C3945c c3945c = new C3945c();
        c3945c.f14222g = obj;
        c3945c.f14224i = handler;
        c3945c.f14218c = j;
        messageObtainMessage.obj = c3945c;
        this.f14210c.sendMessage(messageObtainMessage);
    }

    /* renamed from: c */
    public void m15245c(Handler handler, int i, Object obj, long j) {
        m15232a(i);
        Message messageObtainMessage = this.f14210c.obtainMessage(i);
        messageObtainMessage.arg1 = 6;
        C3945c c3945c = new C3945c();
        c3945c.f14222g = obj;
        c3945c.f14224i = handler;
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        c3945c.f14216a = arrayList;
        messageObtainMessage.obj = c3945c;
        this.f14210c.sendMessage(messageObtainMessage);
    }

    /* renamed from: a */
    public void m15243a(Handler handler, ArrayList<Uri> arrayList, int i, Object obj, boolean z) {
        Message messageObtainMessage = this.f14210c.obtainMessage(i);
        messageObtainMessage.arg1 = 12;
        C3945c c3945c = new C3945c();
        c3945c.f14222g = obj;
        c3945c.f14224i = handler;
        c3945c.f14217b = z;
        c3945c.f14220e = arrayList;
        messageObtainMessage.obj = c3945c;
        this.f14210c.sendMessage(messageObtainMessage);
    }

    /* renamed from: a */
    public void m15240a(Handler handler, Uri uri, int i, Object obj, boolean z) {
        Message messageObtainMessage = this.f14210c.obtainMessage(i);
        messageObtainMessage.arg1 = 12;
        C3945c c3945c = new C3945c();
        c3945c.f14222g = obj;
        c3945c.f14224i = handler;
        c3945c.f14217b = z;
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(uri);
        c3945c.f14220e = arrayList;
        messageObtainMessage.obj = c3945c;
        this.f14210c.sendMessage(messageObtainMessage);
    }

    /* renamed from: a */
    public void m15241a(Handler handler, Uri uri, long j, int i, Object obj, boolean z) {
        Message messageObtainMessage = this.f14210c.obtainMessage(i);
        messageObtainMessage.arg1 = 16;
        C3945c c3945c = new C3945c();
        c3945c.f14222g = obj;
        c3945c.f14224i = handler;
        c3945c.f14217b = z;
        c3945c.f14218c = j;
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(uri);
        c3945c.f14220e = arrayList;
        messageObtainMessage.obj = c3945c;
        this.f14210c.sendMessage(messageObtainMessage);
    }

    /* renamed from: a */
    public void m15239a(Handler handler, Uri uri, int i, Object obj, String str) {
        Message messageObtainMessage = this.f14210c.obtainMessage(i);
        messageObtainMessage.arg1 = 14;
        C3945c c3945c = new C3945c();
        c3945c.f14222g = obj;
        c3945c.f14224i = handler;
        c3945c.f14219d = uri;
        c3945c.f14226k = str;
        messageObtainMessage.obj = c3945c;
        this.f14210c.sendMessage(messageObtainMessage);
    }

    /* renamed from: d */
    public void m15246d(Handler handler, int i, Object obj, long j) {
        Message messageObtainMessage = this.f14210c.obtainMessage(i);
        messageObtainMessage.arg1 = 15;
        C3945c c3945c = new C3945c();
        c3945c.f14222g = obj;
        c3945c.f14224i = handler;
        c3945c.f14218c = j;
        messageObtainMessage.obj = c3945c;
        this.f14210c.sendMessage(messageObtainMessage);
    }

    /* renamed from: e */
    public void m15247e(Handler handler, int i, Object obj, long j) {
        Message messageObtainMessage = this.f14210c.obtainMessage(i);
        messageObtainMessage.arg1 = 20;
        C3945c c3945c = new C3945c();
        c3945c.f14222g = obj;
        c3945c.f14224i = handler;
        c3945c.f14218c = j;
        messageObtainMessage.obj = c3945c;
        this.f14210c.sendMessage(messageObtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m15224a(Collection<Long> collection) {
        StringBuilder sb = new StringBuilder();
        String str = "";
        Iterator<Long> it = collection.iterator();
        while (true) {
            String str2 = str;
            if (it.hasNext()) {
                Long next = it.next();
                sb.append(str2);
                sb.append("'");
                sb.append(next);
                sb.append("'");
                str = ", ";
            } else {
                return sb.toString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static String m15227b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return TextUtils.isEmpty(str2) ? str : str + " AND " + str2;
    }

    /* renamed from: a */
    public final void m15232a(int i) {
        this.f14210c.removeMessages(i);
    }

    /* renamed from: a */
    public MatrixCursor m15230a(Cursor cursor) {
        MatrixCursor matrixCursor = new MatrixCursor(cursor.getColumnNames());
        cursor.moveToLast();
        while (!cursor.isBeforeFirst()) {
            Object[] objArr = new Object[cursor.getColumnCount()];
            for (int i = 0; i < objArr.length; i++) {
                switch (cursor.getType(i)) {
                    case 0:
                        objArr[i] = null;
                        break;
                    case 1:
                        objArr[i] = Long.valueOf(cursor.getLong(i));
                        break;
                    case 2:
                        objArr[i] = Float.valueOf(cursor.getFloat(i));
                        break;
                    case 3:
                        objArr[i] = cursor.getString(i);
                        break;
                    default:
                        objArr[i] = cursor.getString(i);
                        break;
                }
            }
            matrixCursor.addRow(objArr);
            cursor.moveToPrevious();
        }
        return matrixCursor;
    }
}
