/*
 * Phonegap VolumeControl Plugin
 * Cordova 2.2.0
 * Email: manusimpson[at]gmail[dot]com
 * Author: Manuel Simpson
 * Date: 12/28/2012
 */

var exec = require('cordova/exec');

var VolumeControl = {
	STREAM_MEDIA: 3, 
	STREAM_NOTIFICATION: 5,
	STREAM_RING: 2,
	STREAM_VOICE_CALL: 0,

  	setMediaVolume: function(volume, successCallback, failureCallback, playSound) {
		return exec(
			successCallback,
			failureCallback,
			'VolumeControl',
			'setMediaVolume',
			[volume, playSound]
		);
	},
	setVolumeControlStream: function(stream, successCallback, failureCallback) {
		return exec(
			successCallback,
			failureCallback,
			'VolumeControl',
			'setVolumeControlStream',
			[stream]
		);
	},
	getMediaVolume: function(successCallback, failureCallback) {
		return exec(
			successCallback,
			failureCallback,
			'VolumeControl',
			'getMediaVolume',
			[]
		);
	},
	getNotificationVolume: function(successCallback, failureCallback) {
		return exec(
			successCallback,
			failureCallback,
			'VolumeControl',
			'getNotificationVolume',
			[]
		);
	},
	getRingVolume: function(successCallback, failureCallback) {
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
