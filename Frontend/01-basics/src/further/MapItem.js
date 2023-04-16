export default function MapItem({product}){
    return (
        <div>{product.id}
        {product.name}
        {product.price}</div>
    )
}