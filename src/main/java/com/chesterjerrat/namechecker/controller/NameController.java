package com.chesterjerrat.namechecker.controller;

import com.chesterjerrat.namechecker.models.dto.AddName;
import com.chesterjerrat.namechecker.models.dto.CommonResponseObject;
import com.chesterjerrat.namechecker.models.entity.Name;
import com.chesterjerrat.namechecker.resource.NameResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("api/names")
public class NameController {

    @Autowired
    private NameResource nameResource;

    @RequestMapping(value="", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<CommonResponseObject> addName(@RequestBody AddName addName) {
        CommonResponseObject response = nameResource.addName(addName);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @RequestMapping(value="", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public ResponseEntity<List<Name>> getNames() {
        List<Name> nameList = nameResource.getNames();
        return new ResponseEntity<>(nameList, HttpStatus.OK);
    }
}
