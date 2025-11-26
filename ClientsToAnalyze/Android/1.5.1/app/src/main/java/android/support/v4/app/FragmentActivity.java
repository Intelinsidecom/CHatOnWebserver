package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class FragmentActivity extends Activity {
    private static final String FRAGMENTS_TAG = "android:support:fragments";
    private static final int HONEYCOMB = 11;
    static final int MSG_REALLY_STOPPED = 1;
    static final int MSG_RESUME_PENDING = 2;
    private static final String TAG = "FragmentActivity";
    HCSparseArray mAllLoaderManagers;
    boolean mCheckedForLoaderManager;
    boolean mCreated;
    C0017r mLoaderManager;
    boolean mLoadersStarted;
    boolean mOptionsMenuInvalidated;
    boolean mReallyStopped;
    boolean mResumed;
    boolean mStopped;
    final Handler mHandler = new HandlerC0006g(this);
    final C0015p mFragments = new C0015p();

    void doReallyStop(boolean z) {
        if (this.mReallyStopped) {
            return;
        }
        this.mReallyStopped = true;
        this.mHandler.removeMessages(1);
        onReallyStop(z);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (Build.VERSION.SDK_INT >= 11) {
        }
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print("mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.mReallyStopped);
        printWriter.print(str2);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.mLoadersStarted);
        if (this.mLoaderManager != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.mLoaderManager)));
            printWriter.println(":");
            this.mLoaderManager.m125a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        this.mFragments.m85a(str, fileDescriptor, printWriter, strArr);
    }

    C0017r getLoaderManager(int i, boolean z, boolean z2) {
        if (this.mAllLoaderManagers == null) {
            this.mAllLoaderManagers = new HCSparseArray();
        }
        C0017r c0017r = (C0017r) this.mAllLoaderManagers.m22a(i);
        if (c0017r != null) {
            c0017r.m123a(this);
            return c0017r;
        }
        if (!z2) {
            return c0017r;
        }
        C0017r c0017r2 = new C0017r(this, z);
        this.mAllLoaderManagers.m26b(i, c0017r2);
        return c0017r2;
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments;
    }

    public LoaderManager getSupportLoaderManager() {
        if (this.mLoaderManager != null) {
            return this.mLoaderManager;
        }
        this.mCheckedForLoaderManager = true;
        this.mLoaderManager = getLoaderManager(-1, this.mLoadersStarted, true);
        return this.mLoaderManager;
    }

    void invalidateSupportFragmentIndex(int i) {
        if (this.mAllLoaderManagers != null) {
            C0017r c0017r = (C0017r) this.mAllLoaderManagers.m22a(i);
            if (c0017r != null) {
                c0017r.m131g();
            }
            this.mAllLoaderManagers.m27c(i);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = i >> 16;
        if (i3 == 0) {
            super.onActivityResult(i, i2, intent);
            return;
        }
        int i4 = i3 - 1;
        if (this.mFragments.f79f == null || i4 < 0 || i4 >= this.mFragments.f79f.size()) {
            Log.w(TAG, "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
            return;
        }
        Fragment fragment = (Fragment) this.mFragments.f79f.get(i4);
        if (fragment == null) {
            Log.w(TAG, "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
        }
        fragment.onActivityResult(65535 & i, i2, intent);
    }

    public void onAttachFragment(Fragment fragment) {
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.mFragments.m100c()) {
            return;
        }
        finish();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.m76a(configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.mFragments.m83a(this);
        if (getLayoutInflater().getFactory() == null) {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(bundle);
        C0013n c0013n = (C0013n) getLastNonConfigurationInstance();
        if (c0013n != null) {
            this.mAllLoaderManagers = c0013n.f69d;
        }
        if (bundle != null) {
            this.mFragments.m78a(bundle.getParcelable(FRAGMENTS_TAG), c0013n != null ? c0013n.f68c : null);
        }
        this.mFragments.m110i();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean zOnCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.mFragments.m89a(menu, getMenuInflater());
        if (Build.VERSION.SDK_INT >= 11) {
            return zOnCreatePanelMenu;
        }
        return true;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        Fragment fragment;
        byte b = 0;
        if (!"fragment".equals(str)) {
            return super.onCreateView(str, context, attributeSet);
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0010k.f48a);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(0);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        String string = typedArrayObtainStyledAttributes.getString(2);
        typedArrayObtainStyledAttributes.recycle();
        int id = 0 != 0 ? (b == true ? 1 : 0).getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        Fragment fragmentMo4a = resourceId != -1 ? this.mFragments.mo4a(resourceId) : null;
        if (fragmentMo4a == null && string != null) {
            fragmentMo4a = this.mFragments.mo5a(string);
        }
        if (fragmentMo4a == null && id != -1) {
            fragmentMo4a = this.mFragments.mo4a(id);
        }
        if (C0015p.f70a) {
            Log.v(TAG, "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + attributeValue + " existing=" + fragmentMo4a);
        }
        if (fragmentMo4a == null) {
            Fragment fragmentInstantiate = Fragment.instantiate(this, attributeValue);
            fragmentInstantiate.mFromLayout = true;
            fragmentInstantiate.mFragmentId = resourceId != 0 ? resourceId : id;
            fragmentInstantiate.mContainerId = id;
            fragmentInstantiate.mTag = string;
            fragmentInstantiate.mInLayout = true;
            fragmentInstantiate.mImmediateActivity = this;
            fragmentInstantiate.mFragmentManager = this.mFragments;
            fragmentInstantiate.onInflate(this, attributeSet, fragmentInstantiate.mSavedFragmentState);
            this.mFragments.m82a(fragmentInstantiate, true);
            fragment = fragmentInstantiate;
        } else {
            if (fragmentMo4a.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            fragmentMo4a.mInLayout = true;
            fragmentMo4a.mImmediateActivity = this;
            if (!fragmentMo4a.mRetaining) {
                fragmentMo4a.onInflate(this, attributeSet, fragmentMo4a.mSavedFragmentState);
            }
            this.mFragments.m79a(fragmentMo4a);
            fragment = fragmentMo4a;
        }
        if (fragment.mView == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.mView.setId(resourceId);
        }
        if (fragment.mView.getTag() == null) {
            fragment.mView.setTag(string);
        }
        return fragment.mView;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        doReallyStop(false);
        this.mFragments.m116o();
        if (this.mLoaderManager != null) {
            this.mLoaderManager.m131g();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.m117p();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.mFragments.m90a(menuItem);
            case 6:
                return this.mFragments.m97b(menuItem);
            default:
                return false;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.mFragments.m95b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mResumed = false;
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
            this.mFragments.m113l();
        }
        this.mFragments.m114m();
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        this.mHandler.removeMessages(2);
        this.mFragments.m113l();
        this.mFragments.m103d();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.mOptionsMenuInvalidated) {
            this.mOptionsMenuInvalidated = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return (super.onPreparePanel(i, view, menu) || this.mFragments.m88a(menu)) && menu.hasVisibleItems();
    }

    void onReallyStop(boolean z) {
        if (this.mLoadersStarted) {
            this.mLoadersStarted = false;
            if (this.mLoaderManager != null) {
                if (z) {
                    this.mLoaderManager.m127c();
                } else {
                    this.mLoaderManager.m126b();
                }
            }
        }
        this.mFragments.m86a(z);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mHandler.sendEmptyMessage(2);
        this.mResumed = true;
        this.mFragments.m103d();
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        boolean z;
        if (this.mStopped) {
            doReallyStop(true);
        }
        ArrayList arrayListM107f = this.mFragments.m107f();
        boolean z2 = false;
        if (this.mAllLoaderManagers != null) {
            int iM21a = this.mAllLoaderManagers.m21a() - 1;
            boolean z3 = false;
            while (iM21a >= 0) {
                C0017r c0017r = (C0017r) this.mAllLoaderManagers.m30f(iM21a);
                if (c0017r.f101f) {
                    z = true;
                } else {
                    c0017r.m131g();
                    this.mAllLoaderManagers.m28d(iM21a);
                    z = z3;
                }
                iM21a--;
                z3 = z;
            }
            z2 = z3;
        }
        if (arrayListM107f == null && !z2) {
            return null;
        }
        C0013n c0013n = new C0013n();
        c0013n.f66a = null;
        c0013n.f67b = null;
        c0013n.f68c = arrayListM107f;
        c0013n.f69d = this.mAllLoaderManagers;
        return c0013n;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable parcelableM108g = this.mFragments.m108g();
        if (parcelableM108g != null) {
            bundle.putParcelable(FRAGMENTS_TAG, parcelableM108g);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.mStopped = false;
        this.mHandler.removeMessages(1);
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.m111j();
        }
        this.mFragments.m109h();
        this.mFragments.m103d();
        if (!this.mLoadersStarted) {
            this.mLoadersStarted = true;
            if (this.mLoaderManager != null) {
                this.mLoaderManager.m122a();
            } else if (!this.mCheckedForLoaderManager) {
                this.mLoaderManager = getLoaderManager(-1, this.mLoadersStarted, false);
            }
            this.mCheckedForLoaderManager = true;
        }
        this.mFragments.m112k();
        if (this.mAllLoaderManagers != null) {
            for (int iM21a = this.mAllLoaderManagers.m21a() - 1; iM21a >= 0; iM21a--) {
                C0017r c0017r = (C0017r) this.mAllLoaderManagers.m30f(iM21a);
                c0017r.m128d();
                c0017r.m130f();
            }
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.mStopped = true;
        this.mHandler.sendEmptyMessage(1);
        this.mFragments.m115n();
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        if (i != -1 && ((-65536) & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
        super.startActivityForResult(intent, i);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        if (i == -1) {
            super.startActivityForResult(intent, -1);
        } else {
            if (((-65536) & i) != 0) {
                throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
            }
            super.startActivityForResult(intent, ((fragment.mIndex + 1) << 16) + (65535 & i));
        }
    }

    void supportInvalidateOptionsMenu() {
        if (Build.VERSION.SDK_INT >= 11) {
            C0007h.m53a(this);
        } else {
            this.mOptionsMenuInvalidated = true;
        }
    }
}
