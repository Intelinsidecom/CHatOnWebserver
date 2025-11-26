package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;

/* loaded from: classes.dex */
public abstract class LoaderManager {

    public interface LoaderCallbacks {
        /* renamed from: a */
        Loader mo38a(int i, Bundle bundle);

        /* renamed from: a */
        void mo39a(Loader loader);

        /* renamed from: a */
        void mo40a(Loader loader, Object obj);
    }

    /* renamed from: a */
    public abstract Loader mo37a(int i, Bundle bundle, LoaderCallbacks loaderCallbacks);
}
