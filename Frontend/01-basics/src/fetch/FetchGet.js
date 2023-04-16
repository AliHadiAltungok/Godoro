import { useEffect, useState } from "react";

export const FetchGet = ()=>{
    const productId=302;
    const urlGet="/json/product"+productId+".json";
    const[products,setProducts]= useState(initialProduct);
    const initialProduct = {id:0,name:"",price:0.0}
    
    useEffect(()=>{
        console.log("Etki kullan..");
        fetch(urlGet)
        .then(data=>data.json())
        .then(products=>
            setProducts(products)
            )
    },[urlGet])
    return(
        <>
        Fetch Products
        
        <tbody>
        {products.map(product=>
        <tr key={product.id}>
            <td>{product.id}</td>
            <td>{product.name}</td>
            <td>{product.price}</td>
        </tr>   
        )}</tbody>
        </>
    )
}