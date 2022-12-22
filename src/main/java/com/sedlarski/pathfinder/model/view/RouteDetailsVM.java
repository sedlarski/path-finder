package com.sedlarski.pathfinder.model.view;

import com.sedlarski.pathfinder.model.entity.Picture;
import com.sedlarski.pathfinder.model.entity.enums.UserLevelEnum;

import java.util.Set;

public class RouteDetailsVM {
    private String gpxCoordinates;
    private String description;
    private UserLevelEnum level;
    private String name;
    private String videoUrl;
    private Set<Picture> pictures;

    public RouteDetailsVM() {
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserLevelEnum getLevel() {
        return level;
    }

    public void setLevel(UserLevelEnum level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }
}
