package com.project.autodealz.service.impls;

import com.project.autodealz.data.entities.Article;
import com.project.autodealz.data.repository.ArticleRepository;
import com.project.autodealz.service.ArticleService;
import com.project.autodealz.service.models.ArticleServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ModelMapper modelMapper;
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ModelMapper modelMapper, ArticleRepository articleRepository) {
        this.modelMapper = modelMapper;
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleServiceModel createArticle(ArticleServiceModel articleServiceModel) {
        Article article = this.modelMapper.map(articleServiceModel , Article.class);

        return this.modelMapper.map(this.articleRepository.saveAndFlush(article),
                ArticleServiceModel.class);
    }
}
