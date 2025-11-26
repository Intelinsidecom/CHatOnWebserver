package com.sec.chaton.p013a;

import android.hardware.motion.MREvent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p013a.p014a.AbstractC0164c;
import com.sec.chaton.p013a.p014a.C0176o;
import com.sec.chaton.p013a.p014a.C0177p;
import com.sec.chaton.p013a.p014a.C0183v;
import com.sec.chaton.p015b.p016a.C0257e;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.util.C1341p;
import java.util.Iterator;

/* compiled from: MessageControl2.java */
/* renamed from: com.sec.chaton.a.g */
/* loaded from: classes.dex */
class HandlerC0208g extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0223v f510a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC0208g(C0223v c0223v, Looper looper) {
        super(looper);
        this.f510a = c0223v;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        long jM785a;
        long jM785a2;
        long jM785a3;
        C0200am c0200am = (C0200am) message.obj;
        C0215n c0215n = (C0215n) this.f510a.f550o.get(Long.valueOf(c0200am.m752b()));
        if (c0215n != null) {
            switch (message.what) {
                case 0:
                case 1029:
                    C0257e c0257e = (C0257e) c0200am.m751a();
                    int iM917b = c0257e.m917b();
                    if (iM917b == 21 || iM917b == 2 || iM917b == 31 || iM917b == 33 || iM917b == 25 || iM917b == 24 || iM917b == 23) {
                        AbstractC0164c abstractC0164c = (AbstractC0164c) c0215n.m789c();
                        if (abstractC0164c == null || !abstractC0164c.m703b()) {
                            this.f510a.m810a(message.arg1, message.arg2, message.what, c0200am.m751a(), c0215n.m785a());
                            this.f510a.f550o.remove(Long.valueOf(c0200am.m752b()));
                            this.f510a.m822c(false);
                            return;
                        }
                        c0215n.m790d();
                        return;
                    }
                    if (!c0257e.f604a) {
                        this.f510a.m810a(message.arg1, message.arg2, message.what, c0200am.m751a(), c0215n.m785a());
                        this.f510a.f550o.remove(Long.valueOf(c0200am.m752b()));
                        this.f510a.m822c(false);
                        return;
                    } else {
                        if (!c0215n.m791e()) {
                            synchronized (this.f510a.f541e) {
                                if (c0257e instanceof C0176o) {
                                    this.f510a.f553r = ((C0176o) c0257e).m715a();
                                } else if (c0257e instanceof C0177p) {
                                    this.f510a.f553r = ((C0177p) c0257e).f424d;
                                }
                            }
                            this.f510a.m810a(message.arg1, message.arg2, message.what, c0200am.m751a(), c0215n.m785a());
                            this.f510a.f550o.remove(Long.valueOf(c0200am.m752b()));
                            this.f510a.m822c(true);
                            return;
                        }
                        c0215n.m790d();
                        return;
                    }
                case 2:
                    C0257e c0257e2 = (C0257e) c0200am.m751a();
                    int iM917b2 = c0257e2.m917b();
                    if (iM917b2 == 2006 || iM917b2 == 3008) {
                        this.f510a.m851a(c0257e2.f606c, GlobalApplication.m3107h().m4488b().m4513a(), GlobalApplication.m3107h().m4488b().m4516b());
                        this.f510a.m841a(Long.MAX_VALUE);
                        C1341p.m4658b("inboxNO : " + c0257e2.f606c, getClass().getSimpleName());
                        this.f510a.f548l = true;
                        if (c0215n.m791e()) {
                            this.f510a.f555t.add(Long.valueOf(c0200am.m752b()));
                            Message messageObtain = Message.obtain();
                            messageObtain.arg1 = message.arg1;
                            messageObtain.arg2 = message.arg2;
                            messageObtain.what = 1026;
                            messageObtain.obj = new C0200am(-1L, c0200am.m753c(), c0200am.m751a());
                            this.f510a.f558w.sendMessageDelayed(messageObtain, 10000L);
                            return;
                        }
                        this.f510a.m810a(message.arg1, message.arg2, message.what, c0200am.m751a(), c0215n.m785a());
                        this.f510a.f550o.remove(Long.valueOf(c0200am.m752b()));
                        return;
                    }
                    if (iM917b2 == 21 || iM917b2 == 2 || iM917b2 == 31 || iM917b2 == 33 || iM917b2 == 25 || iM917b2 == 24 || iM917b2 == 23) {
                        AbstractC0164c abstractC0164c2 = (AbstractC0164c) c0215n.m789c();
                        if (abstractC0164c2 == null || !abstractC0164c2.m703b()) {
                            this.f510a.f550o.remove(Long.valueOf(c0200am.m752b()));
                            this.f510a.m810a(message.arg1, message.arg2, message.what, c0200am.m751a(), c0215n.m785a());
                            return;
                        } else {
                            c0215n.m790d();
                            return;
                        }
                    }
                    if (!c0257e2.f604a) {
                        this.f510a.f550o.remove(Long.valueOf(c0200am.m752b()));
                        this.f510a.m810a(message.arg1, message.arg2, message.what, c0200am.m751a(), c0215n.m785a());
                        return;
                    } else if (!c0215n.m791e()) {
                        this.f510a.f550o.remove(Long.valueOf(c0200am.m752b()));
                        this.f510a.m810a(message.arg1, message.arg2, message.what, c0200am.m751a(), c0215n.m785a());
                        return;
                    } else {
                        c0215n.m790d();
                        return;
                    }
                case 4:
                case 1025:
                    C0257e c0257e3 = (C0257e) c0200am.m751a();
                    int iM917b3 = c0257e3.m917b();
                    if (iM917b3 == 21 || iM917b3 == 2 || iM917b3 == 31 || iM917b3 == 33 || iM917b3 == 25 || iM917b3 == 24 || iM917b3 == 23) {
                        AbstractC0164c abstractC0164c3 = (AbstractC0164c) c0215n.m789c();
                        if (abstractC0164c3 != null && abstractC0164c3.m703b()) {
                            c0215n.m790d();
                            return;
                        }
                        if (1025 == message.what) {
                            jM785a = c0257e3.m918c();
                        } else {
                            jM785a = c0215n.m785a();
                        }
                        this.f510a.m810a(message.arg1, message.arg2, message.what, c0200am.m751a(), jM785a);
                        return;
                    }
                    if (iM917b3 == 2006 || iM917b3 == 3008) {
                        this.f510a.m851a(c0257e3.f606c, GlobalApplication.m3107h().m4488b().m4513a(), GlobalApplication.m3107h().m4488b().m4516b());
                        this.f510a.m841a(Long.MAX_VALUE);
                        this.f510a.f548l = true;
                        this.f510a.f555t.add(Long.valueOf(c0200am.m752b()));
                        Message messageObtain2 = Message.obtain();
                        messageObtain2.arg1 = message.arg1;
                        messageObtain2.arg2 = message.arg2;
                        messageObtain2.what = 1026;
                        messageObtain2.obj = new C0200am(-1L, c0200am.m753c(), c0200am.m751a());
                        this.f510a.f558w.sendMessageDelayed(messageObtain2, 10000L);
                        return;
                    }
                    if (iM917b3 == 10000) {
                        this.f510a.f555t.add(Long.valueOf(c0200am.m752b()));
                        Message messageObtain3 = Message.obtain();
                        messageObtain3.arg1 = message.arg1;
                        messageObtain3.arg2 = message.arg2;
                        messageObtain3.what = 1026;
                        messageObtain3.obj = new C0200am(-1L, c0200am.m753c(), c0200am.m751a());
                        this.f510a.f558w.sendMessageDelayed(messageObtain3, 10000L);
                        return;
                    }
                    if (6002 == iM917b3) {
                        new C0202ao(new Handler()).m757a();
                    }
                    if (c0257e3.f604a) {
                        if (c0215n.m791e()) {
                            c0215n.m790d();
                            return;
                        }
                        if (1025 == message.what) {
                            jM785a3 = c0257e3.m918c();
                        } else {
                            jM785a3 = c0215n.m785a();
                        }
                        this.f510a.m810a(message.arg1, message.arg2, message.what, c0200am.m751a(), jM785a3);
                        this.f510a.f550o.remove(Long.valueOf(c0200am.m752b()));
                        return;
                    }
                    if (1025 == message.what) {
                        jM785a2 = c0257e3.m918c();
                    } else {
                        jM785a2 = c0215n.m785a();
                    }
                    this.f510a.m810a(message.arg1, message.arg2, message.what, c0200am.m751a(), jM785a2);
                    this.f510a.f550o.remove(Long.valueOf(c0200am.m752b()));
                    return;
                case 8:
                    C0257e c0257e4 = (C0257e) c0200am.m751a();
                    int iM917b4 = c0257e4.m917b();
                    if (iM917b4 == 21 || iM917b4 == 2 || iM917b4 == 31 || iM917b4 == 33 || iM917b4 == 25 || iM917b4 == 24 || iM917b4 == 23) {
                        AbstractC0164c abstractC0164c4 = (AbstractC0164c) c0215n.m789c();
                        if (abstractC0164c4 == null || !abstractC0164c4.m703b()) {
                            this.f510a.m810a(message.arg1, message.arg2, message.what, c0200am.m751a(), c0215n.m785a());
                            return;
                        } else {
                            c0215n.m790d();
                            return;
                        }
                    }
                    if (iM917b4 == 3003 || iM917b4 == 10000) {
                        this.f510a.f555t.add(Long.valueOf(c0200am.m752b()));
                        Message messageObtain4 = Message.obtain();
                        messageObtain4.arg1 = message.arg1;
                        messageObtain4.arg2 = message.arg2;
                        messageObtain4.what = 1026;
                        messageObtain4.obj = new C0200am(-1L, c0200am.m753c(), c0200am.m751a());
                        this.f510a.f558w.sendMessageDelayed(messageObtain4, 10000L);
                        return;
                    }
                    if (!c0257e4.f604a) {
                        this.f510a.m810a(message.arg1, message.arg2, message.what, c0200am.m751a(), c0215n.m785a());
                        this.f510a.f550o.remove(Long.valueOf(c0200am.m752b()));
                        return;
                    } else if (!c0215n.m791e()) {
                        this.f510a.m810a(message.arg1, message.arg2, message.what, c0200am.m751a(), c0215n.m785a());
                        this.f510a.f550o.remove(Long.valueOf(c0200am.m752b()));
                        return;
                    } else {
                        c0215n.m790d();
                        return;
                    }
                case MREvent.TILT_PORTRAIT_BACK /* 12 */:
                case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                    C0257e c0257e5 = (C0257e) c0200am.m751a();
                    int iM917b5 = c0257e5.m917b();
                    if (iM917b5 == 21 || iM917b5 == 2 || iM917b5 == 31 || iM917b5 == 33 || iM917b5 == 25 || iM917b5 == 24 || iM917b5 == 23) {
                        AbstractC0164c abstractC0164c5 = (AbstractC0164c) c0215n.m789c();
                        if (abstractC0164c5 == null || !abstractC0164c5.m703b()) {
                            this.f510a.m810a(message.arg1, message.arg2, message.what, c0200am.m751a(), c0215n.m785a());
                            return;
                        } else {
                            c0215n.m790d();
                            return;
                        }
                    }
                    if (!c0257e5.f604a) {
                        this.f510a.m810a(message.arg1, message.arg2, message.what, c0200am.m751a(), c0215n.m785a());
                        this.f510a.f550o.remove(Long.valueOf(c0200am.m752b()));
                        return;
                    } else if (!c0215n.m791e()) {
                        this.f510a.m810a(message.arg1, message.arg2, message.what, c0200am.m751a(), c0215n.m785a());
                        this.f510a.f550o.remove(Long.valueOf(c0200am.m752b()));
                        return;
                    } else {
                        c0215n.m790d();
                        return;
                    }
                case 801:
                    C0259g c0259g = (C0259g) c0200am.m751a();
                    if ((c0259g.m928b() == EnumC0518y.SUCCESS || c0259g.m928b() == EnumC0518y.NO_CONTENT) && c0215n.m791e()) {
                        c0215n.m790d();
                        return;
                    }
                    return;
                default:
                    if (!c0215n.m791e()) {
                        this.f510a.m810a(message.arg1, message.arg2, message.what, c0200am.m751a(), c0215n.m785a());
                        this.f510a.f550o.remove(Long.valueOf(c0200am.m752b()));
                        return;
                    } else {
                        c0215n.m790d();
                        return;
                    }
            }
        }
        switch (message.what) {
            case 2:
                if (((C0257e) c0200am.m751a()).m917b() == 3003) {
                }
                return;
            case 6:
                if (!((C0183v) c0200am.m751a()).f458e) {
                    if (this.f510a.f548l) {
                        this.f510a.m858g();
                        this.f510a.f548l = false;
                    }
                    if (this.f510a.f555t.size() > 0) {
                        Iterator it = this.f510a.f555t.iterator();
                        while (it.hasNext()) {
                            C0215n c0215n2 = (C0215n) this.f510a.f550o.get(Long.valueOf(((Long) it.next()).longValue()));
                            if (c0215n2 != null) {
                                c0215n2.m790d();
                            }
                        }
                        this.f510a.f555t.clear();
                    }
                }
                this.f510a.m810a(message.arg1, message.arg2, message.what, c0200am.m751a(), -1L);
                return;
            case 1026:
                if (this.f510a.f548l) {
                    this.f510a.m858g();
                    this.f510a.f548l = false;
                }
                if (this.f510a.f555t.size() > 0) {
                    Iterator it2 = this.f510a.f555t.iterator();
                    while (it2.hasNext()) {
                        C0215n c0215n3 = (C0215n) this.f510a.f550o.get(Long.valueOf(((Long) it2.next()).longValue()));
                        if (c0215n3 != null) {
                            c0215n3.m790d();
                        }
                    }
                    this.f510a.f555t.clear();
                    return;
                }
                return;
            default:
                this.f510a.m810a(message.arg1, message.arg2, message.what, c0200am.m751a(), -1L);
                return;
        }
    }
}
