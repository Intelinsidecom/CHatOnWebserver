package com.sds.coolots.call.model;

import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.sds.coolots.call.model.x */
/* loaded from: classes.dex */
public class C1222x {

    /* renamed from: a */
    private static final String f2786a = "[ConferenceHoldHandler]";

    /* renamed from: b */
    private final List f2787b = new ArrayList();

    /* renamed from: a */
    private void m2741a(String str) {
        Log.m2958e(f2786a + str);
    }

    /* renamed from: a */
    private boolean m2742a(SimpleUserInfo simpleUserInfo) {
        return "1".equals(simpleUserInfo.getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(simpleUserInfo.getStatus());
    }

    /* renamed from: b */
    private void m2743b(String str) {
        Log.m2963i(f2786a + str);
    }

    /* renamed from: c */
    private boolean m2744c(String str) {
        Iterator it = this.f2787b.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m2745a(List list) {
        m2743b("isHoldConference!!!!");
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            if (m2742a(simpleUserInfo)) {
                i++;
                if ("N".equals(simpleUserInfo.getHoldYn())) {
                    return false;
                }
            }
        }
        return i != 0;
    }

    /* renamed from: b */
    public C1223y m2746b(List list) {
        m2743b("checkHoldMemberChanged!!!!");
        C1223y c1223y = new C1223y();
        c1223y.f2788a = new ArrayList();
        c1223y.f2789b = new ArrayList();
        for (String str : new ArrayList(this.f2787b)) {
            Iterator it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
                    if (str.equals(simpleUserInfo.getUserID())) {
                        if ("N".equals(simpleUserInfo.getHoldYn())) {
                            if (m2742a(simpleUserInfo)) {
                                c1223y.f2789b.add(str);
                            }
                            this.f2787b.remove(str);
                        } else if (!m2742a(simpleUserInfo)) {
                            this.f2787b.remove(str);
                        }
                    }
                }
            }
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            SimpleUserInfo simpleUserInfo2 = (SimpleUserInfo) it2.next();
            if (m2742a(simpleUserInfo2) && "Y".equals(simpleUserInfo2.getHoldYn()) && !m2744c(simpleUserInfo2.getUserID())) {
                c1223y.f2788a.add(simpleUserInfo2.getUserID());
                this.f2787b.add(simpleUserInfo2.getUserID());
            }
        }
        return c1223y;
    }
}
