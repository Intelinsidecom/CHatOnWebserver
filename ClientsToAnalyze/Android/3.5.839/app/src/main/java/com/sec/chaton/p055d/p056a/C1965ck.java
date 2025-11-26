package com.sec.chaton.p055d.p056a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2180af;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p065io.entry.GetMappingInfo;
import com.sec.chaton.p065io.entry.GetProfileImageList;
import com.sec.chaton.p065io.entry.inner.BuddyProfile;
import com.sec.chaton.p065io.entry.inner.CoverStory;
import com.sec.chaton.p065io.entry.inner.MappingInfoEntry;
import com.sec.chaton.p065io.entry.inner.ProfileInformationList;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4884g;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: GetProfileInformationTask.java */
/* renamed from: com.sec.chaton.d.a.ck */
/* loaded from: classes.dex */
public class C1965ck extends AbstractC1900a {

    /* renamed from: b */
    private String f7259b;

    public C1965ck(Handler handler, C2454e c2454e, String str) {
        super(c2454e);
        this.f7259b = str;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        return null;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) throws RemoteException, OperationApplicationException {
        if (c0778b.m18954n() && c0778b.m3110e() != null && c0778b.m3107b() != EnumC2464o.ERROR) {
            ProfileInformationList profileInformationList = (ProfileInformationList) c0778b.m3110e();
            BuddyProfile buddyProfile = profileInformationList.profile;
            CoverStory coverStory = profileInformationList.coverstory;
            GetProfileImageList getProfileImageList = profileInformationList.profileimage;
            GetMappingInfo getMappingInfo = profileInformationList.mappinginfo;
            if (coverStory.metaid != null) {
                C4904y.m18646e("coverStoryInfo.contentid : " + coverStory.contentid + ", coverStoryInfo.coverimageregdttm : " + coverStory.coverimageregdttm, getClass().getSimpleName());
                C4904y.m18646e("coverStoryInfo.host : " + coverStory.host, getClass().getSimpleName());
                C4904y.m18646e("coverStoryInfo.metacontents : " + coverStory.metacontents, getClass().getSimpleName());
                C4904y.m18646e("coverStoryInfo.metaid : " + coverStory.metaid, getClass().getSimpleName());
            } else {
                C4904y.m18634a("Http result object is null.", this.f18194f);
            }
            if (buddyProfile.timestamp != null) {
                if (this.f7259b != null) {
                    ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
                    C4904y.m18646e("Name : " + buddyProfile.name + ", Status : " + buddyProfile.status + ", Birthday : " + buddyProfile.birthday + ", Email : " + buddyProfile.email + ", Imgstatus : " + buddyProfile.imgstatus, this.f18194f);
                    if (!this.f7259b.startsWith("0999")) {
                        arrayList.add(C2190d.m9803a(this.f7259b, buddyProfile));
                    }
                    CommonApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
                    C4904y.m18641c("buddy " + buddyProfile.name + " written in db.", this.f18194f);
                } else {
                    if (buddyProfile.name != null) {
                        C4809aa.m18104a().m18128b("Push Name", buddyProfile.name.trim());
                    }
                    if (buddyProfile.status != null) {
                        C4809aa.m18104a().m18128b("status_message", buddyProfile.status);
                    }
                    if (buddyProfile.birthday != null) {
                        C4809aa.m18104a().m18128b("birthday_server", buddyProfile.birthday);
                        String strM18121a = C4809aa.m18104a().m18121a("birthday_server", "");
                        if (!strM18121a.equals("")) {
                            C4884g.m18544a(strM18121a);
                        }
                    }
                    if (buddyProfile.samsungemail != null) {
                        C4822an.m18215a(buddyProfile.samsungemail);
                    }
                    C4809aa.m18108a("profile_information_timestamp", buddyProfile.timestamp);
                    C4904y.m18646e("ProfileControl.METHOD_GET_PROFILE_INFOMATION Success", getClass().getSimpleName());
                }
            }
            if (getProfileImageList.totalcount != null && this.f7259b == null) {
                C2180af.m9734a(getProfileImageList);
            }
            if (getMappingInfo != null && this.f7259b == null) {
                C4809aa.m18108a("msisdn1", "");
                C4809aa.m18108a("msisdn2", "");
                C4809aa.m18108a("msisdn3", "");
                C4809aa.m18108a("msisdn4", "");
                int i = 1;
                Iterator<MappingInfoEntry> it = getMappingInfo.MappingInfo.iterator();
                while (true) {
                    int i2 = i;
                    if (it.hasNext()) {
                        MappingInfoEntry next = it.next();
                        if (!TextUtils.isEmpty(next.phoneNumber) && i2 < 5) {
                            if (C4904y.f17872b) {
                                C4904y.m18639b("Mapping Phone number : " + next.phoneNumber, this.f18194f);
                            }
                            C4809aa.m18108a("msisdn" + Integer.toString(i2), next.phoneNumber);
                            i2++;
                        }
                        i = i2;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
