package tcs.tpi.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tcs.tpi.model.Movie;
import tcs.tpi.repository.MovieRepository;

import static tcs.tpi.controller.Constants.*;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository repository;

    @PostMapping
    public String saveMovie(@ModelAttribute Movie movie, RedirectAttributes redirect) {
        log.info("Saving movie {}", movie.getTitle());
        repository.save(movie);
        redirect.addFlashAttribute(SUCCESS, "Película Registrada!");
        return "redirect:/movies";
    }

    @PostMapping("/{id}")
    public String editMovie(@PathVariable Long id,
                            @ModelAttribute Movie movie,
                            RedirectAttributes redirect)
    {
        repository.findById(id)
                .ifPresentOrElse(
                        m -> {
                            repository.save(m.toBuilder()
                                    .title(movie.getTitle())
                                    .genre(movie.getGenre())
                                    .director(movie.getDirector())
                                    .description(movie.getDescription())
                                    .premiere(movie.getPremiere())
                                    .build());
                            redirect.addFlashAttribute(SUCCESS, "Película Actualizada!");
                        },
                        () -> redirect.addFlashAttribute(ERROR, "No se encontró la Película."));
        return "redirect:/movies";
    }
}
