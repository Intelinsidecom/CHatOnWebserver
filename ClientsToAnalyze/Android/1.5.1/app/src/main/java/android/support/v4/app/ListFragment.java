package android.support.v4.app;

import android.R;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

/* loaded from: classes.dex */
public class ListFragment extends Fragment {

    /* renamed from: a */
    private final Handler f13a = new Handler();

    /* renamed from: b */
    private final Runnable f14b = new RunnableC0008i(this);

    /* renamed from: c */
    private final AdapterView.OnItemClickListener f15c = new C0009j(this);

    /* renamed from: e */
    ListAdapter f16e;

    /* renamed from: f */
    ListView f17f;

    /* renamed from: g */
    View f18g;

    /* renamed from: h */
    TextView f19h;

    /* renamed from: i */
    View f20i;

    /* renamed from: j */
    View f21j;

    /* renamed from: k */
    CharSequence f22k;

    /* renamed from: l */
    boolean f23l;

    /* renamed from: a */
    private void m31a() {
        if (this.f17f != null) {
            return;
        }
        View view = getView();
        if (view == null) {
            throw new IllegalStateException("Content view not yet created");
        }
        if (view instanceof ListView) {
            this.f17f = (ListView) view;
        } else {
            this.f19h = (TextView) view.findViewById(16711681);
            if (this.f19h == null) {
                this.f18g = view.findViewById(R.id.empty);
            } else {
                this.f19h.setVisibility(8);
            }
            this.f20i = view.findViewById(16711682);
            this.f21j = view.findViewById(16711683);
            View viewFindViewById = view.findViewById(R.id.list);
            if (!(viewFindViewById instanceof ListView)) {
                if (viewFindViewById != null) {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
                throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
            }
            this.f17f = (ListView) viewFindViewById;
            if (this.f18g != null) {
                this.f17f.setEmptyView(this.f18g);
            } else if (this.f22k != null) {
                this.f19h.setText(this.f22k);
                this.f17f.setEmptyView(this.f19h);
            }
        }
        this.f23l = true;
        this.f17f.setOnItemClickListener(this.f15c);
        if (this.f16e != null) {
            ListAdapter listAdapter = this.f16e;
            this.f16e = null;
            m33a(listAdapter);
        } else if (this.f20i != null) {
            m32a(false, false);
        }
        this.f13a.post(this.f14b);
    }

    /* renamed from: a */
    private void m32a(boolean z, boolean z2) {
        m31a();
        if (this.f20i == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        if (this.f23l == z) {
            return;
        }
        this.f23l = z;
        if (z) {
            if (z2) {
                this.f20i.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out));
                this.f21j.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in));
            } else {
                this.f20i.clearAnimation();
                this.f21j.clearAnimation();
            }
            this.f20i.setVisibility(8);
            this.f21j.setVisibility(0);
            return;
        }
        if (z2) {
            this.f20i.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in));
            this.f21j.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out));
        } else {
            this.f20i.clearAnimation();
            this.f21j.clearAnimation();
        }
        this.f20i.setVisibility(0);
        this.f21j.setVisibility(8);
    }

    /* renamed from: a */
    public void m33a(ListAdapter listAdapter) {
        boolean z = this.f16e != null;
        this.f16e = listAdapter;
        if (this.f17f != null) {
            this.f17f.setAdapter(listAdapter);
            if (this.f23l || z) {
                return;
            }
            m32a(true, getView().getWindowToken() != null);
        }
    }

    /* renamed from: a */
    public void mo34a(ListView listView, View view, int i, long j) {
    }

    /* renamed from: d */
    public ListView m35d() {
        m31a();
        return this.f17f;
    }

    /* renamed from: e */
    public ListAdapter m36e() {
        return this.f16e;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentActivity activity = getActivity();
        FrameLayout frameLayout = new FrameLayout(activity);
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(activity, null, R.attr.progressBarStyleLarge), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(activity);
        frameLayout2.setId(16711683);
        TextView textView = new TextView(getActivity());
        textView.setId(16711681);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(getActivity());
        listView.setId(R.id.list);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        this.f13a.removeCallbacks(this.f14b);
        this.f17f = null;
        this.f23l = false;
        this.f21j = null;
        this.f20i = null;
        this.f18g = null;
        this.f19h = null;
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m31a();
    }
}
