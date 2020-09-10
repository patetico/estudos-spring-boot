import React, { useEffect, useState } from 'react';

import axios from 'axios';


export default function Home() {
  const [loading, setLoading] = useState(true);
  const [foo, setFoo] = useState(null);

  useEffect(() => {
    axios
      .get('http://localhost:8080/pessoas')
      .then(resp => {
        setFoo((
          <ul>
            {resp.data.map(p => (<li key={p.id}>{p.nome}</li>))}
          </ul>
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
    </div>
  );
}
