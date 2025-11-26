package com.sec.chaton.chat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;

/* loaded from: classes.dex */
public class EmptyChatFragment extends Fragment {

    /* renamed from: a */
    private ImageView f3772a;

    /* renamed from: b */
    private TextView f3773b;

    /* renamed from: c */
    private TextView f3774c;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.empty_chat_fragment, viewGroup, false);
        this.f3772a = (ImageView) viewInflate.findViewById(R.id.image1);
        this.f3772a.setImageResource(R.drawable.no_contents_chat);
        this.f3773b = (TextView) viewInflate.findViewById(R.id.text1);
        this.f3773b.setText(getResources().getString(R.string.no_item_selected));
        this.f3774c = (TextView) viewInflate.findViewById(R.id.text2);
        this.f3774c.setText(getResources().getString(R.string.empty_chat_frag_no_chat));
        this.f3774c.setVisibility(8);
        return viewInflate;
    }
}
