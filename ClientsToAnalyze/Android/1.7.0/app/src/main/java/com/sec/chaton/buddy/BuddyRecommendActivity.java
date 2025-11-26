package com.sec.chaton.buddy;

import android.app.ProgressDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.p013a.C0202ao;
import com.sec.chaton.p025d.C0670w;
import com.sec.chaton.widget.ProgressDialogC1354a;

/* loaded from: classes.dex */
public class BuddyRecommendActivity extends BaseSinglePaneActivity {
    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: a */
    protected Fragment mo664a() {
        return new BuddyRecommendFragment();
    }

    public class BuddyRecommendFragment extends Fragment implements LoaderManager.LoaderCallbacks {

        /* renamed from: a */
        private C0421cb f1256a;

        /* renamed from: b */
        private ListView f1257b;

        /* renamed from: c */
        private View f1258c;

        /* renamed from: d */
        private ProgressDialog f1259d;

        /* renamed from: e */
        private C0202ao f1260e;

        /* renamed from: f */
        private String f1261f;

        /* renamed from: g */
        private View.OnClickListener f1262g = new ViewOnClickListenerC0438cs(this);

        /* renamed from: h */
        private Handler f1263h = new HandlerC0437cr(this);

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewInflate = layoutInflater.inflate(R.layout.layout_buddy_recommend, viewGroup, false);
            this.f1257b = (ListView) viewInflate.findViewById(android.R.id.list);
            this.f1258c = viewInflate.findViewById(R.id.no_recommendations_layout);
            return viewInflate;
        }

        @Override // android.support.v4.app.Fragment
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            this.f1256a = new C0421cb(this, getActivity(), R.layout.list_item_add_buddy, null, "type");
            this.f1257b.setAdapter((ListAdapter) this.f1256a);
            this.f1257b.setEmptyView(this.f1258c);
            getLoaderManager().initLoader(0, null, this);
            this.f1260e = new C0202ao(this.f1263h);
            this.f1259d = new ProgressDialogC1354a(getActivity(), false);
            this.f1259d.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
        }

        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        public Loader onCreateLoader(int i, Bundle bundle) {
            return new CursorLoader(getActivity(), C0670w.f2314a, null, null, null, "type");
        }

        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onLoadFinished(Loader loader, Cursor cursor) {
            this.f1256a.swapCursor(cursor);
        }

        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        public void onLoaderReset(Loader loader) {
            this.f1256a.swapCursor(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m2296a(String str) {
            if (str == null) {
                str = this.f1261f;
            }
            this.f1259d.show();
            this.f1260e.m765b(str, true);
            this.f1261f = str;
        }
    }
}
