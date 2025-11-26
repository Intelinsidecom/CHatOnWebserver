package com.sec.chaton.multimedia.p079b;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p055d.AbstractC2070ac;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.util.C4838bc;
import com.sec.chaton.util.C4894o;
import com.sec.chaton.util.C4899t;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4900u;
import com.sec.chaton.widget.C4923p;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;

/* compiled from: SendFileTask.java */
/* renamed from: com.sec.chaton.multimedia.b.d */
/* loaded from: classes.dex */
public class AsyncTaskC2754d extends AsyncTask<Void, Void, Integer> {

    /* renamed from: a */
    private static final String f9891a = AsyncTaskC2754d.class.getSimpleName();

    /* renamed from: b */
    private File f9892b;

    /* renamed from: c */
    private EnumC2214ab f9893c;

    /* renamed from: d */
    private String f9894d;

    /* renamed from: e */
    private String f9895e;

    /* renamed from: f */
    private String f9896f;

    /* renamed from: g */
    private EnumC2300t f9897g;

    /* renamed from: h */
    private String f9898h;

    /* renamed from: i */
    private AbstractC2070ac f9899i;

    /* renamed from: j */
    private String[] f9900j;

    /* renamed from: k */
    private EnumC2301u f9901k;

    /* renamed from: l */
    private String f9902l;

    /* renamed from: m */
    private String f9903m;

    /* renamed from: n */
    private String f9904n;

    /* renamed from: o */
    private boolean f9905o;

    /* renamed from: p */
    private Handler f9906p;

    /* renamed from: q */
    private String f9907q;

    /* renamed from: r */
    private Activity f9908r;

    /* renamed from: s */
    private ProgressDialog f9909s;

    /* renamed from: t */
    private boolean f9910t;

    private AsyncTaskC2754d(C2756f c2756f) {
        this.f9892b = c2756f.f9911a;
        this.f9893c = c2756f.f9912b;
        this.f9894d = c2756f.f9913c;
        this.f9895e = c2756f.f9914d;
        this.f9896f = c2756f.f9915e;
        this.f9897g = c2756f.f9916f;
        this.f9898h = c2756f.f9917g;
        this.f9899i = c2756f.f9918h;
        this.f9900j = c2756f.f9919i;
        this.f9901k = c2756f.f9920j;
        this.f9904n = c2756f.f9923m;
        this.f9905o = c2756f.f9924n;
        this.f9906p = c2756f.f9925o;
        this.f9908r = c2756f.f9927q;
        this.f9902l = c2756f.f9921k;
        this.f9903m = c2756f.f9922l;
        this.f9910t = c2756f.f9928r;
        this.f9907q = c2756f.f9926p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(Void... voidArr) {
        File fileM18310b;
        boolean z = false;
        String strNextToken = null;
        if (this.f9892b == null && this.f9904n != null) {
            if (this.f9904n.startsWith("file")) {
                this.f9892b = new File(Uri.parse(this.f9904n).getPath());
            } else {
                C4899t c4899tM18615c = C4894o.m18615c(this.f9904n);
                if (c4899tM18615c != null) {
                    this.f9892b = c4899tM18615c.f17859a;
                }
            }
        }
        if (this.f9892b == null) {
            return 3;
        }
        EnumC4900u enumC4900uM18601a = C4894o.m18601a(this.f9892b, this.f9893c, (Context) null);
        if (enumC4900uM18601a == EnumC4900u.ERROR_SIZE) {
            return 4;
        }
        if (enumC4900uM18601a == EnumC4900u.ERROR_EXTENSION) {
            return 5;
        }
        if (!this.f9905o) {
            if (C4904y.f17872b) {
                C4904y.m18639b("mFile: " + this.f9892b + ", Need resizing:" + this.f9910t, f9891a);
            }
            if (this.f9893c == EnumC2214ab.IMAGE && this.f9910t && C4838bc.m18308a(this.f9892b)) {
                try {
                    fileM18310b = C4838bc.m18310b(CommonApplication.m18732r(), this.f9892b, this.f9907q, null, false);
                } catch (FileNotFoundException e) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, f9891a);
                    }
                    fileM18310b = null;
                } catch (IOException e2) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e2, f9891a);
                    }
                    fileM18310b = null;
                } catch (Exception e3) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e3, f9891a);
                    }
                    fileM18310b = null;
                } catch (OutOfMemoryError e4) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e4, f9891a);
                    }
                    fileM18310b = null;
                }
                if (fileM18310b == null) {
                    return 3;
                }
                this.f9892b = fileM18310b;
            }
            if (this.f9901k == EnumC2301u.NORMAL && (TextUtils.isEmpty(this.f9898h) || this.f9897g == EnumC2300t.BROADCAST || "null".equals(this.f9898h))) {
                z = true;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(this.f9892b.getName(), ".");
            while (stringTokenizer.hasMoreTokens()) {
                strNextToken = stringTokenizer.nextToken();
            }
            this.f9899i.m9239a(this.f9892b, this.f9893c == EnumC2214ab.AMS ? "jpg" : strNextToken, this.f9893c, this.f9897g, this.f9898h, this.f9900j, z, this.f9894d, this.f9895e, this.f9896f, this.f9902l, this.f9903m);
        }
        return 2;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        if (!this.f9905o) {
            if ((this.f9892b == null && this.f9893c == EnumC2214ab.IMAGE) || (this.f9892b != null && this.f9892b.length() > 5242880)) {
                m11547a();
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        m11548b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        super.onPostExecute(num);
        m11548b();
        if (num != null) {
            switch (num.intValue()) {
                case 2:
                    if (this.f9905o && this.f9906p != null) {
                        Message.obtain(this.f9906p, 1, C2753c.m11546a(this.f9892b, this.f9893c)).sendToTarget();
                        break;
                    }
                    break;
                case 3:
                    C5179v.m19810a(CommonApplication.m18732r(), R.string.toast_error, 0).show();
                    if (this.f9906p != null) {
                        Message.obtain(this.f9906p, 1).sendToTarget();
                        break;
                    }
                    break;
                case 4:
                    C5179v.m19811a(CommonApplication.m18732r(), CommonApplication.m18732r().getString(R.string.maximum_file_size_exceeded, 30L), 0).show();
                    if (this.f9906p != null) {
                        Message.obtain(this.f9906p, 1).sendToTarget();
                        break;
                    }
                    break;
                case 5:
                    if (this.f9908r != null) {
                        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f9908r);
                        abstractC4932aM18733a.mo18734a(R.string.pop_up_attention).mo18746b(R.string.toast_supported_format).mo18756d(R.string.alert_dialog_ok, null);
                        abstractC4932aM18733a.mo18745a().show();
                    }
                    if (this.f9906p != null) {
                        Message.obtain(this.f9906p, 1).sendToTarget();
                        break;
                    }
                    break;
            }
        }
    }

    /* renamed from: a */
    private void m11547a() {
        if (this.f9909s == null && this.f9908r != null) {
            this.f9909s = (ProgressDialog) new C4923p(this.f9908r).m18724a(R.string.setting_webview_please_wait);
        }
        if (this.f9909s != null && !this.f9909s.isShowing()) {
            this.f9909s.show();
        }
    }

    /* renamed from: b */
    private void m11548b() {
        if (this.f9908r != null && this.f9909s != null && this.f9909s.isShowing()) {
            this.f9909s.dismiss();
        }
    }
}
