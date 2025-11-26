package com.sec.chaton.p025d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.sec.chaton.R;
import com.sec.chaton.msgsend.C1756p;
import com.sec.chaton.msgsend.C1757q;
import com.sec.chaton.msgsend.C1759s;
import com.sec.chaton.msgsend.EnumC1751k;
import com.sec.chaton.p016a.p017a.C0265b;
import com.sec.chaton.p016a.p017a.C0272i;
import com.sec.chaton.p025d.p026a.AbstractC1199c;
import com.sec.chaton.p025d.p026a.C1221cv;
import com.sec.chaton.p025d.p026a.C1230dd;
import com.sec.chaton.p025d.p026a.C1240dn;
import com.sec.chaton.p025d.p026a.C1280s;
import com.sec.chaton.p033i.p034a.C1534c;
import com.sec.chaton.p037j.C1579g;
import com.sec.chaton.util.C3194bi;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.log.collector.C3358h;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

/* compiled from: MessageControl2.java */
/* renamed from: com.sec.chaton.d.r */
/* loaded from: classes.dex */
class HandlerC1340r extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1337o f5064a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC1340r(C1337o c1337o, Looper looper) {
        super(looper);
        this.f5064a = c1337o;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws UnsupportedEncodingException {
        long jM5678a;
        long jM5678a2;
        long jM5678a3;
        long jM5678a4;
        long jM5678a5;
        long jM5678a6;
        C1323bi c1323bi = (C1323bi) message.obj;
        if (c1323bi != null) {
            C1318bd c1318bd = (C1318bd) this.f5064a.f5052p.get(Long.valueOf(c1323bi.m5690b()));
            if (c1323bi.m5689a() == null) {
                this.f5064a.m5799a(message.arg1, message.arg2, message.what, c1323bi.m5689a(), c1318bd.m5678a());
                this.f5064a.f5052p.remove(Long.valueOf(c1323bi.m5690b()));
                if (C3250y.f11734b) {
                    C3250y.m11450b("oResult.getResultEntry() is null", "MessageControl");
                    return;
                }
                return;
            }
            C0272i c0272i = (C0272i) c1323bi.m5689a();
            int iM1365f = c0272i.m1365f();
            long jM5690b = c1323bi.m5690b();
            boolean z = c0272i.f858a;
            if (c1318bd == null) {
                C1759s.m7260a("MessageControl", " [mCONTROL_HANDLER]   (TaskContainer is NULL), gpbType(%s, %d), inboxNo(%s), msgId(%d), resultCode(%d), result(%s)", C1579g.m6697c(message.what), Integer.valueOf(message.what), this.f5064a.f5046i, Long.valueOf(jM5690b), Integer.valueOf(iM1365f), Boolean.valueOf(z));
            } else {
                C1759s.m7260a("MessageControl", " [mCONTROL_HANDLER]   TaskContainerID(%d), gpbType(%s, %d), inboxNo(%s), msgId(%d), resultCode(%d), result(%s)", Long.valueOf(c1318bd.m5678a()), C1579g.m6697c(message.what), Integer.valueOf(message.what), this.f5064a.f5046i, Long.valueOf(jM5690b), Integer.valueOf(iM1365f), Boolean.valueOf(z));
            }
            if (c1318bd != null) {
                C0272i c0272i2 = (C0272i) c1323bi.m5689a();
                C1534c c1534c = new C1534c();
                c1534c.m11829d(String.format("%04d%04d", Integer.valueOf(message.what), Integer.valueOf(c0272i2.m1365f())));
                c1534c.m6525a(String.valueOf(c1323bi.m5690b()));
                if (!c0272i2.f858a && CommonApplication.m11493l().getResources().getBoolean(R.bool.log_collector)) {
                    C3358h.m11842a().m11845a(c1534c);
                }
                Log.wtf("CH", c1534c.toString());
                switch (message.what) {
                    case 0:
                    case 106:
                        C0272i c0272i3 = (C0272i) c1323bi.m5689a();
                        int iM1365f2 = c0272i3.m1365f();
                        if (iM1365f2 == 21 || iM1365f2 == 2 || iM1365f2 == 31 || iM1365f2 == 33 || iM1365f2 == 25 || iM1365f2 == 24 || iM1365f2 == 23) {
                            AbstractC1199c abstractC1199c = (AbstractC1199c) c1318bd.m5682c();
                            if (abstractC1199c != null && abstractC1199c.mo5503a()) {
                                c1318bd.m5683d();
                                break;
                            } else {
                                if (106 == message.what) {
                                    jM5678a4 = c0272i3.m1366g();
                                } else {
                                    jM5678a4 = c1318bd.m5678a();
                                }
                                this.f5064a.m5799a(message.arg1, message.arg2, message.what, c1323bi.m5689a(), jM5678a4);
                                this.f5064a.f5052p.remove(Long.valueOf(c1323bi.m5690b()));
                                this.f5064a.m5811c(false);
                                break;
                            }
                        } else if (c0272i3.f858a) {
                            if (c1318bd.m5684e()) {
                                c1318bd.m5685f();
                                c1318bd.m5683d();
                                break;
                            } else {
                                if (106 == message.what) {
                                    jM5678a6 = c0272i3.m1366g();
                                } else {
                                    jM5678a6 = c1318bd.m5678a();
                                }
                                synchronized (this.f5064a.f5042e) {
                                    if (c0272i3 instanceof C1221cv) {
                                        this.f5064a.f5055s = ((C1221cv) c0272i3).m5550a();
                                    } else if (c0272i3 instanceof C1230dd) {
                                        this.f5064a.f5055s = ((C1230dd) c0272i3).f4766d;
                                    }
                                }
                                this.f5064a.m5799a(message.arg1, message.arg2, message.what, c1323bi.m5689a(), jM5678a6);
                                this.f5064a.f5052p.remove(Long.valueOf(c1323bi.m5690b()));
                                this.f5064a.m5811c(true);
                                break;
                            }
                        } else {
                            if (106 == message.what) {
                                jM5678a5 = c0272i3.m1366g();
                            } else {
                                jM5678a5 = c1318bd.m5678a();
                            }
                            this.f5064a.m5799a(message.arg1, message.arg2, message.what, c1323bi.m5689a(), jM5678a5);
                            this.f5064a.f5052p.remove(Long.valueOf(c1323bi.m5690b()));
                            this.f5064a.m5811c(false);
                            break;
                        }
                        break;
                    case 2:
                        C0272i c0272i4 = (C0272i) c1323bi.m5689a();
                        int iM1365f3 = c0272i4.m1365f();
                        if (iM1365f3 == 2006 || iM1365f3 == 3008) {
                            this.f5064a.m5880a(c0272i4.f860c, C3194bi.m11149a().m11154c().m11155a(), C3194bi.m11149a().m11154c().m11158b());
                            this.f5064a.m5893c(Long.MAX_VALUE);
                            C3250y.m11450b("inboxNO : " + c0272i4.f860c, getClass().getSimpleName());
                            this.f5064a.f5050m = true;
                            if (!c1318bd.m5684e()) {
                                this.f5064a.m5799a(message.arg1, message.arg2, message.what, c1323bi.m5689a(), c1318bd.m5678a());
                                this.f5064a.f5052p.remove(Long.valueOf(c1323bi.m5690b()));
                                break;
                            } else {
                                c1318bd.m5685f();
                                this.f5064a.f5058v.add(Long.valueOf(c1323bi.m5690b()));
                                Message messageObtain = Message.obtain();
                                messageObtain.arg1 = message.arg1;
                                messageObtain.arg2 = message.arg2;
                                messageObtain.what = 103;
                                messageObtain.obj = new C1323bi(-1L, c1323bi.m5691c(), c1323bi.m5689a());
                                this.f5064a.f5038A.sendMessageDelayed(messageObtain, 10000L);
                                break;
                            }
                        } else if (iM1365f3 == 21 || iM1365f3 == 2 || iM1365f3 == 31 || iM1365f3 == 33 || iM1365f3 == 25 || iM1365f3 == 24 || iM1365f3 == 23 || iM1365f3 == 7002 || iM1365f3 == 7003) {
                            AbstractC1199c abstractC1199c2 = (AbstractC1199c) c1318bd.m5682c();
                            if (abstractC1199c2 == null || !abstractC1199c2.mo5503a()) {
                                this.f5064a.f5052p.remove(Long.valueOf(c1323bi.m5690b()));
                                this.f5064a.m5799a(message.arg1, message.arg2, message.what, c1323bi.m5689a(), c1318bd.m5678a());
                                break;
                            } else {
                                c1318bd.m5683d();
                                break;
                            }
                        } else if (!c0272i4.f858a || !c1318bd.m5684e()) {
                            this.f5064a.f5052p.remove(Long.valueOf(c1323bi.m5690b()));
                            this.f5064a.m5799a(message.arg1, message.arg2, message.what, c1323bi.m5689a(), c1318bd.m5678a());
                            break;
                        } else {
                            c1318bd.m5685f();
                            c1318bd.m5683d();
                            break;
                        }
                        break;
                    case 4:
                    case 102:
                        C0272i c0272i5 = (C0272i) c1323bi.m5689a();
                        int iM1365f4 = c0272i5.m1365f();
                        if (iM1365f4 == 21 || iM1365f4 == 2 || iM1365f4 == 31 || iM1365f4 == 33 || iM1365f4 == 25 || iM1365f4 == 24 || iM1365f4 == 23 || iM1365f4 == 26 || iM1365f4 == 7002 || iM1365f4 == 7003) {
                            AbstractC1199c abstractC1199c3 = (AbstractC1199c) c1318bd.m5682c();
                            EnumC1751k enumC1751kM5584c = EnumC1751k.f6455d;
                            if (abstractC1199c3 instanceof C1280s) {
                                enumC1751kM5584c = ((C1280s) abstractC1199c3).m5584c();
                            }
                            if (abstractC1199c3 != null && ((enumC1751kM5584c.m7198a() || !C1757q.m7251b()) && (abstractC1199c3.mo5503a() || iM1365f4 == 26 || iM1365f4 == 7002 || iM1365f4 == 7003))) {
                                c1318bd.m5683d();
                                break;
                            } else {
                                if (102 == message.what) {
                                    jM5678a = c0272i5.m1366g();
                                } else {
                                    jM5678a = c1318bd.m5678a();
                                }
                                this.f5064a.m5799a(message.arg1, message.arg2, message.what, c1323bi.m5689a(), jM5678a);
                                Object objM5682c = ((C1318bd) this.f5064a.f5052p.get(Long.valueOf(c1323bi.m5690b()))).m5682c();
                                if (!(objM5682c instanceof C1240dn) || ((C1240dn) objM5682c).m5560a(c0272i5.m1366g()) <= 0) {
                                    this.f5064a.f5052p.remove(Long.valueOf(c1323bi.m5690b()));
                                    break;
                                }
                            }
                        } else if (iM1365f4 == 2006 || iM1365f4 == 3008) {
                            this.f5064a.m5880a(c0272i5.f860c, C3194bi.m11149a().m11154c().m11155a(), C3194bi.m11149a().m11154c().m11158b());
                            this.f5064a.m5893c(Long.MAX_VALUE);
                            this.f5064a.f5050m = true;
                            this.f5064a.f5058v.add(Long.valueOf(c1323bi.m5690b()));
                            Message messageObtain2 = Message.obtain();
                            messageObtain2.arg1 = message.arg1;
                            messageObtain2.arg2 = message.arg2;
                            messageObtain2.what = 103;
                            messageObtain2.obj = new C1323bi(-1L, c1323bi.m5691c(), c1323bi.m5689a());
                            this.f5064a.f5038A.sendMessageDelayed(messageObtain2, 10000L);
                            break;
                        } else if (iM1365f4 == 900) {
                            this.f5064a.f5058v.add(Long.valueOf(c1323bi.m5690b()));
                            Message messageObtain3 = Message.obtain();
                            messageObtain3.arg1 = message.arg1;
                            messageObtain3.arg2 = message.arg2;
                            messageObtain3.what = 103;
                            messageObtain3.obj = new C1323bi(-1L, c1323bi.m5691c(), c1323bi.m5689a());
                            this.f5064a.f5038A.sendMessageDelayed(messageObtain3, 10000L);
                            break;
                        } else {
                            if (6002 == iM1365f4) {
                                new C1330h(new Handler()).m5717a();
                            }
                            if (c0272i5.f858a) {
                                if (c1318bd.m5684e()) {
                                    c1318bd.m5685f();
                                    c1318bd.m5683d();
                                    break;
                                } else {
                                    if (102 == message.what) {
                                        jM5678a3 = c0272i5.m1366g();
                                    } else {
                                        jM5678a3 = c1318bd.m5678a();
                                    }
                                    this.f5064a.m5799a(message.arg1, message.arg2, message.what, c1323bi.m5689a(), jM5678a3);
                                    Object objM5682c2 = ((C1318bd) this.f5064a.f5052p.get(Long.valueOf(c1323bi.m5690b()))).m5682c();
                                    if (!(objM5682c2 instanceof C1240dn) || ((C1240dn) objM5682c2).m5560a(c0272i5.m1366g()) <= 0) {
                                        this.f5064a.f5052p.remove(Long.valueOf(c1323bi.m5690b()));
                                        break;
                                    }
                                }
                            } else {
                                if (102 == message.what) {
                                    jM5678a2 = c0272i5.m1366g();
                                } else {
                                    jM5678a2 = c1318bd.m5678a();
                                }
                                this.f5064a.m5799a(message.arg1, message.arg2, message.what, c1323bi.m5689a(), jM5678a2);
                                Object objM5682c3 = ((C1318bd) this.f5064a.f5052p.get(Long.valueOf(c1323bi.m5690b()))).m5682c();
                                if (!(objM5682c3 instanceof C1240dn) || ((C1240dn) objM5682c3).m5560a(c0272i5.m1366g()) <= 0) {
                                    this.f5064a.f5052p.remove(Long.valueOf(c1323bi.m5690b()));
                                    break;
                                }
                            }
                        }
                        break;
                    case 8:
                        C0272i c0272i6 = (C0272i) c1323bi.m5689a();
                        int iM1365f5 = c0272i6.m1365f();
                        if (iM1365f5 == 21 || iM1365f5 == 2 || iM1365f5 == 31 || iM1365f5 == 33 || iM1365f5 == 25 || iM1365f5 == 24 || iM1365f5 == 23) {
                            AbstractC1199c abstractC1199c4 = (AbstractC1199c) c1318bd.m5682c();
                            if (abstractC1199c4 == null || !abstractC1199c4.mo5503a()) {
                                this.f5064a.m5799a(message.arg1, message.arg2, message.what, c1323bi.m5689a(), c1318bd.m5678a());
                                this.f5064a.f5052p.remove(Long.valueOf(c1323bi.m5690b()));
                                break;
                            } else {
                                c1318bd.m5683d();
                                break;
                            }
                        } else if (iM1365f5 == 3003 || iM1365f5 == 10000) {
                            this.f5064a.f5058v.add(Long.valueOf(c1323bi.m5690b()));
                            Message messageObtain4 = Message.obtain();
                            messageObtain4.arg1 = message.arg1;
                            messageObtain4.arg2 = message.arg2;
                            messageObtain4.what = 103;
                            messageObtain4.obj = new C1323bi(-1L, c1323bi.m5691c(), c1323bi.m5689a());
                            this.f5064a.f5038A.sendMessageDelayed(messageObtain4, 10000L);
                            break;
                        } else if (!c0272i6.f858a || !c1318bd.m5684e()) {
                            this.f5064a.m5799a(message.arg1, message.arg2, message.what, c1323bi.m5689a(), c1318bd.m5678a());
                            this.f5064a.f5052p.remove(Long.valueOf(c1323bi.m5690b()));
                            break;
                        } else {
                            c1318bd.m5685f();
                            c1318bd.m5683d();
                            break;
                        }
                        break;
                    case 12:
                    case 31:
                        C0272i c0272i7 = (C0272i) c1323bi.m5689a();
                        int iM1365f6 = c0272i7.m1365f();
                        if (iM1365f6 == 21 || iM1365f6 == 2 || iM1365f6 == 31 || iM1365f6 == 33 || iM1365f6 == 25 || iM1365f6 == 24 || iM1365f6 == 23 || iM1365f6 == 7002 || iM1365f6 == 7003 || iM1365f6 == 7006) {
                            AbstractC1199c abstractC1199c5 = (AbstractC1199c) c1318bd.m5682c();
                            if (abstractC1199c5 == null || !abstractC1199c5.mo5503a()) {
                                this.f5064a.m5799a(message.arg1, message.arg2, message.what, c1323bi.m5689a(), c1318bd.m5678a());
                                this.f5064a.f5052p.remove(Long.valueOf(c1323bi.m5690b()));
                                break;
                            } else {
                                c1318bd.m5683d();
                                break;
                            }
                        } else if (!c0272i7.f858a || !c1318bd.m5684e()) {
                            this.f5064a.m5799a(message.arg1, message.arg2, message.what, c1323bi.m5689a(), c1318bd.m5678a());
                            this.f5064a.f5052p.remove(Long.valueOf(c1323bi.m5690b()));
                            break;
                        } else {
                            c1318bd.m5685f();
                            c1318bd.m5683d();
                            break;
                        }
                        break;
                    case 107:
                        this.f5064a.m5799a(message.arg1, message.arg2, message.what, c1323bi.m5689a(), c1318bd.m5678a());
                        break;
                    default:
                        if (!c1318bd.m5684e()) {
                            this.f5064a.m5799a(message.arg1, message.arg2, message.what, c1323bi.m5689a(), c1318bd.m5678a());
                            this.f5064a.f5052p.remove(Long.valueOf(c1323bi.m5690b()));
                            break;
                        } else {
                            c1318bd.m5685f();
                            c1318bd.m5683d();
                            break;
                        }
                }
            } else {
                switch (message.what) {
                    case 2:
                        if (((C0272i) c1323bi.m5689a()).m1365f() == 3003) {
                        }
                        break;
                    case 6:
                        if (!((C0265b) c1323bi.m5689a()).m1333a()) {
                            if (this.f5064a.f5050m) {
                                this.f5064a.m5902k();
                                this.f5064a.f5050m = false;
                            }
                            if (this.f5064a.f5058v.size() > 0) {
                                Iterator it = this.f5064a.f5058v.iterator();
                                while (it.hasNext()) {
                                    C1318bd c1318bd2 = (C1318bd) this.f5064a.f5052p.get(Long.valueOf(((Long) it.next()).longValue()));
                                    if (c1318bd2 != null) {
                                        c1318bd2.m5683d();
                                    }
                                }
                                this.f5064a.f5058v.clear();
                            }
                        }
                        this.f5064a.m5799a(message.arg1, message.arg2, message.what, c1323bi.m5689a(), -1L);
                        break;
                    case 103:
                        if (this.f5064a.f5050m) {
                            this.f5064a.m5902k();
                            this.f5064a.f5050m = false;
                        }
                        if (this.f5064a.f5058v.size() > 0) {
                            Iterator it2 = this.f5064a.f5058v.iterator();
                            while (it2.hasNext()) {
                                C1318bd c1318bd3 = (C1318bd) this.f5064a.f5052p.get(Long.valueOf(((Long) it2.next()).longValue()));
                                if (c1318bd3 != null) {
                                    c1318bd3.m5683d();
                                }
                            }
                            this.f5064a.f5058v.clear();
                            break;
                        }
                        break;
                    case 104:
                    case 107:
                        this.f5064a.m5799a(message.arg1, message.arg2, message.what, c1323bi.m5689a(), -1L);
                        break;
                    default:
                        this.f5064a.m5799a(message.arg1, message.arg2, message.what, c1323bi.m5689a(), -1L);
                        this.f5064a.f5052p.remove(Long.valueOf(c1323bi.m5690b()));
                        break;
                }
            }
            C1756p.m7227a(message.what, this.f5064a.f5046i, c1323bi, c1318bd != null);
        }
    }
}
