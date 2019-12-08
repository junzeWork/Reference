package com.sjy.bean;

import java.util.Date;

public class Books {
    private Integer bookid;

    private String bookname;

    private String bookpress;

    private Date pressdate;

    private String bookauthor;

    private Integer bookcount;

    private String bookimage;

    public Books(Integer bookid, String bookname, String bookpress, Date pressdate, String bookauthor, Integer bookcount, String bookimage) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.bookpress = bookpress;
        this.pressdate = pressdate;
        this.bookauthor = bookauthor;
        this.bookcount = bookcount;
        this.bookimage = bookimage;
    }

    public Books() {
        super();
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public String getBookpress() {
        return bookpress;
    }

    public void setBookpress(String bookpress) {
        this.bookpress = bookpress == null ? null : bookpress.trim();
    }

    public Date getPressdate() {
        return pressdate;
    }

    public void setPressdate(Date pressdate) {
        this.pressdate = pressdate;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor == null ? null : bookauthor.trim();
    }

    public Integer getBookcount() {
        return bookcount;
    }

    public void setBookcount(Integer bookcount) {
        this.bookcount = bookcount;
    }

    public String getBookimage() {
        return bookimage;
    }

    public void setBookimage(String bookimage) {
        this.bookimage = bookimage == null ? null : bookimage.trim();
    }
}