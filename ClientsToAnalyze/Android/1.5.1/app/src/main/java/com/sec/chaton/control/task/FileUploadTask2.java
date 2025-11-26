package com.sec.chaton.control.task;

import android.os.AsyncTask;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import com.sec.chaton.C0062R;
import com.sec.chaton.chat.ChatListAdapter;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.util.ChatONLogWriter;
import java.io.File;

/* loaded from: classes.dex */
public class FileUploadTask2 extends AsyncTask {

    /* renamed from: a */
    protected String f1558a;

    /* renamed from: b */
    protected String f1559b;

    /* renamed from: c */
    protected String f1560c;

    /* renamed from: d */
    protected int f1561d;

    /* renamed from: e */
    protected String f1562e;

    /* renamed from: f */
    protected View f1563f;

    /* renamed from: g */
    protected ProgressBar f1564g;

    /* renamed from: h */
    protected boolean f1565h;

    /* renamed from: i */
    protected Handler f1566i;

    /* renamed from: j */
    private File f1567j;

    /* renamed from: k */
    private ChatONContract.MessageTable.MsgContentType f1568k;

    /* renamed from: l */
    private String f1569l;

    /* renamed from: m */
    private String f1570m;

    /* renamed from: n */
    private long f1571n;

    /* renamed from: o */
    private String f1572o;

    /* renamed from: p */
    private String f1573p;

    /* renamed from: q */
    private String f1574q;

    /* renamed from: r */
    private boolean f1575r;

    /* renamed from: s */
    private int f1576s = 0;

    /* renamed from: t */
    private FileUploadTask2 f1577t;

    public FileUploadTask2(Handler handler, File file, ChatONContract.MessageTable.MsgContentType msgContentType, String str, String str2, String str3, long j, String str4) {
        this.f1567j = file;
        this.f1568k = msgContentType;
        if (str == null || !str.contains(".")) {
            this.f1569l = str;
        } else {
            this.f1569l = str.substring(1);
        }
        this.f1570m = str2;
        this.f1571n = j;
        this.f1558a = str4;
        this.f1559b = str3;
        this.f1562e = null;
        this.f1561d = 0;
        this.f1563f = null;
        this.f1564g = null;
        this.f1565h = false;
        this.f1566i = handler;
        this.f1575r = false;
        this.f1577t = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:143:0x05cc  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0650 A[Catch: all -> 0x0633, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x0633, blocks: (B:43:0x02a3, B:45:0x02b1, B:47:0x02b8, B:48:0x02c0, B:50:0x02cd, B:51:0x02df, B:144:0x0620, B:158:0x0650), top: B:271:0x02a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x067a A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0647 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0642 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x063d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:290:0x064c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0446 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0455 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0450 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:311:0x044b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:356:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x02b1 A[Catch: all -> 0x0633, TryCatch #9 {all -> 0x0633, blocks: (B:43:0x02a3, B:45:0x02b1, B:47:0x02b8, B:48:0x02c0, B:50:0x02cd, B:51:0x02df, B:144:0x0620, B:158:0x0650), top: B:271:0x02a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x042a A[Catch: all -> 0x0741, TryCatch #17 {all -> 0x0741, blocks: (B:85:0x0423, B:87:0x042a, B:88:0x0432), top: B:280:0x0423 }] */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String doInBackground(java.lang.String... r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1960
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.control.task.FileUploadTask2.doInBackground(java.lang.String[]):java.lang.String");
    }

    /* renamed from: a */
    public void m2137a(View view) {
        if (view != null) {
            if (this.f1568k != ChatONContract.MessageTable.MsgContentType.VIDEO && this.f1568k != ChatONContract.MessageTable.MsgContentType.IMAGE) {
                this.f1564g = null;
                return;
            }
            this.f1564g = (ProgressBar) view.findViewById(C0062R.id.progressbarUp);
            this.f1563f = view;
            if (this.f1564g != null) {
                this.f1564g.setVisibility(0);
                if (this.f1561d <= 95) {
                    this.f1564g.setProgress(this.f1561d);
                } else {
                    this.f1564g.setProgress(95);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
        if (this.f1563f != null) {
            if (Long.parseLong(((ChatListAdapter.BalloonHolder) this.f1563f.getTag()).f883a) == this.f1571n) {
                if (!this.f1575r && numArr[0].intValue() > 95) {
                    this.f1564g.setProgress(95);
                } else {
                    this.f1564g.setProgress(numArr[0].intValue());
                }
                ChatONLogWriter.m3506b("[onProgressUpdate] " + numArr[0], getClass().getSimpleName());
            }
            this.f1561d = numArr[0].intValue();
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        this.f1565h = true;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.f1561d = 0;
    }
}
