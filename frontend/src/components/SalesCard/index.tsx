import axios from "axios";
import { useEffect, useState } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { Sale } from "../../models/sale";
import { BASE_URL } from "../../utils/request";
import NotificationButton from '../NotificationButton';
import './styles.css';

function SalesCard() {

    const min = new Date(new Date().setDate(new Date().getDate() - 365));
    const max = new Date();

    const [minDate, setMinDate] = useState(min);
    const [maxDate, setMaxDate] = useState(max);

    const [sales, setSales] = useState<Sale[]>([]);

    useEffect(() => {       //Faz o request na url     
        
        const dminDate = minDate.toISOString().slice(0,10); //Transformou a data e depois recortou para pegar 10 primeiros caracteres
        const dmaxDate = maxDate.toISOString().slice(0,10); 

        //Passa na url/request o valor das datas selecionadas pelo usuario
        axios.get(`${BASE_URL}/sales?minDate=${dminDate}&maxDate=${dmaxDate}`).then(response => {   //Usou CRASE dentro do get
            setSales(response.data.content);
        })
    }, [minDate, maxDate]) //sempre que a data mudar, vai rodar novamente o useEffect fazendo recarregar a tabela com os dados filtrados pela data

    return (
        <div className="dsmeta-card">
            <h2 className="dsmeta-sales-title">Vendas</h2>
            <div>
                <div className="dsmeta-form-control-container">
                    <DatePicker
                        selected={minDate}
                        onChange={(date: Date) => setMinDate(date)}
                        className="dsmeta-form-control"
                        dateFormat="dd/MM/yyyy"
                    />
                </div>
                <div className="dsmeta-form-control-container">
                    <DatePicker
                        selected={maxDate}
                        onChange={(date: Date) =>  setMaxDate(date)}
                        className="dsmeta-form-control"
                        dateFormat="dd/MM/yyyy"
                    />
                </div>
            </div>

            <div>
                <table className="dsmeta-sales-table">
                    <thead>
                        <tr>
                            <th className="show992">ID</th>
                            <th className="show576">Data</th>
                            <th>Vendedor</th>
                            <th className="show992">Visitas</th>
                            <th className="show992">Vendas</th>
                            <th>Total</th>
                            <th>Notificar</th>
                        </tr>
                    </thead>
                    <tbody>
                        {sales.map(sale => {     //cria variavel "sale" para receber cada linha/objeto de "sales"
                            return (                                
                                <tr key={sale.id}>                                  
                                    <td className="show992">{sale.id}</td> 
                                    <td className="show576">{new Date(sale.date).toLocaleDateString()}</td>
                                    <td>{sale.sellerName}</td>
                                    <td className="show992">{sale.visited}</td>
                                    <td className="show992">{sale.deals}</td>
                                    <td>R${sale.amount.toFixed(2)}</td>
                                    <td>        
                                        <div className="dsmeta-red-btn-container">
                                            <NotificationButton saleId={sale.id}/>
                                        </div>
                                    </td>
                                </tr>
                                )
                            })
                        }                        
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default SalesCard;