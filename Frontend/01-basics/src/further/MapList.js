export default function MapList(){
    const names=['HTML','CSS','JavaScript','JSON','AJAX']
    return(
        <>
        <h3>
            Dizelge
        </h3>
        <ul>
            {names.map(name=>
                <li> {name}</li>
            )}
        </ul>
        </>
    )
}
