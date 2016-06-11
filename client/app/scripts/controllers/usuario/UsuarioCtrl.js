'use strict';

(function () {
    angular.module('principal').controller('UsuarioCtrl',
        ['$scope', '$location', 'RestResource', function ($scope, $location, ApiResource) {

            var usuarioResource = new ApiResource('usuarios');

            $scope.salvar = function (usuario) {
                usuarioResource.salvar(usuario).then(function () {
                    $scope.path = $location.path('/');
                });
            };

            $scope.alterarUsuario = function (usuario) {
                $scope.$broadcast('alterarUsuario', usuario);
            };

        }]);
})();
