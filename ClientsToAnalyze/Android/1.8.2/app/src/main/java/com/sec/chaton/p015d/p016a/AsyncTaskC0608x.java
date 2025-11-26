package com.sec.chaton.p015d.p016a;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import com.sec.chaton.R;
import com.sec.chaton.chat.C0484az;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p012c.C0452a;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.p017e.p018a.C0665i;
import com.sec.chaton.p022h.C0800j;
import com.sec.chaton.p022h.EnumC0801k;
import com.sec.chaton.p022h.p025c.C0777a;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1767bw;
import com.sec.chaton.util.C1771c;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.EnumC1765bu;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: FileDownloadTask2.java */
/* renamed from: com.sec.chaton.d.a.x */
/* loaded from: classes.dex */
public class AsyncTaskC0608x extends AsyncTask {

    /* renamed from: v */
    private static String f2394v = "FileDownloadTask2";

    /* renamed from: c */
    protected String f2397c;

    /* renamed from: d */
    protected boolean f2398d;

    /* renamed from: e */
    protected String f2399e;

    /* renamed from: f */
    protected long f2400f;

    /* renamed from: g */
    protected EnumC0695j f2401g;

    /* renamed from: h */
    protected String f2402h;

    /* renamed from: n */
    protected int f2408n;

    /* renamed from: p */
    protected EnumC0699n f2410p;

    /* renamed from: q */
    protected String f2411q;

    /* renamed from: r */
    protected String f2412r;

    /* renamed from: t */
    ChatFragment f2414t;

    /* renamed from: w */
    private Handler f2416w;

    /* renamed from: x */
    private View f2417x;

    /* renamed from: y */
    private Handler f2418y;

    /* renamed from: z */
    private ProgressDialog f2419z;

    /* renamed from: a */
    protected String f2395a = null;

    /* renamed from: b */
    protected String f2396b = null;

    /* renamed from: i */
    protected boolean f2403i = false;

    /* renamed from: j */
    ProgressBar f2404j = null;

    /* renamed from: k */
    ProgressBar f2405k = null;

    /* renamed from: l */
    Button f2406l = null;

    /* renamed from: m */
    public boolean f2407m = false;

    /* renamed from: o */
    protected int f2409o = 0;

    /* renamed from: s */
    Boolean f2413s = false;

    /* renamed from: u */
    String f2415u = null;

    public AsyncTaskC0608x(C0533aa c0533aa) {
        this.f2397c = null;
        this.f2398d = false;
        this.f2399e = null;
        this.f2400f = 0L;
        this.f2401g = EnumC0695j.ONETOONE;
        this.f2402h = null;
        this.f2416w = null;
        this.f2417x = null;
        this.f2408n = 0;
        this.f2411q = null;
        this.f2412r = null;
        this.f2414t = null;
        this.f2416w = c0533aa.f2164a;
        this.f2417x = c0533aa.f2165b;
        this.f2398d = c0533aa.f2169f;
        this.f2399e = c0533aa.f2170g;
        this.f2400f = c0533aa.f2171h;
        this.f2401g = c0533aa.f2172i;
        this.f2402h = c0533aa.f2173j;
        this.f2397c = c0533aa.f2168e;
        this.f2408n = c0533aa.f2174k;
        this.f2410p = c0533aa.f2175l;
        this.f2411q = c0533aa.f2167d;
        this.f2412r = c0533aa.f2166c;
        this.f2414t = c0533aa.f2176m;
    }

    /* renamed from: a */
    public void m2792a(View view) {
        C0484az c0484az = (C0484az) view.getTag();
        this.f2404j = c0484az.f2019A;
        if (this.f2404j != null) {
            this.f2404j.setProgress(this.f2409o);
        }
        this.f2405k = null;
        this.f2417x = view;
        this.f2406l = c0484az.f2021C;
        C1786r.m6061b("[setProgressView]", getClass().getName());
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        C1786r.m6061b("[onPreExecute]", getClass().getName());
        if (this.f2410p == EnumC0699n.IMAGE || this.f2410p == EnumC0699n.VIDEO) {
            this.f2404j = (ProgressBar) this.f2417x.findViewById(R.id.progressbarDown);
            this.f2404j.setProgress(0);
            this.f2405k = null;
            Log.d("FileDownloadTask2", "onPreExecutemProgessDown" + this.f2404j);
            return;
        }
        this.f2405k = (ProgressBar) this.f2417x.findViewById(R.id.DownProgressBalloon);
        this.f2404j = null;
        Log.d("FileDownloadTask2", "onPreExecutemProgressBalloon" + this.f2405k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v30, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v43, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Long] */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) throws Throwable {
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream;
        File file;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        RunnableC0609y runnableC0609y = new RunnableC0609y(this);
        C0800j c0800jM3409a = new C0800j(EnumC1765bu.FILE, "/file").m3406a(EnumC0801k.GET).m3409a("uid", C1789u.m6075a().getString("uid", ""));
        String str = "imei=" + C1721ad.m5873a() + "&buddyid=" + this.f2411q + "&filename=" + this.f2397c;
        C1786r.m6061b("filedownLoadUrl:" + str, f2394v);
        try {
            String strM6029a = GlobalApplication.m3264e().m6029a();
            if (TextUtils.isEmpty(strM6029a)) {
                C1786r.m6054a("Fail in getting a key", getClass().getName());
                if (this.f2416w != null) {
                    this.f2416w.post(runnableC0609y);
                }
                return C0452a.f1724c;
            }
            C1771c c1771c = new C1771c(C1771c.m6013b(strM6029a), C1771c.m6014c(strM6029a));
            String strM6009a = this.f2398d ? C1771c.m6009a(c1771c.m6015b((str + "&size=239").getBytes())) : C1771c.m6009a(c1771c.m6015b(str.getBytes()));
            c0800jM3409a.m3409a("param", strM6009a);
            this.f2403i = C1767bw.m6002a();
            try {
                this.f2396b = this.f2403i ? GlobalApplication.m3260b().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m3260b().getFilesDir().getAbsolutePath();
                this.f2396b += "/" + this.f2399e + "/";
                if (this.f2398d) {
                    this.f2396b += "thumbnail//";
                }
                File file2 = new File(this.f2396b, this.f2397c);
                if (file2.exists()) {
                    this.f2413s = true;
                    this.f2415u = Uri.decode(Uri.fromFile(file2).toString());
                    return this.f2415u;
                }
                this.f2395a = this.f2412r + "?uid=" + C1789u.m6075a().getString("uid", "") + "&param=" + strM6009a;
                C1786r.m6061b("Donwload Url : " + this.f2395a, f2394v);
                C1786r.m6061b("[Before connnecting] ", getClass().getName());
                ContentResolver contentResolver = GlobalApplication.m3260b().getContentResolver();
                String str2 = this.f2402h;
                String str3 = this.f2399e;
                ?? ValueOf = Long.valueOf(this.f2400f);
                C0665i.m3056a(contentResolver, str2, str3, (Long) ValueOf, this.f2401g, true);
                try {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f2395a).openConnection();
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setRequestProperty("cache-control", "no-transform");
                        httpURLConnection.setConnectTimeout(30000);
                        httpURLConnection.setReadTimeout(30000);
                        httpURLConnection.connect();
                        OutputStream outputStream2 = "no-transform";
                        if (httpURLConnection.getHeaderFields() != null) {
                            httpURLConnection.getHeaderFields().get("Content-Length");
                            outputStream2 = "Content-Length";
                        }
                        try {
                            try {
                                String str4 = String.valueOf(System.currentTimeMillis()) + this.f2397c;
                                try {
                                    bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                                    try {
                                        File file3 = new File(this.f2396b);
                                        if (!file3.exists()) {
                                            file3.mkdirs();
                                        }
                                        file = new File(file3, str4);
                                        fileOutputStream = new FileOutputStream(file);
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
                                    fileOutputStream = null;
                                    bufferedInputStream = null;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                                try {
                                    int contentLength = httpURLConnection.getContentLength();
                                    byte[] bArr = new byte[AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END];
                                    long j = 0;
                                    this.f2409o = 0;
                                    while (true) {
                                        int i = bufferedInputStream.read(bArr);
                                        if (i == -1 || this.f2407m) {
                                            break;
                                        }
                                        j += i;
                                        if (this.f2404j != null) {
                                            if (contentLength > 0) {
                                                publishProgress(Integer.valueOf((int) ((100 * j) / contentLength)));
                                            } else if (this.f2409o < 100) {
                                                this.f2409o += 5;
                                                publishProgress(Integer.valueOf(this.f2409o));
                                            }
                                        }
                                        fileOutputStream.write(bArr, 0, i);
                                    }
                                    if (GlobalApplication.m3265f()) {
                                        if (isCancelled()) {
                                            if (this.f2416w != null) {
                                                this.f2416w.post(runnableC0609y);
                                            }
                                            String str5 = C0452a.f1724c;
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
                                    } else if (this.f2407m) {
                                        if (this.f2416w != null) {
                                            this.f2416w.post(runnableC0609y);
                                        }
                                        String str6 = C0452a.f1724c;
                                        httpURLConnection.disconnect();
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
                                        return str6;
                                    }
                                    fileOutputStream.flush();
                                    if (httpURLConnection.getResponseCode() == 200) {
                                        Uri uriFromFile = file.renameTo(file2) ? Uri.fromFile(file2) : Uri.fromFile(file);
                                        httpURLConnection.disconnect();
                                        C1786r.m6061b(uriFromFile.toString(), "File Downlad Task#2");
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
                                        return Uri.decode(uriFromFile.toString());
                                    }
                                    C1786r.m6054a("ResponseCode is NOT 200 OK", getClass().getName());
                                    if (this.f2416w != null) {
                                        this.f2416w.post(runnableC0609y);
                                    }
                                    String str7 = C0452a.f1724c;
                                    httpURLConnection.disconnect();
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (IOException e9) {
                                            e9.printStackTrace();
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e10) {
                                            e10.printStackTrace();
                                        }
                                    }
                                    return str7;
                                } catch (Exception e11) {
                                    e = e11;
                                    C1786r.m6056a(e, getClass().getName());
                                    if (this.f2416w != null) {
                                        this.f2416w.post(runnableC0609y);
                                    }
                                    String str8 = C0452a.f1724c;
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
                                    return str8;
                                }
                            } catch (Exception e14) {
                                e = e14;
                                outputStream = outputStream2;
                                inputStream = ValueOf;
                                C1786r.m6056a(e, getClass().getName());
                                if (this.f2416w != null) {
                                    this.f2416w.post(runnableC0609y);
                                }
                                String str9 = C0452a.f1724c;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e15) {
                                        e15.printStackTrace();
                                    }
                                }
                                if (outputStream == null) {
                                    return str9;
                                }
                                try {
                                    outputStream.close();
                                    return str9;
                                } catch (IOException e16) {
                                    e16.printStackTrace();
                                    return str9;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                outputStream = outputStream2;
                                inputStream = ValueOf;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e17) {
                                        e17.printStackTrace();
                                    }
                                }
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (IOException e18) {
                                        e18.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } catch (Exception e19) {
                        e = e19;
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (NullPointerException e20) {
                C1786r.m6054a("Fail to get DownloadPath", f2394v);
                return C0452a.f1724c;
            }
        } catch (Exception e21) {
            C1786r.m6056a(e21, f2394v);
            return C0452a.f1724c;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        C0484az c0484az = (C0484az) this.f2417x.getTag();
        try {
            if (c0484az.f2041a != null && Long.parseLong(c0484az.f2041a) == this.f2400f && numArr[0].intValue() <= 100) {
                if (this.f2419z != null) {
                    this.f2419z.setProgress(numArr[0].intValue());
                }
                if (this.f2404j != null) {
                    this.f2404j.setProgress(numArr[0].intValue());
                }
            }
        } catch (NumberFormatException e) {
            if (C1786r.f6455e) {
                C1786r.m6056a(e, f2394v);
            }
        }
        this.f2409o = numArr[0].intValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        C1786r.m6061b("[onPostExecute]", getClass().getName());
        if (str == null || this.f2407m) {
            C0665i.m3068b(GlobalApplication.m3260b().getContentResolver(), Long.valueOf(this.f2400f));
        } else {
            C0665i.m3058a(GlobalApplication.m3260b().getContentResolver(), this.f2402h, this.f2399e, Long.valueOf(this.f2400f), str, this.f2401g, this.f2403i, this.f2398d);
            if (this.f2413s.booleanValue()) {
                if (C0777a.m3326a().m3332d(this.f2400f)) {
                    C1786r.m6061b("Successfully removed from hashmap after down-load", getClass().getName());
                    return;
                }
                return;
            }
        }
        if (this.f2418y != null) {
            Message messageObtainMessage = this.f2418y.obtainMessage();
            messageObtainMessage.obj = str;
            this.f2418y.sendMessage(messageObtainMessage);
        }
        if (this.f2410p == EnumC0699n.IMAGE || this.f2410p == EnumC0699n.VIDEO) {
            if (this.f2404j != null) {
                this.f2404j.setVisibility(4);
            }
        } else if (this.f2405k != null) {
            this.f2405k.setVisibility(4);
        }
        if (this.f2406l != null) {
            this.f2406l.setVisibility(4);
        }
        if (this.f2416w != null) {
            this.f2416w.post(new RunnableC0610z(this, str));
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        this.f2407m = true;
        super.onCancelled();
    }

    /* renamed from: a */
    public void m2791a(Handler handler) {
        this.f2418y = handler;
    }

    /* renamed from: a */
    public void m2790a(ProgressDialog progressDialog) {
        this.f2419z = progressDialog;
    }
}
