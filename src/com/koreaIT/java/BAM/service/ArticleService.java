package com.koreaIT.java.BAM.service;

import java.util.List;

import com.koreaIT.java.BAM.container.Container;
import com.koreaIT.java.BAM.dto.Article;

public class ArticleService {

	public List<Article> getPrintArticles(String searchKeyword) {
		return Container.articleDao.getPrintARticles(searchKeyword);
	}

	public int getLastId() {
		
		return Container.articleDao.getLastId();
	}

	public void add(Article article) {
		Container.articleDao.add(article);
		
	}

	public Article getArticleById(int id) {
		
		return Container.articleDao.getArticleById(id);
	}
	public void remove(Article foundArticle) {
		Container.articleDao.remove(foundArticle);
		
	}

}
