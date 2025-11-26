package com.sec.chaton.p035io.entry;

import com.sec.chaton.p035io.entry.inner.ProfileImage;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class GetProfileImageList extends Entry {
    public Integer listcount;
    public Integer maxcount;
    public ArrayList<ProfileImage> profileimagelist = new ArrayList<>();

    @Override // com.sec.chaton.p035io.entry.Entry
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("listcount:");
        sb.append(this.listcount);
        sb.append("\n");
        sb.append("maxcount:");
        sb.append(this.maxcount);
        sb.append("\n");
        Iterator<ProfileImage> it = this.profileimagelist.iterator();
        while (it.hasNext()) {
            ProfileImage next = it.next();
            sb.append("profileimagelist:");
            sb.append(next.toString());
        }
        sb.append("\n");
        return sb.toString();
    }
}
