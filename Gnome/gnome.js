var isOpen = false;

function OnLoad() {

	OnOpenStateChange();
	OnPlayStateChange();

}

function CloseHead() {

	pl.visible = false;
	aud.visible = false;
	crown.moveTo(43, 83, 850);
}

function OpenHead()

{
	crown.moveTo(43, 5, 850);
}
function PlmoveDrawer() {

	pl.visible = true;
	aud.visible = false;
}

function EqmoveDrawer() {

	aud.visible = true;
	pl.visible = false;
}

function OnOpenStateChange() {
	if (player.OpenState == osMediaOpen) {

		UpdateMetadata();
	} else {
		status.visible = true;
		metadata.visible = false;
	}
}
function UpdateMetadata() {
	metadata.value = player.currentmedia.getiteminfo("author");

	var temp = player.currentmedia.name;
	if (temp != "") {
		if (metadata.value != "") {
			metadata.value += " -- ";

		}
		metadata.value += temp;

	}
	metadata.scrolling = metadata.textWidth > metadata.width;

}

function close() {
	crown.moveTo(43, 0, 850);
}
function ToggleHawk(showHawk) {

	pl.visible = false;

	aud.visible = false;
	main.visible = false;

	crown.visible = false;
	hawk.visible = showHawk;

}
function Hide(showMain) {

	if (aud.visible = true) {

		EqmoveDrawer();
		aud.visible = false;
		crown.moveTo(43, 83, 850);
	} else if (pl.visible = true) {
		PlmoveDrawer();
		pl.visible = false;
		crown.moveTo(43, 83, 850);
	}

	hawk.visible = false;

	crown.visible = true;

	playdrawer.visible = false;
	vizdrawer.visible = false;
	eqdrawer.visible = false;

	main.visible = true;
}

function ShowEyes() {

	if (player.playState.value = 3) {
		eye1.visible = true;
		eye2.visible = true;
	}
}

function HideEyes() {

	eye1.visible = false;
	eye2.visible = false;

}

function AdjustAudio() {
	eq.gainLevel1 = bass.value;
	eq.gainLevel2 = (8 * bass.value + treble.value) / 9;
	eq.gainLevel3 = (7 * bass.value + 2 * treble.value) / 9;
	eq.gainLevel4 = (6 * bass.value + 3 * treble.value) / 9;
	eq.gainLevel5 = (5 * bass.value + 4 * treble.value) / 9;
	eq.gainLevel6 = (4 * bass.value + 5 * treble.value) / 9;
	eq.gainLevel7 = (3 * bass.value + 6 * treble.value) / 9;
	eq.gainLevel8 = (2 * bass.value + 7 * treble.value) / 9;
	eq.gainLevel9 = (bass.value + 8 * treble.value) / 9;
	eq.gainLevel10 = treble.value;
}

function AdjustAudio2() {
	eq2.gainLevel11 = bass2.value;
	eq2.gainLevel12 = (8 * bass2.value + treble2.value) / 9;
	eq2.gainLevel13 = (7 * bass2.value + 2 * treble2.value) / 9;
	eq2.gainLevel14 = (6 * bass2.value + 3 * treble2.value) / 9;
	eq2.gainLevel15 = (5 * bass2.value + 4 * treble2.value) / 9;
	eq2.gainLevel16 = (4 * bass2.value + 5 * treble2.value) / 9;
	eq2.gainLevel17 = (3 * bass2.value + 6 * treble2.value) / 9;
	eq2.gainLevel18 = (2 * bass2.value + 7 * treble2.value) / 9;
	eq2.gainLevel19 = (bass2.value + 8 * treble2.value) / 9;
	eq2.gainLevel20 = treble2.value;
}

function OnPlayStateChange() {
	play.upToolTip = bgPlay.enabled ? xPlayPause.toolTip : "";
	pause.upToolTip = bgPause.enabled ? xPlayPause.value : "";
	stop.upToolTip = bgStop.enabled ? xStop.toolTip : "";
	prev.upToolTip = bgPrev.enabled ? xPrevNext.toolTip : "";
	next.upToolTip = bgNext.enabled ? xPrevNext.value : "";
}
