package com.sec.chaton.buddy;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.GetProfileImageList;
import com.sec.chaton.p035io.entry.inner.BuddyProfile;
import com.sec.chaton.p035io.entry.inner.ProfileImage;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3231f;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.ff */
/* loaded from: classes.dex */
class HandlerC0695ff extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f2918a;

    HandlerC0695ff(BuddyProfileFragment buddyProfileFragment) {
        this.f2918a = buddyProfileFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        boolean z;
        if (!GlobalApplication.m6456e()) {
            if (this.f2918a.f2114q == null) {
                return;
            }
        } else if (this.f2918a.getActivity() == null) {
            return;
        }
        if (this.f2918a.f2036U.isShowing()) {
            this.f2918a.f2036U.dismiss();
        }
        switch (message.what) {
            case 411:
                C0267d c0267d = (C0267d) message.obj;
                if (c0267d == null || !c0267d.m11704n() || c0267d.m1351b() != EnumC1587o.SUCCESS || ((BuddyProfile) c0267d.m1354e()) == null) {
                }
                return;
            case 412:
                C0267d c0267d2 = (C0267d) message.obj;
                ArrayList<String> arrayList = new ArrayList<>();
                if (c0267d2 != null) {
                    if (c0267d2.m11704n() && c0267d2.m1351b() == EnumC1587o.SUCCESS) {
                        GetProfileImageList getProfileImageList = (GetProfileImageList) c0267d2.m1354e();
                        if (getProfileImageList != null) {
                            ArrayList<ProfileImage> arrayList2 = getProfileImageList.profileimagelist;
                            this.f2918a.f2018C = getProfileImageList.listcount.intValue();
                            if (arrayList2 != null && arrayList2.size() != 0) {
                                this.f2918a.f2056aO = 0;
                                int i = 0;
                                while (true) {
                                    int i2 = i;
                                    if (i2 >= arrayList2.size()) {
                                        z = false;
                                    } else if (!"1".equals(arrayList2.get(i2).represent)) {
                                        i = i2 + 1;
                                    } else {
                                        z = true;
                                    }
                                }
                                if (!z && this.f2918a.f2018C == 0) {
                                    this.f2918a.m3725d();
                                    return;
                                }
                                if (arrayList2 != null && arrayList2.size() > 0) {
                                    this.f2918a.m3712a(arrayList2.size());
                                    int i3 = 0;
                                    while (true) {
                                        int i4 = i3;
                                        if (i4 < arrayList2.size()) {
                                            ProfileImage profileImage = arrayList2.get(i4);
                                            if ("1".equals(profileImage.represent)) {
                                                try {
                                                    C3250y.m11450b("Profile URL : " + profileImage.profileimageurl, getClass().getSimpleName());
                                                    String strM11388c = C3231f.m11361a(this.f2918a.f2058aQ).m11388c(this.f2918a.f2117t);
                                                    if (strM11388c != null && !TextUtils.isEmpty(profileImage.update_msec) && !TextUtils.isEmpty(strM11388c)) {
                                                        if (!strM11388c.equals(profileImage.update_msec)) {
                                                            C3250y.m11450b("***********Timestamp unmatch need to reload main image : " + profileImage.update_msec, "TIME");
                                                            C3231f.m11361a(this.f2918a.f2058aQ).m11383a(this.f2918a.f2117t, profileImage.profileimageid);
                                                            this.f2918a.f2027L.m4340a((String) null);
                                                        } else {
                                                            C3250y.m11450b("***********Timestamp match : " + profileImage.update_msec, "TIME");
                                                        }
                                                    }
                                                    if (this.f2918a.f2027L.m4342b() != null && (this.f2918a.f2027L.m4342b() == null || this.f2918a.f2027L.m4342b().equals(profileImage.profileimageid))) {
                                                        if (this.f2918a.f2027L.m4342b() != null && this.f2918a.f2027L.m4342b().equals(profileImage.profileimageid)) {
                                                            this.f2918a.f2027L.m4341a(true);
                                                            arrayList.add("0:" + profileImage.profileimageid);
                                                        }
                                                    } else {
                                                        BuddyProfileFragment.m3626ag(this.f2918a);
                                                        C3231f.m11361a(this.f2918a.f2058aQ).m11383a(this.f2918a.f2117t, profileImage.profileimageid);
                                                        this.f2918a.f2047aF.m11730a(this.f2918a.f2019D, new CallableC0698fi(this.f2918a.f2023H, profileImage.profileimageurl + this.f2918a.f2048aG + this.f2918a.f2049aH, HttpResponseCode.INTERNAL_SERVER_ERROR, HttpResponseCode.INTERNAL_SERVER_ERROR, this.f2918a.f2058aQ.getCacheDir() + "/" + this.f2918a.f2117t + "/", profileImage.profileimageid, true));
                                                        arrayList.add("0:" + profileImage.profileimageid);
                                                    }
                                                    if (!TextUtils.isEmpty(profileImage.update_msec)) {
                                                        C3231f.m11361a(this.f2918a.f2058aQ).m11387b(this.f2918a.f2117t, profileImage.update_msec);
                                                    }
                                                } catch (Exception e) {
                                                    C3250y.m11443a(e, getClass().getSimpleName());
                                                } catch (OutOfMemoryError e2) {
                                                    C3250y.m11443a(e2, getClass().getSimpleName());
                                                }
                                                this.f2918a.f2027L.m4340a(profileImage.profileimageid);
                                                this.f2918a.m3723c();
                                                i3 = i4 + 1;
                                            } else {
                                                C3250y.m11450b("Profile URL : " + profileImage.profileimageurl, getClass().getSimpleName());
                                                if (i4 == 1) {
                                                    try {
                                                        if (this.f2918a.f2028M.m4342b() != null && (this.f2918a.f2028M.m4342b() == null || this.f2918a.f2028M.m4342b().equals(profileImage.profileimageid))) {
                                                            if (this.f2918a.f2028M.m4342b() != null && this.f2918a.f2028M.m4342b().equals(profileImage.profileimageid)) {
                                                                this.f2918a.f2028M.m4341a(true);
                                                                arrayList.add("1:" + profileImage.profileimageid);
                                                            }
                                                        } else {
                                                            BuddyProfileFragment.m3626ag(this.f2918a);
                                                            this.f2918a.f2047aF.m11730a(this.f2918a.f2028M.m4339a(), new CallableC0698fi(this.f2918a.f2024I, profileImage.profileimageurl + this.f2918a.f2048aG + this.f2918a.f2050aI, 60, 60, this.f2918a.f2058aQ.getCacheDir() + "/" + this.f2918a.f2117t + "/", profileImage.profileimageid));
                                                            arrayList.add("1:" + profileImage.profileimageid);
                                                        }
                                                        this.f2918a.f2028M.m4340a(profileImage.profileimageid);
                                                    } catch (Exception e3) {
                                                        if (C3250y.f11737e) {
                                                            C3250y.m11443a(e3, getClass().getSimpleName());
                                                        }
                                                    } catch (OutOfMemoryError e4) {
                                                        if (C3250y.f11737e) {
                                                            C3250y.m11443a(e4, getClass().getSimpleName());
                                                        }
                                                    }
                                                } else if (i4 == 2) {
                                                    if (this.f2918a.f2029N.m4342b() != null && (this.f2918a.f2029N.m4342b() == null || this.f2918a.f2029N.m4342b().equals(profileImage.profileimageid))) {
                                                        if (this.f2918a.f2029N.m4342b() != null && this.f2918a.f2029N.m4342b().equals(profileImage.profileimageid)) {
                                                            this.f2918a.f2029N.m4341a(true);
                                                            arrayList.add("2:" + profileImage.profileimageid);
                                                        }
                                                    } else {
                                                        BuddyProfileFragment.m3626ag(this.f2918a);
                                                        this.f2918a.f2047aF.m11730a(this.f2918a.f2029N.m4339a(), new CallableC0698fi(this.f2918a.f2025J, profileImage.profileimageurl + this.f2918a.f2048aG + this.f2918a.f2050aI, 60, 60, this.f2918a.f2058aQ.getCacheDir() + "/" + this.f2918a.f2117t + "/", profileImage.profileimageid));
                                                        arrayList.add("2:" + profileImage.profileimageid);
                                                    }
                                                    this.f2918a.f2029N.m4340a(profileImage.profileimageid);
                                                } else if (i4 == 3) {
                                                    if (this.f2918a.f2030O.m4342b() != null && (this.f2918a.f2030O.m4342b() == null || this.f2918a.f2030O.m4342b().equals(profileImage.profileimageid))) {
                                                        if (this.f2918a.f2030O.m4342b() != null && this.f2918a.f2030O.m4342b().equals(profileImage.profileimageid)) {
                                                            this.f2918a.f2030O.m4341a(true);
                                                            arrayList.add("3:" + profileImage.profileimageid);
                                                        }
                                                    } else {
                                                        BuddyProfileFragment.m3626ag(this.f2918a);
                                                        this.f2918a.f2047aF.m11730a(this.f2918a.f2030O.m4339a(), new CallableC0698fi(this.f2918a.f2026K, profileImage.profileimageurl + this.f2918a.f2048aG + this.f2918a.f2050aI, 60, 60, this.f2918a.f2058aQ.getCacheDir() + "/" + this.f2918a.f2117t + "/", profileImage.profileimageid));
                                                        arrayList.add("3:" + profileImage.profileimageid);
                                                    }
                                                    this.f2918a.f2030O.m4340a(profileImage.profileimageid);
                                                }
                                                this.f2918a.m3723c();
                                                i3 = i4 + 1;
                                            }
                                        }
                                        C3231f.m11361a(this.f2918a.f2058aQ).m11384a(this.f2918a.f2117t, arrayList);
                                        if (this.f2918a.f2018C > 4) {
                                            this.f2918a.f2031P.setVisibility(0);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                return;
                            }
                            this.f2918a.m3725d();
                            return;
                        }
                        return;
                    }
                    if (c0267d2.m11704n() && c0267d2.m1351b() == EnumC1587o.NO_CONTENT) {
                        this.f2918a.m3725d();
                    }
                    if (this.f2918a.f2018C > 4) {
                        this.f2918a.f2031P.setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }
}
