package ru.job4j.ood.ocp;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    /*
     *
     * Нарушение принципа OCP в том, что для репозитория добавлена лишняя логика в зависимости от входящего класса,
     * при добавлении новых классов добавится еще больше не нужной логики.
     *
     * */
    private List<DomainEntity> storage = new ArrayList<>();

    public void add(DomainEntity entity) {
        if (entity.getClass() == UserEntity.class) {
            storage.add(entity);
        }
        if (entity.getClass() == RolesEntity.class) {
            entity = null;
            storage.add(entity);
        }
    }
}
