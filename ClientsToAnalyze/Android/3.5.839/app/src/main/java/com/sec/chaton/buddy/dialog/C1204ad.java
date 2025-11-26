package com.sec.chaton.buddy.dialog;

import android.database.Cursor;
import android.hardware.motion.MotionRecognitionManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.C1364hq;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.privateplugin.data.Spam;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: MultipleExpandableDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.ad */
/* loaded from: classes.dex */
class C1204ad implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ MultipleExpandableDialog f4699a;

    C1204ad(MultipleExpandableDialog multipleExpandableDialog) {
        this.f4699a = multipleExpandableDialog;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
        List listAsList;
        if (i == 1000) {
            this.f4699a.f4630q = new LinkedHashMap();
            this.f4699a.f4634u = new HashMap();
            if (cursor != null) {
                try {
                    if (cursor.getCount() != 0) {
                        cursor.moveToFirst();
                        do {
                            String string = cursor.getString(cursor.getColumnIndex("buddy_no"));
                            String string2 = cursor.getString(cursor.getColumnIndex("buddy_name"));
                            String string3 = cursor.getString(cursor.getColumnIndex("buddy_status_message"));
                            String string4 = cursor.getString(cursor.getColumnIndex("buddy_contact_buddy"));
                            String string5 = cursor.getString(cursor.getColumnIndex("buddy_phonenumber_external_use"));
                            if (string4 != null && string4.compareTo(Spam.ACTIVITY_REPORT) == 0) {
                                listAsList = Arrays.asList(string3.split(", "));
                            } else {
                                listAsList = Arrays.asList(string5.split(" "));
                            }
                            if (listAsList.size() == 1) {
                                this.f4699a.f4635v.put(string, string5);
                                this.f4699a.f4629p.remove(string);
                            } else {
                                this.f4699a.f4634u.put(string, string2);
                                this.f4699a.f4630q.put(string, listAsList);
                            }
                        } while (cursor.moveToNext());
                    }
                } catch (Exception e) {
                    if (cursor != null && !cursor.isClosed()) {
                    }
                } catch (Throwable th) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    throw th;
                }
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
            this.f4699a.f4631r = (ExpandableListView) this.f4699a.findViewById(R.id.multi_selection_list);
            this.f4699a.f4633t = new C1364hq(this.f4699a.f4637x, this.f4699a.f4629p, this.f4699a.f4630q, this.f4699a.f4634u, this.f4699a.f4635v);
            View viewInflate = LayoutInflater.from(this.f4699a.f4637x).inflate(R.layout.multiple_expandable_notice, (ViewGroup) this.f4699a.f4631r, false);
            viewInflate.setFocusable(true);
            ((ViewGroup) viewInflate).setDescendantFocusability(MotionRecognitionManager.EVENT_CALL_POSE);
            this.f4699a.f4631r.addHeaderView(viewInflate, null, false);
            this.f4699a.f4631r.setAdapter(this.f4699a.f4633t);
            for (int i2 = 0; i2 < this.f4699a.f4629p.size(); i2++) {
                this.f4699a.f4631r.expandGroup(i2);
            }
            this.f4699a.f4633t.notifyDataSetChanged();
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7101a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7099a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: b */
    public void mo7102b(int i, Object obj, int i2) {
    }
}
