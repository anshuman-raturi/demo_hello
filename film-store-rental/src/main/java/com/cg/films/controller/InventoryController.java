package com.cg.films.controller;
 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import com.cg.films.service.InventoryService;
 
@RestController
@RequestMapping("/api/inventory")
@CrossOrigin("*")

public class InventoryController {
 
    private final InventoryService inventoryService;
 
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
 
    @GetMapping("/count")
    public ResponseEntity<Map<String, Object>> getInventoryCount(@RequestParam String title) {
        long count = inventoryService.getInventoryCountByTitle(title);
        Map<String, Object> response = new HashMap<>();
        response.put("title", title);
        response.put("dvdCount", count);
        return ResponseEntity.ok(response);
    }
}