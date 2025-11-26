package com.sec.chaton.chat;

import android.content.ContentValues;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1067bg;
import com.sec.chaton.ExitAppDialogActivity;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.C2684ab;
import com.sec.chaton.p046a.C0892ds;
import com.sec.chaton.p046a.C0919es;
import com.sec.chaton.p046a.C0925ey;
import com.sec.chaton.p046a.p047a.C0777a;
import com.sec.chaton.p046a.p047a.C0782f;
import com.sec.chaton.p046a.p047a.C0785i;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.p046a.p047a.EnumC0789m;
import com.sec.chaton.p055d.p056a.C1985dd;
import com.sec.chaton.p055d.p056a.C1990di;
import com.sec.chaton.p055d.p056a.C2000ds;
import com.sec.chaton.p055d.p056a.C2009ea;
import com.sec.chaton.p057e.C2220ah;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.EnumC2231as;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.p067j.C2466q;
import com.sec.chaton.p067j.p070c.RunnableC2440g;
import com.sec.chaton.util.C4844bi;
import com.sec.chaton.util.C4855bt;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.spp.push.Config;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bs */
/* loaded from: classes.dex */
class HandlerC1611bs extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6128a;

    HandlerC1611bs(ChatFragment chatFragment) {
        this.f6128a = chatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        boolean z;
        C0919es c0919es;
        ArrayList<String> arrayList;
        ArrayList<String> arrayList2;
        boolean z2 = this.f6128a.f5753y;
        if (this.f6128a.f5624cN != null) {
            if (message.what == 9000) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("resultEntry is null", ChatFragment.f5461a);
                }
                this.f6128a.m8274s();
                return;
            }
            C0788l c0788l = (C0788l) ((C1770hp) message.obj).m8779a();
            if (c0788l == null) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("resultEntry is null", ChatFragment.f5461a);
                    return;
                }
                return;
            }
            C2684ab.m11290a(ChatFragment.f5461a, "ChatFragment, mUIHandler(), GpbType(%d), ResultCode(%d), CheckError(%s)", Integer.valueOf(message.what), Integer.valueOf(c0788l.m3152g()), C1736gi.m8627a(message.what, c0788l.m3152g()));
            if (C1736gi.m8627a(message.what, c0788l.m3152g()) == EnumC0789m.END_APP) {
                if (!ExitAppDialogActivity.m2892a()) {
                    ExitAppDialogActivity.m2894b();
                    return;
                }
                return;
            }
            if (C1736gi.m8627a(message.what, c0788l.m3152g()) == EnumC0789m.RESTART_APP) {
                AbstractC4932a abstractC4932aM8217a = this.f6128a.m8217a(EnumC0789m.RESTART_APP);
                if (abstractC4932aM8217a != null) {
                    abstractC4932aM8217a.mo18745a().show();
                }
            } else if (C1736gi.m8627a(message.what, c0788l.m3152g()) == EnumC0789m.RESET_BY_WEB) {
                C0991aa.m6037a().m18962d(new C1067bg(2));
                return;
            }
            if (c0788l.f2172a) {
                z = true;
            } else {
                int iM3152g = c0788l.m3152g();
                if ((iM3152g == 24 || iM3152g == 23 || iM3152g == 21) && this.f6128a.f5531aX != null) {
                    this.f6128a.f5531aX.mo9274d();
                    this.f6128a.f5531aX.mo9252a(this.f6128a.f5750v, C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b());
                }
                z = false;
            }
            switch (message.what) {
                case 0:
                case 106:
                    if (z) {
                        this.f6128a.f5753y = true;
                    } else {
                        this.f6128a.f5753y = false;
                    }
                    if (!this.f6128a.f5753y) {
                        this.f6128a.f5753y = z2;
                    }
                    if (this.f6128a.f5487D == EnumC2300t.BROADCAST) {
                        if (this.f6128a.m8006aZ()) {
                            this.f6128a.f5753y = true;
                        } else {
                            this.f6128a.f5753y = false;
                        }
                    }
                    if (c0788l.f2172a) {
                        if (!this.f6128a.f5625cO) {
                            this.f6128a.m8275t();
                        }
                        if (c0788l instanceof C1985dd) {
                            this.f6128a.f5488E = ((C1985dd) c0788l).m9136a();
                        } else if (c0788l instanceof C2000ds) {
                            this.f6128a.f5488E = ((C2000ds) c0788l).f7352d;
                        }
                        if (this.f6128a.f5487D != EnumC2300t.MONOLOGUE) {
                            if (this.f6128a.f5487D != EnumC2300t.GROUPCHAT || this.f6128a.f5590bf == null || this.f6128a.f5590bf.size() <= 0) {
                                this.f6128a.f5546ao.startQuery(5, null, C2220ah.m10090b(this.f6128a.f5750v), null, null, null, null);
                            } else {
                                this.f6128a.f5546ao.startInsert(22, null, C2220ah.m10087a(this.f6128a.f5750v, this.f6128a.f5590bf), null);
                            }
                            this.f6128a.m8254e();
                        }
                        if (C1736gi.m8627a(message.what, c0788l.m3152g()) == EnumC0789m.SUCCESS_RECEIVER_ERROR) {
                            if (c0788l instanceof C1985dd) {
                                arrayList2 = ((C1985dd) c0788l).f7285d;
                            } else {
                                arrayList2 = c0788l instanceof C2000ds ? ((C2000ds) c0788l).f7353e : null;
                            }
                            if (arrayList2 != null) {
                                StringBuilder sb = new StringBuilder();
                                Iterator<String> it = arrayList2.iterator();
                                while (it.hasNext()) {
                                    sb.append(it.next());
                                    if (it.hasNext()) {
                                        sb.append(",");
                                    }
                                }
                                C5179v.m19811a(this.f6128a.f5624cN, String.format(CommonApplication.m18732r().getString(R.string.toast_deleted_account), sb.toString()), 0).show();
                            } else {
                                C4904y.m18639b("1001 error - but invalid user list is empty", getClass().getSimpleName());
                            }
                        }
                        this.f6128a.m8019ag();
                        this.f6128a.m8208t(this.f6128a.f5750v);
                    } else {
                        this.f6128a.m8275t();
                        switch (C1736gi.m8627a(message.what, c0788l.m3152g())) {
                            case CHANGE_SERVER:
                                if (this.f6128a.f5531aX != null) {
                                    this.f6128a.f5531aX.mo9274d();
                                    this.f6128a.f5531aX.mo9252a(this.f6128a.f5750v, C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b());
                                    break;
                                }
                                break;
                            case BLOCK_RECEIVER:
                                C5179v.m19811a(this.f6128a.f5624cN, String.format(CommonApplication.m18732r().getString(R.string.toast_was_blocked), ((C0777a) this.f6128a.f5591bg.get(this.f6128a.f5588bd.get(0))).m3099b()), 0).show();
                                break;
                            case INVALID_USER:
                                StringBuilder sb2 = new StringBuilder();
                                if (this.f6128a.f5591bg.size() > 0) {
                                    Iterator it2 = this.f6128a.f5591bg.entrySet().iterator();
                                    while (it2.hasNext()) {
                                        sb2.append(((C0777a) ((Map.Entry) it2.next()).getValue()).m3099b());
                                        if (it2.hasNext()) {
                                            sb2.append(",");
                                        }
                                    }
                                } else {
                                    if (c0788l instanceof C1985dd) {
                                        arrayList = ((C1985dd) c0788l).f7285d;
                                    } else {
                                        arrayList = c0788l instanceof C2000ds ? ((C2000ds) c0788l).f7353e : null;
                                    }
                                    if (arrayList != null) {
                                        Iterator<String> it3 = arrayList.iterator();
                                        while (it3.hasNext()) {
                                            sb2.append(it3.next());
                                            if (it3.hasNext()) {
                                                sb2.append(",");
                                            }
                                        }
                                    }
                                }
                                C5179v.m19811a(this.f6128a.f5624cN, String.format(GlobalApplication.m18732r().getString(R.string.toast_deleted_account), sb2.toString()), 0).show();
                                break;
                            case NON_WEB_USER_DETECTED:
                                if (c0788l instanceof C1985dd) {
                                    c0919es = ((C1985dd) c0788l).f7286e;
                                } else {
                                    c0919es = c0788l instanceof C2000ds ? ((C2000ds) c0788l).f7354f : null;
                                }
                                if (c0919es != null) {
                                    for (C0892ds c0892ds : c0919es.m4985c()) {
                                        String strM4668d = c0892ds.m4668d();
                                        String strM4670f = c0892ds.m4670f();
                                        int iIndexOf = this.f6128a.f5588bd.indexOf(strM4668d);
                                        if (iIndexOf > -1) {
                                            this.f6128a.f5588bd.set(iIndexOf, strM4670f);
                                            C0777a c0777a = (C0777a) this.f6128a.f5591bg.remove(strM4668d);
                                            c0777a.m3098a(strM4670f);
                                            this.f6128a.f5591bg.put(strM4670f, c0777a);
                                        }
                                    }
                                }
                                this.f6128a.m8220a(c0788l.m3153h());
                                break;
                        }
                    }
                    if (this.f6128a.f5601bq != null) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("inbox_title", this.f6128a.f5601bq);
                        contentValues.put("inbox_title_fixed", "Y");
                        this.f6128a.f5546ao.startUpdate(-1, null, C2299s.f8209a, contentValues, "inbox_no='" + this.f6128a.f5750v + "'", null);
                    }
                    if (z || !C2466q.m10670a(c0788l.m3152g())) {
                        this.f6128a.m7947a(true, z);
                    }
                    if (c0788l.m3152g() == 7005) {
                        this.f6128a.m8242b();
                    }
                    if (this.f6128a.f5487D == EnumC2300t.GROUPCHAT && this.f6128a.f5658cv != null && this.f6128a.f5488E != null) {
                        C4855bt.m18351a(this.f6128a.f5624cN).m18365a(this.f6128a.f5750v, this.f6128a.f5658cv, this.f6128a.f5488E);
                    }
                    if (this.f6128a.f5487D == EnumC2300t.BROADCAST) {
                        if (this.f6128a.f5527aT != null && this.f6128a.f5527aT.getCount() == 2) {
                            ((ActionBarFragmentActivity) this.f6128a.getActivity()).mo51u_();
                            break;
                        }
                    } else {
                        ((ActionBarFragmentActivity) this.f6128a.getActivity()).mo51u_();
                        break;
                    }
                    break;
                case 2:
                    this.f6128a.m8275t();
                    if (!c0788l.f2172a) {
                        switch (C1736gi.m8627a(message.what, c0788l.m3152g())) {
                            case SESSION_USER_NOT_EXIST:
                                this.f6128a.m7877Z();
                                break;
                            case SESSION_DEACTIVATED:
                                this.f6128a.m7977aL();
                                break;
                        }
                    }
                    break;
                case 4:
                case 102:
                    if (!c0788l.f2172a) {
                        c0788l.m3152g();
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        switch (C1736gi.m8627a(message.what, r0)) {
                            case CHANGE_SERVER:
                                if (this.f6128a.f5531aX != null) {
                                    this.f6128a.f5531aX.mo9274d();
                                    this.f6128a.f5531aX.mo9252a(this.f6128a.f5750v, C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b());
                                    this.f6128a.f5531aX.mo9243a(300000 + jElapsedRealtime);
                                    break;
                                }
                                break;
                            case BLOCK_RECEIVER:
                                C5179v.m19811a(this.f6128a.f5624cN, String.format(CommonApplication.m18732r().getString(R.string.toast_was_blocked), ((C0777a) this.f6128a.f5591bg.get(this.f6128a.f5588bd.get(0))).m3099b()), 0).show();
                                break;
                            case INVALID_USER:
                                StringBuilder sb3 = new StringBuilder();
                                Iterator it4 = this.f6128a.f5591bg.entrySet().iterator();
                                while (it4.hasNext()) {
                                    sb3.append(((C0777a) ((Map.Entry) it4.next()).getValue()).m3099b());
                                    if (it4.hasNext()) {
                                        sb3.append(",");
                                    }
                                }
                                break;
                            case RETRY:
                                if (this.f6128a.f5531aX != null) {
                                    this.f6128a.f5531aX.mo9252a(this.f6128a.f5750v, C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b());
                                    this.f6128a.f5531aX.mo9243a(jElapsedRealtime + 300000);
                                }
                                this.f6128a.f5488E = null;
                                break;
                            case SESSION_USER_NOT_EXIST:
                                this.f6128a.m7877Z();
                                break;
                            case SESSION_DEACTIVATED:
                                this.f6128a.m7977aL();
                                break;
                        }
                    }
                    if (z || !C2466q.m10670a(c0788l.m3152g())) {
                        this.f6128a.m7947a(true, z);
                    }
                    if (c0788l.m3152g() == 7005) {
                        this.f6128a.m8242b();
                        break;
                    }
                    break;
                case 6:
                    C0782f c0782f = (C0782f) c0788l;
                    int iM3118b = c0782f.m3118b();
                    if (this.f6128a.f5527aT.getTranscriptMode() != 2) {
                        this.f6128a.mo8219a(iM3118b, c0782f.m3120d(), c0782f.m3119c(), c0782f.m3121e());
                    }
                    if (this.f6128a.f5612cB != null) {
                        for (String str : c0782f.m3122f()) {
                            this.f6128a.f5612cB.m8813a(str, -1L, System.currentTimeMillis(), EnumC1787if.IDLE);
                        }
                    }
                    this.f6128a.m7947a(false, z);
                    break;
                case 12:
                    this.f6128a.m8275t();
                    if (!c0788l.f2172a) {
                        switch (C1736gi.m8627a(message.what, c0788l.m3152g())) {
                            case SESSION_USER_NOT_EXIST:
                                this.f6128a.m7877Z();
                                break;
                            case SESSION_DEACTIVATED:
                                this.f6128a.m7977aL();
                                break;
                        }
                        C5179v.m19810a(this.f6128a.f5624cN, R.string.toast_invite_fail, 0).show();
                    }
                    if (c0788l.m3152g() == 7005) {
                        this.f6128a.m8242b();
                        break;
                    }
                    break;
                case 16:
                    if (c0788l.m3152g() == 3006) {
                        this.f6128a.m7877Z();
                        break;
                    }
                    break;
                case 24:
                    C1990di c1990di = (C1990di) c0788l;
                    if (this.f6128a.f5612cB != null) {
                        this.f6128a.f5612cB.m8813a(c1990di.m9139a(), c1990di.m9140b() * 1000, System.currentTimeMillis(), EnumC1787if.m8816a(c1990di.m9141c()));
                        break;
                    }
                    break;
                case 31:
                    this.f6128a.m8275t();
                    if (!c0788l.f2172a) {
                        switch (C1736gi.m8627a(message.what, c0788l.m3152g())) {
                            case SESSION_USER_NOT_EXIST:
                                this.f6128a.m7877Z();
                                break;
                        }
                        C5179v.m19810a(this.f6128a.f5624cN, R.string.toast_invite_fail, 0).show();
                    }
                    if (c0788l.m3152g() == 7005) {
                        this.f6128a.m8242b();
                        break;
                    }
                    break;
                case 34:
                case 36:
                    C0785i c0785i = (C0785i) c0788l;
                    int iM3136b = c0785i.m3136b();
                    if (this.f6128a.f5527aT.getTranscriptMode() != 2) {
                        this.f6128a.mo8219a(iM3136b, c0785i.m3138d(), c0785i.m3137c(), c0785i.m3139e());
                    }
                    if (this.f6128a.f5612cB != null) {
                        this.f6128a.f5612cB.m8813a(c0785i.m3137c(), -1L, System.currentTimeMillis(), EnumC1787if.IDLE);
                    }
                    if (ChatFragment.m8214x()) {
                        this.f6128a.m8098bi();
                    }
                    this.f6128a.m7947a(false, z);
                    break;
                case 48:
                    if (this.f6128a.f5487D == EnumC2300t.ONETOONE) {
                        ArrayList<C0925ey> arrayListM9153a = ((C2009ea) c0788l).m9153a();
                        if (arrayListM9153a.get(0) != null) {
                            C0777a c0777a2 = (C0777a) this.f6128a.f5591bg.get(this.f6128a.f5752x);
                            if (c0777a2 != null) {
                                StringBuilder sb4 = new StringBuilder();
                                if (arrayListM9153a.get(0).m5045f()) {
                                    if (C4904y.f17873c) {
                                        C4904y.m18641c("Receive online PushConnectivityNotify", ChatFragment.f5461a);
                                    }
                                    if (ChatFragment.m8214x()) {
                                        this.f6128a.m8098bi();
                                        break;
                                    }
                                } else {
                                    if (C4904y.f17873c) {
                                        C4904y.m18641c("Receive offline PushConnectivityNotify", ChatFragment.f5461a);
                                    }
                                    if (!ChatFragment.m8214x()) {
                                        ChatFragment.m8075b(true);
                                        String strM8657i = C1736gi.m8657i(c0777a2.m3096a());
                                        if (!TextUtils.isEmpty(strM8657i)) {
                                            sb4.append(String.format("%d,%s,%s", Integer.valueOf(EnumC2231as.OFFLINE_USER.m10100a()), strM8657i, c0777a2.m3099b())).append(Config.KEYVALUE_SPLIT);
                                            C2204r.m10048b(this.f6128a.f5546ao, 1, this.f6128a.f5750v, sb4.toString(), "push_connectivity");
                                            break;
                                        } else if (C4904y.f17873c) {
                                            C4904y.m18641c("Phone Number Empty. So it can't be sent by SMS : " + c0777a2.m3096a(), ChatFragment.f5461a);
                                            break;
                                        }
                                    }
                                }
                            } else if (C4904y.f17873c) {
                                C4904y.m18641c("information of buddy is null. Do not display offline message", ChatFragment.f5461a);
                                break;
                            }
                        }
                    }
                    break;
                case 101:
                    if (!c0788l.f2172a) {
                        this.f6128a.m8275t();
                        this.f6128a.f5648cl = c0788l.m3152g();
                        if (this.f6128a.f5648cl == 28004 || this.f6128a.f5648cl == 28003) {
                            C5179v.m19810a(this.f6128a.f5624cN, R.string.toast_supported_format, 0).show();
                        } else if (!RunnableC2440g.m10589a(message.arg1, message.arg2)) {
                            C5179v.m19810a(this.f6128a.f5624cN, R.string.toast_file_upload_fail, 0).show();
                        }
                        this.f6128a.m7947a(true, z);
                        break;
                    }
                    break;
                case 107:
                    if (c0788l.m3152g() == 7100) {
                        this.f6128a.m7966aF();
                        break;
                    } else {
                        this.f6128a.m7968aG();
                        break;
                    }
            }
        }
    }
}
