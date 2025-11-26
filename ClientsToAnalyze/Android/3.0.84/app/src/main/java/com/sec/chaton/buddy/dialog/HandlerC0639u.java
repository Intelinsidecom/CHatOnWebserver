package com.sec.chaton.buddy.dialog;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p027e.p028a.C1364h;
import com.sec.chaton.p035io.entry.GetProfileImageList;
import com.sec.chaton.p035io.entry.inner.BuddyProfile;
import com.sec.chaton.p035io.entry.inner.CoverStory;
import com.sec.chaton.p035io.entry.inner.CoverStoryDownload;
import com.sec.chaton.p035io.entry.inner.ProfileImage;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.poston.C1960a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3243r;
import com.sec.chaton.util.C3250y;
import java.io.File;

/* compiled from: MeDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.u */
/* loaded from: classes.dex */
class HandlerC0639u extends Handler {

    /* renamed from: a */
    final /* synthetic */ MeDialog f2859a;

    HandlerC0639u(MeDialog meDialog) {
        this.f2859a = meDialog;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        GetProfileImageList getProfileImageList;
        if (this.f2859a.getApplicationContext() != null) {
            switch (message.what) {
                case 407:
                    C0267d c0267d = (C0267d) message.obj;
                    if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR && (getProfileImageList = (GetProfileImageList) c0267d.m1354e()) != null) {
                        this.f2859a.f2755j = getProfileImageList.profileimagelist;
                        if (this.f2859a.f2755j != null && this.f2859a.f2755j.size() != 0) {
                            this.f2859a.f2751f = false;
                            if (this.f2859a.f2755j.size() > 4) {
                                this.f2859a.f2758m = 4;
                                if (this.f2859a.f2734B != null) {
                                    this.f2859a.f2734B.setVisibility(0);
                                }
                            } else {
                                this.f2859a.f2758m = this.f2859a.f2755j.size();
                            }
                            if (this.f2859a.f2755j.size() > 0) {
                                if (!"1".equals(((ProfileImage) this.f2859a.f2755j.get(0)).represent)) {
                                    this.f2859a.m4236a(0);
                                    C3159aa.m10966a("profile_image_status", "deleted");
                                    C3159aa.m10966a("profile_small_image0", (String) null);
                                    if (this.f2859a.f2755j.size() < 3) {
                                        this.f2859a.m4236a(3);
                                        C3159aa.m10966a("profile_small_image3", (String) null);
                                    }
                                    if (this.f2859a.f2755j.size() < 2) {
                                        this.f2859a.m4236a(2);
                                        C3159aa.m10966a("profile_small_image2", (String) null);
                                    }
                                    if (this.f2859a.f2755j.size() < 1) {
                                        this.f2859a.m4236a(1);
                                        C3159aa.m10966a("profile_small_image1", (String) null);
                                    }
                                } else {
                                    C3159aa.m10966a("profile_image_status", "updated");
                                    if (this.f2859a.f2755j.size() < 4) {
                                        this.f2859a.m4236a(3);
                                        C3159aa.m10966a("profile_small_image3", (String) null);
                                    }
                                    if (this.f2859a.f2755j.size() < 3) {
                                        this.f2859a.m4236a(2);
                                        C3159aa.m10966a("profile_small_image2", (String) null);
                                    }
                                    if (this.f2859a.f2755j.size() < 2) {
                                        this.f2859a.m4236a(1);
                                        C3159aa.m10966a("profile_small_image1", (String) null);
                                    }
                                }
                            }
                            for (int i = 0; i < this.f2859a.f2758m; i++) {
                                ProfileImage profileImage = (ProfileImage) this.f2859a.f2755j.get(i);
                                if ("1".equals(profileImage.represent)) {
                                    File file = new File(this.f2859a.f2747b);
                                    if (!file.exists()) {
                                        file.mkdir();
                                    }
                                    if (C3159aa.m10962a().m10977a("profile_image_update_client", (Boolean) true).booleanValue()) {
                                        String str = this.f2859a.f2747b + "profile_t_mine_" + profileImage.profileimageid;
                                        String str2 = this.f2859a.f2747b + "profile_f_mine_" + profileImage.profileimageid;
                                        String str3 = this.f2859a.f2752g + "myprofile.png_";
                                        String str4 = this.f2859a.f2752g + this.f2859a.f2756k + ".jpeg_";
                                        File file2 = new File(str);
                                        if (new File(str4).exists() && !file2.exists()) {
                                            C3243r.m11420a(str4, str);
                                        }
                                        File file3 = new File(str2);
                                        if (new File(str3).exists() && !file3.exists()) {
                                            C3243r.m11420a(str3, str2);
                                        }
                                    }
                                    this.f2859a.m4238a(0, profileImage, "profile_small_image0", this.f2859a.f2765t, true);
                                } else {
                                    C3250y.m11456e("profileimageurl: " + profileImage.profileimageurl.toString(), getClass().getSimpleName());
                                    if ("1".equals(((ProfileImage) this.f2859a.f2755j.get(0)).represent)) {
                                        this.f2859a.m4237a(i, profileImage);
                                    } else {
                                        this.f2859a.m4237a(i + 1, profileImage);
                                    }
                                }
                            }
                            break;
                        } else {
                            C3159aa.m10966a("profile_image_status", "deleted");
                            this.f2859a.f2751f = true;
                            this.f2859a.m4236a(0);
                            C3159aa.m10966a("profile_small_image0", (String) null);
                            break;
                        }
                    }
                    break;
                case 411:
                    C0267d c0267d2 = (C0267d) message.obj;
                    if (c0267d2 != null && c0267d2.m11704n() && c0267d2.m1351b() == EnumC1587o.SUCCESS) {
                        this.f2859a.m4246a((BuddyProfile) c0267d2.m1354e());
                        break;
                    }
                    break;
                case 3001:
                    C0267d c0267d3 = (C0267d) message.obj;
                    C3250y.m11450b("CoverStoryControl.METHOD_GET_COVERSTORY", getClass().getSimpleName());
                    if (c0267d3 == null) {
                        C3250y.m11450b("CoverStoryControl.METHOD_GET_COVERSTORY (httpEntry == null)", getClass().getSimpleName());
                        break;
                    } else if (c0267d3.m11704n() && c0267d3.m1351b() == EnumC1587o.SUCCESS) {
                        CoverStory coverStory = (CoverStory) c0267d3.m1354e();
                        if (coverStory != null) {
                            String strM10979a = C3159aa.m10962a().m10979a("coverstory_metaid", "");
                            if (coverStory.metaid != null) {
                                if (strM10979a != null) {
                                    C3250y.m11450b("CoverStoryControl.METHOD_GET_COVERSTORY mCoverStoryDir : " + strM10979a, getClass().getSimpleName());
                                    C3250y.m11450b("CoverStoryControl.METHOD_GET_COVERSTORY coverStoryInfo.metaid : " + coverStory.metaid, getClass().getSimpleName());
                                }
                                C3159aa.m10966a("mypage_coverstory_state", "updated");
                                C3159aa.m10966a("coverstory_metaid", coverStory.metaid);
                                if (coverStory.contentid == null) {
                                    this.f2859a.f2757l.m11730a(this.f2859a.f2736D, new C1960a(coverStory.host + coverStory.metacontents, this.f2859a.f2756k, "Buddy", this.f2859a.getApplicationContext(), this.f2859a.f2752g, "mycoverstory.jpg", coverStory.metaid));
                                } else {
                                    if (!this.f2859a.m4268a(coverStory.contentid)) {
                                        this.f2859a.f2735C.m5760a(coverStory.contentid, Integer.toString(this.f2859a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(this.f2859a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
                                    }
                                    this.f2859a.f2739G = coverStory.contentid;
                                    C3159aa.m10966a("coverstory_contentid", coverStory.contentid);
                                }
                                C3159aa.m10966a("mypage_coverstory_state", "updated");
                                C3159aa.m10966a("coverstory_metaid", coverStory.metaid);
                                break;
                            } else if (TextUtils.isEmpty(strM10979a)) {
                                C3250y.m11450b("previousMetaid is null. when setting coverstory first, pass ~!", getClass().getSimpleName());
                                break;
                            } else {
                                C3250y.m11450b("Set RandomCoverStory as randomId coverStoryInfo.metaid is null", getClass().getSimpleName());
                                this.f2859a.m4267a();
                                break;
                            }
                        }
                    } else if (!c0267d3.m11704n() || c0267d3.m1351b() != EnumC1587o.NO_CONTENT) {
                    }
                    break;
                case 3005:
                    C0267d c0267d4 = (C0267d) message.obj;
                    if (c0267d4 == null) {
                        C3250y.m11450b("MeDialog CoverStoryControl.METHOD_CONTENT_COVERSTORY_DOWNLOAD (httpEntry == null)", getClass().getSimpleName());
                        break;
                    } else if (c0267d4.m11704n() && c0267d4.m1354e() != null && c0267d4.m1351b() != EnumC1587o.ERROR) {
                        CoverStoryDownload coverStoryDownload = (CoverStoryDownload) c0267d4.m1354e();
                        C3159aa.m10966a("coverstory_file_name", "mycoverstory.jpg");
                        C3159aa.m10966a("mypage_coverstory_state", "updated");
                        this.f2859a.f2757l.m11730a(this.f2859a.f2736D, new C1960a(coverStoryDownload.fileurl, this.f2859a.f2756k, C1960a.f7636b, this.f2859a.getApplicationContext(), this.f2859a.f2752g, "mycoverstory.jpg", this.f2859a.f2739G));
                        break;
                    } else if (c0267d4.m11704n() && c0267d4.m1351b() == EnumC1587o.NO_CONTENT) {
                        C3250y.m11450b("Deleted item on MeDialog mContentId : " + this.f2859a.f2739G, getClass().getSimpleName());
                        C1364h.m6088b(this.f2859a.f2739G);
                        if (this.f2859a.f2739G != null) {
                            this.f2859a.f2739G = null;
                        }
                        this.f2859a.m4267a();
                        break;
                    }
                    break;
                case 3006:
                    C0267d c0267d5 = (C0267d) message.obj;
                    if (c0267d5 == null) {
                        C3250y.m11450b("CoverStoryControl.METHOD_CONTENT_COVERSTORY_DOWNLOAD_RANDOM (httpEntry == null)", getClass().getSimpleName());
                        break;
                    } else if (c0267d5.m11704n() && c0267d5.m1354e() != null && c0267d5.m1351b() != EnumC1587o.ERROR) {
                        CoverStoryDownload coverStoryDownload2 = (CoverStoryDownload) c0267d5.m1354e();
                        C3159aa.m10966a("coverstory_file_name", "mycoverstory.jpg");
                        this.f2859a.f2757l.m11730a(this.f2859a.f2736D, new C1960a(coverStoryDownload2.fileurl, this.f2859a.f2756k, C1960a.f7636b, this.f2859a.getApplicationContext(), this.f2859a.f2752g, "mycoverstory.jpg", null));
                        break;
                    }
                    break;
            }
        }
    }
}
