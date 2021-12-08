package br.com.entities.divida;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDividaEntity is a Querydsl query type for DividaEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDividaEntity extends EntityPathBase<DividaEntity> {

    private static final long serialVersionUID = 645307183L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDividaEntity dividaEntity = new QDividaEntity("dividaEntity");

    public final br.com.entities.empresa.QEmpresaEntity empresa;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath pago = createBoolean("pago");

    public final br.com.entities.pessoa.QPessoaEntity pessoa;

    public final NumberPath<java.math.BigDecimal> valor = createNumber("valor", java.math.BigDecimal.class);

    public QDividaEntity(String variable) {
        this(DividaEntity.class, forVariable(variable), INITS);
    }

    public QDividaEntity(Path<? extends DividaEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDividaEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDividaEntity(PathMetadata metadata, PathInits inits) {
        this(DividaEntity.class, metadata, inits);
    }

    public QDividaEntity(Class<? extends DividaEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.empresa = inits.isInitialized("empresa") ? new br.com.entities.empresa.QEmpresaEntity(forProperty("empresa")) : null;
        this.pessoa = inits.isInitialized("pessoa") ? new br.com.entities.pessoa.QPessoaEntity(forProperty("pessoa")) : null;
    }

}

