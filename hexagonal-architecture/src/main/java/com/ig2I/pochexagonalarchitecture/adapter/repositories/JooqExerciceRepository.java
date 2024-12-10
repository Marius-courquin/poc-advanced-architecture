package com.ig2I.pochexagonalarchitecture.adapter.repositories;

import com.ig2I.pochexagonalarchitecture.domain.exercices.Exercice;
import com.ig2I.pochexagonalarchitecture.domain.exercices.ExerciceRepository;
import com.ig2I.pochexagonalarchitecture.domain.exercices.ExerciceStatus;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

import static com.ig2I.generated.jooq.Tables.EXERCICES;


@Repository
public class JooqExerciceRepository implements ExerciceRepository {

    private final DSLContext dsl;

    public JooqExerciceRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public Exercice getExerciceById(String id) {
        return dsl.selectFrom(EXERCICES)
                .where(EXERCICES.NAME.eq(id))
                .fetchOptional()
                .map(record -> new Exercice(
                        record.get(EXERCICES.ID),
                        record.get(EXERCICES.NAME),
                        record.get(EXERCICES.DESCRIPTION),
                        record.get(EXERCICES.TYPE),
                        record.get(EXERCICES.DIFFICULTY),
                        ExerciceStatus.valueOf(record.get(EXERCICES.STATUS))
                ))
                .orElseThrow(() -> new NoSuchElementException("No exercice found with id: " + id));
    }

    @Override
    public Exercice updateExercice(Exercice exercice) {
        dsl.update(EXERCICES)
                .set(EXERCICES.ID, exercice.getId())
                .set(EXERCICES.DESCRIPTION, exercice.getDescription())
                .set(EXERCICES.TYPE, exercice.getType())
                .set(EXERCICES.DIFFICULTY, exercice.getDifficulty())
                .set(EXERCICES.STATUS, exercice.getStatus().name())
                .where(EXERCICES.NAME.eq(exercice.getName()))
                .execute();

        return exercice;
    }
}
