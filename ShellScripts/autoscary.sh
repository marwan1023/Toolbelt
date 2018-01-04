# Raspberry Pi Video Prank Script
# Use chmod +x ~/autorun.sh to enable

CREEPY_MOVIE="IT.mp4" # Creepy movie to play, located in the Pi home directory
MOVIE_LOOPS="1" # Number of times to play creepy movie (1 by default)
MOVIE_SLEEP="3600" # Number of seconds to sleep between movie plays (1 hour by default)

tv_off() {
  if [ "$(echo "pow 0" | cec-client -d 1 -s | grep 'power status: on')" ]; then # If TV is currently on
    echo "standby 0" | cec-client -d 1 -s # Send the standby command
  fi

}

prepare_tv() {
  tv_off # We switch the TV off and on again to force the active channel to the Pi
  sleep 5 # Give it a few seconds to shut down
  echo "on 0" | cec-client -d 1 -s # Now send the on command
  sleep 5 # And give the TV another few seconds to wake up
  echo "as" | cec-client -d 1 -s # Now set the Pi to be the active source
}

play_movie() {
  if [ -f ~/"$CREEPY_MOVIE" ]; then # Check that the creepy movie file exists
    omxplayer -o hdmi ~/"$CREEPY_MOVIE" # Then play it with sound going out through HDMI
  fi
  echo "Playing movie"
}

prepare_tv
play_movie
tv_off
