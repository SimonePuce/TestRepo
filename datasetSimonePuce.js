db.createCollection("Prenotazioni")

var attrezzi = [
    {
        id: 1,
        tipo: "cabina"    
    },
    {
        id:2,
        tipo: "cabina"
    },
    {
        id:3,
        tipo: "cabina"
    },
    {
        id:4,
        tipo: "cabina"
    },
    {
        id:5,
        tipo: "cabina"
    },
    {
        id:6,
        tipo: "cabina"
    },
    {
        id:7,
        tipo: "cabina"
    },
    {
        id:8,
        tipo: "cabina"
    },
    {
        id:9,
        tipo: "cabina"
    },
    {
        id:10,
        tipo: "cabina"
    }
]

var utenti = [
    {
        id: 1,
        name: "Fabio"    
    },
    {
        id:2,
        name: "Gianluca"
    },
    {
        id:3,
        name: "LuigiPEDIOOOOOOOO"
    },
    {
        id: 4,
        name: "Genny(eliana)"
    },
    {
        id:5,
        name: "metti chiara"
    }
]

for(var i = 0 ; i<20000; i++ ){
    var attrezzo = attrezzi[Math.floor(Math.random()*attrezzi.length)]
    var utente = utenti[Math.floor(Math.random()*utenti.length)]
    var dataRandom = new Date(Date.now() - Math.floor(Math.random() * 365 * 6) * 24 * 60 * 60);
    db.prenotazioni.insertOne(
        {
            data: dataRandom,
            attrezzo,
            utente,
        }
    )
}










