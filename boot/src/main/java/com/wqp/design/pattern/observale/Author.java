package com.wqp.design.pattern.observale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Observable;
import java.util.Observer;

/**
 * @Description TODO
 * @Author Wang QiuPeng
 * Date 19/4/13 16:39
 **/
public class Author implements Observer {

    private static final Logger LOG = LoggerFactory.getLogger(Author.class);

    private String authorName;

    public Author(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public void update(Observable o, Object arg) {
        BlogArticle article = (BlogArticle)o;
        Comment comment = (Comment)arg;
        LOG.info("author  {} , article title is {}, receiver a  from  user {} comment,content is {}"
                ,authorName,article.getTitle(),comment.getUserName(),comment.getCommentContent());
    }
}
