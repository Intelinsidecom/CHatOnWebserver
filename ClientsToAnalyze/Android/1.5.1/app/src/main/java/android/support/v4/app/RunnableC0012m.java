package android.support.v4.app;

import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.m */
/* loaded from: classes.dex */
final class RunnableC0012m extends FragmentTransaction implements FragmentManager.BackStackEntry, Runnable {

    /* renamed from: a */
    final C0015p f49a;

    /* renamed from: b */
    C0018s f50b;

    /* renamed from: c */
    C0018s f51c;

    /* renamed from: d */
    int f52d;

    /* renamed from: e */
    int f53e;

    /* renamed from: f */
    int f54f;

    /* renamed from: g */
    int f55g;

    /* renamed from: h */
    int f56h;

    /* renamed from: i */
    boolean f57i;

    /* renamed from: j */
    boolean f58j = true;

    /* renamed from: k */
    String f59k;

    /* renamed from: l */
    boolean f60l;

    /* renamed from: m */
    int f61m;

    /* renamed from: n */
    int f62n;

    /* renamed from: o */
    CharSequence f63o;

    /* renamed from: p */
    int f64p;

    /* renamed from: q */
    CharSequence f65q;

    public RunnableC0012m(C0015p c0015p) {
        this.f49a = c0015p;
    }

    /* renamed from: a */
    private void m56a(int i, Fragment fragment, String str, int i2) {
        if (fragment.mImmediateActivity != null) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        fragment.mImmediateActivity = this.f49a.f88o;
        fragment.mFragmentManager = this.f49a;
        if (str != null) {
            if (fragment.mTag != null && !str.equals(fragment.mTag)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i != 0) {
            if (fragment.mFragmentId != 0 && fragment.mFragmentId != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
            }
            fragment.mFragmentId = i;
            fragment.mContainerId = i;
        }
        C0018s c0018s = new C0018s();
        c0018s.f105c = i2;
        c0018s.f106d = fragment;
        m59a(c0018s);
    }

    @Override // android.support.v4.app.FragmentTransaction
    /* renamed from: a */
    public int mo10a() {
        return m57a(false);
    }

    /* renamed from: a */
    int m57a(boolean z) {
        if (this.f60l) {
            throw new IllegalStateException("commit already called");
        }
        if (C0015p.f70a) {
            Log.v("BackStackEntry", "Commit: " + this);
        }
        this.f60l = true;
        if (this.f57i) {
            this.f61m = this.f49a.m70a(this);
        } else {
            this.f61m = -1;
        }
        this.f49a.m84a(this, z);
        return this.f61m;
    }

    @Override // android.support.v4.app.FragmentTransaction
    /* renamed from: a */
    public FragmentTransaction mo11a(int i, Fragment fragment) {
        m56a(i, fragment, (String) null, 1);
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    /* renamed from: a */
    public FragmentTransaction mo12a(int i, Fragment fragment, String str) {
        m56a(i, fragment, str, 1);
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    /* renamed from: a */
    public FragmentTransaction mo13a(Fragment fragment) {
        if (fragment.mImmediateActivity == null) {
            throw new IllegalStateException("Fragment not added: " + fragment);
        }
        fragment.mImmediateActivity = null;
        C0018s c0018s = new C0018s();
        c0018s.f105c = 3;
        c0018s.f106d = fragment;
        m59a(c0018s);
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    /* renamed from: a */
    public FragmentTransaction mo14a(Fragment fragment, String str) {
        m56a(0, fragment, str, 1);
        return this;
    }

    /* renamed from: a */
    void m58a(int i) {
        if (this.f57i) {
            if (C0015p.f70a) {
                Log.v("BackStackEntry", "Bump nesting in " + this + " by " + i);
            }
            for (C0018s c0018s = this.f50b; c0018s != null; c0018s = c0018s.f103a) {
                c0018s.f106d.mBackStackNesting += i;
                if (C0015p.f70a) {
                    Log.v("BackStackEntry", "Bump nesting of " + c0018s.f106d + " to " + c0018s.f106d.mBackStackNesting);
                }
                if (c0018s.f109g != null) {
                    for (int size = c0018s.f109g.size() - 1; size >= 0; size--) {
                        Fragment fragment = (Fragment) c0018s.f109g.get(size);
                        fragment.mBackStackNesting += i;
                        if (C0015p.f70a) {
                            Log.v("BackStackEntry", "Bump nesting of " + fragment + " to " + fragment.mBackStackNesting);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    void m59a(C0018s c0018s) {
        if (this.f50b == null) {
            this.f51c = c0018s;
            this.f50b = c0018s;
        } else {
            c0018s.f104b = this.f51c;
            this.f51c.f103a = c0018s;
            this.f51c = c0018s;
        }
        c0018s.f107e = this.f53e;
        c0018s.f108f = this.f54f;
        this.f52d++;
    }

    /* renamed from: a */
    public void m60a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mName=");
        printWriter.print(this.f59k);
        printWriter.print(" mIndex=");
        printWriter.print(this.f61m);
        printWriter.print(" mCommitted=");
        printWriter.println(this.f60l);
        if (this.f55g != 0) {
            printWriter.print(str);
            printWriter.print("mTransition=#");
            printWriter.print(Integer.toHexString(this.f55g));
            printWriter.print(" mTransitionStyle=#");
            printWriter.println(Integer.toHexString(this.f56h));
        }
        if (this.f53e != 0 || this.f54f != 0) {
            printWriter.print(str);
            printWriter.print("mEnterAnim=#");
            printWriter.print(Integer.toHexString(this.f53e));
            printWriter.print(" mExitAnim=#");
            printWriter.println(Integer.toHexString(this.f54f));
        }
        if (this.f62n != 0 || this.f63o != null) {
            printWriter.print(str);
            printWriter.print("mBreadCrumbTitleRes=#");
            printWriter.print(Integer.toHexString(this.f62n));
            printWriter.print(" mBreadCrumbTitleText=");
            printWriter.println(this.f63o);
        }
        if (this.f64p != 0 || this.f65q != null) {
            printWriter.print(str);
            printWriter.print("mBreadCrumbShortTitleRes=#");
            printWriter.print(Integer.toHexString(this.f64p));
            printWriter.print(" mBreadCrumbShortTitleText=");
            printWriter.println(this.f65q);
        }
        if (this.f50b != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            for (C0018s c0018s = this.f50b; c0018s != null; c0018s = c0018s.f103a) {
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(0);
                printWriter.println(":");
                printWriter.print(str2);
                printWriter.print("cmd=");
                printWriter.print(c0018s.f105c);
                printWriter.print(" fragment=");
                printWriter.println(c0018s.f106d);
                if (c0018s.f107e != 0 || c0018s.f108f != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=");
                    printWriter.print(c0018s.f107e);
                    printWriter.print(" exitAnim=");
                    printWriter.println(c0018s.f108f);
                }
                if (c0018s.f109g != null && c0018s.f109g.size() > 0) {
                    for (int i = 0; i < c0018s.f109g.size(); i++) {
                        printWriter.print(str2);
                        if (c0018s.f109g.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            printWriter.println("Removed:");
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(0);
                            printWriter.print(": ");
                        }
                        printWriter.println(c0018s.f109g.get(i));
                    }
                }
            }
        }
    }

    @Override // android.support.v4.app.FragmentTransaction
    /* renamed from: b */
    public int mo15b() {
        return m57a(true);
    }

    @Override // android.support.v4.app.FragmentTransaction
    /* renamed from: b */
    public FragmentTransaction mo16b(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        m56a(i, fragment, str, 2);
        return this;
    }

    /* renamed from: b */
    public void m61b(boolean z) throws Resources.NotFoundException {
        if (C0015p.f70a) {
            Log.v("BackStackEntry", "popFromBackStack: " + this);
        }
        m58a(-1);
        for (C0018s c0018s = this.f51c; c0018s != null; c0018s = c0018s.f104b) {
            switch (c0018s.f105c) {
                case 1:
                    Fragment fragment = c0018s.f106d;
                    fragment.mImmediateActivity = null;
                    this.f49a.m80a(fragment, C0015p.m68c(this.f55g), this.f56h);
                    break;
                case 2:
                    Fragment fragment2 = c0018s.f106d;
                    fragment2.mImmediateActivity = null;
                    this.f49a.m80a(fragment2, C0015p.m68c(this.f55g), this.f56h);
                    if (c0018s.f109g != null) {
                        for (int i = 0; i < c0018s.f109g.size(); i++) {
                            Fragment fragment3 = (Fragment) c0018s.f109g.get(i);
                            fragment2.mImmediateActivity = this.f49a.f88o;
                            this.f49a.m82a(fragment3, false);
                        }
                        break;
                    } else {
                        break;
                    }
                case 3:
                    Fragment fragment4 = c0018s.f106d;
                    fragment4.mImmediateActivity = this.f49a.f88o;
                    this.f49a.m82a(fragment4, false);
                    break;
                case 4:
                    this.f49a.m99c(c0018s.f106d, C0015p.m68c(this.f55g), this.f56h);
                    break;
                case 5:
                    this.f49a.m93b(c0018s.f106d, C0015p.m68c(this.f55g), this.f56h);
                    break;
                case 6:
                    this.f49a.m106e(c0018s.f106d, C0015p.m68c(this.f55g), this.f56h);
                    break;
                case 7:
                    this.f49a.m102d(c0018s.f106d, C0015p.m68c(this.f55g), this.f56h);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0018s.f105c);
            }
        }
        if (z) {
            this.f49a.m73a(this.f49a.f87n, C0015p.m68c(this.f55g), this.f56h, true);
        }
        if (this.f61m >= 0) {
            this.f49a.m91b(this.f61m);
            this.f61m = -1;
        }
    }

    /* renamed from: c */
    public String m62c() {
        return this.f59k;
    }

    @Override // java.lang.Runnable
    public void run() throws Resources.NotFoundException {
        if (C0015p.f70a) {
            Log.v("BackStackEntry", "Run: " + this);
        }
        if (this.f57i && this.f61m < 0) {
            throw new IllegalStateException("addToBackStack() called after commit()");
        }
        m58a(1);
        for (C0018s c0018s = this.f50b; c0018s != null; c0018s = c0018s.f103a) {
            switch (c0018s.f105c) {
                case 1:
                    Fragment fragment = c0018s.f106d;
                    fragment.mNextAnim = c0018s.f107e;
                    this.f49a.m82a(fragment, false);
                    break;
                case 2:
                    Fragment fragment2 = c0018s.f106d;
                    if (this.f49a.f80g != null) {
                        for (int i = 0; i < this.f49a.f80g.size(); i++) {
                            Fragment fragment3 = (Fragment) this.f49a.f80g.get(i);
                            if (C0015p.f70a) {
                                Log.v("BackStackEntry", "OP_REPLACE: adding=" + fragment2 + " old=" + fragment3);
                            }
                            if (fragment3.mContainerId == fragment2.mContainerId) {
                                if (c0018s.f109g == null) {
                                    c0018s.f109g = new ArrayList();
                                }
                                c0018s.f109g.add(fragment3);
                                fragment3.mNextAnim = c0018s.f108f;
                                if (this.f57i) {
                                    fragment3.mBackStackNesting++;
                                    if (C0015p.f70a) {
                                        Log.v("BackStackEntry", "Bump nesting of " + fragment3 + " to " + fragment3.mBackStackNesting);
                                    }
                                }
                                this.f49a.m80a(fragment3, this.f55g, this.f56h);
                            }
                        }
                    }
                    fragment2.mNextAnim = c0018s.f107e;
                    this.f49a.m82a(fragment2, false);
                    break;
                case 3:
                    Fragment fragment4 = c0018s.f106d;
                    fragment4.mNextAnim = c0018s.f108f;
                    this.f49a.m80a(fragment4, this.f55g, this.f56h);
                    break;
                case 4:
                    Fragment fragment5 = c0018s.f106d;
                    fragment5.mNextAnim = c0018s.f108f;
                    this.f49a.m93b(fragment5, this.f55g, this.f56h);
                    break;
                case 5:
                    Fragment fragment6 = c0018s.f106d;
                    fragment6.mNextAnim = c0018s.f107e;
                    this.f49a.m99c(fragment6, this.f55g, this.f56h);
                    break;
                case 6:
                    Fragment fragment7 = c0018s.f106d;
                    fragment7.mNextAnim = c0018s.f108f;
                    this.f49a.m102d(fragment7, this.f55g, this.f56h);
                    break;
                case 7:
                    Fragment fragment8 = c0018s.f106d;
                    fragment8.mNextAnim = c0018s.f107e;
                    this.f49a.m106e(fragment8, this.f55g, this.f56h);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0018s.f105c);
            }
        }
        this.f49a.m73a(this.f49a.f87n, this.f55g, this.f56h, true);
        if (this.f57i) {
            this.f49a.m94b(this);
        }
    }
}
