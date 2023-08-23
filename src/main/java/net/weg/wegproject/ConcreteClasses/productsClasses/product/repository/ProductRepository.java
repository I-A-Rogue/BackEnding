package net.weg.wegproject.ConcreteClasses.productsClasses.product.repository;

import net.weg.wegproject.enums.CategoriesEnums;
import net.weg.wegproject.ConcreteClasses.productsClasses.product.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllByCategories(Pageable pageable, CategoriesEnums categories);

    @Query(value = "SELECT *, MATCH(video.titulo) AGAINST(CONCAT('*', :searchTerm, '*') IN BOOLEAN MODE) * 3000 +" +
            " (SELECT MAX(MATCH(categoria.categoria_string) AGAINST(CONCAT('*', :searchTerm, '*') IN BOOLEAN MODE) * 2000)" +
            " FROM categoria WHERE video.categoria_id = categoria.id) +" +
            " (SELECT MAX(MATCH(tag.tag) AGAINST(CONCAT('*', :searchTerm, '*') IN BOOLEAN MODE) * 1000) " +
            "FROM tag, video_tags WHERE video_tags.tags_tag = tag.tag and video_tags.video_uuid = video.uuid) + (video.pontuacao * 4)" +
            " TotalScore FROM video GROUP BY video.titulo;",
            nativeQuery = true)
    List<Product> searchBy(String searchTerm);

    Page<Product> findAll(Pageable pageable);


}
