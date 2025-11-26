package android.support.v4.app;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

/* loaded from: classes.dex */
public class DialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: a */
    int f0a = 0;

    /* renamed from: b */
    int f1b = 0;

    /* renamed from: c */
    boolean f2c = true;

    /* renamed from: d */
    boolean f3d = true;

    /* renamed from: e */
    int f4e = -1;

    /* renamed from: f */
    Dialog f5f;

    /* renamed from: g */
    boolean f6g;

    /* renamed from: h */
    boolean f7h;

    /* renamed from: a */
    public int m1a() {
        return this.f1b;
    }

    /* renamed from: a */
    public Dialog m2a(Bundle bundle) {
        return new Dialog(getActivity(), m1a());
    }

    /* renamed from: a */
    void m3a(boolean z) {
        if (this.f5f != null) {
            this.f5f.dismiss();
            this.f5f = null;
        }
        this.f7h = true;
        if (this.f4e >= 0) {
            getFragmentManager().mo7a(this.f4e, 1);
            this.f4e = -1;
            return;
        }
        FragmentTransaction fragmentTransactionMo6a = getFragmentManager().mo6a();
        fragmentTransactionMo6a.mo13a(this);
        if (z) {
            fragmentTransactionMo6a.mo15b();
        } else {
            fragmentTransactionMo6a.mo10a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        if (!this.f3d) {
            return super.getLayoutInflater(bundle);
        }
        this.f5f = m2a(bundle);
        this.f6g = false;
        switch (this.f0a) {
            case 3:
                this.f5f.getWindow().addFlags(24);
            case 1:
            case 2:
                this.f5f.requestWindowFeature(1);
                break;
        }
        return (LayoutInflater) this.f5f.getContext().getSystemService("layout_inflater");
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Bundle bundle2;
        super.onActivityCreated(bundle);
        if (this.f3d) {
            View view = getView();
            if (view != null) {
                if (view.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.f5f.setContentView(view);
            }
            this.f5f.setOwnerActivity(getActivity());
            this.f5f.setCancelable(this.f2c);
            this.f5f.setOnCancelListener(this);
            this.f5f.setOnDismissListener(this);
            if (bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
                return;
            }
            this.f5f.onRestoreInstanceState(bundle2);
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3d = this.mContainerId == 0;
        if (bundle != null) {
            this.f0a = bundle.getInt("android:style", 0);
            this.f1b = bundle.getInt("android:theme", 0);
            this.f2c = bundle.getBoolean("android:cancelable", true);
            this.f3d = bundle.getBoolean("android:showsDialog", this.f3d);
            this.f4e = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f6g = true;
        if (this.f5f != null) {
            this.f7h = true;
            this.f5f.dismiss();
            this.f5f = null;
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f7h) {
            return;
        }
        m3a(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Bundle bundleOnSaveInstanceState;
        super.onSaveInstanceState(bundle);
        if (this.f5f != null && (bundleOnSaveInstanceState = this.f5f.onSaveInstanceState()) != null) {
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        if (this.f0a != 0) {
            bundle.putInt("android:style", this.f0a);
        }
        if (this.f1b != 0) {
            bundle.putInt("android:theme", this.f1b);
        }
        if (!this.f2c) {
            bundle.putBoolean("android:cancelable", this.f2c);
        }
        if (!this.f3d) {
            bundle.putBoolean("android:showsDialog", this.f3d);
        }
        if (this.f4e != -1) {
            bundle.putInt("android:backStackId", this.f4e);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.f5f != null) {
            this.f7h = false;
            this.f5f.show();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.f5f != null) {
            this.f5f.hide();
        }
    }
}
