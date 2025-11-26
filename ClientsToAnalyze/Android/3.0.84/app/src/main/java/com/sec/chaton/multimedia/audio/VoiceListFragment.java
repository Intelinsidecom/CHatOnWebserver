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
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.widget.C3263j;

/* loaded from: classes.dex */
public class VoiceListFragment extends Fragment {

    /* renamed from: b */
    private static final String f6522b = VoiceListFragment.class.getSimpleName();

    /* renamed from: a */
    InterfaceC1378v f6523a = new C1790v(this);

    /* renamed from: c */
    private C1377u f6524c;

    /* renamed from: d */
    private Activity f6525d;

    /* renamed from: e */
    private ListView f6526e;

    /* renamed from: f */
    private C1785q f6527f;

    /* renamed from: g */
    private Cursor f6528g;

    /* renamed from: h */
    private ProgressDialog f6529h;

    /* renamed from: i */
    private View f6530i;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6524c = new C1377u(this.f6525d.getContentResolver(), this.f6523a);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View viewInflate = layoutInflater.inflate(R.layout.layout_voice_list, viewGroup, false);
        this.f6526e = (ListView) viewInflate.findViewById(R.id.voice_list_view);
        TextView textView = (TextView) viewInflate.findViewById(R.id.support_type).findViewById(R.id.text1);
        textView.setTextAppearance(this.f6525d, R.style.TextAppearance_List07_Variable);
        textView.setText(getString(R.string.voice_support_lists, "3gp, 3ga, m4a, amr"));
        this.f6530i = viewInflate.findViewById(R.id.voice_no_contents);
        ((ImageView) this.f6530i.findViewById(R.id.image1)).setImageResource(R.drawable.no_contents_voice);
        ((TextView) this.f6530i.findViewById(R.id.text1)).setText(R.string.dialog_title_noblock_item);
        this.f6527f = new C1785q(getActivity(), R.layout.list_item_common_6, null);
        this.f6526e.setAdapter((ListAdapter) this.f6527f);
        this.f6526e.setOnItemClickListener(new C1789u(this));
        this.f6524c.startQuery(1, null, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{"_data", "_id", "mime_type", "_display_name", "date_modified", "duration"}, "_data LIKE '%.3gp' OR _data LIKE '%.amr' OR _data LIKE '%.3ga' OR _data LIKE '%.m4a'", null, "_display_name");
        m7280b();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.f6529h.isShowing()) {
            if (this.f6528g == null || this.f6528g.getCount() == 0) {
                this.f6530i.setVisibility(0);
            } else {
                this.f6530i.setVisibility(8);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f6525d = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f6525d = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() throws IllegalStateException {
        super.onDestroyView();
        if (this.f6527f != null) {
            this.f6527f.m7372a();
        }
        m7281c();
    }

    /* renamed from: b */
    private void m7280b() {
        if (this.f6529h == null) {
            this.f6529h = (ProgressDialog) new C3263j(this.f6525d).m11487a(R.string.setting_webview_please_wait);
        }
        if (!this.f6529h.isShowing()) {
            this.f6529h.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m7281c() {
        if (this.f6529h != null && this.f6525d != null) {
            this.f6529h.dismiss();
        }
    }
}
