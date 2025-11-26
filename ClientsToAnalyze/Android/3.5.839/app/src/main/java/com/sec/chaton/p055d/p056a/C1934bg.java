package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1015an;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2231as;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p057e.p058a.C2201o;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.p065io.entry.GetAllMessageList;
import com.sec.chaton.p065io.entry.inner.Message;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.settings.p096a.C3460d;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GetAllMessagesTask.java */
/* renamed from: com.sec.chaton.d.a.bg */
/* loaded from: classes.dex */
public class C1934bg extends AbstractC1900a {

    /* renamed from: b */
    ContentResolver f7207b;

    /* renamed from: c */
    private String f7208c;

    /* renamed from: d */
    private String f7209d;

    /* renamed from: e */
    private EnumC2300t f7210e;

    public C1934bg(C2454e c2454e, String str, String str2, EnumC2300t enumC2300t) {
        super(c2454e);
        this.f7208c = str;
        this.f7209d = str2;
        this.f7210e = enumC2300t;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) throws RemoteException, OperationApplicationException {
        String str;
        if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
            GetAllMessageList getAllMessageList = (GetAllMessageList) c0778b.m3110e();
            boolean zBooleanValue = getAllMessageList.has_more.booleanValue();
            C4904y.m18641c("has_more : " + zBooleanValue, getClass().getSimpleName());
            ArrayList<Message> arrayList = getAllMessageList.messages;
            if (arrayList.size() <= 0) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("allMessage.messages.size() is 0", getClass().getSimpleName());
                    return;
                }
                return;
            }
            Collections.sort(arrayList, new C1935bh(this));
            this.f7207b = GlobalApplication.m18732r().getContentResolver();
            ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
            Message message = null;
            ArrayList<Message> arrayList3 = new ArrayList<>();
            C2201o c2201oM9951e = C2198l.m9951e(this.f7207b, this.f7208c);
            if (c2201oM9951e != null) {
                for (Message message2 : arrayList) {
                    message2.sender = C2176ab.m9697g(this.f7207b, message2.sender);
                    if (C4904y.f17873c) {
                        String strSubstring = message2.msg;
                        if (strSubstring.length() > 5) {
                            strSubstring = strSubstring.substring(0, 4);
                        }
                        C4904y.m18641c("Msg : " + strSubstring + ",Tid : " + message2.tid + ", Type : " + message2.type + ", MsgId : " + message2.f8571id + ", Sender : " + message2.sender + ", Time : " + message2.time + ", SendCount : " + message2.sendcount + ", ReadCount : " + message2.readcount, getClass().getSimpleName());
                    }
                    if (C2204r.m10049b(this.f7207b, message2.sender, message2.f8571id, this.f7209d)) {
                        if (message2.type.equals(Config.NOTIFICATION_INTENT_MSG)) {
                            m9106a(arrayList2, message2);
                        } else if (message2.type.equals("media")) {
                            m9109c(arrayList2, message2);
                        } else if (message2.type.equals("content")) {
                            m9108b(arrayList2, message2);
                        } else {
                            if (message2.type.equals("noti")) {
                                arrayList3.add(message2);
                            }
                            message2 = message;
                        }
                        message = message2;
                    }
                }
                if (arrayList3.size() > 0) {
                    m9107a(arrayList2, arrayList3);
                }
                if ((TextUtils.isEmpty(c2201oM9951e.f7842e) || c2201oM9951e.f7847j == 0) && message != null) {
                    arrayList2.add(m9105a(c2201oM9951e, message));
                }
                if (zBooleanValue) {
                    str = arrayList.get(0).tid;
                } else {
                    str = "-1";
                }
                arrayList2.add(C2198l.m9919a(this.f7208c, str));
                try {
                    if (arrayList2.size() > 0) {
                        this.f7207b.applyBatch("com.sec.chaton.provider", arrayList2);
                    }
                } catch (Exception e) {
                    C4904y.m18634a(e.getMessage(), getClass().getSimpleName());
                }
                C0991aa.m6037a().m18961c(new C1015an(new String[]{this.f7208c}));
                return;
            }
            return;
        }
        if (c0778b.m3107b() == EnumC2464o.NO_CONTENT) {
            ArrayList<ContentProviderOperation> arrayList4 = new ArrayList<>();
            arrayList4.add(C2198l.m9919a(this.f7208c, "-1"));
            try {
                if (arrayList4.size() > 0) {
                    GlobalApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList4);
                }
            } catch (Exception e2) {
                C4904y.m18634a(e2.getMessage(), getClass().getSimpleName());
            }
            if (C4904y.f17872b) {
                C4904y.m18639b("GetAllMessages fail. code : " + c0778b.m3107b(), getClass().getSimpleName());
            }
            C0991aa.m6037a().m18961c(new C1015an(new String[]{this.f7208c}));
            return;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("GetAllMessages fail. code : " + c0778b.m3107b(), getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private ContentProviderOperation m9105a(C2201o c2201o, Message message) {
        c2201o.f7844g = message.time.longValue();
        c2201o.f7847j = Long.valueOf(message.f8571id).longValue();
        c2201o.f7848k = message.sender;
        c2201o.f7840c = this.f7210e.m10210a();
        StringBuilder sb = new StringBuilder();
        if (message.sender.equals(C4809aa.m18104a().m18121a("chaton_id", ""))) {
            sb.append(1).append(Config.KEYVALUE_SPLIT);
        } else {
            sb.append(2).append(Config.KEYVALUE_SPLIT);
        }
        sb.append(C2204r.m10021a(message.msg, message.type).m10076a()).append(Config.KEYVALUE_SPLIT);
        if (message.sender.startsWith("0999")) {
            try {
                sb.append(C1736gi.m8632a(new JSONObject(message.msg).getString("push_message")));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            sb.append(C1736gi.m8632a(message.msg));
        }
        sb.append(Config.KEYVALUE_SPLIT);
        if (this.f7210e == EnumC2300t.GROUPCHAT || this.f7210e == EnumC2300t.TOPIC) {
            sb.append(C1736gi.m8632a(C2176ab.m9695f(this.f7207b, message.sender)));
        }
        c2201o.f7842e = sb.toString();
        return C2198l.m9947c(this.f7207b, this.f7208c, c2201o);
    }

    /* renamed from: a */
    private void m9106a(ArrayList<ContentProviderOperation> arrayList, Message message) {
        arrayList.add(C2204r.m10009a(this.f7207b, this.f7208c, EnumC2214ab.TEXT, message, this.f7209d, (String) null));
    }

    /* renamed from: b */
    private void m9108b(ArrayList<ContentProviderOperation> arrayList, Message message) {
        try {
            arrayList.add(C2204r.m10009a(this.f7207b, this.f7208c, C2204r.m10022a(new JSONObject(message.msg)), message, this.f7209d, (String) null));
        } catch (JSONException e) {
            C4904y.m18635a(e, this.f18194f);
        }
    }

    /* renamed from: c */
    private void m9109c(ArrayList<ContentProviderOperation> arrayList, Message message) {
        String str;
        EnumC2214ab enumC2214abM10019a = C2204r.m10019a(message.msg);
        String[] strArrSplit = message.msg.split("\n");
        if ((enumC2214abM10019a == EnumC2214ab.CONTACT || enumC2214abM10019a == EnumC2214ab.CALENDAR || enumC2214abM10019a == EnumC2214ab.DOCUMENT || enumC2214abM10019a == EnumC2214ab.FILE) && strArrSplit.length >= 6) {
            str = strArrSplit[5];
        } else {
            str = null;
        }
        if (enumC2214abM10019a == EnumC2214ab.IMAGE && C3460d.m13778b(message.msg)) {
            enumC2214abM10019a = EnumC2214ab.ANICON;
        }
        if (enumC2214abM10019a == EnumC2214ab.IMAGE || enumC2214abM10019a == EnumC2214ab.AUDIO) {
            if (strArrSplit.length >= 5) {
                String str2 = strArrSplit[2];
                String str3 = strArrSplit[4];
                String str4 = strArrSplit[3];
                String str5 = this.f7208c;
                long jLongValue = Long.valueOf(message.f8571id).longValue();
                EnumC2300t enumC2300t = this.f7210e;
                String str6 = message.sender;
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new RunnableC1936bi(this, enumC2214abM10019a, jLongValue, handler, message.msg, str5, enumC2300t, str6, str2, str4));
            } else if (strArrSplit.length >= 4) {
                C4904y.m18639b("No need to update and insert: " + strArrSplit[3], getClass().getName());
            } else {
                C4904y.m18634a("Token Error", getClass().getName());
            }
        }
        arrayList.add(C2204r.m10009a(this.f7207b, this.f7208c, enumC2214abM10019a, message, this.f7209d, str));
    }

    /* renamed from: a */
    private void m9107a(ArrayList<ContentProviderOperation> arrayList, ArrayList<Message> arrayList2) {
        Iterator<Message> it = arrayList2.iterator();
        while (it.hasNext()) {
            Message next = it.next();
            if (!TextUtils.isEmpty(next.msg)) {
                String[] strArrSplit = next.msg.split("\n");
                StringBuilder sb = new StringBuilder();
                for (String str : strArrSplit) {
                    C4904y.m18646e("Row : " + str, getClass().getSimpleName());
                    String[] strArrM8650b = C1736gi.m8650b(str, ",", 3);
                    if (strArrM8650b.length > 2) {
                        String str2 = strArrM8650b[1];
                        String strM9685b = C2176ab.m9685b(this.f7207b, str2, strArrM8650b[2]);
                        EnumC2231as enumC2231as = EnumC2231as.UNKNOWN;
                        if (EnumC2231as.m10099a(strArrM8650b[0]) == EnumC2231as.ENTER) {
                            if (C4809aa.m18104a().m18121a("chaton_id", "").equals(next.sender)) {
                                enumC2231as = EnumC2231as.INVITE;
                            } else {
                                enumC2231as = EnumC2231as.ENTER;
                            }
                        } else if (EnumC2231as.m10099a(strArrM8650b[0]) == EnumC2231as.LEAVE) {
                            enumC2231as = EnumC2231as.LEAVE;
                            arrayList.add(C2176ab.m9672a("", str2, strM9685b));
                        }
                        if (enumC2231as != EnumC2231as.UNKNOWN) {
                            sb.append(String.format("%d,%s,%s", Integer.valueOf(enumC2231as.m10100a()), str2, C1736gi.m8632a(strM9685b))).append(Config.KEYVALUE_SPLIT);
                        }
                    }
                }
                String string = sb.toString();
                if (!TextUtils.isEmpty(string)) {
                    C2204r.m10013a(this.f7207b, this.f7208c, string, next.time.longValue(), next.f8571id, next.sender);
                }
            }
        }
    }
}
