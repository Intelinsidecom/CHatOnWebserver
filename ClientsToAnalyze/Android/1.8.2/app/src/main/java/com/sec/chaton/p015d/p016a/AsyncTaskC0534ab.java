package com.sec.chaton.p015d.p016a;

import android.os.AsyncTask;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import com.sec.chaton.chat.C0484az;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.util.C1786r;
import java.io.File;

/* compiled from: FileUploadTask2.java */
/* renamed from: com.sec.chaton.d.a.ab */
/* loaded from: classes.dex */
public class AsyncTaskC0534ab extends AsyncTask {

    /* renamed from: a */
    protected File f2177a;

    /* renamed from: b */
    protected String f2178b;

    /* renamed from: c */
    protected String f2179c;

    /* renamed from: d */
    protected String f2180d;

    /* renamed from: e */
    protected int f2181e;

    /* renamed from: f */
    protected String f2182f;

    /* renamed from: g */
    protected View f2183g;

    /* renamed from: h */
    protected ProgressBar f2184h;

    /* renamed from: i */
    protected boolean f2185i;

    /* renamed from: j */
    protected Handler f2186j;

    /* renamed from: k */
    private EnumC0699n f2187k;

    /* renamed from: l */
    private String f2188l;

    /* renamed from: m */
    private String f2189m;

    /* renamed from: n */
    private long f2190n;

    /* renamed from: o */
    private String f2191o;

    /* renamed from: p */
    private String f2192p;

    /* renamed from: q */
    private String f2193q;

    /* renamed from: r */
    private boolean f2194r;

    /* renamed from: s */
    private int f2195s;

    /* renamed from: t */
    private AsyncTaskC0534ab f2196t;

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f2181e = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:150:0x05ab  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x062b A[Catch: all -> 0x060f, TRY_ENTER, TRY_LEAVE, TryCatch #42 {all -> 0x060f, blocks: (B:45:0x027f, B:47:0x028b, B:49:0x0291, B:50:0x0298, B:52:0x02a5, B:53:0x02b7, B:151:0x05fc, B:165:0x062b), top: B:315:0x027f }] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0653 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0439 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0434 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0443 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:287:0x043e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0618 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0627 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0622 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:326:0x061d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:358:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x028b A[Catch: all -> 0x060f, TryCatch #42 {all -> 0x060f, blocks: (B:45:0x027f, B:47:0x028b, B:49:0x0291, B:50:0x0298, B:52:0x02a5, B:53:0x02b7, B:151:0x05fc, B:165:0x062b), top: B:315:0x027f }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0419 A[Catch: all -> 0x06fd, TryCatch #32 {all -> 0x06fd, blocks: (B:33:0x023b, B:34:0x023d, B:36:0x0243, B:38:0x024b, B:41:0x025c, B:87:0x03e6, B:89:0x03f0, B:106:0x0449, B:108:0x0450, B:119:0x0472, B:121:0x047a, B:123:0x0480, B:124:0x0487, B:92:0x0413, B:94:0x0419, B:95:0x0420, B:137:0x04f6), top: B:300:0x01af }] */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String doInBackground(java.lang.String... r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1868
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p015d.p016a.AsyncTaskC0534ab.doInBackground(java.lang.String[]):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
        if (this.f2183g != null) {
            if (Long.parseLong(((C0484az) this.f2183g.getTag()).f2041a) == this.f2190n) {
                if (this.f2194r || numArr[0].intValue() <= 95) {
                    this.f2184h.setProgress(numArr[0].intValue());
                } else {
                    this.f2184h.setProgress(95);
                }
                C1786r.m6061b("[onProgressUpdate] " + numArr[0], getClass().getSimpleName());
            }
            this.f2181e = numArr[0].intValue();
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        this.f2185i = true;
    }
}
