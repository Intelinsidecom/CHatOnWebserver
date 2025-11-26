package com.sec.chaton.trunk.p120b;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.util.C4904y;
import java.io.File;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* compiled from: FileDownloadTask.java */
/* renamed from: com.sec.chaton.trunk.b.b */
/* loaded from: classes.dex */
public class AsyncTaskC4604b extends AsyncTask<Void, Integer, String> {

    /* renamed from: a */
    private static final String f16737a = AsyncTaskC4604b.class.getSimpleName();

    /* renamed from: o */
    private static final Random f16738o = new Random(System.currentTimeMillis());

    /* renamed from: d */
    private HttpURLConnection f16741d;

    /* renamed from: e */
    private File f16742e;

    /* renamed from: h */
    private String f16745h;

    /* renamed from: i */
    private String f16746i;

    /* renamed from: j */
    private String f16747j;

    /* renamed from: k */
    private String f16748k;

    /* renamed from: l */
    private boolean f16749l;

    /* renamed from: m */
    private Object f16750m;

    /* renamed from: n */
    private boolean f16751n;

    /* renamed from: b */
    private final Object f16739b = new Object();

    /* renamed from: c */
    private final Object f16740c = new Object();

    /* renamed from: f */
    private boolean f16743f = false;

    /* renamed from: g */
    private List<Handler> f16744g = new ArrayList();

    AsyncTaskC4604b(Handler handler, String str, String str2, String str3, boolean z, Object obj, boolean z2) {
        this.f16744g.add(handler);
        this.f16745h = str;
        this.f16746i = str2;
        this.f16747j = str3;
        this.f16748k = str2 + File.separator + str3;
        this.f16749l = z;
        this.f16750m = obj;
        this.f16751n = z2;
    }

    /* renamed from: a */
    public void m17560a(Object obj) {
        this.f16750m = obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0125, code lost:
    
        if (r14.f16742e == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0127, code lost:
    
        r14.f16742e.delete();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0139 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0195 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x018e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x019a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:201:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:204:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x013e A[Catch: Exception -> 0x00a9, TRY_ENTER, TRY_LEAVE, TryCatch #9 {Exception -> 0x00a9, blocks: (B:17:0x00a5, B:46:0x013e, B:66:0x017f), top: B:164:0x0046 }] */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v2, types: [long] */
    /* JADX WARN: Type inference failed for: r0v51 */
    /* JADX WARN: Type inference failed for: r0v81 */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String doInBackground(java.lang.Void... r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 634
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.trunk.p120b.AsyncTaskC4604b.doInBackground(java.lang.Void[]):java.lang.String");
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        C4904y.m18639b("FileDownloadTask.onPreExecute()", f16737a);
        C4603a.m17553a().m17555b().put(this.f16748k, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        if (str == null) {
            m17556a(4, 0, 0, null);
        } else {
            m17556a(2, 0, 0, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
        m17556a(1, numArr[0].intValue(), 0, null);
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        synchronized (this.f16739b) {
            super.onCancelled();
            C4904y.m18639b("File download is canceled: " + this.f16745h, f16737a);
            if (this.f16741d != null) {
                try {
                    this.f16741d.disconnect();
                } catch (Exception e) {
                }
            }
            m17556a(3, 0, 0, null);
        }
    }

    /* renamed from: a */
    private boolean m17558a(String str, String str2) {
        return new File(str + File.separator + str2).exists();
    }

    /* renamed from: a */
    private void m17556a(int i, int i2, int i3, Object obj) {
        synchronized (this.f16740c) {
            C4605c c4608f = null;
            switch (i) {
                case 1:
                    Iterator<Handler> it = this.f16744g.iterator();
                    while (it.hasNext()) {
                        Message.obtain(it.next(), i, i2, i3, this.f16750m).sendToTarget();
                    }
                    break;
                case 2:
                    C4607e c4607e = new C4607e(this);
                    c4607e.m17565a(this.f16746i);
                    c4607e.m17567b(this.f16747j);
                    c4607e.m17569c((String) obj);
                    m17557a(i, c4607e);
                    break;
                case 3:
                    if (0 == 0) {
                        c4608f = new C4606d(this);
                    }
                    m17557a(i, c4608f);
                    break;
                case 4:
                    if (0 == 0) {
                        c4608f = new C4608f(this);
                    }
                    m17557a(i, c4608f);
                    break;
            }
        }
    }

    /* renamed from: a */
    private void m17557a(int i, C4605c c4605c) {
        c4605c.m17564a(this.f16750m);
        C4603a.m17553a().m17555b().remove(this.f16748k);
        if (!this.f16743f) {
            this.f16743f = true;
            Iterator<Handler> it = this.f16744g.iterator();
            while (it.hasNext()) {
                Message.obtain(it.next(), i, c4605c).sendToTarget();
            }
        }
    }
}
