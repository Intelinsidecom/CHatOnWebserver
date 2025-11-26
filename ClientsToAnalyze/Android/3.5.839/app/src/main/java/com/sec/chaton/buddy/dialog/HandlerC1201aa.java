package com.sec.chaton.buddy.dialog;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2194h;
import com.sec.chaton.p065io.entry.GetProfileImageList;
import com.sec.chaton.p065io.entry.inner.BuddyProfile;
import com.sec.chaton.p065io.entry.inner.CoverStory;
import com.sec.chaton.p065io.entry.inner.CoverStoryDownload;
import com.sec.chaton.p065io.entry.inner.ProfileInformationList;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.poston.C2955a;
import com.sec.chaton.userprofile.C4754bm;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: MeDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.aa */
/* loaded from: classes.dex */
class HandlerC1201aa extends Handler {

    /* renamed from: a */
    final /* synthetic */ MeDialog f4696a;

    HandlerC1201aa(MeDialog meDialog) {
        this.f4696a = meDialog;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f4696a.getApplicationContext() != null) {
            switch (message.what) {
                case 411:
                    C0778b c0778b = (C0778b) message.obj;
                    if (c0778b != null && c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.SUCCESS) {
                        this.f4696a.m7300a((BuddyProfile) c0778b.m3110e());
                        break;
                    }
                    break;
                case 417:
                    C0778b c0778b2 = (C0778b) message.obj;
                    C4904y.m18639b("ProfileControl.METHOD_PROFILE_INFORMATION", getClass().getSimpleName());
                    if (c0778b2 == null) {
                        C4904y.m18639b("ProfileControl.METHOD_PROFILE_INFORMATION (httpEntry == null)", getClass().getSimpleName());
                        break;
                    } else if (c0778b2.m18954n() && c0778b2.m3107b() == EnumC2464o.SUCCESS) {
                        ProfileInformationList profileInformationList = (ProfileInformationList) c0778b2.m3110e();
                        BuddyProfile buddyProfile = profileInformationList.profile;
                        CoverStory coverStory = profileInformationList.coverstory;
                        GetProfileImageList getProfileImageList = profileInformationList.profileimage;
                        if (buddyProfile.timestamp != null) {
                            this.f4696a.m7300a(buddyProfile);
                        }
                        if (coverStory.metaid != null) {
                            C4754bm.m18047a(coverStory, this.f4696a.f4585G, this.f4696a.f4584F, this.f4696a.f4609j);
                        }
                        C4754bm.m18046a(this.f4696a.f4596R);
                        break;
                    } else {
                        C4904y.m18639b("ProfileControl.METHOD_PROFILE_INFORMATION httpEntry fail", MeDialog.f4578a);
                        if (c0778b2.m18954n() && c0778b2.m3107b() == EnumC2464o.NO_CONTENT) {
                            C4904y.m18639b("ProfileControl.METHOD_PROFILE_INFORMATION HttpResultCode.NO_CONTENT", MeDialog.f4578a);
                            break;
                        }
                    }
                    break;
                case 3001:
                    C0778b c0778b3 = (C0778b) message.obj;
                    C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY", getClass().getSimpleName());
                    if (c0778b3 == null) {
                        C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY (httpEntry == null)", getClass().getSimpleName());
                        break;
                    } else if (c0778b3.m18954n() && c0778b3.m3107b() == EnumC2464o.SUCCESS) {
                        CoverStory coverStory2 = (CoverStory) c0778b3.m3110e();
                        if (coverStory2 != null) {
                            C4754bm.m18047a(coverStory2, this.f4696a.f4585G, this.f4696a.f4584F, this.f4696a.f4609j);
                            break;
                        }
                    } else {
                        C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY httpEntry fail", MeDialog.f4578a);
                        if (c0778b3.m18954n() && c0778b3.m3107b() == EnumC2464o.NO_CONTENT) {
                            C4904y.m18639b("CoverStoryControl.METHOD_GET_COVERSTORY HttpResultCode.NO_CONTENT", MeDialog.f4578a);
                            break;
                        }
                    }
                    break;
                case 3005:
                    C0778b c0778b4 = (C0778b) message.obj;
                    if (c0778b4 == null) {
                        C4904y.m18639b("MeDialog CoverStoryControl.METHOD_CONTENT_COVERSTORY_DOWNLOAD (httpEntry == null)", getClass().getSimpleName());
                        break;
                    } else if (c0778b4.m18954n() && c0778b4.m3110e() != null && c0778b4.m3107b() != EnumC2464o.ERROR) {
                        CoverStoryDownload coverStoryDownload = (CoverStoryDownload) c0778b4.m3110e();
                        C4809aa.m18108a("coverstory_file_name", "mycoverstory.jpg");
                        C4809aa.m18108a("mypage_coverstory_state", "updated");
                        this.f4696a.f4609j.m19023b(this.f4696a.f4585G, new C2955a(coverStoryDownload.fileurl, this.f4696a.f4608i, C2955a.f11033b, this.f4696a.getApplicationContext(), this.f4696a.f4605f, "mycoverstory.jpg", this.f4696a.f4588J));
                        break;
                    } else if (c0778b4.m18954n() && c0778b4.m3107b() == EnumC2464o.NO_CONTENT) {
                        C4904y.m18639b("Deleted item on MeDialog mContentId : " + this.f4696a.f4588J, getClass().getSimpleName());
                        C2194h.m9893b(this.f4696a.f4588J);
                        if (this.f4696a.f4588J != null) {
                            this.f4696a.f4588J = null;
                        }
                        C4754bm.m18052a(this.f4696a.f4585G, this.f4696a.f4584F);
                        break;
                    }
                    break;
                case 3006:
                    C0778b c0778b5 = (C0778b) message.obj;
                    if (c0778b5 == null) {
                        C4904y.m18639b("CoverStoryControl.METHOD_CONTENT_COVERSTORY_DOWNLOAD_RANDOM (httpEntry == null)", getClass().getSimpleName());
                        break;
                    } else if (c0778b5.m18954n() && c0778b5.m3110e() != null && c0778b5.m3107b() != EnumC2464o.ERROR) {
                        CoverStoryDownload coverStoryDownload2 = (CoverStoryDownload) c0778b5.m3110e();
                        C4809aa.m18108a("coverstory_file_name", "mycoverstory.jpg");
                        this.f4696a.f4609j.m19023b(this.f4696a.f4585G, new C2955a(coverStoryDownload2.fileurl, this.f4696a.f4608i, C2955a.f11033b, this.f4696a.getApplicationContext(), this.f4696a.f4605f, "mycoverstory.jpg", null));
                        break;
                    }
                    break;
            }
        }
    }
}
