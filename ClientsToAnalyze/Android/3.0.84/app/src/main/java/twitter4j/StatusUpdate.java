package twitter4j;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import twitter4j.internal.http.HttpParameter;

/* loaded from: classes.dex */
public final class StatusUpdate implements Serializable {
    private static final long serialVersionUID = -3595502688477609916L;
    private transient InputStream mediaBody;
    private File mediaFile;
    private String mediaName;
    private boolean possiblySensitive;
    private String status;
    private long inReplyToStatusId = -1;
    private GeoLocation location = null;
    private String placeId = null;
    private boolean displayCoordinates = true;
    private Annotations annotations = null;

    public StatusUpdate(String str) {
        this.status = str;
    }

    public String getStatus() {
        return this.status;
    }

    public long getInReplyToStatusId() {
        return this.inReplyToStatusId;
    }

    public void setInReplyToStatusId(long j) {
        this.inReplyToStatusId = j;
    }

    public StatusUpdate inReplyToStatusId(long j) {
        setInReplyToStatusId(j);
        return this;
    }

    public GeoLocation getLocation() {
        return this.location;
    }

    public void setLocation(GeoLocation geoLocation) {
        this.location = geoLocation;
    }

    public StatusUpdate location(GeoLocation geoLocation) {
        setLocation(geoLocation);
        return this;
    }

    public String getPlaceId() {
        return this.placeId;
    }

    public void setPlaceId(String str) {
        this.placeId = str;
    }

    public StatusUpdate placeId(String str) {
        setPlaceId(str);
        return this;
    }

    public boolean isDisplayCoordinates() {
        return this.displayCoordinates;
    }

    public void setDisplayCoordinates(boolean z) {
        this.displayCoordinates = z;
    }

    public StatusUpdate displayCoordinates(boolean z) {
        setDisplayCoordinates(z);
        return this;
    }

    public void setMedia(File file) {
        this.mediaFile = file;
    }

    public StatusUpdate media(File file) {
        setMedia(file);
        return this;
    }

    public void setMedia(String str, InputStream inputStream) {
        this.mediaName = str;
        this.mediaBody = inputStream;
    }

    boolean isWithMedia() {
        return (this.mediaFile == null && this.mediaName == null) ? false : true;
    }

    public StatusUpdate media(String str, InputStream inputStream) {
        setMedia(str, inputStream);
        return this;
    }

    public void setPossiblySensitive(boolean z) {
        this.possiblySensitive = z;
    }

    public StatusUpdate possiblySensitive(boolean z) {
        setPossiblySensitive(z);
        return this;
    }

    public boolean isPossiblySensitive() {
        return this.possiblySensitive;
    }

    public Annotations getAnnotations() {
        return this.annotations;
    }

    public void setAnnotations(Annotations annotations) {
        this.annotations = annotations;
    }

    public StatusUpdate annotations(Annotations annotations) {
        setAnnotations(annotations);
        return this;
    }

    public void addAnnotation(Annotation annotation) {
        if (this.annotations == null) {
            this.annotations = new Annotations();
        }
        this.annotations.addAnnotation(annotation);
    }

    public StatusUpdate annotation(Annotation annotation) {
        addAnnotation(annotation);
        return this;
    }

    HttpParameter[] asHttpParameterArray(HttpParameter httpParameter) {
        ArrayList arrayList = new ArrayList();
        appendParameter("status", this.status, arrayList);
        if (-1 != this.inReplyToStatusId) {
            appendParameter("in_reply_to_status_id", this.inReplyToStatusId, (List<HttpParameter>) arrayList);
        }
        if (this.location != null) {
            appendParameter("lat", this.location.getLatitude(), arrayList);
            appendParameter("long", this.location.getLongitude(), arrayList);
        }
        appendParameter("place_id", this.placeId, arrayList);
        if (!this.displayCoordinates) {
            appendParameter("display_coordinates", "false", arrayList);
        }
        if (this.annotations != null && !this.annotations.isEmpty()) {
            appendParameter("annotations", this.annotations.asParameterValue(), arrayList);
        }
        arrayList.add(httpParameter);
        if (this.mediaFile != null) {
            arrayList.add(new HttpParameter("media[]", this.mediaFile));
            arrayList.add(new HttpParameter("possibly_sensitive", this.possiblySensitive));
        } else if (this.mediaName != null && this.mediaBody != null) {
            arrayList.add(new HttpParameter("media[]", this.mediaName, this.mediaBody));
            arrayList.add(new HttpParameter("possibly_sensitive", this.possiblySensitive));
        }
        return (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()]);
    }

    private void appendParameter(String str, String str2, List<HttpParameter> list) {
        if (str2 != null) {
            list.add(new HttpParameter(str, str2));
        }
    }

    private void appendParameter(String str, double d, List<HttpParameter> list) {
        list.add(new HttpParameter(str, String.valueOf(d)));
    }

    private void appendParameter(String str, long j, List<HttpParameter> list) {
        list.add(new HttpParameter(str, String.valueOf(j)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StatusUpdate statusUpdate = (StatusUpdate) obj;
        if (this.displayCoordinates == statusUpdate.displayCoordinates && this.inReplyToStatusId == statusUpdate.inReplyToStatusId && this.possiblySensitive == statusUpdate.possiblySensitive) {
            if (this.annotations == null ? statusUpdate.annotations != null : !this.annotations.equals(statusUpdate.annotations)) {
                return false;
            }
            if (this.location == null ? statusUpdate.location != null : !this.location.equals(statusUpdate.location)) {
                return false;
            }
            if (this.mediaBody == null ? statusUpdate.mediaBody != null : !this.mediaBody.equals(statusUpdate.mediaBody)) {
                return false;
            }
            if (this.mediaFile == null ? statusUpdate.mediaFile != null : !this.mediaFile.equals(statusUpdate.mediaFile)) {
                return false;
            }
            if (this.mediaName == null ? statusUpdate.mediaName != null : !this.mediaName.equals(statusUpdate.mediaName)) {
                return false;
            }
            if (this.placeId == null ? statusUpdate.placeId != null : !this.placeId.equals(statusUpdate.placeId)) {
                return false;
            }
            if (this.status != null) {
                if (this.status.equals(statusUpdate.status)) {
                    return true;
                }
            } else if (statusUpdate.status == null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (((this.mediaBody != null ? this.mediaBody.hashCode() : 0) + (((this.mediaName != null ? this.mediaName.hashCode() : 0) + (((((this.annotations != null ? this.annotations.hashCode() : 0) + (((this.displayCoordinates ? 1 : 0) + (((this.placeId != null ? this.placeId.hashCode() : 0) + (((this.location != null ? this.location.hashCode() : 0) + ((((this.status != null ? this.status.hashCode() : 0) * 31) + ((int) (this.inReplyToStatusId ^ (this.inReplyToStatusId >>> 32)))) * 31)) * 31)) * 31)) * 31)) * 31) + (this.possiblySensitive ? 1 : 0)) * 31)) * 31)) * 31) + (this.mediaFile != null ? this.mediaFile.hashCode() : 0);
    }

    public String toString() {
        return new StringBuffer().append("StatusUpdate{status='").append(this.status).append('\'').append(", inReplyToStatusId=").append(this.inReplyToStatusId).append(", location=").append(this.location).append(", placeId='").append(this.placeId).append('\'').append(", displayCoordinates=").append(this.displayCoordinates).append(", annotations=").append(this.annotations).append(", possiblySensitive=").append(this.possiblySensitive).append(", mediaName='").append(this.mediaName).append('\'').append(", mediaBody=").append(this.mediaBody).append(", mediaFile=").append(this.mediaFile).append('}').toString();
    }
}
