import { useEffect, useState } from "react";

export const FetchGett = ()=>{
    const productId=302;
    const urlGet="/json/product"+productId+".json";
    const initialProduct = {id:0,name:"",price:0.0}
    const[product,setProduct]= useState(initialProduct);
    useEffect(()=>{
        console.log("Etki kullan..");
        fetch(urlGet)
        .then(data=>data.json())
        .then(product=>
            setProduct(product)
            )
    },[urlGet])
    return(
        <div>
            <h1>Nesne Bileseni<br/>
                
        {product.id}-{product.name}-{product.price}<br/>
        </h1>
        </div>         
          
    )
}