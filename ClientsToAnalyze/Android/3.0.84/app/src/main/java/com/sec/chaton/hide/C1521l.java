package com.sec.chaton.hide;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.C1441i;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.util.C3228cp;
import com.sec.chaton.util.C3250y;
import java.util.Collections;

/* compiled from: HideImpl.java */
/* renamed from: com.sec.chaton.hide.l */
/* loaded from: classes.dex */
public class C1521l implements InterfaceC1378v {

    /* renamed from: a */
    C1377u f5599a;

    /* renamed from: b */
    final /* synthetic */ C1516g f5600b;

    public C1521l(C1516g c1516g) {
        this.f5600b = c1516g;
        this.f5599a = null;
        if (this.f5599a == null) {
            this.f5599a = new C1377u(c1516g.f5589o.getContentResolver(), this);
        }
    }

    /* renamed from: a */
    public void m6513a() {
        this.f5599a.startQuery(1, null, C1441i.m6319l(), null, null, null, null);
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        C3250y.m11450b("onQueryComplete", getClass().getSimpleName());
        if (this.f5600b.f5589o == null || cursor == null) {
            this.f5600b.m6497f();
            return;
        }
        if (i == 1) {
            cursor.moveToFirst();
            int count = cursor.getCount();
            if (count <= 0) {
                C3250y.m11453c("Has no member of hide buddy", getClass().getSimpleName());
                this.f5600b.f5582h.setEmptyView(this.f5600b.f5585k);
                if (this.f5600b.f5591q != null) {
                    this.f5600b.f5591q.setEnabled(false);
                }
                C3228cp.m11343a(this.f5600b.f5591q);
                if (this.f5600b.f5585k != null) {
                    this.f5600b.f5585k.setVisibility(0);
                }
                this.f5600b.f5583i.clear();
                this.f5600b.f5584j.m6488a(this.f5600b.f5583i);
                this.f5600b.f5584j.notifyDataSetChanged();
                if (!GlobalApplication.m6456e()) {
                    this.f5600b.f5589o.setTitle(this.f5600b.f5589o.getResources().getString(R.string.settings_hided) + " (" + Integer.toString(this.f5600b.f5583i.size()) + ")");
                } else {
                    this.f5600b.f5581g.setText(this.f5600b.f5589o.getResources().getString(R.string.settings_hided) + " (" + Integer.toString(this.f5600b.f5583i.size()) + ")");
                }
            } else {
                C3250y.m11453c("Has " + count + " member of hide buddy", getClass().getSimpleName());
                this.f5600b.f5583i.clear();
                if (cursor.moveToFirst()) {
                    do {
                        this.f5600b.f5583i.add(new C1515f(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number"))));
                    } while (cursor.moveToNext());
                }
                cursor.close();
                Collections.sort(this.f5600b.f5583i, new C1522m(this));
                if (this.f5600b.f5591q != null) {
                    this.f5600b.f5591q.setEnabled(true);
                }
                C3228cp.m11343a(this.f5600b.f5591q);
                if (this.f5600b.f5585k != null) {
                    this.f5600b.f5585k.setVisibility(8);
                }
                this.f5600b.f5584j.m6488a(this.f5600b.f5583i);
                this.f5600b.f5584j.notifyDataSetChanged();
                if (!GlobalApplication.m6456e()) {
                    this.f5600b.f5589o.setTitle(this.f5600b.f5589o.getResources().getString(R.string.settings_hided) + " (" + Integer.toString(this.f5600b.f5583i.size()) + ")");
                } else {
                    this.f5600b.f5581g.setText(this.f5600b.f5589o.getResources().getString(R.string.settings_hided) + " (" + Integer.toString(this.f5600b.f5583i.size()) + ")");
                }
            }
        } else if (i == 2 && this.f5600b.f5592r != null && this.f5600b.f5576b != null) {
            this.f5600b.f5576b.show();
            this.f5600b.f5592r.m6513a();
        }
        if (this.f5600b.f5590p != null) {
            if (C1360d.m6034b(this.f5600b.f5589o.getContentResolver()) - C1360d.m6041c(this.f5600b.f5589o.getContentResolver()) <= 0) {
                this.f5600b.f5590p.setEnabled(false);
            } else {
                this.f5600b.f5590p.setEnabled(true);
            }
            C3228cp.m11343a(this.f5600b.f5590p);
        }
        this.f5600b.m6497f();
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onInsertComplete(int i, Object obj, Uri uri) {
        C3250y.m11450b("onInsertComplete", getClass().getSimpleName());
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onUpdateComplete(int i, Object obj, int i2) {
        C3250y.m11450b("onUpdateComplete", getClass().getSimpleName());
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onDeleteComplete(int i, Object obj, int i2) {
        C3250y.m11450b("onDeleteComplete", getClass().getSimpleName());
    }
}
