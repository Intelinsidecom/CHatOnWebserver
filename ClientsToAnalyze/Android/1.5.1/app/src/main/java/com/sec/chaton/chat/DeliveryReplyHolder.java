package com.sec.chaton.chat;

import com.sec.chaton.common.SSMGPB;
import com.sec.chaton.util.ChatONLogWriter;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class DeliveryReplyHolder {

    /* renamed from: a */
    private static HashMap f929a = new HashMap();

    /* renamed from: b */
    private String f930b;

    /* renamed from: c */
    private ArrayList f931c = new ArrayList();

    private DeliveryReplyHolder(String str) {
        this.f930b = str;
    }

    /* renamed from: a */
    public static void m801a(String str) {
        if (f929a.containsKey(str)) {
            f929a.remove(str);
        }
    }

    /* renamed from: b */
    public static synchronized DeliveryReplyHolder m802b(String str) {
        DeliveryReplyHolder deliveryReplyHolder;
        if (f929a.containsKey(str)) {
            deliveryReplyHolder = (DeliveryReplyHolder) f929a.get(str);
        } else {
            f929a.put(str, new DeliveryReplyHolder(str));
            deliveryReplyHolder = (DeliveryReplyHolder) f929a.get(str);
        }
        return deliveryReplyHolder;
    }

    /* renamed from: a */
    public void m803a() {
        this.f931c.clear();
    }

    /* renamed from: a */
    public void m804a(SSMGPB.InboxMessage inboxMessage) {
        this.f931c.add(inboxMessage);
        ChatONLogWriter.m3508c("Insert msg, sender: " + inboxMessage.m1548d() + ", msg:" + inboxMessage.m1554j(), getClass().getSimpleName());
    }

    /* renamed from: b */
    public boolean m805b() {
        return this.f931c.isEmpty();
    }

    /* renamed from: c */
    public ArrayList m806c() {
        return this.f931c;
    }
}
