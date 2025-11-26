package com.sec.chaton.smsplugin.p112ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SqliteWrapper;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.provider.Telephony;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.forward.ChatForwardActivity;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.sharedialog.ShareActivity;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p101a.C3779a;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.chaton.smsplugin.p102b.C3790i;
import com.sec.chaton.smsplugin.p110g.C3855a;
import com.sec.chaton.smsplugin.p110g.C3870p;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.C3891n;
import com.sec.chaton.smsplugin.transaction.C4052ac;
import com.sec.chaton.smsplugin.transaction.C4081q;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.google.android.p134a.C5077a;
import com.sec.google.android.p134a.C5111c;
import com.sec.google.android.p134a.p135a.C5086i;
import com.sec.google.android.p134a.p135a.C5094q;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: MessageOptions.java */
@SuppressLint({"NewApi"})
/* renamed from: com.sec.chaton.smsplugin.ui.bn */
/* loaded from: classes.dex */
public class C4132bn {

    /* renamed from: e */
    static String f15380e;

    /* renamed from: f */
    static long f15381f;

    /* renamed from: p */
    private static Dialog f15384p;

    /* renamed from: b */
    Context f15386b;

    /* renamed from: c */
    Activity f15387c;

    /* renamed from: d */
    ContentResolver f15388d;

    /* renamed from: g */
    C4108aq f15389g;

    /* renamed from: q */
    private TextView f15396q;

    /* renamed from: r */
    private Button f15397r;

    /* renamed from: s */
    private Button f15398s;

    /* renamed from: t */
    private EditText f15399t;

    /* renamed from: u */
    private ImageView f15400u;

    /* renamed from: v */
    private Toast f15401v;

    /* renamed from: a */
    public static boolean f15379a = false;

    /* renamed from: w */
    private static final String f15385w = Environment.getExternalStorageDirectory() + "/" + Environment.DIRECTORY_DOWNLOADS + "/";

    /* renamed from: h */
    static final ArrayList<Uri> f15382h = new ArrayList<>();

    /* renamed from: i */
    static boolean f15383i = false;

    /* renamed from: j */
    private final StringBuilder f15390j = new StringBuilder();

    /* renamed from: k */
    private final ArrayList<String> f15391k = new ArrayList<>();

    /* renamed from: l */
    private final ArrayList<String> f15392l = new ArrayList<>();

    /* renamed from: m */
    private final ArrayList<C3855a> f15393m = new ArrayList<>();

    /* renamed from: n */
    private final HashMap<String, File> f15394n = new HashMap<>();

    /* renamed from: o */
    private long f15395o = -1;

    /* renamed from: x */
    private final Handler f15402x = new Handler();

    public C4132bn(Context context, Activity activity, C4108aq c4108aq, long j, String str) {
        this.f15386b = context;
        this.f15387c = activity;
        this.f15388d = context.getContentResolver();
        f15381f = j;
        f15380e = str;
        this.f15389g = c4108aq;
    }

    /* renamed from: a */
    public boolean m16386a(C4108aq c4108aq, C3790i c3790i, boolean z) throws Throwable {
        C3890m.m14994a("Mms/MessageOptions", "resendMessage(),msgItem=" + c4108aq);
        if (c4108aq.m16311n()) {
            m16359a(c4108aq, c3790i);
            if (z) {
                this.f15387c.finish();
                return false;
            }
            return false;
        }
        if (c4108aq.m16309l()) {
            m16376b(c4108aq, c3790i, z);
            return false;
        }
        m16378c(c4108aq);
        if (z) {
            this.f15387c.finish();
            return false;
        }
        return false;
    }

    /* renamed from: c */
    private void m16378c(C4108aq c4108aq) {
        C3890m.m14994a("Mms/MessageOptions", "resendSmsMessageItem(),msgItem=" + c4108aq);
        long jM16308k = c4108aq.m16308k();
        C4052ac c4052ac = new C4052ac(this.f15386b, new String[]{c4108aq.f15275j}, c4108aq.f15277l, jM16308k);
        c4052ac.m15605a(c4108aq.f15273h);
        try {
            c4052ac.mo15606a(jM16308k);
        } catch (Exception e) {
            C3890m.m14995a("Mms/MessageOptions", "Failed to send SMS message, threadId=" + jM16308k, e);
        }
        SqliteWrapper.delete(this.f15386b, this.f15388d, ContentUris.withAppendedId(Telephony.Sms.CONTENT_URI, c4108aq.f15268c), (String) null, (String[]) null);
    }

    /* renamed from: a */
    private void m16359a(C4108aq c4108aq, C3790i c3790i) throws Throwable {
        Cursor cursorQuery;
        long jM16308k = c4108aq.m16308k();
        Uri uri = c4108aq.f15283r;
        try {
            cursorQuery = SqliteWrapper.query(this.f15386b, this.f15388d, Telephony.Mms.Outbox.CONTENT_URI, new String[]{"_id", "m_size"}, (String) null, (String[]) null, (String) null);
            if (cursorQuery != null) {
                try {
                    long jM14630N = C3847e.m14630N() * C3847e.m14697c();
                    long j = 0;
                    while (cursorQuery.moveToNext()) {
                        j += cursorQuery.getLong(1);
                    }
                    if (j >= jM14630N) {
                        Toast.makeText(this.f15386b, R.string.too_many_unsent_mms, 1).show();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                            return;
                        }
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            c4108aq.m16301d();
            if (!C3847e.m14652aC() || TextUtils.isEmpty(m16353a(uri, c3790i, jM16308k))) {
                try {
                    if (new C4081q(this.f15386b, uri, c4108aq.f15288w).mo15606a(jM16308k)) {
                        return;
                    }
                    SqliteWrapper.delete(this.f15386b, this.f15388d, uri, (String) null, (String[]) null);
                } catch (Exception e) {
                    C3890m.m14995a("Mms/MessageOptions", "Failed to send message: " + uri + ", threadId=" + jM16308k, e);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* renamed from: a */
    private String[] m16369a(long j) throws Throwable {
        Cursor cursorQuery;
        String[] strArr = null;
        try {
            cursorQuery = SqliteWrapper.query(this.f15387c, this.f15388d, Telephony.Sms.CONTENT_URI, new String[]{"address"}, "group_id=" + j + " AND type=5", (String[]) null, (String) null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        strArr = new String[cursorQuery.getCount()];
                        int i = 0;
                        while (true) {
                            int i2 = i + 1;
                            strArr[i] = cursorQuery.getString(0);
                            if (!cursorQuery.moveToNext()) {
                                break;
                            }
                            i = i2;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return strArr;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* renamed from: b */
    private void m16376b(C4108aq c4108aq, C3790i c3790i, boolean z) throws Throwable {
        String[] strArrM16369a = m16369a(c4108aq.f15291z);
        if (strArrM16369a != null) {
            StringBuilder sb = new StringBuilder();
            for (String str : strArrM16369a) {
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                sb.append(C3782a.m14207a(str));
            }
            AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f15387c);
            abstractC4932aM18733a.mo18734a(R.string.failed_message);
            abstractC4932aM18733a.mo18749b(this.f15386b.getResources().getString(R.string.retry_failed_message, sb));
            abstractC4932aM18733a.mo18756d(R.string.yes, new DialogInterfaceOnClickListenerC4148cc(this, c4108aq, strArrM16369a, c3790i, z));
            abstractC4932aM18733a.mo18747b(R.string.cancel, (DialogInterface.OnClickListener) null);
            abstractC4932aM18733a.mo18745a().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16360a(C4108aq c4108aq, String[] strArr, C3790i c3790i) {
        long jM14359d;
        if (c3790i == null) {
            jM14359d = c4108aq.m16308k();
        } else {
            jM14359d = c3790i.m14359d();
        }
        if (jM14359d == 0) {
            C3890m.m14999e("Mms/MessageOptions", "Failed to send SMS message, threadId=" + jM14359d);
            return;
        }
        C4052ac c4052ac = new C4052ac(this.f15387c, strArr, c4108aq.f15277l, jM14359d, c4108aq.f15291z);
        c4052ac.m15605a(c4108aq.f15273h);
        try {
            c4052ac.mo15606a(jM14359d);
        } catch (Exception e) {
            C3890m.m14995a("Mms/MessageOptions", "Failed to send SMS message, threadId=" + jM14359d, e);
        }
        SqliteWrapper.delete(this.f15387c, this.f15388d, ContentUris.withAppendedId(C4149cd.f15441b, c4108aq.f15291z), "type=5", (String[]) null);
    }

    /* renamed from: a */
    public void m16384a(C3870p c3870p, boolean z, long j) {
        C3855a c3855a;
        C5086i c5086iM16388a = C4146ca.m16388a(this.f15387c, ContentUris.withAppendedId(Telephony.Mms.CONTENT_URI, j));
        if (c5086iM16388a != null) {
            this.f15392l.clear();
            this.f15393m.clear();
            this.f15395o = j;
            this.f15394n.clear();
            int iM19333b = c5086iM16388a.m19333b();
            ArrayList<C3855a> arrayList = new ArrayList<>(iM19333b);
            for (int i = 0; i < iM19333b; i++) {
                C5094q c5094qM19328a = c5086iM16388a.m19328a(i);
                String str = new String(c5094qM19328a.m19394g());
                if (!"text/plain".equals(str) && !"application/smil".equals(str)) {
                    try {
                        c3855a = new C3855a(this.f15387c, str, m16354a(c5094qM19328a, j), c5094qM19328a.m19383b());
                    } catch (C5111c e) {
                        e.printStackTrace();
                        c3855a = null;
                    }
                    if (c3855a != null) {
                        arrayList.add(arrayList.size(), c3855a);
                    }
                }
            }
            if (arrayList.size() <= 0) {
                C3890m.m14997c("kkahn/Mms/MessageOptions", "findAttachmentList > No Attachment");
            } else {
                m16365a(z, j, arrayList);
            }
        }
    }

    /* renamed from: a */
    private void m16365a(boolean z, long j, ArrayList<C3855a> arrayList) {
        ViewOnClickListenerC4172d viewOnClickListenerC4172d = new ViewOnClickListenerC4172d(this.f15387c, R.layout.attachment_list_item, arrayList);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f15387c);
        builder.setTitle(R.string.copy_to_sdcard);
        builder.setCancelable(true);
        if (z) {
            builder.setNegativeButton(R.string.save, new DialogInterfaceOnClickListenerC4143by(this, this.f15387c, z, j));
        } else {
            builder.setNegativeButton(R.string.remove, new DialogInterfaceOnClickListenerC4143by(this, this.f15387c, z, j));
        }
        builder.setPositiveButton(R.string.no, new DialogInterfaceOnClickListenerC4142bx(this, null));
        builder.setAdapter(viewOnClickListenerC4172d, new DialogInterfaceOnClickListenerC4134bp(this));
        builder.setOnKeyListener(new DialogInterfaceOnKeyListenerC4135bq(this));
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.show();
        viewOnClickListenerC4172d.m16462a(alertDialogCreate.getButton(-2));
    }

    /* renamed from: a */
    private String m16354a(C5094q c5094q, long j) {
        String str;
        String strSubstring;
        byte[] bArrM19390e = c5094q.m19390e();
        if (bArrM19390e == null) {
            bArrM19390e = c5094q.m19398j();
        }
        byte[] bArrM19397i = bArrM19390e == null ? c5094q.m19397i() : bArrM19390e;
        if (bArrM19397i == null) {
            str = Long.toHexString(j);
        } else {
            str = new String(bArrM19397i);
        }
        if (true == str.startsWith("<")) {
            str = str.substring(1);
        }
        if (true == str.endsWith(">")) {
            str = str.substring(0, str.length() - 1);
        }
        String strSubstring2 = str.startsWith("cid:") ? str.substring("cid:".length()) : str;
        String str2 = new String(c5094q.m19394g());
        if (C5077a.m19294g(str2)) {
            Cursor cursorQuery = SqliteWrapper.query(this.f15387c, this.f15388d, c5094q.m19383b(), (String[]) null, (String) null, (String[]) null, (String) null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("name"));
                        if (string == null) {
                            string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("cl"));
                        }
                        strSubstring2 = string;
                    }
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
        }
        int iIndexOf = strSubstring2.indexOf(46);
        if (iIndexOf == -1) {
            strSubstring = C3891n.m15001a().m15006c(str2);
        } else {
            strSubstring = strSubstring2.substring(iIndexOf + 1, strSubstring2.length());
            strSubstring2 = strSubstring2.substring(0, iIndexOf);
        }
        if (C5077a.m19294g(str2) && !"dcf".equals(strSubstring)) {
            strSubstring = "dcf";
        }
        if (strSubstring == null) {
            if (str2.equalsIgnoreCase("text/x-vCard")) {
                strSubstring = "vcf";
            } else if (str2.equalsIgnoreCase("text/x-vCalendar")) {
                strSubstring = "vcs";
            } else if (str2.equalsIgnoreCase("text/x-vNote")) {
                strSubstring = "vnt";
            } else if (str2.equalsIgnoreCase("text/x-vtodo")) {
                strSubstring = "vts";
            }
        }
        return strSubstring == null ? strSubstring2 : strSubstring2 + "." + strSubstring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16357a(Context context) {
        if (!this.f15392l.isEmpty()) {
            m16374b(context);
        } else if (!this.f15393m.isEmpty()) {
            m16364a(this.f15393m, this.f15395o);
        }
    }

    /* renamed from: b */
    private void m16374b(Context context) {
        String strSubstring = null;
        m16356a();
        f15384p = new Dialog(context);
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.message_file_rename_dialog, (ViewGroup) null);
        this.f15396q = (TextView) viewInflate.findViewById(R.id.picker_title);
        this.f15399t = (EditText) viewInflate.findViewById(R.id.duplicate_file_name_edittext);
        this.f15397r = (Button) viewInflate.findViewById(R.id.button2);
        this.f15398s = (Button) viewInflate.findViewById(R.id.button1);
        this.f15400u = (ImageView) viewInflate.findViewById(R.id.title_icon);
        this.f15396q.setText(R.string.copy_to_sdcard);
        this.f15400u.setVisibility(8);
        this.f15397r.setText(context.getText(R.string.yes));
        this.f15398s.setText(context.getText(R.string.no));
        String str = this.f15392l.get(0);
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf != -1) {
            strSubstring = str.substring(iLastIndexOf + 1, str.length());
        } else {
            iLastIndexOf = str.length();
        }
        String strSubstring2 = str.substring(0, iLastIndexOf <= 50 ? iLastIndexOf : 50);
        this.f15399t.setText(strSubstring2);
        this.f15399t.setSelection(strSubstring2.length());
        this.f15397r.setOnClickListener(new ViewOnClickListenerC4136br(this, strSubstring));
        this.f15398s.setOnClickListener(new ViewOnClickListenerC4137bs(this));
        f15384p.requestWindowFeature(1);
        f15384p.getWindow().setBackgroundDrawableResource(R.color.transparent_color);
        f15384p.setContentView(viewInflate);
        this.f15399t.addTextChangedListener(new C4138bt(this));
        f15384p.setOnDismissListener(new DialogInterfaceOnDismissListenerC4139bu(this));
        f15384p.show();
        f15384p.getWindow().setSoftInputMode(21);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16364a(ArrayList<C3855a> arrayList, long j) {
        boolean z = false;
        String str = f15385w;
        File file = new File(str);
        int i = 0;
        while (true) {
            if (i < arrayList.size()) {
                if ("text/plain".equals(arrayList.get(i).m14744a()) || "application/smil".equals(arrayList.get(i).m14744a())) {
                    i++;
                } else {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (z && ((!file.exists() || !file.isDirectory() || !file.canRead()) && !file.mkdirs())) {
            this.f15387c.showDialog(R.id.dialog_sdcard_not_found);
            return;
        }
        C4147cb c4147cb = new C4147cb(this, str, arrayList, j);
        if (c4147cb != null) {
            c4147cb.start();
        }
    }

    /* renamed from: a */
    public static void m16356a() {
        if (f15384p != null) {
            f15384p.dismiss();
            f15384p = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m16366a(long j, C3855a c3855a) throws IOException {
        C3890m.m14994a("Mms/MessageOptions", "copyMedia(),msgId=" + j);
        boolean zM16368a = true;
        C5086i c5086iM16388a = C4146ca.m16388a(this.f15387c, ContentUris.withAppendedId(Telephony.Mms.CONTENT_URI, j));
        if (c5086iM16388a == null) {
            return false;
        }
        try {
            int iM19333b = c5086iM16388a.m19333b();
            for (int i = 0; i < iM19333b; i++) {
                C5094q c5094qM19328a = c5086iM16388a.m19328a(i);
                String str = new String(c5094qM19328a.m19394g());
                if (!"text/plain".equals(str) && !"application/smil".equals(str) && c3855a.m14746b().equals(c5094qM19328a.m19383b())) {
                    zM16368a &= m16368a(c5094qM19328a, Long.toHexString(j));
                }
            }
            return zM16368a;
        } catch (IOException e) {
            C3890m.m14999e("Mms/MessageOptions", "copyMedia : is failed. " + e.getMessage());
            if (e.getMessage() != null) {
                throw new IOException(e.getMessage());
            }
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0224 A[Catch: IOException -> 0x0193, all -> 0x01c8, TRY_LEAVE, TryCatch #5 {IOException -> 0x0193, blocks: (B:3:0x0024, B:5:0x002e, B:7:0x0038, B:9:0x003e, B:12:0x0046, B:14:0x0050, B:15:0x0055, B:17:0x005f, B:18:0x006a, B:20:0x0073, B:21:0x007e, B:23:0x008d, B:31:0x00c3, B:33:0x00c7, B:35:0x00d0, B:36:0x00d9, B:38:0x00f9, B:42:0x0107, B:45:0x0114, B:47:0x0121, B:102:0x0209, B:51:0x012d, B:52:0x0138, B:54:0x0140, B:103:0x0224, B:93:0x01dc, B:96:0x01eb, B:99:0x01fa, B:92:0x01ca, B:88:0x01c4, B:89:0x01c7, B:69:0x018c), top: B:162:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0241 A[Catch: all -> 0x01b4, IOException -> 0x0246, LOOP:0: B:108:0x023a->B:110:0x0241, LOOP_END, TryCatch #9 {all -> 0x01b4, blocks: (B:107:0x0238, B:108:0x023a, B:110:0x0241, B:113:0x0249, B:115:0x025b, B:73:0x0196, B:76:0x01a7, B:77:0x01aa, B:78:0x01b3), top: B:167:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x025b A[Catch: all -> 0x01b4, IOException -> 0x0246, TRY_LEAVE, TryCatch #9 {all -> 0x01b4, blocks: (B:107:0x0238, B:108:0x023a, B:110:0x0241, B:113:0x0249, B:115:0x025b, B:73:0x0196, B:76:0x01a7, B:77:0x01aa, B:78:0x01b3), top: B:167:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0249 A[EDGE_INSN: B:175:0x0249->B:113:0x0249 BREAK  A[LOOP:0: B:108:0x023a->B:110:0x0241], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0121 A[Catch: IOException -> 0x0193, all -> 0x01c8, TryCatch #5 {IOException -> 0x0193, blocks: (B:3:0x0024, B:5:0x002e, B:7:0x0038, B:9:0x003e, B:12:0x0046, B:14:0x0050, B:15:0x0055, B:17:0x005f, B:18:0x006a, B:20:0x0073, B:21:0x007e, B:23:0x008d, B:31:0x00c3, B:33:0x00c7, B:35:0x00d0, B:36:0x00d9, B:38:0x00f9, B:42:0x0107, B:45:0x0114, B:47:0x0121, B:102:0x0209, B:51:0x012d, B:52:0x0138, B:54:0x0140, B:103:0x0224, B:93:0x01dc, B:96:0x01eb, B:99:0x01fa, B:92:0x01ca, B:88:0x01c4, B:89:0x01c7, B:69:0x018c), top: B:162:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012d A[Catch: IOException -> 0x0193, all -> 0x01c8, TryCatch #5 {IOException -> 0x0193, blocks: (B:3:0x0024, B:5:0x002e, B:7:0x0038, B:9:0x003e, B:12:0x0046, B:14:0x0050, B:15:0x0055, B:17:0x005f, B:18:0x006a, B:20:0x0073, B:21:0x007e, B:23:0x008d, B:31:0x00c3, B:33:0x00c7, B:35:0x00d0, B:36:0x00d9, B:38:0x00f9, B:42:0x0107, B:45:0x0114, B:47:0x0121, B:102:0x0209, B:51:0x012d, B:52:0x0138, B:54:0x0140, B:103:0x0224, B:93:0x01dc, B:96:0x01eb, B:99:0x01fa, B:92:0x01ca, B:88:0x01c4, B:89:0x01c7, B:69:0x018c), top: B:162:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0140 A[Catch: IOException -> 0x0193, all -> 0x01c8, TRY_LEAVE, TryCatch #5 {IOException -> 0x0193, blocks: (B:3:0x0024, B:5:0x002e, B:7:0x0038, B:9:0x003e, B:12:0x0046, B:14:0x0050, B:15:0x0055, B:17:0x005f, B:18:0x006a, B:20:0x0073, B:21:0x007e, B:23:0x008d, B:31:0x00c3, B:33:0x00c7, B:35:0x00d0, B:36:0x00d9, B:38:0x00f9, B:42:0x0107, B:45:0x0114, B:47:0x0121, B:102:0x0209, B:51:0x012d, B:52:0x0138, B:54:0x0140, B:103:0x0224, B:93:0x01dc, B:96:0x01eb, B:99:0x01fa, B:92:0x01ca, B:88:0x01c4, B:89:0x01c7, B:69:0x018c), top: B:162:0x0024 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m16368a(com.sec.google.android.p134a.p135a.C5094q r16, java.lang.String r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 760
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.p112ui.C4132bn.m16368a(com.sec.google.android.a.a.q, java.lang.String):boolean");
    }

    /* renamed from: a */
    public void m16385a(C4108aq c4108aq) throws Throwable {
        Intent intent = new Intent(this.f15387c, (Class<?>) ChatForwardActivity.class);
        EnumC2214ab enumC2214abM16299b = c4108aq.m16299b();
        if (enumC2214abM16299b != null) {
            intent.putExtra("content_type", enumC2214abM16299b.m10076a());
        }
        if (c4108aq.m16312o() || enumC2214abM16299b == EnumC2214ab.TEXT) {
            intent.putExtra("download_uri", c4108aq.f15277l);
        } else if (c4108aq.f15277l != null && c4108aq.f15277l.startsWith("http://maps.google.com/")) {
            intent.putExtra("content_type", EnumC2214ab.TEXT.m10076a());
            intent.putExtra("download_uri", "[" + this.f15387c.getString(R.string.media_map) + "]\n" + c4108aq.f15277l);
        } else {
            Uri uriM16370b = m16370b(c4108aq.f15268c);
            if (uriM16370b != null) {
                intent.putExtra("download_uri", uriM16370b.toString());
            }
            if (c4108aq.m16303f() == 5) {
                String strM16300c = c4108aq.m16300c();
                if (strM16300c != null) {
                    intent.putExtra("sub_content", strM16300c.split("\\.")[0]);
                }
            } else if (c4108aq.f15277l != null) {
                intent.putExtra("sub_content", c4108aq.f15277l);
            }
            intent.putExtra("is_forward_mode", true);
        }
        this.f15387c.startActivity(intent);
    }

    /* renamed from: b */
    public void m16387b(C4108aq c4108aq) {
        Intent intent = new Intent();
        String strM16318u = c4108aq.m16318u();
        String str = c4108aq.f15286u;
        Uri uriM16302e = c4108aq.m16302e();
        if (f15382h.size() > 0) {
            f15382h.clear();
        }
        if (c4108aq.f15287v != null) {
            ArrayList<C3855a> arrayListM14195a = C3779a.m14195a((Context) this.f15387c, uriM16302e, true);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayListM14195a.size()) {
                    Uri uriM14746b = arrayListM14195a.get(i2).m14746b();
                    arrayList2.add(arrayListM14195a.get(i2).m14744a());
                    arrayList.add(uriM14746b);
                    i = i2 + 1;
                } else {
                    this.f15387c.runOnUiThread(new RunnableC4141bw(this, arrayList, uriM16302e, arrayList2, intent, str, strM16318u));
                    return;
                }
            }
        } else {
            intent.setAction("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", strM16318u);
            this.f15387c.startActivity(ShareActivity.m13949a(this.f15387c, intent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m16375b(android.content.Context r9, android.net.Uri r10, android.net.Uri r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.p112ui.C4132bn.m16375b(android.content.Context, android.net.Uri, android.net.Uri):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0160  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m16353a(android.net.Uri r12, com.sec.chaton.smsplugin.p102b.C3790i r13, long r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.p112ui.C4132bn.m16353a(android.net.Uri, com.sec.chaton.smsplugin.b.i, long):java.lang.String");
    }

    /* renamed from: b */
    private Uri m16370b(long j) throws Throwable {
        C5086i c5086iM14893b;
        Uri uriM16371b = null;
        try {
            c5086iM14893b = C3870p.m14893b(this.f15387c, ContentUris.withAppendedId(Telephony.Mms.CONTENT_URI, j));
        } catch (C5111c e) {
            C3890m.m14999e("Mms/MessageOptions", "copyMedia can't load pdu body: " + j);
            c5086iM14893b = null;
        }
        if (c5086iM14893b != null) {
            int iM19333b = c5086iM14893b.m19333b();
            for (int i = 0; i < iM19333b; i++) {
                C5094q c5094qM19328a = c5086iM14893b.m19328a(i);
                String str = new String(c5094qM19328a.m19394g());
                if (C5077a.m19288b(str) || C5077a.m19291d(str) || C5077a.m19290c(str) || str.equalsIgnoreCase("text/x-vCard") || str.equalsIgnoreCase("text/x-vCalendar")) {
                    uriM16371b = m16371b(c5094qM19328a, Long.toHexString(j));
                }
            }
        }
        return uriM16371b;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x011d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.net.Uri m16371b(com.sec.google.android.p134a.p135a.C5094q r13, java.lang.String r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.p112ui.C4132bn.m16371b(com.sec.google.android.a.a.q, java.lang.String):android.net.Uri");
    }
}
