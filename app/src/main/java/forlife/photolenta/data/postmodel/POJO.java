
package forlife.photolenta.data.postmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class POJO {

    @SerializedName("public_key")
    @Expose
    private String publicKey;
    @SerializedName("_embedded")
    @Expose
    public Embedded embedded;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("exif")
    @Expose
    private Exif_ exif;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("resource_id")
    @Expose
    private String resourceId;
    @SerializedName("public_url")
    @Expose
    private String publicUrl;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("owner")
    @Expose
    private Owner owner;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("comment_ids")
    @Expose
    private CommentIds_ commentIds;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("revision")
    @Expose
    private Long revision;

    public class Embedded {

        @SerializedName("sort")
        @Expose
        private String sort;
        @SerializedName("public_key")
        @Expose
        private String publicKey;
        @SerializedName("items")
        @Expose
        public Item items = null;
        @SerializedName("limit")
        @Expose
        private Integer limit;
        @SerializedName("offset")
        @Expose
        private Integer offset;
        @SerializedName("path")
        @Expose
        private String path;
        @SerializedName("total")
        @Expose
        private Integer total;

        public class Item {

            @SerializedName("antivirus_status")
            @Expose
            public String antivirusStatus;
            @SerializedName("public_key")
            @Expose
            public String publicKey;
            @SerializedName("file")
            @Expose
            public String file;
            @SerializedName("sha256")
            @Expose
            public String sha256;
            @SerializedName("name")
            @Expose
            public String name;
            @SerializedName("exif")
            @Expose
            public Exif exif;
            @SerializedName("created")
            @Expose
            public String created;
            @SerializedName("revision")
            @Expose
            public Long revision;
            @SerializedName("resource_id")
            @Expose
            public String resourceId;
            @SerializedName("modified")
            @Expose
            public String modified;
            @SerializedName("comment_ids")
            @Expose
            private CommentIds commentIds;
            @SerializedName("preview")
            @Expose
            private String preview;
            @SerializedName("media_type")
            @Expose
            private String mediaType;
            @SerializedName("path")
            @Expose
            private String path;
            @SerializedName("md5")
            @Expose
            private String md5;
            @SerializedName("type")
            @Expose
            private String type;
            @SerializedName("mime_type")
            @Expose
            private String mimeType;
            @SerializedName("size")
            @Expose
            public Integer size;

        }


    }

}
