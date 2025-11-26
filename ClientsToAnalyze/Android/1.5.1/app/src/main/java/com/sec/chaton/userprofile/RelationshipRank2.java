package com.sec.chaton.userprofile;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.item.BuddyItem;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.NotifyingAsyncQueryHandler;
import com.sec.chaton.database.helper.NotifyingAsyncTaskWorker;
import com.sec.chaton.database.task.AbstractQueryTask;
import com.sec.chaton.database.task.RelationUpdateTask;
import com.sec.chaton.facebook.FacebookManager;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public class RelationshipRank2 extends BaseActivity implements NotifyingAsyncQueryHandler.AsyncQueryListener {

    /* renamed from: d */
    private static NotifyingAsyncQueryHandler f3368d;

    /* renamed from: g */
    private static int f3369g;

    /* renamed from: a */
    String f3370a;

    /* renamed from: e */
    private ProgressDialog f3373e;

    /* renamed from: f */
    private ProgressDialog f3374f;

    /* renamed from: h */
    private ListView f3375h;

    /* renamed from: i */
    private LinearLayout f3376i;

    /* renamed from: j */
    private ArrayList f3377j;

    /* renamed from: k */
    private ArrayAdapter f3378k;

    /* renamed from: l */
    private ImageView f3379l;

    /* renamed from: m */
    private String f3380m;

    /* renamed from: n */
    private View f3381n;

    /* renamed from: b */
    AbstractQueryTask.OnQueryTaskResult f3371b = new C0570ax(this);

    /* renamed from: c */
    RelationUpdateTask.RelationUpdateStatus f3372c = new C0574ba(this);

    /* renamed from: o */
    private FacebookManager.OnResultListener f3382o = new C0575bb(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3333a(int i) {
        Toast.makeText(this, i, 0).show();
    }

    /* renamed from: a */
    private void m3334a(Cursor cursor) {
        if (cursor != null) {
            this.f3377j.clear();
            while (cursor.moveToNext()) {
                BuddyItem buddyItem = new BuddyItem(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), "", !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), 0, "", false, cursor.getInt(cursor.getColumnIndex("relation_send")), cursor.getInt(cursor.getColumnIndex("relation_received")), cursor.getInt(cursor.getColumnIndex("relation_point")), cursor.getInt(cursor.getColumnIndex("relation_icon")), cursor.getInt(cursor.getColumnIndex("relation_increase")), cursor.getInt(cursor.getColumnIndex("relation_rank")), cursor.getInt(cursor.getColumnIndex("buddy_profile_status")), false, false);
                buddyItem.m677c(cursor.getPosition() + 1);
                if (cursor.getPosition() == 0) {
                    f3369g = buddyItem.m688m();
                }
                if (cursor.getPosition() < 4) {
                    buddyItem.m669a(5);
                }
                this.f3377j.add(buddyItem);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3335a(Bitmap bitmap, String str) {
        ImageView imageView = new ImageView(this);
        imageView.setImageBitmap(bitmap);
        new AlertDialog.Builder(this).setView(imageView).setPositiveButton(C0062R.string.share, new DialogInterfaceOnClickListenerC0572az(this, bitmap, str)).setNegativeButton(C0062R.string.cancel, new DialogInterfaceOnClickListenerC0571ay(this)).show();
    }

    /* renamed from: d */
    private void m3343d() {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(5, -1);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.add(5, -7);
        DateFormat dateInstance = DateFormat.getDateInstance();
        dateInstance.format(new Date(calendar.getTimeInMillis()));
        dateInstance.format(new Date(calendar2.getTimeInMillis()));
        dateInstance.format(new Date(calendar3.getTimeInMillis()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m3344e() {
        f3368d.startQuery(-1, null, ChatONContract.RelationTable.m2201a(), null, "(relation_date = ? or relation_date is null )  AND buddy_relation_hide = 'N'  AND relation_rank != 0 ", new String[]{this.f3370a}, "relation_rank ASC LIMIT 30");
    }

    /* renamed from: f */
    private void m3347f() {
        if (this.f3378k.getCount() == 0) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(C0062R.id.top3DumpView);
        linearLayout.removeAllViews();
        LayoutInflater.from(this).inflate(C0062R.layout.list_relationship_rank_header_for_share, (ViewGroup) linearLayout, true);
        for (int i = 0; i < 3 && i < this.f3378k.getCount(); i++) {
            linearLayout.addView(this.f3378k.getView(i, null, linearLayout), -1, -2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public String m3348g() {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = (Calendar) calendar.clone();
        Calendar calendar3 = (Calendar) calendar.clone();
        DateFormat dateInstance = DateFormat.getDateInstance();
        dateInstance.format(new Date(calendar.getTimeInMillis()));
        calendar2.add(5, -1);
        String str = dateInstance.format(new Date(calendar2.getTimeInMillis()));
        new SimpleDateFormat("yyyy-MM-dd").format(new Date(calendar2.getTimeInMillis()));
        calendar3.add(5, -7);
        return dateInstance.format(new Date(calendar3.getTimeInMillis())) + " - " + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public Bitmap m3349h() {
        View viewFindViewById = findViewById(C0062R.id.top3DumpView);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(viewFindViewById.getWidth(), viewFindViewById.getHeight(), Bitmap.Config.ARGB_8888);
        viewFindViewById.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    /* renamed from: a */
    protected void m3350a() {
        ChatONLogWriter.m3506b("relationUpdateTime=" + ChatONPref.m3519a().getString("relationUpdateTime", ""), getClass().getSimpleName());
        this.f3380m = new SimpleDateFormat("MMM dd, yyyy HH:mm").format(Long.valueOf(System.currentTimeMillis()));
        this.f3373e = ProgressDialog.show(this, null, getResources().getString(C0062R.string.interaction_updating), true);
        NotifyingAsyncTaskWorker.m2304a(new NotifyingAsyncTaskWorker(), -1, new RelationUpdateTask(this.f3371b, this.f3380m, null));
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: a */
    public void mo529a(int i, Object obj, int i2) {
        if (i == 0) {
            if (i2 == 1) {
                m3344e();
            } else {
                Toast.makeText(this, getResources().getString(C0062R.string.buddy_profile_saveprofile_toast_failed), 1).show();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0032 A[Catch: all -> 0x004e, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x004e, blocks: (B:3:0x0002, B:5:0x0008, B:6:0x0024, B:10:0x0032), top: B:16:0x0002 }] */
    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo530a(int r3, java.lang.Object r4, android.database.Cursor r5) {
        /*
            r2 = this;
            if (r5 == 0) goto L32
            int r0 = r5.getCount()     // Catch: java.lang.Throwable -> L4e
            if (r0 <= 0) goto L32
            android.widget.ListView r0 = r2.f3375h     // Catch: java.lang.Throwable -> L4e
            r1 = 0
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> L4e
            android.widget.ImageView r0 = r2.f3379l     // Catch: java.lang.Throwable -> L4e
            r1 = 0
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> L4e
            android.view.View r0 = r2.f3381n     // Catch: java.lang.Throwable -> L4e
            r1 = 0
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> L4e
            android.widget.LinearLayout r0 = r2.f3376i     // Catch: java.lang.Throwable -> L4e
            r1 = 8
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> L4e
            r2.m3334a(r5)     // Catch: java.lang.Throwable -> L4e
        L24:
            android.widget.ArrayAdapter r0 = r2.f3378k     // Catch: java.lang.Throwable -> L4e
            r0.notifyDataSetChanged()     // Catch: java.lang.Throwable -> L4e
            r2.m3347f()     // Catch: java.lang.Throwable -> L4e
            if (r5 == 0) goto L31
            r5.close()
        L31:
            return
        L32:
            android.widget.ListView r0 = r2.f3375h     // Catch: java.lang.Throwable -> L4e
            r1 = 8
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> L4e
            android.widget.ImageView r0 = r2.f3379l     // Catch: java.lang.Throwable -> L4e
            r1 = 8
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> L4e
            android.view.View r0 = r2.f3381n     // Catch: java.lang.Throwable -> L4e
            r1 = 8
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> L4e
            android.widget.LinearLayout r0 = r2.f3376i     // Catch: java.lang.Throwable -> L4e
            r1 = 0
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> L4e
            goto L24
        L4e:
            r0 = move-exception
            if (r5 == 0) goto L54
            r5.close()
        L54:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.userprofile.RelationshipRank2.mo530a(int, java.lang.Object, android.database.Cursor):void");
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: a */
    public void mo531a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.database.helper.NotifyingAsyncQueryHandler.AsyncQueryListener
    /* renamed from: b */
    public void mo534b(int i, Object obj, int i2) {
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0062R.layout.layout_relationshiprank2);
        this.f3375h = (ListView) findViewById(C0062R.id.relationship_list);
        this.f3376i = (LinearLayout) findViewById(C0062R.id.no_item_layout);
        this.f3379l = (ImageView) findViewById(C0062R.id.btnShare);
        this.f3379l.setOnClickListener(new ViewOnClickListenerC0569aw(this));
        this.f3381n = findViewById(C0062R.id.listview_top3dumpview);
        this.f3377j = new ArrayList();
        f3368d = new NotifyingAsyncQueryHandler(getContentResolver(), this);
        this.f3370a = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(Calendar.getInstance().getTimeInMillis()));
        m3343d();
        this.f3378k = new C0546a(this, 0, this.f3377j);
        this.f3375h.setAdapter((ListAdapter) this.f3378k);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        switch (i) {
            case 0:
                ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setMessage(getString(C0062R.string.facebook_post_wait));
                progressDialog.setIndeterminate(true);
                return progressDialog;
            default:
                return null;
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.addSubMenu(0, 1, 0, getResources().getString(C0062R.string.setting_interaction_ru)).setIcon(C0062R.drawable.refresh);
        return true;
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        ChatONLogWriter.m3506b("item =" + menuItem.getItemId(), getClass().getSimpleName());
        switch (menuItem.getItemId()) {
            case 1:
                m3350a();
                break;
        }
        return true;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        ChatONLogWriter.m3506b("onPause", getClass().getSimpleName());
        RelationUpdateTask.m2333b(this.f3372c);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        ChatONLogWriter.m3506b("onResume", getClass().getSimpleName());
        RelationUpdateTask.m2330a(this.f3372c);
        ChatONLogWriter.m3511e("Is Updating : " + RelationUpdateTask.m2334b(), getClass().getSimpleName());
        if (RelationUpdateTask.m2334b()) {
            this.f3374f = ProgressDialog.show(this, null, getResources().getString(C0062R.string.interaction_updating), true);
        } else {
            m3344e();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        ChatONLogWriter.m3506b("onStart", getClass().getSimpleName());
    }
}
