package com.wqp.design.pattern.observale;

/**
 * @Description TODO
 * @Author Wang QiuPeng
 * Date 19/4/13 16:36
 **/
public class Comment  {
    private  String userName;
    private  String  commentContent;

    private Comment(Builder builder) {
        setUserName(builder.userName);
        setCommentContent(builder.commentContent);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }


    public static final class Builder {
        private String userName;
        private String commentContent;

        public Builder() {
        }

        public Builder userName(String val) {
            userName = val;
            return this;
        }

        public Builder commentContent(String val) {
            commentContent = val;
            return this;
        }

        public Comment build() {
            return new Comment(this);
        }
    }
}
