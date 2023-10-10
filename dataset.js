for(var i=0; i<10; i++){
    db.attrezzi.insertOne({
        nome: "ombrellone"
    })
}

var listUtenti = [
    {
        name: "Fabio",
        cognome: "Vergine"
    },
    {
        name: "Gianluca",
        cognome: "Generico"
    },
    {
        name: "Luigi",
        cognome: "PEDIOOOOOOOOOO"
    },
    {
        name: "Eliana",
        cognome: "Laporta"
    },
    {
        name: "Chiara",
        cognome: "Basile"
    }
]

db.utenti.insertMany(listUtenti)


for(var i = 0 ; i<20000; i++ ){
    var utenti = db.utenti.find().count()
    var attrezzi = db.attrezzi.find().count()
    var attrezzo = [Math.floor(Math.random()*attrezzi)]
    var utente = [Math.floor(Math.random()*utenti)]
    var numUtente = utente[0]
    var numAttrezzo = attrezzo[0]
    var utenteDaInserire = db.utenti.find().skip(numUtente).limit(1).toArray()
    var attrezzoDaInserire = db.attrezzi.find().skip(numAttrezzo).limit(1).toArray()
    var dataRandom = new Date(Date.now() - Math.floor(Math.random() * 365 * 6) * 24 * 60 * 60 * 1000);
    db.prenotazioni.insertOne(
        {
            data: dataRandom,
            utenteDaInserire,
            attrezzoDaInserire
        }
    )
}











