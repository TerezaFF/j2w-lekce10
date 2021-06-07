package cz.czechitas.java2webapps.lekce10.controller;

import cz.czechitas.java2webapps.lekce10.entity.Student;
import cz.czechitas.java2webapps.lekce10.service.SkolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class SkolaController {

    private final SkolaService service;

    @Autowired
    public SkolaController(SkolaService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView seznam() {
        return new ModelAndView("seznam").addObject("seznam", service.findAll());
    }

    @GetMapping(path = "/trida/{nazev}")
    public ModelAndView trida(@PathVariable String nazev) {
        return new ModelAndView("trida")
                .addObject("trida", service.findByNazev(nazev))
                .addObject("studenti", service.findStudenti(nazev))
                .addObject("ucitel", service.findUcitel(nazev));
    }

    @GetMapping(path = "/trida/student/{id}")
    public ModelAndView student(@PathVariable Integer id) {
        Student student = service.findById(id).get();
        return new ModelAndView("student")
                .addObject("student", student)
                .addObject("rodice", student.getRodice())
                .addObject("trida", student.getTrida());
    }
}
