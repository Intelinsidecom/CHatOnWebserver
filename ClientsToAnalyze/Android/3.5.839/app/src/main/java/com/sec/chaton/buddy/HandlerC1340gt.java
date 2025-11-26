package com.sec.chaton.buddy;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyProfileImageViewFragment;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.GetProfileImageList;
import com.sec.chaton.p065io.entry.inner.ProfileImage;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.userprofile.CallableC4761bt;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;
import java.io.File;

/* compiled from: BuddyProfileImageViewFragment.java */
/* renamed from: com.sec.chaton.buddy.gt */
/* loaded from: classes.dex */
class HandlerC1340gt extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileImageViewFragment f4918a;

    HandlerC1340gt(BuddyProfileImageViewFragment buddyProfileImageViewFragment) {
        this.f4918a = buddyProfileImageViewFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f4918a.f4037P != null) {
            switch (message.what) {
                case 410:
                    C0778b c0778b = (C0778b) message.obj;
                    if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                        this.f4918a.f4023B.setVisibility(8);
                        if (this.f4918a.f4047j.isShowing()) {
                            this.f4918a.f4047j.dismiss();
                        }
                        if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.NO_CONTENT) {
                            this.f4918a.m6880d();
                            C1331gk.m7453a(this.f4918a.getActivity().getApplicationContext()).m7470b(this.f4918a.f4033L);
                        } else if (c0778b.m3111f() == 15009) {
                            C5179v.m19811a(this.f4918a.f4037P, this.f4918a.getResources().getString(R.string.toast_deleted_account, "Unknown"), 0).show();
                        } else {
                            C5179v.m19810a(this.f4918a.f4037P, R.string.toast_network_unable, 0).show();
                        }
                        this.f4918a.f4037P.setRequestedOrientation(-1);
                        break;
                    } else {
                        GetProfileImageList getProfileImageList = (GetProfileImageList) c0778b.m3110e();
                        if (getProfileImageList != null) {
                            this.f4918a.f4031J = getProfileImageList.listcount.intValue();
                            this.f4918a.f4032K = getProfileImageList.profileimagelist;
                            if (this.f4918a.f4032K != null && this.f4918a.f4032K.size() > 0) {
                                for (int i = 0; i < this.f4918a.f4032K.size(); i++) {
                                    ProfileImage profileImage = (ProfileImage) this.f4918a.f4032K.get(i);
                                    if (profileImage.profileimageid.equals(this.f4918a.f4034M)) {
                                        this.f4918a.f4029H = profileImage.profileimageid;
                                        if (this.f4918a.f4036O) {
                                            File file = new File(this.f4918a.m6898a());
                                            if (!file.exists()) {
                                                file.mkdir();
                                            }
                                            C4904y.m18646e("main profileimageurl : " + profileImage.profileimageurl.toString() + this.f4918a.f4061x, getClass().getSimpleName());
                                            this.f4918a.f4060w.m19023b(this.f4918a.f4046i, new CallableC4761bt(this.f4918a.f4025D, profileImage.profileimageurl.toString() + this.f4918a.f4061x, 600, 600, this.f4918a.m6898a(), "buddy_f_" + this.f4918a.f4033L + "_" + profileImage.profileimageid));
                                        }
                                    }
                                    if (Spam.ACTIVITY_REPORT.equals(profileImage.represent)) {
                                        this.f4918a.f4028G = profileImage.profileimageid;
                                        this.f4918a.f4022A = profileImage.profileimageurl;
                                        File file2 = new File(this.f4918a.m6898a());
                                        if (!file2.exists()) {
                                            file2.mkdir();
                                        }
                                    }
                                    C4904y.m18646e("profileimageurl: " + profileImage.profileimageurl.toString(), getClass().getSimpleName());
                                    this.f4918a.f4062y = "buddy_t_" + this.f4918a.f4033L + "_" + profileImage.profileimageid;
                                    BuddyProfileImageViewFragment.ProfileImageItem profileImageItem = new BuddyProfileImageViewFragment.ProfileImageItem();
                                    profileImageItem.f4064id = profileImage.profileimageurl.toString() + this.f4918a.f4061x;
                                    profileImageItem.dirCachePath = this.f4918a.m6898a();
                                    profileImageItem.ThumbfileName = "buddy_t_" + this.f4918a.f4033L + "_" + profileImage.profileimageid;
                                    profileImageItem.FullfileName = "buddy_f_" + this.f4918a.f4033L + "_" + profileImage.profileimageid;
                                    profileImageItem.Represent = profileImage.represent;
                                    profileImageItem.imageId = profileImage.profileimageid;
                                    C4904y.m18646e("profileimageurl : " + profileImageItem.f4064id, getClass().getSimpleName());
                                    this.f4918a.f4059v.add(profileImageItem);
                                }
                            }
                            this.f4918a.m6877c();
                            this.f4918a.f4023B.setVisibility(8);
                            this.f4918a.setHasOptionsMenu(false);
                            if (this.f4918a.f4047j.isShowing()) {
                                this.f4918a.f4047j.dismiss();
                            }
                            this.f4918a.f4037P.setRequestedOrientation(-1);
                            break;
                        }
                    }
                    break;
            }
        }
    }
}
