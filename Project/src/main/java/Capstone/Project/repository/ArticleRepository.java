package Capstone.Project.repository;

import Capstone.Project.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class ArticleRepository {

    @Autowired
    JdbcTemplate jdbc;

    private RowMapper<Article> rowMapper = new RowMapper<Article>() {

        @Override

        public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
            Article art = new Article();

            art.setArticleId(rs.getInt("ArticleId"));
            art.setArticleName(rs.getString("ArticleName"));
            art.setArticleDescription(rs.getString("ArticleDescription"));
            return art;
        }

    };
    public void createArticle(Article art) {
        String sql = "insert into Article(ArticleName, ArticleDescription) values (?,?)";
        jdbc.update(sql,art.getArticleName(), art.getArticleDescription());
    }
    public List<Article> similarity(){
        String sql = "SELECT ArticleDescription FROM ARTICLE";
        return jdbc.query(sql,rowMapper);
    }
}
