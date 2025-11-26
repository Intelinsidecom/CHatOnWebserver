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
    ListAdapter f65a;

    /* renamed from: b */
    ListView f66b;

    /* renamed from: c */
    View f67c;

    /* renamed from: d */
    TextView f68d;

    /* renamed from: e */
    View f69e;

    /* renamed from: f */
    View f70f;

    /* renamed from: g */
    CharSequence f71g;

    /* renamed from: h */
    boolean f72h;

    /* renamed from: i */
    private final Handler f73i = new Handler();

    /* renamed from: j */
    private final Runnable f74j = new RunnableC0025ak(this);

    /* renamed from: k */
    private final AdapterView.OnItemClickListener f75k = new C0026al(this);

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
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m59c();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        this.f73i.removeCallbacks(this.f74j);
        this.f66b = null;
        this.f72h = false;
        this.f70f = null;
        this.f69e = null;
        this.f67c = null;
        this.f68d = null;
        super.onDestroyView();
    }

    /* renamed from: a */
    public void mo62a(ListView listView, View view, int i, long j) {
    }

    /* renamed from: a */
    public void m61a(ListAdapter listAdapter) {
        boolean z = this.f65a != null;
        this.f65a = listAdapter;
        if (this.f66b != null) {
            this.f66b.setAdapter(listAdapter);
            if (!this.f72h && !z) {
                m58a(true, getView().getWindowToken() != null);
            }
        }
    }

    /* renamed from: a */
    public ListView m60a() {
        m59c();
        return this.f66b;
    }

    /* renamed from: a */
    private void m58a(boolean z, boolean z2) {
        m59c();
        if (this.f69e == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        if (this.f72h != z) {
            this.f72h = z;
            if (z) {
                if (z2) {
                    this.f69e.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out));
                    this.f70f.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in));
                } else {
                    this.f69e.clearAnimation();
                    this.f70f.clearAnimation();
                }
                this.f69e.setVisibility(8);
                this.f70f.setVisibility(0);
                return;
            }
            if (z2) {
                this.f69e.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in));
                this.f70f.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out));
            } else {
                this.f69e.clearAnimation();
                this.f70f.clearAnimation();
            }
            this.f69e.setVisibility(0);
            this.f70f.setVisibility(8);
        }
    }

    /* renamed from: b */
    public ListAdapter m63b() {
        return this.f65a;
    }

    /* renamed from: c */
    private void m59c() {
        if (this.f66b == null) {
            View view = getView();
            if (view == null) {
                throw new IllegalStateException("Content view not yet created");
            }
            if (view instanceof ListView) {
                this.f66b = (ListView) view;
            } else {
                this.f68d = (TextView) view.findViewById(16711681);
                if (this.f68d == null) {
                    this.f67c = view.findViewById(R.id.empty);
                } else {
                    this.f68d.setVisibility(8);
                }
                this.f69e = view.findViewById(16711682);
                this.f70f = view.findViewById(16711683);
                View viewFindViewById = view.findViewById(R.id.list);
                if (!(viewFindViewById instanceof ListView)) {
                    if (viewFindViewById == null) {
                        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                    }
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
                this.f66b = (ListView) viewFindViewById;
                if (this.f67c != null) {
                    this.f66b.setEmptyView(this.f67c);
                } else if (this.f71g != null) {
                    this.f68d.setText(this.f71g);
                    this.f66b.setEmptyView(this.f68d);
                }
            }
            this.f72h = true;
            this.f66b.setOnItemClickListener(this.f75k);
            if (this.f65a != null) {
                ListAdapter listAdapter = this.f65a;
                this.f65a = null;
                m61a(listAdapter);
            } else if (this.f69e != null) {
                m58a(false, false);
            }
            this.f73i.post(this.f74j);
        }
    }
}
