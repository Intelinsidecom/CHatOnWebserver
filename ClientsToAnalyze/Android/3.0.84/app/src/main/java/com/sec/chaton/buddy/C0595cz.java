package com.sec.chaton.buddy;

import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.sec.chaton.C2310s;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.buddy.dialog.SpecialBuddyDialog;
import com.sec.chaton.buddy.p019a.C0511a;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p027e.C1388af;
import com.sec.chaton.p027e.C1390ah;
import com.sec.chaton.p027e.C1441i;
import com.sec.chaton.p027e.C1445m;
import com.sec.chaton.p027e.C1446n;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.p028a.C1362f;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cz */
/* loaded from: classes.dex */
public class C0595cz implements InterfaceC1378v {

    /* renamed from: a */
    public int f2557a = 1;

    /* renamed from: b */
    public int f2558b = 2;

    /* renamed from: c */
    public int f2559c = 3;

    /* renamed from: d */
    public int f2560d = 4;

    /* renamed from: e */
    public int f2561e = 5;

    /* renamed from: f */
    public int f2562f = 6;

    /* renamed from: g */
    public int f2563g = 7;

    /* renamed from: h */
    public int f2564h = 8;

    /* renamed from: i */
    public int f2565i = 9;

    /* renamed from: j */
    public int f2566j = 50;

    /* renamed from: k */
    public int f2567k = 51;

    /* renamed from: l */
    public int f2568l = 10;

    /* renamed from: m */
    public int f2569m = 20;

    /* renamed from: n */
    public int f2570n = 61;

    /* renamed from: o */
    public int f2571o = 62;

    /* renamed from: p */
    public int f2572p = 63;

    /* renamed from: q */
    public int f2573q = 64;

    /* renamed from: r */
    public int f2574r = 67;

    /* renamed from: s */
    C1377u f2575s;

    /* renamed from: t */
    final /* synthetic */ BuddyFragment f2576t;

    public C0595cz(BuddyFragment buddyFragment) {
        this.f2576t = buddyFragment;
        this.f2575s = null;
        if (this.f2575s == null) {
            this.f2575s = new C1377u(buddyFragment.getActivity().getContentResolver(), this);
        }
    }

    /* renamed from: a */
    public void m4050a() {
        this.f2575s.m6200a();
    }

    /* renamed from: a */
    public void m4052a(C0513c c0513c) {
        this.f2575s.startQuery(this.f2562f, c0513c, C1445m.f5377a, null, "group_relation_group = 1 ", null, null);
    }

    /* renamed from: b */
    public void m4055b(C0513c c0513c) {
        this.f2575s.startDelete(this.f2558b, c0513c, C1445m.f5377a, "group_relation_group = 1 AND group_relation_buddy = ? ", new String[]{c0513c.m3975b()});
    }

    /* renamed from: c */
    public void m4058c(C0513c c0513c) {
        this.f2575s.startQuery(this.f2566j, c0513c, C1390ah.f5188a, null, "buddy_no=?", new String[]{c0513c.m3975b()}, null);
    }

    /* renamed from: d */
    public void m4060d(C0513c c0513c) {
        this.f2575s.startQuery(this.f2567k, c0513c, C1390ah.f5188a, null, "buddy_no=?", new String[]{c0513c.m3975b()}, null);
    }

    /* renamed from: e */
    public void m4062e(C0513c c0513c) {
        if (c0513c.m3975b().startsWith("0999")) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_hide", "Y");
            this.f2575s.startUpdate(this.f2572p, c0513c, C1390ah.f5188a, contentValues, "buddy_no IN ( ? )", new String[]{c0513c.m3975b()});
        } else {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("buddy_is_hide", "Y");
            this.f2575s.startUpdate(this.f2572p, c0513c, C1441i.f5369a, contentValues2, "buddy_no IN ( ? )", new String[]{c0513c.m3975b()});
        }
    }

    /* renamed from: b */
    public void m4054b() {
        this.f2575s.startQuery(this.f2561e, null, C1441i.m6316i(), null, null, null, null);
    }

    /* renamed from: c */
    public void m4057c() {
        this.f2575s.startQuery(this.f2574r, null, C1441i.m6317j(), null, null, null, null);
    }

    /* renamed from: d */
    public void m4059d() {
        this.f2575s.startQuery(this.f2565i, null, C1390ah.m6245a(), null, null, null, null);
    }

    /* renamed from: e */
    public void m4061e() {
        this.f2575s.startQuery(this.f2564h, null, C1388af.m6243a(), null, null, new String[]{String.valueOf(C3159aa.m10962a().m10976a("recommend_timestamp", 0L))}, null);
    }

    /* renamed from: f */
    public void m4063f() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("buddy_is_profile_updated", "N");
        contentValues.put("buddy_is_new", "N");
        contentValues.put("buddy_is_status_updated", "N");
        this.f2575s.startUpdate(this.f2568l, null, C1441i.f5369a, contentValues, null, null);
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("isNew", "N");
        this.f2575s.startUpdate(this.f2568l, null, C1390ah.f5188a, contentValues2, null, null);
        if (C3250y.f11734b) {
            C3250y.m11450b("setNewBuddyClear", BuddyFragment.f1724a);
        }
    }

    /* renamed from: g */
    public void m4064g() {
        C3250y.m11458g("setNewGroupClear() : ", BuddyFragment.f1724a);
        ContentValues contentValues = new ContentValues();
        contentValues.put("group_is_new", "N");
        this.f2575s.startUpdate(this.f2569m, null, C1446n.f5378a, contentValues, null, null);
    }

    /* renamed from: h */
    public void m4065h() {
        this.f2575s.startQuery(this.f2573q, null, C1441i.m6315h(), null, null, null, null);
    }

    /* renamed from: a */
    public void m4051a(int i) {
        Uri uriM6308b;
        String str;
        String str2;
        String str3;
        String str4;
        int i2 = 0;
        C3250y.m11458g("getBuddyList() : sortStyle=" + i + ", range=" + this.f2576t.f1874cj, BuddyFragment.f1724a);
        String str5 = "";
        if (i == 11 || i == 12 || i == 13) {
            if (this.f2576t.f1874cj != 3) {
                if (this.f2576t.f1874cj != 4) {
                    if (this.f2576t.f1874cj != 1) {
                        if (this.f2576t.f1874cj == 2) {
                            uriM6308b = C1445m.m6323a();
                            str2 = "buddy_name COLLATE LOCALIZED ASC ";
                            str3 = "group_relation_group = " + this.f2576t.f1881f.m3960a();
                        } else {
                            uriM6308b = C1441i.m6308b();
                            if (this.f2576t.f1873ci) {
                                if (this.f2576t.f1755S != null) {
                                    String[] strArr = this.f2576t.f1755S;
                                    StringBuffer stringBuffer = new StringBuffer();
                                    if (strArr.length > 0) {
                                        String str6 = "buddy_no NOT IN ( ";
                                        while (i2 < strArr.length) {
                                            stringBuffer.append(", '" + strArr[i2] + "'");
                                            i2++;
                                        }
                                        str5 = str6 + stringBuffer.toString().substring(1) + " )";
                                    }
                                } else if (this.f2576t.f1762Z.getString("inboxNO") != null) {
                                    str5 = "buddy_no NOT IN (SELECT participants_buddy_no FROM participant WHERE participants_inbox_no = '" + this.f2576t.f1762Z.getString("inboxNO") + "')";
                                }
                            }
                            if (this.f2576t.f1791ac == 15 || this.f2576t.f1791ac == 14) {
                                if (TextUtils.isEmpty(str5)) {
                                    str = "";
                                } else {
                                    str = str5 + " AND ";
                                }
                                str5 = str + "CASE WHEN group_name IS NOT NULL AND group_type!=1 THEN 1 WHEN buddy_extra_info LIKE '%voip=1%' THEN 1 ELSE 0 END";
                            }
                            if (i == 12) {
                                str2 = "group_type, CASE WHEN group_name IS NULL THEN 1 ELSE 0 END,group_name COLLATE LOCALIZED ASC, relation_point DESC, buddy_hanzitopinyin COLLATE LOCALIZED ASC";
                                str3 = str5;
                            } else if (i == 11) {
                                str2 = "group_type, CASE WHEN group_name IS NULL THEN 1 ELSE 0 END,group_name, buddy_hanzitopinyin COLLATE LOCALIZED ASC";
                                str3 = str5;
                            } else if (i == 13) {
                                str2 = "group_type, CASE WHEN group_name IS NULL THEN 1 ELSE 0 END,group_name, buddy_name COLLATE LOCALIZED ASC";
                                str3 = str5;
                            } else {
                                str2 = null;
                                str3 = str5;
                            }
                        }
                    } else {
                        uriM6308b = C1441i.m6305a();
                        if (this.f2576t.f1873ci) {
                            if (this.f2576t.f1755S != null) {
                                String[] strArr2 = this.f2576t.f1755S;
                                StringBuffer stringBuffer2 = new StringBuffer();
                                if (strArr2.length <= 0) {
                                    str4 = "";
                                } else {
                                    String str7 = "buddy_no NOT IN ( ";
                                    while (i2 < strArr2.length) {
                                        stringBuffer2.append(", '" + strArr2[i2] + "'");
                                        i2++;
                                    }
                                    str4 = str7 + stringBuffer2.toString().substring(1) + " )";
                                }
                                str5 = str4;
                            } else if (this.f2576t.f1762Z.getString("inboxNO") != null) {
                                str5 = "buddy_no NOT IN (SELECT participants_buddy_no FROM participant WHERE participants_inbox_no = '" + this.f2576t.f1762Z.getString("inboxNO") + "')";
                            }
                        }
                        str2 = "group_type, buddy_name COLLATE LOCALIZED ASC";
                        str3 = str5;
                    }
                } else {
                    uriM6308b = C1441i.m6312e();
                    String[] strArr3 = this.f2576t.f1755S;
                    StringBuffer stringBuffer3 = new StringBuffer();
                    if (strArr3.length > 0) {
                        String str8 = "buddy_no IN ( ";
                        while (i2 < strArr3.length) {
                            stringBuffer3.append(", '" + strArr3[i2] + "'");
                            i2++;
                        }
                        str2 = "group_type, buddy_name COLLATE LOCALIZED ASC";
                        str3 = str8 + stringBuffer3.toString().substring(1) + " )";
                    } else {
                        return;
                    }
                }
            } else {
                uriM6308b = C1441i.m6311d();
                String[] strArr4 = this.f2576t.f1755S;
                StringBuffer stringBuffer4 = new StringBuffer();
                if (strArr4.length > 0) {
                    String str9 = "buddy_no IN ( ";
                    while (i2 < strArr4.length) {
                        stringBuffer4.append(", '" + strArr4[i2] + "'");
                        i2++;
                    }
                    str2 = "group_type, buddy_name COLLATE LOCALIZED ASC";
                    str3 = str9 + stringBuffer4.toString().substring(1) + " )";
                } else {
                    return;
                }
            }
        } else if (i != 21) {
            str2 = null;
            str3 = "";
            uriM6308b = null;
        } else {
            uriM6308b = C1441i.m6314g();
            str2 = "group_type, buddy_name COLLATE LOCALIZED ASC";
            str3 = "";
        }
        if (uriM6308b != null) {
            C3250y.m11458g("URI : " + uriM6308b.toString(), BuddyFragment.f1724a);
            C3250y.m11458g("WHERE : " + str3, BuddyFragment.f1724a);
            C3250y.m11458g("WHERE ARGS : " + ((Object) null), BuddyFragment.f1724a);
            C3250y.m11458g("ORDER BY : " + str2, BuddyFragment.f1724a);
        }
        this.f2575s.startQuery(i, null, uriM6308b, null, str3, null, str2);
    }

    /* renamed from: a */
    public void m4053a(String str) {
        this.f2575s.startQuery(this.f2570n, str, C1441i.m6310c(), null, "buddy_no = ? ", new String[]{str}, null);
    }

    /* renamed from: b */
    public void m4056b(String str) {
        this.f2575s.startQuery(this.f2571o, str, C1390ah.f5188a, null, "buddy_no = ? ", new String[]{str}, null);
    }

    /* renamed from: i */
    public void m4066i() {
        Uri uriM6308b = C1441i.m6308b();
        String str = "";
        String[] stringArray = this.f2576t.f1762Z.getStringArray(ChatFragment.f3489f);
        StringBuffer stringBuffer = new StringBuffer();
        if (stringArray.length > 0) {
            String str2 = "buddy_no NOT IN ( ";
            for (String str3 : stringArray) {
                stringBuffer.append(", '" + str3 + "'");
            }
            str = str2 + stringBuffer.toString().substring(1) + " )";
        }
        this.f2575s.startQuery(70, null, uriM6308b, null, str, null, "group_type, CASE WHEN group_name IS NULL THEN 1 ELSE 0 END,group_name, buddy_name COLLATE LOCALIZED ASC");
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        int i2;
        C3250y.m11458g("onQueryComplete() : " + i + ", range=" + this.f2576t.f1874cj, BuddyFragment.f1724a);
        if (this.f2576t.getActivity() != null && cursor != null) {
            this.f2576t.f1810av = false;
            this.f2576t.m3264Z();
            if (i == this.f2561e) {
                cursor.moveToFirst();
                int i3 = cursor.getInt(cursor.getColumnIndex("count"));
                cursor.close();
                this.f2576t.f1838bY = i3;
                if (!this.f2576t.f1873ci) {
                    this.f2576t.f1858bt.setHint(this.f2576t.getResources().getString(R.string.buddy_all_count, Integer.valueOf(((this.f2576t.f1838bY + this.f2576t.f1839bZ) - this.f2576t.f1865ca) - this.f2576t.f1866cb)));
                } else {
                    this.f2576t.f1858bt.setHint(R.string.buddy_list_search_hint);
                }
                this.f2576t.f1858bt.setHint(this.f2576t.getResources().getString(R.string.buddy_all_count, Integer.valueOf(((this.f2576t.f1838bY + this.f2576t.f1839bZ) - this.f2576t.f1865ca) - this.f2576t.f1866cb)));
                if ((this.f2576t.f1791ac == 3 || this.f2576t.f1791ac == 8 || this.f2576t.f1791ac == 10 || this.f2576t.f1791ac == 2 || (this.f2576t.f1791ac == 1000 && this.f2576t.f1768aF != null && this.f2576t.f1768aF.equals("voip"))) && this.f2576t.f1858bt != null) {
                    this.f2576t.f1858bt.setHint(R.string.buddy_list_search_hint);
                }
                C3250y.m11458g("BUDDY COUNT : " + ((i3 - this.f2576t.f1865ca) - this.f2576t.f1866cb) + ", " + this.f2576t.f1791ac, BuddyFragment.f1724a);
                if (i3 - this.f2576t.f1865ca > 0) {
                    this.f2576t.m3417y();
                } else {
                    if (this.f2576t.f1791ac == 1) {
                        if (!this.f2576t.f1811aw) {
                            this.f2576t.f1858bt.setVisibility(0);
                            this.f2576t.m3218C();
                            this.f2576t.m3415x();
                        }
                    } else if (this.f2576t.f1791ac != 5) {
                        if (this.f2576t.f1791ac == 6) {
                            this.f2576t.m3417y();
                        }
                    } else {
                        C3641ai.m13211a(this.f2576t.getActivity(), this.f2576t.getResources().getString(R.string.buddy_list_invite_toast_failed_nomore), 0).show();
                        Intent intent = new Intent();
                        intent.putExtra("receivers", new String[0]);
                        this.f2576t.getActivity().setResult(0, intent);
                        this.f2576t.getActivity().finish();
                    }
                    if (this.f2576t.f1830bQ != null) {
                        this.f2576t.f1830bQ.mo3453b(0);
                    }
                }
            } else if (i == this.f2565i) {
                cursor.moveToFirst();
                int i4 = cursor.getInt(cursor.getColumnIndex("count"));
                cursor.close();
                this.f2576t.f1839bZ = i4;
                if (!this.f2576t.f1873ci) {
                    if (this.f2576t.f1791ac == 3 || this.f2576t.f1791ac == 2 || this.f2576t.f1791ac == 10 || this.f2576t.f1791ac == 19 || this.f2576t.f1791ac == 15 || this.f2576t.f1791ac == 14) {
                        this.f2576t.f1858bt.setHint(this.f2576t.getResources().getString(R.string.buddy_all_count, Integer.valueOf(this.f2576t.f1838bY - this.f2576t.f1865ca)));
                    } else {
                        this.f2576t.f1858bt.setHint(this.f2576t.getResources().getString(R.string.buddy_all_count, Integer.valueOf((this.f2576t.f1838bY + this.f2576t.f1839bZ) - this.f2576t.f1865ca)));
                    }
                } else {
                    this.f2576t.f1858bt.setHint(R.string.buddy_list_search_hint);
                }
                if ((this.f2576t.f1791ac == 3 || this.f2576t.f1791ac == 8 || this.f2576t.f1791ac == 10 || this.f2576t.f1791ac == 2 || (this.f2576t.f1791ac == 1000 && this.f2576t.f1768aF != null && this.f2576t.f1768aF.equals("voip"))) && this.f2576t.f1858bt != null) {
                    this.f2576t.f1858bt.setHint(R.string.buddy_list_search_hint);
                }
                if (i4 > 0) {
                    this.f2576t.f1811aw = true;
                    this.f2576t.m3417y();
                } else {
                    this.f2576t.f1811aw = false;
                }
            } else if (i == this.f2563g) {
                if (cursor.getCount() == 0) {
                    C3250y.m11450b("GET_PARTICIPANTS : cursor is not null, but cursor count is zero", getClass().getSimpleName());
                    return;
                }
                ArrayList arrayList = new ArrayList(cursor.getCount());
                int columnIndex = cursor.getColumnIndex("participants_buddy_no");
                while (cursor.moveToNext()) {
                    if (!cursor.isNull(columnIndex)) {
                        arrayList.add(cursor.getString(columnIndex));
                    }
                }
                cursor.close();
                this.f2576t.f1755S = (String[]) arrayList.toArray(new String[arrayList.size()]);
                this.f2576t.f1804ap.m4054b();
            } else if (i == this.f2564h) {
                boolean zBooleanValue = C3159aa.m10962a().m10977a("recomned_receive", (Boolean) true).booleanValue();
                this.f2576t.f1766aD = 0;
                try {
                    cursor.moveToFirst();
                    this.f2576t.f1766aD = cursor.getInt(cursor.getColumnIndex("count"));
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (zBooleanValue) {
                        this.f2576t.m3434b(this.f2576t.f1766aD);
                    } else {
                        this.f2576t.m3434b(0);
                    }
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            } else if (i == this.f2562f) {
                int count = cursor.getCount();
                cursor.close();
                if (count >= 50) {
                    C3641ai.m13211a(this.f2576t.getActivity(), String.format(this.f2576t.getResources().getString(R.string.buddy_list_addfavorites_toast_failed_50), 50), 0).show();
                } else {
                    C0513c c0513c = (C0513c) obj;
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("group_relation_group", (Integer) 1);
                    contentValues.put("group_relation_buddy", c0513c.m3975b());
                    this.f2575s.startInsert(this.f2576t.f1804ap.f2557a, c0513c, C1445m.f5377a, contentValues);
                }
            } else if (i == this.f2566j) {
                cursor.moveToFirst();
                boolean zEquals = cursor.getString(cursor.getColumnIndex("islike")).equals("Y");
                String string = cursor.getString(cursor.getColumnIndex("likecount"));
                int i5 = (string == null || TextUtils.isEmpty(string)) ? 0 : Integer.parseInt(string);
                String string2 = cursor.getString(cursor.getColumnIndex("buddy_no"));
                cursor.close();
                if (!zEquals) {
                    new C1330h(null).m5746e(string2);
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("islike", "Y");
                    contentValues2.put("likecount", Integer.valueOf(i5 + 1));
                    this.f2575s.startUpdate(this.f2566j, obj, C1390ah.f5188a, contentValues2, "buddy_no='" + string2 + "'", null);
                }
            } else if (i == this.f2567k) {
                cursor.moveToFirst();
                boolean zEquals2 = cursor.getString(cursor.getColumnIndex("islike")).equals("Y");
                String string3 = cursor.getString(cursor.getColumnIndex("likecount"));
                int i6 = (string3 == null || TextUtils.isEmpty(string3)) ? 0 : Integer.parseInt(string3);
                String string4 = cursor.getString(cursor.getColumnIndex("buddy_no"));
                cursor.close();
                if (zEquals2) {
                    new C1330h(null).m5750f(string4);
                    ContentValues contentValues3 = new ContentValues();
                    contentValues3.put("islike", "N");
                    if (i6 > 0) {
                        contentValues3.put("likecount", Integer.valueOf(i6 - 1));
                    }
                    this.f2575s.startUpdate(this.f2567k, obj, C1390ah.f5188a, contentValues3, "buddy_no='" + string4 + "'", null);
                }
            } else if (i == this.f2571o) {
                if (cursor.getCount() <= 0) {
                    this.f2576t.m3269a(obj.toString(), (ArrayList<ArrayList<C0513c>>) this.f2576t.f1797ai);
                } else if (GlobalApplication.m6456e()) {
                    Intent intent2 = new Intent(this.f2576t.getActivity(), (Class<?>) SpecialBuddyActivity.class);
                    intent2.putExtra("specialuserid", this.f2576t.f1802an.m3975b());
                    intent2.putExtra("speicalusername", this.f2576t.f1802an.m3976c());
                    intent2.putExtra("specialBuddyAdded", true);
                    this.f2576t.startActivity(intent2);
                } else {
                    Intent intent3 = new Intent(this.f2576t.getActivity(), (Class<?>) SpecialBuddyDialog.class);
                    intent3.putExtra("specialuserid", this.f2576t.f1802an.m3975b());
                    intent3.putExtra("speicalusername", this.f2576t.f1802an.m3976c());
                    intent3.putExtra("specialBuddyAdded", true);
                    this.f2576t.startActivity(intent3);
                }
            } else if (i == this.f2570n) {
                if (cursor.getCount() > 0) {
                    if (!this.f2576t.f1812ax) {
                        if (this.f2576t.f1892w != 0) {
                            Intent intentM1226a = TabActivity.m1226a(this.f2576t.getActivity());
                            intentM1226a.putExtra("callChatList", true);
                            intentM1226a.putExtra("chatType", EnumC1450r.ONETOONE.m6342a());
                            intentM1226a.putExtra("receivers", new String[]{String.valueOf(obj)});
                            this.f2576t.startActivity(intentM1226a);
                        } else if (GlobalApplication.m6456e()) {
                            Intent intent4 = new Intent(this.f2576t.getActivity(), (Class<?>) BuddyProfileActivity.class);
                            intent4.putExtra("PROFILE_BUDDY_NO", this.f2576t.f1802an.m3975b());
                            intent4.putExtra("PROFILE_BUDDY_NAME", this.f2576t.f1802an.m3976c());
                            intent4.putExtra("ACTIVITY_PURPOSE_CALL_START_CHAT", 21);
                            intent4.putExtra("PROFILE_BUDDY_FROM_CHATINFO", this.f2576t.f1891v);
                            this.f2576t.startActivity(intent4);
                        } else {
                            Intent intent5 = new Intent(this.f2576t.getActivity(), (Class<?>) BuddyDialog.class);
                            intent5.putExtra("BUDDY_DIALOG_BUDDY_NO", this.f2576t.f1802an.m3975b());
                            intent5.putExtra("BUDDY_DIALOG_BUDDY_NAME", this.f2576t.f1802an.m3976c());
                            this.f2576t.startActivity(intent5);
                        }
                    } else {
                        Intent intentM1226a2 = TabActivity.m1226a(this.f2576t.getActivity());
                        intentM1226a2.putExtra("callChatList", true);
                        intentM1226a2.putExtra("chatType", EnumC1450r.ONETOONE.m6342a());
                        intentM1226a2.putExtra("receivers", new String[]{String.valueOf(obj)});
                        intentM1226a2.putExtra("content_type", this.f2576t.f1813ay);
                        intentM1226a2.putExtra("download_uri", this.f2576t.f1814az);
                        intentM1226a2.putExtra("sub_content", this.f2576t.f1763aA);
                        intentM1226a2.putExtra("forward_sender_name", this.f2576t.f1764aB);
                        intentM1226a2.putExtra("is_forward_mode", this.f2576t.f1842bc);
                        intentM1226a2.putExtra(C2310s.f8621e, this.f2576t.f1765aC);
                        this.f2576t.startActivity(intentM1226a2);
                    }
                } else {
                    C0513c c0513cM3269a = this.f2576t.m3269a(obj.toString(), (ArrayList<ArrayList<C0513c>>) this.f2576t.f1797ai);
                    if (GlobalApplication.m6456e()) {
                        Intent intent6 = new Intent(this.f2576t.getActivity(), (Class<?>) BuddyProfileActivity.class);
                        intent6.putExtra("PROFILE_BUDDY_NO", String.valueOf(obj.toString()));
                        intent6.putExtra("PROFILE_BUDDY_NAME", c0513cM3269a.m3976c());
                        intent6.putExtra("ACTIVITY_PURPOSE_CALL_START_CHAT", 21);
                        intent6.putExtra("PROFILE_BUDDY_FROM_CHATINFO", this.f2576t.f1891v);
                        this.f2576t.startActivity(intent6);
                    } else {
                        Intent intent7 = new Intent(this.f2576t.getActivity(), (Class<?>) BuddyDialog.class);
                        intent7.putExtra("BUDDY_DIALOG_BUDDY_NO", String.valueOf(obj.toString()));
                        if (c0513cM3269a != null) {
                            intent7.putExtra("BUDDY_DIALOG_BUDDY_NAME", c0513cM3269a.m3976c());
                        }
                        this.f2576t.startActivity(intent7);
                    }
                }
            } else if (i == 11) {
                if (this.f2576t.f1874cj == 3 || this.f2576t.f1874cj == 4) {
                    this.f2576t.m3383g(cursor);
                } else if (this.f2576t.f1874cj == 2) {
                    this.f2576t.m3385h(cursor);
                } else if (this.f2576t.f1874cj == 1) {
                    this.f2576t.m3379f(cursor);
                } else {
                    this.f2576t.m3376e(cursor);
                }
                this.f2576t.m3429a(this.f2576t.f1797ai);
                if (this.f2576t.f1791ac == 8) {
                    this.f2576t.f1757U.setVisibility(0);
                    if (this.f2576t.f1797ai.size() == 0) {
                        this.f2576t.f1738B.setVisibility(8);
                        this.f2576t.f1742F.setVisibility(8);
                        this.f2576t.f1748L.setVisibility(0);
                    } else {
                        this.f2576t.f1738B.setVisibility(0);
                        this.f2576t.f1742F.setVisibility(0);
                        this.f2576t.f1748L.setVisibility(8);
                    }
                }
                if (this.f2576t.f1796ah.size() < 1) {
                    this.f2576t.f1738B.setVisibility(8);
                    this.f2576t.f1748L.setVisibility(0);
                }
                this.f2576t.m3284a((ArrayList<C0511a>) this.f2576t.f1796ah, (ArrayList<ArrayList<C0513c>>) this.f2576t.f1797ai);
            } else if (i == 12) {
                if (this.f2576t.f1874cj == 3 || this.f2576t.f1874cj == 4) {
                    this.f2576t.m3383g(cursor);
                } else if (this.f2576t.f1874cj == 2) {
                    this.f2576t.m3385h(cursor);
                } else {
                    this.f2576t.m3387i(cursor);
                }
                if (this.f2576t.f1791ac == 8) {
                    this.f2576t.f1757U.setVisibility(0);
                    if (this.f2576t.f1797ai.size() == 0) {
                        this.f2576t.f1738B.setVisibility(8);
                        this.f2576t.f1742F.setVisibility(8);
                        this.f2576t.f1748L.setVisibility(0);
                    } else {
                        this.f2576t.f1738B.setVisibility(0);
                        this.f2576t.f1742F.setVisibility(0);
                        this.f2576t.f1748L.setVisibility(8);
                    }
                }
                this.f2576t.m3284a((ArrayList<C0511a>) this.f2576t.f1796ah, (ArrayList<ArrayList<C0513c>>) this.f2576t.f1797ai);
            } else if (i == 13) {
                if (this.f2576t.f1874cj == 3 || this.f2576t.f1874cj == 4) {
                    this.f2576t.m3383g(cursor);
                } else if (this.f2576t.f1874cj == 2) {
                    this.f2576t.m3385h(cursor);
                } else {
                    this.f2576t.m3390j(cursor);
                }
                if (this.f2576t.f1791ac == 8) {
                    if (this.f2576t.f1797ai.size() == 0) {
                        this.f2576t.f1757U.setVisibility(8);
                        this.f2576t.f1738B.setVisibility(8);
                        this.f2576t.f1742F.setVisibility(8);
                        this.f2576t.f1748L.setVisibility(0);
                    } else {
                        this.f2576t.f1757U.setVisibility(0);
                        this.f2576t.f1738B.setVisibility(0);
                        this.f2576t.f1742F.setVisibility(0);
                        this.f2576t.f1748L.setVisibility(8);
                    }
                }
                this.f2576t.m3284a((ArrayList<C0511a>) this.f2576t.f1796ah, (ArrayList<ArrayList<C0513c>>) this.f2576t.f1797ai);
            } else if (i == 21) {
                if (TextUtils.isEmpty(this.f2576t.f1858bt.m11463a().toString())) {
                    this.f2576t.f1806ar = false;
                    if (this.f2576t.f1789aa == 11) {
                        this.f2576t.f1738B.setFastScrollEnabled(true);
                    }
                    this.f2576t.f1738B.setVisibility(0);
                    this.f2576t.f1747K.setVisibility(8);
                    this.f2576t.m3284a((ArrayList<C0511a>) this.f2576t.f1796ah, (ArrayList<ArrayList<C0513c>>) this.f2576t.f1797ai);
                    this.f2576t.m3232J();
                } else {
                    this.f2576t.m3393l(cursor);
                    if (this.f2576t.f1800al.size() > 0) {
                        this.f2576t.f1738B.setVisibility(0);
                        this.f2576t.f1747K.setVisibility(8);
                    } else {
                        this.f2576t.f1738B.setVisibility(8);
                        this.f2576t.f1747K.setVisibility(0);
                    }
                    this.f2576t.m3284a((ArrayList<C0511a>) this.f2576t.f1800al, (ArrayList<ArrayList<C0513c>>) this.f2576t.f1801am);
                }
            } else if (i == 70) {
                if (cursor.getCount() <= 0) {
                    this.f2576t.f1772aJ.setText(this.f2576t.getResources().getString(R.string.buddy_list_invite_toast_failed_nomore));
                    this.f2576t.f1772aJ.setDuration(0);
                    this.f2576t.f1772aJ.show();
                } else {
                    Intent intent8 = new Intent(this.f2576t.getActivity(), (Class<?>) BuddyActivity2.class);
                    intent8.putExtra("ACTIVITY_PURPOSE", 5);
                    intent8.putExtra(ChatFragment.f3489f, this.f2576t.f1755S);
                    intent8.putExtra("chatType", this.f2576t.f1754R);
                    this.f2576t.startActivityForResult(intent8, 5);
                }
            } else if (i == this.f2573q) {
                if (cursor != null && cursor.getCount() != 0) {
                    HashMap unused = BuddyFragment.f1727bm = new HashMap();
                    cursor.moveToPosition(-1);
                    while (cursor.moveToNext()) {
                        String string5 = cursor.getString(cursor.getColumnIndex("buddy_no"));
                        BuddyFragment.f1727bm.put(string5, string5);
                    }
                }
                if (this.f2576t.f1797ai != null && BuddyFragment.f1727bm != null) {
                    Iterator it = this.f2576t.f1797ai.iterator();
                    while (it.hasNext()) {
                        Iterator it2 = ((ArrayList) it.next()).iterator();
                        while (it2.hasNext()) {
                            C0513c c0513c2 = (C0513c) it2.next();
                            if (c0513c2.m3997x()) {
                                String[] strArr = (String[]) c0513c2.m3999z().keySet().toArray(new String[0]);
                                int i7 = 0;
                                while (true) {
                                    if (i7 >= strArr.length) {
                                        i2 = 1;
                                        break;
                                    } else {
                                        if (BuddyFragment.f1727bm.get(strArr[i7]) == null) {
                                            i2 = 2;
                                            break;
                                        }
                                        i7++;
                                    }
                                }
                                c0513c2.m3971a(i2);
                            }
                        }
                    }
                    this.f2576t.m3284a((ArrayList<C0511a>) this.f2576t.f1796ah, (ArrayList<ArrayList<C0513c>>) this.f2576t.f1797ai);
                }
            } else if (i == 71 && cursor != null && cursor.getCount() != 0) {
                cursor.moveToPosition(-1);
                while (cursor.moveToNext()) {
                    String string6 = cursor.getString(0);
                    String string7 = cursor.getString(cursor.getColumnIndex("group_name"));
                    String string8 = cursor.getString(cursor.getColumnIndex("group_relation_buddy"));
                    if (!string7.equals("Favorites") && string8 == null) {
                        C1362f.m6069b(GlobalApplication.m11493l().getContentResolver(), string6);
                        C3250y.m11453c("remove garbage group " + string6 + ", name : " + string7, getClass().getSimpleName());
                    }
                }
            }
            if (i == 11 || i == 12 || i == 21 || i == 13) {
                this.f2576t.m3232J();
                if (i == 11 || i == 12 || i == 13) {
                    this.f2576t.f1738B.setFastScrollEnabled(false);
                    if (this.f2576t.f1791ac != 18) {
                        this.f2576t.f1803ao.m4041c();
                    }
                    this.f2576t.f1738B.setFastScrollEnabled(true);
                } else if (this.f2576t.f1741E != null) {
                    if (this.f2576t.f1741E.toString().length() > 0) {
                        this.f2576t.f1738B.setFastScrollEnabled(false);
                    } else {
                        this.f2576t.f1738B.setFastScrollEnabled(true);
                    }
                }
            } else if (i == this.f2574r) {
                cursor.moveToFirst();
                this.f2576t.f1865ca = cursor.getInt(cursor.getColumnIndex("count"));
                C3250y.m11450b("hide count : " + this.f2576t.f1865ca, getClass().getSimpleName());
                cursor.close();
            }
            if (this.f2576t.f1791ac == 6 && this.f2576t.f1762Z.containsKey("ACTIVITY_PURPOSE_ARG") && !this.f2576t.f1762Z.getBoolean("ACTIVITY_PURPOSE_ARG") && this.f2576t.f1749M.getVisibility() == 0) {
                this.f2576t.f1749M.setEnabled(true);
            }
            if (this.f2576t.f1748L != null) {
                if (this.f2576t.f1791ac == 1 || this.f2576t.f1791ac == 7 || this.f2576t.f1791ac == 6 || this.f2576t.f1838bY - this.f2576t.f1865ca >= 1) {
                    this.f2576t.f1748L.setVisibility(8);
                } else {
                    this.f2576t.f1748L.setVisibility(0);
                }
            }
            if (!this.f2576t.f1873ci) {
                if (this.f2576t.f1791ac == 3 || this.f2576t.f1791ac == 2 || this.f2576t.f1791ac == 15 || this.f2576t.f1791ac == 14 || this.f2576t.f1791ac == 10 || this.f2576t.f1791ac == 19) {
                    if (this.f2576t.f1858bt != null) {
                        this.f2576t.f1858bt.setHint(this.f2576t.getResources().getString(R.string.buddy_all_count, Integer.valueOf((this.f2576t.f1838bY - this.f2576t.f1865ca) - this.f2576t.f1866cb)));
                    }
                } else if (this.f2576t.f1858bt != null) {
                    this.f2576t.f1858bt.setHint(this.f2576t.getResources().getString(R.string.buddy_all_count, Integer.valueOf(((this.f2576t.f1838bY + this.f2576t.f1839bZ) - this.f2576t.f1865ca) - this.f2576t.f1866cb)));
                }
            } else if (this.f2576t.f1858bt != null) {
                if (GlobalApplication.m6456e()) {
                    this.f2576t.f1858bt.setHint(this.f2576t.getResources().getString(R.string.buddy_all_count, Integer.valueOf(((this.f2576t.f1838bY + this.f2576t.f1839bZ) - this.f2576t.f1865ca) - this.f2576t.f1866cb)));
                } else {
                    this.f2576t.f1858bt.setHint(R.string.buddy_list_search_hint);
                }
            }
            if (this.f2576t.f1791ac == 1000 && this.f2576t.f1768aF != null && this.f2576t.f1768aF.equals("voip") && this.f2576t.f1858bt != null) {
                this.f2576t.f1858bt.setHint(R.string.buddy_list_search_hint);
            }
            Log.i("VerificationLog", "ChatON Executed");
        }
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onInsertComplete(int i, Object obj, Uri uri) {
        if (this.f2576t.getActivity() != null && i == this.f2557a) {
            C0513c c0513c = (C0513c) obj;
            if (Integer.parseInt(uri.getLastPathSegment()) != -1) {
                this.f2576t.f1772aJ.setText(this.f2576t.getString(R.string.buddy_list_addfavorites_toast_success, c0513c.m3976c()));
                this.f2576t.f1772aJ.setDuration(0);
                this.f2576t.f1772aJ.show();
                this.f2576t.m3214A();
                return;
            }
            C3641ai.m13211a(this.f2576t.getActivity(), this.f2576t.getResources().getString(R.string.buddy_list_addfavorites_toast_failed), 0).show();
        }
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onUpdateComplete(int i, Object obj, int i2) {
        if (this.f2576t.getActivity() != null) {
            if (i == this.f2566j) {
                if (i2 != -1) {
                    this.f2576t.m3214A();
                }
            } else if (i == this.f2567k) {
                if (i2 != -1) {
                    this.f2576t.m3214A();
                }
            } else if (i == this.f2572p) {
                m4054b();
                C0513c c0513c = (C0513c) obj;
                C3641ai.m13211a(this.f2576t.getActivity(), String.format(this.f2576t.getResources().getString(R.string.buddy_list_hide_success), c0513c.m3976c()), 0).show();
                if (!c0513c.m3975b().startsWith("0999")) {
                    if (this.f2576t.f1802an != null) {
                        this.f2576t.f1805aq.m13054a(this.f2576t.f1802an.m3975b());
                        this.f2576t.m3427a(c0513c.m3975b(), c0513c.m3976c());
                        this.f2576t.m3428a(c0513c.m3975b(), false, c0513c.m3976c());
                    }
                    if (this.f2576t.m3444i() > 0) {
                        if (this.f2576t.f1843bd != null && this.f2576t.f1845bf != null) {
                            this.f2576t.f1843bd.setVisibility(8);
                            this.f2576t.f1845bf.setVisibility(8);
                        }
                    } else {
                        this.f2576t.m3447l();
                    }
                }
            }
            if (GlobalApplication.m6456e() && this.f2576t.f1791ac == 1) {
                if (this.f2576t.f1843bd.getVisibility() == 0 || this.f2576t.f1845bf.getVisibility() == 0) {
                    this.f2576t.f1820bF.setVisibility(0);
                } else {
                    this.f2576t.f1820bF.setVisibility(8);
                }
            }
        }
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onDeleteComplete(int i, Object obj, int i2) throws Resources.NotFoundException {
        if (this.f2576t.getActivity() != null && i == this.f2558b) {
            if (i2 != -1) {
                this.f2576t.f1772aJ.setText(R.string.buddy_list_removefavorites_toast_success);
                this.f2576t.f1772aJ.setDuration(0);
                this.f2576t.f1772aJ.show();
                this.f2576t.m3214A();
                return;
            }
            C3641ai.m13211a(this.f2576t.getActivity(), this.f2576t.getResources().getString(R.string.buddy_list_removefavorites_toast_failed), 0).show();
        }
    }
}
