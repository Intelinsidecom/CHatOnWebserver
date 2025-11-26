package com.sec.chaton.chat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import android.text.format.DateFormat;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.EnumC0705t;
import com.sec.chaton.util.C1767bw;
import com.sec.widget.AlertDialogBuilderC2120a;
import com.sec.widget.C2153y;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import weibo4android.org.json.HTTP;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ao */
/* loaded from: classes.dex */
class AsyncTaskC0473ao extends AsyncTask {

    /* renamed from: b */
    String f1942b;

    /* renamed from: c */
    String f1943c;

    /* renamed from: d */
    boolean f1944d;

    /* renamed from: e */
    String f1945e;

    /* renamed from: f */
    String f1946f;

    /* renamed from: g */
    String f1947g;

    /* renamed from: h */
    File[] f1948h;

    /* renamed from: j */
    int f1950j;

    /* renamed from: k */
    String f1951k;

    /* renamed from: m */
    final /* synthetic */ ChatFragment f1953m;

    /* renamed from: a */
    StringBuilder f1941a = new StringBuilder();

    /* renamed from: i */
    ArrayList f1949i = new ArrayList();

    /* renamed from: n */
    private String f1954n = null;

    /* renamed from: l */
    byte[] f1952l = {-17, -69, -65};

    AsyncTaskC0473ao(ChatFragment chatFragment) {
        this.f1953m = chatFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Long l) throws IOException {
        this.f1944d = C1767bw.m6002a();
        this.f1945e = this.f1944d ? GlobalApplication.m3260b().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m3260b().getFilesDir().getAbsolutePath();
        this.f1946f = this.f1945e + "/tmp";
        if (this.f1944d) {
            this.f1947g = Environment.getExternalStorageDirectory().getAbsolutePath() + "/ChatON/Chats/" + this.f1943c;
        }
        this.f1951k = this.f1945e + "/" + this.f1953m.f1912z;
        try {
            if (this.f1950j == 0 || this.f1950j == 2) {
                File file = new File(this.f1947g);
                if (!file.exists()) {
                    file.mkdirs();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(new File(this.f1947g, this.f1942b));
                fileOutputStream.write(this.f1952l);
                fileOutputStream.write(this.f1941a.toString().getBytes());
                fileOutputStream.close();
                this.f1953m.f1830as.dismiss();
                if (this.f1950j == 2) {
                    File file2 = new File(this.f1951k);
                    if (file2.exists()) {
                        m2619a(file2);
                    }
                }
                C2153y.m7536a(GlobalApplication.m3260b(), GlobalApplication.m3260b().getString(R.string.toast_save_media) + "\n(" + this.f1947g + "/...)", 0).show();
            } else {
                File file3 = new File(this.f1946f);
                if (!file3.exists()) {
                    file3.mkdirs();
                }
                File file4 = new File(this.f1946f, this.f1942b);
                FileOutputStream fileOutputStream2 = new FileOutputStream(file4);
                fileOutputStream2.write(this.f1952l);
                byte[] bytes = this.f1941a.toString().getBytes();
                if (bytes.length > 10485760) {
                    fileOutputStream2.write(bytes, 0, 10485760);
                } else {
                    fileOutputStream2.write(bytes);
                }
                fileOutputStream2.close();
                this.f1953m.f1830as.dismiss();
                if (this.f1950j == 1) {
                    m2620a(file4, null);
                } else if (this.f1950j == 3) {
                    File file5 = new File(this.f1951k);
                    if (!file5.exists()) {
                        file5 = null;
                    }
                    m2620a(file4, file5);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.f1953m.f1830as.dismiss();
        super.onPostExecute(l);
    }

    /* renamed from: a */
    public void m2620a(File file, File file2) {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(this.f1953m.getString(R.string.app_name)).append("] ").append(this.f1953m.f1787aB);
        if (this.f1953m.f1834aw != null && this.f1953m.f1834aw.size() > 1) {
            sb.append("(").append(this.f1953m.f1834aw.size()).append(")");
        }
        String string = sb.toString();
        if (file2 != null) {
            this.f1949i.add(Uri.fromFile(file));
            this.f1948h = file2.listFiles();
            Arrays.sort(this.f1948h, new C0476ar(this));
            if (m2623b(file2) + file.length() > 10485760) {
                AlertDialogBuilderC2120a alertDialogBuilderC2120a = new AlertDialogBuilderC2120a(this.f1953m.getActivity());
                alertDialogBuilderC2120a.setTitle(R.string.backup);
                alertDialogBuilderC2120a.setMessage(R.string.backup_limit_msg);
                alertDialogBuilderC2120a.setPositiveButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0474ap(this, file, string));
                alertDialogBuilderC2120a.setNegativeButton(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0475aq(this));
                alertDialogBuilderC2120a.setCancelable(true);
                alertDialogBuilderC2120a.show();
                return;
            }
            for (int i = 0; i < this.f1948h.length; i++) {
                if (this.f1948h[i].isFile()) {
                    this.f1949i.add(Uri.fromFile(this.f1948h[i]));
                }
            }
            Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
            intent.setType("plain/text");
            intent.putExtra("android.intent.extra.SUBJECT", string);
            intent.putExtra("android.intent.extra.TEXT", this.f1953m.getString(R.string.attach_email_body, this.f1942b));
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.f1949i);
            this.f1953m.startActivity(Intent.createChooser(intent, this.f1953m.getString(R.string.choose_email_app)));
            return;
        }
        Intent intent2 = new Intent("android.intent.action.SEND");
        intent2.setType("plain/text");
        intent2.putExtra("android.intent.extra.SUBJECT", string);
        intent2.putExtra("android.intent.extra.TEXT", this.f1953m.getString(R.string.attach_email_body, this.f1942b));
        intent2.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
        this.f1953m.startActivity(Intent.createChooser(intent2, this.f1953m.getString(R.string.choose_email_app)));
    }

    /* renamed from: a */
    public void m2619a(File file) throws IOException {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileChannel channel = null;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END);
        File[] fileArrListFiles = file.listFiles();
        int i = 0;
        FileOutputStream fileOutputStream2 = null;
        FileInputStream fileInputStream2 = null;
        FileChannel channel2 = null;
        while (i < fileArrListFiles.length) {
            if (fileArrListFiles[i].isFile()) {
                try {
                    String str = this.f1947g + "/" + fileArrListFiles[i].getName();
                    FileInputStream fileInputStream3 = new FileInputStream(fileArrListFiles[i]);
                    try {
                        fileOutputStream = new FileOutputStream(str);
                        try {
                            channel = fileInputStream3.getChannel();
                            channel2 = fileOutputStream.getChannel();
                            while (channel.read(byteBufferAllocateDirect) != -1) {
                                byteBufferAllocateDirect.flip();
                                channel2.write(byteBufferAllocateDirect);
                                byteBufferAllocateDirect.clear();
                            }
                            fileInputStream = fileInputStream3;
                        } catch (Exception e) {
                            fileInputStream = fileInputStream3;
                        }
                    } catch (Exception e2) {
                        fileOutputStream = fileOutputStream2;
                        fileInputStream = fileInputStream3;
                    }
                } catch (Exception e3) {
                    FileOutputStream fileOutputStream3 = fileOutputStream2;
                    fileInputStream = fileInputStream2;
                    fileOutputStream = fileOutputStream3;
                }
            } else {
                FileOutputStream fileOutputStream4 = fileOutputStream2;
                fileInputStream = fileInputStream2;
                fileOutputStream = fileOutputStream4;
            }
            i++;
            FileOutputStream fileOutputStream5 = fileOutputStream;
            fileInputStream2 = fileInputStream;
            fileOutputStream2 = fileOutputStream5;
        }
        if (channel != null) {
            try {
                channel.close();
            } catch (IOException e4) {
                e4.printStackTrace();
                return;
            }
        }
        if (channel2 != null) {
            channel2.close();
        }
        if (fileInputStream2 != null) {
            fileInputStream2.close();
        }
        if (fileOutputStream2 != null) {
            fileOutputStream2.close();
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f1953m.f1830as = new ProgressDialog(this.f1953m.getActivity());
        this.f1953m.f1830as.setMessage(this.f1953m.getResources().getString(R.string.wait_sending));
        this.f1953m.f1830as.setCancelable(false);
        this.f1954n = null;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f1942b = this.f1953m.getString(R.string.app_name) + "_" + new SimpleDateFormat("yyyyMMddHHmm").format(Long.valueOf(jCurrentTimeMillis)) + ".txt";
        this.f1943c = this.f1953m.getString(R.string.app_name) + "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(Long.valueOf(jCurrentTimeMillis));
        this.f1953m.f1830as.show();
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
        this.f1953m.f1830as.dismiss();
        super.onCancelled();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0207  */
    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Long doInBackground(java.lang.Integer... r15) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 554
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.AsyncTaskC0473ao.doInBackground(java.lang.Integer[]):java.lang.Long");
    }

    /* renamed from: b */
    public long m2623b(File file) {
        long length = 0;
        File[] fileArrListFiles = file.listFiles();
        for (int i = 0; i < fileArrListFiles.length; i++) {
            if (!fileArrListFiles[i].isDirectory()) {
                length += fileArrListFiles[i].length();
            }
        }
        return length;
    }

    /* renamed from: a */
    public String m2618a(long j) {
        StringBuilder sb = new StringBuilder();
        String str = DateFormat.getDateFormat(GlobalApplication.m3260b()).format(new Date(j));
        if (this.f1954n != null && !this.f1954n.equals(str)) {
            sb.append(HTTP.CRLF);
        }
        sb.append(str).append(" ");
        sb.append(DateFormat.getTimeFormat(GlobalApplication.m3260b()).format(new Date(j)));
        this.f1954n = str;
        return sb.toString();
    }

    /* renamed from: a */
    private String m2617a(String str, String str2, String str3) throws Resources.NotFoundException {
        String[] strArrSplit = str3.split(";");
        StringBuilder sb = new StringBuilder();
        if (strArrSplit.length <= 0) {
            return str3;
        }
        EnumC0705t enumC0705tM3169a = EnumC0705t.UNKNOWN;
        for (String str4 : strArrSplit) {
            String[] strArrSplit2 = str4.split(",");
            if (strArrSplit2.length > 2) {
                enumC0705tM3169a = EnumC0705t.m3169a(Integer.parseInt(strArrSplit2[0]));
                sb.append(C0493bg.m2689b(strArrSplit2[2].replace('\n', ' '))).append(",");
            }
        }
        String string = "";
        if (enumC0705tM3169a == EnumC0705t.ENTER) {
            if (TextUtils.isEmpty(str2)) {
                string = GlobalApplication.m3262c().getString(R.string.chat_view_system_invite);
            } else {
                string = GlobalApplication.m3262c().getString(R.string.chat_view_system_invite_2);
            }
        } else if (enumC0705tM3169a == EnumC0705t.LEAVE) {
            string = GlobalApplication.m3262c().getString(R.string.chat_view_system_leave);
        } else if (enumC0705tM3169a == EnumC0705t.INVITE) {
            string = GlobalApplication.m3262c().getString(R.string.noti_invite_member);
        } else if (enumC0705tM3169a == EnumC0705t.INVALID_USER) {
            string = GlobalApplication.m3262c().getString(R.string.toast_chat_change_account_info);
        } else if (enumC0705tM3169a == EnumC0705t.MEMBER) {
            string = GlobalApplication.m3262c().getString(R.string.chat_view_chat_member);
        }
        if (string.length() > 0) {
            return sb.length() > 1 ? (TextUtils.isEmpty(str2) || enumC0705tM3169a != EnumC0705t.ENTER) ? String.format(string, sb.substring(0, sb.length() - 1)) : String.format(string, str2, sb.substring(0, sb.length() - 1)) : String.format(string, GlobalApplication.m3262c().getString(R.string.unknown));
        }
        return "";
    }
}
