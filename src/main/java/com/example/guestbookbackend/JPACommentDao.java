package com.example.guestbookbackend;

import org.springframework.data.repository.CrudRepository;

public interface JPACommentDao  extends CrudRepository<Comment, Long> {
}
