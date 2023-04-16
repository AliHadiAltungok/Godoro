import MapItem from "./MapItem"

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
        <div> 
            <tbody>
            {products.map(product=>
            <MapItem product={product}/>
            )}</tbody>
        </div>
        </>
    )
}