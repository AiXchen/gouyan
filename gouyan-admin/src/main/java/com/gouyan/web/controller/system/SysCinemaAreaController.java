package com.gouyan.web.controller.system;

import com.gouyan.common.response.ResponseResult;
import com.gouyan.system.domin.SysCinemaArea;
import com.gouyan.system.service.SysCinemaAreaService;
import com.gouyan.system.service.impl.SysCinemaAreaServiceImpl;
import com.gouyan.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Aixchen
 * @date 2024/1/22 14:08
 */
@RestController
public class SysCinemaAreaController extends BaseController {

    @Autowired
    private SysCinemaAreaService sysCinemaAreaService;

    @GetMapping("/sysCinemaArea")
    public ResponseResult findAll(){
        startPage();
        List<SysCinemaArea> data = sysCinemaAreaService.findAll();
        return getResult(data);
    }

    @GetMapping("/sysCinemaArea/{id}")
    public ResponseResult findById(@PathVariable Long id){
        return getResult(sysCinemaAreaService.findById(id));
    }

    @PostMapping("/sysCinemaArea")
    public ResponseResult add(@Validated @RequestBody SysCinemaArea sysCinemaArea){
        return getResult(sysCinemaAreaService.add(sysCinemaArea));
    }

    @PutMapping("/sysCinemaArea")
    public ResponseResult update(@Validated @RequestBody SysCinemaArea sysCinemaArea){
        return getResult(sysCinemaAreaService.update(sysCinemaArea));
    }

    @DeleteMapping("/sysCinemaArea/{ids}")
    public ResponseResult delete(@PathVariable Long[] ids){
        return getResult(sysCinemaAreaService.delete(ids));
    }

}
