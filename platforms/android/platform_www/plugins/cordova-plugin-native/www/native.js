cordova.define("cordova-plugin-native.native", function(require, exports, module) {
module.exports = {
    exec: function(successCallback, errorCallback, action, args) {
        cordova.exec(successCallback, errorCallback, "Native", action, args);
    }
};
});
