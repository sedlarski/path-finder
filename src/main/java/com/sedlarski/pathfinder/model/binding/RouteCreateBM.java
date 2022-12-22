package com.sedlarski.pathfinder.model.binding;

import com.sedlarski.pathfinder.model.entity.enums.CategoryNameEnum;
import com.sedlarski.pathfinder.model.entity.enums.UserLevelEnum;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public class RouteCreateBM {

    private String name;
    private String description;
    private MultipartFile gpxCoordinates;
    private UserLevelEnum level;
    private String videoUrl;
    private Set<CategoryNameEnum> categories;

    public RouteCreateBM() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(MultipartFile gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public UserLevelEnum getLevel() {
        return level;
    }

    public void setLevel(UserLevelEnum level) {
        this.level = level;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Set<CategoryNameEnum> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryNameEnum> categories) {
        this.categories = categories;
    }
}
