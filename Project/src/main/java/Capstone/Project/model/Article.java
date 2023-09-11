package Capstone.Project.model;

import javax.persistence.*;

@Entity
@Table
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer 	ArticleId ;
	@Column
	public String ArticleName ;
	@Column
	public String ArticleDescription ;
	
	
	public Integer getArticleId() {
		return ArticleId;
	}
	public void setArticleId(Integer articleId) {
		ArticleId = articleId;
	}
	public String getArticleName() {
		return ArticleName;
	}
	public void setArticleName(String articleName) {
		ArticleName = articleName;
	}
	public String getArticleDescription() {
		return ArticleDescription;
	}
	public void setArticleDescription(String articleDescription) {
		ArticleDescription = articleDescription;
	}

	
}
