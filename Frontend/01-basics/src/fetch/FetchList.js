import { useEffect, useState } from "react";

export const FetchList = ()=>{
    const initialProducts=[]
    const urlList="/json/products.json";
    const [products,setProducts]=useState(initialProducts)
    useEffect(()=>{
        console.log("Etki kullan..");
        fetch(urlList)
        .then(data=>data.json())
        .then(products=>
            setProducts(products)
            )
    },[urlList])
    return(
        <>Fetch Products
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