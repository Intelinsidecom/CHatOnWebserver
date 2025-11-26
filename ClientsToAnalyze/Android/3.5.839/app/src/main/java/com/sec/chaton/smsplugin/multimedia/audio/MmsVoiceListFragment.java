package com.sec.chaton.smsplugin.multimedia.audio;

import android.app.Activity;
import android.app.ProgressDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.widget.C4923p;

/* loaded from: classes.dex */
public class MmsVoiceListFragment extends Fragment {

    /* renamed from: b */
    private static final String f14025b = MmsVoiceListFragment.class.getSimpleName();

    /* renamed from: a */
    InterfaceC2211y f14026a = new C3911f(this);

    /* renamed from: c */
    private C2210x f14027c;

    /* renamed from: d */
    private Activity f14028d;

    /* renamed from: e */
    private ListView f14029e;

    /* renamed from: f */
    private C3906a f14030f;

    /* renamed from: g */
    private Cursor f14031g;

    /* renamed from: h */
    private ProgressDialog f14032h;

    /* renamed from: i */
    private ViewStub f14033i;

    /* renamed from: j */
    private View f14034j;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f14027c = new C2210x(this.f14028d.getContentResolver(), this.f14026a);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(R.layout.layout_voice_list, viewGroup, false);
        this.f14029e = (ListView) viewInflate.findViewById(R.id.voice_list_view);
        TextView textView = (TextView) viewInflate.findViewById(R.id.support_type).findViewById(R.id.text1);
        textView.setTextAppearance(this.f14028d, R.style.TextAppearance_List07_Variable);
        textView.setText(getString(R.string.voice_support_lists, "3gp, 3ga, m4a, amr"));
        this.f14033i = (ViewStub) viewInflate.findViewById(R.id.voice_no_contents);
        this.f14030f = new C3906a(getActivity(), R.layout.list_item_common_6, null);
        this.f14029e.setAdapter((ListAdapter) this.f14030f);
        this.f14029e.setOnItemClickListener(new C3910e(this));
        this.f14027c.startQuery(1, null, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{"_data", "_id", "mime_type", "_display_name", "date_modified", "duration"}, "_data LIKE '%.3gp' OR _data LIKE '%.amr' OR _data LIKE '%.3ga' OR _data LIKE '%.m4a'", null, "_display_name");
        m15083c();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.f14032h.isShowing()) {
            if (this.f14031g == null || this.f14031g.getCount() == 0) {
                m15082b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m15082b() {
        if (this.f14034j == null) {
            this.f14034j = this.f14033i.inflate();
            ((ImageView) this.f14034j.findViewById(R.id.image1)).setImageResource(R.drawable.no_contents_voice);
            ((TextView) this.f14034j.findViewById(R.id.text1)).setText(R.string.dialog_title_noblock_item);
        }
        this.f14034j.setVisibility(0);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f14028d = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f14028d = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() throws IllegalStateException {
        super.onDestroyView();
        if (this.f14030f != null) {
            this.f14030f.m15095c();
        }
        m15085d();
    }

    /* renamed from: c */
    private void m15083c() {
        if (this.f14032h == null) {
            this.f14032h = (ProgressDialog) C4923p.m18723a(this.f14028d).m18724a(R.string.setting_webview_please_wait);
        }
        if (!this.f14032h.isShowing()) {
            this.f14032h.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m15085d() {
        if (this.f14032h != null && this.f14028d != null) {
            this.f14032h.dismiss();
        }
    }
}
