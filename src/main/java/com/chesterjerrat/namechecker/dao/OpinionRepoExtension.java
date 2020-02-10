package com.chesterjerrat.namechecker.dao;

import com.chesterjerrat.namechecker.models.entity.Opinion;

import java.util.List;

public interface OpinionRepoExtension {

    List<Opinion> getAllOpinionsByName(String name);

}
