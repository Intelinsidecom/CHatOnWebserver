package com.sec.chaton.poston;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyProfileFragment;
import com.sec.chaton.multimedia.image.PostONImagePagerActivity;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.GetPostONList;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.userprofile.MyPageFragment;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.y */
/* loaded from: classes.dex */
class HandlerC2034y extends Handler {

    /* renamed from: a */
    final /* synthetic */ PostONDetailFragment f7823a;

    HandlerC2034y(PostONDetailFragment postONDetailFragment) {
        this.f7823a = postONDetailFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        String str;
        String str2;
        Intent intent;
        String str3 = null;
        if (this.f7823a.getActivity() != null) {
            switch (message.what) {
                case 903:
                    if (this.f7823a.f7525W != null) {
                        this.f7823a.f7525W.dismiss();
                    }
                    C0267d c0267d = (C0267d) message.obj;
                    if (c0267d.m11704n() && c0267d.m1351b() != EnumC1587o.ERROR) {
                        C3641ai.m13210a(this.f7823a.f7560z, R.string.poston_deleted, 0).show();
                        GetPostONList getPostONList = (GetPostONList) c0267d.m1354e();
                        if (getPostONList.postonlist == null || getPostONList.postonlist.size() <= 0 || getPostONList.postonlist.get(0) == null) {
                            str = null;
                            str2 = null;
                        } else {
                            str2 = getPostONList.postonlist.get(0).hasmore;
                            str3 = getPostONList.postonlist.get(0).endtime;
                            str = getPostONList.postonlist.get(0).isblind;
                        }
                        if (this.f7823a.f7518P == null || !this.f7823a.f7518P.equals(PostONDetailFragment.f7501o)) {
                            if (this.f7823a.f7539ak) {
                                intent = new Intent(this.f7823a.getActivity(), (Class<?>) MyPageFragment.class);
                            } else {
                                intent = new Intent(this.f7823a.getActivity(), (Class<?>) BuddyProfileFragment.class);
                            }
                        } else {
                            intent = new Intent(this.f7823a.getActivity(), (Class<?>) PostONImagePagerActivity.class);
                        }
                        intent.putExtra("HAS_MORE", str2);
                        intent.putExtra("END_TIME", str3);
                        intent.putExtra("IS_BLIND", str);
                        this.f7823a.getActivity().setResult(-1, intent);
                        this.f7823a.getActivity().finish();
                        break;
                    } else if (c0267d.m1355f() != 90016) {
                        C3641ai.m13210a(this.f7823a.f7560z, R.string.ams_msg_cannot_delete_file, 0).show();
                        this.f7823a.getActivity().finish();
                        break;
                    } else {
                        this.f7823a.f7536ah = AbstractC3271a.m11494a(this.f7823a.getActivity()).mo11500a(this.f7823a.getResources().getString(R.string.poston_title)).mo11509b(this.f7823a.getResources().getString(R.string.trunk_content_deleted)).mo11510b(this.f7823a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC2035z(this)).mo11512b();
                        break;
                    }
                    break;
                case 906:
                    if (this.f7823a.f7534af != null && this.f7823a.f7534af.isShowing()) {
                        this.f7823a.f7534af.dismiss();
                        if (this.f7823a.f7535ag != 0) {
                            C3641ai.m13210a(this.f7823a.f7560z, this.f7823a.f7535ag, 0).show();
                        }
                    }
                    if (this.f7823a.f7537ai != null) {
                        this.f7823a.f7537ai.setVisibility(8);
                    }
                    this.f7823a.m7969a((C0267d) message.obj);
                    break;
                case 907:
                    if (this.f7823a.f7525W.isShowing()) {
                        this.f7823a.f7525W.dismiss();
                    }
                    C0267d c0267d2 = (C0267d) message.obj;
                    if (c0267d2.m11704n() && c0267d2.m1351b() != EnumC1587o.ERROR) {
                        C3250y.m11456e("HTTP Success", getClass().getSimpleName());
                        if (this.f7823a.f7531ac.getText().toString() != null) {
                            this.f7823a.f7531ac.setText((CharSequence) null);
                        }
                        C3641ai.m13210a(this.f7823a.getActivity(), R.string.facebook_post_completed, 0).show();
                        this.f7823a.m7969a(c0267d2);
                        break;
                    } else if (c0267d2.m1351b() == EnumC1587o.ERROR) {
                        if (c0267d2.m1355f() == 90012) {
                            this.f7823a.f7536ah = AbstractC3271a.m11494a(this.f7823a.getActivity()).mo11500a(this.f7823a.getResources().getString(R.string.trunk_btn_comment)).mo11509b(this.f7823a.getResources().getString(R.string.trunk_comment_already_exist)).mo11510b(this.f7823a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1963ac(this)).mo11512b();
                            break;
                        } else if (c0267d2.m1355f() == 50005) {
                            this.f7823a.f7536ah = AbstractC3271a.m11494a(this.f7823a.getActivity()).mo11500a(this.f7823a.getResources().getString(R.string.poston_title)).mo11509b(this.f7823a.getResources().getString(R.string.samsung_account_mapping_not_finished)).mo11510b(this.f7823a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1964ad(this)).mo11512b();
                            break;
                        } else if (c0267d2.m1355f() == 90016) {
                            this.f7823a.f7536ah = AbstractC3271a.m11494a(this.f7823a.getActivity()).mo11500a(this.f7823a.getResources().getString(R.string.poston_title)).mo11509b(this.f7823a.getResources().getString(R.string.trunk_content_deleted)).mo11510b(this.f7823a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1965ae(this)).mo11512b();
                            break;
                        } else if (c0267d2.m1355f() == 91004) {
                            C3641ai.m13210a(this.f7823a.f7560z, R.string.mypage_comment_cannot_be_added, 1).show();
                            this.f7823a.getActivity().finish();
                            break;
                        } else {
                            this.f7823a.f7536ah = AbstractC3271a.m11494a(this.f7823a.getActivity()).mo11495a(R.string.poston_title).mo11506b(R.string.toast_setting_profile_update_failed).mo11511b(true).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC1967ag(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1966af(this)).mo11512b();
                            break;
                        }
                    }
                    break;
                case 910:
                    if (this.f7823a.f7525W != null) {
                        this.f7823a.f7525W.dismiss();
                    }
                    C0267d c0267d3 = (C0267d) message.obj;
                    if (c0267d3.m11704n() && c0267d3.m1351b() != EnumC1587o.ERROR) {
                        this.f7823a.f7538aj = true;
                        C3641ai.m13210a(this.f7823a.f7560z, R.string.poston_comment_deleted, 0).show();
                        this.f7823a.m7969a(c0267d3);
                        break;
                    } else if (c0267d3.m1355f() == 90017) {
                        this.f7823a.f7536ah = AbstractC3271a.m11494a(this.f7823a.getActivity()).mo11500a(this.f7823a.getResources().getString(R.string.poston_title)).mo11509b(this.f7823a.getResources().getString(R.string.trunk_content_deleted)).mo11510b(this.f7823a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1961aa(this)).mo11512b();
                        break;
                    } else if (c0267d3.m1355f() != 90016) {
                        C3641ai.m13210a(this.f7823a.f7560z, R.string.ams_msg_cannot_delete_file, 0).show();
                        break;
                    } else {
                        this.f7823a.f7536ah = AbstractC3271a.m11494a(this.f7823a.getActivity()).mo11500a(this.f7823a.getResources().getString(R.string.poston_title)).mo11509b(this.f7823a.getResources().getString(R.string.trunk_content_deleted)).mo11510b(this.f7823a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1962ab(this)).mo11512b();
                        break;
                    }
                    break;
            }
        }
    }
}
