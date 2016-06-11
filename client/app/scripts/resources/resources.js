(function () {
    angular.module('principal').factory('RestResource', ['$resource', function ($resource) {

        return function (entidade) {

            var resource = $resource('rest/' + entidade + '/:id', {id: '@id'});
            this.salvar = function (objeto) {
                return resource.save([], objeto,
                    function onSave() {
                        //Mostra mensagem de sucesso
                    },
                    function onError(error) {
                        //Mostra mensagem de erro
                    }
                ).$promise;
            };

            this.listar = function (funcaoRetorno) {
                resource.query({isArray: true}, '',
                    function onSave(objetoRetorno) {
                        funcaoRetorno(objetoRetorno);
                    },
                    function onError(error) {
                        //Mostra mensagem de erro
                    }
                );
            };

            this.detalhar = function (objeto, funcaoRetorno) {
                resource.get([], objeto,
                    function onSave(objetoRetorno) {
                        funcaoRetorno(objetoRetorno);
                    },
                    function onError(error) {
                        //Mostra mensagem de erro
                    }
                );
            };

            return this;
        };

    }]);
})();