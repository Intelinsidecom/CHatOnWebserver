package com.sds.coolots.login.p018a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.ContentValuesUtil;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.login.model.NationalCode;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.sds.coolots.login.a.a */
/* loaded from: classes.dex */
public class C1265a {

    /* renamed from: a */
    protected static final String f3168a = "[LoginDbAdaptor]";

    /* renamed from: b */
    public static final String f3169b = "Database is not opened!!!";

    /* renamed from: c */
    public static final String f3170c = "nationalcode";

    /* renamed from: d */
    public static final String f3171d = " Order By ";

    /* renamed from: e */
    public static final String f3172e = " WHERE ";

    /* renamed from: f */
    public static final String f3173f = "iso2";

    /* renamed from: g */
    public static final String f3174g = "mcc";

    /* renamed from: h */
    public static final String f3175h = "namekor";

    /* renamed from: i */
    public static final String f3176i = "nameeng";

    /* renamed from: j */
    public static final String f3177j = "countrycode";

    /* renamed from: k */
    public static final String f3178k = "areacode";

    /* renamed from: l */
    public static final String f3179l = "zero_space";

    /* renamed from: m */
    private static final int f3180m = 0;

    /* renamed from: n */
    private static final int f3181n = 1;

    /* renamed from: o */
    private static final int f3182o = 2;

    /* renamed from: p */
    private SQLiteDatabase f3183p = null;

    public C1265a() {
        m3041b("create LoginDbAdaptor()");
    }

    /* renamed from: a */
    private List m3039a(ContentValues contentValues, int i, boolean z) {
        if (this.f3183p == null || !this.f3183p.isOpen()) {
            m3040a(f3169b);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String stringByContentValuesForWhere = contentValues != null ? ContentValuesUtil.getStringByContentValuesForWhere(contentValues, null) : "";
        String strConcat = (z ? "SELECT DISTINCT iso2, namekor, nameeng, countrycode, areacode, zero_space".concat(", mcc") : "SELECT DISTINCT iso2, namekor, nameeng, countrycode, areacode, zero_space").concat(" from  nationalcode");
        String strConcat2 = (contentValues == null || contentValues.size() <= 0) ? strConcat : strConcat.concat(f3172e + stringByContentValuesForWhere);
        switch (i) {
            case 1:
                strConcat2 = strConcat2.concat(" Order By namekor");
                break;
            case 2:
                strConcat2 = strConcat2.concat(" Order By nameeng");
                break;
        }
        Cursor cursorRawQuery = this.f3183p.rawQuery(strConcat2, null);
        if (cursorRawQuery != null) {
            cursorRawQuery.moveToFirst();
            if (!cursorRawQuery.isAfterLast()) {
                do {
                    NationalCode nationalCode = new NationalCode();
                    nationalCode.setIso2(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("iso2")));
                    if (z) {
                        nationalCode.setMCC(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("mcc")));
                    }
                    nationalCode.setnameKor(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("namekor")));
                    nationalCode.setnameEng(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("nameeng")));
                    nationalCode.setcountryCode(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("countrycode")));
                    nationalCode.setAreaCode(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("areacode")));
                    if (cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("zero_space")) == 1) {
                        nationalCode.setZeroSpace(true);
                    } else {
                        nationalCode.setZeroSpace(false);
                    }
                    arrayList.add(nationalCode);
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m3040a(String str) {
        Log.m2958e(f3168a + str);
    }

    /* renamed from: b */
    private void m3041b(String str) {
        Log.m2963i(f3168a + str);
    }

    /* renamed from: d */
    private List m3042d(ContentValues contentValues, int i) {
        if (this.f3183p == null || !this.f3183p.isOpen()) {
            m3040a(f3169b);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String strConcat = ((contentValues == null || contentValues.size() <= 0) ? "SELECT iso2, namekor, nameeng, countrycode, mcc, areacode, zero_space from  nationalcode" : "SELECT iso2, namekor, nameeng, countrycode, mcc, areacode, zero_space from  nationalcode".concat(f3172e).concat(contentValues != null ? ContentValuesUtil.getStringByContentValuesForWhere(contentValues, null) : "")).concat(" group by iso2, namekor, nameeng, countrycode, mcc");
        switch (i) {
            case 1:
                strConcat = strConcat.concat(" Order By namekor");
                break;
            case 2:
                strConcat = strConcat.concat(" Order By nameeng");
                break;
        }
        Cursor cursorRawQuery = this.f3183p.rawQuery(strConcat, null);
        if (cursorRawQuery != null) {
            cursorRawQuery.moveToFirst();
            if (!cursorRawQuery.isAfterLast()) {
                do {
                    NationalCode nationalCode = new NationalCode();
                    nationalCode.setIso2(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("iso2")));
                    nationalCode.setMCC(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("mcc")));
                    nationalCode.setnameKor(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("namekor")));
                    nationalCode.setnameEng(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("nameeng")));
                    nationalCode.setcountryCode(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("countrycode")));
                    nationalCode.setAreaCode("");
                    if (cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("zero_space")) == 1) {
                        nationalCode.setZeroSpace(true);
                    } else {
                        nationalCode.setZeroSpace(false);
                    }
                    arrayList.add(nationalCode);
                } while (cursorRawQuery.moveToNext());
            }
            cursorRawQuery.close();
        }
        return arrayList;
    }

    /* renamed from: a */
    public ArrayList m3043a(int i) {
        try {
            return C1268d.m3064a(MainApplication.mContext, i);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public List m3044a(ContentValues contentValues, int i) {
        return m3039a(contentValues, i, false);
    }

    /* renamed from: a */
    public void m3045a() {
        this.f3183p = MainApplication.mPhoneManager.getDatabase();
    }

    /* renamed from: a */
    public void m3046a(List list) {
        if (this.f3183p == null || !this.f3183p.isOpen()) {
            m3040a(f3169b);
            return;
        }
        MainApplication.mPhoneManager.lockDatabaseLock();
        this.f3183p.beginTransaction();
        try {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                NationalCode nationalCode = (NationalCode) it.next();
                ContentValues contentValues = new ContentValues();
                contentValues.put("iso2", nationalCode.getIso2());
                contentValues.put("mcc", nationalCode.getMCC());
                contentValues.put("namekor", nationalCode.getnameKor());
                contentValues.put("nameeng", nationalCode.getnameEng());
                contentValues.put("countrycode", nationalCode.getcountryCode());
                contentValues.put("areacode", nationalCode.getAreaCode());
                if (nationalCode.isZeroSpace()) {
                    contentValues.put("zero_space", (Integer) 1);
                } else {
                    contentValues.put("zero_space", (Integer) 0);
                }
                this.f3183p.insert("nationalcode", null, contentValues);
            }
            this.f3183p.setTransactionSuccessful();
        } catch (Exception e) {
            m3040a("EXCEPTION : ");
        } finally {
            this.f3183p.endTransaction();
            MainApplication.mPhoneManager.releaseDatabaseLock();
        }
    }

    /* renamed from: b */
    public List m3047b(ContentValues contentValues, int i) {
        return m3039a(contentValues, i, true);
    }

    /* renamed from: b */
    public void m3048b() {
    }

    /* renamed from: c */
    public List m3049c(ContentValues contentValues, int i) {
        return m3042d(contentValues, i);
    }

    /* renamed from: c */
    public void m3050c() {
        if (this.f3183p == null || !this.f3183p.isOpen()) {
            m3040a(f3169b);
        } else {
            this.f3183p.delete("nationalcode", null, null);
        }
    }

    protected void finalize() throws Throwable {
        m3041b("finalize()");
        m3048b();
        super.finalize();
    }
}
