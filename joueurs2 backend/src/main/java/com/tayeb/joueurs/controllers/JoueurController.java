package com.tayeb.joueurs.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.tayeb.joueurs.entities.Equipe;
import com.tayeb.joueurs.entities.Joueur;
import com.tayeb.joueurs.service.JoueurService;

import jakarta.validation.Valid;

@Controller
public class JoueurController {

    @Autowired
    JoueurService joueurService;

    @RequestMapping("/ListJoueurs")
    public String listeJoueurs(ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "3") int size) {
        Page<Joueur> jous = joueurService.getAllJoueursParPage(page, size);
        modelMap.addAttribute("Joueurs", jous);
        modelMap.addAttribute("pages", new int[jous.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listJoueurs";
    }

    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap) {
        List<Equipe> equipes = joueurService.getAllEquipes();
        modelMap.addAttribute("joueur", new Joueur());
        modelMap.addAttribute("mode", "new");
        modelMap.addAttribute("equipes", equipes);
        return "formJoueur";
    }

    @RequestMapping("/saveJoueur")
    public String saveJoueur(@Valid Joueur joueur, BindingResult bindingResult,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "3") int size,
            ModelMap modelMap) {
        int currentPage;
        boolean isNew = false;
        if (bindingResult.hasErrors()) {
            List<Equipe> equipes = joueurService.getAllEquipes();
            modelMap.addAttribute("equipes", equipes);
            modelMap.addAttribute("mode", joueur.getIdJoueur() == null ? "new" : "edit");
            return "formJoueur";
        }
        if (joueur.getIdJoueur() == null) isNew = true;
        joueurService.saveJoueur(joueur);
        if (isNew) {
            Page<Joueur> jous = joueurService.getAllJoueursParPage(page, size);
            currentPage = jous.getTotalPages() - 1;
        } else {
            currentPage = page;
        }
        return "redirect:/ListJoueurs?page=" + currentPage + "&size=" + size;
    }

    @RequestMapping("/supprimerJoueur")
    public String supprimerJoueur(@RequestParam("id") Long id, ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "3") int size) {
        joueurService.deleteJoueurById(id);
        Page<Joueur> jous = joueurService.getAllJoueursParPage(page, size);
        modelMap.addAttribute("Joueurs", jous);
        modelMap.addAttribute("pages", new int[jous.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listJoueurs";
    }

    @RequestMapping("/modifierJoueur")
    public String editerJoueur(@RequestParam("id") Long id,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "3") int size,
            ModelMap modelMap) {
        Joueur j = joueurService.getJoueur(id);
        List<Equipe> equipes = joueurService.getAllEquipes();
        modelMap.addAttribute("joueur", j);
        modelMap.addAttribute("mode", "edit");
        modelMap.addAttribute("equipes", equipes);
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("size", size);
        return "formJoueur";
    }

    @RequestMapping("/updateJoueur")
    public String updateJoueur(@ModelAttribute("Joueur") Joueur joueur,
            @RequestParam("date") String date, ModelMap modelMap) throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        joueur.setDateTransfert(dateformat.parse(date));
        joueurService.updateJoueur(joueur);
        Page<Joueur> jous = joueurService.getAllJoueursParPage(0, 3);
        modelMap.addAttribute("Joueurs", jous);
        modelMap.addAttribute("pages", new int[jous.getTotalPages()]);
        modelMap.addAttribute("currentPage", 0);
        modelMap.addAttribute("size", 3);
        return "listJoueurs";
    }
    @GetMapping(value = "/")
    public String welcome() {
        return "index";
    }
}