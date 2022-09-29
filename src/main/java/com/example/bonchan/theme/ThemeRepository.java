package com.example.bonchan.theme;

import com.example.bonchan.theme.models.Theme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ThemeRepository extends CrudRepository<Theme, Long> {
    Iterable<Theme> findByTopicId(Long topicId);
}