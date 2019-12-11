package com.project.autodealz.data.repository;

import com.project.autodealz.data.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article,String> {


}
