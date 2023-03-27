package com.demo.sb.restdemo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.sb.restdemo.beans.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
