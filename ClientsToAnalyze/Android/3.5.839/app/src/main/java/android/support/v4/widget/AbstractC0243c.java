package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

/* compiled from: CursorAdapter.java */
/* renamed from: android.support.v4.widget.c */
/* loaded from: classes.dex */
public abstract class AbstractC0243c extends BaseAdapter implements InterfaceC0248h, Filterable {

    /* renamed from: a */
    protected boolean f577a;

    /* renamed from: b */
    protected boolean f578b;

    /* renamed from: c */
    protected Cursor f579c;

    /* renamed from: d */
    protected Context f580d;

    /* renamed from: e */
    protected int f581e;

    /* renamed from: f */
    protected C0245e f582f;

    /* renamed from: g */
    protected DataSetObserver f583g;

    /* renamed from: h */
    protected C0247g f584h;

    /* renamed from: i */
    protected FilterQueryProvider f585i;

    /* renamed from: a */
    public abstract View mo873a(Context context, Cursor cursor, ViewGroup viewGroup);

    /* renamed from: a */
    public abstract void mo876a(View view, Context context, Cursor cursor);

    @Deprecated
    public AbstractC0243c(Context context, Cursor cursor) {
        m874a(context, cursor, 1);
    }

    public AbstractC0243c(Context context, Cursor cursor, boolean z) {
        m874a(context, cursor, z ? 1 : 2);
    }

    public AbstractC0243c(Context context, Cursor cursor, int i) {
        m874a(context, cursor, i);
    }

    /* renamed from: a */
    void m874a(Context context, Cursor cursor, int i) {
        if ((i & 1) == 1) {
            i |= 2;
            this.f578b = true;
        } else {
            this.f578b = false;
        }
        boolean z = cursor != null;
        this.f579c = cursor;
        this.f577a = z;
        this.f580d = context;
        this.f581e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f582f = new C0245e(this);
            this.f583g = new C0246f(this);
        } else {
            this.f582f = null;
            this.f583g = null;
        }
        if (z) {
            if (this.f582f != null) {
                cursor.registerContentObserver(this.f582f);
            }
            if (this.f583g != null) {
                cursor.registerDataSetObserver(this.f583g);
            }
        }
    }

    @Override // android.support.v4.widget.InterfaceC0248h
    /* renamed from: a */
    public Cursor mo871a() {
        return this.f579c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (!this.f577a || this.f579c == null) {
            return 0;
        }
        return this.f579c.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (!this.f577a || this.f579c == null) {
            return null;
        }
        this.f579c.moveToPosition(i);
        return this.f579c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.f577a && this.f579c != null && this.f579c.moveToPosition(i)) {
            return this.f579c.getLong(this.f581e);
        }
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f577a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!this.f579c.moveToPosition(i)) {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
        if (view == null) {
            view = mo873a(this.f580d, this.f579c, viewGroup);
        }
        mo876a(view, this.f580d, this.f579c);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f577a) {
            return null;
        }
        this.f579c.moveToPosition(i);
        if (view == null) {
            view = mo878b(this.f580d, this.f579c, viewGroup);
        }
        mo876a(view, this.f580d, this.f579c);
        return view;
    }

    /* renamed from: b */
    public View mo878b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return mo873a(context, cursor, viewGroup);
    }

    @Override // android.support.v4.widget.InterfaceC0248h
    /* renamed from: a */
    public void mo875a(Cursor cursor) {
        Cursor cursorMo877b = mo877b(cursor);
        if (cursorMo877b != null) {
            cursorMo877b.close();
        }
    }

    /* renamed from: b */
    public Cursor mo877b(Cursor cursor) {
        if (cursor == this.f579c) {
            return null;
        }
        Cursor cursor2 = this.f579c;
        if (cursor2 != null) {
            if (this.f582f != null) {
                cursor2.unregisterContentObserver(this.f582f);
            }
            if (this.f583g != null) {
                cursor2.unregisterDataSetObserver(this.f583g);
            }
        }
        this.f579c = cursor;
        if (cursor != null) {
            if (this.f582f != null) {
                cursor.registerContentObserver(this.f582f);
            }
            if (this.f583g != null) {
                cursor.registerDataSetObserver(this.f583g);
            }
            this.f581e = cursor.getColumnIndexOrThrow("_id");
            this.f577a = true;
            notifyDataSetChanged();
            return cursor2;
        }
        this.f581e = -1;
        this.f577a = false;
        notifyDataSetInvalidated();
        return cursor2;
    }

    @Override // android.support.v4.widget.InterfaceC0248h
    /* renamed from: c */
    public CharSequence mo880c(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    @Override // android.support.v4.widget.InterfaceC0248h
    /* renamed from: a */
    public Cursor mo872a(CharSequence charSequence) {
        return this.f585i != null ? this.f585i.runQuery(charSequence) : this.f579c;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f584h == null) {
            this.f584h = new C0247g(this);
        }
        return this.f584h;
    }

    /* renamed from: b */
    protected void m879b() {
        if (this.f578b && this.f579c != null && !this.f579c.isClosed()) {
            this.f577a = this.f579c.requery();
        }
    }
}
