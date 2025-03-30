package com.webscraping;

import com.webscraping.model.Model;
import com.webscraping.view.View;
import com.webscraping.controller.Controller;;

public class App {

    public static void main(String[] args) {

        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.execute();

    }

}