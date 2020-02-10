package com.chesterjerrat.namechecker.controller;

import com.chesterjerrat.namechecker.models.dto.AddOpinion;
import com.chesterjerrat.namechecker.models.dto.CommonResponseObject;
import com.chesterjerrat.namechecker.models.entity.Opinion;
import com.chesterjerrat.namechecker.resource.OpinionResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/api")
public class OpinionController {

    @Autowired
    private OpinionResource opinionResource;

    @RequestMapping(value = "/names/{name}/opinions", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public ResponseEntity<List<Opinion>> getAllOpinionsForName(@PathVariable(value = "name") String name) {
        List<Opinion> opinionList = opinionResource.getAllOpinionsForName(name);
        return new ResponseEntity<>(opinionList, HttpStatus.OK);
    }


    @RequestMapping(value = "/names/{name}/opinions", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<CommonResponseObject> createOpinion(@PathVariable(value = "name") String name, @RequestBody AddOpinion addOpinion) {
        Opinion newOpinion = new Opinion(name, addOpinion);

        CommonResponseObject responseObject = opinionResource.createOpinion(newOpinion);

        return new ResponseEntity<>(responseObject, HttpStatus.CREATED);
    }
}
