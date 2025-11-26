package com.sec.chaton.registration;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.C0062R;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.registration.ActivityRegist;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.registration.as */
/* loaded from: classes.dex */
class HandlerC0421as extends Handler {

    /* renamed from: a */
    final /* synthetic */ ActivityRegist.RegisteFragment f2932a;

    HandlerC0421as(ActivityRegist.RegisteFragment registeFragment) {
        this.f2932a = registeFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        HttpEntry httpEntry = (HttpEntry) message.obj;
        if (message.what != 303 || this.f2932a.getActivity() == null) {
            return;
        }
        this.f2932a.m3081b();
        if (this.f2932a.f2874s != null) {
            this.f2932a.f2874s.dismiss();
        }
        if (!httpEntry.m1950a()) {
            new AlertDialog.Builder(this.f2932a.f2875t).setTitle(this.f2932a.getResources().getString(C0062R.string.buddy_list_dialog_addbuddy_title)).setMessage(this.f2932a.getResources().getString(C0062R.string.buddy_list_dialog_addbuddy_network_failed)).setPositiveButton(this.f2932a.getResources().getString(C0062R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC0430f(this)).setNegativeButton(this.f2932a.getResources().getString(C0062R.string.dialog_cancel), (DialogInterface.OnClickListener) null).show();
            return;
        }
        if (httpEntry.m1951b() == HttpResultCode.SUCCESS) {
            this.f2932a.getActivity().setResult(-1);
            this.f2932a.getActivity().finish();
        } else if (httpEntry.m1951b() == HttpResultCode.NO_CONTENT) {
            new AlertDialog.Builder(this.f2932a.f2875t).setTitle(String.format(this.f2932a.getResources().getString(C0062R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f2932a.f2878w)).setPositiveButton(this.f2932a.getResources().getString(C0062R.string.dialog_ok), (DialogInterface.OnClickListener) null).show();
        } else {
            ChatONLogWriter.m3512f("ADD BUDDY RESULT : " + httpEntry.m1957f(), null);
            new AlertDialog.Builder(this.f2932a.f2875t).setTitle(httpEntry.m1957f() == 16003 ? this.f2932a.f2878w + " " + this.f2932a.getResources().getString(C0062R.string.buddy_list_dialog_addbuddy_failed_your_self) : httpEntry.m1957f() == 16004 ? this.f2932a.getResources().getString(C0062R.string.buddy_list_dialog_addbuddy_failed_already_added) : httpEntry.m1957f() == 16005 ? this.f2932a.getResources().getString(C0062R.string.buddy_list_dialog_addbuddy_failed_block_buddy) : this.f2932a.getResources().getString(C0062R.string.buddy_list_dialog_addbuddy_network_failed)).setPositiveButton(this.f2932a.getResources().getString(C0062R.string.dialog_ok), (DialogInterface.OnClickListener) null).show();
        }
    }
}
