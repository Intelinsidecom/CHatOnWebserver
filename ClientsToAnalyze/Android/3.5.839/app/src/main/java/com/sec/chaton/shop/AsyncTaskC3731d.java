package com.sec.chaton.shop;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.sec.chaton.p057e.C2257bc;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.p057e.p058a.C2183ai;
import com.sec.chaton.p057e.p058a.C2184aj;
import com.sec.chaton.settings.p096a.C3455ab;
import com.sec.chaton.settings.p096a.C3471o;
import com.sec.chaton.settings.p096a.C3474r;
import com.sec.chaton.shop.entrys.ApplyRequestEntry;
import com.sec.chaton.shop.entrys.ApplyResponseEntry;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5052r;
import java.io.File;
import org.json.JSONException;

/* compiled from: ApplyItemTask.java */
/* renamed from: com.sec.chaton.shop.d */
/* loaded from: classes.dex */
public class AsyncTaskC3731d extends AsyncTask<Void, Void, Boolean> {

    /* renamed from: a */
    private static final String f13410a = AsyncTaskC3731d.class.getSimpleName();

    /* renamed from: b */
    private ApplyRequestEntry f13411b;

    /* renamed from: c */
    private Activity f13412c;

    /* renamed from: d */
    private Handler f13413d;

    /* renamed from: a */
    public static AsyncTaskC3731d m14064a(ApplyRequestEntry applyRequestEntry, Activity activity, Handler handler) {
        return new AsyncTaskC3731d(applyRequestEntry, activity, handler);
    }

    private AsyncTaskC3731d(ApplyRequestEntry applyRequestEntry, Activity activity, Handler handler) {
        this.f13411b = applyRequestEntry;
        this.f13412c = activity;
        this.f13413d = handler;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Void... voidArr) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor = null;
        c2184ajM9746a = null;
        C2184aj c2184ajM9746a = null;
        string = null;
        String string = null;
        if (this.f13412c == null || this.f13411b == null) {
            return false;
        }
        ContentResolver contentResolver = this.f13412c.getContentResolver();
        EnumC2258bd enumC2258bdM14069a = C3733f.m14069a(this.f13411b.itemType);
        String string2 = Long.toString(this.f13411b.itemId);
        switch (C3732e.f13414a[enumC2258bdM14069a.ordinal()]) {
            case 1:
                try {
                    cursorQuery = contentResolver.query(C2257bc.m10121a(EnumC2258bd.Skin), null, C5052r.m19199a("item_id", "=?"), new String[]{string2}, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.getCount() > 0) {
                                cursorQuery.moveToFirst();
                                try {
                                    c2184ajM9746a = C2183ai.m9746a(cursorQuery.getString(cursorQuery.getColumnIndex("extras")));
                                } catch (JSONException e) {
                                    if (C4904y.f17875e) {
                                        C4904y.m18635a(e, f13410a);
                                    }
                                }
                                if (c2184ajM9746a != null) {
                                    Boolean boolValueOf = Boolean.valueOf(C3474r.m13820a(string2, c2184ajM9746a.m9752a()));
                                    if (cursorQuery == null) {
                                        return boolValueOf;
                                    }
                                    cursorQuery.close();
                                    return boolValueOf;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            throw th;
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    cursorQuery = null;
                }
            case 2:
                File fileM13807c = C3471o.m13807c(CommonApplication.m18732r(), string2);
                if (fileM13807c == null || !fileM13807c.exists()) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("download_font, apply(), itemId / (failed) : " + string2.toString(), f13410a);
                    }
                    return false;
                }
                C4809aa.m18104a().m18126b("Default Font Typeface", Integer.valueOf(string2));
                C4809aa.m18104a().m18128b("Default Font Name", string2);
                if (C4904y.f17872b) {
                    C4904y.m18639b(C5052r.m19199a("download_font, apply(), itemId : ", string2.toString()), f13410a);
                }
                return true;
            case 3:
                try {
                    Cursor cursorQuery2 = contentResolver.query(C2257bc.m10121a(EnumC2258bd.Sound).buildUpon().appendEncodedPath("install").build(), null, "item_id=?", new String[]{string2}, null);
                    if (cursorQuery2 != null) {
                        try {
                            if (cursorQuery2.moveToNext()) {
                                string = cursorQuery2.getString(cursorQuery2.getColumnIndex("name"));
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            cursor = cursorQuery2;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                    if (cursorQuery2 != null) {
                        cursorQuery2.close();
                    }
                    return Boolean.valueOf(C3455ab.m13748a(string2, string));
                } catch (Throwable th4) {
                    th = th4;
                }
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        if (this.f13411b != null) {
            ApplyResponseEntry applyResponseEntry = new ApplyResponseEntry(this.f13411b.itemType, this.f13411b.itemId);
            if (bool.booleanValue()) {
                m14065a(this.f13413d, 6, applyResponseEntry, this.f13411b.success);
            } else {
                m14065a(this.f13413d, 6, applyResponseEntry, this.f13411b.error);
            }
        }
    }

    /* renamed from: a */
    private void m14065a(Handler handler, int i, Object obj, String str) {
        Message message = new Message();
        message.what = i;
        message.obj = obj;
        Bundle bundle = new Bundle();
        bundle.putString("itemapply_result", str);
        message.setData(bundle);
        handler.sendMessage(message);
    }
}
