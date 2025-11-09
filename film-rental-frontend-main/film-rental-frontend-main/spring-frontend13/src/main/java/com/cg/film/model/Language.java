package com.cg.film.model;

public class Language {
    private Long languageId;
    private String name;

    public Language() {
    }

    public Language(Long languageId, String name) {
        this.languageId = languageId;
        this.name = name;
    }

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}