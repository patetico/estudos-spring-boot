import React, { useEffect, useState } from 'react';
import axios from 'axios';
import PessoaCard from '../components/pessoaCard';


export default function Home() {
  const [loading, setLoading] = useState(true);
  const [foo, setFoo] = useState(null);

  useEffect(() => {
    axios
      .get('http://localhost:8080/pessoas')
      .then(resp => {
        setFoo((
          <div className="pessoas-wrapper">
            {resp.data.map(p => (<PessoaCard key={p.id} pessoa={p} />))}
          </div>
        ));
        setLoading(false);
      })
      .catch(err => {
        console.error(err);
        setFoo('deu ruim. checa o console ou sei lá');
        setLoading(false);
      });
  }, []);


  return (
    <div className="container">
      {loading ? 'carregando' : foo}
      <style jsx global>{`
        .pessoas-wrapper {
          display: flex;
          flex-wrap: wrap;
          justify-content: center;
        }
        
        .pessoas-wrapper > * {
          margin: 5px;
        }
      `}</style>
    </div>
  );
}
