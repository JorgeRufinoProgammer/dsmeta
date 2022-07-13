import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'
import './index.css'

/*Responsavel por carregar/renderizar em tempo real a div "root" no arquivo index.html*/
ReactDOM.createRoot(document.getElementById('root')!).render(   
  <React.StrictMode>
    <App />          
  </React.StrictMode>
)
