package com.example.yuan.demodiaryapp.database;

import org.litepal.crud.DataSupport;

/**
 * Created by yuan on 2017/11/12.
 */

public class Diary extends DataSupport
{
    //id
    private int diaryId;
    //作者
    private String author;
    //标题
    private String title;
    //日期
    private String date;
    //地址
    private String address;
    //保存内容的路径
    private String uri;
    //内容
    private String content;

    public int getDiaryId()
    {
        return diaryId;
    }

    public void setDiaryId(int diaryId)
    {
        this.diaryId = diaryId;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getUri()
    {
        return uri;
    }

    public void setUri(String uri)
    {
        this.uri = uri;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }
}
