package com.sec.chaton.userprofile;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p046a.p047a.C0790n;
import com.sec.chaton.p065io.entry.GetProfileImageList;
import com.sec.chaton.p065io.entry.inner.ProfileImage;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.userprofile.ProfileImageHistoryFragment;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4894o;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;
import java.io.File;

/* compiled from: ProfileImageHistoryFragment.java */
/* renamed from: com.sec.chaton.userprofile.by */
/* loaded from: classes.dex */
class HandlerC4766by extends Handler {

    /* renamed from: a */
    final /* synthetic */ ProfileImageHistoryFragment f17484a;

    HandlerC4766by(ProfileImageHistoryFragment profileImageHistoryFragment) {
        this.f17484a = profileImageHistoryFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        if (this.f17484a.f17302S != null) {
            switch (message.what) {
                case 0:
                    boolean z = ((Bundle) message.obj).getBoolean("download_success");
                    String string = ((Bundle) message.obj).getString("filename_id");
                    if (this.f17484a.f17330at != null && string != null && string.contains(this.f17484a.f17315ae)) {
                        if (this.f17484a.f17330at.findItem(1) != null) {
                            this.f17484a.f17330at.findItem(1).setEnabled(z);
                        }
                        if (this.f17484a.f17330at.findItem(2) != null) {
                            this.f17484a.f17330at.findItem(2).setEnabled(z);
                        }
                        if (this.f17484a.f17330at.findItem(4) != null) {
                            this.f17484a.f17330at.findItem(4).setEnabled(z);
                        }
                        if (this.f17484a.f17330at.findItem(3) != null) {
                            this.f17484a.f17330at.findItem(3).setEnabled(z);
                        }
                        if (this.f17484a.f17330at.findItem(5) != null) {
                            this.f17484a.f17330at.findItem(5).setEnabled(z);
                        }
                        this.f17484a.f17321ak.mo51u_();
                    }
                    if (C4904y.f17872b) {
                        C4904y.m18639b("Catch the handler for downloading complete.", getClass().getSimpleName());
                        break;
                    }
                    break;
                case 402:
                    if (((C0790n) message.obj).f2172a) {
                        this.f17484a.f17348p.m9316e(this.f17484a.f17352v.getPath());
                        break;
                    } else {
                        if (this.f17484a.f17346n.isShowing()) {
                            this.f17484a.f17346n.dismiss();
                        }
                        if (this.f17484a.f17313ac == null) {
                            AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this.f17484a.f17302S);
                            abstractC4932aM18733a.mo18734a(R.string.ams_attention_title).mo18746b(R.string.toast_setting_profile_update_failed).mo18751b(true).mo18756d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC4769ca(this)).mo18747b(R.string.setting_delete_account_cancel, new DialogInterfaceOnClickListenerC4767bz(this));
                            this.f17484a.f17313ac = abstractC4932aM18733a.mo18745a();
                        }
                        this.f17484a.f17313ac.show();
                        break;
                    }
                case 404:
                    C0778b c0778b = (C0778b) message.obj;
                    if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                        C4809aa.m18107a("last_sync_time_get_mypage_information", (Long) 0L);
                        C4809aa.m18108a("profile_image_status", "updated");
                        this.f17484a.m17965a(true, c0778b, false);
                        break;
                    } else if (c0778b.m3111f() == 45904) {
                        if (this.f17484a.f17346n.isShowing()) {
                            this.f17484a.f17346n.dismiss();
                        }
                        this.f17484a.m17965a(false, (C0778b) null, false);
                        if (this.f17484a.f17311aa == null) {
                            AbstractC4932a abstractC4932aM18733a2 = AbstractC4932a.m18733a(this.f17484a.f17302S);
                            abstractC4932aM18733a2.mo18734a(R.string.mypage_profile_add_photo).mo18746b(R.string.mypage_maximum_image_exceed).mo18751b(true).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC4770cb(this));
                            this.f17484a.f17311aa = abstractC4932aM18733a2.mo18745a();
                        }
                        this.f17484a.f17311aa.show();
                        break;
                    } else {
                        if (this.f17484a.f17346n.isShowing()) {
                            this.f17484a.f17346n.dismiss();
                        }
                        C5179v.m19810a(this.f17484a.f17302S, R.string.toast_network_unable, 0).show();
                        C4904y.m18646e("UserProfileImageViewFragment: METHOD_PROFILE_IMAGE_HISTORY_ADD failed", ProfileImageHistoryFragment.f17281d);
                        break;
                    }
                    break;
                case 405:
                    C0778b c0778b2 = (C0778b) message.obj;
                    if (c0778b2.m18954n() && c0778b2.m3107b() == EnumC2464o.SUCCESS) {
                        this.f17484a.f17315ae = null;
                        if (this.f17484a.f17345m) {
                            this.f17484a.m17965a(true, c0778b2, false);
                        } else {
                            this.f17484a.f17321ak.m17933h().mo18823a(this.f17484a.getText(R.string.mypage_profile_image));
                            this.f17484a.m17965a(true, c0778b2, true);
                        }
                        C5179v.m19810a(this.f17484a.f17302S, R.string.trunk_toast_deleted, 0).show();
                        break;
                    } else if (c0778b2.m3111f() == 45903) {
                        C5179v.m19810a(this.f17484a.f17302S, R.string.trunk_content_deleted, 0).show();
                        this.f17484a.m17965a(false, (C0778b) null, false);
                        break;
                    } else {
                        if (this.f17484a.f17347o.isShowing()) {
                            this.f17484a.f17347o.dismiss();
                        }
                        if (this.f17484a.f17346n.isShowing()) {
                            this.f17484a.f17346n.dismiss();
                        }
                        C5179v.m19810a(this.f17484a.f17302S, R.string.toast_setting_profile_image_save_failed, 0).show();
                        break;
                    }
                    break;
                case 406:
                    C0778b c0778b3 = (C0778b) message.obj;
                    if (c0778b3.m18954n() && c0778b3.m3107b() != EnumC2464o.ERROR) {
                        if (this.f17484a.f17300Q.booleanValue()) {
                            this.f17484a.f17321ak.m17933h().mo18823a(this.f17484a.getText(R.string.mypage_profile_image));
                            this.f17484a.f17315ae = null;
                            this.f17484a.f17314ad = "";
                            this.f17484a.f17290G.setVisibility(0);
                            C4809aa.m18108a("profile_small_image0", (String) null);
                            this.f17484a.m17965a(true, c0778b3, false);
                            C5179v.m19810a(this.f17484a.f17302S, R.string.toast_save_media, 0).show();
                            this.f17484a.f17300Q = false;
                            break;
                        } else {
                            this.f17484a.m17965a(true, c0778b3, false);
                            C5179v.m19810a(this.f17484a.f17302S, R.string.toast_save_media, 0).show();
                            break;
                        }
                    } else if (c0778b3.m3111f() == 45903) {
                        C5179v.m19810a(this.f17484a.f17302S, R.string.trunk_content_deleted, 0).show();
                        this.f17484a.m17965a(false, (C0778b) null, false);
                        break;
                    } else {
                        if (this.f17484a.f17346n.isShowing()) {
                            this.f17484a.f17346n.dismiss();
                        }
                        C4904y.m18646e("UserProfileImageViewFragment: METHOD_PROFILE_IMAGE_HISTORY_SET failed", ProfileImageHistoryFragment.f17281d);
                        C5179v.m19810a(this.f17484a.f17302S, R.string.toast_network_unable, 0).show();
                        break;
                    }
                case 407:
                    this.f17484a.m17956a((C0778b) message.obj, false);
                    break;
                case 410:
                    C0778b c0778b4 = (C0778b) message.obj;
                    if (!c0778b4.m18954n() || c0778b4.m3107b() == EnumC2464o.ERROR) {
                        this.f17484a.f17296M.setVisibility(8);
                        if (this.f17484a.f17346n.isShowing()) {
                            this.f17484a.f17346n.dismiss();
                        }
                        C5179v.m19810a(this.f17484a.f17302S, R.string.toast_network_unable, 0).show();
                        break;
                    } else {
                        GetProfileImageList getProfileImageList = (GetProfileImageList) c0778b4.m3110e();
                        if (getProfileImageList != null) {
                            this.f17484a.f17317ag = getProfileImageList.listcount.intValue();
                            this.f17484a.f17319ai = getProfileImageList.profileimagelist;
                            if (this.f17484a.f17319ai != null && this.f17484a.f17319ai.size() > 0) {
                                for (int i = 0; i < this.f17484a.f17319ai.size(); i++) {
                                    ProfileImage profileImage = (ProfileImage) this.f17484a.f17319ai.get(i);
                                    if (profileImage.profileimageid.equals(this.f17484a.f17327aq)) {
                                        this.f17484a.f17315ae = profileImage.profileimageid;
                                        if (this.f17484a.f17329as) {
                                            File file = new File(this.f17484a.f17336c);
                                            if (!file.exists()) {
                                                file.mkdir();
                                            }
                                            C4904y.m18646e("main profileimageurl : " + profileImage.profileimageurl.toString() + this.f17484a.f17294K, getClass().getSimpleName());
                                            this.f17484a.f17293J.m19023b(this.f17484a.f17339g, new CallableC4761bt(this.f17484a.f17298O, this.f17484a.f17301R, profileImage.profileimageurl.toString() + this.f17484a.f17294K, 600, 600, this.f17484a.f17336c, "buddy_f_" + this.f17484a.f17326ap + "_" + profileImage.profileimageid, false));
                                        }
                                    }
                                    if (Spam.ACTIVITY_REPORT.equals(profileImage.represent)) {
                                        this.f17484a.f17314ad = profileImage.profileimageid;
                                        this.f17484a.f17295L = profileImage.profileimageurl;
                                        File file2 = new File(this.f17484a.f17336c);
                                        if (!file2.exists()) {
                                            file2.mkdir();
                                        }
                                        String str = this.f17484a.f17336c + "buddy_t_" + this.f17484a.f17326ap + "_" + profileImage.profileimageid;
                                        String str2 = this.f17484a.f17336c + "buddy_f_" + this.f17484a.f17326ap + "_" + profileImage.profileimageid;
                                        if (this.f17484a.f17328ar.equals("FULL")) {
                                            String str3 = this.f17484a.f17335b + this.f17484a.f17326ap + "/buddy_f_" + this.f17484a.f17326ap + "_" + this.f17484a.f17327aq;
                                            String str4 = this.f17484a.f17335b + this.f17484a.f17326ap + "/buddy_f_" + this.f17484a.f17326ap + "_" + this.f17484a.f17327aq;
                                            if (new File(str4).exists() && !new File(str).exists()) {
                                                C4894o.m18607a(str4, str);
                                            }
                                            if (new File(str3).exists() && !new File(str2).exists()) {
                                                C4894o.m18607a(str3, str2);
                                            }
                                        }
                                    }
                                    C4904y.m18646e("profileimageurl: " + profileImage.profileimageurl.toString(), getClass().getSimpleName());
                                    ProfileImageHistoryFragment.ProfileImageItem profileImageItem = new ProfileImageHistoryFragment.ProfileImageItem();
                                    profileImageItem.f17357id = profileImage.profileimageurl.toString() + this.f17484a.f17294K;
                                    profileImageItem.dirCachePath = this.f17484a.f17336c;
                                    profileImageItem.ThumbfileName = "buddy_t_" + this.f17484a.f17326ap + "_" + profileImage.profileimageid;
                                    profileImageItem.FullfileName = "buddy_f_" + this.f17484a.f17326ap + "_" + profileImage.profileimageid;
                                    profileImageItem.Represent = profileImage.represent;
                                    profileImageItem.imageId = profileImage.profileimageid;
                                    C4904y.m18646e("profileimageurl : " + profileImageItem.f17357id, getClass().getSimpleName());
                                    this.f17484a.f17292I.add(profileImageItem);
                                }
                            }
                            this.f17484a.m17999k();
                            if (this.f17484a.f17285B != null) {
                                this.f17484a.f17285B.setEnabled(true);
                            }
                            this.f17484a.f17296M.setVisibility(8);
                            this.f17484a.setHasOptionsMenu(true);
                            if (this.f17484a.f17346n.isShowing()) {
                                this.f17484a.f17346n.dismiss();
                                break;
                            }
                        }
                    }
                    break;
            }
        }
    }
}
