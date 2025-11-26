package com.sec.chaton.buddy;

import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p057e.p058a.C2194h;
import com.sec.chaton.p057e.p058a.C2195i;
import com.sec.chaton.p065io.entry.GetProfileImageList;
import com.sec.chaton.p065io.entry.inner.Buddy;
import com.sec.chaton.p065io.entry.inner.BuddyProfile;
import com.sec.chaton.p065io.entry.inner.BuddyProfileNew;
import com.sec.chaton.p065io.entry.inner.CoverStory;
import com.sec.chaton.p065io.entry.inner.CoverStoryDownload;
import com.sec.chaton.p065io.entry.inner.ProfileImage;
import com.sec.chaton.p065io.entry.inner.ProfileInformationList;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.poston.C2955a;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4883f;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.ft */
/* loaded from: classes.dex */
class HandlerC1313ft extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f4849a;

    HandlerC1313ft(BuddyProfileFragment buddyProfileFragment) {
        this.f4849a = buddyProfileFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        boolean z;
        int i;
        int i2;
        if (this.f4849a.f4010q != null) {
            if (this.f4849a.f3964ae.isShowing()) {
                this.f4849a.f3964ae.dismiss();
            }
            switch (message.what) {
                case 411:
                    C0778b c0778b = (C0778b) message.obj;
                    if (c0778b == null || !c0778b.m18954n() || c0778b.m3107b() != EnumC2464o.SUCCESS || ((BuddyProfile) c0778b.m3110e()) == null) {
                    }
                    return;
                case 412:
                    C0778b c0778b2 = (C0778b) message.obj;
                    ArrayList<String> arrayList = new ArrayList<>();
                    if (c0778b2 != null) {
                        if (c0778b2.m18954n() && c0778b2.m3107b() == EnumC2464o.SUCCESS) {
                            GetProfileImageList getProfileImageList = (GetProfileImageList) c0778b2.m3110e();
                            if (getProfileImageList != null) {
                                ArrayList<ProfileImage> arrayList2 = getProfileImageList.profileimagelist;
                                this.f4849a.f3911D = getProfileImageList.listcount.intValue();
                                if (arrayList2 == null || arrayList2.size() == 0) {
                                    this.f4849a.m6862d();
                                    return;
                                }
                                int i3 = 0;
                                while (true) {
                                    int i4 = i3;
                                    if (i4 < arrayList2.size()) {
                                        if (Spam.ACTIVITY_REPORT.equals(arrayList2.get(i4).represent)) {
                                            this.f4849a.f3909B = true;
                                        } else {
                                            i3 = i4 + 1;
                                        }
                                    }
                                }
                                if (!this.f4849a.f3909B && this.f4849a.f3911D == 0) {
                                    this.f4849a.m6862d();
                                    return;
                                }
                                if (arrayList2 != null && arrayList2.size() > 0) {
                                    if (this.f4849a.f3909B) {
                                        i2 = 0;
                                    } else {
                                        i2 = 1;
                                    }
                                    if (this.f4849a.f3909B) {
                                        this.f4849a.m6851a(arrayList2.size());
                                    } else {
                                        this.f4849a.m6851a(arrayList2.size() + i2);
                                        this.f4849a.f3921N.m7482a().setImageBitmap(BitmapFactory.decodeResource(this.f4849a.f3921N.m7482a().getContext().getResources(), R.drawable.profile_photo_buddy_default));
                                        this.f4849a.f3921N.m7484a(false);
                                    }
                                    int i5 = 0;
                                    while (true) {
                                        int i6 = i5;
                                        if (i6 < arrayList2.size()) {
                                            ProfileImage profileImage = arrayList2.get(i6);
                                            if (i6 == 0 && !this.f4849a.f3909B && !TextUtils.isEmpty(profileImage.update_msec)) {
                                                C1331gk.m7453a(this.f4849a.f3954aU).m7471b(this.f4849a.f4013t, profileImage.update_msec);
                                            }
                                            if (Spam.ACTIVITY_REPORT.equals(profileImage.represent)) {
                                                try {
                                                    try {
                                                        C4904y.m18639b("Profile URL : " + profileImage.profileimageurl, getClass().getSimpleName());
                                                        String strM7472c = C1331gk.m7453a(this.f4849a.f3954aU).m7472c(this.f4849a.f4013t);
                                                        if (strM7472c != null && !TextUtils.isEmpty(profileImage.update_msec) && !TextUtils.isEmpty(strM7472c)) {
                                                            if (!strM7472c.equals(profileImage.update_msec)) {
                                                                C4904y.m18639b("***********Timestamp unmatch need to reload main image : " + profileImage.update_msec, "TIME");
                                                                C1331gk.m7453a(this.f4849a.f3954aU).m7468a(this.f4849a.f4013t, profileImage.profileimageid);
                                                                this.f4849a.f3921N.m7483a((String) null);
                                                            } else {
                                                                C4904y.m18639b("***********Timestamp match : " + profileImage.update_msec, "TIME");
                                                            }
                                                        }
                                                        if (this.f4849a.f3921N.m7485b() != null && (this.f4849a.f3921N.m7485b() == null || this.f4849a.f3921N.m7485b().equals(profileImage.profileimageid))) {
                                                            if (this.f4849a.f3921N.m7485b() != null && this.f4849a.f3921N.m7485b().equals(profileImage.profileimageid)) {
                                                                this.f4849a.f3921N.m7484a(true);
                                                                arrayList.add("0:" + profileImage.profileimageid);
                                                            }
                                                        } else {
                                                            BuddyProfileFragment.m6772S(this.f4849a);
                                                            C1331gk.m7453a(this.f4849a.f3954aU).m7468a(this.f4849a.f4013t, profileImage.profileimageid);
                                                            this.f4849a.f3943aJ.m19023b(this.f4849a.f3913F, new CallableC1330gj(this.f4849a.f3917J, profileImage.profileimageurl + this.f4849a.f3944aK + this.f4849a.f3945aL, 500, 500, this.f4849a.f3954aU.getCacheDir() + "/" + this.f4849a.f4013t + "/", profileImage.profileimageid, true));
                                                            arrayList.add("0:" + profileImage.profileimageid);
                                                            C2496n.m10790e(CommonApplication.m18732r(), this.f4849a.f4013t);
                                                        }
                                                        if (!TextUtils.isEmpty(profileImage.update_msec)) {
                                                            C1331gk.m7453a(this.f4849a.f3954aU).m7471b(this.f4849a.f4013t, profileImage.update_msec);
                                                        }
                                                    } catch (OutOfMemoryError e) {
                                                        C4904y.m18635a(e, getClass().getSimpleName());
                                                    }
                                                    this.f4849a.f3921N.m7483a(profileImage.profileimageid);
                                                    i5 = i6 + 1;
                                                } catch (Exception e2) {
                                                    C4904y.m18635a(e2, getClass().getSimpleName());
                                                }
                                            } else {
                                                C4904y.m18639b("Profile URL : " + profileImage.profileimageurl, getClass().getSimpleName());
                                                if (i6 == 1 - i2) {
                                                    try {
                                                        if (this.f4849a.f3922O.m7485b() != null && (this.f4849a.f3922O.m7485b() == null || this.f4849a.f3922O.m7485b().equals(profileImage.profileimageid))) {
                                                            if (this.f4849a.f3922O.m7485b() != null && this.f4849a.f3922O.m7485b().equals(profileImage.profileimageid)) {
                                                                this.f4849a.f3922O.m7484a(true);
                                                                arrayList.add("1:" + profileImage.profileimageid);
                                                            }
                                                        } else {
                                                            BuddyProfileFragment.m6772S(this.f4849a);
                                                            this.f4849a.f3943aJ.m19023b(this.f4849a.f3922O.m7482a(), new CallableC1330gj(this.f4849a.f3918K, profileImage.profileimageurl + this.f4849a.f3944aK + this.f4849a.f3946aM, 60, 60, this.f4849a.f3954aU.getCacheDir() + "/" + this.f4849a.f4013t + "/", profileImage.profileimageid));
                                                            arrayList.add("1:" + profileImage.profileimageid);
                                                        }
                                                        this.f4849a.f3922O.m7483a(profileImage.profileimageid);
                                                    } catch (Exception e3) {
                                                        if (C4904y.f17875e) {
                                                            C4904y.m18635a(e3, getClass().getSimpleName());
                                                        }
                                                    } catch (OutOfMemoryError e4) {
                                                        if (C4904y.f17875e) {
                                                            C4904y.m18635a(e4, getClass().getSimpleName());
                                                        }
                                                    }
                                                } else if (i6 == 2 - i2) {
                                                    if (this.f4849a.f3923P.m7485b() != null && (this.f4849a.f3923P.m7485b() == null || this.f4849a.f3923P.m7485b().equals(profileImage.profileimageid))) {
                                                        if (this.f4849a.f3923P.m7485b() != null && this.f4849a.f3923P.m7485b().equals(profileImage.profileimageid)) {
                                                            this.f4849a.f3923P.m7484a(true);
                                                            arrayList.add("2:" + profileImage.profileimageid);
                                                        }
                                                    } else {
                                                        BuddyProfileFragment.m6772S(this.f4849a);
                                                        this.f4849a.f3943aJ.m19023b(this.f4849a.f3923P.m7482a(), new CallableC1330gj(this.f4849a.f3919L, profileImage.profileimageurl + this.f4849a.f3944aK + this.f4849a.f3946aM, 60, 60, this.f4849a.f3954aU.getCacheDir() + "/" + this.f4849a.f4013t + "/", profileImage.profileimageid));
                                                        arrayList.add("2:" + profileImage.profileimageid);
                                                    }
                                                    this.f4849a.f3923P.m7483a(profileImage.profileimageid);
                                                } else if (i6 == 3 - i2) {
                                                    if (this.f4849a.f3924Q.m7485b() != null && (this.f4849a.f3924Q.m7485b() == null || this.f4849a.f3924Q.m7485b().equals(profileImage.profileimageid))) {
                                                        if (this.f4849a.f3924Q.m7485b() != null && this.f4849a.f3924Q.m7485b().equals(profileImage.profileimageid)) {
                                                            this.f4849a.f3924Q.m7484a(true);
                                                            arrayList.add("3:" + profileImage.profileimageid);
                                                        }
                                                    } else {
                                                        BuddyProfileFragment.m6772S(this.f4849a);
                                                        this.f4849a.f3943aJ.m19023b(this.f4849a.f3924Q.m7482a(), new CallableC1330gj(this.f4849a.f3920M, profileImage.profileimageurl + this.f4849a.f3944aK + this.f4849a.f3946aM, 60, 60, this.f4849a.f3954aU.getCacheDir() + "/" + this.f4849a.f4013t + "/", profileImage.profileimageid));
                                                        arrayList.add("3:" + profileImage.profileimageid);
                                                    }
                                                    this.f4849a.f3924Q.m7483a(profileImage.profileimageid);
                                                }
                                                i5 = i6 + 1;
                                            }
                                        }
                                        this.f4849a.m6861c();
                                        C1331gk.m7453a(this.f4849a.f3954aU).m7469a(this.f4849a.f4013t, arrayList);
                                        if (Spam.ACTIVITY_REPORT.equals(arrayList2.get(0).represent)) {
                                            if (this.f4849a.f3911D > 4 && this.f4849a.f3925R != null) {
                                                this.f4849a.f3925R.setVisibility(0);
                                                return;
                                            }
                                            return;
                                        }
                                        if (this.f4849a.f3911D > 3 && this.f4849a.f3925R != null) {
                                            this.f4849a.f3925R.setVisibility(0);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        if (c0778b2.m18954n() && c0778b2.m3107b() == EnumC2464o.NO_CONTENT) {
                            this.f4849a.m6862d();
                            return;
                        }
                        return;
                    }
                    return;
                case 417:
                    C0778b c0778b3 = (C0778b) message.obj;
                    C4904y.m18639b("ProfileControl.METHOD_PROFILE_INFORMATION", getClass().getSimpleName());
                    if (c0778b3 != null) {
                        this.f4849a.f3935aB = CommonApplication.m18732r().getCacheDir() + "/" + this.f4849a.f4013t + "/coverstory/";
                        if (c0778b3.m18954n() && c0778b3.m3107b() == EnumC2464o.SUCCESS) {
                            ProfileInformationList profileInformationList = (ProfileInformationList) c0778b3.m3110e();
                            BuddyProfile buddyProfile = profileInformationList.profile;
                            CoverStory coverStory = profileInformationList.coverstory;
                            GetProfileImageList getProfileImageList2 = profileInformationList.profileimage;
                            if (buddyProfile.timestamp != null) {
                            }
                            if (coverStory.metaid != null) {
                                boolean z2 = true;
                                ContentResolver contentResolver = GlobalApplication.m10279a().getContentResolver();
                                String strM9847j = C2190d.m9847j(contentResolver, this.f4849a.f4013t);
                                C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY previousMetaId : " + strM9847j + "### new MetaId : " + coverStory.metaid, BuddyProfileFragment.f3906a);
                                if (!TextUtils.isEmpty(strM9847j) && strM9847j.equals(coverStory.metaid)) {
                                    File file = new File(this.f4849a.f3935aB + "coverstory.jpg");
                                    if (file.exists() && file.length() > 0) {
                                        C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY Same coverstory~!!!", BuddyProfileFragment.f3906a);
                                        z2 = false;
                                    }
                                    C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY Same metaid but there is no coverstoryfile~!!!", BuddyProfileFragment.f3906a);
                                }
                                if (z2) {
                                    try {
                                        C2190d.m9830c(contentResolver, this.f4849a.f4013t, coverStory.metaid);
                                    } catch (OperationApplicationException e5) {
                                        e5.printStackTrace();
                                    } catch (RemoteException e6) {
                                        e6.printStackTrace();
                                    }
                                    if (coverStory.contentid != null) {
                                        if (!BuddyDialog.m7180a(coverStory.contentid, this.f4849a.f4013t, this.f4849a.f3936aC, this.f4849a.f3934aA, this.f4849a.f3981aw)) {
                                            this.f4849a.f3983ay.m9540a(coverStory.contentid, Integer.toString(this.f4849a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(this.f4849a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
                                            this.f4849a.f3984az = coverStory.contentid;
                                        }
                                    } else {
                                        if (C4904y.f17872b) {
                                            C4904y.m18639b("coverstory directly access test", BuddyProfileFragment.f3906a);
                                        }
                                        this.f4849a.f3943aJ.m19023b(this.f4849a.f3981aw, new C2955a(coverStory.host + coverStory.metacontents, this.f4849a.f4013t, this.f4849a.f3935aB, "buddy", CommonApplication.m18732r()));
                                    }
                                }
                            } else {
                                C4904y.m18639b("Buddy didn't set Coverstory ", BuddyProfileFragment.f3906a);
                                String strM9895a = C2195i.m9895a();
                                if (strM9895a != null) {
                                    if (!BuddyDialog.m7180a(strM9895a, this.f4849a.f4013t, this.f4849a.f3936aC, this.f4849a.f3934aA, this.f4849a.f3981aw)) {
                                        this.f4849a.f3983ay.m9540a(strM9895a, Integer.toString(this.f4849a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(this.f4849a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
                                        this.f4849a.f3984az = strM9895a;
                                    }
                                    C4904y.m18639b(" Set RandomCoverStory randomId : " + strM9895a, BuddyProfileFragment.f3906a);
                                } else {
                                    C4904y.m18639b(" Random ERROR !!", BuddyProfileFragment.f3906a);
                                    this.f4849a.f3983ay.m9543b(Integer.toString(this.f4849a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(this.f4849a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
                                }
                            }
                            ArrayList<String> arrayList3 = new ArrayList<>();
                            if (getProfileImageList2.totalcount != null) {
                                ArrayList<ProfileImage> arrayList4 = getProfileImageList2.profileimagelist;
                                this.f4849a.f3911D = getProfileImageList2.listcount.intValue();
                                if (arrayList4 == null || arrayList4.size() == 0) {
                                    this.f4849a.m6862d();
                                    return;
                                }
                                int i7 = 0;
                                while (true) {
                                    int i8 = i7;
                                    if (i8 < arrayList4.size()) {
                                        if (Spam.ACTIVITY_REPORT.equals(arrayList4.get(i8).represent)) {
                                            this.f4849a.f3909B = true;
                                        } else {
                                            i7 = i8 + 1;
                                        }
                                    }
                                }
                                if (!this.f4849a.f3909B && this.f4849a.f3911D == 0) {
                                    this.f4849a.m6862d();
                                    return;
                                }
                                if (arrayList4 != null && arrayList4.size() > 0) {
                                    if (this.f4849a.f3909B) {
                                        i = 0;
                                    } else {
                                        i = 1;
                                    }
                                    if (this.f4849a.f3909B) {
                                        this.f4849a.m6851a(arrayList4.size());
                                    } else {
                                        this.f4849a.m6851a(arrayList4.size() + i);
                                        this.f4849a.f3921N.m7482a().setImageBitmap(BitmapFactory.decodeResource(this.f4849a.f3921N.m7482a().getContext().getResources(), R.drawable.profile_photo_buddy_default));
                                        this.f4849a.f3921N.m7484a(false);
                                    }
                                    int i9 = 0;
                                    while (true) {
                                        int i10 = i9;
                                        if (i10 < arrayList4.size()) {
                                            ProfileImage profileImage2 = arrayList4.get(i10);
                                            if (i10 == 0 && !this.f4849a.f3909B && !TextUtils.isEmpty(profileImage2.update_msec)) {
                                                C1331gk.m7453a(this.f4849a.f3954aU).m7471b(this.f4849a.f4013t, profileImage2.update_msec);
                                            }
                                            if (Spam.ACTIVITY_REPORT.equals(profileImage2.represent)) {
                                                try {
                                                    C4904y.m18639b("Profile URL : " + profileImage2.profileimageurl, getClass().getSimpleName());
                                                    String strM7472c2 = C1331gk.m7453a(this.f4849a.f3954aU).m7472c(this.f4849a.f4013t);
                                                    if (strM7472c2 != null && !TextUtils.isEmpty(profileImage2.update_msec) && !TextUtils.isEmpty(strM7472c2)) {
                                                        if (!strM7472c2.equals(profileImage2.update_msec)) {
                                                            C4904y.m18639b("***********Timestamp unmatch need to reload main image : " + profileImage2.update_msec, "TIME");
                                                            C1331gk.m7453a(this.f4849a.f3954aU).m7468a(this.f4849a.f4013t, profileImage2.profileimageid);
                                                            this.f4849a.f3921N.m7483a((String) null);
                                                        } else {
                                                            C4904y.m18639b("***********Timestamp match : " + profileImage2.update_msec, "TIME");
                                                        }
                                                    }
                                                    if (this.f4849a.f3921N.m7485b() != null && (this.f4849a.f3921N.m7485b() == null || this.f4849a.f3921N.m7485b().equals(profileImage2.profileimageid))) {
                                                        if (this.f4849a.f3921N.m7485b() != null && this.f4849a.f3921N.m7485b().equals(profileImage2.profileimageid)) {
                                                            this.f4849a.f3921N.m7484a(true);
                                                            arrayList3.add("0:" + profileImage2.profileimageid);
                                                        }
                                                    } else {
                                                        BuddyProfileFragment.m6772S(this.f4849a);
                                                        C1331gk.m7453a(this.f4849a.f3954aU).m7468a(this.f4849a.f4013t, profileImage2.profileimageid);
                                                        this.f4849a.f3943aJ.m19023b(this.f4849a.f3913F, new CallableC1330gj(this.f4849a.f3917J, profileImage2.profileimageurl + this.f4849a.f3944aK + this.f4849a.f3945aL, 500, 500, this.f4849a.f3954aU.getCacheDir() + "/" + this.f4849a.f4013t + "/", profileImage2.profileimageid, true));
                                                        arrayList3.add("0:" + profileImage2.profileimageid);
                                                        C2496n.m10790e(CommonApplication.m18732r(), this.f4849a.f4013t);
                                                    }
                                                    if (!TextUtils.isEmpty(profileImage2.update_msec)) {
                                                        C1331gk.m7453a(this.f4849a.f3954aU).m7471b(this.f4849a.f4013t, profileImage2.update_msec);
                                                    }
                                                } catch (Exception e7) {
                                                    C4904y.m18635a(e7, getClass().getSimpleName());
                                                } catch (OutOfMemoryError e8) {
                                                    C4904y.m18635a(e8, getClass().getSimpleName());
                                                }
                                                this.f4849a.f3921N.m7483a(profileImage2.profileimageid);
                                                i9 = i10 + 1;
                                            } else {
                                                C4904y.m18639b("Profile URL : " + profileImage2.profileimageurl, getClass().getSimpleName());
                                                if (i10 == 1 - i) {
                                                    try {
                                                        try {
                                                            if (this.f4849a.f3922O.m7485b() != null && (this.f4849a.f3922O.m7485b() == null || this.f4849a.f3922O.m7485b().equals(profileImage2.profileimageid))) {
                                                                if (this.f4849a.f3922O.m7485b() != null && this.f4849a.f3922O.m7485b().equals(profileImage2.profileimageid)) {
                                                                    this.f4849a.f3922O.m7484a(true);
                                                                    arrayList3.add("1:" + profileImage2.profileimageid);
                                                                }
                                                            } else {
                                                                BuddyProfileFragment.m6772S(this.f4849a);
                                                                this.f4849a.f3943aJ.m19023b(this.f4849a.f3922O.m7482a(), new CallableC1330gj(this.f4849a.f3918K, profileImage2.profileimageurl + this.f4849a.f3944aK + this.f4849a.f3946aM, 60, 60, this.f4849a.f3954aU.getCacheDir() + "/" + this.f4849a.f4013t + "/", profileImage2.profileimageid));
                                                                arrayList3.add("1:" + profileImage2.profileimageid);
                                                            }
                                                            this.f4849a.f3922O.m7483a(profileImage2.profileimageid);
                                                        } catch (OutOfMemoryError e9) {
                                                            if (C4904y.f17875e) {
                                                                C4904y.m18635a(e9, getClass().getSimpleName());
                                                            }
                                                        }
                                                    } catch (Exception e10) {
                                                        if (C4904y.f17875e) {
                                                            C4904y.m18635a(e10, getClass().getSimpleName());
                                                        }
                                                    }
                                                } else if (i10 == 2 - i) {
                                                    if (this.f4849a.f3923P.m7485b() != null && (this.f4849a.f3923P.m7485b() == null || this.f4849a.f3923P.m7485b().equals(profileImage2.profileimageid))) {
                                                        if (this.f4849a.f3923P.m7485b() != null && this.f4849a.f3923P.m7485b().equals(profileImage2.profileimageid)) {
                                                            this.f4849a.f3923P.m7484a(true);
                                                            arrayList3.add("2:" + profileImage2.profileimageid);
                                                        }
                                                    } else {
                                                        BuddyProfileFragment.m6772S(this.f4849a);
                                                        this.f4849a.f3943aJ.m19023b(this.f4849a.f3923P.m7482a(), new CallableC1330gj(this.f4849a.f3919L, profileImage2.profileimageurl + this.f4849a.f3944aK + this.f4849a.f3946aM, 60, 60, this.f4849a.f3954aU.getCacheDir() + "/" + this.f4849a.f4013t + "/", profileImage2.profileimageid));
                                                        arrayList3.add("2:" + profileImage2.profileimageid);
                                                    }
                                                    this.f4849a.f3923P.m7483a(profileImage2.profileimageid);
                                                } else if (i10 == 3 - i) {
                                                    if (this.f4849a.f3924Q.m7485b() != null && (this.f4849a.f3924Q.m7485b() == null || this.f4849a.f3924Q.m7485b().equals(profileImage2.profileimageid))) {
                                                        if (this.f4849a.f3924Q.m7485b() != null && this.f4849a.f3924Q.m7485b().equals(profileImage2.profileimageid)) {
                                                            this.f4849a.f3924Q.m7484a(true);
                                                            arrayList3.add("3:" + profileImage2.profileimageid);
                                                        }
                                                    } else {
                                                        BuddyProfileFragment.m6772S(this.f4849a);
                                                        this.f4849a.f3943aJ.m19023b(this.f4849a.f3924Q.m7482a(), new CallableC1330gj(this.f4849a.f3920M, profileImage2.profileimageurl + this.f4849a.f3944aK + this.f4849a.f3946aM, 60, 60, this.f4849a.f3954aU.getCacheDir() + "/" + this.f4849a.f4013t + "/", profileImage2.profileimageid));
                                                        arrayList3.add("3:" + profileImage2.profileimageid);
                                                    }
                                                    this.f4849a.f3924Q.m7483a(profileImage2.profileimageid);
                                                }
                                                i9 = i10 + 1;
                                            }
                                        }
                                        this.f4849a.m6861c();
                                        C1331gk.m7453a(this.f4849a.f3954aU).m7469a(this.f4849a.f4013t, arrayList3);
                                        if (Spam.ACTIVITY_REPORT.equals(arrayList4.get(0).represent)) {
                                            if (this.f4849a.f3911D > 4 && this.f4849a.f3925R != null) {
                                                this.f4849a.f3925R.setVisibility(0);
                                                return;
                                            }
                                            return;
                                        }
                                        if (this.f4849a.f3911D > 3 && this.f4849a.f3925R != null) {
                                            this.f4849a.f3925R.setVisibility(0);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        if (c0778b3.m18954n() && c0778b3.m3107b() == EnumC2464o.NO_CONTENT) {
                            if (C4904y.f17872b) {
                                C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY NO_CONTENT", BuddyProfileFragment.f3906a);
                                this.f4849a.f3983ay.m9543b(Integer.toString(this.f4849a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(this.f4849a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
                            }
                            this.f4849a.m6862d();
                            return;
                        }
                        if (C4904y.f17872b) {
                            C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY network ERROR", BuddyProfileFragment.f3906a);
                        }
                        this.f4849a.f3935aB = CommonApplication.m18732r().getCacheDir() + "/" + this.f4849a.f4013t + "/coverstory/";
                        File file2 = new File(this.f4849a.f3935aB + "coverstory.jpg");
                        if (C4904y.f17872b) {
                            C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY mBuddyCoverStoryFile : " + this.f4849a.f3935aB + "coverstory.jpg", BuddyProfileFragment.f3906a);
                        }
                        if (!file2.exists()) {
                            try {
                                boolean zM7179a = BuddyDialog.m7179a(this.f4849a.f4013t, this.f4849a.f3936aC, this.f4849a.f3934aA, this.f4849a.f3981aw);
                                if (C4904y.f17872b) {
                                    C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY result : " + zM7179a, BuddyProfileFragment.f3906a);
                                }
                                if (!zM7179a) {
                                    this.f4849a.f3983ay.m9543b(Integer.toString(this.f4849a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(this.f4849a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
                                    return;
                                }
                                return;
                            } catch (ArrayIndexOutOfBoundsException e11) {
                                if (C4904y.f17875e) {
                                    C4904y.m18635a(e11, getClass().getSimpleName());
                                    return;
                                }
                                return;
                            } catch (Exception e12) {
                                if (C4904y.f17875e) {
                                    C4904y.m18635a(e12, getClass().getSimpleName());
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    C4904y.m18639b("ProfileControl.METHOD_PROFILE_INFORMATION (httpEntry == null)", getClass().getSimpleName());
                    return;
                case 418:
                    C0778b c0778b4 = (C0778b) message.obj;
                    if (C4904y.f17872b) {
                        C4904y.m18639b("ProfileControl.METHOD_GET_HIDE_BUDDY_PROFILE", getClass().getSimpleName());
                    }
                    if (c0778b4 == null) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("ProfileControl.METHOD_GET_HIDE_BUDDY_PROFILE (httpEntry == null)", getClass().getSimpleName());
                            return;
                        }
                        return;
                    }
                    if (c0778b4.m18954n() && c0778b4.m3107b() == EnumC2464o.SUCCESS) {
                        BuddyProfileNew buddyProfileNew = (BuddyProfileNew) c0778b4.m3110e();
                        if (buddyProfileNew == null) {
                            if (C4904y.f17872b) {
                                C4904y.m18639b("ProfileControl.METHOD_GET_HIDE_BUDDY_PROFILE (buddyNew == null)", getClass().getSimpleName());
                                return;
                            }
                            return;
                        }
                        Buddy buddy = buddyProfileNew.buddy.get(0);
                        if (TextUtils.isEmpty(buddy.devicetype) || !buddy.devicetype.equals("web") || (!TextUtils.isEmpty(buddy.msisdns) && new StringTokenizer(buddy.msisdns, "|").countTokens() != 1)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        this.f4849a.f4016w = C4883f.m18540a(buddy.value, buddy.msisdns);
                        this.f4849a.f4012s = new C1106c(buddy.value, buddy.name, buddy.status, buddy.samsungemail, buddy.orgnum, buddy.orgnums, buddy.msisdns, this.f4849a.f4016w, buddy.birthday, false, 0, buddy.orgname, false, 0, 0, 0, 0, 0, 0, 0, false, false, buddy.showphonenumber.booleanValue() ? 1 : 0, buddy.einfo, z ? 1 : 0, buddy.sainfo, Spam.ACTIVITY_CANCEL, C2190d.m9810a(this.f4849a.f4016w, 1, buddy.showphonenumber, buddy.msisdns, buddy.value, buddy.orgnum, buddy.orgnums));
                        this.f4849a.m6799b(1);
                        return;
                    }
                    if (C4904y.f17872b) {
                        C4904y.m18639b("ProfileControl.METHOD_GET_HIDE_BUDDY_PROFILE httpEntry fail", BuddyProfileFragment.f3906a);
                        return;
                    }
                    return;
                case 3001:
                    C0778b c0778b5 = (C0778b) message.obj;
                    if (C4904y.f17872b) {
                        C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY", BuddyProfileFragment.f3906a);
                    }
                    if (c0778b5 != null) {
                        this.f4849a.f3935aB = CommonApplication.m18732r().getCacheDir() + "/" + this.f4849a.f4013t + "/coverstory/";
                        if (c0778b5.m18954n() && c0778b5.m3107b() == EnumC2464o.SUCCESS) {
                            CoverStory coverStory2 = (CoverStory) c0778b5.m3110e();
                            if (coverStory2 == null) {
                                C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY dialogCoverStory is null !!!", BuddyProfileFragment.f3906a);
                                return;
                            }
                            if (coverStory2.metaid != null) {
                                ContentResolver contentResolver2 = GlobalApplication.m10279a().getContentResolver();
                                String strM9847j2 = C2190d.m9847j(contentResolver2, this.f4849a.f4013t);
                                C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY previousMetaId : " + strM9847j2 + "### new MetaId : " + coverStory2.metaid, BuddyProfileFragment.f3906a);
                                if (!TextUtils.isEmpty(strM9847j2) && strM9847j2.equals(coverStory2.metaid)) {
                                    File file3 = new File(this.f4849a.f3935aB + "coverstory.jpg");
                                    if (file3.exists() && file3.length() > 0) {
                                        C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY Same coverstory~!!!", BuddyProfileFragment.f3906a);
                                        return;
                                    }
                                    C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY Same metaid but there is no coverstoryfile~!!!", BuddyProfileFragment.f3906a);
                                }
                                try {
                                    C2190d.m9830c(contentResolver2, this.f4849a.f4013t, coverStory2.metaid);
                                } catch (OperationApplicationException e13) {
                                    e13.printStackTrace();
                                } catch (RemoteException e14) {
                                    e14.printStackTrace();
                                }
                                if (coverStory2.contentid != null) {
                                    if (!BuddyDialog.m7180a(coverStory2.contentid, this.f4849a.f4013t, this.f4849a.f3936aC, this.f4849a.f3934aA, this.f4849a.f3981aw)) {
                                        this.f4849a.f3983ay.m9540a(coverStory2.contentid, Integer.toString(this.f4849a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(this.f4849a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
                                        this.f4849a.f3984az = coverStory2.contentid;
                                        return;
                                    }
                                    return;
                                }
                                if (C4904y.f17872b) {
                                    C4904y.m18639b("coverstory directly access test", BuddyProfileFragment.f3906a);
                                }
                                this.f4849a.f3943aJ.m19023b(this.f4849a.f3981aw, new C2955a(coverStory2.host + coverStory2.metacontents, this.f4849a.f4013t, this.f4849a.f3935aB + this.f4849a.f4013t + "/coverstory/", "buddy", CommonApplication.m18732r()));
                                return;
                            }
                            C4904y.m18639b("Buddy didn't set Coverstory ", BuddyProfileFragment.f3906a);
                            String strM9895a2 = C2195i.m9895a();
                            if (strM9895a2 != null) {
                                if (!BuddyDialog.m7180a(strM9895a2, this.f4849a.f4013t, this.f4849a.f3936aC, this.f4849a.f3934aA, this.f4849a.f3981aw)) {
                                    this.f4849a.f3983ay.m9540a(strM9895a2, Integer.toString(this.f4849a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(this.f4849a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
                                    this.f4849a.f3984az = strM9895a2;
                                }
                                C4904y.m18639b(" Set RandomCoverStory randomId : " + strM9895a2, BuddyProfileFragment.f3906a);
                                return;
                            }
                            C4904y.m18639b(" Random ERROR !!", BuddyProfileFragment.f3906a);
                            this.f4849a.f3983ay.m9543b(Integer.toString(this.f4849a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(this.f4849a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
                            return;
                        }
                        if (c0778b5.m18954n() && c0778b5.m3107b() == EnumC2464o.NO_CONTENT) {
                            if (C4904y.f17872b) {
                                C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY NO_CONTENT", BuddyProfileFragment.f3906a);
                                this.f4849a.f3983ay.m9543b(Integer.toString(this.f4849a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(this.f4849a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
                                return;
                            }
                            return;
                        }
                        if (C4904y.f17872b) {
                            C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY network ERROR", BuddyProfileFragment.f3906a);
                        }
                        this.f4849a.f3935aB = CommonApplication.m18732r().getCacheDir() + "/" + this.f4849a.f4013t + "/coverstory/";
                        File file4 = new File(this.f4849a.f3935aB + "coverstory.jpg");
                        if (C4904y.f17872b) {
                            C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY mBuddyCoverStoryFile : " + this.f4849a.f3935aB + "coverstory.jpg", BuddyProfileFragment.f3906a);
                        }
                        if (!file4.exists()) {
                            try {
                                boolean zM7179a2 = BuddyDialog.m7179a(this.f4849a.f4013t, this.f4849a.f3936aC, this.f4849a.f3934aA, this.f4849a.f3981aw);
                                if (C4904y.f17872b) {
                                    C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY result : " + zM7179a2, BuddyProfileFragment.f3906a);
                                }
                                if (!zM7179a2) {
                                    this.f4849a.f3983ay.m9543b(Integer.toString(this.f4849a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(this.f4849a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
                                    return;
                                }
                                return;
                            } catch (ArrayIndexOutOfBoundsException e15) {
                                if (C4904y.f17875e) {
                                    C4904y.m18635a(e15, getClass().getSimpleName());
                                    return;
                                }
                                return;
                            } catch (Exception e16) {
                                if (C4904y.f17875e) {
                                    C4904y.m18635a(e16, getClass().getSimpleName());
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    if (C4904y.f17872b) {
                        C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY (httpEntry == null)", BuddyProfileFragment.f3906a);
                        return;
                    }
                    return;
                case 3005:
                    C0778b c0778b6 = (C0778b) message.obj;
                    if (c0778b6 == null) {
                        C4904y.m18639b("CoverStoryControl.METHOD_CONTENT_COVERSTORY_DOWNLOAD (httpEntry == null)", BuddyProfileFragment.f3906a);
                        return;
                    }
                    if (c0778b6.m18954n() && c0778b6.m3110e() != null && c0778b6.m3107b() != EnumC2464o.ERROR) {
                        CoverStoryDownload coverStoryDownload = (CoverStoryDownload) c0778b6.m3110e();
                        this.f4849a.f3935aB = this.f4849a.f3954aU.getApplicationContext().getCacheDir() + "/" + this.f4849a.f4013t + "/coverstory/";
                        this.f4849a.f3943aJ.m19023b(this.f4849a.f3981aw, new C2955a(coverStoryDownload.fileurl, this.f4849a.f4013t, C2955a.f11033b, this.f4849a.f3954aU.getApplicationContext(), this.f4849a.f3935aB, "coverstory.jpg", this.f4849a.f3984az));
                        if (this.f4849a.f3984az != null) {
                            this.f4849a.f3984az = null;
                            return;
                        }
                        return;
                    }
                    if (c0778b6.m18954n() && c0778b6.m3107b() == EnumC2464o.NO_CONTENT) {
                        C4904y.m18639b("Deleted item on BuddyDialog mContentId : " + this.f4849a.f3984az, BuddyProfileFragment.f3906a);
                        C2194h.m9893b(this.f4849a.f3984az);
                        if (this.f4849a.f3984az != null) {
                            this.f4849a.f3984az = null;
                        }
                        this.f4849a.m6858a();
                        return;
                    }
                    return;
                case 3006:
                    C0778b c0778b7 = (C0778b) message.obj;
                    if (c0778b7 == null) {
                        C4904y.m18639b("CoverStoryControl.METHOD_CONTENT_COVERSTORY_DOWNLOAD_RANDOM (httpEntry == null)", BuddyProfileFragment.f3906a);
                        return;
                    }
                    if (c0778b7.m18954n() && c0778b7.m3110e() != null && c0778b7.m3107b() != EnumC2464o.ERROR) {
                        CoverStoryDownload coverStoryDownload2 = (CoverStoryDownload) c0778b7.m3110e();
                        this.f4849a.f3935aB = this.f4849a.f3954aU.getApplicationContext().getCacheDir() + "/" + this.f4849a.f4013t + "/coverstory/";
                        this.f4849a.f3943aJ.m19023b(this.f4849a.f3981aw, new C2955a(coverStoryDownload2.fileurl, this.f4849a.f4013t, C2955a.f11033b, this.f4849a.f3954aU.getApplicationContext(), this.f4849a.f3935aB, "coverstory.jpg", this.f4849a.f3984az));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
