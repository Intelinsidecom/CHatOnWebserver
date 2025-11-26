package com.sec.chaton.chat;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.item.BuddyItem;
import com.sec.chaton.common.entry.BuddyEntry;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.NotifyingAsyncQueryHandler;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.RichString;
import com.sec.chaton.trunk.database.DatabaseConstant;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONNotificationManager;
import java.io.Serializable;
import java.util.Iterator;

/* renamed from: com.sec.chaton.chat.aa */
/* loaded from: classes.dex */
class C0136aa implements NotifyingAsyncQueryHandler.AsyncQueryListener {

    /* renamed from: a */
    int f933a = 0;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f934b;

    C0136aa(ChatFragment chatFragment) {
        this.f934b = chatFragment;
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: a */
    public void mo529a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: a */
    public void mo530a(int i, Object obj, Cursor cursor) {
        boolean zM798a;
        if (this.f934b.getActivity() == null) {
            return;
        }
        switch (i) {
            case 0:
                if (this.f934b.f827x == null && cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                    this.f934b.f827x = cursor.getString(cursor.getColumnIndex("message_session_id"));
                }
                this.f934b.f783aa = this.f934b.f756Z.swapCursor(cursor);
                if (this.f934b.f783aa != null) {
                    this.f934b.f783aa.close();
                }
                if (cursor != null) {
                    this.f934b.f755Y.setSelection(cursor.getCount());
                    return;
                } else {
                    this.f934b.f755Y.setSelection(0);
                    return;
                }
            case 1:
                if (cursor == null || cursor.getCount() == 0) {
                    this.f934b.f785ac.m2050a(this.f934b.f822s, GlobalApplication.m2389g().m3602b().m3603a(), GlobalApplication.m2389g().m3602b().m3606b());
                    this.f934b.f785ac.m2056c(Long.MAX_VALUE);
                    synchronized (this.f934b.f742L) {
                        this.f934b.f743M.startQuery(2, null, ChatONContract.BuddyTable.m2175f(), null, "buddy_no IN" + ChatUtil.m797a(this.f934b.f786ad), null, "buddy_name ASC");
                    }
                    this.f934b.f823t = false;
                    if (cursor != null) {
                        cursor.close();
                        return;
                    }
                    return;
                }
                if (cursor.moveToFirst()) {
                    this.f934b.f827x = cursor.getString(cursor.getColumnIndex("inbox_session_id"));
                    this.f934b.f788af = Long.valueOf(cursor.getLong(cursor.getColumnIndex("inbox_last_msg_no")));
                    this.f934b.f792aj = cursor.getString(cursor.getColumnIndex("inbox_title"));
                    this.f934b.f828y = cursor.getInt(cursor.getColumnIndex("_id"));
                    this.f934b.f789ag = cursor.getString(cursor.getColumnIndex("inbox_server_ip"));
                    this.f934b.f798ap = cursor.getInt(cursor.getColumnIndex("inbox_server_port"));
                    this.f934b.f802at = cursor.getLong(cursor.getColumnIndex("inbox_last_msg_no"));
                    this.f934b.f793ak = cursor.getString(cursor.getColumnIndex("inbox_title_fixed"));
                    this.f934b.f794al = cursor.getString(cursor.getColumnIndex("inbox_last_msg_sender"));
                    this.f934b.f824u = cursor.getString(cursor.getColumnIndex("inbox_last_temp_msg"));
                    this.f934b.f795am = cursor.getString(cursor.getColumnIndex("buddy_name"));
                    if (cursor.getInt(cursor.getColumnIndex("inbox_participants")) == 0) {
                        Toast.makeText(this.f934b.getActivity(), C0062R.string.chat_title_no_buddies, 0).show();
                    }
                    ChatONLogWriter.m3509d("inboxno:" + this.f934b.f822s);
                    ChatONLogWriter.m3509d("mChatTile:" + this.f934b.f792aj);
                    if (this.f934b.f824u != null) {
                        RichString richString = new RichString(this.f934b.getActivity().getResources(), this.f934b.f824u, (int) (this.f934b.f801as.getLineHeight() * 1.2f));
                        this.f934b.f801as.setText(richString);
                        this.f934b.f801as.setSelection(richString.length());
                    }
                    ChatONNotificationManager.m3515a(this.f934b.getActivity()).m3517a(this.f934b.f828y);
                    if (this.f934b.f826w == ChatONContract.InBoxTable.ChatType.ONETOONE) {
                        this.f934b.f803au.setLines(1);
                        this.f934b.f804av.setText(cursor.getString(cursor.getColumnIndex("buddy_status_message")));
                    } else {
                        this.f934b.f803au.setLines(2);
                        this.f934b.f804av.setVisibility(8);
                    }
                    if (this.f934b.f827x == null || this.f934b.f827x.equals("null") || this.f934b.f827x.equals("")) {
                        this.f934b.f785ac.m2050a(this.f934b.f822s, GlobalApplication.m2389g().m3602b().m3603a(), GlobalApplication.m2389g().m3602b().m3606b());
                        this.f934b.f785ac.m2056c(Long.MAX_VALUE);
                        if (this.f934b.f826w == ChatONContract.InBoxTable.ChatType.BROADCAST) {
                            this.f934b.f778aV.m2002a();
                        } else if (this.f934b.f826w == ChatONContract.InBoxTable.ChatType.ONETOONE) {
                            this.f934b.f785ac.m2039a(this.f934b.f826w, this.f934b.f827x);
                            this.f934b.f785ac.m2049a(ChatONContract.InBoxTable.ChatType.BROADCAST, this.f934b.f822s, this.f934b.f788af, this.f934b.f827x, this.f934b.f822s);
                        } else if (this.f934b.f789ag == null) {
                            this.f934b.m765a(GlobalApplication.m2389g().m3602b().m3603a(), GlobalApplication.m2389g().m3602b().m3606b(), this.f934b.f827x, this.f934b.f826w);
                        } else {
                            this.f934b.m765a(this.f934b.f789ag, this.f934b.f798ap, this.f934b.f827x, this.f934b.f826w);
                        }
                    } else {
                        if (this.f934b.f785ac.m2050a(this.f934b.f822s, this.f934b.f789ag, this.f934b.f798ap)) {
                            this.f934b.f785ac.m2056c(Long.MAX_VALUE);
                            this.f934b.f785ac.m2039a(this.f934b.f826w, this.f934b.f827x);
                            if (!this.f934b.f779aW) {
                                this.f934b.f785ac.m2049a(this.f934b.f826w, this.f934b.f822s, this.f934b.f788af, this.f934b.f827x, this.f934b.f822s);
                            }
                        }
                        this.f934b.m712a(this.f934b.f827x);
                    }
                    this.f934b.f743M.startQuery(5, null, ChatONContract.ParticipantTable.m2199a(this.f934b.f822s), new String[]{"buddy_no", "buddy_name", "buddy_status_message"}, null, null, "buddy_name ASC");
                    this.f934b.m768b();
                }
                cursor.close();
                return;
            case 2:
                if (cursor == null || cursor.getCount() == 0) {
                    if (this.f934b.f777aU.containsKey("receivers")) {
                        synchronized (this.f934b.f742L) {
                            for (String str : this.f934b.f777aU.getStringArray("receivers")) {
                                this.f934b.f786ad.add(str);
                                this.f934b.f787ae.put(str, new BuddyEntry(str));
                            }
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } else {
                    if (this.f934b.f797ao == null) {
                        if (this.f934b.f793ak == null || !this.f934b.f793ak.equals("Y")) {
                            this.f934b.f790ah = ChatUtil.m794a(cursor);
                        } else {
                            this.f934b.f790ah = this.f934b.f792aj;
                        }
                        if (this.f934b.f826w == ChatONContract.InBoxTable.ChatType.ONETOONE) {
                            this.f934b.f803au.setLines(1);
                            if (cursor.moveToFirst()) {
                                this.f934b.f804av.setText(cursor.getString(cursor.getColumnIndex("buddy_status_message")));
                            }
                        } else if (this.f934b.f826w == ChatONContract.InBoxTable.ChatType.GROUPCHAT) {
                            this.f934b.f803au.setLines(2);
                            if (this.f934b.f786ad.size() <= 0) {
                                this.f934b.f790ah = GlobalApplication.m2388f().getString(C0062R.string.chat_title_no_buddies);
                            }
                            ChatFragment.m710a(this.f934b, (Object) (" (" + (this.f934b.f786ad.size() + 1) + ")"));
                            this.f934b.f804av.setVisibility(8);
                        } else if (this.f934b.f826w == ChatONContract.InBoxTable.ChatType.BROADCAST) {
                            if (this.f934b.f796an != null) {
                                this.f934b.f790ah = this.f934b.f796an;
                            } else {
                                this.f934b.f790ah = ChatUtil.m796a(this.f934b.f793ak, this.f934b.f792aj);
                            }
                            ChatFragment.m710a(this.f934b, (Object) (" (" + this.f934b.f786ad.size() + ")"));
                            this.f934b.f804av.setVisibility(8);
                            this.f934b.f803au.setLines(2);
                        }
                        this.f934b.f791ai = this.f934b.f790ah;
                        this.f934b.f803au.setText(this.f934b.f790ah, TextView.BufferType.NORMAL);
                    } else {
                        this.f934b.f790ah = this.f934b.f797ao;
                    }
                    cursor.close();
                }
                this.f934b.m754a();
                this.f934b.m771c();
                this.f934b.f761aE = false;
                return;
            case 3:
                ContentValues contentValues = new ContentValues();
                if (cursor == null || cursor.getCount() == 0) {
                    contentValues.put("inbox_last_message", "");
                    this.f934b.f743M.startUpdate(4, null, ChatONContract.InBoxTable.f1717a, contentValues, "inbox_no='" + this.f934b.f822s + "'", null);
                    return;
                }
                cursor.moveToLast();
                int i2 = 0;
                while (true) {
                    if (i2 <= cursor.getCount()) {
                        String string = cursor.getString(cursor.getColumnIndex("message_content"));
                        int i3 = cursor.getInt(cursor.getColumnIndex("message_type"));
                        ChatONContract.MessageTable.MsgContentType msgContentTypeM2195a = ChatONContract.MessageTable.MsgContentType.m2195a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
                        String string2 = cursor.getString(cursor.getColumnIndex("buddy_name"));
                        String string3 = cursor.getString(cursor.getColumnIndex("message_time"));
                        String string4 = cursor.getString(cursor.getColumnIndex("message_sever_id"));
                        String string5 = cursor.getString(cursor.getColumnIndex("message_sender"));
                        if ((i3 == 1 || i3 == 2) && msgContentTypeM2195a != ChatONContract.MessageTable.MsgContentType.SYSTEM) {
                            contentValues.put("inbox_last_message", String.format("%d;%d;%s;%s", Integer.valueOf(i3), Integer.valueOf(msgContentTypeM2195a.m2197a()), ChatUtil.m795a(string), ChatUtil.m795a(string2)));
                            contentValues.put("inbox_last_msg_no", string4);
                            contentValues.put("inbox_last_time", string3);
                            contentValues.put("inbox_last_msg_sender", string5);
                            this.f934b.f743M.startUpdate(4, null, ChatONContract.InBoxTable.f1717a, contentValues, "inbox_no='" + this.f934b.f822s + "'", null);
                        } else {
                            i2++;
                            cursor.moveToPosition(cursor.getCount() - i2);
                        }
                    }
                }
                cursor.close();
                return;
            case 4:
            default:
                return;
            case 5:
                if (cursor != null) {
                    synchronized (this.f934b.f742L) {
                        zM798a = ChatUtil.m798a(cursor, this.f934b.f786ad, this.f934b.f787ae);
                    }
                    if (zM798a) {
                        this.f934b.f790ah = "";
                    }
                    if (this.f934b.f793ak == null) {
                        if (this.f934b.f797ao != null) {
                            this.f934b.f790ah = this.f934b.f797ao;
                            this.f934b.f797ao = null;
                        } else if (zM798a) {
                            Iterator it = this.f934b.f786ad.iterator();
                            while (it.hasNext()) {
                                ChatFragment.m710a(this.f934b, (Object) (((BuddyEntry) this.f934b.f787ae.get((String) it.next())).m1942a() + ","));
                            }
                            if (this.f934b.f790ah.length() > 1) {
                                this.f934b.f790ah = this.f934b.f790ah.substring(0, this.f934b.f790ah.length() - 1);
                            }
                            if (this.f934b.f826w == ChatONContract.InBoxTable.ChatType.GROUPCHAT) {
                                if (this.f934b.f786ad.size() <= 0) {
                                    this.f934b.f790ah = GlobalApplication.m2388f().getString(C0062R.string.chat_title_no_buddies);
                                }
                                ChatFragment.m710a(this.f934b, (Object) (" (" + (this.f934b.f786ad.size() + 1) + ")"));
                            } else if (this.f934b.f826w == ChatONContract.InBoxTable.ChatType.BROADCAST) {
                                this.f934b.f790ah = ChatUtil.m796a(this.f934b.f793ak, this.f934b.f792aj);
                                ChatFragment.m710a(this.f934b, (Object) (" (" + this.f934b.f786ad.size() + ")"));
                            }
                            this.f934b.f791ai = this.f934b.f790ah;
                            this.f934b.f803au.setText(this.f934b.f790ah, TextView.BufferType.NORMAL);
                        }
                        cursor.close();
                    } else if (zM798a) {
                        if (this.f934b.f793ak.equals("Y")) {
                            this.f934b.f790ah = this.f934b.f792aj;
                        } else {
                            Iterator it2 = this.f934b.f786ad.iterator();
                            while (it2.hasNext()) {
                                ChatFragment.m710a(this.f934b, (Object) (((BuddyEntry) this.f934b.f787ae.get((String) it2.next())).m1942a() + ","));
                            }
                            if (this.f934b.f790ah.length() > 1) {
                                this.f934b.f790ah = this.f934b.f790ah.substring(0, this.f934b.f790ah.length() - 1);
                            }
                            if (this.f934b.f786ad.size() <= 0) {
                                this.f934b.f790ah = GlobalApplication.m2388f().getString(C0062R.string.chat_title_no_buddies);
                            }
                            if (this.f934b.f826w != ChatONContract.InBoxTable.ChatType.BROADCAST) {
                                this.f934b.f792aj = this.f934b.f790ah;
                            }
                        }
                        if (this.f934b.f826w == ChatONContract.InBoxTable.ChatType.GROUPCHAT) {
                            ChatFragment.m710a(this.f934b, (Object) (" (" + (this.f934b.f786ad.size() + 1) + ")"));
                        } else if (this.f934b.f826w == ChatONContract.InBoxTable.ChatType.BROADCAST) {
                            this.f934b.f790ah = ChatUtil.m796a(this.f934b.f793ak, this.f934b.f792aj);
                            ChatFragment.m710a(this.f934b, (Object) (" (" + this.f934b.f786ad.size() + ")"));
                        }
                        this.f934b.f803au.setText(this.f934b.f790ah, TextView.BufferType.NORMAL);
                    } else {
                        this.f934b.f790ah = this.f934b.f792aj;
                        if (this.f934b.f826w == ChatONContract.InBoxTable.ChatType.GROUPCHAT) {
                            if (!this.f934b.f793ak.equals("Y") && this.f934b.f786ad.size() <= 0) {
                                this.f934b.f790ah = GlobalApplication.m2388f().getString(C0062R.string.chat_title_no_buddies);
                            }
                            ChatFragment.m710a(this.f934b, (Object) (" (" + (this.f934b.f786ad.size() + 1) + ")"));
                        } else if (this.f934b.f826w == ChatONContract.InBoxTable.ChatType.BROADCAST) {
                            this.f934b.f790ah = ChatUtil.m796a(this.f934b.f793ak, this.f934b.f792aj);
                            ChatFragment.m710a(this.f934b, (Object) (" (" + this.f934b.f786ad.size() + ")"));
                        }
                        this.f934b.f791ai = this.f934b.f790ah;
                        this.f934b.f803au.setText(this.f934b.f790ah, TextView.BufferType.NORMAL);
                    }
                }
                this.f934b.m754a();
                this.f934b.m771c();
                this.f934b.f761aE = false;
                return;
            case 6:
                if (cursor != null) {
                    cursor.close();
                    return;
                }
                return;
            case 7:
                if (cursor != null && cursor.getCount() != 0) {
                    cursor.moveToNext();
                    this.f934b.f733C.add(new BuddyItem(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), cursor.getString(cursor.getColumnIndex("buddy_birthday")), !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_raw_contact_id")), cursor.getString(cursor.getColumnIndex("buddy_push_name")), !cursor.getString(cursor.getColumnIndex("buddy_is_new")).equals("Y")));
                    Intent intent = new Intent(this.f934b.getActivity(), (Class<?>) BuddyProfileActivity.class);
                    intent.putExtra("PROFILE_BUDDY_INFO", (Serializable) this.f934b.f733C.get(0));
                    this.f934b.startActivityForResult(intent, 20);
                }
                if (cursor != null) {
                    cursor.close();
                    return;
                }
                return;
            case 8:
                this.f934b.f796an = ChatUtil.m793a(0, cursor, (Cursor) null);
                ChatONLogWriter.m3509d("title:" + this.f934b.f796an);
                if (cursor != null) {
                    cursor.close();
                    return;
                }
                return;
            case 9:
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    int i4 = cursor.getInt(cursor.getColumnIndex(DatabaseConstant.TrunkColumns.KEY_UNREAD_ITEM_COUNT));
                    if (i4 > 0 && i4 < 100) {
                        this.f934b.f765aI.setTextSize(12.0f);
                        this.f934b.f765aI.setText(String.valueOf(i4));
                        this.f934b.f765aI.setVisibility(0);
                    } else if (i4 >= 100) {
                        this.f934b.f765aI.setTextSize(10.0f);
                        this.f934b.f765aI.setText(C0062R.string.chat_max_unread);
                        this.f934b.f765aI.setVisibility(0);
                    } else {
                        this.f934b.f765aI.setVisibility(4);
                    }
                }
                if (cursor != null) {
                    cursor.close();
                    return;
                }
                return;
        }
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: a */
    public void mo531a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: b */
    public void mo534b(int i, Object obj, int i2) {
        if (i == 3) {
            this.f934b.f755Y.setChoiceMode(0);
            this.f934b.f755Y.setTranscriptMode(2);
            this.f934b.setHasOptionsMenu(true);
            this.f934b.f755Y.clearChoices();
            this.f934b.f814j.setVisibility(8);
            this.f934b.f815k.setVisibility(8);
            this.f934b.f770aN.setVisibility(8);
            this.f934b.f816l.setVisibility(0);
            this.f934b.f817m.setVisibility(0);
            this.f934b.f747Q.setEnabled(false);
            this.f934b.f743M.startQuery(3, null, ChatONContract.MessageTable.m2190a(), null, "message_inbox_no='" + this.f934b.f822s + "'", null, "message_is_failed , message_time , _id");
        }
    }
}
