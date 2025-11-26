package com.sec.chaton.control.task;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import com.sec.chaton.C0062R;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.chat.ChatListAdapter;
import com.sec.chaton.constant.ChatONConst;
import com.sec.chaton.control.MessageControl;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.MessageDatabaseHelper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.util.AesCipher;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.DeviceInfoUtil;
import com.sec.chaton.util.ServerAddressMgr;
import com.sec.chaton.util.StorageStateInfoUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/* loaded from: classes.dex */
public class FileDownloadTask2 extends AsyncTask {

    /* renamed from: v */
    private static String f1521v = "FileDownloadTask2";

    /* renamed from: c */
    protected String f1524c;

    /* renamed from: d */
    protected boolean f1525d;

    /* renamed from: e */
    protected String f1526e;

    /* renamed from: f */
    protected long f1527f;

    /* renamed from: g */
    protected ChatONContract.InBoxTable.ChatType f1528g;

    /* renamed from: h */
    protected String f1529h;

    /* renamed from: n */
    protected int f1535n;

    /* renamed from: p */
    protected ChatONContract.MessageTable.MsgContentType f1537p;

    /* renamed from: q */
    protected String f1538q;

    /* renamed from: r */
    protected String f1539r;

    /* renamed from: t */
    ChatFragment f1541t;

    /* renamed from: w */
    private Handler f1543w;

    /* renamed from: x */
    private View f1544x;

    /* renamed from: a */
    protected String f1522a = null;

    /* renamed from: b */
    protected String f1523b = null;

    /* renamed from: i */
    protected boolean f1530i = false;

    /* renamed from: j */
    ProgressBar f1531j = null;

    /* renamed from: k */
    ProgressBar f1532k = null;

    /* renamed from: l */
    Button f1533l = null;

    /* renamed from: m */
    boolean f1534m = false;

    /* renamed from: o */
    protected int f1536o = 0;

    /* renamed from: s */
    Boolean f1540s = false;

    /* renamed from: u */
    String f1542u = null;

    public class Builder {

        /* renamed from: a */
        protected Handler f1545a = null;

        /* renamed from: b */
        protected View f1546b = null;

        /* renamed from: c */
        protected String f1547c = null;

        /* renamed from: d */
        protected String f1548d = null;

        /* renamed from: e */
        protected String f1549e = null;

        /* renamed from: f */
        protected boolean f1550f = false;

        /* renamed from: g */
        protected String f1551g = null;

        /* renamed from: h */
        protected long f1552h = 0;

        /* renamed from: i */
        protected ChatONContract.InBoxTable.ChatType f1553i = ChatONContract.InBoxTable.ChatType.ONETOONE;

        /* renamed from: j */
        protected String f1554j = null;

        /* renamed from: k */
        protected int f1555k = 0;

        /* renamed from: l */
        protected ChatONContract.MessageTable.MsgContentType f1556l;

        /* renamed from: m */
        ChatFragment f1557m;

        /* renamed from: a */
        public Builder m2120a(int i) {
            this.f1555k = i;
            return this;
        }

        /* renamed from: a */
        public Builder m2121a(long j) {
            this.f1552h = j;
            return this;
        }

        /* renamed from: a */
        public Builder m2122a(Handler handler) {
            this.f1545a = handler;
            return this;
        }

        /* renamed from: a */
        public Builder m2123a(View view) {
            this.f1546b = view;
            return this;
        }

        /* renamed from: a */
        public Builder m2124a(ChatFragment chatFragment) {
            this.f1557m = chatFragment;
            return this;
        }

        /* renamed from: a */
        public Builder m2125a(ChatONContract.InBoxTable.ChatType chatType) {
            this.f1553i = chatType;
            return this;
        }

        /* renamed from: a */
        public Builder m2126a(ChatONContract.MessageTable.MsgContentType msgContentType) {
            this.f1556l = msgContentType;
            return this;
        }

        /* renamed from: a */
        public Builder m2127a(String str) {
            this.f1547c = str;
            return this;
        }

        /* renamed from: a */
        public Builder m2128a(boolean z) {
            this.f1550f = z;
            return this;
        }

        /* renamed from: a */
        public FileDownloadTask2 m2129a() {
            return new FileDownloadTask2(this);
        }

        /* renamed from: b */
        public Builder m2130b(String str) {
            this.f1548d = str;
            return this;
        }

        /* renamed from: c */
        public Builder m2131c(String str) {
            this.f1549e = str;
            return this;
        }

        /* renamed from: d */
        public Builder m2132d(String str) {
            this.f1551g = str;
            return this;
        }

        /* renamed from: e */
        public Builder m2133e(String str) {
            this.f1554j = str;
            return this;
        }
    }

    public FileDownloadTask2(Builder builder) {
        this.f1524c = null;
        this.f1525d = false;
        this.f1526e = null;
        this.f1527f = 0L;
        this.f1528g = ChatONContract.InBoxTable.ChatType.ONETOONE;
        this.f1529h = null;
        this.f1543w = null;
        this.f1544x = null;
        this.f1535n = 0;
        this.f1538q = null;
        this.f1539r = null;
        this.f1541t = null;
        this.f1543w = builder.f1545a;
        this.f1544x = builder.f1546b;
        this.f1525d = builder.f1550f;
        this.f1526e = builder.f1551g;
        this.f1527f = builder.f1552h;
        this.f1528g = builder.f1553i;
        this.f1529h = builder.f1554j;
        this.f1524c = builder.f1549e;
        this.f1535n = builder.f1555k;
        this.f1537p = builder.f1556l;
        this.f1538q = builder.f1548d;
        this.f1539r = builder.f1547c;
        this.f1541t = builder.f1557m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v101 */
    /* JADX WARN: Type inference failed for: r2v71, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v74 */
    /* JADX WARN: Type inference failed for: r2v76 */
    /* JADX WARN: Type inference failed for: r2v79 */
    /* JADX WARN: Type inference failed for: r2v83, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v85 */
    /* JADX WARN: Type inference failed for: r3v23, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v26, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r3v32, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v47 */
    /* JADX WARN: Type inference failed for: r3v50, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r3v52, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r3v55, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r3v57, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v29, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v34, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v51 */
    /* JADX WARN: Type inference failed for: r4v53 */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) throws Throwable {
        OutputStream outputStream;
        IOException e;
        String str;
        OutputStream outputStream2;
        BufferedInputStream bufferedInputStream;
        RunnableC0199h runnableC0199h = new RunnableC0199h(this);
        HttpEnvelope.Builder builderM2741a = new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.FILE, "/file").m2738a(HttpEnvelope.RequestMethod.GET).m2741a("uid", ChatONPref.m3519a().getString("uid", ""));
        String str2 = "imei=" + DeviceInfoUtil.m3564a() + "&buddyid=" + this.f1538q + "&filename=" + this.f1524c;
        ChatONLogWriter.m3506b("filedownLoadUrl:" + str2, f1521v);
        try {
            String strM3477a = GlobalApplication.m2390h().m3477a();
            if (TextUtils.isEmpty(strM3477a)) {
                ChatONLogWriter.m3499a("Fail in getting a key", getClass().getName());
                if (this.f1543w != null) {
                    this.f1543w.post(runnableC0199h);
                }
                return ChatONConst.f1339c;
            }
            AesCipher aesCipher = new AesCipher(AesCipher.m3469b(strM3477a), AesCipher.m3470c(strM3477a));
            String strM3465a = this.f1525d ? AesCipher.m3465a(aesCipher.m3471b((str2 + "&size=239").getBytes())) : AesCipher.m3465a(aesCipher.m3471b(str2.getBytes()));
            builderM2741a.m2741a("param", strM3465a);
            this.f1530i = StorageStateInfoUtil.m3677a();
            this.f1523b = this.f1530i ? GlobalApplication.m2387e().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m2387e().getFilesDir().getAbsolutePath();
            this.f1523b += "/" + this.f1526e + "/";
            if (this.f1525d) {
                this.f1523b += "thumbnail//";
            }
            File file = new File(this.f1523b, this.f1524c);
            if (file.exists()) {
                this.f1540s = true;
                this.f1542u = Uri.decode(Uri.fromFile(file).toString());
                return this.f1542u;
            }
            this.f1522a = this.f1539r + "?uid=" + ChatONPref.m3519a().getString("uid", "") + "&param=" + strM3465a;
            ChatONLogWriter.m3506b("Donwload Url : " + this.f1522a, f1521v);
            ChatONLogWriter.m3506b("[Before connnecting] ", getClass().getName());
            ContentResolver contentResolver = GlobalApplication.m2387e().getContentResolver();
            ?? r3 = this.f1529h;
            ?? r4 = this.f1526e;
            MessageDatabaseHelper.m2286a(contentResolver, (String) r3, (String) r4, Long.valueOf(this.f1527f), this.f1528g, true);
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f1522a).openConnection();
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(30000);
                    httpURLConnection.setReadTimeout(30000);
                    httpURLConnection.connect();
                    List<String> list = httpURLConnection.getHeaderFields().get("Content-Length");
                    outputStream = "Content-Length";
                    if (list != null) {
                        ?? IsEmpty = list.isEmpty();
                        outputStream = IsEmpty;
                        if (IsEmpty == 0) {
                            outputStream = null;
                            Integer.parseInt(list.get(0));
                        }
                    }
                    try {
                        String str3 = String.valueOf(System.currentTimeMillis()) + this.f1524c;
                        try {
                            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
                            try {
                                File file2 = new File(this.f1523b);
                                if (!file2.exists()) {
                                    file2.mkdirs();
                                }
                                File file3 = new File(file2, str3);
                                ?? fileOutputStream = new FileOutputStream(file3);
                                try {
                                    int contentLength = httpURLConnection.getContentLength();
                                    byte[] bArr = new byte[1024];
                                    long j = 0;
                                    this.f1536o = 0;
                                    while (true) {
                                        int i = bufferedInputStream2.read(bArr);
                                        if (i == -1 || this.f1534m) {
                                            break;
                                        }
                                        j += i;
                                        if (this.f1531j != null) {
                                            if (contentLength > 0) {
                                                publishProgress(Integer.valueOf((int) ((100 * j) / contentLength)));
                                            } else if (this.f1536o < 100) {
                                                this.f1536o += 5;
                                                publishProgress(Integer.valueOf(this.f1536o));
                                            }
                                        }
                                        fileOutputStream.write(bArr, 0, i);
                                    }
                                    try {
                                        if (this.f1534m) {
                                            if (this.f1543w != null) {
                                                this.f1543w.post(runnableC0199h);
                                            }
                                            String str4 = ChatONConst.f1339c;
                                            httpURLConnection.disconnect();
                                            BufferedInputStream bufferedInputStream3 = bufferedInputStream2;
                                            if (bufferedInputStream2 != null) {
                                                try {
                                                    bufferedInputStream2.close();
                                                    bufferedInputStream3 = bufferedInputStream2;
                                                } catch (IOException e2) {
                                                    e2.printStackTrace();
                                                    bufferedInputStream3 = e2;
                                                }
                                            }
                                            if (fileOutputStream != 0) {
                                                try {
                                                    fileOutputStream.close();
                                                } catch (IOException e3) {
                                                    e3.printStackTrace();
                                                }
                                            }
                                            fileOutputStream = str4;
                                            bufferedInputStream2 = bufferedInputStream3;
                                        } else {
                                            fileOutputStream.flush();
                                            if (httpURLConnection.getResponseCode() == 200) {
                                                Uri uriFromFile = file3.renameTo(file) ? Uri.fromFile(file) : Uri.fromFile(file3);
                                                httpURLConnection.disconnect();
                                                ChatONLogWriter.m3506b(uriFromFile.toString(), "File Downlad Task#2");
                                                BufferedInputStream bufferedInputStream4 = bufferedInputStream2;
                                                if (bufferedInputStream2 != null) {
                                                    try {
                                                        bufferedInputStream2.close();
                                                        bufferedInputStream4 = bufferedInputStream2;
                                                    } catch (IOException e4) {
                                                        e4.printStackTrace();
                                                        bufferedInputStream4 = e4;
                                                    }
                                                }
                                                if (fileOutputStream != 0) {
                                                    try {
                                                        fileOutputStream.close();
                                                    } catch (IOException e5) {
                                                        e5.printStackTrace();
                                                    }
                                                }
                                                fileOutputStream = Uri.decode(uriFromFile.toString());
                                                bufferedInputStream2 = bufferedInputStream4;
                                            } else {
                                                ChatONLogWriter.m3499a("ResponseCode is NOT 200 OK", getClass().getName());
                                                if (this.f1543w != null) {
                                                    this.f1543w.post(runnableC0199h);
                                                }
                                                String str5 = ChatONConst.f1339c;
                                                httpURLConnection.disconnect();
                                                BufferedInputStream bufferedInputStream5 = bufferedInputStream2;
                                                if (bufferedInputStream2 != null) {
                                                    try {
                                                        bufferedInputStream2.close();
                                                        bufferedInputStream5 = bufferedInputStream2;
                                                    } catch (IOException e6) {
                                                        e6.printStackTrace();
                                                        bufferedInputStream5 = e6;
                                                    }
                                                }
                                                if (fileOutputStream != 0) {
                                                    try {
                                                        fileOutputStream.close();
                                                    } catch (IOException e7) {
                                                        e7.printStackTrace();
                                                    }
                                                }
                                                fileOutputStream = str5;
                                                bufferedInputStream2 = bufferedInputStream5;
                                            }
                                        }
                                        return fileOutputStream;
                                    } catch (Exception e8) {
                                        r4 = bufferedInputStream2;
                                        outputStream = fileOutputStream;
                                        e = e8;
                                        ChatONLogWriter.m3501a(e, getClass().getName());
                                        if (this.f1543w != null) {
                                            this.f1543w.post(runnableC0199h);
                                        }
                                        str = ChatONConst.f1339c;
                                        if (r4 != 0) {
                                            try {
                                                r4.close();
                                            } catch (IOException e9) {
                                                e9.printStackTrace();
                                            }
                                        }
                                        if (outputStream == null) {
                                            return str;
                                        }
                                        try {
                                            outputStream.close();
                                            return str;
                                        } catch (IOException e10) {
                                            e = e10;
                                            e.printStackTrace();
                                            return str;
                                        }
                                    } catch (Throwable th) {
                                        r4 = bufferedInputStream2;
                                        r3 = fileOutputStream;
                                        th = th;
                                        if (r4 != 0) {
                                            try {
                                                r4.close();
                                            } catch (IOException e11) {
                                                e11.printStackTrace();
                                            }
                                        }
                                        if (r3 != 0) {
                                            try {
                                                r3.close();
                                            } catch (IOException e12) {
                                                e12.printStackTrace();
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Exception e13) {
                                    bufferedInputStream = bufferedInputStream2;
                                    outputStream2 = fileOutputStream;
                                    e = e13;
                                    try {
                                        ChatONLogWriter.m3501a(e, getClass().getName());
                                        if (this.f1543w != null) {
                                            this.f1543w.post(runnableC0199h);
                                        }
                                        str = ChatONConst.f1339c;
                                        httpURLConnection.disconnect();
                                        if (bufferedInputStream != null) {
                                            try {
                                                bufferedInputStream.close();
                                            } catch (IOException e14) {
                                                e14.printStackTrace();
                                            }
                                        }
                                        if (outputStream2 == null) {
                                            return str;
                                        }
                                        try {
                                            outputStream2.close();
                                            return str;
                                        } catch (IOException e15) {
                                            e = e15;
                                            e.printStackTrace();
                                            return str;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        httpURLConnection.disconnect();
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    httpURLConnection.disconnect();
                                    throw th;
                                }
                            } catch (Exception e16) {
                                e = e16;
                                bufferedInputStream = bufferedInputStream2;
                                outputStream2 = null;
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } catch (Exception e17) {
                            e = e17;
                            outputStream2 = null;
                            bufferedInputStream = null;
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } catch (Exception e18) {
                        e = e18;
                    }
                } catch (Exception e19) {
                    e = e19;
                    outputStream = null;
                    r4 = 0;
                } catch (Throwable th6) {
                    th = th6;
                    r3 = 0;
                    r4 = 0;
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Exception e20) {
            ChatONLogWriter.m3501a(e20, f1521v);
            return ChatONConst.f1339c;
        }
    }

    /* renamed from: a */
    public void m2117a(View view) {
        ChatListAdapter.BalloonHolder balloonHolder = (ChatListAdapter.BalloonHolder) view.getTag();
        if (this.f1537p == ChatONContract.MessageTable.MsgContentType.IMAGE || this.f1537p == ChatONContract.MessageTable.MsgContentType.VIDEO) {
            this.f1531j = balloonHolder.f905w;
            if (this.f1531j != null) {
                this.f1531j.setProgress(this.f1536o);
            }
            this.f1532k = null;
        } else {
            this.f1532k = balloonHolder.f906x;
            this.f1531j = null;
        }
        this.f1544x = view;
        this.f1533l = balloonHolder.f907y;
        ChatONLogWriter.m3506b("[setProgressView]", getClass().getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        ChatONLogWriter.m3506b("[onPostExecute]", getClass().getName());
        if (str == null || this.f1534m) {
            MessageDatabaseHelper.m2299b(GlobalApplication.m2387e().getContentResolver(), Long.valueOf(this.f1527f));
        } else {
            MessageDatabaseHelper.m2288a(GlobalApplication.m2387e().getContentResolver(), this.f1529h, this.f1526e, Long.valueOf(this.f1527f), str, this.f1528g, this.f1530i, this.f1525d);
            if (this.f1540s.booleanValue()) {
                if (MessageControl.m2012a(this.f1526e) != null && MessageControl.m2012a(this.f1526e).f1367d != null && ((FileDownloadTask2) MessageControl.m2012a(this.f1526e).f1367d.remove(Long.valueOf(this.f1527f))) != null) {
                    ChatONLogWriter.m3506b("Successfully removed from hashmap after down-load", getClass().getName());
                }
                if (this.f1543w != null) {
                    this.f1543w.post(new RunnableC0200i(this));
                    return;
                }
                return;
            }
        }
        if (this.f1537p == ChatONContract.MessageTable.MsgContentType.IMAGE || this.f1537p == ChatONContract.MessageTable.MsgContentType.VIDEO) {
            if (this.f1531j != null) {
                this.f1531j.setVisibility(4);
            }
        } else if (this.f1532k != null) {
            this.f1532k.setVisibility(4);
        }
        if (this.f1533l != null) {
            this.f1533l.setVisibility(4);
        }
        if (this.f1543w != null) {
            this.f1543w.post(new RunnableC0201j(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        if (Long.parseLong(((ChatListAdapter.BalloonHolder) this.f1544x.getTag()).f883a) == this.f1527f && numArr[0].intValue() <= 100 && this.f1531j != null) {
            this.f1531j.setProgress(numArr[0].intValue());
        }
        this.f1536o = numArr[0].intValue();
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        this.f1534m = true;
        super.onCancelled();
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ChatONLogWriter.m3506b("[onPreExecute]", getClass().getName());
        if (this.f1537p != ChatONContract.MessageTable.MsgContentType.IMAGE && this.f1537p != ChatONContract.MessageTable.MsgContentType.VIDEO) {
            this.f1532k = (ProgressBar) this.f1544x.findViewById(C0062R.id.DownProgressBalloon);
            this.f1531j = null;
            Log.d("FileDownloadTask2", "onPreExecutemProgressBalloon" + this.f1532k);
        } else {
            this.f1531j = (ProgressBar) this.f1544x.findViewById(C0062R.id.progressbarDown);
            this.f1531j.setProgress(0);
            this.f1532k = null;
            Log.d("FileDownloadTask2", "onPreExecutemProgessDown" + this.f1531j);
        }
    }
}
