package com.example;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.CursoredPage;
import io.micronaut.data.model.CursoredPageable;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.GenericRepository;
import io.micronaut.data.repository.jpa.criteria.PredicateSpecification;

@JdbcRepository(dialect = Dialect.H2, dataSource = "default")
public interface ExampleEntityRepository extends GenericRepository<ExampleEntity, Integer> {
    void save(ExampleEntity entity);
    Page<ExampleEntity> findAll(PredicateSpecification<ExampleEntity> predicateSpecification, Pageable pageable);
    CursoredPage<ExampleEntity> findAll(PredicateSpecification<ExampleEntity> predicateSpecification, CursoredPageable cursoredPageable);
}