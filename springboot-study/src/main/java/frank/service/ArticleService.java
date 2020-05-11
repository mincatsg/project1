package frank.service;


import frank.mapper.ArticleMapper;
import frank.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    public Article queryArticleById(Long id) {
        return articleMapper.queryArticleById(id);
    }
}
