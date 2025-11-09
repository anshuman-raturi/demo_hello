
package com.cg.film.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
 
@Controller
public class SessionController1 {
 
    // Page to display all categories
    @GetMapping("/categories")
    public String categoriesPage() {
        return "categories"; // maps to categories.html in templates folder
    }
 
    // Page to display films for selected category
    @GetMapping("/filmsbyCategory")
    public String filmsByCategoryPage() {
        return "filmsbyCategory"; // maps to filmsbyCategory.html in templates folder
    }
}