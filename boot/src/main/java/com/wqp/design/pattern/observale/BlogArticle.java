package com.wqp.design.pattern.observale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Observable;

/**
 * @Description 博客文章作为被观察者，
 * 作者作为观察者，观察这篇博客文章的评论内容
 *
 * 被观察者类中有一个vector集合，是用来存放观察者的
 * @Author Wang QiuPeng
 * Date 19/4/13 16:34
 **/
public class BlogArticle extends Observable {
    private static final Logger LOG = LoggerFactory.getLogger(BlogArticle.class);
    private String title;
    private String content;

    private BlogArticle(Builder builder) {
        setTitle(builder.title);
        setContent(builder.content);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public  void writeComment(BlogArticle article,Comment comment){
        LOG.info("{} in article {} write a comment, content is {}"
        ,comment.getUserName(),article.getTitle(),comment.getCommentContent());
        //被观察者状态发生改变，初始化时false代表未改变，这里设置为true，表示改变
        setChanged();
        //通知观察者
        notifyObservers(comment);
    }


    public static final class Builder {

        private String title;
        private String content;

        public Builder() {
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder content(String val) {
            content = val;
            return this;
        }

        public BlogArticle build() {
            return new BlogArticle(this);
        }
    }
}
