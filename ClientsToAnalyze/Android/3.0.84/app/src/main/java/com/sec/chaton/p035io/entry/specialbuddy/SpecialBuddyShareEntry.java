package com.sec.chaton.p035io.entry.specialbuddy;

import com.sec.chaton.p035io.entry.Entry;
import com.sec.chaton.util.C3247v;
import com.sec.chaton.util.C3250y;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SpecialBuddyShareEntry extends Entry {
    public String content;
    public SpecialBuddyShareContentsEntry parsedContent;

    public String getRawContents() {
        return this.content;
    }

    public JSONObject getJsonContents() {
        try {
            return new JSONObject(this.content);
        } catch (JSONException e) {
            C3250y.m11443a(e, SpecialBuddyShareEntry.class.getSimpleName());
            return null;
        }
    }

    public SpecialBuddyShareContentsEntry getParsedContents() {
        if (this.parsedContent == null) {
            try {
                this.parsedContent = (SpecialBuddyShareContentsEntry) new C3247v(this.content).m11432b(SpecialBuddyShareContentsEntry.class);
            } catch (Exception e) {
                C3250y.m11443a(e, SpecialBuddyShareEntry.class.getSimpleName());
            }
        }
        return this.parsedContent;
    }
}
