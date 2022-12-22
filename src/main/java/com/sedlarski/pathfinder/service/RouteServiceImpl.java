package com.sedlarski.pathfinder.service;

import com.sedlarski.pathfinder.model.entity.Route;
import com.sedlarski.pathfinder.model.service.RouteServiceModel;
import com.sedlarski.pathfinder.model.view.RouteDetailsVM;
import com.sedlarski.pathfinder.model.view.RouteVM;
import com.sedlarski.pathfinder.repository.RouteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper, UserService userService, CategoryService categoryService) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public List<RouteVM> findAllRoutesView() {
        return routeRepository.findAll()
                .stream()
                .map(r -> {
                    RouteVM routeVM = modelMapper.map(r, RouteVM.class);
                    if(r.getPictures().isEmpty()) {
                        routeVM.setPictureUrl("/images/pic4.jpg");
                    } else {
                        routeVM.setPictureUrl(r.getPictures().stream().findFirst().get().getUrl());
                    }
                    return routeVM;
                }).collect(Collectors.toList());

    }

    @Override
    public void addNewRoute(RouteServiceModel routeServiceModel) {
        Route route = modelMapper.map(routeServiceModel, Route.class);
        route.setAuthor(userService.findUserEntity());
        route.setCategories(routeServiceModel
                .getCategories()
                .stream()
                .map(c -> categoryService.findCategoryByName(c))
                .collect(Collectors.toSet()));
        routeRepository.save(route);
    }

    @Override
    public RouteDetailsVM findRouteById(Long id) {
        return routeRepository.findById(id)
                .map(route -> modelMapper.map(route, RouteDetailsVM.class))
                .orElse(null);
    }
}
