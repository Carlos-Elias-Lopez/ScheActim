package com.example.scheactim.modelos;

public class ActividadesEntry {
    private long id;
    private String title;
    private String description;
    private String createdINI;

    public ActividadesEntry(long id, String title, String description, String createdINI) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdINI = createdINI;
    }

    public ActividadesEntry(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String createdINI() {
        return createdINI;
    }

    public void createdINI(String createdINI) {
        this.createdINI = createdINI;
    }

}
