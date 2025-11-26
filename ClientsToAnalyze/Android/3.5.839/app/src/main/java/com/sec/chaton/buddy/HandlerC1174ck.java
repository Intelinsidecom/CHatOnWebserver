package com.sec.chaton.buddy;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C0993ac;
import com.sec.chaton.C1063bc;
import com.sec.chaton.EnumC1005ad;
import com.sec.chaton.EnumC1064bd;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p057e.p058a.C2186al;
import com.sec.chaton.p057e.p058a.C2212z;
import com.sec.chaton.p057e.p059b.C2246g;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;
import java.util.ArrayList;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ck */
/* loaded from: classes.dex */
class HandlerC1174ck extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4401a;

    HandlerC1174ck(BuddyFragment buddyFragment) {
        this.f4401a = buddyFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        String string;
        String str;
        C0778b c0778b = (C0778b) message.obj;
        if (this.f4401a.getActivity() != null) {
            if (message.what == 602 || message.what == 606) {
                int i = message.what == 602 ? 2 : 3;
                if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
                    C4904y.m18639b(" Block buddy [Success]", BuddyFragment.f3576a);
                    C2246g c2246g = new C2246g(this.f4401a.f3770w, this.f4401a.f3671az, i, false);
                    if (this.f4401a.m6605h() > 0) {
                        if (this.f4401a.f3713br != null) {
                            this.f4401a.f3713br.setVisibility(8);
                        }
                    } else {
                        this.f4401a.m6608k();
                    }
                    C2212z.m10068a(new C2212z(), i, c2246g);
                    C0991aa.m6037a().m18962d(new C0993ac(EnumC1005ad.BLOCKED, this.f4401a.f3671az.m7046a()));
                    if (this.f4401a.m6604g().length <= 1) {
                        if (this.f4401a.f3671az == null) {
                            this.f4401a.f3671az = this.f4401a.m6341a(this.f4401a.m6604g()[0], (ArrayList<ArrayList<C1106c>>) this.f4401a.f3666au);
                        }
                        this.f4401a.f3622aC.m19614a(this.f4401a.f3671az.m7046a());
                        this.f4401a.m6587a(this.f4401a.f3671az.m7046a(), this.f4401a.f3671az.m7051b());
                        this.f4401a.m6588a(this.f4401a.f3671az.m7046a(), false, this.f4401a.f3671az.m7051b());
                        C5179v.m19811a(this.f4401a.getActivity(), String.format(this.f4401a.getResources().getString(R.string.toast_was_blocked), this.f4401a.f3671az.m7051b()), 0).show();
                    } else {
                        for (String str2 : this.f4401a.m6604g()) {
                            C1106c c1106cM6341a = this.f4401a.m6341a(str2, (ArrayList<ArrayList<C1106c>>) this.f4401a.f3666au);
                            this.f4401a.f3622aC.m19614a(c1106cM6341a.m7046a());
                            this.f4401a.m6587a(c1106cM6341a.m7046a(), c1106cM6341a.m7051b());
                            this.f4401a.m6588a(c1106cM6341a.m7046a(), false, c1106cM6341a.m7051b());
                        }
                        C5179v.m19810a(this.f4401a.getActivity(), R.string.blocked_contacts_toast_popup, 0).show();
                    }
                } else {
                    C4904y.m18639b(" Block buddy [Fail]", BuddyFragment.f3576a);
                    if (message.what == 602) {
                        C5179v.m19810a(this.f4401a.getActivity(), R.string.selected_contacts_failed_to_block_contact, 0).show();
                    } else {
                        C5179v.m19810a(this.f4401a.getActivity(), R.string.selected_contacts_failed_to_block_contacts, 0).show();
                    }
                }
                this.f4401a.m6327W();
                ((ActionBarFragmentActivity) this.f4401a.getActivity()).mo51u_();
                return;
            }
            if (message.what == 303) {
                this.f4401a.m6304K();
                this.f4401a.m6327W();
                if (c0778b.m18954n()) {
                    if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                        if (TextUtils.isEmpty(this.f4401a.f3717bv)) {
                            this.f4401a.m6370a((CharSequence) this.f4401a.getResources().getString(R.string.tellfriends_added));
                        } else {
                            this.f4401a.m6370a((CharSequence) this.f4401a.getResources().getString(R.string.add_buddy_added, this.f4401a.f3717bv));
                            this.f4401a.f3717bv = "";
                        }
                        C0991aa.m6037a().m18962d(new C0993ac(EnumC1005ad.ADDED, this.f4401a.f3671az.m7046a()));
                        return;
                    }
                    if (c0778b.m3107b() == EnumC2464o.NO_CONTENT) {
                        if (TextUtils.isEmpty(this.f4401a.f3717bv)) {
                            str = String.format(this.f4401a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f4401a.f3671az.m7046a());
                        } else {
                            str = String.format(this.f4401a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f4401a.f3717bv);
                            this.f4401a.f3717bv = "";
                        }
                        AbstractC4932a.m18733a(this.f4401a.getActivity()).mo18740a(this.f4401a.getResources().getString(R.string.pop_up_attention)).mo18749b(str).mo18755c(this.f4401a.getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).mo18752b();
                        return;
                    }
                    C4904y.m18639b("ADD BUDDY RESULT : " + c0778b.m3111f(), BuddyFragment.f3576a);
                    if (c0778b.m3111f() == 16003) {
                        string = this.f4401a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                    } else if (c0778b.m3111f() == 16004) {
                        string = this.f4401a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                    } else if (c0778b.m3111f() == 16005) {
                        string = this.f4401a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                    } else {
                        string = this.f4401a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                    }
                    AbstractC4932a.m18733a(this.f4401a.getActivity()).mo18740a(this.f4401a.getResources().getString(R.string.pop_up_attention)).mo18749b(string).mo18755c(this.f4401a.getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).mo18752b();
                    return;
                }
                AbstractC4932a.m18733a(this.f4401a.getActivity()).mo18740a(this.f4401a.getResources().getString(R.string.buddy_add_contact)).mo18749b(this.f4401a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed)).mo18755c(this.f4401a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC1175cl(this)).mo18741a(this.f4401a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo18752b();
                return;
            }
            if (message.what == 904) {
                C0778b c0778b2 = (C0778b) message.obj;
                if (c0778b2.m18954n() && c0778b2.m3107b() != EnumC2464o.ERROR) {
                    C5179v.m19811a(this.f4401a.getActivity(), this.f4401a.getResources().getString(R.string.toast_save_media), 0).show();
                } else {
                    C5179v.m19811a(this.f4401a.getActivity(), this.f4401a.getResources().getString(R.string.dev_network_error), 0).show();
                }
                this.f4401a.m6327W();
                return;
            }
            if (message.what == 318) {
                String strM7051b = this.f4401a.f3671az != null ? this.f4401a.f3671az.m7051b() : null;
                if (!c0778b.m18954n() || c0778b.m3107b() == EnumC2464o.ERROR) {
                    C5179v.m19811a(this.f4401a.getActivity(), this.f4401a.getResources().getString(R.string.livepartner_failed_to_unfollow, strM7051b), 0).show();
                } else {
                    C5179v.m19811a(this.f4401a.getActivity(), this.f4401a.getResources().getString(R.string.livepartner_no_longer_following, strM7051b), 0).show();
                    ContentResolver contentResolver = CommonApplication.m18732r().getContentResolver();
                    if (this.f4401a.f3671az != null) {
                        C2186al.m9777d(contentResolver, this.f4401a.f3671az.m7046a());
                    }
                    C0991aa.m6037a().m18962d(C1063bc.m6173a(EnumC1064bd.UNFOLLOW, this.f4401a.f3671az.m7046a()));
                }
                this.f4401a.m6327W();
                return;
            }
            if (message.what == 702 || message.what == 703) {
                C0778b c0778b3 = (C0778b) message.obj;
                if (c0778b3.m18954n() && c0778b3.m3107b() != EnumC2464o.ERROR) {
                    C4904y.m18639b(" Hide buddy [Success]", BuddyFragment.f3576a);
                    if (this.f4401a.m6604g().length <= 1) {
                        if (this.f4401a.f3671az == null) {
                            this.f4401a.f3671az = this.f4401a.m6341a(this.f4401a.m6604g()[0], (ArrayList<ArrayList<C1106c>>) this.f4401a.f3666au);
                        }
                        this.f4401a.f3622aC.m19614a(this.f4401a.f3671az.m7046a());
                        this.f4401a.m6587a(this.f4401a.f3671az.m7046a(), this.f4401a.f3671az.m7051b());
                        this.f4401a.m6588a(this.f4401a.f3671az.m7046a(), false, this.f4401a.f3671az.m7051b());
                        C5179v.m19811a(this.f4401a.getActivity(), String.format(this.f4401a.getResources().getString(R.string.buddy_list_hide_success), this.f4401a.f3671az.m7051b()), 0).show();
                    } else {
                        for (String str3 : this.f4401a.m6604g()) {
                            C1106c c1106cM6341a2 = this.f4401a.m6341a(str3, (ArrayList<ArrayList<C1106c>>) this.f4401a.f3666au);
                            this.f4401a.f3622aC.m19614a(c1106cM6341a2.m7046a());
                            this.f4401a.m6587a(c1106cM6341a2.m7046a(), c1106cM6341a2.m7051b());
                            this.f4401a.m6588a(c1106cM6341a2.m7046a(), false, c1106cM6341a2.m7051b());
                        }
                        C5179v.m19810a(this.f4401a.getActivity(), R.string.hidden_contacts_toast_popup, 0).show();
                    }
                    if (this.f4401a.m6605h() > 0) {
                        if (this.f4401a.f3713br != null) {
                            this.f4401a.f3713br.setVisibility(8);
                        }
                    } else {
                        this.f4401a.m6608k();
                    }
                    C0991aa.m6037a().m18962d(new C0993ac(EnumC1005ad.HIDED, this.f4401a.f3671az.m7046a()));
                } else {
                    C4904y.m18639b(" Hide buddy [Fail]", BuddyFragment.f3576a);
                    if (message.what == 702) {
                        C5179v.m19810a(this.f4401a.getActivity(), R.string.selected_contacts_failed_to_hide_contact, 0).show();
                    } else {
                        C5179v.m19810a(this.f4401a.getActivity(), R.string.selected_contacts_failed_to_hide_contacts, 0).show();
                    }
                }
                this.f4401a.m6327W();
                return;
            }
            if (message.what == 706) {
                C0778b c0778b4 = (C0778b) message.obj;
                if (c0778b4.m18954n() && c0778b4.m3107b() != EnumC2464o.ERROR) {
                    C4904y.m18639b(" DB Hide List Upload [Success]", BuddyFragment.f3576a);
                    C4809aa.m18104a().m18125b("Is DB Hide List Uploaded", (Boolean) true);
                    return;
                } else {
                    C4904y.m18639b(" DB Hide List Upload [Fail]", BuddyFragment.f3576a);
                    return;
                }
            }
            if (message.what == 332) {
                C0778b c0778b5 = (C0778b) message.obj;
                if (c0778b5.m18954n() && c0778b5.m3107b() != EnumC2464o.ERROR) {
                    C4904y.m18639b(" Delete buddy [Success]", BuddyFragment.f3576a);
                    if (this.f4401a.m6604g().length <= 1) {
                        if (this.f4401a.f3671az == null) {
                            this.f4401a.f3671az = this.f4401a.m6341a(this.f4401a.m6604g()[0], (ArrayList<ArrayList<C1106c>>) this.f4401a.f3666au);
                        }
                        this.f4401a.f3622aC.m19614a(this.f4401a.f3671az.m7046a());
                        this.f4401a.m6587a(this.f4401a.f3671az.m7046a(), this.f4401a.f3671az.m7051b());
                        this.f4401a.m6588a(this.f4401a.f3671az.m7046a(), false, this.f4401a.f3671az.m7051b());
                        C5179v.m19811a(this.f4401a.getActivity(), String.format(this.f4401a.getResources().getString(R.string.toast_was_removed), this.f4401a.f3671az.m7051b()), 0).show();
                    } else {
                        for (String str4 : this.f4401a.m6604g()) {
                            C1106c c1106cM6341a3 = this.f4401a.m6341a(str4, (ArrayList<ArrayList<C1106c>>) this.f4401a.f3666au);
                            this.f4401a.f3622aC.m19614a(c1106cM6341a3.m7046a());
                            this.f4401a.m6587a(c1106cM6341a3.m7046a(), c1106cM6341a3.m7051b());
                            this.f4401a.m6588a(c1106cM6341a3.m7046a(), false, c1106cM6341a3.m7051b());
                        }
                        C5179v.m19810a(this.f4401a.getActivity(), R.string.removed_contacts_toast_popup, 0).show();
                    }
                    if (this.f4401a.m6605h() > 0) {
                        if (this.f4401a.f3713br != null) {
                            this.f4401a.f3713br.setVisibility(8);
                        }
                    } else {
                        this.f4401a.m6608k();
                    }
                    C0991aa.m6037a().m18962d(new C0993ac(EnumC1005ad.DELETED, this.f4401a.f3671az.m7046a()));
                } else {
                    C4904y.m18639b(" Delete buddy [Fail]", BuddyFragment.f3576a);
                    if (message.what == 702) {
                        C5179v.m19810a(this.f4401a.getActivity(), R.string.selected_contacts_failed_to_romve_contact, 0).show();
                    } else {
                        C5179v.m19810a(this.f4401a.getActivity(), R.string.selected_contacts_failed_to_romve_contacts, 0).show();
                    }
                }
                this.f4401a.m6327W();
            }
        }
    }
}
