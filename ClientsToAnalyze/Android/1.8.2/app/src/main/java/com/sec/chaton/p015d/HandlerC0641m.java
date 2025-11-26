package com.sec.chaton.p015d;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.C0229at;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p007a.p008a.C0103d;
import com.sec.chaton.p015d.p016a.AbstractC0559b;
import com.sec.chaton.p015d.p016a.C0605u;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;
import java.util.Iterator;

/* compiled from: MessageControl.java */
/* renamed from: com.sec.chaton.d.m */
/* loaded from: classes.dex */
class HandlerC0641m extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0639k f2505a;

    HandlerC0641m(C0639k c0639k) {
        this.f2505a = c0639k;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        long jM2821b;
        long jM2821b2;
        long jM2821b3;
        C0628ar c0628ar = (C0628ar) message.obj;
        C0623am c0623am = (C0623am) this.f2505a.f2495n.get(Long.valueOf(c0628ar.m2830b()));
        if (c0623am != null) {
            switch (message.what) {
                case 0:
                case C0229at.HorizontalSrollView_android_background /* 12 */:
                case C0229at.HorizontalSrollView_android_focusable /* 18 */:
                    C0103d c0103d = (C0103d) c0628ar.m2829a();
                    int iM680a = c0103d.m680a();
                    if (iM680a == 21 || iM680a == 2 || iM680a == 31 || iM680a == 33 || iM680a == 25 || iM680a == 24 || iM680a == 23) {
                        AbstractC0559b abstractC0559b = (AbstractC0559b) c0623am.m2823d();
                        if (abstractC0559b == null || !abstractC0559b.m2758a()) {
                            this.f2505a.m2907a(message.arg1, message.arg2, message.what, c0628ar.m2829a(), c0623am.m2821b());
                            break;
                        } else {
                            c0623am.m2824e();
                            break;
                        }
                    } else if (!c0103d.f333a) {
                        this.f2505a.m2907a(message.arg1, message.arg2, message.what, c0628ar.m2829a(), c0623am.m2821b());
                        this.f2505a.f2495n.remove(Long.valueOf(c0628ar.m2830b()));
                        break;
                    } else if (!c0623am.m2825f()) {
                        this.f2505a.m2907a(message.arg1, message.arg2, message.what, c0628ar.m2829a(), c0623am.m2821b());
                        this.f2505a.f2495n.remove(Long.valueOf(c0628ar.m2830b()));
                        break;
                    } else {
                        c0623am.m2824e();
                        break;
                    }
                    break;
                case 2:
                    C0103d c0103d2 = (C0103d) c0628ar.m2829a();
                    int iM680a2 = c0103d2.m680a();
                    if (iM680a2 == 2006 || iM680a2 == 3008) {
                        this.f2505a.m2947a(c0103d2.f335c, GlobalApplication.m3263d().m5922b().m5923a(), GlobalApplication.m3263d().m5922b().m5926b());
                        this.f2505a.m2930a(Long.MAX_VALUE);
                        C1786r.m6061b("inboxNO : " + c0103d2.f335c, getClass().getSimpleName());
                        this.f2505a.f2494l = true;
                        if (c0623am.m2825f()) {
                            this.f2505a.f2499r.add(Long.valueOf(c0628ar.m2830b()));
                            Message messageObtain = Message.obtain();
                            messageObtain.arg1 = message.arg1;
                            messageObtain.arg2 = message.arg2;
                            messageObtain.what = 1026;
                            messageObtain.obj = new C0628ar(-1L, c0628ar.m2831c(), c0628ar.m2829a());
                            this.f2505a.f2502v.sendMessageDelayed(messageObtain, 10000L);
                            break;
                        } else {
                            this.f2505a.m2907a(message.arg1, message.arg2, message.what, c0628ar.m2829a(), c0623am.m2821b());
                            this.f2505a.f2495n.remove(Long.valueOf(c0628ar.m2830b()));
                            break;
                        }
                    } else if (iM680a2 == 21 || iM680a2 == 2 || iM680a2 == 31 || iM680a2 == 33 || iM680a2 == 25 || iM680a2 == 24 || iM680a2 == 23) {
                        AbstractC0559b abstractC0559b2 = (AbstractC0559b) c0623am.m2823d();
                        if (abstractC0559b2 == null || !abstractC0559b2.m2758a()) {
                            this.f2505a.f2495n.remove(Long.valueOf(c0628ar.m2830b()));
                            this.f2505a.m2907a(message.arg1, message.arg2, message.what, c0628ar.m2829a(), c0623am.m2821b());
                            break;
                        } else {
                            c0623am.m2824e();
                            break;
                        }
                    } else if (!c0103d2.f333a) {
                        this.f2505a.f2495n.remove(Long.valueOf(c0628ar.m2830b()));
                        this.f2505a.m2907a(message.arg1, message.arg2, message.what, c0628ar.m2829a(), c0623am.m2821b());
                        break;
                    } else if (!c0623am.m2825f()) {
                        this.f2505a.f2495n.remove(Long.valueOf(c0628ar.m2830b()));
                        this.f2505a.m2907a(message.arg1, message.arg2, message.what, c0628ar.m2829a(), c0623am.m2821b());
                        break;
                    } else {
                        c0623am.m2824e();
                        break;
                    }
                    break;
                case 4:
                case 1025:
                    C0103d c0103d3 = (C0103d) c0628ar.m2829a();
                    int iM680a3 = c0103d3.m680a();
                    if (iM680a3 == 21 || iM680a3 == 2 || iM680a3 == 31 || iM680a3 == 33 || iM680a3 == 25 || iM680a3 == 24 || iM680a3 == 23) {
                        AbstractC0559b abstractC0559b3 = (AbstractC0559b) c0623am.m2823d();
                        if (abstractC0559b3 != null && abstractC0559b3.m2758a()) {
                            c0623am.m2824e();
                            break;
                        } else {
                            if (1025 == message.what) {
                                jM2821b = c0103d3.m681b();
                            } else {
                                jM2821b = c0623am.m2821b();
                            }
                            this.f2505a.m2907a(message.arg1, message.arg2, message.what, c0628ar.m2829a(), jM2821b);
                            break;
                        }
                    } else if (iM680a3 == 2006 || iM680a3 == 3008) {
                        this.f2505a.m2947a(c0103d3.f335c, GlobalApplication.m3263d().m5922b().m5923a(), GlobalApplication.m3263d().m5922b().m5926b());
                        this.f2505a.m2930a(Long.MAX_VALUE);
                        this.f2505a.f2494l = true;
                        this.f2505a.f2499r.add(Long.valueOf(c0628ar.m2830b()));
                        Message messageObtain2 = Message.obtain();
                        messageObtain2.arg1 = message.arg1;
                        messageObtain2.arg2 = message.arg2;
                        messageObtain2.what = 1026;
                        messageObtain2.obj = new C0628ar(-1L, c0628ar.m2831c(), c0628ar.m2829a());
                        this.f2505a.f2502v.sendMessageDelayed(messageObtain2, 10000L);
                        break;
                    } else if (iM680a3 == 10000) {
                        this.f2505a.f2499r.add(Long.valueOf(c0628ar.m2830b()));
                        Message messageObtain3 = Message.obtain();
                        messageObtain3.arg1 = message.arg1;
                        messageObtain3.arg2 = message.arg2;
                        messageObtain3.what = 1026;
                        messageObtain3.obj = new C0628ar(-1L, c0628ar.m2831c(), c0628ar.m2829a());
                        this.f2505a.f2502v.sendMessageDelayed(messageObtain3, 10000L);
                        break;
                    } else if (c0103d3.f333a) {
                        if (c0623am.m2825f()) {
                            c0623am.m2824e();
                            break;
                        } else {
                            if (1025 == message.what) {
                                jM2821b3 = c0103d3.m681b();
                            } else {
                                jM2821b3 = c0623am.m2821b();
                            }
                            this.f2505a.m2907a(message.arg1, message.arg2, message.what, c0628ar.m2829a(), jM2821b3);
                            this.f2505a.f2495n.remove(Long.valueOf(c0628ar.m2830b()));
                            break;
                        }
                    } else {
                        if (1025 == message.what) {
                            jM2821b2 = c0103d3.m681b();
                        } else {
                            jM2821b2 = c0623am.m2821b();
                        }
                        this.f2505a.m2907a(message.arg1, message.arg2, message.what, c0628ar.m2829a(), jM2821b2);
                        this.f2505a.f2495n.remove(Long.valueOf(c0628ar.m2830b()));
                        break;
                    }
                    break;
                case 8:
                    C0103d c0103d4 = (C0103d) c0628ar.m2829a();
                    int iM680a4 = c0103d4.m680a();
                    if (iM680a4 == 21 || iM680a4 == 2 || iM680a4 == 31 || iM680a4 == 33 || iM680a4 == 25 || iM680a4 == 24 || iM680a4 == 23) {
                        AbstractC0559b abstractC0559b4 = (AbstractC0559b) c0623am.m2823d();
                        if (abstractC0559b4 == null || !abstractC0559b4.m2758a()) {
                            this.f2505a.m2907a(message.arg1, message.arg2, message.what, c0628ar.m2829a(), c0623am.m2821b());
                            break;
                        } else {
                            c0623am.m2824e();
                            break;
                        }
                    } else if (iM680a4 == 3003 || iM680a4 == 10000) {
                        this.f2505a.f2499r.add(Long.valueOf(c0628ar.m2830b()));
                        Message messageObtain4 = Message.obtain();
                        messageObtain4.arg1 = message.arg1;
                        messageObtain4.arg2 = message.arg2;
                        messageObtain4.what = 1026;
                        messageObtain4.obj = new C0628ar(-1L, c0628ar.m2831c(), c0628ar.m2829a());
                        this.f2505a.f2502v.sendMessageDelayed(messageObtain4, 10000L);
                        break;
                    } else if (!c0103d4.f333a) {
                        this.f2505a.m2907a(message.arg1, message.arg2, message.what, c0628ar.m2829a(), c0623am.m2821b());
                        this.f2505a.f2495n.remove(Long.valueOf(c0628ar.m2830b()));
                        break;
                    } else if (!c0623am.m2825f()) {
                        this.f2505a.m2907a(message.arg1, message.arg2, message.what, c0628ar.m2829a(), c0623am.m2821b());
                        this.f2505a.f2495n.remove(Long.valueOf(c0628ar.m2830b()));
                        break;
                    } else {
                        c0623am.m2824e();
                        break;
                    }
                    break;
                case 801:
                    C0101b c0101b = (C0101b) c0628ar.m2829a();
                    if ((c0101b.m665b() == EnumC0803m.SUCCESS || c0101b.m665b() == EnumC0803m.NO_CONTENT) && c0623am.m2825f()) {
                        c0623am.m2824e();
                        break;
                    }
                    break;
                default:
                    if (!c0623am.m2825f()) {
                        this.f2505a.m2907a(message.arg1, message.arg2, message.what, c0628ar.m2829a(), c0623am.m2821b());
                        this.f2505a.f2495n.remove(Long.valueOf(c0628ar.m2830b()));
                        break;
                    } else {
                        c0623am.m2824e();
                        break;
                    }
            }
        }
        switch (message.what) {
            case 2:
                if (((C0103d) c0628ar.m2829a()).m680a() == 3003) {
                }
                break;
            case 6:
                if (!((C0605u) c0628ar.m2829a()).f2378e) {
                    if (this.f2505a.f2494l) {
                        this.f2505a.m2955g();
                        this.f2505a.f2494l = false;
                    }
                    if (this.f2505a.f2499r.size() > 0) {
                        Iterator it = this.f2505a.f2499r.iterator();
                        while (it.hasNext()) {
                            C0623am c0623am2 = (C0623am) this.f2505a.f2495n.get(Long.valueOf(((Long) it.next()).longValue()));
                            if (c0623am2 != null) {
                                c0623am2.m2824e();
                            }
                        }
                        this.f2505a.f2499r.clear();
                    }
                }
                this.f2505a.m2907a(message.arg1, message.arg2, message.what, c0628ar.m2829a(), -1L);
                break;
            case 1026:
                if (this.f2505a.f2494l) {
                    this.f2505a.m2955g();
                    this.f2505a.f2494l = false;
                }
                if (this.f2505a.f2499r.size() > 0) {
                    Iterator it2 = this.f2505a.f2499r.iterator();
                    while (it2.hasNext()) {
                        C0623am c0623am3 = (C0623am) this.f2505a.f2495n.get(Long.valueOf(((Long) it2.next()).longValue()));
                        if (c0623am3 != null) {
                            c0623am3.m2824e();
                        }
                    }
                    this.f2505a.f2499r.clear();
                    break;
                }
                break;
            default:
                this.f2505a.m2907a(message.arg1, message.arg2, message.what, c0628ar.m2829a(), -1L);
                break;
        }
    }
}
