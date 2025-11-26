package com.sec.chaton.chat;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.C0229at;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.BuddySelectActivity;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.C0968n;
import com.sec.chaton.p007a.p008a.C0100a;
import com.sec.chaton.p017e.C0688c;
import com.sec.chaton.p017e.C0694i;
import com.sec.chaton.p017e.C0698m;
import com.sec.chaton.p017e.C0701p;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.p017e.p018a.C0660d;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.util.C1733ap;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1788t;
import java.io.Serializable;
import java.util.Iterator;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.z */
/* loaded from: classes.dex */
class C0520z implements InterfaceC0667k {

    /* renamed from: a */
    int f2130a = 0;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f2131b;

    C0520z(ChatFragment chatFragment) {
        this.f2131b = chatFragment;
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onQueryComplete(int i, Object obj, Cursor cursor) throws NumberFormatException {
        boolean zM2690b;
        if (this.f2131b.getActivity() == null) {
            C1786r.m6054a("onQueryCompleted - Activity is null", getClass().getSimpleName());
            return;
        }
        switch (i) {
            case 0:
                C1786r.m6061b("onQueryCompleted - QUERY_MESSAGE", getClass().getSimpleName());
                if (cursor != null && cursor.getCount() > 0) {
                    if (this.f2131b.f1902o.getVisibility() == 0) {
                        if (this.f2131b.f1828aq.m2674d() == EnumC0487ba.SELECT_ALL) {
                            this.f2131b.f1828aq.m2664a(EnumC0487ba.SELECT_NONE);
                        } else if (this.f2131b.f1828aq.m2675e() == EnumC0487ba.SELECT_ALL) {
                            this.f2131b.f1828aq.m2671b(EnumC0487ba.SELECT_NONE);
                        } else if (this.f2131b.f1828aq.m2676f() == EnumC0487ba.SELECT_ALL) {
                            this.f2131b.f1828aq.m2673c(EnumC0487ba.SELECT_NONE);
                        }
                        this.f2131b.f1783X.startQuery(12, null, C0698m.m3156c(this.f2131b.f1912z), null, null, null, null);
                    }
                    if (this.f2131b.f1766G == null) {
                        cursor.moveToFirst();
                        this.f2131b.f1766G = cursor.getString(cursor.getColumnIndex("message_session_id"));
                    }
                }
                if (this.f2131b.f1829ar != null) {
                    this.f2131b.f1829ar.close();
                }
                this.f2131b.f1829ar = this.f2131b.f1828aq.swapCursor(cursor);
                if (cursor == null || cursor.getCount() <= 0) {
                    this.f2131b.f1827ap.setSelection(0);
                    return;
                } else {
                    if (this.f2131b.f1772M) {
                        this.f2131b.f1827ap.setSelection(cursor.getCount());
                        return;
                    }
                    return;
                }
            case 1:
                C1786r.m6061b("onQueryCompleted - QUERY_INBOX", getClass().getSimpleName());
                if (cursor == null || cursor.getCount() == 0) {
                    if (TextUtils.isEmpty(this.f2131b.f1912z)) {
                        this.f2131b.f1912z = C1733ap.m5916a();
                    }
                    if (this.f2131b.m2557m()) {
                        this.f2131b.f1831at.m2947a(this.f2131b.f1912z, GlobalApplication.m3263d().m5922b().m5923a(), GlobalApplication.m3263d().m5922b().m5926b());
                        this.f2131b.f1831at.m2930a(Long.MAX_VALUE);
                        synchronized (this.f2131b.f1782W) {
                            this.f2131b.f1783X.startQuery(2, null, C0688c.m3128f(), null, "buddy_no IN" + C0493bg.m2686a(this.f2131b.f1834aw), null, "buddy_name ASC");
                        }
                        this.f2131b.f1761B = false;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (this.f2131b.f1765F == EnumC0695j.GROUPCHAT && !TextUtils.isEmpty(this.f2131b.f1762C)) {
                            CharSequence charSequenceM3825a = C0968n.m3825a(this.f2131b.getActivity(), this.f2131b.f1762C, (int) (this.f2131b.f1800aO.getLineHeight() * 1.2f));
                            this.f2131b.f1800aO.setText(charSequenceM3825a);
                            this.f2131b.f1800aO.setSelection(charSequenceM3825a.length());
                        }
                    } else {
                        cursor.close();
                        return;
                    }
                } else {
                    if (cursor.moveToFirst()) {
                        int i2 = cursor.getInt(cursor.getColumnIndex("inbox_last_chat_type"));
                        this.f2131b.f1912z = cursor.getString(cursor.getColumnIndex("inbox_no"));
                        int i3 = Integer.parseInt(cursor.getString(cursor.getColumnIndex("inbox_trunk_unread_count")));
                        if (i3 > 0 && i3 < 100) {
                            this.f2131b.f1847bJ.setTextSize(12.0f);
                            this.f2131b.f1847bJ.setText(String.valueOf(i3));
                            this.f2131b.f1847bJ.setVisibility(0);
                        } else if (i3 >= 100) {
                            this.f2131b.f1847bJ.setTextSize(10.0f);
                            this.f2131b.f1847bJ.setText(R.string.chat_max_unread);
                            this.f2131b.f1847bJ.setVisibility(0);
                        } else {
                            this.f2131b.f1847bJ.setVisibility(8);
                        }
                        if (i2 == 12) {
                            if (this.f2131b.m2557m()) {
                                this.f2131b.f1831at.m2947a(this.f2131b.f1912z, GlobalApplication.m3263d().m5922b().m5923a(), GlobalApplication.m3263d().m5922b().m5926b());
                                this.f2131b.f1831at.m2930a(Long.MAX_VALUE);
                                synchronized (this.f2131b.f1782W) {
                                    this.f2131b.f1783X.startQuery(2, null, C0688c.m3128f(), null, "buddy_no IN" + C0493bg.m2686a(this.f2131b.f1834aw), null, "buddy_name ASC");
                                }
                                this.f2131b.f1761B = false;
                            } else {
                                cursor.close();
                                return;
                            }
                        } else {
                            this.f2131b.f1766G = cursor.getString(cursor.getColumnIndex("inbox_session_id"));
                            this.f2131b.f1836ay = Long.valueOf(cursor.getLong(cursor.getColumnIndex("inbox_last_msg_no")));
                            this.f2131b.f1787aB = cursor.getString(cursor.getColumnIndex("inbox_title"));
                            this.f2131b.f1767H = cursor.getInt(cursor.getColumnIndex("_id"));
                            this.f2131b.f1837az = cursor.getString(cursor.getColumnIndex("inbox_server_ip"));
                            this.f2131b.f1794aI = cursor.getInt(cursor.getColumnIndex("inbox_server_port"));
                            if (TextUtils.isEmpty(this.f2131b.f1837az)) {
                                this.f2131b.f1837az = GlobalApplication.m3263d().m5922b().m5923a();
                                this.f2131b.f1794aI = GlobalApplication.m3263d().m5922b().m5926b();
                            }
                            this.f2131b.f1788aC = cursor.getString(cursor.getColumnIndex("inbox_title_fixed"));
                            this.f2131b.f1789aD = cursor.getString(cursor.getColumnIndex("inbox_last_msg_sender"));
                            this.f2131b.f1790aE = cursor.getString(cursor.getColumnIndex("buddy_name"));
                            String string = cursor.getString(cursor.getColumnIndex("inbox_last_temp_msg"));
                            this.f2131b.f1760A = cursor.getString(cursor.getColumnIndex("buddy_no"));
                            this.f2131b.f1797aL = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_valid")));
                            this.f2131b.f1798aM = cursor.getLong(cursor.getColumnIndex("inbox_last_timestamp"));
                            this.f2131b.f1799aN = "Y".equals(cursor.getString(cursor.getColumnIndex("inbox_enable_noti")));
                            if (TextUtils.isEmpty(this.f2131b.f1762C)) {
                                this.f2131b.f1762C = string;
                            }
                            String str = this.f2131b.f1760A;
                            if (this.f2131b.f1765F == EnumC0695j.GROUPCHAT) {
                                str = this.f2131b.f1912z;
                            }
                            if (!this.f2131b.m2557m()) {
                                cursor.close();
                                return;
                            }
                            if (cursor.getInt(cursor.getColumnIndex("inbox_participants")) == 0) {
                                Toast.makeText(this.f2131b.getActivity(), R.string.chat_title_no_buddies, 0).show();
                            }
                            this.f2131b.m2532d(this.f2131b.f1912z);
                            if (this.f2131b.f1762C != null) {
                                CharSequence charSequenceM3825a2 = C0968n.m3825a(this.f2131b.getActivity(), this.f2131b.f1762C, (int) (this.f2131b.f1800aO.getLineHeight() * 1.2f));
                                this.f2131b.f1800aO.setText(charSequenceM3825a2);
                                this.f2131b.f1800aO.setSelection(charSequenceM3825a2.length());
                            }
                            C1788t.m6070a(this.f2131b.getActivity()).m6073a(this.f2131b.f1767H);
                            if (this.f2131b.f1797aL) {
                                if (this.f2131b.f1766G == null || "null".equals(this.f2131b.f1766G) || "".equals(this.f2131b.f1766G)) {
                                    this.f2131b.f1831at.m2947a(this.f2131b.f1912z, GlobalApplication.m3263d().m5922b().m5923a(), GlobalApplication.m3263d().m5922b().m5926b());
                                    this.f2131b.f1831at.m2930a(Long.MAX_VALUE);
                                    if (this.f2131b.f1765F == EnumC0695j.BROADCAST) {
                                        this.f2131b.f1855bR.m2887a();
                                    } else if (this.f2131b.f1765F == EnumC0695j.ONETOONE) {
                                        this.f2131b.f1831at.m2936a(this.f2131b.f1765F, this.f2131b.f1766G);
                                        this.f2131b.f1831at.m2945a(EnumC0695j.BROADCAST, str, this.f2131b.f1836ay, this.f2131b.f1766G, this.f2131b.f1912z);
                                    } else if (this.f2131b.f1837az != null) {
                                        this.f2131b.allowWithPush(this.f2131b.f1837az, this.f2131b.f1794aI, str, this.f2131b.f1766G, this.f2131b.f1765F);
                                    } else {
                                        this.f2131b.allowWithPush(GlobalApplication.m3263d().m5922b().m5923a(), GlobalApplication.m3263d().m5922b().m5926b(), str, this.f2131b.f1766G, this.f2131b.f1765F);
                                    }
                                } else {
                                    if (this.f2131b.f1831at.m2947a(this.f2131b.f1912z, this.f2131b.f1837az, this.f2131b.f1794aI)) {
                                        this.f2131b.f1831at.m2930a(Long.MAX_VALUE);
                                        this.f2131b.f1831at.m2936a(this.f2131b.f1765F, this.f2131b.f1766G);
                                        if (this.f2131b.f1797aL) {
                                            this.f2131b.f1831at.m2945a(this.f2131b.f1765F, str, this.f2131b.f1836ay, this.f2131b.f1766G, this.f2131b.f1912z);
                                        }
                                        if (!this.f2131b.f1856bS) {
                                            this.f2131b.f1831at.m2945a(this.f2131b.f1765F, str, this.f2131b.f1836ay, this.f2131b.f1766G, this.f2131b.f1912z);
                                        }
                                    }
                                    this.f2131b.m2527c(this.f2131b.f1766G);
                                }
                            }
                            this.f2131b.f1783X.startQuery(5, null, C0701p.m3164a(this.f2131b.f1912z), new String[]{"buddy_no", "buddy_name", "buddy_status_message"}, null, null, "rowid DESC");
                            this.f2131b.m2605c();
                        }
                    }
                    cursor.close();
                }
                this.f2131b.m2575v();
                this.f2131b.m2573u();
                this.f2131b.m2554l();
                this.f2131b.f1828aq.m2667a(this.f2131b.f1797aL);
                C1786r.m6061b("QUERY_INBOX - QUERY_MESSAGE", getClass().getSimpleName());
                this.f2131b.f1783X.startQuery(0, null, C0698m.m3148a(this.f2131b.f1895cg), null, "message_inbox_no=?", new String[]{this.f2131b.f1912z}, null);
                return;
            case 2:
                if (cursor == null || cursor.getCount() == 0) {
                    if (this.f2131b.f1854bQ.containsKey("receivers")) {
                        synchronized (this.f2131b.f1782W) {
                            for (String str2 : this.f2131b.f1854bQ.getStringArray("receivers")) {
                                this.f2131b.f1834aw.add(str2);
                                this.f2131b.f1835ax.put(str2, new C0100a(str2));
                            }
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } else {
                    if (this.f2131b.f1792aG == null) {
                        if (this.f2131b.f1788aC == null || !this.f2131b.f1788aC.equals("Y")) {
                            this.f2131b.f1786aA = C0493bg.m2683a(cursor, this.f2131b.f1834aw, this.f2131b.f1835ax);
                        } else {
                            this.f2131b.f1786aA = this.f2131b.f1787aB;
                            this.f2131b.f1786aA = C0493bg.m2683a(cursor, this.f2131b.f1834aw, this.f2131b.f1835ax);
                        }
                        if (this.f2131b.f1765F == EnumC0695j.ONETOONE) {
                            this.f2131b.f1801aP.setLines(1);
                            if (cursor.moveToFirst()) {
                            }
                        } else if (this.f2131b.f1765F == EnumC0695j.GROUPCHAT) {
                            if (this.f2131b.f1834aw.size() <= 0) {
                                this.f2131b.f1786aA = GlobalApplication.m3262c().getString(R.string.chat_title_no_buddies);
                            }
                            this.f2131b.f1786aA = this.f2131b.m2506a(this.f2131b.f1786aA, this.f2131b.f1834aw.size() + 1);
                        } else if (this.f2131b.f1765F == EnumC0695j.BROADCAST) {
                            this.f2131b.f1786aA = C0493bg.m2685a(this.f2131b.f1788aC, this.f2131b.f1787aB) + " " + this.f2131b.f1786aA;
                            this.f2131b.f1786aA = this.f2131b.m2506a(this.f2131b.f1786aA, this.f2131b.f1834aw.size());
                        }
                        C1786r.m6061b("mHoneycom_ChatTitle:" + this.f2131b.f1865bb, getClass().getSimpleName());
                        C1786r.m6061b("namelist:" + this.f2131b.f1786aA, getClass().getSimpleName());
                        if (this.f2131b.f1866bc) {
                            this.f2131b.m2511a(this.f2131b.f1865bb, TextView.BufferType.NORMAL);
                            this.f2131b.f1786aA = this.f2131b.f1865bb;
                            this.f2131b.f1866bc = false;
                        } else {
                            this.f2131b.m2511a(this.f2131b.f1786aA, TextView.BufferType.NORMAL);
                        }
                    } else {
                        int iLastIndexOf = this.f2131b.f1792aG.lastIndexOf(40);
                        if (iLastIndexOf <= 1) {
                            this.f2131b.f1786aA = this.f2131b.f1792aG;
                        } else {
                            int size = 0;
                            try {
                                if (this.f2131b.f1765F == EnumC0695j.GROUPCHAT) {
                                    size = this.f2131b.f1834aw.size() + 1;
                                } else if (this.f2131b.f1765F == EnumC0695j.BROADCAST) {
                                    size = this.f2131b.f1834aw.size();
                                }
                                StringBuilder sb = new StringBuilder();
                                sb.append(this.f2131b.f1792aG.substring(0, iLastIndexOf - 1)).append(" (").append(String.valueOf(size)).append(")");
                                this.f2131b.f1792aG = sb.toString();
                            } catch (Exception e) {
                                C1786r.m6056a(e, getClass().getSimpleName());
                            } finally {
                                this.f2131b.f1786aA = this.f2131b.f1792aG;
                                this.f2131b.m2511a(this.f2131b.f1786aA, TextView.BufferType.NORMAL);
                            }
                        }
                    }
                    cursor.close();
                }
                this.f2131b.m2586a();
                this.f2131b.m2606d();
                if (this.f2131b.f1868be) {
                    this.f2131b.m2601a(this.f2131b.f1854bQ.getStringArray("receivers"));
                    this.f2131b.f1868be = false;
                }
                this.f2131b.f1867bd = false;
                return;
            case 3:
            case 4:
            default:
                return;
            case 5:
                if (cursor != null) {
                    synchronized (this.f2131b.f1782W) {
                        zM2690b = C0493bg.m2690b(cursor, this.f2131b.f1834aw, this.f2131b.f1835ax);
                    }
                    if (TextUtils.isEmpty(this.f2131b.f1760A)) {
                        try {
                            this.f2131b.f1760A = (String) this.f2131b.f1834aw.get(0);
                            this.f2131b.f1790aE = ((C0100a) this.f2131b.f1835ax.get(this.f2131b.f1760A)).m656b();
                        } catch (Exception e2) {
                            this.f2131b.f1790aE = GlobalApplication.m3262c().getString(R.string.unknown);
                        }
                    }
                    if (zM2690b) {
                        this.f2131b.f1786aA = "";
                    }
                    if (this.f2131b.f1788aC == null) {
                        if (this.f2131b.f1792aG != null) {
                            this.f2131b.f1786aA = this.f2131b.f1792aG;
                            this.f2131b.f1792aG = null;
                        } else if (zM2690b) {
                            Iterator it = this.f2131b.f1834aw.iterator();
                            while (it.hasNext()) {
                                ChatFragment.m2504a(this.f2131b, (Object) (((C0100a) this.f2131b.f1835ax.get((String) it.next())).m656b() + ","));
                            }
                            if (this.f2131b.f1786aA.length() > 1) {
                                this.f2131b.f1786aA = this.f2131b.f1786aA.substring(0, this.f2131b.f1786aA.length() - 1);
                            }
                            if (this.f2131b.f1765F == EnumC0695j.GROUPCHAT) {
                                if (this.f2131b.f1834aw.size() <= 0) {
                                    this.f2131b.f1786aA = GlobalApplication.m3262c().getString(R.string.chat_title_no_buddies);
                                }
                                this.f2131b.f1786aA = this.f2131b.m2506a(this.f2131b.f1786aA, this.f2131b.f1834aw.size() + 1);
                            } else if (this.f2131b.f1765F == EnumC0695j.BROADCAST) {
                                this.f2131b.f1786aA = C0493bg.m2685a(this.f2131b.f1788aC, this.f2131b.f1787aB) + " " + this.f2131b.f1786aA;
                                this.f2131b.f1786aA = this.f2131b.m2506a(this.f2131b.f1786aA, this.f2131b.f1834aw.size());
                            }
                            this.f2131b.m2511a(this.f2131b.f1786aA, TextView.BufferType.NORMAL);
                        }
                    } else if (zM2690b) {
                        if (!this.f2131b.f1788aC.equals("Y") && C0660d.m3024a(this.f2131b.getActivity(), this.f2131b.f1912z)) {
                            Iterator it2 = this.f2131b.f1834aw.iterator();
                            while (it2.hasNext()) {
                                ChatFragment.m2504a(this.f2131b, (Object) (((C0100a) this.f2131b.f1835ax.get((String) it2.next())).m656b() + ","));
                            }
                            if (this.f2131b.f1786aA.length() > 1) {
                                this.f2131b.f1786aA = this.f2131b.f1786aA.substring(0, this.f2131b.f1786aA.length() - 1);
                            }
                            if (this.f2131b.f1834aw.size() <= 0) {
                                this.f2131b.f1786aA = GlobalApplication.m3262c().getString(R.string.chat_title_no_buddies);
                            }
                        } else {
                            this.f2131b.f1786aA = this.f2131b.f1787aB;
                        }
                        if (this.f2131b.f1765F == EnumC0695j.GROUPCHAT) {
                            this.f2131b.f1786aA = this.f2131b.m2506a(this.f2131b.f1786aA, this.f2131b.f1834aw.size() + 1);
                        } else if (this.f2131b.f1765F == EnumC0695j.BROADCAST) {
                            if (zM2690b) {
                                this.f2131b.f1786aA = C0493bg.m2685a(this.f2131b.f1788aC, (String) null) + this.f2131b.f1786aA;
                                this.f2131b.f1786aA = this.f2131b.m2506a(this.f2131b.f1786aA, this.f2131b.f1834aw.size());
                            } else {
                                this.f2131b.f1786aA = this.f2131b.m2506a(C0493bg.m2685a(this.f2131b.f1788aC, this.f2131b.f1787aB), this.f2131b.f1834aw.size());
                            }
                        }
                        this.f2131b.m2511a(this.f2131b.f1786aA, TextView.BufferType.NORMAL);
                    } else {
                        this.f2131b.f1786aA = this.f2131b.f1787aB;
                        if (this.f2131b.f1765F == EnumC0695j.GROUPCHAT) {
                            if (!this.f2131b.f1788aC.equals("Y") && this.f2131b.f1834aw.size() <= 0) {
                                this.f2131b.f1786aA = GlobalApplication.m3262c().getString(R.string.chat_title_no_buddies);
                            }
                            this.f2131b.f1786aA = this.f2131b.m2506a(this.f2131b.f1786aA, this.f2131b.f1834aw.size() + 1);
                        } else if (this.f2131b.f1765F == EnumC0695j.BROADCAST) {
                            if (this.f2131b.f1786aA != null) {
                                this.f2131b.f1786aA = C0493bg.m2685a(this.f2131b.f1788aC, (String) null) + this.f2131b.f1786aA;
                                this.f2131b.f1786aA = this.f2131b.m2506a(this.f2131b.f1786aA, this.f2131b.f1834aw.size());
                            } else {
                                this.f2131b.f1786aA = this.f2131b.m2506a(C0493bg.m2685a(this.f2131b.f1788aC, this.f2131b.f1787aB), this.f2131b.f1834aw.size());
                            }
                        }
                        this.f2131b.m2511a(this.f2131b.f1786aA, TextView.BufferType.NORMAL);
                    }
                    cursor.close();
                    this.f2131b.m2609g();
                }
                this.f2131b.m2586a();
                this.f2131b.m2606d();
                if (this.f2131b.f1868be) {
                    this.f2131b.m2601a(this.f2131b.f1854bQ.getStringArray("receivers"));
                    this.f2131b.f1868be = false;
                }
                this.f2131b.f1867bd = false;
                return;
            case 6:
                if (cursor != null) {
                    this.f2131b.f1793aH = 0;
                    while (cursor.moveToNext()) {
                        ChatFragment.m2534e(this.f2131b, cursor.getInt(cursor.getColumnIndex("inbox_unread_count")));
                    }
                    cursor.close();
                    this.f2131b.f1847bJ.setVisibility(0);
                    if (this.f2131b.f1793aH > 0) {
                        if (this.f2131b.f1793aH >= 100) {
                            this.f2131b.f1847bJ.setTextSize(10.0f);
                            this.f2131b.f1847bJ.setText(R.string.chat_max_unread);
                        } else {
                            this.f2131b.f1847bJ.setTextSize(12.0f);
                            this.f2131b.f1847bJ.setText(this.f2131b.f1793aH + "");
                        }
                    } else {
                        this.f2131b.f1847bJ.setVisibility(8);
                    }
                } else {
                    this.f2131b.f1847bJ.setVisibility(8);
                }
                if (cursor != null) {
                    cursor.close();
                    return;
                }
                return;
            case 7:
                if (cursor != null && cursor.getCount() != 0) {
                    cursor.moveToNext();
                    this.f2131b.f1770K.add(new C0257c(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), cursor.getString(cursor.getColumnIndex("buddy_birthday")), !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), cursor.getInt(cursor.getColumnIndex("buddy_raw_contact_id")), cursor.getString(cursor.getColumnIndex("buddy_push_name")), !cursor.getString(cursor.getColumnIndex("buddy_is_new")).equals("Y")));
                    Intent intent = new Intent(this.f2131b.getActivity(), (Class<?>) BuddyProfileActivity.class);
                    intent.putExtra("PROFILE_BUDDY_INFO", (Serializable) this.f2131b.f1770K.get(0));
                    intent.setFlags(67108864);
                    this.f2131b.startActivityForResult(intent, 20);
                }
                if (cursor != null) {
                    cursor.close();
                    return;
                }
                return;
            case 8:
                this.f2131b.f1791aF = C0493bg.m2681a(0, cursor, (Cursor) null);
                C1786r.m6064d("title:" + this.f2131b.f1791aF);
                if (cursor != null) {
                    cursor.close();
                    return;
                }
                return;
            case 9:
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    int i4 = cursor.getInt(cursor.getColumnIndex("unread_item_count"));
                    if (i4 > 0 && i4 < 100) {
                        this.f2131b.f1847bJ.setTextSize(12.0f);
                        this.f2131b.f1847bJ.setText(String.valueOf(i4));
                        this.f2131b.f1847bJ.setVisibility(0);
                    } else if (i4 >= 100) {
                        this.f2131b.f1847bJ.setTextSize(10.0f);
                        this.f2131b.f1847bJ.setText(R.string.chat_max_unread);
                        this.f2131b.f1847bJ.setVisibility(0);
                    } else {
                        this.f2131b.f1847bJ.setVisibility(8);
                    }
                }
                if (cursor != null) {
                    cursor.close();
                    return;
                }
                return;
            case 10:
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    this.f2131b.f1797aL = "Y".equals(cursor.getString(0));
                    this.f2131b.f1828aq.m2667a(this.f2131b.f1797aL);
                    String string2 = cursor.getString(1);
                    if (!TextUtils.isEmpty(string2) && !string2.equals(this.f2131b.f1766G)) {
                        this.f2131b.f1766G = string2;
                    }
                    this.f2131b.f1798aM = cursor.getLong(2);
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
                        String string3 = cursor.getString(cursor.getColumnIndex("message_content"));
                        int i5 = cursor.getInt(cursor.getColumnIndex("message_type"));
                        EnumC0699n enumC0699nM3160a = EnumC0699n.m3160a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
                        String string4 = cursor.getString(cursor.getColumnIndex("buddy_name"));
                        String string5 = cursor.getString(cursor.getColumnIndex("message_time"));
                        String string6 = cursor.getString(cursor.getColumnIndex("message_sever_id"));
                        String string7 = cursor.getString(cursor.getColumnIndex("message_sender"));
                        contentValues.put("inbox_last_message", String.format("%d;%d;%s;%s", Integer.valueOf(i5), Integer.valueOf(enumC0699nM3160a.m3162a()), C0493bg.m2684a(string3), C0493bg.m2684a(string4)));
                        contentValues.put("inbox_last_msg_no", string6);
                        contentValues.put("inbox_last_time", string5);
                        contentValues.put("inbox_last_msg_sender", string7);
                        this.f2131b.f1783X.startUpdate(4, null, C0694i.f2616a, contentValues, "inbox_no='" + this.f2131b.f1912z + "'", null);
                    }
                    cursor.close();
                    return;
                }
                contentValues.put("inbox_last_message", "");
                this.f2131b.f1783X.startUpdate(4, null, C0694i.f2616a, contentValues, "inbox_no='" + this.f2131b.f1912z + "'", null);
                return;
            case C0229at.HorizontalSrollView_android_background /* 12 */:
                long j = 0;
                long j2 = 0;
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    long j3 = cursor.getLong(cursor.getColumnIndex("message_total_count"));
                    j = cursor.getLong(cursor.getColumnIndex("message_sent_count"));
                    j2 = j3 - j;
                    this.f2131b.f1828aq.m2662a(j2);
                    this.f2131b.f1828aq.m2670b(j);
                }
                if (cursor != null) {
                    cursor.close();
                }
                this.f2131b.f1846bI.hideSoftInputFromWindow(this.f2131b.f1800aO.getWindowToken(), 0);
                this.f2131b.f1827ap.setChoiceMode(2);
                this.f2131b.f1827ap.setTranscriptMode(0);
                this.f2131b.f1902o.setVisibility(0);
                if (0 == j) {
                    this.f2131b.f1825an.setEnabled(false);
                } else {
                    this.f2131b.f1825an.setEnabled(true);
                }
                if (0 == j2) {
                    this.f2131b.f1824am.setEnabled(false);
                } else {
                    this.f2131b.f1824am.setEnabled(true);
                }
                this.f2131b.f1903p.setVisibility(0);
                this.f2131b.f1848bK.setVisibility(0);
                this.f2131b.f1904q.setVisibility(8);
                this.f2131b.f1905r.setVisibility(8);
                this.f2131b.f1852bO.setVisibility(8);
                this.f2131b.f1909w = false;
                return;
            case C0229at.HorizontalSrollView_android_padding /* 13 */:
                ChatFragment.f1743b = cursor.getCount();
                if (this.f2131b.f1797aL) {
                    if (ChatFragment.f1743b > 0) {
                        Intent intent2 = new Intent(this.f2131b.getActivity(), (Class<?>) BuddySelectActivity.class);
                        intent2.putExtra("inboxNO", this.f2131b.f1912z);
                        intent2.putExtra(ChatFragment.f1753i, this.f2131b.f1761B);
                        intent2.putExtra("chatType", this.f2131b.f1765F);
                        intent2.putExtra("ACTIVITY_PURPOSE", 5);
                        intent2.putExtra("chatType", this.f2131b.f1765F.m3146a());
                        intent2.putExtra("ACTION_PURPOSE", 6);
                        synchronized (this.f2131b.f1782W) {
                            intent2.putExtra(ChatFragment.f1749e, (String[]) this.f2131b.f1834aw.toArray(new String[this.f2131b.f1834aw.size()]));
                        }
                        this.f2131b.startActivityForResult(intent2, 4);
                        return;
                    }
                    Toast.makeText(this.f2131b.getActivity(), R.string.all_buddies_already_included_toast, 0).show();
                    this.f2131b.f1910x = false;
                    this.f2131b.f1841bD = 1;
                    return;
                }
                return;
        }
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onUpdateComplete(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p017e.p018a.InterfaceC0667k
    public void onDeleteComplete(int i, Object obj, int i2) {
        if (i == 3) {
            this.f2131b.f1827ap.setChoiceMode(0);
            this.f2131b.f1827ap.setTranscriptMode(2);
            BaseActivity.m1827a(this.f2131b, true);
            this.f2131b.f1827ap.clearChoices();
            this.f2131b.f1902o.setVisibility(8);
            this.f2131b.f1903p.setVisibility(8);
            if (GlobalApplication.m3265f()) {
                this.f2131b.f1826ao.setVisibility(8);
            }
            this.f2131b.f1848bK.setVisibility(8);
            this.f2131b.f1904q.setVisibility(0);
            this.f2131b.f1905r.setVisibility(0);
            this.f2131b.f1821aj.setEnabled(false);
            this.f2131b.f1783X.startQuery(11, null, C0698m.m3147a(), null, "message_inbox_no = ? AND ( message_type = ? OR message_type = ? ) AND message_content_type != ?", new String[]{this.f2131b.f1912z, String.valueOf(1), String.valueOf(2), String.valueOf(EnumC0699n.SYSTEM.m3162a())}, "message_is_failed , message_time , _id");
        }
    }
}
