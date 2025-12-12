package dev.lucas.serieflix.repository;

import dev.lucas.serieflix.model.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamingRepository extends JpaRepository<Streaming,Long> {
}
