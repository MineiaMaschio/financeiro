package br.com.entities.pessoa;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPessoaEntity is a Querydsl query type for PessoaEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPessoaEntity extends EntityPathBase<PessoaEntity> {

    private static final long serialVersionUID = -544461073L;

    public static final QPessoaEntity pessoaEntity = new QPessoaEntity("pessoaEntity");

    public final ListPath<br.com.entities.bens.BensEntity, br.com.entities.bens.QBensEntity> bens = this.<br.com.entities.bens.BensEntity, br.com.entities.bens.QBensEntity>createList("bens", br.com.entities.bens.BensEntity.class, br.com.entities.bens.QBensEntity.class, PathInits.DIRECT2);

    public final ListPath<br.com.entities.divida.DividaEntity, br.com.entities.divida.QDividaEntity> dividas = this.<br.com.entities.divida.DividaEntity, br.com.entities.divida.QDividaEntity>createList("dividas", br.com.entities.divida.DividaEntity.class, br.com.entities.divida.QDividaEntity.class, PathInits.DIRECT2);

    public final StringPath endereco = createString("endereco");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> idade = createNumber("idade", Long.class);

    public final ListPath<br.com.entities.movimentacao.MovimentacaoEntity, br.com.entities.movimentacao.QMovimentacaoEntity> movimentacoes = this.<br.com.entities.movimentacao.MovimentacaoEntity, br.com.entities.movimentacao.QMovimentacaoEntity>createList("movimentacoes", br.com.entities.movimentacao.MovimentacaoEntity.class, br.com.entities.movimentacao.QMovimentacaoEntity.class, PathInits.DIRECT2);

    public final StringPath nome = createString("nome");

    public final EnumPath<TipoFonteRenda> tipoFonteRenda = createEnum("tipoFonteRenda", TipoFonteRenda.class);

    public QPessoaEntity(String variable) {
        super(PessoaEntity.class, forVariable(variable));
    }

    public QPessoaEntity(Path<? extends PessoaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPessoaEntity(PathMetadata metadata) {
        super(PessoaEntity.class, metadata);
    }

}

