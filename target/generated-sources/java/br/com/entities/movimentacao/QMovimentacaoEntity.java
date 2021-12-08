package br.com.entities.movimentacao;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMovimentacaoEntity is a Querydsl query type for MovimentacaoEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMovimentacaoEntity extends EntityPathBase<MovimentacaoEntity> {

    private static final long serialVersionUID = -2105100753L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMovimentacaoEntity movimentacaoEntity = new QMovimentacaoEntity("movimentacaoEntity");

    public final DateTimePath<java.time.LocalDateTime> dataMovimentacao = createDateTime("dataMovimentacao", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final br.com.entities.pessoa.QPessoaEntity pessoa;

    public final EnumPath<TipoMovimentacao> tipoMovimentacao = createEnum("tipoMovimentacao", TipoMovimentacao.class);

    public final NumberPath<java.math.BigDecimal> valor = createNumber("valor", java.math.BigDecimal.class);

    public QMovimentacaoEntity(String variable) {
        this(MovimentacaoEntity.class, forVariable(variable), INITS);
    }

    public QMovimentacaoEntity(Path<? extends MovimentacaoEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMovimentacaoEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMovimentacaoEntity(PathMetadata metadata, PathInits inits) {
        this(MovimentacaoEntity.class, metadata, inits);
    }

    public QMovimentacaoEntity(Class<? extends MovimentacaoEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.pessoa = inits.isInitialized("pessoa") ? new br.com.entities.pessoa.QPessoaEntity(forProperty("pessoa")) : null;
    }

}

