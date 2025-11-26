package com.sec.chaton.buddy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.database.helper.MemoDatabaseHelper;
import com.sec.chaton.database.helper.MemoSessionsDatabaseHelper;
import com.sec.chaton.database.helper.NotifyingAsyncTaskWorker;
import com.sec.chaton.database.task.BuddyBlockTask;
import com.sec.chaton.memo.MemoAdapter;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.buddy.y */
/* loaded from: classes.dex */
class HandlerC0132y extends Handler {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileActivity f718a;

    HandlerC0132y(BuddyProfileActivity buddyProfileActivity) {
        this.f718a = buddyProfileActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        HttpEntry httpEntry = (HttpEntry) message.obj;
        if (message.what == 602) {
            if (httpEntry.m1950a() && httpEntry.m1951b() != HttpResultCode.ERROR) {
                NotifyingAsyncTaskWorker.m2304a(new NotifyingAsyncTaskWorker(), 2, new BuddyBlockTask(this.f718a.f580e, this.f718a.f585j, 2, false));
                return;
            }
            if (this.f718a.f561H != null) {
                this.f718a.f561H.dismiss();
            }
            Toast.makeText(this.f718a.f584i, this.f718a.getResources().getString(C0062R.string.buddy_profile_block_toast_failed), 0).show();
            return;
        }
        if (message.what == 303) {
            if (this.f718a.f561H != null) {
                this.f718a.f561H.dismiss();
            }
            if (httpEntry.m1950a()) {
                ChatONLogWriter.m3506b("************** RESULT CODE : " + httpEntry.m1951b(), "ADD BUDDY");
                if (httpEntry.m1951b() == HttpResultCode.SUCCESS) {
                    Intent intent = new Intent(this.f718a.f584i, (Class<?>) BuddyProfileActivity.class);
                    intent.putExtra("PROFILE_BUDDY_NO", this.f718a.f586k);
                    intent.putExtra("PROFILE_BUDDY_NAME", this.f718a.f587l);
                    intent.setFlags(268435456);
                    this.f718a.f584i.startActivity(intent);
                    this.f718a.finish();
                } else {
                    ChatONLogWriter.m3506b("*********** ADD BUDDY RESULT : " + httpEntry.m1957f(), null);
                    ChatONLogWriter.m3506b("*********** ADD BUDDY RESULT : " + httpEntry.m1957f(), null);
                    new AlertDialog.Builder(this.f718a.f584i).setTitle(httpEntry.m1957f() == 16003 ? this.f718a.getResources().getString(C0062R.string.buddy_profile_dialog_addbuddy_failed_your_self) : httpEntry.m1957f() == 16004 ? this.f718a.getResources().getString(C0062R.string.buddy_list_dialog_addbuddy_failed_already_added) : httpEntry.m1957f() == 16005 ? this.f718a.getResources().getString(C0062R.string.buddy_list_dialog_addbuddy_failed_block_buddy) : String.format(this.f718a.getResources().getString(C0062R.string.buddy_profile_dialog_addbuddy_failed_invaliduser), this.f718a.f587l)).setPositiveButton(this.f718a.getResources().getString(C0062R.string.dialog_ok), new DialogInterfaceOnClickListenerC0081ae(this)).show();
                }
            } else {
                new AlertDialog.Builder(this.f718a.f584i).setTitle(this.f718a.getResources().getString(C0062R.string.buddy_list_dialog_addbuddy_title)).setMessage(this.f718a.getResources().getString(C0062R.string.buddy_list_dialog_addbuddy_network_failed)).setPositiveButton(this.f718a.getResources().getString(C0062R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterfaceOnClickListenerC0082af(this)).setNegativeButton(this.f718a.getResources().getString(C0062R.string.dialog_cancel), (DialogInterface.OnClickListener) null).show();
            }
            this.f718a.f558E.setEnabled(true);
            this.f718a.f556C.setEnabled(true);
            return;
        }
        if (message.what == 603) {
            if (httpEntry.m1950a() && httpEntry.m1951b() == HttpResultCode.SUCCESS) {
                ChatONLogWriter.m3506b("****** UNBLOCK : " + this.f718a.f586k, BuddyProfileActivity.f553a);
                Toast.makeText(this.f718a.f584i, this.f718a.f584i.getResources().getString(C0062R.string.setting_buddy_unblocked, this.f718a.f587l), 0).show();
                this.f718a.finish();
                return;
            }
            return;
        }
        if (message.what != 901 && message.what != 902) {
            if (message.what == 904) {
                if (httpEntry.m1950a() && httpEntry.m1951b() != HttpResultCode.ERROR) {
                    this.f718a.f575W = true;
                    this.f718a.f565L.m2006a(this.f718a.f586k);
                    return;
                } else {
                    if (this.f718a.f561H != null) {
                        this.f718a.f561H.dismiss();
                    }
                    Toast.makeText(this.f718a.f584i, this.f718a.getResources().getString(C0062R.string.dev_network_error), 0).show();
                    return;
                }
            }
            if (message.what == 903) {
                if (httpEntry.m1950a() && httpEntry.m1951b() != HttpResultCode.ERROR) {
                    this.f718a.f575W = true;
                    this.f718a.f565L.m2006a(this.f718a.f586k);
                    return;
                } else {
                    if (this.f718a.f561H != null) {
                        this.f718a.f561H.dismiss();
                    }
                    Toast.makeText(this.f718a.f584i, this.f718a.getResources().getString(C0062R.string.dev_network_error), 0).show();
                    return;
                }
            }
            return;
        }
        if (this.f718a.f561H != null) {
            this.f718a.f561H.dismiss();
        }
        if (this.f718a.f570R != null) {
            this.f718a.f570R.setVisibility(8);
        }
        Cursor cursorM2270a = MemoSessionsDatabaseHelper.m2270a(this.f718a.getContentResolver(), this.f718a.f586k);
        while (cursorM2270a.moveToNext()) {
            this.f718a.f572T = cursorM2270a.getString(cursorM2270a.getColumnIndex("buddy_name"));
            this.f718a.f573U = cursorM2270a.getString(cursorM2270a.getColumnIndex("endtime"));
            this.f718a.f574V = cursorM2270a.getString(cursorM2270a.getColumnIndex("isblind"));
        }
        cursorM2270a.close();
        if (!httpEntry.m1950a() || httpEntry.m1951b() == HttpResultCode.ERROR) {
            if (this.f718a.f561H != null) {
                this.f718a.f561H.dismiss();
            }
            if (this.f718a.f570R != null) {
                this.f718a.f570R.setVisibility(8);
            }
            if (this.f718a.f574V == null || !this.f718a.f574V.equals("true")) {
                this.f718a.f566N.setVisibility(0);
                this.f718a.f567O.setVisibility(0);
            } else {
                this.f718a.f564K.clear();
                if (this.f718a.f562I != null) {
                    this.f718a.f562I.notifyDataSetChanged();
                }
                ((LinearLayout) this.f718a.f568P.findViewById(C0062R.id.profile_write_area)).setVisibility(8);
                this.f718a.f567O.setVisibility(8);
                if (this.f718a.f587l == null || this.f718a.f587l.length() == 0) {
                    ChatONLogWriter.m3499a("Buddy name is null", BuddyProfileActivity.f553a);
                    this.f718a.f587l = this.f718a.getString(C0062R.string.buddy_profile_no_name);
                }
                this.f718a.f571S.setText(String.format(this.f718a.getResources().getString(C0062R.string.memo_blinded), this.f718a.f587l));
            }
            this.f718a.f571S.setVisibility(0);
            Toast.makeText(this.f718a.f584i, this.f718a.getResources().getString(C0062R.string.dev_network_error), 0).show();
            if (this.f718a.f562I != null) {
                this.f718a.f562I.notifyDataSetChanged();
            }
        } else if (this.f718a.f574V == null || !this.f718a.f574V.equals("true")) {
            Cursor cursorM2269a = MemoDatabaseHelper.m2269a(this.f718a.getContentResolver(), this.f718a.f586k);
            this.f718a.f564K.clear();
            this.f718a.f566N.setVisibility(0);
            this.f718a.f567O.setVisibility(0);
            if (cursorM2269a.getCount() == 0) {
                this.f718a.f571S.setVisibility(0);
                this.f718a.f570R.setVisibility(8);
                if (this.f718a.f562I != null) {
                    this.f718a.f562I.notifyDataSetChanged();
                }
            } else {
                while (cursorM2269a.moveToNext()) {
                    this.f718a.f564K.add(new MemoAdapter.MemoItem(cursorM2269a.getString(cursorM2269a.getColumnIndex("buddy_no")), cursorM2269a.getString(cursorM2269a.getColumnIndex("buddy_name")), cursorM2269a.getString(cursorM2269a.getColumnIndex("memo")), cursorM2269a.getString(cursorM2269a.getColumnIndex("timestamp"))));
                    this.f718a.f571S.setVisibility(8);
                }
                cursorM2269a.close();
            }
            if (this.f718a.f572T == null || !this.f718a.f572T.equals("true")) {
                this.f718a.f570R.setVisibility(8);
            } else {
                this.f718a.f570R.setVisibility(0);
            }
            if (this.f718a.f562I == null) {
                this.f718a.f562I = new MemoAdapter(this.f718a.f563J, this.f718a.f584i, this.f718a.f564K, C0062R.layout.memo_adapter_item);
                this.f718a.f563J.setAdapter((ListAdapter) this.f718a.f562I);
            } else {
                this.f718a.f562I.notifyDataSetChanged();
            }
            if (cursorM2269a != null) {
                cursorM2269a.close();
            }
        } else {
            ChatONLogWriter.m3511e(this.f718a.f586k + " is blinded", BuddyProfileActivity.f553a);
            this.f718a.f564K.clear();
            if (this.f718a.f562I != null) {
                this.f718a.f562I.notifyDataSetChanged();
            }
            ((LinearLayout) this.f718a.f568P.findViewById(C0062R.id.profile_write_area)).setVisibility(8);
            this.f718a.f567O.setVisibility(8);
            this.f718a.f570R.setVisibility(8);
            if (this.f718a.f587l == null || this.f718a.f587l.length() == 0) {
                ChatONLogWriter.m3499a("Buddy name is null", BuddyProfileActivity.f553a);
                this.f718a.f587l = this.f718a.getString(C0062R.string.buddy_profile_no_name);
            }
            this.f718a.f571S.setText(String.format(this.f718a.getResources().getString(C0062R.string.memo_blinded), this.f718a.f587l));
            this.f718a.f571S.setVisibility(0);
            this.f718a.f575W = true;
        }
        this.f718a.f575W = false;
    }
}
