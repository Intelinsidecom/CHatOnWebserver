package com.sec.chaton.api.access_token;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import twitter4j.conf.PropertyConfiguration;

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
        if (!C0440a.m3070a(getContext(), Binder.getCallingUid())) {
            throw new SecurityException("Access Token is invalid.");
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        m3066a(getContext(), jCurrentTimeMillis);
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
    public static void m3066a(Context context, long j) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("access_control", 0).edit();
        editorEdit.putString("pwd_" + j, "");
        if (Build.VERSION.SDK_INT < 9) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }

    /* renamed from: a */
    public static boolean m3067a(Context context, Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return m3068a(context, bundle.getString(PropertyConfiguration.PASSWORD));
    }

    /* renamed from: a */
    public static boolean m3068a(Context context, String str) {
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
        if (Build.VERSION.SDK_INT < 9) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
        return true;
    }
}
