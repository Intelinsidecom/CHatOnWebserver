package com.sec.chaton.smsplugin.p102b;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.provider.Telephony;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.C2289i;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p112ui.C4149cd;
import java.io.IOException;
import java.io.InputStream;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: Contact.java */
/* renamed from: com.sec.chaton.smsplugin.b.c */
/* loaded from: classes.dex */
class C3784c {

    /* renamed from: c */
    private final C3786e f13579c;

    /* renamed from: h */
    private final Context f13580h;

    /* renamed from: i */
    private final HashMap<String, ArrayList<C3782a>> f13581i;

    /* renamed from: d */
    private static final Uri f13575d = ContactsContract.Data.CONTENT_URI;

    /* renamed from: a */
    public static final String[] f13573a = {"_id", "buddy_phonenumber_external_use", "buddy_status_message", "buddy_name", "buddy_msisdns", "buddy_is_hide", "buddy_is_new", "buddy_coverstory_meta_id", "buddy_no", "buddy_contact_buddy", "buddy_raw_contact_id"};

    /* renamed from: e */
    private static final String[] f13576e = {"buddy_phonenumber_external_use", "buddy_name"};

    /* renamed from: f */
    private static final Uri f13577f = ContactsContract.Data.CONTENT_URI;

    /* renamed from: g */
    private static final String[] f13578g = {"_id", "data4", "contact_presence", "contact_id", SlookAirButtonFrequentContactAdapter.DISPLAY_NAME, "send_to_voicemail"};

    /* renamed from: b */
    static CharBuffer f13574b = CharBuffer.allocate(5);

    private C3784c(Context context) {
        this.f13579c = new C3786e();
        this.f13581i = new HashMap<>();
        this.f13580h = context;
    }

    /* renamed from: a */
    public void m14297a(Runnable runnable) {
        this.f13579c.m14299a(runnable);
    }

    /* renamed from: a */
    public C3782a m14294a(boolean z) {
        return m14275a("Self_Item_Key", true, z);
    }

    /* renamed from: a */
    public C3782a m14293a(String str, boolean z) {
        return m14275a(str, false, z);
    }

    /* renamed from: a */
    private C3782a m14275a(String str, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        C3782a c3782aM14287b = m14287b(str, z);
        RunnableC3785d runnableC3785d = null;
        synchronized (c3782aM14287b) {
            while (z2) {
                if (!c3782aM14287b.f13567r) {
                    break;
                }
                try {
                    c3782aM14287b.wait();
                } catch (InterruptedException e) {
                }
            }
            if (c3782aM14287b.f13566q && !c3782aM14287b.f13567r) {
                c3782aM14287b.f13566q = false;
                if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
                    C3782a.m14241g("async update for " + c3782aM14287b.toString() + " canBlock: " + z2 + " isStale: " + c3782aM14287b.f13566q);
                }
                runnableC3785d = new RunnableC3785d(this, c3782aM14287b);
                c3782aM14287b.f13567r = true;
            }
        }
        if (runnableC3785d != null) {
            if (z2) {
                runnableC3785d.run();
            } else {
                m14297a(runnableC3785d);
            }
        }
        return c3782aM14287b;
    }

    /* renamed from: a */
    public List<C3782a> m14295a(Parcelable[] parcelableArr) {
        boolean z;
        boolean z2 = true;
        ArrayList arrayList = null;
        if (parcelableArr.length != 0) {
            StringBuilder sb = new StringBuilder();
            int length = parcelableArr.length;
            int i = 0;
            while (i < length) {
                Uri uri = (Uri) parcelableArr[i];
                if (!"content".equals(uri.getScheme())) {
                    z = z2;
                } else if (z2) {
                    sb.append(uri.getLastPathSegment());
                    z = false;
                } else {
                    sb.append(',').append(uri.getLastPathSegment());
                    z = z2;
                }
                i++;
                z2 = z;
            }
            if (!z2) {
                Cursor cursorQuery = sb.length() > 0 ? this.f13580h.getContentResolver().query(C2289i.f8196a, f13573a, "buddy_phonenumber_external_use!=\"\"", null, null) : null;
                if (cursorQuery != null) {
                    arrayList = new ArrayList();
                    while (cursorQuery.moveToNext()) {
                        try {
                            C3782a c3782a = new C3782a(cursorQuery.getString(1), cursorQuery.getString(3));
                            m14278a(c3782a, cursorQuery);
                            ArrayList<C3782a> arrayList2 = new ArrayList<>();
                            arrayList2.add(c3782a);
                            this.f13581i.put(m14276a(c3782a.f13554e, f13574b), arrayList2);
                            arrayList.add(c3782a);
                        } finally {
                            cursorQuery.close();
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private boolean m14282a(C3782a c3782a, C3782a c3782a2) {
        if (c3782a.f13553d == c3782a2.f13553d) {
            if (TextUtils.equals(c3782a.f13572w, c3782a2.f13572w)) {
                if (!TextUtils.equals(c3782a.f13570u, c3782a2.f13570u)) {
                    C3890m.m14996b("Contact", "buddyNumber changed");
                    return true;
                }
                if (c3782a.f13571v != c3782a2.f13571v) {
                    C3890m.m14996b("Contact", "mContatcBuddy changed");
                    return true;
                }
                if (c3782a.f13552c == c3782a2.f13552c) {
                    return (c3782a.f13561l == c3782a2.f13561l && c3782a.f13562m == c3782a2.f13562m && c3782a.f13569t == c3782a2.f13569t && C3782a.m14238f(c3782a.f13556g).equals(C3782a.m14238f(c3782a2.f13556g)) && C3782a.m14238f(c3782a.f13560k).equals(C3782a.m14238f(c3782a2.f13560k)) && Arrays.equals(c3782a.f13565p, c3782a2.f13565p)) ? false : true;
                }
                C3890m.m14996b("Contact", "mContactMethodId changed");
                return true;
            }
            C3890m.m14996b("Contact", "buddyRawId changed");
            return true;
        }
        C3890m.m14996b("Contact", "method type changed");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d4 A[Catch: all -> 0x00ce, TRY_LEAVE, TryCatch #2 {, blocks: (B:6:0x0008, B:8:0x000e, B:10:0x0019, B:11:0x0034, B:13:0x00aa, B:14:0x00ae, B:17:0x00ba, B:18:0x00be, B:20:0x00c4, B:26:0x00d3, B:27:0x00d4, B:31:0x00dd, B:35:0x00e2, B:29:0x00d6, B:30:0x00dc, B:15:0x00af, B:16:0x00b9), top: B:40:0x0008, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d5  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m14277a(com.sec.chaton.smsplugin.p102b.C3782a r4) {
        /*
            r3 = this;
            if (r4 != 0) goto L3
        L2:
            return
        L3:
            com.sec.chaton.smsplugin.b.a r0 = r3.m14285b(r4)
            monitor-enter(r4)
            boolean r1 = r3.m14282a(r4, r0)     // Catch: java.lang.Throwable -> Lce
            if (r1 == 0) goto Ld4
            java.lang.String r1 = "Mms:app"
            java.lang.String r2 = com.sec.chaton.smsplugin.p111h.C3890m.f13993b     // Catch: java.lang.Throwable -> Lce
            boolean r1 = com.sec.chaton.smsplugin.p111h.C3890m.m15000f(r1, r2)     // Catch: java.lang.Throwable -> Lce
            if (r1 == 0) goto L34
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lce
            r1.<init>()     // Catch: java.lang.Throwable -> Lce
            java.lang.String r2 = "updateContact: contact changed for "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lce
            java.lang.String r2 = com.sec.chaton.smsplugin.p102b.C3782a.m14246l(r0)     // Catch: java.lang.Throwable -> Lce
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lce
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lce
            com.sec.chaton.smsplugin.p102b.C3782a.m14232d(r1)     // Catch: java.lang.Throwable -> Lce
        L34:
            java.lang.String r1 = com.sec.chaton.smsplugin.p102b.C3782a.m14226c(r0)     // Catch: java.lang.Throwable -> Lce
            com.sec.chaton.smsplugin.p102b.C3782a.m14206a(r4, r1)     // Catch: java.lang.Throwable -> Lce
            java.lang.String r1 = com.sec.chaton.smsplugin.p102b.C3782a.m14247m(r0)     // Catch: java.lang.Throwable -> Lce
            com.sec.chaton.smsplugin.p102b.C3782a.m14220b(r4, r1)     // Catch: java.lang.Throwable -> Lce
            long r1 = com.sec.chaton.smsplugin.p102b.C3782a.m14243i(r0)     // Catch: java.lang.Throwable -> Lce
            com.sec.chaton.smsplugin.p102b.C3782a.m14202a(r4, r1)     // Catch: java.lang.Throwable -> Lce
            int r1 = com.sec.chaton.smsplugin.p102b.C3782a.m14244j(r0)     // Catch: java.lang.Throwable -> Lce
            com.sec.chaton.smsplugin.p102b.C3782a.m14201a(r4, r1)     // Catch: java.lang.Throwable -> Lce
            java.lang.String r1 = com.sec.chaton.smsplugin.p102b.C3782a.m14249o(r0)     // Catch: java.lang.Throwable -> Lce
            com.sec.chaton.smsplugin.p102b.C3782a.m14227c(r4, r1)     // Catch: java.lang.Throwable -> Lce
            byte[] r1 = com.sec.chaton.smsplugin.p102b.C3782a.m14248n(r0)     // Catch: java.lang.Throwable -> Lce
            com.sec.chaton.smsplugin.p102b.C3782a.m14217a(r4, r1)     // Catch: java.lang.Throwable -> Lce
            android.graphics.drawable.BitmapDrawable r1 = com.sec.chaton.smsplugin.p102b.C3782a.m14250p(r0)     // Catch: java.lang.Throwable -> Lce
            com.sec.chaton.smsplugin.p102b.C3782a.m14203a(r4, r1)     // Catch: java.lang.Throwable -> Lce
            long r1 = com.sec.chaton.smsplugin.p102b.C3782a.m14242h(r0)     // Catch: java.lang.Throwable -> Lce
            com.sec.chaton.smsplugin.p102b.C3782a.m14219b(r4, r1)     // Catch: java.lang.Throwable -> Lce
            int r1 = com.sec.chaton.smsplugin.p102b.C3782a.m14230d(r0)     // Catch: java.lang.Throwable -> Lce
            com.sec.chaton.smsplugin.p102b.C3782a.m14218b(r4, r1)     // Catch: java.lang.Throwable -> Lce
            java.lang.String r1 = com.sec.chaton.smsplugin.p102b.C3782a.m14252q(r0)     // Catch: java.lang.Throwable -> Lce
            com.sec.chaton.smsplugin.p102b.C3782a.m14231d(r4, r1)     // Catch: java.lang.Throwable -> Lce
            java.lang.String r1 = com.sec.chaton.smsplugin.p102b.C3782a.m14246l(r0)     // Catch: java.lang.Throwable -> Lce
            com.sec.chaton.smsplugin.p102b.C3782a.m14234e(r4, r1)     // Catch: java.lang.Throwable -> Lce
            boolean r1 = com.sec.chaton.smsplugin.p102b.C3782a.m14245k(r0)     // Catch: java.lang.Throwable -> Lce
            com.sec.chaton.smsplugin.p102b.C3782a.m14229c(r4, r1)     // Catch: java.lang.Throwable -> Lce
            java.lang.String r1 = com.sec.chaton.smsplugin.p102b.C3782a.m14236f(r0)     // Catch: java.lang.Throwable -> Lce
            com.sec.chaton.smsplugin.p102b.C3782a.m14237f(r4, r1)     // Catch: java.lang.Throwable -> Lce
            long r1 = com.sec.chaton.smsplugin.p102b.C3782a.m14239g(r0)     // Catch: java.lang.Throwable -> Lce
            com.sec.chaton.smsplugin.p102b.C3782a.m14225c(r4, r1)     // Catch: java.lang.Throwable -> Lce
            java.lang.String r0 = com.sec.chaton.smsplugin.p102b.C3782a.m14233e(r0)     // Catch: java.lang.Throwable -> Lce
            com.sec.chaton.smsplugin.p102b.C3782a.m14240g(r4, r0)     // Catch: java.lang.Throwable -> Lce
            com.sec.chaton.smsplugin.p102b.C3782a.m14254r(r4)     // Catch: java.lang.Throwable -> Lce
            java.lang.String r0 = com.sec.chaton.smsplugin.p102b.C3782a.m14226c(r4)     // Catch: java.lang.Throwable -> Lce
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> Lce
            if (r0 != 0) goto Ld4
            java.util.HashSet r1 = com.sec.chaton.smsplugin.p102b.C3782a.m14251p()     // Catch: java.lang.Throwable -> Lce
            monitor-enter(r1)     // Catch: java.lang.Throwable -> Lce
            java.util.HashSet r0 = com.sec.chaton.smsplugin.p102b.C3782a.m14251p()     // Catch: java.lang.Throwable -> Ld1
            java.lang.Object r0 = r0.clone()     // Catch: java.lang.Throwable -> Ld1
            java.util.HashSet r0 = (java.util.HashSet) r0     // Catch: java.lang.Throwable -> Ld1
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Ld1
            java.util.Iterator r1 = r0.iterator()     // Catch: java.lang.Throwable -> Lce
        Lbe:
            boolean r0 = r1.hasNext()     // Catch: java.lang.Throwable -> Lce
            if (r0 == 0) goto Ld4
            java.lang.Object r0 = r1.next()     // Catch: java.lang.Throwable -> Lce
            com.sec.chaton.smsplugin.b.g r0 = (com.sec.chaton.smsplugin.p102b.InterfaceC3788g) r0     // Catch: java.lang.Throwable -> Lce
            r0.mo14300a(r4)     // Catch: java.lang.Throwable -> Lce
            goto Lbe
        Lce:
            r0 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> Lce
            throw r0
        Ld1:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Ld1
            throw r0     // Catch: java.lang.Throwable -> Lce
        Ld4:
            monitor-enter(r4)     // Catch: java.lang.Throwable -> Lce
            r0 = 0
            com.sec.chaton.smsplugin.p102b.C3782a.m14224b(r4, r0)     // Catch: java.lang.Throwable -> Le0
            r4.notifyAll()     // Catch: java.lang.Throwable -> Le0
            monitor-exit(r4)     // Catch: java.lang.Throwable -> Le0
            monitor-exit(r4)     // Catch: java.lang.Throwable -> Lce
            goto L2
        Le0:
            r0 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> Le0
            throw r0     // Catch: java.lang.Throwable -> Lce
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.p102b.C3784c.m14277a(com.sec.chaton.smsplugin.b.a):void");
    }

    /* renamed from: b */
    private C3782a m14285b(C3782a c3782a) {
        if (!c3782a.f13568s) {
            if (Telephony.Mms.isEmailAddress(c3782a.f13554e) || m14283a(c3782a.f13554e)) {
                return m14291c(c3782a.f13554e);
            }
            String strStripSeparators = PhoneNumberUtils.stripSeparators(c3782a.f13554e);
            return strStripSeparators.length() >= 8 ? m14286b(strStripSeparators) : c3782a;
        }
        return m14284b();
    }

    /* renamed from: a */
    private boolean m14283a(String str) {
        if (!PhoneNumberUtils.isWellFormedSmsAddress(str) || C4149cd.m16418a(str)) {
            return true;
        }
        String strExtractNetworkPortion = PhoneNumberUtils.extractNetworkPortion(str);
        return TextUtils.isEmpty(strExtractNetworkPortion) || strExtractNetworkPortion.length() < 3;
    }

    /* renamed from: b */
    private C3782a m14286b(String str) {
        Cursor cursorQuery;
        C3782a c3782a = new C3782a(str);
        c3782a.f13553d = 1;
        String strNormalizeNumber = PhoneNumberUtils.normalizeNumber(str);
        String callerIDMinMatch = PhoneNumberUtils.toCallerIDMinMatch(strNormalizeNumber);
        if (!TextUtils.isEmpty(strNormalizeNumber) && !TextUtils.isEmpty(callerIDMinMatch)) {
            String.valueOf(strNormalizeNumber.length());
            if (TextUtils.isEmpty(PhoneNumberUtils.formatNumberToE164(str, GlobalApplication.m10279a().m10297l()))) {
            }
            String strSubstring = str.substring(str.length() - 8);
            try {
                cursorQuery = this.f13580h.getContentResolver().query(C2289i.f8196a, f13573a, "buddy_phonenumber_external_use  LIKE '%" + strSubstring + "%'", null, null);
            } catch (Exception e) {
                cursorQuery = null;
            }
            if (cursorQuery == null) {
                C3890m.m14997c("Contact", "queryContactInfoByNumber(" + strSubstring + ") returned NULL cursor! contact uri used " + f13575d);
                return c3782a;
            }
            try {
                if (cursorQuery.moveToFirst()) {
                    m14278a(c3782a, cursorQuery);
                }
            } finally {
                cursorQuery.close();
            }
        }
        return c3782a;
    }

    /* renamed from: b */
    private C3782a m14284b() {
        C3782a c3782a = new C3782a(true);
        c3782a.f13553d = 3;
        Cursor cursorQuery = this.f13580h.getContentResolver().query(C2289i.f8196a, f13576e, "buddy_phonenumber_external_use!=\"\"", null, null);
        if (cursorQuery == null) {
            C3890m.m14997c("Contact", "getContactInfoForSelf() returned NULL cursor! contact uri used " + ContactsContract.Profile.CONTENT_URI);
            return c3782a;
        }
        try {
            if (cursorQuery.moveToFirst()) {
                m14288b(c3782a, cursorQuery);
            }
            return c3782a;
        } finally {
            cursorQuery.close();
        }
    }

    /* renamed from: a */
    private void m14278a(C3782a c3782a, Cursor cursor) throws IOException {
        synchronized (c3782a) {
            c3782a.f13553d = 1;
            c3782a.f13552c = cursor.getLong(0);
            c3782a.f13560k = cursor.getString(2);
            c3782a.f13556g = cursor.getString(3);
            c3782a.f13561l = cursor.getLong(4);
            c3782a.f13562m = m14274a(cursor.getInt(5));
            c3782a.f13563n = cursor.getString(6);
            c3782a.f13555f = cursor.getString(7);
            c3782a.f13570u = cursor.getString(8);
            c3782a.f13571v = cursor.getLong(9);
            c3782a.f13572w = cursor.getString(10);
        }
        byte[] bArrM14292c = m14292c(c3782a);
        synchronized (c3782a) {
            c3782a.f13565p = bArrM14292c;
        }
    }

    /* renamed from: b */
    private void m14288b(C3782a c3782a, Cursor cursor) throws IOException {
        synchronized (c3782a) {
            c3782a.f13556g = cursor.getString(1);
            if (TextUtils.isEmpty(c3782a.f13556g)) {
                c3782a.f13556g = this.f13580h.getString(R.string.messagelist_sender_self);
            }
        }
        byte[] bArrM14292c = m14292c(c3782a);
        synchronized (c3782a) {
            c3782a.f13565p = bArrM14292c;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.net.Uri] */
    /* renamed from: c */
    private byte[] m14292c(C3782a c3782a) throws IOException {
        byte[] bArr;
        byte[] bArr2;
        if ((!c3782a.f13568s && c3782a.f13561l == 0) || c3782a.f13564o != null) {
            return null;
        }
        byte[] bArrWithAppendedId = c3782a.f13568s ? ContactsContract.Profile.CONTENT_URI : ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, c3782a.f13561l);
        InputStream inputStreamOpenContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(this.f13580h.getContentResolver(), bArrWithAppendedId);
        try {
            if (inputStreamOpenContactPhotoInputStream != null) {
                try {
                    try {
                        byte[] bArr3 = new byte[inputStreamOpenContactPhotoInputStream.available()];
                        try {
                            inputStreamOpenContactPhotoInputStream.read(bArr3, 0, bArr3.length);
                            bArr2 = bArr3;
                        } catch (IOException e) {
                            bArr = bArr3;
                            if (inputStreamOpenContactPhotoInputStream != null) {
                                inputStreamOpenContactPhotoInputStream.close();
                                bArrWithAppendedId = bArr;
                                return bArrWithAppendedId;
                            }
                            return bArr;
                        }
                    } catch (Throwable th) {
                        if (inputStreamOpenContactPhotoInputStream != null) {
                            try {
                                inputStreamOpenContactPhotoInputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    bArr = null;
                }
            } else {
                bArr2 = null;
            }
            if (inputStreamOpenContactPhotoInputStream != null) {
                inputStreamOpenContactPhotoInputStream.close();
                bArrWithAppendedId = bArr2;
                return bArrWithAppendedId;
            }
            return bArr2;
        } catch (IOException e4) {
            return bArrWithAppendedId;
        }
    }

    /* renamed from: a */
    private int m14274a(int i) {
        if (i != 0) {
            return ContactsContract.StatusUpdates.getPresenceIconResourceId(i);
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0087, code lost:
    
        r0 = m14292c(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008b, code lost:
    
        monitor-enter(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008c, code lost:
    
        r7.f13565p = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008f, code lost:
    
        monitor-exit(r7);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.sec.chaton.smsplugin.p102b.C3782a m14291c(java.lang.String r12) {
        /*
            r11 = this;
            r10 = 0
            r0 = 2
            r8 = 1
            r9 = 0
            com.sec.chaton.smsplugin.b.a r7 = new com.sec.chaton.smsplugin.b.a
            r7.<init>(r12)
            com.sec.chaton.smsplugin.p102b.C3782a.m14218b(r7, r0)
            android.content.Context r0 = r11.f13580h     // Catch: java.lang.SecurityException -> L95
            android.content.Context r1 = r11.f13580h     // Catch: java.lang.SecurityException -> L95
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.SecurityException -> L95
            android.net.Uri r2 = com.sec.chaton.smsplugin.p102b.C3784c.f13577f     // Catch: java.lang.SecurityException -> L95
            java.lang.String[] r3 = com.sec.chaton.smsplugin.p102b.C3784c.f13578g     // Catch: java.lang.SecurityException -> L95
            java.lang.String r4 = "UPPER(data1)=UPPER(?) AND mimetype='vnd.android.cursor.item/email_v2'"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.SecurityException -> L95
            r6 = 0
            r5[r6] = r12     // Catch: java.lang.SecurityException -> L95
            r6 = 0
            android.database.Cursor r1 = android.database.sqlite.SqliteWrapper.query(r0, r1, r2, r3, r4, r5, r6)     // Catch: java.lang.SecurityException -> L95
            if (r1 == 0) goto L93
        L28:
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Throwable -> Lab
            if (r0 == 0) goto L90
            r0 = 0
            long r2 = r1.getLong(r0)     // Catch: java.lang.Throwable -> Lab
            com.sec.chaton.smsplugin.p102b.C3782a.m14219b(r7, r2)     // Catch: java.lang.Throwable -> Lab
            r0 = 2
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> Lab
            int r0 = r11.m14274a(r0)     // Catch: java.lang.Throwable -> Lab
            com.sec.chaton.smsplugin.p102b.C3782a.m14201a(r7, r0)     // Catch: java.lang.Throwable -> Lab
            r0 = 3
            long r2 = r1.getLong(r0)     // Catch: java.lang.Throwable -> Lab
            com.sec.chaton.smsplugin.p102b.C3782a.m14202a(r7, r2)     // Catch: java.lang.Throwable -> Lab
            r0 = 5
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> Lab
            if (r0 != r8) goto La6
            r0 = r8
        L52:
            com.sec.chaton.smsplugin.p102b.C3782a.m14229c(r7, r0)     // Catch: java.lang.Throwable -> Lab
            monitor-enter(r7)     // Catch: java.lang.Throwable -> Lab
            r0 = 2
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> La8
            int r0 = r11.m14274a(r0)     // Catch: java.lang.Throwable -> La8
            com.sec.chaton.smsplugin.p102b.C3782a.m14201a(r7, r0)     // Catch: java.lang.Throwable -> La8
            r0 = 0
            long r2 = r1.getLong(r0)     // Catch: java.lang.Throwable -> La8
            com.sec.chaton.smsplugin.p102b.C3782a.m14202a(r7, r2)     // Catch: java.lang.Throwable -> La8
            r0 = 1
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> La8
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> La8
            if (r2 == 0) goto L7a
            r0 = 4
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> La8
        L7a:
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> La8
            if (r2 != 0) goto Lb3
            com.sec.chaton.smsplugin.p102b.C3782a.m14234e(r7, r0)     // Catch: java.lang.Throwable -> La8
            r0 = r8
        L84:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> La8
            if (r0 == 0) goto L28
            byte[] r0 = r11.m14292c(r7)     // Catch: java.lang.Throwable -> Lab
            monitor-enter(r7)     // Catch: java.lang.Throwable -> Lab
            com.sec.chaton.smsplugin.p102b.C3782a.m14217a(r7, r0)     // Catch: java.lang.Throwable -> Lb0
            monitor-exit(r7)     // Catch: java.lang.Throwable -> Lb0
        L90:
            r1.close()
        L93:
            r0 = r7
        L94:
            return r0
        L95:
            r0 = move-exception
            java.lang.String r0 = "Contact"
            java.lang.String r1 = "SecurityException has occured, so contacts will have only email address"
            com.sec.chaton.smsplugin.p111h.C3890m.m14996b(r0, r1)
            if (r10 == 0) goto La4
            r10.close()
        La4:
            r0 = r7
            goto L94
        La6:
            r0 = r9
            goto L52
        La8:
            r0 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> La8
            throw r0     // Catch: java.lang.Throwable -> Lab
        Lab:
            r0 = move-exception
            r1.close()
            throw r0
        Lb0:
            r0 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> Lb0
            throw r0     // Catch: java.lang.Throwable -> Lab
        Lb3:
            r0 = r9
            goto L84
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.p102b.C3784c.m14291c(java.lang.String):com.sec.chaton.smsplugin.b.a");
    }

    /* renamed from: a */
    private String m14276a(String str, CharBuffer charBuffer) {
        charBuffer.clear();
        charBuffer.mark();
        int length = str.length();
        int i = 0;
        while (true) {
            length--;
            if (length < 0) {
                break;
            }
            char cCharAt = str.charAt(length);
            if (Character.isDigit(cCharAt)) {
                charBuffer.put(cCharAt);
                i++;
                if (i == 5) {
                    break;
                }
            }
        }
        charBuffer.reset();
        if (i > 0) {
            return charBuffer.toString();
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.sec.chaton.smsplugin.p102b.C3782a m14287b(java.lang.String r7, boolean r8) {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            monitor-enter(r6)
            if (r8 != 0) goto L11
            boolean r2 = android.provider.Telephony.Mms.isEmailAddress(r7)     // Catch: java.lang.Throwable -> L50
            if (r2 != 0) goto L11
            boolean r2 = com.sec.chaton.smsplugin.p112ui.C4149cd.m16418a(r7)     // Catch: java.lang.Throwable -> L50
            if (r2 == 0) goto L3a
        L11:
            r3 = r0
        L12:
            if (r3 == 0) goto L3c
            r2 = r7
        L15:
            java.util.HashMap<java.lang.String, java.util.ArrayList<com.sec.chaton.smsplugin.b.a>> r0 = r6.f13581i     // Catch: java.lang.Throwable -> L50
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> L50
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch: java.lang.Throwable -> L50
            if (r0 == 0) goto L57
            int r4 = r0.size()     // Catch: java.lang.Throwable -> L50
            r2 = r1
        L24:
            if (r2 >= r4) goto L61
            java.lang.Object r1 = r0.get(r2)     // Catch: java.lang.Throwable -> L50
            com.sec.chaton.smsplugin.b.a r1 = (com.sec.chaton.smsplugin.p102b.C3782a) r1     // Catch: java.lang.Throwable -> L50
            if (r3 == 0) goto L44
            java.lang.String r5 = com.sec.chaton.smsplugin.p102b.C3782a.m14226c(r1)     // Catch: java.lang.Throwable -> L50
            boolean r5 = r7.equals(r5)     // Catch: java.lang.Throwable -> L50
            if (r5 == 0) goto L53
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L50
        L39:
            return r1
        L3a:
            r3 = r1
            goto L12
        L3c:
            java.nio.CharBuffer r0 = com.sec.chaton.smsplugin.p102b.C3784c.f13574b     // Catch: java.lang.Throwable -> L50
            java.lang.String r0 = r6.m14276a(r7, r0)     // Catch: java.lang.Throwable -> L50
            r2 = r0
            goto L15
        L44:
            java.lang.String r5 = com.sec.chaton.smsplugin.p102b.C3782a.m14226c(r1)     // Catch: java.lang.Throwable -> L50
            boolean r5 = android.telephony.PhoneNumberUtils.compare(r7, r5)     // Catch: java.lang.Throwable -> L50
            if (r5 == 0) goto L53
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L50
            goto L39
        L50:
            r0 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L50
            throw r0
        L53:
            int r1 = r2 + 1
            r2 = r1
            goto L24
        L57:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L50
            r0.<init>()     // Catch: java.lang.Throwable -> L50
            java.util.HashMap<java.lang.String, java.util.ArrayList<com.sec.chaton.smsplugin.b.a>> r1 = r6.f13581i     // Catch: java.lang.Throwable -> L50
            r1.put(r2, r0)     // Catch: java.lang.Throwable -> L50
        L61:
            if (r8 == 0) goto L6f
            com.sec.chaton.smsplugin.b.a r1 = new com.sec.chaton.smsplugin.b.a     // Catch: java.lang.Throwable -> L50
            r2 = 1
            r3 = 0
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L50
        L6a:
            r0.add(r1)     // Catch: java.lang.Throwable -> L50
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L50
            goto L39
        L6f:
            com.sec.chaton.smsplugin.b.a r1 = new com.sec.chaton.smsplugin.b.a     // Catch: java.lang.Throwable -> L50
            r2 = 0
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L50
            goto L6a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.p102b.C3784c.m14287b(java.lang.String, boolean):com.sec.chaton.smsplugin.b.a");
    }

    /* renamed from: a */
    void m14296a() {
        synchronized (this) {
            Iterator<ArrayList<C3782a>> it = this.f13581i.values().iterator();
            while (it.hasNext()) {
                Iterator<C3782a> it2 = it.next().iterator();
                while (it2.hasNext()) {
                    C3782a next = it2.next();
                    synchronized (next) {
                        next.f13566q = true;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m14281a(ArrayList<String> arrayList) {
        synchronized (this) {
            Collection<ArrayList<C3782a>> collectionValues = this.f13581i.values();
            Iterator<String> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    boolean z = false;
                    Iterator<ArrayList<C3782a>> it2 = collectionValues.iterator();
                    while (it2.hasNext()) {
                        Iterator<C3782a> it3 = it2.next().iterator();
                        while (it3.hasNext()) {
                            C3782a next2 = it3.next();
                            synchronized (next2) {
                                if (TextUtils.equals(next2.f13570u, next) || TextUtils.equals(next2.f13572w, next)) {
                                    next2.f13566q = true;
                                    z = true;
                                }
                            }
                        }
                    }
                    if (!z) {
                        C3782a.m14210a();
                        C3890m.m14994a("Contact", "updateCacheByRawId, invalidate all");
                        break;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m14290b(ArrayList<String> arrayList) {
        synchronized (this) {
            Iterator<String> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    boolean z = false;
                    ArrayList<C3782a> arrayList2 = this.f13581i.get(m14276a(next, f13574b));
                    if (arrayList2 != null && !arrayList2.isEmpty()) {
                        Iterator<C3782a> it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            C3782a next2 = it2.next();
                            synchronized (next2) {
                                if (TextUtils.equals(next.length() > 8 ? next.substring(next.length() - 8) : next, next2.f13554e.length() > 8 ? next2.f13554e.substring(next2.f13554e.length() - 8) : next2.f13554e)) {
                                    next2.f13566q = true;
                                    C3890m.m14994a("Contact", "updateCacheByPhoneNumber, mIsStale = true, buddyNo : " + next2.m14269k() + " buddyName : " + next2.m14264f());
                                    z = true;
                                }
                            }
                        }
                    }
                    if (!z) {
                        C3782a.m14210a();
                        C3890m.m14994a("Contact", "updateCacheByPhoneNumber, invalidate all");
                        break;
                    }
                }
            }
        }
    }
}
