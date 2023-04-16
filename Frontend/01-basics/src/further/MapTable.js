export default function MapTable(){
    const products=[
        {id:301, name: "Cep Telefonu",price:2350.0},
        {id:301, name: "Televizyon",price:3150.0},
        {id:301, name: "PC",price:4095.0}  
    ]
    return(
        <>
        <h3>
            Dizelge
        </h3>
        <table> 
            <tbody>
            {products.map(product=>
            <tr key={product.id}>
                <td>{product.id}</td>
                <td>{product.name}</td>
                <td>{product.price}</td>
            </tr>   
            )}</tbody>
            
        </table>
        </>
    )
}