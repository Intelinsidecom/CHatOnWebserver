package com.sec.chaton.chat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import android.text.format.DateFormat;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.p027e.EnumC1391ai;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3223ck;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.spp.push.Config;
import com.sec.widget.C3641ai;
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
/* renamed from: com.sec.chaton.chat.db */
/* loaded from: classes.dex */
class AsyncTaskC1033db extends AsyncTask<Integer, Integer, Long> {

    /* renamed from: b */
    String f4127b;

    /* renamed from: c */
    String f4128c;

    /* renamed from: d */
    boolean f4129d;

    /* renamed from: e */
    String f4130e;

    /* renamed from: f */
    String f4131f;

    /* renamed from: g */
    String f4132g;

    /* renamed from: h */
    File[] f4133h;

    /* renamed from: j */
    int f4135j;

    /* renamed from: k */
    String f4136k;

    /* renamed from: m */
    final /* synthetic */ ChatFragment f4138m;

    /* renamed from: a */
    StringBuilder f4126a = new StringBuilder();

    /* renamed from: i */
    ArrayList<Uri> f4134i = new ArrayList<>();

    /* renamed from: n */
    private String f4139n = null;

    /* renamed from: l */
    byte[] f4137l = {-17, -69, -65};

    AsyncTaskC1033db(ChatFragment chatFragment) {
        this.f4138m = chatFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Long l) throws IOException {
        this.f4129d = C3223ck.m11327a();
        this.f4130e = this.f4129d ? CommonApplication.m11493l().getExternalFilesDir(null).getAbsolutePath() : CommonApplication.m11493l().getFilesDir().getAbsolutePath();
        this.f4131f = this.f4130e + "/tmp";
        if (this.f4129d) {
            this.f4132g = Environment.getExternalStorageDirectory().getAbsolutePath() + "/ChatON/Chats/" + this.f4128c;
        }
        this.f4136k = this.f4130e + "/" + this.f4138m.f3703r;
        try {
            if (this.f4135j == 0 || this.f4135j == 2) {
                File file = new File(this.f4132g);
                if (!file.exists()) {
                    file.mkdirs();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(new File(this.f4132g, this.f4127b));
                fileOutputStream.write(this.f4137l);
                fileOutputStream.write(this.f4126a.toString().getBytes());
                fileOutputStream.close();
                this.f4138m.f3529aE.dismiss();
                if (this.f4135j == 2) {
                    File file2 = new File(this.f4136k);
                    if (file2.exists()) {
                        m5257b(file2);
                    }
                }
                C3641ai.m13211a(CommonApplication.m11493l(), CommonApplication.m11493l().getString(R.string.toast_save_media) + "\n(" + this.f4132g + "/...)", 0).show();
            } else {
                File file3 = new File(this.f4131f);
                if (!file3.exists()) {
                    file3.mkdirs();
                }
                File file4 = new File(this.f4131f, this.f4127b);
                FileOutputStream fileOutputStream2 = new FileOutputStream(file4);
                fileOutputStream2.write(this.f4137l);
                byte[] bytes = this.f4126a.toString().getBytes();
                if (bytes.length > 10485760) {
                    fileOutputStream2.write(bytes, 0, 10485760);
                } else {
                    fileOutputStream2.write(bytes);
                }
                fileOutputStream2.close();
                this.f4138m.f3529aE.dismiss();
                if (this.f4135j == 1) {
                    m5253a(file4, null);
                } else if (this.f4135j == 3) {
                    File file5 = new File(this.f4136k);
                    if (!file5.exists()) {
                        file5 = null;
                    }
                    m5253a(file4, file5);
                } else if (this.f4135j == 4) {
                    m5252a(file4);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.f4138m.f3529aE.dismiss();
        super.onPostExecute(l);
    }

    /* renamed from: a */
    public void m5252a(File file) {
        if (file.length() > 10485760) {
            AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f4138m.f3672cr);
            abstractC3271aM11494a.mo11495a(R.string.pop_up_attention);
            abstractC3271aM11494a.mo11506b(R.string.backup_limit_msg);
            abstractC3271aM11494a.mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1034dc(this, file));
            abstractC3271aM11494a.mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1035dd(this));
            abstractC3271aM11494a.mo11511b(true);
            abstractC3271aM11494a.mo11512b();
            return;
        }
        AbstractC3271a abstractC3271aM11494a2 = AbstractC3271a.m11494a(this.f4138m.f3672cr);
        abstractC3271aM11494a2.mo11495a(R.string.chat_view_menu_forward_message);
        abstractC3271aM11494a2.mo11506b(R.string.chat_view_message_forward_confirm);
        abstractC3271aM11494a2.mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1036de(this, file));
        abstractC3271aM11494a2.mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1037df(this));
        abstractC3271aM11494a2.mo11511b(true);
        abstractC3271aM11494a2.mo11512b();
    }

    /* renamed from: a */
    public void m5253a(File file, File file2) {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(this.f4138m.getString(R.string.app_name)).append("] ").append(this.f4138m.f3542aR);
        if (this.f4138m.f3536aL != null && this.f4138m.f3536aL.size() > 1) {
            sb.append("(").append(this.f4138m.f3536aL.size()).append(")");
        }
        String string = sb.toString();
        if (file2 != null) {
            this.f4134i.add(Uri.fromFile(file));
            this.f4133h = file2.listFiles();
            Arrays.sort(this.f4133h, new C1040di(this));
            if (m5258c(file2) + file.length() > 10485760) {
                AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f4138m.f3672cr);
                abstractC3271aM11494a.mo11495a(R.string.option_send_email);
                abstractC3271aM11494a.mo11506b(R.string.backup_limit_msg);
                abstractC3271aM11494a.mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1038dg(this, file, string));
                abstractC3271aM11494a.mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1039dh(this));
                abstractC3271aM11494a.mo11511b(true);
                abstractC3271aM11494a.mo11512b();
                return;
            }
            for (int i = 0; i < this.f4133h.length; i++) {
                if (this.f4133h[i].isFile()) {
                    this.f4134i.add(Uri.fromFile(this.f4133h[i]));
                }
            }
            Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
            intent.setType("plain/text");
            intent.putExtra("android.intent.extra.SUBJECT", string);
            intent.putExtra("android.intent.extra.TEXT", this.f4138m.getString(R.string.attach_email_body, this.f4127b));
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.f4134i);
            this.f4138m.startActivityForResult(intent, 23);
            return;
        }
        Intent intent2 = new Intent("android.intent.action.SEND");
        intent2.setType("plain/text");
        intent2.putExtra("android.intent.extra.SUBJECT", string);
        intent2.putExtra("android.intent.extra.TEXT", this.f4138m.getString(R.string.attach_email_body, this.f4127b));
        intent2.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
        this.f4138m.startActivityForResult(intent2, 23);
    }

    /* renamed from: b */
    public void m5257b(File file) throws IOException {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileChannel channel = null;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(1024);
        File[] fileArrListFiles = file.listFiles();
        int i = 0;
        FileOutputStream fileOutputStream2 = null;
        FileInputStream fileInputStream2 = null;
        FileChannel channel2 = null;
        while (i < fileArrListFiles.length) {
            if (fileArrListFiles[i].isFile()) {
                try {
                    String str = this.f4132g + "/" + fileArrListFiles[i].getName();
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
        this.f4138m.f3529aE = new ProgressDialog(this.f4138m.f3672cr);
        this.f4138m.f3529aE.setMessage(this.f4138m.getResources().getString(R.string.wait_sending));
        this.f4138m.f3529aE.setCancelable(false);
        this.f4139n = null;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f4127b = this.f4138m.getString(R.string.app_name) + "_" + new SimpleDateFormat("yyyyMMddHHmm").format(Long.valueOf(jCurrentTimeMillis)) + ".txt";
        this.f4128c = this.f4138m.getString(R.string.app_name) + "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(Long.valueOf(jCurrentTimeMillis));
        this.f4138m.f3529aE.show();
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
        this.f4138m.f3529aE.dismiss();
        super.onCancelled();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Long doInBackground(Integer... numArr) throws Resources.NotFoundException {
        String[] strArrSplit;
        String strSubstring;
        this.f4135j = numArr[0].intValue();
        Cursor cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1454v.m6348b(), null, "message_inbox_no=?", new String[]{this.f4138m.f3703r}, "message_time , _id");
        if (cursorQuery == null || cursorQuery.getCount() == 0) {
            return null;
        }
        cursorQuery.moveToFirst();
        do {
            Long lValueOf = Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("message_time")));
            String string = cursorQuery.getString(cursorQuery.getColumnIndex("message_content"));
            String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("message_sender"));
            EnumC1455w enumC1455wM6358a = EnumC1455w.m6358a(cursorQuery.getInt(cursorQuery.getColumnIndex("message_content_type")));
            String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_no"));
            String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_name"));
            String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("message_formatted"));
            String strM5251a = m5251a(lValueOf.longValue());
            boolean z = true;
            if (!C3159aa.m10962a().m10979a("chaton_id", "").equals(string2)) {
                z = false;
            }
            String string6 = z ? CommonApplication.m11493l().getString(R.string.setting_interaction_me) : string4;
            String strM6359a = EnumC1455w.m6359a(enumC1455wM6358a);
            switch (enumC1455wM6358a) {
                case SYSTEM:
                    strM6359a = m5250a(string3, string4, string);
                    break;
                case TEXT:
                    strM6359a = string;
                    break;
                case IMAGE:
                case AMS:
                case VIDEO:
                case GEO:
                    if (string == null) {
                        strArrSplit = null;
                    } else {
                        strArrSplit = string.split("\n");
                    }
                    if (strArrSplit != null && strArrSplit.length > 6) {
                        StringBuffer stringBuffer = new StringBuffer();
                        for (int i = 6; i < strArrSplit.length; i++) {
                            stringBuffer.append(strArrSplit[i] + "\n");
                        }
                        if (stringBuffer.length() <= 0) {
                            strSubstring = null;
                        } else {
                            strSubstring = stringBuffer.toString().substring(0, stringBuffer.length() - 1);
                        }
                        strM6359a = !TextUtils.isEmpty(strSubstring) ? strM6359a + ", " + strSubstring : strM6359a;
                        break;
                    }
                    break;
                case AUDIO:
                case CONTACT:
                case CALENDAR:
                case DOCUMENT:
                case FILE:
                case POLL:
                    if (!TextUtils.isEmpty(string5)) {
                        strM6359a = strM6359a + ", " + string5;
                        break;
                    }
                    break;
            }
            this.f4126a.append(strM5251a).append(", ");
            if (enumC1455wM6358a != EnumC1455w.SYSTEM) {
                this.f4126a.append(string6).append(" : ");
            }
            this.f4126a.append(strM6359a).append(HTTP.CRLF);
        } while (cursorQuery.moveToNext());
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    /* renamed from: c */
    public long m5258c(File file) {
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
    public String m5251a(long j) {
        StringBuilder sb = new StringBuilder();
        String str = DateFormat.getDateFormat(CommonApplication.m11493l()).format(new Date(j));
        if (this.f4139n != null && !this.f4139n.equals(str)) {
            sb.append(HTTP.CRLF);
        }
        sb.append(str).append(" ");
        sb.append(DateFormat.getTimeFormat(CommonApplication.m11493l()).format(new Date(j)));
        this.f4139n = str;
        return sb.toString();
    }

    /* renamed from: a */
    private String m5250a(String str, String str2, String str3) throws Resources.NotFoundException {
        String[] strArrSplit = str3.split(Config.KEYVALUE_SPLIT);
        StringBuilder sb = new StringBuilder();
        if (strArrSplit.length <= 0) {
            return str3;
        }
        EnumC1391ai enumC1391aiM6246a = EnumC1391ai.UNKNOWN;
        for (String str4 : strArrSplit) {
            String[] strArrSplit2 = str4.split(",");
            if (strArrSplit2.length > 2) {
                enumC1391aiM6246a = EnumC1391ai.m6246a(Integer.parseInt(strArrSplit2[0]));
                sb.append(C1075eq.m5323b(strArrSplit2[2].replace('\n', ' '))).append(",");
            }
        }
        String string = "";
        if (enumC1391aiM6246a == EnumC1391ai.ENTER) {
            if (TextUtils.isEmpty(str2)) {
                string = GlobalApplication.m6451b().getString(R.string.chat_view_system_invite);
            } else {
                string = GlobalApplication.m6451b().getString(R.string.chat_view_system_invite_2);
            }
        } else if (enumC1391aiM6246a == EnumC1391ai.LEAVE) {
            string = GlobalApplication.m6451b().getString(R.string.chat_view_system_leave);
        } else if (enumC1391aiM6246a == EnumC1391ai.INVITE) {
            string = GlobalApplication.m6451b().getString(R.string.noti_invite_member);
        } else if (enumC1391aiM6246a == EnumC1391ai.INVALID_USER) {
            string = GlobalApplication.m6451b().getString(R.string.toast_chat_change_account_info);
        } else if (enumC1391aiM6246a == EnumC1391ai.MEMBER) {
            string = GlobalApplication.m6451b().getString(R.string.chat_view_chat_member);
        }
        if (string.length() > 0) {
            return sb.length() > 1 ? (TextUtils.isEmpty(str2) || enumC1391aiM6246a != EnumC1391ai.ENTER) ? String.format(string, sb.substring(0, sb.length() - 1)) : String.format(string, str2, sb.substring(0, sb.length() - 1)) : String.format(string, GlobalApplication.m6451b().getString(R.string.unknown));
        }
        return "";
    }
}
