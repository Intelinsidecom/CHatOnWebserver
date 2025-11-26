package com.sec.chaton.chat;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.text.format.DateFormat;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.EnumC2231as;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.spp.push.Config;
import com.sec.widget.C5179v;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ed */
/* loaded from: classes.dex */
class AsyncTaskC1677ed extends AsyncTask<Integer, Integer, Long> {

    /* renamed from: b */
    String f6241b;

    /* renamed from: c */
    String f6242c;

    /* renamed from: d */
    boolean f6243d;

    /* renamed from: e */
    String f6244e;

    /* renamed from: f */
    String f6245f;

    /* renamed from: g */
    String f6246g;

    /* renamed from: h */
    File[] f6247h;

    /* renamed from: j */
    int f6249j;

    /* renamed from: k */
    String f6250k;

    /* renamed from: m */
    final /* synthetic */ ChatFragment f6252m;

    /* renamed from: a */
    StringBuilder f6240a = new StringBuilder();

    /* renamed from: i */
    ArrayList<Uri> f6248i = new ArrayList<>();

    /* renamed from: n */
    private String f6253n = null;

    /* renamed from: l */
    byte[] f6251l = {-17, -69, -65};

    AsyncTaskC1677ed(ChatFragment chatFragment) {
        this.f6252m = chatFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0102 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x016d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0166 A[Catch: all -> 0x01f3, TRY_LEAVE, TryCatch #3 {all -> 0x01f3, blocks: (B:42:0x0162, B:44:0x0166), top: B:102:0x0162 }] */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.FileOutputStream] */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onPostExecute(java.lang.Long r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 514
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.AsyncTaskC1677ed.onPostExecute(java.lang.Long):void");
    }

    /* renamed from: a */
    public void m8510a(File file) {
        if (file.length() > 10485760) {
            AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f6252m.f5624cN);
            abstractC4932aM18733a.mo18734a(R.string.pop_up_attention);
            abstractC4932aM18733a.mo18746b(R.string.backup_limit_msg);
            abstractC4932aM18733a.mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1678ee(this, file));
            abstractC4932aM18733a.mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1679ef(this));
            abstractC4932aM18733a.mo18751b(true);
            abstractC4932aM18733a.mo18752b();
            return;
        }
        AbstractC4932a abstractC4932aM18733a2 = AbstractC4932a.m18733a(this.f6252m.f5624cN);
        abstractC4932aM18733a2.mo18734a(R.string.chat_view_menu_forward_message);
        abstractC4932aM18733a2.mo18746b(R.string.chat_view_message_forward_confirm);
        abstractC4932aM18733a2.mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1680eg(this, file));
        abstractC4932aM18733a2.mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1681eh(this));
        abstractC4932aM18733a2.mo18751b(true);
        abstractC4932aM18733a2.mo18752b();
    }

    /* renamed from: a */
    public void m8511a(File file, File file2) {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(this.f6252m.getString(R.string.app_name)).append("] ").append(this.f6252m.f5597bm);
        if (this.f6252m.f5588bd != null && this.f6252m.f5588bd.size() > 1) {
            sb.append("(").append(this.f6252m.f5588bd.size()).append(")");
        }
        String string = sb.toString();
        if (file2 == null) {
            if (file.length() > 10485760) {
                AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f6252m.f5624cN);
                abstractC4932aM18733a.mo18734a(R.string.option_send_email);
                abstractC4932aM18733a.mo18746b(R.string.backup_limit_msg);
                abstractC4932aM18733a.mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1684ek(this, string, file));
                abstractC4932aM18733a.mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1685el(this));
                abstractC4932aM18733a.mo18751b(true);
                abstractC4932aM18733a.mo18752b();
                return;
            }
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("plain/text");
            intent.putExtra("android.intent.extra.SUBJECT", string);
            intent.putExtra("android.intent.extra.TEXT", this.f6252m.getString(R.string.attach_email_body, this.f6241b));
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
            try {
                this.f6252m.startActivityForResult(intent, 23);
                return;
            } catch (ActivityNotFoundException e) {
                C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, ChatFragment.f5461a);
                    return;
                }
                return;
            }
        }
        this.f6248i.add(Uri.fromFile(file));
        this.f6247h = file2.listFiles();
        Arrays.sort(this.f6247h, new C1686em(this));
        if (m8516c(file2) + file.length() > 10485760) {
            AbstractC4932a abstractC4932aM18733a2 = AbstractC4932a.m18733a(this.f6252m.f5624cN);
            abstractC4932aM18733a2.mo18734a(R.string.option_send_email);
            abstractC4932aM18733a2.mo18746b(R.string.backup_limit_msg);
            abstractC4932aM18733a2.mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1682ei(this, file, string));
            abstractC4932aM18733a2.mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1683ej(this));
            abstractC4932aM18733a2.mo18751b(true);
            abstractC4932aM18733a2.mo18752b();
            return;
        }
        for (int i = 0; i < this.f6247h.length; i++) {
            if (this.f6247h[i].isFile()) {
                this.f6248i.add(Uri.fromFile(this.f6247h[i]));
            }
        }
        Intent intent2 = new Intent("android.intent.action.SEND_MULTIPLE");
        intent2.setType("plain/text");
        intent2.putExtra("android.intent.extra.SUBJECT", string);
        intent2.putExtra("android.intent.extra.TEXT", this.f6252m.getString(R.string.attach_email_body, this.f6241b));
        intent2.putParcelableArrayListExtra("android.intent.extra.STREAM", this.f6248i);
        try {
            this.f6252m.startActivityForResult(intent2, 23);
        } catch (ActivityNotFoundException e2) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
            if (C4904y.f17875e) {
                C4904y.m18635a(e2, ChatFragment.f5461a);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0062 A[Catch: IOException -> 0x00d5, TryCatch #2 {IOException -> 0x00d5, blocks: (B:16:0x005d, B:18:0x0062, B:20:0x0067, B:22:0x006c), top: B:80:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067 A[Catch: IOException -> 0x00d5, TryCatch #2 {IOException -> 0x00d5, blocks: (B:16:0x005d, B:18:0x0062, B:20:0x0067, B:22:0x006c), top: B:80:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006c A[Catch: IOException -> 0x00d5, TRY_LEAVE, TryCatch #2 {IOException -> 0x00d5, blocks: (B:16:0x005d, B:18:0x0062, B:20:0x0067, B:22:0x006c), top: B:80:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0095 A[Catch: IOException -> 0x00a3, TryCatch #3 {IOException -> 0x00a3, blocks: (B:33:0x0090, B:35:0x0095, B:37:0x009a, B:39:0x009f), top: B:82:0x0090 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009a A[Catch: IOException -> 0x00a3, TryCatch #3 {IOException -> 0x00a3, blocks: (B:33:0x0090, B:35:0x0095, B:37:0x009a, B:39:0x009f), top: B:82:0x0090 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009f A[Catch: IOException -> 0x00a3, TRY_LEAVE, TryCatch #3 {IOException -> 0x00a3, blocks: (B:33:0x0090, B:35:0x0095, B:37:0x009a, B:39:0x009f), top: B:82:0x0090 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00bb A[Catch: IOException -> 0x00ca, TryCatch #1 {IOException -> 0x00ca, blocks: (B:48:0x00b6, B:50:0x00bb, B:52:0x00c0, B:54:0x00c5), top: B:78:0x00b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c0 A[Catch: IOException -> 0x00ca, TryCatch #1 {IOException -> 0x00ca, blocks: (B:48:0x00b6, B:50:0x00bb, B:52:0x00c0, B:54:0x00c5), top: B:78:0x00b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c5 A[Catch: IOException -> 0x00ca, TRY_LEAVE, TryCatch #1 {IOException -> 0x00ca, blocks: (B:48:0x00b6, B:50:0x00bb, B:52:0x00c0, B:54:0x00c5), top: B:78:0x00b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0070 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m8515b(java.io.File r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.AsyncTaskC1677ed.m8515b(java.io.File):void");
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f6252m.f5530aW = new ProgressDialog(this.f6252m.f5624cN);
        this.f6252m.f5530aW.setMessage(this.f6252m.getResources().getString(R.string.wait_sending));
        this.f6252m.f5530aW.setCancelable(false);
        this.f6253n = null;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f6241b = this.f6252m.getString(R.string.app_name) + "_" + new SimpleDateFormat("yyyyMMddHHmm").format(Long.valueOf(jCurrentTimeMillis)) + ".txt";
        this.f6242c = this.f6252m.getString(R.string.app_name) + "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(Long.valueOf(jCurrentTimeMillis));
        this.f6252m.f5530aW.show();
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr[0]);
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        this.f6252m.f5530aW.dismiss();
        super.onCancelled();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0100 A[PHI: r1
  0x0100: PHI (r1v6 android.database.Cursor) = (r1v4 android.database.Cursor), (r1v5 android.database.Cursor), (r1v8 android.database.Cursor) binds: [B:54:0x01a4, B:58:0x01ad, B:24:0x00fe] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b5  */
    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Long doInBackground(java.lang.Integer... r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 482
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.AsyncTaskC1677ed.doInBackground(java.lang.Integer[]):java.lang.Long");
    }

    /* renamed from: c */
    public long m8516c(File file) {
        long length = 0;
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (int i = 0; i < fileArrListFiles.length; i++) {
                if (!fileArrListFiles[i].isDirectory()) {
                    length += fileArrListFiles[i].length();
                }
            }
        }
        return length;
    }

    /* renamed from: a */
    public String m8509a(long j) {
        StringBuilder sb = new StringBuilder();
        String str = DateFormat.getDateFormat(CommonApplication.m18732r()).format(new Date(j));
        if (this.f6253n != null && !this.f6253n.equals(str)) {
            sb.append("\r\n");
        }
        sb.append(str).append(" ");
        sb.append(DateFormat.getTimeFormat(CommonApplication.m18732r()).format(new Date(j)));
        this.f6253n = str;
        return sb.toString();
    }

    /* renamed from: a */
    private String m8508a(String str, String str2, String str3) throws Resources.NotFoundException {
        String[] strArrSplit = str3.split(Config.KEYVALUE_SPLIT);
        StringBuilder sb = new StringBuilder();
        if (strArrSplit.length <= 0) {
            return str3;
        }
        EnumC2231as enumC2231asM10098a = EnumC2231as.UNKNOWN;
        for (String str4 : strArrSplit) {
            String[] strArrSplit2 = str4.split(",");
            if (strArrSplit2.length > 2) {
                enumC2231asM10098a = EnumC2231as.m10098a(Integer.parseInt(strArrSplit2[0]));
                sb.append(C1736gi.m8646b(strArrSplit2[2].replace('\n', ' '))).append(",");
            }
        }
        String string = "";
        if (enumC2231asM10098a == EnumC2231as.ENTER) {
            if (TextUtils.isEmpty(str2)) {
                string = GlobalApplication.m10283b().getString(R.string.chat_view_system_invite);
            } else {
                string = GlobalApplication.m10283b().getString(R.string.chat_view_system_invite_2);
            }
        } else if (enumC2231asM10098a == EnumC2231as.LEAVE) {
            string = GlobalApplication.m10283b().getString(R.string.chat_view_system_leave);
        } else if (enumC2231asM10098a == EnumC2231as.INVITE) {
            string = GlobalApplication.m10283b().getString(R.string.noti_invite_member);
        } else if (enumC2231asM10098a == EnumC2231as.INVALID_USER) {
            string = GlobalApplication.m10283b().getString(R.string.toast_chat_change_account_info);
        } else if (enumC2231asM10098a == EnumC2231as.MEMBER) {
            string = GlobalApplication.m10283b().getString(R.string.chat_view_chat_member);
        }
        if (string.length() > 0) {
            return sb.length() > 1 ? (TextUtils.isEmpty(str2) || enumC2231asM10098a != EnumC2231as.ENTER) ? String.format(string, sb.substring(0, sb.length() - 1)) : String.format(string, str2, sb.substring(0, sb.length() - 1)) : String.format(string, GlobalApplication.m10283b().getString(R.string.unknown));
        }
        return "";
    }
}
