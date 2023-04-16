import { useEffect, useState } from "react";
import { useParams } from "react-router";
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';

export default function Products() {
    let { id } = useParams();

    const urlGet = `http://localhost:8080/product/products/${id}`;
    const urlAddCart = `http://localhost:8080/cart/add/1/`;
    const [products, setProducts] = useState([]);

    useEffect(() => {
        console.log("Etki kullan..");
        fetch(urlGet)
            .then(data => data.json())
            .then(products => {
                console.log(products);
                setProducts(products)
            }
        )
    }, [urlGet])

    function onAddCart(id) {
        fetch(urlAddCart+id, { method: 'POST' })
            .then(data => data.json())
            .then(products => {
                console.log(products);
            }
        )
    }
    return (
        <div style={{ width: '100%', display: 'flex', alignItems: 'left'}}>
            {products.map(product => (
                <Card sx={{ width: 345, marginBottom: 2, marginRight: 2, }}>
                    <CardMedia
                        sx={{ height: 140 }}
                        image="https://www.lukoilonline.com/uploadFiles/default.png"
                        title="green iguana"
                    />
                    <CardContent>
                        <Typography gutterBottom variant="h5" component="div">
                            {product.productName}
                        </Typography>
                        <Typography variant="body2" color="text.secondary">
                        {product.salesPrice} ₺
                        </Typography>
                    </CardContent>
                    <CardActions>
                        <Button size="small" onClick={() => onAddCart(product.productId)}>Add to Cart</Button>
                    </CardActions>
                </Card>
            ))}

        </div>
    )
}