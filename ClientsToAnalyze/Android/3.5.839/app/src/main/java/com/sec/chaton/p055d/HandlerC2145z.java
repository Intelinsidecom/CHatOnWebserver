package com.sec.chaton.p055d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.sec.chaton.msgsend.C2684ab;
import com.sec.chaton.msgsend.C2716x;
import com.sec.chaton.msgsend.C2717y;
import com.sec.chaton.msgsend.EnumC2706n;
import com.sec.chaton.p046a.p047a.C0782f;
import com.sec.chaton.p046a.p047a.C0785i;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.p055d.p056a.AbstractC1927b;
import com.sec.chaton.p055d.p056a.C1985dd;
import com.sec.chaton.p055d.p056a.C2000ds;
import com.sec.chaton.p055d.p056a.C2019ek;
import com.sec.chaton.p055d.p056a.C2055n;
import com.sec.chaton.p063i.p064a.C2405b;
import com.sec.chaton.p067j.C2460k;
import com.sec.chaton.util.C4844bi;
import com.sec.chaton.util.C4904y;
import java.util.Iterator;
import org.json.JSONException;

/* compiled from: MessageControl2.java */
/* renamed from: com.sec.chaton.d.z */
/* loaded from: classes.dex */
class HandlerC2145z extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2142w f7773a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC2145z(C2142w c2142w, Looper looper) {
        super(looper);
        this.f7773a = c2142w;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws JSONException {
        long jM9452a;
        long jM9452a2;
        long jM9452a3;
        C2119by c2119by = (C2119by) message.obj;
        if (c2119by != null) {
            C2114bt c2114bt = (C2114bt) this.f7773a.f7763r.get(Long.valueOf(c2119by.m9464b()));
            if (c2119by.m9463a() == null) {
                this.f7773a.m9242a(message.arg1, message.arg2, message.what, c2119by.m9463a(), c2114bt.m9452a());
                this.f7773a.f7763r.remove(Long.valueOf(c2119by.m9464b()));
                if (C4904y.f17872b) {
                    C4904y.m18639b("oResult.getResultEntry() is null", "MessageControl");
                    return;
                }
                return;
            }
            C0788l c0788l = (C0788l) c2119by.m9463a();
            int iM3152g = c0788l.m3152g();
            long jM9464b = c2119by.m9464b();
            boolean z = c0788l.f2172a;
            if (c2114bt == null) {
                C2684ab.m11290a("MessageControl", " [mCONTROL_HANDLER]   (TaskContainer is NULL), gpbType(%s, %d), inboxNo(%s), msgId(%d), resultCode(%d), result(%s)", C2460k.m10659c(message.what), Integer.valueOf(message.what), this.f7773a.f7551c, Long.valueOf(jM9464b), Integer.valueOf(iM3152g), Boolean.valueOf(z));
            } else {
                C2684ab.m11290a("MessageControl", " [mCONTROL_HANDLER]   TaskContainerID(%d), gpbType(%s, %d), inboxNo(%s), msgId(%d), resultCode(%d), result(%s)", Long.valueOf(c2114bt.m9452a()), C2460k.m10659c(message.what), Integer.valueOf(message.what), this.f7773a.f7551c, Long.valueOf(jM9464b), Integer.valueOf(iM3152g), Boolean.valueOf(z));
            }
            if (c2114bt != null) {
                C0788l c0788l2 = (C0788l) c2119by.m9463a();
                C2405b c2405b = new C2405b();
                c2405b.m19139c(String.format("%04d%04d", Integer.valueOf(message.what), Integer.valueOf(c0788l2.m3152g())));
                c2405b.m10432a(String.valueOf(c2119by.m9464b()));
                Log.wtf("CH", c2405b.toString());
                switch (message.what) {
                    case 0:
                    case 106:
                        C0788l c0788l3 = (C0788l) c2119by.m9463a();
                        int iM3152g2 = c0788l3.m3152g();
                        if (iM3152g2 == 21 || iM3152g2 == 2 || iM3152g2 == 31 || iM3152g2 == 33 || iM3152g2 == 35 || iM3152g2 == 25 || iM3152g2 == 24 || iM3152g2 == 23) {
                            AbstractC1927b abstractC1927b = (AbstractC1927b) c2114bt.m9456c();
                            if (abstractC1927b != null && abstractC1927b.mo9104a()) {
                                c2114bt.m9457d();
                                break;
                            } else {
                                if (106 == message.what) {
                                    jM9452a = c0788l3.m3153h();
                                } else {
                                    jM9452a = c2114bt.m9452a();
                                }
                                this.f7773a.m9242a(message.arg1, message.arg2, message.what, c2119by.m9463a(), jM9452a);
                                this.f7773a.f7763r.remove(Long.valueOf(c2119by.m9464b()));
                                this.f7773a.m9609c(false);
                                break;
                            }
                        } else if (c0788l3.f2172a) {
                            if (c2114bt.m9458e()) {
                                c2114bt.m9459f();
                                c2114bt.m9457d();
                                break;
                            } else {
                                if (106 == message.what) {
                                    jM9452a3 = c0788l3.m3153h();
                                } else {
                                    jM9452a3 = c2114bt.m9452a();
                                }
                                synchronized (this.f7773a.f7756j) {
                                    if (c0788l3 instanceof C1985dd) {
                                        this.f7773a.f7766u = ((C1985dd) c0788l3).m9136a();
                                    } else if (c0788l3 instanceof C2000ds) {
                                        this.f7773a.f7766u = ((C2000ds) c0788l3).f7352d;
                                    }
                                }
                                this.f7773a.m9242a(message.arg1, message.arg2, message.what, c2119by.m9463a(), jM9452a3);
                                this.f7773a.f7763r.remove(Long.valueOf(c2119by.m9464b()));
                                this.f7773a.m9609c(true);
                                break;
                            }
                        } else {
                            if (106 == message.what) {
                                jM9452a2 = c0788l3.m3153h();
                            } else {
                                jM9452a2 = c2114bt.m9452a();
                            }
                            this.f7773a.m9242a(message.arg1, message.arg2, message.what, c2119by.m9463a(), jM9452a2);
                            this.f7773a.f7763r.remove(Long.valueOf(c2119by.m9464b()));
                            this.f7773a.m9609c(false);
                            break;
                        }
                        break;
                    case 2:
                        this.f7773a.f7762p = false;
                        C0788l c0788l4 = (C0788l) c2119by.m9463a();
                        int iM3152g3 = c0788l4.m3152g();
                        if (iM3152g3 == 2006 || iM3152g3 == 3008) {
                            this.f7773a.mo9252a(c0788l4.f2174c, C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b());
                            this.f7773a.mo9243a(Long.MAX_VALUE);
                            C4904y.m18639b("inboxNO : " + c0788l4.f2174c, getClass().getSimpleName());
                            this.f7773a.f7760n = true;
                            if (c2114bt.m9458e()) {
                                c2114bt.m9459f();
                                this.f7773a.f7768w.add(Long.valueOf(c2119by.m9464b()));
                                m9659a(message);
                                break;
                            } else {
                                this.f7773a.m9242a(message.arg1, message.arg2, message.what, c2119by.m9463a(), c2114bt.m9452a());
                                this.f7773a.f7763r.remove(Long.valueOf(c2119by.m9464b()));
                                break;
                            }
                        } else if (iM3152g3 == 21 || iM3152g3 == 2 || iM3152g3 == 31 || iM3152g3 == 33 || iM3152g3 == 25 || iM3152g3 == 24 || iM3152g3 == 23 || iM3152g3 == 7002 || iM3152g3 == 7003 || iM3152g3 == 35) {
                            AbstractC1927b abstractC1927b2 = (AbstractC1927b) c2114bt.m9456c();
                            if (abstractC1927b2 == null || !abstractC1927b2.mo9104a()) {
                                this.f7773a.f7763r.remove(Long.valueOf(c2119by.m9464b()));
                                this.f7773a.m9242a(message.arg1, message.arg2, message.what, c2119by.m9463a(), c2114bt.m9452a());
                                break;
                            } else {
                                c2114bt.m9457d();
                                break;
                            }
                        } else {
                            m9660a(message, c2114bt);
                            break;
                        }
                        break;
                    case 4:
                    case 102:
                        C0788l c0788l5 = (C0788l) c2119by.m9463a();
                        int iM3152g4 = c0788l5.m3152g();
                        if (iM3152g4 == 21 || iM3152g4 == 2 || iM3152g4 == 31 || iM3152g4 == 33 || iM3152g4 == 25 || iM3152g4 == 24 || iM3152g4 == 23 || iM3152g4 == 26 || iM3152g4 == 7002 || iM3152g4 == 7003 || iM3152g4 == 35) {
                            AbstractC1927b abstractC1927b3 = (AbstractC1927b) c2114bt.m9456c();
                            EnumC2706n enumC2706nM9193c = EnumC2706n.f9699d;
                            if (abstractC1927b3 instanceof C2055n) {
                                enumC2706nM9193c = ((C2055n) abstractC1927b3).m9193c();
                            }
                            if (abstractC1927b3 != null && ((enumC2706nM9193c.m11326a() || !C2717y.m11398b()) && (abstractC1927b3.mo9104a() || iM3152g4 == 26 || iM3152g4 == 7002 || iM3152g4 == 7003))) {
                                c2114bt.m9457d();
                                break;
                            } else {
                                m9661b(message, c2114bt);
                                break;
                            }
                        } else if (iM3152g4 == 2006 || iM3152g4 == 3008) {
                            this.f7773a.mo9252a(c0788l5.f2174c, C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b());
                            this.f7773a.mo9243a(Long.MAX_VALUE);
                            this.f7773a.f7760n = true;
                            this.f7773a.f7768w.add(Long.valueOf(c2119by.m9464b()));
                            m9659a(message);
                            break;
                        } else if (iM3152g4 == 900) {
                            this.f7773a.f7768w.add(Long.valueOf(c2119by.m9464b()));
                            m9659a(message);
                            break;
                        } else {
                            if (6002 == iM3152g4) {
                                new C2128i(new Handler()).m9495a();
                            }
                            if (c0788l5.f2172a && c2114bt.m9458e()) {
                                c2114bt.m9459f();
                                c2114bt.m9457d();
                                break;
                            } else {
                                m9661b(message, c2114bt);
                                break;
                            }
                        }
                        break;
                    case 8:
                        int iM3152g5 = ((C0788l) c2119by.m9463a()).m3152g();
                        if (iM3152g5 == 21 || iM3152g5 == 2 || iM3152g5 == 31 || iM3152g5 == 33 || iM3152g5 == 25 || iM3152g5 == 24 || iM3152g5 == 23 || iM3152g5 == 35) {
                            AbstractC1927b abstractC1927b4 = (AbstractC1927b) c2114bt.m9456c();
                            if (abstractC1927b4 != null && abstractC1927b4.mo9104a()) {
                                c2114bt.m9457d();
                                break;
                            } else {
                                this.f7773a.m9242a(message.arg1, message.arg2, message.what, c2119by.m9463a(), c2114bt.m9452a());
                                this.f7773a.f7763r.remove(Long.valueOf(c2119by.m9464b()));
                                break;
                            }
                        } else if (iM3152g5 == 3003 || iM3152g5 == 10000) {
                            this.f7773a.f7768w.add(Long.valueOf(c2119by.m9464b()));
                            m9659a(message);
                            break;
                        } else {
                            m9660a(message, c2114bt);
                            break;
                        }
                        break;
                    case 12:
                    case 31:
                    case 38:
                    case 42:
                    case 44:
                        int iM3152g6 = ((C0788l) c2119by.m9463a()).m3152g();
                        if (iM3152g6 == 21 || iM3152g6 == 2 || iM3152g6 == 31 || iM3152g6 == 33 || iM3152g6 == 25 || iM3152g6 == 24 || iM3152g6 == 23 || iM3152g6 == 7002 || iM3152g6 == 7003 || iM3152g6 == 7006 || iM3152g6 == 35) {
                            AbstractC1927b abstractC1927b5 = (AbstractC1927b) c2114bt.m9456c();
                            if (abstractC1927b5 != null && abstractC1927b5.mo9104a()) {
                                c2114bt.m9457d();
                                break;
                            } else {
                                this.f7773a.m9242a(message.arg1, message.arg2, message.what, c2119by.m9463a(), c2114bt.m9452a());
                                this.f7773a.f7763r.remove(Long.valueOf(c2119by.m9464b()));
                                break;
                            }
                        } else {
                            m9660a(message, c2114bt);
                            break;
                        }
                        break;
                    case 107:
                        this.f7773a.m9242a(message.arg1, message.arg2, message.what, c2119by.m9463a(), c2114bt.m9452a());
                        break;
                    default:
                        if (c2114bt.m9458e()) {
                            c2114bt.m9459f();
                            c2114bt.m9457d();
                            break;
                        } else {
                            this.f7773a.m9242a(message.arg1, message.arg2, message.what, c2119by.m9463a(), c2114bt.m9452a());
                            this.f7773a.f7763r.remove(Long.valueOf(c2119by.m9464b()));
                            break;
                        }
                }
            } else {
                switch (message.what) {
                    case 2:
                        if (((C0788l) c2119by.m9463a()).m3152g() == 3003) {
                        }
                        break;
                    case 6:
                        if (!((C0782f) c2119by.m9463a()).m3117a()) {
                            if (this.f7773a.f7760n) {
                                this.f7773a.mo9278f();
                                this.f7773a.f7760n = false;
                            }
                            if (this.f7773a.f7768w.size() > 0) {
                                Iterator it = this.f7773a.f7768w.iterator();
                                while (it.hasNext()) {
                                    C2114bt c2114bt2 = (C2114bt) this.f7773a.f7763r.get(Long.valueOf(((Long) it.next()).longValue()));
                                    if (c2114bt2 != null) {
                                        c2114bt2.m9457d();
                                    }
                                }
                                this.f7773a.f7768w.clear();
                            }
                        }
                        this.f7773a.m9242a(message.arg1, message.arg2, message.what, c2119by.m9463a(), -1L);
                        break;
                    case 36:
                        if (!((C0785i) c2119by.m9463a()).m3135a()) {
                            if (this.f7773a.f7760n) {
                                this.f7773a.mo9278f();
                                this.f7773a.f7760n = false;
                            }
                            if (this.f7773a.f7768w.size() > 0) {
                                Iterator it2 = this.f7773a.f7768w.iterator();
                                while (it2.hasNext()) {
                                    C2114bt c2114bt3 = (C2114bt) this.f7773a.f7763r.get(Long.valueOf(((Long) it2.next()).longValue()));
                                    if (c2114bt3 != null) {
                                        c2114bt3.m9457d();
                                    }
                                }
                                this.f7773a.f7768w.clear();
                            }
                        }
                        this.f7773a.m9242a(message.arg1, message.arg2, message.what, c2119by.m9463a(), -1L);
                        break;
                    case 103:
                        if (this.f7773a.f7760n) {
                            this.f7773a.mo9278f();
                            this.f7773a.f7760n = false;
                        }
                        if (this.f7773a.f7768w.size() > 0) {
                            Iterator it3 = this.f7773a.f7768w.iterator();
                            while (it3.hasNext()) {
                                C2114bt c2114bt4 = (C2114bt) this.f7773a.f7763r.get(Long.valueOf(((Long) it3.next()).longValue()));
                                if (c2114bt4 != null) {
                                    c2114bt4.m9457d();
                                }
                            }
                            this.f7773a.f7768w.clear();
                            break;
                        }
                        break;
                    case 104:
                    case 107:
                        this.f7773a.m9242a(message.arg1, message.arg2, message.what, c2119by.m9463a(), -1L);
                        break;
                    default:
                        this.f7773a.m9242a(message.arg1, message.arg2, message.what, c2119by.m9463a(), -1L);
                        this.f7773a.f7763r.remove(Long.valueOf(c2119by.m9464b()));
                        break;
                }
            }
            C2716x.m11371a(message.what, this.f7773a.f7551c, c2119by, c2114bt != null);
        }
    }

    /* renamed from: a */
    private void m9659a(Message message) {
        C2119by c2119by = (C2119by) message.obj;
        Message messageObtain = Message.obtain();
        messageObtain.arg1 = message.arg1;
        messageObtain.arg2 = message.arg2;
        messageObtain.what = 103;
        messageObtain.obj = new C2119by(-1L, c2119by.m9465c(), c2119by.m9463a());
        this.f7773a.f7752C.sendMessageDelayed(messageObtain, 10000L);
    }

    /* renamed from: a */
    private void m9660a(Message message, C2114bt c2114bt) {
        C2119by c2119by = (C2119by) message.obj;
        if (((C0788l) c2119by.m9463a()).f2172a) {
            if (c2114bt.m9458e()) {
                c2114bt.m9459f();
                c2114bt.m9457d();
                return;
            } else {
                this.f7773a.m9242a(message.arg1, message.arg2, message.what, c2119by.m9463a(), c2114bt.m9452a());
                this.f7773a.f7763r.remove(Long.valueOf(c2119by.m9464b()));
                return;
            }
        }
        this.f7773a.m9242a(message.arg1, message.arg2, message.what, c2119by.m9463a(), c2114bt.m9452a());
        this.f7773a.f7763r.remove(Long.valueOf(c2119by.m9464b()));
    }

    /* renamed from: b */
    private void m9661b(Message message, C2114bt c2114bt) {
        long jM9452a;
        C2119by c2119by = (C2119by) message.obj;
        C0788l c0788l = (C0788l) c2119by.m9463a();
        if (102 == message.what) {
            jM9452a = c0788l.m3153h();
        } else {
            jM9452a = c2114bt.m9452a();
        }
        this.f7773a.m9242a(message.arg1, message.arg2, message.what, c2119by.m9463a(), jM9452a);
        Object objM9456c = ((C2114bt) this.f7773a.f7763r.get(Long.valueOf(c2119by.m9464b()))).m9456c();
        if (!(objM9456c instanceof C2019ek)) {
            this.f7773a.f7763r.remove(Long.valueOf(c2119by.m9464b()));
            return;
        }
        if (((C2019ek) objM9456c).m9157a(c0788l.m3153h()) <= 0) {
            this.f7773a.f7763r.remove(Long.valueOf(c2119by.m9464b()));
        }
    }
}
