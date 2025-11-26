package com.sec.chaton.trunk.network;

import android.os.AsyncTask;
import android.os.Handler;
import com.sec.chaton.util.ChatONLogWriter;
import java.io.File;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* loaded from: classes.dex */
public class FileDownloadTask extends AsyncTask {
    private static final int BUFFER_SIZE = 1024;
    public static final int FILE_DOWNLOAD_CANCELED = 3;
    public static final int FILE_DOWNLOAD_DONE = 2;
    public static final int FILE_DOWNLOAD_FAILED = 4;
    public static final int FILE_DOWNLOAD_PROGESS_CHANGED = 1;
    private static final String TAG = FileDownloadTask.class.getSimpleName();
    private static final Random tmpFileNameGenerator = new Random(System.currentTimeMillis());
    private String directory;
    private File file;
    private String fileName;
    private String filePath;
    private List handlerList;
    private final Object handlerLockObject;
    private boolean isCanceled;
    private boolean isNotifyToHandler;
    private final Object statusLockObject;
    private Object tag;
    private String url;
    private HttpURLConnection urlConnection;
    private boolean useCache;

    public class AbstractResult {
        protected Object tag;

        public AbstractResult() {
        }

        public Object getTag() {
            return this.tag;
        }

        public void setTag(Object obj) {
            this.tag = obj;
        }
    }

    public class DownloadCanceledResult extends AbstractResult {
        public DownloadCanceledResult() {
            super();
        }
    }

    public class DownloadDoneResult extends AbstractResult {
        private String directory;
        private String downloadUrl;
        private String fileName;

        public DownloadDoneResult() {
            super();
        }

        public String getDirectory() {
            return this.directory;
        }

        public String getDownloadUrl() {
            return this.downloadUrl;
        }

        public String getFileName() {
            return this.fileName;
        }

        public void setDirectory(String str) {
            this.directory = str;
        }

        public void setDownloadUrl(String str) {
            this.downloadUrl = str;
        }

        public void setFileName(String str) {
            this.fileName = str;
        }
    }

    public class DownloadFailedResult extends AbstractResult {
        public DownloadFailedResult() {
            super();
        }
    }

    FileDownloadTask(Handler handler, String str, String str2, String str3) {
        this(handler, str, str2, str3, true, null);
    }

    FileDownloadTask(Handler handler, String str, String str2, String str3, boolean z, Object obj) {
        this.statusLockObject = new Object();
        this.handlerLockObject = new Object();
        this.isNotifyToHandler = false;
        this.isCanceled = false;
        this.handlerList = new ArrayList();
        this.handlerList.add(handler);
        this.url = str;
        this.directory = str2;
        this.fileName = str3;
        this.filePath = str2 + File.separator + str3;
        this.useCache = z;
        this.tag = obj;
    }

    private boolean doesFileExist(String str, String str2) {
        return new File(str + File.separator + str2).exists();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c A[Catch: all -> 0x0050, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x0009, B:10:0x002c, B:12:0x0033, B:13:0x0038, B:15:0x004e, B:21:0x0054, B:22:0x005c, B:24:0x0062, B:25:0x0070, B:26:0x0076, B:28:0x007c), top: B:30:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033 A[Catch: all -> 0x0050, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x0009, B:10:0x002c, B:12:0x0033, B:13:0x0038, B:15:0x004e, B:21:0x0054, B:22:0x005c, B:24:0x0062, B:25:0x0070, B:26:0x0076, B:28:0x007c), top: B:30:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004e A[Catch: all -> 0x0050, DONT_GENERATE, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x0009, B:10:0x002c, B:12:0x0033, B:13:0x0038, B:15:0x004e, B:21:0x0054, B:22:0x005c, B:24:0x0062, B:25:0x0070, B:26:0x0076, B:28:0x007c), top: B:30:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void notifyToHandler(int r6, int r7, int r8, java.lang.Object r9) {
        /*
            r5 = this;
            java.lang.Object r4 = r5.handlerLockObject
            monitor-enter(r4)
            r1 = 0
            switch(r6) {
                case 1: goto L70;
                case 2: goto L9;
                case 3: goto L2a;
                case 4: goto L31;
                default: goto L7;
            }
        L7:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L50
        L8:
            return
        L9:
            com.sec.chaton.trunk.network.FileDownloadTask$DownloadDoneResult r2 = new com.sec.chaton.trunk.network.FileDownloadTask$DownloadDoneResult     // Catch: java.lang.Throwable -> L50
            r2.<init>()     // Catch: java.lang.Throwable -> L50
            r0 = r2
            com.sec.chaton.trunk.network.FileDownloadTask$DownloadDoneResult r0 = (com.sec.chaton.trunk.network.FileDownloadTask.DownloadDoneResult) r0     // Catch: java.lang.Throwable -> L50
            r1 = r0
            java.lang.String r3 = r5.directory     // Catch: java.lang.Throwable -> L50
            r1.setDirectory(r3)     // Catch: java.lang.Throwable -> L50
            r0 = r2
            com.sec.chaton.trunk.network.FileDownloadTask$DownloadDoneResult r0 = (com.sec.chaton.trunk.network.FileDownloadTask.DownloadDoneResult) r0     // Catch: java.lang.Throwable -> L50
            r3 = r0
            java.lang.String r1 = r5.fileName     // Catch: java.lang.Throwable -> L50
            r3.setFileName(r1)     // Catch: java.lang.Throwable -> L50
            r0 = r2
            com.sec.chaton.trunk.network.FileDownloadTask$DownloadDoneResult r0 = (com.sec.chaton.trunk.network.FileDownloadTask.DownloadDoneResult) r0     // Catch: java.lang.Throwable -> L50
            r3 = r0
            java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.Throwable -> L50
            r3.setDownloadUrl(r9)     // Catch: java.lang.Throwable -> L50
            r1 = r2
        L2a:
            if (r1 != 0) goto L31
            com.sec.chaton.trunk.network.FileDownloadTask$DownloadCanceledResult r1 = new com.sec.chaton.trunk.network.FileDownloadTask$DownloadCanceledResult     // Catch: java.lang.Throwable -> L50
            r1.<init>()     // Catch: java.lang.Throwable -> L50
        L31:
            if (r1 != 0) goto L38
            com.sec.chaton.trunk.network.FileDownloadTask$DownloadFailedResult r1 = new com.sec.chaton.trunk.network.FileDownloadTask$DownloadFailedResult     // Catch: java.lang.Throwable -> L50
            r1.<init>()     // Catch: java.lang.Throwable -> L50
        L38:
            java.lang.Object r2 = r5.tag     // Catch: java.lang.Throwable -> L50
            r1.setTag(r2)     // Catch: java.lang.Throwable -> L50
            com.sec.chaton.trunk.network.FileDownloadManager r2 = com.sec.chaton.trunk.network.FileDownloadManager.getInstance()     // Catch: java.lang.Throwable -> L50
            java.util.Map r2 = r2.getMapper()     // Catch: java.lang.Throwable -> L50
            java.lang.String r3 = r5.filePath     // Catch: java.lang.Throwable -> L50
            r2.remove(r3)     // Catch: java.lang.Throwable -> L50
            boolean r2 = r5.isNotifyToHandler     // Catch: java.lang.Throwable -> L50
            if (r2 == 0) goto L53
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L50
            goto L8
        L50:
            r1 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L50
            throw r1
        L53:
            r2 = 1
            r5.isNotifyToHandler = r2     // Catch: java.lang.Throwable -> L50
            java.util.List r2 = r5.handlerList     // Catch: java.lang.Throwable -> L50
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L50
        L5c:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L50
            if (r3 == 0) goto L7
            java.lang.Object r5 = r2.next()     // Catch: java.lang.Throwable -> L50
            android.os.Handler r5 = (android.os.Handler) r5     // Catch: java.lang.Throwable -> L50
            android.os.Message r3 = android.os.Message.obtain(r5, r6, r1)     // Catch: java.lang.Throwable -> L50
            r3.sendToTarget()     // Catch: java.lang.Throwable -> L50
            goto L5c
        L70:
            java.util.List r1 = r5.handlerList     // Catch: java.lang.Throwable -> L50
            java.util.Iterator r2 = r1.iterator()     // Catch: java.lang.Throwable -> L50
        L76:
            boolean r1 = r2.hasNext()     // Catch: java.lang.Throwable -> L50
            if (r1 == 0) goto L7
            java.lang.Object r1 = r2.next()     // Catch: java.lang.Throwable -> L50
            android.os.Handler r1 = (android.os.Handler) r1     // Catch: java.lang.Throwable -> L50
            java.lang.Object r3 = r5.tag     // Catch: java.lang.Throwable -> L50
            android.os.Message r1 = android.os.Message.obtain(r1, r6, r7, r8, r3)     // Catch: java.lang.Throwable -> L50
            r1.sendToTarget()     // Catch: java.lang.Throwable -> L50
            goto L76
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.trunk.network.FileDownloadTask.notifyToHandler(int, int, int, java.lang.Object):void");
    }

    public void addHandler(Handler handler) {
        synchronized (this.handlerLockObject) {
            if (this.handlerList.contains(handler)) {
                ChatONLogWriter.m3510d("Handler had been registered.", TAG);
            } else {
                this.handlerList.add(handler);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0132, code lost:
    
        if (r13.file == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0134, code lost:
    
        r13.file.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0152, code lost:
    
        r5 = r5 + r7;
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0156, code lost:
    
        if (r3 == (-1)) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x015c, code lost:
    
        r8 = (int) ((100 * r5) / r3);
     */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x014b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0146 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x013f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:? A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String doInBackground(java.lang.Void... r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 555
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.trunk.network.FileDownloadTask.doInBackground(java.lang.Void[]):java.lang.String");
    }

    public Object getTag() {
        return this.tag;
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        synchronized (this.statusLockObject) {
            super.onCancelled();
            ChatONLogWriter.m3506b("File download is canceled: " + this.url, TAG);
            this.isCanceled = true;
            if (this.urlConnection != null) {
                try {
                    this.urlConnection.disconnect();
                } catch (Exception e) {
                }
            }
            notifyToHandler(3, 0, 0, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        super.onPostExecute((FileDownloadTask) str);
        if (str == null) {
            notifyToHandler(4, 0, 0, null);
        } else {
            notifyToHandler(2, 0, 0, str);
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        ChatONLogWriter.m3506b("FileDownloadTask.onPreExecute()", TAG);
        FileDownloadManager.getInstance().getMapper().put(this.filePath, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate((Object[]) numArr);
        notifyToHandler(1, numArr[0].intValue(), 0, null);
    }

    public void removeHandler(Handler handler) {
        synchronized (this.handlerLockObject) {
            this.handlerList.remove(handler);
        }
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }
}
