package com.chesterjerrat.namechecker.resource;

import com.chesterjerrat.namechecker.dao.OpinionRepo;
import com.chesterjerrat.namechecker.dao.OpinionRepoExtension;
import com.chesterjerrat.namechecker.dao.impl.OpinionRepoExtensionImpl;
import com.chesterjerrat.namechecker.models.dto.CommonResponseObject;
import com.chesterjerrat.namechecker.models.entity.Opinion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OpinionResource {

    @Autowired
    private OpinionRepoExtensionImpl opinionRepoExtension;

    @Autowired
    private OpinionRepo opinionRepo;

    public List<Opinion> getAllOpinionsForName(String name) {

        return opinionRepoExtension.getAllOpinionsByName(name);

    }

    public CommonResponseObject createOpinion(Opinion newOpinion) {
        opinionRepo.save(newOpinion);

        return new CommonResponseObject("New opinion added", "success", newOpinion.getUuid());
    }
}
