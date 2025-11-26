package com.sec.chaton.buddy.dialog;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.buddy.CallableC0698fi;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.p028a.C1364h;
import com.sec.chaton.p027e.p028a.C1365i;
import com.sec.chaton.p035io.entry.GetProfileImageList;
import com.sec.chaton.p035io.entry.inner.BuddyProfile;
import com.sec.chaton.p035io.entry.inner.CoverStory;
import com.sec.chaton.p035io.entry.inner.CoverStoryDownload;
import com.sec.chaton.p035io.entry.inner.ProfileImage;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.poston.C1960a;
import com.sec.chaton.util.C3231f;
import com.sec.chaton.util.C3250y;
import java.io.File;
import java.util.ArrayList;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: BuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.b */
/* loaded from: classes.dex */
class HandlerC0620b extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyDialog f2840a;

    HandlerC0620b(BuddyDialog buddyDialog) {
        this.f2840a = buddyDialog;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        boolean z;
        if (this.f2840a.getApplicationContext() == null || this.f2840a.f2687y == null) {
            if (C3250y.f11734b) {
                C3250y.m11450b("[BuddyDialog] mContext is null ", getClass().getSimpleName());
                return;
            }
            return;
        }
        switch (message.what) {
            case 411:
                C0267d c0267d = (C0267d) message.obj;
                if (c0267d != null) {
                    if (!c0267d.m11704n() || c0267d.m1351b() != EnumC1587o.SUCCESS || ((BuddyProfile) c0267d.m1354e()) != null) {
                        this.f2840a.f2634aG = true;
                        return;
                    }
                    return;
                }
                return;
            case 412:
                C0267d c0267d2 = (C0267d) message.obj;
                ArrayList<String> arrayList = new ArrayList<>();
                if (c0267d2 == null) {
                    this.f2840a.f2635aH = true;
                    if (this.f2840a.f2677o != null) {
                        this.f2840a.f2677o.m5938d(this.f2840a.f2666d);
                        return;
                    }
                    return;
                }
                if (c0267d2.m11704n() && c0267d2.m1351b() == EnumC1587o.SUCCESS) {
                    GetProfileImageList getProfileImageList = (GetProfileImageList) c0267d2.m1354e();
                    if (getProfileImageList == null) {
                        this.f2840a.f2635aH = true;
                        if (this.f2840a.f2677o != null) {
                            this.f2840a.f2677o.m5938d(this.f2840a.f2666d);
                            return;
                        }
                        return;
                    }
                    ArrayList<ProfileImage> arrayList2 = getProfileImageList.profileimagelist;
                    this.f2840a.f2636aI = getProfileImageList.listcount.intValue();
                    if (arrayList2 == null || arrayList2.size() == 0) {
                        this.f2840a.m4197b();
                        this.f2840a.f2635aH = true;
                        if (this.f2840a.f2677o != null) {
                            this.f2840a.f2677o.m5938d(this.f2840a.f2666d);
                            return;
                        }
                        return;
                    }
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        this.f2840a.f2676n = 0;
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
                        if (!z && this.f2840a.f2636aI == 0) {
                            this.f2840a.m4197b();
                            this.f2840a.f2635aH = true;
                            if (this.f2840a.f2677o != null) {
                                this.f2840a.f2677o.m5938d(this.f2840a.f2666d);
                                return;
                            }
                            return;
                        }
                    }
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        this.f2840a.m4193a(arrayList2.size());
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 < arrayList2.size()) {
                                ProfileImage profileImage = arrayList2.get(i4);
                                if ("1".equals(profileImage.represent)) {
                                    try {
                                        C3250y.m11450b("Profile URL : " + profileImage.profileimageurl, getClass().getSimpleName());
                                        String strM11388c = C3231f.m11361a(this.f2840a.getApplicationContext()).m11388c(this.f2840a.f2666d);
                                        if (strM11388c != null && !TextUtils.isEmpty(profileImage.update_msec) && !TextUtils.isEmpty(strM11388c)) {
                                            if (!strM11388c.equals(profileImage.update_msec)) {
                                                C3250y.m11450b("***********Timestamp unmatch need to reload main image : " + profileImage.update_msec, "TIME");
                                                C3231f.m11361a(this.f2840a.getApplicationContext()).m11383a(this.f2840a.f2666d, profileImage.profileimageid);
                                                this.f2840a.f2616O.m4340a((String) null);
                                            } else {
                                                C3250y.m11450b("***********Timestamp match : " + profileImage.update_msec, "TIME");
                                            }
                                        }
                                        if (this.f2840a.f2616O.m4342b() != null && (this.f2840a.f2616O.m4342b() == null || this.f2840a.f2616O.m4342b().equals(profileImage.profileimageid))) {
                                            if (this.f2840a.f2616O.m4342b() != null && this.f2840a.f2616O.m4342b().equals(profileImage.profileimageid)) {
                                                this.f2840a.f2616O.m4341a(true);
                                                this.f2840a.f2616O.m4339a().setFocusable(true);
                                                arrayList.add("0:" + profileImage.profileimageid);
                                            }
                                        } else {
                                            BuddyDialog.m4145f(this.f2840a);
                                            C3231f.m11361a(this.f2840a.getApplicationContext()).m11383a(this.f2840a.f2666d, profileImage.profileimageid);
                                            this.f2840a.f2642ac.m11730a(this.f2840a.f2604C, new CallableC0698fi(this.f2840a.f2608G, profileImage.profileimageurl + this.f2840a.f2643ad + this.f2840a.f2644ae, HttpResponseCode.INTERNAL_SERVER_ERROR, HttpResponseCode.INTERNAL_SERVER_ERROR, this.f2840a.getApplicationContext().getCacheDir() + "/" + this.f2840a.f2666d + "/", profileImage.profileimageid, true));
                                            arrayList.add("0:" + profileImage.profileimageid);
                                        }
                                        if (!TextUtils.isEmpty(profileImage.update_msec)) {
                                            C3231f.m11361a(this.f2840a.getApplicationContext()).m11387b(this.f2840a.f2666d, profileImage.update_msec);
                                        }
                                    } catch (Exception e) {
                                        C3250y.m11443a(e, getClass().getSimpleName());
                                    } catch (OutOfMemoryError e2) {
                                        e2.printStackTrace();
                                    }
                                    this.f2840a.f2616O.m4340a(profileImage.profileimageid);
                                    this.f2840a.m4192a();
                                    i3 = i4 + 1;
                                } else {
                                    C3250y.m11450b("Profile URL : " + profileImage.profileimageurl, getClass().getSimpleName());
                                    if (i4 == 1) {
                                        try {
                                            if (this.f2840a.f2617P.m4342b() != null && (this.f2840a.f2617P.m4342b() == null || this.f2840a.f2617P.m4342b().equals(profileImage.profileimageid))) {
                                                if (this.f2840a.f2617P.m4342b() != null && this.f2840a.f2617P.m4342b().equals(profileImage.profileimageid)) {
                                                    this.f2840a.f2617P.m4341a(true);
                                                    this.f2840a.f2617P.m4339a().setFocusable(true);
                                                    arrayList.add("1:" + profileImage.profileimageid);
                                                }
                                            } else {
                                                BuddyDialog.m4145f(this.f2840a);
                                                this.f2840a.f2642ac.m11730a(this.f2840a.f2617P.m4339a(), new CallableC0698fi(this.f2840a.f2609H, profileImage.profileimageurl + this.f2840a.f2643ad + this.f2840a.f2645af, 60, 60, this.f2840a.getApplicationContext().getCacheDir() + "/" + this.f2840a.f2666d + "/", profileImage.profileimageid));
                                                arrayList.add("1:" + profileImage.profileimageid);
                                            }
                                            this.f2840a.f2617P.m4340a(profileImage.profileimageid);
                                        } catch (Exception e3) {
                                            C3250y.m11443a(e3, getClass().getSimpleName());
                                        } catch (OutOfMemoryError e4) {
                                            e4.printStackTrace();
                                        }
                                    } else if (i4 == 2) {
                                        if (this.f2840a.f2618Q.m4342b() != null && (this.f2840a.f2618Q.m4342b() == null || this.f2840a.f2618Q.m4342b().equals(profileImage.profileimageid))) {
                                            if (this.f2840a.f2618Q.m4342b() != null && this.f2840a.f2618Q.m4342b().equals(profileImage.profileimageid)) {
                                                this.f2840a.f2618Q.m4341a(true);
                                                this.f2840a.f2618Q.m4339a().setFocusable(true);
                                                arrayList.add("2:" + profileImage.profileimageid);
                                            }
                                        } else {
                                            BuddyDialog.m4145f(this.f2840a);
                                            this.f2840a.f2642ac.m11730a(this.f2840a.f2618Q.m4339a(), new CallableC0698fi(this.f2840a.f2610I, profileImage.profileimageurl + this.f2840a.f2643ad + this.f2840a.f2645af, 60, 60, this.f2840a.getApplicationContext().getCacheDir() + "/" + this.f2840a.f2666d + "/", profileImage.profileimageid));
                                            arrayList.add("2:" + profileImage.profileimageid);
                                        }
                                        this.f2840a.f2618Q.m4340a(profileImage.profileimageid);
                                    } else if (i4 == 3) {
                                        if (this.f2840a.f2619R.m4342b() != null && (this.f2840a.f2619R.m4342b() == null || this.f2840a.f2619R.m4342b().equals(profileImage.profileimageid))) {
                                            if (this.f2840a.f2619R.m4342b() != null && this.f2840a.f2619R.m4342b().equals(profileImage.profileimageid)) {
                                                this.f2840a.f2619R.m4341a(true);
                                                this.f2840a.f2619R.m4339a().setFocusable(true);
                                                arrayList.add("3:" + profileImage.profileimageid);
                                            }
                                        } else {
                                            BuddyDialog.m4145f(this.f2840a);
                                            this.f2840a.f2642ac.m11730a(this.f2840a.f2619R.m4339a(), new CallableC0698fi(this.f2840a.f2611J, profileImage.profileimageurl + this.f2840a.f2643ad + this.f2840a.f2645af, 60, 60, this.f2840a.getApplicationContext().getCacheDir() + "/" + this.f2840a.f2666d + "/", profileImage.profileimageid));
                                            arrayList.add("3:" + profileImage.profileimageid);
                                        }
                                        this.f2840a.f2619R.m4340a(profileImage.profileimageid);
                                    }
                                    this.f2840a.m4192a();
                                    i3 = i4 + 1;
                                }
                            }
                            C3231f.m11361a(this.f2840a.getApplicationContext()).m11384a(this.f2840a.f2666d, arrayList);
                            if (this.f2840a.f2676n == 0) {
                                this.f2840a.f2635aH = true;
                            }
                            if (this.f2840a.f2677o != null) {
                                this.f2840a.f2677o.m5938d(this.f2840a.f2666d);
                            }
                            if (this.f2840a.f2636aI > 4) {
                                this.f2840a.f2612K.setVisibility(0);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                if (c0267d2.m11704n() && c0267d2.m1351b() == EnumC1587o.NO_CONTENT) {
                    this.f2840a.m4197b();
                }
                this.f2840a.f2635aH = true;
                this.f2840a.f2677o.m5938d(this.f2840a.f2666d);
                if (this.f2840a.f2636aI > 4) {
                    this.f2840a.f2612K.setVisibility(0);
                    return;
                }
                return;
            case 3001:
                C0267d c0267d3 = (C0267d) message.obj;
                C3250y.m11450b("CoverStoryControl.METHOD_GET_COVERSTORY", getClass().getSimpleName());
                if (c0267d3 == null) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("CoverStoryControl.METHOD_GET_COVERSTORY (httpEntry == null)", getClass().getSimpleName());
                        return;
                    }
                    return;
                }
                if (c0267d3.m11704n() && c0267d3.m1351b() == EnumC1587o.SUCCESS) {
                    CoverStory coverStory = (CoverStory) c0267d3.m1354e();
                    if (coverStory == null) {
                        C3250y.m11450b("CoverStoryControl.METHOD_GET_COVERSTORY dialogCoverStory is null !!!", getClass().getSimpleName());
                        return;
                    }
                    if (coverStory.metaid != null) {
                        this.f2840a.f2683u = this.f2840a.getApplicationContext().getCacheDir() + "/" + this.f2840a.f2666d + "/coverstory/";
                        if (coverStory.contentid != null) {
                            if (!this.f2840a.m4195a(coverStory.contentid, this.f2840a.f2666d)) {
                                this.f2840a.f2678p.m5760a(coverStory.contentid, Integer.toString(this.f2840a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(this.f2840a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
                                this.f2840a.f2686x = coverStory.contentid;
                                return;
                            }
                            return;
                        }
                        this.f2840a.f2642ac.m11730a(this.f2840a.f2682t, new C1960a(coverStory.host + coverStory.metacontents, this.f2840a.f2666d, this.f2840a.f2683u, "buddy", this.f2840a.getApplicationContext()));
                        return;
                    }
                    C3250y.m11450b("Buddy didn't set Coverstory ", getClass().getSimpleName());
                    String strM6090a = C1365i.m6090a();
                    if (strM6090a != null) {
                        if (!this.f2840a.m4195a(strM6090a, this.f2840a.f2666d)) {
                            this.f2840a.f2678p.m5760a(strM6090a, Integer.toString(this.f2840a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(this.f2840a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
                            this.f2840a.f2686x = strM6090a;
                        }
                    } else {
                        C3250y.m11450b(" Random ERROR !!", getClass().getSimpleName());
                    }
                    C3250y.m11450b(" Set RandomCoverStory randomId : " + strM6090a, getClass().getSimpleName());
                    return;
                }
                if (c0267d3.m11704n() && c0267d3.m1351b() == EnumC1587o.NO_CONTENT) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("CoverStoryControl.METHOD_GET_COVERSTORY NO_CONTENT", BuddyDialog.f2599a);
                        return;
                    }
                    return;
                }
                if (C3250y.f11734b) {
                    C3250y.m11450b("CoverStoryControl.METHOD_GET_COVERSTORY network ERROR", BuddyDialog.f2599a);
                }
                String str = this.f2840a.getApplicationContext().getCacheDir() + "/" + this.f2840a.f2666d + "/coverstory/";
                File file = new File(str + "coverstory.jpg");
                if (C3250y.f11734b) {
                    C3250y.m11450b("CoverStoryControl.METHOD_GET_COVERSTORY mBuddyCoverStoryFile : " + str + "coverstory.jpg", BuddyDialog.f2599a);
                }
                if (!file.exists()) {
                    boolean zM4194a = this.f2840a.m4194a(this.f2840a.f2666d);
                    if (C3250y.f11734b) {
                        C3250y.m11450b("CoverStoryControl.METHOD_GET_COVERSTORY result : " + zM4194a, BuddyDialog.f2599a);
                        return;
                    }
                    return;
                }
                return;
            case 3005:
                C0267d c0267d4 = (C0267d) message.obj;
                if (c0267d4 == null) {
                    C3250y.m11450b("CoverStoryControl.METHOD_CONTENT_COVERSTORY_DOWNLOAD (httpEntry == null)", getClass().getSimpleName());
                    return;
                }
                if (c0267d4.m11704n() && c0267d4.m1354e() != null && c0267d4.m1351b() != EnumC1587o.ERROR) {
                    CoverStoryDownload coverStoryDownload = (CoverStoryDownload) c0267d4.m1354e();
                    this.f2840a.f2683u = this.f2840a.getApplicationContext().getCacheDir() + "/" + this.f2840a.f2666d + "/coverstory/";
                    this.f2840a.f2642ac.m11730a(this.f2840a.f2682t, new C1960a(coverStoryDownload.fileurl, this.f2840a.f2666d, C1960a.f7636b, this.f2840a.getApplicationContext(), this.f2840a.f2683u, "coverstory.jpg", this.f2840a.f2686x));
                    if (this.f2840a.f2686x != null) {
                        this.f2840a.f2686x = null;
                        return;
                    }
                    return;
                }
                if (c0267d4.m11704n() && c0267d4.m1351b() == EnumC1587o.NO_CONTENT) {
                    C3250y.m11450b("Deleted item on BuddyDialog mContentId : " + this.f2840a.f2686x, getClass().getSimpleName());
                    C1364h.m6088b(this.f2840a.f2686x);
                    if (this.f2840a.f2686x != null) {
                        this.f2840a.f2686x = null;
                    }
                    this.f2840a.m4199c();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
