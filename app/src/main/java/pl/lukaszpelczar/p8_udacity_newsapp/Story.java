package pl.lukaszpelczar.p8_udacity_newsapp;

public class Story {

    private String mDate;
    private String mSection;
    private String mTitle;
    private String mAuthor;
    private String mUrl;

    public Story(String date, String title, String section, String url, String author){
        mDate = date;
        mSection = section;
        mTitle = title;
        mUrl = url;
        mAuthor = author;
    }

    public String getmDate() {
        return mDate;
    }

    public String getmSection() {
        return mSection;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmUrl() {
        return mUrl;
    }

    public String getmAuthor() { return mAuthor; }
}
