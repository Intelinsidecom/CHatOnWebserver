package com.sec.chaton.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.motion.MotionRecognitionManager;
import android.net.Uri;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.amsoma.AMSLibs;
import com.sec.chaton.api.access_token.C1041a;
import com.sec.chaton.buddy.p050a.EnumC1109f;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.C2218af;
import com.sec.chaton.p057e.C2220ah;
import com.sec.chaton.p057e.C2224al;
import com.sec.chaton.p057e.C2225am;
import com.sec.chaton.p057e.C2227ao;
import com.sec.chaton.p057e.C2268bn;
import com.sec.chaton.p057e.C2283cb;
import com.sec.chaton.p057e.C2289i;
import com.sec.chaton.p057e.C2290j;
import com.sec.chaton.p057e.C2293m;
import com.sec.chaton.p057e.C2294n;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.C2306z;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2215ac;
import com.sec.chaton.p057e.EnumC2231as;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.p057e.InterfaceC2269bo;
import com.sec.chaton.p057e.InterfaceC2271bq;
import com.sec.chaton.p057e.InterfaceC2272br;
import com.sec.chaton.p057e.InterfaceC2273bs;
import com.sec.chaton.p057e.InterfaceC2275bu;
import com.sec.chaton.p057e.InterfaceC2277bw;
import com.sec.chaton.p057e.InterfaceC2279by;
import com.sec.chaton.p057e.InterfaceC2282ca;
import com.sec.chaton.p057e.p058a.C2176ab;
import com.sec.chaton.p057e.p058a.C2186al;
import com.sec.chaton.p057e.p058a.C2208v;
import com.sec.chaton.specialbuddy.EnumC4549n;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4839bd;
import com.sec.chaton.util.C4843bh;
import com.sec.chaton.util.C4855bt;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5052r;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ChatONProvider extends BaseContentProvider {

    /* renamed from: a */
    private static final UriMatcher f11238a = m12427b();

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        switch (f11238a.match(uri)) {
            case 100:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 102:
                return "vnd.chaton.cursor.item/vnd.chaton.buddy";
            case 103:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 104:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 105:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 106:
                return "vnd.chaton.cursor.item/vnd.chaton.buddy";
            case 107:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 108:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 109:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 110:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 111:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 115:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 116:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 118:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddy";
            case 200:
                return "vnd.chaton.cursor.dir/vnd.chaton.group";
            case 201:
                return "vnd.chaton.cursor.item/vnd.chaton.group";
            case 203:
                return "vnd.chaton.cursor.dir/vnd.chaton.group";
            case 300:
                return "vnd.chaton.cursor.dir/vnd.chaton.contacts";
            case 301:
                return "vnd.chaton.cursor.item/vnd.chaton.contacts";
            case 302:
                return "vnd.chaton.cursor.dir/vnd.chaton.contacts";
            case AMSLibs.ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE /* 400 */:
                return "vnd.chaton.cursor.dir/vnd.chaton.inbox";
            case 401:
                return "vnd.chaton.cursor.item/vnd.chaton.inbox";
            case 402:
                return "vnd.chaton.cursor.dir/vnd.chaton.inbox";
            case 404:
                return "vnd.chaton.cursor.dir/vnd.chaton.inbox";
            case 461:
                return "vnd.chaton.cursor.dir/vnd.chaton.inboxbuddyrelation";
            case 500:
                return "vnd.chaton.cursor.dir/vnd.chaton.message";
            case 501:
                return "vnd.chaton.cursor.item/vnd.chaton.message";
            case 502:
                return "vnd.chaton.cursor.item/vnd.chaton.message";
            case 505:
                return "vnd.chaton.cursor.dir/vnd.chaton.message";
            case 506:
                return "vnd.chaton.cursor.dir/vnd.chaton.message";
            case 507:
                return "vnd.chaton.cursor.dir/vnd.chaton.message";
            case 508:
                return "vnd.chaton.cursor.dir/vnd.chaton.message";
            case 511:
                return "vnd.chaton.cursor.dir/vnd.chaton.message";
            case MotionRecognitionManager.EVENT_VOLUME_DOWN /* 512 */:
                return "vnd.chaton.cursor.dir/vnd.chaton.message";
            case 600:
                return "vnd.chaton.cursor.dir/vnd.chaton.relation";
            case 603:
                return "vnd.chaton.cursor.dir/vnd.chaton.relation";
            case 700:
                return "vnd.chaton.cursor.dir/vnd.chaton.grouprelation";
            case 701:
                return "vnd.chaton.cursor.dir/vnd.chaton.grouprelation";
            case 702:
                return "vnd.chaton.cursor.dir/vnd.chaton.group";
            case 711:
                return "vnd.chaton.cursor.dir/vnd.chaton.grouprelation";
            case 712:
                return "vnd.chaton.cursor.dir/vnd.chaton.grouprelation";
            case 713:
                return "vnd.chaton.cursor.item/vnd.chaton.grouprelation";
            case 900:
                return "vnd.chaton.cursor.dir/vnd.chaton.memo";
            case 902:
                return "vnd.chaton.cursor.dir/vnd.chaton.poston";
            case 903:
                return "vnd.chaton.cursor.dir/vnd.chaton.postoncomments";
            case 904:
                return "vnd.chaton.cursor.dir/vnd.chaton.poston";
            case 905:
                return "vnd.chaton.cursor.dir/vnd.chaton.postoncomments";
            case 906:
                return "vnd.chaton.cursor.dir/vnd.chaton.myposton";
            case 907:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddyposton";
            case 908:
                return "vnd.chaton.cursor.dir/vnd.chaton.myposton";
            case 909:
                return "vnd.chaton.cursor.dir/vnd.chaton.buddyposton";
            case 910:
                return "vnd.chaton.cursor.dir/vnd.chaton.postonmymultimedia";
            case 911:
                return "vnd.chaton.cursor.dir/vnd.chaton.postonbuddymultimedia";
            case 912:
                return "vnd.chaton.cursor.dir/vnd.chaton.postonmymultimedia";
            case 913:
                return "vnd.chaton.cursor.dir/vnd.chaton.postonbuddymultimedia";
            case 914:
                return "vnd.chaton.cursor.dir/vnd.chaton.coverstorysample";
            case 915:
                return "vnd.chaton.cursor.dir/vnd.chaton.profileimage";
            case 1000:
                return "vnd.chaton.cursor.dir/vnd.chaton.recommendee";
            case 1001:
                return "vnd.chaton.cursor.dir/vnd.chaton.recommendee";
            case 1100:
                return "vnd.chaton.cursor.item/vnd.chaton.buddy";
            case 1300:
                return "com.sec.chaton.provider/buddyextrainfo";
            case 2000:
                return "vnd.chaton.cursor.dir/vnd.chaton.specialbuddy";
            case 2001:
                return "vnd.chaton.cursor.dir/vnd.chaton.specialbuddy";
            case 6000:
                return "vnd.chaton.cursor.dir/vnd.chaton.unknownbuddy";
            case 6100:
                return "vnd.chaton.cursor.dir/vnd.chaton.inboxsmsmapping";
            default:
                throw new UnsupportedOperationException("UnKonwn Uri : " + uri);
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        C2268bn.m10126a(getContext());
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:162:0x08f3  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x08f6  */
    /* JADX WARN: Removed duplicated region for block: B:174:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0087 A[Catch: SQLiteConstraintException -> 0x06ab, SQLiteFullException -> 0x06cd, all -> 0x06d5, SQLiteDiskIOException -> 0x08d8, SQLiteException -> 0x08e1, Exception -> 0x08ea, TryCatch #2 {Exception -> 0x08ea, blocks: (B:6:0x0017, B:8:0x0029, B:10:0x002d, B:11:0x003b, B:13:0x004a, B:14:0x006d, B:16:0x0072, B:17:0x0083, B:19:0x0087, B:21:0x00ab, B:22:0x00b4, B:23:0x00be, B:24:0x00c8, B:25:0x00d2, B:26:0x00dc, B:27:0x00e6, B:28:0x00f0, B:29:0x00fa, B:30:0x0104, B:31:0x010f, B:32:0x011b, B:33:0x0169, B:35:0x0173, B:37:0x017e, B:38:0x0186, B:39:0x01a3, B:41:0x01ad, B:43:0x01b8, B:44:0x01c0, B:46:0x01df, B:48:0x01f1, B:49:0x0201, B:51:0x020b, B:52:0x0239, B:54:0x024b, B:55:0x0259, B:57:0x02b0, B:58:0x0332, B:60:0x033d, B:62:0x0352, B:64:0x0388, B:65:0x03ed, B:66:0x0407, B:68:0x042b, B:70:0x0454, B:72:0x0463, B:74:0x0469, B:77:0x04ba, B:80:0x04c4, B:83:0x04cd, B:85:0x04d1, B:86:0x054f, B:88:0x0566, B:93:0x057d, B:95:0x0595, B:96:0x059b, B:116:0x06a6, B:127:0x06c9, B:128:0x06cc, B:134:0x06d7, B:135:0x06ee, B:136:0x0705, B:137:0x0710, B:138:0x0728, B:139:0x0733, B:140:0x073e, B:141:0x0749, B:142:0x0755, B:143:0x0760, B:145:0x079b, B:146:0x07eb, B:147:0x0807, B:149:0x0827, B:150:0x0839, B:151:0x0854, B:152:0x0860, B:153:0x08cc), top: B:169:0x0017, outer: #0 }] */
    /* JADX WARN: Type inference failed for: r2v100 */
    /* JADX WARN: Type inference failed for: r2v104 */
    /* JADX WARN: Type inference failed for: r2v108 */
    /* JADX WARN: Type inference failed for: r2v111 */
    /* JADX WARN: Type inference failed for: r2v119 */
    /* JADX WARN: Type inference failed for: r2v121 */
    /* JADX WARN: Type inference failed for: r2v123 */
    /* JADX WARN: Type inference failed for: r2v133 */
    /* JADX WARN: Type inference failed for: r2v144 */
    /* JADX WARN: Type inference failed for: r2v149 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v151 */
    /* JADX WARN: Type inference failed for: r2v153 */
    /* JADX WARN: Type inference failed for: r2v155 */
    /* JADX WARN: Type inference failed for: r2v157 */
    /* JADX WARN: Type inference failed for: r2v159 */
    /* JADX WARN: Type inference failed for: r2v161 */
    /* JADX WARN: Type inference failed for: r2v163 */
    /* JADX WARN: Type inference failed for: r2v165 */
    /* JADX WARN: Type inference failed for: r2v167 */
    /* JADX WARN: Type inference failed for: r2v169 */
    /* JADX WARN: Type inference failed for: r2v171 */
    /* JADX WARN: Type inference failed for: r2v172 */
    /* JADX WARN: Type inference failed for: r2v173, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v175 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r2v68, types: [android.database.MatrixCursor] */
    /* JADX WARN: Type inference failed for: r2v69 */
    /* JADX WARN: Type inference failed for: r2v70 */
    /* JADX WARN: Type inference failed for: r2v78 */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.database.Cursor query(android.net.Uri r15, java.lang.String[] r16, java.lang.String r17, java.lang.String[] r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 2454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONProvider.query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x09bf: MOVE (r5 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:279:0x09bf */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008e A[Catch: SQLiteConstraintException -> 0x00e2, all -> 0x09be, Exception -> 0x09c1, SQLiteException -> 0x09c5, SQLiteDiskIOException -> 0x09c9, SQLiteFullException -> 0x09cd, TryCatch #10 {all -> 0x09be, blocks: (B:14:0x008a, B:16:0x008e, B:17:0x00b1, B:22:0x00bf, B:24:0x00c5, B:25:0x00c9, B:27:0x00cf, B:268:0x0971, B:30:0x00e3, B:38:0x011e, B:41:0x0136, B:44:0x0148, B:47:0x0160, B:50:0x0176, B:118:0x0408, B:121:0x041a, B:138:0x04cf, B:139:0x04d2, B:141:0x04d6, B:156:0x05cb, B:158:0x05d2, B:175:0x06e7, B:177:0x06f0, B:184:0x0777, B:188:0x0798, B:191:0x07aa, B:194:0x07ba, B:197:0x07cc, B:200:0x07de, B:203:0x07f0, B:206:0x0802, B:209:0x0814, B:212:0x0826, B:215:0x0836, B:218:0x0848, B:221:0x0858, B:224:0x0868, B:227:0x087a, B:230:0x088c, B:233:0x089e, B:236:0x08ae, B:246:0x08e5, B:267:0x096b), top: B:299:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0978  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cf A[Catch: SQLiteConstraintException -> 0x00e2, all -> 0x09be, Exception -> 0x09c1, SQLiteException -> 0x09c5, SQLiteDiskIOException -> 0x09c9, SQLiteFullException -> 0x09cd, LOOP:0: B:25:0x00c9->B:27:0x00cf, LOOP_END, TRY_LEAVE, TryCatch #10 {all -> 0x09be, blocks: (B:14:0x008a, B:16:0x008e, B:17:0x00b1, B:22:0x00bf, B:24:0x00c5, B:25:0x00c9, B:27:0x00cf, B:268:0x0971, B:30:0x00e3, B:38:0x011e, B:41:0x0136, B:44:0x0148, B:47:0x0160, B:50:0x0176, B:118:0x0408, B:121:0x041a, B:138:0x04cf, B:139:0x04d2, B:141:0x04d6, B:156:0x05cb, B:158:0x05d2, B:175:0x06e7, B:177:0x06f0, B:184:0x0777, B:188:0x0798, B:191:0x07aa, B:194:0x07ba, B:197:0x07cc, B:200:0x07de, B:203:0x07f0, B:206:0x0802, B:209:0x0814, B:212:0x0826, B:215:0x0836, B:218:0x0848, B:221:0x0858, B:224:0x0868, B:227:0x087a, B:230:0x088c, B:233:0x089e, B:236:0x08ae, B:246:0x08e5, B:267:0x096b), top: B:299:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:292:0x09dd A[PHI: r4 r6
  0x09dd: PHI (r4v111 android.net.Uri) = (r4v98 android.net.Uri), (r4v114 android.net.Uri) binds: [B:157:0x05d0, B:140:0x04d4] A[DONT_GENERATE, DONT_INLINE]
  0x09dd: PHI (r6v36 long) = (r6v32 long), (r6v37 long) binds: [B:157:0x05d0, B:140:0x04d4] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.net.Uri insert(android.net.Uri r18, android.content.ContentValues r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2678
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONProvider.insert(android.net.Uri, android.content.ContentValues):android.net.Uri");
    }

    /* renamed from: a */
    private void m12422a(SQLiteDatabase sQLiteDatabase, String str, ArrayList<String> arrayList, EnumC2300t enumC2300t) throws Throwable {
        ContentValues contentValues = new ContentValues(2);
        if (!sQLiteDatabase.isOpen() && C4904y.f17872b) {
            C4904y.m18639b("insertSmsParticipants  but db is not opened", getClass().getSimpleName());
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (TextUtils.isEmpty(next)) {
                if (C4904y.f17873c) {
                    C4904y.m18641c("SMS participants no is null!!", "ChatONProvider");
                }
            } else {
                contentValues.put("participants_inbox_no", str);
                C2208v c2208v = new C2208v(next);
                String strM10060a = c2208v.m10060a();
                if (TextUtils.isEmpty(strM10060a)) {
                    strM10060a = c2208v.m10061b();
                    if (C4904y.f17873c) {
                        C4904y.m18641c("Normalized number is null - number : " + next, "ChatONProvider");
                    }
                }
                contentValues.put("participants_sms_address", strM10060a);
                String strM12419a = m12419a(sQLiteDatabase, c2208v);
                if (TextUtils.isEmpty(strM12419a)) {
                    strM12419a = c2208v.m10061b();
                }
                contentValues.put("participants_buddy_no", strM12419a);
                if (enumC2300t == EnumC2300t.GROUPCHAT) {
                    contentValues.put("participants_user_type", EnumC1109f.INVITED.m7095a());
                }
                sQLiteDatabase.insertOrThrow("participant", null, contentValues);
                contentValues.clear();
            }
        }
    }

    /* renamed from: a */
    private int m12411a(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        Cursor cursorQuery = sQLiteDatabase.query("inbox", new String[]{"inbox_unread_count"}, "inbox_no = ?", new String[]{contentValues.getAsString("inbox_no")}, null, null, null);
        if (cursorQuery == null) {
            return 0;
        }
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
        }
    }

    /*  JADX ERROR: Types fix failed
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:439)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:232)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:212)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:183)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:112)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:83)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:56)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:183)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:242)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:221)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:91)
        */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x00cf: MOVE (r5 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:29:0x00cf */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0432: MOVE (r5 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:85:0x0432 */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x046e: MOVE (r5 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:97:0x046e */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0669: MOVE (r5 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:146:0x0669 */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x066c: MOVE (r5 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:148:0x066c */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x066f: MOVE (r5 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:150:0x066f */
    @Override // android.content.ContentProvider
    public int update(android.net.Uri r16, android.content.ContentValues r17, java.lang.String r18, java.lang.String[] r19) {
        /*
            Method dump skipped, instructions count: 1724
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONProvider.update(android.net.Uri, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01e4  */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v5 */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int delete(android.net.Uri r6, java.lang.String r7, java.lang.String[] r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 537
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONProvider.delete(android.net.Uri, java.lang.String, java.lang.String[]):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        if (!C1041a.m6138a(getContext(), Binder.getCallingUid())) {
            throw new SecurityException("Access Token is invalid.");
        }
        int iMatch = f11238a.match(uri);
        C4904y.m18639b("openFile : uri = " + uri.toString(), getClass().getSimpleName());
        switch (iMatch) {
            case 102:
                if ("r".equals(str)) {
                    return ParcelFileDescriptor.open(new File(getContext().getFilesDir(), C4855bt.m18355c(uri.getLastPathSegment())), 268435456);
                }
                return null;
            case 202:
                if ("r".equals(str)) {
                    return ParcelFileDescriptor.open(new File(getContext().getFilesDir(), C4855bt.m18356d(uri.getLastPathSegment())), 268435456);
                }
                return null;
            case 401:
                if ("r".equals(str)) {
                    return ParcelFileDescriptor.open(new File(getContext().getFilesDir(), C4855bt.m18354b(uri.getLastPathSegment())), 268435456);
                }
                return null;
            default:
                return null;
        }
    }

    /* renamed from: b */
    private static UriMatcher m12427b() {
        UriMatcher uriMatcher = new UriMatcher(-1);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/buddy_no/*", 102);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/buddy_count", 111);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/hide_buddy_count", 117);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/participants_no_same", 108);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/participants", 107);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/unknown_calllogs", 118);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/profile", 106);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/group", 103);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/alphabetical", 104);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/alphabetical2", 109);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/alphabetical2_sms", 10001);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/relation", 105);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/alphabetical_special", 110);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/get_hide_buddy", 112);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/buddygroup_chatonv", 115);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy/buddy_included_group", 116);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy", 100);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy_group/group_info", 203);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy_group/group_name/*", 202);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy_group/group_refresh", 714);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy_group/*", 201);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy_group", 200);
        uriMatcher.addURI("com.sec.chaton.provider", "contacts/conatct_number/*", 302);
        uriMatcher.addURI("com.sec.chaton.provider", "contacts/*", 301);
        uriMatcher.addURI("com.sec.chaton.provider", "contacts", 300);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation/group_relation_group/*", 711);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation/group_relation_buddy/*", 712);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation/group", 713);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation/buddy_in", 701);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation/buddy_not_in", 702);
        uriMatcher.addURI("com.sec.chaton.provider", "grouprelation", 700);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/update_unread_count_live/*/*", 4400);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/chat_list_sync", 4100);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/update_unread_count", 4200);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/update_inbox_with_current_unread_count", 412);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/update_for_push", 410);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/get_inbox_no", 406);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/get_or_make_inbox_no", 416);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/inbox_title_for_search", 411);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/update_title", 422);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/inbox_invalid_update", 405);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/group_title_update", 404);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/buddy_participant_join", 403);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/buddy_participant_join_for_list", 407);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/buddy_participant_join_for_list_of_forward", 408);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/buddy_participant_join_for_list_of_forward_sms_only", 413);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/search_buddy_participant_join_for_list_of_forward_sms_only", 421);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/buddy_participant_join_for_list_of_forward_sms_only_except_broadcast", 415);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/buddy_participant_join_for_list_of_forward_chaton_only", 414);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/search_buddy_participant_join_for_list_of_forward_chaton_only", 419);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/buddy_participant_join_for_list_of_forward_without_topic", 417);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/search_buddy_participant_join_for_list_of_forward_without_topic", 418);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/buddy_participant_join_for_list_of_poll", 409);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/inbox_no", 402);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/inbox_join_for_sms_mapping", 6101);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/inbox_join_sms_mapping", 6102);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/fullsearch", 420);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/sms", 469);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox/*", 401);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox", AMSLibs.ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox_buddy_relation", 461);
        uriMatcher.addURI("com.sec.chaton.provider", "message/read_ack", 504);
        uriMatcher.addURI("com.sec.chaton.provider", "message/message_sever_id/*", 502);
        uriMatcher.addURI("com.sec.chaton.provider", "message/message_buddy", 505);
        uriMatcher.addURI("com.sec.chaton.provider", "message/message_buddy/*", 509);
        uriMatcher.addURI("com.sec.chaton.provider", "message/message_buddy_noti/*", 513);
        uriMatcher.addURI("com.sec.chaton.provider", "message/media", 514);
        uriMatcher.addURI("com.sec.chaton.provider", "message/get_pendings", 515);
        uriMatcher.addURI("com.sec.chaton.provider", "message/message_for_livechat_feedback", 517);
        uriMatcher.addURI("com.sec.chaton.provider", "message/update_cancel_sending_status", 518);
        uriMatcher.addURI("com.sec.chaton.provider", "message/update", MotionRecognitionManager.EVENT_VOLUME_DOWN);
        uriMatcher.addURI("com.sec.chaton.provider", "message/delete", 511);
        uriMatcher.addURI("com.sec.chaton.provider", "message/count/*", 510);
        uriMatcher.addURI("com.sec.chaton.provider", "message/send", 506);
        uriMatcher.addURI("com.sec.chaton.provider", "message/received", 507);
        uriMatcher.addURI("com.sec.chaton.provider", "message/send/inbox", 508);
        uriMatcher.addURI("com.sec.chaton.provider", "message/message_for_search", 516);
        uriMatcher.addURI("com.sec.chaton.provider", "message/*", 501);
        uriMatcher.addURI("com.sec.chaton.provider", VKApiConst.MESSAGE, 500);
        uriMatcher.addURI("com.sec.chaton.provider", "relation/insert", 604);
        uriMatcher.addURI("com.sec.chaton.provider", "relation/day", 603);
        uriMatcher.addURI("com.sec.chaton.provider", "relation", 600);
        uriMatcher.addURI("com.sec.chaton.provider", "participant/withphone/*", 4300);
        uriMatcher.addURI("com.sec.chaton.provider", "participant/name_join_buddy", 802);
        uriMatcher.addURI("com.sec.chaton.provider", "participant/join_sms_buddy_buddyinfo", 803);
        uriMatcher.addURI("com.sec.chaton.provider", "participant/join_chat_buddy_buddyinfo", 804);
        uriMatcher.addURI("com.sec.chaton.provider", "participant/join_chat_specialbuddy_livebuddyinfo", 805);
        uriMatcher.addURI("com.sec.chaton.provider", "participant/insert_invited_contact_buddy/*/*", 4301);
        uriMatcher.addURI("com.sec.chaton.provider", "participant/participant_without_contact_buddy/*", 4302);
        uriMatcher.addURI("com.sec.chaton.provider", "participant/*", 801);
        uriMatcher.addURI("com.sec.chaton.provider", "participant", 800);
        uriMatcher.addURI("com.sec.chaton.provider", "memo", 900);
        uriMatcher.addURI("com.sec.chaton.provider", "memo_sessions", 901);
        uriMatcher.addURI("com.sec.chaton.provider", "poston", 902);
        uriMatcher.addURI("com.sec.chaton.provider", "my_poston", 906);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy_poston", 907);
        uriMatcher.addURI("com.sec.chaton.provider", "poston_comments", 903);
        uriMatcher.addURI("com.sec.chaton.provider", "my_multimedia_poston", 912);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy_multimedia_poston", 913);
        uriMatcher.addURI("com.sec.chaton.provider", "cover_story_sample", 914);
        uriMatcher.addURI("com.sec.chaton.provider", "profile_image", 915);
        uriMatcher.addURI("com.sec.chaton.provider", "poston/joined_buddy", 904);
        uriMatcher.addURI("com.sec.chaton.provider", "poston_comments/joined_buddy", 905);
        uriMatcher.addURI("com.sec.chaton.provider", "my_poston/joined_buddy", 908);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy_poston/joined_buddy", 909);
        uriMatcher.addURI("com.sec.chaton.provider", "my_multimedia_poston/joined_my_multimedia", 910);
        uriMatcher.addURI("com.sec.chaton.provider", "buddy_multimedia_poston/joined_buddy_multimedia", 911);
        uriMatcher.addURI("com.sec.chaton.provider", "recommendee", 1000);
        uriMatcher.addURI("com.sec.chaton.provider", "recommendee/recommendee_count", 1001);
        uriMatcher.addURI("com.sec.chaton.provider", "specialbuddy", 2000);
        uriMatcher.addURI("com.sec.chaton.provider", "specialbuddy/specialbuddy_count", 2001);
        uriMatcher.addURI("com.sec.chaton.provider", "specialbuddy/specialbuddy_join_participants", 2002);
        uriMatcher.addURI("com.sec.chaton.provider", "me", 1100);
        uriMatcher.addURI("com.sec.chaton.provider", "myextrainfo", 1200);
        uriMatcher.addURI("com.sec.chaton.provider", "buddyextrainfo/#", 1300);
        uriMatcher.addURI("com.sec.chaton.provider", "buddyextrainfoall", 1400);
        uriMatcher.addURI("com.sec.chaton.provider", "message_notification", 3000);
        uriMatcher.addURI("com.sec.chaton.provider", "message_notification/parse_message_noti", 3001);
        uriMatcher.addURI("com.sec.chaton.provider", "participant_mapping", 4000);
        uriMatcher.addURI("com.sec.chaton.provider", "inbox_session_id_mapping", 471);
        uriMatcher.addURI("com.sec.chaton.provider", "setting_info", 5000);
        uriMatcher.addURI("com.sec.chaton.provider", "inboxsms_mapping", 6100);
        uriMatcher.addURI("com.sec.chaton.provider", "unknownbuddy", 6000);
        uriMatcher.addURI("com.sec.chaton.provider", C5052r.m19199a("huge_file_upload_mapping"), 7000);
        uriMatcher.addURI("com.sec.chaton.provider", C5052r.m19199a("multichannel_upload"), 7001);
        uriMatcher.addURI("com.sec.chaton.provider", C5052r.m19199a("multichannel_upload", "/", "huge_file_upload_mapping"), 7002);
        uriMatcher.addURI("com.sec.chaton.provider", C5052r.m19199a("multichannel_upload", "/", "request_id", "/*"), 7003);
        uriMatcher.addURI("com.sec.chaton.provider", "phone_numbers_equal", 470);
        return uriMatcher;
    }

    /* renamed from: a */
    private C2283cb m12418a(Uri uri, int i) {
        C2283cb c2283cb = new C2283cb();
        switch (i) {
            case 100:
                return c2283cb.m10145a("buddy");
            case 102:
                return c2283cb.m10145a("buddy").m10146a("buddy_no=?", C2289i.m10164b(uri));
            case 103:
                return c2283cb.m10145a(InterfaceC2269bo.f8066a);
            case 104:
                return c2283cb.m10145a(InterfaceC2269bo.f8067b);
            case 105:
                return c2283cb.m10145a(InterfaceC2269bo.f8076k);
            case 106:
                return c2283cb.m10145a(InterfaceC2269bo.f8077l);
            case 107:
                return c2283cb.m10145a(InterfaceC2269bo.f8072g);
            case 108:
                return c2283cb.m10145a(InterfaceC2269bo.f8075j);
            case 109:
                return c2283cb.m10145a(InterfaceC2269bo.f8069d);
            case 110:
                return c2283cb.m10145a(InterfaceC2269bo.f8074i);
            case 111:
                return c2283cb.m10145a(InterfaceC2269bo.f8080o);
            case 112:
                return c2283cb.m10145a(InterfaceC2269bo.f8082q);
            case 115:
                return c2283cb.m10145a("(select buddy_no from buddy where buddy_extra_info like '%voip=1%' and length(buddy_sainfo) > 0 intersect select distinct buddy_no from grouprelation a left outer join buddy as b on a.group_relation_buddy = b.buddy_no)");
            case 116:
                return c2283cb.m10145a("(SELECT r.group_relation_buddy AS buddy_no, g._id AS _id, g.group_name AS group_name FROM grouprelation r JOIN buddy_group g ON r.group_relation_group=g._id WHERE g._id <> 1)");
            case 117:
                return c2283cb.m10145a(InterfaceC2269bo.f8081p);
            case 118:
                return c2283cb.m10145a(InterfaceC2269bo.f8073h);
            case 200:
                return c2283cb.m10145a("buddy_group");
            case 201:
                return c2283cb.m10145a("buddy_group").m10146a("_id=?", C2294n.m10183a(uri));
            case 203:
                return c2283cb.m10145a(InterfaceC2271bq.f8088a);
            case 300:
                return c2283cb.m10145a("contacts");
            case 301:
                return c2283cb.m10145a("contacts").m10146a("_id=?", C2290j.m10177a(uri));
            case 302:
                return c2283cb.m10145a("contacts").m10146a("conatct_number=?", C2290j.m10178b(uri));
            case AMSLibs.ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE /* 400 */:
                return c2283cb.m10145a("inbox");
            case 401:
                return c2283cb.m10145a("inbox").m10146a("_id=?", C2299s.m10187a(uri));
            case 402:
                return c2283cb.m10145a("inbox").m10146a("inbox_no=?", C2299s.m10189b(uri));
            case 403:
                return c2283cb.m10145a(InterfaceC2273bs.f8092a);
            case 404:
                return c2283cb.m10145a(InterfaceC2273bs.f8103l);
            case 406:
                return c2283cb.m10145a(InterfaceC2273bs.f8092a);
            case 407:
                return c2283cb.m10145a(InterfaceC2273bs.f8093b);
            case 408:
                return c2283cb.m10145a(InterfaceC2273bs.f8094c);
            case 409:
                return c2283cb.m10145a(InterfaceC2273bs.f8102k);
            case 413:
                return c2283cb.m10145a(InterfaceC2273bs.f8095d);
            case 414:
                return c2283cb.m10145a(InterfaceC2273bs.f8098g);
            case 415:
                return c2283cb.m10145a(InterfaceC2273bs.f8097f);
            case 416:
                return c2283cb.m10145a(InterfaceC2273bs.f8092a);
            case 417:
                return c2283cb.m10145a(InterfaceC2273bs.f8100i);
            case 461:
                return c2283cb.m10145a("inbox_buddy_relation");
            case 462:
                return c2283cb.m10145a("SELECT * FROM ( SELECT * FROM inbox_buddy_relation WHERE buddy_no =? ) a  LEFT OUTER JOIN inbox b  WHERE a.inbox_no = b.inbox_no");
            case 471:
                return c2283cb.m10145a("inbox_session_id_mapping");
            case 500:
                return c2283cb.m10145a(VKApiConst.MESSAGE);
            case 501:
                String strM10216a = C2306z.m10216a(uri);
                return c2283cb.m10145a(VKApiConst.MESSAGE).m10146a(strM10216a + "=?", strM10216a);
            case 502:
                String strM10221b = C2306z.m10221b(uri);
                return c2283cb.m10145a(VKApiConst.MESSAGE).m10146a(strM10221b + "=?", strM10221b);
            case 505:
                return c2283cb.m10145a(InterfaceC2279by.f8167a);
            case 511:
                return c2283cb.m10145a(VKApiConst.MESSAGE);
            case 600:
                return c2283cb.m10145a("relation");
            case 603:
                return c2283cb.m10145a(InterfaceC2277bw.f8118a);
            case 700:
                return c2283cb.m10145a("grouprelation");
            case 701:
                return c2283cb.m10145a(InterfaceC2272br.f8089a);
            case 702:
                return c2283cb.m10145a(InterfaceC2272br.f8090b);
            case 711:
                return c2283cb.m10145a("grouprelation").m10146a("group_relation_group=?", C2293m.m10182b(uri));
            case 712:
                return c2283cb.m10145a("grouprelation").m10146a("group_relation_buddy=?", C2293m.m10181a(uri));
            case 713:
                return c2283cb.m10145a(InterfaceC2272br.f8091c);
            case 714:
                return c2283cb.m10145a(InterfaceC2269bo.f8084s);
            case 800:
                return c2283cb.m10145a(InterfaceC2279by.f8172f);
            case 801:
                return c2283cb.m10145a(InterfaceC2279by.f8172f).m10146a("participants_inbox_no=?", C2220ah.m10088a(uri));
            case 802:
                return c2283cb.m10145a(InterfaceC2279by.f8173g);
            case 803:
                return c2283cb.m10145a(InterfaceC2279by.f8174h);
            case 804:
                return c2283cb.m10145a(InterfaceC2279by.f8175i);
            case 805:
                return c2283cb.m10145a(InterfaceC2279by.f8176j);
            case 900:
                return c2283cb.m10145a("memo");
            case 901:
                return c2283cb.m10145a("memo_sessions");
            case 902:
                return c2283cb.m10145a("poston");
            case 903:
                return c2283cb.m10145a("poston_comments");
            case 904:
                return c2283cb.m10145a(InterfaceC2275bu.f8111a);
            case 905:
                return c2283cb.m10145a(InterfaceC2275bu.f8114d);
            case 906:
                return c2283cb.m10145a("my_poston");
            case 907:
                return c2283cb.m10145a("buddy_poston");
            case 908:
                return c2283cb.m10145a(InterfaceC2275bu.f8112b);
            case 909:
                return c2283cb.m10145a(InterfaceC2275bu.f8113c);
            case 910:
                return c2283cb.m10145a(InterfaceC2275bu.f8115e);
            case 911:
                return c2283cb.m10145a(InterfaceC2275bu.f8116f);
            case 912:
                return c2283cb.m10145a("my_multimedia_poston");
            case 913:
                return c2283cb.m10145a("buddy_multimedia_poston");
            case 914:
                return c2283cb.m10145a("cover_story_sample");
            case 915:
                return c2283cb.m10145a("profile_image");
            case 1000:
                return c2283cb.m10145a("recommendee");
            case 1001:
                return c2283cb.m10145a(InterfaceC2269bo.f8085t);
            case 1300:
            case 1400:
                return c2283cb.m10145a(InterfaceC2269bo.f8079n);
            case 2000:
                return c2283cb.m10145a("specialbuddy");
            case 2001:
                return c2283cb.m10145a(InterfaceC2269bo.f8083r);
            case 3000:
                return c2283cb.m10145a("message_notification");
            case 4000:
                return c2283cb.m10145a("participant_mapping");
            case 4302:
                return c2283cb.m10145a(InterfaceC2279by.f8172f).m10146a("participants_inbox_no=? AND participants_user_type!=" + EnumC1109f.INVITED.m7095a() + " AND participants_user_type!=" + EnumC1109f.INVITING.m7095a(), uri.getPathSegments().get(2));
            case 6000:
                return c2283cb.m10145a("unknownbuddy");
            case 6100:
                return c2283cb.m10145a("inboxsms_mapping");
            case 6101:
                return c2283cb.m10145a(InterfaceC2273bs.f8106o);
            case 6102:
                return c2283cb.m10145a("( SELECT x.*, s.sms_unread_count, s.inboxsms_mapping_sms_no FROM inbox x LEFT OUTER JOIN ( SELECT inboxsms_mapping_inbox_no AS inbox_no, inboxsms_mapping_sms_no, SUM(inboxsms_mapping_unread_count) AS sms_unread_count FROM inboxsms_mapping GROUP BY inboxsms_mapping_inbox_no ) s ON x.inbox_no = s.inbox_no )");
            case 7000:
                return c2283cb.m10145a("huge_file_upload_mapping");
            case 7001:
                return c2283cb.m10145a("multichannel_upload");
            case 10001:
                return c2283cb.m10145a(InterfaceC2269bo.f8068c);
            default:
                return null;
        }
    }

    /* renamed from: b */
    private C2283cb m12429b(Uri uri, int i) {
        C2283cb c2283cb = new C2283cb();
        switch (i) {
            case 100:
                return c2283cb.m10145a("buddy");
            case 102:
                return c2283cb.m10145a("buddy").m10146a("buddy_no=?", C2289i.m10164b(uri));
            case 200:
                return c2283cb.m10145a("buddy_group");
            case 201:
                return c2283cb.m10145a("buddy_group").m10146a("_id=?", C2294n.m10183a(uri));
            case 300:
                return c2283cb.m10145a("contacts");
            case 301:
                return c2283cb.m10145a("contacts").m10146a("_id=?", C2290j.m10177a(uri));
            case 302:
                return c2283cb.m10145a("contacts").m10146a("conatct_number=?", C2290j.m10178b(uri));
            case AMSLibs.ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE /* 400 */:
                return c2283cb.m10145a("inbox");
            case 401:
                return c2283cb.m10145a("inbox").m10146a("_id=?", C2299s.m10187a(uri));
            case 402:
                return c2283cb.m10145a("inbox").m10146a("inbox_no=?", C2299s.m10189b(uri));
            case 461:
                return c2283cb.m10145a("inbox_buddy_relation");
            case 469:
                return c2283cb.m10145a("inbox").m10146a("inbox_room_type=" + EnumC2301u.SMS.m10212a(), new String[0]);
            case 471:
                return c2283cb.m10145a("inbox_session_id_mapping");
            case 500:
                return c2283cb.m10145a(VKApiConst.MESSAGE);
            case 501:
                String strM10216a = C2306z.m10216a(uri);
                return c2283cb.m10145a(VKApiConst.MESSAGE).m10146a(strM10216a + "=?", strM10216a);
            case 502:
                String strM10221b = C2306z.m10221b(uri);
                return c2283cb.m10145a(VKApiConst.MESSAGE).m10146a(strM10221b + "=?", strM10221b);
            case 504:
                return c2283cb.m10145a(InterfaceC2282ca.f8185a);
            case 511:
                return c2283cb.m10145a(VKApiConst.MESSAGE);
            case MotionRecognitionManager.EVENT_VOLUME_DOWN /* 512 */:
                return c2283cb.m10145a(VKApiConst.MESSAGE);
            case 600:
                return c2283cb.m10145a("relation");
            case 700:
                return c2283cb.m10145a("grouprelation");
            case 711:
                return c2283cb.m10145a("grouprelation").m10146a("group_relation_group=?", C2293m.m10182b(uri));
            case 712:
                return c2283cb.m10145a("grouprelation").m10146a("group_relation_buddy=?", C2293m.m10181a(uri));
            case 800:
                return c2283cb.m10145a("participant");
            case 801:
                String strM10088a = C2220ah.m10088a(uri);
                return c2283cb.m10145a("participant").m10146a(strM10088a + "=?", strM10088a);
            case 802:
                return c2283cb.m10145a(InterfaceC2279by.f8173g);
            case 900:
                return c2283cb.m10145a("memo");
            case 901:
                return c2283cb.m10145a("memo_sessions");
            case 902:
                return c2283cb.m10145a("poston");
            case 903:
                return c2283cb.m10145a("poston_comments");
            case 906:
                return c2283cb.m10145a("my_poston");
            case 907:
                return c2283cb.m10145a("buddy_poston");
            case 912:
                return c2283cb.m10145a("my_multimedia_poston");
            case 913:
                return c2283cb.m10145a("buddy_multimedia_poston");
            case 914:
                return c2283cb.m10145a("cover_story_sample");
            case 915:
                return c2283cb.m10145a("profile_image");
            case 1000:
                return c2283cb.m10145a("recommendee");
            case 2000:
                return c2283cb.m10145a("specialbuddy");
            case 3000:
                return c2283cb.m10145a("message_notification");
            case 3001:
                return c2283cb.m10145a("SELECT noti_buddy_no,noti_inbox_no,noti_sent_time,noti_message,noti_chat_type,noti_msg_type,buddy_name FROM message_notification n LEFT OUTER JOIN (SELECT p.participants_buddy_no AS buddy_no,ifnull (b.buddy_name, p.participants_buddy_name)  AS buddy_name, p.participants_inbox_no FROM participant p LEFT OUTER JOIN (SELECT buddy_no,buddy_name FROM buddy UNION ALL SELECT buddy_no AS buddy_no,buddy_name AS buddy_name FROM specialbuddy) b ON p.participants_buddy_no=b.buddy_no) j ON n.noti_inbox_no=j.participants_inbox_no AND n.noti_buddy_no=j.buddy_no ORDER BY n.noti_sent_time DESC;");
            case 4000:
                return c2283cb.m10145a("participant_mapping");
            case 6000:
                return c2283cb.m10145a("unknownbuddy");
            case 6100:
                return c2283cb.m10145a("inboxsms_mapping");
            case 7000:
                return c2283cb.m10145a("huge_file_upload_mapping");
            case 7001:
                return c2283cb.m10145a("multichannel_upload");
            default:
                return c2283cb;
        }
    }

    /* renamed from: b */
    private long m12426b(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        try {
            return sQLiteDatabase.insertOrThrow("cover_story_sample", null, contentValues);
        } catch (SQLiteConstraintException e) {
            if (!contentValues.containsKey("coverstory_id")) {
                return 0L;
            }
            return sQLiteDatabase.update("cover_story_sample", contentValues, "coverstory_id=?", new String[]{contentValues.getAsString("coverstory_id")});
        }
    }

    /* renamed from: a */
    private long m12414a(SQLiteDatabase sQLiteDatabase, int i, Uri uri, ContentValues contentValues) throws Throwable {
        Uri uri2;
        String str;
        String strM19199a;
        String[] strArr;
        int iUpdate = 0;
        if (!sQLiteDatabase.isOpen() && C4904y.f17872b) {
            C4904y.m18639b("insertOrUpdate  but db is not opened", getClass().getSimpleName());
        }
        boolean zM12423a = m12423a(uri, "replace", false);
        switch (i) {
            case 906:
                uri2 = C2225am.f7951a;
                str = "my_poston";
                strM19199a = C5052r.m19199a("poston_id", "=?");
                strArr = new String[]{contentValues.getAsString("poston_id")};
                uri2.buildUpon().appendPath(contentValues.getAsString("poston_id")).build();
                break;
            case 912:
                uri2 = C2224al.f7949a;
                str = "my_multimedia_poston";
                strM19199a = C5052r.m19199a("poston_metaid", "=?");
                strArr = new String[]{contentValues.getAsString("poston_metaid")};
                uri2.buildUpon().appendPath(contentValues.getAsString("poston_metaid")).build();
                break;
            case 915:
                uri2 = C2227ao.f7955a;
                str = "profile_image";
                strM19199a = C5052r.m19199a("profile_image_id", "=?");
                strArr = new String[]{contentValues.getAsString("profile_image_id")};
                uri2.buildUpon().appendPath(contentValues.getAsString("profile_image_id")).build();
                break;
            default:
                strArr = null;
                strM19199a = null;
                str = null;
                uri2 = null;
                break;
        }
        if (!zM12423a || (iUpdate = update(uri2, contentValues, strM19199a, strArr)) == 0) {
            sQLiteDatabase.insert(str, null, contentValues);
        }
        return iUpdate;
    }

    /* renamed from: a */
    private boolean m12423a(Uri uri, String str, boolean z) {
        String queryParameter;
        return (uri == null || (queryParameter = uri.getQueryParameter(str)) == null) ? z : Boolean.parseBoolean(queryParameter);
    }

    /* renamed from: c */
    private long m12433c(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        if (!sQLiteDatabase.isOpen() && C4904y.f17872b) {
            C4904y.m18639b("buddyInsertOrUpdate  but db is not opened", getClass().getSimpleName());
        }
        try {
            return sQLiteDatabase.insertOrThrow("buddy", null, contentValues);
        } catch (SQLiteConstraintException e) {
            if (!contentValues.containsKey("buddy_no")) {
                return 0L;
            }
            return sQLiteDatabase.update("buddy", contentValues, "buddy_no=?", new String[]{contentValues.getAsString("buddy_no")});
        }
    }

    /* renamed from: d */
    private long m12435d(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        if (!sQLiteDatabase.isOpen() && C4904y.f17872b) {
            C4904y.m18639b("specialBuddyInsertOrUpdate  but db is not opened", getClass().getSimpleName());
        }
        try {
            return sQLiteDatabase.insertOrThrow("specialbuddy", null, contentValues);
        } catch (SQLiteConstraintException e) {
            if (!contentValues.containsKey("buddy_no")) {
                return 0L;
            }
            return sQLiteDatabase.update("specialbuddy", contentValues, "buddy_no=?", new String[]{contentValues.getAsString("buddy_no")});
        }
    }

    /* renamed from: e */
    private long m12436e(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        if (!sQLiteDatabase.isOpen() && C4904y.f17872b) {
            C4904y.m18639b("recommendeeInsertOrUpdate  but db is not opened", getClass().getSimpleName());
        }
        try {
            return sQLiteDatabase.insertOrThrow("recommendee", null, contentValues);
        } catch (SQLiteConstraintException e) {
            if (!contentValues.containsKey("buddy_no")) {
                return 0L;
            }
            return sQLiteDatabase.update("recommendee", contentValues, "buddy_no=?", new String[]{contentValues.getAsString("buddy_no")});
        }
    }

    /* renamed from: f */
    private long m12437f(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        if (!sQLiteDatabase.isOpen() && C4904y.f17872b) {
            C4904y.m18639b("unknownBuddyInsertOrUpdate  but db is not opened", getClass().getSimpleName());
        }
        try {
            return sQLiteDatabase.insertOrThrow("unknownbuddy", null, contentValues);
        } catch (SQLiteConstraintException e) {
            if (!contentValues.containsKey("buddy_no")) {
                return 0L;
            }
            return sQLiteDatabase.update("unknownbuddy", contentValues, "buddy_no=?", new String[]{contentValues.getAsString("buddy_no")});
        }
    }

    @Deprecated
    /* renamed from: g */
    private long m12438g(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        C4904y.m18646e("memoSessionInsertOrUpdatert", "ChatONProvider");
        String[] strArr = {contentValues.getAsString("buddy_no")};
        try {
            return sQLiteDatabase.insertOrThrow("memo_sessions", null, contentValues);
        } catch (SQLiteConstraintException e) {
            if (!contentValues.containsKey("buddy_no")) {
                return 0L;
            }
            return sQLiteDatabase.update("memo_sessions", contentValues, "buddy_no=?", strArr);
        }
    }

    /* renamed from: h */
    private long m12439h(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) throws Throwable {
        Cursor cursorQuery;
        if (!sQLiteDatabase.isOpen() && C4904y.f17872b) {
            C4904y.m18639b("inboxInsert  but db is not opened", getClass().getSimpleName());
        }
        sQLiteDatabase.beginTransaction();
        try {
            if (EnumC2300t.ONETOONE.m10210a() == contentValues.getAsInteger("inbox_chat_type").intValue()) {
                String asString = contentValues.getAsString("buddy_no");
                cursorQuery = sQLiteDatabase.query("inbox_buddy_relation", null, "buddy_no = ?", new String[]{asString}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.moveToFirst();
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no"));
                            if (!string.equals(contentValues.getAsString("inbox_no"))) {
                                ContentValues contentValues2 = new ContentValues();
                                contentValues2.put("inbox_valid", "N");
                                contentValues2.put("inbox_title_fixed", "Y");
                                sQLiteDatabase.update("inbox", contentValues2, "inbox_no = ?", new String[]{string});
                                sQLiteDatabase.delete("inbox_buddy_relation", "buddy_no = ?", new String[]{asString});
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        sQLiteDatabase.endTransaction();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        throw th;
                    }
                }
                m12415a(sQLiteDatabase, contentValues.getAsString("inbox_no"), asString, EnumC2300t.m10207a(contentValues.getAsInteger("inbox_chat_type").intValue()));
                contentValues.remove("buddy_no");
            } else {
                cursorQuery = null;
            }
            long jInsertOrThrow = sQLiteDatabase.insertOrThrow("inbox", null, contentValues);
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return jInsertOrThrow;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* renamed from: i */
    private int m12440i(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) throws Throwable {
        Cursor cursor;
        Cursor cursorQuery;
        int iUpdate = 0;
        if (!sQLiteDatabase.isOpen() && C4904y.f17872b) {
            C4904y.m18639b("updateInboxToInvalid  but db is not opened", getClass().getSimpleName());
        }
        sQLiteDatabase.beginTransaction();
        try {
            String asString = contentValues.getAsString("buddy_no");
            Cursor cursorQuery2 = sQLiteDatabase.query("inbox_buddy_relation", null, "buddy_no = ?", new String[]{asString}, null, null, null);
            if (cursorQuery2 != null) {
                try {
                    if (cursorQuery2.getCount() > 0) {
                        cursorQuery2.moveToFirst();
                        String string = cursorQuery2.getString(cursorQuery2.getColumnIndex("inbox_no"));
                        if (!TextUtils.isEmpty(string) && (cursorQuery = sQLiteDatabase.query("inbox", new String[]{"inbox_valid"}, "inbox_no = ?", new String[]{asString}, null, null, null)) != null && cursorQuery.getCount() > 0) {
                            cursorQuery.moveToFirst();
                            if ("N".equals(cursorQuery.getString(0))) {
                                sQLiteDatabase.endTransaction();
                                if (cursorQuery2 != null) {
                                    cursorQuery2.close();
                                }
                                return 0;
                            }
                        }
                        sQLiteDatabase.delete("inbox_buddy_relation", "buddy_no = ?", new String[]{asString});
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("inbox_valid", "N");
                        contentValues2.put("inbox_title_fixed", "Y");
                        iUpdate = sQLiteDatabase.update("inbox", contentValues2, "inbox_no = ?", new String[]{string});
                        long jLongValue = contentValues.getAsLong("message_time").longValue();
                        ContentValues contentValues3 = new ContentValues();
                        contentValues3.put("_id", Long.valueOf(C4843bh.m18322a()));
                        contentValues3.put("message_inbox_no", string);
                        contentValues3.put("message_type", (Integer) 1);
                        contentValues3.put("message_content_type", Integer.valueOf(EnumC2214ab.SYSTEM.m10076a()));
                        if (contentValues.getAsBoolean("KEY_DEACTIVATED").booleanValue()) {
                            contentValues3.put("message_content", String.format("%d,%s,%s", Integer.valueOf(EnumC2231as.DEACTIVATED.m10100a()), asString, "deactivated"));
                            ContentValues contentValues4 = new ContentValues();
                            contentValues4.put("message_read_status", (Integer) 1);
                            contentValues4.put("message_sender", C4809aa.m18104a().m18121a("chaton_id", ""));
                            sQLiteDatabase.update(VKApiConst.MESSAGE, contentValues4, "message_inbox_no = ?", new String[]{string});
                            ContentValues contentValues5 = new ContentValues();
                            contentValues5.put("message_type", (Integer) 1);
                            iUpdate = sQLiteDatabase.update(VKApiConst.MESSAGE, contentValues5, "message_inbox_no = ? AND message_type = 2", new String[]{string});
                        } else {
                            contentValues3.put("message_content", String.format("%d,%s,%s", Integer.valueOf(EnumC2231as.INVALID_USER.m10100a()), asString, C1736gi.m8632a(contentValues.getAsString("buddy_name"))));
                        }
                        contentValues3.put("message_time", Long.valueOf(jLongValue));
                        contentValues3.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jLongValue)));
                        sQLiteDatabase.insertOrThrow(VKApiConst.MESSAGE, null, contentValues3);
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery2;
                    sQLiteDatabase.endTransaction();
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            int i = iUpdate;
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            if (cursorQuery2 == null) {
                return i;
            }
            cursorQuery2.close();
            return i;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    /* renamed from: j */
    private long m12441j(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        if (!sQLiteDatabase.isOpen() && C4904y.f17872b) {
            C4904y.m18639b("insertSendMessageAndUpdateInbox  but db is not opened", getClass().getSimpleName());
        }
        sQLiteDatabase.beginTransaction();
        try {
            long jInsertOrThrow = sQLiteDatabase.insertOrThrow(VKApiConst.MESSAGE, null, contentValues);
            System.currentTimeMillis();
            String asString = contentValues.getAsString("message_inbox_no");
            int iIntValue = contentValues.getAsInteger("message_content_type").intValue();
            String asString2 = contentValues.getAsString("message_sender");
            int iIntValue2 = contentValues.getAsInteger("message_read_status").intValue();
            long jLongValue = contentValues.getAsLong("message_time").longValue();
            String str = String.format("%d;%d;%s;%s", 1, Integer.valueOf(iIntValue), C1736gi.m8632a(contentValues.getAsString("message_content")), "");
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("inbox_last_msg_sender", asString2);
            contentValues2.put("inbox_last_message", str);
            contentValues2.put("inbox_last_time", Long.valueOf(jLongValue));
            contentValues2.put("inbox_participants", Integer.valueOf(iIntValue2));
            sQLiteDatabase.update("inbox", contentValues2, "inbox_no=?", new String[]{asString});
            sQLiteDatabase.setTransactionSuccessful();
            return jInsertOrThrow;
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x01ab A[Catch: all -> 0x01a1, TRY_ENTER, TryCatch #0 {all -> 0x01a1, blocks: (B:10:0x0064, B:12:0x006a, B:14:0x0080, B:16:0x0089, B:26:0x00ee, B:18:0x0098, B:20:0x00a6, B:22:0x00b5, B:23:0x00cf, B:25:0x00ec, B:31:0x00fa, B:33:0x0137, B:34:0x0144, B:36:0x015a, B:37:0x0167, B:39:0x0170, B:40:0x017d, B:42:0x0186, B:48:0x0194, B:55:0x01ab, B:57:0x01b9), top: B:62:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01c0  */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.sec.chaton.provider.EnumC3039d m12442k(android.database.sqlite.SQLiteDatabase r14, android.content.ContentValues r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 451
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONProvider.m12442k(android.database.sqlite.SQLiteDatabase, android.content.ContentValues):com.sec.chaton.provider.d");
    }

    /* renamed from: a */
    private long m12416a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        if (!sQLiteDatabase.isOpen() && C4904y.f17872b) {
            C4904y.m18639b("insertParticipantInboxNoAndBuddyNo  but db is not opened", getClass().getSimpleName());
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("participants_inbox_no", str);
        contentValues.put("participants_buddy_no", str2);
        contentValues.put("participants_user_type", str3);
        contentValues.put("participants_buddy_name", C2176ab.m9685b(GlobalApplication.m18732r().getContentResolver(), str2, (String) null));
        return sQLiteDatabase.insertOrThrow("participant", null, contentValues);
    }

    /* renamed from: a */
    private long m12415a(SQLiteDatabase sQLiteDatabase, String str, String str2, EnumC2300t enumC2300t) {
        if (!sQLiteDatabase.isOpen() && C4904y.f17872b) {
            C4904y.m18639b("insertRelationInboxBuddy  but db is not opened", getClass().getSimpleName());
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_no", str);
        contentValues.put("buddy_no", str2);
        contentValues.put("chat_type", Integer.valueOf(enumC2300t.m10210a()));
        return sQLiteDatabase.insertOrThrow("inbox_buddy_relation", null, contentValues);
    }

    /* renamed from: a */
    public static String m12420a(SQLiteDatabase sQLiteDatabase, String str) {
        if (!sQLiteDatabase.isOpen() && C4904y.f17872b) {
            C4904y.m18639b("getBuddyNoFromPhoneNumber  but db is not opened", "ChatONProvider");
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return m12419a(sQLiteDatabase, new C2208v(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007e  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m12419a(android.database.sqlite.SQLiteDatabase r9, com.sec.chaton.p057e.p058a.C2208v r10) throws java.lang.Throwable {
        /*
            r8 = 0
            boolean r0 = r9.isOpen()
            if (r0 != 0) goto L14
            boolean r0 = com.sec.chaton.util.C4904y.f17872b
            if (r0 == 0) goto L14
            java.lang.String r0 = "getBuddyNoFromPhoneNumber  but db is not opened"
            java.lang.String r1 = "ChatONProvider"
            com.sec.chaton.util.C4904y.m18639b(r0, r1)
        L14:
            if (r10 != 0) goto L18
            r0 = r8
        L17:
            return r0
        L18:
            int[] r0 = com.sec.chaton.provider.C3034a.f11243a
            com.sec.chaton.e.a.w r1 = r10.m10063d()
            int r1 = r1.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 2: goto L29;
                case 3: goto L2b;
                case 4: goto L6c;
                default: goto L27;
            }
        L27:
            r0 = r8
            goto L17
        L29:
            r0 = r8
            goto L17
        L2b:
            java.lang.String r3 = "buddy_phonenumber_external_use = ? "
            java.lang.String r0 = r10.m10060a()
        L32:
            java.lang.String r1 = "buddy"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L74
            r4 = 0
            java.lang.String r5 = "buddy_no"
            r2[r4] = r5     // Catch: java.lang.Throwable -> L74
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L74
            r5 = 0
            r4[r5] = r0     // Catch: java.lang.Throwable -> L74
            r5 = 0
            r6 = 0
            r7 = 0
            r0 = r9
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L74
            if (r1 == 0) goto L7e
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L7b
            if (r0 == 0) goto L7e
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L7b
            if (r0 == 0) goto L7e
            java.lang.String r0 = "buddy_no"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r8 = r1.getString(r0)     // Catch: java.lang.Throwable -> L7b
            r0 = r8
        L66:
            if (r1 == 0) goto L17
            r1.close()
            goto L17
        L6c:
            java.lang.String r3 = "buddy_phonenumber_external_use LIKE ? "
            java.lang.String r0 = r10.m10062c()
            goto L32
        L74:
            r0 = move-exception
        L75:
            if (r8 == 0) goto L7a
            r8.close()
        L7a:
            throw r0
        L7b:
            r0 = move-exception
            r8 = r1
            goto L75
        L7e:
            r0 = r8
            goto L66
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONProvider.m12419a(android.database.sqlite.SQLiteDatabase, com.sec.chaton.e.a.v):java.lang.String");
    }

    /* renamed from: a */
    private void m12421a(SQLiteDatabase sQLiteDatabase, String str, String str2, EnumC2300t enumC2300t, String str3) throws SQLException {
        String strM9769b;
        if (!sQLiteDatabase.isOpen() && C4904y.f17872b) {
            C4904y.m18639b("insertRelationInboxBuddyAndInbox  but db is not opened", "ChatONProvider");
        }
        String strM18311a = C4839bd.m18311a();
        if (!TextUtils.isEmpty(str)) {
            m12415a(sQLiteDatabase, strM18311a, str, enumC2300t);
            m12416a(sQLiteDatabase, strM18311a, str, str3);
        }
        ContentValues contentValues = new ContentValues();
        if (TextUtils.isEmpty(str) || !str.startsWith("0999")) {
            strM9769b = null;
        } else {
            strM9769b = C2186al.m9769b(getContext(), str);
            contentValues.put("inbox_room_type", Integer.valueOf(EnumC2301u.LIVE.m10212a()));
        }
        if (!TextUtils.isEmpty(strM9769b)) {
            contentValues.put("inbox_web_url", strM9769b);
        }
        if (str != null && strM9769b != null) {
            C4904y.m18639b("spbd weburl, insertRelationInboxBuddyAndInbox(), " + str.toString() + "/" + strM9769b.toString(), getClass().getSimpleName());
        }
        contentValues.put("inbox_no", strM18311a);
        contentValues.put("inbox_chat_type", Integer.valueOf(enumC2300t.m10210a()));
        contentValues.put("inbox_last_chat_type", (Integer) 12);
        if (!TextUtils.isEmpty(str2)) {
            contentValues.put("inbox_session_id", str2);
        }
        sQLiteDatabase.insertOrThrow("inbox", null, contentValues);
    }

    /* renamed from: b */
    private void m12430b(SQLiteDatabase sQLiteDatabase, String str, String str2, EnumC2300t enumC2300t) throws SQLException {
        String strM18311a = C4839bd.m18311a();
        ContentValues contentValues = new ContentValues();
        if (!sQLiteDatabase.isOpen() && C4904y.f17872b) {
            C4904y.m18639b("insertDefaultInbox  but db is not opened", getClass().getSimpleName());
        }
        String strM9769b = (TextUtils.isEmpty(str) || !str.startsWith("0999")) ? null : C2186al.m9769b(getContext(), str);
        if (!TextUtils.isEmpty(strM9769b)) {
            contentValues.put("inbox_web_url", strM9769b);
            contentValues.put("inbox_room_type", Integer.valueOf(EnumC2301u.LIVE.m10212a()));
        }
        if (str != null && strM9769b != null) {
            C4904y.m18639b("spbd weburl, insertRelationInboxBuddyAndInbox(), " + str.toString() + "/" + strM9769b.toString(), getClass().getSimpleName());
        }
        contentValues.put("inbox_no", strM18311a);
        contentValues.put("inbox_chat_type", Integer.valueOf(enumC2300t.m10210a()));
        contentValues.put("inbox_last_chat_type", (Integer) 12);
        contentValues.put("inbox_is_new", "Y");
        if (enumC2300t == EnumC2300t.GROUPCHAT) {
            contentValues.put("inbox_enable_noti", C4809aa.m18104a().m18119a("Setting alert_new_groupchat", (Boolean) true).booleanValue() ? "Y" : "N");
        } else {
            contentValues.put("inbox_enable_noti", "Y");
        }
        if (!TextUtils.isEmpty(str2)) {
            contentValues.put("inbox_session_id", str2);
        }
        sQLiteDatabase.insertOrThrow("inbox", null, contentValues);
    }

    /* renamed from: a */
    private Cursor m12417a(SQLiteDatabase sQLiteDatabase, C2283cb c2283cb, String[] strArr, String str, String[] strArr2, String str2) {
        String[] strArr3;
        sQLiteDatabase.beginTransaction();
        String str3 = "";
        if (!sQLiteDatabase.isOpen() && C4904y.f17872b) {
            C4904y.m18639b("inboxGetNO  but db is not opened", getClass().getSimpleName());
        }
        if (strArr2.length > 1) {
            str3 = strArr2[1];
        }
        EnumC2300t enumC2300tM10207a = EnumC2300t.UNKNOWN;
        if (strArr2.length > 2) {
            enumC2300tM10207a = EnumC2300t.m10207a(Integer.parseInt(strArr2[2]));
        }
        String strM7095a = EnumC1109f.NONE.m7095a();
        if (strArr2.length > 3) {
            strM7095a = strArr2[3];
        }
        String str4 = strArr2[0];
        if (TextUtils.isEmpty(str4)) {
            strArr3 = new String[]{""};
        } else {
            strArr3 = new String[]{str4};
        }
        boolean z = false;
        try {
            Cursor cursorM10143a = c2283cb.m10146a(str, strArr3).m10143a(sQLiteDatabase, strArr, str2);
            if (cursorM10143a == null || cursorM10143a.getCount() == 0) {
                m12421a(sQLiteDatabase, str4, str3, enumC2300tM10207a, strM7095a);
                z = true;
            } else {
                cursorM10143a.moveToFirst();
                String string = cursorM10143a.getString(cursorM10143a.getColumnIndex("inbox_session_id"));
                if (EnumC2300t.ONETOONE == EnumC2300t.m10207a(cursorM10143a.getInt(cursorM10143a.getColumnIndex("inbox_chat_type")))) {
                    if (TextUtils.isEmpty(string)) {
                        if (!TextUtils.isEmpty(str3)) {
                            String string2 = cursorM10143a.getString(cursorM10143a.getColumnIndex("inbox_no"));
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("inbox_session_id", str3);
                            sQLiteDatabase.update("inbox", contentValues, "inbox_no=?", new String[]{string2});
                            z = true;
                        }
                    } else if (!TextUtils.isEmpty(str3) && !string.equals(str3)) {
                        sQLiteDatabase.delete("inbox_buddy_relation", "inbox_no=?", new String[]{cursorM10143a.getString(cursorM10143a.getColumnIndex("inbox_no"))});
                        m12421a(sQLiteDatabase, strArr2[0], str3, enumC2300tM10207a, strM7095a);
                        z = true;
                    }
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (!z) {
                return cursorM10143a;
            }
            if (cursorM10143a != null) {
                cursorM10143a.close();
            }
            return c2283cb.m10146a(str, strArr3).m10143a(sQLiteDatabase, strArr, str2);
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* renamed from: b */
    private Cursor m12428b(SQLiteDatabase sQLiteDatabase, C2283cb c2283cb, String[] strArr, String str, String[] strArr2, String str2) {
        String[] strArr3;
        boolean z;
        Cursor cursor;
        String[] strArr4;
        if (!sQLiteDatabase.isOpen() && C4904y.f17872b) {
            C4904y.m18639b("getOrMakeInboxNO  but db is not opened", getClass().getSimpleName());
        }
        sQLiteDatabase.beginTransaction();
        String str3 = strArr2[0];
        String str4 = "";
        if (strArr2.length > 1) {
            str4 = strArr2[1];
        }
        EnumC2300t enumC2300tM10207a = EnumC2300t.UNKNOWN;
        if (strArr2.length > 2) {
            enumC2300tM10207a = EnumC2300t.m10207a(Integer.parseInt(strArr2[2]));
        }
        String strM7095a = EnumC1109f.NONE.m7095a();
        if (strArr2.length > 3) {
            strM7095a = strArr2[3];
        }
        boolean z2 = false;
        switch (C3034a.f11244b[enumC2300tM10207a.ordinal()]) {
            case 1:
                str = "buddy_no=?";
                String[] strArr5 = {str3};
                try {
                    Cursor cursorM10143a = c2283cb.m10146a("buddy_no=?", strArr5).m10143a(sQLiteDatabase, strArr, str2);
                    if (cursorM10143a == null || cursorM10143a.getCount() == 0) {
                        m12430b(sQLiteDatabase, str3, str4, enumC2300tM10207a);
                        z2 = true;
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                    strArr3 = strArr5;
                    z = z2;
                    cursor = cursorM10143a;
                    break;
                } finally {
                }
                break;
            case 2:
                if (TextUtils.isEmpty(str3)) {
                    strArr4 = new String[]{""};
                } else {
                    strArr4 = new String[]{str3};
                }
                try {
                    Cursor cursorM10143a2 = c2283cb.m10146a(str, strArr4).m10143a(sQLiteDatabase, strArr, str2);
                    if (cursorM10143a2 == null || cursorM10143a2.getCount() == 0) {
                        m12421a(sQLiteDatabase, str3, str4, enumC2300tM10207a, strM7095a);
                        z2 = true;
                    } else {
                        cursorM10143a2.moveToFirst();
                        String string = cursorM10143a2.getString(cursorM10143a2.getColumnIndex("inbox_session_id"));
                        if (EnumC2300t.ONETOONE == EnumC2300t.m10207a(cursorM10143a2.getInt(cursorM10143a2.getColumnIndex("inbox_chat_type")))) {
                            if (TextUtils.isEmpty(string)) {
                                if (!TextUtils.isEmpty(str4)) {
                                    String string2 = cursorM10143a2.getString(cursorM10143a2.getColumnIndex("inbox_no"));
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("inbox_session_id", str4);
                                    sQLiteDatabase.update("inbox", contentValues, "inbox_no=?", new String[]{string2});
                                    z2 = true;
                                }
                            } else if (!TextUtils.isEmpty(str4) && !string.equals(str4)) {
                                sQLiteDatabase.delete("inbox_buddy_relation", "inbox_no=?", new String[]{cursorM10143a2.getString(cursorM10143a2.getColumnIndex("inbox_no"))});
                                m12421a(sQLiteDatabase, strArr2[0], str4, enumC2300tM10207a, strM7095a);
                                z2 = true;
                            }
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                    z = z2;
                    strArr3 = strArr4;
                    cursor = cursorM10143a2;
                    break;
                } finally {
                }
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                if (TextUtils.isEmpty(str4) && C4904y.f17875e) {
                    C4904y.m18634a("getOrMakeInboxNO() - sessionID is null", "ChatONProvider");
                }
                str = "inbox_session_id=?";
                String[] strArr6 = {str4};
                try {
                    Cursor cursorM10143a3 = c2283cb.m10146a("inbox_session_id=?", strArr6).m10143a(sQLiteDatabase, strArr, str2);
                    if (cursorM10143a3 == null || cursorM10143a3.getCount() == 0) {
                        m12430b(sQLiteDatabase, str3, str4, enumC2300tM10207a);
                        z2 = true;
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                    strArr3 = strArr6;
                    z = z2;
                    cursor = cursorM10143a3;
                    break;
                } finally {
                }
                break;
            default:
                strArr3 = null;
                str = null;
                z = false;
                cursor = null;
                break;
        }
        if (z) {
            if (cursor != null) {
                cursor.close();
            }
            return c2283cb.m10146a(str, strArr3).m10143a(sQLiteDatabase, strArr, str2);
        }
        return cursor;
    }

    /* renamed from: l */
    private int m12443l(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        Cursor cursor = null;
        if (!sQLiteDatabase.isOpen() && C4904y.f17872b) {
            C4904y.m18639b("updateMessageReadAck  but db is not opened", getClass().getSimpleName());
        }
        sQLiteDatabase.beginTransaction();
        try {
            String asString = (contentValues == null || !contentValues.containsKey("inboxNo")) ? null : contentValues.getAsString("inboxNo");
            Long asLong = (contentValues == null || !contentValues.containsKey("time")) ? 0L : contentValues.getAsLong("time");
            int iIntValue = (contentValues == null || !contentValues.containsKey(VKApiConst.COUNT)) ? 0 : contentValues.getAsInteger(VKApiConst.COUNT).intValue();
            if (TextUtils.isEmpty(asString) || asLong.longValue() <= 0 || iIntValue <= 0) {
                sQLiteDatabase.setTransactionSuccessful();
                return 0;
            }
            sQLiteDatabase.execSQL(InterfaceC2282ca.f8185a, new String[]{String.valueOf(iIntValue), asString, C4809aa.m18104a().m18121a("chaton_id", ""), String.valueOf(asLong), String.valueOf(iIntValue)});
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            if (0 == 0) {
                return 1;
            }
            cursor.close();
            return 1;
        } finally {
            sQLiteDatabase.endTransaction();
            if (0 != 0) {
                cursor.close();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009b  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m12412a(android.database.sqlite.SQLiteDatabase r11, android.content.ContentValues r12, java.lang.String r13, java.lang.String[] r14) throws java.lang.Throwable {
        /*
            r10 = this;
            r9 = 0
            r8 = 0
            boolean r0 = r11.isOpen()
            if (r0 != 0) goto L1a
            boolean r0 = com.sec.chaton.util.C4904y.f17872b
            if (r0 == 0) goto L1a
            java.lang.String r0 = "updateInboxForPush  but db is not opened"
            java.lang.Class r1 = r10.getClass()
            java.lang.String r1 = r1.getSimpleName()
            com.sec.chaton.util.C4904y.m18639b(r0, r1)
        L1a:
            r11.beginTransaction()
            java.lang.String r1 = "inbox"
            r0 = 2
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L8e
            r0 = 0
            java.lang.String r3 = "inbox_last_time"
            r2[r0] = r3     // Catch: java.lang.Throwable -> L8e
            r0 = 1
            java.lang.String r3 = "inbox_unread_count"
            r2[r0] = r3     // Catch: java.lang.Throwable -> L8e
            r5 = 0
            r6 = 0
            r7 = 0
            r0 = r11
            r3 = r13
            r4 = r14
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L8e
            if (r1 == 0) goto L9b
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L99
            if (r0 <= 0) goto L9b
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L99
            r0 = 0
            long r2 = r1.getLong(r0)     // Catch: java.lang.Throwable -> L99
            java.lang.String r0 = "inbox_last_time"
            java.lang.Long r0 = r12.getAsLong(r0)     // Catch: java.lang.Throwable -> L99
            long r4 = r0.longValue()     // Catch: java.lang.Throwable -> L99
            android.content.ContentValues r0 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L99
            r0.<init>()     // Catch: java.lang.Throwable -> L99
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L60
            r0.putAll(r12)     // Catch: java.lang.Throwable -> L99
        L60:
            r2 = 1
            int r2 = r1.getInt(r2)     // Catch: java.lang.Throwable -> L99
            java.lang.String r3 = "inbox_unread_count"
            java.lang.Integer r3 = r12.getAsInteger(r3)     // Catch: java.lang.Throwable -> L99
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L99
            int r2 = r2 + r3
            java.lang.String r3 = "inbox_unread_count"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L99
            r0.put(r3, r2)     // Catch: java.lang.Throwable -> L99
            java.lang.String r2 = "inbox"
            int r0 = r11.update(r2, r0, r13, r14)     // Catch: java.lang.Throwable -> L99
        L82:
            r11.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L99
            r11.endTransaction()
            if (r1 == 0) goto L8d
            r1.close()
        L8d:
            return r0
        L8e:
            r0 = move-exception
            r1 = r8
        L90:
            r11.endTransaction()
            if (r1 == 0) goto L98
            r1.close()
        L98:
            throw r0
        L99:
            r0 = move-exception
            goto L90
        L9b:
            r0 = r9
            goto L82
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONProvider.m12412a(android.database.sqlite.SQLiteDatabase, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0070  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m12424b(android.database.sqlite.SQLiteDatabase r11, android.content.ContentValues r12, java.lang.String r13, java.lang.String[] r14) throws java.lang.Throwable {
        /*
            r10 = this;
            r9 = 0
            r8 = 0
            r11.beginTransaction()
            java.lang.String r1 = "inbox"
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L72
            r0 = 0
            java.lang.String r3 = "inbox_title"
            r2[r0] = r3     // Catch: java.lang.Throwable -> L72
            r5 = 0
            r6 = 0
            r7 = 0
            r0 = r11
            r3 = r13
            r4 = r14
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L72
            if (r1 == 0) goto L70
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L82
            if (r0 <= 0) goto L70
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L82
            r0 = 0
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L82
            java.lang.String r2 = "inbox_title"
            java.lang.String r2 = r12.getAsString(r2)     // Catch: java.lang.Throwable -> L82
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L82
            if (r3 != 0) goto L63
            boolean r0 = r2.equals(r0)     // Catch: java.lang.Throwable -> L82
            if (r0 != 0) goto L63
            boolean r0 = com.sec.chaton.util.C4904y.f17872b     // Catch: java.lang.Throwable -> L82
            if (r0 == 0) goto L4b
            java.lang.String r0 = "New title and ole title is not equal."
            java.lang.String r2 = "ChatONProvider"
            com.sec.chaton.util.C4904y.m18639b(r0, r2)     // Catch: java.lang.Throwable -> L82
        L4b:
            java.lang.String r0 = "inbox"
            int r0 = r11.update(r0, r12, r13, r14)     // Catch: java.lang.Throwable -> L82
        L52:
            r11.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L82
            r11.endTransaction()
            if (r1 == 0) goto L5d
            r1.close()
        L5d:
            if (r8 == 0) goto L62
            r8.close()
        L62:
            return r0
        L63:
            boolean r0 = com.sec.chaton.util.C4904y.f17872b     // Catch: java.lang.Throwable -> L82
            if (r0 == 0) goto L70
            java.lang.String r0 = "New title and ole title is equal."
            java.lang.String r2 = "ChatONProvider"
            com.sec.chaton.util.C4904y.m18639b(r0, r2)     // Catch: java.lang.Throwable -> L82
        L70:
            r0 = r9
            goto L52
        L72:
            r0 = move-exception
            r1 = r8
        L74:
            r11.endTransaction()
            if (r1 == 0) goto L7c
            r1.close()
        L7c:
            if (r8 == 0) goto L81
            r8.close()
        L81:
            throw r0
        L82:
            r0 = move-exception
            goto L74
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONProvider.m12424b(android.database.sqlite.SQLiteDatabase, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b2  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m12432c(android.database.sqlite.SQLiteDatabase r12, android.content.ContentValues r13, java.lang.String r14, java.lang.String[] r15) throws java.lang.Throwable {
        /*
            r11 = this;
            r8 = 0
            r12.beginTransaction()
            r10 = -10
            java.lang.String r1 = "inbox"
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L9b
            r0 = 0
            java.lang.String r3 = "inbox_unread_count"
            r2[r0] = r3     // Catch: java.lang.Throwable -> L9b
            r5 = 0
            r6 = 0
            r7 = 0
            r0 = r12
            r3 = r14
            r4 = r15
            android.database.Cursor r9 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L9b
            if (r9 == 0) goto L35
            int r0 = r9.getCount()     // Catch: java.lang.Throwable -> Lab
            if (r0 <= 0) goto L35
            r9.moveToFirst()     // Catch: java.lang.Throwable -> Lab
            r0 = 0
            int r0 = r9.getInt(r0)     // Catch: java.lang.Throwable -> Lab
            if (r0 <= 0) goto L35
            java.lang.String r0 = "inbox"
            int r10 = r12.update(r0, r13, r14, r15)     // Catch: java.lang.Throwable -> Lab
        L35:
            java.lang.String r1 = "inboxsms_mapping"
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> Lab
            r0 = 0
            java.lang.String r3 = "inboxsms_mapping_unread_count"
            r2[r0] = r3     // Catch: java.lang.Throwable -> Lab
            java.lang.String r3 = "inboxsms_mapping_inbox_no=? "
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> Lab
            r0 = 0
            r5 = 0
            r5 = r15[r5]     // Catch: java.lang.Throwable -> Lab
            r4[r0] = r5     // Catch: java.lang.Throwable -> Lab
            r5 = 0
            r6 = 0
            r7 = 0
            r0 = r12
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> Lab
            if (r1 == 0) goto Lb2
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> Laf
            if (r0 <= 0) goto Lb2
            r1.moveToFirst()     // Catch: java.lang.Throwable -> Laf
            r0 = 0
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> Laf
            if (r0 <= 0) goto Lb2
            android.content.ContentValues r0 = new android.content.ContentValues     // Catch: java.lang.Throwable -> Laf
            r0.<init>()     // Catch: java.lang.Throwable -> Laf
            java.lang.String r2 = "inboxsms_mapping_unread_count"
            r3 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> Laf
            r0.put(r2, r3)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r2 = "inboxsms_mapping"
            java.lang.String r3 = "inboxsms_mapping_inbox_no=? "
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> Laf
            r5 = 0
            r6 = 0
            r6 = r15[r6]     // Catch: java.lang.Throwable -> Laf
            r4[r5] = r6     // Catch: java.lang.Throwable -> Laf
            int r0 = r12.update(r2, r0, r3, r4)     // Catch: java.lang.Throwable -> Laf
        L8a:
            r12.setTransactionSuccessful()     // Catch: java.lang.Throwable -> Laf
            r12.endTransaction()
            if (r9 == 0) goto L95
            r9.close()
        L95:
            if (r1 == 0) goto L9a
            r1.close()
        L9a:
            return r0
        L9b:
            r0 = move-exception
            r1 = r8
        L9d:
            r12.endTransaction()
            if (r8 == 0) goto La5
            r8.close()
        La5:
            if (r1 == 0) goto Laa
            r1.close()
        Laa:
            throw r0
        Lab:
            r0 = move-exception
            r1 = r8
            r8 = r9
            goto L9d
        Laf:
            r0 = move-exception
            r8 = r9
            goto L9d
        Lb2:
            r0 = r10
            goto L8a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONProvider.m12432c(android.database.sqlite.SQLiteDatabase, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }

    /* renamed from: a */
    private int m12413a(SQLiteDatabase sQLiteDatabase, String str, EnumC4549n enumC4549n) {
        int count;
        Cursor cursorQuery;
        int iUpdate = -1;
        sQLiteDatabase.beginTransaction();
        try {
            int iM12425b = m12425b(sQLiteDatabase, str, enumC4549n);
            if (iM12425b >= 0) {
                try {
                    cursorQuery = sQLiteDatabase.query(VKApiConst.MESSAGE, new String[]{"_id"}, "message_inbox_no =?  AND message_type = " + String.valueOf(2) + " AND message_content_type != " + EnumC2214ab.SYSTEM.m10076a() + " AND message_content_type != " + EnumC2214ab.UNDEFINED.m10076a() + " AND message_is_read = " + EnumC2215ac.UNREAD.m10081b(), new String[]{str}, null, null, null);
                    if (cursorQuery != null) {
                        try {
                            count = cursorQuery.getCount();
                        } catch (Throwable th) {
                            th = th;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            throw th;
                        }
                    } else {
                        count = -1;
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (count >= 0) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("inbox_unread_count", Integer.valueOf(count));
                        iUpdate = sQLiteDatabase.update("inbox", contentValues, "inbox_no = ?", new String[]{str});
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursorQuery = null;
                }
            } else {
                count = -1;
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            if (C4904y.f17872b) {
                C4904y.m18639b("[hslee_unread] updateChatRoomUnreadCountLive(), updated message #n : " + iM12425b + ", new unread #n : " + count + ", updated Inbox #n : " + iUpdate, "ChatONProvider");
            }
            return count;
        } catch (Throwable th3) {
            sQLiteDatabase.endTransaction();
            throw th3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x008b  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m12434d(android.database.sqlite.SQLiteDatabase r11, android.content.ContentValues r12, java.lang.String r13, java.lang.String[] r14) throws java.lang.Throwable {
        /*
            r10 = this;
            r8 = 0
            r11.beginTransaction()
            r9 = -10
            java.lang.String r1 = "inbox"
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L7e
            r0 = 0
            java.lang.String r3 = "inbox_unread_count"
            r2[r0] = r3     // Catch: java.lang.Throwable -> L7e
            r5 = 0
            r6 = 0
            r7 = 0
            r0 = r11
            r3 = r13
            r4 = r14
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L7e
            if (r1 == 0) goto L8b
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L89
            if (r0 <= 0) goto L8b
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L89
            r0 = 0
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L89
            java.lang.String r2 = "inbox_unread_count"
            java.lang.Integer r2 = r12.getAsInteger(r2)     // Catch: java.lang.Throwable -> L89
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L89
            boolean r3 = com.sec.chaton.util.C4904y.f17873c     // Catch: java.lang.Throwable -> L89
            if (r3 == 0) goto L60
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L89
            r3.<init>()     // Catch: java.lang.Throwable -> L89
            java.lang.String r4 = "updateChatRoomWithCurrentUnreadCount - current unread count :"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L89
            java.lang.StringBuilder r3 = r3.append(r0)     // Catch: java.lang.Throwable -> L89
            java.lang.String r4 = ", added unread count : "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L89
            java.lang.StringBuilder r3 = r3.append(r2)     // Catch: java.lang.Throwable -> L89
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L89
            java.lang.String r4 = "ChatONProvider"
            com.sec.chaton.util.C4904y.m18641c(r3, r4)     // Catch: java.lang.Throwable -> L89
        L60:
            java.lang.String r3 = "inbox_unread_count"
            int r0 = r0 + r2
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L89
            r12.put(r3, r0)     // Catch: java.lang.Throwable -> L89
            java.lang.String r0 = "inbox"
            int r0 = r11.update(r0, r12, r13, r14)     // Catch: java.lang.Throwable -> L89
        L72:
            r11.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L89
            r11.endTransaction()
            if (r1 == 0) goto L7d
            r1.close()
        L7d:
            return r0
        L7e:
            r0 = move-exception
            r1 = r8
        L80:
            r11.endTransaction()
            if (r1 == 0) goto L88
            r1.close()
        L88:
            throw r0
        L89:
            r0 = move-exception
            goto L80
        L8b:
            r0 = r9
            goto L72
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONProvider.m12434d(android.database.sqlite.SQLiteDatabase, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }

    /* renamed from: m */
    private Uri m12444m(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        sQLiteDatabase.beginTransaction();
        try {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("upload_id", contentValues.getAsLong("upload_id"));
            contentValues2.put("file_uri", contentValues.getAsString("file_uri"));
            sQLiteDatabase.insert("multichannel_upload", null, contentValues2);
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("upload_id", contentValues.getAsLong("upload_id"));
            contentValues3.put("request_id", contentValues.getAsLong("request_id"));
            contentValues3.put("request_type", contentValues.getAsInteger("request_type"));
            sQLiteDatabase.insert("huge_file_upload_mapping", null, contentValues3);
            Uri uriBuild = C2218af.f7940a.buildUpon().appendPath("huge_file_upload_mapping").build();
            sQLiteDatabase.setTransactionSuccessful();
            return uriBuild;
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* renamed from: b */
    private static int m12425b(SQLiteDatabase sQLiteDatabase, String str, EnumC4549n enumC4549n) {
        String str2;
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_is_read", EnumC2215ac.READ_LOCAL.m10081b());
        String[] strArr = {str, EnumC2214ab.LIVECONTENTS.m10077b()};
        switch (C3034a.f11245c[enumC4549n.ordinal()]) {
            case 1:
                str2 = "message_inbox_no =?  AND message_type = " + String.valueOf(2) + " AND message_content_type !=?  AND message_content_type != " + EnumC2214ab.SYSTEM.m10076a() + " AND message_content_type != " + EnumC2214ab.UNDEFINED.m10076a() + " AND message_is_read = " + EnumC2215ac.UNREAD.m10081b();
                break;
            case 2:
                str2 = "message_inbox_no =?  AND message_type = " + String.valueOf(2) + " AND message_content_type =?  AND message_is_read = " + EnumC2215ac.UNREAD.m10081b();
                break;
            default:
                if (C4904y.f17872b) {
                    C4904y.m18639b("clearUnreadCountForLive(), What happened? inboxNo:" + str + ", live service type: " + enumC4549n, "ChatONProvider");
                }
                return -1;
        }
        return sQLiteDatabase.update(VKApiConst.MESSAGE, contentValues, str2, strArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0046  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m12431b(android.database.sqlite.SQLiteDatabase r11, java.lang.String r12) throws java.lang.Throwable {
        /*
            r9 = 1
            r8 = 0
            r10 = 0
            java.lang.String r1 = "buddy"
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L3c
            r0 = 0
            java.lang.String r3 = "COUNT(*)"
            r2[r0] = r3     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = "buddy_contact_buddy != '1' AND buddy_no =?"
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L3c
            r0 = 0
            r4[r0] = r12     // Catch: java.lang.Throwable -> L3c
            r5 = 0
            r6 = 0
            r7 = 0
            r0 = r11
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L3c
            if (r1 == 0) goto L46
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L44
            if (r0 == 0) goto L46
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L44
            if (r0 == 0) goto L46
            r0 = 0
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L44
            if (r0 <= 0) goto L46
            r0 = r9
        L36:
            if (r1 == 0) goto L3b
            r1.close()
        L3b:
            return r0
        L3c:
            r0 = move-exception
            r1 = r8
        L3e:
            if (r1 == 0) goto L43
            r1.close()
        L43:
            throw r0
        L44:
            r0 = move-exception
            goto L3e
        L46:
            r0 = r10
            goto L36
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.provider.ChatONProvider.m12431b(android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
    }
}
