/**
 * Created by Nicolas on 13/06/2015.
 */
var fichierPoliceJudiciaireApp = angular.module('fichierPoliceJudiciaireApp', []);

fichierPoliceJudiciaireApp.controller('listeDeVilains', function ($scope) {
    $scope.vilains = [
        {'nom': 'Le Papillon',
            'prenom': 'L�on',
            'delit': 'A vol� le cocon de Camille La Chenille'},
        {'nom': 'La chenille',
            'prenom': 'Camille',
            'delit': 'A �t� trop lente � se d�velopper (violation de l\'article 5 du code des insecte paragraphe 227 alin�a 4'}
    ];
});