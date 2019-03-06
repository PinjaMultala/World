package fi.academy.ekajpaharjoitus;


import fi.academy.ekajpaharjoitus.entities.Country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
@ComponentScan
@Controller
public class MaailmaController {

    @Autowired
    private MaailmaRepository repo;
    private Country data;


    public MaailmaController(MaailmaRepository repo) {
        this.repo = repo;


    } //MAA-HAKUTOIMINTO

    @GetMapping("/maat")
    public String maalistaus(Model model) {
        model.addAttribute("lomakeOlio", new Country());  //luodaan lomakeolio
        Iterable<Country> maat = repo.findAll();
        model.addAttribute("maat", maat);
        return "maalistaus";
    }


    @PostMapping("/maatName")
    public String lomakekasittelija(@ModelAttribute Country country, Model model) {  // toiminto lukee haun ja lähettää sen hakutulolseen.
        Iterable<Country> maaHaku = repo.findCountryByNameContains(country.getName());
        model.addAttribute("maaHaku", maaHaku);
        return "hakutulos";
    }

    //LISÄÄ MAA

    @PostMapping("/uusimaa")
    public String luoUusiMaa(@ModelAttribute Country maa, Model model) {
        repo.save(maa);

        return "redirect:/maalistaus";

    }

    @DeleteMapping("/delete")
    public String postaMaa(@PathVariable Country maa, Model model) {
        repo.delete(maa);
        return "redirect:/maalistaus";

    }
}




