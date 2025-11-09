package com.cg.film.model;

public class ActorDTO {
    private Long actorId;
    private String fullName;

    public ActorDTO() {}

    public ActorDTO(Long actorId, String fullName) {
        this.actorId = actorId;
        this.fullName = fullName;
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
