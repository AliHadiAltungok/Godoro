import {useState} from 'react'
export default function ObjectComponent(){
const initialProduct = {id:301,name:"Cep Telefonu",price:2350.0}
const[product,setProduct]= useState(initialProduct);

const nameChanged=(event)=>{
    setProduct({
        id: product.id,
        name: event.target.value,
        price: product.price
    });
    // const priceChanged=(event)=>{
    //     setProduct({
    //         ...product,
    //         price: event.target.value
    //     });
    const save=(event)=>{
            event.preventDefault();
            alert('Saklaniyor ${product.id} ${product.id} ${product.id}')
}
    return(
        <div>
            <h1>
                Nesne Bileseni <br/>
                {product.id}-{product.name}-{product.price}<br/>
                <form>
                Ozdeslik: {product.id}<br/>
                Ad: <input type="text" value={product.name} onChange={nameChanged}/><br/>
                Deger: <input type="text" value={product.price}  /><br/></form> 
                {/* onChange={priceChanged} */}
                <input type="submit" value="Sakla"/>
                
            </h1>
        </div>
    )
    }}