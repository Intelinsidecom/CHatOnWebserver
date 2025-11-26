package com.sec.chaton.p035io.entry.specialbuddy;

import com.sec.chaton.p035io.entry.Entry;
import com.sec.chaton.util.C3247v;
import com.sec.chaton.util.C3250y;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SpecialBuddyRecommendEntry extends Entry {
    public String content;
    public SpecialBuddyRecommendBuddyEntry parsedContent;

    public String getRawContents() {
        return this.content;
    }

    public JSONObject getJsonContents() {
        try {
            return new JSONObject(this.content);
        } catch (JSONException e) {
            C3250y.m11443a(e, SpecialBuddyRecommendEntry.class.getSimpleName());
            return null;
        }
    }

    public SpecialBuddyRecommendBuddyEntry getParsedContents() {
        if (this.parsedContent == null) {
            try {
                this.parsedContent = (SpecialBuddyRecommendBuddyEntry) new C3247v(this.content).m11432b(SpecialBuddyRecommendBuddyEntry.class);
            } catch (Exception e) {
                C3250y.m11443a(e, SpecialBuddyRecommendEntry.class.getSimpleName());
            }
        }
        return this.parsedContent;
    }
}
