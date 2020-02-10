package com.chesterjerrat.namechecker.dao.impl;

import com.chesterjerrat.namechecker.dao.OpinionRepoExtension;
import com.chesterjerrat.namechecker.models.entity.Opinion;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class OpinionRepoExtensionImpl implements OpinionRepoExtension {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public List<Opinion> getAllOpinionsByName(String name) {
        Query findQuery = em.createNativeQuery("SELECT * FROM opinions WHERE name = :name", Opinion.class);

        findQuery.setParameter("name", name);

        List<Opinion> opinionList = findQuery.getResultList();

        return opinionList;
    }
}
