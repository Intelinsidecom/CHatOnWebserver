package com.sec.chaton.userprofile;

import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p046a.p047a.C0790n;
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

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.az */
/* loaded from: classes.dex */
class HandlerC4740az extends Handler {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f17404a;

    HandlerC4740az(MyPageFragment myPageFragment) {
        this.f17404a = myPageFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f17404a.getActivity() != null && !this.f17404a.getActivity().isFinishing()) {
            switch (message.what) {
                case 402:
                    if (((C0790n) message.obj).f2172a) {
                        if (this.f17404a.f17240ai != null) {
                            this.f17404a.f17208M.m9316e(this.f17404a.f17240ai.getPath());
                            break;
                        }
                    } else {
                        if (this.f17404a.f17278y != null && this.f17404a.f17278y.isShowing()) {
                            this.f17404a.f17278y.dismiss();
                        }
                        this.f17404a.f17220Y = AbstractC4932a.m18733a(this.f17404a.getActivity()).mo18734a(R.string.ams_attention_title).mo18746b(R.string.toast_setting_profile_update_failed).mo18751b(true).mo18756d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC4744bc(this)).mo18747b(R.string.setting_delete_account_cancel, new DialogInterfaceOnClickListenerC4743bb(this)).mo18752b();
                        break;
                    }
                    break;
                case 404:
                    C0778b c0778b = (C0778b) message.obj;
                    if (this.f17404a.f17278y != null && this.f17404a.f17278y.isShowing()) {
                        this.f17404a.f17278y.dismiss();
                    }
                    if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                        C5179v.m19810a(this.f17404a.getActivity(), R.string.toast_network_unable, 0).show();
                        if (C4904y.f17871a) {
                            C4904y.m18646e("MyPageFragment: METHOD_PROFILE_IMAGE_HISTORY_ADD failed", MyPageFragment.f17192a);
                            break;
                        }
                    }
                    break;
                case 417:
                    C0778b c0778b2 = (C0778b) message.obj;
                    if (c0778b2.m18954n() && c0778b2.m3107b() != EnumC2464o.ERROR) {
                        C4754bm.m18047a(((ProfileInformationList) c0778b2.m3110e()).coverstory, this.f17404a.f17252au, this.f17404a.f17251at, this.f17404a.f17209N);
                        this.f17404a.m17900d();
                        C4754bm.m18046a(this.f17404a.f17216U);
                        break;
                    }
                    break;
                case 901:
                    this.f17404a.m17887a((C0778b) message.obj);
                    break;
                case 903:
                    C0778b c0778b3 = (C0778b) message.obj;
                    if (this.f17404a.f17221Z != null && this.f17404a.f17221Z.isShowing()) {
                        this.f17404a.f17221Z.dismiss();
                    }
                    if (c0778b3.m18954n() && c0778b3.m3107b() != EnumC2464o.ERROR) {
                        this.f17404a.m17887a(c0778b3);
                        C5179v.m19810a(this.f17404a.getActivity(), R.string.poston_deleted, 0).show();
                        break;
                    } else if (c0778b3.m3111f() == 90016) {
                        this.f17404a.f17220Y = AbstractC4932a.m18733a(this.f17404a.getActivity()).mo18740a(this.f17404a.getResources().getString(R.string.poston_title)).mo18749b(this.f17404a.getResources().getString(R.string.trunk_content_deleted)).mo18755c(this.f17404a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC4742ba(this)).mo18752b();
                        break;
                    } else {
                        C5179v.m19810a(this.f17404a.getActivity(), R.string.ams_msg_cannot_delete_file, 0).show();
                        break;
                    }
                    break;
                case 3002:
                    if (this.f17404a.f17278y != null && this.f17404a.f17278y.isShowing()) {
                        this.f17404a.f17278y.dismiss();
                    }
                    C0778b c0778b4 = (C0778b) message.obj;
                    if (c0778b4.m18954n() && c0778b4.m3107b() != EnumC2464o.ERROR) {
                        C4754bm.m18048a(this.f17404a.f17248aq, this.f17404a.f17249ar, this.f17404a.f17252au, (CoverStoryAdd) c0778b4.m3110e());
                    } else {
                        this.f17404a.f17220Y = AbstractC4932a.m18733a(this.f17404a.getActivity()).mo18734a(R.string.ams_attention_title).mo18746b(R.string.toast_setting_profile_update_failed).mo18751b(true).mo18756d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC4746be(this)).mo18747b(R.string.setting_delete_account_cancel, new DialogInterfaceOnClickListenerC4745bd(this)).mo18752b();
                    }
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[CoverStory] CoverStoryControl.METHOD_ADD_COVERSTORY", MyPageFragment.f17192a);
                        break;
                    }
                    break;
                case 3004:
                    C0778b c0778b5 = (C0778b) message.obj;
                    if (c0778b5.m18954n() && c0778b5.m3110e() != null && c0778b5.m3107b() != EnumC2464o.ERROR) {
                        String str = this.f17404a.getActivity().getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/";
                        if (C4904y.f17871a) {
                            C4904y.m18646e("METHOD_CONTENT_COVERSTORY_LIST created and folder remove : " + str, MyPageFragment.f17192a);
                        }
                        CoverStorySampleList coverStorySampleList = (CoverStorySampleList) c0778b5.m3110e();
                        C4809aa.m18105a("coverstory_first_set", (Boolean) false);
                        C4809aa.m18107a("get_coverstory_sample_timestamp", coverStorySampleList.timestamp);
                        C4894o.m18606a(str);
                        break;
                    } else if (C4904y.f17871a) {
                        C4904y.m18646e("METHOD_CONTENT_COVERSTORY_LIST failed ", MyPageFragment.f17192a);
                        break;
                    }
                    break;
                case 3005:
                    C0778b c0778b6 = (C0778b) message.obj;
                    if (this.f17404a.f17278y != null && this.f17404a.f17278y.isShowing()) {
                        this.f17404a.f17278y.dismiss();
                    }
                    if (c0778b6 == null) {
                        C4904y.m18639b("CoverStoryControl.METHOD_CONTENT_COVERSTORY_DOWNLOAD (httpEntry == null)", getClass().getSimpleName());
                        break;
                    } else if (c0778b6.m18954n() && c0778b6.m3110e() != null && c0778b6.m3107b() != EnumC2464o.ERROR) {
                        CoverStoryDownload coverStoryDownload = (CoverStoryDownload) c0778b6.m3110e();
                        C4809aa.m18108a("coverstory_file_name", "mycoverstory.jpg");
                        C4809aa.m18108a("mypage_coverstory_state", "updated");
                        this.f17404a.f17209N.m19023b(this.f17404a.f17252au, new C2955a(coverStoryDownload.fileurl, C4809aa.m18104a().m18121a("chaton_id", ""), C2955a.f11033b, this.f17404a.getActivity(), this.f17404a.f17253av, "mycoverstory.jpg", C4809aa.m18104a().m18121a("coverstory_contentid", "")));
                        break;
                    }
                    break;
                case 3006:
                    C0778b c0778b7 = (C0778b) message.obj;
                    if (this.f17404a.f17278y != null && this.f17404a.f17278y.isShowing()) {
                        this.f17404a.f17278y.dismiss();
                    }
                    if (c0778b7 == null) {
                        C4904y.m18639b("CoverStoryControl.METHOD_CONTENT_COVERSTORY_DOWNLOAD_RANDOM (httpEntry == null)", getClass().getSimpleName());
                        break;
                    } else if (c0778b7.m18954n() && c0778b7.m3110e() != null && c0778b7.m3107b() != EnumC2464o.ERROR) {
                        CoverStoryDownload coverStoryDownload2 = (CoverStoryDownload) c0778b7.m3110e();
                        C4809aa.m18108a("coverstory_file_name", "mycoverstory.jpg");
                        this.f17404a.f17209N.m19023b(this.f17404a.f17252au, new C2955a(coverStoryDownload2.fileurl, C4809aa.m18104a().m18121a("chaton_id", ""), C2955a.f11033b, this.f17404a.getActivity(), this.f17404a.f17253av, "mycoverstory.jpg", C4809aa.m18104a().m18121a("coverstory_contentid", "")));
                        break;
                    }
                    break;
            }
        }
    }
}
