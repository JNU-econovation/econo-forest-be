package com.example.econoforestbe.infra.eatTogather;

import com.example.econoforestbe.domain.eatToagther.*;
import lombok.RequiredArgsConstructor;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaEatTogatherRepository implements EatTogatherRepository {

    private final String WARM = "[ERROR]";
    private final String WARM_NO_EXISTING_RESULT = WARM + " no existing result!";

    private final EntityManager em;

    @Override
    public Long save(EatTogather eatTogather) {
        if (eatTogather.getId() == null) {
            em.persist(eatTogather);
        }
        em.merge(eatTogather);
        return eatTogather.getId();
    }

    @Override
    public EatTogather findById(Long id) {
        Optional<EatTogather> eatTogather = Optional.of(em.find(EatTogather.class, id));
        if (!eatTogather.isPresent()) {
            throw new NoSuchElementException(WARM_NO_EXISTING_RESULT);
        }
        return eatTogather.get();
    }

    @Override
    public EatTogather findByLocation(Specification<EatTogather> spec) {
        TypedQuery<EatTogather> query = makeQuery(spec);
        return query.getSingleResult();
    }

    @Override
    public List<EatTogather> findAllByLocation(Specification<EatTogather> spec) {
        TypedQuery<EatTogather> query = makeQuery(spec);
        return query.getResultList();
    }

    @Override
    public EatTogather findByDate(Specification<EatTogather> spec) {
        TypedQuery<EatTogather> query = makeQuery(spec);
        return query.getSingleResult();
    }

    @Override
    public List<EatTogather> findAllByDate(Specification<EatTogather> spec) {
        TypedQuery<EatTogather> query = makeQuery(spec);
        return query.getResultList();
    }

    @Override
    public EatTogather findBySpec(Specification<EatTogather> spec) {
        TypedQuery<EatTogather> query = makeQuery(spec);
        return query.getSingleResult();
    }

    @Override
    public List<EatTogather> findAllBySpec(Specification<EatTogather> spec) {
        TypedQuery<EatTogather> query = makeQuery(spec);
        return query.getResultList();
    }

    private TypedQuery<EatTogather> makeQuery(Specification<EatTogather> spec) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<EatTogather> criteriaQuery = cb.createQuery(EatTogather.class);
        Root<EatTogather> root = criteriaQuery.from(EatTogather.class);
        Predicate predicate = spec.toPredicate(root, criteriaQuery, cb);
        criteriaQuery.where(predicate);
        TypedQuery<EatTogather> query = em.createQuery(criteriaQuery);
        return query;
    }

    @Override
    public Boolean remove(Long id) {
        EatTogather toBeRemoved = findById(id);
        if (toBeRemoved == null) {
            throw new NoSuchElementException(WARM_NO_EXISTING_RESULT);
        }
        em.remove(toBeRemoved);
        return true;
    }

}