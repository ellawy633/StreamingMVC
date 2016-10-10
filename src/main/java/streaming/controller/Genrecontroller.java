/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import streaming.entity.Genre;
import streaming.service.GenreCrudService;

/**
 *
 * @author admin
 */
@Controller
public class Genrecontroller {

    @Autowired
    private GenreCrudService service;
    
    
    @RequestMapping(value = "/ajouter_genre",method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("nouvGenre", new Genre());
       
        return "ajouter_genre.jsp";
    }
            

    @RequestMapping(value = "/modifier_genre", method = RequestMethod.POST)
    public String modifierPOST(@ModelAttribute("genreAct") Genre genre) {
        service.save(genre);
        return "modifier_genre.jsp";
    }

    @RequestMapping(value = "/modifier_genre/{idGenre}", method = RequestMethod.GET)
    public String modifier(@PathVariable("idGenre") long id, Model model) {
        //recup genre
        Genre genre = service.findOne(id);
        //prep l'attribu a destination jsp
        model.addAttribute("genreAct", genre);
        return "modifier_genre.jsp";

    }

    @RequestMapping(value = "/supprimer_genre/{val}", method = RequestMethod.GET)

    public String supprimer(@PathVariable("val") long idGenreASupprimer) {
        service.delete(idGenreASupprimer);
        return "redirect:/list_genres";
    }

    @RequestMapping(value = {"/genre_liste", "/"}, method = RequestMethod.GET)
    public String list(Model m) {
        m.addAttribute("titre", "liste de genre");
        m.addAttribute("mesgenres", service.findAllByOrderByNomAsc());

        return "genre_list.jsp";
    }

}
