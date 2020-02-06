package com.chesterjerrat.namechecker.controller;
import com.chesterjerrat.namechecker.models.dto.AddName;
import com.chesterjerrat.namechecker.models.dto.CommonResponseObject;
import com.chesterjerrat.namechecker.models.entity.Name;
import com.chesterjerrat.namechecker.resource.NameResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value="{name}", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Name> getSingleName(@PathVariable(value = "name") String searchName) {
        Name name = nameResource.getName(searchName);
        if (name == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(name, HttpStatus.OK);
        }
    }
}
