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
import com.sec.chaton.util.C4873ck;
import com.sec.common.actionbar.AbstractC4946a;
import com.sec.widget.C5179v;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class CategoryActivity extends BaseSinglePaneActivity {

    /* renamed from: n */
    private static final String f10510n = CategoryActivity.class.getSimpleName();

    /* renamed from: o */
    private BroadcastReceiver f10511o;

    /* renamed from: p */
    private CategoryView f10512p;

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        this.f10512p = new CategoryView();
        return this.f10512p;
    }

    /* renamed from: a */
    public ArrayList<C2871e> m11952a(ArrayList<C2871e> arrayList, String str) {
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
                    arrayList.add(new C2871e(cursorQuery.getString(cursorQuery.getColumnIndex("_data")), cursorQuery.getString(cursorQuery.getColumnIndex("_id")), cursorQuery.getString(cursorQuery.getColumnIndex("orientation"))));
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

    /* renamed from: b */
    public void m11953b(Intent intent) {
        setResult(-1, intent);
        finish();
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        BaseActivity.m6159a(this);
        m11949j();
        super.onResume();
    }

    /* renamed from: j */
    private void m11949j() {
        this.f10511o = new C2867a(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f10511o, intentFilter);
        m11950k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m11950k() {
        if (!C4873ck.m18500a()) {
            C5179v.m19810a(getBaseContext(), R.string.sdcard_not_found, 0).show();
            finish();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        BaseActivity.m6159a(this);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        m11951l();
    }

    /* renamed from: l */
    private void m11951l() {
        unregisterReceiver(this.f10511o);
    }

    /* renamed from: h */
    public AbstractC4946a m11954h() {
        return m18784t();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }
}
