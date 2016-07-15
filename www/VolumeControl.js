/*
 * Phonegap VolumeControl Plugin for Android
 * Cordova 2.2.0
 * Email: manusimpson[at]gmail[dot]com
 * Author: Manuel Simpson
 * Date: 12/28/2012
 */

var exec = require('cordova/exec');

var VolumeControl = {
  	setMediaVolume: function(vol, successCallback, failureCallback, playSound){
		return exec(
			successCallback,
			failureCallback,
			'VolumeControl',
			'setMediaVolume',
			[vol, playSound]
		);
	},
	getMediaVolume: function(successCallback, failureCallback){
		return exec(
			successCallback,
			failureCallback,
			'VolumeControl',
			'getMediaVolume',
			[]
		);
	},
	getNotificationVolume: function(successCallback, failureCallback){
		return exec(
			successCallback,
			failureCallback,
			'VolumeControl',
			'getNotificationVolume',
			[]
		);
	},
	getRingVolume: function(successCallback, failureCallback){
		return exec(
			successCallback,
			failureCallback,
			'VolumeControl',
			'getRingVolume',
			[]
		);
	}
};

module.exports = VolumeControl;
