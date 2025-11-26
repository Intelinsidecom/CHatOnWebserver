package com.sec.chaton.p018c.p019a;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.chat.C0606w;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p018c.C0519z;
import com.sec.chaton.p018c.EnumC0511r;
import com.sec.chaton.p025d.EnumC0651d;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p025d.p026a.C0635o;
import com.sec.chaton.p029f.C0684a;
import com.sec.chaton.util.C1322br;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1327bw;
import com.sec.chaton.util.C1336k;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.EnumC1333h;
import com.sec.widget.C1619g;
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
/* renamed from: com.sec.chaton.c.a.c */
/* loaded from: classes.dex */
public class AsyncTaskC0466c extends AsyncTask {

    /* renamed from: v */
    private static String f1462v = "FileDownloadTask2";

    /* renamed from: c */
    protected String f1465c;

    /* renamed from: d */
    protected boolean f1466d;

    /* renamed from: e */
    protected String f1467e;

    /* renamed from: f */
    protected long f1468f;

    /* renamed from: g */
    protected EnumC0665r f1469g;

    /* renamed from: h */
    protected String f1470h;

    /* renamed from: m */
    protected int f1475m;

    /* renamed from: o */
    protected EnumC0651d f1477o;

    /* renamed from: p */
    protected String f1478p;

    /* renamed from: q */
    protected String f1479q;

    /* renamed from: s */
    ChatFragment f1481s;

    /* renamed from: u */
    Toast f1483u;

    /* renamed from: w */
    private Handler f1484w;

    /* renamed from: x */
    private View f1485x;

    /* renamed from: a */
    protected String f1463a = null;

    /* renamed from: b */
    protected String f1464b = null;

    /* renamed from: i */
    protected boolean f1471i = false;

    /* renamed from: j */
    ProgressBar f1472j = null;

    /* renamed from: k */
    ProgressBar f1473k = null;

    /* renamed from: l */
    Button f1474l = null;

    /* renamed from: n */
    protected int f1476n = 0;

    /* renamed from: r */
    Boolean f1480r = false;

    /* renamed from: t */
    String f1482t = null;

    public AsyncTaskC0466c(C0469f c0469f) {
        this.f1465c = null;
        this.f1466d = false;
        this.f1467e = null;
        this.f1468f = 0L;
        this.f1469g = EnumC0665r.ONETOONE;
        this.f1470h = null;
        this.f1484w = null;
        this.f1485x = null;
        this.f1475m = 0;
        this.f1478p = null;
        this.f1479q = null;
        this.f1481s = null;
        this.f1483u = null;
        this.f1484w = c0469f.f1491a;
        this.f1485x = c0469f.f1492b;
        this.f1466d = c0469f.f1496f;
        this.f1467e = c0469f.f1497g;
        this.f1468f = c0469f.f1498h;
        this.f1469g = c0469f.f1499i;
        this.f1470h = c0469f.f1500j;
        this.f1465c = c0469f.f1495e;
        this.f1475m = c0469f.f1501k;
        this.f1477o = c0469f.f1502l;
        this.f1478p = c0469f.f1494d;
        this.f1479q = c0469f.f1493c;
        this.f1481s = c0469f.f1503m;
        this.f1483u = C1619g.m5888a(GlobalApplication.m3100a(), R.string.media_download_fail, 0);
    }

    /* renamed from: a */
    public void m2384a(View view) {
        C0606w c0606w = (C0606w) view.getTag();
        this.f1472j = c0606w.f2137x;
        if (this.f1472j != null) {
            this.f1472j.setProgress(this.f1476n);
        }
        this.f1473k = null;
        this.f1485x = view;
        this.f1474l = c0606w.f2139z;
        C1341p.m4658b("[setProgressView]", getClass().getName());
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        C1341p.m4658b("[onPreExecute]", getClass().getName());
        if (this.f1477o == EnumC0651d.IMAGE || this.f1477o == EnumC0651d.VIDEO) {
            this.f1472j = (ProgressBar) this.f1485x.findViewById(R.id.progressbarDown);
            this.f1472j.setProgress(0);
            this.f1473k = null;
            Log.d("FileDownloadTask2", "onPreExecutemProgessDown" + this.f1472j);
            return;
        }
        this.f1473k = (ProgressBar) this.f1485x.findViewById(R.id.DownProgressBalloon);
        this.f1472j = null;
        Log.d("FileDownloadTask2", "onPreExecutemProgressBalloon" + this.f1473k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v44, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v45 */
    /* JADX WARN: Type inference failed for: r4v57 */
    /* JADX WARN: Type inference failed for: r4v58 */
    /* JADX WARN: Type inference failed for: r5v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Long] */
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
        RunnableC0472i runnableC0472i = new RunnableC0472i(this);
        C0519z c0519zM2584a = new C0519z(EnumC1333h.FILE, "/file").m2581a(EnumC0511r.GET).m2584a("uid", C1323bs.m4575a().getString("uid", ""));
        String str = "imei=" + C1336k.m4621a() + "&buddyid=" + this.f1478p + "&filename=" + this.f1465c;
        C1341p.m4658b("filedownLoadUrl:" + str, f1462v);
        try {
            String strM4670a = GlobalApplication.m3108i().m4670a();
            if (TextUtils.isEmpty(strM4670a)) {
                C1341p.m4651a("Fail in getting a key", getClass().getName());
                if (this.f1484w != null) {
                    this.f1484w.post(runnableC0472i);
                }
                return C0684a.f2332c;
            }
            C1322br c1322br = new C1322br(C1322br.m4571b(strM4670a), C1322br.m4572c(strM4670a));
            String strM4567a = this.f1466d ? C1322br.m4567a(c1322br.m4573b((str + "&size=239").getBytes())) : C1322br.m4567a(c1322br.m4573b(str.getBytes()));
            c0519zM2584a.m2584a("param", strM4567a);
            this.f1471i = C1327bw.m4595a();
            this.f1464b = this.f1471i ? GlobalApplication.m3100a().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m3100a().getFilesDir().getAbsolutePath();
            this.f1464b += "/" + this.f1467e + "/";
            if (this.f1466d) {
                this.f1464b += "thumbnail//";
            }
            File file2 = new File(this.f1464b, this.f1465c);
            if (file2.exists()) {
                this.f1480r = true;
                this.f1482t = Uri.decode(Uri.fromFile(file2).toString());
                return this.f1482t;
            }
            this.f1463a = this.f1479q + "?uid=" + C1323bs.m4575a().getString("uid", "") + "&param=" + strM4567a;
            C1341p.m4658b("Donwload Url : " + this.f1463a, f1462v);
            C1341p.m4658b("[Before connnecting] ", getClass().getName());
            ContentResolver contentResolver = GlobalApplication.m3100a().getContentResolver();
            String str2 = this.f1470h;
            String str3 = this.f1467e;
            ?? ValueOf = Long.valueOf(this.f1468f);
            C0635o.m2925a(contentResolver, str2, str3, (Long) ValueOf, this.f1469g, true);
            long j2 = 0;
            try {
                try {
                    String str4 = this.f1465c.substring(0, this.f1465c.lastIndexOf(".")) + ".tmp";
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f1463a).openConnection();
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty("cache-control", "no-transform");
                    httpURLConnection.setConnectTimeout(30000);
                    httpURLConnection.setReadTimeout(30000);
                    File file3 = new File(this.f1464b, str4);
                    if (!file3.exists() || file3.length() <= 0) {
                        z = false;
                        j = 0;
                        inputStream = ValueOf;
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
                                try {
                                    File file4 = new File(this.f1464b);
                                    if (!file4.exists()) {
                                        file4.mkdirs();
                                    }
                                    file = new File(file4, str4);
                                    fileOutputStream = z ? new FileOutputStream(file, z) : new FileOutputStream(file);
                                } catch (Exception e) {
                                    e = e;
                                    fileOutputStream = null;
                                } catch (Throwable th) {
                                    th = th;
                                    httpURLConnection.disconnect();
                                    throw th;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                outputStream = IsEmpty;
                                inputStream2 = inputStream;
                                C1341p.m4653a(e, getClass().getName());
                                if (this.f1484w != null) {
                                    this.f1484w.post(runnableC0472i);
                                }
                                String str5 = C0684a.f2332c;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                if (outputStream == null) {
                                    return str5;
                                }
                                try {
                                    outputStream.close();
                                    return str5;
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    return str5;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                outputStream = IsEmpty;
                                inputStream2 = inputStream;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            fileOutputStream = null;
                            bufferedInputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                        try {
                            int contentLength = httpURLConnection.getContentLength();
                            byte[] bArr = new byte[1024];
                            this.f1476n = 0;
                            while (true) {
                                int i = bufferedInputStream.read(bArr);
                                if (i == -1 || isCancelled()) {
                                    break;
                                }
                                j2 += i;
                                if (this.f1472j != null) {
                                    if (contentLength > 0) {
                                        publishProgress(Integer.valueOf((int) ((100 * j2) / (contentLength + j))));
                                    } else if (this.f1476n < 100) {
                                        this.f1476n += 5;
                                        publishProgress(Integer.valueOf(this.f1476n));
                                    }
                                }
                                fileOutputStream.write(bArr, 0, i);
                            }
                            if (isCancelled()) {
                                if (this.f1484w != null) {
                                    this.f1484w.post(runnableC0472i);
                                }
                                String str6 = C0684a.f2332c;
                                httpURLConnection.disconnect();
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e8) {
                                        e8.printStackTrace();
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e9) {
                                        e9.printStackTrace();
                                    }
                                }
                                return str6;
                            }
                            fileOutputStream.flush();
                            if (httpURLConnection.getResponseCode() == 200 || httpURLConnection.getResponseCode() == 206) {
                                Uri uriFromFile = file.renameTo(file2) ? Uri.fromFile(file2) : Uri.fromFile(file);
                                httpURLConnection.disconnect();
                                C1341p.m4658b(uriFromFile.toString(), "File Downlad Task#2");
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
                                return Uri.decode(uriFromFile.toString());
                            }
                            C1341p.m4651a("ResponseCode is NOT 200 OK", getClass().getName());
                            if (this.f1484w != null) {
                                this.f1484w.post(runnableC0472i);
                            }
                            String str7 = C0684a.f2332c;
                            httpURLConnection.disconnect();
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e12) {
                                    e12.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e13) {
                                    e13.printStackTrace();
                                }
                            }
                            return str7;
                        } catch (Exception e14) {
                            e = e14;
                            C1341p.m4653a(e, getClass().getName());
                            if (this.f1484w != null) {
                                this.f1484w.post(runnableC0472i);
                            }
                            String str8 = C0684a.f2332c;
                            httpURLConnection.disconnect();
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e15) {
                                    e15.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e16) {
                                    e16.printStackTrace();
                                }
                            }
                            return str8;
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
            C1341p.m4653a(e18, f1462v);
            return C0684a.f2332c;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        if (Long.parseLong(((C0606w) this.f1485x.getTag()).f2114a) == this.f1468f && numArr[0].intValue() <= 100 && this.f1472j != null) {
            this.f1472j.setProgress(numArr[0].intValue());
        }
        this.f1476n = numArr[0].intValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        C1341p.m4658b("[onPostExecute]", getClass().getName());
        if (str == null || C0684a.f2332c.equals(str)) {
            C0635o.m2942b(GlobalApplication.m3100a().getContentResolver(), Long.valueOf(this.f1468f));
        } else {
            C0635o.m2927a(GlobalApplication.m3100a().getContentResolver(), this.f1470h, this.f1467e, Long.valueOf(this.f1468f), str, this.f1469g, this.f1471i, this.f1466d);
            if (this.f1480r.booleanValue()) {
                if (C0473j.m2410a().m2416d(this.f1468f)) {
                    C1341p.m4658b("Successfully removed from hashmap after down-load", getClass().getName());
                }
                if (this.f1484w != null) {
                    this.f1484w.post(new RunnableC0471h(this));
                    return;
                }
                return;
            }
        }
        if (this.f1477o == EnumC0651d.IMAGE || this.f1477o == EnumC0651d.VIDEO) {
            if (this.f1472j != null) {
                this.f1472j.setVisibility(4);
            }
        } else if (this.f1473k != null) {
            this.f1473k.setVisibility(4);
        }
        if (this.f1474l != null) {
            this.f1474l.setVisibility(4);
        }
        if (this.f1484w != null) {
            this.f1484w.post(new RunnableC0470g(this));
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
    }
}
