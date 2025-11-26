package com.sec.chaton.buddy.dialog;

import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.buddy.C1331gk;
import com.sec.chaton.buddy.CallableC1330gj;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2187am;
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

/* compiled from: BuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.c */
/* loaded from: classes.dex */
class HandlerC1225c extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyDialog f4725a;

    HandlerC1225c(BuddyDialog buddyDialog) {
        this.f4725a = buddyDialog;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        boolean z;
        int i;
        int i2;
        if (this.f4725a.getApplicationContext() == null || this.f4725a.f4531z == null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("[BuddyDialog] mContext is null ", getClass().getSimpleName());
                return;
            }
            return;
        }
        switch (message.what) {
            case 411:
                C0778b c0778b = (C0778b) message.obj;
                if (c0778b != null) {
                    if (!c0778b.m18954n() || c0778b.m3107b() != EnumC2464o.SUCCESS || ((BuddyProfile) c0778b.m3110e()) != null) {
                        this.f4725a.f4475aQ = true;
                        return;
                    }
                    return;
                }
                return;
            case 412:
                C0778b c0778b2 = (C0778b) message.obj;
                ArrayList<String> arrayList = new ArrayList<>();
                if (c0778b2 == null) {
                    this.f4725a.f4476aR = true;
                    if (this.f4725a.f4522q != null) {
                    }
                    return;
                }
                if (c0778b2.m18954n() && c0778b2.m3107b() == EnumC2464o.SUCCESS) {
                    GetProfileImageList getProfileImageList = (GetProfileImageList) c0778b2.m3110e();
                    if (getProfileImageList == null) {
                        this.f4725a.f4476aR = true;
                        if (this.f4725a.f4522q != null) {
                        }
                        return;
                    }
                    this.f4725a.f4512g = getProfileImageList.profileimagelist;
                    this.f4725a.f4477aS = getProfileImageList.listcount.intValue();
                    if (this.f4725a.f4512g == null || this.f4725a.f4512g.size() == 0) {
                        this.f4725a.m7262b();
                        this.f4725a.f4476aR = true;
                        if (this.f4725a.f4522q != null) {
                        }
                        return;
                    }
                    if (this.f4725a.f4512g != null && this.f4725a.f4512g.size() > 0) {
                        this.f4725a.f4521p = 0;
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 < this.f4725a.f4512g.size()) {
                                if (Spam.ACTIVITY_REPORT.equals(this.f4725a.f4512g.get(i4).represent)) {
                                    this.f4725a.f4478aT = true;
                                } else {
                                    i3 = i4 + 1;
                                }
                            }
                        }
                        if (!this.f4725a.f4478aT && this.f4725a.f4477aS == 0) {
                            this.f4725a.m7262b();
                            this.f4725a.f4476aR = true;
                            if (this.f4725a.f4522q != null) {
                            }
                            return;
                        }
                    }
                    if (this.f4725a.f4512g != null && this.f4725a.f4512g.size() > 0) {
                        if (this.f4725a.f4478aT) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                        }
                        if (this.f4725a.f4478aT) {
                            this.f4725a.m7259a(this.f4725a.f4512g.size());
                        } else {
                            this.f4725a.m7259a(this.f4725a.f4512g.size() + i2);
                            this.f4725a.f4452T.m7482a().setImageBitmap(BitmapFactory.decodeResource(this.f4725a.f4452T.m7482a().getContext().getResources(), R.drawable.profile_photo_buddy_default));
                            this.f4725a.f4452T.m7484a(false);
                            C2496n.m10790e(CommonApplication.m18732r(), this.f4725a.f4509d);
                        }
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 < this.f4725a.f4512g.size()) {
                                ProfileImage profileImage = this.f4725a.f4512g.get(i6);
                                if (i6 == 0 && !this.f4725a.f4478aT && !TextUtils.isEmpty(profileImage.update_msec)) {
                                    C1331gk.m7453a(this.f4725a.getApplicationContext()).m7471b(this.f4725a.f4509d, profileImage.update_msec);
                                }
                                if (Spam.ACTIVITY_REPORT.equals(profileImage.represent)) {
                                    try {
                                        C4904y.m18639b("Profile URL : " + profileImage.profileimageurl, getClass().getSimpleName());
                                        String strM7472c = C1331gk.m7453a(this.f4725a.getApplicationContext()).m7472c(this.f4725a.f4509d);
                                        if (strM7472c != null && !TextUtils.isEmpty(profileImage.update_msec) && !TextUtils.isEmpty(strM7472c)) {
                                            if (!strM7472c.equals(profileImage.update_msec)) {
                                                C4904y.m18639b("***********Timestamp unmatch need to reload main image : " + profileImage.update_msec, "TIME");
                                                C1331gk.m7453a(this.f4725a.getApplicationContext()).m7468a(this.f4725a.f4509d, profileImage.profileimageid);
                                                this.f4725a.f4452T.m7483a((String) null);
                                            } else {
                                                C4904y.m18639b("***********Timestamp match : " + profileImage.update_msec, "TIME");
                                            }
                                        }
                                        if (this.f4725a.f4452T.m7485b() != null && (this.f4725a.f4452T.m7485b() == null || this.f4725a.f4452T.m7485b().equals(profileImage.profileimageid))) {
                                            if (this.f4725a.f4452T.m7485b() != null && this.f4725a.f4452T.m7485b().equals(profileImage.profileimageid)) {
                                                this.f4725a.f4452T.m7484a(true);
                                                this.f4725a.f4452T.m7482a().setFocusable(true);
                                                arrayList.add("0:" + profileImage.profileimageid);
                                            }
                                        } else {
                                            BuddyDialog.m7213g(this.f4725a);
                                            C1331gk.m7453a(this.f4725a.getApplicationContext()).m7468a(this.f4725a.f4509d, profileImage.profileimageid);
                                            this.f4725a.f4491ai.m19023b(this.f4725a.f4441I, new CallableC1330gj(this.f4725a.f4445M, profileImage.profileimageurl + this.f4725a.f4492aj + "&size=800", 500, 500, this.f4725a.getApplicationContext().getCacheDir() + "/" + this.f4725a.f4509d + "/", profileImage.profileimageid, true));
                                            arrayList.add("0:" + profileImage.profileimageid);
                                            C2496n.m10790e(CommonApplication.m18732r(), this.f4725a.f4509d);
                                        }
                                        if (!TextUtils.isEmpty(profileImage.update_msec)) {
                                            C1331gk.m7453a(this.f4725a.getApplicationContext()).m7471b(this.f4725a.f4509d, profileImage.update_msec);
                                        }
                                    } catch (Exception e) {
                                        C4904y.m18635a(e, getClass().getSimpleName());
                                    } catch (OutOfMemoryError e2) {
                                        e2.printStackTrace();
                                    }
                                    this.f4725a.f4452T.m7483a(profileImage.profileimageid);
                                    i5 = i6 + 1;
                                } else {
                                    C4904y.m18639b("Profile URL : " + profileImage.profileimageurl, getClass().getSimpleName());
                                    if (i6 == 1 - i2) {
                                        try {
                                            if (this.f4725a.f4453U.m7485b() != null && (this.f4725a.f4453U.m7485b() == null || this.f4725a.f4453U.m7485b().equals(profileImage.profileimageid))) {
                                                if (this.f4725a.f4453U.m7485b() != null && this.f4725a.f4453U.m7485b().equals(profileImage.profileimageid)) {
                                                    this.f4725a.f4453U.m7484a(true);
                                                    this.f4725a.f4453U.m7482a().setFocusable(true);
                                                    arrayList.add("1:" + profileImage.profileimageid);
                                                }
                                            } else {
                                                BuddyDialog.m7213g(this.f4725a);
                                                this.f4725a.f4491ai.m19023b(this.f4725a.f4453U.m7482a(), new CallableC1330gj(this.f4725a.f4446N, profileImage.profileimageurl + this.f4725a.f4492aj + "&size=100", 60, 60, this.f4725a.getApplicationContext().getCacheDir() + "/" + this.f4725a.f4509d + "/", profileImage.profileimageid));
                                                arrayList.add("1:" + profileImage.profileimageid);
                                            }
                                            this.f4725a.f4453U.m7483a(profileImage.profileimageid);
                                        } catch (Exception e3) {
                                            C4904y.m18635a(e3, getClass().getSimpleName());
                                        } catch (OutOfMemoryError e4) {
                                            e4.printStackTrace();
                                        }
                                    } else if (i6 == 2 - i2) {
                                        if (this.f4725a.f4454V.m7485b() != null && (this.f4725a.f4454V.m7485b() == null || this.f4725a.f4454V.m7485b().equals(profileImage.profileimageid))) {
                                            if (this.f4725a.f4454V.m7485b() != null && this.f4725a.f4454V.m7485b().equals(profileImage.profileimageid)) {
                                                this.f4725a.f4454V.m7484a(true);
                                                this.f4725a.f4454V.m7482a().setFocusable(true);
                                                arrayList.add("2:" + profileImage.profileimageid);
                                            }
                                        } else {
                                            BuddyDialog.m7213g(this.f4725a);
                                            this.f4725a.f4491ai.m19023b(this.f4725a.f4454V.m7482a(), new CallableC1330gj(this.f4725a.f4447O, profileImage.profileimageurl + this.f4725a.f4492aj + "&size=100", 60, 60, this.f4725a.getApplicationContext().getCacheDir() + "/" + this.f4725a.f4509d + "/", profileImage.profileimageid));
                                            arrayList.add("2:" + profileImage.profileimageid);
                                        }
                                        this.f4725a.f4454V.m7483a(profileImage.profileimageid);
                                    } else if (i6 == 3 - i2) {
                                        if (this.f4725a.f4455W.m7485b() != null && (this.f4725a.f4455W.m7485b() == null || this.f4725a.f4455W.m7485b().equals(profileImage.profileimageid))) {
                                            if (this.f4725a.f4455W.m7485b() != null && this.f4725a.f4455W.m7485b().equals(profileImage.profileimageid)) {
                                                this.f4725a.f4455W.m7484a(true);
                                                this.f4725a.f4455W.m7482a().setFocusable(true);
                                                arrayList.add("3:" + profileImage.profileimageid);
                                            }
                                        } else {
                                            BuddyDialog.m7213g(this.f4725a);
                                            this.f4725a.f4491ai.m19023b(this.f4725a.f4455W.m7482a(), new CallableC1330gj(this.f4725a.f4448P, profileImage.profileimageurl + this.f4725a.f4492aj + "&size=100", 60, 60, this.f4725a.getApplicationContext().getCacheDir() + "/" + this.f4725a.f4509d + "/", profileImage.profileimageid));
                                            arrayList.add("3:" + profileImage.profileimageid);
                                        }
                                        this.f4725a.f4455W.m7483a(profileImage.profileimageid);
                                    }
                                    i5 = i6 + 1;
                                }
                            }
                            this.f4725a.m7258a();
                            C1331gk.m7453a(this.f4725a.getApplicationContext()).m7469a(this.f4725a.f4509d, arrayList);
                            if (this.f4725a.f4521p == 0) {
                                this.f4725a.f4476aR = true;
                            }
                            if (Spam.ACTIVITY_REPORT.equals(this.f4725a.f4512g.get(0).represent)) {
                                if (this.f4725a.f4477aS > 4 && this.f4725a.f4449Q != null) {
                                    this.f4725a.f4449Q.setVisibility(0);
                                    return;
                                }
                                return;
                            }
                            if (this.f4725a.f4477aS > 3 && this.f4725a.f4449Q != null) {
                                this.f4725a.f4449Q.setVisibility(0);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                if (c0778b2.m18954n() && c0778b2.m3107b() == EnumC2464o.ERROR && c0778b2.m3111f() == 15009) {
                    this.f4725a.m7264c();
                    return;
                }
                if (c0778b2.m18954n() && c0778b2.m3107b() == EnumC2464o.NO_CONTENT) {
                    this.f4725a.m7262b();
                }
                this.f4725a.f4476aR = true;
                return;
            case 417:
                C0778b c0778b3 = (C0778b) message.obj;
                C4904y.m18639b("ProfileControl.METHOD_PROFILE_INFORMATION", getClass().getSimpleName());
                if (c0778b3 == null) {
                    C4904y.m18639b("ProfileControl.METHOD_PROFILE_INFORMATION (httpEntry == null)", getClass().getSimpleName());
                    this.f4725a.f4476aR = true;
                    return;
                }
                if (c0778b3.m18954n() && c0778b3.m3107b() == EnumC2464o.SUCCESS) {
                    ProfileInformationList profileInformationList = (ProfileInformationList) c0778b3.m3110e();
                    BuddyProfile buddyProfile = profileInformationList.profile;
                    CoverStory coverStory = profileInformationList.coverstory;
                    GetProfileImageList getProfileImageList2 = profileInformationList.profileimage;
                    if (buddyProfile.timestamp != null) {
                        this.f4725a.f4475aQ = true;
                    }
                    if (coverStory.metaid != null) {
                        boolean z2 = true;
                        this.f4725a.f4528w = this.f4725a.getApplicationContext().getCacheDir() + "/" + this.f4725a.f4509d + "/coverstory/";
                        ContentResolver contentResolver = GlobalApplication.m10279a().getContentResolver();
                        String strM9847j = C2190d.m9847j(contentResolver, this.f4725a.f4509d);
                        C4904y.m18639b("ProfileControl.METHOD_PROFILE_INFORMATION previousMetaId : " + strM9847j + "### new MetaId : " + coverStory.metaid, BuddyDialog.f4430a);
                        if (!TextUtils.isEmpty(strM9847j) && strM9847j.equals(coverStory.metaid)) {
                            File file = new File(this.f4725a.f4528w + "coverstory.jpg");
                            if (file.exists() && file.length() > 0) {
                                C4904y.m18639b("ProfileControl.METHOD_PROFILE_INFORMATION Same coverstory~ PASS!!!", BuddyDialog.f4430a);
                                z2 = false;
                            } else {
                                C4904y.m18639b("ProfileControl.METHOD_PROFILE_INFORMATION Same metaid but there is no coverstoryfile~!!!", BuddyDialog.f4430a);
                            }
                        }
                        if (z2) {
                            try {
                                C2190d.m9830c(contentResolver, this.f4725a.f4509d, coverStory.metaid);
                            } catch (OperationApplicationException e5) {
                                e5.printStackTrace();
                            } catch (RemoteException e6) {
                                e6.printStackTrace();
                            }
                            if (coverStory.contentid == null) {
                                this.f4725a.f4491ai.m19023b(this.f4725a.f4527v, new C2955a(coverStory.host + coverStory.metacontents, this.f4725a.f4509d, this.f4725a.f4528w, "buddy", this.f4725a.getApplicationContext()));
                            } else if (!this.f4725a.m7261a(coverStory.contentid, this.f4725a.f4509d)) {
                                this.f4725a.f4523r.m9540a(coverStory.contentid, Integer.toString(this.f4725a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(this.f4725a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
                                this.f4725a.f4530y = coverStory.contentid;
                            }
                        }
                    } else {
                        C4904y.m18639b("Buddy didn't set Coverstory ", getClass().getSimpleName());
                        String strM9895a = C2195i.m9895a();
                        if (strM9895a != null) {
                            if (!this.f4725a.m7261a(strM9895a, this.f4725a.f4509d)) {
                                this.f4725a.f4523r.m9540a(strM9895a, Integer.toString(this.f4725a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(this.f4725a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
                                this.f4725a.f4530y = strM9895a;
                            }
                            C4904y.m18639b(" Set RandomCoverStory randomId : " + strM9895a, getClass().getSimpleName());
                        } else {
                            C4904y.m18639b(" Random ERROR !!", getClass().getSimpleName());
                        }
                    }
                    if (getProfileImageList2.totalcount == null) {
                        this.f4725a.f4476aR = true;
                        if (this.f4725a.f4522q != null) {
                        }
                        return;
                    }
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    this.f4725a.f4512g = getProfileImageList2.profileimagelist;
                    this.f4725a.f4477aS = getProfileImageList2.listcount.intValue();
                    if (this.f4725a.f4512g == null || this.f4725a.f4512g.size() == 0) {
                        this.f4725a.m7262b();
                        this.f4725a.f4476aR = true;
                        if (this.f4725a.f4522q != null) {
                        }
                        return;
                    }
                    if (this.f4725a.f4512g != null && this.f4725a.f4512g.size() > 0) {
                        this.f4725a.f4521p = 0;
                        int i7 = 0;
                        while (true) {
                            int i8 = i7;
                            if (i8 < this.f4725a.f4512g.size()) {
                                if (Spam.ACTIVITY_REPORT.equals(this.f4725a.f4512g.get(i8).represent)) {
                                    this.f4725a.f4478aT = true;
                                } else {
                                    i7 = i8 + 1;
                                }
                            }
                        }
                        if (!this.f4725a.f4478aT && this.f4725a.f4477aS == 0) {
                            this.f4725a.m7262b();
                            this.f4725a.f4476aR = true;
                            if (this.f4725a.f4522q != null) {
                            }
                            return;
                        }
                    }
                    if (this.f4725a.f4512g != null && this.f4725a.f4512g.size() > 0) {
                        if (this.f4725a.f4478aT) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                        if (this.f4725a.f4478aT) {
                            this.f4725a.m7259a(this.f4725a.f4512g.size());
                        } else {
                            this.f4725a.m7259a(this.f4725a.f4512g.size() + i);
                            this.f4725a.f4452T.m7482a().setImageBitmap(BitmapFactory.decodeResource(this.f4725a.f4452T.m7482a().getContext().getResources(), R.drawable.profile_photo_buddy_default));
                            this.f4725a.f4452T.m7484a(false);
                            C2496n.m10790e(CommonApplication.m18732r(), this.f4725a.f4509d);
                        }
                        int i9 = 0;
                        while (true) {
                            int i10 = i9;
                            if (i10 < this.f4725a.f4512g.size()) {
                                ProfileImage profileImage2 = this.f4725a.f4512g.get(i10);
                                if (i10 == 0 && !this.f4725a.f4478aT && !TextUtils.isEmpty(profileImage2.update_msec)) {
                                    C1331gk.m7453a(this.f4725a.getApplicationContext()).m7471b(this.f4725a.f4509d, profileImage2.update_msec);
                                }
                                if (Spam.ACTIVITY_REPORT.equals(profileImage2.represent)) {
                                    try {
                                        C4904y.m18639b("Profile URL : " + profileImage2.profileimageurl, getClass().getSimpleName());
                                        String strM7472c2 = C1331gk.m7453a(this.f4725a.getApplicationContext()).m7472c(this.f4725a.f4509d);
                                        if (strM7472c2 != null && !TextUtils.isEmpty(profileImage2.update_msec) && !TextUtils.isEmpty(strM7472c2)) {
                                            if (!strM7472c2.equals(profileImage2.update_msec)) {
                                                C4904y.m18639b("***********Timestamp unmatch need to reload main image : " + profileImage2.update_msec, "TIME");
                                                C1331gk.m7453a(this.f4725a.getApplicationContext()).m7468a(this.f4725a.f4509d, profileImage2.profileimageid);
                                                this.f4725a.f4452T.m7483a((String) null);
                                            } else {
                                                C4904y.m18639b("***********Timestamp match : " + profileImage2.update_msec, "TIME");
                                            }
                                        }
                                        if (this.f4725a.f4452T.m7485b() != null && (this.f4725a.f4452T.m7485b() == null || this.f4725a.f4452T.m7485b().equals(profileImage2.profileimageid))) {
                                            if (this.f4725a.f4452T.m7485b() != null && this.f4725a.f4452T.m7485b().equals(profileImage2.profileimageid)) {
                                                this.f4725a.f4452T.m7484a(true);
                                                this.f4725a.f4452T.m7482a().setFocusable(true);
                                                arrayList2.add("0:" + profileImage2.profileimageid);
                                            }
                                        } else {
                                            BuddyDialog.m7213g(this.f4725a);
                                            C1331gk.m7453a(this.f4725a.getApplicationContext()).m7468a(this.f4725a.f4509d, profileImage2.profileimageid);
                                            this.f4725a.f4491ai.m19023b(this.f4725a.f4441I, new CallableC1330gj(this.f4725a.f4445M, profileImage2.profileimageurl + this.f4725a.f4492aj + "&size=800", 500, 500, this.f4725a.getApplicationContext().getCacheDir() + "/" + this.f4725a.f4509d + "/", profileImage2.profileimageid, true));
                                            arrayList2.add("0:" + profileImage2.profileimageid);
                                            C2496n.m10790e(CommonApplication.m18732r(), this.f4725a.f4509d);
                                        }
                                        if (!TextUtils.isEmpty(profileImage2.update_msec)) {
                                            C1331gk.m7453a(this.f4725a.getApplicationContext()).m7471b(this.f4725a.f4509d, profileImage2.update_msec);
                                        }
                                    } catch (Exception e7) {
                                        C4904y.m18635a(e7, getClass().getSimpleName());
                                    } catch (OutOfMemoryError e8) {
                                        e8.printStackTrace();
                                    }
                                    this.f4725a.f4452T.m7483a(profileImage2.profileimageid);
                                    i9 = i10 + 1;
                                } else {
                                    C4904y.m18639b("Profile URL : " + profileImage2.profileimageurl, getClass().getSimpleName());
                                    if (i10 == 1 - i) {
                                        try {
                                            if (this.f4725a.f4453U.m7485b() != null && (this.f4725a.f4453U.m7485b() == null || this.f4725a.f4453U.m7485b().equals(profileImage2.profileimageid))) {
                                                if (this.f4725a.f4453U.m7485b() != null && this.f4725a.f4453U.m7485b().equals(profileImage2.profileimageid)) {
                                                    this.f4725a.f4453U.m7484a(true);
                                                    this.f4725a.f4453U.m7482a().setFocusable(true);
                                                    arrayList2.add("1:" + profileImage2.profileimageid);
                                                }
                                            } else {
                                                BuddyDialog.m7213g(this.f4725a);
                                                this.f4725a.f4491ai.m19023b(this.f4725a.f4453U.m7482a(), new CallableC1330gj(this.f4725a.f4446N, profileImage2.profileimageurl + this.f4725a.f4492aj + "&size=100", 60, 60, this.f4725a.getApplicationContext().getCacheDir() + "/" + this.f4725a.f4509d + "/", profileImage2.profileimageid));
                                                arrayList2.add("1:" + profileImage2.profileimageid);
                                            }
                                            this.f4725a.f4453U.m7483a(profileImage2.profileimageid);
                                        } catch (Exception e9) {
                                            C4904y.m18635a(e9, getClass().getSimpleName());
                                        } catch (OutOfMemoryError e10) {
                                            e10.printStackTrace();
                                        }
                                    } else if (i10 == 2 - i) {
                                        if (this.f4725a.f4454V.m7485b() != null && (this.f4725a.f4454V.m7485b() == null || this.f4725a.f4454V.m7485b().equals(profileImage2.profileimageid))) {
                                            if (this.f4725a.f4454V.m7485b() != null && this.f4725a.f4454V.m7485b().equals(profileImage2.profileimageid)) {
                                                this.f4725a.f4454V.m7484a(true);
                                                this.f4725a.f4454V.m7482a().setFocusable(true);
                                                arrayList2.add("2:" + profileImage2.profileimageid);
                                            }
                                        } else {
                                            BuddyDialog.m7213g(this.f4725a);
                                            this.f4725a.f4491ai.m19023b(this.f4725a.f4454V.m7482a(), new CallableC1330gj(this.f4725a.f4447O, profileImage2.profileimageurl + this.f4725a.f4492aj + "&size=100", 60, 60, this.f4725a.getApplicationContext().getCacheDir() + "/" + this.f4725a.f4509d + "/", profileImage2.profileimageid));
                                            arrayList2.add("2:" + profileImage2.profileimageid);
                                        }
                                        this.f4725a.f4454V.m7483a(profileImage2.profileimageid);
                                    } else if (i10 == 3 - i) {
                                        if (this.f4725a.f4455W.m7485b() != null && (this.f4725a.f4455W.m7485b() == null || this.f4725a.f4455W.m7485b().equals(profileImage2.profileimageid))) {
                                            if (this.f4725a.f4455W.m7485b() != null && this.f4725a.f4455W.m7485b().equals(profileImage2.profileimageid)) {
                                                this.f4725a.f4455W.m7484a(true);
                                                this.f4725a.f4455W.m7482a().setFocusable(true);
                                                arrayList2.add("3:" + profileImage2.profileimageid);
                                            }
                                        } else {
                                            BuddyDialog.m7213g(this.f4725a);
                                            this.f4725a.f4491ai.m19023b(this.f4725a.f4455W.m7482a(), new CallableC1330gj(this.f4725a.f4448P, profileImage2.profileimageurl + this.f4725a.f4492aj + "&size=100", 60, 60, this.f4725a.getApplicationContext().getCacheDir() + "/" + this.f4725a.f4509d + "/", profileImage2.profileimageid));
                                            arrayList2.add("3:" + profileImage2.profileimageid);
                                        }
                                        this.f4725a.f4455W.m7483a(profileImage2.profileimageid);
                                    }
                                    i9 = i10 + 1;
                                }
                            }
                            this.f4725a.m7258a();
                            C1331gk.m7453a(this.f4725a.getApplicationContext()).m7469a(this.f4725a.f4509d, arrayList2);
                            if (this.f4725a.f4521p == 0) {
                                this.f4725a.f4476aR = true;
                            }
                            if (Spam.ACTIVITY_REPORT.equals(this.f4725a.f4512g.get(0).represent)) {
                                if (this.f4725a.f4477aS > 4 && this.f4725a.f4449Q != null) {
                                    this.f4725a.f4449Q.setVisibility(0);
                                    return;
                                }
                                return;
                            }
                            if (this.f4725a.f4477aS > 3 && this.f4725a.f4449Q != null) {
                                this.f4725a.f4449Q.setVisibility(0);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                C4904y.m18639b("ProfileControl.METHOD_PROFILE_INFORMATION httpEntry fail", BuddyDialog.f4430a);
                if (c0778b3.m18954n() && c0778b3.m3107b() == EnumC2464o.NO_CONTENT) {
                    C4904y.m18639b("ProfileControl.METHOD_PROFILE_INFORMATION HttpResultCode.NO_CONTENT", BuddyDialog.f4430a);
                    this.f4725a.m7262b();
                } else {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("ProfileControl.METHOD_PROFILE_INFORMATION network ERROR", BuddyDialog.f4430a);
                    }
                    String str = this.f4725a.getApplicationContext().getCacheDir() + "/" + this.f4725a.f4509d + "/coverstory/";
                    File file2 = new File(str + "coverstory.jpg");
                    if (C4904y.f17872b) {
                        C4904y.m18639b("ProfileControl.METHOD_PROFILE_INFORMATIO mBuddyCoverStoryFile : " + str + "coverstory.jpg", BuddyDialog.f4430a);
                    }
                    if (!file2.exists()) {
                        if (this.f4725a.f4524s.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                            this.f4725a.m7260a((String) null);
                        } else {
                            boolean zM7260a = this.f4725a.m7260a(this.f4725a.f4509d);
                            if (C4904y.f17872b) {
                                C4904y.m18639b("ProfileControl.METHOD_PROFILE_INFORMATIO result : " + zM7260a, BuddyDialog.f4430a);
                            }
                        }
                    }
                }
                if (!c0778b3.m18954n() || c0778b3.m3107b() != EnumC2464o.ERROR || c0778b3.m3111f() != 15009) {
                    this.f4725a.f4476aR = true;
                    return;
                } else {
                    this.f4725a.m7264c();
                    return;
                }
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
                    String strM9784c = C2187am.m9784c(this.f4725a.f4509d);
                    if (TextUtils.isEmpty(buddy.devicetype) || !buddy.devicetype.equals("web") || (!TextUtils.isEmpty(buddy.msisdns) && new StringTokenizer(buddy.msisdns, "|").countTokens() != 1)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    this.f4725a.f4498ap = C4883f.m18540a(buddy.value, buddy.msisdns);
                    this.f4725a.f4524s = new C1106c(buddy.value, !TextUtils.isEmpty(strM9784c) ? strM9784c : buddy.name, buddy.status, buddy.samsungemail, buddy.orgnum, buddy.orgnums, buddy.msisdns, this.f4725a.f4498ap, buddy.birthday, false, 0, buddy.name, false, 0, 0, 0, 0, 0, 0, 0, false, false, buddy.showphonenumber.booleanValue() ? 1 : 0, buddy.einfo, z ? 1 : 0, buddy.sainfo, Spam.ACTIVITY_CANCEL, C2190d.m9810a(this.f4725a.f4498ap, 1, buddy.showphonenumber, buddy.msisdns, buddy.value, buddy.orgnum, buddy.orgnums));
                    this.f4725a.m7175a(false);
                    return;
                }
                if (C4904y.f17872b) {
                    C4904y.m18639b("ProfileControl.METHOD_GET_HIDE_BUDDY_PROFILE httpEntry fail", BuddyDialog.f4430a);
                    return;
                }
                return;
            case 3001:
                C0778b c0778b5 = (C0778b) message.obj;
                C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY", getClass().getSimpleName());
                if (c0778b5 == null) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY (httpEntry == null)", getClass().getSimpleName());
                        return;
                    }
                    return;
                }
                if (c0778b5.m18954n() && c0778b5.m3107b() == EnumC2464o.SUCCESS) {
                    CoverStory coverStory2 = (CoverStory) c0778b5.m3110e();
                    if (coverStory2 == null) {
                        C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY dialogCoverStory is null !!!", BuddyDialog.f4430a);
                        return;
                    }
                    if (coverStory2.metaid != null) {
                        this.f4725a.f4528w = this.f4725a.getApplicationContext().getCacheDir() + "/" + this.f4725a.f4509d + "/coverstory/";
                        ContentResolver contentResolver2 = GlobalApplication.m10279a().getContentResolver();
                        String strM9847j2 = C2190d.m9847j(contentResolver2, this.f4725a.f4509d);
                        C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY previousMetaId : " + strM9847j2 + "### new MetaId : " + coverStory2.metaid, BuddyDialog.f4430a);
                        if (!TextUtils.isEmpty(strM9847j2) && strM9847j2.equals(coverStory2.metaid)) {
                            File file3 = new File(this.f4725a.f4528w + "coverstory.jpg");
                            if (file3.exists() && file3.length() > 0) {
                                C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY Same coverstory~!!!", BuddyDialog.f4430a);
                                return;
                            }
                            C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY Same metaid but there is no coverstoryfile~!!!", BuddyDialog.f4430a);
                        }
                        try {
                            C2190d.m9830c(contentResolver2, this.f4725a.f4509d, coverStory2.metaid);
                        } catch (OperationApplicationException e11) {
                            e11.printStackTrace();
                        } catch (RemoteException e12) {
                            e12.printStackTrace();
                        }
                        if (coverStory2.contentid == null) {
                            this.f4725a.f4491ai.m19023b(this.f4725a.f4527v, new C2955a(coverStory2.host + coverStory2.metacontents, this.f4725a.f4509d, this.f4725a.f4528w, "buddy", this.f4725a.getApplicationContext()));
                            return;
                        } else {
                            if (!this.f4725a.m7261a(coverStory2.contentid, this.f4725a.f4509d)) {
                                this.f4725a.f4523r.m9540a(coverStory2.contentid, Integer.toString(this.f4725a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(this.f4725a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
                                this.f4725a.f4530y = coverStory2.contentid;
                                return;
                            }
                            return;
                        }
                    }
                    C4904y.m18639b("Buddy didn't set Coverstory ", getClass().getSimpleName());
                    String strM9895a2 = C2195i.m9895a();
                    if (strM9895a2 != null) {
                        if (!this.f4725a.m7261a(strM9895a2, this.f4725a.f4509d)) {
                            this.f4725a.f4523r.m9540a(strM9895a2, Integer.toString(this.f4725a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(this.f4725a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
                            this.f4725a.f4530y = strM9895a2;
                        }
                        C4904y.m18639b(" Set RandomCoverStory randomId : " + strM9895a2, getClass().getSimpleName());
                        return;
                    }
                    C4904y.m18639b(" Random ERROR !!", getClass().getSimpleName());
                    return;
                }
                if (c0778b5.m3111f() != 15009) {
                    if (c0778b5.m18954n() && c0778b5.m3107b() == EnumC2464o.NO_CONTENT) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY NO_CONTENT", BuddyDialog.f4430a);
                            return;
                        }
                        return;
                    }
                    if (C4904y.f17872b) {
                        C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY network ERROR", BuddyDialog.f4430a);
                    }
                    String str2 = this.f4725a.getApplicationContext().getCacheDir() + "/" + this.f4725a.f4509d + "/coverstory/";
                    File file4 = new File(str2 + "coverstory.jpg");
                    if (C4904y.f17872b) {
                        C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY mBuddyCoverStoryFile : " + str2 + "coverstory.jpg", BuddyDialog.f4430a);
                    }
                    if (!file4.exists()) {
                        if (this.f4725a.f4524s.m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                            this.f4725a.m7260a((String) null);
                            return;
                        }
                        boolean zM7260a2 = this.f4725a.m7260a(this.f4725a.f4509d);
                        if (C4904y.f17872b) {
                            C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY result : " + zM7260a2, BuddyDialog.f4430a);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 3005:
                C0778b c0778b6 = (C0778b) message.obj;
                if (c0778b6 == null) {
                    C4904y.m18639b("CoverStoryControl.METHOD_CONTENT_COVERSTORY_DOWNLOAD (httpEntry == null)", getClass().getSimpleName());
                    return;
                }
                if (c0778b6.m18954n() && c0778b6.m3110e() != null && c0778b6.m3107b() != EnumC2464o.ERROR) {
                    CoverStoryDownload coverStoryDownload = (CoverStoryDownload) c0778b6.m3110e();
                    this.f4725a.f4528w = this.f4725a.getApplicationContext().getCacheDir() + "/" + this.f4725a.f4509d + "/coverstory/";
                    this.f4725a.f4491ai.m19023b(this.f4725a.f4527v, new C2955a(coverStoryDownload.fileurl, this.f4725a.f4509d, C2955a.f11033b, this.f4725a.getApplicationContext(), this.f4725a.f4528w, "coverstory.jpg", this.f4725a.f4530y));
                    if (this.f4725a.f4530y != null) {
                        this.f4725a.f4530y = null;
                        return;
                    }
                    return;
                }
                if (c0778b6.m18954n() && c0778b6.m3107b() == EnumC2464o.NO_CONTENT) {
                    C4904y.m18639b("Deleted item on BuddyDialog mContentId : " + this.f4725a.f4530y, getClass().getSimpleName());
                    C2194h.m9893b(this.f4725a.f4530y);
                    if (this.f4725a.f4530y != null) {
                        this.f4725a.f4530y = null;
                    }
                    this.f4725a.m7265d();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
