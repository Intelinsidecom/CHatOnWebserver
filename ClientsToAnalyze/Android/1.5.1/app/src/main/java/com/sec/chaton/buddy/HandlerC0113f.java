package com.sec.chaton.buddy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.database.helper.NotifyingAsyncTaskWorker;
import com.sec.chaton.database.task.BuddyBlockTask;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.buddy.f */
/* loaded from: classes.dex */
class HandlerC0113f extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f657a;

    HandlerC0113f(BuddyFragment buddyFragment) {
        this.f657a = buddyFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        HttpEntry httpEntry = (HttpEntry) message.obj;
        if (message.what == 602) {
            if (httpEntry.m1950a() && httpEntry.m1951b() != HttpResultCode.ERROR) {
                NotifyingAsyncTaskWorker.m2304a(new NotifyingAsyncTaskWorker(), 2, new BuddyBlockTask(this.f657a.f449e, this.f657a.f428S, 2, false));
                return;
            } else {
                if (this.f657a.getActivity() != null) {
                    if (this.f657a.f435Z != null) {
                        this.f657a.f435Z.dismiss();
                    }
                    Toast.makeText(this.f657a.f453i, this.f657a.getResources().getString(C0062R.string.buddy_list_block_toast_failed), 0).show();
                    return;
                }
                return;
            }
        }
        if (message.what != 303 || this.f657a.getActivity() == null) {
            return;
        }
        this.f657a.m511o();
        if (this.f657a.f435Z != null) {
            this.f657a.f435Z.dismiss();
        }
        if (!httpEntry.m1950a()) {
            new AlertDialog.Builder(this.f657a.f453i).setTitle(this.f657a.getResources().getString(C0062R.string.buddy_list_dialog_addbuddy_title)).setMessage(this.f657a.getResources().getString(C0062R.string.buddy_list_dialog_addbuddy_network_failed)).setPositiveButton(this.f657a.getResources().getString(C0062R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC0129v(this)).setNegativeButton(this.f657a.getResources().getString(C0062R.string.dialog_cancel), (DialogInterface.OnClickListener) null).show();
            return;
        }
        if (httpEntry.m1951b() != HttpResultCode.SUCCESS) {
            if (httpEntry.m1951b() == HttpResultCode.NO_CONTENT) {
                new AlertDialog.Builder(this.f657a.f453i).setTitle(String.format(this.f657a.getResources().getString(C0062R.string.buddy_list_dialog_addbuddy_failed_invaliduser), this.f657a.f428S.m668a())).setPositiveButton(this.f657a.getResources().getString(C0062R.string.dialog_ok), (DialogInterface.OnClickListener) null).show();
            } else {
                ChatONLogWriter.m3512f("ADD BUDDY RESULT : " + httpEntry.m1957f(), BuddyFragment.f409a);
                new AlertDialog.Builder(this.f657a.f453i).setTitle(httpEntry.m1957f() == 16003 ? this.f657a.getResources().getString(C0062R.string.buddy_list_dialog_addbuddy_failed_your_self) : httpEntry.m1957f() == 16004 ? this.f657a.getResources().getString(C0062R.string.buddy_list_dialog_addbuddy_failed_already_added) : httpEntry.m1957f() == 16005 ? this.f657a.getResources().getString(C0062R.string.buddy_list_dialog_addbuddy_failed_block_buddy) : this.f657a.getResources().getString(C0062R.string.buddy_list_dialog_addbuddy_network_failed)).setPositiveButton(this.f657a.getResources().getString(C0062R.string.dialog_ok), (DialogInterface.OnClickListener) null).show();
            }
        }
    }
}
