package com.sec.chaton.buddy;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p009b.ContextMenuC0237a;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.p015d.C0636h;
import com.sec.chaton.p017e.C0702q;
import com.sec.chaton.p017e.C0706u;
import com.sec.chaton.p022h.C0809s;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.ProgressDialogC1806j;
import com.sec.widget.AlertDialogBuilderC2120a;
import com.sec.widget.C2153y;
import java.util.ArrayList;
import twitter4j.MediaEntity;

/* loaded from: classes.dex */
public class BuddyRecommendActivity extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
        }
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo649a() {
        return new BuddyRecommendFragment();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        ActionBar actionBar;
        super.onPostCreate(bundle);
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14 && (actionBar = getActionBar()) != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public class BuddyRecommendFragment extends Fragment implements LoaderManager.LoaderCallbacks {

        /* renamed from: a */
        private C0362dt f1165a;

        /* renamed from: b */
        private ListView f1166b;

        /* renamed from: c */
        private View f1167c;

        /* renamed from: d */
        private TextView f1168d;

        /* renamed from: e */
        private ProgressDialogC1806j f1169e;

        /* renamed from: f */
        private C0633e f1170f;

        /* renamed from: g */
        private C0636h f1171g;

        /* renamed from: h */
        private String f1172h;

        /* renamed from: i */
        private int f1173i;

        /* renamed from: j */
        private String f1174j;

        /* renamed from: k */
        private ArrayList f1175k = new ArrayList();

        /* renamed from: l */
        private View.OnClickListener f1176l = new ViewOnClickListenerC0352dj(this);

        /* renamed from: m */
        private View.OnClickListener f1177m = new ViewOnClickListenerC0353dk(this);

        /* renamed from: n */
        private View.OnClickListener f1178n = new ViewOnClickListenerC0354dl(this);

        /* renamed from: o */
        private View.OnClickListener f1179o = new ViewOnClickListenerC0355dm(this);

        /* renamed from: p */
        private View.OnClickListener f1180p = new ViewOnClickListenerC0356dn(this);

        /* renamed from: q */
        private Handler f1181q = new HandlerC0357do(this);

        /* renamed from: r */
        private Handler f1182r = new HandlerC0361ds(this);

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewInflate = layoutInflater.inflate(R.layout.layout_buddy_recommend, viewGroup, false);
            this.f1166b = (ListView) viewInflate.findViewById(android.R.id.list);
            this.f1167c = viewInflate.findViewById(R.id.no_recommendations_layout);
            this.f1168d = (TextView) viewInflate.findViewById(R.id.recommend_recv_info);
            return viewInflate;
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            if (C1789u.m6075a().getBoolean("recomned_receive", true) || C1789u.m6075a().getBoolean("recomned_special", true)) {
                this.f1165a = new C0362dt(this, getActivity(), R.layout.list_item_add_buddy, null, "type");
                this.f1166b.setDivider(getResources().getDrawable(R.drawable.list_2line));
                this.f1166b.setAdapter((ListAdapter) this.f1165a);
                this.f1166b.setEmptyView(this.f1167c);
                getLoaderManager().initLoader(0, null, this);
                this.f1165a.notifyDataSetChanged();
                this.f1170f = new C0633e(this.f1181q);
                this.f1171g = new C0636h(this.f1182r);
                this.f1169e = new ProgressDialogC1806j(getActivity(), false);
                this.f1169e.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
                return;
            }
            this.f1168d.setText(R.string.add_buddy_suggestion_not_use);
            this.f1166b.setEmptyView(this.f1167c);
        }

        @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
            super.onConfigurationChanged(configuration);
            if (getResources() != null && this.f1167c != null) {
                this.f1167c.setPadding(0, getResources().getDimensionPixelSize(R.dimen.buddy_no_suggestion_padding_top), 0, 0);
            }
        }

        /* renamed from: a */
        public static Cursor m2178a(ContentResolver contentResolver, String str) {
            return contentResolver.query(C0702q.f2645a, null, "buddy_no='" + str + "'", null, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public int m2176a() {
            Cursor cursorQuery = GlobalApplication.m3260b().getContentResolver().query(C0702q.f2645a, null, "type='200'", null, null);
            int count = cursorQuery.getCount();
            cursorQuery.close();
            return count;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public int m2184b() {
            Cursor cursorQuery = GlobalApplication.m3260b().getContentResolver().query(C0702q.f2645a, null, "type='100'", null, null);
            int count = cursorQuery.getCount();
            cursorQuery.close();
            return count;
        }

        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        public Loader onCreateLoader(int i, Bundle bundle) {
            return new CursorLoader(getActivity(), C0702q.f2645a, null, null, null, "type");
        }

        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onLoadFinished(Loader loader, Cursor cursor) {
            SQLiteDatabase readableDatabase = C0706u.m3172a(getActivity()).getReadableDatabase();
            if (C1789u.m6075a().getBoolean("recomned_receive", true)) {
                this.f1165a.swapCursor(readableDatabase.rawQuery("SELECT * FROM recommendee WHERE type='200' LIMIT 30; ", null));
            }
            if (C1789u.m6075a().getBoolean("recomned_special", true)) {
                this.f1165a.swapCursor(readableDatabase.rawQuery("SELECT * FROM recommendee WHERE type='100' LIMIT 3; ", null));
            }
            if (C1789u.m6075a().getBoolean("recomned_receive", true) && C1789u.m6075a().getBoolean("recomned_special", true)) {
                this.f1165a.swapCursor(readableDatabase.rawQuery("SELECT * FROM (SELECT * FROM recommendee WHERE type='100' LIMIT 3) UNION ALL SELECT * FROM (SELECT * FROM recommendee WHERE type='200' LIMIT 30); ", null));
            }
            if (!C1789u.m6075a().getBoolean("recomned_receive", true) && !C1789u.m6075a().getBoolean("recomned_special", true)) {
                this.f1165a.swapCursor(null);
            }
            this.f1165a.notifyDataSetChanged();
        }

        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(Loader loader) {
            this.f1165a.swapCursor(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m2183a(String str, int i) {
            if (str == null) {
                str = this.f1172h;
            }
            this.f1169e.show();
            if (i == 200) {
                this.f1170f.m2869b(str, true);
            } else if (str.startsWith("0999")) {
                this.f1170f.m2873c(str);
            }
            this.f1165a.notifyDataSetChanged();
            this.f1172h = str;
            Cursor cursorM2178a = m2178a(getActivity().getContentResolver(), this.f1172h);
            if (cursorM2178a != null && cursorM2178a.moveToFirst()) {
                this.f1174j = cursorM2178a.getString(2);
            }
            if (cursorM2178a != null) {
                cursorM2178a.close();
            }
        }

        /* renamed from: a */
        private void m2182a(String str) {
            if (str == null) {
                str = this.f1172h;
            }
            if (!this.f1175k.contains(str)) {
                this.f1175k.add(str);
            }
            AlertDialog alertDialogCreate = new AlertDialogBuilderC2120a(getActivity()).setCancelable(false).setTitle(getResources().getString(R.string.buddy_suggestion_ignore_all)).setMessage(R.string.suggestion_ignore_buddy_toast).setPositiveButton(android.R.string.cancel, new DialogInterfaceOnClickListenerC0351di(this)).setNegativeButton(android.R.string.ok, new DialogInterfaceOnClickListenerC0350dh(this)).create();
            if (!getActivity().isFinishing()) {
                alertDialogCreate.show();
            }
        }

        @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            ContextMenuC0237a contextMenuC0237a = new ContextMenuC0237a(getActivity(), contextMenu);
            C0363du c0363du = new C0363du(view);
            this.f1172h = c0363du.f1513c.getTag(R.id.TAG_FOR_BUDDYNO).toString();
            this.f1173i = Integer.parseInt(c0363du.f1513c.getTag(R.id.TAG_FOR_TYPE).toString());
            this.f1174j = c0363du.f1512b.getText().toString();
            contextMenuC0237a.setHeaderTitle(this.f1174j);
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
                    m2183a(this.f1172h, this.f1173i);
                    break;
                case MediaEntity.Size.CROP /* 101 */:
                    m2182a(this.f1172h);
                    break;
            }
            return true;
        }
    }
}
