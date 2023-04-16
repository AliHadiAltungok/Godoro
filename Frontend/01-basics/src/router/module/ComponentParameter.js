import { useParams } from "react-router-dom";
export default function ComponentParameter(){
    const {id} = useParams();
    return(
        <div>
            <h6>Parameter</h6>
            Özdeşlik{id}
        </div>
    )
}