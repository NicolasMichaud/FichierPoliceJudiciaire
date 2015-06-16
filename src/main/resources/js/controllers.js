/**
 * Created by Nicolas on 13/06/2015.
 */
var fichierPoliceJudiciaireApp = angular.module('fichierPoliceJudiciaireApp', []);

fichierPoliceJudiciaireApp.controller('listeDeVilains', function ($scope) {
    $scope.vilains = [
        {'nom': 'Le Papillon',
            'prenom': 'Léon',
            'delit': 'A volé le cocon de Camille La Chenille'},
        {'nom': 'La chenille',
            'prenom': 'Camille',
            'delit': 'A été trop lente à se développer (violation de l\'article 5 du code des insecte paragraphe 227 alinéa 4'}
    ];
    $scope.valider = function() {
        //console.log("valider()",$scope.nom);
        var mongoose = require('mongoose');
        mongoose.connect('mongodb://localhost/fichiersPoliceJudiciaire');
        var persoSchema=mongoose.Schema({
            nom:{type:String},
            prenom:{type:String},
            delit:{type:String}
        });
        var Vilains=mongoose.model('Vilains',persoSchema);
        var nouveauPerso=new Vilains({
            nom:$scope.nom,
            prenom:$scope.prenom,
            delit:$scope.delit
        });
        nouveauPerso.save(function(err) {
            if (err) {
                console.log("erreur d'écriture")
            }
            else {
                console.log("enregistrement effectué");
            }
        });
    }
});

/*

var sendToBDD = angular.module('sendToBDD', []);

sendToBDD.controller('toBDD', function ($scope) {

var mongoose = require('mongoose');
mongoose.connect('mongodb://localhost/fichiersPoliceJudiciaire');
var persoSchema=mongoose.Schema({
    nom:{type:String},
    prenom:{type:String},
    delit:{type:String}
});
var Vilains=mongoose.model('Vilains',persoSchema);
var nouveauPerso=new Vilains({
    nom:'Durand',
    prenom:'Pierre',
    delit:'vol de saucisson'
});
nouveauPerso.save(function(err) {
    if (err) {
        console.log("erreur d'écriture")
    }
    else {
        console.log("enregistrement effectué");
    }
}
}
    */