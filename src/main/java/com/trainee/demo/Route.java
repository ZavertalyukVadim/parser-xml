package com.trainee.demo;

public class Route {
    private String route;

    public Route(String route) {
        this.route = route;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "/"+route;
    }
}
