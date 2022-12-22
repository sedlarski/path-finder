package com.sedlarski.pathfinder.service;

import com.sedlarski.pathfinder.model.service.RouteServiceModel;
import com.sedlarski.pathfinder.model.view.RouteDetailsVM;
import com.sedlarski.pathfinder.model.view.RouteVM;

import java.util.List;

public interface RouteService {

    List<RouteVM> findAllRoutesView();
    void addNewRoute(RouteServiceModel routeServiceModel);
    RouteDetailsVM findRouteById(Long id);
}
