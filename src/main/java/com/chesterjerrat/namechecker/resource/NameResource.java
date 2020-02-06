package com.chesterjerrat.namechecker.resource;
import com.chesterjerrat.namechecker.dao.NameRepo;
import com.chesterjerrat.namechecker.models.dto.AddName;
import com.chesterjerrat.namechecker.models.dto.CommonResponseObject;
import com.chesterjerrat.namechecker.models.entity.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class NameResource {

    @Autowired
    private NameRepo nameRepo;

    public CommonResponseObject addName(AddName addName) {
        Name name = new Name(addName);
        nameRepo.save(name);
        return new CommonResponseObject("Name was saved successfully", "success", name.getName());
    }

    public List<Name> getNames() {
        List<Name> nameList = (List<Name>) nameRepo.findAll();
        return nameList;
    }

    public Name getName(String searchName) {
        Optional<Name> name = nameRepo.findById(searchName);

        if(name.isPresent()) {
            return name.get();
        } else {
            return null;
        }
    }
}
