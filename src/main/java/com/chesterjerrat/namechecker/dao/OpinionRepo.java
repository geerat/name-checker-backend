package com.chesterjerrat.namechecker.dao;

import com.chesterjerrat.namechecker.models.entity.Opinion;
import org.springframework.data.repository.CrudRepository;

public interface OpinionRepo extends CrudRepository<Opinion, String> {
}
