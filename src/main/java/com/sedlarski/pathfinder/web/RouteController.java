package com.sedlarski.pathfinder.web;

import com.sedlarski.pathfinder.model.binding.RouteCreateBM;
import com.sedlarski.pathfinder.model.service.RouteServiceModel;
import com.sedlarski.pathfinder.service.RouteService;
import com.sedlarski.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public RouteController(RouteService routeService, UserService userService, ModelMapper modelMapper) {
        this.routeService = routeService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public RouteCreateBM routeCreateBM() {
        return new RouteCreateBM();
    }

    @GetMapping()
    public String allRoutes(Model model) {
        model.addAttribute("routes", routeService.findAllRoutesView());
        return "routes";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        model.addAttribute("route", routeService.findRouteById(id));
        return "route-details";
    }

    @GetMapping("/add")
    public String addGET() {
        if(!userService.isLogged()) {
            return "redirect:/users/login";
        }
        return "add-route";
    }

    @PostMapping("/add")
    public String addPOST(@Valid RouteCreateBM routeCreateBM, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("routeCreateBM", routeCreateBM);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.routeCreateBM", bindingResult);
        }
        RouteServiceModel routeServiceModel = modelMapper.map(routeCreateBM, RouteServiceModel.class);
        routeServiceModel.setGpxCoordinates(new String(routeCreateBM.getGpxCoordinates().getBytes()));
        routeService.addNewRoute(routeServiceModel);
        return "redirect:/";
    }
}
