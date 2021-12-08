package br.com.entities.consultaCpf;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QConsultaCpfEntity is a Querydsl query type for ConsultaCpfEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QConsultaCpfEntity extends EntityPathBase<ConsultaCpfEntity> {

    private static final long serialVersionUID = -1497898949L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QConsultaCpfEntity consultaCpfEntity = new QConsultaCpfEntity("consultaCpfEntity");

    public final DateTimePath<java.time.LocalDateTime> dataConsulta = createDateTime("dataConsulta", java.time.LocalDateTime.class);

    public final br.com.entities.empresa.QEmpresaEntity empresa;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final br.com.entities.pessoa.QPessoaEntity pessoa;

    public QConsultaCpfEntity(String variable) {
        this(ConsultaCpfEntity.class, forVariable(variable), INITS);
    }

    public QConsultaCpfEntity(Path<? extends ConsultaCpfEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QConsultaCpfEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QConsultaCpfEntity(PathMetadata metadata, PathInits inits) {
        this(ConsultaCpfEntity.class, metadata, inits);
    }

    public QConsultaCpfEntity(Class<? extends ConsultaCpfEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.empresa = inits.isInitialized("empresa") ? new br.com.entities.empresa.QEmpresaEntity(forProperty("empresa")) : null;
        this.pessoa = inits.isInitialized("pessoa") ? new br.com.entities.pessoa.QPessoaEntity(forProperty("pessoa")) : null;
    }

}

