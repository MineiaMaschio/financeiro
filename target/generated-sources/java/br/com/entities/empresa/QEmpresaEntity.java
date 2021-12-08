package br.com.entities.empresa;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEmpresaEntity is a Querydsl query type for EmpresaEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEmpresaEntity extends EntityPathBase<EmpresaEntity> {

    private static final long serialVersionUID = 1788114693L;

    public static final QEmpresaEntity empresaEntity = new QEmpresaEntity("empresaEntity");

    public final StringPath cnpj = createString("cnpj");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nome = createString("nome");

    public final StringPath telefone = createString("telefone");

    public QEmpresaEntity(String variable) {
        super(EmpresaEntity.class, forVariable(variable));
    }

    public QEmpresaEntity(Path<? extends EmpresaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmpresaEntity(PathMetadata metadata) {
        super(EmpresaEntity.class, metadata);
    }

}

