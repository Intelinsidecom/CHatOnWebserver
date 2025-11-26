package com.sec.chaton.p037j.p040c;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1070el;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.chaton.p033i.p034a.C1533b;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.chaton.util.C3158a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3243r;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.EnumC3219cg;
import com.sec.chaton.widget.AlertDialogC3256c;
import com.sec.common.CommonApplication;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* compiled from: FileDownloadTask2.java */
/* renamed from: com.sec.chaton.j.c.c */
/* loaded from: classes.dex */
public class AsyncTaskC1557c extends AsyncTask<String, Integer, String> {

    /* renamed from: v */
    private static String f5744v = "FileDownloadTask2";

    /* renamed from: c */
    protected String f5747c;

    /* renamed from: d */
    protected boolean f5748d;

    /* renamed from: e */
    protected String f5749e;

    /* renamed from: f */
    protected long f5750f;

    /* renamed from: g */
    protected EnumC1450r f5751g;

    /* renamed from: h */
    protected String f5752h;

    /* renamed from: m */
    protected int f5757m;

    /* renamed from: o */
    protected EnumC1455w f5759o;

    /* renamed from: p */
    protected String f5760p;

    /* renamed from: q */
    protected String f5761q;

    /* renamed from: s */
    ChatFragment f5763s;

    /* renamed from: u */
    Toast f5765u;

    /* renamed from: w */
    private Handler f5766w;

    /* renamed from: x */
    private Handler f5767x;

    /* renamed from: y */
    private View f5768y;

    /* renamed from: z */
    private AlertDialogC3256c f5769z;

    /* renamed from: a */
    protected String f5745a = null;

    /* renamed from: b */
    protected String f5746b = null;

    /* renamed from: i */
    protected boolean f5753i = false;

    /* renamed from: j */
    ProgressBar f5754j = null;

    /* renamed from: k */
    ProgressBar f5755k = null;

    /* renamed from: l */
    Button f5756l = null;

    /* renamed from: n */
    protected int f5758n = 0;

    /* renamed from: r */
    Boolean f5762r = false;

    /* renamed from: t */
    String f5764t = null;

    public AsyncTaskC1557c(C1560f c1560f) {
        this.f5747c = null;
        this.f5748d = false;
        this.f5749e = null;
        this.f5750f = 0L;
        this.f5751g = EnumC1450r.ONETOONE;
        this.f5752h = null;
        this.f5766w = null;
        this.f5768y = null;
        this.f5757m = 0;
        this.f5760p = null;
        this.f5761q = null;
        this.f5763s = null;
        this.f5765u = null;
        this.f5766w = c1560f.f5773a;
        this.f5768y = c1560f.f5774b;
        this.f5748d = c1560f.f5778f;
        this.f5749e = c1560f.f5779g;
        this.f5750f = c1560f.f5780h;
        this.f5751g = c1560f.f5781i;
        this.f5752h = c1560f.f5782j;
        this.f5747c = c1560f.f5777e;
        this.f5757m = c1560f.f5783k;
        this.f5759o = c1560f.f5784l;
        this.f5760p = c1560f.f5776d;
        this.f5761q = c1560f.f5775c;
        this.f5763s = c1560f.f5785m;
        this.f5765u = Toast.makeText(CommonApplication.m11493l(), R.string.media_download_fail, 0);
    }

    /* renamed from: a */
    public void m6609a(View view) {
        if (view != null && !this.f5748d) {
            C1070el c1070el = (C1070el) view.getTag();
            this.f5754j = c1070el.f4216E;
            if (this.f5754j != null) {
                this.f5754j.setProgress(this.f5758n);
            }
            this.f5755k = null;
            this.f5768y = view;
            this.f5756l = c1070el.f4218G;
            C3250y.m11450b("[setProgressView]", getClass().getName());
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        C3250y.m11450b("[onPreExecute]", getClass().getName());
        if (this.f5768y != null && !this.f5748d) {
            if (this.f5759o == EnumC1455w.IMAGE || this.f5759o == EnumC1455w.VIDEO) {
                this.f5754j = (ProgressBar) this.f5768y.findViewById(R.id.progressbarDown);
                this.f5754j.setProgress(0);
                this.f5755k = null;
                Log.d("FileDownloadTask2", "onPreExecutemProgessDown" + this.f5754j);
                return;
            }
            this.f5755k = (ProgressBar) this.f5768y.findViewById(R.id.DownProgressBalloon);
            this.f5754j = null;
            Log.d("FileDownloadTask2", "onPreExecutemProgressBalloon" + this.f5755k);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v43, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v44 */
    /* JADX WARN: Type inference failed for: r4v57 */
    /* JADX WARN: Type inference failed for: r4v58 */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v16, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.String] */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) throws Throwable {
        boolean z;
        long j;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream;
        File file;
        InputStream inputStream2 = null;
        OutputStream outputStream = null;
        RunnableC1558d runnableC1558d = new RunnableC1558d(this);
        C1582j c1582jM6714a = new C1582j(EnumC3219cg.FILE, "/file").m6710a(EnumC1583k.GET).m6714a("uid", C3159aa.m10962a().m10979a("uid", ""));
        String str = "imei=" + C3171am.m11045a() + "&buddyid=" + this.f5760p + "&filename=" + this.f5747c;
        C3250y.m11450b("filedownLoadUrl:" + str, f5744v);
        try {
            String strM11411a = GlobalApplication.m6453c().m11411a();
            if (TextUtils.isEmpty(strM11411a)) {
                C3250y.m11442a("Fail in getting a key", getClass().getName());
                if (this.f5766w != null) {
                    this.f5766w.post(runnableC1558d);
                }
                return C0816a.f3113b;
            }
            C3158a c3158a = new C3158a(C3158a.m10958b(strM11411a), C3158a.m10959c(strM11411a));
            String strM10954a = this.f5748d ? C3158a.m10954a(c3158a.m10960b((str + "&size=239").getBytes())) : C3158a.m10954a(c3158a.m10960b(str.getBytes()));
            c1582jM6714a.m6714a("param", strM10954a);
            this.f5753i = C3223ck.m11327a();
            this.f5746b = this.f5753i ? CommonApplication.m11493l().getExternalFilesDir(null).getAbsolutePath() : CommonApplication.m11493l().getFilesDir().getAbsolutePath();
            this.f5746b += "/" + this.f5749e + "/";
            if (this.f5748d) {
                this.f5746b += "thumbnail//";
            }
            File file2 = new File(this.f5746b, this.f5747c);
            if (file2.exists()) {
                this.f5762r = true;
                this.f5764t = Uri.decode(Uri.fromFile(file2).toString());
                return this.f5764t;
            }
            this.f5745a = this.f5761q + "?uid=" + C3159aa.m10962a().m10979a("uid", "") + "&param=" + strM10954a;
            C3250y.m11450b("Donwload Url : " + this.f5745a, f5744v);
            C3250y.m11450b("[Before connnecting] ", getClass().getName());
            InputStream inputStream3 = "uid";
            if (!this.f5748d) {
                ContentResolver contentResolver = CommonApplication.m11493l().getContentResolver();
                String str2 = this.f5752h;
                String str3 = this.f5749e;
                ?? ValueOf = Long.valueOf(this.f5750f);
                C1373q.m6160a(contentResolver, str2, str3, (Long) ValueOf, this.f5751g, true);
                inputStream3 = ValueOf;
            }
            long j2 = 0;
            try {
                try {
                    String str4 = this.f5747c.substring(0, this.f5747c.lastIndexOf(".")) + ".tmp";
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f5745a).openConnection();
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestMethod("GET");
                    if (this.f5759o == EnumC1455w.AMS || this.f5759o == EnumC1455w.IMAGE) {
                        httpURLConnection.setRequestProperty("cache-control", "no-transform");
                    }
                    httpURLConnection.setConnectTimeout(30000);
                    httpURLConnection.setReadTimeout(30000);
                    File file3 = new File(this.f5746b, str4);
                    if (!file3.exists() || file3.length() <= 0) {
                        z = false;
                        j = 0;
                        inputStream = inputStream3;
                    } else {
                        httpURLConnection.setRequestProperty("Range", "bytes=" + file3.length() + "-");
                        long length = file3.length();
                        z = true;
                        j = length;
                        j2 = length;
                        inputStream = "-";
                    }
                    httpURLConnection.connect();
                    List<String> list = null;
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    ?? IsEmpty = headerFields;
                    if (headerFields != null) {
                        list = httpURLConnection.getHeaderFields().get("Content-Length");
                        IsEmpty = "Content-Length";
                    }
                    if (list != null && (IsEmpty = list.isEmpty()) == 0) {
                        IsEmpty = 0;
                        Integer.parseInt(list.get(0));
                    }
                    try {
                        try {
                            try {
                                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                            } catch (Exception e) {
                                e = e;
                                fileOutputStream = null;
                                bufferedInputStream = null;
                            } catch (Throwable th) {
                                th = th;
                            }
                            try {
                                File file4 = new File(this.f5746b);
                                if (!file4.exists()) {
                                    file4.mkdirs();
                                }
                                file = new File(file4, str4);
                                fileOutputStream = z ? new FileOutputStream(file, z) : new FileOutputStream(file);
                            } catch (Exception e2) {
                                e = e2;
                                fileOutputStream = null;
                            } catch (Throwable th2) {
                                th = th2;
                                httpURLConnection.disconnect();
                                throw th;
                            }
                            try {
                                int contentLength = httpURLConnection.getContentLength();
                                byte[] bArr = new byte[1024];
                                this.f5758n = 0;
                                while (true) {
                                    int i = bufferedInputStream.read(bArr);
                                    if (i == -1 || isCancelled()) {
                                        break;
                                    }
                                    j2 += i;
                                    if (this.f5754j != null || this.f5769z != null) {
                                        if (contentLength > 0) {
                                            publishProgress(Integer.valueOf((int) ((100 * j2) / (contentLength + j))));
                                        } else if (this.f5758n < 100) {
                                            this.f5758n += 5;
                                            publishProgress(Integer.valueOf(this.f5758n));
                                        }
                                    }
                                    fileOutputStream.write(bArr, 0, i);
                                }
                                if (isCancelled()) {
                                    if (this.f5766w != null) {
                                        this.f5766w.post(runnableC1558d);
                                    }
                                    String str5 = C0816a.f3113b;
                                    httpURLConnection.disconnect();
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (IOException e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    return str5;
                                }
                                fileOutputStream.flush();
                                if (httpURLConnection.getResponseCode() == 200 || httpURLConnection.getResponseCode() == 206) {
                                    Uri uriFromFile = file.renameTo(file2) ? Uri.fromFile(file2) : Uri.fromFile(file);
                                    httpURLConnection.disconnect();
                                    C3250y.m11450b(uriFromFile.toString(), "File Downlad Task#2");
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (IOException e5) {
                                            e5.printStackTrace();
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e6) {
                                            e6.printStackTrace();
                                        }
                                    }
                                    return Uri.decode(uriFromFile.toString());
                                }
                                C3250y.m11442a("ResponseCode is NOT 200 OK", getClass().getName());
                                if (this.f5766w != null) {
                                    this.f5766w.post(runnableC1558d);
                                }
                                if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                                    C1533b.m6523a("01000006", "2002", httpURLConnection);
                                }
                                String str6 = C0816a.f3113b;
                                httpURLConnection.disconnect();
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e7) {
                                        e7.printStackTrace();
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e8) {
                                        e8.printStackTrace();
                                    }
                                }
                                return str6;
                            } catch (Exception e9) {
                                e = e9;
                                C3250y.m11443a(e, getClass().getName());
                                if (this.f5766w != null) {
                                    this.f5766w.post(runnableC1558d);
                                }
                                if (CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                                    C1533b.m6523a("01000006", "2002", httpURLConnection);
                                }
                                String str7 = C0816a.f3113b;
                                httpURLConnection.disconnect();
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e10) {
                                        e10.printStackTrace();
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e11) {
                                        e11.printStackTrace();
                                    }
                                }
                                return str7;
                            }
                        } catch (Exception e12) {
                            e = e12;
                            outputStream = IsEmpty;
                            inputStream2 = inputStream;
                            C3250y.m11443a(e, getClass().getName());
                            if (this.f5766w != null) {
                                this.f5766w.post(runnableC1558d);
                            }
                            String str8 = C0816a.f3113b;
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (IOException e13) {
                                    e13.printStackTrace();
                                }
                            }
                            if (outputStream == null) {
                                return str8;
                            }
                            try {
                                outputStream.close();
                                return str8;
                            } catch (IOException e14) {
                                e14.printStackTrace();
                                return str8;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            outputStream = IsEmpty;
                            inputStream2 = inputStream;
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (IOException e15) {
                                    e15.printStackTrace();
                                }
                            }
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e16) {
                                    e16.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Exception e17) {
                e = e17;
            }
        } catch (Exception e18) {
            C3250y.m11443a(e18, f5744v);
            return C0816a.f3113b;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        if (this.f5769z != null) {
            this.f5769z.m11483a(numArr[0].intValue());
        }
        if (this.f5768y != null && !this.f5748d) {
            if (((C1070el) this.f5768y.getTag()).f4273c == this.f5750f && numArr[0].intValue() <= 100 && this.f5754j != null) {
                this.f5754j.setProgress(numArr[0].intValue());
            }
            this.f5758n = numArr[0].intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        C3250y.m11450b("[onPostExecute]", getClass().getName());
        if (this.f5767x != null) {
            Message messageObtainMessage = this.f5767x.obtainMessage();
            messageObtainMessage.obj = String.valueOf(this.f5750f);
            messageObtainMessage.arg1 = this.f5759o.m6364a();
            Bundle bundle = new Bundle();
            bundle.putString("download_uri", str);
            messageObtainMessage.setData(bundle);
            this.f5767x.sendMessage(messageObtainMessage);
        }
        if (str == null || C0816a.f3113b.equals(str)) {
            C1373q.m6193c(CommonApplication.m11493l().getContentResolver(), Long.valueOf(this.f5750f));
        } else {
            C1373q.m6161a(CommonApplication.m11493l().getContentResolver(), this.f5752h, this.f5749e, Long.valueOf(this.f5750f), str, this.f5751g, this.f5753i, this.f5748d);
            if (this.f5762r.booleanValue()) {
                if (C1555a.m6596a().m6603d(this.f5750f)) {
                    C3250y.m11450b("Successfully removed from hashmap after down-load", getClass().getName());
                    return;
                }
                return;
            } else if (EnumC1455w.AUDIO == this.f5759o) {
                C1373q.m6179a(CommonApplication.m11493l().getContentResolver(), this.f5749e, Long.valueOf(this.f5750f), C3243r.m11423b(str), this.f5752h);
            }
        }
        if (this.f5759o == EnumC1455w.IMAGE || this.f5759o == EnumC1455w.VIDEO) {
            if (this.f5754j != null) {
                this.f5754j.setVisibility(4);
            }
        } else if (this.f5755k != null) {
            this.f5755k.setVisibility(4);
        }
        if (this.f5756l != null) {
            this.f5756l.setVisibility(4);
        }
        if (this.f5766w != null) {
            this.f5766w.post(new RunnableC1559e(this, str));
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
    }

    /* renamed from: a */
    public void m6608a(Handler handler) {
        this.f5767x = handler;
    }

    /* renamed from: a */
    public void m6610a(AlertDialogC3256c alertDialogC3256c) {
        this.f5769z = alertDialogC3256c;
    }

    /* renamed from: a */
    public boolean m6613a() {
        return this.f5748d;
    }
}
