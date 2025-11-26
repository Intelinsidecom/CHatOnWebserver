package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.p008c.C0081d;
import android.support.v4.p008c.C0082e;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: FragmentManager.java */
/* renamed from: android.support.v4.app.y */
/* loaded from: classes.dex */
final class C0071y extends AbstractC0069w {

    /* renamed from: A */
    static final Interpolator f207A;

    /* renamed from: B */
    static final Interpolator f208B;

    /* renamed from: C */
    static final Interpolator f209C;

    /* renamed from: a */
    static boolean f210a = false;

    /* renamed from: b */
    static final boolean f211b;

    /* renamed from: z */
    static final Interpolator f212z;

    /* renamed from: c */
    ArrayList<Runnable> f213c;

    /* renamed from: d */
    Runnable[] f214d;

    /* renamed from: e */
    boolean f215e;

    /* renamed from: f */
    ArrayList<Fragment> f216f;

    /* renamed from: g */
    ArrayList<Fragment> f217g;

    /* renamed from: h */
    ArrayList<Integer> f218h;

    /* renamed from: i */
    ArrayList<RunnableC0058l> f219i;

    /* renamed from: j */
    ArrayList<Fragment> f220j;

    /* renamed from: k */
    ArrayList<RunnableC0058l> f221k;

    /* renamed from: l */
    ArrayList<Integer> f222l;

    /* renamed from: m */
    ArrayList<InterfaceC0070x> f223m;

    /* renamed from: o */
    FragmentActivity f225o;

    /* renamed from: p */
    InterfaceC0068v f226p;

    /* renamed from: q */
    Fragment f227q;

    /* renamed from: r */
    boolean f228r;

    /* renamed from: s */
    boolean f229s;

    /* renamed from: t */
    boolean f230t;

    /* renamed from: u */
    String f231u;

    /* renamed from: v */
    boolean f232v;

    /* renamed from: n */
    int f224n = 0;

    /* renamed from: w */
    Bundle f233w = null;

    /* renamed from: x */
    SparseArray<Parcelable> f234x = null;

    /* renamed from: y */
    Runnable f235y = new RunnableC0072z(this);

    C0071y() {
    }

    static {
        f211b = Build.VERSION.SDK_INT >= 11;
        f212z = new DecelerateInterpolator(2.5f);
        f207A = new DecelerateInterpolator(1.5f);
        f208B = new AccelerateInterpolator(2.5f);
        f209C = new AccelerateInterpolator(1.5f);
    }

    /* renamed from: a */
    private void m191a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C0082e("FragmentManager"));
        if (this.f225o != null) {
            try {
                this.f225o.dump("  ", null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e) {
                Log.e("FragmentManager", "Failed dumping state", e);
                throw runtimeException;
            }
        }
        try {
            m207a("  ", (FileDescriptor) null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e2) {
            Log.e("FragmentManager", "Failed dumping state", e2);
            throw runtimeException;
        }
    }

    @Override // android.support.v4.app.AbstractC0069w
    /* renamed from: a */
    public AbstractC0024aj mo183a() {
        return new RunnableC0058l(this);
    }

    @Override // android.support.v4.app.AbstractC0069w
    /* renamed from: b */
    public boolean mo186b() {
        return m228f();
    }

    /* renamed from: d */
    public boolean m223d() {
        m194u();
        mo186b();
        return m208a(this.f225o.f44a, (String) null, -1, 0);
    }

    @Override // android.support.v4.app.AbstractC0069w
    /* renamed from: a */
    public void mo184a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        m206a((Runnable) new RunnableC0015aa(this, i, i2), false);
    }

    @Override // android.support.v4.app.AbstractC0069w
    /* renamed from: a */
    public void mo185a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mIndex < 0) {
            m191a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.mIndex);
    }

    @Override // android.support.v4.app.AbstractC0069w
    /* renamed from: a */
    public Fragment mo181a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f216f.size()) {
            m191a(new IllegalStateException("Fragement no longer exists for key " + str + ": index " + i));
        }
        Fragment fragment = this.f216f.get(i);
        if (fragment == null) {
            m191a(new IllegalStateException("Fragement no longer exists for key " + str + ": index " + i));
            return fragment;
        }
        return fragment;
    }

    @Override // android.support.v4.app.AbstractC0069w
    /* renamed from: c */
    public List<Fragment> mo187c() {
        return this.f216f;
    }

    @Override // android.support.v4.app.AbstractC0069w
    /* renamed from: a */
    public Fragment.SavedState mo179a(Fragment fragment) {
        Bundle bundleM229g;
        if (fragment.mIndex < 0) {
            m191a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        if (fragment.mState <= 0 || (bundleM229g = m229g(fragment)) == null) {
            return null;
        }
        return new Fragment.SavedState(bundleM229g);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        if (this.f227q != null) {
            C0081d.m262a(this.f227q, sb);
        } else {
            C0081d.m262a(this.f225o, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    /* renamed from: a */
    public void m207a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        int size6;
        String str2 = str + "    ";
        if (this.f216f != null && (size6 = this.f216f.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i = 0; i < size6; i++) {
                Fragment fragment = this.f216f.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment);
                if (fragment != null) {
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        if (this.f217g != null && (size5 = this.f217g.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size5; i2++) {
                Fragment fragment2 = this.f217g.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        if (this.f220j != null && (size4 = this.f220j.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size4; i3++) {
                Fragment fragment3 = this.f220j.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        if (this.f219i != null && (size3 = this.f219i.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                RunnableC0058l runnableC0058l = this.f219i.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(runnableC0058l.toString());
                runnableC0058l.m170a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        synchronized (this) {
            if (this.f221k != null && (size2 = this.f221k.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i5 = 0; i5 < size2; i5++) {
                    Object obj = (RunnableC0058l) this.f221k.get(i5);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println(obj);
                }
            }
            if (this.f222l != null && this.f222l.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f222l.toArray()));
            }
        }
        if (this.f213c != null && (size = this.f213c.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i6 = 0; i6 < size; i6++) {
                Object obj2 = (Runnable) this.f213c.get(i6);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(obj2);
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mActivity=");
        printWriter.println(this.f225o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f226p);
        if (this.f227q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f227q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f224n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f229s);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f230t);
        if (this.f228r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f228r);
        }
        if (this.f231u != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f231u);
        }
        if (this.f218h != null && this.f218h.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.f218h.toArray()));
        }
    }

    /* renamed from: a */
    static Animation m190a(Context context, float f, float f2, float f3, float f4) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f212z);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f3, f4);
        alphaAnimation.setInterpolator(f207A);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }

    /* renamed from: a */
    static Animation m189a(Context context, float f, float f2) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f207A);
        alphaAnimation.setDuration(220L);
        return alphaAnimation;
    }

    /* renamed from: a */
    Animation m196a(Fragment fragment, int i, boolean z, int i2) {
        int iM192b;
        Animation animationLoadAnimation;
        Animation animationOnCreateAnimation = fragment.onCreateAnimation(i, z, fragment.mNextAnim);
        if (animationOnCreateAnimation == null) {
            if (fragment.mNextAnim == 0 || (animationLoadAnimation = AnimationUtils.loadAnimation(this.f225o, fragment.mNextAnim)) == null) {
                if (i != 0 && (iM192b = m192b(i, z)) >= 0) {
                    switch (iM192b) {
                        case 1:
                            return m190a(this.f225o, 1.125f, 1.0f, 0.0f, 1.0f);
                        case 2:
                            return m190a(this.f225o, 1.0f, 0.975f, 1.0f, 0.0f);
                        case 3:
                            return m190a(this.f225o, 0.975f, 1.0f, 0.0f, 1.0f);
                        case 4:
                            return m190a(this.f225o, 1.0f, 1.075f, 1.0f, 0.0f);
                        case 5:
                            return m189a(this.f225o, 0.0f, 1.0f);
                        case 6:
                            return m189a(this.f225o, 1.0f, 0.0f);
                        default:
                            if (i2 == 0 && this.f225o.getWindow() != null) {
                                i2 = this.f225o.getWindow().getAttributes().windowAnimations;
                            }
                            return i2 == 0 ? null : null;
                    }
                }
                return null;
            }
            return animationLoadAnimation;
        }
        return animationOnCreateAnimation;
    }

    /* renamed from: b */
    public void m214b(Fragment fragment) {
        if (fragment.mDeferStart) {
            if (this.f215e) {
                this.f232v = true;
            } else {
                fragment.mDeferStart = false;
                m203a(fragment, this.f224n, 0, 0, false);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:114:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02e5  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void m203a(android.support.v4.app.Fragment r10, int r11, int r12, int r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 980
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.C0071y.m203a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    /* renamed from: c */
    void m219c(Fragment fragment) {
        m203a(fragment, this.f224n, 0, 0, false);
    }

    /* renamed from: a */
    void m199a(int i, boolean z) {
        m197a(i, 0, 0, z);
    }

    /* renamed from: a */
    void m197a(int i, int i2, int i3, boolean z) {
        if (this.f225o == null && i != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z || this.f224n != i) {
            this.f224n = i;
            if (this.f216f != null) {
                int i4 = 0;
                boolean zMo110a = false;
                while (i4 < this.f216f.size()) {
                    Fragment fragment = this.f216f.get(i4);
                    if (fragment != null) {
                        m203a(fragment, i, i2, i3, false);
                        if (fragment.mLoaderManager != null) {
                            zMo110a |= fragment.mLoaderManager.mo110a();
                        }
                    }
                    i4++;
                    zMo110a = zMo110a;
                }
                if (!zMo110a) {
                    m224e();
                }
                if (this.f228r && this.f225o != null && this.f224n == 5) {
                    this.f225o.mo51u_();
                    this.f228r = false;
                }
            }
        }
    }

    /* renamed from: e */
    void m224e() {
        if (this.f216f != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f216f.size()) {
                    Fragment fragment = this.f216f.get(i2);
                    if (fragment != null) {
                        m214b(fragment);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: d */
    void m221d(Fragment fragment) {
        if (fragment.mIndex < 0) {
            if (this.f218h == null || this.f218h.size() <= 0) {
                if (this.f216f == null) {
                    this.f216f = new ArrayList<>();
                }
                fragment.setIndex(this.f216f.size(), this.f227q);
                this.f216f.add(fragment);
            } else {
                fragment.setIndex(this.f218h.remove(this.f218h.size() - 1).intValue(), this.f227q);
                this.f216f.set(fragment.mIndex, fragment);
            }
            if (f210a) {
                Log.v("FragmentManager", "Allocated fragment index " + fragment);
            }
        }
    }

    /* renamed from: e */
    void m225e(Fragment fragment) {
        if (fragment.mIndex >= 0) {
            if (f210a) {
                Log.v("FragmentManager", "Freeing fragment index " + fragment);
            }
            this.f216f.set(fragment.mIndex, null);
            if (this.f218h == null) {
                this.f218h = new ArrayList<>();
            }
            this.f218h.add(Integer.valueOf(fragment.mIndex));
            this.f225o.m45a(fragment.mWho);
            fragment.initState();
        }
    }

    /* renamed from: a */
    public void m204a(Fragment fragment, boolean z) {
        if (this.f217g == null) {
            this.f217g = new ArrayList<>();
        }
        if (f210a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        m221d(fragment);
        if (!fragment.mDetached) {
            if (this.f217g.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            this.f217g.add(fragment);
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.f228r = true;
            }
            if (z) {
                m219c(fragment);
            }
        }
    }

    /* renamed from: a */
    public void m202a(Fragment fragment, int i, int i2) {
        if (f210a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            if (this.f217g != null) {
                this.f217g.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.f228r = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
            m203a(fragment, z ? 0 : 1, i, i2, false);
        }
    }

    /* renamed from: b */
    public void m215b(Fragment fragment, int i, int i2) {
        if (f210a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            if (fragment.mView != null) {
                Animation animationM196a = m196a(fragment, i, false, i2);
                if (animationM196a != null) {
                    fragment.mView.startAnimation(animationM196a);
                }
                fragment.mView.setVisibility(8);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                this.f228r = true;
            }
            fragment.onHiddenChanged(true);
        }
    }

    /* renamed from: c */
    public void m220c(Fragment fragment, int i, int i2) {
        if (f210a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            if (fragment.mView != null) {
                Animation animationM196a = m196a(fragment, i, true, i2);
                if (animationM196a != null) {
                    fragment.mView.startAnimation(animationM196a);
                }
                fragment.mView.setVisibility(0);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                this.f228r = true;
            }
            fragment.onHiddenChanged(false);
        }
    }

    /* renamed from: d */
    public void m222d(Fragment fragment, int i, int i2) {
        if (f210a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (this.f217g != null) {
                    if (f210a) {
                        Log.v("FragmentManager", "remove from detach: " + fragment);
                    }
                    this.f217g.remove(fragment);
                }
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.f228r = true;
                }
                fragment.mAdded = false;
                m203a(fragment, 1, i, i2, false);
            }
        }
    }

    /* renamed from: e */
    public void m226e(Fragment fragment, int i, int i2) {
        if (f210a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                if (this.f217g == null) {
                    this.f217g = new ArrayList<>();
                }
                if (this.f217g.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (f210a) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                this.f217g.add(fragment);
                fragment.mAdded = true;
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.f228r = true;
                }
                m203a(fragment, this.f224n, i, i2, false);
            }
        }
    }

    @Override // android.support.v4.app.AbstractC0069w
    /* renamed from: a */
    public Fragment mo180a(int i) {
        if (this.f217g != null) {
            for (int size = this.f217g.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f217g.get(size);
                if (fragment != null && fragment.mFragmentId == i) {
                    return fragment;
                }
            }
        }
        if (this.f216f != null) {
            for (int size2 = this.f216f.size() - 1; size2 >= 0; size2--) {
                Fragment fragment2 = this.f216f.get(size2);
                if (fragment2 != null && fragment2.mFragmentId == i) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    @Override // android.support.v4.app.AbstractC0069w
    /* renamed from: a */
    public Fragment mo182a(String str) {
        if (this.f217g != null && str != null) {
            for (int size = this.f217g.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f217g.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (this.f216f != null && str != null) {
            for (int size2 = this.f216f.size() - 1; size2 >= 0; size2--) {
                Fragment fragment2 = this.f216f.get(size2);
                if (fragment2 != null && str.equals(fragment2.mTag)) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public Fragment m212b(String str) {
        Fragment fragmentFindFragmentByWho;
        if (this.f216f != null && str != null) {
            for (int size = this.f216f.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f216f.get(size);
                if (fragment != null && (fragmentFindFragmentByWho = fragment.findFragmentByWho(str)) != null) {
                    return fragmentFindFragmentByWho;
                }
            }
        }
        return null;
    }

    /* renamed from: u */
    private void m194u() {
        if (this.f229s) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.f231u != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.f231u);
        }
    }

    /* renamed from: a */
    public void m206a(Runnable runnable, boolean z) {
        if (!z) {
            m194u();
        }
        synchronized (this) {
            if (this.f230t || this.f225o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.f213c == null) {
                this.f213c = new ArrayList<>();
            }
            this.f213c.add(runnable);
            if (this.f213c.size() == 1) {
                this.f225o.f44a.removeCallbacks(this.f235y);
                this.f225o.f44a.post(this.f235y);
            }
        }
    }

    /* renamed from: a */
    public int m195a(RunnableC0058l runnableC0058l) {
        int size;
        synchronized (this) {
            if (this.f222l == null || this.f222l.size() <= 0) {
                if (this.f221k == null) {
                    this.f221k = new ArrayList<>();
                }
                size = this.f221k.size();
                if (f210a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + runnableC0058l);
                }
                this.f221k.add(runnableC0058l);
            } else {
                size = this.f222l.remove(this.f222l.size() - 1).intValue();
                if (f210a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + runnableC0058l);
                }
                this.f221k.set(size, runnableC0058l);
            }
        }
        return size;
    }

    /* renamed from: a */
    public void m198a(int i, RunnableC0058l runnableC0058l) {
        synchronized (this) {
            if (this.f221k == null) {
                this.f221k = new ArrayList<>();
            }
            int size = this.f221k.size();
            if (i < size) {
                if (f210a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + runnableC0058l);
                }
                this.f221k.set(i, runnableC0058l);
            } else {
                while (size < i) {
                    this.f221k.add(null);
                    if (this.f222l == null) {
                        this.f222l = new ArrayList<>();
                    }
                    if (f210a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f222l.add(Integer.valueOf(size));
                    size++;
                }
                if (f210a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + runnableC0058l);
                }
                this.f221k.add(runnableC0058l);
            }
        }
    }

    /* renamed from: b */
    public void m213b(int i) {
        synchronized (this) {
            this.f221k.set(i, null);
            if (this.f222l == null) {
                this.f222l = new ArrayList<>();
            }
            if (f210a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f222l.add(Integer.valueOf(i));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0085, code lost:
    
        r6.f215e = true;
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0088, code lost:
    
        if (r1 >= r3) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008a, code lost:
    
        r6.f214d[r1].run();
        r6.f214d[r1] = null;
        r1 = r1 + 1;
     */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m228f() {
        /*
            r6 = this;
            r0 = 1
            r2 = 0
            boolean r1 = r6.f215e
            if (r1 == 0) goto Lf
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Recursive entry to executePendingTransactions"
            r0.<init>(r1)
            throw r0
        Lf:
            android.os.Looper r1 = android.os.Looper.myLooper()
            android.support.v4.app.FragmentActivity r3 = r6.f225o
            android.os.Handler r3 = r3.f44a
            android.os.Looper r3 = r3.getLooper()
            if (r1 == r3) goto L26
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Must be called from main thread of process"
            r0.<init>(r1)
            throw r0
        L26:
            r1 = r2
        L27:
            monitor-enter(r6)
            java.util.ArrayList<java.lang.Runnable> r3 = r6.f213c     // Catch: java.lang.Throwable -> L99
            if (r3 == 0) goto L34
            java.util.ArrayList<java.lang.Runnable> r3 = r6.f213c     // Catch: java.lang.Throwable -> L99
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L99
            if (r3 != 0) goto L5c
        L34:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L99
            boolean r0 = r6.f232v
            if (r0 == 0) goto La7
            r3 = r2
            r4 = r2
        L3b:
            java.util.ArrayList<android.support.v4.app.Fragment> r0 = r6.f216f
            int r0 = r0.size()
            if (r3 >= r0) goto La0
            java.util.ArrayList<android.support.v4.app.Fragment> r0 = r6.f216f
            java.lang.Object r0 = r0.get(r3)
            android.support.v4.app.Fragment r0 = (android.support.v4.app.Fragment) r0
            if (r0 == 0) goto L58
            android.support.v4.app.ao r5 = r0.mLoaderManager
            if (r5 == 0) goto L58
            android.support.v4.app.ao r0 = r0.mLoaderManager
            boolean r0 = r0.mo110a()
            r4 = r4 | r0
        L58:
            int r0 = r3 + 1
            r3 = r0
            goto L3b
        L5c:
            java.util.ArrayList<java.lang.Runnable> r1 = r6.f213c     // Catch: java.lang.Throwable -> L99
            int r3 = r1.size()     // Catch: java.lang.Throwable -> L99
            java.lang.Runnable[] r1 = r6.f214d     // Catch: java.lang.Throwable -> L99
            if (r1 == 0) goto L6b
            java.lang.Runnable[] r1 = r6.f214d     // Catch: java.lang.Throwable -> L99
            int r1 = r1.length     // Catch: java.lang.Throwable -> L99
            if (r1 >= r3) goto L6f
        L6b:
            java.lang.Runnable[] r1 = new java.lang.Runnable[r3]     // Catch: java.lang.Throwable -> L99
            r6.f214d = r1     // Catch: java.lang.Throwable -> L99
        L6f:
            java.util.ArrayList<java.lang.Runnable> r1 = r6.f213c     // Catch: java.lang.Throwable -> L99
            java.lang.Runnable[] r4 = r6.f214d     // Catch: java.lang.Throwable -> L99
            r1.toArray(r4)     // Catch: java.lang.Throwable -> L99
            java.util.ArrayList<java.lang.Runnable> r1 = r6.f213c     // Catch: java.lang.Throwable -> L99
            r1.clear()     // Catch: java.lang.Throwable -> L99
            android.support.v4.app.FragmentActivity r1 = r6.f225o     // Catch: java.lang.Throwable -> L99
            android.os.Handler r1 = r1.f44a     // Catch: java.lang.Throwable -> L99
            java.lang.Runnable r4 = r6.f235y     // Catch: java.lang.Throwable -> L99
            r1.removeCallbacks(r4)     // Catch: java.lang.Throwable -> L99
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L99
            r6.f215e = r0
            r1 = r2
        L88:
            if (r1 >= r3) goto L9c
            java.lang.Runnable[] r4 = r6.f214d
            r4 = r4[r1]
            r4.run()
            java.lang.Runnable[] r4 = r6.f214d
            r5 = 0
            r4[r1] = r5
            int r1 = r1 + 1
            goto L88
        L99:
            r0 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L99
            throw r0
        L9c:
            r6.f215e = r2
            r1 = r0
            goto L27
        La0:
            if (r4 != 0) goto La7
            r6.f232v = r2
            r6.m224e()
        La7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.C0071y.m228f():boolean");
    }

    /* renamed from: g */
    void m230g() {
        if (this.f223m != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f223m.size()) {
                    this.f223m.get(i2).m188a();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: b */
    void m216b(RunnableC0058l runnableC0058l) {
        if (this.f219i == null) {
            this.f219i = new ArrayList<>();
        }
        this.f219i.add(runnableC0058l);
        m230g();
    }

    /* renamed from: a */
    boolean m208a(Handler handler, String str, int i, int i2) {
        if (this.f219i == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = this.f219i.size() - 1;
            if (size < 0) {
                return false;
            }
            this.f219i.remove(size).m172b(true);
            m230g();
        } else {
            int i3 = -1;
            if (str != null || i >= 0) {
                int size2 = this.f219i.size() - 1;
                while (size2 >= 0) {
                    RunnableC0058l runnableC0058l = this.f219i.get(size2);
                    if ((str != null && str.equals(runnableC0058l.m173d())) || (i >= 0 && i == runnableC0058l.f184o)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        RunnableC0058l runnableC0058l2 = this.f219i.get(size2);
                        if ((str == null || !str.equals(runnableC0058l2.m173d())) && (i < 0 || i != runnableC0058l2.f184o)) {
                            break;
                        }
                        size2--;
                    }
                }
                i3 = size2;
            }
            if (i3 == this.f219i.size() - 1) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int size3 = this.f219i.size() - 1; size3 > i3; size3--) {
                arrayList.add(this.f219i.remove(size3));
            }
            int size4 = arrayList.size() - 1;
            int i4 = 0;
            while (i4 <= size4) {
                if (f210a) {
                    Log.v("FragmentManager", "Popping back stack state: " + arrayList.get(i4));
                }
                ((RunnableC0058l) arrayList.get(i4)).m172b(i4 == size4);
                i4++;
            }
            m230g();
        }
        return true;
    }

    /* renamed from: h */
    ArrayList<Fragment> m231h() {
        ArrayList<Fragment> arrayList = null;
        if (this.f216f != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f216f.size()) {
                    break;
                }
                Fragment fragment = this.f216f.get(i2);
                if (fragment != null && fragment.mRetainInstance) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(fragment);
                    fragment.mRetaining = true;
                    fragment.mTargetIndex = fragment.mTarget != null ? fragment.mTarget.mIndex : -1;
                    if (f210a) {
                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                    }
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    void m227f(Fragment fragment) {
        if (fragment.mInnerView != null) {
            if (this.f234x == null) {
                this.f234x = new SparseArray<>();
            } else {
                this.f234x.clear();
            }
            fragment.mInnerView.saveHierarchyState(this.f234x);
            if (this.f234x.size() > 0) {
                fragment.mSavedViewState = this.f234x;
                this.f234x = null;
            }
        }
    }

    /* renamed from: g */
    Bundle m229g(Fragment fragment) {
        Bundle bundle;
        if (this.f233w == null) {
            this.f233w = new Bundle();
        }
        fragment.performSaveInstanceState(this.f233w);
        if (this.f233w.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f233w;
            this.f233w = null;
        }
        if (fragment.mView != null) {
            m227f(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
        }
        return bundle;
    }

    /* renamed from: i */
    Parcelable m232i() {
        int[] iArr;
        int size;
        int size2;
        boolean z;
        BackStackState[] backStackStateArr = null;
        m228f();
        if (f211b) {
            this.f229s = true;
        }
        if (this.f216f == null || this.f216f.size() <= 0) {
            return null;
        }
        int size3 = this.f216f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size3];
        int i = 0;
        boolean z2 = false;
        while (i < size3) {
            Fragment fragment = this.f216f.get(i);
            if (fragment != null) {
                if (fragment.mIndex < 0) {
                    m191a(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.mIndex));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.mState > 0 && fragmentState.mSavedFragmentState == null) {
                    fragmentState.mSavedFragmentState = m229g(fragment);
                    if (fragment.mTarget != null) {
                        if (fragment.mTarget.mIndex < 0) {
                            m191a(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.mTarget));
                        }
                        if (fragmentState.mSavedFragmentState == null) {
                            fragmentState.mSavedFragmentState = new Bundle();
                        }
                        mo185a(fragmentState.mSavedFragmentState, "android:target_state", fragment.mTarget);
                        if (fragment.mTargetRequestCode != 0) {
                            fragmentState.mSavedFragmentState.putInt("android:target_req_state", fragment.mTargetRequestCode);
                        }
                    }
                } else {
                    fragmentState.mSavedFragmentState = fragment.mSavedFragmentState;
                }
                if (f210a) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.mSavedFragmentState);
                }
                z = true;
            } else {
                z = z2;
            }
            i++;
            z2 = z;
        }
        if (!z2) {
            if (!f210a) {
                return null;
            }
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
        if (this.f217g == null || (size2 = this.f217g.size()) <= 0) {
            iArr = null;
        } else {
            iArr = new int[size2];
            for (int i2 = 0; i2 < size2; i2++) {
                iArr[i2] = this.f217g.get(i2).mIndex;
                if (iArr[i2] < 0) {
                    m191a(new IllegalStateException("Failure saving state: active " + this.f217g.get(i2) + " has cleared index: " + iArr[i2]));
                }
                if (f210a) {
                    Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.f217g.get(i2));
                }
            }
        }
        if (this.f219i != null && (size = this.f219i.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i3 = 0; i3 < size; i3++) {
                backStackStateArr[i3] = new BackStackState(this, this.f219i.get(i3));
                if (f210a) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i3 + ": " + this.f219i.get(i3));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.mActive = fragmentStateArr;
        fragmentManagerState.mAdded = iArr;
        fragmentManagerState.mBackStack = backStackStateArr;
        return fragmentManagerState;
    }

    /* renamed from: a */
    void m201a(Parcelable parcelable, ArrayList<Fragment> arrayList) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.mActive != null) {
                if (arrayList != null) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        Fragment fragment = arrayList.get(i);
                        if (f210a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.mActive[fragment.mIndex];
                        fragmentState.mInstance = fragment;
                        fragment.mSavedViewState = null;
                        fragment.mBackStackNesting = 0;
                        fragment.mInLayout = false;
                        fragment.mAdded = false;
                        fragment.mTarget = null;
                        if (fragmentState.mSavedFragmentState != null) {
                            fragmentState.mSavedFragmentState.setClassLoader(this.f225o.getClassLoader());
                            fragment.mSavedViewState = fragmentState.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                        }
                    }
                }
                this.f216f = new ArrayList<>(fragmentManagerState.mActive.length);
                if (this.f218h != null) {
                    this.f218h.clear();
                }
                for (int i2 = 0; i2 < fragmentManagerState.mActive.length; i2++) {
                    FragmentState fragmentState2 = fragmentManagerState.mActive[i2];
                    if (fragmentState2 != null) {
                        Fragment fragmentM53a = fragmentState2.m53a(this.f225o, this.f227q);
                        if (f210a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + fragmentM53a);
                        }
                        this.f216f.add(fragmentM53a);
                        fragmentState2.mInstance = null;
                    } else {
                        this.f216f.add(null);
                        if (this.f218h == null) {
                            this.f218h = new ArrayList<>();
                        }
                        if (f210a) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                        }
                        this.f218h.add(Integer.valueOf(i2));
                    }
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        Fragment fragment2 = arrayList.get(i3);
                        if (fragment2.mTargetIndex >= 0) {
                            if (fragment2.mTargetIndex < this.f216f.size()) {
                                fragment2.mTarget = this.f216f.get(fragment2.mTargetIndex);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment2 + " target no longer exists: " + fragment2.mTargetIndex);
                                fragment2.mTarget = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.mAdded != null) {
                    this.f217g = new ArrayList<>(fragmentManagerState.mAdded.length);
                    for (int i4 = 0; i4 < fragmentManagerState.mAdded.length; i4++) {
                        Fragment fragment3 = this.f216f.get(fragmentManagerState.mAdded[i4]);
                        if (fragment3 == null) {
                            m191a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.mAdded[i4]));
                        }
                        fragment3.mAdded = true;
                        if (f210a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + i4 + ": " + fragment3);
                        }
                        if (this.f217g.contains(fragment3)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.f217g.add(fragment3);
                    }
                } else {
                    this.f217g = null;
                }
                if (fragmentManagerState.mBackStack != null) {
                    this.f219i = new ArrayList<>(fragmentManagerState.mBackStack.length);
                    for (int i5 = 0; i5 < fragmentManagerState.mBackStack.length; i5++) {
                        RunnableC0058l runnableC0058lM31a = fragmentManagerState.mBackStack[i5].m31a(this);
                        if (f210a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i5 + " (index " + runnableC0058lM31a.f184o + "): " + runnableC0058lM31a);
                            runnableC0058lM31a.m171a("  ", new PrintWriter(new C0082e("FragmentManager")), false);
                        }
                        this.f219i.add(runnableC0058lM31a);
                        if (runnableC0058lM31a.f184o >= 0) {
                            m198a(runnableC0058lM31a.f184o, runnableC0058lM31a);
                        }
                    }
                    return;
                }
                this.f219i = null;
            }
        }
    }

    /* renamed from: a */
    public void m205a(FragmentActivity fragmentActivity, InterfaceC0068v interfaceC0068v, Fragment fragment) {
        if (this.f225o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f225o = fragmentActivity;
        this.f226p = interfaceC0068v;
        this.f227q = fragment;
    }

    /* renamed from: j */
    public void m233j() {
        this.f229s = false;
    }

    /* renamed from: k */
    public void m234k() {
        this.f229s = false;
        m199a(1, false);
    }

    /* renamed from: l */
    public void m235l() {
        this.f229s = false;
        m199a(2, false);
    }

    /* renamed from: m */
    public void m236m() {
        this.f229s = false;
        m199a(4, false);
    }

    /* renamed from: n */
    public void m237n() {
        this.f229s = false;
        m199a(5, false);
    }

    /* renamed from: o */
    public void m238o() {
        m199a(4, false);
    }

    /* renamed from: p */
    public void m239p() {
        this.f229s = true;
        m199a(3, false);
    }

    /* renamed from: q */
    public void m240q() {
        m199a(2, false);
    }

    /* renamed from: r */
    public void m241r() {
        m199a(1, false);
    }

    /* renamed from: s */
    public void m242s() {
        this.f230t = true;
        m228f();
        m199a(0, false);
        this.f225o = null;
        this.f226p = null;
        this.f227q = null;
    }

    /* renamed from: a */
    public void m200a(Configuration configuration) {
        if (this.f217g != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f217g.size()) {
                    Fragment fragment = this.f217g.get(i2);
                    if (fragment != null) {
                        fragment.performConfigurationChanged(configuration);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: t */
    public void m243t() {
        if (this.f217g != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f217g.size()) {
                    Fragment fragment = this.f217g.get(i2);
                    if (fragment != null) {
                        fragment.performLowMemory();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public boolean m210a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        ArrayList<Fragment> arrayList = null;
        if (this.f217g != null) {
            int i = 0;
            z = false;
            while (i < this.f217g.size()) {
                Fragment fragment = this.f217g.get(i);
                if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                    z = true;
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(fragment);
                }
                i++;
                z = z;
            }
        } else {
            z = false;
        }
        if (this.f220j != null) {
            for (int i2 = 0; i2 < this.f220j.size(); i2++) {
                Fragment fragment2 = this.f220j.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f220j = arrayList;
        return z;
    }

    /* renamed from: a */
    public boolean m209a(Menu menu) {
        if (this.f217g == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f217g.size(); i++) {
            Fragment fragment = this.f217g.get(i);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: a */
    public boolean m211a(MenuItem menuItem) {
        if (this.f217g == null) {
            return false;
        }
        for (int i = 0; i < this.f217g.size(); i++) {
            Fragment fragment = this.f217g.get(i);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public boolean m218b(MenuItem menuItem) {
        if (this.f217g == null) {
            return false;
        }
        for (int i = 0; i < this.f217g.size(); i++) {
            Fragment fragment = this.f217g.get(i);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public void m217b(Menu menu) {
        if (this.f217g != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f217g.size()) {
                    Fragment fragment = this.f217g.get(i2);
                    if (fragment != null) {
                        fragment.performOptionsMenuClosed(menu);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: c */
    public static int m193c(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    /* renamed from: b */
    public static int m192b(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }
}
