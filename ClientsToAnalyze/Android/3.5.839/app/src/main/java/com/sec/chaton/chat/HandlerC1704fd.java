package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p046a.p047a.C0790n;
import com.sec.chaton.p055d.C2134o;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;
import java.util.concurrent.ExecutionException;

/* compiled from: ChatInfoFragment.java */
/* renamed from: com.sec.chaton.chat.fd */
/* loaded from: classes.dex */
class HandlerC1704fd extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatInfoFragment f6309a;

    HandlerC1704fd(ChatInfoFragment chatInfoFragment) {
        this.f6309a = chatInfoFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws ExecutionException, InterruptedException, Resources.NotFoundException {
        String string;
        String str;
        if (this.f6309a.f5797h != null) {
            switch (message.what) {
                case 303:
                case 321:
                    if (this.f6309a.getActivity() != null) {
                        if (this.f6309a.f5772Q.isShowing()) {
                            this.f6309a.f5772Q.dismiss();
                        }
                        C0778b c0778b = (C0778b) message.obj;
                        if (c0778b.m18954n()) {
                            if (c0778b.m3107b() == EnumC2464o.SUCCESS) {
                                if (TextUtils.isEmpty(this.f6309a.f5778W)) {
                                    C5179v.m19810a(this.f6309a.f5797h, R.string.tellfriends_added, 0).show();
                                } else {
                                    C5179v.m19811a(this.f6309a.f5797h, this.f6309a.getResources().getString(R.string.add_buddy_added, this.f6309a.f5778W), 0).show();
                                    this.f6309a.f5778W = "";
                                    this.f6309a.f5779X = "";
                                }
                                this.f6309a.m8300f();
                                break;
                            } else if (c0778b.m3107b() == EnumC2464o.NO_CONTENT) {
                                if (TextUtils.isEmpty(this.f6309a.f5778W)) {
                                    str = String.format(this.f6309a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f6309a.f5779X);
                                } else {
                                    str = String.format(this.f6309a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f6309a.f5778W);
                                    this.f6309a.f5778W = "";
                                    this.f6309a.f5779X = "";
                                }
                                AbstractC4932a.m18733a(this.f6309a.getActivity()).mo18740a(this.f6309a.getResources().getString(R.string.pop_up_attention)).mo18749b(str).mo18755c(this.f6309a.getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).mo18752b();
                                break;
                            } else {
                                C4904y.m18639b("ADD BUDDY RESULT : " + c0778b.m3111f(), ChatInfoFragment.f5755a);
                                if (c0778b.m3111f() == 16003) {
                                    string = this.f6309a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_your_self);
                                } else if (c0778b.m3111f() == 16004) {
                                    string = this.f6309a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_already_added);
                                } else if (c0778b.m3111f() == 16005) {
                                    string = this.f6309a.getResources().getString(R.string.buddy_list_dialog_addbuddy_failed_block_buddy);
                                } else {
                                    string = this.f6309a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed);
                                }
                                AbstractC4932a.m18733a(this.f6309a.getActivity()).mo18740a(this.f6309a.getResources().getString(R.string.pop_up_attention)).mo18749b(string).mo18755c(this.f6309a.getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).mo18752b();
                                break;
                            }
                        } else {
                            AbstractC4932a.m18733a(this.f6309a.getActivity()).mo18740a(this.f6309a.getResources().getString(R.string.buddy_add_contact)).mo18749b(this.f6309a.getResources().getString(R.string.buddy_list_dialog_addbuddy_network_failed)).mo18755c(this.f6309a.getResources().getString(R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC1707fg(this)).mo18741a(this.f6309a.getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo18752b();
                            break;
                        }
                    }
                    break;
                case 803:
                    this.f6309a.m8300f();
                    this.f6309a.f5756A.startQuery(3, null, C2299s.f8209a, new String[]{"inbox_title"}, "inbox_no=?", new String[]{this.f6309a.f5799j}, null);
                    break;
                case 804:
                    if (((C0790n) message.obj).f2172a) {
                        C2134o.m9575b(this.f6309a.f5790ai, this.f6309a.f5773R, this.f6309a.f5774S);
                        break;
                    } else {
                        if (this.f6309a.f5772Q.isShowing()) {
                            this.f6309a.f5772Q.dismiss();
                        }
                        AbstractC4932a.m18733a(this.f6309a.f5797h).mo18734a(R.string.ams_attention_title).mo18746b(R.string.toast_setting_profile_update_failed).mo18756d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC1706ff(this)).mo18747b(R.string.setting_delete_account_cancel, new DialogInterfaceOnClickListenerC1705fe(this)).mo18751b(true).mo18752b();
                        break;
                    }
                case 805:
                    C0778b c0778b2 = (C0778b) message.obj;
                    if (this.f6309a.f5772Q.isShowing()) {
                        this.f6309a.f5772Q.dismiss();
                    }
                    if (!c0778b2.m18954n() || c0778b2.m3107b() == EnumC2464o.ERROR) {
                        C5179v.m19810a(this.f6309a.f5797h, R.string.toast_network_unable, 0).show();
                        break;
                    } else {
                        this.f6309a.m8308j();
                        break;
                    }
                    break;
            }
        }
    }
}
