package bj.highfiveuniversity.book.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class BiblioController {

    @GetMapping
    public String welcom() {
        return "Bienvenu sur notre application de Gestion de Bibliothèque";
    }

}
