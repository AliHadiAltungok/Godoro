import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';

export default function Categories() {
    const urlGet = "http://localhost:8080/category/categories";
    const [categories, setCategories] = useState([]);

    let navigate = useNavigate();

    useEffect(() => {
        console.log("Etki kullan..");
        fetch(urlGet)
            .then(data => data.json())
            .then(categories => {
                console.log(categories);
                setCategories(categories)
            }
            )
    }, [urlGet])

    
    function redirect(id) {
        let path = `/products/${id}`;
        navigate(path);
    }

    return (
        <>
            {categories.map(category => (
                <Card onClick={() => redirect(category.categoryId) } sx={{ width: 250, marginBottom: 2, ':hover': { boxShadow: 10 } }}>
                    <CardContent>
                        {category.categoryName}
                    </CardContent>
                </Card>
            ))}

        </>
    )
}