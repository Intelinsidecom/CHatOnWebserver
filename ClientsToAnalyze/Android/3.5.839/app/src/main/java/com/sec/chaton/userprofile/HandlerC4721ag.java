package com.sec.chaton.userprofile;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.inner.CoverStoryAdd;
import com.sec.chaton.p065io.entry.inner.CoverStoryDownload;
import com.sec.chaton.p065io.entry.inner.CoverStorySampleList;
import com.sec.chaton.p065io.entry.inner.ProfileInformationList;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.poston.C2955a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4894o;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;

/* compiled from: MyInfoFragment.java */
/* renamed from: com.sec.chaton.userprofile.ag */
/* loaded from: classes.dex */
class HandlerC4721ag extends Handler {

    /* renamed from: a */
    final /* synthetic */ MyInfoFragment f17385a;

    HandlerC4721ag(MyInfoFragment myInfoFragment) {
        this.f17385a = myInfoFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        if (this.f17385a.getActivity() != null) {
            switch (message.what) {
                case 417:
                    C0778b c0778b = (C0778b) message.obj;
                    if (c0778b != null) {
                        if (c0778b.m18954n() && c0778b.m3107b() == EnumC2464o.SUCCESS) {
                            if (C4904y.f17871a) {
                                C4904y.m18646e("ProfileControl.METHOD_GET_PROFILE_ALL Success", getClass().getSimpleName());
                            }
                            C4754bm.m18047a(((ProfileInformationList) c0778b.m3110e()).coverstory, this.f17385a.f17151G, this.f17385a.f17152H, this.f17385a.f17161Q);
                            this.f17385a.m17844b();
                            this.f17385a.m17850e();
                            break;
                        } else {
                            C5179v.m19810a(this.f17385a.getActivity(), R.string.popup_no_network_connection, 0).show();
                            break;
                        }
                    }
                    break;
                case 3002:
                    if (this.f17385a.f17153I != null && this.f17385a.f17153I.isShowing()) {
                        this.f17385a.f17153I.dismiss();
                    }
                    C0778b c0778b2 = (C0778b) message.obj;
                    if (c0778b2.m18954n() && c0778b2.m3107b() != EnumC2464o.ERROR) {
                        C4754bm.m18048a(this.f17385a.f17156L, this.f17385a.f17157M, this.f17385a.f17151G, (CoverStoryAdd) c0778b2.m3110e());
                    } else {
                        this.f17385a.f17158N = AbstractC4932a.m18733a(this.f17385a.getActivity()).mo18734a(R.string.ams_attention_title).mo18746b(R.string.toast_setting_profile_update_failed).mo18751b(true).mo18756d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC4723ai(this)).mo18747b(R.string.setting_delete_account_cancel, new DialogInterfaceOnClickListenerC4722ah(this)).mo18752b();
                    }
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[CoverStory] CoverStoryControl.METHOD_ADD_COVERSTORY", MyInfoFragment.f17144c);
                        break;
                    }
                    break;
                case 3004:
                    C0778b c0778b3 = (C0778b) message.obj;
                    if (c0778b3.m18954n() && c0778b3.m3110e() != null && c0778b3.m3107b() != EnumC2464o.ERROR) {
                        String str = this.f17385a.getActivity().getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/";
                        if (C4904y.f17871a) {
                            C4904y.m18646e("METHOD_CONTENT_COVERSTORY_LIST created and folder remove : " + str, MyInfoFragment.f17144c);
                        }
                        CoverStorySampleList coverStorySampleList = (CoverStorySampleList) c0778b3.m3110e();
                        C4809aa.m18105a("coverstory_first_set", (Boolean) false);
                        C4809aa.m18107a("get_coverstory_sample_timestamp", coverStorySampleList.timestamp);
                        C4894o.m18606a(str);
                        break;
                    } else if (C4904y.f17871a) {
                        C4904y.m18646e("METHOD_CONTENT_COVERSTORY_LIST failed ", MyInfoFragment.f17144c);
                        break;
                    }
                    break;
                case 3005:
                    C0778b c0778b4 = (C0778b) message.obj;
                    if (c0778b4 == null) {
                        C4904y.m18639b("CoverStoryControl.METHOD_CONTENT_COVERSTORY_DOWNLOAD (httpEntry == null)", getClass().getSimpleName());
                        break;
                    } else if (c0778b4.m18954n() && c0778b4.m3110e() != null && c0778b4.m3107b() != EnumC2464o.ERROR) {
                        CoverStoryDownload coverStoryDownload = (CoverStoryDownload) c0778b4.m3110e();
                        C4809aa.m18108a("coverstory_file_name", "mycoverstory.jpg");
                        C4809aa.m18108a("mypage_coverstory_state", "updated");
                        this.f17385a.f17161Q.m19023b(this.f17385a.f17151G, new C2955a(coverStoryDownload.fileurl, C4809aa.m18104a().m18121a("chaton_id", ""), C2955a.f11033b, this.f17385a.getActivity(), this.f17385a.f17162R, "mycoverstory.jpg", C4809aa.m18104a().m18121a("coverstory_contentid", "")));
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
                        this.f17385a.f17161Q.m19023b(this.f17385a.f17151G, new C2955a(coverStoryDownload2.fileurl, C4809aa.m18104a().m18121a("chaton_id", ""), C2955a.f11033b, this.f17385a.getActivity(), this.f17385a.f17162R, "mycoverstory.jpg", C4809aa.m18104a().m18121a("coverstory_contentid", "")));
                        break;
                    }
                    break;
            }
        }
    }
}
