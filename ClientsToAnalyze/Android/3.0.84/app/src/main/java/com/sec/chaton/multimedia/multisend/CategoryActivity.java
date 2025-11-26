package com.sec.chaton.multimedia.multisend;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.util.C3223ck;
import com.sec.common.actionbar.AbstractC3284a;
import com.sec.widget.C3641ai;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class CategoryActivity extends BaseSinglePaneActivity {

    /* renamed from: a */
    private static final String f7189a = CategoryActivity.class.getSimpleName();

    /* renamed from: b */
    private BroadcastReceiver f7190b;

    /* renamed from: c */
    private CategoryView f7191c;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo1193a() {
        this.f7191c = new CategoryView();
        return this.f7191c;
    }

    /* renamed from: a */
    public ArrayList<C1902e> m7721a(ArrayList<C1902e> arrayList, String str) {
        Cursor cursorQuery;
        try {
            if (str.equals("")) {
                cursorQuery = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_data", "_id", null, "orientation"}, null, null, "datetaken DESC");
            } else {
                cursorQuery = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_data", "_id", "bucket_id", "orientation"}, "bucket_id = '" + str + "'", null, "datetaken DESC");
            }
        } catch (Throwable th) {
            th = th;
            cursorQuery = null;
        }
        try {
            arrayList.clear();
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                do {
                    arrayList.add(new C1902e(cursorQuery.getString(cursorQuery.getColumnIndex("_data")), cursorQuery.getString(cursorQuery.getColumnIndex("_id")), cursorQuery.getString(cursorQuery.getColumnIndex("orientation"))));
                } while (cursorQuery.moveToNext());
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    /* renamed from: c */
    public void m7723c(Intent intent) {
        setResult(-1, intent);
        finish();
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        BaseActivity.m3080a(this);
        m7718e();
        super.onResume();
    }

    /* renamed from: e */
    private void m7718e() {
        this.f7190b = new C1898a(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f7190b, intentFilter);
        m7719f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m7719f() {
        if (!C3223ck.m11327a()) {
            C3641ai.m13210a(getBaseContext(), R.string.sdcard_not_found, 0).show();
            finish();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        BaseActivity.m3080a(this);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        m7720g();
    }

    /* renamed from: g */
    private void m7720g() {
        unregisterReceiver(this.f7190b);
    }

    /* renamed from: c */
    public AbstractC3284a m7722c() {
        return m11543k();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }
}
