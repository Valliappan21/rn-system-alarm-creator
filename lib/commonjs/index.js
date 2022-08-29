'use strict';

Object.defineProperty(exports, '__esModule', {
  value: true,
});
exports.setAlarm = setAlarm;

var _reactNative = require('react-native');

const LINKING_ERROR =
  `The package 'rn-system-alarm-creator' doesn't seem to be linked. Make sure: \n\n` +
  _reactNative.Platform.select({
    ios: "- You have run 'pod install'\n",
    default: '',
  }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n';
const RnSystemAlarmCreator = _reactNative.NativeModules.RnSystemAlarmCreator
  ? _reactNative.NativeModules.RnSystemAlarmCreator
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

function setAlarm(data) {
  return RnSystemAlarmCreator.setAlarm(data);
}
//# sourceMappingURL=index.js.map
