package com.sec.chaton.control.task;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.provider.ContactsContract;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.p000io.entry.RegisterSSMServer;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.ChatOnXmlParser;
import com.sec.chaton.util.DeviceInfoUtil;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class RegistrationTask extends AbstractHttpTask2 {

    /* renamed from: a */
    protected String f1661a;

    /* renamed from: b */
    protected String f1662b;

    /* renamed from: c */
    private String f1663c;

    /* renamed from: d */
    private String f1664d;

    /* renamed from: e */
    private Context f1665e;

    /* renamed from: f */
    private ContentResolver f1666f;

    public RegistrationTask(Handler handler, HttpEnvelope httpEnvelope, String str, String str2, String str3, String str4) {
        super(handler, httpEnvelope);
        this.f1663c = str;
        this.f1664d = str2;
        this.f1661a = str4;
        this.f1662b = str3;
        this.f1665e = GlobalApplication.m2387e();
        this.f1666f = this.f1665e.getContentResolver();
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) {
        if (!httpEntry.m1950a() || httpEntry.m1951b() == HttpResultCode.ERROR) {
            return;
        }
        RegisterSSMServer registerSSMServer = (RegisterSSMServer) httpEntry.m1955d();
        ChatONPref.m3519a().edit().putString("msisdn", this.f1663c).commit();
        ChatONPref.m3519a().edit().putString("uid", registerSSMServer.uid).commit();
        ChatONPref.m3523a("Push Name", this.f1664d);
        ChatONLogWriter.m3508c("Success, UID : " + registerSSMServer.uid, getClass().getSimpleName());
        this.f1666f.delete(ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build(), "account_type=?", new String[]{"com.sec.chaton"});
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() {
        ChatOnXmlParser chatOnXmlParser = new ChatOnXmlParser();
        LinkedHashMap linkedHashMap = new LinkedHashMap(5);
        linkedHashMap.put("msisdn", this.f1663c);
        linkedHashMap.put("imei", DeviceInfoUtil.m3564a());
        if (GlobalApplication.f1895b != null) {
            linkedHashMap.put("regid", GlobalApplication.f1895b);
        }
        linkedHashMap.put("pushtype", "SPP");
        linkedHashMap.put("osversion", "android " + Build.VERSION.SDK);
        linkedHashMap.put("imsi", DeviceInfoUtil.m3568e());
        linkedHashMap.put("model", DeviceInfoUtil.m3565b());
        linkedHashMap.put("name", this.f1664d);
        linkedHashMap.put("token", this.f1662b);
        linkedHashMap.put("authnum", this.f1661a);
        String strM3552a = chatOnXmlParser.m3552a((Object) linkedHashMap);
        ChatONLogWriter.m3511e(strM3552a, getClass().getSimpleName());
        return strM3552a;
    }
}
