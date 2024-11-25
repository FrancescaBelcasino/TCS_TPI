package tcs.tpi.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tcs.tpi.model.Movie;
import tcs.tpi.repository.MovieRepository;

import static tcs.tpi.controller.Constants.*;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping
public class ViewController {
    private final MovieRepository repository;

    @GetMapping
    public String displayHome(Model model) {
        log.info("Displaying Home...");
        return "/home";
    }

    @GetMapping("/movies")
    public String getAllMovies(Model model) {
        log.info("Displaying Movies...");
        model.addAttribute("movies", repository.findAll());
        log.info(repository.findAll().toString());
        return "movies";
    }

    @GetMapping("/movies/register")
    public String displayRegisterMovieForm(Model model) {
        log.info("Displaying Movie Register Form...");
        model.addAttribute("movie", new Movie());
        return "register";
    }

    @GetMapping("/movies/{id}/update")
    public String displayUpdateMovieForm(@PathVariable Long id,
                                         Model model,
                                         RedirectAttributes redirect)
    {
        log.info("Displaying Movie Update Form...");
        return repository.findById(id)
                .map(m -> model.addAttribute("movie", m))
                .map(m -> "update")
                .orElseGet(() -> {
                    redirect.addFlashAttribute(ERROR, "No se encontró la Película.");
                    return "redirect:/movies";
                });
    }

    @GetMapping("/movies/{id}/delete")
    public String deleteMovie(@PathVariable Long id, RedirectAttributes redirect) {
        repository.findById(id)
                .ifPresentOrElse(
                        m -> {
                            repository.delete(m);
                            redirect.addFlashAttribute(SUCCESS, "Película Eliminada!");
                        },
                        () -> redirect.addFlashAttribute(ERROR, NOT_FOUND_MESSAGE)
                );
        return "redirect:/movies";
    }

}
