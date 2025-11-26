package android.support.v4.app;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* renamed from: a */
    private final ArrayList<C0023ai> f57a;

    /* renamed from: b */
    private FrameLayout f58b;

    /* renamed from: c */
    private Context f59c;

    /* renamed from: d */
    private AbstractC0069w f60d;

    /* renamed from: e */
    private int f61e;

    /* renamed from: f */
    private TabHost.OnTabChangeListener f62f;

    /* renamed from: g */
    private C0023ai f63g;

    /* renamed from: h */
    private boolean f64h;

    class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0022ah();
        String curTab;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.curTab = parcel.readString();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.curTab);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.curTab + "}";
        }
    }

    public FragmentTabHost(Context context) {
        super(context, null);
        this.f57a = new ArrayList<>();
        m57a(context, (AttributeSet) null);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f57a = new ArrayList<>();
        m57a(context, attributeSet);
    }

    /* renamed from: a */
    private void m57a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.inflatedId}, 0, 0);
        this.f61e = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    /* renamed from: a */
    private void m56a(Context context) {
        if (findViewById(R.id.tabs) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            TabWidget tabWidget = new TabWidget(context);
            tabWidget.setId(R.id.tabs);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, -2, 0.0f));
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(R.id.tabcontent);
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, 0, 0.0f));
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.f58b = frameLayout2;
            this.f58b.setId(this.f61e);
            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void setup(Context context, AbstractC0069w abstractC0069w) {
        m56a(context);
        super.setup();
        this.f59c = context;
        this.f60d = abstractC0069w;
        m55a();
    }

    public void setup(Context context, AbstractC0069w abstractC0069w, int i) {
        m56a(context);
        super.setup();
        this.f59c = context;
        this.f60d = abstractC0069w;
        this.f61e = i;
        m55a();
        this.f58b.setId(i);
        if (getId() == -1) {
            setId(R.id.tabhost);
        }
    }

    /* renamed from: a */
    private void m55a() {
        if (this.f58b == null) {
            this.f58b = (FrameLayout) findViewById(this.f61e);
            if (this.f58b == null) {
                throw new IllegalStateException("No tab content FrameLayout found for id " + this.f61e);
            }
        }
    }

    @Override // android.widget.TabHost
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.f62f = onTabChangeListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        AbstractC0024aj abstractC0024ajMo183a = null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f57a.size()) {
                break;
            }
            C0023ai c0023ai = this.f57a.get(i2);
            c0023ai.f104d = this.f60d.mo182a(c0023ai.f101a);
            if (c0023ai.f104d != null && !c0023ai.f104d.isDetached()) {
                if (c0023ai.f101a.equals(currentTabTag)) {
                    this.f63g = c0023ai;
                } else {
                    if (abstractC0024ajMo183a == null) {
                        abstractC0024ajMo183a = this.f60d.mo183a();
                    }
                    abstractC0024ajMo183a.mo105d(c0023ai.f104d);
                }
            }
            i = i2 + 1;
        }
        this.f64h = true;
        AbstractC0024aj abstractC0024ajM54a = m54a(currentTabTag, abstractC0024ajMo183a);
        if (abstractC0024ajM54a != null) {
            abstractC0024ajM54a.mo99b();
            this.f60d.mo186b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f64h = false;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.curTab = getCurrentTabTag();
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.curTab);
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(String str) {
        AbstractC0024aj abstractC0024ajM54a;
        if (this.f64h && (abstractC0024ajM54a = m54a(str, (AbstractC0024aj) null)) != null) {
            abstractC0024ajM54a.mo99b();
        }
        if (this.f62f != null) {
            this.f62f.onTabChanged(str);
        }
    }

    /* renamed from: a */
    private AbstractC0024aj m54a(String str, AbstractC0024aj abstractC0024aj) {
        C0023ai c0023ai = null;
        int i = 0;
        while (i < this.f57a.size()) {
            C0023ai c0023ai2 = this.f57a.get(i);
            if (!c0023ai2.f101a.equals(str)) {
                c0023ai2 = c0023ai;
            }
            i++;
            c0023ai = c0023ai2;
        }
        if (c0023ai == null) {
            throw new IllegalStateException("No tab known for tag " + str);
        }
        if (this.f63g != c0023ai) {
            if (abstractC0024aj == null) {
                abstractC0024aj = this.f60d.mo183a();
            }
            if (this.f63g != null && this.f63g.f104d != null) {
                abstractC0024aj.mo105d(this.f63g.f104d);
            }
            if (c0023ai != null) {
                if (c0023ai.f104d == null) {
                    c0023ai.f104d = Fragment.instantiate(this.f59c, c0023ai.f102b.getName(), c0023ai.f103c);
                    abstractC0024aj.mo96a(this.f61e, c0023ai.f104d, c0023ai.f101a);
                } else {
                    abstractC0024aj.mo106e(c0023ai.f104d);
                }
            }
            this.f63g = c0023ai;
        }
        return abstractC0024aj;
    }
}
