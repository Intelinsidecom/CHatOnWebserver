package com.sec.chaton.api.access_token;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.sec.common.util.C5033j;

/* loaded from: classes.dex */
public class AccessTokenProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (!C1041a.m6138a(getContext(), Binder.getCallingUid())) {
            throw new SecurityException("Access Token is invalid.");
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        m6134a(getContext(), jCurrentTimeMillis);
        return ContentUris.withAppendedId(uri, jCurrentTimeMillis);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    /* renamed from: a */
    public static void m6134a(Context context, long j) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("access_control", 0).edit();
        editorEdit.putString("pwd_" + j, "");
        C5033j.m19087a(editorEdit);
    }

    /* renamed from: a */
    public static boolean m6135a(Context context, Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return m6136a(context, bundle.getString("password"));
    }

    /* renamed from: a */
    public static boolean m6136a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("access_control", 0);
        String str2 = "pwd_" + str;
        if (!sharedPreferences.contains(str2)) {
            return false;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.remove(str2);
        C5033j.m19087a(editorEdit);
        return true;
    }
}
