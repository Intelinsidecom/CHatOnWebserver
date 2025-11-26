package com.sec.chaton.multimedia.emoticon.anicon;

import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2131l;
import com.sec.chaton.p057e.C2257bc;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.p057e.p058a.C2188b;
import com.sec.chaton.shop.p099a.C3707e;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4821am;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.AdaptableTextView;
import com.sec.common.CommonApplication;
import com.sec.common.p132g.C5007c;
import java.util.ArrayList;
import org.json.JSONException;

/* loaded from: classes.dex */
public class AniconSortListFragment extends Fragment implements InterfaceC2783o {

    /* renamed from: d */
    private static final String f10044d = AniconSortListFragment.class.getSimpleName();

    /* renamed from: a */
    Activity f10045a;

    /* renamed from: b */
    StickerSortListView f10046b;

    /* renamed from: c */
    C5007c f10047c;

    /* renamed from: e */
    private ArrayList<Object> f10048e;

    /* renamed from: f */
    private View f10049f;

    /* renamed from: g */
    private Handler f10050g = new HandlerC2784p(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f10045a = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f10045a = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f10047c != null) {
            this.f10047c.m19014a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f10049f = layoutInflater.inflate(R.layout.layout_anicon_sort, viewGroup, false);
        ((AdaptableTextView) this.f10049f.findViewById(R.id.anicon_guide).findViewById(R.id.text1)).setText(R.string.anicon_sort_guide);
        this.f10048e = new ArrayList<>();
        this.f10048e.clear();
        this.f10046b = (StickerSortListView) this.f10049f.findViewById(R.id.dynamiclist);
        if (C4809aa.m18104a().m18119a("get_characterlist", (Boolean) false).booleanValue()) {
            m11671c();
        } else {
            C3707e.m13998a(this.f10050g).m14002b();
        }
        return this.f10049f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m11671c() {
        this.f10048e = m11672d();
        this.f10047c = new C5007c();
        C2786r c2786r = new C2786r(this.f10045a, R.layout.list_item_aniconsort, this.f10048e, this.f10047c, new C2131l(this.f10045a, null));
        this.f10046b.setDataList(this.f10048e);
        this.f10046b.setAdapter((ListAdapter) c2786r);
        this.f10046b.setChoiceMode(1);
        this.f10046b.setAttachedActivity(this.f10045a);
    }

    /* renamed from: d */
    private ArrayList<Object> m11672d() {
        Cursor cursorM11673e = m11673e();
        if (cursorM11673e != null && cursorM11673e.getCount() > 0) {
            cursorM11673e.moveToFirst();
            do {
                String string = cursorM11673e.getString(cursorM11673e.getColumnIndex("item_id"));
                String string2 = cursorM11673e.getString(cursorM11673e.getColumnIndex("extras"));
                String string3 = cursorM11673e.getString(cursorM11673e.getColumnIndex("name"));
                try {
                    this.f10048e.add(new C2785q(string, C2188b.m9789a(string2).m9795a(), string3, null));
                } catch (JSONException e) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b(e.toString(), "TAG");
                    }
                    e.printStackTrace();
                }
            } while (cursorM11673e.moveToNext());
            C4809aa.m18104a().m18125b("pref_anicon_sort_set", (Boolean) true);
        }
        return this.f10048e;
    }

    /* renamed from: e */
    private Cursor m11673e() {
        return this.f10045a.getContentResolver().query(C2257bc.m10121a(EnumC2258bd.Anicon).buildUpon().appendPath("anicon_group_sort").build(), null, null, null, "install DESC");
    }

    @Override // com.sec.chaton.multimedia.emoticon.anicon.InterfaceC2783o
    /* renamed from: a */
    public void mo11674a() {
        ArrayList<Object> arrayListA = this.f10046b.m18696a();
        if (arrayListA != null) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayListA.size()) {
                    arrayList.add(C2188b.m9787a(((C2785q) arrayListA.get(i2)).f10079a, (arrayListA.size() - i2) + 1));
                    i = i2 + 1;
                } else {
                    try {
                        C4821am.m18190a(CommonApplication.m18732r(), "com.sec.chaton.provider2", (ArrayList<ContentProviderOperation>) arrayList);
                        return;
                    } catch (OperationApplicationException e) {
                        e.printStackTrace();
                        return;
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
            }
        }
    }
}
