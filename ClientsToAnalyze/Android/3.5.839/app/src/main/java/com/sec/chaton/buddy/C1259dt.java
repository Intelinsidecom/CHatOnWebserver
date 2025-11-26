package com.sec.chaton.buddy;

import com.sec.chaton.C0992ab;
import com.sec.chaton.C0993ac;
import com.sec.chaton.C1012ak;
import com.sec.chaton.C1013al;
import com.sec.chaton.C1016ao;
import com.sec.chaton.C1047as;
import com.sec.chaton.C1063bc;
import com.sec.chaton.EnumC1005ad;
import com.sec.chaton.EnumC1014am;
import com.sec.chaton.EnumC1017ap;
import com.sec.chaton.EnumC1064bd;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.util.C4904y;
import com.sec.common.p130e.InterfaceC4995d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.dt */
/* loaded from: classes.dex */
class C1259dt {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4781a;

    private C1259dt(BuddyFragment buddyFragment) {
        this.f4781a = buddyFragment;
    }

    /* synthetic */ C1259dt(BuddyFragment buddyFragment, ViewOnClickListenerC1133ax viewOnClickListenerC1133ax) {
        this(buddyFragment);
    }

    @InterfaceC4995d
    public void onMeStatusChanged(C1016ao c1016ao) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onMeStatusChanged", BuddyFragment.f3576a);
        }
        if (c1016ao.m6092a() == EnumC1017ap.NAME_CHANGED || c1016ao.m6092a() == EnumC1017ap.STATUS_MESSAGE_CHANGED) {
            this.f4781a.m6576y();
        }
        if (this.f4781a.f3620aA != null) {
            this.f4781a.f3620aA.notifyDataSetChanged();
        }
        if (this.f4781a.f3602I != null) {
            this.f4781a.f3602I.invalidate();
        }
    }

    @InterfaceC4995d
    public void onMyProfileImageChanged(C1047as c1047as) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onMyProfileImageChanged", BuddyFragment.f3576a);
        }
        if (this.f4781a.f3620aA != null) {
            this.f4781a.f3620aA.notifyDataSetChanged();
        }
        if (this.f4781a.f3602I != null) {
            this.f4781a.f3602I.invalidate();
        }
    }

    @InterfaceC4995d
    public void onGroupProfileImageChanged(C1012ak c1012ak) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onGroupProfileImageChanged.", BuddyFragment.f3576a);
            List<String> list = c1012ak.f3287a;
            if (list != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    C4904y.m18639b(" - " + it.next(), BuddyFragment.f3576a);
                }
            }
        }
        if (this.f4781a.f3620aA != null) {
            this.f4781a.f3620aA.notifyDataSetChanged();
        }
        if (this.f4781a.f3602I != null) {
            this.f4781a.f3602I.invalidate();
        }
    }

    @InterfaceC4995d
    public void onBuddyProfileImageChanged(C0992ab c0992ab) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onBuddyProfileImageChanged.", BuddyFragment.f3576a);
            List<String> list = c0992ab.f3246a;
            if (list != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    C4904y.m18639b(" - " + it.next(), BuddyFragment.f3576a);
                }
            }
        }
        if (this.f4781a.f3620aA != null) {
            this.f4781a.f3620aA.notifyDataSetChanged();
        }
        if (this.f4781a.f3602I != null) {
            this.f4781a.f3602I.invalidate();
        }
    }

    @InterfaceC4995d
    public void onBuddyStatusChanged(C0993ac c0993ac) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onBuddyStatusChanged : " + c0993ac.m6038a().toString(), BuddyFragment.f3576a);
        }
        if (c0993ac.m6038a() == EnumC1005ad.NAME_CHANGED || c0993ac.m6038a() == EnumC1005ad.BLOCKED || c0993ac.m6038a() == EnumC1005ad.HIDED || c0993ac.m6038a() == EnumC1005ad.DELETED || c0993ac.m6038a() == EnumC1005ad.ADD_FAVORITE || c0993ac.m6038a() == EnumC1005ad.REMOVE_FAVORITE) {
            this.f4781a.m6576y();
        } else if (c0993ac.m6038a() == EnumC1005ad.ADDED) {
            this.f4781a.m6576y();
            this.f4781a.m6288C();
        }
        if (this.f4781a.f3620aA != null) {
            this.f4781a.f3620aA.notifyDataSetChanged();
        }
        if (this.f4781a.f3602I != null) {
            this.f4781a.f3602I.invalidate();
        }
    }

    @InterfaceC4995d
    public void onGroupStatusChanged(C1013al c1013al) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onGroupStatusChanged.", BuddyFragment.f3576a);
        }
        if (c1013al.m6088a() == EnumC1014am.NAME_CHANGED) {
            if (this.f4781a.f3620aA != null) {
                Iterator<ArrayList<C1106c>> it = this.f4781a.f3620aA.m7126c().iterator();
                while (it.hasNext()) {
                    Iterator<C1106c> it2 = it.next().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            C1106c next = it2.next();
                            try {
                            } catch (Exception e) {
                                if (C4904y.f17872b) {
                                    C4904y.m18639b("onGroupStatusChanged exception occured " + c1013al.m6089b(), BuddyFragment.f3576a);
                                }
                            }
                            if (next.m7074w() && next.m7046a().equals(c1013al.m6089b())) {
                                C4904y.m18639b("onGroupStatusChanged : " + next.m7051b() + ", " + c1013al.m6090c(), BuddyFragment.f3576a);
                                next.m7052b(c1013al.m6090c());
                                break;
                            }
                        }
                    }
                }
            }
        } else if (c1013al.m6088a() == EnumC1014am.ADDED || c1013al.m6088a() == EnumC1014am.REMOVED || c1013al.m6088a() == EnumC1014am.MEMBER_CHANGED) {
            this.f4781a.m6576y();
        }
        this.f4781a.f3620aA.notifyDataSetChanged();
        if (this.f4781a.f3602I != null) {
            this.f4781a.f3602I.invalidate();
        }
    }

    @InterfaceC4995d
    public void onSpecialbuddyStatusChanged(C1063bc c1063bc) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onSpecialbuddyStatusChanged.", BuddyFragment.f3576a);
        }
        if (c1063bc.m6174a() == EnumC1064bd.UNFOLLOW || c1063bc.m6174a() == EnumC1064bd.FOLLOW) {
            this.f4781a.m6576y();
        } else if (c1063bc.m6174a() == EnumC1064bd.GET_MY_FOLLOWING) {
            this.f4781a.f3660ao = 1;
            this.f4781a.m6576y();
        }
        this.f4781a.f3620aA.notifyDataSetChanged();
        if (this.f4781a.f3602I != null) {
            this.f4781a.f3602I.invalidate();
        }
    }
}
