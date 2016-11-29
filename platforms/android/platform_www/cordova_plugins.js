cordova.define('cordova/plugin_list', function(require, exports, module) {
module.exports = [
    {
        "id": "cordova-plugin-native.native",
        "file": "plugins/cordova-plugin-native/www/native.js",
        "pluginId": "cordova-plugin-native",
        "clobbers": [
            "native"
        ]
    }
];
module.exports.metadata = 
// TOP OF METADATA
{
    "cordova-plugin-whitelist": "1.3.0",
    "cordova-plugin-native": "1.0.0"
};
// BOTTOM OF METADATA
});