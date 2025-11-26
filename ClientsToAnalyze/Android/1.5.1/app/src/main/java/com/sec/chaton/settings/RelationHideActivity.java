package com.sec.chaton.settings;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.C0062R;
import com.sec.chaton.account.ContactManager;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.item.BuddyItem;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.NotifyingAsyncQueryHandler;
import com.sec.chaton.database.helper.NotifyingAsyncTaskWorker;
import com.sec.chaton.database.task.RelationUpdateTask;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class RelationHideActivity extends BaseActivity {

    /* renamed from: a */
    static boolean f3097a = false;

    /* renamed from: b */
    static boolean f3098b = false;

    /* renamed from: d */
    Cursor f3100d;

    /* renamed from: g */
    private Context f3103g;

    /* renamed from: h */
    private ListView f3104h;

    /* renamed from: i */
    private ArrayList f3105i;

    /* renamed from: j */
    private RelationHideAdapter f3106j;

    /* renamed from: k */
    private ContentResolver f3107k;

    /* renamed from: l */
    private LinearLayout f3108l;

    /* renamed from: m */
    private String f3109m;

    /* renamed from: c */
    Dialog f3099c = null;

    /* renamed from: e */
    ArrayList f3101e = new ArrayList();

    /* renamed from: f */
    public NotifyingAsyncQueryHandler.AsyncQueryListener f3102f = new C0467ap(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3202a(Cursor cursor) {
        this.f3101e.clear();
        if (!cursor.isBeforeFirst()) {
            cursor.moveToPosition(-1);
        }
        while (cursor.moveToNext()) {
            this.f3101e.add(new BuddyItem(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), "", !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), 0, "", false));
        }
        cursor.close();
    }

    /* renamed from: a */
    protected void m3208a() {
        ChatONLogWriter.m3506b("relationUpdateTime=" + ChatONPref.m3519a().getString("relationUpdateTime", ""), getClass().getSimpleName());
        this.f3109m = new SimpleDateFormat("MMM dd, yyyy HH:mm").format(Long.valueOf(System.currentTimeMillis()));
        NotifyingAsyncTaskWorker.m2304a(new NotifyingAsyncTaskWorker(), -1, new RelationUpdateTask(null, this.f3109m, null));
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3107k = GlobalApplication.m2387e().getContentResolver();
        this.f3105i = new ArrayList();
        this.f3103g = this;
        this.f3106j = new RelationHideAdapter(this, C0062R.layout.layout_relationship_hide, this.f3101e, this.f3102f);
        setContentView(C0062R.layout.layout_relationship_hide);
        this.f3104h = (ListView) findViewById(C0062R.id.list);
        this.f3108l = (LinearLayout) findViewById(C0062R.id.no_item_layout);
        this.f3104h.setAdapter((ListAdapter) this.f3106j);
        this.f3100d = this.f3107k.query(ChatONContract.BuddyTable.f1713a, null, "buddy_relation_hide = 'Y' ", null, null);
        if (this.f3100d.getCount() == 0) {
            this.f3104h.setVisibility(8);
            this.f3108l.setVisibility(0);
        }
        m3202a(this.f3100d);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        ContactManager.m403a();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        if (f3098b) {
            ChatONLogWriter.m3506b("refresh interaction", getClass().getSimpleName());
            m3208a();
            f3098b = false;
        }
    }
}
