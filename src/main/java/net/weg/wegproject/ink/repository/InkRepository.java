package net.weg.wegproject.ink.repository;

import net.weg.wegproject.ink.model.Ink;
import net.weg.wegproject.product.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InkRepository extends JpaRepository<Ink, Long> {
}
