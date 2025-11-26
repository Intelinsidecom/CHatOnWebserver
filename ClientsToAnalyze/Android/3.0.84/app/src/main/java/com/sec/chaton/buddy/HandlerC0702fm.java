package com.sec.chaton.buddy;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyProfileImageViewFragment;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.GetProfileImageList;
import com.sec.chaton.p035io.entry.inner.ProfileImage;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.userprofile.CallableC3115bn;
import com.sec.chaton.util.C3231f;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;
import java.io.File;

/* compiled from: BuddyProfileImageViewFragment.java */
/* renamed from: com.sec.chaton.buddy.fm */
/* loaded from: classes.dex */
class HandlerC0702fm extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileImageViewFragment f2942a;

    HandlerC0702fm(BuddyProfileImageViewFragment buddyProfileImageViewFragment) {
        this.f2942a = buddyProfileImageViewFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f2942a.f2141P != null) {
            switch (message.what) {
                case 410:
                    C0267d c0267d = (C0267d) message.obj;
                    if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                        this.f2942a.f2127B.setVisibility(8);
                        if (this.f2942a.f2151j.isShowing()) {
                            this.f2942a.f2151j.dismiss();
                        }
                        if (!c0267d.m11704n() || c0267d.m1351b() != EnumC1587o.NO_CONTENT) {
                            C3641ai.m13210a(this.f2942a.f2141P, R.string.toast_network_unable, 0).show();
                        } else {
                            this.f2942a.m3747e();
                            C3231f.m11361a(this.f2942a.getActivity().getApplicationContext()).m11386b(this.f2942a.f2137L);
                        }
                        this.f2942a.f2141P.setRequestedOrientation(-1);
                        break;
                    } else {
                        GetProfileImageList getProfileImageList = (GetProfileImageList) c0267d.m1354e();
                        if (getProfileImageList != null) {
                            this.f2942a.f2135J = getProfileImageList.listcount.intValue();
                            this.f2942a.f2136K = getProfileImageList.profileimagelist;
                            if (this.f2942a.f2136K != null && this.f2942a.f2136K.size() > 0) {
                                for (int i = 0; i < this.f2942a.f2136K.size(); i++) {
                                    ProfileImage profileImage = (ProfileImage) this.f2942a.f2136K.get(i);
                                    if (profileImage.profileimageid.equals(this.f2942a.f2138M)) {
                                        this.f2942a.f2133H = profileImage.profileimageid;
                                        if (this.f2942a.f2140O) {
                                            File file = new File(this.f2942a.m3763a());
                                            if (!file.exists()) {
                                                file.mkdir();
                                            }
                                            C3250y.m11456e("main profileimageurl : " + profileImage.profileimageurl.toString() + this.f2942a.f2165x, getClass().getSimpleName());
                                            this.f2942a.f2164w.m11730a(this.f2942a.f2150i, new CallableC3115bn(this.f2942a.f2129D, profileImage.profileimageurl.toString() + this.f2942a.f2165x, 600, 600, this.f2942a.m3763a(), "buddy_f_" + this.f2942a.f2137L + "_" + profileImage.profileimageid));
                                        }
                                    }
                                    if ("1".equals(profileImage.represent)) {
                                        this.f2942a.f2132G = profileImage.profileimageid;
                                        this.f2942a.f2126A = profileImage.profileimageurl;
                                        File file2 = new File(this.f2942a.m3763a());
                                        if (!file2.exists()) {
                                            file2.mkdir();
                                        }
                                    }
                                    C3250y.m11456e("profileimageurl: " + profileImage.profileimageurl.toString(), getClass().getSimpleName());
                                    this.f2942a.f2166y = "buddy_t_" + this.f2942a.f2137L + "_" + profileImage.profileimageid;
                                    BuddyProfileImageViewFragment.ProfileImageItem profileImageItem = new BuddyProfileImageViewFragment.ProfileImageItem();
                                    profileImageItem.f2168id = profileImage.profileimageurl.toString() + this.f2942a.f2165x;
                                    profileImageItem.dirCachePath = this.f2942a.m3763a();
                                    profileImageItem.ThumbfileName = "buddy_t_" + this.f2942a.f2137L + "_" + profileImage.profileimageid;
                                    profileImageItem.FullfileName = "buddy_f_" + this.f2942a.f2137L + "_" + profileImage.profileimageid;
                                    profileImageItem.Represent = profileImage.represent;
                                    profileImageItem.imageId = profileImage.profileimageid;
                                    C3250y.m11456e("profileimageurl : " + profileImageItem.f2168id, getClass().getSimpleName());
                                    this.f2942a.f2163v.add(profileImageItem);
                                }
                            }
                            this.f2942a.m3744d();
                            this.f2942a.f2127B.setVisibility(8);
                            this.f2942a.setHasOptionsMenu(false);
                            if (this.f2942a.f2151j.isShowing()) {
                                this.f2942a.f2151j.dismiss();
                            }
                            this.f2942a.f2141P.setRequestedOrientation(-1);
                            break;
                        }
                    }
                    break;
            }
        }
    }
}
