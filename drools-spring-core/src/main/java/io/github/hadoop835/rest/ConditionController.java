package io.github.hadoop835.rest;

import io.github.hadoop835.dto.ConditionDto;
import io.github.hadoop835.service.ConditionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@RestController
@RequestMapping(value = "/v1")
public class ConditionController {

    @Resource
    private ConditionService conditionService;


   @PostMapping(value = "/create/condition")
    public   String  createCondition(@RequestBody List<ConditionDto> conditionDtos){
        conditionService.createCondition(conditionDtos);
        return "SUCEESS";
    }


    /**
     * 规则查询条件
     * @param rulesId
     * @return
     */
    @GetMapping(value = "/get/condition/{rulesId}")
   public List<ConditionDto> getCondition(@PathVariable Long rulesId){
        return conditionService.getConditionByRulesId(rulesId);
    }

}
