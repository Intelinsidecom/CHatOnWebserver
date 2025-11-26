package com.sec.chaton.chat;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.hardware.motion.MREvent;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.p017a.C0363a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.p034a.C0760c;
import com.sec.chaton.p013a.C0227z;
import com.sec.chaton.p015b.p016a.C0258f;
import com.sec.chaton.p025d.C0654g;
import com.sec.chaton.p025d.C0662o;
import com.sec.chaton.p025d.C0667t;
import com.sec.chaton.p025d.C0671x;
import com.sec.chaton.p025d.EnumC0651d;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p025d.p026a.InterfaceC0626f;
import com.sec.chaton.util.C1332g;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1351z;
import com.sec.widget.C1619g;
import java.io.Serializable;
import java.util.Iterator;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bt */
/* loaded from: classes.dex */
class C0580bt implements InterfaceC0626f {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f2001a;

    C0580bt(ChatFragment chatFragment) {
        this.f2001a = chatFragment;
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo880a(int i, Object obj, Cursor cursor) {
        boolean zM2719b;
        if (this.f2001a.getActivity() == null) {
            C1341p.m4651a("onQueryCompleted - Activity is null", getClass().getSimpleName());
            return;
        }
        switch (i) {
            case 0:
                C1341p.m4658b("onQueryCompleted - QUERY_MESSAGE", getClass().getSimpleName());
                if (this.f2001a.f1850bv) {
                    if (cursor != null) {
                        cursor.close();
                        return;
                    }
                    return;
                }
                if (cursor != null && cursor.getCount() > 0 && this.f2001a.f1867z == null) {
                    cursor.moveToFirst();
                    this.f2001a.f1867z = cursor.getString(cursor.getColumnIndex("message_session_id"));
                }
                this.f2001a.f1796af = this.f2001a.f1795ae.swapCursor(cursor);
                if (this.f2001a.f1796af != null) {
                    this.f2001a.f1796af.close();
                }
                if (cursor == null || cursor.getCount() <= 0) {
                    this.f2001a.f1794ad.setSelection(0);
                    return;
                }
                this.f2001a.f1848bt = cursor.getCount();
                if (this.f2001a.f1745F) {
                    this.f2001a.f1794ad.setSelection(cursor.getCount());
                    return;
                }
                return;
            case 1:
                C1341p.m4658b("onQueryCompleted - QUERY_INBOX", getClass().getSimpleName());
                if (cursor == null || cursor.getCount() == 0) {
                    if (TextUtils.isEmpty(this.f2001a.f1861t)) {
                        this.f2001a.f1861t = C1351z.m4716a();
                        this.f2001a.f1828bM.mo2596b(this.f2001a.f1861t);
                    }
                    if (this.f2001a.m2668p()) {
                        this.f2001a.f1799ai.m851a(this.f2001a.f1861t, GlobalApplication.m3107h().m4488b().m4513a(), GlobalApplication.m3107h().m4488b().m4516b());
                        this.f2001a.f1799ai.m841a(Long.MAX_VALUE);
                        this.f2001a.f1799ai.m858g();
                        synchronized (this.f2001a.f1759T) {
                            this.f2001a.f1760U.startQuery(2, null, C0667t.m3031f(), null, "buddy_no IN" + C0520a.m2715a(this.f2001a.f1802al), null, "buddy_name ASC");
                        }
                        this.f2001a.f1863v = false;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (this.f2001a.f1866y == EnumC0665r.GROUPCHAT && !TextUtils.isEmpty(this.f2001a.f1864w)) {
                            C0760c c0760c = new C0760c(this.f2001a.getActivity().getResources(), this.f2001a.f1864w, (int) (ChatFragment.f1726aC.getLineHeight() * 1.2f));
                            ChatFragment.f1726aC.setText(c0760c);
                            ChatFragment.f1726aC.setSelection(c0760c.length());
                        }
                    } else {
                        cursor.close();
                        return;
                    }
                } else {
                    if (cursor.moveToFirst()) {
                        int i2 = cursor.getInt(cursor.getColumnIndex("inbox_last_chat_type"));
                        this.f2001a.f1861t = cursor.getString(cursor.getColumnIndex("inbox_no"));
                        this.f2001a.f1828bM.mo2596b(this.f2001a.f1861t);
                        if (i2 == 12) {
                            if (this.f2001a.m2668p()) {
                                this.f2001a.f1799ai.m851a(this.f2001a.f1861t, GlobalApplication.m3107h().m4488b().m4513a(), GlobalApplication.m3107h().m4488b().m4516b());
                                this.f2001a.f1799ai.m841a(Long.MAX_VALUE);
                                this.f2001a.f1799ai.m858g();
                                synchronized (this.f2001a.f1759T) {
                                    this.f2001a.f1760U.startQuery(2, null, C0667t.m3031f(), null, "buddy_no IN" + C0520a.m2715a(this.f2001a.f1802al), null, "buddy_name ASC");
                                }
                                this.f2001a.f1863v = false;
                            } else {
                                cursor.close();
                                return;
                            }
                        } else {
                            this.f2001a.f1867z = cursor.getString(cursor.getColumnIndex("inbox_session_id"));
                            this.f2001a.f1804an = Long.valueOf(cursor.getLong(cursor.getColumnIndex("inbox_last_msg_no")));
                            this.f2001a.f1807aq = cursor.getString(cursor.getColumnIndex("inbox_title"));
                            this.f2001a.f1740A = cursor.getInt(cursor.getColumnIndex("_id"));
                            this.f2001a.f1805ao = cursor.getString(cursor.getColumnIndex("inbox_server_ip"));
                            this.f2001a.f1814ax = cursor.getInt(cursor.getColumnIndex("inbox_server_port"));
                            this.f2001a.f1808ar = cursor.getString(cursor.getColumnIndex("inbox_title_fixed"));
                            this.f2001a.f1809as = cursor.getString(cursor.getColumnIndex("inbox_last_msg_sender"));
                            this.f2001a.f1864w = cursor.getString(cursor.getColumnIndex("inbox_last_temp_msg"));
                            this.f2001a.f1810at = cursor.getString(cursor.getColumnIndex("buddy_name"));
                            this.f2001a.f1813aw = cursor.getInt(cursor.getColumnIndex("inbox_trunk_unread_count"));
                            this.f2001a.f1862u = cursor.getString(cursor.getColumnIndex("buddy_no"));
                            this.f2001a.f1816az = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_valid")));
                            this.f2001a.f1766aA = cursor.getLong(cursor.getColumnIndex("inbox_last_timestamp"));
                            this.f2001a.f1767aB = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_enable_noti")));
                            this.f2001a.f1828bM.mo2594a(this.f2001a.f1867z);
                            String str = this.f2001a.f1862u;
                            if (this.f2001a.f1866y == EnumC0665r.GROUPCHAT) {
                                str = this.f2001a.f1861t;
                            }
                            if (!this.f2001a.m2668p()) {
                                cursor.close();
                                return;
                            }
                            if (cursor.getInt(cursor.getColumnIndex("inbox_participants")) == 0) {
                                C1619g.m5888a(this.f2001a.getActivity(), R.string.chat_title_no_buddies, 0).show();
                            }
                            this.f2001a.m2625a(this.f2001a.f1861t);
                            if (this.f2001a.f1864w != null) {
                                C0760c c0760c2 = new C0760c(this.f2001a.getActivity().getResources(), this.f2001a.f1864w, (int) (ChatFragment.f1726aC.getLineHeight() * 1.2f));
                                ChatFragment.f1726aC.setText(c0760c2);
                                ChatFragment.f1726aC.setSelection(c0760c2.length());
                            }
                            C1332g.m4605a(this.f2001a.getActivity()).m4610a(this.f2001a.f1740A);
                            if (this.f2001a.f1867z == null || "null".equals(this.f2001a.f1867z) || "".equals(this.f2001a.f1867z)) {
                                this.f2001a.f1799ai.m851a(this.f2001a.f1861t, GlobalApplication.m3107h().m4488b().m4513a(), GlobalApplication.m3107h().m4488b().m4516b());
                                this.f2001a.f1799ai.m841a(Long.MAX_VALUE);
                                if (this.f2001a.f1866y == EnumC0665r.BROADCAST) {
                                    C0227z.m876a(null);
                                } else if (this.f2001a.f1866y == EnumC0665r.ONETOONE) {
                                    if (this.f2001a.f1816az) {
                                        this.f2001a.f1799ai.m845a(this.f2001a.f1866y, this.f2001a.f1867z);
                                        this.f2001a.f1799ai.m849a(EnumC0665r.BROADCAST, str, this.f2001a.f1804an, this.f2001a.f1867z, this.f2001a.f1861t, this.f2001a.f1766aA);
                                    }
                                } else if (this.f2001a.f1816az) {
                                    if (this.f2001a.f1805ao != null) {
                                        this.f2001a.m2696a(this.f2001a.f1805ao, this.f2001a.f1814ax, str, this.f2001a.f1867z, this.f2001a.f1866y);
                                    } else {
                                        this.f2001a.m2696a(GlobalApplication.m3107h().m4488b().m4513a(), GlobalApplication.m3107h().m4488b().m4516b(), str, this.f2001a.f1867z, this.f2001a.f1866y);
                                    }
                                }
                            } else {
                                if (this.f2001a.f1799ai.m851a(this.f2001a.f1861t, this.f2001a.f1805ao, this.f2001a.f1814ax)) {
                                    this.f2001a.f1799ai.m841a(Long.MAX_VALUE);
                                    this.f2001a.f1799ai.m845a(this.f2001a.f1866y, this.f2001a.f1867z);
                                    if (this.f2001a.f1816az) {
                                        this.f2001a.f1799ai.m849a(this.f2001a.f1866y, str, this.f2001a.f1804an, this.f2001a.f1867z, this.f2001a.f1861t, this.f2001a.f1766aA);
                                    }
                                }
                                ((ChatActivity) this.f2001a.getActivity()).m2593a(this.f2001a.f1813aw);
                            }
                            if (!this.f2001a.f1816az) {
                                this.f2001a.f1856n.setVisibility(8);
                            }
                            C1341p.m4660c("QUERY_INBOX_QUERY_PARTICIPANTS_AFTER_INSERTED_onQueryCompleted", ChatFragment.f1725a);
                            this.f2001a.f1760U.startQuery(5, null, C0654g.m2980a(this.f2001a.f1861t), new String[]{"buddy_no", "buddy_name", "buddy_status_message"}, null, null, "rowid DESC");
                            this.f2001a.m2701b();
                        }
                    }
                    cursor.close();
                }
                this.f2001a.m2666o();
                this.f2001a.f1795ae.m2818a(this.f2001a.f1816az);
                C1341p.m4658b("QUERY_INBOX - QUERY_MESSAGE", getClass().getSimpleName());
                this.f2001a.f1760U.startQuery(0, null, C0662o.m2995a(this.f2001a.f1852by), null, "message_inbox_no=?", new String[]{this.f2001a.f1861t}, null);
                return;
            case 2:
                if (cursor == null || cursor.getCount() == 0) {
                    if (this.f2001a.f1840bl.containsKey("receivers")) {
                        synchronized (this.f2001a.f1759T) {
                            for (String str2 : this.f2001a.f1840bl.getStringArray("receivers")) {
                                this.f2001a.f1802al.add(str2);
                                this.f2001a.f1803am.put(str2, new C0258f(str2));
                            }
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } else {
                    if (this.f2001a.f1812av == null) {
                        if (this.f2001a.f1808ar == null || !this.f2001a.f1808ar.equals("Y")) {
                            this.f2001a.f1806ap = C0520a.m2712a(cursor, this.f2001a.f1802al, this.f2001a.f1803am);
                        } else {
                            this.f2001a.f1806ap = this.f2001a.f1807aq;
                        }
                        if (this.f2001a.f1866y != EnumC0665r.ONETOONE) {
                            if (this.f2001a.f1866y == EnumC0665r.GROUPCHAT) {
                                if (this.f2001a.f1802al.size() <= 0) {
                                    this.f2001a.f1806ap = GlobalApplication.m3106g().getString(R.string.chat_title_no_buddies);
                                }
                                ChatFragment.m2622a(this.f2001a, (Object) (" (" + (this.f2001a.f1802al.size() + 1) + ")"));
                            } else if (this.f2001a.f1866y == EnumC0665r.BROADCAST) {
                                if (this.f2001a.f1811au != null) {
                                    this.f2001a.f1806ap = this.f2001a.f1811au;
                                } else {
                                    this.f2001a.f1806ap = C0520a.m2714a(this.f2001a.f1808ar, this.f2001a.f1807aq);
                                }
                                ChatFragment.m2622a(this.f2001a, (Object) (" (" + this.f2001a.f1802al.size() + ")"));
                                ((ChatActivity) this.f2001a.getActivity()).m2598c(this.f2001a.f1806ap);
                            }
                        }
                        System.out.println("mHoneycom_ChatTitle:" + this.f2001a.f1777aM);
                        System.out.println("namelist:" + this.f2001a.f1806ap);
                        if (this.f2001a.f1778aN) {
                            this.f2001a.f1806ap = this.f2001a.f1777aM;
                            this.f2001a.f1778aN = false;
                        }
                    } else {
                        int iLastIndexOf = this.f2001a.f1812av.lastIndexOf(40);
                        if (iLastIndexOf <= 1) {
                            this.f2001a.f1806ap = this.f2001a.f1812av;
                        } else {
                            int size = 0;
                            try {
                                if (this.f2001a.f1866y == EnumC0665r.GROUPCHAT) {
                                    size = this.f2001a.f1802al.size() + 1;
                                } else if (this.f2001a.f1866y == EnumC0665r.BROADCAST) {
                                    size = this.f2001a.f1802al.size();
                                }
                                StringBuilder sb = new StringBuilder();
                                sb.append(this.f2001a.f1812av.substring(0, iLastIndexOf - 1)).append(" (").append(String.valueOf(size)).append(")");
                                this.f2001a.f1812av = sb.toString();
                            } catch (Exception e) {
                                C1341p.m4653a(e, getClass().getSimpleName());
                            } finally {
                                this.f2001a.f1806ap = this.f2001a.f1812av;
                                ((ChatActivity) this.f2001a.getActivity()).m2598c(this.f2001a.f1806ap);
                            }
                        }
                    }
                    cursor.close();
                }
                this.f2001a.m2684a();
                this.f2001a.m2704c();
                if (this.f2001a.f1780aP) {
                    this.f2001a.m2698a(this.f2001a.f1840bl.getStringArray("receivers"));
                    this.f2001a.f1780aP = false;
                }
                this.f2001a.f1779aO = false;
                return;
            case 3:
            case 4:
            case 9:
            default:
                return;
            case 5:
                if (cursor != null) {
                    C1341p.m4660c("QUERY_PARTICIPANTS_AFTER_onQueryCompleted : " + String.valueOf(cursor.getCount()), ChatFragment.f1725a);
                    synchronized (this.f2001a.f1759T) {
                        zM2719b = C0520a.m2719b(cursor, this.f2001a.f1802al, this.f2001a.f1803am);
                    }
                    if (TextUtils.isEmpty(this.f2001a.f1862u)) {
                        try {
                            this.f2001a.f1862u = (String) this.f2001a.f1802al.get(0);
                            this.f2001a.f1810at = ((C0258f) this.f2001a.f1803am.get(this.f2001a.f1862u)).m919a();
                        } catch (Exception e2) {
                            this.f2001a.f1810at = GlobalApplication.m3106g().getString(R.string.unknown);
                        }
                    }
                    if (zM2719b) {
                        this.f2001a.f1806ap = "";
                    }
                    if (this.f2001a.f1808ar == null) {
                        if (this.f2001a.f1812av != null) {
                            this.f2001a.f1806ap = this.f2001a.f1812av;
                            this.f2001a.f1812av = null;
                        } else if (zM2719b) {
                            Iterator it = this.f2001a.f1802al.iterator();
                            while (it.hasNext()) {
                                ChatFragment.m2622a(this.f2001a, (Object) (((C0258f) this.f2001a.f1803am.get((String) it.next())).m919a() + ", "));
                            }
                            if (this.f2001a.f1806ap.length() > 1) {
                                this.f2001a.f1806ap = this.f2001a.f1806ap.substring(0, this.f2001a.f1806ap.length() - 2);
                            }
                            if (this.f2001a.f1866y == EnumC0665r.GROUPCHAT) {
                                if (this.f2001a.f1802al.size() <= 0) {
                                    this.f2001a.f1806ap = GlobalApplication.m3106g().getString(R.string.chat_title_no_buddies);
                                }
                                ChatFragment.m2622a(this.f2001a, (Object) (" (" + (this.f2001a.f1802al.size() + 1) + ")"));
                            } else if (this.f2001a.f1866y == EnumC0665r.BROADCAST) {
                                this.f2001a.f1806ap = C0520a.m2714a(this.f2001a.f1808ar, this.f2001a.f1807aq);
                                ChatFragment.m2622a(this.f2001a, (Object) (" (" + this.f2001a.f1802al.size() + ")"));
                                ((ChatActivity) this.f2001a.getActivity()).m2598c(this.f2001a.f1806ap);
                            }
                        }
                    } else if (zM2719b) {
                        if (this.f2001a.f1808ar.equals("Y")) {
                            this.f2001a.f1806ap = this.f2001a.f1807aq;
                        } else {
                            Iterator it2 = this.f2001a.f1802al.iterator();
                            while (it2.hasNext()) {
                                ChatFragment.m2622a(this.f2001a, (Object) (((C0258f) this.f2001a.f1803am.get((String) it2.next())).m919a() + ", "));
                            }
                            if (this.f2001a.f1806ap.length() > 1) {
                                this.f2001a.f1806ap = this.f2001a.f1806ap.substring(0, this.f2001a.f1806ap.length() - 2);
                            }
                            if (this.f2001a.f1802al.size() <= 0) {
                                this.f2001a.f1806ap = GlobalApplication.m3106g().getString(R.string.chat_title_no_buddies);
                            }
                            if (this.f2001a.f1866y != EnumC0665r.BROADCAST) {
                                this.f2001a.f1807aq = this.f2001a.f1806ap;
                            }
                        }
                        if (this.f2001a.f1866y == EnumC0665r.GROUPCHAT) {
                            ChatFragment.m2622a(this.f2001a, (Object) (" (" + (this.f2001a.f1802al.size() + 1) + ")"));
                        } else if (this.f2001a.f1866y == EnumC0665r.BROADCAST) {
                            this.f2001a.f1806ap = C0520a.m2714a(this.f2001a.f1808ar, this.f2001a.f1807aq);
                            ChatFragment.m2622a(this.f2001a, (Object) (" (" + this.f2001a.f1802al.size() + ")"));
                            ((ChatActivity) this.f2001a.getActivity()).m2598c(this.f2001a.f1806ap);
                        }
                    } else {
                        this.f2001a.f1806ap = this.f2001a.f1807aq;
                        if (this.f2001a.f1866y == EnumC0665r.GROUPCHAT) {
                            if (!this.f2001a.f1808ar.equals("Y") && this.f2001a.f1802al.size() <= 0) {
                                this.f2001a.f1806ap = GlobalApplication.m3106g().getString(R.string.chat_title_no_buddies);
                            }
                            ChatFragment.m2622a(this.f2001a, (Object) (" (" + (this.f2001a.f1802al.size() + 1) + ")"));
                        } else if (this.f2001a.f1866y == EnumC0665r.BROADCAST) {
                            this.f2001a.f1806ap = C0520a.m2714a(this.f2001a.f1808ar, this.f2001a.f1807aq);
                            ChatFragment.m2622a(this.f2001a, (Object) (" (" + this.f2001a.f1802al.size() + ")"));
                            ((ChatActivity) this.f2001a.getActivity()).m2598c(this.f2001a.f1806ap);
                        }
                    }
                    cursor.close();
                    this.f2001a.m2706g();
                }
                this.f2001a.m2684a();
                this.f2001a.m2704c();
                if (this.f2001a.f1780aP) {
                    this.f2001a.m2698a(this.f2001a.f1840bl.getStringArray("receivers"));
                    this.f2001a.f1780aP = false;
                }
                this.f2001a.f1779aO = false;
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
                    this.f2001a.f1743D.add(new C0363a(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), cursor.getString(cursor.getColumnIndex("buddy_birthday")), !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_raw_contact_id")), cursor.getString(cursor.getColumnIndex("buddy_push_name")), !cursor.getString(cursor.getColumnIndex("buddy_is_new")).equals("Y")));
                    Intent intent = new Intent(this.f2001a.getActivity(), (Class<?>) BuddyProfileActivity.class);
                    intent.putExtra("PROFILE_BUDDY_INFO", (Serializable) this.f2001a.f1743D.get(0));
                    intent.setFlags(67108864);
                    this.f2001a.startActivityForResult(intent, 20);
                }
                if (cursor != null) {
                    cursor.close();
                    return;
                }
                return;
            case 8:
                this.f2001a.f1811au = C0520a.m2710a(0, cursor, (Cursor) null);
                C1341p.m4659c("title:" + this.f2001a.f1811au);
                if (cursor != null) {
                    cursor.close();
                    return;
                }
                return;
            case 10:
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    this.f2001a.f1816az = "Y".equals(cursor.getString(0));
                    if (!this.f2001a.f1816az) {
                        this.f2001a.f1856n.setVisibility(8);
                    }
                    this.f2001a.f1795ae.m2818a(this.f2001a.f1816az);
                    String string = cursor.getString(1);
                    if (!TextUtils.isEmpty(string) && !string.equals(this.f2001a.f1867z)) {
                        this.f2001a.f1867z = string;
                        this.f2001a.f1828bM.mo2594a(this.f2001a.f1867z);
                    }
                    this.f2001a.f1766aA = cursor.getLong(2);
                }
                if (cursor != null) {
                    cursor.close();
                    return;
                }
                return;
            case 11:
                ContentValues contentValues = new ContentValues();
                if (cursor != null && cursor.getCount() != 0) {
                    cursor.moveToLast();
                    if (0 <= cursor.getCount()) {
                        String string2 = cursor.getString(cursor.getColumnIndex("message_content"));
                        int i3 = cursor.getInt(cursor.getColumnIndex("message_type"));
                        EnumC0651d enumC0651dM2976a = EnumC0651d.m2976a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
                        String string3 = cursor.getString(cursor.getColumnIndex("buddy_name"));
                        String string4 = cursor.getString(cursor.getColumnIndex("message_time"));
                        String string5 = cursor.getString(cursor.getColumnIndex("message_sever_id"));
                        String string6 = cursor.getString(cursor.getColumnIndex("message_sender"));
                        contentValues.put("inbox_last_message", String.format("%d;%d;%s;%s", Integer.valueOf(i3), Integer.valueOf(enumC0651dM2976a.m2978a()), C0520a.m2713a(string2), C0520a.m2713a(string3)));
                        contentValues.put("inbox_last_msg_no", string5);
                        contentValues.put("inbox_last_time", string4);
                        contentValues.put("inbox_last_msg_sender", string6);
                        this.f2001a.f1760U.startUpdate(4, null, C0671x.f2315a, contentValues, "inbox_no='" + this.f2001a.f1861t + "'", null);
                    }
                } else {
                    contentValues.put("inbox_last_message", "");
                    this.f2001a.f1760U.startUpdate(4, null, C0671x.f2315a, contentValues, "inbox_no='" + this.f2001a.f1861t + "'", null);
                }
                if (cursor != null) {
                    cursor.close();
                    return;
                }
                return;
            case MREvent.TILT_PORTRAIT_BACK /* 12 */:
                long j = 0;
                long j2 = 0;
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    long j3 = cursor.getLong(cursor.getColumnIndex("message_total_count"));
                    j = cursor.getLong(cursor.getColumnIndex("message_sent_count"));
                    j2 = j3 - j;
                    this.f2001a.f1795ae.m2814a(j2);
                    this.f2001a.f1795ae.m2822b(j);
                }
                if (cursor != null) {
                    cursor.close();
                }
                if (this.f2001a.f1795ae != null) {
                    this.f2001a.f1795ae.m2817a(EnumC0542ar.SELECT_NONE);
                    this.f2001a.f1795ae.m2823b(EnumC0542ar.SELECT_NONE);
                    this.f2001a.f1795ae.m2825c(EnumC0542ar.SELECT_NONE);
                }
                this.f2001a.f1834bf.hideSoftInputFromWindow(ChatFragment.f1726aC.getWindowToken(), 0);
                this.f2001a.f1794ad.setChoiceMode(2);
                this.f2001a.f1794ad.setTranscriptMode(0);
                this.f2001a.f1854l.setVisibility(0);
                if (0 == j) {
                    this.f2001a.f1792ab.setEnabled(false);
                } else {
                    this.f2001a.f1792ab.setEnabled(true);
                }
                if (0 == j2) {
                    this.f2001a.f1791aa.setEnabled(false);
                } else {
                    this.f2001a.f1791aa.setEnabled(true);
                }
                this.f2001a.f1855m.setVisibility(0);
                this.f2001a.f1856n.setVisibility(8);
                this.f2001a.f1839bk.setVisibility(8);
                this.f2001a.f1858q = false;
                return;
            case MREvent.TILT_PORTRAIT_FRONT_BACK_STOP /* 13 */:
                if (cursor.getCount() > 0) {
                    Intent intent2 = new Intent(this.f2001a.getActivity(), (Class<?>) BuddyActivity2.class);
                    intent2.putExtra("ACTIVITY_PURPOSE", 5);
                    intent2.putExtra("chatType", this.f2001a.f1866y.m3012a());
                    synchronized (this.f2001a.f1759T) {
                        intent2.putExtra(ChatFragment.f1730c, (String[]) this.f2001a.f1802al.toArray(new String[this.f2001a.f1802al.size()]));
                    }
                    this.f2001a.startActivityForResult(intent2, 4);
                    this.f2001a.f1857p = true;
                } else {
                    C1619g.m5889a(GlobalApplication.m3100a(), this.f2001a.getResources().getString(R.string.buddy_list_invite_toast_failed_nomore), 0).show();
                    this.f2001a.f1859r = false;
                    this.f2001a.f1831bc = 1;
                }
                if (cursor != null) {
                    cursor.close();
                    return;
                }
                return;
            case 14:
                C1341p.m4658b("onQueryCompleted - QUERY_MESSAGE_LOAD_MORE", getClass().getSimpleName());
                if (this.f2001a.f1850bv) {
                    if (cursor != null) {
                        cursor.close();
                        return;
                    }
                    return;
                }
                if (cursor != null && cursor.getCount() > 0 && this.f2001a.f1867z == null) {
                    cursor.moveToFirst();
                    this.f2001a.f1867z = cursor.getString(cursor.getColumnIndex("message_session_id"));
                }
                this.f2001a.f1796af = this.f2001a.f1795ae.swapCursor(cursor);
                if (this.f2001a.f1796af != null) {
                    this.f2001a.f1796af.close();
                }
                if (cursor == null || cursor.getCount() <= 0) {
                    this.f2001a.f1794ad.setSelection(0);
                    return;
                }
                if (this.f2001a.f1745F) {
                    this.f2001a.f1794ad.setSelection(cursor.getCount());
                    return;
                }
                int count = cursor.getCount();
                if (count > this.f2001a.f1848bt) {
                    int i4 = count - this.f2001a.f1848bt;
                    if (i4 < ChatFragment.f1729bx) {
                        this.f2001a.f1794ad.setSelection(i4);
                    } else {
                        this.f2001a.f1794ad.setSelection(ChatFragment.f1729bx);
                    }
                    this.f2001a.f1848bt = count;
                    return;
                }
                return;
        }
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo881a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo879a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: b */
    public void mo882b(int i, Object obj, int i2) {
        if (i == 3) {
            this.f2001a.f1794ad.setChoiceMode(0);
            if (!this.f2001a.f1745F) {
                if (C1341p.f4578b) {
                    C1341p.m4658b("DeleteMessageObserver_QUERY_MESSAGE", getClass().getSimpleName());
                }
                this.f2001a.f1760U.startQuery(0, null, C0662o.m2995a(this.f2001a.f1852by), null, "message_inbox_no=?", new String[]{this.f2001a.f1861t}, null);
            }
            BaseActivity.m2041a(this.f2001a, true);
            this.f2001a.f1794ad.clearChoices();
            this.f2001a.f1854l.setVisibility(8);
            this.f2001a.f1855m.setVisibility(8);
            if (this.f2001a.f1816az) {
                this.f2001a.f1856n.setVisibility(0);
            }
            this.f2001a.f1763X.setEnabled(false);
            this.f2001a.f1760U.startQuery(11, null, C0662o.m2994a(), null, "message_inbox_no = ? AND ( message_type = ? OR message_type = ? ) AND message_content_type != ?", new String[]{this.f2001a.f1861t, String.valueOf(1), String.valueOf(2), String.valueOf(EnumC0651d.SYSTEM.m2978a())}, "message_is_failed , message_time , _id");
        }
    }
}
