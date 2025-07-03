package com.OrderProcess.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBasedEntity is a Querydsl query type for BasedEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QBasedEntity extends EntityPathBase<BasedEntity> {

    private static final long serialVersionUID = 1940400463L;

    public static final QBasedEntity basedEntity = new QBasedEntity("basedEntity");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QBasedEntity(String variable) {
        super(BasedEntity.class, forVariable(variable));
    }

    public QBasedEntity(Path<? extends BasedEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBasedEntity(PathMetadata metadata) {
        super(BasedEntity.class, metadata);
    }

}

