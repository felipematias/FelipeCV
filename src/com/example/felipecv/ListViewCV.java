package com.example.felipecv;

/**
 * @author Felipe
 */
public class ListViewCV {

    private String text;
    private int iconeRid;

    public ListViewCV () {
    }

    public ListViewCV (String text, int iconeRid) {
        this.text = text;
        this.iconeRid = iconeRid;
    }

    public int getIconeRid() {
        return iconeRid;
    }

    public void setIconeRid(int iconeRid) {
        this.iconeRid = iconeRid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}