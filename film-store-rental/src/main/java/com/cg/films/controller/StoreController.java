package com.cg.films.controller;
 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cg.films.service.StoreService;
 
 
@RestController
@RequestMapping("/store")
public class StoreController {
 
    @Autowired
    private StoreService storeService;

 
    @GetMapping("/managers")
    public List<Long> getAllManagerIds() {
        return storeService.getAllManagerIds();
    }
 
 
}