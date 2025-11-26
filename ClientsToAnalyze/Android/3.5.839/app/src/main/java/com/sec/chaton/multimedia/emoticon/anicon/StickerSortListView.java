package com.sec.chaton.multimedia.emoticon.anicon;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.widget.AdaptableTextView;
import com.sec.chaton.widget.DynamicListView;

/* loaded from: classes.dex */
public class StickerSortListView extends DynamicListView {
    public StickerSortListView(Context context) {
        super(context);
    }

    public StickerSortListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18697a(context);
    }

    public StickerSortListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18697a(context);
    }

    @Override // com.sec.chaton.widget.DynamicListView
    /* renamed from: a */
    protected void mo11675a(View view, View view2) {
        ImageView imageView = (ImageView) view2.findViewById(R.id.image1);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.image1);
        AdaptableTextView adaptableTextView = (AdaptableTextView) view2.findViewById(R.id.text1);
        AdaptableTextView adaptableTextView2 = (AdaptableTextView) view.findViewById(R.id.text1);
        Drawable drawable = imageView2.getDrawable();
        CharSequence text = adaptableTextView2.getText();
        imageView2.setImageDrawable(imageView.getDrawable());
        adaptableTextView2.setText(adaptableTextView.getText());
        imageView.setImageDrawable(drawable);
        adaptableTextView.setText(text);
    }
}
