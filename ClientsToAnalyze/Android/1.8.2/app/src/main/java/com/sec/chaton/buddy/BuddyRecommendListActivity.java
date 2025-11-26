package com.sec.chaton.buddy;

import android.app.ActionBar;
import android.content.ContentResolver;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p009b.ContextMenuC0237a;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.p015d.C0636h;
import com.sec.chaton.p017e.C0702q;
import com.sec.chaton.p022h.C0809s;
import com.sec.chaton.widget.ProgressDialogC1806j;
import com.sec.widget.C2153y;
import java.util.ArrayList;
import twitter4j.MediaEntity;
import twitter4j.internal.http.HttpResponseCode;

/* loaded from: classes.dex */
public class BuddyRecommendListActivity extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo649a() {
        return new BuddyRecommendListFragment();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        ActionBar actionBar;
        super.onPostCreate(bundle);
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
            if (Build.VERSION.SDK_INT >= 14 && (actionBar = getActionBar()) != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setHomeButtonEnabled(true);
            }
        }
        setTitle(R.string.buddy_suggestion_special_buddy);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public class BuddyRecommendListFragment extends Fragment implements LoaderManager.LoaderCallbacks {

        /* renamed from: a */
        private C0377eh f1183a;

        /* renamed from: b */
        private ListView f1184b;

        /* renamed from: c */
        private View f1185c;

        /* renamed from: d */
        private ProgressDialogC1806j f1186d;

        /* renamed from: e */
        private C0633e f1187e;

        /* renamed from: f */
        private C0636h f1188f;

        /* renamed from: g */
        private int f1189g;

        /* renamed from: h */
        private String f1190h;

        /* renamed from: i */
        private int f1191i;

        /* renamed from: j */
        private String f1192j;

        /* renamed from: k */
        private View f1193k;

        /* renamed from: l */
        private Button f1194l;

        /* renamed from: m */
        private Button f1195m;

        /* renamed from: n */
        private int f1196n;

        /* renamed from: o */
        private ArrayList f1197o = new ArrayList();

        /* renamed from: p */
        private ArrayList f1198p = new ArrayList();

        /* renamed from: q */
        private View.OnClickListener f1199q = new ViewOnClickListenerC0368dz(this);

        /* renamed from: r */
        private View.OnClickListener f1200r = new ViewOnClickListenerC0370ea(this);

        /* renamed from: s */
        private View.OnClickListener f1201s = new ViewOnClickListenerC0371eb(this);

        /* renamed from: t */
        private Handler f1202t = new HandlerC0372ec(this);

        /* renamed from: u */
        private Handler f1203u = new HandlerC0376eg(this);

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            if (getArguments().getInt("RECOMMENDED_BUDDY_TYPE") == 100) {
                this.f1189g = 100;
            } else if (getArguments().getInt("RECOMMENDED_BUDDY_TYPE") == 200) {
                this.f1189g = HttpResponseCode.f7897OK;
            }
        }

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewInflate = layoutInflater.inflate(R.layout.layout_buddy_recommend_list, viewGroup, false);
            this.f1184b = (ListView) viewInflate.findViewById(android.R.id.list);
            this.f1185c = viewInflate.findViewById(R.id.no_recommendations_layout);
            this.f1193k = viewInflate.findViewById(R.id.suggestion_ignore_add_all_button);
            this.f1194l = (Button) this.f1193k.findViewById(R.id.suggestion_ignore_all_button);
            this.f1195m = (Button) this.f1193k.findViewById(R.id.suggestion_add_all_button);
            this.f1194l.setOnClickListener(new ViewOnClickListenerC0364dv(this));
            this.f1195m.setOnClickListener(new ViewOnClickListenerC0366dx(this));
            this.f1193k.setVisibility(0);
            return viewInflate;
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            this.f1183a = new C0377eh(this, getActivity(), R.layout.list_item_add_buddy, null, "type");
            this.f1184b.setAdapter((ListAdapter) this.f1183a);
            getLoaderManager().initLoader(0, null, this);
            this.f1187e = new C0633e(this.f1202t);
            this.f1188f = new C0636h(this.f1203u);
            this.f1186d = new ProgressDialogC1806j(getActivity(), false);
            this.f1186d.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
        }

        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        public Loader onCreateLoader(int i, Bundle bundle) {
            return this.f1189g == 100 ? new CursorLoader(getActivity(), C0702q.f2645a, null, "type='100'", null, null) : new CursorLoader(getActivity(), C0702q.f2645a, null, "type='200'", null, null);
        }

        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onLoadFinished(Loader loader, Cursor cursor) {
            this.f1183a.swapCursor(cursor);
        }

        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(Loader loader) {
            this.f1183a.swapCursor(null);
        }

        /* renamed from: a */
        public void m2225a() {
            this.f1196n = this.f1197o.size();
            if (this.f1186d != null) {
                this.f1186d.show();
            } else {
                this.f1186d = new ProgressDialogC1806j(getActivity(), false);
                this.f1186d.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
            }
            if (this.f1196n > 0) {
                this.f1188f.m2892b(m2206a(this.f1197o));
            }
        }

        /* renamed from: b */
        public void m2227b() {
            this.f1196n = this.f1197o.size();
            if (this.f1186d != null) {
                this.f1186d.show();
            } else {
                this.f1186d = new ProgressDialogC1806j(getActivity(), false);
                this.f1186d.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
            }
            if (this.f1196n > 0) {
                this.f1187e.m2864a(m2206a(this.f1197o), true);
            }
        }

        /* renamed from: a */
        private ArrayList m2206a(ArrayList arrayList) {
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    if (this.f1189g == 100) {
                        if (((String) arrayList.get(i2)).startsWith("0999")) {
                            arrayList2.add(arrayList.get(i2));
                        }
                    } else if (!((String) arrayList.get(i2)).startsWith("0999")) {
                        arrayList2.add(arrayList.get(i2));
                    }
                    i = i2 + 1;
                } else {
                    return arrayList2;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public int m2212c() {
            Cursor cursorQuery;
            if (this.f1189g == 100) {
                cursorQuery = GlobalApplication.m3260b().getContentResolver().query(C0702q.f2645a, null, "type='100'", null, null);
            } else {
                cursorQuery = GlobalApplication.m3260b().getContentResolver().query(C0702q.f2645a, null, "type='200'", null, null);
            }
            int count = cursorQuery.getCount();
            cursorQuery.close();
            return count;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m2209a(String str, int i) {
            if (str == null) {
                str = this.f1190h;
            }
            this.f1186d.show();
            if (i == 200) {
                this.f1187e.m2869b(str, true);
            } else if (str.startsWith("0999")) {
                this.f1187e.m2873c(str);
            }
            this.f1183a.notifyDataSetChanged();
            this.f1190h = str;
            Cursor cursorM2204a = m2204a(getActivity().getContentResolver(), this.f1190h);
            if (cursorM2204a != null && cursorM2204a.moveToFirst()) {
                this.f1192j = cursorM2204a.getString(2);
            }
            if (cursorM2204a != null) {
                cursorM2204a.close();
            }
        }

        /* renamed from: a */
        private void m2208a(String str) {
            if (str == null) {
                str = this.f1190h;
            }
            this.f1186d.show();
            this.f1198p.add(str);
            this.f1188f.m2890a("true", this.f1198p);
        }

        @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
            super.onConfigurationChanged(configuration);
            if (getResources() != null && this.f1185c != null) {
                this.f1185c.setPadding(0, getResources().getDimensionPixelSize(R.dimen.buddy_no_suggestion_padding_top), 0, 0);
            }
        }

        /* renamed from: a */
        public static Cursor m2204a(ContentResolver contentResolver, String str) {
            return contentResolver.query(C0702q.f2645a, null, "buddy_no='" + str + "'", null, null);
        }

        @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            ContextMenuC0237a contextMenuC0237a = new ContextMenuC0237a(getActivity(), contextMenu);
            C0378ei c0378ei = new C0378ei(view);
            this.f1190h = c0378ei.f1535c.getTag(R.id.TAG_FOR_BUDDYNO).toString();
            this.f1191i = Integer.parseInt(c0378ei.f1535c.getTag(R.id.TAG_FOR_TYPE).toString());
            this.f1192j = c0378ei.f1534b.getText().toString();
            contextMenuC0237a.setHeaderTitle(this.f1192j);
            contextMenuC0237a.add(0, 100, 1, getResources().getString(R.string.buddy_list_dialog_addbuddy_title));
            contextMenuC0237a.add(0, MediaEntity.Size.CROP, 2, getResources().getString(R.string.buddy_suggestion_ignore));
        }

        @Override // android.support.v4.app.Fragment
        public boolean onContextItemSelected(MenuItem menuItem) {
            int iM3420a = C0809s.m3420a(GlobalApplication.m3260b());
            if (-3 == iM3420a || -2 == iM3420a) {
                C2153y.m7535a(getActivity(), R.string.popup_no_network_connection, 0).show();
                return true;
            }
            switch (menuItem.getItemId()) {
                case MediaEntity.Size.FIT /* 100 */:
                    m2209a(this.f1190h, this.f1191i);
                    break;
                case MediaEntity.Size.CROP /* 101 */:
                    m2208a(this.f1190h);
                    break;
            }
            return true;
        }
    }
}
