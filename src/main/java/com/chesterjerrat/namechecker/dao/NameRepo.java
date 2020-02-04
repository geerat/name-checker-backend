package com.chesterjerrat.namechecker.dao;

import com.chesterjerrat.namechecker.models.entity.Name;
import org.springframework.data.repository.CrudRepository;

public interface NameRepo extends CrudRepository<Name, String> {
}
