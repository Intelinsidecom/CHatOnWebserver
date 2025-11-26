package com.sec.chaton.userprofile;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p016a.p017a.C0274k;
import com.sec.chaton.p035io.entry.inner.CoverStory;
import com.sec.chaton.p035io.entry.inner.CoverStoryAdd;
import com.sec.chaton.p035io.entry.inner.CoverStoryDownload;
import com.sec.chaton.p035io.entry.inner.CoverStorySampleList;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.poston.C1960a;
import com.sec.chaton.trunk.p061c.C3020a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3243r;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;
import java.io.File;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.ax */
/* loaded from: classes.dex */
class HandlerC3098ax extends Handler {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f11311a;

    HandlerC3098ax(MyPageFragment myPageFragment) {
        this.f11311a = myPageFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        if (this.f11311a.getActivity() != null) {
            switch (message.what) {
                case 0:
                    if (this.f11311a.f11179k != null && this.f11311a.f11179k.isShowing()) {
                        this.f11311a.f11179k.dismiss();
                        break;
                    }
                    break;
                case 402:
                    if (((C0274k) message.obj).f858a) {
                        this.f11311a.f11181m.m5935c();
                        break;
                    } else {
                        if (this.f11311a.f11179k != null && this.f11311a.f11179k.isShowing()) {
                            this.f11311a.f11179k.dismiss();
                        }
                        this.f11311a.f11185q = AbstractC3271a.m11494a(this.f11311a.getActivity()).mo11495a(R.string.ams_attention_title).mo11506b(R.string.toast_setting_profile_update_failed).mo11511b(true).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3102ba(this)).mo11507b(R.string.setting_delete_account_cancel, new DialogInterfaceOnClickListenerC3100az(this)).mo11512b();
                        break;
                    }
                    break;
                case HttpResponseCode.NOT_FOUND /* 404 */:
                    C0267d c0267d = (C0267d) message.obj;
                    if (!c0267d.m11704n() || c0267d.m1351b() == EnumC1587o.ERROR) {
                        if (this.f11311a.f11179k != null && this.f11311a.f11179k.isShowing()) {
                            this.f11311a.f11179k.dismiss();
                        }
                        Toast.makeText(this.f11311a.getActivity(), R.string.toast_network_unable, 0).show();
                        if (C3250y.f11733a) {
                            C3250y.m11456e("MyPageFragment: METHOD_PROFILE_IMAGE_HISTORY_ADD failed", MyPageFragment.f11095a);
                            break;
                        }
                    } else {
                        if (this.f11311a.f11179k != null && this.f11311a.f11179k.isShowing()) {
                            this.f11311a.f11179k.dismiss();
                        }
                        C3159aa.m10966a("profile_image_status", "updated");
                        this.f11311a.m10707a(c0267d);
                        break;
                    }
                    break;
                case 407:
                    C0267d c0267d2 = (C0267d) message.obj;
                    if (c0267d2.m11704n() && c0267d2.m1351b() != EnumC1587o.ERROR) {
                        this.f11311a.m10707a(c0267d2);
                    }
                    if (this.f11311a.f11148ae.getVisibility() == 0) {
                        this.f11311a.f11147ad.setNextFocusRightId(this.f11311a.f11148ae.getId());
                        break;
                    } else {
                        this.f11311a.f11147ad.setNextFocusRightId(this.f11311a.f11100C.getId());
                        break;
                    }
                case 411:
                    C0267d c0267d3 = (C0267d) message.obj;
                    if (c0267d3 != null) {
                        if (c0267d3.m11704n() && c0267d3.m1351b() == EnumC1587o.SUCCESS) {
                            this.f11311a.m10742j();
                            this.f11311a.m10754p();
                            break;
                        } else {
                            Toast.makeText(this.f11311a.getActivity(), R.string.popup_no_network_connection, 0).show();
                            break;
                        }
                    }
                    break;
                case 901:
                    if (this.f11311a.f11180l != null && this.f11311a.f11180l.isShowing()) {
                        this.f11311a.f11180l.dismiss();
                    }
                    if (this.f11311a.f11186r != null) {
                        this.f11311a.f11186r.setVisibility(8);
                    }
                    this.f11311a.m10720b((C0267d) message.obj);
                    break;
                case 903:
                    if (this.f11311a.getActivity() != null) {
                        if (this.f11311a.f11180l != null && this.f11311a.f11180l.isShowing()) {
                            this.f11311a.f11180l.dismiss();
                        }
                        C0267d c0267d4 = (C0267d) message.obj;
                        if (c0267d4.m11704n() && c0267d4.m1351b() != EnumC1587o.ERROR) {
                            this.f11311a.m10720b(c0267d4);
                            C3641ai.m13210a(this.f11311a.getActivity(), R.string.poston_deleted, 0).show();
                            break;
                        } else if (c0267d4.m1355f() == 90016) {
                            this.f11311a.f11185q = AbstractC3271a.m11494a(this.f11311a.getActivity()).mo11500a(this.f11311a.getResources().getString(R.string.poston_title)).mo11509b(this.f11311a.getResources().getString(R.string.trunk_content_deleted)).mo11510b(this.f11311a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC3099ay(this)).mo11512b();
                            break;
                        } else {
                            Toast.makeText(this.f11311a.getActivity(), R.string.ams_msg_cannot_delete_file, 0).show();
                            break;
                        }
                    }
                    break;
                case 3001:
                    C0267d c0267d5 = (C0267d) message.obj;
                    String strM10979a = C3159aa.m10962a().m10979a("coverstory_metaid", "");
                    if (c0267d5.m11704n() && c0267d5.m1351b() != EnumC1587o.ERROR) {
                        CoverStory coverStory = (CoverStory) c0267d5.m1354e();
                        if (coverStory.metaid != null) {
                            if (strM10979a != null) {
                                C3250y.m11450b("CoverStoryControl.METHOD_GET_COVERSTORY mCoverStoryDir : " + strM10979a, getClass().getSimpleName());
                                C3250y.m11450b("CoverStoryControl.METHOD_GET_COVERSTORY coverStoryInfo.metaid : " + coverStory.metaid, getClass().getSimpleName());
                                C3159aa.m10966a("mypage_coverstory_state", "updated");
                                C3159aa.m10966a("coverstory_metaid", coverStory.metaid);
                                if (coverStory.contentid != null) {
                                    if (!this.f11311a.m10776b(coverStory.contentid)) {
                                        this.f11311a.m10714a(coverStory.contentid, Integer.toString(this.f11311a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width)), Integer.toString(this.f11311a.getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height)));
                                    }
                                    C3159aa.m10966a("coverstory_contentid", coverStory.contentid);
                                } else {
                                    C3159aa.m10966a("coverstory_contentid", (String) null);
                                    this.f11311a.f11153aj.m11730a(this.f11311a.f11183o, new C1960a(coverStory.host + coverStory.metacontents, this.f11311a.f11102E, MyPageFragment.f11094O, this.f11311a.getActivity(), this.f11311a.f11161ar, "mycoverstory.jpg", coverStory.metaid));
                                }
                                C3159aa.m10966a("mypage_coverstory_state", "updated");
                                C3159aa.m10966a("coverstory_metaid", coverStory.metaid);
                                break;
                            }
                        } else if (TextUtils.isEmpty(strM10979a)) {
                            C3250y.m11450b("previousMetaid is null. when setting coverstory first, pass ~!", getClass().getSimpleName());
                            break;
                        } else {
                            C3250y.m11450b("Set RandomCoverStory as randomId coverStoryInfo.metaid is null", getClass().getSimpleName());
                            this.f11311a.m10777d();
                            break;
                        }
                    } else if (C3250y.f11734b) {
                        C3250y.m11450b("CoverStoryControl.METHOD_GET_COVERSTORY http fail", MyPageFragment.f11095a);
                        break;
                    }
                    break;
                case 3002:
                    if (this.f11311a.f11179k != null && this.f11311a.f11179k.isShowing()) {
                        this.f11311a.f11179k.dismiss();
                    }
                    C0267d c0267d6 = (C0267d) message.obj;
                    if (c0267d6.m11704n() && c0267d6.m1351b() != EnumC1587o.ERROR) {
                        CoverStoryAdd coverStoryAdd = (CoverStoryAdd) c0267d6.m1354e();
                        if (coverStoryAdd.metaid != null) {
                            C3159aa.m10966a("mypage_coverstory_state", "updated");
                            C3159aa.m10966a("coverstory_metaid", coverStoryAdd.metaid);
                            if (coverStoryAdd.contentid != null) {
                                if (C3250y.f11733a) {
                                    C3250y.m11456e("CoverStoryControl.METHOD_ADD_COVERSTORY entry.contentid : " + coverStoryAdd.contentid, MyPageFragment.f11095a);
                                }
                                C3159aa.m10966a("coverstory_contentid", coverStoryAdd.contentid);
                            } else {
                                C3159aa.m10966a("coverstory_contentid", (String) null);
                            }
                        }
                        if (this.f11311a.f11129aG != null && this.f11311a.f11130aH != null) {
                            try {
                                C3020a.m10525a(this.f11311a.f11129aG, this.f11311a.f11123aA);
                                String str = this.f11311a.f11129aG.getName().split("\\.")[r1.length - 1];
                                C3250y.m11456e("ChatOnGraphics.MY_COVERSTORY_NAME + ext: mycoverstory." + str, MyPageFragment.f11095a);
                                File file = new File(this.f11311a.f11161ar + "mycoverstory." + str);
                                if (file.exists()) {
                                    file.delete();
                                }
                                C3020a.m10525a(this.f11311a.f11129aG, file);
                                String[] strArrSplit = coverStoryAdd.metacontents.split("\\.");
                                if (strArrSplit.length > 0) {
                                    String str2 = "mycoverstory." + strArrSplit[strArrSplit.length - 1];
                                    C3250y.m11456e("entry.metacontents: " + coverStoryAdd.metacontents + " // mFileName: " + str2, MyPageFragment.f11095a);
                                    C3159aa.m10966a("coverstory_file_name", str2);
                                }
                                this.f11311a.m10706a(this.f11311a.f11183o);
                            } catch (Exception e) {
                                if (C3250y.f11737e) {
                                    C3250y.m11443a(e, getClass().getSimpleName());
                                }
                                this.f11311a.m10702a(0);
                            }
                        }
                    } else {
                        this.f11311a.f11185q = AbstractC3271a.m11494a(this.f11311a.getActivity()).mo11495a(R.string.ams_attention_title).mo11506b(R.string.toast_setting_profile_update_failed).mo11511b(true).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3104bc(this)).mo11507b(R.string.setting_delete_account_cancel, new DialogInterfaceOnClickListenerC3103bb(this)).mo11512b();
                    }
                    if (C3250y.f11734b) {
                        C3250y.m11450b("[CoverStory] CoverStoryControl.METHOD_ADD_COVERSTORY", MyPageFragment.f11095a);
                        break;
                    }
                    break;
                case 3004:
                    C0267d c0267d7 = (C0267d) message.obj;
                    if (c0267d7.m11704n() && c0267d7.m1354e() != null && c0267d7.m1351b() != EnumC1587o.ERROR) {
                        String str3 = this.f11311a.getActivity().getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/";
                        if (C3250y.f11733a) {
                            C3250y.m11456e("METHOD_CONTENT_COVERSTORY_LIST created and folder remove : " + str3, MyPageFragment.f11095a);
                        }
                        CoverStorySampleList coverStorySampleList = (CoverStorySampleList) c0267d7.m1354e();
                        C3159aa.m10963a("coverstory_first_set", (Boolean) false);
                        C3159aa.m10965a("get_coverstory_sample_timestamp", coverStorySampleList.timestamp);
                        C3243r.m11419a(str3);
                        break;
                    } else if (C3250y.f11733a) {
                        C3250y.m11456e("METHOD_CONTENT_COVERSTORY_LIST failed ", MyPageFragment.f11095a);
                        break;
                    }
                    break;
                case 3005:
                    C0267d c0267d8 = (C0267d) message.obj;
                    if (this.f11311a.f11179k != null && this.f11311a.f11179k.isShowing()) {
                        this.f11311a.f11179k.dismiss();
                    }
                    if (c0267d8 == null) {
                        C3250y.m11450b("CoverStoryControl.METHOD_CONTENT_COVERSTORY_DOWNLOAD (httpEntry == null)", getClass().getSimpleName());
                        break;
                    } else if (c0267d8.m11704n() && c0267d8.m1354e() != null && c0267d8.m1351b() != EnumC1587o.ERROR) {
                        CoverStoryDownload coverStoryDownload = (CoverStoryDownload) c0267d8.m1354e();
                        C3159aa.m10966a("coverstory_file_name", "mycoverstory.jpg");
                        C3159aa.m10966a("mypage_coverstory_state", "updated");
                        this.f11311a.f11153aj.m11730a(this.f11311a.f11183o, new C1960a(coverStoryDownload.fileurl, this.f11311a.f11102E, C1960a.f7636b, this.f11311a.getActivity(), this.f11311a.f11161ar, "mycoverstory.jpg", C3159aa.m10962a().m10979a("coverstory_contentid", "")));
                        break;
                    }
                    break;
                case 3006:
                    C0267d c0267d9 = (C0267d) message.obj;
                    if (this.f11311a.f11179k != null && this.f11311a.f11179k.isShowing()) {
                        this.f11311a.f11179k.dismiss();
                    }
                    if (c0267d9 == null) {
                        C3250y.m11450b("CoverStoryControl.METHOD_CONTENT_COVERSTORY_DOWNLOAD_RANDOM (httpEntry == null)", getClass().getSimpleName());
                        break;
                    } else if (c0267d9.m11704n() && c0267d9.m1354e() != null && c0267d9.m1351b() != EnumC1587o.ERROR) {
                        CoverStoryDownload coverStoryDownload2 = (CoverStoryDownload) c0267d9.m1354e();
                        C3159aa.m10966a("coverstory_file_name", "mycoverstory.jpg");
                        this.f11311a.f11153aj.m11730a(this.f11311a.f11183o, new C1960a(coverStoryDownload2.fileurl, this.f11311a.f11102E, C1960a.f7636b, this.f11311a.getActivity(), this.f11311a.f11161ar, "mycoverstory.jpg", C3159aa.m10962a().m10979a("coverstory_contentid", "")));
                        break;
                    }
                    break;
            }
        }
    }
}
