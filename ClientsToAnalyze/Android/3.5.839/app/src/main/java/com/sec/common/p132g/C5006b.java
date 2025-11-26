package com.sec.common.p132g;

import android.content.Context;
import android.database.DataSetObservable;
import com.sec.common.C4996f;
import com.sec.common.util.C5052r;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

/* compiled from: MruDataManager.java */
/* renamed from: com.sec.common.g.b */
/* loaded from: classes.dex */
public class C5006b extends DataSetObservable {

    /* renamed from: b */
    private static final String f18264b = C5006b.class.getSimpleName();

    /* renamed from: a */
    protected List<String> f18265a = new LinkedList();

    /* renamed from: c */
    private Context f18266c;

    /* renamed from: d */
    private String f18267d;

    /* renamed from: e */
    private int f18268e;

    public C5006b(Context context, String str, int i) throws Exception {
        this.f18266c = context;
        this.f18267d = str;
        this.f18268e = i;
        m19000c();
    }

    /* renamed from: a */
    public String[] mo11703a() {
        return (String[]) this.f18265a.toArray(new String[0]);
    }

    /* renamed from: a */
    public void m19002a(String str, boolean z) throws IOException {
        int iIndexOf = this.f18265a.indexOf(str);
        if (iIndexOf != -1) {
            this.f18265a.remove(iIndexOf);
        }
        this.f18265a.add(0, str);
        if (this.f18265a.size() > this.f18268e) {
            this.f18265a.remove(this.f18265a.size() - 1);
        }
        m19001d();
        if (z) {
            notifyChanged();
        }
    }

    /* renamed from: a */
    public void m19003a(List<String> list, boolean z) throws IOException {
        if (list != null && list.size() != 0) {
            for (String str : list) {
                int iIndexOf = this.f18265a.indexOf(str);
                if (iIndexOf != -1) {
                    this.f18265a.remove(iIndexOf);
                }
                this.f18265a.add(0, str);
                if (this.f18265a.size() > this.f18268e) {
                    this.f18265a.remove(this.f18265a.size() - 1);
                }
            }
            m19001d();
            if (z) {
                notifyChanged();
            }
        }
    }

    /* renamed from: b */
    public void m19005b(String str, boolean z) throws IOException {
        if (this.f18265a.remove(str)) {
            if (C4996f.f18229a.f18171c) {
                C4996f.f18229a.m18892f(f18264b, C5052r.m19199a(str, " is removed."));
            }
            m19001d();
            notifyChanged();
        }
    }

    /* renamed from: b */
    public void m19004b() throws IOException {
        this.f18265a.clear();
        m19001d();
        notifyChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0064 A[LOOP:0: B:26:0x0062->B:27:0x0064, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m19000c() throws java.lang.Exception {
        /*
            r7 = this;
            r1 = 0
            r3 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Exception -> L9f
            android.content.Context r0 = r7.f18266c     // Catch: java.lang.Exception -> L9f
            java.io.File r0 = r0.getFilesDir()     // Catch: java.lang.Exception -> L9f
            java.lang.String r4 = r7.f18267d     // Catch: java.lang.Exception -> L9f
            r2.<init>(r0, r4)     // Catch: java.lang.Exception -> L9f
            boolean r0 = r2.exists()     // Catch: java.lang.Exception -> L3f
            if (r0 == 0) goto L5a
            android.content.Context r0 = r7.f18266c     // Catch: java.lang.Exception -> L3f
            java.lang.String r4 = r7.f18267d     // Catch: java.lang.Exception -> L3f
            java.io.FileInputStream r0 = r0.openFileInput(r4)     // Catch: java.lang.Exception -> L3f
            java.io.ObjectInputStream r4 = new java.io.ObjectInputStream     // Catch: java.lang.Exception -> L3f
            r4.<init>(r0)     // Catch: java.lang.Exception -> L3f
            java.lang.Object r0 = r4.readObject()     // Catch: java.lang.Throwable -> L71
            java.lang.Object[] r0 = (java.lang.Object[]) r0     // Catch: java.lang.Throwable -> L71
            java.lang.Object[] r0 = (java.lang.Object[]) r0     // Catch: java.lang.Throwable -> L71
            if (r4 == 0) goto L2f
            r4.close()     // Catch: java.lang.Exception -> L3f
        L2f:
            if (r0 == 0) goto L5b
            int r4 = r0.length     // Catch: java.lang.Exception -> L3f
            int r5 = r7.f18268e     // Catch: java.lang.Exception -> L3f
            if (r4 <= r5) goto L5b
            java.lang.Exception r0 = new java.lang.Exception     // Catch: java.lang.Exception -> L3f
            java.lang.String r4 = "Saved data length is bigger than limit count."
            r0.<init>(r4)     // Catch: java.lang.Exception -> L3f
            throw r0     // Catch: java.lang.Exception -> L3f
        L3f:
            r0 = move-exception
        L40:
            com.sec.common.c.a r4 = com.sec.common.C4996f.f18229a
            boolean r4 = r4.f18174f
            if (r4 == 0) goto L51
            com.sec.common.c.a r4 = com.sec.common.C4996f.f18229a
            java.lang.String r5 = com.sec.common.p132g.C5006b.f18264b
            java.lang.String r6 = r0.getMessage()
            r4.mo18649a(r5, r6, r0)
        L51:
            boolean r0 = r2.exists()
            if (r0 == 0) goto L5a
            r2.delete()
        L5a:
            r0 = r1
        L5b:
            if (r0 != 0) goto La2
            java.lang.Object[] r0 = new java.lang.Object[r3]
            r1 = r0
        L60:
            int r4 = r1.length
            r2 = r3
        L62:
            if (r2 >= r4) goto L78
            r0 = r1[r2]
            java.util.List<java.lang.String> r5 = r7.f18265a
            java.lang.String r0 = (java.lang.String) r0
            r5.add(r0)
            int r0 = r2 + 1
            r2 = r0
            goto L62
        L71:
            r0 = move-exception
            if (r4 == 0) goto L77
            r4.close()     // Catch: java.lang.Exception -> L3f
        L77:
            throw r0     // Catch: java.lang.Exception -> L3f
        L78:
            com.sec.common.c.a r0 = com.sec.common.C4996f.f18229a
            boolean r0 = r0.f18171c
            if (r0 == 0) goto L9e
            com.sec.common.c.a r0 = com.sec.common.C4996f.f18229a
            java.lang.String r1 = com.sec.common.p132g.C5006b.f18264b
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r4 = "Loaded data count: "
            r2[r3] = r4
            r3 = 1
            java.util.List<java.lang.String> r4 = r7.f18265a
            int r4 = r4.size()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2[r3] = r4
            java.lang.String r2 = com.sec.common.util.C5052r.m19199a(r2)
            r0.m18892f(r1, r2)
        L9e:
            return
        L9f:
            r0 = move-exception
            r2 = r1
            goto L40
        La2:
            r1 = r0
            goto L60
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.common.p132g.C5006b.m19000c():void");
    }

    /* renamed from: d */
    private void m19001d() throws IOException {
        try {
            if (C4996f.f18229a.f18171c) {
                C4996f.f18229a.m18892f(f18264b, C5052r.m19199a("Saving data count: ", Integer.valueOf(this.f18265a.size())));
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(this.f18266c.openFileOutput(this.f18267d, 0));
            try {
                objectOutputStream.writeObject(this.f18265a.toArray());
            } finally {
                objectOutputStream.close();
            }
        } catch (Exception e) {
            if (C4996f.f18229a.f18174f) {
                C4996f.f18229a.mo18649a(f18264b, e.getMessage(), e);
            }
        }
    }
}
