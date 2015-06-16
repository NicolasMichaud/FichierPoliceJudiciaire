/**
 * Created by Nicolas on 13/06/2015.
 */
var fichierPoliceJudiciaireApp = angular.module('fichierPoliceJudiciaireApp', []);

fichierPoliceJudiciaireApp.controller('listeDeVilains', function ($scope, $http) {
    $scope.vilains = [
        {'nom': 'Le Papillon',
            'prenom': 'Léon',
            'delit': 'A volé le cocon de Camille La Chenille'},
        {'nom': 'La chenille',
            'prenom': 'Camille',
            'delit': 'A été trop lente à se développer (violation de l\'article 5 du code des insecte paragraphe 227 alinéa 4)'}
    ];
    $scope.valider = function() {
        //console.log("valider()",$scope.nom);

        $http.post('/createUser',  { nom:$scope.nom,
                                    prenom:$scope.prenom,
                                    delit:$scope.delit} ).
            success(function(data, status, headers, config) {
                // this callback will be called asynchronously
                // when the response is available
                alert("enregistrement effectué!");
            }).
            error(function(data, status, headers, config) {
                // called asynchronously if an error occurs
                // or server returns response with an error status.
                alert("enregistrement echoué!");
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