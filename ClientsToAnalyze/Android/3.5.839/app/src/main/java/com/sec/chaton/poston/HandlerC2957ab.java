package com.sec.chaton.poston;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p065io.entry.GetPostONDetailInfoList;
import com.sec.chaton.p065io.entry.GetPostONList;
import com.sec.chaton.p065io.entry.inner.PostONCommentList;
import com.sec.chaton.p065io.entry.inner.PostONDetailEntry;
import com.sec.chaton.p065io.entry.inner.PostONMultimediaEntry;
import com.sec.chaton.p065io.entry.inner.PostONMultimediaList;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;
import java.util.Iterator;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.ab */
/* loaded from: classes.dex */
class HandlerC2957ab extends Handler {

    /* renamed from: a */
    final /* synthetic */ PostONDetailFragment f11049a;

    HandlerC2957ab(PostONDetailFragment postONDetailFragment) {
        this.f11049a = postONDetailFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        String str2;
        String str3 = null;
        if (this.f11049a.getActivity() != null) {
            C0778b c0778b = (C0778b) message.obj;
            switch (message.what) {
                case 903:
                    if (this.f11049a.f10910Y != null) {
                        this.f11049a.f10910Y.dismiss();
                    }
                    if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                        C5179v.m19810a(this.f11049a.f10887B, R.string.poston_deleted, 0).show();
                        GetPostONList getPostONList = (GetPostONList) c0778b.m3110e();
                        if (getPostONList.postonlist == null || getPostONList.postonlist.size() <= 0 || getPostONList.postonlist.get(0) == null) {
                            str = null;
                            str2 = null;
                        } else {
                            str2 = getPostONList.postonlist.get(0).hasmore;
                            str3 = getPostONList.postonlist.get(0).endtime;
                            str = getPostONList.postonlist.get(0).isblind;
                        }
                        Intent intent = new Intent();
                        intent.putExtra("HAS_MORE", str2);
                        intent.putExtra("END_TIME", str3);
                        intent.putExtra("IS_BLIND", str);
                        intent.putExtra("IS_DELETED", true);
                        this.f11049a.getActivity().setResult(-1, intent);
                        this.f11049a.getActivity().finish();
                        break;
                    } else if (c0778b.m3111f() == 90016 || c0778b.m3111f() == 93503) {
                        if (this.f11049a.f10927ai == null) {
                            this.f11049a.m12236d();
                        }
                        this.f11049a.f10927ai.show();
                        break;
                    } else {
                        C5179v.m19810a(this.f11049a.f10887B, R.string.ams_msg_cannot_delete_file, 0).show();
                        this.f11049a.getActivity().finish();
                        break;
                    }
                    break;
                case 906:
                    if (this.f11049a.f10928aj != null) {
                        this.f11049a.f10928aj.setVisibility(8);
                    }
                    this.f11049a.m12277a(c0778b, true);
                    this.f11049a.f10935aq = true;
                    break;
                case 907:
                    if (this.f11049a.f10910Y.isShowing()) {
                        this.f11049a.f10910Y.dismiss();
                    }
                    if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                        this.f11049a.f10934ap = false;
                        C4904y.m18646e("HTTP Success", getClass().getSimpleName());
                        if (this.f11049a.f10923ae.getText().toString() != null) {
                            this.f11049a.f10923ae.setText((CharSequence) null);
                        }
                        C5179v.m19810a(this.f11049a.getActivity(), R.string.facebook_post_completed, 0).show();
                        this.f11049a.m12227b(c0778b, true);
                        this.f11049a.f10936ar = true;
                        this.f11049a.f10935aq = true;
                        break;
                    } else {
                        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
                        if (-3 == iM10677a || -2 == iM10677a) {
                            Toast.makeText(this.f11049a.getActivity(), R.string.popup_no_network_connection, 0).show();
                            this.f11049a.f10934ap = true;
                            break;
                        } else if (c0778b.m3107b() == EnumC2464o.ERROR) {
                            if (c0778b.m3111f() == 90012) {
                                if (this.f11049a.f10934ap) {
                                    this.f11049a.f10934ap = false;
                                    if (this.f11049a.f10923ae.getText().toString() != null) {
                                        this.f11049a.f10923ae.setText((CharSequence) null);
                                    }
                                    C4904y.m18646e("WRITE_POSTON_COMMENT_DUPLICATED_PREVIOUS_ONE: mResponseErr true", getClass().getSimpleName());
                                    this.f11049a.f10906U.m9300d(this.f11049a.f10890E, this.f11049a.f10896K);
                                    break;
                                } else {
                                    this.f11049a.f10934ap = false;
                                    this.f11049a.f10926ah = AbstractC4932a.m18733a(this.f11049a.getActivity()).mo18740a(this.f11049a.getResources().getString(R.string.trunk_btn_comment)).mo18749b(this.f11049a.getResources().getString(R.string.trunk_comment_already_exist)).mo18755c(this.f11049a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC2959ad(this)).mo18752b();
                                    break;
                                }
                            } else if (c0778b.m3111f() == 50005) {
                                this.f11049a.f10934ap = false;
                                this.f11049a.f10926ah = AbstractC4932a.m18733a(this.f11049a.getActivity()).mo18740a(this.f11049a.getResources().getString(R.string.poston_title)).mo18749b(this.f11049a.getResources().getString(R.string.samsung_account_mapping_not_finished)).mo18755c(this.f11049a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC2960ae(this)).mo18752b();
                                break;
                            } else if (c0778b.m3111f() == 90016 || c0778b.m3111f() == 93503) {
                                this.f11049a.f10934ap = false;
                                if (this.f11049a.f10927ai == null) {
                                    this.f11049a.m12236d();
                                }
                                this.f11049a.f10927ai.show();
                                break;
                            } else if (c0778b.m3111f() == 91004) {
                                this.f11049a.f10934ap = false;
                                C5179v.m19810a(this.f11049a.f10887B, R.string.mypage_comment_cannot_be_added, 1).show();
                                this.f11049a.getActivity().finish();
                                break;
                            } else {
                                this.f11049a.f10934ap = true;
                                this.f11049a.f10926ah = AbstractC4932a.m18733a(this.f11049a.getActivity()).mo18734a(R.string.poston_title).mo18746b(R.string.toast_setting_profile_update_failed).mo18751b(true).mo18756d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2962ag(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2961af(this)).mo18752b();
                                break;
                            }
                        }
                    }
                    break;
                case 910:
                    if (this.f11049a.f10910Y != null) {
                        this.f11049a.f10910Y.dismiss();
                    }
                    if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                        this.f11049a.f10929ak = true;
                        C5179v.m19810a(this.f11049a.f10887B, R.string.poston_comment_deleted, 0).show();
                        this.f11049a.m12227b(c0778b, false);
                        this.f11049a.f10935aq = true;
                        break;
                    } else if (c0778b.m3111f() == 90017 || c0778b.m3111f() == 93503) {
                        this.f11049a.f10926ah = AbstractC4932a.m18733a(this.f11049a.getActivity()).mo18740a(this.f11049a.getResources().getString(R.string.poston_title)).mo18749b(this.f11049a.getResources().getString(R.string.trunk_content_deleted)).mo18755c(this.f11049a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC2958ac(this)).mo18752b();
                        break;
                    } else if (c0778b.m3111f() == 90016) {
                        if (this.f11049a.f10927ai == null) {
                            this.f11049a.m12236d();
                        }
                        this.f11049a.f10927ai.show();
                        break;
                    } else {
                        C5179v.m19810a(this.f11049a.f10887B, R.string.ams_msg_cannot_delete_file, 0).show();
                        break;
                    }
                    break;
                case 912:
                    if (this.f11049a.f10910Y != null) {
                        this.f11049a.f10910Y.dismiss();
                    }
                    if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                        GetPostONDetailInfoList getPostONDetailInfoList = (GetPostONDetailInfoList) c0778b.m3110e();
                        PostONDetailEntry postONDetailEntry = getPostONDetailInfoList.poston;
                        if ("true".equals(getPostONDetailInfoList.isblind) || postONDetailEntry == null) {
                            this.f11049a.f10926ah = AbstractC4932a.m18733a(this.f11049a.getActivity()).mo18734a(R.string.pop_up_attention).mo18746b(R.string.contents_not_available).mo18751b(false).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2963ah(this)).mo18752b();
                            break;
                        } else {
                            PostONMultimediaList postONMultimediaList = postONDetailEntry.multimedialist;
                            PostONCommentList postONCommentList = postONDetailEntry.commentlist;
                            this.f11049a.f10900O = postONDetailEntry.sender;
                            this.f11049a.f10891F = postONDetailEntry.sendername;
                            this.f11049a.f10892G = postONDetailEntry.regdttm;
                            this.f11049a.f10893H = C3009d.m12358a(Long.parseLong(this.f11049a.f10892G));
                            this.f11049a.f10894I = postONDetailEntry.postonmessage;
                            this.f11049a.f10895J = String.valueOf(Integer.parseInt(postONDetailEntry.commentreadcount) + Integer.parseInt(postONDetailEntry.commentunreadcount));
                            this.f11049a.f10896K = postONDetailEntry.postonid;
                            if (postONMultimediaList != null) {
                                Iterator<PostONMultimediaEntry> it = postONMultimediaList.multimedia.iterator();
                                while (it.hasNext()) {
                                    PostONMultimediaEntry next = it.next();
                                    if (next.metatype.equals(C3009d.f11133d)) {
                                        if (C4904y.f17872b) {
                                            C4904y.m18639b("getMultimediaDownload has geo tag, content.metacontents = " + next.metacontents, PostONDetailFragment.f10885r);
                                        }
                                        this.f11049a.f10901P = next.metacontents;
                                    } else {
                                        this.f11049a.f10897L = next.host + next.metacontents;
                                        this.f11049a.f10898M = next.metatype;
                                    }
                                }
                            }
                            this.f11049a.getActivity().mo51u_();
                            this.f11049a.m12240e();
                            this.f11049a.m12219a(postONCommentList, false);
                            break;
                        }
                    } else {
                        Toast.makeText(this.f11049a.getActivity(), R.string.toast_network_unable, 0).show();
                        this.f11049a.f10934ap = true;
                        this.f11049a.getActivity().finish();
                        break;
                    }
                    break;
            }
        }
    }
}
