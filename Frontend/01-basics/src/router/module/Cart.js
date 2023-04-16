import { useEffect, useState } from "react";
import { useParams } from "react-router";
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import { ReactSVG } from 'react-svg'

export default function Cart() {
    const urlGet = `http://localhost:8080/cartproduct/list/1`;
    const urlGetCart = `http://localhost:8080/cart/get/1`;
    const urlAddItem = `http://localhost:8080/cart/add/1/`;
    const urlRemoveItem = `http://localhost:8080/cart/remove/1/`;
    const urlCheckout = `http://localhost:8080/cart/checkout`;
    const [cartProducts, setCartProducts] = useState([]);

    useEffect(() => {
        getCartProducts()
    }, [urlGet])


    function getCartProducts()
    {
        fetch(urlGet)
            .then(data => data.json())
            .then(cartProducts => {
                console.log(cartProducts);
                setCartProducts(cartProducts)
            }
        )
    }

    function getCart()
    {
        return cartProducts.cart
    }

    function onAddItem(id) {
        fetch(urlAddItem+id, { method: 'POST' })
            .then(() => {
                getCartProducts()
            }
        )
    }
    function onRemoveItem(id) {
        fetch(urlRemoveItem+id, { method: 'DELETE' })
            .then(() => {
                getCartProducts()
            }
        )
    }
    function onCheckOut(cart) {
        fetch(urlCheckout, { method: 'PUT', 
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(cart) })    
        .then(response => response.json())
         //.then(data => { cart })
        //     .then(() => {
        //         getCartProducts()
        //     }
        // )
    }
    return (
        <div style={{ width: '100%', display: 'flex', alignItems: 'left'}}>
            {cartProducts.map(cartProduct => (
                <Card sx={{ width: 345, marginBottom: 2, marginRight: 2, }}>
                    <CardMedia
                        sx={{ height: 140 }}
                        image="https://www.lukoilonline.com/uploadFiles/default.png"
                        title={"green iguana"}
                    />
                    <CardContent>
                        <Typography gutterBottom variant="h5" component="div">
                            {cartProduct.product.productName}
                        </Typography>
                        <Typography variant="body2" color="text.secondary">
                        {cartProduct.product.salesPrice} ₺
                        </Typography>
                    </CardContent>
                    <CardActions style={{display: 'flex',  justifyContent:'center', alignItems:'center'}}>
                        <Button size="small" onClick={() => onRemoveItem(cartProduct.product.productId)}><b>-</b></Button>
                        {cartProduct.salesQuantity}
                        <Button size="small" onClick={() => onAddItem(cartProduct.product.productId)}><b>+</b></Button>
                    </CardActions>
                </Card>
            ))}

            {cartProducts.map(cartProduct => (
                <Card sx={{ width: 345, marginBottom: 2, marginRight: 2, }}>
                    <CardContent>
                        <Typography gutterBottom variant="h7" component="div">
                            {cartProduct.cart.cartId}
                        </Typography>
                        <Typography gutterBottom variant="h7" component="div">
                            {cartProduct.cart.customerName}
                        </Typography>
                        <Typography gutterBottom variant="h7" component="div">
                            {cartProduct.cart.cardNumber}
                        </Typography>
                        <Typography gutterBottom variant="h7" component="div">
                            {cartProduct.cart.cartStatus}
                        </Typography>
                    </CardContent>
                    <CardActions style={{display: 'flex',  justifyContent:'center', alignItems:'center'}}>
                        <Button size="small" onClick={() => onCheckOut(cartProduct.cart)}><b>Checkout</b></Button>
                    </CardActions>
                </Card>
          )).at(0)}
            
            
        </div>
        
        
    )
}

//<Button size="big" onClick={() => onCheckOut()}><b>Checkout</b></Button>