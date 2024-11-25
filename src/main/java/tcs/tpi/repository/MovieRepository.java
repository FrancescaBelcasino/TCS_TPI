package tcs.tpi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tcs.tpi.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
