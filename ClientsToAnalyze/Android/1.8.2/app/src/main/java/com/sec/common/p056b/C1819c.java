package com.sec.common.p056b;

import android.content.Context;
import android.database.DataSetObservable;
import com.sec.common.p056b.p060d.C1828c;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: MruDataManager.java */
/* renamed from: com.sec.common.b.c */
/* loaded from: classes.dex */
public class C1819c extends DataSetObservable {

    /* renamed from: a */
    private static final String f6515a = C1819c.class.getSimpleName();

    /* renamed from: b */
    private Context f6516b;

    /* renamed from: c */
    private String f6517c;

    /* renamed from: d */
    private int f6518d;

    /* renamed from: e */
    private List f6519e = new LinkedList();

    public C1819c(Context context, String str, int i) throws Exception {
        this.f6516b = context;
        this.f6517c = str;
        this.f6518d = i;
        m6168b();
    }

    /* renamed from: a */
    public String[] m6171a() {
        return (String[]) this.f6519e.toArray(new String[0]);
    }

    /* renamed from: a */
    public void m6170a(List list, boolean z) throws IOException {
        if (list != null && list.size() != 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                int iIndexOf = this.f6519e.indexOf(str);
                if (iIndexOf != -1) {
                    this.f6519e.remove(iIndexOf);
                }
                this.f6519e.add(0, str);
                if (this.f6519e.size() > this.f6518d) {
                    this.f6519e.remove(this.f6519e.size() - 1);
                }
            }
            m6169c();
            if (z) {
                notifyChanged();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0065 A[LOOP:0: B:27:0x0063->B:28:0x0065, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m6168b() throws java.lang.Exception {
        /*
            r7 = this;
            r1 = 0
            r3 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Exception -> L9f
            android.content.Context r0 = r7.f6516b     // Catch: java.lang.Exception -> L9f
            java.io.File r0 = r0.getFilesDir()     // Catch: java.lang.Exception -> L9f
            java.lang.String r4 = r7.f6517c     // Catch: java.lang.Exception -> L9f
            r2.<init>(r0, r4)     // Catch: java.lang.Exception -> L9f
            boolean r0 = r2.exists()     // Catch: java.lang.Exception -> L3e
            if (r0 == 0) goto L5b
            android.content.Context r0 = r7.f6516b     // Catch: java.lang.Exception -> L3e
            java.lang.String r4 = r7.f6517c     // Catch: java.lang.Exception -> L3e
            java.io.FileInputStream r0 = r0.openFileInput(r4)     // Catch: java.lang.Exception -> L3e
            java.io.ObjectInputStream r4 = new java.io.ObjectInputStream     // Catch: java.lang.Exception -> L3e
            r4.<init>(r0)     // Catch: java.lang.Exception -> L3e
            java.lang.Object r0 = r4.readObject()     // Catch: java.lang.Throwable -> L72
            java.lang.Object[] r0 = (java.lang.Object[]) r0     // Catch: java.lang.Throwable -> L72
            java.lang.Object[] r0 = (java.lang.Object[]) r0     // Catch: java.lang.Throwable -> L72
            if (r4 == 0) goto L2f
            r4.close()     // Catch: java.lang.Exception -> L3e
        L2f:
            if (r0 == 0) goto L5c
            int r4 = r0.length     // Catch: java.lang.Exception -> L3e
            int r5 = r7.f6518d     // Catch: java.lang.Exception -> L3e
            if (r4 <= r5) goto L5c
            java.lang.Exception r0 = new java.lang.Exception     // Catch: java.lang.Exception -> L3e
            java.lang.String r4 = "Saved data length is bigger than limit count."
            r0.<init>(r4)     // Catch: java.lang.Exception -> L3e
            throw r0     // Catch: java.lang.Exception -> L3e
        L3e:
            r0 = move-exception
        L3f:
            com.sec.common.b.d.a r4 = com.sec.common.p056b.C1825d.f6539a
            boolean r4 = r4.f6544e
            if (r4 == 0) goto L50
            com.sec.common.b.d.a r4 = com.sec.common.p056b.C1825d.f6539a
            java.lang.String r5 = com.sec.common.p056b.C1819c.f6515a
            java.lang.String r6 = r0.getMessage()
            r4.m6201a(r5, r6, r0)
        L50:
            if (r2 == 0) goto L5b
            boolean r0 = r2.exists()
            if (r0 == 0) goto L5b
            r2.delete()
        L5b:
            r0 = r1
        L5c:
            if (r0 != 0) goto La2
            java.lang.Object[] r0 = new java.lang.Object[r3]
            r1 = r0
        L61:
            int r4 = r1.length
            r2 = r3
        L63:
            if (r2 >= r4) goto L79
            r0 = r1[r2]
            java.util.List r5 = r7.f6519e
            java.lang.String r0 = (java.lang.String) r0
            r5.add(r0)
            int r0 = r2 + 1
            r2 = r0
            goto L63
        L72:
            r0 = move-exception
            if (r4 == 0) goto L78
            r4.close()     // Catch: java.lang.Exception -> L3e
        L78:
            throw r0     // Catch: java.lang.Exception -> L3e
        L79:
            com.sec.common.b.d.a r0 = com.sec.common.p056b.C1825d.f6539a
            boolean r0 = r0.f6541b
            if (r0 == 0) goto L9e
            com.sec.common.b.d.a r0 = com.sec.common.p056b.C1825d.f6539a
            java.lang.String r1 = com.sec.common.p056b.C1819c.f6515a
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r4 = "Loaded data count: "
            r2[r3] = r4
            r3 = 1
            java.util.List r4 = r7.f6519e
            int r4 = r4.size()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2[r3] = r4
            java.lang.String r2 = com.sec.common.p056b.p060d.C1828c.m6207a(r2)
            r0.m6200a(r1, r2)
        L9e:
            return
        L9f:
            r0 = move-exception
            r2 = r1
            goto L3f
        La2:
            r1 = r0
            goto L61
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.common.p056b.C1819c.m6168b():void");
    }

    /* renamed from: c */
    private void m6169c() throws IOException {
        try {
            if (C1825d.f6539a.f6541b) {
                C1825d.f6539a.m6200a(f6515a, C1828c.m6207a("Saving data count: ", Integer.valueOf(this.f6519e.size())));
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(this.f6516b.openFileOutput(this.f6517c, 0));
            try {
                objectOutputStream.writeObject(this.f6519e.toArray());
            } finally {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            }
        } catch (Exception e) {
            if (C1825d.f6539a.f6544e) {
                C1825d.f6539a.m6201a(f6515a, e.getMessage(), e);
            }
        }
    }
}
