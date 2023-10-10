//prendo a caso una zona
var contaZone = db.neighborhoods.find().count()
var idZona = [Math.floor(Math.random() * contaZone)]
var numZona = idZona[0]
var zonaDaFiltrare = db.neighborhoods.find().skip(numZona).limit(1).toArray()
var coordinate = zonaDaFiltrare[0].geometry.coordinates
db.restaurants.find({location:{$geoIntersects:{$geometry:{type:"Polygon", coordinates:coordinate}}}})

