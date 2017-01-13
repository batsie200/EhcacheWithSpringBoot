package com.sample.jsr107;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author WS
 */

@RestController
public class PersonController
{
    @Autowired PersonService personService;

    @RequestMapping("/person/{id}")
    public @ResponseBody String getPerson(@PathVariable("id") int id)
    {
        return personService.getPerson(id).toString();
    }
}
