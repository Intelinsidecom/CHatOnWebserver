package com.sec.chaton.settings;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p017a.C0363a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p013a.C0197aj;
import com.sec.chaton.p013a.C0202ao;
import com.sec.chaton.p025d.C0667t;
import com.sec.chaton.p025d.p026a.C0630j;
import com.sec.chaton.p025d.p026a.InterfaceC0626f;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.widget.C1356c;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class RelationHideFragment extends Fragment implements InterfaceC1072d {

    /* renamed from: b */
    static ProgressDialog f3575b;

    /* renamed from: e */
    Cursor f3578e;

    /* renamed from: h */
    private Context f3581h;

    /* renamed from: i */
    private ListView f3582i;

    /* renamed from: j */
    private ArrayList f3583j;

    /* renamed from: k */
    private C1038bi f3584k;

    /* renamed from: l */
    private ContentResolver f3585l;

    /* renamed from: m */
    private LinearLayout f3586m;

    /* renamed from: n */
    private C0630j f3587n;

    /* renamed from: o */
    private String f3588o;

    /* renamed from: a */
    static boolean f3574a = false;

    /* renamed from: c */
    static boolean f3576c = false;

    /* renamed from: d */
    Dialog f3577d = null;

    /* renamed from: f */
    ArrayList f3579f = new ArrayList();

    /* renamed from: p */
    private final Handler f3589p = new HandlerC1037bh(this);

    /* renamed from: q */
    private ContentObserver f3590q = new C1035bf(this, new Handler());

    /* renamed from: g */
    public InterfaceC0626f f3580g = new C1036bg(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3585l = GlobalApplication.m3100a().getContentResolver();
        this.f3583j = new ArrayList();
        this.f3584k = new C1038bi(getActivity(), R.layout.layout_relationship_hide, this.f3579f, this.f3580g);
        new C0197aj(this.f3589p).m748b();
        C1341p.m4658b("Start getInteractionBlindList Sync", getClass().getSimpleName());
        f3575b = (ProgressDialog) new C1356c(getActivity()).m4728a(R.string.dialog_connecting_server);
        f3575b.show();
        this.f3587n = new C0630j(this.f3585l, this.f3580g);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3581h = getActivity();
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f3581h = null;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_relationship_hide, viewGroup, false);
        this.f3582i = (ListView) viewInflate.findViewById(R.id.list);
        this.f3586m = (LinearLayout) viewInflate.findViewById(R.id.no_item_layout);
        this.f3584k.m3927a(this);
        this.f3582i.setAdapter((ListAdapter) this.f3584k);
        this.f3578e = this.f3585l.query(C0667t.f2310a, null, "buddy_relation_hide = 'Y' ", null, null);
        if (this.f3578e.getCount() == 0) {
            this.f3582i.setVisibility(8);
            this.f3586m.setVisibility(0);
        }
        m3893a(this.f3578e);
        getActivity().getContentResolver().registerContentObserver(C0667t.f2310a, true, this.f3590q);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        if (f3575b != null) {
            f3575b.dismiss();
        }
        getActivity().getContentResolver().unregisterContentObserver(this.f3590q);
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (f3575b != null) {
            f3575b.dismiss();
        }
        super.onDestroyView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3893a(Cursor cursor) {
        this.f3579f.clear();
        if (!cursor.isBeforeFirst()) {
            cursor.moveToPosition(-1);
        }
        while (cursor.moveToNext()) {
            this.f3579f.add(new C0363a(cursor.getString(cursor.getColumnIndex("buddy_no")), cursor.getString(cursor.getColumnIndex("buddy_name")), cursor.getString(cursor.getColumnIndex("buddy_status_message")), cursor.getString(cursor.getColumnIndex("buddy_samsung_email")), cursor.getString(cursor.getColumnIndex("buddy_orginal_number")), "", !cursor.getString(cursor.getColumnIndex("buddy_relation_hide")).equals("Y"), 0, "", false));
        }
        cursor.close();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        new C0202ao(null).m757a();
    }

    @Override // com.sec.chaton.settings.InterfaceC1072d
    /* renamed from: a */
    public void mo3902a(String str, String str2) {
        this.f3588o = str2;
        f3576c = true;
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        f3575b.show();
        new C0197aj(this.f3589p).m747a(arrayList, new ArrayList());
        C1341p.m4658b("InteractionShow: " + str2, getClass().getSimpleName());
    }
}
