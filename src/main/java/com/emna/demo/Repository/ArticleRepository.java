package com.emna.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emna.demo.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer>{

}
