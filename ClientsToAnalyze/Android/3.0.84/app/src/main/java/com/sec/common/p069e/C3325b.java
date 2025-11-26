package com.sec.common.p069e;

import android.content.Context;
import android.database.DataSetObservable;
import com.sec.common.C3330f;
import com.sec.common.util.C3364o;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

/* compiled from: MruDataManager.java */
/* renamed from: com.sec.common.e.b */
/* loaded from: classes.dex */
public class C3325b extends DataSetObservable {

    /* renamed from: a */
    private static final String f12015a = C3325b.class.getSimpleName();

    /* renamed from: b */
    private Context f12016b;

    /* renamed from: c */
    private String f12017c;

    /* renamed from: d */
    private int f12018d;

    /* renamed from: e */
    private List<String> f12019e = new LinkedList();

    public C3325b(Context context, String str, int i) throws Exception {
        this.f12016b = context;
        this.f12017c = str;
        this.f12018d = i;
        m11717c();
    }

    /* renamed from: a */
    public String[] m11720a() {
        return (String[]) this.f12019e.toArray(new String[0]);
    }

    /* renamed from: a */
    public void m11719a(List<String> list, boolean z) throws IOException {
        if (list != null && list.size() != 0) {
            for (String str : list) {
                int iIndexOf = this.f12019e.indexOf(str);
                if (iIndexOf != -1) {
                    this.f12019e.remove(iIndexOf);
                }
                this.f12019e.add(0, str);
                if (this.f12019e.size() > this.f12018d) {
                    this.f12019e.remove(this.f12019e.size() - 1);
                }
            }
            m11718d();
            if (z) {
                notifyChanged();
            }
        }
    }

    /* renamed from: b */
    public void m11721b() throws IOException {
        this.f12019e.clear();
        m11718d();
        notifyChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0065 A[LOOP:0: B:27:0x0063->B:28:0x0065, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m11717c() throws java.lang.Exception {
        /*
            r7 = this;
            r1 = 0
            r3 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Exception -> L9f
            android.content.Context r0 = r7.f12016b     // Catch: java.lang.Exception -> L9f
            java.io.File r0 = r0.getFilesDir()     // Catch: java.lang.Exception -> L9f
            java.lang.String r4 = r7.f12017c     // Catch: java.lang.Exception -> L9f
            r2.<init>(r0, r4)     // Catch: java.lang.Exception -> L9f
            boolean r0 = r2.exists()     // Catch: java.lang.Exception -> L3e
            if (r0 == 0) goto L5b
            android.content.Context r0 = r7.f12016b     // Catch: java.lang.Exception -> L3e
            java.lang.String r4 = r7.f12017c     // Catch: java.lang.Exception -> L3e
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
            int r5 = r7.f12018d     // Catch: java.lang.Exception -> L3e
            if (r4 <= r5) goto L5c
            java.lang.Exception r0 = new java.lang.Exception     // Catch: java.lang.Exception -> L3e
            java.lang.String r4 = "Saved data length is bigger than limit count."
            r0.<init>(r4)     // Catch: java.lang.Exception -> L3e
            throw r0     // Catch: java.lang.Exception -> L3e
        L3e:
            r0 = move-exception
        L3f:
            com.sec.common.c.a r4 = com.sec.common.C3330f.f12033a
            boolean r4 = r4.f11975e
            if (r4 == 0) goto L50
            com.sec.common.c.a r4 = com.sec.common.C3330f.f12033a
            java.lang.String r5 = com.sec.common.p069e.C3325b.f12015a
            java.lang.String r6 = r0.getMessage()
            r4.m11652a(r5, r6, r0)
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
            java.util.List<java.lang.String> r5 = r7.f12019e
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
            com.sec.common.c.a r0 = com.sec.common.C3330f.f12033a
            boolean r0 = r0.f11972b
            if (r0 == 0) goto L9e
            com.sec.common.c.a r0 = com.sec.common.C3330f.f12033a
            java.lang.String r1 = com.sec.common.p069e.C3325b.f12015a
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r4 = "Loaded data count: "
            r2[r3] = r4
            r3 = 1
            java.util.List<java.lang.String> r4 = r7.f12019e
            int r4 = r4.size()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2[r3] = r4
            java.lang.String r2 = com.sec.common.util.C3364o.m11849a(r2)
            r0.m11651a(r1, r2)
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
        throw new UnsupportedOperationException("Method not decompiled: com.sec.common.p069e.C3325b.m11717c():void");
    }

    /* renamed from: d */
    private void m11718d() throws IOException {
        try {
            if (C3330f.f12033a.f11972b) {
                C3330f.f12033a.m11651a(f12015a, C3364o.m11849a("Saving data count: ", Integer.valueOf(this.f12019e.size())));
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(this.f12016b.openFileOutput(this.f12017c, 0));
            try {
                objectOutputStream.writeObject(this.f12019e.toArray());
            } finally {
                objectOutputStream.close();
            }
        } catch (Exception e) {
            if (C3330f.f12033a.f11975e) {
                C3330f.f12033a.m11652a(f12015a, e.getMessage(), e);
            }
        }
    }
}
