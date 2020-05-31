#!/bin/sh
export VOLK_GENERIC=1
export GR_DONT_LOAD_PREFS=1
export srcdir=/Users/johnson_marcus/Downloads/gr-my_module/lib
export PATH=/Users/johnson_marcus/Downloads/gr-my_module/build/lib:$PATH
export DYLD_LIBRARY_PATH=/Users/johnson_marcus/Downloads/gr-my_module/build/lib:$DYLD_LIBRARY_PATH
export PYTHONPATH=$PYTHONPATH
test-my_module 
