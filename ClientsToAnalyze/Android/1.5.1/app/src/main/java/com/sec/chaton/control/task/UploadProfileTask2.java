package com.sec.chaton.control.task;

import android.os.Handler;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.common.entry.UserProfileEntry;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.ChatOnXmlParser;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class UploadProfileTask2 extends AbstractHttpTask2 {

    /* renamed from: a */
    private UserProfileEntry f1679a;

    /* renamed from: b */
    private String f1680b;

    /* renamed from: c */
    private String f1681c;

    public UploadProfileTask2(Handler handler, HttpEnvelope httpEnvelope, UserProfileEntry userProfileEntry, String str) {
        super(handler, httpEnvelope);
        this.f1679a = userProfileEntry;
        this.f1681c = str;
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) {
        if (!httpEntry.m1950a() || httpEntry.m1951b() == HttpResultCode.ERROR) {
            return;
        }
        if (this.f1679a.m1964a() != null) {
            ChatONPref.m3523a("Push Name", this.f1679a.m1964a());
        }
        if (this.f1679a.m1966b() != null) {
            ChatONPref.m3523a("status_message", this.f1679a.m1966b());
        }
        if (this.f1679a.m1968c() != null) {
            ChatONPref.m3523a("birthday", this.f1680b);
            ChatONPref.m3523a("birthday_type", this.f1681c);
        }
        if (this.f1679a.m1970d() != null) {
            ChatONPref.m3523a("email", this.f1679a.m1970d());
        }
        if (this.f1679a.m1971e() != null) {
            ChatONPref.m3523a("samsung_email", this.f1679a.m1971e());
        }
        httpEntry.m1953b(this.f1679a);
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() {
        ChatOnXmlParser chatOnXmlParser = new ChatOnXmlParser();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.f1679a.m1964a() != null) {
            linkedHashMap.put("name", this.f1679a.m1964a());
        }
        if (this.f1679a.m1966b() != null) {
            linkedHashMap.put("status", this.f1679a.m1966b());
        }
        if (this.f1679a.m1968c() != null) {
            this.f1680b = this.f1679a.m1968c();
            if (this.f1681c.equals("FULL")) {
                linkedHashMap.put("birthday", this.f1679a.m1968c());
            } else if (this.f1681c.equals("SHORT")) {
                linkedHashMap.put("birthday", this.f1679a.m1968c().substring(5, 10));
            } else if (this.f1681c.equals("DONT")) {
                linkedHashMap.put("birthday", "0000-12-31");
            } else {
                ChatONLogWriter.m3506b("Unknown birthday option", getClass().getSimpleName());
            }
        }
        if (this.f1679a.m1970d() != null) {
            linkedHashMap.put("email", this.f1679a.m1970d());
        }
        if (this.f1679a.m1971e() != null) {
            linkedHashMap.put("samsungemail", this.f1679a.m1971e());
        }
        String strM3552a = chatOnXmlParser.m3552a((Object) linkedHashMap);
        ChatONLogWriter.m3511e(strM3552a, getClass().getSimpleName());
        return strM3552a;
    }
}
