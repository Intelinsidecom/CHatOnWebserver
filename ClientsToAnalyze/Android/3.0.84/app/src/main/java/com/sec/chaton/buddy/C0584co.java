package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButton;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.buddy.p019a.C0512b;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p027e.C1404av;
import com.sec.chaton.p027e.p028a.C1357af;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.co */
/* loaded from: classes.dex */
class C0584co implements SlookAirButton.ItemSelectListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2546a;

    C0584co(BuddyFragment buddyFragment) {
        this.f2546a = buddyFragment;
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButton.ItemSelectListener
    public void onItemSelected(View view, int i, Object obj) {
        if (obj != null) {
            if (((C0513c) obj).m3975b().equals(GlobalApplication.m11493l().getResources().getString(R.string.setting_interaction_me))) {
                if (i == 0) {
                    Intent intentM1226a = TabActivity.m1226a(GlobalApplication.m11493l());
                    intentM1226a.putExtra("callMyPageTab", true);
                    this.f2546a.startActivity(intentM1226a);
                    return;
                }
                return;
            }
            if (((C0513c) obj).m3975b().startsWith("0999")) {
                if (i == 0) {
                    Intent intent = new Intent(GlobalApplication.m11493l(), (Class<?>) SpecialBuddyActivity.class);
                    intent.putExtra("specialuserid", ((C0513c) obj).m3975b());
                    intent.putExtra("speicalusername", ((C0513c) obj).m3976c());
                    intent.putExtra("specialBuddyAdded", C1357af.m5997c(GlobalApplication.m11493l().getContentResolver(), ((C0513c) obj).m3975b()));
                    this.f2546a.startActivity(intent);
                    return;
                }
                if (i == 1) {
                    if (this.f2546a.m3431a(((C0513c) obj).m3975b())) {
                        if (this.f2546a.f1803ao != null) {
                            C0522ag unused = this.f2546a.f1803ao;
                            C0522ag.m4027g(((C0513c) obj).m3975b());
                            C1357af.m5994b(C1404av.m6253a(this.f2546a.getActivity()).getReadableDatabase(), ((C0513c) obj).m3975b());
                        }
                        this.f2546a.f1804ap.m4060d((C0513c) obj);
                        return;
                    }
                    if (this.f2546a.f1803ao != null) {
                        C0522ag unused2 = this.f2546a.f1803ao;
                        C0522ag.m4025f(((C0513c) obj).m3975b());
                        C1357af.m5989a(C1404av.m6253a(this.f2546a.getActivity()).getReadableDatabase(), ((C0513c) obj).m3975b());
                    }
                    this.f2546a.f1804ap.m4058c((C0513c) obj);
                    return;
                }
                if (i == 2) {
                    this.f2546a.m3281a((C0513c) obj, 106);
                    return;
                } else {
                    if (i == 3) {
                        new C1330h(this.f2546a.f1886q).m5741d(((C0513c) obj).m3975b());
                        return;
                    }
                    return;
                }
            }
            if (((C0513c) obj).m3986m()) {
                if (i == 0) {
                    Intent intent2 = new Intent(GlobalApplication.m11493l(), (Class<?>) BuddyProfileActivity.class);
                    intent2.putExtra("PROFILE_BUDDY_NO", ((C0513c) obj).m3975b());
                    intent2.putExtra("PROFILE_BUDDY_NAME", ((C0513c) obj).m3976c());
                    intent2.putExtra("PROFILE_BUDDY_PROFILE_LOAD_DONE", true);
                    intent2.putExtra("PROFILE_BUDDY_PROFILE_IMAGE_LOAD_DONE", true);
                    intent2.setFlags(335544320);
                    this.f2546a.startActivity(intent2);
                    return;
                }
                if (i == 1) {
                    this.f2546a.f1804ap.m4052a((C0513c) obj);
                    return;
                } else {
                    if (i == 2) {
                        this.f2546a.m3281a((C0513c) obj, 106);
                        return;
                    }
                    return;
                }
            }
            if (this.f2546a.m3438c(((C0513c) obj).m3975b())) {
                if (i == 0) {
                    Intent intent3 = new Intent(GlobalApplication.m11493l(), (Class<?>) BuddyProfileActivity.class);
                    intent3.putExtra("PROFILE_BUDDY_NO", ((C0513c) obj).m3975b());
                    intent3.putExtra("PROFILE_BUDDY_NAME", ((C0513c) obj).m3976c());
                    intent3.putExtra("PROFILE_BUDDY_PROFILE_LOAD_DONE", true);
                    intent3.putExtra("PROFILE_BUDDY_PROFILE_IMAGE_LOAD_DONE", true);
                    intent3.setFlags(335544320);
                    this.f2546a.startActivity(intent3);
                    return;
                }
                if (i == 1) {
                    this.f2546a.f1804ap.m4055b((C0513c) obj);
                    return;
                } else if (i == 2) {
                    this.f2546a.m3281a((C0513c) obj, 106);
                    return;
                } else {
                    if (i == 3) {
                        this.f2546a.f1804ap.m4062e((C0513c) obj);
                        return;
                    }
                    return;
                }
            }
            if (((C0513c) obj).m3997x()) {
                if (i == 0) {
                    C0512b c0512b = new C0512b(Integer.parseInt(((C0513c) obj).m3975b()), ((C0513c) obj).m3976c(), ((C0513c) obj).m3999z().keySet().toArray(new String[0]) == null ? 0 : ((String[]) ((C0513c) obj).m3999z().keySet().toArray(new String[0])).length, 18);
                    Intent intent4 = new Intent(GlobalApplication.m11493l(), (Class<?>) BuddyGroupProfileActivity.class);
                    intent4.putExtra("ACTIVITY_PURPOSE", 18);
                    intent4.putExtra("groupInfo", c0512b);
                    intent4.putExtra("GROUP_PROFILE_NAME", ((C0513c) obj).m3976c());
                    intent4.putExtra("ACTIVITY_ARG_GROUP_MEMBER_NO_LIST", (String[]) ((C0513c) obj).m3999z().keySet().toArray(new String[0]));
                    this.f2546a.startActivity(intent4);
                    return;
                }
                if (i == 1) {
                    this.f2546a.m3281a((C0513c) obj, 115);
                    return;
                } else {
                    if (i == 2) {
                        AbstractC3271a.m11494a(this.f2546a.getActivity()).mo11500a(this.f2546a.getResources().getString(R.string.buddy_group_list_dialog_removegroup_title)).mo11509b(this.f2546a.getResources().getString(R.string.buddy_group_list_dialog_removegroup_message)).mo11510b(this.f2546a.getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC0585cp(this, obj)).mo11501a(this.f2546a.getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null).mo11512b();
                        return;
                    }
                    return;
                }
            }
            if (i == 0) {
                Intent intent5 = new Intent(GlobalApplication.m11493l(), (Class<?>) BuddyProfileActivity.class);
                intent5.putExtra("PROFILE_BUDDY_NO", ((C0513c) obj).m3975b());
                intent5.putExtra("PROFILE_BUDDY_NAME", ((C0513c) obj).m3976c());
                intent5.putExtra("PROFILE_BUDDY_PROFILE_LOAD_DONE", true);
                intent5.putExtra("PROFILE_BUDDY_PROFILE_IMAGE_LOAD_DONE", true);
                intent5.setFlags(335544320);
                this.f2546a.startActivity(intent5);
                return;
            }
            if (i == 1) {
                this.f2546a.f1804ap.m4052a((C0513c) obj);
            } else if (i == 2) {
                this.f2546a.m3281a((C0513c) obj, 106);
            } else if (i == 3) {
                this.f2546a.f1804ap.m4062e((C0513c) obj);
            }
        }
    }
}
