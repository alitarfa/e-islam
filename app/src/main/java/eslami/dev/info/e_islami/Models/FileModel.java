package eslami.dev.info.e_islami.Models;

import com.google.gson.annotations.SerializedName;

public class FileModel {

    @SerializedName("name")
   private String name;

    @SerializedName("source")
   private String source;

    @SerializedName("format")
   private String format;

    @SerializedName("original")
   private String original;

    @SerializedName("mtime")
   private String mtime;

    @SerializedName("size")
   private String size;

    @SerializedName("md5")
   private String md5;

    @SerializedName("crc32")
   private String crc32;

    @SerializedName("sha1")
   private String sha1;



    public FileModel(String name, String source, String format, String original, String mtime, String size, String md5, String crc32, String sha1) {

        this.name = name;
        this.source = source;
        this.format = format;
        this.original = original;
        this.mtime = mtime;
        this.size = size;
        this.md5 = md5;
        this.crc32 = crc32;
        this.sha1 = sha1;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getCrc32() {
        return crc32;
    }

    public void setCrc32(String crc32) {
        this.crc32 = crc32;
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }


}
