package com.example.guestbookbackend;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MySQLCommentDao {

    private final JPACommentDao jpaCommentDao;

    public MySQLCommentDao(JPACommentDao jpaCommentDao) {
        this.jpaCommentDao = jpaCommentDao;
    }

    public Iterable<Comment> getComments(){
        return this.jpaCommentDao.findAll();
    }

    public void save(Comment comment){
        this.jpaCommentDao.save(comment);
    }
}
