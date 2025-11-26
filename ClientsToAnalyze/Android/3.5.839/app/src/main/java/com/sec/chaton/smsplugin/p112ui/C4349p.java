package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CursorAdapter;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p102b.C3790i;
import com.sec.chaton.smsplugin.p111h.C3890m;

/* compiled from: ConversationListAdapter.java */
/* renamed from: com.sec.chaton.smsplugin.ui.p */
/* loaded from: classes.dex */
public class C4349p extends CursorAdapter implements AbsListView.RecyclerListener {

    /* renamed from: a */
    private final LayoutInflater f15786a;

    /* renamed from: b */
    private InterfaceC4350q f15787b;

    public C4349p(Context context, Cursor cursor) {
        super(context, cursor, false);
        this.f15786a = LayoutInflater.from(context);
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        if (!(view instanceof ConversationListItem)) {
            C3890m.m14999e("ConversationListAdapter", "Unexpected bound view: " + view);
        } else {
            ((ConversationListItem) view).m15754a(context, C3790i.m14318a(context, cursor));
        }
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        ((ConversationListItem) view).m15753a();
    }

    @Override // android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f15786a.inflate(R.layout.conversation_list_item, viewGroup, false);
    }

    /* renamed from: a */
    public void m16527a(InterfaceC4350q interfaceC4350q) {
        this.f15787b = interfaceC4350q;
    }

    @Override // android.widget.CursorAdapter
    protected void onContentChanged() {
        if (this.mCursor != null && !this.mCursor.isClosed() && this.f15787b != null) {
            this.f15787b.mo16475a(this);
        }
    }

    /* renamed from: a */
    public void m16526a() {
        int count = getCount();
        for (int i = 0; i < count; i++) {
            C3790i.m14318a(this.mContext, (Cursor) getItem(i)).m14358c(false);
        }
    }
}
