package com.sec.chaton.buddy;

import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C0993ac;
import com.sec.chaton.C1071bk;
import com.sec.chaton.EnumC1005ad;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.buddy.dialog.BuddyDialog;
import com.sec.chaton.buddy.dialog.SpecialBuddyDialog;
import com.sec.chaton.buddy.p050a.C1104a;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p057e.C2228ap;
import com.sec.chaton.p057e.C2230ar;
import com.sec.chaton.p057e.C2289i;
import com.sec.chaton.p057e.C2293m;
import com.sec.chaton.p057e.C2294n;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2191e;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p065io.entry.inner.LiveGroupFollower;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ds */
/* loaded from: classes.dex */
public class C1258ds implements InterfaceC2211y {

    /* renamed from: a */
    public int f4762a = 1;

    /* renamed from: b */
    public int f4763b = 2;

    /* renamed from: c */
    public int f4764c = 3;

    /* renamed from: d */
    public int f4765d = 5;

    /* renamed from: e */
    public int f4766e = 6;

    /* renamed from: f */
    public int f4767f = 7;

    /* renamed from: g */
    public int f4768g = 8;

    /* renamed from: h */
    public int f4769h = 9;

    /* renamed from: i */
    public int f4770i = 50;

    /* renamed from: j */
    public int f4771j = 51;

    /* renamed from: k */
    public int f4772k = 10;

    /* renamed from: l */
    public int f4773l = 20;

    /* renamed from: m */
    public int f4774m = 61;

    /* renamed from: n */
    public int f4775n = 62;

    /* renamed from: o */
    public int f4776o = 63;

    /* renamed from: p */
    public int f4777p = 64;

    /* renamed from: q */
    public int f4778q = 67;

    /* renamed from: r */
    C2210x f4779r;

    /* renamed from: s */
    final /* synthetic */ BuddyFragment f4780s;

    public C1258ds(BuddyFragment buddyFragment) {
        this.f4780s = buddyFragment;
        this.f4779r = null;
        if (this.f4779r == null) {
            this.f4779r = new C2210x(buddyFragment.getActivity().getContentResolver(), this);
        }
    }

    /* renamed from: a */
    public void m7399a() {
        this.f4779r.m10064a();
    }

    /* renamed from: a */
    public void m7401a(C1106c c1106c) {
        this.f4779r.startQuery(this.f4766e, c1106c, C2293m.f8204a, null, "group_relation_group = 1 ", null, null);
    }

    /* renamed from: b */
    public void m7404b(C1106c c1106c) {
        this.f4779r.startDelete(this.f4763b, c1106c, C2293m.f8204a, "group_relation_group = 1 AND group_relation_buddy = ? ", new String[]{c1106c.m7046a()});
    }

    /* renamed from: c */
    public void m7407c(C1106c c1106c) {
        this.f4779r.startQuery(this.f4770i, c1106c, C2230ar.f7958a, null, "buddy_no=?", new String[]{c1106c.m7046a()}, null);
    }

    /* renamed from: d */
    public void m7409d(C1106c c1106c) {
        this.f4779r.startQuery(this.f4771j, c1106c, C2230ar.f7958a, null, "buddy_no=?", new String[]{c1106c.m7046a()}, null);
    }

    /* renamed from: e */
    public void m7411e(C1106c c1106c) {
        if (c1106c.m7046a().startsWith("0999")) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_hide", "Y");
            this.f4779r.startUpdate(this.f4776o, c1106c, C2230ar.f7958a, contentValues, "buddy_no IN ( ? )", new String[]{c1106c.m7046a()});
        } else {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("buddy_is_hide", "Y");
            this.f4779r.startUpdate(this.f4776o, c1106c, C2289i.f8196a, contentValues2, "buddy_no IN ( ? )", new String[]{c1106c.m7046a()});
        }
    }

    /* renamed from: b */
    public void m7403b() {
        this.f4779r.startQuery(this.f4765d, null, C2289i.m10172j(), null, null, null, null);
    }

    /* renamed from: c */
    public void m7406c() {
        this.f4779r.startQuery(this.f4778q, null, C2289i.m10173k(), null, null, null, null);
    }

    /* renamed from: d */
    public void m7408d() {
        this.f4779r.startQuery(this.f4769h, null, C2230ar.m10096a(), null, null, null, null);
    }

    /* renamed from: e */
    public void m7410e() {
        this.f4779r.startQuery(this.f4768g, null, C2228ap.m10094a(), null, null, new String[]{String.valueOf(C4809aa.m18104a().m18118a("recommend_timestamp", 0L))}, null);
    }

    /* renamed from: f */
    public void m7412f() {
        this.f4779r.startQuery(72, null, C2228ap.f7956a, null, "timestamp>" + C4809aa.m18104a().m18118a("recommend_timestamp", 0L), null, null);
    }

    /* renamed from: g */
    public void m7413g() {
        if (C4904y.f17872b) {
            C4904y.m18639b("setNewBuddyClear()", BuddyFragment.f3576a);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("buddy_is_profile_updated", "N");
        contentValues.put("buddy_is_new", "N");
        contentValues.put("buddy_is_status_updated", "N");
        this.f4779r.startUpdate(this.f4772k, null, C2289i.f8196a, contentValues, null, null);
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("isNew", "N");
        this.f4779r.startUpdate(this.f4772k, null, C2230ar.f7958a, contentValues2, null, null);
    }

    /* renamed from: h */
    public void m7414h() {
        C4904y.m18639b("setNewGroupClear() : ", BuddyFragment.f3576a);
        ContentValues contentValues = new ContentValues();
        contentValues.put("group_is_new", "N");
        this.f4779r.startUpdate(this.f4773l, null, C2294n.f8205a, contentValues, null, null);
    }

    /* renamed from: i */
    public void m7415i() {
        this.f4779r.startQuery(this.f4777p, null, C2289i.m10171i(), null, null, null, null);
    }

    /* renamed from: a */
    public void m7400a(int i) {
        Uri uriM10163b;
        String str;
        String str2;
        String str3;
        int i2 = 0;
        C4904y.m18639b("getBuddyList() : sortStyle=" + i + ", range=" + this.f4780s.f3721cA, BuddyFragment.f3576a);
        String str4 = "";
        if (i == 11 || i == 12 || i == 13) {
            if (this.f4780s.f3721cA != 3) {
                if (this.f4780s.f3721cA != 4) {
                    if (this.f4780s.f3721cA != 1) {
                        if (this.f4780s.f3721cA != 2) {
                            if (this.f4780s.f3721cA == 5) {
                                Uri uriM10163b2 = C2289i.m10163b();
                                String[] strArr = new String[this.f4780s.f3692bW.size()];
                                for (int i3 = 0; i3 < this.f4780s.f3692bW.size(); i3++) {
                                    strArr[i3] = ((LiveGroupFollower) this.f4780s.f3692bW.get(i3)).chatonid;
                                }
                                StringBuffer stringBuffer = new StringBuffer();
                                if (strArr.length > 0) {
                                    String str5 = "buddy_no IN ( ";
                                    while (i2 < strArr.length) {
                                        stringBuffer.append(", '" + strArr[i2] + "'");
                                        i2++;
                                    }
                                    str2 = "group_type, buddy_name COLLATE LOCALIZED ASC";
                                    str3 = str5 + stringBuffer.toString().substring(1) + " )";
                                    uriM10163b = uriM10163b2;
                                } else {
                                    return;
                                }
                            } else {
                                if (this.f4780s.getActivity().getIntent().getStringExtra("fromsms") != null) {
                                    uriM10163b = C2289i.m10165c();
                                } else {
                                    uriM10163b = C2289i.m10163b();
                                }
                                if (this.f4780s.f3762cz) {
                                    if (this.f4780s.f3648ac != null) {
                                        String[] strArr2 = this.f4780s.f3648ac;
                                        StringBuffer stringBuffer2 = new StringBuffer();
                                        if (strArr2.length > 0) {
                                            String str6 = "buddy_no NOT IN ( ";
                                            while (i2 < strArr2.length) {
                                                stringBuffer2.append(", '" + strArr2[i2] + "'");
                                                i2++;
                                            }
                                            str4 = str6 + stringBuffer2.toString().substring(1) + " )";
                                        }
                                    } else if (this.f4780s.f3657al.getString("inboxNO") != null) {
                                        str4 = "buddy_no NOT IN (SELECT participants_buddy_no FROM participant WHERE participants_inbox_no = '" + this.f4780s.f3657al.getString("inboxNO") + "')";
                                    }
                                }
                                if (this.f4780s.f3660ao == 15 || this.f4780s.f3660ao == 14) {
                                    if (TextUtils.isEmpty(str4)) {
                                        str = "";
                                    } else {
                                        str = str4 + " AND ";
                                    }
                                    str4 = str + "CASE WHEN group_name IS NOT NULL AND group_type!=1 THEN 1 WHEN buddy_extra_info LIKE '%voip=1%' THEN 1 ELSE 0 END";
                                }
                                if (i == 12) {
                                    str2 = "group_type, CASE WHEN group_name IS NULL THEN 1 ELSE 0 END,group_name COLLATE LOCALIZED ASC, relation_point DESC, buddy_hanzitopinyin COLLATE LOCALIZED ASC";
                                    str3 = str4;
                                } else if (i == 11) {
                                    str2 = "group_type, CASE WHEN group_name IS NULL THEN 1 ELSE 0 END,group_name, buddy_hanzitopinyin COLLATE LOCALIZED ASC";
                                    str3 = str4;
                                } else if (i == 13) {
                                    str2 = "group_type, CASE WHEN group_name IS NULL THEN 1 ELSE 0 END,group_name, buddy_name COLLATE LOCALIZED ASC";
                                    str3 = str4;
                                } else {
                                    str2 = null;
                                    str3 = str4;
                                }
                            }
                        } else {
                            uriM10163b = C2293m.m10179a();
                            str2 = "buddy_name COLLATE LOCALIZED ASC ";
                            str3 = "group_relation_group = " + this.f4780s.f3763f.m7034a();
                        }
                    } else {
                        uriM10163b = C2289i.m10160a();
                        if (this.f4780s.f3762cz) {
                            if (this.f4780s.f3648ac != null) {
                                String[] strArr3 = this.f4780s.f3648ac;
                                StringBuffer stringBuffer3 = new StringBuffer();
                                if (strArr3.length > 0) {
                                    String str7 = "buddy_no NOT IN ( ";
                                    while (i2 < strArr3.length) {
                                        stringBuffer3.append(", '" + strArr3[i2] + "'");
                                        i2++;
                                    }
                                    str4 = str7 + stringBuffer3.toString().substring(1) + " )";
                                }
                            } else if (this.f4780s.f3657al.getString("inboxNO") != null) {
                                str4 = "buddy_no NOT IN (SELECT participants_buddy_no FROM participant WHERE participants_inbox_no = '" + this.f4780s.f3657al.getString("inboxNO") + "')";
                            }
                        }
                        str2 = "group_type, buddy_name COLLATE LOCALIZED ASC";
                        str3 = str4;
                    }
                } else {
                    uriM10163b = C2289i.m10168f();
                    String[] strArr4 = this.f4780s.f3648ac;
                    StringBuffer stringBuffer4 = new StringBuffer();
                    if (strArr4.length > 0) {
                        String str8 = "buddy_no IN ( ";
                        while (i2 < strArr4.length) {
                            stringBuffer4.append(", '" + strArr4[i2] + "'");
                            i2++;
                        }
                        str2 = "group_type, buddy_name COLLATE LOCALIZED ASC";
                        str3 = str8 + stringBuffer4.toString().substring(1) + " )";
                    } else {
                        return;
                    }
                }
            } else {
                uriM10163b = C2289i.m10167e();
                String[] strArr5 = this.f4780s.f3648ac;
                StringBuffer stringBuffer5 = new StringBuffer();
                if (strArr5.length > 0) {
                    String str9 = "buddy_no IN ( ";
                    for (String str10 : strArr5) {
                        stringBuffer5.append(", '" + str10 + "'");
                    }
                    str2 = "group_type, buddy_name COLLATE LOCALIZED ASC";
                    str3 = str9 + stringBuffer5.toString().substring(1) + " )";
                } else {
                    return;
                }
            }
        } else if (i != 21) {
            str2 = null;
            str3 = "";
            uriM10163b = null;
        } else {
            Uri uriM10170h = C2289i.m10170h();
            if (this.f4780s.f3721cA == 5) {
                String[] strArr6 = new String[this.f4780s.f3692bW.size()];
                for (int i4 = 0; i4 < this.f4780s.f3692bW.size(); i4++) {
                    strArr6[i4] = ((LiveGroupFollower) this.f4780s.f3692bW.get(i4)).chatonid;
                }
                StringBuffer stringBuffer6 = new StringBuffer();
                if (strArr6.length > 0) {
                    String str11 = "buddy_no IN ( ";
                    while (i2 < strArr6.length) {
                        stringBuffer6.append(", '" + strArr6[i2] + "'");
                        i2++;
                    }
                    str4 = str11 + stringBuffer6.toString().substring(1) + " )";
                } else {
                    return;
                }
            }
            str2 = "group_type, buddy_name COLLATE LOCALIZED ASC";
            str3 = str4;
            uriM10163b = uriM10170h;
        }
        if (uriM10163b != null) {
            C4904y.m18639b("URI : " + uriM10163b.toString(), BuddyFragment.f3576a);
            C4904y.m18639b("WHERE : " + str3, BuddyFragment.f3576a);
            C4904y.m18639b("WHERE ARGS : " + ((Object) null), BuddyFragment.f3576a);
            C4904y.m18639b("ORDER BY : " + str2, BuddyFragment.f3576a);
        }
        this.f4779r.startQuery(i, null, uriM10163b, null, str3, null, str2);
    }

    /* renamed from: a */
    public void m7402a(String str) {
        this.f4779r.startQuery(this.f4774m, str, C2289i.m10166d(), null, "buddy_no = ? ", new String[]{str}, null);
    }

    /* renamed from: b */
    public void m7405b(String str) {
        this.f4779r.startQuery(this.f4775n, str, C2230ar.f7958a, null, "buddy_no = ? ", new String[]{str}, null);
    }

    /* renamed from: j */
    public void m7416j() {
        Uri uriM10163b = C2289i.m10163b();
        String str = "";
        String[] stringArray = this.f4780s.f3657al.getStringArray(ChatFragment.f5465d);
        StringBuffer stringBuffer = new StringBuffer();
        if (stringArray.length > 0) {
            String str2 = "buddy_no NOT IN ( ";
            for (String str3 : stringArray) {
                stringBuffer.append(", '" + str3 + "'");
            }
            str = str2 + stringBuffer.toString().substring(1) + " )";
        }
        this.f4779r.startQuery(70, null, uriM10163b, null, str, null, "group_type, CASE WHEN group_name IS NULL THEN 1 ELSE 0 END,group_name, buddy_name COLLATE LOCALIZED ASC");
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) throws Resources.NotFoundException {
        int i2;
        C4904y.m18639b("onQueryComplete() : " + i + ", range=" + this.f4780s.f3721cA, BuddyFragment.f3576a);
        this.f4780s.f3690bU = false;
        this.f4780s.f3691bV = -1;
        Iterator it = this.f4780s.f3665at.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (((C1104a) it.next()).m7030d() == 1) {
                this.f4780s.f3690bU = true;
                this.f4780s.f3691bV = i3;
                break;
            }
            i3++;
        }
        if (this.f4780s.getActivity() != null && cursor != null) {
            this.f4780s.f3628aI = false;
            this.f4780s.m6327W();
            if (this.f4780s.f3660ao == 1) {
                if (this.f4780s.m6605h() > 0) {
                    BuddyFragment.f3585k = true;
                } else {
                    BuddyFragment.f3585k = false;
                }
            }
            if (i == this.f4765d) {
                cursor.moveToFirst();
                int i4 = cursor.getInt(cursor.getColumnIndex(VKApiConst.COUNT));
                this.f4780s.m6554n(cursor);
                this.f4780s.f3750cn = i4;
                if (!this.f4780s.f3762cz) {
                    this.f4780s.f3687bR.setText(this.f4780s.getResources().getString(R.string.buddy_list_total_contacts, Integer.valueOf(((this.f4780s.f3750cn + this.f4780s.f3751co) - this.f4780s.f3752cp) - this.f4780s.f3753cq)));
                } else {
                    this.f4780s.f3687bR.setText(this.f4780s.getResources().getString(R.string.buddy_list_total_contacts, Integer.valueOf(((this.f4780s.f3750cn + this.f4780s.f3751co) - this.f4780s.f3752cp) - this.f4780s.f3753cq)));
                }
                this.f4780s.f3687bR.setText(this.f4780s.getResources().getString(R.string.buddy_list_total_contacts, Integer.valueOf(((this.f4780s.f3750cn + this.f4780s.f3751co) - this.f4780s.f3752cp) - this.f4780s.f3753cq)));
                if ((this.f4780s.f3660ao == 3 || this.f4780s.f3660ao == 8 || this.f4780s.f3660ao == 10 || this.f4780s.f3660ao == 2 || (this.f4780s.f3660ao == 1000 && this.f4780s.f3638aS != null && this.f4780s.f3638aS.equals("voip"))) && this.f4780s.f3677bF != null) {
                    this.f4780s.f3687bR.setText(this.f4780s.getResources().getString(R.string.buddy_list_total_contacts, Integer.valueOf(((this.f4780s.f3750cn + this.f4780s.f3751co) - this.f4780s.f3752cp) - this.f4780s.f3753cq)));
                }
                C4904y.m18639b("BUDDY COUNT : " + ((i4 - this.f4780s.f3752cp) - this.f4780s.f3753cq) + ", " + this.f4780s.f3660ao, BuddyFragment.f3576a);
                if (i4 - this.f4780s.f3752cp > 0) {
                    this.f4780s.m6569v();
                } else {
                    if (this.f4780s.f3660ao == 1) {
                        if (!this.f4780s.f3629aJ) {
                            this.f4780s.f3677bF.setVisibility(0);
                            if (C4822an.m18218a()) {
                                this.f4780s.m6577z();
                            }
                            this.f4780s.m6567u();
                        }
                    } else if (this.f4780s.f3660ao != 5) {
                        if (this.f4780s.f3660ao == 6 || this.f4780s.f3660ao == 23) {
                            this.f4780s.m6569v();
                        }
                    } else {
                        C5179v.m19811a(this.f4780s.getActivity(), this.f4780s.getResources().getString(R.string.buddy_list_invite_toast_failed_nomore), 0).show();
                        Intent intent = new Intent();
                        intent.putExtra("receivers", new String[0]);
                        this.f4780s.getActivity().setResult(0, intent);
                        this.f4780s.getActivity().finish();
                    }
                    if (this.f4780s.f3742cf != null) {
                        this.f4780s.f3742cf.mo6199b(0);
                    }
                }
                this.f4780s.m6427am();
            } else if (i == this.f4769h) {
                cursor.moveToFirst();
                int i5 = cursor.getInt(cursor.getColumnIndex(VKApiConst.COUNT));
                this.f4780s.m6554n(cursor);
                this.f4780s.f3751co = i5;
                if (!this.f4780s.f3762cz) {
                    if (this.f4780s.f3660ao == 3 || this.f4780s.f3660ao == 2 || this.f4780s.f3660ao == 10 || this.f4780s.f3660ao == 19 || this.f4780s.f3660ao == 15 || this.f4780s.f3660ao == 14) {
                        this.f4780s.f3687bR.setText(this.f4780s.getResources().getString(R.string.buddy_list_total_contacts, Integer.valueOf(this.f4780s.f3750cn - this.f4780s.f3752cp)));
                    } else {
                        this.f4780s.f3687bR.setText(this.f4780s.getResources().getString(R.string.buddy_list_total_contacts, Integer.valueOf((this.f4780s.f3750cn + this.f4780s.f3751co) - this.f4780s.f3752cp)));
                    }
                } else {
                    this.f4780s.f3687bR.setText(this.f4780s.getResources().getString(R.string.buddy_list_total_contacts, Integer.valueOf(((this.f4780s.f3750cn + this.f4780s.f3751co) - this.f4780s.f3752cp) - this.f4780s.f3753cq)));
                }
                if ((this.f4780s.f3660ao == 3 || this.f4780s.f3660ao == 8 || this.f4780s.f3660ao == 10 || this.f4780s.f3660ao == 2 || (this.f4780s.f3660ao == 1000 && this.f4780s.f3638aS != null && this.f4780s.f3638aS.equals("voip"))) && this.f4780s.f3677bF != null) {
                    this.f4780s.f3687bR.setText(this.f4780s.getResources().getString(R.string.buddy_list_total_contacts, Integer.valueOf(((this.f4780s.f3750cn + this.f4780s.f3751co) - this.f4780s.f3752cp) - this.f4780s.f3753cq)));
                }
                if (i5 > 0) {
                    this.f4780s.f3629aJ = true;
                    this.f4780s.m6569v();
                } else {
                    this.f4780s.f3629aJ = false;
                }
                this.f4780s.m6427am();
            } else if (i == this.f4767f) {
                if (cursor.getCount() == 0) {
                    C4904y.m18639b("GET_PARTICIPANTS : cursor is not null, but cursor count is zero", getClass().getSimpleName());
                    return;
                }
                ArrayList arrayList = new ArrayList(cursor.getCount());
                int columnIndex = cursor.getColumnIndex("participants_buddy_no");
                while (cursor.moveToNext()) {
                    if (!cursor.isNull(columnIndex)) {
                        arrayList.add(cursor.getString(columnIndex));
                    }
                }
                this.f4780s.m6554n(cursor);
                this.f4780s.f3648ac = (String[]) arrayList.toArray(new String[arrayList.size()]);
                this.f4780s.m6440at();
                this.f4780s.f3621aB.m7403b();
            } else if (i == this.f4768g) {
                boolean zBooleanValue = C4809aa.m18104a().m18119a("recomned_receive", (Boolean) true).booleanValue();
                this.f4780s.f3636aQ = 0;
                try {
                    cursor.moveToFirst();
                    this.f4780s.f3636aQ = cursor.getInt(cursor.getColumnIndex(VKApiConst.COUNT));
                    if (cursor != null) {
                        this.f4780s.m6554n(cursor);
                    }
                    if (zBooleanValue) {
                        this.f4780s.m6594b(this.f4780s.f3636aQ);
                    } else {
                        this.f4780s.m6594b(0);
                    }
                } finally {
                    if (cursor != null) {
                        this.f4780s.m6554n(cursor);
                    }
                }
            } else if (i == this.f4766e) {
                int count = cursor.getCount();
                this.f4780s.m6554n(cursor);
                C4904y.m18639b("favorites count : " + count, getClass().getSimpleName());
                if (count >= 50) {
                    C5179v.m19811a(this.f4780s.getActivity(), String.format(this.f4780s.getResources().getString(R.string.contact_list_addfavorites_toast_failed_50), 50), 0).show();
                } else {
                    C1106c c1106c = (C1106c) obj;
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("group_relation_group", (Integer) 1);
                    contentValues.put("group_relation_buddy", c1106c.m7046a());
                    this.f4779r.startInsert(this.f4780s.f3621aB.f4762a, c1106c, C2293m.f8204a, contentValues);
                }
                if (!TextUtils.isEmpty(this.f4780s.f3677bF.m18658a().toString())) {
                    this.f4780s.m6548k(((C1106c) obj).m7046a());
                } else {
                    C0991aa.m6037a().m18962d(new C0993ac(EnumC1005ad.ADD_FAVORITE, ((C1106c) obj).m7046a()));
                }
            } else if (i == this.f4770i) {
                cursor.moveToFirst();
                boolean zEquals = cursor.getString(cursor.getColumnIndex("islike")).equals("Y");
                String string = cursor.getString(cursor.getColumnIndex("likecount"));
                int i6 = (string == null || TextUtils.isEmpty(string)) ? 0 : Integer.parseInt(string);
                String string2 = cursor.getString(cursor.getColumnIndex("buddy_no"));
                this.f4780s.m6554n(cursor);
                if (!zEquals) {
                    new C2128i(null).m9519d(string2);
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("islike", "Y");
                    contentValues2.put("likecount", Integer.valueOf(i6 + 1));
                    this.f4779r.startUpdate(this.f4770i, obj, C2230ar.f7958a, contentValues2, "buddy_no='" + string2 + "'", null);
                    C1113ad unused = this.f4780s.f3620aA;
                    C1113ad.m7113f(string2);
                }
            } else if (i == this.f4771j) {
                cursor.moveToFirst();
                boolean zEquals2 = cursor.getString(cursor.getColumnIndex("islike")).equals("Y");
                String string3 = cursor.getString(cursor.getColumnIndex("likecount"));
                int i7 = (string3 == null || TextUtils.isEmpty(string3)) ? 0 : Integer.parseInt(string3);
                String string4 = cursor.getString(cursor.getColumnIndex("buddy_no"));
                this.f4780s.m6554n(cursor);
                if (zEquals2) {
                    new C2128i(null).m9524e(string4);
                    ContentValues contentValues3 = new ContentValues();
                    contentValues3.put("islike", "N");
                    if (i7 > 0) {
                        contentValues3.put("likecount", Integer.valueOf(i7 - 1));
                    }
                    this.f4779r.startUpdate(this.f4771j, obj, C2230ar.f7958a, contentValues3, "buddy_no='" + string4 + "'", null);
                    C1113ad unused2 = this.f4780s.f3620aA;
                    C1113ad.m7114g(string4);
                }
            } else if (i == this.f4775n) {
                if (cursor.getCount() <= 0) {
                    this.f4780s.m6341a(obj.toString(), (ArrayList<ArrayList<C1106c>>) this.f4780s.f3666au);
                } else {
                    Intent intent2 = new Intent(this.f4780s.getActivity(), (Class<?>) SpecialBuddyDialog.class);
                    intent2.putExtra("specialuserid", this.f4780s.f3671az.m7046a());
                    intent2.putExtra("speicalusername", this.f4780s.f3671az.m7051b());
                    intent2.putExtra("specialBuddyAdded", true);
                    this.f4780s.startActivityForResult(intent2, 101);
                }
            } else if (i == this.f4774m) {
                if (cursor.getCount() > 0) {
                    if (!this.f4780s.f3630aK) {
                        if (this.f4780s.f3595B != 0) {
                            if (this.f4780s.m6341a(obj.toString(), (ArrayList<ArrayList<C1106c>>) this.f4780s.f3666au).m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                                this.f4780s.startActivity(this.f4780s.m6424al());
                            } else {
                                Intent intent3 = new Intent(this.f4780s.getActivity(), (Class<?>) ChatActivity.class);
                                intent3.setFlags(67108864);
                                intent3.putExtra(ChatFragment.f5473i, true);
                                intent3.putExtra("chatType", EnumC2300t.ONETOONE.m10210a());
                                intent3.putExtra("receivers", new String[]{String.valueOf(obj)});
                                this.f4780s.startActivity(intent3);
                                if (this.f4780s.getActivity() != null && !this.f4780s.f3707bl) {
                                    this.f4780s.getActivity().finish();
                                }
                            }
                        } else {
                            Intent intent4 = new Intent(this.f4780s.getActivity(), (Class<?>) BuddyDialog.class);
                            intent4.putExtra("BUDDY_DIALOG_BUDDY_NO", this.f4780s.f3671az.m7046a());
                            intent4.putExtra("BUDDY_DIALOG_BUDDY_NAME", this.f4780s.f3671az.m7051b());
                            this.f4780s.startActivity(intent4);
                        }
                    } else {
                        if (this.f4780s.m6341a(obj.toString(), (ArrayList<ArrayList<C1106c>>) this.f4780s.f3666au).m7043F().compareTo(Spam.ACTIVITY_REPORT) == 0) {
                            this.f4780s.startActivity(this.f4780s.m6424al());
                        } else {
                            Intent intentM3014a = TabActivity.m3014a(this.f4780s.getActivity());
                            intentM3014a.putExtra("callChatList", true);
                            intentM3014a.putExtra("chatType", EnumC2300t.ONETOONE.m10210a());
                            intentM3014a.putExtra("receivers", new String[]{String.valueOf(obj)});
                            intentM3014a.putExtra("content_type", this.f4780s.f3631aL);
                            intentM3014a.putExtra("download_uri", this.f4780s.f3632aM);
                            intentM3014a.putExtra("sub_content", this.f4780s.f3633aN);
                            intentM3014a.putExtra("forward_sender_name", this.f4780s.f3634aO);
                            intentM3014a.putExtra("is_forward_mode", this.f4780s.f3711bp);
                            intentM3014a.putExtra("forward_chat_message", this.f4780s.f3712bq);
                            intentM3014a.putExtra(C1071bk.f3371e, this.f4780s.f3635aP);
                            this.f4780s.startActivity(intentM3014a);
                        }
                    }
                } else {
                    C1106c c1106cM6341a = this.f4780s.m6341a(obj.toString(), (ArrayList<ArrayList<C1106c>>) this.f4780s.f3666au);
                    Intent intent5 = new Intent(this.f4780s.getActivity(), (Class<?>) BuddyDialog.class);
                    intent5.putExtra("BUDDY_DIALOG_BUDDY_NO", String.valueOf(obj.toString()));
                    if (c1106cM6341a != null) {
                        intent5.putExtra("BUDDY_DIALOG_BUDDY_NAME", c1106cM6341a.m7051b());
                    }
                    this.f4780s.startActivity(intent5);
                }
            } else if (i == 11) {
                if (this.f4780s.f3721cA == 3 || this.f4780s.f3721cA == 4) {
                    this.f4780s.m6530h(cursor);
                } else if (this.f4780s.f3721cA == 2) {
                    this.f4780s.m6537i(cursor);
                } else if (this.f4780s.f3721cA == 1) {
                    this.f4780s.m6524g(cursor);
                } else if (this.f4780s.f3721cA == 5) {
                    this.f4780s.m6452b(cursor, false);
                } else {
                    this.f4780s.m6515f(cursor);
                }
                this.f4780s.m6589a(this.f4780s.f3666au);
                if (this.f4780s.f3660ao == 8) {
                    this.f4780s.f3650ae.setVisibility(0);
                    if (this.f4780s.f3666au.size() == 0) {
                        this.f4780s.f3602I.setVisibility(8);
                        this.f4780s.m6351a(this.f4780s.f3606M);
                    } else {
                        this.f4780s.f3602I.setVisibility(0);
                        this.f4780s.m6423ak();
                    }
                }
                if (this.f4780s.f3665at.size() < 1 && this.f4780s.f3660ao == 7) {
                    this.f4780s.f3602I.setVisibility(8);
                    if (!this.f4780s.f3714bs || !this.f4780s.f3715bt || this.f4780s.f3716bu) {
                        if (!this.f4780s.f3714bs || !this.f4780s.f3715bt || !this.f4780s.f3716bu) {
                            this.f4780s.f3611R.setVisibility(8);
                            this.f4780s.f3613T.setVisibility(8);
                            this.f4780s.m6351a(this.f4780s.f3606M);
                        } else {
                            this.f4780s.f3611R.setVisibility(8);
                            this.f4780s.f3613T.setVisibility(0);
                            this.f4780s.f3614U.setEnabled(true);
                            this.f4780s.m6351a(this.f4780s.f3606M);
                        }
                    } else {
                        if (this.f4780s.f3607N != null) {
                            this.f4780s.f3607N.setVisibility(8);
                        }
                        this.f4780s.f3611R.setVisibility(0);
                        this.f4780s.f3612S.setBackgroundResource(R.drawable.upgrade_info_character);
                        this.f4780s.f3613T.setVisibility(0);
                        this.f4780s.f3614U.setEnabled(true);
                    }
                }
                this.f4780s.m6371a((ArrayList<C1104a>) this.f4780s.f3665at, (ArrayList<ArrayList<C1106c>>) this.f4780s.f3666au);
            } else if (i == 12) {
                if (this.f4780s.f3721cA == 3 || this.f4780s.f3721cA == 4) {
                    this.f4780s.m6530h(cursor);
                } else if (this.f4780s.f3721cA != 2 && this.f4780s.f3721cA != 5) {
                    this.f4780s.m6543j(cursor);
                } else {
                    this.f4780s.m6537i(cursor);
                }
                if (this.f4780s.f3660ao == 8) {
                    this.f4780s.f3650ae.setVisibility(0);
                    if (this.f4780s.f3666au.size() == 0) {
                        this.f4780s.f3602I.setVisibility(8);
                        this.f4780s.m6351a(this.f4780s.f3606M);
                    } else {
                        this.f4780s.f3602I.setVisibility(0);
                        this.f4780s.m6423ak();
                    }
                }
                this.f4780s.m6371a((ArrayList<C1104a>) this.f4780s.f3665at, (ArrayList<ArrayList<C1106c>>) this.f4780s.f3666au);
            } else if (i == 13) {
                if (this.f4780s.f3721cA == 3 || this.f4780s.f3721cA == 4) {
                    this.f4780s.m6530h(cursor);
                } else if (this.f4780s.f3721cA == 2) {
                    this.f4780s.m6537i(cursor);
                } else if (this.f4780s.f3721cA == 5) {
                    this.f4780s.m6452b(cursor, false);
                } else {
                    this.f4780s.m6547k(cursor);
                }
                if (this.f4780s.f3660ao == 8) {
                    if (this.f4780s.f3666au.size() == 0) {
                        this.f4780s.f3650ae.setVisibility(8);
                        this.f4780s.f3602I.setVisibility(8);
                        this.f4780s.m6351a(this.f4780s.f3606M);
                    } else {
                        this.f4780s.f3650ae.setVisibility(0);
                        this.f4780s.f3602I.setVisibility(0);
                        this.f4780s.m6423ak();
                    }
                }
                this.f4780s.m6371a((ArrayList<C1104a>) this.f4780s.f3665at, (ArrayList<ArrayList<C1106c>>) this.f4780s.f3666au);
            } else if (i == 21) {
                if (this.f4780s.f3677bF != null) {
                    if (!TextUtils.isEmpty(this.f4780s.f3677bF.m18658a().toString())) {
                        this.f4780s.m6552m(cursor);
                        if (this.f4780s.f3669ax.size() > 0) {
                            this.f4780s.f3602I.setVisibility(0);
                            this.f4780s.f3615V.setVisibility(8);
                        } else {
                            this.f4780s.f3602I.setVisibility(8);
                            this.f4780s.f3615V.setVisibility(0);
                        }
                        this.f4780s.m6371a((ArrayList<C1104a>) this.f4780s.f3669ax, (ArrayList<ArrayList<C1106c>>) this.f4780s.f3670ay);
                    } else {
                        if (this.f4780s.f3765h) {
                            this.f4780s.m6550l(cursor);
                            this.f4780s.f3765h = false;
                        }
                        if (this.f4780s.f3708bm == null || this.f4780s.f3708bm.size() == 0) {
                            this.f4780s.m6550l(cursor);
                        }
                        this.f4780s.f3623aD = false;
                        if (this.f4780s.f3658am == 11) {
                            this.f4780s.f3602I.setFastScrollEnabled(true);
                        }
                        this.f4780s.f3602I.setVisibility(0);
                        this.f4780s.f3615V.setVisibility(8);
                        this.f4780s.m6371a((ArrayList<C1104a>) this.f4780s.f3665at, (ArrayList<ArrayList<C1106c>>) this.f4780s.f3666au);
                        this.f4780s.m6293F();
                    }
                } else {
                    return;
                }
            } else if (i == 70) {
                if (cursor.getCount() <= 0) {
                    this.f4780s.f3642aW.setText(this.f4780s.getResources().getString(R.string.buddy_list_invite_toast_failed_nomore));
                    this.f4780s.f3642aW.setDuration(0);
                    this.f4780s.f3642aW.show();
                } else {
                    Intent intent6 = new Intent(this.f4780s.getActivity(), (Class<?>) BuddyActivity2.class);
                    intent6.putExtra("ACTIVITY_PURPOSE", 5);
                    intent6.putExtra(ChatFragment.f5465d, this.f4780s.f3648ac);
                    intent6.putExtra("chatType", this.f4780s.f3647ab);
                    this.f4780s.startActivityForResult(intent6, 5);
                }
            } else if (i == this.f4777p) {
                if (cursor != null && cursor.getCount() != 0) {
                    HashMap unused3 = BuddyFragment.f3580by = new HashMap();
                    cursor.moveToPosition(-1);
                    while (cursor.moveToNext()) {
                        String string5 = cursor.getString(cursor.getColumnIndex("buddy_no"));
                        BuddyFragment.f3580by.put(string5, string5);
                    }
                }
                if (this.f4780s.f3666au != null && BuddyFragment.f3580by != null) {
                    Iterator it2 = this.f4780s.f3666au.iterator();
                    while (it2.hasNext()) {
                        Iterator it3 = ((ArrayList) it2.next()).iterator();
                        while (it3.hasNext()) {
                            C1106c c1106c2 = (C1106c) it3.next();
                            if (c1106c2.m7074w()) {
                                String[] strArr = (String[]) c1106c2.m7076y().keySet().toArray(new String[0]);
                                int i8 = 0;
                                while (true) {
                                    if (i8 >= strArr.length) {
                                        i2 = 1;
                                        break;
                                    } else {
                                        if (BuddyFragment.f3580by.get(strArr[i8]) == null) {
                                            i2 = 2;
                                            break;
                                        }
                                        i8++;
                                    }
                                }
                                c1106c2.m7047a(i2);
                            }
                        }
                    }
                    this.f4780s.m6371a((ArrayList<C1104a>) this.f4780s.f3665at, (ArrayList<ArrayList<C1106c>>) this.f4780s.f3666au);
                }
            } else if (i == 71) {
                if (cursor != null && cursor.getCount() != 0) {
                    cursor.moveToPosition(-1);
                    while (cursor.moveToNext()) {
                        String string6 = cursor.getString(0);
                        String string7 = cursor.getString(cursor.getColumnIndex("group_name"));
                        String string8 = cursor.getString(cursor.getColumnIndex("group_relation_buddy"));
                        if (!string7.equals("Favorites") && string8 == null) {
                            C2191e.m9862b(GlobalApplication.m18732r().getContentResolver(), string6);
                            C4904y.m18641c("remove garbage group " + string6 + ", name : " + string7, getClass().getSimpleName());
                        }
                    }
                }
            } else if (i == 72) {
                if (cursor != null) {
                    try {
                        if (cursor.getCount() != 0) {
                            this.f4780s.m6594b(cursor.getCount());
                        }
                    } catch (Throwable th) {
                        if (cursor != null && !cursor.isClosed()) {
                            this.f4780s.m6554n(cursor);
                        }
                        throw th;
                    }
                }
                if (cursor != null && !cursor.isClosed()) {
                    this.f4780s.m6554n(cursor);
                }
            }
            if (i == 11 || i == 12 || i == 21 || i == 13) {
                this.f4780s.m6293F();
                if (i == 11 || i == 12 || i == 13) {
                    this.f4780s.f3602I.setFastScrollEnabled(false);
                    if (this.f4780s.f3660ao != 18) {
                        this.f4780s.f3620aA.m7124b();
                    }
                    this.f4780s.f3602I.setFastScrollEnabled(true);
                } else if (this.f4780s.f3604K != null) {
                    if (this.f4780s.f3604K.toString().length() > 0) {
                        this.f4780s.f3602I.setFastScrollEnabled(false);
                    } else {
                        this.f4780s.f3602I.setFastScrollEnabled(true);
                    }
                }
            } else if (i == this.f4778q) {
                cursor.moveToFirst();
                this.f4780s.f3752cp = cursor.getInt(cursor.getColumnIndex(VKApiConst.COUNT));
                C4904y.m18639b("hide count : " + this.f4780s.f3752cp, getClass().getSimpleName());
                this.f4780s.m6554n(cursor);
                ((ActionBarFragmentActivity) this.f4780s.getActivity()).mo51u_();
                this.f4780s.m6427am();
            }
            if (this.f4780s.f3660ao == 6 && this.f4780s.f3657al.containsKey("ACTIVITY_PURPOSE_ARG") && !this.f4780s.f3657al.getBoolean("ACTIVITY_PURPOSE_ARG") && this.f4780s.f3616W.getVisibility() == 0) {
                this.f4780s.f3616W.setEnabled(true);
            }
            if (this.f4780s.f3606M != null && this.f4780s.f3660ao != 1 && this.f4780s.f3660ao != 7 && this.f4780s.f3660ao != 6) {
                if (this.f4780s.f3750cn - this.f4780s.f3752cp >= 1 && this.f4780s.f3666au.size() != 0) {
                    this.f4780s.m6423ak();
                } else {
                    this.f4780s.m6351a(this.f4780s.f3606M);
                }
            }
            if (!this.f4780s.f3762cz) {
                if (this.f4780s.f3660ao == 3 || this.f4780s.f3660ao == 2 || this.f4780s.f3660ao == 15 || this.f4780s.f3660ao == 14 || this.f4780s.f3660ao == 10 || this.f4780s.f3660ao == 19) {
                    if (this.f4780s.f3677bF != null) {
                        if ((this.f4780s.f3750cn - this.f4780s.f3752cp) - this.f4780s.f3753cq == 1) {
                            this.f4780s.f3687bR.setText(this.f4780s.getResources().getString(R.string.buddy_list_total_1_contact, Integer.valueOf((this.f4780s.f3750cn - this.f4780s.f3752cp) - this.f4780s.f3753cq)));
                        } else {
                            this.f4780s.f3687bR.setText(this.f4780s.getResources().getString(R.string.buddy_list_total_contacts, Integer.valueOf((this.f4780s.f3750cn - this.f4780s.f3752cp) - this.f4780s.f3753cq)));
                        }
                    }
                } else if (this.f4780s.f3677bF != null) {
                    if (((this.f4780s.f3750cn + this.f4780s.f3751co) - this.f4780s.f3752cp) - this.f4780s.f3753cq == 1) {
                        this.f4780s.f3687bR.setText(this.f4780s.getResources().getString(R.string.buddy_list_total_1_contact, Integer.valueOf(((this.f4780s.f3750cn + this.f4780s.f3751co) - this.f4780s.f3752cp) - this.f4780s.f3753cq)));
                    } else {
                        this.f4780s.f3687bR.setText(this.f4780s.getResources().getString(R.string.buddy_list_total_contacts, Integer.valueOf(((this.f4780s.f3750cn + this.f4780s.f3751co) - this.f4780s.f3752cp) - this.f4780s.f3753cq)));
                    }
                }
            } else if (this.f4780s.f3677bF != null) {
                this.f4780s.f3687bR.setText(this.f4780s.getResources().getString(R.string.buddy_list_total_contacts, Integer.valueOf(((this.f4780s.f3750cn + this.f4780s.f3751co) - this.f4780s.f3752cp) - this.f4780s.f3753cq)));
            }
            if (this.f4780s.f3660ao == 1000 && this.f4780s.f3638aS != null && this.f4780s.f3638aS.equals("voip") && this.f4780s.f3677bF != null) {
                if (((this.f4780s.f3750cn + this.f4780s.f3751co) - this.f4780s.f3752cp) - this.f4780s.f3753cq == 1) {
                    this.f4780s.f3687bR.setText(this.f4780s.getResources().getString(R.string.buddy_list_total_1_contact, Integer.valueOf(((this.f4780s.f3750cn + this.f4780s.f3751co) - this.f4780s.f3752cp) - this.f4780s.f3753cq)));
                } else {
                    this.f4780s.f3687bR.setText(this.f4780s.getResources().getString(R.string.buddy_list_total_contacts, Integer.valueOf(((this.f4780s.f3750cn + this.f4780s.f3751co) - this.f4780s.f3752cp) - this.f4780s.f3753cq)));
                }
            }
            if (this.f4780s.f3687bR != null && !TextUtils.isEmpty(this.f4780s.f3677bF.m18658a().toString())) {
                if (this.f4780s.f3755cs == 1) {
                    this.f4780s.f3687bR.setText(this.f4780s.getResources().getString(R.string.buddy_list_total_1_contact, Integer.valueOf(this.f4780s.f3755cs)));
                } else {
                    this.f4780s.f3687bR.setText(this.f4780s.getResources().getString(R.string.buddy_list_total_contacts, Integer.valueOf(this.f4780s.f3755cs)));
                }
            }
            if (this.f4780s.f3677bF != null && TextUtils.isEmpty(this.f4780s.f3677bF.m18658a().toString())) {
                ((ActionBarFragmentActivity) this.f4780s.getActivity()).mo51u_();
            }
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7101a(int i, Object obj, Uri uri) {
        if (this.f4780s.getActivity() != null && i == this.f4762a) {
            C1106c c1106c = (C1106c) obj;
            if (Integer.parseInt(uri.getLastPathSegment()) != -1) {
                this.f4780s.f3642aW.setText(this.f4780s.getString(R.string.buddy_list_addfavorites_toast_success, c1106c.m7051b()));
                this.f4780s.f3642aW.setDuration(0);
                this.f4780s.f3642aW.show();
                return;
            }
            C5179v.m19811a(this.f4780s.getActivity(), this.f4780s.getResources().getString(R.string.buddy_list_addfavorites_toast_failed), 0).show();
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7099a(int i, Object obj, int i2) throws Resources.NotFoundException {
        if (this.f4780s.getActivity() != null) {
            if (i == this.f4770i) {
                if (i2 != -1) {
                }
                return;
            }
            if (i == this.f4771j) {
                if (i2 != -1) {
                }
                return;
            }
            if (i == this.f4776o) {
                m7403b();
                C1106c c1106c = (C1106c) obj;
                C5179v.m19811a(this.f4780s.getActivity(), String.format(this.f4780s.getResources().getString(R.string.buddy_list_hide_success), c1106c.m7051b()), 0).show();
                if (!c1106c.m7046a().startsWith("0999")) {
                    if (this.f4780s.f3671az != null) {
                        this.f4780s.f3622aC.m19614a(this.f4780s.f3671az.m7046a());
                        this.f4780s.m6587a(c1106c.m7046a(), c1106c.m7051b());
                        this.f4780s.m6588a(c1106c.m7046a(), false, c1106c.m7051b());
                    }
                    if (this.f4780s.m6605h() > 0) {
                        if (this.f4780s.f3713br != null) {
                            this.f4780s.f3713br.setVisibility(8);
                        }
                    } else {
                        this.f4780s.m6608k();
                    }
                }
                C0991aa.m6037a().m18962d(new C0993ac(EnumC1005ad.HIDED, this.f4780s.f3671az.m7046a()));
                return;
            }
            if (i == this.f4772k) {
                this.f4780s.m6576y();
            }
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: b */
    public void mo7102b(int i, Object obj, int i2) throws Resources.NotFoundException {
        if (this.f4780s.getActivity() != null && i == this.f4763b) {
            if (i2 != -1) {
                this.f4780s.f3642aW.setText(R.string.buddy_list_removefavorites_toast_success);
                this.f4780s.f3642aW.setDuration(0);
                this.f4780s.f3642aW.show();
                if (!TextUtils.isEmpty(this.f4780s.f3677bF.m18658a().toString())) {
                    this.f4780s.m6544j(((C1106c) obj).m7046a());
                    return;
                } else {
                    C0991aa.m6037a().m18962d(new C0993ac(EnumC1005ad.REMOVE_FAVORITE, ((C1106c) obj).m7046a()));
                    return;
                }
            }
            C5179v.m19811a(this.f4780s.getActivity(), this.f4780s.getResources().getString(R.string.buddy_list_removefavorites_toast_failed), 0).show();
        }
    }
}
