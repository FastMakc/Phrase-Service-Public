package com.example.phraseservicepublic.dao.impl;
import com.example.phraseservicepublic.domain.api.search.searchTags.TagRespRowMapper;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.sql.DataSource;
import com.example.phraseservicepublic.domain.api.search.searchTags.TagResp;
import java.util.List;

@Slf4j
@Repository
@Transactional
public class SearchDaoImpl implements com.example.phraseservicepublic.dao.SearchDao {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;



    @Override
    public List<TagResp> searchTags(String partTag) {

        return jdbcTemplate.query("SELECT id, text " +
                        "FROM (" +
                        "         SELECT tag.id, text, count(tag.id) AS c " +
                        "         FROM tag " +
                        "                  JOIN phrase_tag pt ON tag.id = pt.tag_id " +
                        "         WHERE text LIKE CONCAT(LOWER(?), '%') " +
                        "         GROUP BY tag.id " +
                        "         ORDER BY count(tag.id) DESC) t1 " +
                        "UNION " +
                        "SELECT id, text " +
                        "FROM (" +
                        "         SELECT tag.id, text, count(tag.id) AS c " +
                        "         FROM tag " +
                        "                  JOIN phrase_tag pt ON tag.id = pt.tag_id " +
                        "         WHERE text LIKE CONCAT('%', LOWER(?), '%') " +
                        "         GROUP BY tag.id " +
                        "         ORDER BY count(tag.id) DESC) t2;"
                , new TagRespRowMapper(), partTag, partTag);

    }
}
