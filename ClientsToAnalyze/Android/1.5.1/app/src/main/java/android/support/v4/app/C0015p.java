package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
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

/* renamed from: android.support.v4.app.p */
/* loaded from: classes.dex */
final class C0015p extends FragmentManager {

    /* renamed from: a */
    static boolean f70a = false;

    /* renamed from: b */
    static final boolean f71b;

    /* renamed from: w */
    static final Interpolator f72w;

    /* renamed from: x */
    static final Interpolator f73x;

    /* renamed from: y */
    static final Interpolator f74y;

    /* renamed from: z */
    static final Interpolator f75z;

    /* renamed from: c */
    ArrayList f76c;

    /* renamed from: d */
    Runnable[] f77d;

    /* renamed from: e */
    boolean f78e;

    /* renamed from: f */
    ArrayList f79f;

    /* renamed from: g */
    ArrayList f80g;

    /* renamed from: h */
    ArrayList f81h;

    /* renamed from: i */
    ArrayList f82i;

    /* renamed from: j */
    ArrayList f83j;

    /* renamed from: k */
    ArrayList f84k;

    /* renamed from: l */
    ArrayList f85l;

    /* renamed from: m */
    ArrayList f86m;

    /* renamed from: o */
    FragmentActivity f88o;

    /* renamed from: p */
    boolean f89p;

    /* renamed from: q */
    boolean f90q;

    /* renamed from: r */
    boolean f91r;

    /* renamed from: s */
    String f92s;

    /* renamed from: n */
    int f87n = 0;

    /* renamed from: t */
    Bundle f93t = null;

    /* renamed from: u */
    SparseArray f94u = null;

    /* renamed from: v */
    Runnable f95v = new RunnableC0002c(this);

    static {
        f71b = Build.VERSION.SDK_INT >= 11;
        f72w = new DecelerateInterpolator(2.5f);
        f73x = new DecelerateInterpolator(1.5f);
        f74y = new AccelerateInterpolator(2.5f);
        f75z = new AccelerateInterpolator(1.5f);
    }

    C0015p() {
    }

    /* renamed from: a */
    static Animation m65a(Context context, float f, float f2) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f73x);
        alphaAnimation.setDuration(220L);
        return alphaAnimation;
    }

    /* renamed from: a */
    static Animation m66a(Context context, float f, float f2, float f3, float f4) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f72w);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f3, f4);
        alphaAnimation.setInterpolator(f73x);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }

    /* renamed from: b */
    public static int m67b(int i, boolean z) {
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

    /* renamed from: c */
    public static int m68c(int i) {
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

    /* renamed from: q */
    private void m69q() {
        if (this.f90q) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.f92s != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.f92s);
        }
    }

    /* renamed from: a */
    public int m70a(RunnableC0012m runnableC0012m) {
        int size;
        synchronized (this) {
            if (this.f85l == null || this.f85l.size() <= 0) {
                if (this.f84k == null) {
                    this.f84k = new ArrayList();
                }
                size = this.f84k.size();
                if (f70a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + runnableC0012m);
                }
                this.f84k.add(runnableC0012m);
            } else {
                size = ((Integer) this.f85l.remove(this.f85l.size() - 1)).intValue();
                if (f70a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + runnableC0012m);
                }
                this.f84k.set(size, runnableC0012m);
            }
        }
        return size;
    }

    @Override // android.support.v4.app.FragmentManager
    /* renamed from: a */
    public Fragment mo4a(int i) {
        if (this.f79f != null) {
            for (int size = this.f80g.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.f80g.get(size);
                if (fragment != null && fragment.mFragmentId == i) {
                    return fragment;
                }
            }
            for (int size2 = this.f79f.size() - 1; size2 >= 0; size2--) {
                Fragment fragment2 = (Fragment) this.f79f.get(size2);
                if (fragment2 != null && fragment2.mFragmentId == i) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public Fragment m71a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f79f.size()) {
            throw new IllegalStateException("Fragement no longer exists for key " + str + ": index " + i);
        }
        Fragment fragment = (Fragment) this.f79f.get(i);
        if (fragment == null) {
            throw new IllegalStateException("Fragement no longer exists for key " + str + ": index " + i);
        }
        return fragment;
    }

    @Override // android.support.v4.app.FragmentManager
    /* renamed from: a */
    public Fragment mo5a(String str) {
        if (this.f79f != null && str != null) {
            for (int size = this.f80g.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.f80g.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
            for (int size2 = this.f79f.size() - 1; size2 >= 0; size2--) {
                Fragment fragment2 = (Fragment) this.f79f.get(size2);
                if (fragment2 != null && str.equals(fragment2.mTag)) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    @Override // android.support.v4.app.FragmentManager
    /* renamed from: a */
    public FragmentTransaction mo6a() {
        return new RunnableC0012m(this);
    }

    /* renamed from: a */
    Animation m72a(Fragment fragment, int i, boolean z, int i2) throws Resources.NotFoundException {
        int iM67b;
        Animation animationLoadAnimation;
        Animation animationOnCreateAnimation = fragment.onCreateAnimation(i, z, fragment.mNextAnim);
        if (animationOnCreateAnimation != null) {
            return animationOnCreateAnimation;
        }
        if (fragment.mNextAnim != 0 && (animationLoadAnimation = AnimationUtils.loadAnimation(this.f88o, fragment.mNextAnim)) != null) {
            return animationLoadAnimation;
        }
        if (i != 0 && (iM67b = m67b(i, z)) >= 0) {
            switch (iM67b) {
                case 1:
                    return m66a(this.f88o, 1.125f, 1.0f, 0.0f, 1.0f);
                case 2:
                    return m66a(this.f88o, 1.0f, 0.975f, 1.0f, 0.0f);
                case 3:
                    return m66a(this.f88o, 0.975f, 1.0f, 0.0f, 1.0f);
                case 4:
                    return m66a(this.f88o, 1.0f, 1.075f, 1.0f, 0.0f);
                case 5:
                    return m65a(this.f88o, 0.0f, 1.0f);
                case 6:
                    return m65a(this.f88o, 1.0f, 0.0f);
                default:
                    return ((i2 != 0 || this.f88o.getWindow() == null) ? i2 : this.f88o.getWindow().getAttributes().windowAnimations) == 0 ? null : null;
            }
        }
        return null;
    }

    @Override // android.support.v4.app.FragmentManager
    /* renamed from: a */
    public void mo7a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        m84a((Runnable) new RunnableC0001b(this, i, i2), false);
    }

    /* renamed from: a */
    void m73a(int i, int i2, int i3, boolean z) throws Resources.NotFoundException {
        if (this.f88o == null && i != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z || this.f87n != i) {
            this.f87n = i;
            if (this.f79f != null) {
                for (int i4 = 0; i4 < this.f79f.size(); i4++) {
                    Fragment fragment = (Fragment) this.f79f.get(i4);
                    if (fragment != null) {
                        m81a(fragment, i, i2, i3);
                    }
                }
                if (!this.f89p || this.f88o == null) {
                    return;
                }
                this.f88o.supportInvalidateOptionsMenu();
                this.f89p = false;
            }
        }
    }

    /* renamed from: a */
    public void m74a(int i, RunnableC0012m runnableC0012m) {
        synchronized (this) {
            if (this.f84k == null) {
                this.f84k = new ArrayList();
            }
            int size = this.f84k.size();
            if (i < size) {
                if (f70a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + runnableC0012m);
                }
                this.f84k.set(i, runnableC0012m);
            } else {
                while (size < i) {
                    this.f84k.add(null);
                    if (this.f85l == null) {
                        this.f85l = new ArrayList();
                    }
                    if (f70a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f85l.add(Integer.valueOf(size));
                    size++;
                }
                if (f70a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + runnableC0012m);
                }
                this.f84k.add(runnableC0012m);
            }
        }
    }

    /* renamed from: a */
    void m75a(int i, boolean z) throws Resources.NotFoundException {
        m73a(i, 0, 0, z);
    }

    /* renamed from: a */
    public void m76a(Configuration configuration) {
        if (this.f79f == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f80g.size()) {
                return;
            }
            Fragment fragment = (Fragment) this.f80g.get(i2);
            if (fragment != null) {
                fragment.onConfigurationChanged(configuration);
            }
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    public void m77a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mIndex < 0) {
            throw new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager");
        }
        bundle.putInt(str, fragment.mIndex);
    }

    /* renamed from: a */
    void m78a(Parcelable parcelable, ArrayList arrayList) {
        if (parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
        if (fragmentManagerState.mActive != null) {
            if (arrayList != null) {
                for (int i = 0; i < arrayList.size(); i++) {
                    Fragment fragment = (Fragment) arrayList.get(i);
                    if (f70a) {
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
                        fragmentState.mSavedFragmentState.setClassLoader(this.f88o.getClassLoader());
                        fragment.mSavedViewState = fragmentState.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                    }
                }
            }
            this.f79f = new ArrayList(fragmentManagerState.mActive.length);
            if (this.f81h != null) {
                this.f81h.clear();
            }
            for (int i2 = 0; i2 < fragmentManagerState.mActive.length; i2++) {
                FragmentState fragmentState2 = fragmentManagerState.mActive[i2];
                if (fragmentState2 != null) {
                    Fragment fragmentM9a = fragmentState2.m9a(this.f88o);
                    if (f70a) {
                        Log.v("FragmentManager", "restoreAllState: adding #" + i2 + ": " + fragmentM9a);
                    }
                    this.f79f.add(fragmentM9a);
                    fragmentState2.mInstance = null;
                } else {
                    if (f70a) {
                        Log.v("FragmentManager", "restoreAllState: adding #" + i2 + ": (null)");
                    }
                    this.f79f.add(null);
                    if (this.f81h == null) {
                        this.f81h = new ArrayList();
                    }
                    if (f70a) {
                        Log.v("FragmentManager", "restoreAllState: adding avail #" + i2);
                    }
                    this.f81h.add(Integer.valueOf(i2));
                }
            }
            if (arrayList != null) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    Fragment fragment2 = (Fragment) arrayList.get(i3);
                    if (fragment2.mTargetIndex >= 0) {
                        if (fragment2.mTargetIndex < this.f79f.size()) {
                            fragment2.mTarget = (Fragment) this.f79f.get(fragment2.mTargetIndex);
                        } else {
                            Log.w("FragmentManager", "Re-attaching retained fragment " + fragment2 + " target no longer exists: " + fragment2.mTargetIndex);
                            fragment2.mTarget = null;
                        }
                    }
                }
            }
            if (fragmentManagerState.mAdded != null) {
                this.f80g = new ArrayList(fragmentManagerState.mAdded.length);
                for (int i4 = 0; i4 < fragmentManagerState.mAdded.length; i4++) {
                    Fragment fragment3 = (Fragment) this.f79f.get(fragmentManagerState.mAdded[i4]);
                    if (fragment3 == null) {
                        throw new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.mAdded[i4]);
                    }
                    fragment3.mAdded = true;
                    fragment3.mImmediateActivity = this.f88o;
                    if (f70a) {
                        Log.v("FragmentManager", "restoreAllState: making added #" + i4 + ": " + fragment3);
                    }
                    this.f80g.add(fragment3);
                }
            } else {
                this.f80g = null;
            }
            if (fragmentManagerState.mBackStack == null) {
                this.f82i = null;
                return;
            }
            this.f82i = new ArrayList(fragmentManagerState.mBackStack.length);
            for (int i5 = 0; i5 < fragmentManagerState.mBackStack.length; i5++) {
                RunnableC0012m runnableC0012mM0a = fragmentManagerState.mBackStack[i5].m0a(this);
                if (f70a) {
                    Log.v("FragmentManager", "restoreAllState: adding bse #" + i5 + " (index " + runnableC0012mM0a.f61m + "): " + runnableC0012mM0a);
                }
                this.f82i.add(runnableC0012mM0a);
                if (runnableC0012mM0a.f61m >= 0) {
                    m74a(runnableC0012mM0a.f61m, runnableC0012mM0a);
                }
            }
        }
    }

    /* renamed from: a */
    void m79a(Fragment fragment) {
        m81a(fragment, this.f87n, 0, 0);
    }

    /* renamed from: a */
    public void m80a(Fragment fragment, int i, int i2) throws Resources.NotFoundException {
        if (f70a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            this.f80g.remove(fragment);
            if (fragment.mHasMenu) {
                this.f89p = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
            m81a(fragment, z ? 0 : 1, i, i2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03ad  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void m81a(android.support.v4.app.Fragment r10, int r11, int r12, int r13) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 1132
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.C0015p.m81a(android.support.v4.app.Fragment, int, int, int):void");
    }

    /* renamed from: a */
    public void m82a(Fragment fragment, boolean z) {
        if (this.f80g == null) {
            this.f80g = new ArrayList();
        }
        if (f70a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        m92b(fragment);
        if (fragment.mDetached) {
            return;
        }
        this.f80g.add(fragment);
        fragment.mAdded = true;
        fragment.mRemoving = false;
        if (fragment.mHasMenu) {
            this.f89p = true;
        }
        if (z) {
            m79a(fragment);
        }
    }

    /* renamed from: a */
    public void m83a(FragmentActivity fragmentActivity) {
        if (this.f88o != null) {
            throw new IllegalStateException();
        }
        this.f88o = fragmentActivity;
    }

    /* renamed from: a */
    public void m84a(Runnable runnable, boolean z) {
        if (!z) {
            m69q();
        }
        synchronized (this) {
            if (this.f88o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.f76c == null) {
                this.f76c = new ArrayList();
            }
            this.f76c.add(runnable);
            if (this.f76c.size() == 1) {
                this.f88o.mHandler.removeCallbacks(this.f95v);
                this.f88o.mHandler.post(this.f95v);
            }
        }
    }

    /* renamed from: a */
    public void m85a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        int size6;
        String str2 = str + "    ";
        if (this.f79f != null && (size6 = this.f79f.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i = 0; i < size6; i++) {
                Fragment fragment = (Fragment) this.f79f.get(i);
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
        if (this.f80g != null && (size5 = this.f80g.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size5; i2++) {
                Fragment fragment2 = (Fragment) this.f80g.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        if (this.f83j != null && (size4 = this.f83j.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size4; i3++) {
                Fragment fragment3 = (Fragment) this.f83j.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        if (this.f82i != null && (size3 = this.f82i.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                RunnableC0012m runnableC0012m = (RunnableC0012m) this.f82i.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(runnableC0012m.toString());
                runnableC0012m.m60a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        synchronized (this) {
            if (this.f84k != null && (size2 = this.f84k.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i5 = 0; i5 < size2; i5++) {
                    Object obj = (RunnableC0012m) this.f84k.get(i5);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println(obj);
                }
            }
            if (this.f85l != null && this.f85l.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f85l.toArray()));
            }
        }
        if (this.f76c != null && (size = this.f76c.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i6 = 0; i6 < size; i6++) {
                Object obj2 = (Runnable) this.f76c.get(i6);
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
        printWriter.print("  mCurState=");
        printWriter.print(this.f87n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f90q);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f91r);
        if (this.f89p) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f89p);
        }
        if (this.f92s != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f92s);
        }
        if (this.f81h == null || this.f81h.size() <= 0) {
            return;
        }
        printWriter.print(str);
        printWriter.print("  mAvailIndices: ");
        printWriter.println(Arrays.toString(this.f81h.toArray()));
    }

    /* renamed from: a */
    public void m86a(boolean z) {
        if (this.f79f == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f80g.size()) {
                return;
            }
            Fragment fragment = (Fragment) this.f80g.get(i2);
            if (fragment != null) {
                fragment.performReallyStop(z);
            }
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    boolean m87a(Handler handler, String str, int i, int i2) throws Resources.NotFoundException {
        if (this.f82i == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = this.f82i.size() - 1;
            if (size < 0) {
                return false;
            }
            ((RunnableC0012m) this.f82i.remove(size)).m61b(true);
            m105e();
        } else {
            int i3 = -1;
            if (str != null || i >= 0) {
                int size2 = this.f82i.size() - 1;
                while (size2 >= 0) {
                    RunnableC0012m runnableC0012m = (RunnableC0012m) this.f82i.get(size2);
                    if ((str != null && str.equals(runnableC0012m.m62c())) || (i >= 0 && i == runnableC0012m.f61m)) {
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
                        RunnableC0012m runnableC0012m2 = (RunnableC0012m) this.f82i.get(size2);
                        if ((str == null || !str.equals(runnableC0012m2.m62c())) && (i < 0 || i != runnableC0012m2.f61m)) {
                            break;
                        }
                        size2--;
                    }
                }
                i3 = size2;
            }
            if (i3 == this.f82i.size() - 1) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int size3 = this.f82i.size() - 1; size3 > i3; size3--) {
                arrayList.add(this.f82i.remove(size3));
            }
            int size4 = arrayList.size() - 1;
            int i4 = 0;
            while (i4 <= size4) {
                if (f70a) {
                    Log.v("FragmentManager", "Popping back stack state: " + arrayList.get(i4));
                }
                ((RunnableC0012m) arrayList.get(i4)).m61b(i4 == size4);
                i4++;
            }
            m105e();
        }
        return true;
    }

    /* renamed from: a */
    public boolean m88a(Menu menu) {
        int i = 0;
        if (this.f79f == null) {
            return false;
        }
        boolean z = false;
        while (i < this.f80g.size()) {
            Fragment fragment = (Fragment) this.f80g.get(i);
            if (fragment != null && !fragment.mHidden && fragment.mHasMenu) {
                z = true;
                fragment.onPrepareOptionsMenu(menu);
            }
            i++;
            z = z;
        }
        return z;
    }

    /* renamed from: a */
    public boolean m89a(Menu menu, MenuInflater menuInflater) {
        ArrayList arrayList;
        boolean z;
        if (this.f79f != null) {
            int i = 0;
            ArrayList arrayList2 = null;
            boolean z2 = false;
            while (i < this.f80g.size()) {
                Fragment fragment = (Fragment) this.f80g.get(i);
                if (fragment != null && !fragment.mHidden && fragment.mHasMenu) {
                    z2 = true;
                    fragment.onCreateOptionsMenu(menu, menuInflater);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(fragment);
                }
                i++;
                z2 = z2;
                arrayList2 = arrayList2;
            }
            arrayList = arrayList2;
            z = z2;
        } else {
            arrayList = null;
            z = false;
        }
        if (this.f83j != null) {
            for (int i2 = 0; i2 < this.f83j.size(); i2++) {
                Fragment fragment2 = (Fragment) this.f83j.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f83j = arrayList;
        return z;
    }

    /* renamed from: a */
    public boolean m90a(MenuItem menuItem) {
        if (this.f79f != null) {
            for (int i = 0; i < this.f80g.size(); i++) {
                Fragment fragment = (Fragment) this.f80g.get(i);
                if (fragment != null && !fragment.mHidden && fragment.mHasMenu && fragment.onOptionsItemSelected(menuItem)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public void m91b(int i) {
        synchronized (this) {
            this.f84k.set(i, null);
            if (this.f85l == null) {
                this.f85l = new ArrayList();
            }
            if (f70a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f85l.add(Integer.valueOf(i));
        }
    }

    /* renamed from: b */
    void m92b(Fragment fragment) {
        if (fragment.mIndex >= 0) {
            return;
        }
        if (this.f81h != null && this.f81h.size() > 0) {
            fragment.setIndex(((Integer) this.f81h.remove(this.f81h.size() - 1)).intValue());
            this.f79f.set(fragment.mIndex, fragment);
        } else {
            if (this.f79f == null) {
                this.f79f = new ArrayList();
            }
            fragment.setIndex(this.f79f.size());
            this.f79f.add(fragment);
        }
    }

    /* renamed from: b */
    public void m93b(Fragment fragment, int i, int i2) throws Resources.NotFoundException {
        if (f70a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        if (fragment.mView != null) {
            Animation animationM72a = m72a(fragment, i, true, i2);
            if (animationM72a != null) {
                fragment.mView.startAnimation(animationM72a);
            }
            fragment.mView.setVisibility(8);
        }
        if (fragment.mAdded && fragment.mHasMenu) {
            this.f89p = true;
        }
        fragment.onHiddenChanged(true);
    }

    /* renamed from: b */
    void m94b(RunnableC0012m runnableC0012m) {
        if (this.f82i == null) {
            this.f82i = new ArrayList();
        }
        this.f82i.add(runnableC0012m);
        m105e();
    }

    /* renamed from: b */
    public void m95b(Menu menu) {
        if (this.f79f == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f80g.size()) {
                return;
            }
            Fragment fragment = (Fragment) this.f80g.get(i2);
            if (fragment != null && !fragment.mHidden && fragment.mHasMenu) {
                fragment.onOptionsMenuClosed(menu);
            }
            i = i2 + 1;
        }
    }

    /* renamed from: b */
    public boolean m96b() {
        return m103d();
    }

    /* renamed from: b */
    public boolean m97b(MenuItem menuItem) {
        if (this.f79f != null) {
            for (int i = 0; i < this.f80g.size(); i++) {
                Fragment fragment = (Fragment) this.f80g.get(i);
                if (fragment != null && !fragment.mHidden && fragment.onContextItemSelected(menuItem)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    void m98c(Fragment fragment) {
        if (fragment.mIndex < 0) {
            return;
        }
        if (f70a) {
            Log.v("FragmentManager", "Freeing fragment index " + fragment.mIndex);
        }
        this.f79f.set(fragment.mIndex, null);
        if (this.f81h == null) {
            this.f81h = new ArrayList();
        }
        this.f81h.add(Integer.valueOf(fragment.mIndex));
        this.f88o.invalidateSupportFragmentIndex(fragment.mIndex);
        fragment.initState();
    }

    /* renamed from: c */
    public void m99c(Fragment fragment, int i, int i2) throws Resources.NotFoundException {
        if (f70a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            if (fragment.mView != null) {
                Animation animationM72a = m72a(fragment, i, true, i2);
                if (animationM72a != null) {
                    fragment.mView.startAnimation(animationM72a);
                }
                fragment.mView.setVisibility(0);
            }
            if (fragment.mAdded && fragment.mHasMenu) {
                this.f89p = true;
            }
            fragment.onHiddenChanged(false);
        }
    }

    /* renamed from: c */
    public boolean m100c() {
        m69q();
        m96b();
        return m87a(this.f88o.mHandler, (String) null, -1, 0);
    }

    /* renamed from: d */
    void m101d(Fragment fragment) {
        if (fragment.mInnerView == null) {
            return;
        }
        if (this.f94u == null) {
            this.f94u = new SparseArray();
        } else {
            this.f94u.clear();
        }
        fragment.mInnerView.saveHierarchyState(this.f94u);
        if (this.f94u.size() > 0) {
            fragment.mSavedViewState = this.f94u;
            this.f94u = null;
        }
    }

    /* renamed from: d */
    public void m102d(Fragment fragment, int i, int i2) throws Resources.NotFoundException {
        if (f70a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            this.f80g.remove(fragment);
            if (fragment.mHasMenu) {
                this.f89p = true;
            }
            fragment.mAdded = false;
            m81a(fragment, 1, i, i2);
        }
    }

    /* renamed from: d */
    public boolean m103d() {
        int size;
        if (this.f78e) {
            throw new IllegalStateException("Recursive entry to executePendingTransactions");
        }
        if (Looper.myLooper() != this.f88o.mHandler.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of process");
        }
        boolean z = false;
        while (true) {
            synchronized (this) {
                if (this.f76c == null || this.f76c.size() == 0) {
                    break;
                }
                size = this.f76c.size();
                if (this.f77d == null || this.f77d.length < size) {
                    this.f77d = new Runnable[size];
                }
                this.f76c.toArray(this.f77d);
                this.f76c.clear();
                this.f88o.mHandler.removeCallbacks(this.f95v);
            }
            this.f78e = true;
            for (int i = 0; i < size; i++) {
                this.f77d[i].run();
            }
            this.f78e = false;
            z = true;
        }
        return z;
    }

    /* renamed from: e */
    Bundle m104e(Fragment fragment) {
        Bundle bundle;
        if (this.f93t == null) {
            this.f93t = new Bundle();
        }
        fragment.onSaveInstanceState(this.f93t);
        if (this.f93t.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f93t;
            this.f93t = null;
        }
        if (fragment.mView != null) {
            m101d(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
        }
        return bundle;
    }

    /* renamed from: e */
    void m105e() {
        if (this.f86m == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f86m.size()) {
                return;
            }
            ((FragmentManager.OnBackStackChangedListener) this.f86m.get(i2)).m8a();
            i = i2 + 1;
        }
    }

    /* renamed from: e */
    public void m106e(Fragment fragment, int i, int i2) throws Resources.NotFoundException {
        if (f70a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.f80g.add(fragment);
            fragment.mAdded = true;
            if (fragment.mHasMenu) {
                this.f89p = true;
            }
            m81a(fragment, this.f87n, i, i2);
        }
    }

    /* renamed from: f */
    ArrayList m107f() {
        ArrayList arrayList = null;
        if (this.f79f == null) {
            return null;
        }
        int i = 0;
        while (true) {
            ArrayList arrayList2 = arrayList;
            if (i >= this.f79f.size()) {
                return arrayList2;
            }
            Fragment fragment = (Fragment) this.f79f.get(i);
            if (fragment != null && fragment.mRetainInstance) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(fragment);
                fragment.mRetaining = true;
                fragment.mTargetIndex = fragment.mTarget != null ? fragment.mTarget.mIndex : -1;
            }
            arrayList = arrayList2;
            i++;
        }
    }

    /* renamed from: g */
    Parcelable m108g() {
        int[] iArr;
        BackStackState[] backStackStateArr;
        int size;
        int size2;
        boolean z;
        m103d();
        if (f71b) {
            this.f90q = true;
        }
        if (this.f79f == null || this.f79f.size() <= 0) {
            return null;
        }
        int size3 = this.f79f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size3];
        int i = 0;
        boolean z2 = false;
        while (i < size3) {
            Fragment fragment = (Fragment) this.f79f.get(i);
            if (fragment != null) {
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.mState <= 0 || fragmentState.mSavedFragmentState != null) {
                    fragmentState.mSavedFragmentState = fragment.mSavedFragmentState;
                } else {
                    fragmentState.mSavedFragmentState = m104e(fragment);
                    if (fragment.mTarget != null) {
                        if (fragment.mTarget.mIndex < 0) {
                            String str = "Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.mTarget;
                            Log.e("FragmentManager", str);
                            m85a("  ", (FileDescriptor) null, new PrintWriter(new LogWriter("FragmentManager")), new String[0]);
                            throw new IllegalStateException(str);
                        }
                        if (fragmentState.mSavedFragmentState == null) {
                            fragmentState.mSavedFragmentState = new Bundle();
                        }
                        m77a(fragmentState.mSavedFragmentState, "android:target_state", fragment.mTarget);
                        if (fragment.mTargetRequestCode != 0) {
                            fragmentState.mSavedFragmentState.putInt("android:target_req_state", fragment.mTargetRequestCode);
                        }
                    }
                }
                if (f70a) {
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
            if (f70a) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        if (this.f80g == null || (size2 = this.f80g.size()) <= 0) {
            iArr = null;
        } else {
            int[] iArr2 = new int[size2];
            for (int i2 = 0; i2 < size2; i2++) {
                iArr2[i2] = ((Fragment) this.f80g.get(i2)).mIndex;
                if (f70a) {
                    Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.f80g.get(i2));
                }
            }
            iArr = iArr2;
        }
        if (this.f82i == null || (size = this.f82i.size()) <= 0) {
            backStackStateArr = null;
        } else {
            BackStackState[] backStackStateArr2 = new BackStackState[size];
            for (int i3 = 0; i3 < size; i3++) {
                backStackStateArr2[i3] = new BackStackState(this, (RunnableC0012m) this.f82i.get(i3));
                if (f70a) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i3 + ": " + this.f82i.get(i3));
                }
            }
            backStackStateArr = backStackStateArr2;
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.mActive = fragmentStateArr;
        fragmentManagerState.mAdded = iArr;
        fragmentManagerState.mBackStack = backStackStateArr;
        return fragmentManagerState;
    }

    /* renamed from: h */
    public void m109h() {
        this.f90q = false;
    }

    /* renamed from: i */
    public void m110i() {
        this.f90q = false;
        m75a(1, false);
    }

    /* renamed from: j */
    public void m111j() {
        this.f90q = false;
        m75a(2, false);
    }

    /* renamed from: k */
    public void m112k() {
        this.f90q = false;
        m75a(4, false);
    }

    /* renamed from: l */
    public void m113l() {
        this.f90q = false;
        m75a(5, false);
    }

    /* renamed from: m */
    public void m114m() {
        m75a(4, false);
    }

    /* renamed from: n */
    public void m115n() {
        this.f90q = true;
        m75a(3, false);
    }

    /* renamed from: o */
    public void m116o() {
        this.f91r = true;
        m75a(0, false);
        this.f88o = null;
    }

    /* renamed from: p */
    public void m117p() {
        if (this.f79f == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f80g.size()) {
                return;
            }
            Fragment fragment = (Fragment) this.f80g.get(i2);
            if (fragment != null) {
                fragment.onLowMemory();
            }
            i = i2 + 1;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.m170a(this.f88o, sb);
        sb.append("}}");
        return sb.toString();
    }
}
