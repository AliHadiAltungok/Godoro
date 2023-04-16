export default function EventComponent(){
    const handle=()=>{
        alert('Kotariliyor...')
    }
    const deal=(input)=>{
        alert('Ugrasiliyor...'+input)
    }
    const manage=(event)=>{
        alert('Isletiliyor...'+event.target.id+' '+event.target.tagName)
    }
    return(
        <div>
            <h1>
                Bicim Bileseni
            </h1>
            <form>
                <button onClick={()=> alert('Isleniyor..')}>Cizgi Ici</button>{' '}
                <button onClick={handle}>Ok</button>{' '}
                <button onClick={()=>deal('Girdi')}>Degistirgen</button>{' '}
                <button id="manager" onClick={(event)=>manage(event)}>Olay</button>{' '}
            </form>
        </div>
    )
}