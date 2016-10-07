(function(window, document, $, undefined) {

    window.android = window.android || {

        // Log nativo
        log: function(str) {},

        // Modelo do Android
        getModel: function() {},

        // Versão do Android, ex.: 4.1.2
        getVersion: function() {},

        // Versão do app
        getAppVersion: function() {},

        // IMEI do aparelho
        getDeviceImei: function() {},

        // Obter string do arquivo de tradução (strings.xml)
        getString: function(str) {},

        // Mostrar alerta
        showToast: function(msg) {},

        // Mostrar tela de carregamento
        showLoading: function(msg) {},

        // Esconder tela de carregamento
        hideLoading: function() {},

        // Vibrar
        vibrate: function(time) {},

        // Compartilhar texto
        share: function(text) {},

        // Verificar se está conectado à internet
        isNetworkAvailable: function() {},

        // Fechar app
        closeApp: function() {},

        // Definir preferências
        prefSetString: function(key, value) {},
        prefSetInteger: function(key, value) {},
        prefSetBoolean: function(key, value) {},

        // Obter preferências
        prefGetString: function(key) {},
        prefGetInteger: function(key) {},
        prefGetBoolean: function(key) {}
    };



    window.onBackPressed = function() {
        android.closeApp();
    };


    $('#info').html(android.getVersion());

})(window, document, jQuery);
