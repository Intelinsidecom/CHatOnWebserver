package android.support.v4.widget;

import android.content.Context;
import android.os.Build;
import android.support.v4.widget.SearchViewCompatHoneycomb;
import android.view.View;

/* loaded from: classes.dex */
public class SearchViewCompat {
    private static final SearchViewCompatImpl IMPL;

    interface SearchViewCompatImpl {
        Object newOnQueryTextListener(OnQueryTextListenerCompat onQueryTextListenerCompat);

        View newSearchView(Context context);

        void setOnQueryTextListener(Object obj, Object obj2);
    }

    class SearchViewCompatStubImpl implements SearchViewCompatImpl {
        SearchViewCompatStubImpl() {
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public View newSearchView(Context context) {
            return null;
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public Object newOnQueryTextListener(OnQueryTextListenerCompat onQueryTextListenerCompat) {
            return null;
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setOnQueryTextListener(Object obj, Object obj2) {
        }
    }

    class SearchViewCompatHoneycombImpl extends SearchViewCompatStubImpl {
        SearchViewCompatHoneycombImpl() {
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public View newSearchView(Context context) {
            return SearchViewCompatHoneycomb.newSearchView(context);
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public Object newOnQueryTextListener(final OnQueryTextListenerCompat onQueryTextListenerCompat) {
            return SearchViewCompatHoneycomb.newOnQueryTextListener(new SearchViewCompatHoneycomb.OnQueryTextListenerCompatBridge() { // from class: android.support.v4.widget.SearchViewCompat.SearchViewCompatHoneycombImpl.1
                @Override // android.support.v4.widget.SearchViewCompatHoneycomb.OnQueryTextListenerCompatBridge
                public boolean onQueryTextSubmit(String str) {
                    return onQueryTextListenerCompat.onQueryTextSubmit(str);
                }

                @Override // android.support.v4.widget.SearchViewCompatHoneycomb.OnQueryTextListenerCompatBridge
                public boolean onQueryTextChange(String str) {
                    return onQueryTextListenerCompat.onQueryTextChange(str);
                }
            });
        }

        @Override // android.support.v4.widget.SearchViewCompat.SearchViewCompatStubImpl, android.support.v4.widget.SearchViewCompat.SearchViewCompatImpl
        public void setOnQueryTextListener(Object obj, Object obj2) {
            SearchViewCompatHoneycomb.setOnQueryTextListener(obj, obj2);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new SearchViewCompatHoneycombImpl();
        } else {
            IMPL = new SearchViewCompatStubImpl();
        }
    }

    private SearchViewCompat(Context context) {
    }

    public static View newSearchView(Context context) {
        return IMPL.newSearchView(context);
    }

    public static void setOnQueryTextListener(View view, OnQueryTextListenerCompat onQueryTextListenerCompat) {
        IMPL.setOnQueryTextListener(view, onQueryTextListenerCompat.mListener);
    }

    public abstract class OnQueryTextListenerCompat {
        final Object mListener = SearchViewCompat.IMPL.newOnQueryTextListener(this);

        public boolean onQueryTextSubmit(String str) {
            return false;
        }

        public boolean onQueryTextChange(String str) {
            return false;
        }
    }
}
