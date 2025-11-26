package com.sec.chaton.hugefiletransfer;

import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.doc.FileExplorerActivity;
import com.sec.chaton.p046a.p047a.C0784h;
import com.sec.chaton.p057e.C2218af;
import com.sec.chaton.p057e.C2296p;
import com.sec.chaton.p065io.entry.HugeFileUploadEndEntry;
import com.sec.chaton.p065io.entry.HugeFileUploadErrorEntry;
import com.sec.chaton.p065io.entry.HugeFileUploadStartEntry;
import com.sec.chaton.p067j.C2456g;
import com.sec.chaton.p067j.C2472w;
import com.sec.chaton.p067j.EnumC2457h;
import com.sec.chaton.p067j.EnumC2463n;
import com.sec.chaton.util.C4808a;
import com.sec.chaton.util.C4865cc;
import com.sec.chaton.util.C4901v;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4867ce;
import com.sec.chaton.util.EnumC4868cf;
import com.sec.common.CommonApplication;
import com.sec.common.p126d.p127a.EnumC4988d;
import com.sec.common.util.C5052r;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: HugeFileUploadTask.java */
/* renamed from: com.sec.chaton.hugefiletransfer.k */
/* loaded from: classes.dex */
public class C2397k {

    /* renamed from: a */
    private static final String f8508a = C2397k.class.getSimpleName();

    /* renamed from: c */
    private String f8510c;

    /* renamed from: d */
    private String f8511d;

    /* renamed from: e */
    private String f8512e;

    /* renamed from: f */
    private String f8513f;

    /* renamed from: j */
    private String f8517j;

    /* renamed from: l */
    private String f8519l;

    /* renamed from: m */
    private Handler f8520m;

    /* renamed from: n */
    private Intent f8521n;

    /* renamed from: o */
    private File f8522o;

    /* renamed from: p */
    private int f8523p;

    /* renamed from: q */
    private long f8524q;

    /* renamed from: r */
    private long f8525r;

    /* renamed from: s */
    private int f8526s;

    /* renamed from: t */
    private int f8527t;

    /* renamed from: u */
    private boolean f8528u;

    /* renamed from: v */
    private PendingIntent f8529v;

    /* renamed from: w */
    private Future<C0784h> f8530w;

    /* renamed from: x */
    private Future<C0784h> f8531x;

    /* renamed from: b */
    private String f8509b = "TESTCHATON";

    /* renamed from: g */
    private boolean f8514g = false;

    /* renamed from: h */
    private boolean f8515h = false;

    /* renamed from: i */
    private boolean f8516i = false;

    /* renamed from: k */
    private final ExecutorService f8518k = Executors.newFixedThreadPool(3);

    /* renamed from: y */
    private Handler f8532y = new HandlerC2398l(this, Looper.getMainLooper());

    /* renamed from: e */
    static /* synthetic */ int m10409e(C2397k c2397k) {
        int i = c2397k.f8526s + 1;
        c2397k.f8526s = i;
        return i;
    }

    public C2397k(Handler handler, Intent intent) {
        this.f8520m = handler;
        this.f8521n = intent;
        if (this.f8521n != null && intent.getData() != null) {
            this.f8519l = intent.getData().toString();
            this.f8524q = intent.getLongExtra("huge_file_request_id", 0L);
            this.f8525r = intent.getLongExtra("huge_file_upload_id", 0L);
            this.f8529v = (PendingIntent) intent.getParcelableExtra("huge_file_pending_intent");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02d9  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m10412a() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 733
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.hugefiletransfer.C2397k.m10412a():void");
    }

    /* renamed from: a */
    private void m10400a(String str, int i, long j, int i2, int i3) {
        if (C4904y.f17872b) {
            C4904y.m18639b(C5052r.m19199a("setUplaodResult publicUrl: ", str, ", authCode: ", Integer.valueOf(i), ", expiredTime: ", Long.valueOf(j), ", maxUploadCount: ", Integer.valueOf(i2), ", uploadCount: ", Integer.valueOf(i3)), f8508a);
        }
        this.f8521n.putExtra("huge_file_download_url", str);
        this.f8521n.putExtra("huge_file_auth_code", i);
        this.f8521n.putExtra("huge_file_expired_time", j);
        this.f8521n.putExtra("huge_file_max_upload_count", i2);
        this.f8521n.putExtra("huge_file_upload_count", i3);
    }

    /* renamed from: a */
    private void m10399a(C0784h c0784h) {
        HugeFileUploadErrorEntry hugeFileUploadErrorEntry;
        if (c0784h != null && (hugeFileUploadErrorEntry = (HugeFileUploadErrorEntry) c0784h.mo18927o()) != null) {
            m10397a(hugeFileUploadErrorEntry.rcode.intValue(), hugeFileUploadErrorEntry.rmsg);
        }
    }

    /* renamed from: a */
    private void m10397a(int i, String str) {
        if (C4904y.f17875e) {
            C4904y.m18634a("Hugefile errorCode: " + i + ", errorMessage: " + str, f8508a);
        }
        this.f8521n.putExtra("huge_file_error_code", i);
        if (str != null) {
            int iIndexOf = str.indexOf(40);
            int iIndexOf2 = str.indexOf(41);
            if (iIndexOf > 0 && iIndexOf2 > iIndexOf) {
                this.f8521n.putExtra("huge_file_error_message", str.substring(iIndexOf + 1, iIndexOf2));
            }
        }
        if (i == 39025) {
            if (C4904y.f17875e) {
                C4904y.m18634a(C5052r.m19199a("Hugefile remove data uploadId: ", Long.valueOf(this.f8525r), ", file: ", this.f8519l), f8508a);
            }
            int iDelete = CommonApplication.m18732r().getContentResolver().delete(C2218af.f7940a, "upload_id = ? ", new String[]{String.valueOf(this.f8525r)});
            int iDelete2 = CommonApplication.m18732r().getContentResolver().delete(C2296p.f8206a, "upload_id = ? ", new String[]{String.valueOf(this.f8525r)});
            if (C4904y.f17872b) {
                C4904y.m18639b(C5052r.m19199a("Hugefile delete uploadCount: ", Integer.valueOf(iDelete), ", mappingCount: ", Integer.valueOf(iDelete2)), f8508a);
            }
        }
    }

    /* renamed from: c */
    private C0784h m10407c() throws Throwable {
        try {
            this.f8530w = C2472w.m10687a().m10690b().m10663a(new C2401o(new C2456g(EnumC4868cf.HUGE_FILE, C5052r.m19199a("/ors/v2/mupload/start", "/", Long.valueOf(System.currentTimeMillis()), "/", Uri.encode(this.f8522o.getName()))).m10641a("uid", this.f8510c).m10641a("param", m10396a(C5052r.m19199a("imei", "=", this.f8512e, "&", "cid", "=", this.f8511d, "&", "chunk_count", "=", Integer.valueOf(this.f8523p), "&", "size", "=", Long.valueOf(this.f8522o.length())))).m10644b("x-sc-appid", this.f8513f).m10643b(C4901v.class).m10638a(new C2390d()).m10639a(HugeFileUploadStartEntry.class).m10637a(EnumC2457h.POST).m10635a(), this.f8525r), EnumC2463n.BACKGROUND);
            return this.f8530w.get();
        } catch (InterruptedException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f8508a);
            }
            return null;
        } catch (CancellationException e2) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e2, f8508a);
            }
            return null;
        } catch (ExecutionException e3) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e3, f8508a);
            }
            return null;
        }
    }

    /* renamed from: a */
    private String m10396a(String str) {
        String strM18098a = "";
        try {
            if (!TextUtils.isEmpty(this.f8517j)) {
                strM18098a = C4808a.m18098a(new C4808a(C4808a.m18100b(this.f8517j), C4808a.m18101c(this.f8517j)).m18102b(str.getBytes()));
            } else if (C4904y.f17875e) {
                C4904y.m18634a("Fail in getting a key", f8508a);
            }
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18634a("Encryption Error", f8508a);
            }
        }
        if (C4904y.f17872b) {
            C4904y.m18639b(C5052r.m19199a("paramBefore: " + str, ", paramAfter: ", strM18098a), f8508a);
        }
        return strM18098a;
    }

    /* renamed from: a */
    public void m10413a(boolean z) {
        this.f8528u = z;
        if (this.f8530w != null) {
            this.f8530w.cancel(true);
        }
        if (this.f8518k != null) {
            this.f8518k.shutdownNow();
        }
        if (this.f8531x != null) {
            this.f8531x.cancel(true);
        }
    }

    /* renamed from: a */
    private boolean m10401a(String str, int i, int i2) throws Throwable {
        if (str == null) {
            return false;
        }
        String strM19199a = C5052r.m19199a(C4865cc.m18464i(EnumC4867ce.PRIMARY), "/ors/v2/mupload/chunk", "/", str);
        StringTokenizer stringTokenizer = new StringTokenizer(this.f8522o.getName(), ".");
        String strNextToken = null;
        while (stringTokenizer.hasMoreTokens()) {
            strNextToken = stringTokenizer.nextToken();
        }
        if (strNextToken == null) {
            return false;
        }
        String strM11579b = FileExplorerActivity.m11579b(strNextToken);
        ArrayList<Future<?>> arrayList = new ArrayList<>();
        for (int i3 = i2 + 1; i3 <= i; i3++) {
            long j = (i3 - 1) * 1048576;
            long length = 1048576 * i3;
            if (length > this.f8522o.length()) {
                length = this.f8522o.length();
            }
            long j2 = length - j;
            try {
                arrayList.add(this.f8518k.submit(new C2399m(j2, m10395a(i3, j2, strM11579b, strM19199a), 4, this.f8532y)));
                if (arrayList.size() % 10 == 0 || i3 == i) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("getChunkResult index: " + i3, f8508a);
                    }
                    boolean zM10402a = m10402a(arrayList);
                    arrayList.clear();
                    if (zM10402a) {
                        return false;
                    }
                }
            } catch (RejectedExecutionException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f8508a);
                }
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private void m10398a(int i, boolean z) {
        if (C4904y.f17872b) {
            C4904y.m18639b("update successChunkCount: " + i, f8508a);
        }
        ContentValues contentValues = new ContentValues();
        if (z) {
            if (this.f8528u) {
                contentValues.put("status", Integer.valueOf(EnumC2388b.CANCEL.m10385a()));
            } else {
                contentValues.put("status", Integer.valueOf(EnumC2388b.FAIL.m10385a()));
            }
        }
        contentValues.put("last_chunk_no", Integer.valueOf(i));
        CommonApplication.m18732r().getContentResolver().update(C2218af.f7940a, contentValues, "upload_id=?", new String[]{String.valueOf(this.f8525r)});
    }

    /* renamed from: a */
    private boolean m10402a(ArrayList<Future<?>> arrayList) throws Throwable {
        boolean z;
        int i;
        JSONException e;
        int i2 = -1;
        try {
            try {
                Iterator<Future<?>> it = arrayList.iterator();
                while (it.hasNext()) {
                    C2394h c2394h = (C2394h) it.next().get();
                    try {
                    } catch (JSONException e2) {
                        i = i2;
                        e = e2;
                    }
                    if (c2394h.m18953m() != 200) {
                        JSONObject jSONObject = (JSONObject) c2394h.mo18927o();
                        if (jSONObject != null) {
                            m10397a(jSONObject.getInt("rcode"), jSONObject.getString("rmsg"));
                        }
                        z = true;
                        break;
                    }
                    i = ((JSONObject) c2394h.m10392a()).getInt("chunk_number");
                    try {
                        try {
                            if (C4904y.f17872b) {
                                C4904y.m18639b("success chunkNumber: " + i, f8508a);
                            }
                        } catch (InterruptedException e3) {
                            i2 = i;
                            e = e3;
                            if (C4904y.f17875e) {
                                C4904y.m18635a(e, f8508a);
                            }
                            if (i2 > 0) {
                                m10398a(i2, true);
                            }
                            return true;
                        } catch (ExecutionException e4) {
                            i2 = i;
                            e = e4;
                            if (C4904y.f17875e) {
                                C4904y.m18635a(e, f8508a);
                            }
                            if (i2 > 0) {
                                m10398a(i2, true);
                            }
                            return true;
                        } catch (Throwable th) {
                            i2 = i;
                            th = th;
                            if (i2 > 0) {
                                m10398a(i2, false);
                            }
                            throw th;
                        }
                    } catch (JSONException e5) {
                        e = e5;
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e, f8508a);
                        }
                        i2 = i;
                    }
                    i2 = i;
                }
                z = false;
                if (i2 <= 0) {
                    return z;
                }
                m10398a(i2, z);
                return z;
            } catch (InterruptedException e6) {
                e = e6;
            } catch (ExecutionException e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    private C2393g m10395a(int i, long j, String str, String str2) throws Throwable {
        C2393g c2393g = new C2393g();
        String strM19199a = C5052r.m19199a("imei", "=", this.f8512e, "&", "cid", "=", this.f8511d);
        c2393g.m18930a(EnumC4988d.PUT);
        c2393g.m18935b("uid", this.f8510c);
        c2393g.m18935b("param", m10396a(strM19199a));
        c2393g.m18906a(this.f8522o);
        c2393g.mo10630a(C5052r.m19199a(str2, "/", Integer.valueOf(i)));
        c2393g.m10391a(i);
        c2393g.m18931a("Content-Length", String.valueOf(j));
        c2393g.m18931a("Content-Type", str);
        c2393g.m18931a("x-sc-appid", this.f8513f);
        c2393g.m18931a("Connection", "Close");
        return c2393g;
    }

    /* renamed from: b */
    private C0784h m10403b(String str) throws Throwable {
        String strM19199a = C5052r.m19199a("imei", "=", this.f8512e, "&", "cid", "=", this.f8511d, "&", "publish", "=", String.valueOf(Boolean.TRUE));
        String str2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", GlobalApplication.m10283b().getConfiguration().locale).format(Calendar.getInstance().getTime());
        if (C4904y.f17872b) {
            C4904y.m18639b("time zone : " + str2, f8508a);
        }
        try {
            this.f8531x = C2472w.m10687a().m10690b().m10663a(new C2400n(new C2456g(EnumC4868cf.HUGE_FILE, C5052r.m19199a("/ors/v2/mupload/end", "/", str)).m10641a("uid", this.f8510c).m10641a("param", m10396a(strM19199a)).m10644b("x-sc-appid", this.f8513f).m10644b("Timezone", str2).m10643b(C4901v.class).m10638a(new C2390d()).m10639a(HugeFileUploadEndEntry.class).m10637a(EnumC2457h.POST).m10635a(), this.f8525r), EnumC2463n.BACKGROUND);
            return this.f8531x.get();
        } catch (InterruptedException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f8508a);
            }
            return null;
        } catch (CancellationException e2) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e2, f8508a);
            }
            return null;
        } catch (ExecutionException e3) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e3, f8508a);
            }
            return null;
        }
    }
}
