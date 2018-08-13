package eslami.dev.info.e_islami.Models;

import com.google.gson.annotations.SerializedName;

public class MetaDataModel {

    @SerializedName("identifier")
 private  String identifier;

    @SerializedName("mediatype")
 private  String mediatype;

    @SerializedName("collection")
 private  String collection;

    @SerializedName("creator")
 private  String creator;

    @SerializedName("description")
 private  String description;

    @SerializedName("scanner")
 private  String scanner;

    @SerializedName("subject")
 private  String subject;

    @SerializedName("title")
 private  String title;

    @SerializedName("publicdate")
 private  String publicdate;

    @SerializedName("uploader")
 private  String uploader;

    @SerializedName("addeddate")
 private  String addeddate;

    @SerializedName("curation")
 private  String curation;

    @SerializedName("server")
 private  String server;

    @SerializedName("uniq")
 private  String uniq;


    public MetaDataModel(String identifier, String mediatype, String collection, String creator, String description, String scanner, String subject, String title, String publicdate, String uploader, String addeddate, String curation, String server, String uniq) {
        this.identifier = identifier;
        this.mediatype = mediatype;
        this.collection = collection;
        this.creator = creator;
        this.description = description;
        this.scanner = scanner;
        this.subject = subject;
        this.title = title;
        this.publicdate = publicdate;
        this.uploader = uploader;
        this.addeddate = addeddate;
        this.curation = curation;
        this.server = server;
        this.uniq = uniq;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getMediatype() {
        return mediatype;
    }

    public void setMediatype(String mediatype) {
        this.mediatype = mediatype;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScanner() {
        return scanner;
    }

    public void setScanner(String scanner) {
        this.scanner = scanner;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublicdate() {
        return publicdate;
    }

    public void setPublicdate(String publicdate) {
        this.publicdate = publicdate;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public String getAddeddate() {
        return addeddate;
    }

    public void setAddeddate(String addeddate) {
        this.addeddate = addeddate;
    }

    public String getCuration() {
        return curation;
    }

    public void setCuration(String curation) {
        this.curation = curation;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getUniq() {
        return uniq;
    }

    public void setUniq(String uniq) {
        this.uniq = uniq;
    }
}
