package com.sec.chaton.multimedia.audio;

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
public class VoiceListFragment extends Fragment {

    /* renamed from: b */
    private static final String f9748b = VoiceListFragment.class.getSimpleName();

    /* renamed from: a */
    InterfaceC2211y f9749a = new C2742r(this);

    /* renamed from: c */
    private C2210x f9750c;

    /* renamed from: d */
    private Activity f9751d;

    /* renamed from: e */
    private ListView f9752e;

    /* renamed from: f */
    private C2737m f9753f;

    /* renamed from: g */
    private Cursor f9754g;

    /* renamed from: h */
    private ProgressDialog f9755h;

    /* renamed from: i */
    private ViewStub f9756i;

    /* renamed from: j */
    private View f9757j;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9750c = new C2210x(this.f9751d.getContentResolver(), this.f9749a);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(R.layout.layout_voice_list, viewGroup, false);
        this.f9752e = (ListView) viewInflate.findViewById(R.id.voice_list_view);
        TextView textView = (TextView) viewInflate.findViewById(R.id.support_type).findViewById(R.id.text1);
        textView.setTextAppearance(this.f9751d, R.style.TextAppearance_List07_Variable);
        textView.setText(getString(R.string.voice_support_lists, "3gp, 3ga, m4a, amr"));
        this.f9756i = (ViewStub) viewInflate.findViewById(R.id.voice_no_contents);
        this.f9753f = new C2737m(getActivity(), R.layout.list_item_common_6, null);
        this.f9752e.setAdapter((ListAdapter) this.f9753f);
        this.f9752e.setOnItemClickListener(new C2741q(this));
        this.f9750c.startQuery(1, null, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{"_data", "_id", "mime_type", "_display_name", "date_modified", "duration"}, "_data LIKE '%.3gp' OR _data LIKE '%.amr' OR _data LIKE '%.3ga' OR _data LIKE '%.m4a'", null, "_display_name");
        m11420c();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.f9755h.isShowing()) {
            if (this.f9754g == null || this.f9754g.getCount() == 0) {
                m11419b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m11419b() {
        if (this.f9757j == null) {
            this.f9757j = this.f9756i.inflate();
            ((ImageView) this.f9757j.findViewById(R.id.image1)).setImageResource(R.drawable.no_contents_voice);
            ((TextView) this.f9757j.findViewById(R.id.text1)).setText(R.string.dialog_title_noblock_item);
        }
        this.f9757j.setVisibility(0);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f9751d = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f9751d = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() throws IllegalStateException {
        super.onDestroyView();
        if (this.f9753f != null) {
            this.f9753f.m11496c();
        }
        m11422d();
    }

    /* renamed from: c */
    private void m11420c() {
        if (this.f9755h == null) {
            this.f9755h = (ProgressDialog) new C4923p(this.f9751d).m18724a(R.string.setting_webview_please_wait);
        }
        if (!this.f9755h.isShowing()) {
            this.f9755h.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m11422d() {
        if (this.f9755h != null && this.f9751d != null) {
            this.f9755h.dismiss();
        }
    }
}
