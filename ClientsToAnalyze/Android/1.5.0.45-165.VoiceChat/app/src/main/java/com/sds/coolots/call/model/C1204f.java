package com.sds.coolots.call.model;

import com.coolots.p2pmsg.model.SimpleUserInfo;
import java.util.Date;

/* renamed from: com.sds.coolots.call.model.f */
/* loaded from: classes.dex */
public class C1204f {

    /* renamed from: a */
    private final String f2656a;

    /* renamed from: b */
    private Date f2657b;

    /* renamed from: c */
    private Date f2658c;

    /* renamed from: d */
    private Date f2659d;

    public C1204f(SimpleUserInfo simpleUserInfo, Date date) {
        this.f2656a = simpleUserInfo.getUserID();
        if ("0".equals(simpleUserInfo.getStatus())) {
            this.f2657b = date;
        } else if (!"1".equals(simpleUserInfo.getStatus()) && !SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(simpleUserInfo.getStatus())) {
            this.f2657b = date;
        } else {
            this.f2657b = date;
            this.f2658c = date;
        }
    }

    /* renamed from: a */
    public String m2450a() {
        return this.f2656a;
    }

    /* renamed from: a */
    public void m2451a(Date date) {
        this.f2658c = date;
    }

    /* renamed from: b */
    public Date m2452b() {
        return this.f2657b;
    }

    /* renamed from: b */
    public void m2453b(Date date) {
        this.f2659d = date;
    }

    /* renamed from: c */
    public Date m2454c() {
        return this.f2658c;
    }

    /* renamed from: d */
    public Date m2455d() {
        return this.f2659d;
    }

    /* renamed from: e */
    public int m2456e() {
        if (this.f2659d == null || this.f2658c == null) {
            return 0;
        }
        return (int) ((this.f2659d.getTime() - this.f2658c.getTime()) / 1000);
    }
}
