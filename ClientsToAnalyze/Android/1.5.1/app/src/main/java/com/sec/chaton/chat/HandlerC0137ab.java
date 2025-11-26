package com.sec.chaton.chat;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.common.entry.BuddyEntry;
import com.sec.chaton.common.entry.MessageResultEntry;
import com.sec.chaton.common.entry.ResultEntry;
import com.sec.chaton.control.task.InitChatRoomTask;
import com.sec.chaton.control.task.MediaChatTask;
import com.sec.chaton.control.task.ReInitTask;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.trunk.database.helper.TrunkDatabaseHelper;
import com.sec.chaton.util.ChatONLogWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.sec.chaton.chat.ab */
/* loaded from: classes.dex */
class HandlerC0137ab extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f935a;

    HandlerC0137ab(ChatFragment chatFragment) {
        this.f935a = chatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        AlertDialog.Builder builderM753a;
        if (this.f935a.getActivity() == null) {
        }
        MessageResultEntry messageResultEntry = (MessageResultEntry) message.obj;
        if (ChatUtil.m792a(message.what, messageResultEntry.m1963a()) == MessageResultEntry.errorCode.END_APP) {
            AlertDialog.Builder builderM753a2 = this.f935a.m753a(MessageResultEntry.errorCode.END_APP);
            if (builderM753a2 != null) {
                builderM753a2.create().show();
            }
        } else if (ChatUtil.m792a(message.what, messageResultEntry.m1963a()) == MessageResultEntry.errorCode.RESTART_APP && (builderM753a = this.f935a.m753a(MessageResultEntry.errorCode.RESTART_APP)) != null) {
            builderM753a.create().show();
        }
        switch (message.what) {
            case 0:
                this.f935a.f823t = true;
                if (this.f935a.f734D.isShowing()) {
                    this.f935a.f734D.dismiss();
                }
                if (!messageResultEntry.f1325a) {
                    if (messageResultEntry.f1326b == ResultEntry.Result.NETWORKFAIL) {
                        this.f935a.f785ac.m2057d();
                        this.f935a.f785ac.m2050a(this.f935a.f822s, GlobalApplication.m2389g().m3602b().m3603a(), GlobalApplication.m2389g().m3602b().m3606b());
                    }
                    switch (ChatUtil.m792a(message.what, messageResultEntry.m1963a())) {
                        case CHANGE_SERVER:
                            this.f935a.f785ac.m2057d();
                            this.f935a.f785ac.m2050a(this.f935a.f822s, GlobalApplication.m2389g().m3602b().m3603a(), GlobalApplication.m2389g().m3602b().m3606b());
                            break;
                        case BLOCK_RECEIVER:
                            Toast.makeText(this.f935a.getActivity(), String.format(GlobalApplication.m2387e().getString(C0062R.string.toast_was_blocked), ((BuddyEntry) this.f935a.f787ae.get(this.f935a.f786ad.get(0))).m1942a()), 0).show();
                            break;
                        case INVALID_USER:
                            StringBuilder sb = new StringBuilder();
                            Iterator it = this.f935a.f787ae.entrySet().iterator();
                            while (it.hasNext()) {
                                sb.append(((BuddyEntry) ((Map.Entry) it.next()).getValue()).m1942a());
                                if (it.hasNext()) {
                                    sb.append(",");
                                }
                            }
                            Toast.makeText(this.f935a.getActivity(), String.format(GlobalApplication.m2387e().getString(C0062R.string.toast_deleted_account), sb.toString()), 0).show();
                            break;
                    }
                } else {
                    if (messageResultEntry instanceof InitChatRoomTask.InitChatRoomResultEntry) {
                        this.f935a.f827x = ((InitChatRoomTask.InitChatRoomResultEntry) messageResultEntry).f1607d;
                    } else if (messageResultEntry instanceof MediaChatTask.MediaIntiChatRoomReulstEntry) {
                        this.f935a.f827x = ((MediaChatTask.MediaIntiChatRoomReulstEntry) messageResultEntry).f1631d;
                    } else if (messageResultEntry instanceof ReInitTask.InitChatRoomResultEntry) {
                        this.f935a.f827x = ((ReInitTask.InitChatRoomResultEntry) messageResultEntry).f1651d;
                    }
                    if (this.f935a.f826w != ChatONContract.InBoxTable.ChatType.BROADCAST) {
                        this.f935a.f743M.startQuery(5, null, ChatONContract.ParticipantTable.m2199a(this.f935a.f822s), new String[]{"buddy_no", "buddy_name", "buddy_status_message"}, null, null, "buddy_name ASC");
                        this.f935a.m768b();
                    }
                    if (ChatUtil.m792a(message.what, messageResultEntry.m1963a()) == MessageResultEntry.errorCode.SUCCESS_RECEIVER_ERROR) {
                        ArrayList arrayList = messageResultEntry instanceof InitChatRoomTask.InitChatRoomResultEntry ? ((InitChatRoomTask.InitChatRoomResultEntry) messageResultEntry).f1608e : messageResultEntry instanceof MediaChatTask.MediaIntiChatRoomReulstEntry ? ((MediaChatTask.MediaIntiChatRoomReulstEntry) messageResultEntry).f1632e : null;
                        if (arrayList != null) {
                            StringBuilder sb2 = new StringBuilder();
                            Iterator it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                sb2.append((String) it2.next());
                                if (it2.hasNext()) {
                                    sb2.append(",");
                                }
                            }
                            Toast.makeText(this.f935a.getActivity(), String.format(GlobalApplication.m2387e().getString(C0062R.string.toast_deleted_account), sb2.toString()), 0).show();
                        } else {
                            ChatONLogWriter.m3499a("1001 error - but invalid user list is empty", getClass().getSimpleName());
                        }
                    }
                }
                if (this.f935a.f797ao != null) {
                    ContentValues contentValues = new ContentValues();
                    if (this.f935a.f826w != ChatONContract.InBoxTable.ChatType.ONETOONE) {
                        contentValues.put("inbox_title", this.f935a.f797ao.substring(0, this.f935a.f797ao.length() - (Integer.toString(this.f935a.f786ad.size()).length() + 3)));
                    } else {
                        contentValues.put("inbox_title", this.f935a.f797ao);
                    }
                    contentValues.put("inbox_title_fixed", "Y");
                    this.f935a.f743M.startUpdate(-1, null, ChatONContract.InBoxTable.f1717a, contentValues, "inbox_no='" + this.f935a.f822s + "'", null);
                    break;
                }
                break;
            case 2:
                if (this.f935a.f734D.isShowing()) {
                    this.f935a.f734D.dismiss();
                }
                if (messageResultEntry.f1325a || this.f935a.f826w != ChatONContract.InBoxTable.ChatType.GROUPCHAT || messageResultEntry.f1326b == ResultEntry.Result.NETWORKFAIL) {
                }
                break;
            case 4:
                if (!messageResultEntry.f1325a) {
                    if (messageResultEntry.f1326b == ResultEntry.Result.NETWORKFAIL) {
                        this.f935a.f785ac.m2057d();
                        this.f935a.f785ac.m2050a(this.f935a.f822s, GlobalApplication.m2389g().m3602b().m3603a(), GlobalApplication.m2389g().m3602b().m3606b());
                    }
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    switch (ChatUtil.m792a(message.what, messageResultEntry.m1963a())) {
                        case CHANGE_SERVER:
                            this.f935a.f785ac.m2057d();
                            this.f935a.f785ac.m2050a(this.f935a.f822s, GlobalApplication.m2389g().m3602b().m3603a(), GlobalApplication.m2389g().m3602b().m3606b());
                            this.f935a.f785ac.m2056c(jElapsedRealtime + 480000);
                            break;
                        case BLOCK_RECEIVER:
                            Toast.makeText(this.f935a.getActivity(), String.format(GlobalApplication.m2387e().getString(C0062R.string.toast_was_blocked), ((BuddyEntry) this.f935a.f787ae.get(this.f935a.f786ad.get(0))).m1942a()), 0).show();
                            break;
                        case INVALID_USER:
                            StringBuilder sb3 = new StringBuilder();
                            Iterator it3 = this.f935a.f787ae.entrySet().iterator();
                            while (it3.hasNext()) {
                                sb3.append(((BuddyEntry) ((Map.Entry) it3.next()).getValue()).m1942a());
                                if (it3.hasNext()) {
                                    sb3.append(",");
                                }
                            }
                            Toast.makeText(this.f935a.getActivity(), String.format(GlobalApplication.m2387e().getString(C0062R.string.toast_deleted_account), sb3.toString()), 0).show();
                            break;
                        case RETRY:
                            this.f935a.f785ac.m2050a(this.f935a.f822s, GlobalApplication.m2389g().m3602b().m3603a(), GlobalApplication.m2389g().m3602b().m3606b());
                            this.f935a.f785ac.m2056c(jElapsedRealtime + 480000);
                            this.f935a.f827x = null;
                            break;
                    }
                }
                break;
            case 8:
                if (this.f935a.f734D.isShowing()) {
                    this.f935a.f734D.dismiss();
                }
                if (!messageResultEntry.f1325a && ChatUtil.m792a(message.what, messageResultEntry.m1963a()) != MessageResultEntry.errorCode.REGARD_SUCCEESS) {
                    if (messageResultEntry.f1326b == ResultEntry.Result.NETWORKFAIL) {
                        this.f935a.f785ac.m2057d();
                        this.f935a.f785ac.m2050a(this.f935a.f822s, GlobalApplication.m2389g().m3602b().m3603a(), GlobalApplication.m2389g().m3602b().m3606b());
                    }
                    Toast.makeText(this.f935a.getActivity(), C0062R.string.toast_end_chat_fail, 0).show();
                    break;
                } else {
                    this.f935a.m726f();
                    this.f935a.f785ac.m2055c();
                    new TrunkDatabaseHelper(this.f935a.getActivity()).removeTrunk(this.f935a.f827x);
                    break;
                }
            case 12:
                if (this.f935a.f734D.isShowing()) {
                    this.f935a.f734D.dismiss();
                }
                if (!messageResultEntry.f1325a) {
                    Toast.makeText(this.f935a.getActivity(), C0062R.string.toast_invite_fail, 0).show();
                    break;
                }
                break;
            case 18:
                if (messageResultEntry.f1325a) {
                }
                break;
            case 1024:
                if (!messageResultEntry.f1325a) {
                    if (this.f935a.f734D.isShowing()) {
                        this.f935a.f734D.dismiss();
                    }
                    this.f935a.f780aX = messageResultEntry.m1963a();
                    if (this.f935a.f780aX != 28004) {
                        Toast.makeText(this.f935a.getActivity(), C0062R.string.toast_file_upload_fail, 0).show();
                        break;
                    } else {
                        Toast.makeText(this.f935a.getActivity(), C0062R.string.toast_supported_format, 0).show();
                        break;
                    }
                }
                break;
        }
    }
}
