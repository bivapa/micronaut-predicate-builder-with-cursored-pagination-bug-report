package example;

import io.micronaut.data.model.CursoredPageable;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.model.Sort;
import io.micronaut.data.repository.jpa.criteria.PredicateSpecification;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.example.ExampleEntity;
import com.example.ExampleEntityRepository;

import org.junit.jupiter.api.BeforeAll;

import jakarta.inject.Inject;

@MicronautTest
@TestInstance(Lifecycle.PER_CLASS)
class PredicateSpecificationWithPageableTest {
    @Inject
    ExampleEntityRepository repository;

    @BeforeAll
    void createEntity() {
        repository.save(new ExampleEntity(1));
    }

    @Test
    void predicateSpecificationWorksWithOffsetPagination() {
        repository.findAll(PredicateSpecification.where((root, cb) -> cb.equal(root.get("id"), 1)), Pageable.from(Sort.UNSORTED));
    }

    @Test
    void predicateSpecificationWorksWithCursoredPagination() {
        repository.findAll(PredicateSpecification.where((root, cb) -> cb.equal(root.get("id"), 1)), CursoredPageable.from(Sort.UNSORTED));
    }
}
