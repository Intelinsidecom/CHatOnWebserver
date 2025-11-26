package com.sec.chaton.p067j.p070c;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1729gb;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.multimedia.audio.C2726b;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.qmlog.C3119a;
import com.sec.chaton.qmlog.EnumC3124f;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4894o;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.AlertDialogC4916i;
import com.sec.common.CommonApplication;

/* compiled from: FileDownloadTask2.java */
/* renamed from: com.sec.chaton.j.c.c */
/* loaded from: classes.dex */
public class AsyncTaskC2436c extends AsyncTask<String, Integer, String> {

    /* renamed from: a */
    private static final String f8697a = AsyncTaskC2436c.class.getSimpleName();

    /* renamed from: d */
    private String f8700d;

    /* renamed from: e */
    private boolean f8701e;

    /* renamed from: f */
    private String f8702f;

    /* renamed from: g */
    private long f8703g;

    /* renamed from: h */
    private EnumC2300t f8704h;

    /* renamed from: i */
    private String f8705i;

    /* renamed from: k */
    private Handler f8707k;

    /* renamed from: l */
    private View f8708l;

    /* renamed from: n */
    private AlertDialogC4916i f8710n;

    /* renamed from: p */
    private EnumC2214ab f8712p;

    /* renamed from: q */
    private String f8713q;

    /* renamed from: r */
    private String f8714r;

    /* renamed from: s */
    private String f8715s;

    /* renamed from: t */
    private Toast f8716t;

    /* renamed from: b */
    private String f8698b = null;

    /* renamed from: c */
    private String f8699c = null;

    /* renamed from: j */
    private boolean f8706j = false;

    /* renamed from: m */
    private ProgressBar f8709m = null;

    /* renamed from: o */
    private int f8711o = 0;

    public AsyncTaskC2436c(C2437d c2437d) {
        this.f8700d = null;
        this.f8701e = false;
        this.f8702f = null;
        this.f8703g = 0L;
        this.f8704h = EnumC2300t.ONETOONE;
        this.f8705i = null;
        this.f8708l = null;
        this.f8713q = null;
        this.f8714r = null;
        this.f8716t = null;
        this.f8708l = c2437d.f8718b;
        this.f8701e = c2437d.f8722f;
        this.f8702f = c2437d.f8723g;
        this.f8703g = c2437d.f8724h;
        this.f8704h = c2437d.f8725i;
        this.f8705i = c2437d.f8726j;
        this.f8700d = c2437d.f8721e;
        this.f8712p = c2437d.f8728l;
        this.f8713q = c2437d.f8720d;
        this.f8714r = c2437d.f8719c;
        this.f8716t = Toast.makeText(CommonApplication.m18732r(), R.string.media_download_fail, 0);
    }

    /* renamed from: a */
    public void m10553a(View view) {
        if (view != null && !this.f8701e) {
            this.f8709m = ((C1729gb) view.getTag()).f6390H;
            if (this.f8709m != null) {
                this.f8709m.setProgress(this.f8711o);
            }
            this.f8708l = view;
            if (C4904y.f17872b) {
                C4904y.m18639b("[setProgressView]", f8697a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0431 A[Catch: all -> 0x05d5, TryCatch #22 {all -> 0x05d5, blocks: (B:39:0x024e, B:41:0x029d, B:44:0x02ae, B:46:0x02c8, B:48:0x02d2, B:49:0x0302, B:51:0x030b, B:53:0x0311, B:54:0x031e, B:56:0x0328, B:58:0x0337, B:60:0x033d, B:110:0x042d, B:112:0x0431, B:113:0x0436, B:43:0x02a5), top: B:258:0x024e }] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x05dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0445 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0440 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x05d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:291:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v9, types: [boolean] */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String doInBackground(java.lang.String... r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1646
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p067j.p070c.AsyncTaskC2436c.doInBackground(java.lang.String[]):java.lang.String");
    }

    /* renamed from: a */
    private void m10550a(boolean z) {
        if (z) {
            C2204r.m10005a(CommonApplication.m18732r().getContentResolver(), this.f8705i, this.f8702f, Long.valueOf(this.f8703g), this.f8715s, this.f8704h, this.f8706j, this.f8701e);
            if (EnumC2214ab.AUDIO == this.f8712p) {
                C2204r.m10031a(CommonApplication.m18732r().getContentResolver(), this.f8702f, Long.valueOf(this.f8703g), C4894o.m18613b(this.f8715s), this.f8705i);
            }
        } else {
            C2204r.m10050c(CommonApplication.m18732r().getContentResolver(), Long.valueOf(this.f8703g));
        }
        if (C2434a.m10540a().m10547d(this.f8703g)) {
            C4904y.m18639b("Successfully removed from hashmap", f8697a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        if (this.f8710n != null) {
            this.f8710n.m18719a(numArr[0].intValue());
        }
        if (this.f8708l != null && !this.f8701e) {
            if (((C1729gb) this.f8708l.getTag()).f6458c == this.f8703g && numArr[0].intValue() <= 100 && this.f8709m != null) {
                this.f8709m.setProgress(numArr[0].intValue());
            }
            this.f8711o = numArr[0].intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("[onPostExecute]", f8697a);
        }
        if (this.f8707k != null) {
            Message messageObtainMessage = this.f8707k.obtainMessage();
            messageObtainMessage.obj = String.valueOf(this.f8703g);
            messageObtainMessage.arg1 = this.f8712p.m10076a();
            Bundle bundle = new Bundle();
            bundle.putString("download_uri", str);
            messageObtainMessage.setData(bundle);
            this.f8707k.sendMessage(messageObtainMessage);
        }
        if (TextUtils.isEmpty(str) || C1427a.f5066d.equals(str)) {
            if (!this.f8701e) {
                this.f8716t.show();
            }
        } else if (this.f8712p == EnumC2214ab.AUDIO) {
            boolean z = false;
            if (C4809aa.m18104a().m18121a("chaton_id", "").equals(this.f8705i)) {
                z = true;
            }
            C2726b.m11429a().m11436a((View) null, str, this.f8703g, z);
        }
        if (this.f8710n != null) {
            this.f8710n.hide();
        }
        if (C2349a.m10301a("chaton_qmlog_sending") && !this.f8701e) {
            if (TextUtils.isEmpty(str) || C1427a.f5066d.equals(str)) {
                C3119a.m12716a().m12721a(this, EnumC3124f.FILEDOWNLOAD, -1L);
            } else {
                C3119a.m12716a().m12721a(this, EnumC3124f.FILEDOWNLOAD, System.currentTimeMillis());
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        if (!this.f8701e && TextUtils.isEmpty(this.f8715s)) {
            this.f8716t.show();
        }
    }

    /* renamed from: a */
    public void m10552a(Handler handler) {
        this.f8707k = handler;
    }

    /* renamed from: a */
    public void m10554a(AlertDialogC4916i alertDialogC4916i) {
        this.f8710n = alertDialogC4916i;
    }

    /* renamed from: a */
    public boolean m10557a() {
        return this.f8701e;
    }
}
