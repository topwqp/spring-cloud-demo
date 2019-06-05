package com.wqp.domain.pattern.observale;

/**
 * @Description 观察者模式测试类
 * @Author Wang QiuPeng
 * Date 19/4/13 16:56
 **/
public class Test {
    public static void main(String args[]){
         BlogArticle article = new BlogArticle.Builder()
                 .title("[design pattern observe]").content("~~~~~~~~").build();
         Author  bob  = new Author("Bob");
         Author  tom  = new Author("Tom");
         article.addObserver(bob);
         article.addObserver(tom);

         Comment comment = new Comment.Builder().userName("Alice").commentContent("oh shit ").build();

         article.writeComment(article,comment);








    }
}
