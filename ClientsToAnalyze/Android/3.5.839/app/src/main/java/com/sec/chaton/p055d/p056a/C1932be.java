package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.text.TextUtils;
import com.sec.chaton.account.C1002i;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.buddy.C1331gk;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2181ag;
import com.sec.chaton.p057e.p058a.C2187am;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p057e.p058a.C2191e;
import com.sec.chaton.p057e.p058a.C2192f;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p065io.entry.GetBuddyList;
import com.sec.chaton.p065io.entry.inner.Buddy;
import com.sec.chaton.p065io.entry.inner.BuddyPreviousData;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4855bt;
import com.sec.chaton.util.C4883f;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

/* compiled from: GetAllBuddiesTask.java */
/* renamed from: com.sec.chaton.d.a.be */
/* loaded from: classes.dex */
public class C1932be extends AbstractC1900a {

    /* renamed from: b */
    private Long f7205b;

    /* renamed from: c */
    private boolean f7206c;

    public C1932be(C2454e c2454e) {
        super(c2454e);
    }

    public C1932be(C2454e c2454e, boolean z) {
        super(c2454e);
        this.f7206c = z;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) throws Throwable {
        Long.valueOf(C4809aa.m18104a().m18118a("get_group_image_sync_timestamp", 0L));
        if (c0778b.m18954n() && c0778b.m3110e() != null) {
            GetBuddyList getBuddyList = (GetBuddyList) c0778b.m3110e();
            this.f7205b = getBuddyList.timestamp;
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            C4904y.m18641c("the number of buddy from Server : " + getBuddyList.buddy.size(), "GetAllBuddiesTask");
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            Iterator<Buddy> it = getBuddyList.buddy.iterator();
            while (it.hasNext()) {
                Buddy next = it.next();
                BuddyPreviousData buddyPreviousDataM9807a = C2190d.m9807a(GlobalApplication.m10279a().getContentResolver(), next.value);
                if (C4904y.f17872b) {
                    C4904y.m18639b("NO : " + next.value + ", OrgNumber : " + next.orgnum + ", Name : " + next.name + ", Deleted : " + next.deleted + ", OrgName : " + next.orgname, "GetAllBuddiesTask");
                    C4904y.m18639b("StatusMsg : " + next.status + ", ImageStatus : " + next.getImagestatus().toString() + ", BIRTHDAY : " + next.birthday + ", showphonenumber=" + next.showphonenumber + ", extra info : " + next.einfo, "GetAllBuddiesTask");
                    C4904y.m18639b("OrgNumbers : " + next.orgnums + ", Msisdns : " + next.msisdns, "GetAllBuddiesTask");
                    C4904y.m18639b("Group : " + next.group + ", blocked : " + next.blocked + ", isHidden : " + next.isHidden, "GetAllBuddiesTask");
                    C4904y.m18639b("SEmail : " + next.samsungemail + "SAInfo : " + next.sainfo + "Result : " + next.result, "GetAllBuddiesTask");
                    C4904y.m18639b("DeviceType : " + next.devicetype, "GetAllBuddiesTask");
                }
                if (!next.deleted.booleanValue()) {
                    if (!next.value.startsWith("0999")) {
                        arrayList.add(C2190d.m9802a(next, buddyPreviousDataM9807a));
                        arrayList.add(C2176ab.m9669a(next.value, 0));
                        C2191e.m9857a(arrayList, next);
                        arrayList.add(C2181ag.m9738a(next.value));
                        arrayList.add(C2187am.m9779a(next.value));
                        if (C2349a.m10301a("sms_feature")) {
                            arrayList4.add(buddyPreviousDataM9807a.oldPhoneNumberForExternal);
                        }
                    }
                    if (next.getImagestatus() != Buddy.BuddyImageStatus.NOT_CHANGE) {
                        arrayList3.add(next.value);
                        C1331gk.m7453a(CommonApplication.m18732r()).m7470b(next.value);
                    }
                } else {
                    if (next.group != null && next.group.length() > 0) {
                        arrayList.add(C2191e.m9850a(next.group, next.value));
                    }
                    if (next.blocked.booleanValue()) {
                        if (next.orgname == null) {
                            if (buddyPreviousDataM9807a != null) {
                                if (!TextUtils.isEmpty(buddyPreviousDataM9807a.oldOrgName)) {
                                    arrayList.add(C2187am.m9780a(next.value, buddyPreviousDataM9807a.oldOrgName));
                                } else {
                                    arrayList.add(C2187am.m9780a(next.value, buddyPreviousDataM9807a.buddyNickName));
                                }
                            }
                        } else {
                            arrayList.add(C2187am.m9780a(next.value, next.orgname));
                        }
                    }
                    if (next.isHidden.booleanValue()) {
                        if (next.orgname == null) {
                            if (buddyPreviousDataM9807a != null) {
                                if (!TextUtils.isEmpty(buddyPreviousDataM9807a.oldOrgName)) {
                                    arrayList.add(C2187am.m9782b(next.value, buddyPreviousDataM9807a.oldOrgName));
                                } else {
                                    arrayList.add(C2187am.m9782b(next.value, buddyPreviousDataM9807a.buddyNickName));
                                }
                            }
                        } else {
                            arrayList.add(C2187am.m9782b(next.value, next.orgname));
                        }
                    }
                    if (C2349a.m10301a("sms_feature")) {
                        String str = buddyPreviousDataM9807a.oldPhoneNumberForExternal;
                        if (next.orgnum != null && C4883f.m18539a(next.orgnum) && next.orgnum.length() >= 8) {
                            arrayList.add(C2192f.m9878b(next.orgnum));
                            arrayList4.add(str);
                        }
                        if (str != null && str.length() >= 8) {
                            if (str.contains(" ")) {
                                StringTokenizer stringTokenizer = new StringTokenizer(str, " ");
                                while (stringTokenizer.hasMoreTokens()) {
                                    String strNextToken = stringTokenizer.nextToken();
                                    if (strNextToken != null && C4883f.m18539a(strNextToken) && strNextToken.length() >= 8) {
                                        arrayList.add(C2192f.m9878b("%" + strNextToken.substring(strNextToken.length() - 8)));
                                        arrayList4.add(str);
                                    }
                                }
                            } else if (C4883f.m18539a(str)) {
                                arrayList.add(C2192f.m9878b("%" + str.substring(str.length() - 8)));
                                arrayList4.add(str);
                            }
                        }
                    } else if (next.blocked.booleanValue()) {
                        C4904y.m18646e("Deleted NO : " + next.value + "is just blocked.", "GetAllBuddiesTask");
                    } else {
                        C4904y.m18646e("Deleted NO : " + next.value + "is deleted account. buddy.forcedel : " + next.forcedel, "GetAllBuddiesTask");
                        if (next.forcedel.booleanValue()) {
                            if (next.orgnum != null && C4883f.m18539a(next.orgnum) && next.orgnum.length() >= 8) {
                                arrayList.add(C2192f.m9878b(next.orgnum));
                            }
                            if (next.orgnums != null) {
                                new ArrayList();
                                for (String str2 : C2192f.m9882f(next.orgnums)) {
                                    if (C4883f.m18539a(str2) && str2.length() >= 8) {
                                        arrayList.add(C2192f.m9878b(str2));
                                    }
                                }
                            }
                        }
                    }
                    arrayList.add(C2190d.m9826c(next));
                    arrayList.add(C2191e.m9849a(next.value));
                    arrayList.add(C2190d.m9832d(next));
                    arrayList.add(C2198l.m9917a(next.value));
                    C4855bt.m18351a(GlobalApplication.m10279a()).m18363a(next.value);
                    C1331gk.m7453a(GlobalApplication.m10279a()).m7467a(next.value);
                }
                String strM9810a = C2190d.m9810a(C4883f.m18540a(next.value, next.msisdns), buddyPreviousDataM9807a.oldShowPhoneNum, next.showphonenumber, next.msisdns, next.value, next.orgnum, next.orgnums);
                if (!TextUtils.isEmpty(strM9810a)) {
                    arrayList2.add(strM9810a);
                }
            }
            C2496n.m10761a(CommonApplication.m18732r(), arrayList3);
            GlobalApplication.m10279a().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
            C4904y.m18641c("the number of buddy from Server : " + getBuddyList.buddy.size() + " written in db.", "GetAllBuddiesTask");
            GlobalApplication.m10279a().getContentResolver().applyBatch("com.sec.chaton.provider", C2176ab.m9677a((ArrayList<String>) arrayList2));
            BuddyFragment.f3584j = C2190d.m9837e(GlobalApplication.m10279a().getContentResolver());
            C2191e.m9853a();
            if (!TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""))) {
                C1002i.m6057a(GlobalApplication.m10279a(), getBuddyList.buddy);
            }
            if (this.f7206c) {
                C1002i.m6069b(false);
            }
            C4809aa.m18107a("get_all_buddies_timestamp", this.f7205b);
            this.f7205b = null;
            if (C2349a.m10301a("sms_feature") && !arrayList4.isEmpty()) {
                C3782a.m14222b((ArrayList<String>) arrayList4);
            }
            C2176ab.m9678a();
        } else if (this.f7206c) {
            C4904y.m18641c("manualContactSync", "GetAllBuddiesTask");
            C1002i.m6069b(false);
        }
        if (c0778b.m3107b() == EnumC2464o.SUCCESS || c0778b.m3107b() == EnumC2464o.NO_CONTENT) {
        }
    }
}
