import React from 'react';


const GENEROS = {
  MASCULINO: 'MASCULINO',
  FEMININO: 'FEMININO',
  OUTRO: 'OUTRO',
};

const PessoaCard = ({ pessoa }) => {
  return (
    <div className="pessoa-card">
      <p>Nome: {pessoa.nome}</p>
      <p>Gênero: {GENEROS[pessoa.genero]}</p>
      <p>Data de Nascimento: {pessoa.dataNasc}</p>

      {/*<button type="button">editar</button>*/}
      {/*<button type="button">remover</button>*/}

      <style jsx global>{`
        .pessoa-card {
          width: 300px;
          border: 1px solid #333;
          border-radius: 3px;
          padding: 15px;
        }
      `}</style>
    </div>
  );
};

export default PessoaCard;
