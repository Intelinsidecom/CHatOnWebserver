package com.sec.chaton.settings;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.account.C0210g;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.C0688c;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class RelationHideFragment extends Fragment {

    /* renamed from: a */
    static boolean f4704a = false;

    /* renamed from: b */
    static boolean f4705b = false;

    /* renamed from: d */
    Cursor f4707d;

    /* renamed from: g */
    private Context f4710g;

    /* renamed from: h */
    private ListView f4711h;

    /* renamed from: i */
    private ArrayList f4712i;

    /* renamed from: j */
    private C1298cw f4713j;

    /* renamed from: k */
    private ContentResolver f4714k;

    /* renamed from: l */
    private LinearLayout f4715l;

    /* renamed from: c */
    Dialog f4706c = null;

    /* renamed from: e */
    ArrayList f4708e = new ArrayList();

    /* renamed from: f */
    public InterfaceC0667k f4709f = new C1303da(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4714k = GlobalApplication.m3260b().getContentResolver();
        this.f4712i = new ArrayList();
        this.f4713j = new C1298cw(getActivity(), R.layout.layout_relationship_hide, this.f4708e, this.f4709f);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_relationship_hide, viewGroup, false);
        this.f4711h = (ListView) viewInflate.findViewById(R.id.list);
        this.f4715l = (LinearLayout) viewInflate.findViewById(R.id.no_item_layout);
        this.f4711h.setAdapter((ListAdapter) this.f4713j);
        this.f4707d = this.f4714k.query(C0688c.f2606a, null, "buddy_relation_hide = 'Y' ", null, null);
        if (this.f4707d.getCount() == 0) {
            this.f4711h.setVisibility(8);
            this.f4715l.setVisibility(0);
        }
        m4687a(this.f4707d);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (f4705b) {
            f4705b = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4687a(Cursor cursor) {
        this.f4708e.clear();
        if (!cursor.isBeforeFirst()) {
            cursor.moveToPosition(-1);
        }
        while (cursor.moveToNext()) {
            this.f4708e.add(new C0257c(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), "", !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), 0, "", false));
        }
        cursor.close();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        C0210g.m1809a();
    }
}
