package com.sec.chaton.buddy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;

@Deprecated
/* loaded from: classes.dex */
public class EmptyFragment extends Fragment {

    /* renamed from: a */
    public static String f4099a = "No_Buddy_Selection";

    /* renamed from: b */
    public static String f4100b = "No_Chat_Selection";

    /* renamed from: c */
    public static String f4101c = "Empty_Flag";

    /* renamed from: d */
    private Bundle f4102d;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4102d = getArguments();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.empty_fragment, viewGroup, false);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.image1);
        TextView textView = (TextView) viewInflate.findViewById(R.id.text1);
        if (this.f4102d != null) {
            String string = this.f4102d.getString(f4101c);
            if (string.equals(f4099a)) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.no_contents_buddies));
                textView.setText(getResources().getString(R.string.no_item_selected));
            } else if (string.equals(f4100b)) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.no_contents_chat));
                textView.setText(getResources().getString(R.string.no_item_selected_on_chat));
            }
        }
        return viewInflate;
    }
}
