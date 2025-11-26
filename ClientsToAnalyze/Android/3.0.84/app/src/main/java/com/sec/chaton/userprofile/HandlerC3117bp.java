package com.sec.chaton.userprofile;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p016a.p017a.C0274k;
import com.sec.chaton.p035io.entry.GetProfileImageList;
import com.sec.chaton.p035io.entry.inner.ProfileImage;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.userprofile.ProfileImageHistoryFragment;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3243r;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;
import java.io.File;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: ProfileImageHistoryFragment.java */
/* renamed from: com.sec.chaton.userprofile.bp */
/* loaded from: classes.dex */
class HandlerC3117bp extends Handler {

    /* renamed from: a */
    final /* synthetic */ ProfileImageHistoryFragment f11350a;

    HandlerC3117bp(ProfileImageHistoryFragment profileImageHistoryFragment) {
        this.f11350a = profileImageHistoryFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        if (this.f11350a.f11217S != null) {
            switch (message.what) {
                case 402:
                    if (((C0274k) message.obj).f858a) {
                        this.f11350a.f11256p.m5935c();
                        break;
                    } else {
                        if (this.f11350a.f11254n.isShowing()) {
                            this.f11350a.f11254n.dismiss();
                        }
                        if (this.f11350a.f11222X == null) {
                            AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(this.f11350a.f11217S);
                            abstractC3271aM11494a.mo11495a(R.string.ams_attention_title).mo11506b(R.string.toast_setting_profile_update_failed).mo11511b(true).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3119br(this)).mo11507b(R.string.setting_delete_account_cancel, new DialogInterfaceOnClickListenerC3118bq(this));
                            this.f11350a.f11222X = abstractC3271aM11494a.mo11505a();
                        }
                        this.f11350a.f11222X.show();
                        break;
                    }
                case HttpResponseCode.NOT_FOUND /* 404 */:
                    C0267d c0267d = (C0267d) message.obj;
                    if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                        if (this.f11350a.f11254n.isShowing()) {
                            this.f11350a.f11254n.dismiss();
                        }
                        C3641ai.m13210a(this.f11350a.f11217S, R.string.toast_network_unable, 0).show();
                        C3250y.m11456e("UserProfileImageViewFragment: METHOD_PROFILE_IMAGE_HISTORY_ADD failed", ProfileImageHistoryFragment.f11196d);
                        break;
                    } else {
                        this.f11350a.f11207I.clear();
                        C3159aa.m10966a("profile_image_status", "updated");
                        this.f11350a.m10811a(true, c0267d);
                        break;
                    }
                    break;
                case 405:
                    C0267d c0267d2 = (C0267d) message.obj;
                    if (c0267d2.m11704n() && c0267d2.m1351b() == EnumC1587o.SUCCESS) {
                        this.f11350a.f11224Z = null;
                        if (this.f11350a.f11253m) {
                            this.f11350a.f11207I.clear();
                            this.f11350a.m10811a(true, c0267d2);
                        } else {
                            this.f11350a.f11231af.m10781c().mo11583a(this.f11350a.getText(R.string.mypage_profile_image));
                            this.f11350a.f11207I.clear();
                            this.f11350a.m10811a(true, c0267d2);
                        }
                        C3641ai.m13210a(this.f11350a.f11217S, R.string.trunk_toast_deleted, 0).show();
                        break;
                    } else if (c0267d2.m1355f() == 45903) {
                        if (this.f11350a.f11255o.isShowing()) {
                            this.f11350a.f11255o.dismiss();
                        }
                        if (this.f11350a.f11254n.isShowing()) {
                            this.f11350a.f11254n.dismiss();
                        }
                        C3641ai.m13210a(this.f11350a.f11217S, R.string.toast_setting_profile_update_failed, 0).show();
                        this.f11350a.f11207I.clear();
                        this.f11350a.m10811a(false, (C0267d) null);
                        break;
                    } else {
                        if (this.f11350a.f11255o.isShowing()) {
                            this.f11350a.f11255o.dismiss();
                        }
                        if (this.f11350a.f11254n.isShowing()) {
                            this.f11350a.f11254n.dismiss();
                        }
                        C3641ai.m13210a(this.f11350a.f11217S, R.string.toast_setting_profile_image_save_failed, 0).show();
                        break;
                    }
                    break;
                case HttpResponseCode.NOT_ACCEPTABLE /* 406 */:
                    C0267d c0267d3 = (C0267d) message.obj;
                    if (c0267d3.m11704n() && c0267d3.m1351b() != EnumC1587o.ERROR) {
                        if (this.f11350a.f11215Q.booleanValue()) {
                            this.f11350a.f11231af.m10781c().mo11583a(this.f11350a.getText(R.string.mypage_profile_image));
                            this.f11350a.f11224Z = null;
                            this.f11350a.f11223Y = "";
                            this.f11350a.f11205G.setVisibility(0);
                            C3159aa.m10966a("profile_small_image0", (String) null);
                            this.f11350a.f11207I.clear();
                            this.f11350a.m10811a(true, c0267d3);
                            C3641ai.m13210a(this.f11350a.f11217S, R.string.toast_save_media, 0).show();
                            this.f11350a.f11215Q = false;
                            break;
                        } else {
                            this.f11350a.f11207I.clear();
                            this.f11350a.m10811a(true, c0267d3);
                            C3641ai.m13210a(this.f11350a.f11217S, R.string.toast_save_media, 0).show();
                            break;
                        }
                    } else if (c0267d3.m1355f() == 45903) {
                        C3641ai.m13210a(this.f11350a.f11217S, R.string.toast_setting_profile_update_failed, 0).show();
                        this.f11350a.f11207I.clear();
                        this.f11350a.m10811a(true, c0267d3);
                        break;
                    } else {
                        if (this.f11350a.f11254n.isShowing()) {
                            this.f11350a.f11254n.dismiss();
                        }
                        C3250y.m11456e("UserProfileImageViewFragment: METHOD_PROFILE_IMAGE_HISTORY_SET failed", ProfileImageHistoryFragment.f11196d);
                        C3641ai.m13210a(this.f11350a.f11217S, R.string.toast_network_unable, 0).show();
                        break;
                    }
                case 407:
                    this.f11350a.m10802a((C0267d) message.obj);
                    break;
                case 410:
                    C0267d c0267d4 = (C0267d) message.obj;
                    if (!c0267d4.m11704n() || c0267d4.m1351b() == EnumC1587o.ERROR) {
                        this.f11350a.f11211M.setVisibility(8);
                        if (this.f11350a.f11254n.isShowing()) {
                            this.f11350a.f11254n.dismiss();
                        }
                        C3641ai.m13210a(this.f11350a.f11217S, R.string.toast_network_unable, 0).show();
                        break;
                    } else {
                        GetProfileImageList getProfileImageList = (GetProfileImageList) c0267d4.m1354e();
                        if (getProfileImageList != null) {
                            this.f11350a.f11227ab = getProfileImageList.listcount.intValue();
                            this.f11350a.f11229ad = getProfileImageList.profileimagelist;
                            if (this.f11350a.f11229ad != null && this.f11350a.f11229ad.size() > 0) {
                                for (int i = 0; i < this.f11350a.f11229ad.size(); i++) {
                                    ProfileImage profileImage = (ProfileImage) this.f11350a.f11229ad.get(i);
                                    if (profileImage.profileimageid.equals(this.f11350a.f11236ak)) {
                                        this.f11350a.f11224Z = profileImage.profileimageid;
                                        if (this.f11350a.f11238am) {
                                            File file = new File(this.f11350a.f11244c);
                                            if (!file.exists()) {
                                                file.mkdir();
                                            }
                                            C3250y.m11456e("main profileimageurl : " + profileImage.profileimageurl.toString() + this.f11350a.f11209K, getClass().getSimpleName());
                                            this.f11350a.f11208J.m11730a(this.f11350a.f11247g, new CallableC3115bn(this.f11350a.f11213O, this.f11350a.f11216R, profileImage.profileimageurl.toString() + this.f11350a.f11209K, 600, 600, this.f11350a.f11244c, "buddy_f_" + this.f11350a.f11235aj + "_" + profileImage.profileimageid, false));
                                        }
                                    }
                                    if ("1".equals(profileImage.represent)) {
                                        this.f11350a.f11223Y = profileImage.profileimageid;
                                        this.f11350a.f11210L = profileImage.profileimageurl;
                                        File file2 = new File(this.f11350a.f11244c);
                                        if (!file2.exists()) {
                                            file2.mkdir();
                                        }
                                        String str = this.f11350a.f11244c + "buddy_t_" + this.f11350a.f11235aj + "_" + profileImage.profileimageid;
                                        String str2 = this.f11350a.f11244c + "buddy_f_" + this.f11350a.f11235aj + "_" + profileImage.profileimageid;
                                        if (this.f11350a.f11237al.equals("FULL")) {
                                            String str3 = this.f11350a.f11243b + this.f11350a.f11235aj + "/buddy_f_" + this.f11350a.f11235aj + "_" + this.f11350a.f11236ak;
                                            String str4 = this.f11350a.f11243b + this.f11350a.f11235aj + "/buddy_f_" + this.f11350a.f11235aj + "_" + this.f11350a.f11236ak;
                                            if (new File(str4).exists() && !new File(str).exists()) {
                                                C3243r.m11420a(str4, str);
                                            }
                                            if (new File(str3).exists() && !new File(str2).exists()) {
                                                C3243r.m11420a(str3, str2);
                                            }
                                        }
                                    }
                                    C3250y.m11456e("profileimageurl: " + profileImage.profileimageurl.toString(), getClass().getSimpleName());
                                    ProfileImageHistoryFragment.ProfileImageItem profileImageItem = new ProfileImageHistoryFragment.ProfileImageItem();
                                    profileImageItem.f11265id = profileImage.profileimageurl.toString() + this.f11350a.f11209K;
                                    profileImageItem.dirCachePath = this.f11350a.f11244c;
                                    profileImageItem.ThumbfileName = "buddy_t_" + this.f11350a.f11235aj + "_" + profileImage.profileimageid;
                                    profileImageItem.FullfileName = "buddy_f_" + this.f11350a.f11235aj + "_" + profileImage.profileimageid;
                                    profileImageItem.Represent = profileImage.represent;
                                    profileImageItem.imageId = profileImage.profileimageid;
                                    C3250y.m11456e("profileimageurl : " + profileImageItem.f11265id, getClass().getSimpleName());
                                    this.f11350a.f11207I.add(profileImageItem);
                                }
                            }
                            this.f11350a.m10844k();
                            this.f11350a.f11200B.setEnabled(true);
                            this.f11350a.f11211M.setVisibility(8);
                            if (this.f11350a.f11254n.isShowing()) {
                                this.f11350a.f11254n.dismiss();
                                break;
                            }
                        }
                    }
                    break;
            }
        }
    }
}
