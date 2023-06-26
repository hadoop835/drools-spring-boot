package io.github.hadoop835.rest;

import com.google.common.collect.Lists;
import io.github.hadoop835.dto.FieldDto;
import io.github.hadoop835.service.FieldService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@RestController
@RequestMapping(value = "/v1")
public class FieldController {
    @Resource
    private FieldService fieldService;


    @PostMapping(value = "/createField")
    public  String  createField(@RequestBody FieldDto fieldDto){
        fieldService.createField(Lists.newArrayList(fieldDto));
      return "SUCCESS";
    }

}
