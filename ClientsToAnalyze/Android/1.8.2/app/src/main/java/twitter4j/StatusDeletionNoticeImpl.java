package twitter4j;

import java.io.Serializable;
import org.json.JSONObject;
import twitter4j.internal.util.z_T4JInternalParseUtil;

/* loaded from: classes.dex */
class StatusDeletionNoticeImpl implements Serializable, StatusDeletionNotice {
    private static final long serialVersionUID = 1723338404242596062L;
    private long statusId;
    private long userId;

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return compareTo((StatusDeletionNotice) obj);
    }

    StatusDeletionNoticeImpl(JSONObject jSONObject) {
        this.statusId = z_T4JInternalParseUtil.getLong("id", jSONObject);
        this.userId = z_T4JInternalParseUtil.getLong("user_id", jSONObject);
    }

    @Override // twitter4j.StatusDeletionNotice
    public long getStatusId() {
        return this.statusId;
    }

    @Override // twitter4j.StatusDeletionNotice
    public long getUserId() {
        return this.userId;
    }

    public int compareTo(StatusDeletionNotice statusDeletionNotice) {
        long statusId = this.statusId - statusDeletionNotice.getStatusId();
        if (statusId < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        if (statusId > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) statusId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StatusDeletionNoticeImpl statusDeletionNoticeImpl = (StatusDeletionNoticeImpl) obj;
        return this.statusId == statusDeletionNoticeImpl.statusId && this.userId == statusDeletionNoticeImpl.userId;
    }

    public int hashCode() {
        return (((int) (this.statusId ^ (this.statusId >>> 32))) * 31) + ((int) (this.userId ^ (this.userId >>> 32)));
    }

    public String toString() {
        return new StringBuffer().append("StatusDeletionNoticeImpl{statusId=").append(this.statusId).append(", userId=").append(this.userId).append('}').toString();
    }
}
