'use strict';

angular.module("principal", ['ngRoute'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when('/', {
                redirectTo: '/principal'
            })
            .when('/usuario', {
                templateUrl: 'views/usuario/manterUsuario.html',
                controller: 'UsuarioCtrl'
            })
            .otherwise({redirectTo: '/404'});
    }]);

