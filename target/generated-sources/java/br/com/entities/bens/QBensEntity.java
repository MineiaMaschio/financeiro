package br.com.entities.bens;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBensEntity is a Querydsl query type for BensEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBensEntity extends EntityPathBase<BensEntity> {

    private static final long serialVersionUID = -538175409L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBensEntity bensEntity = new QBensEntity("bensEntity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final br.com.entities.pessoa.QPessoaEntity pessoa;

    public final EnumPath<TipoBens> tipoBens = createEnum("tipoBens", TipoBens.class);

    public final NumberPath<java.math.BigDecimal> valor = createNumber("valor", java.math.BigDecimal.class);

    public QBensEntity(String variable) {
        this(BensEntity.class, forVariable(variable), INITS);
    }

    public QBensEntity(Path<? extends BensEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBensEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBensEntity(PathMetadata metadata, PathInits inits) {
        this(BensEntity.class, metadata, inits);
    }

    public QBensEntity(Class<? extends BensEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.pessoa = inits.isInitialized("pessoa") ? new br.com.entities.pessoa.QPessoaEntity(forProperty("pessoa")) : null;
    }

}

